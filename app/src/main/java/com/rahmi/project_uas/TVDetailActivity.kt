package com.rahmi.project_uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rahmi.project_uas.model.TV
import kotlinx.android.synthetic.main.activity_tvdetail.img_item_photo
import kotlinx.android.synthetic.main.activity_tvdetail.tv_item_desc
import kotlinx.android.synthetic.main.activity_tvdetail.tv_item_name

class TVDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TvS = "extra_tvs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tvdetail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        img_item_photo.clipToOutline = true

        val detailTvs = intent.getParcelableExtra<TV>(TVDetailActivity.EXTRA_TvS)

        if (detailTvs != null){
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailTvs.poster).into(img_item_photo)
            tv_item_name.text = detailTvs.title
            tv_item_desc.text = detailTvs.overview

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}