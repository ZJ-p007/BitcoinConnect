package com.btc.connect.entity;

public class ValiDateAddress {
    private boolean isvalid;
    private String address;
    private String scriptPubKey;
    private boolean isscript;
    private boolean iswitness;

    public boolean isIsvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScriptPubKey() {
        return scriptPubKey;
    }

    public void setScriptPubKey(String scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    public boolean isIsscript() {
        return isscript;
    }

    public void setIsscript(boolean isscript) {
        this.isscript = isscript;
    }

    public boolean isIswitness() {
        return iswitness;
    }

    public void setIswitness(boolean iswitness) {
        this.iswitness = iswitness;
    }
}
