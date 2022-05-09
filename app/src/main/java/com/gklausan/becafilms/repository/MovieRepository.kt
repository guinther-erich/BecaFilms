package com.gklausan.becafilms.repository

import com.gklausan.becafilms.api.IRetrofitService

class MovieRepository constructor(private val retrofitService: IRetrofitService) {

    fun getAllResults() = retrofitService.getAllResults()
}