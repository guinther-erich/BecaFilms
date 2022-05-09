package com.gklausan.becafilms.viewmodel

import androidx.lifecycle.*
import com.gklausan.becafilms.model.MovieDetails
import com.gklausan.becafilms.model.MovieResult
import com.gklausan.becafilms.model.Results
import com.gklausan.becafilms.model.mockResults
import com.gklausan.becafilms.repository.IMovieRepository
import com.gklausan.becafilms.repository.IMovieRepositoryDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieViewModel(
    private val movieRepository: IMovieRepository,
) : ViewModel() {
    private val movieList = MutableLiveData<MovieResult<Results>>()
    val movies: LiveData<MovieResult<Results>> = movieList

    fun getAllResults() {
        viewModelScope.launch {
            movieList.value = MovieResult.Loading()
            try {
                val movieFromApi = withContext(Dispatchers.IO) {
                    movieRepository.getAllResults()
                }
                movieList.value = MovieResult.Success(movieFromApi)
            } catch (e: Exception) {
                val movieResult = MovieResult.Error<Results>(e, mockResults())

                movieList.value = movieResult
            }
        }
    }
}

class MovieViewModelDetails(
    private val movieRepositoryDetails: IMovieRepositoryDetails,
) : ViewModel() {
    private val detailMovie = MutableLiveData<MovieDetails>()
    val movies: LiveData<MovieDetails> = detailMovie

    fun getAllResultsDetails() {
        viewModelScope.launch {
            val movieFromApiDetails = withContext(Dispatchers.IO) {
                movieRepositoryDetails.getMovieDetails()
            }
            detailMovie.value = movieFromApiDetails
        }
    }
}