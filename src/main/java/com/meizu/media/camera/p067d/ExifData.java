package com.meizu.media.camera.p067d;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.meizu.media.camera.d.b */
public class ExifData {

    /* renamed from: a */
    public static ChangeQuickRedirect f9281a;

    /* renamed from: b */
    private static final byte[] f9282b = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: c */
    private static final byte[] f9283c = {74, 73, 83, 0, 0, 0, 0, 0};

    /* renamed from: d */
    private static final byte[] f9284d = {85, 78, 73, 67, 79, 68, 69, 0};

    /* renamed from: e */
    private final IfdData[] f9285e = new IfdData[5];

    /* renamed from: f */
    private byte[] f9286f;

    /* renamed from: g */
    private ArrayList<byte[]> f9287g = new ArrayList<>();

    /* renamed from: h */
    private final ByteOrder f9288h;

    ExifData(ByteOrder byteOrder) {
        this.f9288h = byteOrder;
    }

    /* renamed from: a */
    public byte[] mo19830a() {
        return this.f9286f;
    }

    /* renamed from: a */
    public void mo19829a(byte[] bArr) {
        this.f9286f = bArr;
    }

    /* renamed from: b */
    public boolean mo19834b() {
        return this.f9286f != null;
    }

    /* renamed from: a */
    public void mo19827a(int i, byte[] bArr) {
        Object[] objArr = {new Integer(i), bArr};
        ChangeQuickRedirect changeQuickRedirect = f9281a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3807, new Class[]{Integer.TYPE, byte[].class}, Void.TYPE).isSupported) {
            if (i < this.f9287g.size()) {
                this.f9287g.set(i, bArr);
                return;
            }
            for (int size = this.f9287g.size(); size < i; size++) {
                this.f9287g.add((Object) null);
            }
            this.f9287g.add(bArr);
        }
    }

    /* renamed from: c */
    public int mo19835c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9281a, false, 3808, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f9287g.size();
    }

    /* renamed from: a */
    public byte[] mo19831a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9281a, false, 3809, new Class[]{Integer.TYPE}, byte[].class);
        return proxy.isSupported ? (byte[]) proxy.result : this.f9287g.get(i);
    }

    /* renamed from: d */
    public boolean mo19837d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9281a, false, 3810, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f9287g.size() != 0;
    }

    /* renamed from: e */
    public ByteOrder mo19838e() {
        return this.f9288h;
    }

    /* renamed from: b */
    public IfdData mo19832b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9281a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3811, new Class[]{Integer.TYPE}, IfdData.class);
        if (proxy.isSupported) {
            return (IfdData) proxy.result;
        }
        if (ExifTag.m9917a(i)) {
            return this.f9285e[i];
        }
        return null;
    }

    /* renamed from: a */
    public void mo19828a(IfdData iVar) {
        if (!PatchProxy.proxy(new Object[]{iVar}, this, f9281a, false, 3812, new Class[]{IfdData.class}, Void.TYPE).isSupported) {
            this.f9285e[iVar.mo19946c()] = iVar;
        }
    }

    /* renamed from: c */
    public IfdData mo19836c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9281a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3813, new Class[]{Integer.TYPE}, IfdData.class);
        if (proxy.isSupported) {
            return (IfdData) proxy.result;
        }
        IfdData iVar = this.f9285e[i];
        if (iVar != null) {
            return iVar;
        }
        IfdData iVar2 = new IfdData(i);
        this.f9285e[i] = iVar2;
        return iVar2;
    }

    /* renamed from: a */
    public ExifTag mo19826a(short s, int i) {
        Object[] objArr = {new Short(s), new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9281a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3814, new Class[]{Short.TYPE, Integer.TYPE}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        IfdData iVar = this.f9285e[i];
        if (iVar == null) {
            return null;
        }
        return iVar.mo19942a(s);
    }

    /* renamed from: a */
    public ExifTag mo19824a(ExifTag hVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hVar}, this, f9281a, false, 3815, new Class[]{ExifTag.class}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        if (hVar != null) {
            return mo19825a(hVar, hVar.mo19907a());
        }
        return null;
    }

    /* renamed from: a */
    public ExifTag mo19825a(ExifTag hVar, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hVar, new Integer(i)}, this, f9281a, false, 3816, new Class[]{ExifTag.class, Integer.TYPE}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        if (hVar == null || !ExifTag.m9917a(i)) {
            return null;
        }
        return mo19836c(i).mo19941a(hVar);
    }

    /* renamed from: f */
    public void mo19840f() {
        if (!PatchProxy.proxy(new Object[0], this, f9281a, false, 3817, new Class[0], Void.TYPE).isSupported) {
            this.f9286f = null;
            this.f9287g.clear();
        }
    }

    /* renamed from: b */
    public void mo19833b(short s, int i) {
        IfdData iVar;
        Object[] objArr = {new Short(s), new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9281a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3819, new Class[]{Short.TYPE, Integer.TYPE}, Void.TYPE).isSupported && (iVar = this.f9285e[i]) != null) {
            iVar.mo19944b(s);
        }
    }

    /* renamed from: g */
    public List<ExifTag> mo19841g() {
        ExifTag[] b;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9281a, false, 3821, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        for (IfdData iVar : this.f9285e) {
            if (!(iVar == null || (b = iVar.mo19945b()) == null)) {
                Collections.addAll(arrayList, b);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f9281a, false, 3824, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ExifData)) {
            return false;
        }
        ExifData bVar = (ExifData) obj;
        if (bVar.f9288h != this.f9288h || bVar.f9287g.size() != this.f9287g.size() || !Arrays.equals(bVar.f9286f, this.f9286f)) {
            return false;
        }
        for (int i = 0; i < this.f9287g.size(); i++) {
            if (!Arrays.equals(bVar.f9287g.get(i), this.f9287g.get(i))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < 5; i2++) {
            IfdData b = bVar.mo19832b(i2);
            IfdData b2 = mo19832b(i2);
            if (b != b2 && b != null && !b.equals(b2)) {
                return false;
            }
        }
        return true;
    }
}
