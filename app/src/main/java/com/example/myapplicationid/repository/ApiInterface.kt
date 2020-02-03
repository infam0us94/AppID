package com.example.myapplicationid.repository

import com.example.myapplicationid.repository.entity.UserListResponse
import com.example.myapplicationid.repository.entity.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("public-api/users")
    fun getUserList(
        @Query("_format") format: String,
        @Query("access-token") accessToken: String
    ): Call<UserListResponse>

    @GET("public-api/users/{userId}") fun getUser(
        @Path ("userId") Id: Int?,
        @Query("_format") format: String,
        @Query ("access-token") accessToken: String
    ): Call<UserResponse>




}