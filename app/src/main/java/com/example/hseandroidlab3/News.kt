package com.example.hseandroidlab3

class News() {
    var title: String = ""
    var category: String = ""
    var language: String = ""
    var link: String = ""

    constructor(title: String, category: String, language: String, link: String) : this() {
        this.title = title
        this.category = category
        this.language = language
        this.link = link
    }
}