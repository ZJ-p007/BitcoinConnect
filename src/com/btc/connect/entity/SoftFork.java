package com.btc.connect.entity;

public class SoftFork {
    private String status;
    private long startTime;
    private long timeout;
    private int since;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }
}
