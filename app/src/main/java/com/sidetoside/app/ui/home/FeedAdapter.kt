package com.sidetoside.app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sidetoside.app.databinding.HolderFeedBinding
import com.sidetoside.app.entity.LeftRight


class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedHolder>() {

    private val items by lazy { mutableListOf<LeftRight>() }

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

    fun setItems(items: List<LeftRight>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class FeedHolder(
        private val binding: HolderFeedBinding,
        private val root: View = binding.root
    ) : RecyclerView.ViewHolder(root) {

        fun onBind(leftRight: LeftRight) = with(binding) {
            data = leftRight
            executePendingBindings()
        }
    }
}

