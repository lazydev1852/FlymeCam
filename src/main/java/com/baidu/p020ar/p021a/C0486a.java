package com.baidu.p020ar.p021a;

import com.baidu.p020ar.p021a.p022a.p023a.C0491b;
import com.baidu.p020ar.p021a.p022a.p024b.C0494b;
import com.baidu.p020ar.p021a.p022a.p025c.C0497b;
import com.baidu.p020ar.p021a.p026b.p027a.C0499a;
import com.baidu.p020ar.p021a.p026b.p027a.C0501c;
import com.baidu.p020ar.p021a.p026b.p028b.C0504a;
import com.baidu.p020ar.p021a.p026b.p029c.C0505a;
import com.baidu.p020ar.p021a.p026b.p030d.C0506a;

/* renamed from: com.baidu.ar.a.a */
public final class C0486a {
    /* renamed from: a */
    public static int m831a(String str, int i, int i2, float[] fArr, int i3, C0494b bVar) {
        if (bVar == null) {
            return -1;
        }
        return bVar.mo8943a(str, i, i2, fArr, (float) i3);
    }

    /* renamed from: a */
    public static void m832a() {
        C0501c a = C0501c.m896a();
        if (a != null) {
            a.mo8970b();
        }
        C0501c.m899c();
    }

    /* renamed from: a */
    public static void m833a(int i, int i2, int i3) {
        C0501c.m897a(i, i2, i3);
    }

    /* renamed from: a */
    public static void m834a(C0491b bVar) {
        if (bVar != null) {
            bVar.mo8937b();
        }
    }

    /* renamed from: a */
    public static void m835a(C0494b bVar) {
        if (bVar != null) {
            bVar.mo8946a();
        }
    }

    /* renamed from: a */
    public static void m836a(C0494b bVar, C0494b.C0495a aVar) {
        if (bVar != null) {
            bVar.mo8945a(aVar);
        }
    }

    /* renamed from: a */
    public static void m837a(C0497b bVar) {
        if (bVar != null) {
            bVar.mo8958a();
        }
    }

    /* renamed from: a */
    public static void m838a(byte[] bArr, int i, int i2, C0491b bVar, C0499a aVar, int i3) {
        C0501c a = C0501c.m896a();
        if (a != null) {
            a.mo8968a((Runnable) new C0504a(bArr, i, i2, bVar, aVar, i3));
        }
    }

    /* renamed from: a */
    public static void m839a(byte[] bArr, int i, int i2, C0494b bVar, C0499a aVar) {
        C0501c a = C0501c.m896a();
        if (a != null) {
            a.mo8968a((Runnable) new C0505a(bArr, i, i2, bVar, aVar));
        }
    }

    /* renamed from: a */
    public static void m840a(byte[] bArr, int i, int i2, C0497b bVar, C0499a aVar) {
        C0501c a = C0501c.m896a();
        if (a != null) {
            a.mo8968a((Runnable) new C0506a(bArr, i, i2, bVar, aVar));
        }
    }

    /* renamed from: a */
    public static float[] m841a(float f, float[] fArr, C0494b bVar) {
        return bVar != null ? bVar.mo8947a(f, fArr) : new float[0];
    }

    /* renamed from: b */
    public static void m842b(C0494b bVar) {
        if (bVar != null) {
            bVar.mo8949c();
        }
    }

    /* renamed from: c */
    public static int m843c(C0494b bVar) {
        if (bVar != null) {
            return bVar.mo8950d();
        }
        return -1;
    }
}
