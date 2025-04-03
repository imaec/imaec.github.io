package com.imaec.portfolio.ui.detail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.imaec.portfolio.theme.Gray900
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CoverDetailDialog(
    coverImage: DrawableResource,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .animateContentSize()
            .fillMaxSize()
            .background(Gray900.copy(alpha = 0.9f))
            .clickable(
                enabled = true,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onDismiss() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(coverImage),
            contentDescription = null
        )
    }
}
