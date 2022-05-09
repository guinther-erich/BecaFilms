package com.gklausan.becafilms.api

import com.gklausan.becafilms.model.MovieDetails
import com.gklausan.becafilms.model.Results
import com.gklausan.becafilms.utils.Constants
import retrofit2.http.GET

interface IRetrofitService {
    @GET(Constants.PATH_URL)
    suspend fun getAllResults(): Results
}

interface RetrofitServiceDetail {
    @GET(Constants.PATH_MOVIE_DETAIL)
    suspend fun getMovieDetails(): MovieDetails
}