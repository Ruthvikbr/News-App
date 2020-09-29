package com.ruthvikbr.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ruthvikbr.newsapp.models.Article


@Database(entities = [Article::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArticleDatabase :RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

}