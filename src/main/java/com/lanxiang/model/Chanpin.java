package com.lanxiang.model;

public class Chanpin {
    private Integer cid;

    private String chanpin;

    private String price;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getChanpin() {
        return chanpin;
    }

    public void setChanpin(String chanpin) {
        this.chanpin = chanpin == null ? null : chanpin.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }
}