package com.example.kointest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kointest.Network.Photox

class PagingAdaptor():ListAdapter<Photox, PagingAdaptor.PagingViewHolder>(ToDoCallBack()){
    class PagingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo,parent,false)
        return PagingViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        val item:Photox = getItem(position)
        Glide.with(holder.itemView.context).load(item.url_s).into(holder.imageView)
    }

}
class ToDoCallBack: DiffUtil.ItemCallback<Photox>(){
    override fun areItemsTheSame(oldItem: Photox, newItem: Photox): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Photox, newItem: Photox): Boolean {
        return oldItem.id == newItem.id
    }

}
