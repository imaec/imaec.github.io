package com.imaec.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
