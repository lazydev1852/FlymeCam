package com.meizu.media.camera.barcode.entity;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class ExpressEntity {
    public static ChangeQuickRedirect changeQuickRedirect;

    /* renamed from: com  reason: collision with root package name */
    private String f19137com;
    private String context;
    private String data;
    private String detailUri;
    private String icon;
    private String message;
    private String name;

    /* renamed from: nu */
    private String f8044nu;
    private String state;
    private String stateName;
    private String status;
    private String tel;
    private String time;
    private String url;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String str) {
        this.tel = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getDetailUri() {
        return this.detailUri;
    }

    public void setDetailUri(String str) {
        this.detailUri = str;
    }

    public String getCom() {
        return this.f19137com;
    }

    public void setCom(String str) {
        this.f19137com = str;
    }

    public String getNu() {
        return this.f8044nu;
    }

    public void setNu(String str) {
        this.f8044nu = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 2575, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "ExpressEntity{name='" + this.name + '\'' + ", icon='" + this.icon + '\'' + ", tel='" + this.tel + '\'' + ", url='" + this.url + '\'' + ", detailUri='" + this.detailUri + '\'' + ", com='" + this.f19137com + '\'' + ", nu='" + this.f8044nu + '\'' + ", state='" + this.state + '\'' + ", message='" + this.message + '\'' + ", status='" + this.status + '\'' + ", stateName='" + this.stateName + '\'' + ", data='" + this.data + '\'' + ", context='" + this.context + '\'' + ", time='" + this.time + '\'' + '}';
    }
}
