package com.gklausan.becafilms.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gklausan.becafilms.R
import com.gklausan.becafilms.api.HttpClient
import com.gklausan.becafilms.model.TrendingFilms
import com.gklausan.becafilms.databinding.ActivityMovieDetailsBinding
import com.gklausan.becafilms.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private val retrofitInstanceDetails by lazy {
        Retrofit.Builder()
            .client(HttpClient.clientInterceptor)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val binding by lazy {
        ActivityMovieDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.tvMovieDescription.movementMethod = ScrollingMovementMethod()
        binding.moviePosterImage.setOnClickListener(this)
        val movieSelected = setDataDetailsActivity()

        val overview = movieSelected.overview
        binding.tvMovieDescription.text = overview

        Glide
            .with(binding.root.context)
            .load("https://image.tmdb.org/t/p/original" + movieSelected.backdrop_path)
            .placeholder(R.drawable.loading_details)
            .centerCrop()
            .into(binding.movieBackdropImage)

        Glide
            .with(binding.root.context)
            .load("https://image.tmdb.org/t/p/original" + movieSelected.poster_path)
            .placeholder(R.drawable.loading_details)
            .into(binding.moviePosterImage)
    }

    @SuppressLint("SetTextI18n")
    private fun setDataDetailsActivity(): TrendingFilms {
        val movieSelected = intent.getSerializableExtra("movieSelected") as TrendingFilms
        val movieTitle = intent.getStringExtra("movieTitle")
        val movieVoteAverage = intent.getFloatExtra("movieVoteAverage",
            movieSelected.vote_average.toFloat()
        )
        val movieReleaseDate = intent.getStringExtra("movieReleaseDate")
        binding.tvMovieTitle.text = movieTitle
        binding.tvReleaseDate.text = "Release date: $movieReleaseDate"
        binding.tvVoteAverage.text = "Vote average: $movieVoteAverage"
        return movieSelected

    }

    override fun onClick(view: View) {
        if (view.id == R.id.iv_movie) {
            finish()
        }
    }
}