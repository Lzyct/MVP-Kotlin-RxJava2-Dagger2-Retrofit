package com.tuxdev.books.presentation.books

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.tuxdev.books.R
import com.tuxdev.books.data.model.DataBooks
import com.tuxdev.books.di.component.ActivityComponent
import com.tuxdev.books.presentation.base.BaseActivity
import com.tuxdev.books.utils.RxSearchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_books.*
import javax.inject.Inject

class BooksActivity : BaseActivity(), BooksView.View {
    @Inject
    lateinit var rxSearchView: RxSearchView
    @Inject
    lateinit var mPresenter: BooksPresenter

    private val compositeDisposable = CompositeDisposable()

    private var query = "android"
    override fun getLayoutResource(): Int = R.layout.activity_books

    override fun myCodeHere() {
        title = getString(R.string.book)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        setupView()
    }

    override fun setupView() {
        mPresenter.attachView(this)
        mPresenter.getBooks(query)

        rv_books.setHasFixedSize(true)
        rv_books.layoutManager = LinearLayoutManager(this)
    }

    override fun injectModule(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onGetBooks(dataBooks: DataBooks, string: String) {
        if (dataBooks.items!!.isEmpty()) {
            tv_no_data.visibility = View.VISIBLE
            tv_no_data.text = "$query tidak ditemukan"
        } else {
            tv_no_data.visibility = View.GONE
            rv_books.adapter = AdapterBooks(dataBooks.items)
        }
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun onLoading(show: Boolean) {
        if (show) pb_progress.visibility = View.VISIBLE else pb_progress.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.book_list_menu, menu)
        val menuItem = menu?.findItem(R.id.action_search)
        val searchView = menuItem?.actionView as SearchView
        rxSearchView.getSearchView(searchView)

        compositeDisposable.add(rxSearchView.getTextWatcherObservable()
                .debounce(500, java.util.concurrent.TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ searchText ->
                    if (searchText.isEmpty()) {
                        query = "android"
                        mPresenter.getBooks(query)
                    } else if (!searchText.isEmpty()) {
                        query = searchText
                        mPresenter.getBooks(query)
                    }
                }))
        return true
    }

    override fun onDetachScreen() {
        mPresenter.detachView()
        compositeDisposable.dispose()

    }
}
