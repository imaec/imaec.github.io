package com.imaec.portfolio.model

enum class ScreenType {
    WEB, TABLET, MOBILE;

    companion object {
        fun fromScreenWidth(screenWidth: Int) = when (screenWidth) {
            in 0..480 -> MOBILE
            in 481..1024 -> TABLET
            else -> WEB
        }
    }
}

fun ScreenType.isWeb() = this == ScreenType.WEB

fun ScreenType.isTablet() = this == ScreenType.TABLET

fun ScreenType.isMobile() = this == ScreenType.MOBILE
