package com.gklausan.becafilms.data.api

import com.gklausan.becafilms.data.repository.Interceptor
import okhttp3.OkHttpClient

object HttpClient {
    val clientInterceptor by lazy {
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptor())
            .build()
    }
}
