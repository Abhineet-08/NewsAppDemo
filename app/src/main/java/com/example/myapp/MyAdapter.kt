package com.example.myapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private var newsArrayList:ArrayList<News>, var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        private lateinit var myListener : OnItemClickListener
        interface OnItemClickListener {
            fun onItemClick(position: Int)
        }

    fun setItemClickListener(listener : OnItemClickListener){
        myListener = listener
    }


    // if layout manager fails to find a suitable view , it will create one
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView,myListener)
    }

    // populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.headingTitle.text = currentItem.newsHeading
        holder.headingImage.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size // tells how many items are present in recycler view
    }

    // it holds the view so views are not created everytime , and memory can be saved
    class MyViewHolder(itemView: View,listener : OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val headingTitle = itemView.findViewById<TextView>(R.id.tv_heading)!!
        val headingImage = itemView.findViewById<ShapeableImageView>(R.id.pic_1)!!

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

}
