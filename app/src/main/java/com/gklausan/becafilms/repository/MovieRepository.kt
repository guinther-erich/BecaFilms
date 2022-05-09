package com.gklausan.becafilms.repository

import com.gklausan.becafilms.api.IRetrofitService
import com.gklausan.becafilms.api.RetrofitServiceDetail
import com.gklausan.becafilms.model.MovieDetails
import com.gklausan.becafilms.model.Results

class MovieRepository(private val movieClient:IRetrofitService): IMovieRepository {
    override suspend fun getAllResults(): Results {
        return movieClient.getAllResults()
    }
}

class MovieRepositoryDetails(private val movieDetailsClient: RetrofitServiceDetail): IMovieRepositoryDetails {
    override suspend fun getMovieDetails(): MovieDetails {
        return movieDetailsClient.getMovieDetails()
    }
}