package com.geektech.youtube12.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtube12.databinding.ItemDetailBinding
import com.geektech.youtube12.model.playlist.Item

class DetailAdapter:RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private val data:ArrayList<Item> = arrayListOf()

    fun addData(newData: List<Item>?){
        data.clear()
        if(newData!=null)
            data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class DetailViewHolder(val binding: ItemDetailBinding)
        :RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.apply {

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(ItemDetailBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
       holder.bind(data[position])
    }

    override fun getItemCount()=data.size

}