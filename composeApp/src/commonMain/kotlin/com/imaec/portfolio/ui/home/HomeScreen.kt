package com.imaec.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.model.isWeb
import com.imaec.portfolio.theme.Gray400
import com.imaec.portfolio.theme.Gray800

@Composable
fun HomeScreen(
    screenType: ScreenType,
    onClickLink: (String) -> Unit,
    onShowDetail: (ProjectDetailVo) -> Unit
) {
    val listState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Gray800, Gray400)))
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HomeTopBar(
                listState = listState,
                screenType = screenType
            )
            HomeContent(
                listState = listState,
                screenType = screenType,
                onClickLink = onClickLink,
                onShowDetail = onShowDetail
            )
        }
    }
}

@Composable
private fun HomeContent(
    listState: LazyListState,
    screenType: ScreenType,
    onClickLink: (String) -> Unit,
    onShowDetail: (ProjectDetailVo) -> Unit
) {
    LazyColumn(
        state = listState,
        modifier = Modifier.widthIn(max = 1640.dp),
        verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 200.dp else 60.dp),
        contentPadding = PaddingValues(
            start = if (screenType.isWeb()) 100.dp else 20.dp,
            end = if (screenType.isWeb()) 100.dp else 20.dp,
            top = if (screenType.isWeb()) 100.dp else 20.dp,
            bottom = if (screenType.isWeb()) 100.dp else 60.dp,
        )
    ) {
        item {
            HomeProfile(
                screenType = screenType,
                onClickLink = onClickLink,
            )
        }
        item {
            HomeAboutMe(screenType = screenType)
        }
        item {
            HomeSkillTools(screenType = screenType)
        }
        item {
            HomeCareer(screenType = screenType)
        }
        item {
            HomeProjects(
                screenType = screenType,
                onShowDetail = onShowDetail
            )
        }
    }
}
