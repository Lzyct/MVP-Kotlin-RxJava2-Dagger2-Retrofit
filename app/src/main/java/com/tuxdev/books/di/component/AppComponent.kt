package com.tuxdev.books.di.component

import com.tuxdev.books.di.module.AppModule
import com.tuxdev.books.di.module.DataModule
import dagger.Component
import javax.inject.Singleton

/**
 **********************************************
 * Created by ukie on 12/2/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */

//register Modules
@Singleton
@Component(modules = [(AppModule::class), (DataModule::class)])
interface AppComponent {
    fun activityComponent(): ActivityComponent.Builder
}