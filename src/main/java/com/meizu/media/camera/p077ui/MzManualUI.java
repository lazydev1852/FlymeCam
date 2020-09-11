package com.meizu.media.camera.p077ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzManualControlBinding;
import com.meizu.media.camera.mode.CameraModeListener;
import com.meizu.media.camera.mode.ManualMode;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.HorizontalPickerView;
import com.meizu.media.camera.views.ImageCheckableView;
import com.meizu.media.camera.views.ManualCircleBoardView;
import com.meizu.media.camera.views.SelectAdapter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.GridLayoutManager;
import flyme.support.p093v7.widget.LinearLayoutManager;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.meizu.media.camera.ui.t */
public class MzManualUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13552a;

    /* renamed from: b */
    private static final LogUtil.C2630a f13553b = new LogUtil.C2630a("MzManualUI");
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f13554A = false;

    /* renamed from: B */
    private MzRecyclerView.C3227j f13555B = new MzRecyclerView.C3227j() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13585a;

        public void onItemClick(RecyclerView recyclerView, View view, int i, long j) {
            Object[] objArr = {recyclerView, view, new Integer(i), new Long(j)};
            ChangeQuickRedirect changeQuickRedirect = f13585a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7453, new Class[]{RecyclerView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported && i != -1 && ((ManualMode.C2189a) MzManualUI.this.f13569k.get(i)).mo20586a()) {
                MzManualUI.this.mo22491b(i);
                MzManualUI.this.m15566b(((ManualMode.C2189a) MzManualUI.this.f13569k.get(i)).mo20587b());
            }
        }
    };

    /* renamed from: C */
    private Runnable f13556C = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13596a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f13596a, false, 7457, new Class[0], Void.TYPE).isSupported) {
                if (MzManualUI.this.f13578t) {
                    MzManualUI.this.f13563e.setVisibility(4);
                } else {
                    MzManualUI.this.f13563e.setVisibility(8);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Runnable f13557D = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13598a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f13598a, false, 7458, new Class[0], Void.TYPE).isSupported && MzManualUI.this.f13578t) {
                MzManualUI.this.mo22498e(false);
            }
        }
    };

    /* renamed from: E */
    private ManualCircleBoardView.C2704b f13558E = new ManualCircleBoardView.C2704b() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13600a;

        /* renamed from: a */
        public void mo22514a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f13600a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7459, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                MzManualUI.this.m15569c(i);
            }
        }
    };

    /* renamed from: F */
    private HorizontalPickerView.C2702a f13559F = new HorizontalPickerView.C2702a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13602a;

        /* renamed from: a */
        public void mo22515a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f13602a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7460, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                MzManualUI.this.m15569c(i);
            }
        }
    };

    /* renamed from: G */
    private MzCommonUI.C2403f f13560G = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13587a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f13587a, false, 7465, new Class[0], Void.TYPE).isSupported) {
                if (DeviceHelper.f13929bc) {
                    MzManualUI.this.f13565g.removeCallbacks(MzManualUI.this.f13557D);
                } else {
                    MzManualUI.this.f13564f.removeCallbacks(MzManualUI.this.f13557D);
                }
                MzManualUI.this.f13561c.clearAnimation();
                MzManualUI.this.f13561c.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f13587a, false, 7466, new Class[0], Void.TYPE).isSupported) {
                if (DeviceHelper.f13929bc) {
                    if (MzManualUI.this.f13554A) {
                        MzManualUI.this.f13565g.postDelayed(MzManualUI.this.f13557D, 5000);
                        return;
                    }
                    MzManualUI.this.f13565g.postDelayed(MzManualUI.this.f13557D, 5000);
                } else if (MzManualUI.this.f13554A) {
                    MzManualUI.this.f13564f.postDelayed(MzManualUI.this.f13557D, 5000);
                    return;
                } else {
                    MzManualUI.this.f13564f.postDelayed(MzManualUI.this.f13557D, 5000);
                }
                MzManualUI.this.f13561c.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinearLayout f13561c;

    /* renamed from: d */
    private View f13562d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f13563e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HorizontalPickerView f13564f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ManualCircleBoardView f13565g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MzRecyclerView f13566h;

    /* renamed from: i */
    private LinearLayoutManager f13567i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public HashMap<String, ManualMode.C2189a> f13568j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<ManualMode.C2189a> f13569k = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C2590c f13570l;

    /* renamed from: m */
    private boolean f13571m = false;

    /* renamed from: n */
    private boolean f13572n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f13573o;

    /* renamed from: p */
    private MzUIController f13574p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C2589b f13575q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Context f13576r;

    /* renamed from: s */
    private MzCamUI f13577s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f13578t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f13579u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f13580v;

    /* renamed from: w */
    private int f13581w;

    /* renamed from: x */
    private boolean f13582x = true;

    /* renamed from: y */
    private CameraModeListener f13583y;

    /* renamed from: z */
    private boolean f13584z = false;

    /* renamed from: com.meizu.media.camera.ui.t$b */
    /* compiled from: MzManualUI */
    public interface C2589b {
        /* renamed from: a */
        void mo20576a(boolean z);

        /* renamed from: b */
        void mo20577b(String str);

        /* renamed from: c */
        void mo20578c();

        /* renamed from: c */
        void mo20579c(String str);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15569c(final int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13552a, false, 7424, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f13553b;
            LogUtil.m15942a(aVar, "onValueChange value:" + i);
            if (this.f13573o != null && this.f13568j.containsKey(this.f13573o) && this.f13568j.get(this.f13573o).mo20586a()) {
                m15580k();
                if (i != this.f13580v && this.f13582x && !ManualMode.f10872f.equals(this.f13573o)) {
                    DeviceUtil.m16194a(this.f13574p.mo21541af(), 22507);
                }
                this.f13580v = i;
                if (ManualMode.f10872f.equals(this.f13573o)) {
                    if (this.f13582x) {
                        int i2 = 1023 - i;
                        if (Math.abs(this.f13581w - i2) >= (i2 >= 800 ? 8 : 15)) {
                            DeviceUtil.m16194a(this.f13574p.mo21541af(), 22507);
                            this.f13581w = this.f13568j.get(this.f13573o).mo20590e();
                        }
                    }
                    new AsyncTaskEx<String, Void, String>() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f13604a;

                        /* renamed from: a */
                        public String mo17658a(String... strArr) {
                            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f13604a, false, 7461, new Class[]{String[].class}, String.class);
                            if (proxy.isSupported) {
                                return (String) proxy.result;
                            }
                            if (strArr == null || strArr[0] == null || !MzManualUI.this.f13568j.containsKey(strArr[0])) {
                                return null;
                            }
                            ((ManualMode.C2189a) MzManualUI.this.f13568j.get(strArr[0])).mo20584a(1023 - i);
                            MzManualUI.this.m15562a(ManualMode.f10872f);
                            return strArr[0];
                        }

                        /* renamed from: a */
                        public void mo17660a(String str) {
                            if (!PatchProxy.proxy(new Object[]{str}, this, f13604a, false, 7462, new Class[]{String.class}, Void.TYPE).isSupported) {
                                if (str != null) {
                                    View childAt = MzManualUI.this.f13566h.getChildAt(MzManualUI.this.f13570l.mo23409b());
                                    if (childAt != null) {
                                        C2588a aVar = (C2588a) MzManualUI.this.f13566h.mo26395e(childAt);
                                        float f = ((float) i) / 1023.0f;
                                        if (i == 0) {
                                            aVar.f13610b.setText(((ManualMode.C2189a) MzManualUI.this.f13568j.get(str)).mo20592g());
                                        } else if (f <= 0.0f || ((double) f) > 0.4d) {
                                            double d = (double) f;
                                            if (d > 0.4d && d <= 0.8d) {
                                                aVar.f13610b.setText(MzManualUI.this.f13576r.getResources().getText(R.string.mz_manual_focus_standard));
                                            } else if (d > 0.8d && f <= 1.0f) {
                                                aVar.f13610b.setText(MzManualUI.this.f13576r.getResources().getText(R.string.mz_manual_focus_infinite));
                                            }
                                        } else {
                                            aVar.f13610b.setText(MzManualUI.this.f13576r.getResources().getText(R.string.mz_manual_focus_marco));
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                MzManualUI.this.m15581l();
                            }
                        }
                    }.mo22610a(AsyncTaskEx.f13745s, (Params[]) new String[]{this.f13573o});
                    return;
                }
                new AsyncTaskEx<String, Void, String>() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13607a;

                    /* renamed from: a */
                    public String mo17658a(String... strArr) {
                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f13607a, false, 7463, new Class[]{String[].class}, String.class);
                        if (proxy.isSupported) {
                            return (String) proxy.result;
                        }
                        if (MzManualUI.this.f13580v == MzManualUI.this.f13579u) {
                            return null;
                        }
                        int unused = MzManualUI.this.f13579u = MzManualUI.this.f13580v;
                        if (strArr == null || strArr[0] == null) {
                            return null;
                        }
                        ((ManualMode.C2189a) MzManualUI.this.f13568j.get(strArr[0])).mo20584a(MzManualUI.this.f13580v);
                        MzManualUI.this.m15562a(strArr[0]);
                        return strArr[0];
                    }

                    /* renamed from: a */
                    public void mo17660a(String str) {
                        if (!PatchProxy.proxy(new Object[]{str}, this, f13607a, false, 7464, new Class[]{String.class}, Void.TYPE).isSupported) {
                            if (ManualMode.f10875m.equals(str)) {
                                MzManualUI.this.f13575q.mo20576a(true);
                                MzManualUI.this.f13575q.mo20579c(str);
                            }
                            MzManualUI.this.m15586n();
                            if (str != null && MzManualUI.this.f13568j.containsKey(MzManualUI.this.f13573o)) {
                                View childAt = MzManualUI.this.f13566h.getChildAt(MzManualUI.this.f13570l.mo23409b());
                                if (childAt != null) {
                                    C2588a aVar = (C2588a) MzManualUI.this.f13566h.mo26395e(childAt);
                                    if (ManualMode.f10875m.equals(str)) {
                                        aVar.f13610b.setText(MzManualUI.this.m15583m());
                                    } else {
                                        aVar.f13610b.setText(((ManualMode.C2189a) MzManualUI.this.f13568j.get(str)).mo20592g());
                                    }
                                } else {
                                    return;
                                }
                            }
                            MzManualUI.this.m15581l();
                            MzManualUI.this.f13570l.mo26541f();
                        }
                    }
                }.mo22610a(AsyncTaskEx.f13745s, (Params[]) new String[]{this.f13573o});
            }
        }
    }

    public MzManualUI(CameraBinding cameraBinding, MzCamUI iVar) {
        DelayInflateTwoBinding delayInflateTwoBinding;
        MzManualControlBinding mzManualControlBinding;
        if (cameraBinding.f9509h.getViewStub() != null) {
            delayInflateTwoBinding = (DelayInflateTwoBinding) DataBindingUtil.bind(cameraBinding.f9509h.getViewStub().inflate());
        } else {
            delayInflateTwoBinding = (DelayInflateTwoBinding) cameraBinding.f9509h.getBinding();
        }
        if (delayInflateTwoBinding.f9582m.getViewStub() != null) {
            mzManualControlBinding = (MzManualControlBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9582m.getViewStub().inflate());
        } else {
            mzManualControlBinding = (MzManualControlBinding) delayInflateTwoBinding.f9582m.getBinding();
        }
        this.f13576r = mzManualControlBinding.getRoot().getContext();
        this.f13561c = mzManualControlBinding.f9783e;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13561c.getLayoutParams();
        layoutParams.bottomMargin = CameraUtil.m15897f();
        this.f13561c.setLayoutParams(layoutParams);
        this.f13562d = mzManualControlBinding.f9782d;
        this.f13563e = mzManualControlBinding.f9781c;
        if (DeviceHelper.f13929bc) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13563e.getLayoutParams();
            layoutParams2.bottomMargin = this.f13576r.getResources().getDimensionPixelOffset(R.dimen.mz_manual_hint_text_bottom_margin);
            this.f13563e.setLayoutParams(layoutParams2);
            this.f13565g = mzManualControlBinding.f9780b;
            this.f13565g.setValueChangeListener(this.f13558E);
        } else {
            this.f13564f = mzManualControlBinding.f9779a;
            this.f13564f.setOnValueChangeListener(this.f13559F);
        }
        this.f13567i = new GridLayoutManager(mzManualControlBinding.getRoot().getContext(), 1) {
            /* renamed from: a */
            public boolean mo22258a() {
                return false;
            }
        };
        this.f13567i.mo26076b(0);
        this.f13566h = mzManualControlBinding.f9784f;
        if (DeviceHelper.f13929bc) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f13566h.getLayoutParams();
            layoutParams3.rightMargin = 0;
            layoutParams3.leftMargin = 0;
            layoutParams3.height = this.f13576r.getResources().getDimensionPixelOffset(R.dimen.mz_manual_gallery_height_two);
            this.f13566h.setLayoutParams(layoutParams3);
            this.f13566h.setBackgroundColor(this.f13576r.getResources().getColor(R.color.mz_zoom_circle_board_bg));
        }
        this.f13566h.setLayoutManager(this.f13567i);
        this.f13566h.setHapticFeedbackEnabled(false);
        this.f13566h.setOnItemClickListener(this.f13555B);
        this.f13566h.setSelectorCanDraw(false);
        this.f13570l = new C2590c(mzManualControlBinding.getRoot().getContext());
        this.f13566h.setAdapter(this.f13570l);
        this.f13577s = iVar;
    }

    /* renamed from: a */
    public boolean mo22489a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f13552a, false, 7425, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13561c != null && CameraUtil.m15856a((float) i, (float) i2, (View) this.f13561c);
    }

    /* renamed from: k */
    private void m15580k() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7426, new Class[0], Void.TYPE).isSupported) {
            if (this.f13564f != null) {
                this.f13564f.removeCallbacks(this.f13557D);
                this.f13564f.postDelayed(this.f13557D, 5000);
            } else if (this.f13565g != null) {
                this.f13565g.removeCallbacks(this.f13557D);
                this.f13565g.postDelayed(this.f13557D, 5000);
            }
        }
    }

    /* renamed from: a */
    public boolean mo22488a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13552a, false, 7427, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13561c != null && this.f13561c.getVisibility() == 0;
    }

    /* renamed from: a */
    public void mo22484a(C2589b bVar) {
        this.f13575q = bVar;
    }

    /* renamed from: a */
    public void mo22483a(MzUIController uVar) {
        this.f13574p = uVar;
    }

    /* renamed from: a */
    public void mo22487a(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13552a, false, 7428, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13561c != null) {
            LinearLayout linearLayout = this.f13561c;
            if (!z) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    /* renamed from: b */
    public void mo22490b() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7429, new Class[0], Void.TYPE).isSupported) {
            this.f13574p.mo21520a(this.f13560G);
            this.f13567i.mo26086e(0);
            if (!this.f13574p.mo21590f()) {
                this.f13561c.setVisibility(0);
            }
            this.f13574p.mo21548am();
            this.f13584z = false;
            this.f13582x = true;
            EventBus.m21789a().mo27980d(1);
        }
    }

    /* renamed from: a */
    public void mo22481a(int i) {
        ManualMode.C2189a aVar;
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13552a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7430, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (aVar = this.f13568j.get(ManualMode.f10872f)) != null && aVar.mo20586a() && aVar != null && !"-1".equals(aVar.mo20591f())) {
            aVar.mo20584a(1023 - i);
            String str = this.f13573o;
            this.f13573o = ManualMode.f10872f;
            m15562a(ManualMode.f10872f);
            this.f13573o = str;
        }
    }

    /* renamed from: c */
    public void mo22493c() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7431, new Class[0], Void.TYPE).isSupported) {
            this.f13574p.mo21520a((MzCommonUI.C2403f) null);
            this.f13563e.setVisibility(8);
            if (this.f13564f != null) {
                this.f13564f.setVisibility(8);
            } else if (this.f13565g != null) {
                this.f13565g.setVisibility(8);
            }
            this.f13578t = false;
            this.f13561c.setVisibility(8);
            this.f13573o = null;
            this.f13582x = false;
            mo22491b(-1);
            this.f13584z = false;
            EventBus.m21789a().mo27980d(4);
        }
    }

    /* renamed from: b */
    public void mo22492b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13552a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7432, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13584z = z;
            this.f13574p.mo21585e(this.f13577s.mo22178o(), this.f13584z);
        }
    }

    /* renamed from: c */
    public void mo22494c(boolean z) {
        this.f13554A = z;
    }

    /* renamed from: d */
    public boolean mo22495d() {
        return this.f13584z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15562a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13552a, false, 7433, new Class[]{String.class}, Void.TYPE).isSupported && this.f13568j.containsKey(str) && this.f13568j.get(str).mo20602q()) {
            this.f13575q.mo20577b(this.f13573o);
            this.f13575q.mo20578c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m15581l() {
        String str;
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7434, new Class[0], Void.TYPE).isSupported) {
            this.f13574p.mo21495R();
            if (this.f13573o != null && this.f13568j.containsKey(this.f13573o)) {
                if (ManualMode.f10875m.equals(this.f13573o)) {
                    str = m15583m();
                } else {
                    str = this.f13568j.get(this.f13573o).mo20592g();
                }
                this.f13563e.setText(this.f13568j.get(this.f13573o).mo20588c() + ": " + str);
                this.f13563e.setVisibility(0);
                this.f13563e.removeCallbacks(this.f13556C);
                this.f13563e.postDelayed(this.f13556C, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public String m15583m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13552a, false, 7435, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        switch (this.f13568j.get(ManualMode.f10875m).mo20590e()) {
            case 0:
                return this.f13576r.getResources().getString(R.string.mz_manual_camera_id_wide_angle);
            case 1:
                return this.f13576r.getResources().getString(R.string.mz_manual_camera_id_normal);
            case 2:
                return this.f13576r.getResources().getString(R.string.mz_manual_camera_id_tele_photo);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void mo22486a(HashMap<String, ManualMode.C2189a> hashMap, boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{hashMap, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f13552a, false, 7436, new Class[]{HashMap.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13568j = hashMap;
            this.f13569k.clear();
            if (hashMap.containsKey(ManualMode.f10869c)) {
                hashMap.get(ManualMode.f10869c).mo20593h();
                this.f13569k.add(hashMap.get(ManualMode.f10869c));
            }
            if (hashMap.containsKey(ManualMode.f10870d)) {
                hashMap.get(ManualMode.f10870d).mo20593h();
                this.f13569k.add(hashMap.get(ManualMode.f10870d));
            }
            if (hashMap.containsKey(ManualMode.f10871e)) {
                hashMap.get(ManualMode.f10871e).mo20593h();
                this.f13569k.add(hashMap.get(ManualMode.f10871e));
            }
            if (hashMap.containsKey(ManualMode.f10872f) && !z) {
                hashMap.get(ManualMode.f10872f).mo20593h();
                this.f13569k.add(hashMap.get(ManualMode.f10872f));
            }
            if (hashMap.containsKey(ManualMode.f10873g)) {
                hashMap.get(ManualMode.f10873g).mo20593h();
                this.f13569k.add(hashMap.get(ManualMode.f10873g));
            }
            if (hashMap.containsKey(ManualMode.f10875m)) {
                if (!z2) {
                    hashMap.get(ManualMode.f10875m).mo20593h();
                }
                this.f13569k.add(hashMap.get(ManualMode.f10875m));
            }
            if (hashMap.containsKey(ManualMode.f10874l)) {
                hashMap.get(ManualMode.f10874l).mo20593h();
                this.f13569k.add(hashMap.get(ManualMode.f10874l));
            }
            this.f13570l.mo26541f();
        }
    }

    /* renamed from: a */
    public void mo22485a(HashMap<String, ManualMode.C2189a> hashMap, boolean z) {
        if (!PatchProxy.proxy(new Object[]{hashMap, new Byte(z ? (byte) 1 : 0)}, this, f13552a, false, 7437, new Class[]{HashMap.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13568j = hashMap;
            if (this.f13568j.containsKey(ManualMode.f10869c)) {
                ManualMode.C2189a aVar = this.f13568j.get(ManualMode.f10869c);
                aVar.mo20593h();
                this.f13569k.remove(0);
                this.f13569k.add(0, aVar);
            }
            if (this.f13568j.containsKey(ManualMode.f10870d)) {
                this.f13568j.get(ManualMode.f10870d).mo20593h();
            }
            if (this.f13568j.containsKey(ManualMode.f10871e)) {
                ManualMode.C2189a aVar2 = this.f13568j.get(ManualMode.f10871e);
                aVar2.mo20593h();
                aVar2.mo20585a(true);
            }
            if (this.f13568j.containsKey(ManualMode.f10872f) && !z) {
                this.f13568j.get(ManualMode.f10872f).mo20593h();
            }
            if (this.f13568j.containsKey(ManualMode.f10873g)) {
                this.f13568j.get(ManualMode.f10873g).mo20593h();
            }
            if (this.f13568j.containsKey(ManualMode.f10874l)) {
                this.f13568j.get(ManualMode.f10874l).mo20593h();
            }
            this.f13570l.mo26541f();
        }
    }

    /* renamed from: e */
    public void mo22497e() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7438, new Class[0], Void.TYPE).isSupported) {
            if (!DeviceHelper.f13929bc || !ManualMode.f10875m.equals(this.f13573o)) {
                this.f13563e.setVisibility(8);
                this.f13574p.mo21520a(this.f13560G);
            }
        }
    }

    /* renamed from: f */
    public void mo22499f() {
        if (PatchProxy.proxy(new Object[0], this, f13552a, false, 7439, new Class[0], Void.TYPE).isSupported || !this.f13568j.containsKey(ManualMode.f10872f) || !this.f13568j.get(ManualMode.f10872f).mo20586a()) {
            return;
        }
        if (!this.f13568j.containsKey(this.f13573o)) {
            this.f13575q.mo20577b(ManualMode.f10872f);
            this.f13575q.mo20578c();
            this.f13566h.getAdapter().mo26541f();
        } else if (this.f13573o == null || !ManualMode.f10872f.equals(this.f13573o)) {
            this.f13575q.mo20577b(ManualMode.f10872f);
            this.f13575q.mo20578c();
            this.f13566h.getAdapter().mo26541f();
        } else if (!"-1".equals(this.f13568j.get(this.f13573o).mo20591f()) && !DeviceHelper.f13929bc) {
            this.f13564f.mo22928b(1023 - this.f13568j.get(this.f13573o).mo20590e());
        }
    }

    /* renamed from: g */
    public void mo22501g() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7440, new Class[0], Void.TYPE).isSupported && this.f13566h != null && this.f13568j != null) {
            m15586n();
            this.f13570l.mo26541f();
            if (this.f13578t && ManualMode.f10869c.equals(this.f13573o)) {
                if (DeviceHelper.f13929bc) {
                    this.f13565g.setSelectorValue(this.f13568j.get(ManualMode.f10869c).mo20592g());
                    return;
                }
                this.f13564f.setSelectorValue(this.f13568j.get(ManualMode.f10869c).mo20592g());
                this.f13564f.mo22928b(0);
            }
        }
    }

    /* renamed from: h */
    public void mo22502h() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7441, new Class[0], Void.TYPE).isSupported) {
            if (this.f13568j != null && this.f13568j.containsKey(ManualMode.f10875m)) {
                this.f13568j.get(ManualMode.f10875m).mo20593h();
            }
            this.f13570l.mo26541f();
        }
    }

    /* renamed from: d */
    public boolean mo22496d(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13552a, false, 7442, new Class[]{Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f13568j == null) {
            return false;
        }
        if (z) {
            if (this.f13568j.containsKey(ManualMode.f10869c) && this.f13568j.get(ManualMode.f10869c).mo20586a() && Float.valueOf(this.f13568j.get(ManualMode.f10869c).mo20591f()).floatValue() / 1000.0f > ((float) ManualMode.f10868b)) {
                CameraUtil.m15879b((View) this.f13561c, 170);
            }
        } else if (this.f13568j.containsKey(ManualMode.f10869c) && this.f13568j.get(ManualMode.f10869c).mo20586a() && Float.valueOf(this.f13568j.get(ManualMode.f10869c).mo20591f()).floatValue() / 1000.0f > ((float) ManualMode.f10868b)) {
            CameraUtil.m15852a((View) this.f13561c, 170);
        }
        return true;
    }

    /* renamed from: i */
    public boolean mo22503i() {
        return this.f13578t;
    }

    /* renamed from: e */
    public void mo22498e(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13552a, false, 7443, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!DeviceHelper.f13929bc) {
                this.f13573o = null;
                this.f13563e.setVisibility(8);
                this.f13578t = false;
                if (this.f13561c.getVisibility() == 0) {
                    this.f13564f.startAnimation(m15574g(false));
                } else {
                    if (this.f13564f.getVisibility() == 0) {
                        EventBus.m21789a().mo27980d(3);
                    }
                    this.f13564f.setVisibility(8);
                }
                mo22491b(-1);
                this.f13566h.mo26161c();
            } else if (!z || !ManualMode.f10875m.equals(this.f13573o)) {
                this.f13573o = null;
                this.f13563e.setVisibility(8);
                if (this.f13561c.getVisibility() == 0) {
                    m15576h(false);
                } else {
                    this.f13565g.setVisibility(8);
                }
                this.f13578t = false;
                mo22491b(-1);
                this.f13566h.mo26161c();
            }
        }
    }

    /* renamed from: b */
    public void mo22491b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13552a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7444, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            m15586n();
            this.f13570l.mo20095a(i);
            this.f13570l.mo26541f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m15586n() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7445, new Class[0], Void.TYPE).isSupported && this.f13568j != null && this.f13568j.containsKey(ManualMode.f10871e) && this.f13568j.containsKey(ManualMode.f10870d) && this.f13568j.containsKey(ManualMode.f10869c)) {
            String string = this.f13576r.getResources().getString(R.string.auto);
            if (string.equals(this.f13568j.get(ManualMode.f10870d).mo20592g()) || string.equals(this.f13568j.get(ManualMode.f10869c).mo20592g())) {
                this.f13568j.get(ManualMode.f10871e).mo20585a(true);
            } else {
                this.f13568j.get(ManualMode.f10871e).mo20585a(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15566b(String str) {
        float f;
        float f2;
        if (!PatchProxy.proxy(new Object[]{str}, this, f13552a, false, 7446, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f13574p.mo21495R();
            if (TextUtils.equals(this.f13573o, str)) {
                this.f13571m = false;
                this.f13573o = null;
                this.f13566h.mo26161c();
                mo22491b(-1);
            } else {
                this.f13571m = true;
                this.f13573o = str;
            }
            if (DeviceHelper.f13929bc) {
                this.f13565g.mo22976a();
                if (this.f13571m) {
                    this.f13563e.setVisibility(8);
                    this.f13582x = false;
                    this.f13578t = false;
                    this.f13565g.setIsSolidInterval(false);
                    this.f13565g.setMaxIndexOffSet(0);
                    m15580k();
                    if (ManualMode.f10873g.equals(this.f13573o) || ManualMode.f10875m.equals(this.f13573o)) {
                        this.f13565g.setScaleInterval(10);
                        this.f13565g.setIndexEverInterval(0);
                        this.f13565g.mo22978a(false);
                    } else {
                        this.f13565g.mo22978a(true);
                        if (ManualMode.f10869c.equals(this.f13573o) && this.f13577s.mo22178o() != DeviceHelper.f13949bw) {
                            this.f13565g.setMaxIndexOffSet(2);
                        }
                        this.f13565g.setScaleInterval(6);
                        if (ManualMode.f10871e.equals(this.f13573o) || ManualMode.f10872f.equals(this.f13573o)) {
                            if (ManualMode.f10872f.equals(this.f13573o)) {
                                this.f13565g.setIsSolidInterval(true);
                            }
                            this.f13565g.setIndexEverInterval(6);
                        } else {
                            this.f13565g.setIndexEverInterval(3);
                        }
                    }
                    this.f13565g.setValue(this.f13568j.get(this.f13573o).mo20589d(), Arrays.asList(this.f13568j.get(this.f13573o).mo20598m()));
                    if (ManualMode.f10872f.equals(this.f13573o)) {
                        ManualCircleBoardView manualCircleBoardView = this.f13565g;
                        manualCircleBoardView.setSelectorValue((ARPMessageType.MSG_TYPE_VIDEO_PAUSE - this.f13568j.get(this.f13573o).mo20590e()) + "");
                    } else {
                        this.f13565g.setSelectorValue(this.f13568j.get(this.f13573o).mo20592g());
                    }
                    if (!mo22503i()) {
                        this.f13578t = true;
                        m15576h(true);
                    }
                    this.f13582x = true;
                    return;
                }
                this.f13563e.setVisibility(8);
                this.f13575q.mo20576a(false);
                this.f13578t = false;
                m15576h(false);
                return;
            }
            this.f13564f.mo22927b();
            if (this.f13571m) {
                this.f13563e.setVisibility(8);
                this.f13564f.setVisibility(8);
                this.f13578t = false;
                this.f13582x = false;
                m15580k();
                if (ManualMode.f10872f.equals(this.f13573o)) {
                    this.f13568j.get(this.f13573o).mo20601p();
                    this.f13564f.setIntervalNumber(9);
                    this.f13564f.setMaxValue(ARPMessageType.MSG_TYPE_VIDEO_PAUSE);
                    this.f13564f.setIsSplit(true);
                    this.f13564f.setAutoOffset(0);
                } else {
                    if (ManualMode.f10870d.equals(this.f13573o)) {
                        HorizontalPickerView horizontalPickerView = this.f13564f;
                        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                            f2 = this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_iso) / 3.0f;
                        } else {
                            f2 = this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_iso);
                        }
                        horizontalPickerView.setLineSpaceWidth(f2);
                        this.f13564f.setAutoOffset(DeviceHelper.f13910bJ == CameraController.CameraApi.API2 ? (((int) this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_iso)) / 3) * 2 : 0);
                    } else if (ManualMode.f10873g.equals(this.f13573o)) {
                        this.f13564f.setLineSpaceWidth(this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_wb));
                        this.f13564f.setAutoOffset(0);
                    } else if (ManualMode.f10869c.equals(this.f13573o)) {
                        HorizontalPickerView horizontalPickerView2 = this.f13564f;
                        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                            f = this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_iso) / 3.0f;
                        } else {
                            f = this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_shutter);
                        }
                        horizontalPickerView2.setLineSpaceWidth(f);
                        this.f13564f.setAutoOffset(DeviceHelper.f13910bJ == CameraController.CameraApi.API2 ? (((int) this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_iso)) / 3) * 2 : 0);
                    } else {
                        this.f13564f.setLineSpaceWidth(this.f13576r.getResources().getDimension(R.dimen.mz_manual_linespace_width_normal));
                        this.f13564f.setAutoOffset(0);
                    }
                    this.f13564f.setIntervalNumber(0);
                }
                this.f13564f.setValue(this.f13568j.get(this.f13573o).mo20589d(), Arrays.asList(this.f13568j.get(this.f13573o).mo20598m()));
                if (this.f13568j.containsKey(this.f13573o)) {
                    this.f13564f.setIconItems(this.f13568j.get(this.f13573o).mo20599n());
                }
                this.f13564f.setIconSelectedItems(this.f13568j.get(this.f13573o).mo20600o());
                if (ManualMode.f10872f.equals(this.f13573o)) {
                    HorizontalPickerView horizontalPickerView3 = this.f13564f;
                    horizontalPickerView3.setSelectorValue((ARPMessageType.MSG_TYPE_VIDEO_PAUSE - this.f13568j.get(this.f13573o).mo20590e()) + "");
                } else {
                    this.f13564f.setSelectorValue(this.f13568j.get(this.f13573o).mo20592g());
                }
                this.f13564f.mo22925a();
                this.f13564f.invalidate();
                this.f13563e.setVisibility(0);
                this.f13582x = true;
                if (!mo22503i()) {
                    this.f13564f.setVisibility(0);
                    this.f13578t = true;
                    this.f13564f.startAnimation(m15574g(true));
                }
                EventBus.m21789a().mo27980d(2);
                return;
            }
            this.f13563e.setVisibility(8);
            this.f13578t = false;
            this.f13564f.startAnimation(m15574g(false));
            EventBus.m21789a().mo27980d(3);
        }
    }

    /* renamed from: g */
    private Animation m15574g(final boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13552a, false, 7449, new Class[]{Boolean.TYPE}, Animation.class);
        if (proxy.isSupported) {
            return (Animation) proxy.result;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f13576r, z ? R.anim.mz_manual_translate_show : R.anim.mz_manual_translate_hide);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f13590a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f13590a, false, 7454, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    boolean unused = MzManualUI.this.f13578t = z;
                    int i = 8;
                    if (DeviceHelper.f13929bc) {
                        ManualCircleBoardView p = MzManualUI.this.f13565g;
                        if (z) {
                            i = 0;
                        }
                        p.setVisibility(i);
                        return;
                    }
                    HorizontalPickerView q = MzManualUI.this.f13564f;
                    if (z) {
                        i = 0;
                    }
                    q.setVisibility(i);
                    EventBus.m21789a().mo27980d(Integer.valueOf(z ? 2 : 3));
                }
            }
        });
        return loadAnimation;
    }

    /* renamed from: h */
    private void m15576h(boolean z) {
        final boolean z2 = z;
        if (!PatchProxy.proxy(new Object[]{new Byte(z2 ? (byte) 1 : 0)}, this, f13552a, false, 7450, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13565g.setPivotX(((float) CameraUtil.m15809a()) / 2.0f);
            this.f13565g.setPivotY(this.f13576r.getResources().getDimension(R.dimen.mz_manual_circle_board_height));
            this.f13565g.clearAnimation();
            AnimatorSet animatorSet = new AnimatorSet();
            ManualCircleBoardView manualCircleBoardView = this.f13565g;
            float[] fArr = new float[2];
            float f = 80.0f;
            fArr[0] = z2 ? 80.0f : 0.0f;
            if (z2) {
                f = 0.0f;
            }
            fArr[1] = f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(manualCircleBoardView, "translationY", fArr);
            ofFloat.setDuration(175);
            ofFloat.setInterpolator(new PathInterpolator(0.14f, 0.0f, 0.09f, 1.0f));
            ManualCircleBoardView manualCircleBoardView2 = this.f13565g;
            float[] fArr2 = new float[2];
            fArr2[0] = z2 ? 0.0f : 1.0f;
            fArr2[1] = z2 ? 1.0f : 0.0f;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(manualCircleBoardView2, "alpha", fArr2);
            ofFloat2.setDuration(105);
            if (z2) {
                ofFloat2.setStartDelay(47);
            }
            ofFloat2.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            ManualCircleBoardView manualCircleBoardView3 = this.f13565g;
            float[] fArr3 = new float[2];
            fArr3[0] = z2 ? 0.66f : 1.0f;
            float f2 = 1.01f;
            fArr3[1] = z2 ? 1.01f : 0.5f;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(manualCircleBoardView3, "scaleX", fArr3);
            PathInterpolator pathInterpolator = new PathInterpolator(0.11f, 0.09f, 0.35f, 1.0f);
            ofFloat3.setDuration(187);
            ofFloat3.setInterpolator(pathInterpolator);
            ManualCircleBoardView manualCircleBoardView4 = this.f13565g;
            float[] fArr4 = new float[2];
            fArr4[0] = z2 ? 0.66f : 1.0f;
            if (!z2) {
                f2 = 0.5f;
            }
            fArr4[1] = f2;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(manualCircleBoardView4, "scaleY", fArr4);
            ofFloat4.setDuration(187);
            ofFloat4.setInterpolator(pathInterpolator);
            PathInterpolator pathInterpolator2 = new PathInterpolator(0.32f, 0.0f, 0.36f, 0.79f);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f13565g, "scaleX", new float[]{1.01f, 1.0f});
            ofFloat5.setDuration(257);
            ofFloat5.setStartDelay(187);
            ofFloat5.setInterpolator(pathInterpolator2);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f13565g, "scaleY", new float[]{1.01f, 1.0f});
            ofFloat6.setDuration(257);
            ofFloat6.setStartDelay(187);
            ofFloat6.setInterpolator(pathInterpolator2);
            if (z2) {
                animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6});
            } else {
                animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat3, ofFloat4});
            }
            animatorSet.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13593a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13593a, false, 7455, new Class[]{Animator.class}, Void.TYPE).isSupported && z2) {
                        MzManualUI.this.f13565g.setVisibility(0);
                        MzManualUI.this.f13565g.setAlpha(0.0f);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13593a, false, 7456, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        boolean unused = MzManualUI.this.f13578t = z2;
                        int i = 8;
                        if (DeviceHelper.f13929bc) {
                            ManualCircleBoardView p = MzManualUI.this.f13565g;
                            if (z2) {
                                i = 0;
                            }
                            p.setVisibility(i);
                            return;
                        }
                        HorizontalPickerView q = MzManualUI.this.f13564f;
                        if (z2) {
                            i = 0;
                        }
                        q.setVisibility(i);
                        EventBus.m21789a().mo27980d(Integer.valueOf(z2 ? 2 : 3));
                    }
                }
            });
            animatorSet.start();
        }
    }

    /* renamed from: a */
    public void mo22482a(CameraModeListener hVar) {
        this.f13583y = hVar;
    }

    /* renamed from: j */
    public void mo22504j() {
        if (!PatchProxy.proxy(new Object[0], this, f13552a, false, 7451, new Class[0], Void.TYPE).isSupported) {
            mo22498e(false);
        }
    }

    /* renamed from: com.meizu.media.camera.ui.t$a */
    /* compiled from: MzManualUI */
    class C2588a extends RecyclerView.C3286u {

        /* renamed from: a */
        ImageCheckableView f13609a;

        /* renamed from: b */
        TextView f13610b;

        public C2588a(View view) {
            super(view);
            this.f13609a = (ImageCheckableView) view.findViewById(R.id.mz_manual_item_view);
            this.f13610b = (TextView) view.findViewById(R.id.mz_manual_item_value);
            if (DeviceHelper.f13929bc) {
                RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
                hVar.width = MzManualUI.this.f13576r.getResources().getDimensionPixelOffset(R.dimen.mz_manual_new_widget_item_width);
                view.setLayoutParams(hVar);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13609a.getLayoutParams();
                int dimensionPixelOffset = MzManualUI.this.f13576r.getResources().getDimensionPixelOffset(R.dimen.mz_manual_new_widget_image_item_width);
                layoutParams.height = dimensionPixelOffset;
                layoutParams.width = dimensionPixelOffset;
                layoutParams.bottomMargin = MzManualUI.this.f13576r.getResources().getDimensionPixelOffset(R.dimen.mz_manual_new_widget_image_item_bottom_margin);
                this.f13609a.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.ui.t$c */
    /* compiled from: MzManualUI */
    public class C2590c extends SelectAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f13612a;

        /* renamed from: f */
        private LayoutInflater f13614f;

        /* renamed from: c */
        public long mo20100c(int i) {
            return (long) i;
        }

        public C2590c(Context context) {
            this.f13614f = LayoutInflater.from(context);
        }

        /* renamed from: b */
        public RecyclerView.C3286u mo20098b(ViewGroup viewGroup, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f13612a, false, 7473, new Class[]{ViewGroup.class, Integer.TYPE}, RecyclerView.C3286u.class);
            if (proxy.isSupported) {
                return (RecyclerView.C3286u) proxy.result;
            }
            return new C2588a(this.f13614f.inflate(R.layout.mz_manual_item, viewGroup, false));
        }

        /* renamed from: a_ */
        public int mo22520a_(int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13612a, false, 7474, new Class[]{Integer.TYPE}, Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : super.mo22520a_(i);
        }

        /* renamed from: a */
        public void mo20097a(RecyclerView.C3286u uVar, int i) {
            if (!PatchProxy.proxy(new Object[]{uVar, new Integer(i)}, this, f13612a, false, 7475, new Class[]{RecyclerView.C3286u.class, Integer.TYPE}, Void.TYPE).isSupported) {
                C2588a aVar = (C2588a) uVar;
                ManualMode.C2189a aVar2 = (ManualMode.C2189a) MzManualUI.this.f13569k.get(i);
                aVar.f13609a.setTwoStateIcon(aVar2.mo20596k(), aVar2.mo20595j());
                if (aVar2.mo20586a()) {
                    if (ManualMode.f10875m.equals(aVar2.mo20587b())) {
                        aVar.f13610b.setText(MzManualUI.this.m15583m());
                    } else {
                        aVar.f13610b.setText(aVar2.mo20592g());
                    }
                    aVar.f13610b.setTextColor(-1);
                    aVar.f13610b.setAlpha(1.0f);
                    aVar.f13609a.setImageResource(i == this.f15559c ? aVar2.mo20595j() : aVar2.mo20596k());
                    return;
                }
                aVar.f13610b.setText(aVar2.mo20594i());
                if (aVar2.mo20597l() != 0) {
                    aVar.f13609a.setImageResource(aVar2.mo20597l());
                }
                aVar.f13610b.setAlpha(0.45f);
            }
        }

        /* renamed from: a */
        public int mo20093a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13612a, false, 7476, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : MzManualUI.this.f13569k.size();
        }

        /* renamed from: a */
        public void mo20095a(int i) {
            this.f15559c = i;
        }
    }

    /* renamed from: f */
    public void mo22500f(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13552a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7452, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13564f != null) {
            LogUtil.C2630a aVar = f13553b;
            LogUtil.m15942a(aVar, "enableManualGallery: " + z);
            this.f13564f.setEnable(z);
        }
    }
}
