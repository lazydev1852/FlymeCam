package com.meizu.media.camera.barcode.result;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.barcode.result.r */
public class UrlAppPkgInfo {

    /* renamed from: a */
    public static ChangeQuickRedirect f8168a;

    /* renamed from: b */
    private String f8169b;

    /* renamed from: c */
    private boolean f8170c;

    /* renamed from: d */
    private int f8171d;

    /* renamed from: e */
    private boolean f8172e;

    /* renamed from: a */
    public String mo19304a() {
        return this.f8169b;
    }

    /* renamed from: a */
    public void mo19306a(String str) {
        this.f8169b = str;
    }

    /* renamed from: a */
    public void mo19307a(boolean z) {
        this.f8172e = z;
    }

    /* renamed from: b */
    public boolean mo19309b() {
        return this.f8170c;
    }

    /* renamed from: b */
    public void mo19308b(boolean z) {
        this.f8170c = z;
    }

    /* renamed from: c */
    public int mo19310c() {
        return this.f8171d;
    }

    /* renamed from: a */
    public void mo19305a(int i) {
        this.f8171d = i;
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8168a, false, 2714, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "UrlAppPkgInfo{packageName='" + this.f8169b + '\'' + ", openByInternalBrowser=" + this.f8172e + ", needMimeType=" + this.f8170c + ", priority=" + this.f8171d + '}';
    }
}
