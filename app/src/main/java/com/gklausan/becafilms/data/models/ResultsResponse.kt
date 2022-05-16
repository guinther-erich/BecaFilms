package com.gklausan.becafilms.data.models

import com.gklausan.becafilms.domain.model.Results
import com.gklausan.becafilms.domain.model.TrendingFilms

data class ResultsResponse(
    val pageResults: Int,
    val resultsList: MutableList<TrendingFilms>,
    val totalPagesResults: Int,
    val totalResults: Int
)

fun ResultsResponse.toResponse() = Results(
    page = this.pageResults,
    results = this.resultsList,
    total_pages = totalPagesResults,
    total_results = this.totalPagesResults
)
