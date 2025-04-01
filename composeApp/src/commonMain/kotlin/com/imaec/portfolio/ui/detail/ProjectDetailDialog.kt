package com.imaec.portfolio.ui.detail

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
    projectDetail: ProjectDetailVo,
    onClickLink: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray900.copy(alpha = 0.6f))
            .clickable(
                enabled = true,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onDismiss() }
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 120.dp, vertical = 80.dp)
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
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(bottom = 200.dp)
            ) {
                item {
                    var topHeight by remember { mutableStateOf(0) }
                    val topHeightDp by remember {
                        derivedStateOf {
                            with(density) {
                                if (projectDetail.cover != null) {
                                    (topHeight * 0.8).toInt().toDp()
                                } else {
                                    topHeight.toDp() - 34.dp
                                }
                            }
                        }
                    }

                    Box {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(topHeightDp)
                                .background(
                                    brush = Brush.verticalGradient(colors = listOf(Gray800, Gray700))
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
                                modifier = Modifier.padding(top = 228.dp),
                                text = projectDetail.title,
                                style = TextStyle(
                                    color = White,
                                    fontSize = 48.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = pretendard()
                                ),
                                textAlign = TextAlign.Center
                            )
                            if (projectDetail.links.isNotEmpty()) {
                                Row(
                                    modifier = Modifier.padding(vertical = 36.dp),
                                    horizontalArrangement = Arrangement.spacedBy(36.dp)
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
                                                modifier = Modifier.size(40.dp),
                                                imageVector = vectorResource(it.first),
                                                tint = Gray100,
                                                contentDescription = null
                                            )
                                            Text(
                                                text = it.second,
                                                style = TextStyle(
                                                    color = Gray100,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Medium,
                                                    fontFamily = firaCode()
                                                ),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                }
                            } else {
                                Box(modifier = Modifier.height(100.dp))
                            }
                            if (projectDetail.cover != null) {
                                Image(
                                    modifier = Modifier.width(800.dp),
                                    painter = painterResource(projectDetail.cover),
                                    contentScale = ContentScale.FillWidth,
                                    contentDescription = null
                                )
                            }
                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                text = "2024. 08. 02 ~ 2024. 10. 04",
                                style = TextStyle(
                                    color = Gray900,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = firaCode()
                                )
                            )
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier.padding(horizontal = 300.dp, vertical = 100.dp),
                        verticalArrangement = Arrangement.spacedBy(80.dp)
                    ) {
                        Content(
                            icon = Res.drawable.ic_summary,
                            title = "Project Summary",
                            content = projectDetail.projectSummary
                        )
                        Content(
                            icon = Res.drawable.ic_responsibility,
                            title = "Responsibilities",
                            content = projectDetail.responsibilities
                        )
                        if (projectDetail.troubleShootings.isNotEmpty()) {
                            Content(
                                icon = Res.drawable.ic_trouble_shooting,
                                title = "Trouble Shooting",
                                content = projectDetail.troubleShootings
                            )
                        }
                        Content(
                            icon = Res.drawable.ic_tech_skill,
                            title = "Tech Skills",
                            content = projectDetail.techSkills
                        )
                        if (projectDetail.notes.isNotEmpty()) {
                            Content(
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
                    .padding(40.dp)
                    .size(48.dp)
                    .clip(CircleShape)
                    .clickable { onDismiss() }
                    .align(Alignment.TopEnd),
                imageVector = vectorResource(Res.drawable.ic_close_circle),
                tint = White,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun Content(
    icon: DrawableResource,
    title: String,
    content: List<String>
) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(icon),
                tint = Color.Unspecified,
                contentDescription = null
            )
            Text(
                text = title,
                style = TextStyle(
                    color = Gray900,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = firaCode()
                )
            )
        }
        Text(
            text = content.joinToString("\n"),
            style = TextStyle(
                color = Gray600,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = pretendard(),
                lineHeight = 32.sp
            )
        )
    }
}
