package com.btc.connect.entity;

public class BipSoftForks {
    private SoftFork csv;
    private SoftFork segwit;

    public SoftFork getCsv() {
        return csv;
    }

    public void setCsv(SoftFork csv) {
        this.csv = csv;
    }

    public SoftFork getSegwit() {
        return segwit;
    }

    public void setSegwit(SoftFork segwit) {
        this.segwit = segwit;
    }
}
