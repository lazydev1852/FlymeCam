package com.meizu.media.camera.util;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.aj */
public class PostParameter implements Comparable<PostParameter> {

    /* renamed from: a */
    public static ChangeQuickRedirect f14101a;

    /* renamed from: b */
    private String f14102b = null;

    /* renamed from: c */
    private String f14103c = null;

    /* renamed from: d */
    private String f14104d = null;

    /* renamed from: a */
    public String mo22670a() {
        return this.f14102b;
    }

    /* renamed from: b */
    public String mo22671b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14101a, false, 8166, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return C2644av.m16105a(this.f14104d) ? this.f14103c : this.f14104d;
    }

    public int hashCode() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14101a, false, 8167, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return (this.f14102b.hashCode() * 31) + this.f14103c.hashCode();
    }

    public boolean equals(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f14101a, false, 8168, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostParameter)) {
            return false;
        }
        PostParameter ajVar = (PostParameter) obj;
        if (!this.f14102b.equals(ajVar.f14102b) || !this.f14103c.equals(ajVar.f14103c)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(PostParameter ajVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{ajVar}, this, f14101a, false, 8169, new Class[]{PostParameter.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int compareTo = this.f14102b.compareTo(ajVar.f14102b);
        return compareTo == 0 ? this.f14103c.compareTo(ajVar.f14103c) : compareTo;
    }
}
