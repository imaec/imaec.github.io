package com.imaec.portfolio.model

data class CareerVo(
    val period: String,
    val company: String,
    val team: String,
    val position: String,
    val job: String,
    val responsibilities: List<String>,
    val skills: List<List<String>>
) {
    companion object {
        fun items(): List<CareerVo> = listOf(
            CareerVo(
                period = "2022. 11. 15 ~ 2024. 10. 31",
                company = "주식회사 브랜드엑스피트니스",
                team = "개발팀",
                position = "팀장",
                job = "개발 관리 및 앱 개발",
                responsibilities = listOf(
                    " • 국민피티 안드로이드 앱 개발",
                    " • 국민피티 iOS 앱 개발",
                    " • 웰니스북 Flutter 앱 개발",
                    " • 웰니스북 파트너 Flutter 앱 개발"
                ),
                skills = listOf(
                    listOf("Android", "Kotlin", "Compose", "MVVM", "Hilt", "Jetpack Navigation", "Coroutines", "Flow"),
                    listOf("iOS", "Swift", "Swift UI", "Swift Concurrency", "Observable Object"),
                    listOf("Flutter", "Dart", "BLoC", "Future", "Dio", "Retrofit", "GetIt", "freezed"),
                    listOf("Clean Architecture", "Git", "Github Actions", "Fastlane", "Appsflyer")
                )
            ),
            CareerVo(
                period = "2021. 07. 19 ~ 2022. 07. 22",
                company = "주식회사라이픽",
                team = "개발팀",
                position = "안드로이드 엔지니어",
                job = "",
                responsibilities = listOf(
                    " • 라이픽 안드로이드 앱 개발"
                ),
                skills = listOf(
                    listOf("Android", "Kotlin", "MVVM", "Hilt", "Coroutines", "LiveData", "DataBinding"),
                    listOf("Clean Architecture", "Git", "Github Actions", "Fastlane", "Appsflyer")
                )
            ),
            CareerVo(
                period = "2019. 12. 16 ~ 2021. 07. 09",
                company = "(주)티모넷",
                team = "개발팀",
                position = "대리",
                job = "안드로이드 개발",
                responsibilities = listOf(
                    " • FIDO2 Android BLE Authenticator 개발",
                    " • FIDO1 Client + Autneticator Combo 개발",
                    " • 댐댐 안드로이드 앱 리뉴얼 및 유지보수",
                    " • 페라비트 안드로이드 앱 개발",
                    " • 페이코 전용 티머니 플라스틱 카드 결제 모듈 개발"
                ),
                skills = listOf(
                    listOf("Android", "Kotlin", "MVVM", "Coroutines", "LiveData", "DataBinding", "aar"),
                    listOf("FIDO2", "FIDO1", "BLE", "NFC", "NDK", "Git", "Firebase")
                )
            ),
            CareerVo(
                period = "2016. 11. 19 ~ 2019. 04. 30",
                company = "주식회사 예스폼",
                team = "개발팀",
                position = "사원",
                job = "안드로이드, iOS 개발",
                responsibilities = listOf(
                    " • 예스폼 안드로이드 앱 리뉴얼 및 유지보수",
                    " • 예스폼 iOS 앱 리뉴얼 및 유지보수",
                    " • 예스레쥬메 안드로이드 앱 개발",
                    " • 예스레쥬메 iOS 앱 개발"
                ),
                skills = listOf(
                    listOf("Android", "Kotlin", "Java", "MVP"),
                    listOf("iOS", "Swift"),
                    listOf("Firebase")
                )
            )
        )
    }
}
