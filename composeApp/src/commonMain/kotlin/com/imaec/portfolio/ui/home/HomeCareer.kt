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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.CareerVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.model.isWeb
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.Gray600
import com.imaec.portfolio.theme.Gray800
import com.imaec.portfolio.theme.firaCode
import com.imaec.portfolio.theme.pretendard
import com.imaec.portfolio.ui.common.Tag
import com.imaec.portfolio.ui.common.Title
import kotlinx.coroutines.delay

@Composable
fun HomeCareer(screenType: ScreenType) {
    var isFontLoad by remember { mutableStateOf(false) }

    LaunchedEffect(isFontLoad) {
        if (!isFontLoad) {
            delay(10)
            isFontLoad = true
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 60.dp else 16.dp)) {
        Title(
            title = "Career",
            screenType = screenType,
            isFontLoad = isFontLoad
        )
        LazyVerticalGrid(
            modifier = Modifier
                .widthIn(
                    min = if (screenType.isWeb()) 700.dp else 300.dp,
                    max = if (screenType.isWeb()) 1440.dp else 616.dp
                )
                .heightIn(
                    min = if (screenType.isWeb()) 500.dp else 280.dp,
                    max = if (screenType.isWeb()) 5600.dp else 3360.dp
                ),
            columns = GridCells.Adaptive(minSize = if (screenType.isWeb()) 700.dp else 300.dp),
            horizontalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 40.dp else 16.dp),
            verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 40.dp else 16.dp)
        ) {
            items(CareerVo.items()) {
                CareerItem(
                    career = it,
                    screenType = screenType,
                    isFontLoad = isFontLoad
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CareerItem(
    career: CareerVo,
    screenType: ScreenType,
    isFontLoad: Boolean
) {
    Column(
        modifier = Modifier
            .width(if (screenType.isWeb()) 700.dp else 300.dp)
            .height(if (screenType.isWeb()) 500.dp else 280.dp)
            .background(color = Gray800, shape = RoundedCornerShape(8.dp))
            .padding(if (screenType.isWeb()) 32.dp else 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 16.dp else 12.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 8.dp else 4.dp)
            ) {
                Text(
                    text = career.period,
                    style = TextStyle(
                        color = Gray600,
                        fontSize = if (screenType.isWeb()) 12.sp else 6.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = if (isFontLoad) firaCode() else null
                    )
                )
                Text(
                    text = career.company,
                    style = TextStyle(
                        color = Gray100,
                        fontSize = if (screenType.isWeb()) 24.sp else 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = if (isFontLoad) pretendard() else null
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        if (screenType.isWeb()) 6.dp else 4.dp
                    )
                ) {
                    Tag(
                        screenType = screenType,
                        text = career.team,
                        fontFamily = if (isFontLoad) pretendard() else null
                    )
                    Tag(
                        screenType = screenType,
                        text = career.position,
                        fontFamily = if (isFontLoad) pretendard() else null
                    )
                    if (career.job.isNotEmpty()) {
                        Tag(
                            screenType = screenType,
                            text = career.job,
                            fontFamily = if (isFontLoad) pretendard() else null
                        )
                    }
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                career.responsibilities.forEach {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = Gray100,
                            fontSize = if (screenType.isWeb()) 18.sp else 10.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = if (isFontLoad) pretendard() else null,
                            lineHeight = if (screenType.isWeb()) 28.sp else 16.sp
                        )
                    )
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 8.dp else 6.dp)
        ) {
            career.skills.forEach { skill ->
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(
                        if (screenType.isWeb()) 6.dp else 4.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    skill.forEach {
                        Tag(
                            screenType = screenType,
                            text = it,
                            fontFamily = if (isFontLoad) firaCode() else null
                        )
                    }
                }
            }
        }
    }
}
