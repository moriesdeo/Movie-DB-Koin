package com.test.moviedbkoin.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.domain.model.movie.Genre
import com.test.moviedbkoin.databinding.GenreItemBinding

class GenreAdapter(
    private val onCLick: (Genre) -> Unit
) : ListAdapter<Genre, GenreAdapter.GenreViewHolder>(GenreDiffCallBack) {
    object GenreDiffCallBack : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreAdapter.GenreViewHolder {
        return GenreViewHolder(
            GenreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class GenreViewHolder(private val binding: GenreItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Genre) {
            binding.apply {
                titleTv.text = data.name
                root.setOnClickListener {
                    onCLick.invoke(data)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: GenreAdapter.GenreViewHolder, position: Int) {
        getItem(position)?.let { data ->
            holder.bind(data)
        }
    }

    override fun submitList(list: List<Genre?>?) {
        super.submitList(list)
    }
}