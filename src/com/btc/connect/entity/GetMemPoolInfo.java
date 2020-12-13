package com.btc.connect.entity;

public class GetMemPoolInfo {
    private int size;
    private int bytes;
    private int usage;
    private long maxmempool;
    private double mempoolminfee;
    private double minrelaytxfee;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public long getMaxmempool() {
        return maxmempool;
    }

    public void setMaxmempool(long maxmempool) {
        this.maxmempool = maxmempool;
    }

    public double getMempoolminfee() {
        return mempoolminfee;
    }

    public void setMempoolminfee(double mempoolminfee) {
        this.mempoolminfee = mempoolminfee;
    }

    public double getMinrelaytxfee() {
        return minrelaytxfee;
    }

    public void setMinrelaytxfee(double minrelaytxfee) {
        this.minrelaytxfee = minrelaytxfee;
    }
}
