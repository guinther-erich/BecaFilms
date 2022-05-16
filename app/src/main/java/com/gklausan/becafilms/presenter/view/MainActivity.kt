package com.gklausan.becafilms.presenter.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gklausan.becafilms.data.api.HttpClient
import com.gklausan.becafilms.data.api.IRetrofitService
import com.gklausan.becafilms.data.repository.MovieRepository
import com.gklausan.becafilms.databinding.ActivityMainBinding
import com.gklausan.becafilms.presenter.viewmodel.movie.MovieResult
import com.gklausan.becafilms.domain.model.Results
import com.gklausan.becafilms.domain.utils.Constants
import com.gklausan.becafilms.presenter.adapters.MovieItemAdapter
import com.gklausan.becafilms.presenter.viewmodel.movie.MovieViewModel
import com.gklausan.becafilms.presenter.viewmodel.movie.MovieViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofitInstanceMain by lazy {
        Retrofit.Builder()
            .client(HttpClient.clientInterceptor)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val movieClient: IRetrofitService by lazy {
        retrofitInstanceMain.create(IRetrofitService::class.java)
    }

    private val movieRepository = MovieRepository(movieClient)

    private val movieFactory = MovieViewModelFactory(movieRepository)

    private val movieViewModel by viewModels<MovieViewModel> { movieFactory }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val movieListAdapter = MovieItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        movieListAdapter.onClickListener = { movieId ->
            goToMovieDetails(movieId)
        }
        binding.movieItemRecyclerView.adapter = movieListAdapter
        movieViewModel.getAllResults()
        getMovieAndObserve()
    }

    private fun getMovieAndObserve() {
        movieViewModel.movies.observe(this) { movieApiResult ->
            when (movieApiResult) {
                is MovieResult.Loading -> {
                    Log.d("Info", "Loading")
                }
                is MovieResult.Success -> {
                    Log.d("Info", "Loaded")
                    setListAdapter(movieApiResult.data)
                }
                is MovieResult.Error -> {
                    setListAdapter(movieApiResult.emptyResult)
                    (
                        Toast.makeText(
                            this,
                            "Something unexpected happened, try again later.",
                            Toast.LENGTH_LONG
                        ).show()
                        )
                }
            }
        }
    }

    private fun setListAdapter(list: Results) {
        movieListAdapter.submitList(list.results)
    }

    private fun goToMovieDetails(movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)

        movieViewModel.movies.observe(this) { movieResult ->
            when (movieResult) {
                is MovieResult.Success -> {
                    val movieSelected = movieResult.data.results.find { TrendingFilms ->
                        TrendingFilms.id == movieId
                    }
                    intent.putExtra("movieId", movieId)
                    intent.putExtra("movieTitle", movieSelected?.title)
                    intent.putExtra("movieAdult", movieSelected?.adult)
                    intent.putExtra("movieReleaseDate", movieSelected?.release_date)
                    intent.putExtra("movieVoteAverage", movieSelected?.vote_average)
                    intent.putExtra("movieSelected", movieSelected)
                    startActivity(intent)
                }
            }
        }
    }
}
