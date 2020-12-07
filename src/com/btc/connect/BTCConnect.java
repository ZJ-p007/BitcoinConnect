package com.btc.connect;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class BTCConnect {
    //RPC服务的用户名,应该与比特币客户端节点的配置文件一致
    private static final String RPCUSER = "user";
    //RPC服务中的用户密码,应该与比特币客户端节点的配置文件一致
    private static final String RPCPASSWORD = "pwd";
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
        object.put("method","getblockcount");//
        //object.put("params","");
        //Basic基础的
        object.put("Authorization","Basic" + base64Encode(RPCUSER + ":" + RPCPASSWORD));
        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);

        //2.使用java网络通信进行rpc连接,发起一个post类型的请求把准备好json数据发送给rpc服务器



    }
    public static String base64Encode(String msg){
      return Base64.getEncoder().encodeToString(msg.getBytes(StandardCharsets.UTF_8));
    }
}
