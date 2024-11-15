package com.jampuero.applydigitaltest.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jampuero.applydigitaltest.data.model.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM posts WHERE deleted = 0")
    fun getPosts(): Flow<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(postEntities: List<PostEntity>)

    @Delete
    suspend fun delete(postEntity: PostEntity)

    @Insert
    suspend fun insert(postEntity: PostEntity)

    @Query("UPDATE posts SET deleted = 1 WHERE id = :postId")
    suspend fun softDeletePosts(postId: String)
}