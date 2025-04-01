package com.imaec.portfolio.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.ProjectDetailVo
import com.imaec.portfolio.model.ProjectVo
import com.imaec.portfolio.theme.Gray100
import com.imaec.portfolio.theme.Gray200
import com.imaec.portfolio.theme.Gray50
import com.imaec.portfolio.theme.Gray800
import com.imaec.portfolio.theme.Gray900
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
import portfolio.composeapp.generated.resources.ic_arrow_left
import portfolio.composeapp.generated.resources.ic_arrow_right

@Composable
fun HomeProjects(isFull: Boolean, onShowDetail: (ProjectDetailVo) -> Unit) {
    var isFontLoad by remember { mutableStateOf(false) }

    LaunchedEffect(isFontLoad) {
        if (!isFontLoad) {
            delay(10)
            isFontLoad = true
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 60.dp else 20.dp)) {
        Title(title = "Projects", isFull = isFull, isFontLoad = isFontLoad)
        Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 10.dp else 8.dp)) {
            Text(
                text = "Company Projects",
                style = TextStyle(
                    color = Gray200,
                    fontSize = if (isFull) 36.sp else 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = if (isFontLoad) firaCode() else null
                )
            )
            CompanyProjects(
                isFull = isFull,
                isFontLoad = isFontLoad,
                onShowDetail = onShowDetail
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(if (isFull) 10.dp else 8.dp)) {
            Text(
                text = "Team Projects",
                style = TextStyle(
                    color = Gray200,
                    fontSize = if (isFull) 36.sp else 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = if (isFontLoad) firaCode() else null
                )
            )
            TeamProjects(
                isFull = isFull,
                isFontLoad = isFontLoad,
                onShowDetail = onShowDetail
            )
        }
    }
}

@Composable
private fun CompanyProjects(
    isFull: Boolean,
    isFontLoad: Boolean,
    onShowDetail: (ProjectDetailVo) -> Unit
) {
    Column(
        modifier = Modifier
            .width(1440.dp)
            .background(color = Gray800, shape = RoundedCornerShape(if (isFull) 16.dp else 8.dp))
            .padding(
                horizontal = if (isFull) 50.dp else 16.dp,
                vertical = if (isFull) 80.dp else 24.dp
            ),
        verticalArrangement = Arrangement.spacedBy(if (isFull) 60.dp else 24.dp)
    ) {
        ProjectGroup(
            isFull = isFull,
            isFontLoad = isFontLoad,
            title = "브랜드엑스피트니스",
            projects = ProjectVo.brandxfitnessItems(),
            projectDetails = ProjectDetailVo.brandxfitnessItems(),
            onShowDetail = onShowDetail
        )
        ProjectGroup(
            isFull = isFull,
            isFontLoad = isFontLoad,
            title = "라이픽",
            projects = ProjectVo.lificItems(),
            projectDetails = ProjectDetailVo.lificItems(),
            onShowDetail = onShowDetail
        )
        ProjectGroup(
            isFull = isFull,
            isFontLoad = isFontLoad,
            title = "티모넷",
            projects = ProjectVo.tmonetItems(),
            projectDetails = ProjectDetailVo.tmonetItems(),
            onShowDetail = onShowDetail
        )
        ProjectGroup(
            isFull = isFull,
            isFontLoad = isFontLoad,
            title = "예스폼",
            projects = ProjectVo.yesformItems(),
            projectDetails = ProjectDetailVo.yesformItems(),
            onShowDetail = onShowDetail
        )
    }
}

@Composable
private fun TeamProjects(
    isFull: Boolean,
    isFontLoad: Boolean,
    onShowDetail: (ProjectDetailVo) -> Unit
) {
    Column(
        modifier = Modifier
            .width(1440.dp)
            .background(color = Gray800, shape = RoundedCornerShape(if (isFull) 16.dp else 8.dp))
            .padding(
                horizontal = if (isFull) 50.dp else 16.dp,
                vertical = if (isFull) 80.dp else 24.dp
            ),
        verticalArrangement = Arrangement.spacedBy(if (isFull) 60.dp else 24.dp)
    ) {
        ProjectGroup(
            isFull = isFull,
            isFontLoad = isFontLoad,
            title = "아파트임당",
            projects = ProjectVo.imdangItems(),
            projectDetails = ProjectDetailVo.imdangItems(),
            onShowDetail = onShowDetail
        )
    }
}

@Composable
private fun ProjectGroup(
    isFull: Boolean,
    isFontLoad: Boolean,
    title: String,
    projects: List<ProjectVo>,
    projectDetails: List<ProjectDetailVo>,
    onShowDetail: (ProjectDetailVo) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    Column {
        Text(
            modifier = Modifier.padding(horizontal = if (isFull) 72.dp else 32.dp),
            text = title,
            style = TextStyle(
                color = White,
                fontSize = if (isFull) 30.sp else 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = if (isFontLoad) pretendard() else null
            )
        )
        Row(
            modifier = Modifier.padding(vertical = if (isFull) 20.dp else 12.dp),
            horizontalArrangement = Arrangement.spacedBy(if (isFull) 16.dp else 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(if (isFull) 56.dp else 24.dp)
                    .clip(CircleShape)
                    .clickable {
                        coroutineScope.launch {
                            val targetIndex = if (listState.firstVisibleItemIndex > 0) {
                                listState.firstVisibleItemIndex - 1
                            } else {
                                0
                            }
                            listState.animateScrollToItem(targetIndex)
                        }
                    },
                imageVector = vectorResource(Res.drawable.ic_arrow_left),
                tint = White,
                contentDescription = null
            )
            LazyRow(
                state = listState,
                modifier = Modifier
                    .weight(1f)
                    .height(if (isFull) 400.dp else 200.dp),
                horizontalArrangement = Arrangement.spacedBy(if (isFull) 36.dp else 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                itemsIndexed(projects) { index, item ->
                    ProjectItem(
                        project = item,
                        isFull = isFull,
                        isFontLoad = isFontLoad,
                        onShowDetail = {
                            onShowDetail(projectDetails[index])
                        }
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .size(if (isFull) 56.dp else 24.dp)
                    .clip(CircleShape)
                    .clickable {
                        coroutineScope.launch {
                            val targetIndex = if (listState.firstVisibleItemIndex < projects.lastIndex) {
                                listState.firstVisibleItemIndex + 1
                            } else {
                                projects.lastIndex
                            }
                            listState.animateScrollToItem(targetIndex)
                        }
                    },
                imageVector = vectorResource(Res.drawable.ic_arrow_right),
                tint = White,
                contentDescription = null
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ProjectItem(
    project: ProjectVo,
    isFull: Boolean,
    isFontLoad: Boolean,
    onShowDetail: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(if (isFull) 374.67.dp else 220.dp)
            .height(if (isFull) 366.dp else 200.dp)
            .background(color = Gray50, shape = RoundedCornerShape(if (isFull) 12.dp else 8.dp))
            .clip(RoundedCornerShape(if (isFull) 12.dp else 8.dp))
            .clickable { onShowDetail() }
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (isFull) 230.dp else 120.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = if (isFull) 12.dp else 8.dp,
                        topEnd = if (isFull) 12.dp else 8.dp
                    )
                ),
            painter = painterResource(project.cover),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Gray100))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Gray50,
                    shape = RoundedCornerShape(
                        bottomStart = if (isFull) 12.dp else 8.dp,
                        bottomEnd = if (isFull) 12.dp else 8.dp
                    )
                )
                .padding(if (isFull) 16.dp else 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = project.title,
                style = TextStyle(
                    color = Gray900,
                    fontSize = if (isFull) 16.sp else 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = if (isFontLoad) pretendard() else null
                )
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(if (isFull) 6.dp else 2.dp),
                verticalArrangement = Arrangement.spacedBy(if (isFull) 6.dp else 2.dp)
            ) {
                project.tags.forEach { tag ->
                    Tag(
                        isFull = isFull,
                        text = tag,
                        fontFamily = if (isFontLoad) firaCode() else null
                    )
                }
            }
        }
    }
}
