package com.btc.connect;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BcRPCUtils {
    private static final String RPCURL = "http://127.0.0.1:7001";
    /**
     * ①准备json数据
     * ②发送一个post请求
     */
    public String prepareJSON(String method,Object... params){
        JSONObject object = new JSONObject();
        object.put("id",System.currentTimeMillis());
        object.put("jsonrpc","2.0");
        object.put("method",method);
        //几个参数，数据类型
        //可变参数，Object
        if(params != null){
            object.put("params",params);
        }
       return object.toJSONString();
    }

    //发送一个post请求
    public void executePost(Map<String,String>headers,String jsonStr){
        DefaultHttpClient client =new DefaultHttpClient();
        HttpPost post = new HttpPost(RPCURL);
        post.addHeader("Encoding","UTF-8");
        post.addHeader("Content-Type","application/json");
        //post.addHeader();
        //map :key --> value
        if (headers != null){
            Set<String> keys = headers.keySet();
            for(String key : keys){
             String value = headers.get(key);
             post.addHeader(key,value);
            }
        }
        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonStr);
            post.setEntity(entity);
            HttpResponse response =  client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code == HttpStatus.SC_OK){
              String resEntity =  EntityUtils.toString(response.getEntity());
            }else {

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
