package com.example.myapplicationid.user_profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationid.repository.RemoteRepository
import com.example.myapplicationid.repository.entity.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserProfileViewModel : ViewModel() {

    private val repository = RemoteRepository.getInstance()

    val userLiveData = MutableLiveData<UserResponse>()

    fun getUser(id: Int?) {
        repository.getUser(id)
            .enqueue(object : Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    userLiveData.postValue(response.body())
                }


            })
    }
}






