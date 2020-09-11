package com.meizu.media.camera.barcode.entity;

import com.meizu.savior.ChangeQuickRedirect;

public class ProductStoresEntity {
    public static ChangeQuickRedirect changeQuickRedirect;
    private String price;
    private String seller;
    private String store;

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String str) {
        this.seller = str;
    }

    public String getStore() {
        return this.store;
    }

    public void setStore(String str) {
        this.store = str;
    }
}
