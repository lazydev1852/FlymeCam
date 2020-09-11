package com.meizu.media.camera.p064a;

import java.io.Serializable;

/* renamed from: com.meizu.media.camera.a.g */
public class XmpMetaData implements Serializable {

    /* renamed from: a */
    private String f7490a;

    /* renamed from: b */
    private boolean f7491b;

    /* renamed from: c */
    private boolean f7492c;

    /* renamed from: d */
    private int f7493d;

    public XmpMetaData(String str, boolean z, boolean z2, int i) {
        this.f7490a = str;
        this.f7491b = z;
        this.f7492c = z2;
        this.f7493d = i;
    }

    public XmpMetaData() {
        this("", false, false, -1);
    }

    /* renamed from: a */
    public String mo18752a() {
        return this.f7490a;
    }

    /* renamed from: a */
    public void mo18754a(String str) {
        this.f7490a = str;
    }

    /* renamed from: b */
    public boolean mo18757b() {
        return this.f7491b;
    }

    /* renamed from: a */
    public void mo18755a(boolean z) {
        this.f7491b = z;
    }

    /* renamed from: c */
    public boolean mo18758c() {
        return this.f7492c;
    }

    /* renamed from: b */
    public void mo18756b(boolean z) {
        this.f7492c = z;
    }

    /* renamed from: d */
    public int mo18759d() {
        return this.f7493d;
    }

    /* renamed from: a */
    public void mo18753a(int i) {
        this.f7493d = i;
    }
}
