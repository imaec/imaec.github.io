package com.imaec.portfolio

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.ui.detail.ProjectDetailDialog
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.events.KeyboardEvent

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        var projectDetail: ProjectDetailVo? by remember { mutableStateOf(null) }

        LaunchedEffect(Unit) {
            addEscKeyListener {
                projectDetail = null
            }
        }

        Box {
            App(
                onClickLink = {
                    window.open(it)
                },
                onShowDetail = {
                    projectDetail = it
                },
                onScreenWidthChanged = {

                }
            )
            if (projectDetail != null) {
                ProjectDetailDialog(
                    projectDetail = projectDetail!!,
                    onClickLink = {
                        window.open(it)
                    },
                    onDismiss = {
                        projectDetail = null
                    }
                )
            }
        }
    }
}

fun addEscKeyListener(onEscPressed: () -> Unit) {
    window.addEventListener("keydown", { event ->
        val keyboardEvent = event as? KeyboardEvent
        if (keyboardEvent?.key == "Escape") {
            onEscPressed()
        }
    })
}
