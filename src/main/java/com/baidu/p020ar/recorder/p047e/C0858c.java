package com.baidu.p020ar.recorder.p047e;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;

/* renamed from: com.baidu.ar.recorder.e.c */
public class C0858c {

    /* renamed from: a */
    protected static final String f2128a = "c";

    /* renamed from: b */
    protected C0857b f2129b;

    /* renamed from: c */
    private EGLSurface f2130c = EGL14.EGL_NO_SURFACE;

    /* renamed from: d */
    private int f2131d = -1;

    /* renamed from: e */
    private int f2132e = -1;

    protected C0858c(C0857b bVar) {
        this.f2129b = bVar;
    }

    /* renamed from: a */
    public void mo10523a(long j) {
        this.f2129b.mo10518a(this.f2130c, j);
    }

    /* renamed from: a */
    public void mo10524a(Object obj) {
        if (this.f2130c == EGL14.EGL_NO_SURFACE) {
            this.f2130c = this.f2129b.mo10515a(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    /* renamed from: b */
    public void mo10525b() {
        this.f2129b.mo10517a(this.f2130c);
        this.f2130c = EGL14.EGL_NO_SURFACE;
        this.f2132e = -1;
        this.f2131d = -1;
    }

    /* renamed from: b */
    public void mo10526b(C0857b bVar) {
        if (!bVar.mo10521d(this.f2130c)) {
            bVar.mo10519b(this.f2130c);
        }
    }

    /* renamed from: c */
    public boolean mo10527c() {
        boolean c = this.f2129b.mo10520c(this.f2130c);
        if (!c) {
            Log.d(f2128a, "WARNING: swapBuffers() failed");
        }
        return c;
    }
}
