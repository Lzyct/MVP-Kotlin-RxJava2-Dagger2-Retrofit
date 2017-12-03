package com.tuxdev.books.presentation.base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.WindowManager
import com.tuxdev.books.R
import com.tuxdev.books.di.component.ActivityComponent
import com.tuxdev.books.di.module.ActivityModule
import com.tuxdev.books.di.module.WidgetModule
import com.tuxdev.books.utils.BaseApp

/**
 **********************************************
 * Created by ukie on 11/1/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */


abstract class BaseActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        toolbar = findViewById(R.id.toolbar)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        val activityComponent = BaseApp.get(this)
                .appComponent
                .activityComponent()
                .activityModule(ActivityModule(this))
                .widgetModule(WidgetModule())
                .build()

        injectModule(activityComponent)

        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
        }

        myCodeHere()
    }

    protected abstract fun injectModule(activityComponent: ActivityComponent)

    protected abstract fun getLayoutResource(): Int

    protected abstract fun myCodeHere()

    protected abstract fun onDetachScreen()

    override fun onDestroy() {
        super.onDestroy()
        onDetachScreen()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

}

