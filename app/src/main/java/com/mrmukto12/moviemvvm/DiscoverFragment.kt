package com.mrmukto12.moviemvvm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrmukto12.moviemvvm.adapter.MovieAdapter
import com.mrmukto12.moviemvvm.databinding.FragmentDiscoverBinding
import com.mrmukto12.moviemvvm.viewmodels.MovieViewModel


class DiscoverFragment : Fragment() {
    private val movieViewModel : MovieViewModel by activityViewModels()
    private lateinit var binding:  FragmentDiscoverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDiscoverBinding.inflate(inflater,container,false)
        val adapter  = MovieAdapter()
        binding.popularRV.layoutManager = LinearLayoutManager(requireActivity()).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        movieViewModel.fetchData()
       binding.popularRV.adapter = adapter
        movieViewModel.popularMovieLiveData.observe(viewLifecycleOwner){
            Log.d("movie", "${it.results}")
            binding.popular = it
            adapter.submitList(it.results)
        }
        movieViewModel.upcomingMovieLiveData.observe(viewLifecycleOwner){
            Log.d("up", "${it.results}")
        }

        movieViewModel.topratedMovieLiveData.observe(viewLifecycleOwner){
            Log.d("top", "${it.results}")
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}