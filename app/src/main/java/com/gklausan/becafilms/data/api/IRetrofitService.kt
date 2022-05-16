package com.gklausan.becafilms.data.api

import com.gklausan.becafilms.domain.model.Results
import com.gklausan.becafilms.domain.utils.Constants
import retrofit2.http.GET

interface IRetrofitService {
    @GET(Constants.PATH_URL)
    suspend fun getAllResults(): Results
}
