package com.ruthvikbr.newsapp.di

import android.content.Context
import androidx.room.Room
import com.ruthvikbr.newsapp.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun createDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        ArticleDatabase::class.java,
        "ArticleDb"
    ).build()

    @Singleton
    @Provides
    fun getDao(db : ArticleDatabase) = db.getArticleDao()
}