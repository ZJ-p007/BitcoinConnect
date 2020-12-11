package com.btc.connect.entity;

public class GetChainTxStats {
    private long time;
    private int txcount;
    private String window_final_block_hash;
    private int window_block_count;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getTxcount() {
        return txcount;
    }

    public void setTxcount(int txcount) {
        this.txcount = txcount;
    }

    public String getWindow_final_block_hash() {
        return window_final_block_hash;
    }

    public void setWindow_final_block_hash(String window_final_block_hash) {
        this.window_final_block_hash = window_final_block_hash;
    }

    public int getWindow_block_count() {
        return window_block_count;
    }

    public void setWindow_block_count(int window_block_count) {
        this.window_block_count = window_block_count;
    }
}
