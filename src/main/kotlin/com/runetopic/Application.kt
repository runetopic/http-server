package com.runetopic

import com.runetopic.api.properties.JavConfigProperties
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun Application.module() {
    install(Koin) {
        modules(module {
            single { JavConfigProperties() }
        })
    }

    val javaConfigProperties: JavConfigProperties by inject()

    routing {
        get("/jav_config.ws") {
            call.respondBytes {
                javaConfigProperties.asBytes
            }
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