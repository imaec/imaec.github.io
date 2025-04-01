package com.imaec.portfolio.ui.home

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.CareerVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.model.isWeb
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.Gray200
import com.imaec.portfolio.theme.Gray600
import com.imaec.portfolio.theme.Gray800
import com.imaec.portfolio.theme.White
import com.imaec.portfolio.theme.firaCode
import com.imaec.portfolio.theme.pretendard
import com.imaec.portfolio.ui.common.Tag
import com.imaec.portfolio.ui.common.Title
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ic_arrow_down_circle
import portfolio.composeapp.generated.resources.ic_arrow_up_circle
import portfolio.composeapp.generated.resources.ic_refresh
import portfolio.composeapp.generated.resources.ic_responsibility

@Composable
fun HomeCareer(screenType: ScreenType) {
    var isFontLoad by remember { mutableStateOf(false) }

    LaunchedEffect(isFontLoad) {
        if (!isFontLoad) {
            delay(10)
            isFontLoad = true
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 60.dp else 16.dp)) {
        Title(
            title = "Career",
            screenType = screenType,
            isFontLoad = isFontLoad
        )
        LazyVerticalGrid(
            modifier = Modifier
                .then(
                    if (screenType.isWeb()) {
                        Modifier.widthIn(
                            min = if (screenType.isWeb()) 700.dp else 300.dp,
                            max = if (screenType.isWeb()) 1440.dp else 616.dp
                        )
                    } else {
                        Modifier.fillMaxWidth()
                    }
                )
                .heightIn(
                    min = if (screenType.isWeb()) 500.dp else 280.dp,
                    max = if (screenType.isWeb()) 5600.dp else 3360.dp
                ),
            columns = GridCells.Adaptive(minSize = if (screenType.isWeb()) 700.dp else 300.dp),
            horizontalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 40.dp else 16.dp),
            verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 40.dp else 16.dp)
        ) {
            items(CareerVo.items()) {
                CareerItem(
                    career = it,
                    screenType = screenType,
                    isFontLoad = isFontLoad
                )
            }
        }
    }
}

@Composable
private fun CareerItem(
    career: CareerVo,
    screenType: ScreenType,
    isFontLoad: Boolean
) {
    var flipped by remember { mutableStateOf(false) }
    val rotationX by animateFloatAsState(
        targetValue = if (flipped) 180f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "Flip Animation"
    )

    Box(
        modifier = Modifier
            .graphicsLayer {
                this.rotationX = rotationX
                cameraDistance = 16 * density
            }
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(
                enabled = true,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { flipped = !flipped }
    ) {
        if (rotationX <= 90f) {
            CareerItemFront(
                screenType = screenType,
                career = career,
                isFontLoad = isFontLoad
            )
        } else {
            CareerItemBack(
                screenType = screenType,
                career = career,
                isFontLoad = isFontLoad
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CareerItemFront(
    screenType: ScreenType,
    career: CareerVo,
    isFontLoad: Boolean
) {
    var isVisibleRotate by remember { mutableStateOf(false) }

    Box {
        Column(
            modifier = Modifier
                .then(if (screenType.isWeb()) Modifier.width(700.dp) else Modifier.fillMaxWidth())
                .height(if (screenType.isWeb()) 500.dp else 280.dp)
                .background(color = Gray800, shape = RoundedCornerShape(8.dp))
                .padding(if (screenType.isWeb()) 32.dp else 16.dp)
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            when (event.type) {
                                PointerEventType.Enter -> isVisibleRotate = true
                                PointerEventType.Exit -> isVisibleRotate = false
                                PointerEventType.Press -> {}
                            }
                        }
                    }
                },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 16.dp else 12.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 8.dp else 4.dp)
                ) {
                    Text(
                        text = career.period,
                        style = TextStyle(
                            color = Gray600,
                            fontSize = if (screenType.isWeb()) 12.sp else 6.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = if (isFontLoad) firaCode() else null
                        )
                    )
                    Text(
                        text = career.company,
                        style = TextStyle(
                            color = Gray100,
                            fontSize = if (screenType.isWeb()) 24.sp else 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = if (isFontLoad) pretendard() else null
                        )
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            if (screenType.isWeb()) 6.dp else 4.dp
                        )
                    ) {
                        Tag(
                            screenType = screenType,
                            text = career.team,
                            fontFamily = if (isFontLoad) pretendard() else null
                        )
                        Tag(
                            screenType = screenType,
                            text = career.position,
                            fontFamily = if (isFontLoad) pretendard() else null
                        )
                        if (career.job.isNotEmpty()) {
                            Tag(
                                screenType = screenType,
                                text = career.job,
                                fontFamily = if (isFontLoad) pretendard() else null
                            )
                        }
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    career.responsibilities.forEach {
                        Text(
                            text = it,
                            style = TextStyle(
                                color = Gray100,
                                fontSize = if (screenType.isWeb()) 18.sp else 10.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = if (isFontLoad) pretendard() else null,
                                lineHeight = if (screenType.isWeb()) 28.sp else 16.sp
                            )
                        )
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 8.dp else 6.dp)
            ) {
                career.skills.forEach { skill ->
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(
                            if (screenType.isWeb()) 6.dp else 4.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        skill.forEach {
                            Tag(
                                screenType = screenType,
                                text = it,
                                fontFamily = if (isFontLoad) firaCode() else null
                            )
                        }
                    }
                }
            }
        }
        if (isVisibleRotate) {
            Icon(
                modifier = Modifier
                    .padding(if (screenType.isWeb()) 32.dp else 16.dp)
                    .size(if (screenType.isWeb()) 36.dp else 18.dp)
                    .align(Alignment.TopEnd),
                imageVector = vectorResource(Res.drawable.ic_refresh),
                tint = White,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun CareerItemBack(
    screenType: ScreenType,
    career: CareerVo,
    isFontLoad: Boolean
) {
    val density = LocalDensity.current
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val scrollingHeight by remember { mutableStateOf(with(density) { 80.dp.toPx() }) }
    var isVisibleRotate by remember { mutableStateOf(false) }

    Box {
        Column(
            modifier = Modifier
                .then(if (screenType.isWeb()) Modifier.width(700.dp) else Modifier.fillMaxWidth())
                .height(if (screenType.isWeb()) 500.dp else 280.dp)
                .background(color = Gray800, shape = RoundedCornerShape(8.dp))
                .padding(if (screenType.isWeb()) 32.dp else 16.dp)
                .graphicsLayer { this.rotationX = 180f } // 반대쪽 UI는 180도 회전
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            when (event.type) {
                                PointerEventType.Enter -> isVisibleRotate = true
                                PointerEventType.Exit -> isVisibleRotate = false
                                PointerEventType.Press -> {}
                            }
                        }
                    }
                },
            verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 20.dp else 16.dp)
        ) {
            Text(
                text = career.company,
                style = TextStyle(
                    color = Gray100,
                    fontSize = if (screenType.isWeb()) 24.sp else 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (isFontLoad) pretendard() else null
                )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    if (screenType.isWeb()) 6.dp else 4.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(
                        if (screenType.isWeb()) 20.dp else 10.dp
                    ),
                    painter = painterResource(Res.drawable.ic_responsibility),
                    tint = Color.Unspecified,
                    contentDescription = null
                )
                Text(
                    text = "경력 소개",
                    style = TextStyle(
                        color = Gray200,
                        fontSize = if (screenType.isWeb()) 20.sp else 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = if (isFontLoad) pretendard() else null
                    )
                )
            }
            Box {
                LazyColumn(state = listState) {
                    item {
                        Text(
                            text = career.work,
                            style = TextStyle(
                                color = Gray100,
                                fontSize = if (screenType.isWeb()) 18.sp else 10.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = if (isFontLoad) pretendard() else null,
                                lineHeight = if (screenType.isWeb()) 28.sp else 16.sp
                            )
                        )
                    }
                }
                if (listState.canScrollBackward) {
                    Icon(
                        modifier = Modifier
                            .size(if (screenType.isWeb()) 48.dp else 32.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable {
                                coroutineScope.launch {
                                    listState.animateScrollBy(
                                        scrollingHeight * -1,
                                        tween(500)
                                    )
                                }
                            }
                            .padding(if (screenType.isWeb()) 0.dp else 4.dp),
                        imageVector = vectorResource(Res.drawable.ic_arrow_up_circle),
                        tint = Color.Unspecified,
                        contentDescription = null
                    )
                }
                if (listState.canScrollForward) {
                    Icon(
                        modifier = Modifier
                            .size(if (screenType.isWeb()) 48.dp else 32.dp)
                            .align(Alignment.BottomCenter)
                            .clip(CircleShape)
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable {
                                coroutineScope.launch {
                                    listState.animateScrollBy(scrollingHeight, tween(500))
                                }
                            }
                            .padding(if (screenType.isWeb()) 0.dp else 4.dp),
                        imageVector = vectorResource(Res.drawable.ic_arrow_down_circle),
                        tint = Color.Unspecified,
                        contentDescription = null
                    )
                }
            }
        }
        if (isVisibleRotate) {
            Icon(
                modifier = Modifier
                    .padding(if (screenType.isWeb()) 32.dp else 16.dp)
                    .size(if (screenType.isWeb()) 36.dp else 18.dp)
                    .align(Alignment.BottomEnd)
                    .graphicsLayer { this.rotationX = 180f }, // 반대쪽 UI는 180도 회전,,
                imageVector = vectorResource(Res.drawable.ic_refresh),
                tint = White,
                contentDescription = null
            )
        }
    }
}
