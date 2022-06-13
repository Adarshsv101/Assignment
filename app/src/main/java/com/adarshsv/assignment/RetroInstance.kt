package com.adarshsv.assignment


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class RetroInstance {
    companion object{
        val baseUrl = "https://gorest.co.in/public-api/"
        fun getRetroInstance(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client (client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}