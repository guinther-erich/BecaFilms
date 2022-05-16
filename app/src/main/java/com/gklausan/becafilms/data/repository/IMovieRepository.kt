package com.gklausan.becafilms.data.repository

import com.gklausan.becafilms.domain.model.Results

interface IMovieRepository {
    suspend fun getAllResults(): Results
}
