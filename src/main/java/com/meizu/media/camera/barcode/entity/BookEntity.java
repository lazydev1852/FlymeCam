package com.meizu.media.camera.barcode.entity;

import com.meizu.savior.ChangeQuickRedirect;

public class BookEntity {
    public static ChangeQuickRedirect changeQuickRedirect;
    private String author;
    private String barcode;

    /* renamed from: id */
    private long f8043id;
    private String logo;
    private String msg;
    private String name;
    private String price;
    private String publish;
    private String status;
    private String summary;

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String str) {
        this.barcode = str;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public long getId() {
        return this.f8043id;
    }

    public void setId(long j) {
        this.f8043id = j;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public String getPublish() {
        return this.publish;
    }

    public void setPublish(String str) {
        this.publish = str;
    }
}
