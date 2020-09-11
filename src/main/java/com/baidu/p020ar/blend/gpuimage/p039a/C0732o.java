package com.baidu.p020ar.blend.gpuimage.p039a;

/* renamed from: com.baidu.ar.blend.gpuimage.a.o */
public class C0732o extends C0706b {

    /* renamed from: l */
    private float f1558l;

    /* renamed from: b */
    public void mo10046b(float f) {
        this.f1558l = f;
        float f2 = this.f1558l;
        float f3 = 1.0f - f2;
        float f4 = 0.213f * f3;
        float f5 = 0.715f * f3;
        float f6 = f3 * 0.072f;
        System.arraycopy(new float[]{f4 + f2, f5, f6, 0.0f, f4, f5 + f2, f6, 0.0f, f4, f5, f6 + f2, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0, this.f1474a, 0, 16);
        mo9984a(this.f1474a);
    }
}
