package com.imaec.portfolio.model

import org.jetbrains.compose.resources.DrawableResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ic_app_store
import portfolio.composeapp.generated.resources.ic_github
import portfolio.composeapp.generated.resources.ic_play_store
import portfolio.composeapp.generated.resources.img_cover_damdam
import portfolio.composeapp.generated.resources.img_cover_fido1
import portfolio.composeapp.generated.resources.img_cover_fido2
import portfolio.composeapp.generated.resources.img_cover_imdang
import portfolio.composeapp.generated.resources.img_cover_kookminpt
import portfolio.composeapp.generated.resources.img_cover_lific
import portfolio.composeapp.generated.resources.img_cover_wellnessbook
import portfolio.composeapp.generated.resources.img_cover_wellnessbook_partner
import portfolio.composeapp.generated.resources.img_cover_yesform
import portfolio.composeapp.generated.resources.img_cover_yesresume

data class ProjectDetailVo(
    val cover: DrawableResource? = null,
    val title: String,
    val projectSummary: List<String>,
    val responsibilities: List<String>,
    val troubleShootings: List<String>,
    val techSkills: List<String>,
    val notes: List<String>,
    val links: List<Triple<DrawableResource, String, String>>
) {
    companion object {
        fun brandxfitnessItems(): List<ProjectDetailVo> = listOf(
            ProjectDetailVo(
                cover = Res.drawable.img_cover_wellnessbook_partner,
                title = "웰니스북 파트너\nFlutter 앱",
                projectSummary = listOf(
                    " • 웰니스북의 Business 고객인 파트너들이 프로그램 및 고객을 관리할 수 있는 앱",
                    " • Flutter를 이용해서 안드로이드와 iOS 동시 개발",
                    " • Github Actions, Fastlane을 이용해 빌드-배포 자동화 구축"
                ),
                responsibilities = listOf(
                    " • 개발 환경 구축 → 개발/운영 환경 분리",
                    " • 빌드 라인 구축 → Github Actions와 Fastlane을 활용해 CI/CD 라인 구축",
                    " • 로그인/회원가입 → 소셜(Google, Kakao)/이메일 로그인 및 회원가입 구현",
                    " • 프로그램/클래스 관리 → 파트너가 직접 프로그램을 생성하고 고객을 관리할 수 있는 기능 개발",
                    " • 푸시 알림 → FCM을 활용한 푸시 알림 기능 개발"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 프레임워크 : Flutter",
                    " • 언어 : Dart",
                    " • 상태 관리 : BLoC",
                    " • 네트워크 : Dio, Retrofit",
                    " • DI(의존성 주입) : GetIt",
                    " • 기타 : Multi Module, CleanArchitecture, Future, freezed"
                ),
                notes = listOf(
                    " • 회사의 사업 중단으로 인해 서비스 오픈 전 종료 (2024. 10. 11)"
                ),
                links = listOf()
            ),
            ProjectDetailVo(
                cover = Res.drawable.img_cover_wellnessbook,
                title = "웰니스북\nFlutter 앱",
                projectSummary = listOf(
                    " • 부티크 운동 예약 플랫폼 웰니스북 앱 개발",
                    " • Flutter를 이용해서 안드로이드와 iOS를 동시 개발",
                    " • 예약, 결제, 검색, 딥링크, 미디어 처리 등의 주요 기능 담당",
                    " • Github Actions, Fastlane을 이용해 빌드-배포 자동화 구축"
                ),
                responsibilities = listOf(
                    " • 개발 환경 구축 → 개발/운영 환경 분리",
                    " • 빌드 라인 구축 → Github Actions와 Fastlane을 활용해 CI/CD 라인 구축",
                    " • 로그인/회원가입 → 소셜(Google, Kakao)/이메일 로그인 및 회원가입 구현",
                    " • 예약/결제 → 사용자 얘약 기능 개발 및 TossPayments SDK를 연동한 결제 기능 개발",
                    " • 검색 → 다양한 조건에 따른 프로그램/클래스 검색 기능 개발",
                    " • 푸시 알림 → FCM을 활용한 푸시 알림 기능 개발",
                    " • 딥링크 처리 → Appsflyer를 이용한 앱 및 상세화면 공유 기능 개발"
                ),
                troubleShootings = listOf(
                    " • 커스텀 미디어 피커 성능 개선",
                    "    • 이미지 목록을 가져오는 로직과 앨범을 그룹화하는 로직을 비동기로 처리해 성능 개선",
                    " • 동영상 메모리 최적화",
                    "    • 스크롤에 따른 동영상 재성/정지 및 캐싱 구현으로 성능 개선",
                    "    • 웹뷰로 되어있던 상세 페이지를 네이티브로 전환해 동영상이 많은 화면에서 발생하는 메모리 릭 문제 해결"
                ),
                techSkills = listOf(
                    " • 프레임워크 : Flutter",
                    " • 언어 : Dart",
                    " • 상태 관리 : BLoC",
                    " • 네트워크 : Dio, Retrofit",
                    " • DI(의존성 주입) : GetIt",
                    " • 기타 : Multi Module, CleanArchitecture, Future, freezed"
                ),
                notes = listOf(
                    " • 안드로이드",
                    "    • 현재 서비스 종료",
                    "    • 앱 관리 미흡으로 스토어에서 내려간 것으로 추정"
                ),
                links = listOf(
                    Triple(
                        Res.drawable.ic_app_store,
                        "AppStore",
                        "https://apps.apple.com/kr/app/웰니스북-부티크-운동-예약-플랫폼/id6475799328"
                    )
                )
            ),
            ProjectDetailVo(
                cover = Res.drawable.img_cover_kookminpt,
                title = "국민피티\n안드로이드 앱",
                projectSummary = listOf(
                    " • 운동 O2O 플랫폼 국민피티 안드로이드 앱 개발",
                    " • 주요 기능 개발부터 성능 최적화, 보안 강화까지 전반적인 서비스 개발 담당"
                ),
                responsibilities = listOf(
                    " • 로그인/회원가입 → 소셜(Google, Kakao)/이메일 로그인 및 회원가입 구현",
                    " • 온보딩 → 사용자의 앱 사용 안내를 위한 온보딩 구현",
                    " • 모임 → 지역별 운동 모임을 만들어 사용자간 운동을 함께 할 수 있는 모임 기능 개발",
                    " • 피드 → 개인/모임 운동 후 운동/식단 팁, 후기 등을 남길 수 있는 피드 기능 개발",
                    " • 채팅 → 1:1, 그룹 채팅 개발",
                    " • 푸시 알림 → FCM을 활용한 푸시 알림 기능 개발"
                ),
                troubleShootings = listOf(
                    " • API Interceptor를 이용한 네트워크 오류 공통 처리",
                    " • 동영상, 이미지 캐싱 최적화로 네트워크 과부하 해결",
                    " • 난독화 및 Proguard 적용으로 보안 강화"
                ),
                techSkills = listOf(
                    " • 언어 : Kotlin",
                    " • UI : Compose",
                    " • 네트워크 : Retrofit",
                    " • DI(의존성 주입) : Hilt",
                    " • 비동기 처리 : Coroutines, Flow",
                    " • 기타 : Multi Module, CleanArchitecture, MVVM"
                ),
                notes = listOf(
                    " • 회사의 사업 중단으로 인해 서비스 종료 (2024. 06. 25)"
                ),
                links = listOf()
            ),
            ProjectDetailVo(
                cover = Res.drawable.img_cover_kookminpt,
                title = "국민피티\niOS 앱",
                projectSummary = listOf(
                    " • 운동 O2O 플랫폼 국민피티 iOS 앱 개발",
                    " • 사용자 편의를 위한 빠른 문의 기능 구현",
                    " • 사용자 경험 개선을 위한 이미지 로딩 성능 최적화"
                ),
                responsibilities = listOf(
                    " • 빠른 문의 채팅 구현 → 일반 채팅과 구분된 사용자 액션 기반의 빠른 문의 기능 개발"
                ),
                troubleShootings = listOf(
                    " • 커스텀 미디어 피커 성능 개선",
                    "    • 전체 이미지를 한 번에 가져오는 방식에서 이미지를 분할 로딩하는 방식으로 수정하여 성능 최적화"
                ),
                techSkills = listOf(
                    " • 언어 : Swift",
                    " • UI : SwiftUI",
                    " • 패키지 관리 : SPM",
                    " • 비동기 처리 : Swift Concurrency"
                ),
                notes = listOf(
                    " • 회사의 사업 중단으로 인해 서비스 종료 (2024. 06. 25)"
                ),
                links = listOf()
            )
        )

        fun lificItems(): List<ProjectDetailVo> = listOf(
            ProjectDetailVo(
                cover = Res.drawable.img_cover_lific,
                title = "라이픽\n안드로이드 앱",
                projectSummary = listOf(
                    " • 뷰티/피트니스 종합 플랫폼 라이픽 앱 개발",
                    " • 앱 초기 개발부터 서비스 출시까지 수행"
                ),
                responsibilities = listOf(
                    " • 홈, 목록, 검색, 브랜드관 → 사용자가 상품을 탐색하는 목록, 검색, 브랜드관 구현",
                    " • 회원 → 소셜 (Kakao, Naver, Google, Facebook)/이메일 로그인 및 회원가입 구현",
                    " • 프로모션, 공유 → Appsflyer를 이용한 친구 초대 프로모션 기능 구현"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 언어 : Kotlin",
                    " • 네트워크 : Retrofit",
                    " • DI(의존성 주입) : Hilt",
                    " • 비동기 처리 : Coroutines",
                    " • 기타 : Multi Module, CleanArchitecture, MVVM"
                ),
                notes = listOf(
                    " • 회사의 사업 중단으로 인해 서비스 종료 (2022. 07. 20)"
                ),
                links = listOf()
            )
        )

        fun tmonetItems(): List<ProjectDetailVo> = listOf(
            ProjectDetailVo(
                cover = Res.drawable.img_cover_fido1,
                title = "FIDO1 Client +\nAuthenticator Combo",
                projectSummary = listOf(
                    " • 비밀번호 없이 인증을 할 수 있는 FIDO1 UAF 프로토콜 기반의 인증 장치 개발",
                    " • Android 환경에서 동작하는 FIDO Client 구현",
                    " • FIDO 공식 Conformance Tools의 모든 항목 통과",
                    " • RP 서버 및 페라비트 앱과 연동을 통해 인증 강화 및 실사용"
                ),
                responsibilities = listOf(
                    " • FIDO1 UAF 프로토콜 기반 인증 장치 및 클라이언트 개발",
                    " • FIDO1 Conformance Test Tools UAF 1.1 모든 항목 통과",
                    " • UAF Client + Authenticator Combo 모듈화",
                    " • PIN 인증 방식 추가",
                    " • RP 서버 및 페라비트 앱과의 연동"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 프레임워크 : UAF (Universal Authenticator Framework)",
                    " • 언어 : Kotlin",
                    " • 서버 통신 데이터 형식 : KLV (Key Length Value) Hex String",
                    " • 기타 : arr"
                ),
                notes = listOf(
                    " • FIDO1 기반의 강력한 인증 시스템 구축",
                    " • FIDO Conformance Test Tools의 테스트를 통과함으로써 신뢰성 검증"
                ),
                links = listOf()
            ),
            ProjectDetailVo(
                cover = null,
                title = "페라비트\n안드로이드 앱",
                projectSummary = listOf(
                    " • 가상자산(암호화폐)를 안전하게 관리할 수 있는 페라비트 안드로이드 앱 개발",
                    " • FIDO1 인증을 통한 보안 강화",
                    " • 비트코인, 이더리움, ERC20 코인을 연동하여 다중 암호화폐 관리"
                ),
                responsibilities = listOf(
                    " • 회원가입/로그인 → 이메일 및 휴대폰 인증",
                    " • 지갑 생성 및 리스트 관리 기능 개발",
                    " • 친구 관리 기능 개발",
                    " • 비트코인, 이더리움, ERC20(체인링크) 연동",
                    " • FIDO1 인증 연동을 통한 보안 강화"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 언어 : Kotlin",
                    " • 네트워크 : Retrofit",
                    " • DI(의존성 주입) : Hilt",
                    " • 비동기 처리 : Coroutines",
                    " • 보안 : FIDO1",
                    " • 기타 : MVVM, LiveData, DataBinding"
                ),
                notes = listOf(
                    " • 2021. 10 오픈 예정이나 퇴사 후 소식 없음"
                ),
                links = listOf()
            ),
            ProjectDetailVo(
                cover = Res.drawable.img_cover_fido2,
                title = "FIDO2 Android\nBLE Authenticator",
                projectSummary = listOf(
                    " • FIDO2 기반 BLE Authenticator를 개발하여 개인 기기를 안전한 인증 장치로 활용할 수 있도록 구현",
                    " • CTAP2 CBOR API를 통해 WebBrowser(FIDO Client)와 통신",
                    " • FIDO 공식 Conformance Test Tools의 모든 항목 통과",
                    " • 키 백업 서버와의 연동을 통해 키 저장 및 복구 기능 지원"
                ),
                responsibilities = listOf(
                    " • FIDO2 Authenticator BLE 방식 개발",
                    " • FIDO Client와 CTAP CBOR API 통신 구현",
                    " • FIDO2 Conformance Test Tools CTAP2 모든 항목 통과",
                    " • Authenticator 모듈화 (aar 패키징)",
                    " • 샘플 앱 개발 및 UI를 통한 로그 확인 기능 제공",
                    " • 키 백업 서버 연동(키 저장, 키 복구, 이용 내역 관리, 등록된 RP 목록 관리)"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 언어 : Kotlin",
                    " • 서버 통신 및 데이터 형식 : CTAP, CBOR, BLE",
                    " • 네트워크 : Retrofit",
                    " • DI(의존성 주입) : Hilt",
                    " • 비동기 처리 : Coroutines",
                    " • 기타 : MVVM, DataBinding, arr"
                ),
                notes = listOf(
                    " • BLE 기반의 FIDO2 Authenticator를 성공적인 개발",
                    " • FIDO 공식 인증 시험을 통과하여 신뢰성 검증",
                    " • 키백업 서버와의 연동을 통해 사용성 향상"
                ),
                links = listOf()
            ),
            ProjectDetailVo(
                cover = Res.drawable.img_cover_damdam,
                title = "댐댐\n안드로이드 앱",
                projectSummary = listOf(
                    " • 교통카드 잔액 충전/조회 서비스 댐댐 안드로이드 앱 리뉴얼 및 유지보수",
                    " • 기존 외주 개발자들이 작업한 코드의 일관성 및 가독성 개선",
                    " • 유지보수성을 높이기 위해 공통 기능 모듈화",
                    " • 추가 기능 개발 및 androidx 마이그레이션"
                ),
                responsibilities = listOf(
                    " • 부비NFC → 댐댐 브랜드 리뉴얼 및 네이티브 UI 개편",
                    " • 공통 코드 정리 및 JavascriptInterface 공통 모듈화",
                    " • 오픈뱅킹 연동 및 결제 기능 확장(캐시비 추가)",
                    " • 스티커형 티머니 충전 불가 처리",
                    " • androidx 마이그레이션 및 카카오 비즈보드 SDK 적용"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 언어 : Java",
                    " • 기타 : NFC, Firebase"
                ),
                notes = listOf(),
                links = listOf(
                    Triple(
                        Res.drawable.ic_play_store,
                        "PlayStore",
                        "https://play.google.com/store/apps/details?id=com.tmoney.nfc_pay"
                    )
                )
            ),
            ProjectDetailVo(
                cover = null,
                title = "페이코 전용 티머니 플라스틱\n카드 결제 모듈",
                projectSummary = listOf(
                    " • 페이코 전용 티머니 플라스틱 카드 결제 기능을 독립적인 모듈로 개발",
                    " • 기존 결제 및 충전 모듈에서 결제 부분만 분리",
                    " • NDK를 활용한 네이티브 코드(.so 파일) 제작"
                ),
                responsibilities = listOf(
                    " • 결제 기능을 독립적인 라이브러리(aar)로 분리",
                    " • NFC 기반 결제 기능 구현"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 언어 : Java",
                    " • 기타 : Java, NDK, aar"
                ),
                notes = listOf(),
                links = listOf()
            )
        )

        fun yesformItems(): List<ProjectDetailVo> = listOf(
            ProjectDetailVo(
                cover = Res.drawable.img_cover_yesform,
                title = "예스폼\n안드로이드, iOS 앱",
                projectSummary = listOf(
                    " • 서식 양식, 교통카드 잔액 충전/조회 서비스 댐댐 안드로이드 앱 리뉴얼 및 유지보수",
                    " • 성능, 편의성, UX 개선을 위한 네이티브 리뉴얼"
                ),
                responsibilities = listOf(
                    " • 웹뷰 → 네이티브 리뉴얼",
                    " • 성능, 편의성, UX 개선을 위한 리뉴얼 제안",
                    " • 기존 모바일 웹과 화면은 동일하나 탭 전환 및 화면 이동 성능 개선",
                    " • 리뉴얼 과정에서 필요한 신규 API 개발"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 안드로이드 : Kotlin, MVP, Retrofit",
                    " • iOS : Swift, Alamofire"
                ),
                notes = listOf(
                    " • iOS : 퇴사 후 개발자의 부재로 iOS 서비스 종료"
                ),
                links = listOf(
                    Triple(
                        Res.drawable.ic_play_store,
                        "PlayStore",
                        "https://play.google.com/store/apps/details?id=com.yesform.app"
                    )
                )
            ),
            ProjectDetailVo(
                cover = Res.drawable.img_cover_yesresume,
                title = "예스레쥬메\n안드로이드, iOS 앱",
                projectSummary = listOf(
                    " • 2만여 가지의 자기소개서 구성항목을 활용하여 자기소개서 작성을 지원하는 서비스 예스레쥬메 앱 개발",
                    " • ‘예스폼’ 앱과의 연동으로 자기소개서 샘플 가져오기 기능 개발"
                ),
                responsibilities = listOf(
                    " • 자기소개서 작성 지원 기능 개발",
                    " • 스펙 공유 및 면접 후기 작성/조회 기능 개발",
                    " • ‘예스폼’ 앱과 연동하여 자기소개서 샘플 가져오기 기능 개발",
                    " • 안드로이드 및 iOS 버전 모두 개발 및 배포"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 안드로이드 : Kotlin, MVP, Retrofit",
                    " • iOS : Swift, Alamofire"
                ),
                notes = listOf(
                    " • 퇴사 후 개발자의 부재로 서비스 종료"
                ),
                links = listOf()
            )
        )

        fun imdangItems(): List<ProjectDetailVo> = listOf(
            ProjectDetailVo(
                cover = Res.drawable.img_cover_imdang,
                title = "아파트임당 안드로이드 앱",
                projectSummary = listOf(
                    " • 아파트 임장 후기 공유 서비스 아파트임장 안드로이드 앱 개발",
                    " • 단순 SNS 게시글 공유 방식이 아닌 회원간 게시글 교환 시스템",
                    " • 인사이트(임장 후기 게시글) 작성/조회, 인사이트 교환 등 주요 기능 담당",
                    " • CI/CD를 구축해 빌드-배포 자동화 구축",
                    " • 프로젝트는 XML 기반의 UI로 제작되었으나 Jetpack Compose를 활용한 별도 개인 프로젝트 병행"
                ),
                responsibilities = listOf(
                    " • 개발 스택 결정",
                    "    • 개발 시작 전 기술 스택을 결정하고 팀원과 공유",
                    "    • 컨벤션 작성 및 린트 설정 → 통일성 있는 코드 작성 및 규칙적인 코드 리뷰 환경",
                    " • 개발 환경 구축 → 개발/운영 환경 분리",
                    " • 빌드 라인 구축 → Github Actions와 Fastlane을 활용해 CI/CD 라인 구축",
                    " • 로그인 → 소셜 (Google, Kakao) 로그인 구현",
                    " • 홈, 보관함, 목록 → 인사이트를 탐색하는 홈, 보관함, 목록 구현",
                    " • 인사이트 작성, 상세, 교환 → 아파트임당의 주요 기능인 인사이트 작성, 상세, 교환 기능 구현"
                ),
                troubleShootings = listOf(),
                techSkills = listOf(
                    " • 언어 : Kotlin",
                    " • UI : XML, Compose",
                    " • 네트워크 : Retrofit",
                    " • DI(의존성 주입) : Hilt",
                    " • 비동기 처리 : Coroutines, Flow",
                    " • 기타 : Multi Module, CleanArchitecture, MVVM"
                ),
                notes = listOf(),
                links = listOf(
                    Triple(
                        Res.drawable.ic_play_store,
                        "PlayStore",
                        "https://play.google.com/store/apps/details?id=info.imdang.imdang"
                    ),
                    Triple(
                        Res.drawable.ic_github,
                        "Github\n(XML)",
                        "https://github.com/imdangg/imdang-android"
                    ),
                    Triple(
                        Res.drawable.ic_github,
                        "Github\n(Compose)",
                        "https://github.com/imaec/imdang"
                    )
                )
            )
        )
    }
}
