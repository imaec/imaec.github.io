package com.imaec.portfolio.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.Gray200
import com.imaec.portfolio.theme.firaCode

@Composable
fun Title(title: String, isFull: Boolean) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(if (isFull) 30.dp else 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = Gray200,
                fontSize = if (isFull) 48.sp else 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = firaCode()
            )
        )
        Box(
            modifier = Modifier
                .width(if (isFull) 360.dp else 100.dp)
                .height(if (isFull) 4.dp else 2.dp)
                .background(Gray100)
        )
    }
}
