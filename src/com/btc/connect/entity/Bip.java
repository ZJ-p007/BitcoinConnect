package com.btc.connect.entity;

public class Bip {
    private String id;
    private int version;
    private Reject reject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Reject getReject() {
        return reject;
    }

    public void setReject(Reject reject) {
        this.reject = reject;
    }
}
