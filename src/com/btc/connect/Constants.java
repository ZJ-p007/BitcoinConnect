package com.btc.connect;

import org.omg.CORBA.PUBLIC_MEMBER;

import static com.btc.connect.ADDRESS_TYPE.BECH32;

/**
 * 常量
 */

public class Constants {
    //rpc服务协议
    public static final String RPCUSER = "user";//rpc用户
    public static final String RPCPASSWORD = "pwd";//rpc密码
    public static final String RPCURL = "http://127.0.0.1:7001";//rpc连接

    //地址类型
    public static final String ADDRESS_LEGACY = "legacy";
    public static final String ADDRESS_P2SH_SEGWIT = "p2sh-segwit";
    public static final String ADDRESS_BECH32 = "bech32";

    //rpc服务命令
    /**
     * 获取区块总数
     */
    public static final String GETBLOCKCOUNT = "getblockcount";

    /**
     * 获取最新区块的哈希
     */
    public static final String GETBESTBLOCKHASH = "getbestblockhash";

    /**
     * 获取当前区块链信息
     */
    public static final String GETBLOCKCHAININFO = "getblockchaininfo";

    /**
     * 获取指定高度的区块的哈希值
     */
    public static final String GETBLOCKHASH = "getblockhash";

    /**
     * 据区块hash值获取指定区块的信息
     */
    public static final String GETBLOCK = "getblock";

    /**
     *生成比特币的新地址
     */
    public static final String GETNEWADDRESS = "getnewaddress";

    /**
     * 获取链
     */
    public static final String GETCHAINTXSTATS = "getchaintxstats";

    /**
     * 获取指定哈希的区块头
     */
    public static final String GETBLOCKHEADER = "getblockheader";

    //
    public static final String GETMEMPOOLINFO = "getmempoolinfo";

    public static final String VALIDATEADDRESS = "validateaddress";

    public static final String DUMPWALLET = "dumpwallet";

    public static final String GETWALLETINFO = "getwalletinfo";

    public static final String GETMININGINFO = "getmininginfo";

    public static final String DUMPPRIVKEY = "dumpprivkey";






    /**
     * 用于根据枚举类型返回对应的比特币地址类型对应的字符串
     *
     * @param type 枚举
     * @return 比特币地址类型字符串形式
     */
    public static String getNewAddressTy(ADDRESS_TYPE type) {
        switch (type) {
            case LEGACY:
                return ADDRESS_LEGACY;
            case P2SH_SEGWIT:
                return ADDRESS_P2SH_SEGWIT;
            case BECH32:
                return ADDRESS_BECH32;
        }
        return null;
    }
}
