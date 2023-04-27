package com.geektech.youtube12.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtube12.databinding.ItemDetailBinding
import com.geektech.youtube12.model.playlist.Item
import com.geektech.youtube12.utils.loadImage

class DetailAdapter(context: Context, private val onClick: (Item) -> Unit) :
    RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private val data: ArrayList<Item> = arrayListOf()

    fun addData(newData: List<Item>?) {
        data.clear()
        if (newData != null)
            data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class DetailViewHolder(val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            itemView.setOnClickListener {
                onClick(item)
            }
            val title = item.snippet?.title
            binding.tvDetailTime.text = item.snippet?.publishedAt
            binding.tvDetailTitle.text = title
            binding.ivDetailImage.loadImage(item.snippet?.thumbnails?.default?.url.toString())
        }

    }
}