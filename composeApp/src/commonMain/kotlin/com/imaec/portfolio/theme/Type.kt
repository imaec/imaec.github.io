package com.imaec.portfolio.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.firacode_bold
import portfolio.composeapp.generated.resources.firacode_light
import portfolio.composeapp.generated.resources.firacode_medium
import portfolio.composeapp.generated.resources.firacode_regular
import portfolio.composeapp.generated.resources.firacode_semibold
import portfolio.composeapp.generated.resources.pretendard_bold
import portfolio.composeapp.generated.resources.pretendard_light
import portfolio.composeapp.generated.resources.pretendard_medium
import portfolio.composeapp.generated.resources.pretendard_regular
import portfolio.composeapp.generated.resources.pretendard_semibold

@Composable
fun firaCode(): FontFamily = FontFamily(
    Font(Res.font.firacode_bold, FontWeight.Bold),
    Font(Res.font.firacode_semibold, FontWeight.SemiBold),
    Font(Res.font.firacode_medium, FontWeight.Medium),
    Font(Res.font.firacode_regular, FontWeight.Normal),
    Font(Res.font.firacode_light, FontWeight.Light)
)

@Composable
fun pretendard(): FontFamily = FontFamily(
    Font(Res.font.pretendard_bold, FontWeight.Bold),
    Font(Res.font.pretendard_semibold, FontWeight.SemiBold),
    Font(Res.font.pretendard_medium, FontWeight.Medium),
    Font(Res.font.pretendard_regular, FontWeight.Normal),
    Font(Res.font.pretendard_light, FontWeight.Light)
)
