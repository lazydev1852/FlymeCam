package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.blend.gpuimage.a.v */
public class C0744v extends C0712g {

    /* renamed from: l */
    private static final float[] f1591l = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: a */
    private FloatBuffer f1592a = C0749a.m1939a(f1591l);

    /* renamed from: a */
    public void mo10064a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5) {
        final int i6 = i5;
        final ByteBuffer byteBuffer2 = byteBuffer;
        final int i7 = i;
        final int i8 = i2;
        final int i9 = i3;
        final int i10 = i4;
        mo9992a((Runnable) new Runnable() {
            public void run() {
                GLES20.glActiveTexture(33984);
                if (i6 != -1) {
                    C0749a.m1938a(byteBuffer2, i7, i8, i9, i10, i6);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo10065a(boolean z, float f) {
        FloatBuffer floatBuffer;
        float[] fArr;
        int length;
        if (z) {
            f1591l[0] = f;
            f1591l[1] = 0.0f;
            float f2 = 1.0f - f;
            f1591l[2] = f2;
            f1591l[3] = 0.0f;
            f1591l[4] = f;
            f1591l[5] = 1.0f;
            f1591l[6] = f2;
            f1591l[7] = 1.0f;
            this.f1592a.position(0);
            floatBuffer = this.f1592a;
            fArr = f1591l;
            length = f1591l.length;
        } else {
            f1591l[0] = 0.0f;
            f1591l[1] = f;
            f1591l[2] = 1.0f;
            f1591l[3] = f;
            f1591l[4] = 0.0f;
            float f3 = 1.0f - f;
            f1591l[5] = f3;
            f1591l[6] = 1.0f;
            f1591l[7] = f3;
            this.f1592a.position(0);
            floatBuffer = this.f1592a;
            fArr = f1591l;
            length = f1591l.length;
        }
        floatBuffer.put(fArr, 0, length);
        this.f1592a.position(0);
    }

    /* renamed from: m */
    public void mo10030m() {
        this.f1494k = this.f1485b.mo10070b();
    }

    /* renamed from: n */
    public void mo10066n() {
        this.f1494k = this.f1592a;
    }
}
