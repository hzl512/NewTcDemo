package com.newtcdemo.data0;

/**
 * Created by admin on 2016/12/29.
 * 基础的请求类
 */
public class BaseRequest {
    public boolean paging;//是否分页
    public Integer page_no;//页码
    public Integer page_size;//页大小
    public Integer id;

    public boolean isPaging() {
        return paging;
    }

    public void setPaging(boolean paging) {
        this.paging = paging;
    }

    public Integer getPage_no() {
        return page_no;
    }

    public void setPage_no(Integer page_no) {
        this.page_no = page_no;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
