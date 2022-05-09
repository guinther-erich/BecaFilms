package com.gklausan.becafilms.api

import com.gklausan.becafilms.repository.Interceptor
import okhttp3.OkHttpClient

object HttpClient {
    val clientInterceptor by lazy {
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptor())
            .build()
    }
}