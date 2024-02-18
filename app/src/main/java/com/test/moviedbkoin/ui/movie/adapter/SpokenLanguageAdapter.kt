package com.test.moviedbkoin.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.domain.model.movie.SpokenLanguage
import com.test.moviedbkoin.databinding.ItemSpokenLanguageBinding

class SpokenLanguageAdapter :
    ListAdapter<SpokenLanguage, SpokenLanguageAdapter.ViewHolder>(SpokenLanguageDiffCallBack) {
    inner class ViewHolder(private val binding: ItemSpokenLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(spokenLanguage: SpokenLanguage) {
            binding.apply {
                nameTv.text = spokenLanguage.name
                nameEnglishTv.text = spokenLanguage.english_name
            }
        }
    }

    object SpokenLanguageDiffCallBack : DiffUtil.ItemCallback<SpokenLanguage>() {
        override fun areItemsTheSame(
            oldItem: SpokenLanguage,
            newItem: SpokenLanguage
        ): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: SpokenLanguage,
            newItem: SpokenLanguage
        ): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSpokenLanguageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
        }
    }
}