package com.example.api_nyt_yuritzy.recyclerview

import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api_nyt_yuritzy.R
import com.example.api_nyt_yuritzy.data.Results
import com.example.api_nyt_yuritzy.databinding.ItemArticleBinding
import com.squareup.picasso.Picasso

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemArticleBinding.bind(view)

    //onClickListener: (Results) -> Unit

    fun render(article: Results, onClickListener: (Results) -> Unit){
        binding.tvTitle.text = article.title
        binding.tvDate.text = article.published_date
        Picasso.get().load(article.media[0].metadata[0].url).into(view.findViewById<ImageView>(R.id.iv_item))


         itemView.setOnClickListener{
            onClickListener(article)
           // listener.onItemClick(article)
        }

    }
}