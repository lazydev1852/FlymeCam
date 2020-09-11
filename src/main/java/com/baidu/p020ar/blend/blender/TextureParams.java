package com.baidu.p020ar.blend.blender;

import android.opengl.Matrix;

/* renamed from: com.baidu.ar.blend.blender.TextureParams */
public class TextureParams {

    /* renamed from: a */
    public float f1210a = 0.0f;

    /* renamed from: b */
    public float f1211b = 0.0f;

    /* renamed from: c */
    private boolean f1212c = true;

    /* renamed from: d */
    private VideoRenderMode f1213d = VideoRenderMode.BG;

    /* renamed from: e */
    private boolean f1214e = true;

    /* renamed from: f */
    private boolean f1215f = true;

    /* renamed from: g */
    private float f1216g = 0.0f;

    /* renamed from: h */
    private int f1217h = 0;

    /* renamed from: i */
    private float f1218i = 0.0f;

    /* renamed from: j */
    private float f1219j = 1.0f;

    /* renamed from: k */
    private float f1220k = 1.0f;

    /* renamed from: l */
    private SourceType f1221l = SourceType.SURFACE_TEXTURE;

    /* renamed from: m */
    private final float[] f1222m = new float[16];

    /* renamed from: n */
    private final float[] f1223n = new float[16];

    /* renamed from: o */
    private boolean f1224o = true;

    /* renamed from: p */
    private boolean f1225p = true;

    /* renamed from: q */
    private float f1226q = 1.0f;

    /* renamed from: r */
    private int f1227r;

    /* renamed from: s */
    private int f1228s;

    /* renamed from: com.baidu.ar.blend.blender.TextureParams$SourceType */
    public enum SourceType {
        NONE("none"),
        SURFACE_TEXTURE("surfacetexture"),
        YUV_DATA("yuv"),
        IM("im");
        
        private final String mValue;

        private SourceType(String str) {
            this.mValue = str;
        }
    }

    /* renamed from: com.baidu.ar.blend.blender.TextureParams$VideoRenderMode */
    public enum VideoRenderMode {
        NONE(0),
        BG(1),
        FG(2);
        
        private final int mValue;

        private VideoRenderMode(int i) {
            this.mValue = i;
        }

        /* renamed from: a */
        public static VideoRenderMode m1475a(int i) {
            for (VideoRenderMode videoRenderMode : values()) {
                if (videoRenderMode.mo9788a() == i) {
                    return videoRenderMode;
                }
            }
            return NONE;
        }

        /* renamed from: a */
        public int mo9788a() {
            return this.mValue;
        }
    }

    /* renamed from: a */
    private void m1455a(float[] fArr, int i, float f, float f2, float f3, float f4, float f5) {
        int i2;
        float f6;
        float f7;
        float f8;
        float[] fArr2 = fArr;
        int i3 = i;
        float f9 = f4;
        float f10 = f5;
        Matrix.setIdentityM(fArr, 0);
        if (i3 == 1) {
            i2 = 0;
            f6 = 180.0f;
            f7 = 0.0f;
            f8 = 1.0f;
        } else {
            if (i3 == 2) {
                i2 = 0;
                f6 = 180.0f;
                f7 = 1.0f;
                f8 = 0.0f;
            }
            Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
            if (!(Float.compare(f9, 0.0f) == 0 && Float.compare(f10, 0.0f) == 0)) {
                Matrix.translateM(fArr, 0, f9, f10, 0.0f);
            }
            float f11 = f2;
            float f12 = f3;
            Matrix.scaleM(fArr, 0, f2, f3, 1.0f);
        }
        Matrix.rotateM(fArr, i2, f6, f7, f8, 0.0f);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        Matrix.translateM(fArr, 0, f9, f10, 0.0f);
        float f112 = f2;
        float f122 = f3;
        Matrix.scaleM(fArr, 0, f2, f3, 1.0f);
    }

    /* renamed from: a */
    public void mo9769a(float f) {
        this.f1226q = f;
    }

    /* renamed from: a */
    public void mo9770a(int i, float f, float f2, float f3, float f4, float f5) {
        m1455a(this.f1223n, i, f, f2, f3, f4, f5);
    }

    /* renamed from: a */
    public void mo9771a(int i, float f, float f2, float f3, float f4, float f5, SourceType sourceType) {
        this.f1217h = i;
        this.f1218i = f;
        this.f1219j = f2;
        this.f1220k = f3;
        this.f1221l = sourceType;
        this.f1210a = f4;
        this.f1211b = f5;
        m1455a(this.f1222m, i, f, f2, f3, f4, f5);
    }

    /* renamed from: a */
    public void mo9772a(int i, int i2) {
        this.f1227r = i;
        this.f1228s = i2;
    }

    /* renamed from: a */
    public void mo9773a(VideoRenderMode videoRenderMode) {
        this.f1213d = videoRenderMode;
    }

    /* renamed from: a */
    public void mo9774a(boolean z) {
        this.f1212c = z;
    }

    /* renamed from: a */
    public void mo9775a(boolean z, float f) {
        this.f1215f = z;
        this.f1216g = f;
    }

    /* renamed from: a */
    public boolean mo9776a() {
        return this.f1212c;
    }

    /* renamed from: b */
    public int mo9777b() {
        return this.f1227r;
    }

    /* renamed from: c */
    public int mo9778c() {
        return this.f1228s;
    }

    /* renamed from: d */
    public float[] mo9779d() {
        return this.f1222m;
    }

    /* renamed from: e */
    public VideoRenderMode mo9780e() {
        return this.f1213d;
    }

    /* renamed from: f */
    public boolean mo9781f() {
        return this.f1215f;
    }

    /* renamed from: g */
    public float mo9782g() {
        return this.f1216g;
    }

    /* renamed from: h */
    public SourceType mo9783h() {
        return this.f1221l;
    }

    /* renamed from: i */
    public float mo9784i() {
        return this.f1226q;
    }

    /* renamed from: j */
    public float[] mo9785j() {
        return this.f1223n;
    }

    /* renamed from: k */
    public boolean mo9786k() {
        return this.f1224o;
    }

    /* renamed from: l */
    public boolean mo9787l() {
        return this.f1225p;
    }
}
