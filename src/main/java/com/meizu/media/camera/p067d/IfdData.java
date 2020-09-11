package com.meizu.media.camera.p067d;

import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.media.camera.d.i */
public class IfdData {

    /* renamed from: a */
    public static ChangeQuickRedirect f9473a;

    /* renamed from: e */
    private static final int[] f9474e = {0, 1, 2, 3, 4};

    /* renamed from: b */
    private final int f9475b;

    /* renamed from: c */
    private final Map<Short, ExifTag> f9476c = new HashMap();

    /* renamed from: d */
    private int f9477d = 0;

    IfdData(int i) {
        this.f9475b = i;
    }

    /* renamed from: a */
    public static int[] m9959a() {
        return f9474e;
    }

    /* renamed from: b */
    public ExifTag[] mo19945b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9473a, false, ARPMessageType.MSG_TYPE_DEVICE_ORIENTATION, new Class[0], ExifTag[].class);
        return proxy.isSupported ? (ExifTag[]) proxy.result : (ExifTag[]) this.f9476c.values().toArray(new ExifTag[this.f9476c.size()]);
    }

    /* renamed from: c */
    public int mo19946c() {
        return this.f9475b;
    }

    /* renamed from: a */
    public ExifTag mo19942a(short s) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Short(s)}, this, f9473a, false, 4002, new Class[]{Short.TYPE}, ExifTag.class);
        return proxy.isSupported ? (ExifTag) proxy.result : this.f9476c.get(Short.valueOf(s));
    }

    /* renamed from: a */
    public ExifTag mo19941a(ExifTag hVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hVar}, this, f9473a, false, 4003, new Class[]{ExifTag.class}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        hVar.mo19920b(this.f9475b);
        return this.f9476c.put(Short.valueOf(hVar.mo19919b()), hVar);
    }

    /* renamed from: b */
    public void mo19944b(short s) {
        Object[] objArr = {new Short(s)};
        ChangeQuickRedirect changeQuickRedirect = f9473a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4005, new Class[]{Short.TYPE}, Void.TYPE).isSupported) {
            this.f9476c.remove(Short.valueOf(s));
        }
    }

    /* renamed from: d */
    public int mo19947d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9473a, false, 4006, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f9476c.size();
    }

    /* renamed from: a */
    public void mo19943a(int i) {
        this.f9477d = i;
    }

    /* renamed from: e */
    public int mo19948e() {
        return this.f9477d;
    }

    public boolean equals(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f9473a, false, 4007, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof IfdData)) {
            IfdData iVar = (IfdData) obj;
            if (iVar.mo19946c() == this.f9475b && iVar.mo19947d() == mo19947d()) {
                for (ExifTag hVar : iVar.mo19945b()) {
                    if (!ExifInterface.m9822a(hVar.mo19919b()) && !hVar.equals(this.f9476c.get(Short.valueOf(hVar.mo19919b())))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
