package com.imaec.portfolio.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.Gray600

@Composable
fun Tag(isFull: Boolean, text: String, fontFamily: FontFamily?) {
    Text(
        modifier = Modifier
            .background(color = Gray600, shape = RoundedCornerShape(4.dp))
            .padding(
                horizontal = if (isFull) 6.dp else 4.dp,
                vertical = if (isFull) 6.dp else 2.dp
            ),
        text = text,
        style = TextStyle(
            color = Gray100,
            fontSize = if (isFull) 12.sp else 8.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily
        )
    )
}
