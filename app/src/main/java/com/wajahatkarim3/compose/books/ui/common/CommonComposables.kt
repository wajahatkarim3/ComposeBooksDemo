package com.wajahatkarim3.compose.books.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalSpace(value: Dp) {
    Spacer(modifier = Modifier.height(value))
}

@Composable
fun HorizontalSpace(value: Dp) {
    Spacer(modifier = Modifier.width(value))
}