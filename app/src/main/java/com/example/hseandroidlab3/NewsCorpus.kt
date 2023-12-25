package com.example.hseandroidlab3

class NewsCorpus {
    var status: String? = null
    private var totalResults: Int? = null
    var results: MutableList<CustomNews>? = null

    public class CustomNews {
        private val article_id: String? = null
        var title: String = ""
        var link: String = ""
        private val keywords: List<String>? = null
        private val creator: List<String>? = null
        private val video_url: String? = null
        private var description: String? = null
        private val image_url: String? = null
        private val source_id: String? = null
        private val source_priority = 0
        private val country: List<String>? = null
        var category: List<String>? = null
        var language: String = ""
    }
}