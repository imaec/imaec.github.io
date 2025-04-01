package com.imaec.portfolio.ui.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.model.isWeb
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.Gray600
import com.imaec.portfolio.theme.Gray700
import com.imaec.portfolio.theme.Gray800
import com.imaec.portfolio.theme.Gray900
import com.imaec.portfolio.theme.White
import com.imaec.portfolio.theme.firaCode
import com.imaec.portfolio.theme.pretendard
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ic_close_circle
import portfolio.composeapp.generated.resources.ic_note
import portfolio.composeapp.generated.resources.ic_responsibility
import portfolio.composeapp.generated.resources.ic_summary
import portfolio.composeapp.generated.resources.ic_tech_skill
import portfolio.composeapp.generated.resources.ic_trouble_shooting

@Composable
fun ProjectDetailDialog(
    screenType: ScreenType,
    projectDetail: ProjectDetailVo,
    onClickLink: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Box(
        modifier = Modifier
            .animateContentSize()
            .fillMaxSize()
            .background(Gray900.copy(alpha = 0.8f))
            .clickable(
                enabled = true,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onDismiss() }
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            Dialog(
                screenType = screenType,
                projectDetail = projectDetail,
                onClickLink = onClickLink,
                onDismiss = onDismiss
            )
        }
    }
}

@Composable
private fun Dialog(
    screenType: ScreenType,
    projectDetail: ProjectDetailVo,
    onClickLink: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .padding(
                horizontal = if (screenType.isWeb()) 120.dp else 24.dp,
                vertical = if (screenType.isWeb()) 80.dp else 30.dp
            )
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .clickable(
                enabled = true,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {}
            )
    ) {
        var topHeight by remember { mutableStateOf(0) }
        val topHeightDp by remember {
            derivedStateOf {
                with(density) {
                    if (projectDetail.cover != null) {
                        (topHeight * 0.8).toInt().toDp()
                    } else {
                        topHeight.toDp() - (if (screenType.isWeb()) 34.dp else 20.dp)
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(topHeightDp)
                .background(Gray800)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(
                bottom = if (screenType.isWeb()) 200.dp else 48.dp
            )
        ) {
            item {
                Box(Modifier.background(White)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(topHeightDp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Gray800, Gray700)
                                )
                            )
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned {
                                topHeight = it.size.height
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                top = if (screenType.isWeb()) 228.dp else 104.dp
                            ),
                            text = projectDetail.title,
                            style = TextStyle(
                                color = White,
                                fontSize = if (screenType.isWeb()) 48.sp else 24.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = pretendard()
                            ),
                            textAlign = TextAlign.Center
                        )
                        if (projectDetail.links.isNotEmpty()) {
                            Row(
                                modifier = Modifier.padding(
                                    vertical = if (screenType.isWeb()) 36.dp else 20.dp
                                ),
                                horizontalArrangement = Arrangement.spacedBy(
                                    if (screenType.isWeb()) 36.dp else 20.dp
                                )
                            ) {
                                projectDetail.links.forEach {
                                    Column(
                                        modifier = Modifier.clickable {
                                            onClickLink(it.third)
                                        },
                                        verticalArrangement = Arrangement.spacedBy(4.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(
                                                if (screenType.isWeb()) 40.dp else 20.dp
                                            ),
                                            imageVector = vectorResource(it.first),
                                            tint = Gray100,
                                            contentDescription = null
                                        )
                                        Text(
                                            text = it.second,
                                            style = TextStyle(
                                                color = Gray100,
                                                fontSize = if (screenType.isWeb()) {
                                                    14.sp
                                                } else {
                                                    8.sp
                                                },
                                                fontWeight = FontWeight.Medium,
                                                fontFamily = firaCode()
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        } else {
                            Box(
                                modifier = Modifier.height(
                                    if (screenType.isWeb()) 100.dp else 40.dp
                                )
                            )
                        }
                        if (projectDetail.cover != null) {
                            Image(
                                modifier = Modifier.width(
                                    if (screenType.isWeb()) 800.dp else 240.dp
                                ),
                                painter = painterResource(projectDetail.cover),
                                contentScale = ContentScale.FillWidth,
                                contentDescription = null
                            )
                        }
                        Text(
                            modifier = Modifier.padding(
                                top = if (screenType.isWeb()) 10.dp else 4.dp
                            ),
                            text = "2024. 08. 02 ~ 2024. 10. 04",
                            style = TextStyle(
                                color = Gray900,
                                fontSize = if (screenType.isWeb()) 16.sp else 10.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = firaCode()
                            )
                        )
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(
                            horizontal = if (screenType.isWeb()) 300.dp else 40.dp,
                            vertical = if (screenType.isWeb()) 100.dp else 40.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(
                        if (screenType.isWeb()) 80.dp else 40.dp
                    )
                ) {
                    Content(
                        screenType = screenType,
                        icon = Res.drawable.ic_summary,
                        title = "Project Summary",
                        content = projectDetail.projectSummary
                    )
                    Content(
                        screenType = screenType,
                        icon = Res.drawable.ic_responsibility,
                        title = "Responsibilities",
                        content = projectDetail.responsibilities
                    )
                    if (projectDetail.troubleShootings.isNotEmpty()) {
                        Content(
                            screenType = screenType,
                            icon = Res.drawable.ic_trouble_shooting,
                            title = "Trouble Shooting",
                            content = projectDetail.troubleShootings
                        )
                    }
                    Content(
                        screenType = screenType,
                        icon = Res.drawable.ic_tech_skill,
                        title = "Tech Skills",
                        content = projectDetail.techSkills
                    )
                    if (projectDetail.notes.isNotEmpty()) {
                        Content(
                            screenType = screenType,
                            icon = Res.drawable.ic_note,
                            title = "Notes",
                            content = projectDetail.notes
                        )
                    }
                }
            }
        }
        Icon(
            modifier = Modifier
                .padding(if (screenType.isWeb()) 40.dp else 20.dp)
                .size(if (screenType.isWeb()) 48.dp else 24.dp)
                .clip(CircleShape)
                .clickable { onDismiss() }
                .align(Alignment.TopEnd),
            imageVector = vectorResource(Res.drawable.ic_close_circle),
            tint = White,
            contentDescription = null
        )
    }
}

@Composable
private fun Content(
    screenType: ScreenType,
    icon: DrawableResource,
    title: String,
    content: List<String>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            if (screenType.isWeb()) 20.dp else 12.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                if (screenType.isWeb()) 12.dp else 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(
                    if (screenType.isWeb()) 24.dp else 14.dp
                ),
                painter = painterResource(icon),
                tint = Color.Unspecified,
                contentDescription = null
            )
            Text(
                text = title,
                style = TextStyle(
                    color = Gray900,
                    fontSize = if (screenType.isWeb()) 24.sp else 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = firaCode()
                )
            )
        }
        Text(
            text = content.joinToString("\n"),
            style = TextStyle(
                color = Gray600,
                fontSize = if (screenType.isWeb()) 20.sp else 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = pretendard(),
                lineHeight = if (screenType.isWeb()) 32.sp else 20.sp
            )
        )
    }
}
