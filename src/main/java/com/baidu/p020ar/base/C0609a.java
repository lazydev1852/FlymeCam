package com.baidu.p020ar.base;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.Matrix;
import com.baidu.p020ar.ProjectParams;
import com.baidu.p020ar.audio.AudioParams;
import com.baidu.p020ar.audio.easy.EasyAudio;
import com.baidu.p020ar.audio.easy.EasyAudioCallback;
import com.baidu.p020ar.blend.blender.C0654c;
import com.baidu.p020ar.recorder.C0835a;
import com.baidu.p020ar.recorder.MovieRecorderCallback;
import com.baidu.p020ar.recorder.filter.FilterManager;
import com.baidu.p020ar.recorder.p044b.C0842a;
import com.baidu.p020ar.recorder.p044b.C0845d;
import com.baidu.p020ar.recorder.p046d.C0852d;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.C0924a;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.baidu.ar.base.a */
public class C0609a implements C0654c.C0668c {

    /* renamed from: b */
    private static final String f988b = "a";

    /* renamed from: a */
    float[] f989a = new float[16];

    /* renamed from: c */
    private C0842a f990c;

    /* renamed from: d */
    private int f991d = -1;

    /* renamed from: e */
    private final Context f992e;

    /* renamed from: f */
    private FilterManager.FilterType f993f;

    /* renamed from: g */
    private boolean f994g = false;

    /* renamed from: h */
    private C0835a f995h;

    /* renamed from: i */
    private C0852d f996i;

    /* renamed from: j */
    private MovieRecorderCallback f997j;

    /* renamed from: k */
    private boolean f998k;

    /* renamed from: l */
    private int f999l;

    /* renamed from: m */
    private EasyAudio f1000m;

    /* renamed from: n */
    private AudioParams f1001n;

    /* renamed from: o */
    private EasyAudioCallback f1002o;

    /* renamed from: com.baidu.ar.base.a$a */
    private static class C0610a implements EasyAudioCallback {

        /* renamed from: a */
        private WeakReference<C0609a> f1003a;

        public C0610a(C0609a aVar) {
            this.f1003a = new WeakReference<>(aVar);
        }

        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.f1003a.get() != null) {
                ((C0609a) this.f1003a.get()).m1243a(byteBuffer, i, j);
            }
        }

        public void onAudioStart(boolean z, AudioParams audioParams) {
            if (this.f1003a.get() != null) {
                ((C0609a) this.f1003a.get()).m1244a(z);
            }
        }

        public void onAudioStop(boolean z) {
        }
    }

    public C0609a(Context context) {
        this.f992e = context;
        this.f995h = C0835a.m2271a();
        Matrix.setIdentityM(this.f989a, 0);
    }

    /* renamed from: a */
    private void m1239a(int i, float[] fArr, long j) {
        if (this.f998k && this.f996i != null) {
            switch (this.f999l) {
                case 0:
                    m1245d();
                    this.f995h.mo10401a(this.f992e, this.f996i, this.f997j);
                    break;
                case 1:
                    break;
                case 2:
                    this.f990c.mo10425a(i);
                    this.f990c.mo10428a(this.f993f);
                    this.f995h.mo10409b(this.f990c);
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.f999l);
            }
            this.f999l = 1;
        }
        if (this.f995h != null) {
            this.f995h.mo10407a(fArr, j);
        }
    }

    /* renamed from: a */
    private void m1240a(AudioParams audioParams) {
        if (this.f1002o == null) {
            m1247f();
        }
        if (audioParams == null) {
            this.f1001n = new AudioParams();
            if (ProjectParams.isHuaweiProject()) {
                this.f1001n.setSampleRate(32000);
                this.f1001n.setFrameSize(1280);
            }
        } else {
            this.f1001n = audioParams;
        }
        this.f1000m = EasyAudio.getInstance();
        this.f1000m.startAudio(this.f1001n, this.f1002o);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1243a(ByteBuffer byteBuffer, int i, long j) {
        if (this.f995h != null && this.f998k && byteBuffer != null && i > 0) {
            this.f995h.mo10406a(byteBuffer, i, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1244a(boolean z) {
        C0924a.m2751a(this.f996i, this.f1001n);
        this.f996i.mo10481a(z);
        this.f998k = true;
    }

    /* renamed from: d */
    private void m1245d() {
        if (this.f996i != null && this.f990c != null) {
            int f = this.f996i.mo10489f();
            int e = this.f996i.mo10488e();
            if (f > e) {
                f = (this.f996i.mo10488e() * this.f990c.mo10438g().mo10455b()) / this.f990c.mo10438g().mo10452a();
            } else {
                e = (this.f996i.mo10489f() * this.f990c.mo10438g().mo10455b()) / this.f990c.mo10438g().mo10452a();
            }
            if (f % 2 == 1) {
                f++;
            }
            if (e % 2 == 1) {
                e++;
            }
            this.f996i.mo10478a(e);
            this.f996i.mo10483b(f);
        }
    }

    /* renamed from: e */
    private void m1246e() {
        if (this.f994g) {
            if (this.f995h != null) {
                this.f995h.mo10405a(this.f993f);
            }
            this.f994g = false;
        }
    }

    /* renamed from: f */
    private void m1247f() {
        if (this.f1002o == null) {
            this.f1002o = new C0610a(this);
        }
    }

    /* renamed from: a */
    public void mo9505a() {
        m1240a((AudioParams) null);
    }

    /* renamed from: a */
    public void mo9506a(int i) {
        if (this.f990c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f991d != i) {
                ARLog.m2695d("bdar: onFrameAvailable textureId = " + i);
                this.f990c.mo10425a(i);
                C0835a.m2271a().mo10402a(this.f990c.mo10424a(), i);
                this.f991d = i;
            }
            m1246e();
            m1239a(this.f991d, this.f989a, System.nanoTime());
            ARLog.m2695d("bdar: onFrameAvailable time is = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* renamed from: a */
    public void mo9507a(C0852d dVar) {
        this.f996i = dVar;
    }

    /* renamed from: a */
    public void mo9508a(C0852d dVar, MovieRecorderCallback movieRecorderCallback) {
        mo9507a(dVar);
        this.f997j = movieRecorderCallback;
    }

    /* renamed from: a */
    public void mo9509a(EGLContext eGLContext, int i, int i2) {
        ARLog.m2695d("bdar: onContextChanged width*height = " + i + " * " + i2);
        if (eGLContext != null) {
            if (this.f990c == null) {
                this.f990c = new C0842a(EGL14.eglGetCurrentContext(), 0, true, false);
            } else {
                this.f990c.mo10426a(EGL14.eglGetCurrentContext());
            }
            C0845d dVar = new C0845d();
            dVar.mo10453a(i);
            dVar.mo10456b(i2);
            this.f990c.mo10427a(dVar);
            C0835a.m2271a().mo10403a(this.f990c);
        }
    }

    /* renamed from: b */
    public void mo9510b() {
        this.f998k = false;
        switch (this.f999l) {
            case 0:
                return;
            case 1:
            case 2:
                this.f999l = 0;
                if (this.f1000m != null) {
                    this.f1000m.stopAudio(this.f1002o);
                }
                if (this.f995h != null) {
                    this.f995h.mo10408b();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.f999l);
        }
    }

    /* renamed from: b */
    public void mo9511b(int i) {
        this.f995h.mo10400a(i);
    }

    /* renamed from: c */
    public void mo9512c() {
        if (this.f1000m != null) {
            this.f1000m.release();
            this.f1000m = null;
        }
        if (this.f995h != null) {
            this.f995h.mo10411c();
            this.f995h = null;
        }
        if (this.f997j != null) {
            this.f997j = null;
        }
    }
}
