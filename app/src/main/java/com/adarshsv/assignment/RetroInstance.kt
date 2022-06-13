package com.adarshsv.assignment


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class RetroInstance {
    companion object{

        val baseUrl = "https://gorest.co.in/public-api/" /*url of website with json doc*/
        fun getRetroInstance(): Retrofit {

            val interceptor = HttpLoggingInterceptor()              /*to log http rquests and response*/
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


            return Retrofit.Builder() /*uses the Builder API to allow defining the URL end point for the HTTP operations*/
                .baseUrl(baseUrl)
                .client (client)
                .addConverterFactory(GsonConverterFactory.create()) /*Gson converter factory*/
                .build()
        }
    }
}