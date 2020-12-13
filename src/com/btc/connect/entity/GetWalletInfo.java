package com.btc.connect.entity;

public class GetWalletInfo {
        private String walletname;
        private long walletversion;
        private double balance;
        private double unconfirmed_balance;
        private double immature_balance;
        private int txcount;
        private long keypoololdest;
        private long keypoolsize_hd_internal;
        private double paytxfee;
        private String hdseedid;
        private String hdmasterkeyid;
        private boolean private_keys_enabled;

    public String getWalletname() {
        return walletname;
    }

    public void setWalletname(String walletname) {
        this.walletname = walletname;
    }

    public long getWalletversion() {
        return walletversion;
    }

    public void setWalletversion(long walletversion) {
        this.walletversion = walletversion;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getUnconfirmed_balance() {
        return unconfirmed_balance;
    }

    public void setUnconfirmed_balance(double unconfirmed_balance) {
        this.unconfirmed_balance = unconfirmed_balance;
    }

    public double getImmature_balance() {
        return immature_balance;
    }

    public void setImmature_balance(double immature_balance) {
        this.immature_balance = immature_balance;
    }

    public int getTxcount() {
        return txcount;
    }

    public void setTxcount(int txcount) {
        this.txcount = txcount;
    }

    public long getKeypoololdest() {
        return keypoololdest;
    }

    public void setKeypoololdest(long keypoololdest) {
        this.keypoololdest = keypoololdest;
    }

    public long getKeypoolsize_hd_internal() {
        return keypoolsize_hd_internal;
    }

    public void setKeypoolsize_hd_internal(long keypoolsize_hd_internal) {
        this.keypoolsize_hd_internal = keypoolsize_hd_internal;
    }

    public double getPaytxfee() {
        return paytxfee;
    }

    public void setPaytxfee(double paytxfee) {
        this.paytxfee = paytxfee;
    }

    public String getHdseedid() {
        return hdseedid;
    }

    public void setHdseedid(String hdseedid) {
        this.hdseedid = hdseedid;
    }

    public String getHdmasterkeyid() {
        return hdmasterkeyid;
    }

    public void setHdmasterkeyid(String hdmasterkeyid) {
        this.hdmasterkeyid = hdmasterkeyid;
    }

    public boolean isPrivate_keys_enabled() {
        return private_keys_enabled;
    }

    public void setPrivate_keys_enabled(boolean private_keys_enabled) {
        this.private_keys_enabled = private_keys_enabled;
    }
}
