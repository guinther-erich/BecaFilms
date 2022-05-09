package com.gklausan.becafilms.api

import com.gklausan.becafilms.model.Results
import com.gklausan.becafilms.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET(Constants.PATH_URL)
    fun getAllLives(): Call<List<Results>>

    companion object {
        private val retrofitService: RetrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance():RetrofitService{
            return retrofitService
        }
    }
}