package com.meizu.media.camera.p077ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.media.ImageReader;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.baidu.p020ar.DuMixCallback;
import com.baidu.p020ar.DuMixSource;
import com.baidu.p020ar.DuMixTarget;
import com.baidu.p020ar.TakePictureCallback;
import com.baidu.p020ar.bean.ARResource;
import com.baidu.p020ar.bean.DuMixARConfig;
import com.baidu.p020ar.recorder.MovieRecorderCallback;
import com.meizu.common.widget.OperatingGuideView;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.PreviewGestures;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.adapter.BaseViewHolder;
import com.meizu.media.camera.bean.ARSticker;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateOneBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzArBinding;
import com.meizu.media.camera.databinding.MzArContainerBinding;
import com.meizu.media.camera.filter.CenterLockLayoutManager;
import com.meizu.media.camera.filter.CenterLockListener;
import com.meizu.media.camera.p071h.StickerNetworkManager;
import com.meizu.media.camera.p077ui.MzARUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NetWorkUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.ARRenderer;
import com.meizu.media.camera.views.SelectAdapter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.app.AlertDialog;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.meizu.media.camera.ui.d */
public class MzARUI implements StickerNetworkManager.C2117a {

    /* renamed from: a */
    public static ChangeQuickRedirect f12806a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f12807b = new LogUtil.C2630a("ARUI");
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f12808A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f12809B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f12810C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Handler f12811D = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f12812E = false;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f12813F = false;

    /* renamed from: G */
    private ViewGroup f12814G;

    /* renamed from: H */
    private ImageReader f12815H;

    /* renamed from: I */
    private CenterLockListener f12816I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public MzRecyclerView f12817J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public DuMixSource f12818K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public DuMixTarget f12819L;

    /* renamed from: M */
    private GLSurfaceView f12820M;

    /* renamed from: N */
    private ARRenderer f12821N;

    /* renamed from: O */
    private ObjectAnimator f12822O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f12823P = true;

    /* renamed from: Q */
    private MzRecyclerView.C3227j f12824Q = new MzRecyclerView.C3227j() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12859a;

        public void onItemClick(RecyclerView recyclerView, View view, int i, long j) {
            Object[] objArr = {recyclerView, view, new Integer(i), new Long(j)};
            ChangeQuickRedirect changeQuickRedirect = f12859a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6381, new Class[]{RecyclerView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported && !MzARUI.this.f12812E && MzARUI.this.f12841o != null && MzARUI.this.f12841o.mo20093a() > i) {
                ARSticker d = MzARUI.this.f12841o.mo21982d(i);
                int a = NetWorkUtils.m15976a(MzARUI.this.f12831e);
                if (d.mo19332e()) {
                    if (a == -1) {
                        MzARUI.this.m14701v();
                        return;
                    }
                    MzARUI.this.f12842p.mo20398c();
                    MzARUI.this.f12842p.mo20397b_();
                } else if (d.mo19338j() == ARSticker.DownloadState.DOWNLOADING) {
                    LogUtil.m15942a(MzARUI.f12807b, "ar sticker is downloading");
                } else if (i != ((SelectAdapter) recyclerView.getAdapter()).mo23409b()) {
                    recyclerView.mo26403g(i);
                } else {
                    MzARUI.this.m14702w();
                }
            }
        }
    };

    /* renamed from: R */
    private AlertDialog f12825R;

    /* renamed from: S */
    private AlertDialog f12826S;

    /* renamed from: T */
    private Camera.PreviewCallback f12827T = new Camera.PreviewCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12861a;

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Class[] clsArr = {byte[].class, Camera.class};
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f12861a, false, 6382, clsArr, Void.TYPE).isSupported && !MzARUI.this.f12812E && MzARController.f12803b.mo21932a() != null) {
                if (MzARUI.this.f12830d != null) {
                    if (!MzARUI.this.f12830d.mo20416s()) {
                        MzARController.f12803b.mo21932a().orientationChange(MzARUI.this.f12830d.mo20415r());
                    } else {
                        return;
                    }
                }
                MzARController.f12803b.mo21932a().onCameraPreviewFrame(bArr, 1280, 720);
                if (MzARUI.this.f12833g != null) {
                    MzARUI.this.f12833g.mo22135ax();
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: U */
    public DuMixCallback f12828U = new DuMixCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12869a;

        public void onPause(boolean z) {
        }

        public void onRelease(boolean z) {
        }

        public void onReset(boolean z) {
        }

        public void onResume(boolean z) {
        }

        public void onSetup(boolean z) {
        }

        public void onStateError(int i, String str) {
        }

        public void onStateChange(int i, Object obj) {
            Object[] objArr = {new Integer(i), obj};
            ChangeQuickRedirect changeQuickRedirect = f12869a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6391, new Class[]{Integer.TYPE, Object.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a r = MzARUI.f12807b;
                LogUtil.m15942a(r, "on State Change id: " + i + " value: " + obj);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007e, code lost:
            if (r10.equals("model_move") == false) goto L_0x009f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onLuaMessage(java.util.HashMap<java.lang.String, java.lang.Object> r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f12869a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<java.util.HashMap> r2 = java.util.HashMap.class
                r6[r8] = r2
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 6392(0x18f8, float:8.957E-42)
                r2 = r9
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x001d
                return
            L_0x001d:
                if (r10 != 0) goto L_0x0020
                return
            L_0x0020:
                java.lang.String r1 = "type"
                boolean r1 = r10.containsKey(r1)
                if (r1 == 0) goto L_0x00d6
                java.lang.String r1 = "type"
                java.lang.Object r10 = r10.get(r1)
                java.lang.String r10 = r10.toString()
                com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p077ui.MzARUI.f12807b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "on Lua Msg type: "
                r2.append(r3)
                r2.append(r10)
                java.lang.String r2 = r2.toString()
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                java.lang.String r2 = "sticker_id"
                com.meizu.media.camera.ui.d r3 = com.meizu.media.camera.p077ui.MzARUI.this
                int r3 = r3.f12808A
                java.lang.String r3 = java.lang.String.valueOf(r3)
                r1.put(r2, r3)
                r2 = -1
                int r3 = r10.hashCode()
                r4 = -20533455(0xfffffffffec6af31, float:-1.3204839E38)
                if (r3 == r4) goto L_0x0095
                r4 = 816668914(0x30ad60f2, float:1.261496E-9)
                if (r3 == r4) goto L_0x008b
                r4 = 831169716(0x318aa4b4, float:4.035053E-9)
                if (r3 == r4) goto L_0x0081
                r4 = 2104855335(0x7d758b27, float:2.0398961E37)
                if (r3 == r4) goto L_0x0078
                goto L_0x009f
            L_0x0078:
                java.lang.String r3 = "model_move"
                boolean r10 = r10.equals(r3)
                if (r10 == 0) goto L_0x009f
                goto L_0x00a0
            L_0x0081:
                java.lang.String r0 = "model_scale"
                boolean r10 = r10.equals(r0)
                if (r10 == 0) goto L_0x009f
                r0 = 3
                goto L_0x00a0
            L_0x008b:
                java.lang.String r0 = "model_click"
                boolean r10 = r10.equals(r0)
                if (r10 == 0) goto L_0x009f
                r0 = 0
                goto L_0x00a0
            L_0x0095:
                java.lang.String r0 = "model_rotate"
                boolean r10 = r10.equals(r0)
                if (r10 == 0) goto L_0x009f
                r0 = 2
                goto L_0x00a0
            L_0x009f:
                r0 = -1
            L_0x00a0:
                switch(r0) {
                    case 0: goto L_0x00bc;
                    case 1: goto L_0x00b4;
                    case 2: goto L_0x00ac;
                    case 3: goto L_0x00a4;
                    default: goto L_0x00a3;
                }
            L_0x00a3:
                goto L_0x00c3
            L_0x00a4:
                java.lang.String r10 = "type"
                java.lang.String r0 = "scale"
                r1.put(r10, r0)
                goto L_0x00c3
            L_0x00ac:
                java.lang.String r10 = "type"
                java.lang.String r0 = "rotate"
                r1.put(r10, r0)
                goto L_0x00c3
            L_0x00b4:
                java.lang.String r10 = "type"
                java.lang.String r0 = "move"
                r1.put(r10, r0)
                goto L_0x00c3
            L_0x00bc:
                java.lang.String r10 = "type"
                java.lang.String r0 = "click"
                r1.put(r10, r0)
            L_0x00c3:
                com.meizu.media.camera.ui.d r10 = com.meizu.media.camera.p077ui.MzARUI.this
                android.content.Context r10 = r10.f12831e
                android.content.Context r10 = r10.getApplicationContext()
                com.meizu.media.camera.util.at r10 = com.meizu.media.camera.util.UsageStatsHelper.m16042a((android.content.Context) r10)
                java.lang.String r0 = "interact_ar_model"
                r10.mo22693a((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r1)
            L_0x00d6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p077ui.MzARUI.C24558.onLuaMessage(java.util.HashMap):void");
        }

        public void onCaseChange(boolean z) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f12869a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6393, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                LogUtil.C2630a r = MzARUI.f12807b;
                LogUtil.m15942a(r, "onCaseChange: " + z);
            }
        }

        public void onCaseCreated(ARResource aRResource) {
            if (!PatchProxy.proxy(new Object[]{aRResource}, this, f12869a, false, 6394, new Class[]{ARResource.class}, Void.TYPE).isSupported) {
                if (!MzARUI.this.f12850x) {
                    boolean unused = MzARUI.this.f12850x = true;
                    MzARUI.this.f12811D.post(new Runnable() {
                        public final void run() {
                            MzARUI.C24558.this.m14744b();
                        }
                    });
                    return;
                }
                MzARUI.this.f12811D.post(new Runnable() {
                    public final void run() {
                        MzARUI.C24558.this.m14743a();
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m14744b() {
            if (!PatchProxy.proxy(new Object[0], this, f12869a, false, 6396, new Class[0], Void.TYPE).isSupported) {
                MzARUI.this.m14671d(true);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m14743a() {
            if (!PatchProxy.proxy(new Object[0], this, f12869a, false, 6395, new Class[0], Void.TYPE).isSupported) {
                MzARUI.this.m14671d(false);
            }
        }
    };

    /* renamed from: c */
    private MzUIController f12829c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2458b f12830d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f12831e;

    /* renamed from: f */
    private Activity f12832f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MzCamUI f12833g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MzCamController f12834h;

    /* renamed from: i */
    private CameraBinding f12835i;

    /* renamed from: j */
    private View f12836j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public FrameLayout f12837k;

    /* renamed from: l */
    private TextView f12838l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ImageView f12839m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public FrameLayout f12840n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C2460d f12841o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C2457a f12842p;

    /* renamed from: q */
    private ComboPreferences f12843q;

    /* renamed from: r */
    private boolean f12844r;

    /* renamed from: s */
    private int f12845s;

    /* renamed from: t */
    private FrameLayout f12846t;

    /* renamed from: u */
    private FrameLayout f12847u;

    /* renamed from: v */
    private TextView f12848v;

    /* renamed from: w */
    private OperatingGuideView f12849w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f12850x = false;

    /* renamed from: y */
    private View f12851y;

    /* renamed from: z */
    private flyme.support.p093v7.app.AlertDialog f12852z;

    /* renamed from: com.meizu.media.camera.ui.d$a */
    /* compiled from: MzARUI */
    public interface C2457a {
        /* renamed from: a */
        void mo20388a(String str);

        /* renamed from: a */
        void mo20389a(String str, int i);

        /* renamed from: a */
        void mo20391a(String str, String str2, String str3, boolean z);

        /* renamed from: b */
        void mo20396b(String str);

        /* renamed from: b_ */
        void mo20397b_();

        /* renamed from: c */
        void mo20398c();

        /* renamed from: c */
        void mo20399c(String str);
    }

    /* renamed from: com.meizu.media.camera.ui.d$b */
    /* compiled from: MzARUI */
    public interface C2458b {
        /* renamed from: a */
        void mo20390a(String str, long j, String str2);

        /* renamed from: d */
        void mo20400d(String str);

        /* renamed from: q */
        void mo20414q();

        /* renamed from: r */
        int mo20415r();

        /* renamed from: s */
        boolean mo20416s();
    }

    MzARUI(CameraActivity cameraActivity, CameraBinding cameraBinding, MzCamUI iVar, MzCamController mzCamController) {
        MzArContainerBinding mzArContainerBinding;
        this.f12832f = cameraActivity;
        this.f12831e = cameraActivity.mo17639f();
        this.f12834h = mzCamController;
        this.f12835i = cameraBinding;
        this.f12833g = iVar;
        this.f12843q = ComboPreferences.m10003a(this.f12831e.getApplicationContext());
        m14698u();
        m14696t();
        if (this.f12843q != null) {
            this.f12845s = this.f12843q.getInt("ar_mode_guide_show_count", 0);
        }
        DelayInflateOneBinding delayInflateOneBinding = (DelayInflateOneBinding) this.f12835i.f9508g.getBinding();
        if (delayInflateOneBinding.f9559d.getViewStub() != null) {
            mzArContainerBinding = (MzArContainerBinding) DataBindingUtil.bind(delayInflateOneBinding.f9559d.getViewStub().inflate());
        } else {
            mzArContainerBinding = (MzArContainerBinding) delayInflateOneBinding.f9559d.getBinding();
        }
        this.f12814G = mzArContainerBinding.f9618a;
        this.f12814G.removeAllViews();
        this.f12814G.setVisibility(0);
        LayoutInflater.from(cameraActivity).inflate(R.layout.mz_ar_view, this.f12814G, true);
        this.f12814G.setVisibility(4);
        m14695s();
        this.f12820M = (GLSurfaceView) this.f12814G.findViewById(R.id.mz_ar_preview_view);
        this.f12820M.setEGLContextClientVersion(2);
        this.f12833g.mo22074a(this.f12820M);
        this.f12821N = new ARRenderer(false);
        this.f12821N.mo23310a((SurfaceTexture.OnFrameAvailableListener) new SurfaceTexture.OnFrameAvailableListener() {
            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                MzARUI.this.m14648a(surfaceTexture);
            }
        });
        this.f12820M.setEGLConfigChooser(new C2459c());
        this.f12820M.setRenderer(this.f12821N);
        this.f12820M.setRenderMode(0);
        MzARController.f12803b.mo21933a(this.f12831e);
        m14705z();
        m14703x();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14648a(SurfaceTexture surfaceTexture) {
        if (!PatchProxy.proxy(new Object[]{surfaceTexture}, this, f12806a, false, 6376, new Class[]{SurfaceTexture.class}, Void.TYPE).isSupported && !this.f12812E) {
            this.f12820M.requestRender();
        }
    }

    /* renamed from: s */
    private void m14695s() {
        MzArBinding mzArBinding;
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6308, new Class[0], Void.TYPE).isSupported) {
            DelayInflateTwoBinding delayInflateTwoBinding = (DelayInflateTwoBinding) this.f12835i.f9509h.getBinding();
            if (delayInflateTwoBinding.f9573d.getViewStub() != null) {
                mzArBinding = (MzArBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9573d.getViewStub().inflate());
            } else {
                mzArBinding = (MzArBinding) delayInflateTwoBinding.f9573d.getBinding();
            }
            this.f12836j = mzArBinding.f9610e;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12836j.getLayoutParams();
            layoutParams.bottomMargin = CameraUtil.m15897f();
            this.f12836j.setLayoutParams(layoutParams);
            FrameLayout frameLayout = mzArBinding.f9607b;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.height = CameraUtil.m15901h();
            layoutParams2.gravity = 49;
            frameLayout.setLayoutParams(layoutParams2);
            this.f12838l = mzArBinding.f9606a;
            this.f12838l.setText("00:00:00");
            this.f12838l.setVisibility(4);
            this.f12839m = mzArBinding.f9612g;
            this.f12837k = mzArBinding.f9608c;
            this.f12837k.setVisibility(0);
            this.f12837k.setAlpha(1.0f);
            this.f12837k.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MzARUI.this.m14652a(view);
                }
            });
            this.f12840n = mzArBinding.f9611f;
            this.f12840n.setVisibility(4);
            this.f12840n.setAlpha(0.0f);
            this.f12840n.setTranslationY(0.0f);
            this.f12817J = mzArBinding.f9613h;
            CenterLockLayoutManager aVar = new CenterLockLayoutManager(this.f12832f, this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width), this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width_selected));
            aVar.mo26076b(0);
            this.f12817J.setLayoutManager(aVar);
            this.f12816I = new CenterLockListener(this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width), this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width_selected), this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_height), this.f12831e.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_height_selected));
            this.f12817J.setOnScrollListener(this.f12816I);
            this.f12817J.setSelectorCanDraw(false);
            this.f12841o = new C2460d(this.f12831e);
            this.f12817J.setAdapter(this.f12841o);
            this.f12817J.setItemViewCacheSize(20);
            this.f12810C = true;
            this.f12817J.setOnItemClickListener(this.f12824Q);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14652a(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f12806a, false, 6375, new Class[]{View.class}, Void.TYPE).isSupported) {
            if (this.f12849w != null) {
                m14675e(false);
                m14675e(true);
                return;
            }
            mo21941a(false);
            mo21942b(true);
            UsageStatsHelper.m16042a(this.f12831e.getApplicationContext()).mo22695b("open_ar_window");
        }
    }

    /* renamed from: t */
    private void m14696t() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6309, new Class[0], Void.TYPE).isSupported) {
            DuMixARConfig.setAppId("10000");
            DuMixARConfig.setAPIKey("2288883fb087c4a37fbaf12bce65916e");
            DuMixARConfig.setSecretKey("");
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    /* renamed from: u */
    private void m14698u() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6310, new Class[0], Void.TYPE).isSupported) {
            try {
                String str = Storage.m7750a().mo18642c(this.f12831e) + File.separator;
                for (String str2 : Contants.C2628a.f13820a) {
                    System.load(str + str2 + ".so");
                }
                LogUtil.m15942a(f12807b, "load ar lib from ar lib success!");
            } catch (UnsatisfiedLinkError e) {
                LogUtil.m15949b(f12807b, "loadLibrary from ar lib path failed: " + e.getMessage());
                try {
                    for (String str3 : Contants.C2628a.f13820a) {
                        System.loadLibrary(str3 + ".so");
                    }
                } catch (UnsatisfiedLinkError unused) {
                    LogUtil.m15949b(f12807b, "loadLibrary from system failed: " + e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo21941a(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12806a, false, 6311, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f12822O != null && this.f12822O.isRunning()) {
                return;
            }
            if (this.f12837k.getVisibility() == 0 && z) {
                return;
            }
            if ((this.f12837k.getVisibility() != 8 || z) && this.f12823P) {
                this.f12837k.setClickable(false);
                FrameLayout frameLayout = this.f12837k;
                float[] fArr = new float[2];
                fArr[0] = z ? 0.0f : 1.0f;
                fArr[1] = z ? 1.0f : 0.0f;
                this.f12822O = ObjectAnimator.ofFloat(frameLayout, "alpha", fArr);
                this.f12822O.setDuration(100);
                this.f12822O.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
                if (z) {
                    this.f12822O.setStartDelay(100);
                }
                this.f12822O.addListener(new Animator.AnimatorListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f12853a;

                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        if (!PatchProxy.proxy(new Object[]{animator}, this, f12853a, false, 6377, new Class[]{Animator.class}, Void.TYPE).isSupported && z) {
                            MzARUI.this.f12837k.setVisibility(0);
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!PatchProxy.proxy(new Object[]{animator}, this, f12853a, false, 6378, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                            if (!z) {
                                MzARUI.this.f12837k.setVisibility(8);
                            }
                            MzARUI.this.f12837k.setClickable(true);
                        }
                    }
                });
                this.f12822O.start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo21942b(final boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12806a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6312, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || !this.f12823P || this.f12840n == null) {
            return;
        }
        if (this.f12840n.getVisibility() != 0 && !z) {
            return;
        }
        if (this.f12840n.getVisibility() != 0 || !z) {
            AnimatorSet a = m14641a((View) this.f12840n, z);
            a.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12856a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f12856a, false, 6379, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        if (z && MzARUI.this.f12810C) {
                            boolean unused = MzARUI.this.f12810C = false;
                            MzARUI.this.f12817J.mo26403g(MzARUI.this.f12809B);
                            MzARUI.this.f12841o.mo20095a(MzARUI.this.f12809B);
                        }
                        MzARUI.this.f12840n.setVisibility(0);
                        MzARUI.this.f12840n.setAlpha(1.0f);
                        boolean unused2 = MzARUI.this.f12823P = false;
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    int i = 0;
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f12856a, false, 6380, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        MzARUI.this.f12840n.setVisibility(z ? 0 : 8);
                        MzCamUI g = MzARUI.this.f12833g;
                        if (z) {
                            i = MzARUI.this.f12840n.getHeight();
                        }
                        g.mo22138b(i);
                        boolean unused = MzARUI.this.f12823P = true;
                    }
                }
            });
            if (this.f12839m.getVisibility() != 8) {
                m14641a((View) this.f12839m, z).start();
            }
            a.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo21943b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12806a, false, 6313, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f12840n != null && this.f12840n.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m14701v() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6314, new Class[0], Void.TYPE).isSupported) {
            if (this.f12825R == null) {
                this.f12825R = new AlertDialog.Builder(this.f12832f).setMessage(R.string.mz_funny_cam_no_network).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MzARUI.this.m14668c(dialogInterface, i);
                    }
                }).setPositiveButton(R.string.mz_network_setting, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MzARUI.this.m14659b(dialogInterface, i);
                    }
                }).create();
            }
            this.f12825R.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m14668c(DialogInterface dialogInterface, int i) {
        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f12806a, false, 6374, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported && this.f12825R != null && this.f12825R.isShowing()) {
            this.f12825R.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m14659b(DialogInterface dialogInterface, int i) {
        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f12806a, false, 6373, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f12832f.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14646a(DialogInterface.OnClickListener onClickListener) {
        if (!PatchProxy.proxy(new Object[]{onClickListener}, this, f12806a, false, 6315, new Class[]{DialogInterface.OnClickListener.class}, Void.TYPE).isSupported) {
            this.f12826S = new AlertDialog.Builder(this.f12832f).setMessage(R.string.mz_funny_cam_download_with_mobile_network).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MzARUI.this.m14647a(dialogInterface, i);
                }
            }).setPositiveButton(R.string.mz_download, onClickListener).create();
            this.f12826S.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14647a(DialogInterface dialogInterface, int i) {
        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f12806a, false, 6372, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported && this.f12826S != null && this.f12826S.isShowing()) {
            this.f12826S.hide();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m14677f(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6316, new Class[]{String.class}, Void.TYPE).isSupported) {
            String c = Storage.m7750a().mo18643c(this.f12831e, str);
            LogUtil.C2630a aVar = f12807b;
            LogUtil.m15942a(aVar, "change AR Case id: " + str + "  filePath: " + c);
            try {
                if (this.f12818K != null && c != null && !c.equals(this.f12818K.getResFilePath())) {
                    this.f12808A = Integer.parseInt(str);
                    this.f12818K = new DuMixSource((SurfaceTexture) null, 1280, 720);
                    this.f12818K.setResFilePath(c);
                    this.f12818K.setArType(5);
                    this.f12818K.setArKey((String) null);
                    if (MzARController.f12803b.mo21932a() != null) {
                        MzARController.f12803b.mo21932a().changeCase(this.f12818K);
                    }
                }
            } catch (Exception e) {
                LogUtil.C2630a aVar2 = f12807b;
                LogUtil.m15949b(aVar2, "changeARCase ERR: " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m14702w() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6317, new Class[0], Void.TYPE).isSupported && MzARController.f12803b.mo21932a() != null) {
            LogUtil.C2630a aVar = f12807b;
            LogUtil.m15942a(aVar, "resetARSticker  id: " + this.f12808A);
            HashMap hashMap = new HashMap(1);
            hashMap.put("event_name", "mz_model_reset_pos");
            MzARController.f12803b.mo21932a().sendMessage2Lua(hashMap);
        }
    }

    /* renamed from: x */
    private void m14703x() {
        int i = 0;
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6318, new Class[0], Void.TYPE).isSupported && (this.f12820M.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12820M.getLayoutParams();
            layoutParams.topMargin = DeviceHelper.f13874aa ? CameraUtil.m15901h() : 0;
            if (DeviceHelper.f13874aa) {
                i = (CameraUtil.m15865b() - CameraUtil.m15901h()) - ((int) (((float) CameraUtil.m15809a()) * 1.7777778f));
            }
            layoutParams.bottomMargin = i;
            this.f12820M.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    public void mo21936a(MzUIController uVar) {
        this.f12829c = uVar;
    }

    /* renamed from: a */
    public void mo21938a(C2458b bVar) {
        this.f12830d = bVar;
    }

    /* renamed from: c */
    public void mo21944c() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6319, new Class[0], Void.TYPE).isSupported) {
            this.f12812E = false;
            if (CameraController.m8868g().mo19522k() != null) {
                m14649a(this.f12827T);
            }
        }
    }

    /* renamed from: d */
    public void mo21946d() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6320, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12807b, "onEnter");
            this.f12814G.setVisibility(0);
            this.f12836j.setVisibility(0);
            mo21949e("00:00:00");
            this.f12812E = false;
        }
    }

    /* renamed from: e */
    public Surface mo21948e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12806a, false, 6321, new Class[0], Surface.class);
        if (proxy.isSupported) {
            return (Surface) proxy.result;
        }
        m14704y();
        return this.f12815H.getSurface();
    }

    /* renamed from: y */
    private void m14704y() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6322, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12807b, "setupImageReader");
            if (this.f12815H != null) {
                this.f12815H.close();
            }
            this.f12815H = ImageReader.newInstance(1280, 720, 35, 2);
            this.f12815H.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                public final void onImageAvailable(ImageReader imageReader) {
                    MzARUI.this.m14650a(imageReader);
                }
            }, (Handler) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0080, code lost:
        if (r10 != null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if (r0 != null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0089, code lost:
        r0.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008d, code lost:
        r10.close();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void m14650a(android.media.ImageReader r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f12806a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.media.ImageReader> r0 = android.media.ImageReader.class
            r6[r8] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 6371(0x18e3, float:8.928E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x001d
            return
        L_0x001d:
            android.media.Image r10 = r10.acquireNextImage()
            r0 = 0
            if (r10 == 0) goto L_0x0091
            boolean r1 = r9.f12812E     // Catch:{ Throwable -> 0x007e }
            if (r1 != 0) goto L_0x0091
            com.meizu.media.camera.ui.c r1 = com.meizu.media.camera.p077ui.MzARController.f12803b     // Catch:{ Throwable -> 0x007e }
            com.baidu.ar.ARController r1 = r1.mo21932a()     // Catch:{ Throwable -> 0x007e }
            if (r1 != 0) goto L_0x0031
            goto L_0x0091
        L_0x0031:
            com.meizu.media.camera.ui.d$b r1 = r9.f12830d     // Catch:{ Throwable -> 0x007e }
            if (r1 == 0) goto L_0x0052
            com.meizu.media.camera.ui.d$b r1 = r9.f12830d     // Catch:{ Throwable -> 0x007e }
            boolean r1 = r1.mo20416s()     // Catch:{ Throwable -> 0x007e }
            if (r1 == 0) goto L_0x0043
            if (r10 == 0) goto L_0x0042
            r10.close()
        L_0x0042:
            return
        L_0x0043:
            com.meizu.media.camera.ui.c r1 = com.meizu.media.camera.p077ui.MzARController.f12803b     // Catch:{ Throwable -> 0x007e }
            com.baidu.ar.ARController r1 = r1.mo21932a()     // Catch:{ Throwable -> 0x007e }
            com.meizu.media.camera.ui.d$b r2 = r9.f12830d     // Catch:{ Throwable -> 0x007e }
            int r2 = r2.mo20415r()     // Catch:{ Throwable -> 0x007e }
            r1.orientationChange(r2)     // Catch:{ Throwable -> 0x007e }
        L_0x0052:
            byte[] r1 = com.meizu.media.camera.util.FormatUtil.m16270a((android.media.Image) r10)     // Catch:{ Throwable -> 0x007e }
            int r2 = r10.getHeight()     // Catch:{ Throwable -> 0x007e }
            android.media.Image$Plane[] r3 = r10.getPlanes()     // Catch:{ Throwable -> 0x007e }
            r3 = r3[r8]     // Catch:{ Throwable -> 0x007e }
            int r3 = r3.getRowStride()     // Catch:{ Throwable -> 0x007e }
            com.meizu.media.camera.ui.c r4 = com.meizu.media.camera.p077ui.MzARController.f12803b     // Catch:{ Throwable -> 0x007e }
            com.baidu.ar.ARController r4 = r4.mo21932a()     // Catch:{ Throwable -> 0x007e }
            r4.onCameraPreviewFrame(r1, r3, r2)     // Catch:{ Throwable -> 0x007e }
            com.meizu.media.camera.ui.i r1 = r9.f12833g     // Catch:{ Throwable -> 0x007e }
            if (r1 == 0) goto L_0x0076
            com.meizu.media.camera.ui.i r1 = r9.f12833g     // Catch:{ Throwable -> 0x007e }
            r1.mo22135ax()     // Catch:{ Throwable -> 0x007e }
        L_0x0076:
            if (r10 == 0) goto L_0x007b
            r10.close()
        L_0x007b:
            return
        L_0x007c:
            r1 = move-exception
            goto L_0x0080
        L_0x007e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x007c }
        L_0x0080:
            if (r10 == 0) goto L_0x0090
            if (r0 == 0) goto L_0x008d
            r10.close()     // Catch:{ Throwable -> 0x0088 }
            goto L_0x0090
        L_0x0088:
            r10 = move-exception
            r0.addSuppressed(r10)
            goto L_0x0090
        L_0x008d:
            r10.close()
        L_0x0090:
            throw r1
        L_0x0091:
            if (r10 == 0) goto L_0x0096
            r10.close()
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p077ui.MzARUI.m14650a(android.media.ImageReader):void");
    }

    /* renamed from: a */
    private void m14649a(Camera.PreviewCallback previewCallback) {
        if (!PatchProxy.proxy(new Object[]{previewCallback}, this, f12806a, false, 6323, new Class[]{Camera.PreviewCallback.class}, Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null) {
            CameraController.m8868g().mo19518i().post(new Runnable(previewCallback) {
                private final /* synthetic */ Camera.PreviewCallback f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    MzARUI.m14660b(this.f$0);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m14660b(Camera.PreviewCallback previewCallback) {
        if (!PatchProxy.proxy(new Object[]{previewCallback}, (Object) null, f12806a, true, 6370, new Class[]{Camera.PreviewCallback.class}, Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19516h() == CameraController.CameraApi.API1) {
            ((Camera) ((CameraProxyV1) CameraController.m8868g().mo19522k()).mo19730a()).setPreviewCallback(previewCallback);
        }
    }

    /* renamed from: f */
    public void mo21950f() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6324, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12807b, "onResume");
            if (MzARController.f12803b.mo21932a() == null) {
                MzARController.f12803b.mo21933a(this.f12831e);
                m14705z();
            }
            MzARController.f12803b.mo21932a().resume();
            MzARController.f12803b.mo21932a().onAppear();
            m14678f(false);
            this.f12811D.postDelayed(new Runnable() {
                public final void run() {
                    MzARUI.this.m14639J();
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void m14639J() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6369, new Class[0], Void.TYPE).isSupported && this.f12841o != null) {
            this.f12841o.mo20095a(this.f12809B);
        }
    }

    /* renamed from: g */
    public void mo21951g() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6325, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12807b, "onPause");
            if (MzARController.f12803b.mo21932a() != null) {
                MzARController.f12803b.mo21932a().pause();
            }
            m14678f(true);
        }
    }

    /* renamed from: h */
    public void mo21952h() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6326, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12807b, "release");
            this.f12812E = true;
            this.f12810C = false;
            m14649a((Camera.PreviewCallback) null);
            m14634E();
            if (this.f12821N != null) {
                this.f12821N.mo23310a((SurfaceTexture.OnFrameAvailableListener) null);
                this.f12821N.mo23309a();
                this.f12821N = null;
            }
            if (MzARController.f12803b.mo21932a() != null) {
                MzARController.f12803b.mo21934b();
            }
            if (this.f12814G != null) {
                this.f12814G.setVisibility(8);
            }
            if (this.f12836j != null) {
                this.f12836j.setVisibility(8);
            }
            if (this.f12833g != null) {
                this.f12833g.mo22083a((PreviewGestures.C2669a) null);
                this.f12833g.mo22125an();
            }
            this.f12820M = null;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: z */
    private synchronized void m14705z() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6327, new Class[0], Void.TYPE).isSupported) {
            if (this.f12833g != null) {
                this.f12833g.mo22083a((PreviewGestures.C2669a) new PreviewGestures.C2669a() {
                    public final void onTouch(MotionEvent motionEvent) {
                        MzARUI.this.m14651a(motionEvent);
                    }
                });
            }
            this.f12821N.mo23311a((ARRenderer.C2739a) new ARRenderer.C2739a() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12863a;

                /* renamed from: a */
                public void mo21971a(SurfaceTexture surfaceTexture, int i, int i2) {
                    if (!PatchProxy.proxy(new Object[]{surfaceTexture, new Integer(i), new Integer(i2)}, this, f12863a, false, 6383, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                        LogUtil.m15952c(MzARUI.f12807b, "onCameraDrawerCreated");
                        DuMixSource unused = MzARUI.this.f12818K = new DuMixSource(surfaceTexture, i, i2);
                        if (TextUtils.isEmpty("filepath")) {
                            MzARUI.this.f12818K.setArKey((String) null);
                            MzARUI.this.f12818K.setArType(5);
                            return;
                        }
                        MzARUI.this.f12818K.setArType(5);
                        MzARUI.this.f12818K.setResFilePath(Storage.m7750a().mo18643c(MzARUI.this.f12831e, String.valueOf(MzARUI.this.f12808A)));
                    }
                }

                /* renamed from: a */
                public void mo21972a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2) {
                    Object[] objArr = {surfaceTexture, onFrameAvailableListener, new Integer(i), new Integer(i2)};
                    ChangeQuickRedirect changeQuickRedirect = f12863a;
                    if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6384, new Class[]{SurfaceTexture.class, SurfaceTexture.OnFrameAvailableListener.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                        LogUtil.m15952c(MzARUI.f12807b, "onARDrawerCreated");
                        DuMixTarget unused = MzARUI.this.f12819L = new DuMixTarget(surfaceTexture, onFrameAvailableListener, i, i2, true);
                        if (MzARUI.this.f12818K != null) {
                            MzARUI.this.f12818K.setCameraSource((SurfaceTexture) null);
                        }
                        if (MzARController.f12803b.mo21932a() != null) {
                            MzARController.f12803b.mo21932a().setup(MzARUI.this.f12818K, MzARUI.this.f12819L, MzARUI.this.f12828U);
                            MzARController.f12803b.mo21932a().resume();
                        }
                    }
                }

                /* renamed from: b */
                public void mo21973b(SurfaceTexture surfaceTexture, int i, int i2) {
                    if (!PatchProxy.proxy(new Object[]{surfaceTexture, new Integer(i), new Integer(i2)}, this, f12863a, false, 6385, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                        LogUtil.m15952c(MzARUI.f12807b, "onARDrawerChanged");
                        if (MzARController.f12803b.mo21932a() != null) {
                            MzARController.f12803b.mo21932a().reSetup(surfaceTexture, i, i2);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14651a(MotionEvent motionEvent) {
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f12806a, false, 6368, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            if (motionEvent.getAction() == 0) {
                m14675e(false);
            } else if (motionEvent.getAction() == 1) {
                m14675e(true);
            }
            if (this.f12831e != null) {
                MzARController.f12803b.mo21932a().onTouchEvent(motionEvent);
            }
        }
    }

    /* renamed from: a */
    public void mo21939a(String str, long j, String str2) {
        Object[] objArr = {str, new Long(j), str2};
        ChangeQuickRedirect changeQuickRedirect = f12806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6328, new Class[]{String.class, Long.TYPE, String.class}, Void.TYPE).isSupported && MzARController.f12803b.mo21932a() != null) {
            MzARController.f12803b.mo21932a().takePicture(str, new TakePictureCallback(j, str2) {
                private final /* synthetic */ long f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r4;
                }

                public final void onPictureTake(boolean z, String str) {
                    MzARUI.this.m14645a(this.f$1, this.f$2, z, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14645a(long j, String str, boolean z, String str2) {
        Object[] objArr = {new Long(j), str, new Byte(z ? (byte) 1 : 0), str2};
        ChangeQuickRedirect changeQuickRedirect = f12806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6366, new Class[]{Long.TYPE, String.class, Boolean.TYPE, String.class}, Void.TYPE).isSupported) {
            this.f12811D.post(new Runnable(str2, j, str) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ long f$2;
                private final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r5;
                }

                public final void run() {
                    MzARUI.this.m14663b(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m14663b(String str, long j, String str2) {
        Object[] objArr = {str, new Long(j), str2};
        ChangeQuickRedirect changeQuickRedirect = f12806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6367, new Class[]{String.class, Long.TYPE, String.class}, Void.TYPE).isSupported) {
            this.f12830d.mo20390a(str, j, str2);
        }
    }

    /* renamed from: d */
    public void mo21947d(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6329, new Class[]{String.class}, Void.TYPE).isSupported && MzARController.f12803b.mo21932a() != null) {
            LogUtil.C2630a aVar = f12807b;
            LogUtil.m15942a(aVar, "start Recording filePath: " + str);
            this.f12813F = true;
            MzARController.f12803b.mo21932a().startRecord(str, 9000000, new MovieRecorderCallback() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12865a;

                public void onRecorderStart(boolean z) {
                    Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
                    ChangeQuickRedirect changeQuickRedirect = f12865a;
                    if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6386, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                        LogUtil.C2630a r = MzARUI.f12807b;
                        LogUtil.m15952c(r, "onRecorderStart: " + z);
                    }
                }

                public void onRecorderProcess(int i) {
                    if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12865a, false, 6387, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i == 100) {
                        boolean unused = MzARUI.this.f12813F = false;
                        LogUtil.C2630a r = MzARUI.f12807b;
                        LogUtil.m15952c(r, "onRecorderProcess: " + i);
                        MzARUI.this.f12830d.mo20414q();
                    }
                }

                public void onRecorderComplete(boolean z, String str) {
                    if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), str}, this, f12865a, false, 6388, new Class[]{Boolean.TYPE, String.class}, Void.TYPE).isSupported) {
                        boolean unused = MzARUI.this.f12813F = false;
                        LogUtil.C2630a r = MzARUI.f12807b;
                        LogUtil.m15952c(r, "onRecorderComplete: " + str);
                        if (MzARUI.this.f12830d != null) {
                            MzARUI.this.f12830d.mo20400d(str);
                        }
                    }
                }

                public void onRecorderError(int i) {
                    if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12865a, false, 6389, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                        boolean unused = MzARUI.this.f12813F = false;
                        LogUtil.C2630a r = MzARUI.f12807b;
                        LogUtil.m15952c(r, "onRecorderError: " + i);
                        MzARUI.this.f12830d.mo20414q();
                    }
                }
            });
        }
    }

    /* renamed from: i */
    public void mo21953i() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6330, new Class[0], Void.TYPE).isSupported && MzARController.f12803b.mo21932a() != null) {
            LogUtil.m15942a(f12807b, "stop Recording");
            MzARController.f12803b.mo21932a().stopRecord();
            m14632C();
        }
    }

    /* renamed from: j */
    public boolean mo21954j() {
        return this.f12813F;
    }

    /* renamed from: k */
    public int mo21955k() {
        return this.f12808A;
    }

    /* renamed from: l */
    public int mo21956l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12806a, false, 6331, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f12820M != null) {
            return this.f12820M.getWidth();
        }
        return CameraUtil.m15809a();
    }

    /* renamed from: m */
    public int mo21957m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12806a, false, 6332, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f12820M != null) {
            return this.f12820M.getHeight();
        }
        return CameraUtil.m15865b();
    }

    /* renamed from: a */
    public void mo21940a(ArrayList<ARSticker> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f12806a, false, 6333, new Class[]{ArrayList.class}, Void.TYPE).isSupported && this.f12841o != null) {
            this.f12811D.post(new Runnable(arrayList) {
                private final /* synthetic */ ArrayList f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MzARUI.this.m14664b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m14664b(ArrayList arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f12806a, false, 6365, new Class[]{ArrayList.class}, Void.TYPE).isSupported && this.f12841o != null) {
            this.f12841o.mo21980a((ArrayList<ARSticker>) arrayList);
            m14630A();
        }
    }

    /* renamed from: a */
    public void mo21935a(ARSticker aRSticker) {
        if (!PatchProxy.proxy(new Object[]{aRSticker}, this, f12806a, false, 6334, new Class[]{ARSticker.class}, Void.TYPE).isSupported && this.f12841o != null) {
            this.f12811D.post(new Runnable(aRSticker) {
                private final /* synthetic */ ARSticker f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MzARUI.this.m14661b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m14661b(ARSticker aRSticker) {
        if (!PatchProxy.proxy(new Object[]{aRSticker}, this, f12806a, false, 6364, new Class[]{ARSticker.class}, Void.TYPE).isSupported && this.f12841o != null) {
            this.f12841o.mo21979a(aRSticker);
        }
    }

    /* renamed from: A */
    private void m14630A() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6335, new Class[0], Void.TYPE).isSupported && !this.f12844r && this.f12841o.mo20093a() > 0) {
            m14677f("-1");
            this.f12844r = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14653a(ARSticker aRSticker, ARSticker.DownloadState downloadState) {
        Class[] clsArr = {ARSticker.class, ARSticker.DownloadState.class};
        if (!PatchProxy.proxy(new Object[]{aRSticker, downloadState}, this, f12806a, false, 6336, clsArr, Void.TYPE).isSupported) {
            aRSticker.mo19318a(downloadState);
            this.f12842p.mo20389a(String.valueOf(aRSticker.mo19315a()), downloadState.ordinal());
        }
    }

    /* renamed from: a */
    public void mo21937a(C2457a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f12806a, false, 6337, new Class[]{C2457a.class}, Void.TYPE).isSupported) {
            this.f12842p = aVar;
            this.f12811D.post(new Runnable() {
                public final void run() {
                    MzARUI.this.m14638I();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void m14638I() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6363, new Class[0], Void.TYPE).isSupported) {
            this.f12842p.mo20397b_();
        }
    }

    /* renamed from: a */
    public void mo20283a(String str, boolean z) {
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f12806a, false, 6338, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z && Integer.valueOf(str).intValue() == this.f12841o.mo21982d(this.f12809B).mo19315a()) {
                m14677f(str);
                UsageStatsHelper.m16042a(this.f12831e.getApplicationContext()).mo22691a("select_ar_sticker", "id", str);
            }
            new AsyncTaskEx<String, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12867a;

                /* renamed from: a */
                public Void mo17658a(String... strArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f12867a, false, 6390, new Class[]{String[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    MzARUI.this.f12842p.mo20396b(strArr[0]);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new String[]{str});
        }
    }

    /* renamed from: a */
    public void mo20282a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6339, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12807b;
            LogUtil.m15942a(aVar, "onStickerFileVerifyFailed  stickerId:" + str);
            if (this.f12841o != null && this.f12841o.mo21977a(str) != null) {
                this.f12841o.mo21981b(str);
                this.f12841o.mo26541f();
                m14635F();
            }
        }
    }

    /* renamed from: b */
    public void mo20284b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6340, new Class[]{String.class}, Void.TYPE).isSupported && this.f12841o != null && this.f12841o.mo21977a(str) != null) {
            this.f12841o.mo21977a(str).mo19318a(ARSticker.DownloadState.DOWNLOAD_FAILED);
            this.f12841o.mo26541f();
            m14635F();
            this.f12842p.mo20389a(str, ARSticker.DownloadState.DOWNLOAD_FAILED.ordinal());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m14681h(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6362, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f12842p.mo20388a(str);
        }
    }

    /* renamed from: c */
    public void mo20285c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6341, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f12811D.post(new Runnable(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MzARUI.this.m14681h(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void m14637H() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6361, new Class[0], Void.TYPE).isSupported) {
            this.f12842p.mo20397b_();
        }
    }

    /* renamed from: a */
    public void mo20281a() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6342, new Class[0], Void.TYPE).isSupported) {
            this.f12811D.post(new Runnable() {
                public final void run() {
                    MzARUI.this.m14637H();
                }
            });
        }
    }

    /* renamed from: B */
    private boolean m14631B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12806a, false, 6343, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f12838l != null && this.f12838l.getVisibility() == 0;
    }

    /* renamed from: c */
    public void mo21945c(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12806a, false, 6344, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f12838l != null) {
            TextView textView = this.f12838l;
            if (!z) {
                i = 4;
            }
            textView.setVisibility(i);
        }
    }

    /* renamed from: e */
    public void mo21949e(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6345, new Class[]{String.class}, Void.TYPE).isSupported && m14631B()) {
            this.f12838l.setText(str);
        }
    }

    /* renamed from: C */
    private void m14632C() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6346, new Class[0], Void.TYPE).isSupported) {
            this.f12838l.setText("00:00:00");
        }
    }

    /* renamed from: com.meizu.media.camera.ui.d$d */
    /* compiled from: MzARUI */
    public class C2460d extends SelectAdapter<C2461e> {

        /* renamed from: a */
        public static ChangeQuickRedirect f12875a;

        /* renamed from: f */
        private LayoutInflater f12877f;

        /* renamed from: g */
        private ArrayList<ARSticker> f12878g = new ArrayList<>();

        /* renamed from: h */
        private Map<ARSticker, C2461e> f12879h = new HashMap();

        C2460d(Context context) {
            this.f12877f = LayoutInflater.from(context);
        }

        /* renamed from: a */
        public C2461e mo20098b(ViewGroup viewGroup, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f12875a, false, 6399, new Class[]{ViewGroup.class, Integer.TYPE}, C2461e.class);
            return proxy.isSupported ? (C2461e) proxy.result : new C2461e(this.f12877f.inflate(R.layout.mz_ar_sticker_item, viewGroup, false));
        }

        /* renamed from: a */
        public void mo20097a(RecyclerView.C3286u uVar, int i) {
            boolean z = true;
            if (!PatchProxy.proxy(new Object[]{uVar, new Integer(i)}, this, f12875a, false, 6400, new Class[]{RecyclerView.C3286u.class, Integer.TYPE}, Void.TYPE).isSupported) {
                C2461e eVar = (C2461e) uVar;
                ARSticker aRSticker = this.f12878g.get(i);
                this.f12879h.put(aRSticker, eVar);
                if (aRSticker.mo19336h() != null) {
                    eVar.f12882d.setImageBitmap(aRSticker.mo19336h());
                } else {
                    eVar.f12882d.setImageResource(R.drawable.mz_ar_sticker_default);
                }
                eVar.f18121j.setTag(Integer.valueOf(i));
                boolean z2 = aRSticker.mo19315a() == MzARUI.this.f12808A;
                eVar.mo18785a(i == MzARUI.this.f12809B);
                if (z2 && MzARUI.this.f12839m != null) {
                    String k = aRSticker.mo19339k();
                    if (k == null || k.isEmpty() || aRSticker.mo19337i() == null) {
                        z = false;
                    }
                    if (z) {
                        MzARUI.this.f12839m.setVisibility(0);
                        MzARUI.this.f12839m.setImageBitmap(aRSticker.mo19337i());
                        MzARUI.this.f12839m.setOnClickListener(new View.OnClickListener(k) {
                            private final /* synthetic */ String f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                MzARUI.C2460d.this.m14757a(this.f$1, view);
                            }
                        });
                    } else {
                        MzARUI.this.f12839m.setImageBitmap((Bitmap) null);
                        MzARUI.this.f12839m.setVisibility(4);
                        MzARUI.this.f12839m.setOnClickListener((View.OnClickListener) null);
                    }
                }
                int i2 = 8;
                if (ARSticker.DownloadState.DOWNLOAD_FAILED.equals(aRSticker.mo19338j())) {
                    eVar.f12885g.setVisibility(0);
                    eVar.f12885g.setImageResource(R.drawable.mz_funnysnap_download);
                } else {
                    eVar.f12885g.setImageResource(R.drawable.mz_funnysnap_download);
                    eVar.f12885g.setVisibility(ARSticker.DownloadState.NOT_DOWNLOAD.equals(aRSticker.mo19338j()) ? 0 : 8);
                }
                ProgressBar progressBar = eVar.f12886h;
                if (ARSticker.DownloadState.DOWNLOADING.equals(aRSticker.mo19338j())) {
                    i2 = 0;
                }
                progressBar.setVisibility(i2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m14757a(String str, View view) {
            Class[] clsArr = {String.class, View.class};
            if (!PatchProxy.proxy(new Object[]{str, view}, this, f12875a, false, 6410, clsArr, Void.TYPE).isSupported) {
                LogUtil.C2630a r = MzARUI.f12807b;
                LogUtil.m15942a(r, "go to link view, url: " + str);
                UsageStatsHelper.m16042a(MzARUI.this.f12831e.getApplicationContext()).mo22691a("click_ar_link", "sticker_id", String.valueOf(MzARUI.this.f12808A));
                MzARUI.this.m14680g(str);
            }
        }

        /* renamed from: a */
        public int mo20093a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12875a, false, 6401, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f12878g.size();
        }

        /* renamed from: a */
        public void mo20095a(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12875a, false, 6402, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                super.mo20095a(i);
                if (!MzARUI.this.f12812E && MzARUI.this.f12841o != null && MzARUI.this.f12841o.mo20093a() > i) {
                    int unused = MzARUI.this.f12809B = i;
                    ARSticker d = MzARUI.this.f12841o.mo21982d(i);
                    int a = NetWorkUtils.m15976a(MzARUI.this.f12831e);
                    if (d.mo19332e()) {
                        if (a == -1) {
                            MzARUI.this.m14701v();
                            return;
                        }
                        MzARUI.this.f12842p.mo20398c();
                        MzARUI.this.f12842p.mo20397b_();
                    } else if (d.mo19338j() == ARSticker.DownloadState.DOWNLOADING) {
                        LogUtil.m15942a(MzARUI.f12807b, "ar sticker is downloading");
                    } else {
                        if (d.mo19336h() == null && d.mo19321b() != null) {
                            MzARUI.this.f12842p.mo20399c(d.mo19321b());
                        }
                        String valueOf = String.valueOf(d.mo19315a());
                        if (Storage.m7750a().mo18643c(MzARUI.this.f12831e, valueOf) == null) {
                            HashMap hashMap = new HashMap();
                            int i2 = 8;
                            if (a != 7) {
                                switch (a) {
                                    case -1:
                                        MzARUI.this.m14701v();
                                        return;
                                    case 0:
                                        C2461e eVar = this.f12879h.get(d);
                                        if (!MzARUI.this.f12834h.mo17877Z()) {
                                            MzARUI.this.m14646a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener(valueOf, d, hashMap, eVar) {
                                                private final /* synthetic */ String f$1;
                                                private final /* synthetic */ ARSticker f$2;
                                                private final /* synthetic */ Map f$3;
                                                private final /* synthetic */ MzARUI.C2461e f$4;

                                                {
                                                    this.f$1 = r2;
                                                    this.f$2 = r3;
                                                    this.f$3 = r4;
                                                    this.f$4 = r5;
                                                }

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    MzARUI.C2460d.this.m14758a(this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i);
                                                }
                                            });
                                            return;
                                        }
                                        LogUtil.m15942a(MzARUI.f12807b, "mStickerSelectListener, file is not download, start download!");
                                        MzARUI.this.f12842p.mo20391a(valueOf, d.mo19333f(), d.mo19335g(), false);
                                        MzARUI.this.m14653a(d, ARSticker.DownloadState.DOWNLOADING);
                                        C2461e eVar2 = this.f12879h.get(d);
                                        if (eVar2 != null) {
                                            ProgressBar progressBar = eVar2.f12886h;
                                            if (ARSticker.DownloadState.DOWNLOADING.equals(d.mo19338j())) {
                                                i2 = 0;
                                            }
                                            progressBar.setVisibility(i2);
                                            return;
                                        }
                                        return;
                                    case 1:
                                        MzARUI.this.m14653a(d, ARSticker.DownloadState.DOWNLOADING);
                                        C2461e eVar3 = this.f12879h.get(d);
                                        if (eVar3 != null) {
                                            ProgressBar progressBar2 = eVar3.f12886h;
                                            if (ARSticker.DownloadState.DOWNLOADING.equals(d.mo19338j())) {
                                                i2 = 0;
                                            }
                                            progressBar2.setVisibility(i2);
                                        }
                                        MzARUI.this.f12842p.mo20391a(valueOf, d.mo19333f(), d.mo19335g(), true);
                                        hashMap.put("type", "wifi");
                                        hashMap.put("ar_sticker_id", valueOf);
                                        UsageStatsHelper.m16042a(MzARUI.this.f12831e.getApplicationContext()).mo22693a("download_ar_sticker", (Map<String, String>) hashMap);
                                        return;
                                    default:
                                        return;
                                }
                            } else {
                                MzARUI.this.m14653a(d, ARSticker.DownloadState.DOWNLOADING);
                                C2461e eVar4 = this.f12879h.get(d);
                                if (eVar4 != null) {
                                    ProgressBar progressBar3 = eVar4.f12886h;
                                    if (ARSticker.DownloadState.DOWNLOADING.equals(d.mo19338j())) {
                                        i2 = 0;
                                    }
                                    progressBar3.setVisibility(i2);
                                }
                                MzARUI.this.f12842p.mo20391a(valueOf, d.mo19333f(), d.mo19335g(), true);
                                hashMap.put("type", "blue_tooth");
                                hashMap.put("ar_sticker_id", valueOf);
                                UsageStatsHelper.m16042a(MzARUI.this.f12831e.getApplicationContext()).mo22693a("download_ar_sticker", (Map<String, String>) hashMap);
                            }
                        } else {
                            if (valueOf.equals(String.valueOf(MzARUI.this.f12808A))) {
                                MzARUI.this.m14702w();
                            } else {
                                MzARUI.this.m14677f(valueOf);
                            }
                            UsageStatsHelper.m16042a(MzARUI.this.f12831e.getApplicationContext()).mo22691a("select_ar_sticker", "id", valueOf);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m14758a(String str, ARSticker aRSticker, Map map, C2461e eVar, DialogInterface dialogInterface, int i) {
            String str2 = str;
            ARSticker aRSticker2 = aRSticker;
            Map map2 = map;
            C2461e eVar2 = eVar;
            int i2 = 0;
            Object[] objArr = {str2, aRSticker2, map2, eVar2, dialogInterface, new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f12875a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6409, new Class[]{String.class, ARSticker.class, Map.class, C2461e.class, DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                LogUtil.m15942a(MzARUI.f12807b, "TYPE_MOBILE, file is not download, start download!");
                MzARUI.this.f12842p.mo20391a(str2, aRSticker.mo19333f(), aRSticker.mo19335g(), false);
                map2.put("type", "mobile");
                map2.put("ar_sticker_id", str2);
                UsageStatsHelper.m16042a(MzARUI.this.f12831e.getApplicationContext()).mo22693a("download_ar_sticker", (Map<String, String>) map2);
                MzARUI.this.m14653a(aRSticker2, ARSticker.DownloadState.DOWNLOADING);
                if (eVar2 != null) {
                    ProgressBar progressBar = eVar2.f12886h;
                    if (!ARSticker.DownloadState.DOWNLOADING.equals(aRSticker.mo19338j())) {
                        i2 = 8;
                    }
                    progressBar.setVisibility(i2);
                }
                MzARUI.this.f12834h.mo17949l(true);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public ARSticker mo21982d(int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12875a, false, 6403, new Class[]{Integer.TYPE}, ARSticker.class);
            return proxy.isSupported ? (ARSticker) proxy.result : this.f12878g.get(i);
        }

        /* renamed from: c */
        public long mo20100c(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f12875a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 6404, new Class[]{Integer.TYPE}, Long.TYPE);
            if (proxy.isSupported) {
                return ((Long) proxy.result).longValue();
            }
            ARSticker d = mo21982d(i);
            if (d == null) {
                return -1;
            }
            return (long) d.mo19315a();
        }

        /* renamed from: a */
        public void mo21980a(ArrayList<ARSticker> arrayList) {
            if (!PatchProxy.proxy(new Object[]{arrayList}, this, f12875a, false, 6405, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
                if (arrayList.size() == this.f12878g.size()) {
                    Iterator<ARSticker> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ARSticker next = it.next();
                        for (int i = 0; i < this.f12878g.size(); i++) {
                            ARSticker aRSticker = this.f12878g.get(i);
                            if (next.mo19315a() == aRSticker.mo19315a() && next.mo19338j() != aRSticker.mo19338j()) {
                                aRSticker.mo19318a(next.mo19338j());
                                C2461e eVar = this.f12879h.get(aRSticker);
                                if (eVar != null) {
                                    int i2 = 8;
                                    if (ARSticker.DownloadState.DOWNLOAD_FAILED.equals(aRSticker.mo19338j())) {
                                        eVar.f12885g.setVisibility(0);
                                        eVar.f12885g.setImageResource(R.drawable.mz_funnysnap_download);
                                    } else {
                                        eVar.f12885g.setImageResource(R.drawable.mz_funnysnap_download);
                                        eVar.f12885g.setVisibility(ARSticker.DownloadState.NOT_DOWNLOAD.equals(aRSticker.mo19338j()) ? 0 : 8);
                                    }
                                    ProgressBar progressBar = eVar.f12886h;
                                    if (ARSticker.DownloadState.DOWNLOADING.equals(aRSticker.mo19338j())) {
                                        i2 = 0;
                                    }
                                    progressBar.setVisibility(i2);
                                }
                            }
                        }
                    }
                    return;
                }
                this.f12878g.clear();
                this.f12878g.addAll(arrayList);
                mo26541f();
                MzARUI.this.m14635F();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ARSticker mo21977a(String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12875a, false, 6406, new Class[]{String.class}, ARSticker.class);
            if (proxy.isSupported) {
                return (ARSticker) proxy.result;
            }
            Iterator<ARSticker> it = this.f12878g.iterator();
            while (it.hasNext()) {
                ARSticker next = it.next();
                if (str.equals(String.valueOf(next.mo19315a()))) {
                    return next;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo21981b(String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, f12875a, false, 6407, new Class[]{String.class}, Void.TYPE).isSupported) {
                Iterator<ARSticker> it = this.f12878g.iterator();
                while (it.hasNext()) {
                    if (str.equals(String.valueOf(it.next().mo19315a()))) {
                        it.remove();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo21979a(ARSticker aRSticker) {
            int i = 0;
            if (!PatchProxy.proxy(new Object[]{aRSticker}, this, f12875a, false, 6408, new Class[]{ARSticker.class}, Void.TYPE).isSupported) {
                while (true) {
                    if (i >= this.f12878g.size()) {
                        i = -1;
                        break;
                    } else if (this.f12878g.get(i).mo19315a() == aRSticker.mo19315a()) {
                        this.f12878g.set(i, aRSticker);
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    mo26542h(i);
                    MzARUI.this.m14635F();
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.ui.d$e */
    /* compiled from: MzARUI */
    public class C2461e extends BaseViewHolder {

        /* renamed from: b */
        public static ChangeQuickRedirect f12880b;

        /* renamed from: c */
        boolean f12881c;

        /* renamed from: d */
        ImageView f12882d;

        /* renamed from: e */
        ImageView f12883e;

        /* renamed from: f */
        ImageView f12884f;

        /* renamed from: g */
        ImageView f12885g;

        /* renamed from: h */
        ProgressBar f12886h;

        public C2461e(View view) {
            super(view);
            this.f7557a = view.findViewById(R.id.mz_sticker_item);
            this.f12882d = (ImageView) view.findViewById(R.id.mz_ar_sticker_img);
            this.f12883e = (ImageView) view.findViewById(R.id.mz_ar_sticker_selected);
            this.f12884f = (ImageView) view.findViewById(R.id.mz_ar_left_corner_img);
            this.f12885g = (ImageView) view.findViewById(R.id.mz_ar_right_corner_img);
            this.f12886h = (ProgressBar) view.findViewById(R.id.mz_ar_loadingView);
        }

        /* renamed from: a */
        public void mo18785a(boolean z) {
            int i = 0;
            if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12880b, false, 6411, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                this.f12881c = z;
                ImageView imageView = this.f12883e;
                if (!z) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: d */
    public void m14671d(boolean z) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12806a, false, 6347, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f12845s >= 4) {
            return;
        }
        if (this.f12845s >= 2 && z) {
            return;
        }
        if (this.f12845s != 3 || m14657a(this.f12808A)) {
            if (this.f12846t == null) {
                this.f12846t = CameraUtil.m15889d(this.f12832f);
                LayoutInflater.from(this.f12831e).inflate(R.layout.mz_ar_guide, this.f12846t, true);
            }
            this.f12847u = (FrameLayout) this.f12846t.findViewById(R.id.mz_ar_guide_container);
            this.f12848v = (TextView) this.f12846t.findViewById(R.id.mz_ar_guide_text);
            this.f12848v.setTypeface(Typeface.create("Flyme-Medium", 0));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12848v.getLayoutParams();
            layoutParams.topMargin = CameraUtil.m15901h();
            this.f12848v.setLayoutParams(layoutParams);
            m14633D();
        }
    }

    /* renamed from: D */
    private void m14633D() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6348, new Class[0], Void.TYPE).isSupported) {
            if (this.f12845s >= 4 || this.f12847u == null) {
                m14634E();
                return;
            }
            m14678f(true);
            this.f12847u.removeView(this.f12849w);
            this.f12849w = null;
            this.f12849w = new OperatingGuideView(this.f12831e);
            switch (this.f12845s) {
                case 0:
                    this.f12848v.setText(R.string.mz_ar_guide_move);
                    this.f12849w.setOperationType(2);
                    this.f12849w.setDrag(true);
                    break;
                case 1:
                    this.f12848v.setText(R.string.mz_ar_guide_scale);
                    this.f12849w.setOperationType(5);
                    this.f12849w.setGesturePoints(2);
                    break;
                case 2:
                    this.f12848v.setText(R.string.mz_ar_guide_rotate);
                    this.f12849w.setOperationType(2);
                    this.f12849w.setGesturePoints(2);
                    break;
                case 3:
                    this.f12848v.setText(R.string.mz_ar_guide_interact);
                    this.f12849w.setOperationType(0);
                    break;
            }
            this.f12847u.addView(this.f12849w);
            this.f12848v.setVisibility(0);
            this.f12849w.mo16995a();
        }
    }

    /* renamed from: e */
    private void m14675e(boolean z) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12806a, false, 6349, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f12845s >= 4) {
            return;
        }
        if (!z && this.f12847u != null && this.f12848v != null && this.f12849w != null) {
            m14678f(true);
            this.f12848v.setVisibility(8);
            this.f12847u.removeView(this.f12849w);
            this.f12849w = null;
            this.f12845s++;
            if (this.f12843q != null) {
                this.f12843q.edit().putInt("ar_mode_guide_show_count", this.f12845s).apply();
            }
        } else if (!z) {
        } else {
            if (this.f12845s < 2 || (this.f12845s == 3 && m14657a(this.f12808A))) {
                m14633D();
            }
        }
    }

    /* renamed from: f */
    private void m14678f(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12806a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6350, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f12849w == null) {
            return;
        }
        if (z) {
            this.f12849w.mo16996b();
        } else {
            this.f12849w.mo16995a();
        }
    }

    /* renamed from: E */
    private void m14634E() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6351, new Class[0], Void.TYPE).isSupported) {
            m14678f(true);
            this.f12849w = null;
            if (this.f12846t != null) {
                this.f12846t.removeView(this.f12847u);
                this.f12846t.removeView(this.f12848v);
            }
            this.f12847u = null;
            this.f12848v = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m14680g(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12806a, false, 6352, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (str.startsWith("HTTP://")) {
                str = "http" + str.substring(4);
            } else if (str.startsWith("HTTPS://")) {
                str = "https" + str.substring(5);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            this.f12832f.startActivity(intent);
        }
    }

    /* renamed from: com.meizu.media.camera.ui.d$c */
    /* compiled from: MzARUI */
    private class C2459c implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: a */
        public static ChangeQuickRedirect f12873a;

        private C2459c() {
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{egl10, eGLDisplay}, this, f12873a, false, 6398, new Class[]{EGL10.class, EGLDisplay.class}, EGLConfig.class);
            if (proxy.isSupported) {
                return (EGLConfig) proxy.result;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, new int[]{12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 4, 12344}, eGLConfigArr, 1, iArr);
            if (iArr[0] == 0) {
                return null;
            }
            return eGLConfigArr[0];
        }
    }

    /* renamed from: n */
    public void mo21958n() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6353, new Class[0], Void.TYPE).isSupported && this.f12815H != null) {
            this.f12815H.close();
            this.f12815H.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
            this.f12815H = null;
        }
    }

    /* renamed from: a */
    private boolean m14657a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12806a, false, 6354, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f12841o == null || this.f12841o.mo21977a(String.valueOf(i)) == null) {
            return false;
        }
        return this.f12841o.mo21977a(String.valueOf(i)).mo19341m();
    }

    /* renamed from: o */
    public boolean mo21959o() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12806a, false, 6355, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f12852z != null && this.f12852z.isShowing();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: p */
    public void mo21960p() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6356, new Class[0], Void.TYPE).isSupported) {
            if (this.f12852z == null) {
                this.f12851y = LayoutInflater.from(this.f12831e).inflate(R.layout.mz_ar_mode_info, (ViewGroup) null, false);
                this.f12852z = new AlertDialog.Builder(this.f12832f, R.style.CustomDeviceMarkStyle).mo25138b(this.f12851y).mo25125a((int) R.string.dialog_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f12871a;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f12871a, false, 6397, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                            dialogInterface.dismiss();
                        }
                    }
                }).mo25141b();
                this.f12852z.setCanceledOnTouchOutside(true);
                this.f12852z.setCancelable(true);
                ((TextView) this.f12851y.findViewById(R.id.mz_ar_info_title)).setTypeface(Typeface.create("sans-serif-medium", 0));
                ((TextView) this.f12851y.findViewById(R.id.mz_ar_info_desc)).setTypeface(Typeface.create("SFDIN-Regular", 0));
            }
            mo21961q();
            this.f12852z.show();
            this.f12852z.mo25117a(-1).setTypeface(Typeface.create("sans-serif-medium", 0));
        }
    }

    /* renamed from: q */
    public void mo21961q() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6357, new Class[0], Void.TYPE).isSupported && mo21959o()) {
            this.f12852z.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m14635F() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6358, new Class[0], Void.TYPE).isSupported && this.f12817J != null) {
            this.f12817J.post(new Runnable() {
                public final void run() {
                    MzARUI.this.m14636G();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void m14636G() {
        if (!PatchProxy.proxy(new Object[0], this, f12806a, false, 6360, new Class[0], Void.TYPE).isSupported) {
            this.f12816I.mo20070a((RecyclerView) this.f12817J);
        }
    }

    /* renamed from: a */
    private AnimatorSet m14641a(View view, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, new Byte(z ? (byte) 1 : 0)}, this, f12806a, false, 6359, new Class[]{View.class, Boolean.TYPE}, AnimatorSet.class);
        if (proxy.isSupported) {
            return (AnimatorSet) proxy.result;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        int dimensionPixelOffset = this.f12831e.getResources().getDimensionPixelOffset(R.dimen.mz_funny_snap_anim_translation);
        float[] fArr = new float[2];
        fArr[0] = z ? (float) dimensionPixelOffset : 0.0f;
        fArr[1] = z ? 0.0f : (float) dimensionPixelOffset;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 0.0f : 1.0f;
        fArr2[1] = z ? 1.0f : 0.0f;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", fArr2);
        PathInterpolator pathInterpolator = new PathInterpolator(0.15f, 0.43f, 0.21f, 1.0f);
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        ofFloat2.setInterpolator(pathInterpolator2);
        if (z) {
            ofFloat.setInterpolator(pathInterpolator);
        } else {
            ofFloat.setInterpolator(pathInterpolator2);
        }
        animatorSet.setDuration(z ? 170 : 100);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }
}
