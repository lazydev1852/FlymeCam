package com.meizu.media.camera.views;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.meizu.media.camera.views.b */
public class ARRenderer implements GLSurfaceView.Renderer {

    /* renamed from: a */
    public static ChangeQuickRedirect f15226a = null;

    /* renamed from: b */
    private static final String f15227b = "b";

    /* renamed from: c */
    private ARDrawer f15228c;

    /* renamed from: d */
    private SurfaceTexture f15229d;

    /* renamed from: e */
    private int f15230e;

    /* renamed from: f */
    private ARDrawer f15231f;

    /* renamed from: g */
    private SurfaceTexture f15232g;

    /* renamed from: h */
    private int f15233h;

    /* renamed from: i */
    private int f15234i;

    /* renamed from: j */
    private int f15235j;

    /* renamed from: k */
    private C2739a f15236k;

    /* renamed from: l */
    private SurfaceTexture.OnFrameAvailableListener f15237l;

    /* renamed from: m */
    private volatile boolean f15238m = true;

    /* renamed from: n */
    private boolean f15239n;

    /* renamed from: o */
    private boolean f15240o = false;

    /* renamed from: com.meizu.media.camera.views.b$a */
    /* compiled from: ARRenderer */
    public interface C2739a {
        /* renamed from: a */
        void mo21971a(SurfaceTexture surfaceTexture, int i, int i2);

        /* renamed from: a */
        void mo21972a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2);

        /* renamed from: b */
        void mo21973b(SurfaceTexture surfaceTexture, int i, int i2);
    }

    public ARRenderer(boolean z) {
        this.f15239n = z;
        if (this.f15229d == null) {
            this.f15229d = new SurfaceTexture(m16692a(3553));
        }
        if (this.f15232g == null) {
            this.f15232g = new SurfaceTexture(m16692a(3553));
        }
    }

    /* renamed from: a */
    public void mo23311a(C2739a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f15226a, false, 8282, new Class[]{C2739a.class}, Void.TYPE).isSupported) {
            this.f15236k = aVar;
            if (this.f15236k != null) {
                this.f15236k.mo21971a(this.f15229d, 1280, 720);
            }
            if (this.f15236k != null) {
                this.f15236k.mo21972a(this.f15232g, this.f15237l, this.f15234i, this.f15235j);
            }
        }
    }

    /* renamed from: a */
    public void mo23310a(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.f15237l = onFrameAvailableListener;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (!PatchProxy.proxy(new Object[]{gl10, eGLConfig}, this, f15226a, false, 8283, new Class[]{GL10.class, EGLConfig.class}, Void.TYPE).isSupported) {
            this.f15230e = m16692a(3553);
            this.f15233h = m16692a(3553);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Object[] objArr = {gl10, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f15226a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8284, new Class[]{GL10.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            GLES20.glViewport(0, 0, i, i2);
            this.f15234i = i;
            this.f15235j = i2;
            if (this.f15228c == null) {
                this.f15228c = new ARDrawer(this.f15230e, 3553, this.f15239n);
            }
            if (this.f15231f == null) {
                this.f15231f = new ARDrawer(this.f15233h, 3553, this.f15239n);
            }
            if (this.f15236k != null) {
                this.f15236k.mo21973b(this.f15232g, this.f15234i, this.f15235j);
            }
        }
    }

    public void onDrawFrame(GL10 gl10) {
        if (!PatchProxy.proxy(new Object[]{gl10}, this, f15226a, false, 8285, new Class[]{GL10.class}, Void.TYPE).isSupported) {
            m16693b();
            if (StatisticConstants.getIsRenderModel()) {
                StatisticHelper.getInstance().statisticFrameRate(StatisticConstants.VIEW_RENDER_FRAME_TIME);
            }
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glClear(16640);
            try {
                if (this.f15238m) {
                    if (this.f15232g != null) {
                        Log.d(f15227b, "mARTexture.updateTexImage(); ");
                        this.f15232g.updateTexImage();
                        float[] fArr = new float[16];
                        this.f15232g.getTransformMatrix(fArr);
                        this.f15231f.mo23308a(fArr);
                    }
                } else if (this.f15229d != null) {
                    this.f15229d.updateTexImage();
                    float[] fArr2 = new float[16];
                    this.f15229d.getTransformMatrix(fArr2);
                    this.f15228c.mo23308a(fArr2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m16693b() {
        if (!PatchProxy.proxy(new Object[0], this, f15226a, false, 8286, new Class[0], Void.TYPE).isSupported && this.f15240o) {
            try {
                this.f15232g.detachFromGLContext();
            } catch (Exception e) {
                Log.e(f15227b, "onSurfaceChanged attachToGLContext error!!!");
                e.printStackTrace();
            }
            try {
                this.f15229d.detachFromGLContext();
            } catch (Exception e2) {
                Log.e(f15227b, "onSurfaceChanged attachToGLContext error!!!");
                e2.printStackTrace();
            }
            try {
                if (this.f15238m) {
                    this.f15232g.attachToGLContext(this.f15233h);
                } else {
                    this.f15229d.attachToGLContext(this.f15230e);
                }
            } catch (Exception e3) {
                Log.e(f15227b, "onSurfaceChanged attachToGLContext error!!!");
                e3.printStackTrace();
            }
            this.f15240o = false;
        }
    }

    /* renamed from: a */
    public void mo23309a() {
        if (!PatchProxy.proxy(new Object[0], this, f15226a, false, 8287, new Class[0], Void.TYPE).isSupported) {
            if (this.f15231f != null) {
                this.f15231f = null;
            }
            if (this.f15232g != null) {
                this.f15232g.release();
                this.f15232g = null;
            }
            this.f15236k = null;
        }
    }

    /* renamed from: a */
    private int m16692a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f15226a, false, 8288, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i, iArr[0]);
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        return iArr[0];
    }
}
