package com.baidu.p020ar.bean;

import java.io.Serializable;

/* renamed from: com.baidu.ar.bean.ToastBean */
public class ToastBean implements Serializable {
    private static final long serialVersionUID = 8124965987658747179L;
    private int mId;
    private String mKey;
    private String mMsg;

    /* renamed from: a */
    public String mo9655a() {
        return this.mMsg;
    }

    /* renamed from: a */
    public void mo9656a(String str) {
        this.mMsg = str;
    }

    /* renamed from: b */
    public void mo9657b(String str) {
        this.mKey = str;
    }
}
