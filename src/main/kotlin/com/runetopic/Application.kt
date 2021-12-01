package com.runetopic

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun Application.module() {
    routing {
        get("/jav_config.ws") {
            call.respondBytes {
                JavConfigResource.asBytes()
            }
        }
    }
}

private class JavConfigResource {
    companion object {
        fun asBytes(): ByteArray {
            val reader = this::class.java.getResourceAsStream("/jav_config.ws")!!
            val bytes = reader.readAllBytes()
            reader.close()
            return bytes
        }
    }
}

fun main() {
    embeddedServer(
        Netty,
        watchPaths = listOf("http-server"),
        module = Application::module,
        port = 8080
    ).start(wait = true)
}