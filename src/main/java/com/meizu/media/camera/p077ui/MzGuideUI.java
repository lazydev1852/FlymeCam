package com.meizu.media.camera.p077ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.databinding.MzModeGuideBinding;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.ModeGirdViewController;
import com.meizu.media.camera.views.GuidePageIndicator;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.ui.MzGuideUI */
public class MzGuideUI implements View.OnClickListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f12620a;

    /* renamed from: b */
    public ViewPager.OnPageChangeListener f12621b = new ViewPager.OnPageChangeListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12642a;

        public void onPageScrolled(int i, float f, int i2) {
            Object[] objArr = {new Integer(i), new Float(f), new Integer(i2)};
            ChangeQuickRedirect changeQuickRedirect = f12642a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7342, new Class[]{Integer.TYPE, Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                MzGuideUI.this.f12631l.getBackground().setAlpha((int) (255.0d - ((Math.abs(((double) f) - 0.5d) * 510.0d) * 0.8999999761581421d)));
            }
        }

        public void onPageSelected(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f12642a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7343, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                MzGuideUI.this.f12623d.setBackgroundResource(((Integer) MzGuideUI.this.f12638s.get(i)).intValue());
                MzGuideUI.this.mo21778a(CameraModeType.m10962e((CameraModeType.ModeType) MzGuideUI.this.f12636q.get(i)));
            }
        }

        public void onPageScrollStateChanged(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12642a, false, 7344, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                if (i == 0) {
                    boolean unused = MzGuideUI.this.f12635p = false;
                } else {
                    boolean unused2 = MzGuideUI.this.f12635p = true;
                }
            }
        }
    };

    /* renamed from: c */
    private MzModeGuideBinding f12622c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f12623d;

    /* renamed from: e */
    private Activity f12624e;

    /* renamed from: f */
    private MzUIController f12625f;

    /* renamed from: g */
    private boolean f12626g = false;

    /* renamed from: h */
    private ModeGirdViewController.C2446c f12627h;

    /* renamed from: i */
    private GuidePageIndicator f12628i;

    /* renamed from: j */
    private TextView f12629j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ViewPager f12630k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ImageView f12631l;

    /* renamed from: m */
    private LayoutInflater f12632m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public List<View> f12633n;

    /* renamed from: o */
    private int f12634o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f12635p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public List<CameraModeType.ModeType> f12636q = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List<Integer> f12637r = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public List<Integer> f12638s = new ArrayList();

    /* renamed from: t */
    private int f12639t;

    /* renamed from: com.meizu.media.camera.ui.MzGuideUI$PageIndicator */
    public interface PageIndicator extends ViewPager.OnPageChangeListener {
    }

    public MzGuideUI(Activity activity, MzModeGuideBinding mzModeGuideBinding) {
        this.f12624e = activity;
        this.f12622c = mzModeGuideBinding;
    }

    /* renamed from: a */
    public void mo21777a() {
        if (!PatchProxy.proxy(new Object[0], this, f12620a, false, 7333, new Class[0], Void.TYPE).isSupported && !this.f12626g) {
            this.f12632m = LayoutInflater.from(this.f12624e);
            this.f12623d = this.f12622c.f9791c;
            this.f12629j = this.f12622c.f9795g;
            this.f12631l = this.f12622c.f9790b;
            this.f12628i = this.f12622c.f9789a;
            this.f12630k = this.f12622c.f9793e;
            this.f12622c.f9792d.setOnClickListener(this);
            this.f12622c.f9794f.setOnClickListener(this);
            this.f12626g = true;
        }
    }

    /* renamed from: e */
    private void m14266e() {
        if (!PatchProxy.proxy(new Object[0], this, f12620a, false, 7334, new Class[0], Void.TYPE).isSupported) {
            this.f12633n = new ArrayList();
            int size = this.f12636q.size();
            int i = size > 2 ? 1 : 0;
            if (this.f12639t != -1) {
                this.f12629j.setText(this.f12639t);
            }
            for (int i2 = 0; i2 < size; i2++) {
                this.f12633n.add(this.f12632m.inflate(R.layout.mz_mode_guide_card, (ViewGroup) null));
            }
            this.f12630k.setAdapter(new pagerAdapter(this.f12633n));
            this.f12630k.setCurrentItem(i);
            mo21778a(CameraModeType.m10962e(this.f12636q.get(i)));
            this.f12623d.setBackgroundResource(this.f12638s.get(i).intValue());
            this.f12630k.setPageTransformer(true, new GuidePagerTransform());
            this.f12630k.setOffscreenPageLimit(3);
            this.f12630k.setPageMargin(3);
            this.f12630k.setOverScrollMode(2);
            this.f12628i.setViewPager(this.f12630k);
            this.f12628i.mo22902a();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12628i.getLayoutParams();
            layoutParams.width = this.f12628i.getIndicatorWidth();
            layoutParams.height = this.f12628i.getIndicatorHeight();
            this.f12628i.setLayoutParams(layoutParams);
            this.f12630k.addOnPageChangeListener(this.f12621b);
            this.f12623d.setOnTouchListener(new View.OnTouchListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12640a;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, motionEvent}, this, f12640a, false, 7341, new Class[]{View.class, MotionEvent.class}, Boolean.TYPE);
                    return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : MzGuideUI.this.f12630k.dispatchTouchEvent(motionEvent);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo21779a(CameraModeType.ModeType modeType) {
        if (!PatchProxy.proxy(new Object[]{modeType}, this, f12620a, false, 7335, new Class[]{CameraModeType.ModeType.class}, Void.TYPE).isSupported) {
            this.f12636q.clear();
            this.f12637r.clear();
            this.f12638s.clear();
            this.f12639t = modeType.getGroupTextId();
            CameraModeType.ModeType[] modeTypeArr = CameraModeType.f10557b;
            for (int i = 0; i < modeTypeArr.length; i++) {
                if (modeType.getGroupId() == modeTypeArr[i].getGroupId()) {
                    this.f12636q.add(modeTypeArr[i]);
                    this.f12637r.add(Integer.valueOf(modeTypeArr[i].getGuideCardId()));
                    this.f12638s.add(Integer.valueOf(modeTypeArr[i].getGuideBgId()));
                }
            }
            m14266e();
        }
    }

    /* renamed from: com.meizu.media.camera.ui.MzGuideUI$pagerAdapter */
    public class pagerAdapter extends PagerAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f12646a;

        /* renamed from: c */
        private List<View> f12648c;

        public boolean isViewFromObject(View view, Object obj) {
            return obj == view;
        }

        public pagerAdapter(List<View> list) {
            this.f12648c = list;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f12646a, false, 7346, new Class[]{ViewGroup.class, Integer.TYPE}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            View view = (View) MzGuideUI.this.f12633n.get(i);
            ((ImageView) view.findViewById(R.id.mz_mode_guide_card_pic)).setImageResource(((Integer) MzGuideUI.this.f12637r.get(i)).intValue());
            view.setScaleX(0.88f);
            view.setScaleY(0.88f);
            viewGroup.addView(view);
            return view;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Object[] objArr = {viewGroup, new Integer(i), obj};
            ChangeQuickRedirect changeQuickRedirect = f12646a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7347, new Class[]{ViewGroup.class, Integer.TYPE, Object.class}, Void.TYPE).isSupported) {
                viewGroup.removeView((View) obj);
            }
        }

        public int getCount() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12646a, false, 7348, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f12648c.size();
        }
    }

    /* renamed from: a */
    public void mo21780a(MzUIController uVar) {
        this.f12625f = uVar;
    }

    /* renamed from: a */
    public void mo21781a(ModeGirdViewController.C2446c cVar) {
        this.f12627h = cVar;
    }

    /* renamed from: b */
    public void mo21782b() {
        if (!PatchProxy.proxy(new Object[0], this, f12620a, false, 7336, new Class[0], Void.TYPE).isSupported) {
            this.f12623d.setVisibility(0);
        }
    }

    /* renamed from: c */
    public void mo21783c() {
        if (!PatchProxy.proxy(new Object[0], this, f12620a, false, 7337, new Class[0], Void.TYPE).isSupported) {
            this.f12623d.setVisibility(8);
        }
    }

    /* renamed from: d */
    public boolean mo21784d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12620a, false, 7338, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f12623d.getVisibility() == 0;
    }

    /* renamed from: a */
    public void mo21778a(int i) {
        this.f12634o = i;
    }

    public void onClick(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f12620a, false, 7340, new Class[]{View.class}, Void.TYPE).isSupported) {
            int id = view.getId();
            if (id == R.id.mz_mode_guide_back) {
                this.f12625f.mo21624p();
            } else if (id == R.id.mz_mode_guide_enter && !this.f12635p) {
                this.f12627h.mo21045a(this.f12634o);
                this.f12625f.mo21624p();
            }
        }
    }

    /* renamed from: com.meizu.media.camera.ui.MzGuideUI$GuidePagerTransform */
    private class GuidePagerTransform implements ViewPager.PageTransformer {

        /* renamed from: a */
        public static ChangeQuickRedirect f12644a;

        private GuidePagerTransform() {
        }

        public void transformPage(View view, float f) {
            if (!PatchProxy.proxy(new Object[]{view, new Float(f)}, this, f12644a, false, 7345, new Class[]{View.class, Float.TYPE}, Void.TYPE).isSupported) {
                if (f <= 0.0f) {
                    float abs = ((1.0f - Math.abs(f)) * 0.120000005f) + 0.88f;
                    view.setScaleX(abs);
                    view.setScaleY(abs);
                } else if (f <= 1.0f) {
                    float abs2 = ((1.0f - Math.abs(f)) * 0.120000005f) + 0.88f;
                    view.setScaleX(abs2);
                    view.setScaleY(abs2);
                }
            }
        }
    }
}
