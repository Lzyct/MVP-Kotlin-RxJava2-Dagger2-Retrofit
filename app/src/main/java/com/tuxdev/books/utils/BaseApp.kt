package com.tuxdev.books.utils

import android.app.Application
import android.content.Context
import com.tuxdev.books.di.component.AppComponent
import com.tuxdev.books.di.component.DaggerAppComponent
import com.tuxdev.books.di.module.AppModule
import com.tuxdev.books.di.module.DataModule

/**
 **********************************************
 * Created by ukie on 12/3/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
class BaseApp : Application() {
    companion object {
        fun get(context: Context): BaseApp = context.applicationContext as BaseApp
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .dataModule(DataModule())
                .build()
    }
}