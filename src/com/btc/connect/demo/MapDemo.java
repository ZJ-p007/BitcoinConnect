package com.btc.connect.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        //Map:key --> value
        Map<String, String> map = new HashMap();
        //向map中存数据
        map.put("name", "扬尼斯");
        map.put("age", "18");
        map.put("sex", "male");

        //从map中取数据，如何遍历map,如何取出全部
       /*String name = map.get("name");
       System.out.println(name);*/
        Set<String> keys = map.keySet();//全部的key取出来
        //map的遍历
        for (String key:keys){
            System.out.println(key);
            String value = map.get(key);//根据key取值
            System.out.println(value);
        }
    }
}
