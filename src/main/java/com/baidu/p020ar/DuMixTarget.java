package com.baidu.p020ar;

import android.graphics.SurfaceTexture;

/* renamed from: com.baidu.ar.DuMixTarget */
public class DuMixTarget {

    /* renamed from: a */
    private SurfaceTexture f494a;

    /* renamed from: b */
    private SurfaceTexture.OnFrameAvailableListener f495b;

    /* renamed from: c */
    private int f496c;

    /* renamed from: d */
    private int f497d;

    /* renamed from: e */
    private ScaleType f498e;

    /* renamed from: f */
    private boolean f499f;

    /* renamed from: com.baidu.ar.DuMixTarget$ScaleType */
    public enum ScaleType {
        MATRIX,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public DuMixTarget(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z) {
        this.f494a = surfaceTexture;
        this.f495b = onFrameAvailableListener;
        this.f496c = i;
        this.f497d = i2;
        this.f499f = z;
    }

    public SurfaceTexture getDrawTarget() {
        return this.f494a;
    }

    public ScaleType getScaleType() {
        return this.f498e;
    }

    public SurfaceTexture.OnFrameAvailableListener getTargetFrameAvailableListener() {
        return this.f495b;
    }

    public int getTargetHeight() {
        return this.f497d;
    }

    public int getTargetWidth() {
        return this.f496c;
    }

    public boolean isDrawPreview() {
        return this.f499f;
    }

    public void setDrawPreview(boolean z) {
        this.f499f = z;
    }

    public void setDrawTarget(SurfaceTexture surfaceTexture) {
        this.f494a = surfaceTexture;
    }

    public void setScaleType(ScaleType scaleType) {
        this.f498e = scaleType;
    }

    public void setTargetFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.f495b = onFrameAvailableListener;
    }

    public void setTargetHeight(int i) {
        this.f497d = i;
    }

    public void setTargetWidth(int i) {
        this.f496c = i;
    }
}
