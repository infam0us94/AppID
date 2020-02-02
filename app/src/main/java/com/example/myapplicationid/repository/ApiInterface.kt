package com.example.myapplicationid.repository

import com.example.myapplicationid.repository.entity.UserListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("public-api/users")
    fun getNetworkData2(
        @Query("_format") format: String,
        @Query("access-token") accessToken: String
    ): Call<UserListResponse>




}