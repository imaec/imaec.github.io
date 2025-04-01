package com.imaec.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.CareerVo
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.Gray600
import com.imaec.portfolio.theme.Gray800
import com.imaec.portfolio.theme.firaCode
import com.imaec.portfolio.theme.pretendard
import com.imaec.portfolio.ui.common.Tag
import com.imaec.portfolio.ui.common.Title

@Composable
fun HomeCareer(isFull: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 60.dp else 16.dp)) {
        Title(title = "Career", isFull = isFull)
        LazyVerticalGrid(
            modifier = Modifier
                .widthIn(
                    min = if (isFull) 700.dp else 300.dp,
                    max = if (isFull) 1440.dp else 616.dp
                )
                .heightIn(
                    min = if (isFull) 500.dp else 280.dp,
                    max = if (isFull) 5600.dp else 3360.dp
                ),
            columns = GridCells.Adaptive(minSize = if (isFull) 700.dp else 300.dp),
            horizontalArrangement = Arrangement.spacedBy(if (isFull) 40.dp else 16.dp),
            verticalArrangement = Arrangement.spacedBy(if (isFull) 40.dp else 16.dp)
        ) {
            items(CareerVo.items()) {
                CareerItem(career = it, isFull = isFull)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CareerItem(career: CareerVo, isFull: Boolean) {
    Column(
        modifier = Modifier
            .width(if (isFull) 700.dp else 300.dp)
            .height(if (isFull) 500.dp else 280.dp)
            .background(color = Gray800, shape = RoundedCornerShape(8.dp))
            .padding(if (isFull) 32.dp else 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 16.dp else 12.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 8.dp else 4.dp)) {
                Text(
                    text = career.period,
                    style = TextStyle(
                        color = Gray600,
                        fontSize = if (isFull) 12.sp else 6.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = firaCode()
                    )
                )
                Text(
                    text = career.company,
                    style = TextStyle(
                        color = Gray100,
                        fontSize = if (isFull) 24.sp else 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pretendard()
                    )
                )
                Row(horizontalArrangement = Arrangement.spacedBy(if (isFull) 6.dp else 4.dp)) {
                    Tag(isFull = isFull, text = career.team, fontFamily = pretendard())
                    Tag(isFull = isFull, text = career.position, fontFamily = pretendard())
                    if (career.job.isNotEmpty()) {
                        Tag(isFull = isFull, text = career.job, fontFamily = pretendard())
                    }
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                career.responsibilities.forEach {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = Gray100,
                            fontSize = if (isFull) 18.sp else 10.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = pretendard(),
                            lineHeight = if (isFull) 28.sp else 16.sp
                        )
                    )
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 8.dp else 6.dp)) {
            career.skills.forEach { skill ->
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(if (isFull) 6.dp else 4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    skill.forEach {
                        Tag(isFull = isFull, text = it, fontFamily = firaCode())
                    }
                }
            }
        }
    }
}
