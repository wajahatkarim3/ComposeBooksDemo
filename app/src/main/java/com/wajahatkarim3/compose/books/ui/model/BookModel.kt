package com.wajahatkarim3.compose.books.ui.model

data class BookModel(
    val coverUrl: String,
    val name: String = "You're A Miracle",
    val author: String = "James Clear",
    val price: Float = 20f,
)