package com.btc.connect.demo;

import com.alibaba.fastjson.JSONObject;

public class JSONDemo {
    public static void main(String[] args) {
        System.out.println("学生信息：");
        //如何序列化json和反序列化json
        Student student = new Student();
        student.setName("憨憨");
        student.setAge(18);
        student.setSex("男");

        System.out.println("学生姓名:"+student.name);
        System.out.println("学生年龄:"+student.age);
        System.out.println("学生性别:"+student.sex);

        System.out.println("=========第一种方法========");
        //序列化操作
        JSONObject object = (JSONObject) JSONObject.toJSON(student);
        String objStr = object.toJSONString();
        System.out.println(objStr);

        //反序列化
       Student stu = JSONObject.parseObject(objStr,Student.class);
       System.out.println(stu.name);

        System.out.println("=========第二种方法========");
        //例如实例化一个程序员实例json格式
        //序列化
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","张三");
        jsonObject.put("sex","男");
        jsonObject.put("slogn","走自己的路，让其他人说去吧!");
        jsonObject.put("languaes","java,go,python");
        String coderJson =  jsonObject.toJSONString();
        System.out.println(coderJson);

    }
    static class Student{
        private String name;
        private int age;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
