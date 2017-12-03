package com.tuxdev.books.presentation.books

import com.tuxdev.books.data.model.DataBooks
import com.tuxkdev.books.base.BaseMVP

/**
 **********************************************
 * Created by ukie on 11/1/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
interface BooksView {
    interface View : BaseMVP {
        fun onGetBooks(dataBooks: DataBooks, string: String)
        fun onLoading(show: Boolean)
    }

    interface Presenter {
        fun getBooks(query: String)
    }
}