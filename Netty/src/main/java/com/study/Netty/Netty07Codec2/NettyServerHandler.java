package com.study.Netty.Netty07Codec2;

import com.study.Netty.Netty07Codec.StudentPOJO;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


/*
说明：
1.自定义一个Handler需要继承netty规定好的某个HandlerAdapter
2.这时我们自定义的一个Handler，才能称作一个handler
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

        if (msg.getDataType()==(MyDataInfo.MyMessage.DataType.StudentType)){
            MyDataInfo.Student student = msg.getStudent();
            System.out.println("学生id="+student.getId()+"，姓名="+student.getName());
        }else if(msg.getDataType()==MyDataInfo.MyMessage.DataType.WorkerType){
            MyDataInfo.Worker worker = msg.getWorker();
            System.out.println("worker Age="+worker.getAge()+"，姓名="+worker.getName());
        }else {
            System.out.println("传输的类型不对");
        }
    }


    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //writeAndFlush是write+flush
        //将数据写入到缓存，并刷新
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端", CharsetUtil.UTF_8));
    }

    //处理异常,一般需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
