package com.gklausan.becafilms.presenter.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gklausan.becafilms.R
import com.gklausan.becafilms.databinding.ActivityMovieDetailsBinding
import com.gklausan.becafilms.domain.model.TrendingFilms

class MovieDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy {
        ActivityMovieDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.tvMovieDescription.movementMethod = ScrollingMovementMethod()
        binding.ivBack.setOnClickListener(this)
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
        val movieVoteAverage = intent.getFloatExtra(
            "movieVoteAverage",
            movieSelected.vote_average.toFloat()
        )
        val movieReleaseDate = intent.getStringExtra("movieReleaseDate")
        binding.tvMovieTitle.text = movieTitle
        binding.tvReleaseDate.text = "Lançamento: $movieReleaseDate"
        binding.tvVoteAverage.text = "Classificação: $movieVoteAverage"
        return movieSelected
    }

    override fun onClick(view: View) {
        if (view.id == R.id.iv_back) {
            finish()
        }
    }
}
