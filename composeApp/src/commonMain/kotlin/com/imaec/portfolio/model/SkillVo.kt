package com.imaec.portfolio.model

data class SkillVo(
    val title: String,
    val content: String
) {
    companion object {
        fun items() = listOf(
            SkillVo(
                title = "Language",
                content = "Kotlin, Java, Dart"
            ),
            SkillVo(
                title = "Architecture",
                content = "Clean Architecture, MVVM, BLoC"
            ),
            SkillVo(
                title = "Android",
                content = "Jetpack Compose, Jetpack Navigation, Dagger Hilt, Coroutines, Flow, LiveData, DataBinding"
            ),
            SkillVo(
                title = "Flutter",
                content = "Future, Dio, Retrofit, GetIt, freezed"
            ),
            SkillVo(
                title = "Etc.",
                content = "Git, Github Actions, Fastlane, Firebase"
            ),
            SkillVo(
                title = "Tools",
                content = "Slack, Figma, Jira, Confluence, Notion"
            )
        )
    }
}
