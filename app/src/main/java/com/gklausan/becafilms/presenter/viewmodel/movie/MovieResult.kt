package com.gklausan.becafilms.presenter.viewmodel.movie

import com.gklausan.becafilms.domain.model.Results

sealed class MovieResult<T> {
    class Loading<T> : MovieResult<T>()
    class Success<T>(val data: T) : MovieResult<T>()
    class Error<T>(val throwable: Throwable, val emptyResult: Results) : MovieResult<T>()
}
