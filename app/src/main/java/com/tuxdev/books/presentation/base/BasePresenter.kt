package com.tuxkdev.books.base

import io.reactivex.disposables.CompositeDisposable


/**
 *----------------------------------------------
 * Created by ukieTux on 2/27/17 with ♥ .
 * @email  : ukie.tux@gmail.com
 * @github : https://www.github.com/tuxkids
 * ----------------------------------------------
 *          © 2017 | All Rights Reserved
 */
open class BasePresenter<T : BaseMVP> : Presenter<T> {
    private var mvpView: T? = null
    lateinit var composite: CompositeDisposable
    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
        composite = CompositeDisposable()
    }

    override fun detachView() {
        this.mvpView = null
        composite.dispose()
    }

    fun mView(): T? {
        return this.mvpView
    }
}
