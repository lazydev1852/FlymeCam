package com.baidu.p020ar.imgseg;

import android.util.Log;

/* renamed from: com.baidu.ar.imgseg.a */
public class C0766a {

    /* renamed from: a */
    private static C0766a f1681a;

    /* renamed from: b */
    private ImgSegJniClient f1682b = new ImgSegJniClient();

    /* renamed from: c */
    private boolean f1683c = false;

    private C0766a() {
    }

    /* renamed from: a */
    public static synchronized C0766a m1990a() {
        C0766a aVar;
        synchronized (C0766a.class) {
            if (f1681a == null) {
                f1681a = new C0766a();
            }
            aVar = f1681a;
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo10114a(byte[] bArr, int i, int i2, int i3, int i4, float[] fArr, float[] fArr2, int i5, int i6, float[] fArr3) {
        if (this.f1682b != null) {
            ImgSegJniClient imgSegJniClient = this.f1682b;
            if (ImgSegJniClient.imgPreProcess(bArr, i, i2, i3, i4, fArr, fArr2, i5, i6, fArr3) == 0) {
                this.f1683c = false;
            }
        }
    }

    /* renamed from: a */
    public void mo10115a(byte[] bArr, float[] fArr, int i, int i2, int i3, int i4, float f, float f2, byte[] bArr2) {
        if (this.f1682b != null) {
            ImgSegJniClient imgSegJniClient = this.f1682b;
            if (ImgSegJniClient.imgSegPostProcess(bArr, fArr, i, i2, i3, i4, f, f2, bArr2) == 0) {
                this.f1683c = false;
            }
        }
    }

    /* renamed from: b */
    public void mo10116b() {
        String str;
        String str2;
        if (this.f1682b != null && !this.f1683c) {
            ImgSegJniClient imgSegJniClient = this.f1682b;
            if (ImgSegJniClient.release() == 0) {
                this.f1683c = true;
                str = "ImgSeg";
                str2 = "model release success!";
            } else {
                str = "ImgSeg";
                str2 = "model release fail!";
            }
            Log.e(str, str2);
        }
        this.f1682b = null;
        f1681a = null;
    }
}
