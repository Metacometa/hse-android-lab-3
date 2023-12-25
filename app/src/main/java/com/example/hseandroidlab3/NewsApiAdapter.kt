package com.example.hseandroidlab3

import android.util.Log
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.net.URL
import kotlin.concurrent.thread


class NewsApiAdapter {
    //val api_address: String = "https://newsdata.io/api/1/news?apikey=pub_35197be01c0871d1e525b7ee99f4e382f4deb&q="
    val api_address: String = "https://newsdata.io/api/1/news?apikey=pub_351971d474acd3f896b0b550e3b90680976d7&q="

    fun requestNews(request: String?): ArrayList<News> {
        val gson = Gson()
        val news = ArrayList<News>()

        var requestedNews = ""
        if (request != null) {
            requestedNews = makeRequest(api_address + request)
        }

        val gottenNews = gson.fromJson(requestedNews, NewsCorpus::class.java)

        for (news_i in gottenNews.results!!) {
            val title: String = news_i.title
            var category: String = ""
            val language: String = news_i.language

            for (cat in news_i.category!!) {
                category += cat + ", "
            }
            category = category.substring(0, category.length - 2)

            val link: String = news_i.link

            val formatted_news = News(title, category, language, link)

            news.add(formatted_news)
        }
        return news
    }

    private fun makeRequest(request: String): String = runBlocking(Dispatchers.Default) {
        return@runBlocking URL(request).readText()
    }
}