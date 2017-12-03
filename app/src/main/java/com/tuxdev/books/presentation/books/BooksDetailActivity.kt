package com.tuxdev.books.presentation.books

import android.view.MenuItem
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.tuxdev.books.R
import com.tuxdev.books.data.model.ItemsItem
import com.tuxdev.books.di.component.ActivityComponent
import com.tuxdev.books.presentation.base.BaseActivity
import com.tuxdev.books.utils.GlideApp
import kotlinx.android.synthetic.main.activity_books_details.*

class BooksDetailActivity : BaseActivity() {
    override fun getLayoutResource(): Int = R.layout.activity_books_details

    override
    fun myCodeHere() {
        title = getString(R.string.detail_book)
        val book: ItemsItem = intent.extras.getParcelable("items")
        GlideApp.with(this)
                .load(book.volumeInfo?.imageLinks?.thumbnail)
                .transition(withCrossFade())
                .into(iv_book)
        tv_title.text = book.volumeInfo?.title
        tv_subtitle.text = book.volumeInfo?.subtitle
        var authors = ""
        try {
            for (items in book.volumeInfo?.authors!!.indices) {
                if (book.volumeInfo.authors.size == 1)
                    authors = book.volumeInfo.authors[0]
                else {
                    if (items == 0) {
                        authors = book.volumeInfo.authors[0]
                    } else
                        authors += ",${book.volumeInfo.authors[items]}"
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        tv_authors.text = authors
        tv_description.text = book.volumeInfo?.description
        tv_publisher.text = book.volumeInfo?.publisher
        tv_publish_date.text = book.volumeInfo?.publishedDate
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            supportFinishAfterTransition()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun injectModule(activityComponent: ActivityComponent) {
    }

    override fun onDetachScreen() {
        supportStartPostponedEnterTransition()
    }
}
