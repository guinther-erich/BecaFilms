package com.gklausan.becafilms.presenter.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gklausan.becafilms.R
import com.gklausan.becafilms.databinding.MovieListItemBinding
import com.gklausan.becafilms.domain.model.TrendingFilms
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MovieItemAdapter :
    ListAdapter<TrendingFilms, MovieItemAdapter.MovieItemViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((movieId: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding =
            MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItemViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieItemViewHolder(
        private val binding: MovieListItemBinding,
        private val onClickListener: ((movieId: Int) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movie: TrendingFilms) {

            binding.tvMovieTitle.text = movie.title

            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original" + movie.poster_path)
                .placeholder(R.drawable.loading_black)
                .centerCrop()
                .into(binding.ivMovie)

            binding.tvReleaseDate.text = "Lançamento: ${movie.release_date.getDateTimeFormatted()}"

            binding.tvVoteAverage.text = "Classificação: ${movie.vote_average}"

            binding.root.setOnClickListener {
                onClickListener?.invoke(movie.id)
            }
        }

        private fun String.getDateTimeFormatted(): String {
            try {
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", getLocale())
                val date = dateFormat.parse(this)
                date?.let {
                    return getDateToStringFormatted(date, "dd/MM/yyyy")
                }
            } catch (e: ParseException) {
                e.localizedMessage?.let {
                    Log.d("TAG", "getDateTimeFormatted: $e")
                }
            }
            return orEmpty()
        }

        private fun getDateToStringFormatted(date: Date, dateString: String): String {
            val simpleDateFormat = SimpleDateFormat(dateString, getLocale())
            return simpleDateFormat.format(date)
        }

        private fun getLocale(): Locale {
            return Locale("pt", "BR")
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TrendingFilms>() {
            override fun areItemsTheSame(
                oldItem: TrendingFilms,
                newItem: TrendingFilms
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TrendingFilms,
                newItem: TrendingFilms
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
