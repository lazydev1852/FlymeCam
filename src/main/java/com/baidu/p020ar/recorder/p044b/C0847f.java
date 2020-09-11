package com.baidu.p020ar.recorder.p044b;

import android.view.Surface;
import com.baidu.p020ar.recorder.p047e.C0857b;
import com.baidu.p020ar.recorder.p047e.C0858c;

/* renamed from: com.baidu.ar.recorder.b.f */
public class C0847f extends C0858c {

    /* renamed from: c */
    private Surface f2077c;

    /* renamed from: d */
    private boolean f2078d;

    public C0847f(C0857b bVar, Surface surface, boolean z) {
        super(bVar);
        mo10524a((Object) surface);
        this.f2077c = surface;
        this.f2078d = z;
    }

    /* renamed from: a */
    public void mo10467a() {
        mo10525b();
        if (this.f2077c != null) {
            if (this.f2078d) {
                this.f2077c.release();
            }
            this.f2077c = null;
        }
    }

    /* renamed from: a */
    public void mo10468a(C0857b bVar) {
        if (this.f2077c != null) {
            this.f2129b = bVar;
            mo10524a((Object) this.f2077c);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }
}
