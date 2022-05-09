package com.gklausan.becafilms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gklausan.becafilms.repository.MovieRepository
import com.gklausan.becafilms.repository.MovieRepositoryDetails

class MovieViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T
    }
}
class MovieViewModelFactoryDetails(private val repositoryDetails: MovieRepositoryDetails) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModelDetails(repositoryDetails) as T
    }
}