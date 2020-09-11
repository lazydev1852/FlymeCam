package com.meizu.media.camera.p077ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.result.ResultActionBarItem;
import com.meizu.media.camera.barcode.result.ResultHandler;
import com.meizu.media.camera.barcode.result.ResultInfoAdapter;
import com.meizu.media.camera.barcode.result.ResultInfoHeader;
import com.meizu.media.camera.barcode.result.TextResultHandler;
import com.meizu.media.camera.barcode.result.URIResultHandler;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzBarcodeBinding;
import com.meizu.media.camera.p066c.AsyncDrawable;
import com.meizu.media.camera.p066c.MeasuredAsyncDrawable;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.FixedSizeImageView;
import com.meizu.media.camera.views.GlowImageView;
import com.meizu.media.camera.views.MzBarcodeListview;
import com.meizu.media.camera.views.MzBarcodeRenderer;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.meizu.media.camera.ui.g */
public class MzBarcodeUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12907a;

    /* renamed from: b */
    private static final LogUtil.C2630a f12908b = new LogUtil.C2630a("MzBarcodeUI");
    /* access modifiers changed from: private */

    /* renamed from: A */
    public LinearLayout f12909A;

    /* renamed from: B */
    private LinearLayout f12910B;

    /* renamed from: C */
    private TextView f12911C;

    /* renamed from: D */
    private ImageView f12912D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public View f12913E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public LinearLayout f12914F;

    /* renamed from: G */
    private TextView f12915G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f12916H;

    /* renamed from: I */
    private boolean f12917I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public ResultHandler f12918J;

    /* renamed from: K */
    private ResultInfoHeader f12919K;

    /* renamed from: L */
    private ResultInfoAdapter f12920L;

    /* renamed from: M */
    private ArrayList<ResultActionBarItem> f12921M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public Handler f12922N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f12923O = false;

    /* renamed from: P */
    private MzCommonUI.C2403f f12924P = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12961a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f12961a, false, 6453, new Class[0], Void.TYPE).isSupported) {
                boolean unused = MzBarcodeUI.this.f12923O = MzBarcodeUI.this.mo22016i();
                MzBarcodeUI.this.f12925c.setVisibility(8);
                MzBarcodeUI.this.f12926d.setVisibility(8);
                MzBarcodeUI.this.f12914F.setVisibility(8);
                MzBarcodeUI.this.f12922N.removeMessages(ComponentMessageType.MSG_TYPE_START_SHAKE);
                MzBarcodeUI.this.m14799h(false);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f12961a, false, 6454, new Class[0], Void.TYPE).isSupported) {
                MzBarcodeUI.this.f12925c.setVisibility(0);
                MzBarcodeUI.this.f12926d.setVisibility(0);
                if (!MzBarcodeUI.this.f12923O) {
                    MzBarcodeUI.this.m14799h(true);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f12925c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RelativeLayout f12926d;

    /* renamed from: e */
    private FixedSizeImageView f12927e;

    /* renamed from: f */
    private TextView f12928f;

    /* renamed from: g */
    private TextView f12929g;

    /* renamed from: h */
    private LinearLayout f12930h;

    /* renamed from: i */
    private TextView f12931i;

    /* renamed from: j */
    private TextView f12932j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f12933k;

    /* renamed from: l */
    private View f12934l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public MzBarcodeListview f12935m;

    /* renamed from: n */
    private View f12936n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public RelativeLayout f12937o;

    /* renamed from: p */
    private View f12938p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public View f12939q;

    /* renamed from: r */
    private GlowImageView f12940r;

    /* renamed from: s */
    private GlowImageView f12941s;

    /* renamed from: t */
    private GlowImageView f12942t;

    /* renamed from: u */
    private MzBarcodeRenderer f12943u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public C2472a f12944v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public MzUIController f12945w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public Activity f12946x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f12947y;

    /* renamed from: z */
    private Context f12948z;

    /* renamed from: com.meizu.media.camera.ui.g$a */
    /* compiled from: MzBarcodeUI */
    public interface C2472a {
        /* renamed from: c */
        void mo20518c();

        /* renamed from: q */
        Boolean mo20520q();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m14788a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* renamed from: com.meizu.media.camera.ui.g$b */
    /* compiled from: MzBarcodeUI */
    private static class C2473b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f12963a;

        /* renamed from: b */
        WeakReference<MzBarcodeUI> f12964b;

        C2473b(MzBarcodeUI gVar) {
            this.f12964b = new WeakReference<>(gVar);
        }

        public void dispatchMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f12963a, false, 6455, new Class[]{Message.class}, Void.TYPE).isSupported) {
                super.dispatchMessage(message);
                if (message.what == 10001) {
                    try {
                        ((MzBarcodeUI) this.f12964b.get()).f12914F.setVisibility(8);
                        EventBus.m21789a().mo27980d(18);
                        if (((MzBarcodeUI) this.f12964b.get()).f12944v != null) {
                            ((MzBarcodeUI) this.f12964b.get()).f12944v.mo20518c();
                        }
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo22001a(C2472a aVar) {
        this.f12944v = aVar;
    }

    /* renamed from: a */
    public void mo22000a(MzUIController uVar) {
        this.f12945w = uVar;
    }

    public MzBarcodeUI(DelayInflateTwoBinding delayInflateTwoBinding, Activity activity, RenderOverlay renderOverlay) {
        m14787a(delayInflateTwoBinding, activity, renderOverlay);
        this.f12922N = new C2473b(this);
    }

    /* renamed from: a */
    private void m14787a(DelayInflateTwoBinding delayInflateTwoBinding, Activity activity, RenderOverlay renderOverlay) {
        MzBarcodeBinding mzBarcodeBinding;
        if (!PatchProxy.proxy(new Object[]{delayInflateTwoBinding, activity, renderOverlay}, this, f12907a, false, 6423, new Class[]{DelayInflateTwoBinding.class, Activity.class, RenderOverlay.class}, Void.TYPE).isSupported) {
            this.f12946x = activity;
            this.f12948z = ContextBuilder.m6349a(this.f12946x, true, true);
            if (this.f12943u == null) {
                this.f12943u = new MzBarcodeRenderer(this.f12948z);
                renderOverlay.mo23140a(0, this.f12943u);
            }
            if (delayInflateTwoBinding.f9575f.getViewStub() != null) {
                mzBarcodeBinding = (MzBarcodeBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9575f.getViewStub().inflate());
                this.f12925c = mzBarcodeBinding.f9625c;
                this.f12926d = mzBarcodeBinding.f9644v;
            } else {
                mzBarcodeBinding = (MzBarcodeBinding) delayInflateTwoBinding.f9575f.getBinding();
            }
            this.f12933k = mzBarcodeBinding.f9642t;
            this.f12927e = mzBarcodeBinding.f9631i;
            this.f12928f = mzBarcodeBinding.f9627e;
            this.f12929g = mzBarcodeBinding.f9626d;
            this.f12930h = mzBarcodeBinding.f9632j;
            this.f12931i = mzBarcodeBinding.f9628f;
            this.f12932j = mzBarcodeBinding.f9629g;
            this.f12934l = mzBarcodeBinding.f9630h;
            this.f12935m = mzBarcodeBinding.f9643u;
            this.f12936n = mzBarcodeBinding.f9645w;
            this.f12939q = mzBarcodeBinding.f9648z;
            this.f12940r = mzBarcodeBinding.f9623a;
            this.f12941s = mzBarcodeBinding.f9624b;
            this.f12942t = mzBarcodeBinding.f9634l;
            this.f12942t.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12949a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f12949a, false, 6447, new Class[]{View.class}, Void.TYPE).isSupported && MzBarcodeUI.this.f12946x != null) {
                        MzBarcodeUI.this.f12946x.onBackPressed();
                    }
                }
            });
            this.f12937o = mzBarcodeBinding.f9640r;
            this.f12938p = mzBarcodeBinding.f9641s;
            this.f12938p.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12951a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f12951a, false, 6448, new Class[]{View.class}, Void.TYPE).isSupported && MzBarcodeUI.this.f12947y && MzBarcodeUI.this.f12944v != null) {
                        MzBarcodeUI.this.f12944v.mo20518c();
                    }
                }
            });
            this.f12909A = mzBarcodeBinding.f9646x;
            this.f12910B = mzBarcodeBinding.f9638p;
            this.f12911C = mzBarcodeBinding.f9639q;
            this.f12912D = mzBarcodeBinding.f9637o;
            this.f12910B.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12953a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f12953a, false, 6449, new Class[]{View.class}, Void.TYPE).isSupported && MzBarcodeUI.this.f12945w != null) {
                        MzBarcodeUI.this.f12945w.mo21554as();
                    }
                }
            });
            this.f12913E = mzBarcodeBinding.f9635m;
            this.f12913E.setOnTouchListener($$Lambda$g$iDjH5fgZDo9ohnOFNOVhZdJ3W_Q.INSTANCE);
            this.f12914F = mzBarcodeBinding.f9636n;
            this.f12915G = mzBarcodeBinding.f9647y;
            this.f12914F.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12955a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f12955a, false, 6450, new Class[]{View.class}, Void.TYPE).isSupported) {
                        UsageStatsHelper.m16042a(MzBarcodeUI.this.f12946x.getApplicationContext()).mo22695b("view_scan_results");
                        if ((MzBarcodeUI.this.f12918J instanceof URIResultHandler) && ((URIResultHandler) MzBarcodeUI.this.f12918J).mo19176k()) {
                            ((URIResultHandler) MzBarcodeUI.this.f12918J).mo19177l();
                        } else if (!(MzBarcodeUI.this.f12918J instanceof TextResultHandler) || !((TextResultHandler) MzBarcodeUI.this.f12918J).mo19299k()) {
                            MzBarcodeUI.this.mo22004b(true);
                        } else {
                            ((TextResultHandler) MzBarcodeUI.this.f12918J).mo19300l();
                        }
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12914F.getLayoutParams();
            layoutParams.topMargin = CameraUtil.m15865b() - ((CameraUtil.m15897f() + (this.f12948z.getResources().getDimensionPixelSize(R.dimen.mz_barcode_mode_auto_hint_margin_bottom) / 2)) + this.f12948z.getResources().getDimensionPixelSize(R.dimen.mz_barcode_mode_auto_hint_height));
            this.f12914F.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f12910B.getLayoutParams();
            layoutParams2.topMargin = (mo22003b().top + this.f12948z.getResources().getDimensionPixelSize(R.dimen.mz_barcode_flash_tip_margin_top)) - this.f12910B.getPaddingTop();
            this.f12910B.setLayoutParams(layoutParams2);
            if (NavigationBarUtils.m15973a(this.f12948z.getResources())) {
                this.f12909A.setPadding(0, 0, 0, CameraUtil.m15912r());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f12942t.getLayoutParams();
                layoutParams3.topMargin = ((CameraUtil.m15865b() - (CameraUtil.m15897f() / 2)) - (this.f12946x.getResources().getDimensionPixelSize(R.dimen.mz_barcode_exit_height) / 2)) - (CameraUtil.m15912r() / 2);
                this.f12942t.setLayoutParams(layoutParams3);
                return;
            }
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f12942t.getLayoutParams();
            layoutParams4.topMargin = (CameraUtil.m15865b() - (CameraUtil.m15897f() / 2)) - (this.f12946x.getResources().getDimensionPixelSize(R.dimen.mz_barcode_exit_height) / 2);
            this.f12942t.setLayoutParams(layoutParams4);
        }
    }

    /* renamed from: a */
    public void mo21997a() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6424, new Class[0], Void.TYPE).isSupported) {
            this.f12925c.setVisibility(0);
            this.f12926d.setVisibility(0);
            this.f12945w.mo21520a(this.f12924P);
            if (!EventBus.m21789a().mo27978b(this)) {
                EventBus.m21789a().mo27974a((Object) this);
            }
        }
    }

    /* renamed from: b */
    public Rect mo22003b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12907a, false, 6425, new Class[0], Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        if (this.f12943u == null) {
            this.f12943u = new MzBarcodeRenderer(this.f12948z);
        }
        return this.f12943u.mo23316a();
    }

    /* renamed from: c */
    public void mo22005c() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6426, new Class[0], Void.TYPE).isSupported) {
            if (this.f12943u.mo23319b()) {
                this.f12943u.mo23317a(false);
            }
            m14799h(true);
            if (!this.f12916H) {
                this.f12945w.mo21574c(1024, true);
                this.f12945w.mo21574c(2048, true);
                this.f12945w.mo21574c(4096, true);
                this.f12942t.setVisibility(0);
            }
        }
    }

    /* renamed from: d */
    public void mo22007d() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6427, new Class[0], Void.TYPE).isSupported) {
            this.f12947y = false;
            this.f12909A.setVisibility(8);
            this.f12926d.setVisibility(8);
            this.f12925c.setVisibility(8);
            this.f12914F.setVisibility(8);
            m14799h(false);
            this.f12943u.mo23317a(false);
            this.f12945w.mo21520a((MzCommonUI.C2403f) null);
            this.f12922N.removeMessages(ComponentMessageType.MSG_TYPE_START_SHAKE);
            if (!this.f12916H) {
                this.f12945w.mo21648z(true);
                this.f12945w.mo21574c(512, true);
                this.f12945w.mo21574c(1024, true);
                this.f12945w.mo21574c(4096, true);
            }
            this.f12918J = null;
            this.f12917I = false;
            this.f12920L = null;
            this.f12919K = null;
            this.f12921M = null;
            EventBus.m21789a().mo27979c(this);
        }
    }

    /* renamed from: e */
    public void mo22009e() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6428, new Class[0], Void.TYPE).isSupported) {
            this.f12947y = false;
            this.f12909A.setVisibility(8);
        }
    }

    /* renamed from: f */
    public boolean mo22012f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12907a, false, 6429, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f12947y) {
            return false;
        }
        this.f12944v.mo20518c();
        return true;
    }

    /* renamed from: a */
    public void mo22002a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12907a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6430, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f12943u.mo23317a(z);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTouchHideResultHint(Integer num) {
        if (!PatchProxy.proxy(new Object[]{num}, this, f12907a, false, 6431, new Class[]{Integer.class}, Void.TYPE).isSupported && num.intValue() == 19 && this.f12914F != null && this.f12914F.getVisibility() == 0) {
            this.f12914F.setVisibility(8);
            this.f12922N.removeMessages(ComponentMessageType.MSG_TYPE_START_SHAKE);
            EventBus.m21789a().mo27980d(18);
        }
    }

    /* renamed from: a */
    public void mo21998a(ResultHandler iVar) {
        if (!PatchProxy.proxy(new Object[]{iVar}, this, f12907a, false, 6432, new Class[]{ResultHandler.class}, Void.TYPE).isSupported) {
            if (iVar == null) {
                LogUtil.m15942a(f12908b, "device moving, update scan result next time");
                this.f12917I = true;
                return;
            }
            String e = iVar.mo19234e();
            LogUtil.C2630a aVar = f12908b;
            LogUtil.m15952c(aVar, "showBarcodeResultHint " + e);
            boolean equals = this.f12915G.getText().equals(e);
            if (e != null) {
                this.f12915G.setText(e);
            }
            if (!this.f12947y && this.f12916H && this.f12945w.mo21556au() && !this.f12945w.mo21590f()) {
                if (this.f12918J == null || !equals || this.f12917I || this.f12918J.mo19238g() != iVar.mo19238g() || !TextUtils.equals(this.f12918J.mo19174b().mo19259b(), iVar.mo19174b().mo19259b())) {
                    this.f12917I = false;
                    this.f12914F.setVisibility(0);
                    this.f12918J = iVar;
                    EventBus.m21789a().mo27980d(17);
                    this.f12922N.removeMessages(ComponentMessageType.MSG_TYPE_START_SHAKE);
                    this.f12922N.sendEmptyMessageDelayed(ComponentMessageType.MSG_TYPE_START_SHAKE, 8000);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo21999a(ResultInfoHeader lVar, ResultInfoAdapter kVar, ArrayList<ResultActionBarItem> arrayList) {
        this.f12919K = lVar;
        this.f12920L = kVar;
        this.f12921M = arrayList;
    }

    /* renamed from: b */
    public void mo22004b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12907a, false, 6433, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f12919K == null || this.f12926d.getVisibility() != 0) {
                mo22002a(false);
            } else if (!this.f12947y) {
                Drawable a = this.f12919K.mo19255a();
                String b = this.f12919K.mo19259b();
                String c = this.f12919K.mo19261c();
                String d = this.f12919K.mo19263d();
                String e = this.f12919K.mo19265e();
                boolean f = this.f12919K.mo19266f();
                this.f12922N.removeMessages(ComponentMessageType.MSG_TYPE_START_SHAKE);
                this.f12914F.setVisibility(8);
                this.f12909A.setVisibility(0);
                this.f12933k.setVisibility(0);
                if (this.f12916H) {
                    EventBus.m21789a().mo27980d(20);
                }
                if (z) {
                    this.f12937o.setVisibility(0);
                } else {
                    this.f12937o.setVisibility(8);
                }
                if (a != null) {
                    this.f12927e.setVisibility(0);
                    if (a instanceof AsyncDrawable) {
                        this.f12927e.setMeasuredDrawable((MeasuredAsyncDrawable) a);
                        this.f12927e.setBackground((Drawable) null);
                    } else {
                        this.f12927e.setMeasuredDrawable((MeasuredAsyncDrawable) null);
                        this.f12927e.setBackground(a);
                    }
                } else {
                    this.f12927e.setVisibility(8);
                }
                if (b != null) {
                    this.f12928f.setText(b);
                }
                if (c != null) {
                    this.f12929g.setVisibility(0);
                    this.f12929g.setText(c);
                } else {
                    this.f12929g.setVisibility(8);
                }
                if (d != null) {
                    this.f12930h.setVisibility(0);
                    this.f12931i.setText(d);
                    this.f12932j.setText(e);
                } else {
                    this.f12930h.setVisibility(8);
                }
                if (f) {
                    this.f12934l.setVisibility(0);
                } else {
                    this.f12934l.setVisibility(8);
                }
                if (this.f12920L != null) {
                    this.f12935m.setAdapter(this.f12920L);
                    this.f12935m.setVisibility(0);
                } else {
                    this.f12935m.setVisibility(8);
                }
                if (this.f12921M != null && this.f12921M.size() > 0) {
                    this.f12939q.setVisibility(0);
                    this.f12936n.setVisibility(0);
                    switch (this.f12921M.size()) {
                        case 1:
                            this.f12940r.setVisibility(8);
                            this.f12941s.setVisibility(0);
                            int a2 = this.f12921M.get(0).mo19211a();
                            if (a2 != 0) {
                                this.f12941s.setImageResource(a2);
                            } else {
                                Drawable b2 = this.f12921M.get(0).mo19214b();
                                ((MzTextDrawable) b2).mo23385a((View) this.f12941s);
                                this.f12941s.setImageDrawable(b2);
                            }
                            this.f12941s.setOnClickListener(this.f12921M.get(0).mo19215c());
                            break;
                        case 2:
                            this.f12940r.setVisibility(0);
                            this.f12941s.setVisibility(0);
                            int a3 = this.f12921M.get(0).mo19211a();
                            if (a3 != 0) {
                                this.f12940r.setImageResource(a3);
                            } else {
                                Drawable b3 = this.f12921M.get(0).mo19214b();
                                ((MzTextDrawable) b3).mo23385a((View) this.f12940r);
                                this.f12940r.setImageDrawable(b3);
                            }
                            this.f12940r.setOnClickListener(this.f12921M.get(0).mo19215c());
                            int a4 = this.f12921M.get(1).mo19211a();
                            if (a4 != 0) {
                                this.f12941s.setImageResource(a4);
                            } else {
                                Drawable b4 = this.f12921M.get(1).mo19214b();
                                ((MzTextDrawable) b4).mo23385a((View) this.f12941s);
                                this.f12941s.setImageDrawable(b4);
                            }
                            this.f12941s.setOnClickListener(this.f12921M.get(1).mo19215c());
                            break;
                    }
                } else {
                    this.f12939q.setVisibility(8);
                    this.f12940r.setVisibility(8);
                    this.f12941s.setVisibility(8);
                    this.f12936n.setVisibility(8);
                }
                if (this.f12945w != null) {
                    mo22006c(true);
                    m14799h(false);
                    if (!this.f12916H) {
                        this.f12945w.mo21574c(1024, false);
                        this.f12945w.mo21574c(2048, false);
                        this.f12945w.mo21574c(4096, false);
                        this.f12942t.setVisibility(8);
                    }
                }
            }
        }
    }

    /* renamed from: g */
    public void mo22013g() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6434, new Class[0], Void.TYPE).isSupported && this.f12947y) {
            this.f12944v.mo20518c();
        }
    }

    /* renamed from: c */
    public void mo22006c(boolean z) {
        boolean z2 = z;
        if (!PatchProxy.proxy(new Object[]{new Byte(z2 ? (byte) 1 : 0)}, this, f12907a, false, 6435, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f12909A.clearAnimation();
            if (z2) {
                this.f12947y = true;
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(352);
                translateAnimation.setInterpolator(new PathInterpolator(0.2f, 0.5f, 0.05f, 1.0f));
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(translateAnimation.getDuration());
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f12957a;

                    public void onAnimationEnd(Animation animation) {
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                        if (!PatchProxy.proxy(new Object[]{animation}, this, f12957a, false, 6451, new Class[]{Animation.class}, Void.TYPE).isSupported && MzBarcodeUI.this.f12916H) {
                            MzBarcodeUI.this.f12913E.setVisibility(0);
                        }
                    }
                });
                if (this.f12909A.getVisibility() == 0) {
                    this.f12909A.startAnimation(translateAnimation);
                    this.f12913E.startAnimation(alphaAnimation);
                    return;
                }
                return;
            }
            this.f12947y = false;
            TranslateAnimation translateAnimation2 = r8;
            TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation2.setDuration(352);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(translateAnimation2.getDuration());
            alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12959a;

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (!PatchProxy.proxy(new Object[]{animation}, this, f12959a, false, 6452, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                        if (MzBarcodeUI.this.f12916H) {
                            MzBarcodeUI.this.f12913E.setVisibility(8);
                        }
                        if (!MzBarcodeUI.this.f12947y) {
                            MzBarcodeUI.this.f12935m.setVisibility(8);
                            MzBarcodeUI.this.f12933k.setVisibility(8);
                            MzBarcodeUI.this.f12939q.setVisibility(8);
                            MzBarcodeUI.this.f12937o.setVisibility(8);
                            MzBarcodeUI.this.f12909A.setVisibility(8);
                            boolean unused = MzBarcodeUI.this.f12947y = false;
                        }
                    }
                }
            });
            translateAnimation2.setInterpolator(new PathInterpolator(0.2f, 0.5f, 0.05f, 1.0f));
            if (this.f12909A.getVisibility() == 0) {
                this.f12909A.startAnimation(translateAnimation2);
                this.f12913E.startAnimation(alphaAnimation2);
            }
        }
    }

    /* renamed from: h */
    public void mo22015h() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6436, new Class[0], Void.TYPE).isSupported) {
            if (this.f12916H && this.f12947y) {
                this.f12922N.postDelayed($$Lambda$g$Krjn0EgnzIM8Kf9dBNojsdeoIQ.INSTANCE, 100);
            }
            mo22006c(false);
            if (this.f12913E.getVisibility() == 0) {
                this.f12913E.setVisibility(8);
            }
            this.f12936n.setVisibility(8);
            this.f12943u.mo23317a(false);
            m14799h(true);
            if (!this.f12916H) {
                this.f12945w.mo21574c(1024, true);
                this.f12945w.mo21574c(2048, true);
                this.f12945w.mo21574c(4096, true);
                this.f12942t.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public static /* synthetic */ void m14807n() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f12907a, true, 6446, new Class[0], Void.TYPE).isSupported) {
            EventBus.m21789a().mo27980d(21);
        }
    }

    /* renamed from: i */
    public boolean mo22016i() {
        return this.f12947y;
    }

    /* renamed from: j */
    public boolean mo22017j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12907a, false, 6437, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f12914F != null && this.f12914F.getVisibility() == 0;
    }

    /* renamed from: d */
    public void mo22008d(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12907a, false, 6438, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12926d.getLayoutParams();
            if (z) {
                i = CameraUtil.m15912r();
            }
            layoutParams.bottomMargin = i;
            this.f12926d.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m14799h(boolean z) {
        boolean z2 = true;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12907a, false, 6439, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzBarcodeRenderer eVar = this.f12943u;
            if (!z || this.f12916H) {
                z2 = false;
            }
            eVar.mo23403f(z2);
            if (!z || this.f12916H) {
                mo22019l();
            } else {
                m14805m();
            }
        }
    }

    /* renamed from: e */
    public void mo22010e(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12907a, false, 6440, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f12916H = z;
            if (this.f12943u != null) {
                this.f12943u.mo23403f(!z);
            }
            if (this.f12942t != null) {
                GlowImageView glowImageView = this.f12942t;
                if (z) {
                    i = 8;
                }
                glowImageView.setVisibility(i);
            }
        }
    }

    /* renamed from: k */
    public void mo22018k() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6441, new Class[0], Void.TYPE).isSupported && this.f12916H) {
            this.f12914F.setVisibility(8);
            this.f12922N.removeMessages(ComponentMessageType.MSG_TYPE_START_SHAKE);
        }
    }

    /* renamed from: m */
    private void m14805m() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6442, new Class[0], Void.TYPE).isSupported && this.f12944v != null && this.f12945w != null) {
            boolean D = this.f12945w.mo21481D();
            if (this.f12944v.mo20520q() != null) {
                z = this.f12944v.mo20520q().booleanValue();
            }
            if (z || !D) {
                mo22011f(this.f12945w.mo21481D());
            } else {
                mo22019l();
            }
        }
    }

    /* renamed from: l */
    public void mo22019l() {
        if (!PatchProxy.proxy(new Object[0], this, f12907a, false, 6443, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12908b, "hideFlashTip");
            this.f12910B.setVisibility(4);
            if (this.f12943u != null) {
                this.f12943u.mo23318b(false);
            }
        }
    }

    /* renamed from: f */
    public void mo22011f(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12907a, false, 6444, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f12943u == null || this.f12943u.mo23404k()) {
                LogUtil.C2630a aVar = f12908b;
                LogUtil.m15952c(aVar, "showFlashTip :" + z);
                if (z) {
                    this.f12912D.setImageResource(R.drawable.mz_ic_barcode_flash_off);
                    this.f12911C.setVisibility(0);
                } else {
                    this.f12912D.setImageResource(R.drawable.mz_ic_barcode_flash_on);
                    this.f12911C.setVisibility(4);
                }
                this.f12910B.setVisibility(0);
                if (this.f12943u != null) {
                    this.f12943u.mo23318b(true);
                    return;
                }
                return;
            }
            mo22019l();
        }
    }

    /* renamed from: g */
    public void mo22014g(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12907a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6445, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f12943u != null) {
            this.f12943u.mo23403f(z);
        }
    }
}
