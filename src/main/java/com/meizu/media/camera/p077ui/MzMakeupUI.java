package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.common.widget.AdapterView;
import com.meizu.common.widget.EnhanceGallery;
import com.meizu.imageproc.effects.renders.VideoMakeupRender;
import com.meizu.media.camera.MzFilterPreference;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.PreferenceGroup;
import com.meizu.media.camera.R;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzMakeupControlBinding;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.ui.s */
public class MzMakeupUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13519a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f13520b = new LogUtil.C2630a("MakeupUI");
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static final String[] f13521o = {"original", "enthusiasm", "neighbour", "lolita", "fresh", "charm"};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MzFilterPreference[] f13522c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PreferenceGroup f13523d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2572a f13524e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f13525f;

    /* renamed from: g */
    private EnhanceGallery f13526g;

    /* renamed from: h */
    private PreviewView f13527h;

    /* renamed from: i */
    private MzCamUI f13528i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C2575d f13529j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public VideoMakeupRender f13530k;

    /* renamed from: l */
    private MzUIController f13531l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C2573b f13532m = new C2573b();

    /* renamed from: n */
    private Context f13533n;

    /* renamed from: p */
    private MzCommonUI.C2403f f13534p = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13535a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f13535a, false, 7418, new Class[0], Void.TYPE).isSupported) {
                MzMakeupUI.this.f13525f.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f13535a, false, 7419, new Class[0], Void.TYPE).isSupported) {
                MzMakeupUI.this.f13525f.setVisibility(0);
            }
        }
    };

    /* renamed from: com.meizu.media.camera.ui.s$d */
    /* compiled from: MzMakeupUI */
    public interface C2575d {
        /* renamed from: a */
        void mo20571a(String str, int i, boolean z);
    }

    public MzMakeupUI(Context context, DelayInflateTwoBinding delayInflateTwoBinding, MzCamUI iVar) {
        MzMakeupControlBinding mzMakeupControlBinding;
        this.f13533n = context;
        if (delayInflateTwoBinding.f9581l.getViewStub() != null) {
            mzMakeupControlBinding = (MzMakeupControlBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9581l.getViewStub().inflate());
        } else {
            mzMakeupControlBinding = (MzMakeupControlBinding) delayInflateTwoBinding.f9581l.getBinding();
        }
        this.f13525f = mzMakeupControlBinding.f9774b;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13525f.getLayoutParams();
        layoutParams.bottomMargin = CameraUtil.m15897f();
        this.f13525f.setLayoutParams(layoutParams);
        this.f13526g = mzMakeupControlBinding.f9773a;
        if (this.f13523d == null) {
            m15528a(this.f13523d);
        }
        this.f13524e = new C2572a(context);
        this.f13526g.setAdapter((SpinnerAdapter) this.f13524e);
        this.f13526g.setOnItemClickListener(new C2574c());
        this.f13527h = iVar.mo22133av();
        this.f13528i = iVar;
    }

    /* renamed from: a */
    public void mo22461a(MzUIController uVar) {
        this.f13531l = uVar;
    }

    /* renamed from: a */
    public void mo22460a() {
        if (!PatchProxy.proxy(new Object[0], this, f13519a, false, 7404, new Class[0], Void.TYPE).isSupported) {
            this.f13531l.mo21520a(this.f13534p);
            this.f13528i.mo22084a("Mzmake up");
            this.f13530k = (VideoMakeupRender) this.f13527h.getRender();
            if (this.f13530k != null) {
                this.f13530k.mo17631b("original");
            }
        }
    }

    /* renamed from: b */
    public void mo22464b() {
        if (!PatchProxy.proxy(new Object[0], this, f13519a, false, 7405, new Class[0], Void.TYPE).isSupported) {
            this.f13525f.setVisibility(8);
            this.f13531l.mo21520a((MzCommonUI.C2403f) null);
            if (this.f13528i != null) {
                this.f13528i.mo22084a("Mznone");
            }
            if (this.f13530k != null) {
                this.f13530k.mo17631b("original");
            }
            this.f13530k = null;
            if (this.f13524e != null) {
                this.f13524e.mo22473a(0);
                this.f13524e.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: a */
    public boolean mo22463a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f13519a, false, 7406, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13526g != null && CameraUtil.m15856a((float) i, (float) i2, (View) this.f13526g);
    }

    /* renamed from: c */
    public boolean mo22465c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13519a, false, 7407, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13526g != null && this.f13526g.getVisibility() == 0;
    }

    /* renamed from: d */
    public void mo22466d() {
        if (!PatchProxy.proxy(new Object[0], this, f13519a, false, 7408, new Class[0], Void.TYPE).isSupported && this.f13525f != null && this.f13525f.getVisibility() != 0) {
            this.f13525f.setVisibility(0);
            this.f13525f.startAnimation(m15526a(true));
        }
    }

    /* renamed from: a */
    public void mo22462a(C2575d dVar) {
        this.f13529j = dVar;
    }

    /* renamed from: e */
    public void mo22467e() {
        if (!PatchProxy.proxy(new Object[0], this, f13519a, false, 7409, new Class[0], Void.TYPE).isSupported) {
            this.f13532m.m15553b();
        }
    }

    /* renamed from: com.meizu.media.camera.ui.s$e */
    /* compiled from: MzMakeupUI */
    static class C2576e {

        /* renamed from: a */
        ImageView f13549a;

        /* renamed from: b */
        ImageView f13550b;

        /* renamed from: c */
        TextView f13551c;

        C2576e() {
        }
    }

    /* renamed from: com.meizu.media.camera.ui.s$a */
    /* compiled from: MzMakeupUI */
    public class C2572a extends BaseAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f13539a;

        /* renamed from: c */
        private LayoutInflater f13541c;

        /* renamed from: d */
        private int f13542d;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public C2572a(Context context) {
            this.f13541c = LayoutInflater.from(context);
        }

        /* renamed from: a */
        public void mo22473a(int i) {
            this.f13542d = i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C2576e eVar;
            View view2;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), view, viewGroup}, this, f13539a, false, 7420, new Class[]{Integer.TYPE, View.class, ViewGroup.class}, View.class);
            if (proxy.isSupported) {
                return (View) proxy.result;
            }
            if (view == null) {
                eVar = new C2576e();
                view2 = this.f13541c.inflate(R.layout.mz_makeup_item, (ViewGroup) null);
                eVar.f13549a = (ImageView) view2.findViewById(R.id.mz_makeup_item_img);
                eVar.f13551c = (TextView) view2.findViewById(R.id.mz_makeup_item_txt);
                eVar.f13550b = (ImageView) view2.findViewById(R.id.mz_makeup_item_bg);
                eVar.f13549a.setImageResource(MzMakeupUI.this.m15524a(i));
                eVar.f13551c.setText(MzMakeupUI.this.m15530b(i));
            } else {
                view.setTag((Object) null);
                view2 = view;
                eVar = null;
            }
            if (this.f13542d == i) {
                eVar.f13550b.setBackgroundResource(R.drawable.mz_makeup_item_select);
            } else {
                eVar.f13550b.setBackground((Drawable) null);
            }
            return view2;
        }

        public int getCount() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13539a, false, 7421, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : MzMakeupUI.this.f13523d.mo18594c();
        }
    }

    /* renamed from: a */
    private void m15528a(PreferenceGroup preferenceGroup) {
        int c;
        if (!PatchProxy.proxy(new Object[]{preferenceGroup}, this, f13519a, false, 7410, new Class[]{PreferenceGroup.class}, Void.TYPE).isSupported && preferenceGroup != null && (c = preferenceGroup.mo18594c()) > 0) {
            this.f13522c = new MzFilterPreference[c];
            for (int i = 0; i < c; i++) {
                this.f13522c[i] = (MzFilterPreference) this.f13523d.mo18591a(i);
                LogUtil.C2630a aVar = f13520b;
                LogUtil.m15942a(aVar, "title " + i + " : " + this.f13522c[i].mo18346a());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m15524a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13519a, false, 7411, new Class[]{Integer.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f13522c[i].mo18347c();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m15530b(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13519a, false, 7413, new Class[]{Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : this.f13522c[i].mo18346a();
    }

    /* renamed from: f */
    public C2573b mo22468f() {
        return this.f13532m;
    }

    /* renamed from: com.meizu.media.camera.ui.s$c */
    /* compiled from: MzMakeupUI */
    private class C2574c implements AdapterView.C1350b {

        /* renamed from: a */
        public static ChangeQuickRedirect f13547a;

        private C2574c() {
        }

        /* renamed from: a */
        public void mo16109a(AdapterView<?> adapterView, View view, int i, long j) {
            Object[] objArr = {adapterView, view, new Integer(i), new Long(j)};
            ChangeQuickRedirect changeQuickRedirect = f13547a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7423, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported && i >= 0) {
                LogUtil.C2630a h = MzMakeupUI.f13520b;
                LogUtil.m15952c(h, "makeup item click" + MzMakeupUI.this.f13522c[i].mo18348d());
                MzMakeupUI.this.f13530k.mo17631b(MzMakeupUI.this.f13522c[i].mo18348d());
                MzMakeupUI.this.f13529j.mo20571a("makeup-Style", VideoMakeupRender.m6383a(MzMakeupUI.this.f13522c[i].mo18348d()), true);
                MzMakeupUI.this.f13532m.mo22479a(MzMakeupUI.this.f13522c[i].mo18348d());
                MzMakeupUI.this.f13532m.mo22480b(MzMakeupUI.f13521o[i]);
                MzMakeupUI.this.f13524e.mo22473a(i);
                MzMakeupUI.this.f13524e.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.meizu.media.camera.ui.s$b */
    /* compiled from: MzMakeupUI */
    public class C2573b {

        /* renamed from: a */
        public static ChangeQuickRedirect f13543a;

        /* renamed from: c */
        private String f13545c;

        /* renamed from: d */
        private String f13546d;

        public C2573b() {
            m15553b();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m15553b() {
            if (!PatchProxy.proxy(new Object[0], this, f13543a, false, 7422, new Class[0], Void.TYPE).isSupported) {
                this.f13545c = "original";
                this.f13546d = MzMakeupUI.f13521o[0];
            }
        }

        /* renamed from: a */
        public void mo22479a(String str) {
            this.f13545c = str;
        }

        /* renamed from: b */
        public void mo22480b(String str) {
            this.f13546d = str;
        }

        /* renamed from: a */
        public String mo22478a() {
            return this.f13545c;
        }
    }

    /* renamed from: a */
    private Animation m15526a(final boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13519a, false, 7416, new Class[]{Boolean.TYPE}, Animation.class);
        if (proxy.isSupported) {
            return (Animation) proxy.result;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f13533n, z ? R.anim.mz_fb_control_translate_show : R.anim.mz_fb_control_translate_hide);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                boolean z = z;
            }

            public void onAnimationEnd(Animation animation) {
                boolean z = z;
            }
        });
        return loadAnimation;
    }

    /* renamed from: g */
    public void mo22469g() {
        if (!PatchProxy.proxy(new Object[0], this, f13519a, false, 7417, new Class[0], Void.TYPE).isSupported) {
            if (this.f13528i.mo22096aC()) {
                this.f13525f.setBackground(this.f13533n.getResources().getDrawable(R.color.mz_makeup_menu_fullscreen_bg_color));
            } else {
                this.f13525f.setBackground(this.f13533n.getResources().getDrawable(R.color.mz_makeup_menu_normal_bg_color));
            }
        }
    }
}
