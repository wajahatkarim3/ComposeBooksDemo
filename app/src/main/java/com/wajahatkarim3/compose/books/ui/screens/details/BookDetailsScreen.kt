package com.wajahatkarim3.compose.books.ui.screens.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wajahatkarim3.compose.books.ui.model.BookModel

@Composable
fun BookDetailsScreen(bookModel: BookModel, navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Text(text = bookModel.name)
    }
}