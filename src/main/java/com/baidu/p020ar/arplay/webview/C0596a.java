package com.baidu.p020ar.arplay.webview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;

/* renamed from: com.baidu.ar.arplay.webview.a */
public class C0596a {

    /* renamed from: b */
    private static final String f947b = "a";

    /* renamed from: a */
    public int f948a;

    /* renamed from: c */
    private int f949c = 500;

    /* renamed from: d */
    private int f950d = 500;

    /* renamed from: e */
    private Surface f951e;

    /* renamed from: f */
    private Canvas f952f;

    /* renamed from: g */
    private SurfaceTexture f953g;

    /* renamed from: h */
    private boolean f954h = true;

    /* renamed from: a */
    public Surface mo9423a(int i, int i2, int i3) {
        this.f948a = i;
        this.f953g = new SurfaceTexture(i);
        mo9425a(i2, i3);
        this.f951e = new Surface(this.f953g);
        return this.f951e;
    }

    /* renamed from: a */
    public void mo9424a() {
        try {
            this.f953g.updateTexImage();
        } catch (Exception e) {
            String str = f947b;
            Log.e(str, "error while update view to gl: " + e);
        }
    }

    /* renamed from: a */
    public void mo9425a(int i, int i2) {
        this.f949c = i;
        this.f950d = i2;
        this.f953g.setDefaultBufferSize(this.f949c, this.f950d);
    }

    /* renamed from: b */
    public Canvas mo9426b() {
        this.f952f = null;
        if (this.f951e != null) {
            try {
                this.f952f = this.f951e.lockCanvas((Rect) null);
            } catch (Exception e) {
                String str = f947b;
                Log.e(str, "error while rendering view to gl: " + e);
            }
        }
        return this.f952f;
    }

    /* renamed from: c */
    public void mo9427c() {
        if (this.f952f != null) {
            this.f951e.unlockCanvasAndPost(this.f952f);
        }
        this.f952f = null;
    }

    /* renamed from: d */
    public void mo9428d() {
        if (this.f951e != null) {
            this.f951e.release();
        }
        if (this.f953g != null) {
            this.f953g.release();
        }
        this.f951e = null;
        this.f953g = null;
    }
}
