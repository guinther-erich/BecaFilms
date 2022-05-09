package com.gklausan.becafilms.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gklausan.becafilms.api.IRetrofitService
import com.gklausan.becafilms.model.Results
import com.gklausan.becafilms.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel constructor(private val repository: MovieRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Results>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllResults() {
        val request = repository.getAllResults()
        request.enqueue(object: Callback<List<Results>> {
            override fun onResponse(call: Call<List<Results>>, response: Response<List<Results>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Results>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}