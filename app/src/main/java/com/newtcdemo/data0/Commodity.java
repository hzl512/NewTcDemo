package com.newtcdemo.data0;

import java.io.File;

/**
 * Created by admin on 2016/12/29.
 */
public class Commodity {

    public Commodity() {}

    //
    private Integer id;
    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //
    private Integer usersID;
    public Integer getUsersID(){
        return usersID;
    }
    public void setUsersID(Integer usersid) {
        this.usersID = usersid;
    }
    //
    private String commodityImageUrl;
    public String getCommodityImageUrl(){
        return commodityImageUrl;
    }
    public void setCommodityImageUrl(String commodityimageurl) {
        this.commodityImageUrl = commodityimageurl;
    }
    //
    private File formFile;
    public File getFormFile(){
        return formFile;
    }
    public void setCommodityImageUrl(File file) {
        this.formFile = file;
    }
    //
    private String commodityName;
    public String getCommodityName(){
        return commodityName;
    }
    public void setCommodityName(String commodityname) {
        this.commodityName = commodityname;
    }
    //
    private String commodityDetail;
    public String getCommodityDetail(){
        return commodityDetail;
    }
    public void setCommodityDetail(String commoditydetail) {
        this.commodityDetail = commoditydetail;
    }
    //
    private String commodityAddress;
    public String getCommodityAddress(){
        return commodityAddress;
    }
    public void setCommodityAddress(String commodityaddress) {
        this.commodityAddress = commodityaddress;
    }
    //
    private String commodityPrice;
    public String getCommodityPrice(){
        return commodityPrice;
    }
    public void setCommodityPrice(String commodityprice) {
        this.commodityPrice = commodityprice;
    }
    //
    private Integer categoryID;
    public Integer getCategoryID(){
        return categoryID;
    }
    public void setCategoryID(Integer categoryid) {
        this.categoryID = categoryid;
    }
    //
    private Integer commodityBargain;
    public Integer getCommodityBargain(){
        return commodityBargain;
    }
    public void setCommodityBargain(Integer commoditybargain) {
        this.commodityBargain = commoditybargain;
    }
    //
    private Integer commodityPhone;
    public Integer getCommodityPhone(){
        return commodityPhone;
    }
    public void setCommodityPhone(Integer commodityphone) {
        this.commodityPhone = commodityphone;
    }
    //
    private Integer commodityQQ;
    public Integer getCommodityQQ(){
        return commodityQQ;
    }
    public void setCommodityQQ(Integer commodityqq) {
        this.commodityQQ = commodityqq;
    }
    //
    private String commodityAddTime;
    public String getCommodityAddTime(){
        return commodityAddTime;
    }
    public void setCommodityAddTime(String commodityaddtime) {
        this.commodityAddTime = commodityaddtime;
    }
    //
    private Integer commodityStatus;
    public Integer getCommodityStatus(){
        return commodityStatus;
    }
    public void setCommodityStatus(Integer commoditystatus) {
        this.commodityStatus = commoditystatus;
    }
    //
    private Integer commodityViews;
    public Integer getCommodityViews(){
        return commodityViews;
    }
    public void setCommodityViews(Integer commodityviews) {
        this.commodityViews = commodityviews;
    }

    @Override
    public String toString() {
        return "Commodity [categoryID=" + categoryID + ", commodityAddTime="
                + commodityAddTime + ", commodityAddress=" + commodityAddress
                + ", commodityBargain=" + commodityBargain
                + ", commodityDetail=" + commodityDetail
                + ", commodityImageUrl=" + commodityImageUrl
                + ", commodityName=" + commodityName + ", commodityPhone="
                + commodityPhone + ", commodityPrice=" + commodityPrice
                + ", commodityQQ=" + commodityQQ + ", commodityStatus="
                + commodityStatus + ", commodityViews=" + commodityViews
                + ", formFile=" + formFile + ", id=" + id + ", usersID="
                + usersID + "]";
    }
}
