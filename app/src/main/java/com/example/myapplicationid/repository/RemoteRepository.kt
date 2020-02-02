package com.example.myapplicationid.repository

import com.example.myapplicationid.repository.entity.UserListResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRepository private constructor(): Repository {

init {
    createApi()
}

    companion object {
        private var repo : RemoteRepository? = null

        fun getInstance() : RemoteRepository {
            if (repo == null) {
                repo = RemoteRepository()
            }
            return repo!!
        }
    }

    private lateinit var api: ApiInterface
    private val token = "C7bvQyN0UvykiiOtjAiDeYG6URhnjI7MNQ5f"
    private var format = "json"

    override fun getUserList(): Call<UserListResponse> = api.getNetworkData2(
        format,
        token
    )

    private fun createApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gorest.co.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiInterface::class.java)
    }


}