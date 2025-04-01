package com.imaec.portfolio.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.SkillVo
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.White
import com.imaec.portfolio.theme.firaCode
import com.imaec.portfolio.ui.common.Title

@Composable
fun HomeSkillTools(isFull: Boolean) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(if (isFull) 60.dp else 20.dp)
    ) {
        Title(title = "Skill&Tools", isFull = isFull)
        SkillVo.items().forEach {
            Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 20.dp else 8.dp)) {
                Text(
                    text = it.title,
                    style = TextStyle(
                        color = White,
                        fontSize = if (isFull) 24.sp else 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = firaCode()
                    )
                )
                Text(
                    text = it.content,
                    style = TextStyle(
                        color = Gray100,
                        fontSize = if (isFull) 20.sp else 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = firaCode(),
                        lineHeight = if (isFull) 32.sp else 20.sp
                    )
                )
            }
        }
    }
}
