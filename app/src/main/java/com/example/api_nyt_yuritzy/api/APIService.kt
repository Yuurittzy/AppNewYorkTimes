package com.example.api_nyt_yuritzy.api

import com.example.api_nyt_yuritzy.data.NYTResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getResponse(@Url url:String): Response<NYTResponse>
}