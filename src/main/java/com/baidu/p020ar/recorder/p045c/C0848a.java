package com.baidu.p020ar.recorder.p045c;

import com.baidu.p020ar.recorder.p047e.C0856a;
import com.baidu.p020ar.recorder.p047e.C0859d;
import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.recorder.c.a */
public class C0848a extends C0856a {

    /* renamed from: g */
    private static final float[] f2079g = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: h */
    private static final float[] f2080h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: i */
    private static final FloatBuffer f2081i = C0859d.m2466a(f2079g);

    /* renamed from: j */
    private static final FloatBuffer f2082j = C0859d.m2466a(f2080h);

    public C0848a() {
        this.f2117a = f2081i;
        this.f2118b = f2082j;
        this.f2120d = 2;
        this.f2121e = this.f2120d * 4;
        this.f2119c = f2079g.length / this.f2120d;
        this.f2122f = 8;
    }
}
