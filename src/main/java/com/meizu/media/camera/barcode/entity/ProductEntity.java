package com.meizu.media.camera.barcode.entity;

import com.meizu.savior.ChangeQuickRedirect;
import java.util.ArrayList;

public class ProductEntity {
    public static ChangeQuickRedirect changeQuickRedirect;
    private String barcode;
    private String country;
    private String factory;

    /* renamed from: id */
    private long f8045id;
    private int islogout;
    private String logo;
    private String msg;
    private String name;
    private String origin;
    private String price;
    private String specifications;
    private String status;
    private ArrayList<ProductStoresEntity> stores;

    public ArrayList<ProductStoresEntity> getStores() {
        return this.stores;
    }

    public void setStores(ArrayList<ProductStoresEntity> arrayList) {
        this.stores = arrayList;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String str) {
        this.barcode = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getFactory() {
        return this.factory;
    }

    public void setFactory(String str) {
        this.factory = str;
    }

    public long getId() {
        return this.f8045id;
    }

    public void setId(long j) {
        this.f8045id = j;
    }

    public int getIslogout() {
        return this.islogout;
    }

    public void setIslogout(int i) {
        this.islogout = i;
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

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getSpecifications() {
        return this.specifications;
    }

    public void setSpecifications(String str) {
        this.specifications = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String str) {
        this.logo = str;
    }
}
