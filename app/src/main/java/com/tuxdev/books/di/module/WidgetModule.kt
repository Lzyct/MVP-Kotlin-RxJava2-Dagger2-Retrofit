package com.tuxdev.books.di.module

import com.tuxdev.books.di.PerActivity
import com.tuxdev.books.utils.RxSearchView
import dagger.Module
import dagger.Provides

/**
 **********************************************
 * Created by ukie on 12/2/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
@Module
class WidgetModule {

    @Provides
    @PerActivity
    fun rxSearchView(): RxSearchView = RxSearchView()
}