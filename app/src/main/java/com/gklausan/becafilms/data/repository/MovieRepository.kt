package com.gklausan.becafilms.data.repository

import com.gklausan.becafilms.data.api.IRetrofitService
import com.gklausan.becafilms.domain.model.Results

class MovieRepository(private val movieClient: IRetrofitService) : IMovieRepository {
    override suspend fun getAllResults(): Results {
        return movieClient.getAllResults()
    }
}
