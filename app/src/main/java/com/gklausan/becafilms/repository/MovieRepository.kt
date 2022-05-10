package com.gklausan.becafilms.repository

import com.gklausan.becafilms.api.IRetrofitService
import com.gklausan.becafilms.model.Results

class MovieRepository(private val movieClient:IRetrofitService): IMovieRepository {
    override suspend fun getAllResults(): Results {
        return movieClient.getAllResults()
    }
}