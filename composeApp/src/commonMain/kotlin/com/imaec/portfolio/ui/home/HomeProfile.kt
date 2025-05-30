package com.imaec.portfolio.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imaec.portfolio.model.ProfileVo
import com.imaec.portfolio.model.ScreenType
import com.imaec.portfolio.model.isWeb
import com.imaec.portfolio.theme.Gray200
import com.imaec.portfolio.theme.Gray300
import com.imaec.portfolio.theme.White
import com.imaec.portfolio.theme.firaCode
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ic_github
import portfolio.composeapp.generated.resources.ic_mail
import portfolio.composeapp.generated.resources.ic_notion

@Composable
fun HomeProfile(
    screenType: ScreenType,
    onClickLink: (String) -> Unit
) {
    val profile by remember { mutableStateOf(ProfileVo()) }
    var isFontLoad by remember { mutableStateOf(false) }

    LaunchedEffect(isFontLoad) {
        if (!isFontLoad) {
            delay(10)
            isFontLoad = true
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 160.dp else 40.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 56.dp else 12.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(if (screenType.isWeb()) 250.dp else 80.dp)
                    .clip(CircleShape)
                    .background(White),
                painter = painterResource(profile.profile),
                contentDescription = null
            )
            Row(
                modifier = Modifier
                    .width(if (screenType.isWeb()) 250.dp else 80.dp)
                    .padding(horizontal = if (screenType.isWeb()) 10.dp else 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier
                        .size(if (screenType.isWeb()) 64.dp else 24.dp)
                        .clip(CircleShape)
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable {
                            onClickLink(profile.githubUrl)
                        }
                        .padding(if (screenType.isWeb()) 12.dp else 4.dp),
                    imageVector = vectorResource(Res.drawable.ic_github),
                    tint = White,
                    contentDescription = null
                )
                Icon(
                    modifier = Modifier
                        .size(if (screenType.isWeb()) 64.dp else 24.dp)
                        .clip(CircleShape)
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable {
                            onClickLink(profile.notionUrl)
                        }
                        .padding(if (screenType.isWeb()) 12.dp else 4.dp),
                    imageVector = vectorResource(Res.drawable.ic_notion),
                    tint = White,
                    contentDescription = null
                )
                Icon(
                    modifier = Modifier
                        .size(if (screenType.isWeb()) 64.dp else 24.dp)
                        .clip(CircleShape)
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable {
                            onClickLink(profile.mailUrl)
                        }
                        .padding(if (screenType.isWeb()) 12.dp else 4.dp),
                    imageVector = vectorResource(Res.drawable.ic_mail),
                    tint = White,
                    contentDescription = null
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 48.dp else 12.dp)
        ) {
            Text(
                text = "Hello, I am",
                style = TextStyle(
                    color = Gray200,
                    fontSize = if (screenType.isWeb()) 40.sp else 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (isFontLoad) firaCode() else null
                )
            )
            Text(
                modifier = Modifier.width(if (screenType.isWeb()) 550.dp else 200.dp),
                text = profile.name,
                style = TextStyle(
                    color = White,
                    fontSize = if (screenType.isWeb()) 60.sp else 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (isFontLoad) firaCode() else null
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Android Developer",
                style = TextStyle(
                    color = White,
                    fontSize = if (screenType.isWeb()) 48.sp else 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (isFontLoad) firaCode() else null
                )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    if (screenType.isWeb()) 48.dp else 20.dp
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(if (screenType.isWeb()) 16.dp else 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${profile.experience}",
                        style = TextStyle(
                            color = Gray300,
                            fontSize = if (screenType.isWeb()) 86.sp else 30.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = if (isFontLoad) firaCode() else null
                        )
                    )
                    Text(
                        text = "YEARS OF\nEXPERIENCE",
                        style = TextStyle(
                            color = Gray200,
                            fontSize = if (screenType.isWeb()) 28.sp else 12.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = if (isFontLoad) firaCode() else null
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        if (screenType.isWeb()) 16.dp else 4.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${profile.projectCount}",
                        style = TextStyle(
                            color = Gray300,
                            fontSize = if (screenType.isWeb()) 86.sp else 30.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = if (isFontLoad) firaCode() else null
                        )
                    )
                    Text(
                        text = "PROJECTS\nCOMPLETED",
                        style = TextStyle(
                            color = Gray200,
                            fontSize = if (screenType.isWeb()) 28.sp else 12.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = if (isFontLoad) firaCode() else null
                        )
                    )
                }
            }
        }
    }
}
