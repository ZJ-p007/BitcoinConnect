package com.btc.connect;

import com.btc.connect.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
   /* private static final String RPCUSER = "user";
    private static final String RPCPASSWORD = "pwd";*/

    public static void main(String[] args) {
        //1.生成一个新地址
       /* String jsonStr = BcRPCUtils.prepareJSON("getnewaddress");
        Map<String, String> map = new HashMap();
        map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCUPASSWORD));
        Result result = BcRPCUtils.executePost(map, jsonStr);
        System.out.println("请求状态码:" + result.getCode());
        System.out.println("请求状描述信息:" + result.getMsg());
        System.out.println("请求结果:" + result.getData().getResult());*/

        //获取区块的总数
        BTCService service = new BTCService();
        int count = service.getBlockCount();
        System.out.println("比特币节点的区块数:" + count);


        //获取最新区块的哈希值
        String hash = service.getBestBlockHsah();
        System.out.println("最新区块的哈希:" + hash);


        //获取区块链节点信息
        BlockChainInfo chainInfo = service.getBlockChainInfo();
        if (chainInfo != null) {
            String chainInfoChain = chainInfo.getChain();
            System.out.println(chainInfoChain);
            // System.out.println(chainInfo.getMediantime());
            System.out.println("最新区块的哈希值:" + chainInfo.getBestblockhash());
            //System.out.println("挖矿难度:"+chainInfo.getDifficulty());
            List<Bip> bipList = chainInfo.getSoftforks();
            for (Bip bip : bipList) {
                System.out.println(bip.getId());
                // System.out.println(bip.getVersion());
            }
        }

        //特定高度区块的哈希值
        String hash0 = service.getBlockHashByteHeight(0);
        System.out.println("特定高度区块的哈希值:" + hash0);

        //根据区块hash值获取指定区块的信息
        BlockData data = service.getBlockByHash(hash0);
        System.out.println("区块信息:" + data.getHash());

        //生成比特币的地址
        String address = service.getNewAddress("0000",ADDRESS_TYPE.LEGACY);
        System.out.println("生成的新地址:" + address);

        //计算关于链中事务的总数和速率的统计信息参数:获取链
        GetChainTxStats chainTxStats = service.getChainTxStats(0);
        System.out.println("获取链:" + chainTxStats.getWindow_final_block_hash());

        //获取指定哈希的区块头
        GetBlockHeader getBlockHeader = service.getBlockHeader(hash0);
        System.out.println("hash值:" + getBlockHeader.getHash());
        System.out.println("mediantime是:" + getBlockHeader.getMediantime());


    }
}
