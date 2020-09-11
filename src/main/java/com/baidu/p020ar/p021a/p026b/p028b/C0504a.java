package com.baidu.p020ar.p021a.p026b.p028b;

import android.os.Bundle;
import android.util.Log;
import com.baidu.p020ar.p021a.p022a.p023a.C0491b;
import com.baidu.p020ar.p021a.p026b.p027a.C0499a;
import com.baidu.p020ar.p021a.p026b.p027a.C0500b;

/* renamed from: com.baidu.ar.a.b.b.a */
public class C0504a extends C0500b {

    /* renamed from: e */
    C0491b f611e;

    public C0504a(byte[] bArr, int i, int i2, C0491b bVar, C0499a aVar, int i3) {
        super(bArr, i, i2, aVar, i3);
        this.f611e = bVar;
    }

    /* renamed from: b */
    public void mo8962b() {
        if (this.f611e != null) {
            Log.d("PaddleRunnable", "bdar: PaddleRunnable algo");
            Bundle a = this.f611e.mo8929a(mo8963c(), this.f594a, this.f595b);
            if (this.f596c != null) {
                this.f596c.mo8959a(a);
            }
        }
    }
}
