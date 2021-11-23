package com.runetopic

import com.runetopic.api.extension.inject
import com.runetopic.api.properties.JavConfigProperties
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.*

/**
 * @author Jordan Abraham
 */
internal class HttpChannelInboundHandler : SimpleChannelInboundHandler<DefaultHttpRequest>() {

    private val javaConfigProperties by inject<JavConfigProperties>()

    override fun channelRead0(ctx: ChannelHandlerContext, msg: DefaultHttpRequest) {
        if (msg.decoderResult().isFailure) {
            ctx.channel().close()
            return
        }
        if (msg.method() != HttpMethod.GET) {
            ctx.channel().close()
            return
        }
        when (QueryStringDecoder(msg.uri()).path()) {
            "/jav_config.ws" -> {
                val response = DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(javaConfigProperties.asBytes))
                response.headers().set(HttpHeaderNames.SERVER, "JaGeX/3.1")
                response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=ISO-8859-1")
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, javaConfigProperties.asBytes.size)
                ctx.channel().writeAndFlush(response).addListener(ChannelFutureListener.CLOSE)
            }
            else -> ctx.channel().writeAndFlush(DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST)).addListener(ChannelFutureListener.CLOSE)
        }
    }
}