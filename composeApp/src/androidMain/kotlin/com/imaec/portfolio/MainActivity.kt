package com.imaec.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.ui.detail.ProjectDetailDialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uriHandler = LocalUriHandler.current
            var projectDetail: ProjectDetailVo? by remember { mutableStateOf(null) }
            var screenType by remember { mutableStateOf(ScreenType.WEB) }

            BackHandler {
                if (projectDetail != null) {
                    projectDetail = null
                } else {
                    finish()
                }
            }

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
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
