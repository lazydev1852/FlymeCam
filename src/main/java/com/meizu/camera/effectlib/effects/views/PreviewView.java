package com.meizu.camera.effectlib.effects.views;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.imageproc.SurfaceTextureWrapper;

/* renamed from: com.meizu.camera.effectlib.effects.views.c */
public interface PreviewView {

    /* renamed from: com.meizu.camera.effectlib.effects.views.c$a */
    /* compiled from: PreviewView */
    public interface C1192a {
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.c$b */
    /* compiled from: PreviewView */
    public interface C1193b {
        /* renamed from: n_ */
        void mo14346n_();
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.c$c */
    /* compiled from: PreviewView */
    public interface C1194c {
        /* renamed from: a */
        void mo14347a(SurfaceTexture surfaceTexture, int i, int i2);

        /* renamed from: a */
        boolean mo14348a(SurfaceTexture surfaceTexture);

        /* renamed from: b */
        void mo14349b(SurfaceTexture surfaceTexture);

        /* renamed from: b */
        void mo14350b(SurfaceTexture surfaceTexture, int i, int i2);

        /* renamed from: c */
        boolean mo14351c(SurfaceTexture surfaceTexture);
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.c$d */
    /* compiled from: PreviewView */
    public interface C1195d {
        /* renamed from: a */
        void mo14352a(SurfaceTextureWrapper surfaceTextureWrapper, int i, int i2);

        /* renamed from: a */
        boolean mo14353a(SurfaceTextureWrapper surfaceTextureWrapper);

        /* renamed from: b */
        void mo14354b(SurfaceTextureWrapper surfaceTextureWrapper, int i, int i2);

        /* renamed from: b */
        boolean mo14355b(SurfaceTextureWrapper surfaceTextureWrapper);

        /* renamed from: c */
        void mo14356c(SurfaceTextureWrapper surfaceTextureWrapper);
    }

    /* renamed from: a */
    int mo14098a(byte[] bArr, int[] iArr, int[] iArr2);

    /* renamed from: a */
    Bitmap mo14099a(int i, int i2);

    /* renamed from: a */
    void mo14100a();

    /* renamed from: a */
    void mo14102a(boolean z, boolean z2);

    /* renamed from: a */
    void mo14103a(float[] fArr);

    /* renamed from: c */
    void mo14105c();

    /* renamed from: d */
    void mo14106d();

    /* renamed from: f */
    void mo14108f();

    Bitmap getPreviewBitmap();

    BaseRender getRender();

    BaseRender getVfbRender();

    /* renamed from: h */
    void mo14116h();

    /* renamed from: i */
    void mo14117i();

    /* renamed from: j */
    void mo14118j();

    /* renamed from: k */
    void mo14119k();

    /* renamed from: l */
    void mo14120l();

    /* renamed from: m */
    void mo14122m();

    void setBokehListener(C1192a aVar);

    void setBokehStatus(boolean z);

    void setCleanScreen(boolean z);

    void setEffectRenderFactory(EffectRenderFactory bVar);

    void setPreviewData(byte[] bArr, int i, int i2, int i3);

    void setRender(BaseRender aVar);

    void setRenderType(String str);

    void setRenderViewCallBackListener(C1193b bVar);

    void setSurfaceTextureBitmap(int i);

    void setSurfaceTextureBitmap(int i, int i2, boolean z);

    void setSurfaceTextureBitmap(int i, int i2, boolean z, boolean z2);

    void setSurfaceTextureListener(C1194c cVar);

    void setSurfaceTextureListener2(C1194c cVar, C1195d dVar);

    void setTofStatus(boolean z);

    void setTransform(float[] fArr);

    void setTransformParms(float f, float f2, float f3);

    void setVfbRenderType(String str);

    void setViewAlpha(float f);
}
