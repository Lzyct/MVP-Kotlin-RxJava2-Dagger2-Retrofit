package com.tuxdev.books.presentation.books

import android.app.Activity
import com.anandahospital.myanandahospital.network.BookService
import com.tuxdev.books.R
import com.tuxkdev.books.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 **********************************************
 * Created by ukie on 11/1/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
class BooksPresenter @Inject constructor(private val bookService: BookService, private val activity: Activity) : BasePresenter<BooksView.View>(), BooksView.Presenter {

    override fun getBooks(query: String) {
        composite.add(bookService.getBooks(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { mView()?.onLoading(true) }
                .doOnComplete { mView()?.onLoading(false) }
                .subscribe {
                    if (it.code() == 200) {
                        mView()?.onGetBooks(it.body()!!, activity.getString(R.string.app_name))
                    }
                })
    }
}