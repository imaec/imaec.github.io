package com.imaec.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.ui.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    onClickLink: (String) -> Unit = {},
    onShowDetail: (ProjectDetailVo) -> Unit = {},
    onChangeScreenType: (ScreenType) -> Unit = {},
) {
    val density = LocalDensity.current
    var screenType by remember { mutableStateOf(ScreenType.WEB) }

    LaunchedEffect(screenType) {
        onChangeScreenType(screenType)
    }

    Layout(
        content = {
            HomeScreen(
                screenType = screenType,
                onClickLink = onClickLink,
                onShowDetail = onShowDetail
            )
        },
        measurePolicy = { measurables, constraints ->
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            screenType = ScreenType.fromScreenWidth(with(density) { width.toDp() }.value.toInt())

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
