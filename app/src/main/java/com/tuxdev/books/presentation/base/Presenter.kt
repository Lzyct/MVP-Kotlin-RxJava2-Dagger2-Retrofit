package com.tuxkdev.books.base

/**
 *----------------------------------------------
 * Created by ukieTux on 2/27/17 with ♥ .
 * @email  : ukie.tux@gmail.com
 * @github : https://www.github.com/tuxkids
 * ----------------------------------------------
 *          © 2017 | All Rights Reserved
 */
interface Presenter<in V : BaseMVP> {

    fun attachView(mvpView: V)

    fun detachView()
}