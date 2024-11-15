package com.jampuero.applydigitaltest.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("search_by_date?query=mobile")
    suspend fun fetchPosts(): Response<ApiResponse>
}