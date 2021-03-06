package com.wajahatkarim3.compose.books.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wajahatkarim3.compose.books.ui.model.BookModel
import com.wajahatkarim3.compose.books.ui.screens.details.BookDetailsScreen
import com.wajahatkarim3.compose.books.ui.screens.home.HomeScreen

@Composable
fun BooksMainUI() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        NavHost(navController = navController, startDestination = "home") {
            // Home
            composable("home") {
                HomeScreen(navController)
            }

            // Book Details
            composable("book_details") {
                var bookModel = navController.previousBackStackEntry?.arguments?.getParcelable<BookModel>("book")
                bookModel?.let {
                    BookDetailsScreen(bookModel = it, navController = navController)
                }
            }
        }
    }
}