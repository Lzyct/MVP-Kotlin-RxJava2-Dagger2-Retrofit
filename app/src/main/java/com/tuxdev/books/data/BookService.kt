package com.anandahospital.myanandahospital.network

import com.tuxdev.books.data.model.DataBooks
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ----------------------------------------------
 * Created by ukieTux on 2/28/17 with ♥ .
 * @email : ukie.tux@gmail.com
 * @github : https://www.github.com/tuxkids
 * * ----------------------------------------------
 * * © 2017 | All Rights Reserved
 */

interface BookService {

    @GET("books/v1/volumes")
    fun getBooks(@Query("q") query: String): Flowable<Response<DataBooks>>


}
