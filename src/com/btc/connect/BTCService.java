package com.btc.connect;

import com.alibaba.fastjson.JSON;
import com.btc.connect.entity.BlockChainInfo;
import com.btc.connect.entity.BlockData;
import com.btc.connect.entity.GetBlockHeader;
import com.btc.connect.entity.GetChainTxStats;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

//Service:服务
public class BTCService {
    private static Map<String, String> map = new HashMap();

    static {
        map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
    }

    /**
     * 获取bi特币节点的区块总数
     * @return 返回比特币节点的区块总数int类型
     */

    /**
     * 获取最新区块的哈希值
     *
     * @return
     */
    public String getBestBlockHsah() {
        String json = BcRPCUtils.prepareJSON(Constants.GETBESTBLOCKHASH);
        //  Map<String,String> map = new HashMap();
        // map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
        // map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(RPCUSER + ":" + RPCUPASSWORD));
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        } else {
            // System.out.println(result.getCode());
            return null;
        }
    }

    /**
     * 取当前节点同步到的所有区块数据的个数
     *
     * @return
     */
    public int getBlockCount() {
        //1.json
        //2.post请求
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCOUNT);
        // Map<String,String> map = new HashMap();
        // map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
        //map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(RPCUSER + ":" + Constants.RPCUPASSWORD));
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return -1;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String countStr = result.getData().getResult();
            return Integer.parseInt(countStr);//将字符串转换成int类型

        } else {
            //System.out.println(result.getCode());
            return -1;//-1查询失败
        }
    }

    /**
     * 获取当前区块链信息
     * 命令:getBlockChainInfo
     *
     * @return
     */
    public BlockChainInfo getBlockChainInfo() {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCHAININFO);
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return JSON.parseObject(info, BlockChainInfo.class);
        }
        return null;
    }

    //获取指定高度的区块的哈希值

    /**
     * 获取指定高度的区块的哈希值
     *
     * @param height 指定高度
     * @return 区块hash值
     */
    public String getBlockHashByteHeight(int height) {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKHASH, height);
        System.out.println(json);
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 根据区块hash值获取指定区块的信息
     *
     * @param hash 区块的hash
     * @return 区块的信息，查询失败返回null
     */
    public BlockData getBlockByHash(String hash) {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCK, hash);
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            //return result.getData().getResult();
            return JSON.parseObject(result.getData().getResult(), BlockData.class);
        }
        return null;
    }

    /**
     * 生成比特币的新地址
     *
     * @param label        标签，可自定义
     * @param address_type 比特币地址类型，可选项有3个，分别是:legacy,p2sh-segwit,bech32
     * @return 返回生成的新的比特币地址，如果请求失败，返回null,
     */
    public String getNewAddress(String label, ADDRESS_TYPE address_type) {
       /* String address = null;
        switch (address_type){
            case LEGACY:
                address = "legacy";
                break;
            case P2SH_SEGWIT:
                address = "p2sh_segwit";
                break;
            case BECH32:
                address = "bech32";
                break;
        }*/
        String type = Constants.getNewAddressTy(address_type);
        String json = BcRPCUtils.prepareJSON(Constants.GETNEWADDRESS, label, type);
        System.out.println(json);
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    //使用数据的时候只能从给定的选项内选择其中一项

    /**
     * 获取链
     *
     * @param hash1
     * @return
     */
    //获取链getchaintxstats
    public GetChainTxStats getChainTxStats(int hash1) {
        String json = BcRPCUtils.prepareJSON(Constants.GETCHAINTXSTATS, hash1);
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return JSON.parseObject(result.getData().getResult(), GetChainTxStats.class);
        }
        return null;
    }

    //getblockheader "blockhash" ( verbose )：获取指定哈希的区块头
    public GetBlockHeader getBlockHeader(String hash2) {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKHEADER, hash2);
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return JSON.parseObject(result.getData().getResult(), GetBlockHeader.class);
        }
        return null;
    }

}
