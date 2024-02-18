package com.test.moviedbkoin.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.domain.model.movie.ProductionCountry
import com.test.moviedbkoin.databinding.ItemProductionCountriesBinding

class ProductionCountriesAdapter() :
    ListAdapter<ProductionCountry, ProductionCountriesAdapter.ViewHolder>(
        ProductionCountriesDiffCallBack
    ) {
    inner class ViewHolder(private val binding: ItemProductionCountriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productionCountry: ProductionCountry) {
            binding.apply {
                titleTv.text = productionCountry.name
                isoTv.text = productionCountry.iso_3166_1
            }
        }
    }

    object ProductionCountriesDiffCallBack : DiffUtil.ItemCallback<ProductionCountry>() {
        override fun areItemsTheSame(
            oldItem: ProductionCountry,
            newItem: ProductionCountry
        ): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: ProductionCountry,
            newItem: ProductionCountry
        ): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductionCountriesBinding.inflate(
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
}