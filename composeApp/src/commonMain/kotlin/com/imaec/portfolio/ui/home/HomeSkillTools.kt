package com.imaec.portfolio.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.model.SkillVo
import com.imaec.portfolio.model.isWeb
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.White
import com.imaec.portfolio.theme.firaCode
import com.imaec.portfolio.theme.pretendard
import com.imaec.portfolio.ui.common.Title
import kotlinx.coroutines.delay

@Composable
fun HomeSkillTools(screenType: ScreenType) {
    var isFontLoad by remember { mutableStateOf(false) }

    LaunchedEffect(isFontLoad) {
        if (!isFontLoad) {
            delay(10)
            isFontLoad = true
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 60.dp else 20.dp)
    ) {
        Title(
            title = "Skill&Tools",
            screenType = screenType,
            isFontLoad = isFontLoad
        )
        SkillVo.items().forEach {
            Column(
                verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 20.dp else 8.dp)
            ) {
                Text(
                    text = it.title,
                    style = TextStyle(
                        color = White,
                        fontSize = if (screenType.isWeb()) 24.sp else 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = if (isFontLoad) firaCode() else null
                    )
                )
                Text(
                    text = it.content,
                    style = TextStyle(
                        color = Gray100,
                        fontSize = if (screenType.isWeb()) 20.sp else 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = if (isFontLoad) firaCode() else null,
                        lineHeight = if (screenType.isWeb()) 32.sp else 20.sp
                    )
                )
            }
        }
    }
}
