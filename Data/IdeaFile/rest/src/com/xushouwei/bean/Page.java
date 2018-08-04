package com.xushouwei.bean;


import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/29.
 */
public class Page  implements Serializable{

    private Integer size;
    private Integer start;
    private Integer count;
    private  Integer page;

    public Page() {

    }

    public Page(Integer start, Integer size, Integer count,Integer page) {
        this.start = start;
        this.size = size;
        this.count = count;
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "Page{" +
                "size=" + size +
                ", start=" + start +
                ", count=" + count +
                ", page=" + page +
                '}';
    }
}
