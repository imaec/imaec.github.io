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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.theme.Gray400
import com.imaec.portfolio.theme.Gray800
import com.imaec.portfolio.ui.detail.ProjectDetailDialog

@Composable
fun HomeScreen(
    isFull: Boolean,
    onClickLink: (String) -> Unit,
    onShowDetail: (ProjectDetailVo) -> Unit
) {
    val listState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Gray800, Gray400)))
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HomeTopBar(listState = listState, isFull = isFull)
            HomeContent(
                listState = listState,
                isFull = isFull,
                onClickLink = onClickLink,
                onShowDetail = onShowDetail
            )
        }
    }
}

@Composable
private fun HomeContent(
    listState: LazyListState,
    isFull: Boolean,
    onClickLink: (String) -> Unit,
    onShowDetail: (ProjectDetailVo) -> Unit
) {
    LazyColumn(
        state = listState,
        modifier = Modifier.widthIn(max = 1640.dp),
        verticalArrangement = Arrangement.spacedBy(if (isFull) 200.dp else 60.dp),
        contentPadding = PaddingValues(
            start = if (isFull) 100.dp else 20.dp,
            end = if (isFull) 100.dp else 20.dp,
            top = if (isFull) 100.dp else 20.dp,
            bottom = if (isFull) 100.dp else 60.dp,
        )
    ) {
        item {
            HomeProfile(
                isFull = isFull,
                onClickLink = onClickLink,
            )
        }
        item {
            HomeAboutMe(isFull = isFull)
        }
        item {
            HomeSkillTools(isFull = isFull)
        }
        item {
            HomeCareer(isFull = isFull)
        }
        item {
            HomeProjects(
                isFull = isFull,
                onShowDetail = onShowDetail
            )
        }
    }
}
