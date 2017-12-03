package com.tuxdev.books.presentation.books

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.tuxdev.books.R
import com.tuxdev.books.data.model.ItemsItem
import com.tuxdev.books.utils.GlideApp
import kotlinx.android.synthetic.main.activity_books_item.view.*


/**
 **********************************************
 * Created by ukie on 11/1/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */

class AdapterBooks(private val listBooks: List<ItemsItem>) : RecyclerView.Adapter<AdapterBooks.MyHolder>() {
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.bindBooks(listBooks[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder =
            MyHolder(LayoutInflater.from(parent?.context).inflate(R.layout.activity_books_item, parent, false))

    override fun getItemCount(): Int = listBooks.size

    inner class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindBooks(books: ItemsItem) {
            GlideApp.with(itemView.context)
                    .load(books.volumeInfo?.imageLinks?.smallThumbnail)
                    .transition(withCrossFade())
                    .into(itemView.iv_thumb_books)

            var authors = ""
            try {
                for (items in books.volumeInfo?.authors?.indices!!) {
                    if (books.volumeInfo.authors.size == 1)
                        authors = books.volumeInfo.authors[0]
                    else {
                        if (items == 0) {
                            authors = books.volumeInfo.authors[0]
                        } else
                            authors += ",${books.volumeInfo.authors[items]}"
                    }
                }
                itemView.tv_books_authors.text = authors
                itemView.tv_books_title.text = books.volumeInfo.title
                itemView.tv_books_publisher.text = books.volumeInfo.publisher
                itemView.tv_books_date.text = books.volumeInfo.publishedDate
                itemView.cv_root_list.setOnClickListener {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        val detailBook = Intent(itemView.context.applicationContext, BooksDetailActivity::class.java)
                        detailBook.putExtra("items", books)
                        val image = Pair<View, String>(itemView.iv_thumb_books, itemView.iv_thumb_books.transitionName)
                        val author = Pair<View, String>(itemView.tv_books_authors, itemView.tv_books_authors.transitionName)
                        val title = Pair<View, String>(itemView.tv_books_title, itemView.tv_books_title.transitionName)
                        val date = Pair<View, String>(itemView.tv_books_date, itemView.tv_books_date.transitionName)
                        val publisher = Pair<View, String>(itemView.tv_books_publisher, itemView.tv_books_publisher.transitionName)

                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                itemView.context as Activity,
                                author, title, date, publisher, image
                        )
                        itemView.context.startActivity(detailBook, options.toBundle())
                    } else {
                        val detailBook = Intent(itemView.context.applicationContext, BooksDetailActivity::class.java)
                        detailBook.putExtra("items", books)
                        itemView.context.startActivity(detailBook)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}