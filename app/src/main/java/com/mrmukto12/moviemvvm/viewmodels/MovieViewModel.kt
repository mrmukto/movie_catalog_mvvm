package com.mrmukto12.moviemvvm.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrmukto12.moviemvvm.models.PopularModel
import com.mrmukto12.moviemvvm.models.TopratedModel
import com.mrmukto12.moviemvvm.models.UpcomingModel
import com.mrmukto12.moviemvvm.repos.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    val repository = MovieRepository()

    val popularMovieLiveData : MutableLiveData<PopularModel> = MutableLiveData()
    val upcomingMovieLiveData : MutableLiveData<UpcomingModel> = MutableLiveData()
    val topratedMovieLiveData : MutableLiveData<TopratedModel> = MutableLiveData()


    fun fetchData() {
        viewModelScope.launch {
            try {
                popularMovieLiveData.value = repository.fetchPopularMovieData()
                upcomingMovieLiveData.value = repository.fetchUpcomingMovieData()
                topratedMovieLiveData.value = repository.fetchTopratedMovieData()
            }catch (e: Exception) {
                 Log.d("MovieViewModel", e.localizedMessage)
            }
        }
    }
}