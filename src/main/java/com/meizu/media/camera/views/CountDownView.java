package com.meizu.media.camera.views;

import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class CountDownView extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14466a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14467b = new LogUtil.C2630a("CountDownView");

    /* renamed from: c */
    private RotateTextView f14468c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f14469d = 0;

    /* renamed from: e */
    private C2684b f14470e;

    /* renamed from: f */
    private Animation f14471f;

    /* renamed from: g */
    private SoundPool f14472g;

    /* renamed from: h */
    private int f14473h;

    /* renamed from: i */
    private int f14474i;

    /* renamed from: j */
    private boolean f14475j;

    /* renamed from: k */
    private final Handler f14476k = new C2683a();

    /* renamed from: l */
    private int f14477l = 1000;

    /* renamed from: m */
    private boolean f14478m;

    /* renamed from: com.meizu.media.camera.views.CountDownView$b */
    public interface C2684b {
        /* renamed from: cO */
        void mo18137cO();

        /* renamed from: cP */
        void mo18138cP();

        /* renamed from: cQ */
        void mo18139cQ();
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14471f = AnimationUtils.loadAnimation(context, R.anim.count_down_exit);
        this.f14472g = new SoundPool(1, 5, 0);
        this.f14474i = m16376a(context, "sound/beep_once.ogg");
        this.f14473h = m16376a(context, "sound/beep_twice.ogg");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[SYNTHETIC, Splitter:B:24:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005f A[SYNTHETIC, Splitter:B:30:0x005f] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m16376a(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r11
            r9 = 1
            r1[r9] = r12
            com.meizu.savior.ChangeQuickRedirect r3 = f14466a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r6[r8] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r9] = r0
            java.lang.Class r7 = java.lang.Integer.TYPE
            r4 = 0
            r5 = 8311(0x2077, float:1.1646E-41)
            r2 = r10
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002c
            java.lang.Object r11 = r0.result
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            return r11
        L_0x002c:
            r0 = 0
            android.content.res.AssetManager r11 = r11.getAssets()     // Catch:{ IOException -> 0x004e }
            android.content.res.AssetFileDescriptor r11 = r11.openFd(r12)     // Catch:{ IOException -> 0x004e }
            android.media.SoundPool r12 = r10.f14472g     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            int r12 = r12.load(r11, r9)     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            if (r11 == 0) goto L_0x0045
            r11.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0045:
            return r12
        L_0x0046:
            r12 = move-exception
            r0 = r11
            goto L_0x005d
        L_0x0049:
            r12 = move-exception
            r0 = r11
            goto L_0x004f
        L_0x004c:
            r12 = move-exception
            goto L_0x005d
        L_0x004e:
            r12 = move-exception
        L_0x004f:
            r12.printStackTrace()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x005c
            r0.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r11 = move-exception
            r11.printStackTrace()
        L_0x005c:
            return r8
        L_0x005d:
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0067:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.CountDownView.m16376a(android.content.Context, java.lang.String):int");
    }

    public void setWatchCamera(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f14466a, false, 8312, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14478m = z;
            this.f14471f = AnimationUtils.loadAnimation(getContext(), this.f14478m ? R.anim.count_down_exit_watch : R.anim.count_down_exit);
            this.f14477l = this.f14478m ? MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION : 1000;
        }
    }

    /* renamed from: a */
    public boolean mo22818a() {
        return this.f14469d > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16378a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14466a, false, 8313, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14469d = i;
            if (i == 0) {
                setVisibility(4);
                if (this.f14470e != null) {
                    this.f14470e.mo18138cP();
                    return;
                }
                return;
            }
            this.f14468c.setText(String.format(getResources().getConfiguration().locale, "%d", new Object[]{Integer.valueOf(i)}));
            this.f14471f.reset();
            this.f14468c.clearAnimation();
            this.f14468c.startAnimation(this.f14471f);
            if (this.f14475j) {
                if (i == 1) {
                    this.f14472g.play(this.f14473h, 1.0f, 1.0f, 0, 0, 1.0f);
                } else if (i <= 3) {
                    this.f14472g.play(this.f14474i, 1.0f, 1.0f, 0, 0, 1.0f);
                }
            }
            this.f14476k.sendEmptyMessageDelayed(1, (long) this.f14477l);
        }
    }

    public void onFinishInflate() {
        if (!PatchProxy.proxy(new Object[0], this, f14466a, false, 8314, new Class[0], Void.TYPE).isSupported) {
            super.onFinishInflate();
            this.f14468c = (RotateTextView) findViewById(R.id.remaining_seconds);
        }
    }

    public void setCountDownFinishedListener(C2684b bVar) {
        this.f14470e = bVar;
    }

    /* renamed from: a */
    public void mo22817a(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14466a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8315, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (i <= 0) {
                LogUtil.C2630a aVar = f14467b;
                LogUtil.m15956e(aVar, "Invalid input for countdown timer: " + i + " seconds");
                return;
            }
            if (this.f14470e != null) {
                this.f14470e.mo18137cO();
            }
            setVisibility(0);
            this.f14475j = z;
            m16378a(i);
        }
    }

    /* renamed from: b */
    public void mo22819b() {
        if (!PatchProxy.proxy(new Object[0], this, f14466a, false, 8316, new Class[0], Void.TYPE).isSupported && this.f14469d > 0) {
            this.f14469d = 0;
            this.f14476k.removeMessages(1);
            setVisibility(4);
            if (this.f14470e != null) {
                this.f14470e.mo18139cQ();
            }
        }
    }

    /* renamed from: com.meizu.media.camera.views.CountDownView$a */
    private class C2683a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f14479a;

        private C2683a() {
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f14479a, false, 8318, new Class[]{Message.class}, Void.TYPE).isSupported && message.what == 1) {
                CountDownView.this.m16378a(CountDownView.this.f14469d - 1);
            }
        }
    }

    public Rotatable getCountDownTextView() {
        return this.f14468c;
    }

    /* renamed from: c */
    public void mo22820c() {
        if (!PatchProxy.proxy(new Object[0], this, f14466a, false, 8317, new Class[0], Void.TYPE).isSupported) {
            if (this.f14472g != null) {
                this.f14472g.release();
                this.f14472g = null;
            }
            if (this.f14470e != null) {
                this.f14470e = null;
            }
        }
    }
}
