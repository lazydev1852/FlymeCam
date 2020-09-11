package com.baidu.p020ar.bean;

import java.io.Serializable;

/* renamed from: com.baidu.ar.bean.DialogBean */
public class DialogBean implements Serializable {
    private static final long serialVersionUID = 793013907308438500L;
    private String mCancelText;
    private String mConfirmText;
    private int mId;
    private String mKey;
    private String mMessage;
    private String mTitle;

    /* renamed from: a */
    public String mo9607a() {
        return this.mMessage;
    }

    /* renamed from: a */
    public void mo9608a(String str) {
        this.mMessage = str;
    }

    /* renamed from: b */
    public String mo9609b() {
        return this.mTitle;
    }

    /* renamed from: b */
    public void mo9610b(String str) {
        this.mTitle = str;
    }

    /* renamed from: c */
    public String mo9611c() {
        return this.mConfirmText;
    }

    /* renamed from: c */
    public void mo9612c(String str) {
        this.mConfirmText = str;
    }

    /* renamed from: d */
    public String mo9613d() {
        return this.mCancelText;
    }

    /* renamed from: d */
    public void mo9614d(String str) {
        this.mCancelText = str;
    }

    /* renamed from: e */
    public String mo9615e() {
        return this.mKey;
    }

    /* renamed from: e */
    public void mo9616e(String str) {
        this.mKey = str;
    }
}
