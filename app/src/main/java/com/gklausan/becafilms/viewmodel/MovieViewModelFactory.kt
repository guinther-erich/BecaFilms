package com.gklausan.becafilms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gklausan.becafilms.repository.MovieRepository

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory constructor (private val repository: MovieRepository) :
    ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            MovieViewModel(this.repository) as T
        } else
        {
            throw IllegalArgumentException("Cant find viewmodel")
        }
    }
}