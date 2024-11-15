package com.jampuero.applydigitaltest.data.repository

import com.jampuero.applydigitaltest.data.local.PostDao
import com.jampuero.applydigitaltest.data.model.PostEntity
import com.jampuero.applydigitaltest.data.remote.RetrofitInstance
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class PostRepository @Inject constructor(private val dao: PostDao) {

    val posts: Flow<List<PostEntity>> = dao.getPosts()

    suspend fun fetchAndSavePosts() {
        try {
            val response = RetrofitInstance.api.fetchPosts()
            if (response.isSuccessful) {
                response.body()?.hits?.let { posts ->
                    dao.insertAll(posts)
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    suspend fun deletePost(postEntity: PostEntity) {
        dao.softDeletePosts(postEntity.id)
    }
}