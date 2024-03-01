package com.test.moviedbkoin.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.domain.model.movie.ReviewData
import com.test.moviedbkoin.databinding.ItemReviewsBinding

class ReviewsAdapter : ListAdapter<ReviewData, ReviewsAdapter.ViewHolder>(ReviewDataDiffCallBack) {
    object ReviewDataDiffCallBack : DiffUtil.ItemCallback<ReviewData>() {
        override fun areItemsTheSame(
            oldItem: ReviewData, newItem: ReviewData
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ReviewData, newItem: ReviewData
        ): Boolean = oldItem == newItem
    }

    inner class ViewHolder(val binding: ItemReviewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ReviewData){
            binding.apply {
                contentTv.text = data.content
                nameTv.text = data.author_details?.name
                usernameTv.text = data.author_details?.username
                ratingTv.text = data.author_details?.rating.toString()
                authorTv.text = data.author
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemReviewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
        }
    }
}