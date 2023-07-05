package com.rahmi.project_uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rahmi.project_uas.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.tv_item_name
import kotlinx.android.synthetic.main.activity_tvdetail.img_item_photo
import kotlinx.android.synthetic.main.activity_tvdetail.tv_item_desc

class MovieDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIES = "extra_movies"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        img_item_photo.clipToOutline = true

        val detailMovies = intent.getParcelableExtra<Movie>(EXTRA_MOVIES)

        if (detailMovies != null){
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailMovies.poster).into(img_item_photo)
            tv_item_name.text = detailMovies.title
            tv_item_desc.text = detailMovies.overview

        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}