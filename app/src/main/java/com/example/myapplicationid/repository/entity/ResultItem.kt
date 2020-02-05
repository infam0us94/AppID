package com.example.myapplicationid.repository.entity

import com.google.gson.annotations.SerializedName

data class ResultItem (
    val website: String? = null,
    val address: String? = null,
    val gender: String? = null,
    val phone: String? = null,
    val dob: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    val id: Int? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    val email: String? = null,
    val status: String? = null
)