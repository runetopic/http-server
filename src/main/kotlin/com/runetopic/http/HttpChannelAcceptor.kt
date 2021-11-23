package com.runetopic.http

import com.runetopic.api.extension.inject
import com.runetopic.api.properties.JavConfigProperties
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.HttpRequestDecoder
import io.netty.handler.codec.http.HttpResponseEncoder
import java.net.InetSocketAddress

/**
 * @author Jordan Abraham
 */
class HttpChannelAcceptor {

    private val javaConfigProperties by inject<JavConfigProperties>()

    fun accept() {
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
            .bind(InetSocketAddress(javaConfigProperties.codebase.removePrefix("http://"), 8080))
            .sync()
    }
}