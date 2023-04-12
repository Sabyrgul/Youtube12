package com.geektech.youtube12.ui.playlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtube12.databinding.ItemPlaylistBinding
import com.geektech.youtube12.model.playlist.Item
import com.geektech.youtube12.utils.loadImage

class PlaylistAdapter(private val onClick:(String)->Unit):RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private val data:ArrayList<Item> = arrayListOf()

   fun addData(newData: List<Item>?){
        data.clear()
       if(newData!=null)
        data.addAll(newData)
        notifyDataSetChanged()
    }

   inner class PlaylistViewHolder(private val binding:ItemPlaylistBinding)
       :RecyclerView.ViewHolder(binding.root) {
       fun bind(item: Item) {
           itemView.setOnClickListener {
               onClick(item.id.toString())
           }
           val count=item.contentDetails?.itemCount.toString()
           val title=item.snippet?.title
           binding.tvVideoCount.text=count
           binding.tvTitle.text=title
           binding.ivVideo.loadImage(item.snippet?.thumbnails?.default.toString())

       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
       return PlaylistViewHolder((ItemPlaylistBinding
           .inflate(LayoutInflater.from(parent.context),parent,false)))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount()=data.size
}