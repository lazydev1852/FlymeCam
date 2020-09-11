package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.Matrix;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;

/* renamed from: com.baidu.ar.blend.gpuimage.a.k */
public class C0728k extends C0706b {
    public C0728k() {
        this.f1474a = (float[]) C0749a.f1635a.clone();
    }

    /* renamed from: a */
    private void m1845a(float[] fArr, float f) {
        float f2 = 1.0f - f;
        float f3 = 0.3f * f2;
        float f4 = 0.59f * f2;
        float f5 = f2 * 0.11f;
        m1847a(new float[]{f3 + f, f3, f3, 0.0f, f4, f4 + f, f4, 0.0f, f5, f5, f + f5, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, (float[]) fArr.clone(), fArr);
    }

    /* renamed from: a */
    private void m1846a(float[] fArr, float[] fArr2) {
        fArr[0] = fArr2[0];
        fArr[5] = fArr2[1];
        fArr[10] = fArr2[2];
    }

    /* renamed from: a */
    private void m1847a(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
    }

    /* renamed from: b */
    private void m1848b(float[] fArr, float f) {
        Matrix.rotateM(fArr, 0, f, 0.3f, 0.59f, 0.11f);
    }

    /* renamed from: m */
    private void m1849m() {
        mo9984a(this.f1474a);
    }

    /* renamed from: b */
    public void mo10036b(float f) {
        m1848b(this.f1474a, f);
        m1849m();
    }

    /* renamed from: c */
    public void mo10037c(float f) {
        m1845a(this.f1474a, f);
        m1849m();
    }

    /* renamed from: d */
    public void mo10038d(float f) {
        m1846a(this.f1474a, new float[]{f, f, f});
        m1849m();
    }
}
