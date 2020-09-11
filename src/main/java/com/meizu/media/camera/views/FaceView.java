package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import com.meizu.media.camera.R;
import com.meizu.media.camera.agegender.AgeGenderEngine;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

public class FaceView extends View implements MzCamUI.C2499c, FocusIndicator, Rotatable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14511a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f14512b = new LogUtil.C2630a("FaceView");

    /* renamed from: A */
    private int f14513A;

    /* renamed from: B */
    private int f14514B;

    /* renamed from: C */
    private final int f14515C;

    /* renamed from: D */
    private final int f14516D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f14517E = false;

    /* renamed from: F */
    private int f14518F = 1;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f14519G = 1;

    /* renamed from: H */
    private boolean f14520H;

    /* renamed from: I */
    private int f14521I;

    /* renamed from: J */
    private int f14522J;

    /* renamed from: K */
    private int f14523K;

    /* renamed from: L */
    private boolean f14524L = false;

    /* renamed from: M */
    private Bitmap f14525M = null;

    /* renamed from: N */
    private Bitmap f14526N = null;

    /* renamed from: O */
    private int f14527O;

    /* renamed from: P */
    private int f14528P;

    /* renamed from: Q */
    private int f14529Q;

    /* renamed from: R */
    private int f14530R;

    /* renamed from: S */
    private int f14531S;

    /* renamed from: T */
    private Handler f14532T = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f14556a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f14556a, false, 8353, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        boolean unused = FaceView.this.f14517E = false;
                        FaceView.this.m16407a(FaceView.this.f14540j);
                        int unused2 = FaceView.this.f14519G = 1;
                        FaceView.this.m16415h();
                        return;
                    case 2:
                        LogUtil.m15954d(FaceView.f14512b, "handleMessage MSG_HIDE_FACES");
                        boolean unused3 = FaceView.this.f14551v = true;
                        boolean unused4 = FaceView.this.f14550u = false;
                        int unused5 = FaceView.this.f14519G = 1;
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: c */
    private int f14533c;

    /* renamed from: d */
    private int f14534d;

    /* renamed from: e */
    private boolean f14535e;

    /* renamed from: f */
    private boolean f14536f;

    /* renamed from: g */
    private boolean f14537g;

    /* renamed from: h */
    private Matrix f14538h = new Matrix();

    /* renamed from: i */
    private RectF f14539i = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CameraController.C1880f[] f14540j;

    /* renamed from: k */
    private List<C2688a> f14541k = new ArrayList();

    /* renamed from: l */
    private int f14542l;

    /* renamed from: m */
    private final int f14543m;

    /* renamed from: n */
    private final int f14544n;

    /* renamed from: o */
    private final int f14545o;

    /* renamed from: p */
    private final int f14546p;

    /* renamed from: q */
    private final int f14547q;

    /* renamed from: r */
    private Paint f14548r;

    /* renamed from: s */
    private volatile boolean f14549s;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public volatile boolean f14550u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public volatile boolean f14551v;

    /* renamed from: w */
    private int f14552w;

    /* renamed from: x */
    private Rect f14553x;

    /* renamed from: y */
    private float f14554y;

    /* renamed from: z */
    private float f14555z = 1.0f;

    /* renamed from: b */
    public void mo22845b(boolean z) {
    }

    public FaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f14543m = resources.getColor(R.color.face_detect_start);
        this.f14544n = resources.getColor(R.color.face_detect_success);
        this.f14545o = resources.getColor(R.color.face_detect_fail);
        this.f14546p = resources.getColor(R.color.face_man);
        this.f14547q = resources.getColor(R.color.face_women);
        this.f14542l = this.f14543m;
        this.f14548r = new Paint();
        this.f14548r.setAntiAlias(true);
        this.f14548r.setStyle(Paint.Style.STROKE);
        this.f14548r.setStrokeWidth(resources.getDimension(R.dimen.face_round_rect_stroke_width));
        this.f14552w = (int) resources.getDimension(R.dimen.face_round_rect_radius);
        this.f14515C = getResources().getDimensionPixelSize(R.dimen.mz_watch_top_bar_height_4_3);
        this.f14516D = getResources().getDimensionPixelSize(R.dimen.mz_watch_top_bar_height_16_9);
        this.f14522J = (int) resources.getDimension(R.dimen.face_round_corner_length);
        this.f14523K = (int) resources.getDimension(R.dimen.face_round_arc_length);
        this.f14527O = (int) resources.getDimension(R.dimen.face_round_gender_length);
        this.f14528P = this.f14527O / 2;
        this.f14530R = (int) resources.getDimension(R.dimen.face_round_man_margin);
        this.f14529Q = (int) resources.getDimension(R.dimen.face_round_women_margin);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        this.f14525M = BitmapFactory.decodeResource(resources, R.drawable.man, options);
        this.f14526N = BitmapFactory.decodeResource(resources, R.drawable.women, options);
    }

    /* renamed from: a */
    public void mo22243a(int i, int i2) {
        this.f14513A = i;
        this.f14514B = i2;
    }

    /* renamed from: a */
    public void mo22841a(Rect rect, float f) {
        this.f14553x = rect;
        this.f14554y = f / 100.0f;
    }

    public void setFaces(CameraController.C1880f[] fVarArr) {
        if (!PatchProxy.proxy(new Object[]{fVarArr}, this, f14511a, false, 8334, new Class[]{CameraController.C1880f[].class}, Void.TYPE).isSupported && !this.f14537g) {
            if (this.f14541k != null) {
                if (this.f14541k.size() != fVarArr.length) {
                    m16414g();
                }
                if ((fVarArr.length > 0 && this.f14541k.size() == 0) || (fVarArr.length == 0 && this.f14541k.size() > 0)) {
                    this.f14540j = fVarArr;
                    if (!this.f14517E) {
                        this.f14517E = true;
                        this.f14532T.sendEmptyMessageDelayed(1, 140);
                        return;
                    }
                    return;
                }
            }
            if (this.f14517E) {
                this.f14517E = false;
                this.f14532T.removeMessages(1);
            }
            if (!this.f14520H) {
                m16407a(fVarArr);
                m16415h();
            }
        }
    }

    public void setDisplayOrientation(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14511a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8335, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14533c = i;
            LogUtil.C2630a aVar = f14512b;
            LogUtil.m15954d(aVar, "mDisplayOrientation=" + i);
        }
    }

    public void setOrientation(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14511a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8336, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14534d = i;
            invalidate();
        }
    }

    public void setMirror(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14511a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8337, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14535e = z;
            LogUtil.C2630a aVar = f14512b;
            LogUtil.m15954d(aVar, "mMirror=" + z);
        }
    }

    public void setWatchCamera(boolean z) {
        this.f14536f = z;
    }

    /* renamed from: a */
    public boolean mo22843a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14511a, false, 8338, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f14541k != null && this.f14541k.size() > 0;
    }

    /* renamed from: a */
    public void mo22840a(long j) {
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f14511a, false, 8340, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            this.f14542l = this.f14544n;
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo22842a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f14511a, false, 8341, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14542l = this.f14545o;
            invalidate();
        }
    }

    /* renamed from: b */
    public void mo22844b() {
        if (!PatchProxy.proxy(new Object[0], this, f14511a, false, 8342, new Class[0], Void.TYPE).isSupported) {
            this.f14542l = this.f14543m;
            if (this.f14541k != null) {
                this.f14541k.clear();
            }
            m16414g();
            this.f14532T.removeMessages(1);
            this.f14517E = false;
            postInvalidate();
        }
    }

    /* renamed from: c */
    public void mo22846c() {
        this.f14537g = true;
    }

    /* renamed from: d */
    public void mo22847d() {
        if (!PatchProxy.proxy(new Object[0], this, f14511a, false, 8343, new Class[0], Void.TYPE).isSupported) {
            this.f14537g = false;
            m16414g();
        }
    }

    public void setBlockDraw(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14511a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8344, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14549s = z;
            if (this.f14549s) {
                m16414g();
            }
        }
    }

    /* renamed from: g */
    private void m16414g() {
        if (!PatchProxy.proxy(new Object[0], this, f14511a, false, 8345, new Class[0], Void.TYPE).isSupported) {
            this.f14550u = false;
            this.f14551v = false;
            this.f14532T.removeMessages(2);
        }
    }

    public void setGenderEstimation(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14511a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8346, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14524L = z;
            LogUtil.C2630a aVar = f14512b;
            LogUtil.m15954d(aVar, "mIsGenderEstimated=" + this.f14524L);
        }
    }

    /* renamed from: e */
    public boolean mo22848e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14511a, false, 8347, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f14541k.size() <= 0) {
            return false;
        }
        int i = 0;
        while (i < this.f14541k.size()) {
            CameraController.C1880f fVar = this.f14541k.get(i).f14559b;
            if (fVar.mo19560e() == AgeGenderEngine.f7572c || fVar.mo19560e() == AgeGenderEngine.f7571b) {
                i++;
            } else {
                LogUtil.C2630a aVar = f14512b;
                LogUtil.m15954d(aVar, "faceGenderEffective=false index:" + i + " gender" + fVar.mo19560e());
                return false;
            }
        }
        return true;
    }

    public void setFaceOrientation(int i) {
        this.f14531S = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r19) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = 1
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r10 = 0
            r0[r10] = r8
            com.meizu.savior.ChangeQuickRedirect r2 = f14511a
            java.lang.Class[] r5 = new java.lang.Class[r9]
            java.lang.Class<android.graphics.Canvas> r1 = android.graphics.Canvas.class
            r5[r10] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 8348(0x209c, float:1.1698E-41)
            r1 = r18
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            boolean r0 = r7.f14549s
            r1 = 15
            if (r0 != 0) goto L_0x032b
            boolean r0 = r7.f14551v
            if (r0 == 0) goto L_0x0030
            int r0 = r7.f14519G
            if (r0 >= r1) goto L_0x032b
        L_0x0030:
            java.util.List<com.meizu.media.camera.views.FaceView$a> r0 = r7.f14541k
            if (r0 == 0) goto L_0x032b
            java.util.List<com.meizu.media.camera.views.FaceView$a> r0 = r7.f14541k
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x032b
            android.graphics.Rect r0 = r7.f14553x
            if (r0 != 0) goto L_0x004c
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = r0.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r0 != r2) goto L_0x032b
        L_0x004c:
            boolean r0 = r7.f14524L
            if (r0 == 0) goto L_0x0056
            boolean r0 = r18.mo22848e()
            if (r0 != 0) goto L_0x005a
        L_0x0056:
            boolean r0 = r7.f14524L
            if (r0 != 0) goto L_0x032b
        L_0x005a:
            int r0 = r7.f14513A
            int r2 = r7.f14514B
            float r3 = (float) r2
            float r4 = (float) r0
            float r3 = r3 / r4
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r3 = com.meizu.media.camera.util.CameraUtil.m15829a((float) r3)
            if (r2 <= r0) goto L_0x0071
            int r4 = r7.f14533c
            if (r4 == 0) goto L_0x007f
            int r4 = r7.f14533c
            r5 = 180(0xb4, float:2.52E-43)
            if (r4 == r5) goto L_0x007f
        L_0x0071:
            if (r0 <= r2) goto L_0x0084
            int r4 = r7.f14533c
            r5 = 90
            if (r4 == r5) goto L_0x007f
            int r4 = r7.f14533c
            r5 = 270(0x10e, float:3.78E-43)
            if (r4 != r5) goto L_0x0084
        L_0x007f:
            r17 = r2
            r2 = r0
            r0 = r17
        L_0x0084:
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = r4.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r5 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r4 != r5) goto L_0x00d0
            android.graphics.Rect r4 = r7.f14553x
            int r4 = r4.width()
            int r4 = r4 * r0
            android.graphics.Rect r5 = r7.f14553x
            int r5 = r5.height()
            int r5 = r5 * r2
            if (r4 == r5) goto L_0x00d0
            if (r0 == r2) goto L_0x00c1
            int r4 = r2 * 288
            int r5 = r0 * 352
            if (r4 == r5) goto L_0x00c1
            int r4 = r2 * 480
            int r5 = r0 * 800
            if (r4 != r5) goto L_0x00b1
            goto L_0x00c1
        L_0x00b1:
            android.graphics.Rect r0 = r7.f14553x
            int r0 = r0.height()
            int r0 = r0 * r2
            android.graphics.Rect r4 = r7.f14553x
            int r4 = r4.width()
            int r0 = r0 / r4
            goto L_0x00d0
        L_0x00c1:
            android.graphics.Rect r2 = r7.f14553x
            int r2 = r2.width()
            int r2 = r2 * r0
            android.graphics.Rect r4 = r7.f14553x
            int r4 = r4.height()
            int r2 = r2 / r4
        L_0x00d0:
            r16 = r2
            android.graphics.Matrix r11 = r7.f14538h
            boolean r12 = r7.f14535e
            boolean r13 = r7.f14536f
            int r14 = r7.f14533c
            r15 = r0
            com.meizu.media.camera.util.CameraUtil.m15849a(r11, r12, r13, r14, r15, r16)
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r2 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_4_3
            if (r3 != r2) goto L_0x00f9
            boolean r2 = r7.f14536f
            if (r2 == 0) goto L_0x00e9
            int r2 = r7.f14515C
            goto L_0x010e
        L_0x00e9:
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13874aa
            if (r2 != 0) goto L_0x00f4
            boolean r2 = com.meizu.media.camera.util.NavigationBarUtils.m15972a()
            if (r2 == 0) goto L_0x00f4
            goto L_0x010d
        L_0x00f4:
            int r2 = com.meizu.media.camera.util.CameraUtil.m15901h()
            goto L_0x010e
        L_0x00f9:
            boolean r2 = r7.f14536f
            if (r2 == 0) goto L_0x0100
            int r2 = r7.f14516D
            goto L_0x010e
        L_0x0100:
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13874aa
            if (r2 == 0) goto L_0x010d
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r2 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_16_9
            if (r2 != r3) goto L_0x010d
            int r2 = com.meizu.media.camera.util.CameraUtil.m15901h()
            goto L_0x010e
        L_0x010d:
            r2 = 0
        L_0x010e:
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = r3.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r3 != r4) goto L_0x012b
            int r3 = r18.getWidth()
            int r4 = r7.f14513A
            int r3 = r3 - r4
            int r3 = r3 / 2
            int r4 = r7.f14513A
            int r0 = r0 - r4
            int r0 = r0 / 2
            int r0 = r3 - r0
            goto L_0x012c
        L_0x012b:
            r0 = 0
        L_0x012c:
            int r3 = r7.f14521I
            int r2 = r2 - r3
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = r3.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r3 != r4) goto L_0x0182
            android.graphics.Rect r3 = r7.f14553x
            if (r3 == 0) goto L_0x0182
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            android.graphics.Rect r4 = r7.f14553x
            int r4 = r4.width()
            int r4 = -r4
            float r4 = (float) r4
            r6 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r6
            android.graphics.Rect r11 = r7.f14553x
            int r11 = r11.height()
            int r11 = -r11
            float r11 = (float) r11
            float r11 = r11 / r6
            r3.preTranslate(r4, r11)
            android.graphics.Rect r4 = r7.f14553x
            int r4 = r4.width()
            float r4 = (float) r4
            r6 = 1157234688(0x44fa0000, float:2000.0)
            float r4 = r6 / r4
            float r11 = r7.f14554y
            float r4 = r4 * r11
            float r11 = r7.f14555z
            float r4 = r4 * r11
            android.graphics.Rect r11 = r7.f14553x
            int r11 = r11.height()
            float r11 = (float) r11
            float r6 = r6 / r11
            float r11 = r7.f14554y
            float r6 = r6 * r11
            float r11 = r7.f14555z
            float r6 = r6 * r11
            r3.postScale(r4, r6)
            goto L_0x0183
        L_0x0182:
            r3 = 0
        L_0x0183:
            r19.save()
            android.graphics.Matrix r4 = r7.f14538h
            int r6 = r7.f14534d
            float r6 = (float) r6
            r4.postRotate(r6)
            int r4 = r7.f14534d
            int r4 = -r4
            float r4 = (float) r4
            r8.rotate(r4)
            int r4 = r7.f14518F
            r6 = 8
            if (r4 <= r6) goto L_0x019d
            r7.f14518F = r6
        L_0x019d:
            int r4 = r7.f14519G
            if (r4 <= r1) goto L_0x01a3
            r7.f14519G = r1
        L_0x01a3:
            r4 = 0
        L_0x01a4:
            java.util.List<com.meizu.media.camera.views.FaceView$a> r11 = r7.f14541k
            int r11 = r11.size()
            if (r4 >= r11) goto L_0x0306
            java.util.List<com.meizu.media.camera.views.FaceView$a> r11 = r7.f14541k
            java.lang.Object r11 = r11.get(r4)
            com.meizu.media.camera.views.FaceView$a r11 = (com.meizu.media.camera.views.FaceView.C2688a) r11
            com.meizu.media.camera.camcontroller.CameraController$f r12 = r11.f14559b
            int r13 = r12.mo19560e()
            com.meizu.media.camera.camcontroller.CameraController$f r14 = r11.f14558a
            if (r14 == 0) goto L_0x0264
            com.meizu.media.camera.camcontroller.CameraController$f r12 = r11.f14558a
            com.meizu.media.camera.camcontroller.CameraController$f r14 = r11.f14559b
            int r14 = r14.mo19555a()
            r15 = 50
            if (r14 >= r15) goto L_0x01cc
            goto L_0x0300
        L_0x01cc:
            com.meizu.media.camera.camcontroller.CameraController$f r14 = r11.f14558a
            android.graphics.Rect r14 = r14.mo19557b()
            int r14 = r14.top
            float r14 = (float) r14
            com.meizu.media.camera.camcontroller.CameraController$f r15 = r11.f14559b
            android.graphics.Rect r15 = r15.mo19557b()
            int r15 = r15.top
            com.meizu.media.camera.camcontroller.CameraController$f r5 = r11.f14558a
            android.graphics.Rect r5 = r5.mo19557b()
            int r5 = r5.top
            int r15 = r15 - r5
            float r5 = (float) r15
            int r15 = r7.f14518F
            float r15 = (float) r15
            r16 = 1090519040(0x41000000, float:8.0)
            float r15 = r15 / r16
            float r5 = r5 * r15
            float r14 = r14 + r5
            com.meizu.media.camera.camcontroller.CameraController$f r5 = r11.f14558a
            android.graphics.Rect r5 = r5.mo19557b()
            int r5 = r5.bottom
            float r5 = (float) r5
            com.meizu.media.camera.camcontroller.CameraController$f r15 = r11.f14559b
            android.graphics.Rect r15 = r15.mo19557b()
            int r15 = r15.bottom
            com.meizu.media.camera.camcontroller.CameraController$f r9 = r11.f14558a
            android.graphics.Rect r9 = r9.mo19557b()
            int r9 = r9.bottom
            int r15 = r15 - r9
            float r9 = (float) r15
            int r15 = r7.f14518F
            float r15 = (float) r15
            float r15 = r15 / r16
            float r9 = r9 * r15
            float r5 = r5 + r9
            com.meizu.media.camera.camcontroller.CameraController$f r9 = r11.f14558a
            android.graphics.Rect r9 = r9.mo19557b()
            int r9 = r9.left
            float r9 = (float) r9
            com.meizu.media.camera.camcontroller.CameraController$f r15 = r11.f14559b
            android.graphics.Rect r15 = r15.mo19557b()
            int r15 = r15.left
            com.meizu.media.camera.camcontroller.CameraController$f r10 = r11.f14558a
            android.graphics.Rect r10 = r10.mo19557b()
            int r10 = r10.left
            int r15 = r15 - r10
            float r10 = (float) r15
            int r15 = r7.f14518F
            float r15 = (float) r15
            float r15 = r15 / r16
            float r10 = r10 * r15
            float r9 = r9 + r10
            com.meizu.media.camera.camcontroller.CameraController$f r10 = r11.f14558a
            android.graphics.Rect r10 = r10.mo19557b()
            int r10 = r10.right
            float r10 = (float) r10
            com.meizu.media.camera.camcontroller.CameraController$f r15 = r11.f14559b
            android.graphics.Rect r15 = r15.mo19557b()
            int r15 = r15.right
            com.meizu.media.camera.camcontroller.CameraController$f r11 = r11.f14558a
            android.graphics.Rect r11 = r11.mo19557b()
            int r11 = r11.right
            int r15 = r15 - r11
            float r11 = (float) r15
            int r15 = r7.f14518F
            float r15 = (float) r15
            float r15 = r15 / r16
            float r11 = r11 * r15
            float r10 = r10 + r11
            android.graphics.Rect r11 = new android.graphics.Rect
            int r9 = (int) r9
            int r14 = (int) r14
            int r10 = (int) r10
            int r5 = (int) r5
            r11.<init>(r9, r14, r10, r5)
            goto L_0x0265
        L_0x0264:
            r11 = 0
        L_0x0265:
            android.graphics.RectF r5 = r7.f14539i
            if (r11 != 0) goto L_0x026d
            android.graphics.Rect r11 = r12.mo19557b()
        L_0x026d:
            r5.set(r11)
            if (r3 == 0) goto L_0x02b7
            float r5 = r7.f14554y
            r9 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x02b2
            android.graphics.RectF r5 = r7.f14539i
            android.graphics.RectF r9 = r7.f14539i
            float r9 = r9.left
            android.graphics.Rect r10 = r7.f14553x
            int r10 = r10.left
            float r10 = (float) r10
            float r9 = r9 - r10
            r5.left = r9
            android.graphics.RectF r5 = r7.f14539i
            android.graphics.RectF r9 = r7.f14539i
            float r9 = r9.right
            android.graphics.Rect r10 = r7.f14553x
            int r10 = r10.left
            float r10 = (float) r10
            float r9 = r9 - r10
            r5.right = r9
            android.graphics.RectF r5 = r7.f14539i
            android.graphics.RectF r9 = r7.f14539i
            float r9 = r9.top
            android.graphics.Rect r10 = r7.f14553x
            int r10 = r10.top
            float r10 = (float) r10
            float r9 = r9 - r10
            r5.top = r9
            android.graphics.RectF r5 = r7.f14539i
            android.graphics.RectF r9 = r7.f14539i
            float r9 = r9.bottom
            android.graphics.Rect r10 = r7.f14553x
            int r10 = r10.top
            float r10 = (float) r10
            float r9 = r9 - r10
            r5.bottom = r9
        L_0x02b2:
            android.graphics.RectF r5 = r7.f14539i
            r3.mapRect(r5)
        L_0x02b7:
            android.graphics.Matrix r5 = r7.f14538h
            android.graphics.RectF r9 = r7.f14539i
            r5.mapRect(r9)
            android.graphics.Paint r5 = r7.f14548r
            int r9 = r7.f14542l
            r5.setColor(r9)
            boolean r5 = r7.f14551v
            r9 = 1097859072(0x41700000, float:15.0)
            r10 = 1132396544(0x437f0000, float:255.0)
            r11 = 255(0xff, float:3.57E-43)
            if (r5 == 0) goto L_0x02e4
            android.graphics.Paint r5 = r7.f14548r
            int r12 = r7.f14519G
            if (r12 >= r1) goto L_0x02df
            int r12 = r7.f14519G
            float r12 = (float) r12
            float r12 = r12 / r9
            float r12 = r12 * r10
            int r9 = (int) r12
            int r10 = 255 - r9
            goto L_0x02e0
        L_0x02df:
            r10 = 0
        L_0x02e0:
            r5.setAlpha(r10)
            goto L_0x02f4
        L_0x02e4:
            android.graphics.Paint r5 = r7.f14548r
            int r12 = r7.f14519G
            if (r12 >= r1) goto L_0x02f1
            int r11 = r7.f14519G
            float r11 = (float) r11
            float r11 = r11 / r9
            float r11 = r11 * r10
            int r11 = (int) r11
        L_0x02f1:
            r5.setAlpha(r11)
        L_0x02f4:
            android.graphics.RectF r5 = r7.f14539i
            float r9 = (float) r0
            float r10 = (float) r2
            r5.offset(r9, r10)
            android.graphics.RectF r5 = r7.f14539i
            r7.m16405a(r8, r5, r13)
        L_0x0300:
            int r4 = r4 + 1
            r9 = 1
            r10 = 0
            goto L_0x01a4
        L_0x0306:
            boolean r0 = r7.f14550u
            if (r0 != 0) goto L_0x030c
            boolean r0 = r7.f14551v
        L_0x030c:
            r19.restore()
            int r0 = r7.f14518F
            if (r0 < r6) goto L_0x031c
            int r0 = r7.f14519G
            if (r0 >= r1) goto L_0x0318
            goto L_0x031c
        L_0x0318:
            r0 = 0
            r7.f14520H = r0
            goto L_0x0330
        L_0x031c:
            int r0 = r7.f14518F
            r1 = 1
            int r0 = r0 + r1
            r7.f14518F = r0
            int r0 = r7.f14519G
            int r0 = r0 + r1
            r7.f14519G = r0
            r18.invalidate()
            goto L_0x0330
        L_0x032b:
            r7.f14519G = r1
            r0 = 0
            r7.f14520H = r0
        L_0x0330:
            super.onDraw(r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.FaceView.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16415h() {
        if (!PatchProxy.proxy(new Object[0], this, f14511a, false, 8349, new Class[0], Void.TYPE).isSupported) {
            this.f14520H = true;
            this.f14518F = 1;
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16407a(CameraController.C1880f[] fVarArr) {
        int sqrt;
        CameraController.C1880f[] fVarArr2 = fVarArr;
        if (PatchProxy.proxy(new Object[]{fVarArr2}, this, f14511a, false, 8350, new Class[]{CameraController.C1880f[].class}, Void.TYPE).isSupported || this.f14541k == null) {
            return;
        }
        if (fVarArr2.length != this.f14541k.size()) {
            this.f14541k.clear();
            for (CameraController.C1880f aVar : fVarArr2) {
                this.f14541k.add(new C2688a((CameraController.C1880f) null, aVar));
            }
            return;
        }
        for (int i = 0; i < this.f14541k.size(); i++) {
            C2688a aVar2 = this.f14541k.get(i);
            CameraController.C1880f fVar = aVar2.f14559b;
            int i2 = -1;
            int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (int i4 = 0; i4 < fVarArr2.length; i4++) {
                CameraController.C1880f fVar2 = fVarArr2[i4];
                if (!fVar2.mo19559d() && (i3 > (sqrt = (int) Math.sqrt(Math.pow((double) (fVar.mo19557b().centerX() - fVar2.mo19557b().centerX()), 2.0d) + Math.pow((double) (fVar.mo19557b().centerY() - fVar2.mo19557b().centerY()), 2.0d))) || i2 == -1)) {
                    i2 = i4;
                    i3 = sqrt;
                }
            }
            CameraController.C1880f fVar3 = fVarArr2[i2];
            aVar2.f14559b = fVar3;
            aVar2.f14558a = fVar;
            fVar3.mo19558c();
        }
    }

    public void setTextureTranslationY(int i) {
        this.f14521I = i;
    }

    public void setCropPreviewRatio(float f) {
        this.f14555z = f + 1.0f;
    }

    /* renamed from: com.meizu.media.camera.views.FaceView$a */
    private static class C2688a {

        /* renamed from: a */
        CameraController.C1880f f14558a;

        /* renamed from: b */
        CameraController.C1880f f14559b;

        C2688a(CameraController.C1880f fVar, CameraController.C1880f fVar2) {
            this.f14558a = fVar;
            this.f14559b = fVar2;
        }
    }

    /* renamed from: a */
    private void m16404a(Canvas canvas, RectF rectF) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        Class[] clsArr = {Canvas.class, RectF.class};
        if (!PatchProxy.proxy(new Object[]{canvas2, rectF2}, this, f14511a, false, 8351, clsArr, Void.TYPE).isSupported) {
            int i = this.f14522J;
            int i2 = this.f14523K;
            if (i + i2 > ((int) (rectF.width() / 2.0f))) {
                i = (int) ((rectF.width() / 2.0f) * (((float) this.f14522J) / ((float) (this.f14522J + this.f14523K))));
                i2 = (int) ((rectF.width() / 2.0f) * (((float) this.f14523K) / ((float) (this.f14522J + this.f14523K))));
            }
            Path path = new Path();
            float f = (float) i;
            float f2 = (float) i2;
            path.moveTo(rectF2.left, rectF2.top + f + f2);
            path.lineTo(rectF2.left, rectF2.top + f2);
            path.arcTo(rectF2.left, rectF2.top, rectF2.left + f2, rectF2.top + f2, 180.0f, 90.0f, false);
            path.lineTo(rectF2.left + f + f2, rectF2.top);
            canvas2.drawPath(path, this.f14548r);
            Path path2 = new Path();
            path2.moveTo(rectF2.right, rectF2.top + f + f2);
            path2.lineTo(rectF2.right, rectF2.top + f2);
            path2.arcTo(rectF2.right - f2, rectF2.top, rectF2.right, rectF2.top + f2, 0.0f, -90.0f, false);
            path2.lineTo((rectF2.right - f) - f2, rectF2.top);
            canvas2.drawPath(path2, this.f14548r);
            Path path3 = new Path();
            path3.moveTo(rectF2.left, (rectF2.bottom - f) - f2);
            path3.lineTo(rectF2.left, rectF2.bottom - f2);
            path3.arcTo(rectF2.left, rectF2.bottom - f2, rectF2.left + f2, rectF2.bottom, 180.0f, -90.0f, false);
            path3.lineTo(rectF2.left + f + f2, rectF2.bottom);
            canvas2.drawPath(path3, this.f14548r);
            Path path4 = new Path();
            path4.moveTo(rectF2.right, (rectF2.bottom - f) - f2);
            path4.lineTo(rectF2.right, rectF2.bottom - f2);
            path4.arcTo(rectF2.right - f2, rectF2.bottom - f2, rectF2.right, rectF2.bottom, 0.0f, 90.0f, false);
            path4.lineTo((rectF2.right - f) - f2, rectF2.bottom);
            canvas2.drawPath(path4, this.f14548r);
        }
    }

    /* renamed from: a */
    private void m16405a(Canvas canvas, RectF rectF, int i) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i2 = i;
        if (!PatchProxy.proxy(new Object[]{canvas2, rectF2, new Integer(i2)}, this, f14511a, false, 8352, new Class[]{Canvas.class, RectF.class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (i2 == 0) {
                this.f14548r.setColor(this.f14542l);
                m16404a(canvas, rectF);
                return;
            }
            int i3 = this.f14522J;
            int i4 = this.f14523K;
            if (i3 + i4 > ((int) (rectF.width() / 2.0f))) {
                i3 = (int) ((rectF.width() / 2.0f) * (((float) this.f14522J) / ((float) (this.f14522J + this.f14523K))));
                i4 = (int) ((rectF.width() / 2.0f) * (((float) this.f14523K) / ((float) (this.f14522J + this.f14523K))));
            }
            if (this.f14528P > ((int) (rectF.width() / 2.0f))) {
                this.f14528P = (int) (rectF.width() / 2.0f);
            }
            if (i2 == AgeGenderEngine.f7572c) {
                this.f14548r.setColor(this.f14546p);
                if (this.f14531S == 0) {
                    canvas2.drawBitmap(this.f14525M, (Rect) null, new RectF(rectF2.left - ((float) this.f14528P), (rectF2.top - ((float) this.f14528P)) + ((float) this.f14530R), rectF2.left + ((float) this.f14528P), rectF2.top + ((float) this.f14528P) + ((float) this.f14530R)), this.f14548r);
                } else if (this.f14531S == 270) {
                    canvas.save();
                    canvas2.translate((rectF2.right + ((float) this.f14528P)) - ((float) this.f14530R), rectF2.top - ((float) this.f14528P));
                    canvas2.rotate(90.0f);
                    canvas2.drawBitmap(this.f14525M, (Rect) null, new RectF(0.0f, 0.0f, (float) this.f14527O, (float) this.f14527O), this.f14548r);
                    canvas.restore();
                } else if (this.f14531S == 180) {
                    canvas.save();
                    canvas2.translate(rectF2.right + ((float) this.f14528P), (rectF2.bottom + ((float) this.f14528P)) - ((float) this.f14530R));
                    canvas2.rotate(180.0f);
                    canvas2.drawBitmap(this.f14525M, (Rect) null, new RectF(0.0f, 0.0f, (float) this.f14527O, (float) this.f14527O), this.f14548r);
                    canvas.restore();
                } else if (this.f14531S == 90) {
                    canvas.save();
                    canvas2.translate((rectF2.left - ((float) this.f14528P)) + ((float) this.f14530R), rectF2.bottom + ((float) this.f14528P));
                    canvas2.rotate(270.0f);
                    canvas2.drawBitmap(this.f14525M, (Rect) null, new RectF(0.0f, 0.0f, (float) this.f14527O, (float) this.f14527O), this.f14548r);
                    canvas.restore();
                }
            } else {
                this.f14548r.setColor(this.f14547q);
                if (this.f14531S == 0) {
                    canvas2.drawBitmap(this.f14526N, (Rect) null, new RectF(rectF2.left - ((float) this.f14528P), (rectF2.top - ((float) this.f14528P)) + ((float) this.f14530R), rectF2.left + ((float) this.f14528P), rectF2.top + ((float) this.f14528P) + ((float) this.f14530R)), this.f14548r);
                } else if (this.f14531S == 270) {
                    canvas.save();
                    canvas2.translate((rectF2.right + ((float) this.f14528P)) - ((float) this.f14530R), rectF2.top - ((float) this.f14528P));
                    canvas2.rotate(90.0f);
                    canvas2.drawBitmap(this.f14526N, (Rect) null, new RectF(0.0f, 0.0f, (float) this.f14527O, (float) this.f14527O), this.f14548r);
                    canvas.restore();
                } else if (this.f14531S == 180) {
                    canvas.save();
                    canvas2.translate(rectF2.right + ((float) this.f14528P), (rectF2.bottom + ((float) this.f14528P)) - ((float) this.f14530R));
                    canvas2.rotate(180.0f);
                    canvas2.drawBitmap(this.f14526N, (Rect) null, new RectF(0.0f, 0.0f, (float) this.f14527O, (float) this.f14527O), this.f14548r);
                    canvas.restore();
                } else if (this.f14531S == 90) {
                    canvas.save();
                    canvas2.translate((rectF2.left - ((float) this.f14528P)) + ((float) this.f14530R), rectF2.bottom + ((float) this.f14528P));
                    canvas2.rotate(270.0f);
                    canvas2.drawBitmap(this.f14526N, (Rect) null, new RectF(0.0f, 0.0f, (float) this.f14527O, (float) this.f14527O), this.f14548r);
                    canvas.restore();
                }
            }
            if (this.f14531S != 0) {
                Path path = new Path();
                float f = (float) i3;
                float f2 = (float) i4;
                path.moveTo(rectF2.left, rectF2.top + f + f2);
                path.lineTo(rectF2.left, rectF2.top + f2);
                path.arcTo(rectF2.left, rectF2.top, rectF2.left + f2, rectF2.top + f2, 180.0f, 90.0f, false);
                path.lineTo(rectF2.left + f + f2, rectF2.top);
                canvas2.drawPath(path, this.f14548r);
            }
            if (this.f14531S != 270) {
                Path path2 = new Path();
                float f3 = (float) i3;
                float f4 = (float) i4;
                path2.moveTo(rectF2.right, rectF2.top + f3 + f4);
                path2.lineTo(rectF2.right, rectF2.top + f4);
                Path path3 = path2;
                path3.arcTo(rectF2.right - f4, rectF2.top, rectF2.right, rectF2.top + f4, 0.0f, -90.0f, false);
                path2.lineTo((rectF2.right - f3) - f4, rectF2.top);
                canvas2.drawPath(path2, this.f14548r);
            }
            if (this.f14531S != 180) {
                Path path4 = new Path();
                float f5 = (float) i3;
                float f6 = (float) i4;
                path4.moveTo(rectF2.right, (rectF2.bottom - f5) - f6);
                path4.lineTo(rectF2.right, rectF2.bottom - f6);
                path4.arcTo(rectF2.right - f6, rectF2.bottom - f6, rectF2.right, rectF2.bottom, 0.0f, 90.0f, false);
                path4.lineTo((rectF2.right - f5) - f6, rectF2.bottom);
                canvas2.drawPath(path4, this.f14548r);
            }
            if (this.f14531S != 90) {
                Path path5 = new Path();
                float f7 = (float) i3;
                float f8 = (float) i4;
                path5.moveTo(rectF2.left, (rectF2.bottom - f7) - f8);
                path5.lineTo(rectF2.left, rectF2.bottom - f8);
                path5.arcTo(rectF2.left, rectF2.bottom - f8, rectF2.left + f8, rectF2.bottom, 180.0f, -90.0f, false);
                path5.lineTo(rectF2.left + f7 + f8, rectF2.bottom);
                canvas2.drawPath(path5, this.f14548r);
            }
        }
    }
}
