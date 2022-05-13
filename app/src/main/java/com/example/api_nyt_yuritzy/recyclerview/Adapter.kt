package com.example.api_nyt_yuritzy.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_nyt_yuritzy.R
import com.example.api_nyt_yuritzy.data.Results


class Adapter( val list_articles: List<Results>, private val onClickListener: (Results) -> Unit): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_article,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(list_articles[position], onClickListener)
    }

    override fun getItemCount(): Int {
        return list_articles.size
    }
}