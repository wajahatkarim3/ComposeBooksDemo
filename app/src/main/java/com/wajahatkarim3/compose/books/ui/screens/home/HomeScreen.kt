package com.wajahatkarim3.compose.books.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.transform.CircleCropTransformation
import com.wajahatkarim3.compose.books.ui.common.VerticalSpace
import com.wajahatkarim3.compose.books.ui.model.BookModel
import com.wajahatkarim3.compose.books.ui.utils.getBooksList
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {

        }
    ) {
        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent() {
    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(10.dp)
    ) {
        HomeSearchBar()
        NewBooksHorizontalList()
        PopularBooksList()
    }
}

@Composable
fun PopularBooksList() {
    VerticalSpace(value = 20.dp)
    Text(
        text = "Popular Books",
        style = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    )
    VerticalSpace(value = 10.dp)
    var books = getBooksList().shuffled()
    books.forEach { book ->
        PopularBookItem(book)
    }
//    LazyColumn(
//        modifier = Modifier.wrapContentHeight()
//    ) {
//        items(
//            items = getBooksList().shuffled(),
//            itemContent = { item ->
//                PopularBookItem(item)
//            }
//        )
//    }
}

@Composable
fun PopularBookItem(bookModel: BookModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .clickable {

            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        NewBookItem(bookModel = bookModel, maxWidth = 60.dp)
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = bookModel.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = bookModel.author,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Text(
                text = "$${bookModel.price}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun NewBooksHorizontalList() {
    VerticalSpace(value = 20.dp)
    Text(
        text = "New Books",
        style = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    )
    VerticalSpace(value = 10.dp)
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = getBooksList(),
            itemContent = { item ->
                NewBookItem(item)
            }
        )
    }
}

@Composable
fun NewBookItem(bookModel: BookModel, maxWidth: Dp = 140.dp) {
    CoilImage(
        data = bookModel.coverUrl,
        contentDescription = "My content description",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(end = 10.dp)
            .width(maxWidth)
            .aspectRatio(0.75f)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable {

            },
    )
}

@Composable
fun HomeSearchBar() {
    VerticalSpace(value = 10.dp)
    Text(
        text = "Hi, Wajahat",
        style = TextStyle(
            color = Color.Gray,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
    VerticalSpace(value = 5.dp)
    Text(
        text = "Discover Latest Books",
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    )

    VerticalSpace(value = 20.dp)

    var searchTextFieldState by remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchTextFieldState,
        onValueChange = { searchTextFieldState = it },
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = "Search books...",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color(0xFFF4F4F4)
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.White,
                modifier = Modifier
                    .offset(x = 10.dp)
                    .background(
                        color = Color(0xFFFFAAA5),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .requiredSize(55.dp)
                    .padding(10.dp)
            )
        }
    )
}