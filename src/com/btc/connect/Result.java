package com.btc.connect;

public class Result {
    private int code;//状态码
    private String msg;//状态码对应的描述信息
    private RpcResult data;//返回的数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RpcResult getData() {
        return data;
    }

    public void setData(RpcResult data) {
        this.data = data;
    }
}
