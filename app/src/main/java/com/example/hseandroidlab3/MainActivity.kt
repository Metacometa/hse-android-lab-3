package com.example.hseandroidlab3

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: RecyclerView

    private lateinit var editKeywords : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editKeywords = findViewById(R.id.edit_keywords)

        newsAdapter = NewsAdapter(mutableListOf())

        newsList = findViewById(R.id.newsList)
        newsList.adapter = newsAdapter
    }

    fun addNews(view: View) {
        val keyword: String = editKeywords.getText().toString()

        if (!keyword.isEmpty()) {
            newsAdapter.addNews(keyword)
        }
    }
}