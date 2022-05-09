package com.gklausan.becafilms.model

sealed class MovieResult<T>{
    class Loading<T>: MovieResult<T>()
    class Success<T>(val data:T): MovieResult<T>()
    class Error<T>(val throwable: Throwable,val emptyLive:Results): MovieResult<T>()
}