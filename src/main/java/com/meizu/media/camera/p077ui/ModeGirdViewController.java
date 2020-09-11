package com.meizu.media.camera.p077ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.PreviewGestures;
import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.modemove.C2236a;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.PreferenceUtil;
import com.meizu.media.camera.util.SlideBarModeComparator;
import com.meizu.media.camera.views.ImageCheckableView;
import com.meizu.media.camera.views.ModeItemView;
import com.meizu.media.camera.views.MzSlideModeRenderer;
import com.meizu.media.camera.views.RedTipView;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.media.camera.views.Rotatable;
import com.meizu.media.camera.views.TextCheckableView;
import com.meizu.media.mzdocumentscannersdk.MzCropDSController;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.meizu.media.camera.ui.b */
public class ModeGirdViewController implements View.OnTouchListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f12739a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f12740b = new LogUtil.C2630a("ModeGirdViewController");
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ImageView f12741A;

    /* renamed from: B */
    private int f12742B = -1;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public CameraModeType.ModeType[] f12743C;

    /* renamed from: D */
    private boolean f12744D = false;

    /* renamed from: E */
    private boolean f12745E = false;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Context f12746F;

    /* renamed from: G */
    private View.OnLayoutChangeListener f12747G = new View.OnLayoutChangeListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12778a;

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Object[] objArr = {view, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4), new Integer(i5), new Integer(i6), new Integer(i7), new Integer(i8)};
            ChangeQuickRedirect changeQuickRedirect = f12778a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6289, new Class[]{View.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                LogUtil.C2630a g = ModeGirdViewController.f12740b;
                LogUtil.m15942a(g, "onLayoutChange:" + ModeGirdViewController.this.f12765r);
            }
        }
    };

    /* renamed from: H */
    private MzSlideModeRenderer.C2751a f12748H = new MzSlideModeRenderer.C2751a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12780a;

        /* renamed from: a */
        public void mo21918a() {
            if (!PatchProxy.proxy(new Object[0], this, f12780a, false, 6290, new Class[0], Void.TYPE).isSupported) {
                ModeGirdViewController.this.f12761n.mo21048b(false);
            }
        }

        /* renamed from: a */
        public void mo21919a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f12780a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6291, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && ModeGirdViewController.this.f12761n != null) {
                ModeGirdViewController.this.f12761n.mo21045a(i);
            }
        }

        /* renamed from: b */
        public void mo21920b() {
            if (!PatchProxy.proxy(new Object[0], this, f12780a, false, 6293, new Class[0], Void.TYPE).isSupported) {
                ModeGirdViewController.this.mo21902b();
            }
        }

        /* renamed from: c */
        public void mo21921c() {
            if (!PatchProxy.proxy(new Object[0], this, f12780a, false, 6294, new Class[0], Void.TYPE).isSupported) {
                ModeGirdViewController.this.mo21905c();
            }
        }

        /* renamed from: d */
        public boolean mo21922d() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12780a, false, 6295, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            return ModeGirdViewController.this.f12772y != null && ModeGirdViewController.this.f12772y.mo20687a();
        }

        /* renamed from: e */
        public boolean mo21923e() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12780a, false, 6296, new Class[0], Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : ModeGirdViewController.this.f12761n.mo21050c();
        }
    };

    /* renamed from: I */
    private C2236a.C2238b f12749I = new C2236a.C2238b() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12786a;

        /* renamed from: a */
        public void mo20691a() {
            if (!PatchProxy.proxy(new Object[0], this, f12786a, false, 6299, new Class[0], Void.TYPE).isSupported) {
                ModeGirdViewController.this.f12750c.mo23403f(false);
                ModeGirdViewController.this.f12757j.setVisibility(8);
                ModeGirdViewController.this.f12773z.setVisibility(8);
                ModeGirdViewController.this.f12741A.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo20692b() {
            if (!PatchProxy.proxy(new Object[0], this, f12786a, false, 6300, new Class[0], Void.TYPE).isSupported) {
                CameraUtil.m15885c(ModeGirdViewController.this.f12763p.getApplicationContext());
                ModeGirdViewController.this.mo21894a((CameraModeType.ModeType) null);
                ModeGirdViewController.this.m14574e(false);
                ModeGirdViewController.this.f12750c.mo23403f(true);
                ModeGirdViewController.this.f12757j.setVisibility(0);
                ModeGirdViewController.this.f12773z.setVisibility(0);
                ModeGirdViewController.this.f12741A.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MzSlideModeRenderer f12750c;

    /* renamed from: d */
    private RenderOverlay f12751d;

    /* renamed from: e */
    private int f12752e = -1;

    /* renamed from: f */
    private int f12753f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<CameraModeType.ModeType> f12754g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<CameraModeType.ModeType> f12755h = new ArrayList<>();

    /* renamed from: i */
    private View f12756i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public FrameLayout f12757j;

    /* renamed from: k */
    private FrameLayout f12758k;

    /* renamed from: l */
    private GridView f12759l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C2447d f12760m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C2446c f12761n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public List<C2445b> f12762o = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Activity f12763p;

    /* renamed from: q */
    private Handler f12764q = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f12765r = false;

    /* renamed from: s */
    private boolean f12766s;

    /* renamed from: t */
    private boolean f12767t;

    /* renamed from: u */
    private boolean f12768u;

    /* renamed from: v */
    private PreviewGestures f12769v;

    /* renamed from: w */
    private Animation f12770w;

    /* renamed from: x */
    private Animation f12771x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C2236a f12772y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ImageView f12773z;

    /* renamed from: com.meizu.media.camera.ui.b$c */
    /* compiled from: ModeGirdViewController */
    public interface C2446c {
        /* renamed from: a */
        void mo21044a();

        /* renamed from: a */
        void mo21045a(int i);

        /* renamed from: a */
        void mo21046a(CameraModeType.ModeType modeType);

        /* renamed from: a */
        void mo21047a(boolean z);

        /* renamed from: b */
        void mo21048b(boolean z);

        /* renamed from: b */
        boolean mo21049b();

        /* renamed from: c */
        boolean mo21050c();
    }

    public ModeGirdViewController(Activity activity, View view, C2236a aVar, boolean z, boolean z2, boolean z3) {
        this.f12763p = activity;
        this.f12746F = ContextBuilder.m6349a(this.f12763p, true, true);
        this.f12756i = view;
        this.f12772y = aVar;
        if (z) {
            this.f12743C = new CameraModeType.ModeType[]{CameraModeType.ModeType.AUTO};
        } else if (z2) {
            this.f12743C = new CameraModeType.ModeType[]{CameraModeType.ModeType.VIDEO};
        } else if (z3) {
            this.f12743C = new CameraModeType.ModeType[]{CameraModeType.ModeType.BARCODE};
        } else {
            m14574e(true);
        }
        m14579h();
        this.f12770w = AnimationUtils.loadAnimation(this.f12763p, R.anim.mz_mode_menu_gridview_enter);
        this.f12771x = AnimationUtils.loadAnimation(this.f12763p, R.anim.mz_mode_menu_gridview_exit);
        this.f12766s = z;
        this.f12767t = z2;
        this.f12768u = z3;
        if (this.f12772y != null) {
            this.f12772y.mo20685a(this.f12749I);
        }
    }

    /* renamed from: a */
    public void mo21896a(RenderOverlay renderOverlay, PreviewGestures yVar) {
        if (!PatchProxy.proxy(new Object[]{renderOverlay, yVar}, this, f12739a, false, 6259, new Class[]{RenderOverlay.class, PreviewGestures.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12740b;
            LogUtil.m15942a(aVar, "initRender mSlideModeRenderer:" + this.f12750c);
            if (!this.f12745E) {
                this.f12750c.mo23370a(this.f12748H);
                this.f12751d = renderOverlay;
                if (this.f12767t || this.f12766s || this.f12768u) {
                    this.f12750c.mo23375b(false);
                }
                renderOverlay.mo23142a((RenderOverlay.C2723a) this.f12750c);
                this.f12769v = yVar;
                mo21894a(CameraModeType.ModeType.AUTO);
                this.f12745E = true;
            }
            this.f12753f = this.f12750c.mo23367a();
        }
    }

    /* renamed from: a */
    public void mo21897a(MzSlideModeRenderer jVar) {
        this.f12750c = jVar;
    }

    /* renamed from: a */
    public void mo21899a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6260, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f12750c.mo23374a(CameraModeType.m10962e(CameraModeType.ModeType.AUTO), z)) {
            if (this.f12750c.mo23376b() || !z) {
                mo21905c();
            }
            this.f12753f = CameraModeType.m10962e(CameraModeType.ModeType.AUTO);
        }
    }

    /* renamed from: a */
    public void mo21898a(ArrayList<CameraModeType.ModeType> arrayList, CameraModeType.ModeType modeType) {
        Class[] clsArr = {ArrayList.class, CameraModeType.ModeType.class};
        if (!PatchProxy.proxy(new Object[]{arrayList, modeType}, this, f12739a, false, 6261, clsArr, Void.TYPE).isSupported) {
            this.f12750c.mo23371a(arrayList, modeType);
            this.f12753f = this.f12750c.mo23367a();
        }
    }

    /* renamed from: a */
    public void mo21894a(CameraModeType.ModeType modeType) {
        if (!PatchProxy.proxy(new Object[]{modeType}, this, f12739a, false, 6262, new Class[]{CameraModeType.ModeType.class}, Void.TYPE).isSupported) {
            ArrayList arrayList = new ArrayList();
            if (this.f12766s || this.f12767t || this.f12768u) {
                Collections.addAll(arrayList, this.f12743C);
            } else {
                boolean equals = PreferenceUtil.m15983c(this.f12763p, "enable_funny_snap_mode", "1").equals("1");
                for (CameraModeType.ModeType modeType2 : CameraModeType.f10557b) {
                    if (modeType2.getSortDeterminer() >= 0 && (!modeType2.equals(CameraModeType.ModeType.FUNNY_SNAP) || equals)) {
                        arrayList.add(modeType2);
                    }
                }
                if (arrayList.contains(CameraModeType.ModeType.AUTO) && arrayList.contains(CameraModeType.ModeType.VIDEO) && arrayList.size() == 2) {
                    arrayList.clear();
                    arrayList.add(CameraModeType.ModeType.VIDEO);
                    arrayList.add(CameraModeType.ModeType.AUTO);
                }
            }
            Collections.sort(arrayList, new SlideBarModeComparator());
            mo21898a((ArrayList<CameraModeType.ModeType>) arrayList, modeType);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m14574e(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12739a, false, 6263, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            boolean equals = PreferenceUtil.m15983c(this.f12763p, "enable_funny_snap_mode", "1").equals("1");
            boolean z2 = Settings.Global.getInt(this.f12763p.getContentResolver(), "enable_back_trace_mode", 0) == 1;
            boolean z3 = PreferenceUtil.m15983c(this.f12763p, "enable_amazing_ar_mode", "1").equals("1") && PreferenceUtil.m15983c(this.f12763p, "amazing_ar_mode_value", "0").equals("1");
            this.f12743C = CameraModeType.f10557b;
            this.f12754g.clear();
            this.f12755h.clear();
            this.f12762o.clear();
            ArrayList arrayList = new ArrayList();
            int i = -1;
            for (int i2 = 0; i2 < this.f12743C.length; i2++) {
                if ((!this.f12743C[i2].equals(CameraModeType.ModeType.FUNNY_SNAP) || equals) && ((!this.f12743C[i2].equals(CameraModeType.ModeType.AMAZINGAR) || z3) && !this.f12743C[i2].equals(CameraModeType.ModeType.AR) && (!this.f12743C[i2].equals(CameraModeType.ModeType.BACK_TRACE) || ((z2 || !CameraUtil.m15857a(this.f12746F, "com.meizu.flymelab", 1001003)) && CameraUtil.m15857a(this.f12746F, "com.meizu.media.gallery", 700003000))))) {
                    if (this.f12743C[i2].equals(CameraModeType.ModeType.DOCUMENT) && z && this.f12743C[i2].getSortDeterminer() < 0) {
                        i = i2;
                    } else if (!arrayList.contains(Integer.valueOf(this.f12743C[i2].getGroupId()))) {
                        arrayList.add(Integer.valueOf(this.f12743C[i2].getGroupId()));
                        if (this.f12743C[i2].getSortDeterminer() < 0) {
                            this.f12754g.add(this.f12743C[i2]);
                        } else {
                            this.f12755h.add(this.f12743C[i2]);
                        }
                    }
                }
            }
            Collections.sort(this.f12754g, new SlideBarModeComparator());
            Collections.sort(this.f12755h, new SlideBarModeComparator());
            Iterator<CameraModeType.ModeType> it = this.f12754g.iterator();
            while (it.hasNext()) {
                CameraModeType.ModeType next = it.next();
                C2445b bVar = new C2445b();
                if (CameraModeType.m10950a(next)) {
                    bVar.f12796e = true;
                }
                bVar.f12792a = next.getGroupTextId() == -1 ? next.getTxtId() : next.getGroupTextId();
                bVar.f12794c = next.getIconPressedId();
                bVar.f12793b = next.getIconNormalId();
                bVar.f12795d = next.getIconDownloadId();
                this.f12762o.add(bVar);
            }
            if (i >= 0) {
                m14565a(CameraModeType.ModeType.DOCUMENT, i);
            } else if (this.f12760m != null) {
                this.f12760m.notifyDataSetChanged();
            }
            if (this.f12772y != null) {
                this.f12772y.mo20686a((List<? extends CameraModeType.ModeType>) this.f12754g, (List<? extends CameraModeType.ModeType>) this.f12755h);
            }
        }
    }

    /* renamed from: h */
    private void m14579h() {
        if (!PatchProxy.proxy(new Object[0], this, f12739a, false, 6264, new Class[0], Void.TYPE).isSupported && this.f12757j == null) {
            ViewStub viewStub = (ViewStub) this.f12756i.findViewById(R.id.mz_mode_menu_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            this.f12757j = (FrameLayout) this.f12756i.findViewById(R.id.mz_mode_menu_layout);
            this.f12757j.setPadding(0, CameraUtil.m15901h(), 0, CameraUtil.m15897f());
            this.f12758k = (FrameLayout) this.f12757j.findViewById(R.id.mz_mode_menu_container);
            this.f12759l = (GridView) this.f12758k.findViewById(R.id.mz_mode_menu);
            this.f12760m = new C2447d(this.f12763p);
            this.f12759l.setAdapter(this.f12760m);
            this.f12759l.setChoiceMode(1);
            this.f12759l.setOverScrollMode(1);
            this.f12759l.setSelector(new ColorDrawable(0));
            this.f12759l.setOnItemClickListener(this);
            this.f12759l.setOnTouchListener(this);
            this.f12759l.addOnLayoutChangeListener(this.f12747G);
            if (this.f12742B != -1) {
                this.f12759l.setItemChecked(this.f12742B, true);
            }
            this.f12742B = -1;
            this.f12757j.setVisibility(8);
            this.f12773z = (ImageView) this.f12756i.findViewById(R.id.mode_menu_shutter_btn);
            this.f12741A = (ImageView) this.f12756i.findViewById(R.id.shutter_bg);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, motionEvent}, this, f12739a, false, 6265, new Class[]{View.class, MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!(this.f12769v == null || this.f12769v.mo22782d() == null)) {
            this.f12769v.mo22782d().onTouchEvent(motionEvent);
        }
        return false;
    }

    /* renamed from: com.meizu.media.camera.ui.b$b */
    /* compiled from: ModeGirdViewController */
    public class C2445b {

        /* renamed from: a */
        public int f12792a;

        /* renamed from: b */
        public int f12793b;

        /* renamed from: c */
        int f12794c;

        /* renamed from: d */
        int f12795d;

        /* renamed from: e */
        boolean f12796e = false;

        public C2445b() {
        }
    }

    /* renamed from: com.meizu.media.camera.ui.b$a */
    /* compiled from: ModeGirdViewController */
    private static class C2444a {

        /* renamed from: a */
        ImageCheckableView f12789a;

        /* renamed from: b */
        TextCheckableView f12790b;

        /* renamed from: c */
        RedTipView f12791c;

        private C2444a() {
        }
    }

    /* renamed from: a */
    public void mo21895a(C2446c cVar) {
        this.f12761n = cVar;
    }

    /* renamed from: com.meizu.media.camera.ui.b$d */
    /* compiled from: ModeGirdViewController */
    public class C2447d extends BaseAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f12798a;

        /* renamed from: c */
        private LayoutInflater f12800c;

        /* renamed from: d */
        private List<Rotatable> f12801d = new ArrayList();

        public long getItemId(int i) {
            return (long) i;
        }

        public C2447d(Context context) {
            this.f12800c = (LayoutInflater) ModeGirdViewController.this.f12746F.getSystemService("layout_inflater");
        }

        public int getCount() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12798a, false, 6301, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : ModeGirdViewController.this.f12762o.size();
        }

        public Object getItem(int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12798a, false, 6302, new Class[]{Integer.TYPE}, Object.class);
            return proxy.isSupported ? proxy.result : ModeGirdViewController.this.f12762o.get(i);
        }

        /* renamed from: a */
        private C2445b m14624a(int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12798a, false, 6303, new Class[]{Integer.TYPE}, C2445b.class);
            return proxy.isSupported ? (C2445b) proxy.result : (C2445b) ModeGirdViewController.this.f12762o.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C2444a aVar;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), view, viewGroup}, this, f12798a, false, 6304, new Class[]{Integer.TYPE, View.class, ViewGroup.class}, View.class);
            if (proxy.isSupported) {
                return (View) proxy.result;
            }
            C2445b a = m14624a(i);
            Activity c = ModeGirdViewController.this.f12763p;
            boolean equals = PreferenceUtil.m15983c(c, "camera.mode_userguide" + ModeGirdViewController.this.f12754g.get(i), "0").equals("1");
            if (view == null) {
                view = this.f12800c.inflate(R.layout.mz_mode_menu_item, (ViewGroup) null);
                aVar = new C2444a();
                aVar.f12789a = (ImageCheckableView) view.findViewById(R.id.mode_icon);
                aVar.f12790b = (TextCheckableView) view.findViewById(R.id.mode_name);
                aVar.f12791c = (RedTipView) view.findViewById(R.id.mode_badge);
                if (!a.f12796e || equals) {
                    aVar.f12791c.setVisibility(8);
                } else {
                    aVar.f12791c.setVisibility(0);
                }
                view.setTag(aVar);
                if (this.f12801d.size() < getCount() * 2) {
                    this.f12801d.add((ModeItemView) view);
                }
            } else {
                aVar = (C2444a) view.getTag();
                aVar.f12791c = (RedTipView) view.findViewById(R.id.mode_badge);
                if (aVar.f12791c != null) {
                    if (!a.f12796e || equals) {
                        aVar.f12791c.setVisibility(8);
                    } else {
                        aVar.f12791c.setVisibility(0);
                    }
                }
            }
            if (a.f12792a == CameraModeType.ModeType.AMAZINGAR.getTxtId()) {
                if (ModeGirdViewController.this.f12761n.mo21049b()) {
                    aVar.f12789a.setTwoStateIcon(a.f12793b, a.f12794c);
                    aVar.f12789a.setImageResource(a.f12793b);
                } else {
                    aVar.f12789a.setTwoStateIcon(a.f12795d, a.f12795d);
                    aVar.f12789a.setImageResource(a.f12795d);
                }
                aVar.f12790b.setChecked(false);
            } else {
                aVar.f12789a.setTwoStateIcon(a.f12793b, a.f12794c);
                aVar.f12789a.setImageResource(a.f12793b);
            }
            aVar.f12790b.setText(a.f12792a);
            return view;
        }

        /* renamed from: a */
        public void mo21926a() {
            if (!PatchProxy.proxy(new Object[0], this, f12798a, false, 6305, new Class[0], Void.TYPE).isSupported) {
                LogUtil.m15942a(ModeGirdViewController.f12740b, "notifyDataSetChanged");
                notifyDataSetChanged();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public List<Rotatable> mo21927b() {
            return this.f12801d;
        }
    }

    /* renamed from: a */
    public boolean mo21900a() {
        return this.f12744D;
    }

    /* renamed from: b */
    public void mo21902b() {
        if (!PatchProxy.proxy(new Object[0], this, f12739a, false, 6266, new Class[0], Void.TYPE).isSupported) {
            this.f12765r = false;
            this.f12753f = mo21907d();
            this.f12744D = true;
            this.f12751d.mo23141a((View) this.f12757j);
            this.f12761n.mo21047a(true);
            this.f12757j.setVisibility(0);
            this.f12757j.clearAnimation();
            this.f12757j.startAnimation(this.f12770w);
            this.f12759l.setEnabled(true);
            ((C2447d) this.f12759l.getAdapter()).mo21926a();
        }
    }

    /* renamed from: c */
    public void mo21905c() {
        if (!PatchProxy.proxy(new Object[0], this, f12739a, false, 6267, new Class[0], Void.TYPE).isSupported) {
            this.f12744D = false;
            this.f12751d.mo23141a((View) null);
            this.f12757j.clearAnimation();
            this.f12771x.setAnimationListener(new Animation.AnimationListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12774a;

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    if (!PatchProxy.proxy(new Object[]{animation}, this, f12774a, false, 6286, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                        LogUtil.m15942a(ModeGirdViewController.f12740b, "onAnimationStart");
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    if (!PatchProxy.proxy(new Object[]{animation}, this, f12774a, false, 6287, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                        ModeGirdViewController.this.f12757j.setVisibility(8);
                        LogUtil.m15942a(ModeGirdViewController.f12740b, "onAnimationEnd");
                    }
                }
            });
            this.f12757j.startAnimation(this.f12771x);
            this.f12761n.mo21047a(false);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object[] objArr = {adapterView, view, new Integer(i), new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6268, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f12772y == null || !this.f12772y.mo20687a()) {
                this.f12752e = i;
                CameraModeType.ModeType modeType = this.f12754g.get(i);
                this.f12753f = CameraModeType.m10962e(modeType);
                Activity activity = this.f12763p;
                boolean equals = PreferenceUtil.m15983c(activity, "camera.mode_userguide" + this.f12754g.get(i), "0").equals("1");
                if (CameraModeType.m10950a(modeType) && !equals) {
                    this.f12762o.get(i).f12796e = false;
                    this.f12760m.notifyDataSetChanged();
                    Activity activity2 = this.f12763p;
                    PreferenceUtil.m15982b(activity2, "camera.mode_userguide" + modeType, "1");
                    this.f12761n.mo21046a(modeType);
                } else if (CameraModeType.f10557b[this.f12753f].equals(CameraModeType.ModeType.AMAZINGAR)) {
                    this.f12761n.mo21044a();
                    ((ImageCheckableView) view.findViewById(R.id.mode_icon)).setChecked(false);
                    ((TextCheckableView) view.findViewById(R.id.mode_name)).setChecked(false);
                } else if (this.f12750c.mo23374a(this.f12753f, false)) {
                    this.f12759l.setEnabled(false);
                    if (modeType != CameraModeType.m10946a() || this.f12761n.mo21050c()) {
                        this.f12761n.mo21048b(false);
                        this.f12761n.mo21045a(this.f12753f);
                    }
                    this.f12764q.postDelayed(new Runnable() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f12776a;

                        public void run() {
                            if (!PatchProxy.proxy(new Object[0], this, f12776a, false, 6288, new Class[0], Void.TYPE).isSupported) {
                                ModeGirdViewController.this.mo21905c();
                            }
                        }
                    }, 50);
                } else {
                    ((ImageCheckableView) view.findViewById(R.id.mode_icon)).setChecked(false);
                    ((TextCheckableView) view.findViewById(R.id.mode_name)).setChecked(false);
                }
            } else {
                ((ImageCheckableView) view.findViewById(R.id.mode_icon)).setChecked(false);
                ((TextCheckableView) view.findViewById(R.id.mode_name)).setChecked(false);
            }
        }
    }

    /* renamed from: d */
    public int mo21907d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12739a, false, 6269, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f12750c != null) {
            return this.f12750c.mo23367a();
        }
        return this.f12753f;
    }

    /* renamed from: a */
    public void mo21893a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12739a, false, 6271, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            int c = m14570c(i);
            if (this.f12759l != null) {
                this.f12759l.setItemChecked(this.f12752e, false);
                this.f12759l.setItemChecked(c, true);
            }
            this.f12742B = c;
            this.f12752e = c;
            this.f12753f = i;
            if (this.f12750c != null && this.f12750c.mo23374a(i, false)) {
                this.f12761n.mo21048b(false);
                this.f12761n.mo21045a(i);
            }
        }
    }

    /* renamed from: a */
    public void mo21892a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6274, new Class[]{Float.TYPE}, Void.TYPE).isSupported && this.f12750c != null) {
            this.f12750c.mo23368a(f);
        }
    }

    /* renamed from: a */
    public boolean mo21901a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 6275, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.m15942a(f12740b, "tapToSlideMode");
        if (this.f12750c != null) {
            return this.f12750c.mo23373a(i, i2);
        }
        return false;
    }

    /* renamed from: c */
    private int m14570c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 6276, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        CameraModeType.ModeType modeType = CameraModeType.f10557b[i];
        int indexOf = this.f12754g.indexOf(modeType);
        LogUtil.C2630a aVar = f12740b;
        LogUtil.m15942a(aVar, "translateModeIndexToModePositionInMenu modeType:" + modeType + ",mode position in slide render:" + indexOf);
        return indexOf;
    }

    /* renamed from: a */
    private void m14565a(final CameraModeType.ModeType modeType, final int i) {
        Object[] objArr = {modeType, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6277, new Class[]{CameraModeType.ModeType.class, Integer.TYPE}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Boolean>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12782a;

                /* renamed from: a */
                public Boolean mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f12782a, false, 6297, new Class[]{Void[].class}, Boolean.class);
                    if (proxy.isSupported) {
                        return (Boolean) proxy.result;
                    }
                    boolean a = ModeGirdViewController.this.m14569b(modeType);
                    if (!a || ModeGirdViewController.this.f12743C == null) {
                        return Boolean.valueOf(a);
                    }
                    boolean z = false;
                    for (CameraModeType.ModeType equals : ModeGirdViewController.this.f12743C) {
                        if (equals.equals(modeType)) {
                            z = true;
                        }
                    }
                    if (z) {
                        ModeGirdViewController.this.f12743C[i] = modeType;
                    }
                    if (!CameraModeType.m10957c(ModeGirdViewController.this.f12743C[i])) {
                        ModeGirdViewController.this.f12754g.add(ModeGirdViewController.this.f12743C[i]);
                        Collections.sort(ModeGirdViewController.this.f12754g, new SlideBarModeComparator());
                        C2445b bVar = new C2445b();
                        if (CameraModeType.m10950a(modeType)) {
                            bVar.f12796e = true;
                        }
                        bVar.f12792a = ModeGirdViewController.this.f12743C[i].getGroupTextId() == -1 ? ModeGirdViewController.this.f12743C[i].getTxtId() : ModeGirdViewController.this.f12743C[i].getGroupTextId();
                        bVar.f12794c = ModeGirdViewController.this.f12743C[i].getIconPressedId();
                        bVar.f12793b = ModeGirdViewController.this.f12743C[i].getIconNormalId();
                        ModeGirdViewController.this.f12762o.add(ModeGirdViewController.this.f12754g.indexOf(modeType), bVar);
                        return true;
                    }
                    ModeGirdViewController.this.f12755h.add(ModeGirdViewController.this.f12743C[i]);
                    Collections.sort(ModeGirdViewController.this.f12755h, new SlideBarModeComparator());
                    return false;
                }

                /* renamed from: a */
                public void mo17660a(Boolean bool) {
                    if (!PatchProxy.proxy(new Object[]{bool}, this, f12782a, false, 6298, new Class[]{Boolean.class}, Void.TYPE).isSupported) {
                        LogUtil.C2630a g = ModeGirdViewController.f12740b;
                        LogUtil.m15942a(g, "load mode finish, result = " + bool);
                        if (bool.booleanValue()) {
                            ModeGirdViewController.this.f12760m.notifyDataSetChanged();
                        }
                    }
                }
            }.mo22614c((Params[]) new Void[0]);
        }
    }

    /* renamed from: com.meizu.media.camera.ui.b$7 */
    /* compiled from: ModeGirdViewController */
    static /* synthetic */ class C24437 {

        /* renamed from: a */
        static final /* synthetic */ int[] f12788a = new int[CameraModeType.ModeType.values().length];

        static {
            try {
                f12788a[CameraModeType.ModeType.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m14569b(CameraModeType.ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, this, f12739a, false, 6278, new Class[]{CameraModeType.ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (C24437.f12788a[modeType.ordinal()] != 1) {
            return false;
        }
        return MzCropDSController.loadLibrary();
    }

    /* renamed from: b */
    public void mo21904b(boolean z) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12739a, false, 6279, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f12750c == null) {
            return;
        }
        if (z) {
            this.f12750c.mo23403f(false);
        } else {
            this.f12750c.mo23403f(true);
        }
    }

    /* renamed from: c */
    public void mo21906c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6280, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f12750c != null) {
            this.f12750c.mo23379d(z);
        }
    }

    /* renamed from: b */
    public void mo21903b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6282, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f12760m != null) {
            for (Rotatable orientation : this.f12760m.mo21927b()) {
                orientation.setOrientation(i, true);
            }
        }
    }

    /* renamed from: e */
    public void mo21909e() {
        if (!PatchProxy.proxy(new Object[0], this, f12739a, false, 6283, new Class[0], Void.TYPE).isSupported) {
            this.f12750c.mo23378c(false);
        }
    }

    /* renamed from: f */
    public void mo21910f() {
        if (!PatchProxy.proxy(new Object[0], this, f12739a, false, 6284, new Class[0], Void.TYPE).isSupported) {
            this.f12750c.mo23378c(true);
        }
    }

    /* renamed from: d */
    public void mo21908d(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12739a, false, 6285, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f12750c != null) {
            this.f12750c.mo23377c();
        }
    }
}
