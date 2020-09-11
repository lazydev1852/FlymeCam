package com.baidu.p020ar.bean;

/* renamed from: com.baidu.ar.bean.BrowserBean */
public class BrowserBean {
    public static final String TYPE = "type";
    public static final String URL = "url";

    /* renamed from: a */
    private int f1093a;

    /* renamed from: b */
    private String f1094b;

    /* renamed from: com.baidu.ar.bean.BrowserBean$OPENTYPE */
    public enum OPENTYPE {
        DEFAULT_TYPE,
        SHOUBAI_O2O_TYPE,
        INTERNAL_TYPE
    }

    public int getType() {
        return this.f1093a;
    }

    public String getUrl() {
        return this.f1094b;
    }

    public void setType(int i) {
        this.f1093a = i;
    }

    public void setUrl(String str) {
        this.f1094b = str;
    }
}
