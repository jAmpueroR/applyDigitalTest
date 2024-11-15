package com.jampuero.applydigitaltest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jampuero.applydigitaltest.data.model.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract fun articleDao(): PostDao
}