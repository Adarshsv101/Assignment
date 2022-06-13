package com.adarshsv.assignment

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUsersList(): retrofit2.Call<UserList>
}