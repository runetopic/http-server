package com.runetopic

import com.runetopic.api.properties.JavConfigProperties
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.HttpRequestDecoder
import io.netty.handler.codec.http.HttpResponseEncoder
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import java.net.InetSocketAddress

fun main() {
    startKoin {
        modules(module {
            single { JavConfigProperties() }
        })
    }

    ServerBootstrap()
        .group(NioEventLoopGroup(1), NioEventLoopGroup(1))
        .channel(NioServerSocketChannel::class.java)
        .childHandler(object : ChannelInitializer<Channel>() {
            override fun initChannel(channel: Channel) {
                channel.pipeline()
                    .addLast(HttpRequestDecoder())
                    .addLast(HttpResponseEncoder())
                    .addLast(HttpChannelInboundHandler())
            }
        })
        .childOption(ChannelOption.TCP_NODELAY, true)
        .bind(InetSocketAddress( 8080))
        .sync()

    println("Hello World! FGuck u")
}