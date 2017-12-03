package com.tuxdev.books.di.component

import com.tuxdev.books.di.PerActivity
import com.tuxdev.books.di.module.ActivityModule
import com.tuxdev.books.di.module.WidgetModule
import com.tuxdev.books.presentation.books.BooksActivity
import dagger.Subcomponent

/**
 **********************************************
 * Created by ukie on 12/3/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */

@PerActivity
@Subcomponent(modules = [(ActivityModule::class), (WidgetModule::class)])
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(activityModule: ActivityModule): Builder
        fun widgetModule(widgetModule: WidgetModule): Builder

        fun build(): ActivityComponent
    }

    fun inject(booksActivity: BooksActivity)

}