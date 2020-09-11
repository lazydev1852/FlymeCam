package com.baidu.p020ar.logo;

/* renamed from: com.baidu.ar.logo.RecognitionRes */
public class RecognitionRes {

    /* renamed from: a */
    private String f1839a;

    /* renamed from: b */
    private String f1840b;

    /* renamed from: c */
    private int f1841c;

    /* renamed from: d */
    private double f1842d;

    /* renamed from: e */
    private C0792b f1843e;

    public String getCode() {
        return this.f1840b;
    }

    public C0792b getImageLocation() {
        return this.f1843e;
    }

    public String getName() {
        return this.f1839a;
    }

    public double getProbability() {
        return this.f1842d;
    }

    public int getType() {
        return this.f1841c;
    }

    public void setCode(String str) {
        this.f1840b = str;
    }

    public void setImageLocation(C0792b bVar) {
        this.f1843e = bVar;
    }

    public void setName(String str) {
        this.f1839a = str;
    }

    public void setProbability(double d) {
        this.f1842d = d;
    }

    public void setType(int i) {
        this.f1841c = i;
    }
}
