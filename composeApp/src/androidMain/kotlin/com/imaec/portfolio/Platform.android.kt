package com.imaec.portfolio

class AndroidPlatform : Platform {
    override val name: String = "ANDROID"
}

actual fun getPlatform(): Platform = AndroidPlatform()
