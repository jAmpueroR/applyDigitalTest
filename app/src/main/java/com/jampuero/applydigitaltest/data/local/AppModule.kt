package com.jampuero.applydigitaltest.data.local

import android.app.Application
import androidx.room.Room
import com.jampuero.applydigitaltest.data.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): PostDatabase {
        return Room.databaseBuilder(app, PostDatabase::class.java, "article_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticleDao(db: PostDatabase): PostDao {
        return db.articleDao()
    }

    @Provides
    @Singleton
    fun provideArticleRepository(dao: PostDao): PostRepository {
        return PostRepository(dao)
    }
}