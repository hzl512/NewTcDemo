package com.newtcdemo.data0;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by admin on 2016/12/29.
 * 定义网络业务接口
 */
public interface PostRoute {

    //http://192.168.1.226:8080/CampusSecondaryMarket/CommodityServlet?action=6
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("api/CampusSecondaryMarket/CommodityServlet")
    Call<ResCommodity> postCommoditys(@Body RequestBody route, @Query("action") int action);

}
