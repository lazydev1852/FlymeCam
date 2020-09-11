package com.baidu.p020ar;

import android.graphics.SurfaceTexture;

/* renamed from: com.baidu.ar.DuMixSource */
public class DuMixSource {

    /* renamed from: a */
    private String f485a;

    /* renamed from: b */
    private int f486b = -1;

    /* renamed from: c */
    private String f487c = "";

    /* renamed from: d */
    private boolean f488d = false;

    /* renamed from: e */
    private SurfaceTexture f489e;

    /* renamed from: f */
    private int f490f = 0;

    /* renamed from: g */
    private int f491g = 0;

    /* renamed from: h */
    private String f492h;

    /* renamed from: i */
    private String f493i;

    public DuMixSource(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f489e = surfaceTexture;
        this.f490f = i;
        this.f491g = i2;
    }

    public DuMixSource clone() {
        try {
            return (DuMixSource) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getArKey() {
        return this.f485a;
    }

    public int getArType() {
        return this.f486b;
    }

    public SurfaceTexture getCameraSource() {
        return this.f489e;
    }

    public String getFilterConfigPath() {
        return this.f492h;
    }

    public String getFilterResPath() {
        return this.f493i;
    }

    public String getResFilePath() {
        return this.f487c;
    }

    public int getSourceHeight() {
        return this.f491g;
    }

    public int getSourceWidth() {
        return this.f490f;
    }

    public boolean isFrontCamera() {
        return this.f488d;
    }

    public void setArKey(String str) {
        this.f485a = str;
    }

    public void setArType(int i) {
        this.f486b = i;
    }

    public void setCameraSource(SurfaceTexture surfaceTexture) {
        this.f489e = surfaceTexture;
    }

    public void setFilterConfigPath(String str) {
        this.f492h = str;
    }

    public void setFilterResPath(String str) {
        this.f493i = str;
    }

    public void setFrontCamera(boolean z) {
        this.f488d = z;
    }

    public void setResFilePath(String str) {
        this.f487c = str;
    }

    public void setSourceHeight(int i) {
        this.f491g = i;
    }

    public void setSourceWidth(int i) {
        this.f490f = i;
    }
}
