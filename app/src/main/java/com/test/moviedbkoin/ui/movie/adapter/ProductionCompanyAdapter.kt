package com.test.moviedbkoin.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.domain.model.movie.ProductionCompany
import com.test.moviedbkoin.databinding.ItemProductionCompanyBinding

class ProductionCompanyAdapter() :
    ListAdapter<ProductionCompany, ProductionCompanyAdapter.ViewHolder>(
        ProductionCompanyDiffCallBack
    ) {

    object ProductionCompanyDiffCallBack : DiffUtil.ItemCallback<ProductionCompany>() {
        override fun areItemsTheSame(
            oldItem: ProductionCompany,
            newItem: ProductionCompany
        ): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: ProductionCompany,
            newItem: ProductionCompany
        ): Boolean =
            oldItem == newItem
    }

    inner class ViewHolder(private val binding: ItemProductionCompanyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productionCompany: ProductionCompany) {
            binding.apply {

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductionCompanyAdapter.ViewHolder {
        return ViewHolder(
            ItemProductionCompanyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductionCompanyAdapter.ViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
        }
    }
}