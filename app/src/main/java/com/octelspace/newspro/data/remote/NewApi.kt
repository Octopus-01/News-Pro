package com.octelspace.newspro.data.remote

import com.octelspace.newspro.data.remote.dto.NewsResponse
import com.octelspace.newspro.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}