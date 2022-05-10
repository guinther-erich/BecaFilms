package com.gklausan.becafilms.repository

import com.gklausan.becafilms.model.Results

interface IMovieRepository{
    suspend fun getAllResults(): Results
}