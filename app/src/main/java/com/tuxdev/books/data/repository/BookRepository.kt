package com.tuxdev.books.data.repository

import com.tuxdev.books.data.model.DataBooks
import io.reactivex.Flowable
import retrofit2.Response

/**
 **********************************************
 * Created by ukie on 12/3/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
interface BookRepository {
    fun getBooks(query: String): Flowable<Response<DataBooks>>
}