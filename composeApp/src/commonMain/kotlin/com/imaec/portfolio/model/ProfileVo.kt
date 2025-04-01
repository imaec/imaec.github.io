package com.imaec.portfolio.model

import org.jetbrains.compose.resources.DrawableResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.kimhansik

data class ProfileVo(
    val profile: DrawableResource = Res.drawable.kimhansik,
    val githubUrl: String = "https://github.com/imaec",
    val notionUrl: String = "https://dev-imaec.notion.site/1c3d4a92fd0580059c6cf30903c59f40",
    val mailUrl: String = "mailto:imaec@naver.com",
    val name: String = "KIM HANSIK",
    val experience: Int = 8,
    val projectCount: Int = 13
)
