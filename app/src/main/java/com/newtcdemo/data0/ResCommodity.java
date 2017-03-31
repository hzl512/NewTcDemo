package com.newtcdemo.data0;

/**
 * Created by admin on 2016/12/29.
 * 商品信息
 */
public class ResCommodity extends BaseResponse {
    //单一数据
    public Commodity data;

    @Override
    public String toString() {
        return "ResCommodity{" +
                "data=" + data +
                '}';
    }
}
