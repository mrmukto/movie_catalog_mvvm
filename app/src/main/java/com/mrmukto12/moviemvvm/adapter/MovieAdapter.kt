package com.mrmukto12.moviemvvm.adapter

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mrmukto12.moviemvvm.R
import com.mrmukto12.moviemvvm.databinding.ItemMovieBinding
import com.mrmukto12.moviemvvm.models.PopularModel

class MovieAdapter : ListAdapter<PopularModel.Result, MovieAdapter.MovieViewHolder>(MovieDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        Log.d("MovieAdapter", "Item at position ${item.title}")

    }

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)

        fun bind(item: PopularModel.Result) {
            binding.item = item
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${item.posterPath}")
                .transform(CenterCrop())
                .into(poster)

        }
    }

    class MovieDiffUtil : DiffUtil.ItemCallback<PopularModel.Result>() {
        override fun areItemsTheSame(oldItem: PopularModel.Result, newItem: PopularModel.Result): Boolean {
            return oldItem.id == newItem.id // Assuming 'id' is the unique identifier
        }

        override fun areContentsTheSame(oldItem: PopularModel.Result, newItem: PopularModel.Result): Boolean {
            return oldItem == newItem // You might want to compare specific fields if needed
        }
    }
}
