package com.mrmukto12.moviemvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mrmukto12.moviemvvm.databinding.FragmentDetailsBinding
import com.mrmukto12.moviemvvm.viewmodels.MovieViewModel


class DetailsFragment : Fragment() {

    private val movieViewModel : MovieViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }


}