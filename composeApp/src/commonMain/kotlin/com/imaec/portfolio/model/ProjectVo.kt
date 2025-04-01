package com.imaec.portfolio.model

import org.jetbrains.compose.resources.DrawableResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.img_cover_damdam
import portfolio.composeapp.generated.resources.img_cover_empty
import portfolio.composeapp.generated.resources.img_cover_fido1
import portfolio.composeapp.generated.resources.img_cover_fido2
import portfolio.composeapp.generated.resources.img_cover_imdang
import portfolio.composeapp.generated.resources.img_cover_kookminpt
import portfolio.composeapp.generated.resources.img_cover_lific
import portfolio.composeapp.generated.resources.img_cover_wellnessbook
import portfolio.composeapp.generated.resources.img_cover_wellnessbook_partner
import portfolio.composeapp.generated.resources.img_cover_yesform
import portfolio.composeapp.generated.resources.img_cover_yesresume

data class ProjectVo(
    val cover: DrawableResource,
    val title: String,
    val tags: List<String>
) {
    companion object {
        fun brandxfitnessItems(): List<ProjectVo> = listOf(
            ProjectVo(
                cover = Res.drawable.img_cover_wellnessbook_partner,
                title = "웰니스북 파트너 Flutter 앱",
                tags = listOf("Flutter", "Clean Architecture", "BLoC", "Future", "Dio", "Retrofit", "GetIt", "freezed")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_wellnessbook,
                title = "웰니스북 Flutter 앱",
                tags = listOf("Flutter", "Clean Architecture", "BLoC", "Future", "Dio", "Retrofit", "GetIt", "freezed")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_kookminpt,
                title = "국민피티 안드로이드 앱",
                tags = listOf("Android", "Clean Architecture", "Compose", "MVVM", "Hilt", "Coroutines", "Flow")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_kookminpt,
                title = "국민피티 iOS 앱",
                tags = listOf("iOS", "Swift UI", "Siwft Concurrency", "Observable Object")
            )
        )

        fun lificItems(): List<ProjectVo> = listOf(
            ProjectVo(
                cover = Res.drawable.img_cover_lific,
                title = "라이픽 안드로이드 앱",
                tags = listOf("Android", "Clean Architecture", "MVVM", "Hilt", "Coroutines", "LiveData", "DataBinding")
            )
        )

        fun tmonetItems(): List<ProjectVo> = listOf(
            ProjectVo(
                cover = Res.drawable.img_cover_fido1,
                title = "FIDO1 Client + Authenticator Combo",
                tags = listOf("Android", "UAF", "KLV", "aar")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_empty,
                title = "페라비트 안드로이드 앱",
                tags = listOf("Android", "FIDO1", "MVVM", "LiveData", "DataBinding")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_fido2,
                title = "FIDO2 Android BLE Authenticator",
                tags = listOf("Android", "CTAP", "CBOR", "BLE", "MVVM", "Coroutiens", "aar")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_damdam,
                title = "댐댐 안드로이드 앱",
                tags = listOf("Android", "NFC")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_empty,
                title = "페이코 전용 티머니 플라스틱 카드 결제 모듈",
                tags = listOf("Android", "NFC", "NDK", "aar")
            )
        )

        fun yesformItems(): List<ProjectVo> = listOf(
            ProjectVo(
                cover = Res.drawable.img_cover_yesform,
                title = "예스폼 안드로이드, iOS 앱",
                tags = listOf("Android", "iOS", "MVP", "Firebase")
            ),
            ProjectVo(
                cover = Res.drawable.img_cover_yesresume,
                title = "예스레쥬메 안드로이드, iOS 앱",
                tags = listOf("Android", "iOS", "Firebase")
            )
        )

        fun imdangItems(): List<ProjectVo> = listOf(
            ProjectVo(
                cover = Res.drawable.img_cover_imdang,
                title = "아파트임당 안드로이드 앱",
                tags = listOf("Android", "Clean Architecture", "Compose", "MVVM", "Hilt", "Coroutines", "Flow")
            )
        )
    }
}
