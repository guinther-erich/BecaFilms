package com.gklausan.becafilms.presenter.viewmodel.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gklausan.becafilms.data.repository.IMovieRepository
import com.gklausan.becafilms.domain.model.Results
import com.gklausan.becafilms.domain.model.mockResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
