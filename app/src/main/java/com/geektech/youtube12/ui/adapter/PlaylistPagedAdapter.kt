package com.geektech.youtube12.ui.adapter

//import android.content.Context
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.paging.PagedListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.geektech.youtube12.databinding.ItemPlaylistBinding
//import com.geektech.youtube12.model.playlist.Item
//import com.geektech.youtube12.utils.loadImage
//
//class PlaylistPagedAdapter(val context: Context, private val onClick:(String)->Unit)
//    : PagedListAdapter<Item,PlaylistPagedAdapter.PlaylistViewHolder>(DIFF_CALLBACK){
//
//    inner class PlaylistViewHolder (private val binding: ItemPlaylistBinding):
//    RecyclerView.ViewHolder(binding.root){
//
//        fun bind(item: Item) {
//            itemView.setOnClickListener {
//                onClick(item.id.toString())
//            }
//            val count=item.contentDetails?.itemCount.toString()
//            val title=item.snippet?.title
//            binding.tvVideoCount.text=count+" video series"
//            binding.tvTitle.text=title
//            binding.ivVideo.loadImage(item.snippet?.thumbnails?.default?.url.toString())
//
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
//        return PlaylistViewHolder((ItemPlaylistBinding
//            .inflate(LayoutInflater.from(parent.context),parent,false)))
//    }
//
//    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
//        getItem(position)?.let {
//            holder.bind(it)
//        }
//    }
//
//    companion object{
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
//            // The ID property identifies when items are the same.
//            override fun areItemsTheSame(oldItem: Item, newItem: Item) =
//                oldItem.id == newItem.id
//
//            // If you use the "==" operator, make sure that the object implements
//            // .equals(). Alternatively, write custom data comparison logic here.
//            override fun areContentsTheSame(
//                oldItem: Item, newItem: Item) = oldItem == newItem
//        }
//    }
//}