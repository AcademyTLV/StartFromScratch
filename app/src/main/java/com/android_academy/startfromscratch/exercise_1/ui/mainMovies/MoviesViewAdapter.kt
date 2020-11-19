package com.android_academy.startfromscratch.exercise_1.ui.mainMovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesViewAdapter(private val movieClickListener: OnMovieClickListener) :
    RecyclerView.Adapter<MoviesViewAdapter.ViewHolder>() {

    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view, movieClickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setData(newItems: List<Movie>) {
        movies.clear()
        movies.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View, movieClickListener: OnMovieClickListener) :
        RecyclerView.ViewHolder(view) {

        private val ivImage: ImageView = view.movieImage
        private val tvTitle: TextView = view.movieNameText
        private lateinit var movie: Movie


        init {
            view.setOnClickListener {
                movieClickListener.onMovieClicked(movie, adapterPosition)
            }
        }

        fun bind(movie: Movie) {
            if (movie.imageUrl.isNotEmpty()) {
                Picasso.get()
                    .load(movie.imageUrl)
                    .into(ivImage)
            }

            tvTitle.text = movie.name
            this.movie = movie
        }
    }

}