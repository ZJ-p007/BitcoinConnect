package com.btc.connect;

import com.alibaba.fastjson.JSON;
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
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BcRPCUtils {
    private static final String RPCURL = "http://127.0.0.1:7001";

    /**
     * ①准备json数据
     * ②发送一个post请求
     */
    public static String prepareJSON(String method, Object... params) {
        JSONObject object = new JSONObject();
        object.put("id", System.currentTimeMillis());
        object.put("jsonrpc", "2.0");
        object.put("method", method);
        //几个参数，数据类型
        //可变参数，Object
        if (params != null) {
            object.put("params", params);
        }
        return object.toJSONString();
    }

    /**
     * 发送一个post请求
     * @param headers  请求头设置
     * @param jsonStr 请求体数据
     * @return 返回的结果信息
     */
    //发送一个post请求
    public static Result executePost(Map<String, String> headers, String jsonStr) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(RPCURL);
        post.addHeader("Encoding", "UTF-8");
        post.addHeader("Content-Type", "application/json");
        //post.addHeader();
        //map :key --> value
        if (headers != null) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                String value = headers.get(key);
                post.addHeader(key, value);
            }
        }
        // StringEntity entity = null;
        try {
            StringEntity entity = new StringEntity(jsonStr);
            // entity = new StringEntity(jsonStr);
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            Result result = new Result();
            if (code == HttpStatus.SC_OK) {
                String resEntity = EntityUtils.toString(response.getEntity());
                result.setCode(code);
                result.setMsg("请求成功");
                //反序列化
                RpcResult rpcResult = JSON.parseObject(resEntity, RpcResult.class);
                result.setData(rpcResult);
            } else {
                result.setCode(code);
                result.setMsg("请求失败");
                result.setData(null);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String base64Encode(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes(StandardCharsets.UTF_8));
    }
}


