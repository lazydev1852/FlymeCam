package com.baidu.p020ar.blend.gpuimage.graphics;

import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.blend.gpuimage.graphics.Drawable2d */
public class Drawable2d {

    /* renamed from: a */
    public static final FloatBuffer f1606a = C0749a.m1939a(f1618m);

    /* renamed from: b */
    public static final FloatBuffer f1607b = C0749a.m1939a(f1619n);

    /* renamed from: c */
    public static final FloatBuffer f1608c = C0749a.m1939a(f1620o);

    /* renamed from: d */
    public static final FloatBuffer f1609d = C0749a.m1939a(f1621p);

    /* renamed from: e */
    private static final float[] f1610e = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};

    /* renamed from: f */
    private static final float[] f1611f = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: g */
    private static final FloatBuffer f1612g = C0749a.m1939a(f1610e);

    /* renamed from: h */
    private static final FloatBuffer f1613h = C0749a.m1939a(f1611f);

    /* renamed from: i */
    private static final float[] f1614i = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};

    /* renamed from: j */
    private static final float[] f1615j = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: k */
    private static final FloatBuffer f1616k = C0749a.m1939a(f1614i);

    /* renamed from: l */
    private static final FloatBuffer f1617l = C0749a.m1939a(f1615j);

    /* renamed from: m */
    private static final float[] f1618m = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: n */
    private static final float[] f1619n = {1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};

    /* renamed from: o */
    private static final float[] f1620o = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: p */
    private static final float[] f1621p = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: q */
    private FloatBuffer f1622q;

    /* renamed from: r */
    private FloatBuffer f1623r;

    /* renamed from: s */
    private int f1624s;

    /* renamed from: t */
    private int f1625t;

    /* renamed from: u */
    private int f1626u;

    /* renamed from: v */
    private int f1627v;

    /* renamed from: w */
    private Prefab f1628w;

    /* renamed from: com.baidu.ar.blend.gpuimage.graphics.Drawable2d$Prefab */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE,
        FULL_RECTANGLE_MIRRORED
    }

    public Drawable2d(Prefab prefab) {
        int i;
        switch (prefab) {
            case TRIANGLE:
                this.f1622q = f1612g;
                this.f1623r = f1613h;
                this.f1625t = 2;
                this.f1626u = this.f1625t * 4;
                i = f1610e.length;
                break;
            case RECTANGLE:
                this.f1622q = f1616k;
                this.f1623r = f1617l;
                this.f1625t = 2;
                this.f1626u = this.f1625t * 4;
                i = f1614i.length;
                break;
            case FULL_RECTANGLE:
                this.f1622q = f1606a;
                this.f1623r = f1608c;
                this.f1625t = 2;
                this.f1626u = this.f1625t * 4;
                i = f1618m.length;
                break;
            case FULL_RECTANGLE_MIRRORED:
                this.f1622q = f1607b;
                this.f1623r = f1608c;
                this.f1625t = 2;
                this.f1626u = this.f1625t * 4;
                i = f1618m.length;
                break;
            default:
                throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f1624s = i / this.f1625t;
        this.f1627v = 8;
        this.f1628w = prefab;
    }

    /* renamed from: a */
    public FloatBuffer mo10069a() {
        return this.f1622q;
    }

    /* renamed from: b */
    public FloatBuffer mo10070b() {
        return this.f1623r;
    }

    public String toString() {
        if (this.f1628w == null) {
            return "[Drawable2d: ...]";
        }
        return "[Drawable2d: " + this.f1628w + "]";
    }
}
