package com.example.myapplicationid.repository

import com.example.myapplicationid.repository.entity.UserListResponse
import com.example.myapplicationid.repository.entity.UserResponse
import retrofit2.Call

interface Repository {
   fun getUserList() : Call<UserListResponse>
   fun getUser(id: Int?): Call<UserResponse>
}