package com.mrmukto12.moviemvvm.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrmukto12.moviemvvm.databinding.ItemMovieBinding
import com.mrmukto12.moviemvvm.models.PopularModel

class MovieAdapter : ListAdapter<PopularModel.Result, MovieAdapter.MovieViewholder > (MovieDiffUtil()){
    class MovieViewholder(val binding: ItemMovieBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(item: PopularModel.Result){
                    binding.item = item
                }
            }
    class MovieDiffUtil :DiffUtil.ItemCallback<PopularModel.Result>() {
        override fun areItemsTheSame(
            oldItem: PopularModel.Result,
            newItem: PopularModel.Result,
        ): Boolean {
          return oldItem ==newItem
        }

        override fun areContentsTheSame(
            oldItem: PopularModel.Result,
            newItem: PopularModel.Result,
        ): Boolean {
           return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewholder {
       val binding  = ItemMovieBinding.inflate(
           LayoutInflater.from(parent.context),parent, false
       )
        return  MovieViewholder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}