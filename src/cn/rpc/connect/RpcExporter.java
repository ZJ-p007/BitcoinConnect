package cn.rpc.connect;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {

    //创建一个可重用固定线程数的线程池
    //Runtime.getRuntime().availableProcessors()返回虚拟机可用的处理器数量
    static Executor executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostname,int port) throws IOException {
        //创建一个监听特定端口的Serversocket,负责接收客户连接请求
        ServerSocket server = new ServerSocket();
        //绑定主机名端口号
        server.bind(new InetSocketAddress(hostname,port));
        try{
            while (true)
            {
                executor.execute(new ExporterTask(server.accept()));
            }
        }finally {
            server.close();
        }
    }
    private static class ExporterTask implements Runnable{
        Socket client = null;
        public ExporterTask(Socket client){
            this.client = client;
        }
        @Override
        public void run(){
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try{
                //获取输入流
                input = new ObjectInputStream(client.getInputStream());
                //获取调用的接口名
                String interfaceName = input.readUTF();
                //加载接口
                Class<?> service = Class.forName(interfaceName);
                //获取调用的方法名
                String methodName = input.readUTF();
                //获取方法返回类型
                Class<?>[] ParameterTypes = (Class<?>[]) input.readObject();
                //获取参数
                Object[] arguments = (Object[]) input.readObject();
                //通过反射获取方法
                Method method = service.getMethod(methodName, ParameterTypes);
                //通过反射调用方法
                Object result = method.invoke(service.newInstance(), arguments);
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            finally {
                if(output != null)
                    try{
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if(input != null){
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

//https://github.com/ZJ-p007/BitcoinConnect.git