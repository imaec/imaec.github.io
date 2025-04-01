package com.imaec.portfolio.model

data class CareerVo(
    val period: String,
    val company: String,
    val team: String,
    val position: String,
    val job: String,
    val responsibilities: List<String>,
    val skills: List<List<String>>,
    val work: String
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
                ),
                work = "운동 O2O 플랫폼 국민피티를 개발 및 유지보수 했고, " +
                        "국민피티 서비스를 종료하고 부티크 운동 예약 플랫폼 웰니스북을 개발하고 출시 했습니다.\n\n" +
                        "국민피티를 운영 할 땐 안드로이드 앱 개발 업무를 담당하였고, " +
                        "iOS 개발자가 모두 퇴사 후에는 iOS 앱 개발 업무도 병행 수행했습니다.\n" +
                        "웰니스북은 Flutter로 안드로이드/iOS 앱 개발 업무를 하였습니다.\n\n" +
                        "국민피티를 운영 할 때는 클라이언트팀 팀장으로 안드로이드 개발자 2명, iOS 개발자 2명, " +
                        "프론트엔드 개발자 2명, 총 6명의 팀원들과 함께 개발하였고,\n웰니스북을 운영 할 땐 " +
                        "개발팀 팀장으로 모바일 개발자 3명, 프론트엔드 개발자 1명, 백엔드 개발자 2명, " +
                        "총 6명의 팀원들과 함께 개발하였습니다.\n\n" +
                        "타 부서와 프로젝트 진행 전반에 관한 소통을 담당하고, 개발팀의 일정과 개발 범위를 관리하였습니다. " +
                        "안드로이드, iOS 네이티브 개발에서 Flutter로 전환함에 있어 프로젝트의 구조 및 코드 컨벤션 " +
                        "등을 고민하여 Clean Architecture 기반으로 BLoC을 이용한 상태관리를 채택했고, " +
                        "Effective Dart 기반의 코드 컨벤션을 만들어 코드의 규칙성을 확립하고 이에 따른 코드 리뷰를 " +
                        "진행 했습니다.\n\n" +
                        "2024년 10월 10일 회사의 사업 중단 결정으로 서비스를 종료하게 됐습니다."
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
                ),
                work = "뷰티/피트니스 O2O 플랫폼 라이픽을 개발하고 출시 했습니다.\n\n" +
                        "라이픽에서 라이픽 소비자 앱을 총 4명의 팀원들과 같이 개발하였고,\n" +
                        "프로젝트는 Clean Architecture, MVVM, Multi Module 구조로 개발하였습니다. " +
                        "코드리뷰를 통해 동료 개발자들과 상호 보완하며 프로젝트를 개발 및 출시하였습니다.\n\n" +
                        "2022년 07월 22일 회사의 사업 중단으로 서비스를 종료하게 됐습니다."
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
                ),
                work = "티머니(전 한국스마트카드)에서 스핀오프해서 나와 모바일 티머니, 댐댐(교통카드 충전/조회 서비스) " +
                        "앱 등을 서비스하는 회사입니다.\n\n" +
                        "안드로이드 앱 개발 업무를 하였습니다.\n\n" +
                        "티모넷에서 댐댐 안드로이드 앱과 티머니 인앱 결제, 클라우드 공인인증서 저장 서비스인 스마트사인 " +
                        "등을 개발/유지보수 했습니다.\n" +
                        "정부 과제 사업으로 FIDO2 안드로이드 BLE 인증장치를 " +
                        "개발하였으며 FIDO1 안드로이드 Client + Authenticator Combo, " +
                        "가상자산 지갑 앱인 페라비트 안드로이드 앱도 개발했습니다."
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
                ),
                work = "예스폼은 문서/양식 제공 업체로 사업계획서, 계약서, 이력서, 자기소개서, 재직증명서 각종 " +
                        "문서샘플 다운로드를 제공하는 서비스를 가지고 있습니다.\n\n" +
                        "안드로이드, iOS 앱 개발 업무를 하였습니다.\n\n" +
                        "예스폼은 WEB 기반의 서비스가 주요 서비스로 모바일 서비스의 비중이 10%도 되지 않아 회사에서 " +
                        "모바일 서비스에 대한 관심이 없었기 때문에 앱 개발자로서의 성장이 힘들다고 생각하였습니다." +
                        "회사에서 일이 없었기 때문에 업무를 익히고 개발자로서 성장하기 위해 예스폼 앱의 " +
                        "WebView → 네이티브 앱으로 리뉴얼 등을 제안하여 진행했지만 한계가 있다고 생각하여 " +
                        "퇴사를 하게 되었습니다."
            )
        )
    }
}
