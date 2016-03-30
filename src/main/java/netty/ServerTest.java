//package netty;
//
//import java.util.Date;
//import java.util.logging.Logger;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelHandlerAdapter;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.LineBasedFrameDecoder;
//import io.netty.handler.codec.string.StringDecoder;
//import io.netty.util.concurrent.Future;
//
//public class ServerTest {
//    static Logger logger = Logger.getLogger("Server");
//
//    public static void main(String[] args) throws Exception {
//        logger.info("start");
//        new TimeServer().bind(20000);
//    }
//
//    static class TimeServer {
//        public void bind(int port) throws Exception {
//            EventLoopGroup bossGroup = new NioEventLoopGroup();
//            EventLoopGroup workerGroup = new NioEventLoopGroup();
//            try {
//                ServerBootstrap b = new ServerBootstrap();
//                b.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 1024)
//                    .childHandler(new ChildChannelHandler());
//                ChannelFuture f = b.bind(port).sync();
//                f.channel().closeFuture().sync();
//            } finally {
//                Future<?> bossGroupShutdownFuture = bossGroup.shutdownGracefully();
//                Future<?> workerGroupShutdownFuture = workerGroup.shutdownGracefully();
//                logger.info("bossGroupShutdownFuture: " + bossGroupShutdownFuture.get());
//                logger.info("workerGroupShutdownFuture: " + workerGroupShutdownFuture.get());
//            }
//        }
//    }
//    static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
//        @Override
//        protected void initChannel(SocketChannel arg0) throws Exception {
//            arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
//            arg0.pipeline().addLast(new StringDecoder());
//            arg0.pipeline().addLast(new TimeServerHandler());
//        }
//    }
//    static class TimeServerHandler extends ChannelHandlerAdapter {
//        private int counter;
//        @Override
//        public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        	super.channelActive(ctx);
//        }
//        @Override
//        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//            //ByteBuf buf = (ByteBuf) msg;
//            //byte[] req = new byte[buf.readableBytes()];
//            //buf.readBytes(req);
//            //String body = new String(req, "UTF-8");
//        	String body = (String) msg;
//            System.out.println( ("【统计次数：" + ++counter + "，收到命令：" + body + "】").replace("\n", "#") );
//            System.out.println();
//            String curTime = ( "QUERY TIME ORDER".equalsIgnoreCase(body) ?
//                    new Date().toString() : "BAD ORDER" ) + "\n";
//            ByteBuf res = Unpooled.copiedBuffer(curTime.getBytes());
//            ctx.write(res);
//            super.channelRead(ctx, msg); // XXX
//        }
//        
//        
//
//        @Override
//        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//            super.exceptionCaught(ctx, cause); // XXX
//            ctx.close();
//        }
//        
//        @Override
//        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//            ctx.flush();
//            super.channelReadComplete(ctx); // XXX
//        }
//        
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
