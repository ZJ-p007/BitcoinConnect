package com.btc.connect;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.security.DeployClientAuthCertStore;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpClientConnectionOperator;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class BTCConnect {
    //RPC服务的用户名,应该与比特币客户端节点的配置文件一致
    private static final String RPCUSER = "user";
    //RPC服务中的用户密码,应该与比特币客户端节点的配置文件一致
    private static final String RPCPASSWORD = "pwd";
    private static final String RPCURL = "http://127.0.0.1:7001";
    //maven：管理和构建项目的依赖和配置
    //依赖的配置:xml文件
    public static void main(String[] args) {
        System.out.println("Hello word");
        /**
         * 1.准备json-rpc通信的json数据
             fastjson.jar
         * 2.使用java网络通信进行rpc连接
             httpclient、httpcore
         * 3.接收java中http形式的rpc连接响应
         * 4.处理结果
         */

        //1.准备json-rpc通信的json数据
        JSONObject object = new JSONObject();
        object.put("id",System.currentTimeMillis() + "");//当前时间的毫秒数
        object.put("jsonrpc","2.0");//rpc服务协议版本
        //object.put("method","getblockchaininfo");
        object.put("method","getnewaddress");
        //object.put("Authorization","Basic" + base64Encode(RPCUSER + ":" + RPCPASSWORD));
        //object.put("params","0");//调用命令时的传参数
        //Basic基础的

        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);

        //2.使用java网络通信进行rpc连接,发起一个post类型的请求把准备好json数据发送给rpc服务器
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(RPCURL);
        //client执行一个post请求
        try {
            //设置请求头
            post.addHeader("Content-Type","application/json");
            post.addHeader("Encoding","UTF-8");
            post.addHeader("Authorization","Basic " + base64Encode(RPCUSER + ":" + RPCPASSWORD));

            //entity:实体
            StringEntity entity = new StringEntity(jsonRpcStr);
            post.setEntity(entity);//设置请求数据
            HttpResponse response = client.execute(post);//执行网络，阻塞在当前行
            //请求状态码
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){
                System.out.println("rpc请求连接成功");
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }else {
               //UNAUTHORIZED unauthorized
                System.out.println("rpc请求连接失败,状态码是:"+code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String base64Encode(String msg){
      return Base64.getEncoder().encodeToString(msg.getBytes(StandardCharsets.UTF_8));
    }
}
//https://github.com/ZJ-p007/BitcoinConnect.git