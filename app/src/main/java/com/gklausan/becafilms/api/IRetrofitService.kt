package com.gklausan.becafilms.api

import com.gklausan.becafilms.model.Results
import com.gklausan.becafilms.utils.Constants
import retrofit2.http.GET

interface IRetrofitService {
    @GET(Constants.PATH_URL)
    suspend fun getAllResults(): Results
}
