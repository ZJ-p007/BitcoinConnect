package cn.rpc.connect;

import java.net.InetSocketAddress;

public class run {
    public static void main(String[] args) {
//创建异步发布服务端的线程并启动，用于接受PRC客户端的请求，根据请求参数调用服务实现类，返回结果给客户端
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    RpcExporter.exporter("localhost",8080);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
//创建客户端服务代理类，构造RPC求情参数，发起RPC调用
        RpcImporter<EchoService> importer=new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost",8088));
        System.out.println(echo.echo("Are you ok?"));
    }
}
