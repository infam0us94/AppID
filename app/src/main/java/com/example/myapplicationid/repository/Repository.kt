package com.example.myapplicationid.repository

import com.example.myapplicationid.repository.entity.UserListResponse
import retrofit2.Call

interface Repository {

   fun getUserList() : Call<UserListResponse>
}