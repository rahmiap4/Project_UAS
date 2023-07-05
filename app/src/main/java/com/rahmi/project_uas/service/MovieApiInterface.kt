package com.rahmi.project_uas.service

import com.rahmi.project_uas.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=24962902e51d529c9f9690b2783c887e")
    fun getMovieList(): Call<MovieResponse>
}
