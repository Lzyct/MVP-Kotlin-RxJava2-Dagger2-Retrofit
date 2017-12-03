package com.tuxdev.books.di.module

import com.anandahospital.myanandahospital.network.BookService
import com.tuxdev.books.data.repository.BookRepository
import com.tuxdev.books.data.repository.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 **********************************************
 * Created by ukie on 12/2/17 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2017 | All Right Reserved
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideBookService(retrofit: Retrofit): BookService = retrofit.create(BookService::class.java)

    @Provides
    @Singleton
    fun provideBookRepo(bookRepositoryImpl: BookRepositoryImpl): BookRepository = bookRepositoryImpl

}