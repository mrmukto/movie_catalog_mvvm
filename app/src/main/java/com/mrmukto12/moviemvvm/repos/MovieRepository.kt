package com.mrmukto12.moviemvvm.repos

import com.mrmukto12.moviemvvm.NetworkService
import com.mrmukto12.moviemvvm.models.PopularModel
import com.mrmukto12.moviemvvm.models.TopratedModel
import com.mrmukto12.moviemvvm.models.UpcomingModel
import com.mrmukto12.moviemvvm.movie_api_key

class MovieRepository {
    suspend fun fetchPopularMovieData(): PopularModel {
        val endUrl = "movie/popular?api_key=53a3fedaca98c4bcf210a970522c3e89"
        return NetworkService.movieServiceApi
            .getPopularMovie(endUrl)
    }
    suspend fun fetchUpcomingMovieData(): UpcomingModel {
        val endUrl = "movie/top_rated?api_key=53a3fedaca98c4bcf210a970522c3e89"
        return NetworkService.movieServiceApi
            .getUpcomingMovie(endUrl)
    }
    suspend fun fetchTopratedMovieData(): TopratedModel {
        val endUrl = "movie/upcoming?api_key=53a3fedaca98c4bcf210a970522c3e89"
        return NetworkService.movieServiceApi
            .getTopratedMovie(endUrl)
    }

}