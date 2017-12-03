package com.tuxdev.books.utils

import android.support.v7.widget.SearchView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 **********************************************
 * Created by ukie on 12/2/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
class RxSearchView() {
    private var searchView: SearchView? = null

    fun getSearchView(searchView: SearchView) {
        this.searchView = searchView
    }

    fun getTextWatcherObservable(): Observable<String> {
        val subject = PublishSubject.create<String>()
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                subject.onNext(newText)
                return false
            }
        })
        return subject
    }
}