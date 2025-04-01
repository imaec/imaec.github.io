package com.imaec.portfolio

class WasmPlatform: Platform {
    override val name: String = "Web"
}

actual fun getPlatform(): Platform = WasmPlatform()
