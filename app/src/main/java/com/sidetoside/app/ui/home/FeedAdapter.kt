package com.sidetoside.app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sidetoside.app.databinding.HolderFeedBinding
import com.sidetoside.app.entity.Compare


class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedHolder>() {

    private val items by lazy { mutableListOf<Compare>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedHolder =
        FeedHolder(
            HolderFeedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        holder.onBind(items[position])
    }

    fun setItems(items: List<Compare>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class FeedHolder(
        private val binding: HolderFeedBinding,
        private val root: View = binding.root
    ) : RecyclerView.ViewHolder(root) {

        fun onBind(compare: Compare) = with(binding) {
            data = compare
            executePendingBindings()
        }
    }
}

