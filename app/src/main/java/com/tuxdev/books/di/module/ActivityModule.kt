package com.tuxdev.books.di.module

import android.app.Activity
import android.content.Context
import com.tuxdev.books.di.ActivityContext
import com.tuxdev.books.di.PerActivity
import dagger.Module
import dagger.Provides

/**
 **********************************************
 * Created by ukie on 12/3/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @PerActivity
    fun provideActivity(): Activity = activity

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context = activity
}