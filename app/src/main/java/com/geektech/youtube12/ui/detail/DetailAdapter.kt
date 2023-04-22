//package com.geektech.youtube12.ui.detail
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.geektech.youtube12.databinding.ItemDetailBinding
//import com.geektech.youtube12.model.playlist.Item
//import com.geektech.youtube12.utils.loadImage
//
//class DetailAdapter(private val onClick:(String)->Unit):RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
//
//    private val data:ArrayList<Item> = arrayListOf()
//
//    fun addData(newData: List<Item>?){
//        data.clear()
//        if(newData!=null)
//            data.addAll(newData)
//        notifyDataSetChanged()
//    }
//
//    inner class DetailViewHolder(val binding: ItemDetailBinding)
//        :RecyclerView.ViewHolder(binding.root) {
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
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
//        return DetailViewHolder(ItemDetailBinding
//            .inflate(LayoutInflater.from(parent.context),parent,false))
//    }
//
//    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
//       holder.bind(data[position])
//    }
//
//    override fun getItemCount()=data.size
//
//}