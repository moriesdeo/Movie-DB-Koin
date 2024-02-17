package com.test.moviedbkoin.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.core.extension.loadImage
import com.test.domain.model.credentials.ListMoviesData
import com.test.moviedbkoin.BuildConfig
import com.test.moviedbkoin.databinding.DiscoverMovieItemBinding

class DiscoverMovieAdapter(
    private val onclick: (ListMoviesData) -> Unit
) : ListAdapter<ListMoviesData, DiscoverMovieAdapter.ViewHolder>(DiscoverMovieDiffCallBack) {

    inner class ViewHolder(private val binding: DiscoverMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ListMoviesData) {
            binding.apply {
                coverImg.loadImage(BuildConfig.MOVIE_BASE_URL + "${data.backdrop_path}")
                titleTv.text = data.title
                root.setOnClickListener { onclick.invoke(data) }
            }
        }
    }

    object DiscoverMovieDiffCallBack : DiffUtil.ItemCallback<ListMoviesData>() {
        override fun areItemsTheSame(oldItem: ListMoviesData, newItem: ListMoviesData): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ListMoviesData, newItem: ListMoviesData): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DiscoverMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun submitList(list: List<ListMoviesData>?) {
        super.submitList(list)
    }
}