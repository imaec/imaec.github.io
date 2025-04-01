package com.imaec.portfolio.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.ProfileVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.model.isWeb
import com.imaec.portfolio.theme.Gray500
import com.imaec.portfolio.theme.White
import com.imaec.portfolio.theme.firaCode
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeTopBar(
    listState: LazyListState,
    screenType: ScreenType
) {
    val coroutineScope = rememberCoroutineScope()
    val menu by remember {
        mutableStateOf(
            listOf(
                "Profile",
                "About Me",
                "Skill&Tools",
                "Career",
                "Projects"
            )
        )
    }
    var selectedMenu by remember { mutableStateOf(menu.first()) }
    var isUserScrolling by remember { mutableStateOf(false) }
    var isFontLoad by remember { mutableStateOf(false) }

    LaunchedEffect(isFontLoad) {
        if (!isFontLoad) {
            delay(10)
            isFontLoad = true
        }
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .collect {
                if (!isUserScrolling) {
                    selectedMenu = menu[listState.firstVisibleItemIndex]
                }
            }
    }


    if (screenType.isWeb()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 100.dp,
                    end = 84.dp,
                    top = 24.dp,
                    bottom = 24.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = ProfileVo().name,
                style = TextStyle(
                    color = White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (isFontLoad) firaCode() else null
                )
            )
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                menu.forEach {
                    TopBarMenu(
                        screenType = screenType,
                        isFontLoad = isFontLoad,
                        menu = it,
                        isSelected = it == selectedMenu,
                        onClickMenu = { clickedMenu ->
                            isUserScrolling = true
                            selectedMenu = clickedMenu
                            coroutineScope.launch {
                                listState.animateScrollToItem(menu.indexOf(clickedMenu))
                                isUserScrolling = false
                            }
                        }
                    )
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    bottom = 20.dp,
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = ProfileVo().name,
                style = TextStyle(
                    color = White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = firaCode()
                )
            )
            FlowRow(
                modifier = Modifier.padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                menu.forEach {
                    TopBarMenu(
                        screenType = screenType,
                        isFontLoad = isFontLoad,
                        menu = it,
                        isSelected = it == selectedMenu,
                        onClickMenu = { clickedMenu ->
                            isUserScrolling = true
                            selectedMenu = clickedMenu
                            coroutineScope.launch {
                                listState.animateScrollToItem(menu.indexOf(clickedMenu))
                                isUserScrolling = false
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun TopBarMenu(
    screenType: ScreenType,
    isFontLoad: Boolean,
    menu: String,
    isSelected: Boolean,
    onClickMenu: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onClickMenu(menu) }
            .padding(
                horizontal = if (screenType.isWeb()) 16.dp else 8.dp,
                vertical = if (screenType.isWeb()) 8.dp else 4.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = menu,
            style = TextStyle(
                color = if (isSelected) White else Gray500,
                fontSize = if (screenType.isWeb()) 24.sp else 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = if (isFontLoad) firaCode() else null
            )
        )
    }
}
