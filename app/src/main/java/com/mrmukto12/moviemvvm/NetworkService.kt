package com.mrmukto12.moviemvvm

import com.mrmukto12.moviemvvm.models.PopularModel
import com.mrmukto12.moviemvvm.models.TopratedModel
import com.mrmukto12.moviemvvm.models.UpcomingModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

const val movie_api_key = "53a3fedaca98c4bcf210a970522c3e89"
const val base_url = "https://api.themoviedb.org/3/"
const val image_url = "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg"


//retrofit object
val retrofit= Retrofit.Builder()
 .baseUrl(base_url)
 .addConverterFactory(GsonConverterFactory.create())
 .build()

//endUrl interface method
interface MovieServiceApi{
 @GET
 suspend fun getPopularMovie(@Url endUrl: String) :PopularModel

 @GET
 suspend fun getUpcomingMovie(@Url endUrl: String) :UpcomingModel

 @GET
 suspend fun getTopratedMovie(@Url endUrl: String) :TopratedModel
}

//interface object
object NetworkService {
 val movieServiceApi:MovieServiceApi by lazy {
  retrofit.create(MovieServiceApi::class.java)
 }
}