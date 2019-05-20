package com.example.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (var items: ArrayList<Movie>, val context: Context) : RecyclerView.Adapter<MovieViewHolder>() {
    lateinit var mListener: MovieItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        movieViewHolder.Name.text = items.get(position).title
        movieViewHolder.ReleaseDate.text = "Release date: "+items.get(position).release_date
        movieViewHolder.Language.text = "Original language: "+items.get(position).original_language
        movieViewHolder.Popularity.text = "Popularity: "+items.get(position).popularity
        movieViewHolder.Vote.text = "Vote count: "+items.get(position).vote_count
        var url : String? = "https://image.tmdb.org/t/p/w500/"+items[position].poster_path
        Glide.with(context)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.student)
            .into(movieViewHolder.tvAvatar)


        movieViewHolder.itemView.setOnClickListener {
            mListener.onItemCLicked(position)
        }


        // movieViewHolder.itemView.info.setOnClickListener(toDetail)

    }
    fun setListener(listener: MovieItemClickListener) {
        this.mListener = listener
    }

}


class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvAvatar = view.Avatar
    var Name = view.NameFilm
    var ReleaseDate = view.Release
    var Language = view.language
    var Popularity = view.popularity
    var Vote = view.vote_count
}