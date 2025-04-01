package com.imaec.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.Layout
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.ui.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    onClickLink: (String) -> Unit = {},
    onShowDetail: (ProjectDetailVo) -> Unit = {},
    onScreenWidthChanged: (Int) -> Unit = {},
) {
    var screenWidth by remember { mutableStateOf(0) }

    LaunchedEffect(screenWidth) {
        onScreenWidthChanged(screenWidth)
    }

    Layout(
        content = {
            HomeScreen(
                screenType = ScreenType.fromScreenWidth(screenWidth),
                onClickLink = onClickLink,
                onShowDetail = onShowDetail
            )
        },
        measurePolicy = { measurables, constraints ->
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            screenWidth = width

            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            layout(width, height) {
                var yPosition = 0
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    )
}
