package com.meizu.media.camera.views;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.views.m */
public final class OnScreenHint implements ToastHint {

    /* renamed from: a */
    public static ChangeQuickRedirect f15533a;

    /* renamed from: b */
    static final LogUtil.C2630a f15534b = new LogUtil.C2630a("OnScreenHint");

    /* renamed from: c */
    int f15535c;

    /* renamed from: d */
    int f15536d;

    /* renamed from: e */
    int f15537e;

    /* renamed from: f */
    float f15538f;

    /* renamed from: g */
    float f15539g;

    /* renamed from: h */
    View f15540h;

    /* renamed from: i */
    View f15541i;

    /* renamed from: j */
    private final WindowManager.LayoutParams f15542j;

    /* renamed from: k */
    private final WindowManager f15543k;

    /* renamed from: l */
    private final Handler f15544l;

    /* renamed from: m */
    private final Runnable f15545m;

    /* renamed from: n */
    private final Runnable f15546n;

    private OnScreenHint(Context context) {
        this(context, false);
    }

    private OnScreenHint(Context context, boolean z) {
        this.f15535c = 81;
        this.f15542j = new WindowManager.LayoutParams();
        this.f15544l = new Handler();
        this.f15545m = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f15547a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f15547a, false, 8767, new Class[0], Void.TYPE).isSupported) {
                    OnScreenHint.this.m16865e();
                }
            }
        };
        this.f15546n = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f15549a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f15549a, false, 8768, new Class[0], Void.TYPE).isSupported) {
                    OnScreenHint.this.m16866f();
                }
            }
        };
        this.f15543k = (WindowManager) context.getSystemService("window");
        this.f15537e = ContextBuilder.m6349a(context, true, true).getResources().getDimensionPixelSize(R.dimen.hint_y_offset);
        this.f15542j.height = -1;
        this.f15542j.width = -1;
        this.f15542j.flags = 24;
        this.f15542j.format = -3;
        if (!z) {
            this.f15542j.windowAnimations = R.style.Animation_OnScreenHint;
        }
        this.f15542j.type = 1000;
        this.f15542j.setTitle("OnScreenHint");
    }

    /* renamed from: a */
    public void mo23395a() {
        if (!PatchProxy.proxy(new Object[0], this, f15533a, false, 8756, new Class[0], Void.TYPE).isSupported) {
            if (this.f15541i == null) {
                LogUtil.m15949b(f15534b, "View is not initialized");
            } else {
                this.f15544l.post(this.f15545m);
            }
        }
    }

    /* renamed from: a */
    public void mo23397a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f15533a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8757, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f15541i == null) {
                LogUtil.m15949b(f15534b, "View is not initialized");
                return;
            }
            this.f15544l.post(this.f15545m);
            this.f15544l.postDelayed(this.f15546n, j);
        }
    }

    /* renamed from: b */
    public void mo23398b() {
        if (!PatchProxy.proxy(new Object[0], this, f15533a, false, 8758, new Class[0], Void.TYPE).isSupported) {
            this.f15544l.post(this.f15546n);
        }
    }

    /* renamed from: a */
    public static ToastHint m16862a(Context context, CharSequence charSequence) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, charSequence}, (Object) null, f15533a, true, 8759, new Class[]{Context.class, CharSequence.class}, ToastHint.class);
        if (proxy.isSupported) {
            return (ToastHint) proxy.result;
        }
        OnScreenHint mVar = new OnScreenHint(context);
        View inflate = ((LayoutInflater) ContextBuilder.m6349a(context, true, true).getSystemService("layout_inflater")).inflate(R.layout.on_screen_hint, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.toast_text);
        textView.setShadowLayer(2.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
        textView.setText(charSequence);
        mVar.f15541i = inflate;
        return mVar;
    }

    /* renamed from: a */
    public static ToastHint m16861a(Context context, int i, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, new Integer(i), new Byte(z ? (byte) 1 : 0)}, (Object) null, f15533a, true, 8760, new Class[]{Context.class, Integer.TYPE, Boolean.TYPE}, ToastHint.class);
        if (proxy.isSupported) {
            return (ToastHint) proxy.result;
        }
        OnScreenHint mVar = new OnScreenHint(context, z);
        View inflate = ((LayoutInflater) ContextBuilder.m6349a(context, true, true).getSystemService("layout_inflater")).inflate(R.layout.on_screen_hint, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.toast_text);
        textView.setShadowLayer(2.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
        textView.setText(i);
        mVar.f15541i = inflate;
        return mVar;
    }

    /* renamed from: c */
    public void mo23399c() {
        if (!PatchProxy.proxy(new Object[0], this, f15533a, false, 8762, new Class[0], Void.TYPE).isSupported) {
            this.f15544l.removeCallbacksAndMessages((Object) null);
        }
    }

    /* renamed from: a */
    public void mo23396a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15533a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8763, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f15541i == null) {
                LogUtil.m15949b(f15534b, "This OnScreenHint was not created with OnScreenHint.makeText()");
                return;
            }
            TextView textView = (TextView) this.f15541i.findViewById(R.id.toast_text);
            textView.setShadowLayer(2.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
            if (textView == null) {
                LogUtil.m15949b(f15534b, "This OnScreenHint was not created with OnScreenHint.makeText()");
            } else {
                textView.setText(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        return;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m16865e() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0085 }
            com.meizu.savior.ChangeQuickRedirect r3 = f15533a     // Catch:{ all -> 0x0085 }
            r4 = 0
            r5 = 8764(0x223c, float:1.2281E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0085 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0085 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0085 }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            android.view.View r1 = r8.f15540h     // Catch:{ all -> 0x0085 }
            android.view.View r2 = r8.f15541i     // Catch:{ all -> 0x0085 }
            if (r1 == r2) goto L_0x0083
            r8.m16866f()     // Catch:{ all -> 0x0085 }
            android.view.View r1 = r8.f15541i     // Catch:{ all -> 0x0085 }
            r8.f15540h = r1     // Catch:{ all -> 0x0085 }
            int r1 = r8.f15535c     // Catch:{ all -> 0x0085 }
            android.view.WindowManager$LayoutParams r2 = r8.f15542j     // Catch:{ all -> 0x0085 }
            r2.gravity = r1     // Catch:{ all -> 0x0085 }
            r2 = r1 & 7
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 7
            if (r2 != r4) goto L_0x0036
            android.view.WindowManager$LayoutParams r2 = r8.f15542j     // Catch:{ all -> 0x0085 }
            r2.horizontalWeight = r3     // Catch:{ all -> 0x0085 }
        L_0x0036:
            r2 = 112(0x70, float:1.57E-43)
            r1 = r1 & r2
            if (r1 != r2) goto L_0x003f
            android.view.WindowManager$LayoutParams r1 = r8.f15542j     // Catch:{ all -> 0x0085 }
            r1.verticalWeight = r3     // Catch:{ all -> 0x0085 }
        L_0x003f:
            android.view.WindowManager$LayoutParams r1 = r8.f15542j     // Catch:{ all -> 0x0085 }
            int r2 = r8.f15536d     // Catch:{ all -> 0x0085 }
            r1.x = r2     // Catch:{ all -> 0x0085 }
            android.view.WindowManager$LayoutParams r1 = r8.f15542j     // Catch:{ all -> 0x0085 }
            int r2 = r8.f15537e     // Catch:{ all -> 0x0085 }
            r1.y = r2     // Catch:{ all -> 0x0085 }
            android.view.WindowManager$LayoutParams r1 = r8.f15542j     // Catch:{ all -> 0x0085 }
            float r2 = r8.f15539g     // Catch:{ all -> 0x0085 }
            r1.verticalMargin = r2     // Catch:{ all -> 0x0085 }
            android.view.WindowManager$LayoutParams r1 = r8.f15542j     // Catch:{ all -> 0x0085 }
            float r2 = r8.f15538f     // Catch:{ all -> 0x0085 }
            r1.horizontalMargin = r2     // Catch:{ all -> 0x0085 }
            android.view.View r1 = r8.f15540h     // Catch:{ all -> 0x0085 }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0066
            android.view.WindowManager r1 = r8.f15543k     // Catch:{ all -> 0x0085 }
            android.view.View r2 = r8.f15540h     // Catch:{ all -> 0x0085 }
            r1.removeView(r2)     // Catch:{ all -> 0x0085 }
        L_0x0066:
            android.view.WindowManager r1 = r8.f15543k     // Catch:{ all -> 0x0085 }
            android.view.View r2 = r8.f15540h     // Catch:{ all -> 0x0085 }
            android.view.WindowManager$LayoutParams r3 = r8.f15542j     // Catch:{ all -> 0x0085 }
            r1.addView(r2, r3)     // Catch:{ all -> 0x0085 }
            android.view.View r1 = r8.f15540h     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0083
            android.view.View r1 = r8.f15540h     // Catch:{ all -> 0x0085 }
            r2 = 2131297086(0x7f09033e, float:1.8212107E38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ all -> 0x0085 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0083
            r1.setVisibility(r0)     // Catch:{ all -> 0x0085 }
        L_0x0083:
            monitor-exit(r8)
            return
        L_0x0085:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.OnScreenHint.m16865e():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        return;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m16866f() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0030 }
            com.meizu.savior.ChangeQuickRedirect r3 = f15533a     // Catch:{ all -> 0x0030 }
            r4 = 0
            r5 = 8765(0x223d, float:1.2282E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0030 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0030 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0030 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            android.view.View r0 = r8.f15540h     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002e
            android.view.View r0 = r8.f15540h     // Catch:{ all -> 0x0030 }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002b
            android.view.WindowManager r0 = r8.f15543k     // Catch:{ all -> 0x0030 }
            android.view.View r1 = r8.f15540h     // Catch:{ all -> 0x0030 }
            r0.removeView(r1)     // Catch:{ all -> 0x0030 }
        L_0x002b:
            r0 = 0
            r8.f15540h = r0     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r8)
            return
        L_0x0030:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.OnScreenHint.m16866f():void");
    }

    /* renamed from: d */
    public void mo23400d() {
        TextView textView;
        if (!PatchProxy.proxy(new Object[0], this, f15533a, false, 8766, new Class[0], Void.TYPE).isSupported && this.f15540h != null && (textView = (TextView) this.f15540h.findViewById(R.id.toast_text)) != null) {
            textView.setVisibility(4);
        }
    }
}
