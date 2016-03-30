//package netty;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.channel.nio.*;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.LineBasedFrameDecoder;
//import io.netty.handler.codec.string.StringDecoder;
//
//import java.util.logging.Logger;
//
//import org.junit.Assert;
//
//public class ClientTest {
//    private static final Logger logger = Logger.getLogger("TimeClient");
//
//    public static void main(String[] args) throws Exception {
////        for (int n=0; n<10; ++n) {
////            new ClientThread(new TimeClient()).start();
////        }
//        new TimeClient().connect(20000, "127.0.0.1");
//    }
////    static class ClientThread extends Thread {
////        private TimeClient timeClient;
////        public ClientThread(TimeClient timeClient) throws Exception {
////            this.timeClient = timeClient;
////        }
////        
////        @Override
////        public void run() {
////            try {
////                timeClient.connect(8080, "127.0.0.1");
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////        
////    }
//    static class TimeClient {
//        public void connect(int port, String host) throws Exception {
//            EventLoopGroup group = new NioEventLoopGroup();
//            try {
//                Bootstrap b = new Bootstrap();
//                b.group(group)
//                        .channel(NioSocketChannel.class)
//                        .option(ChannelOption.TCP_NODELAY, true)
//                        .handler(new ChannelInitializer<SocketChannel>() {
//                            @Override
//                            protected void initChannel(SocketChannel ch) throws Exception {
//                            	ChannelPipeline pipeline = ch.pipeline();
//                            	pipeline.addLast(new LineBasedFrameDecoder(1024));
////                            	pipeline.addLast(new StringDecoder());
//                            	pipeline.addLast(new TimeClientHandler());
//                            }
//                        });
//                ChannelFuture f = b.connect(host, port).sync();
//                f.channel().closeFuture().sync();
//                System.out.println("=============================");
//            } finally {
//                group.shutdownGracefully();
//            }
//        }
//    }
//    static class TimeClientHandler extends ChannelHandlerAdapter {
//        //private ByteBuf firstMessage;
//        private final byte[] req;
//        private int counter;
//        public TimeClientHandler() {
//            req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
//            //firstMessage = Unpooled.buffer(req.length);
//            //firstMessage.writeBytes(req);
//        }
//        @Override
//        public void channelActive(ChannelHandlerContext ctx) {
//            //ctx.writeAndFlush(firstMessage);
//            for (int i=0; i<100; ++i) {
//                ByteBuf message = Unpooled.buffer(req.length);
//                message.writeBytes(req);
//                ctx.writeAndFlush(message);
//            }
//        }
//        @Override
//        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//            ByteBuf buf = (ByteBuf) msg;
//            byte[] req = new byte[buf.readableBytes()];
//            buf.readBytes(req);
//            String body = new String(req, "UTF-8");
//            System.out.println("现在是：" + body);
//            System.out.println("客户端统计次数：" + ++counter);
//            //super.channelRead(ctx, msg); // XXX
//        	
//        	
////        	String body = (String) msg;
////        	System.out.println("客户端统计次数：" + ++counter + "【现在是：" + body + "】");
//        }
//        @Override
//        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//            logger.warning("client exception" + cause.getMessage());
//            super.exceptionCaught(ctx, cause);
//        }
//    }
//}
