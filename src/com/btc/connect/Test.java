package com.btc.connect;

import com.btc.connect.entity.Bip;
import com.btc.connect.entity.BlockChainInfo;
import com.btc.connect.entity.Reject;

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
        System.out.println("比特币节点的区块数:"+count);
        //获取最新区块的哈希值
        String hash =  service.getBestBlockHsah();
        System.out.println("最新区块的哈希:"+hash);

        //获取区块链节点信息
        BlockChainInfo chainInfo = service.getBlockChainInfo();
        if(chainInfo !=null){
           String chainInfoChain = chainInfo.getChain();
            System.out.println(chainInfoChain);
            System.out.println(chainInfo.getDifficulty());
            List<Bip> bipList = chainInfo.getSoftforks();
            for(Bip bip:bipList){
                System.out.println(bip.getId());
                System.out.println(bip.getVersion());

            }
        }
    }
}
