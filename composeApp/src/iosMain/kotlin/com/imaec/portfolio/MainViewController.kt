package com.imaec.portfolio

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.window.ComposeUIViewController
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.ui.detail.ProjectDetailDialog

fun MainViewController() = ComposeUIViewController {
    val uriHandler = LocalUriHandler.current
    var projectDetail: ProjectDetailVo? by remember { mutableStateOf(null) }
    var screenType by remember { mutableStateOf(ScreenType.WEB) }

    App(
        onClickLink = {
            uriHandler.openUri(it)
        },
        onShowDetail = {
            projectDetail = it
        },
        onChangeScreenType = {
            screenType = it
        }
    )
    if (projectDetail != null) {
        ProjectDetailDialog(
            screenType = screenType,
            projectDetail = projectDetail!!,
            onClickLink = {
                uriHandler.openUri(it)
            },
            onDismiss = {
                projectDetail = null
            }
        )
    }
}
