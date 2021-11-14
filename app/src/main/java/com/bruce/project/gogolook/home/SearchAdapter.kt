package com.bruce.project.gogolook.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bruce.project.gogolook.databinding.SearchItemBinding
import com.bruce.project.gogolook.entity.HitsItems

class SearchAdapter :
    PagingDataAdapter<HitsItems, SearchAdapter.SearchListViewHolder>(REPO_COMPARATOR) {

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        return SearchListViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class SearchListViewHolder(private val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HitsItems) = with(binding) {
            ivAvatar.load(item.largeImageURL)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<HitsItems>() {

            override fun areItemsTheSame(oldItem: HitsItems, newItem: HitsItems): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: HitsItems, newItem: HitsItems): Boolean =
                oldItem == newItem
        }
    }
}