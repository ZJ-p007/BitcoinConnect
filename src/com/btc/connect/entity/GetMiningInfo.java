package com.btc.connect.entity;

public class GetMiningInfo {
    private int blocks;
    private int currentblockweight;
    private int currentblocktx;
    private int difficulty;
    private int networkhashps;
    private int pooledtx;
    private String chain;
    private String warnings;

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getCurrentblockweight() {
        return currentblockweight;
    }

    public void setCurrentblockweight(int currentblockweight) {
        this.currentblockweight = currentblockweight;
    }

    public int getCurrentblocktx() {
        return currentblocktx;
    }

    public void setCurrentblocktx(int currentblocktx) {
        this.currentblocktx = currentblocktx;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getNetworkhashps() {
        return networkhashps;
    }

    public void setNetworkhashps(int networkhashps) {
        this.networkhashps = networkhashps;
    }

    public int getPooledtx() {
        return pooledtx;
    }

    public void setPooledtx(int pooledtx) {
        this.pooledtx = pooledtx;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }
}
