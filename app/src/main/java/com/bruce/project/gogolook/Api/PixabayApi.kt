package com.bruce.project.gogolook.Api

import com.bruce.project.gogolook.entity.PixabayData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface PixabayApi {
    @GET("api/")
    suspend fun getSearchImage(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): PixabayData
}