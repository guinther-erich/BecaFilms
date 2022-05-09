package com.gklausan.becafilms.model

data class Results(
    val page: Int,
    val results: List<TrendingFilms>,
    val total_pages: Int,
    val total_results: Int
)