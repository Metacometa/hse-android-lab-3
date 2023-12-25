package com.example.hseandroidlab3

import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val news: MutableList<News>
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val cur_news = news[position]

        holder.itemView.apply {
             val title : TextView = findViewById(R.id.title)
             val category: TextView = findViewById(R.id.category)
             val language: TextView = findViewById(R.id.language)
             val link : TextView = findViewById(R.id.link)

             title.text = cur_news.title
             category.text = "Category: " + cur_news.category
             language.text = "Language: " + cur_news.language

             val http_link: String = "<a href=" + cur_news.link.toString() + " >Link</a>";
             link.text = Html.fromHtml(http_link)
             link.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    fun addNews(keyword: String) {
        news.clear()

        val newsApi = NewsApiAdapter()
        val requested_news = newsApi.requestNews(keyword)

        for (news_i in requested_news) {
            news.add(news_i)
        }

        notifyDataSetChanged()
    }
}