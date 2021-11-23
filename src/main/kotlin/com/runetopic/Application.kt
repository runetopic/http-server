package com.runetopic

import com.runetopic.api.properties.JavConfigProperties
import com.runetopic.http.HttpChannelAcceptor
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

fun main() {
    startKoin {
        modules(module {
            single { JavConfigProperties() }
        })
    }
    HttpChannelAcceptor().accept()
    println("Accepting connections...")
}