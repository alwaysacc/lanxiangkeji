package com.lanxiang.model;

public class Orderitem {
    private Integer itemid;
    private String chanpin;
    private String menxing;

    private String color;

    private String chicun;

    private String menxiang;

    private String mensuo;

    private String heye;

    private String menxi;

    private String xuanpei;

    private String beizhu;

    private Integer oid;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }
    public String getChanpin() {
        return chanpin;
    }

    public void setChanpin(String chanpin) {
        this.chanpin = chanpin == null ? null : chanpin.trim();
    }


    public String getMenxing() {
        return menxing;
    }

    public void setMenxing(String menxing) {
        this.menxing = menxing == null ? null : menxing.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getChicun() {
        return chicun;
    }

    public void setChicun(String chicun) {
        this.chicun = chicun == null ? null : chicun.trim();
    }

    public String getMenxiang() {
        return menxiang;
    }

    public void setMenxiang(String menxiang) {
        this.menxiang = menxiang == null ? null : menxiang.trim();
    }

    public String getMensuo() {
        return mensuo;
    }

    public void setMensuo(String mensuo) {
        this.mensuo = mensuo == null ? null : mensuo.trim();
    }

    public String getHeye() {
        return heye;
    }

    public void setHeye(String heye) {
        this.heye = heye == null ? null : heye.trim();
    }

    public String getMenxi() {
        return menxi;
    }

    public void setMenxi(String menxi) {
        this.menxi = menxi == null ? null : menxi.trim();
    }

    public String getXuanpei() {
        return xuanpei;
    }

    public void setXuanpei(String xuanpei) {
        this.xuanpei = xuanpei == null ? null : xuanpei.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}