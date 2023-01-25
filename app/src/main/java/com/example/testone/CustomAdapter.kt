package com.example.testone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val img:Array<Int>,val text: Array<String>, val desc: Array<String>,
                    val img_two:Array<Int>,val text_two:Array<String>, val desc_two: Array<String>
                ):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindValue(image:Int, txt: String, desc: String, image_two: Int, txt_two:String, desc_t: String){
            itemView.findViewById<ImageView>(R.id.image).setImageResource(image)
            itemView.findViewById<TextView>(R.id.title).text = txt
            itemView.findViewById<TextView>(R.id.desc).text = desc
            itemView.findViewById<ImageView>(R.id.image_two).setImageResource(image_two)
            itemView.findViewById<TextView>(R.id.title_two).text = txt_two
            itemView.findViewById<TextView>(R.id.desc_two).text = desc_t
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
        holder.bindValue(img[position],text[position],desc[position],img_two[position],text_two[position],desc_two[position])
    }

}