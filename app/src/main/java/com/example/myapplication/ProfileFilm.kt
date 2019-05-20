package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile_film.*

class ProfileFilm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_film)
        getAndPutData()

    }
    private fun getAndPutData() {
        val data = intent.extras
        if(data != null) {
            val film = data.getParcelable("FILM_KEY") as Movie
            val content =film.overview
            val releasedate = film.release_date
            val title = film.title
            val play_video = film.video
            val poster_path2 = film.poster_path
            val vote = film.vote_average

            idTitle.text = title
            tvReleasedate.text = releasedate
            tvContent.text = content
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/"+poster_path2)
                .centerCrop()
                .placeholder(R.drawable.student)
                .into(poster)
            if (play_video == true){
                tvPlay.visibility = View.VISIBLE
            }
            else
            {
                tvPlay.visibility = View.INVISIBLE
            }

            idVote.rating = (vote/2).toFloat()
        }
    }
}


