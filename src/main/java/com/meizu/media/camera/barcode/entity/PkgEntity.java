package com.meizu.media.camera.barcode.entity;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class PkgEntity {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int code;
    private String errorCode;
    private String message;
    private String redirect;
    private String value;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public String getValue() {
        return this.value;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRedirect(String str) {
        this.redirect = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 2576, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "PkgEntity{code=" + this.code + ", message='" + this.message + '\'' + ", redirect='" + this.redirect + '\'' + ", errorCode='" + this.errorCode + '\'' + ", value=" + this.value + '}';
    }
}
