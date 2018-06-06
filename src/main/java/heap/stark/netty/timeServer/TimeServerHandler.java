/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package heap.stark.netty.timeServer;



import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.TimeUnit;

/**
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
//@ChannelHandler.Sharable
public class TimeServerHandler extends ChannelHandlerAdapter {
    @Override
    public boolean isSharable() {
        return true;
    }

    public static  int a=0;
    public int b;
    TimeServerHandler(){
        a++;
        b=a;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
	    throws Exception {
        System.out.println("b:"+b);
        System.out.println(Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
	    ByteBuf buf = (ByteBuf) msg;
	    byte[] req = new byte[buf.readableBytes()];
	    buf.readBytes(req);
	    String body = new String(req, "UTF-8");
	    System.out.println("The time server receive order : " + body);
	    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(
		    System.currentTimeMillis()).toString() : "BAD ORDER";
	    ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
	    ctx.write(resp);
	    //ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
	ctx.close();
    }
}
