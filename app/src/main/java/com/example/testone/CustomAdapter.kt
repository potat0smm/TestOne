package com.example.testone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val img:Array<Int>,val text: Array<String>, val desc: Array<String>
                ):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindValue(image:Int, txt: String, desc: String, ){
            itemView.findViewById<ImageView>(R.id.image).setImageResource(image)
            itemView.findViewById<TextView>(R.id.title).text = txt
            itemView.findViewById<TextView>(R.id.desc).text = desc

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(v)
    }
    override fun getItemCount(): Int {
        return img.size
    }


    override fun onBindViewHolder(holder: CustomAdapter.CustomViewHolder, position: Int) {
        holder.bindValue(img[position],text[position],desc[position])
    }

}