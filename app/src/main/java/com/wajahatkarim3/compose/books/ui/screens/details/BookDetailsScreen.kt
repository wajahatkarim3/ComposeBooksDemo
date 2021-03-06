package com.wajahatkarim3.compose.books.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wajahatkarim3.compose.books.ui.model.BookModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun BookDetailsScreen(bookModel: BookModel, navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            BookPicture(bookModel.coverUrl, navController)
            BookHeading(bookModel.name, bookModel.author, bookModel.price)
        }
    }
}

@Composable
fun BookPicture(coverUrl: String, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(
                color = Color.Red
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp)
                .clickable {
                    navController.navigateUp()
                },
            tint = Color.White
        )

        CoilImage(
            data = coverUrl,
            contentDescription = "Book Cover",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 10.dp)
                .width(140.dp)
                .aspectRatio(0.75f)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun BookHeading(name: String, author: String, price: Float) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, top = 30.dp, end = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = name,
            style = TextStyle(
                color = Color.Black,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Text(
            text = author,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
        )

        Text(
            text = "$${price}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Column(modifier = Modifier.weight(1f)) {

        }

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFD7B73)
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Add to Library",
                style = TextStyle(
                    color = Color.White
                ),
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}