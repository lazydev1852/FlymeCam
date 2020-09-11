package flyme.support.p092v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.p020ar.base.MsgField;
import flyme.support.p092v4.view.ViewPager;
import flyme.support.p092v4.viewpager.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: flyme.support.v4.view.BannerViewPager */
public class BannerViewPager extends LayerAniViewPager {

    /* renamed from: a */
    private static final Interpolator f16401a = PathInterpolatorCompat.create(0.33f, 0.0f, 0.2f, 1.0f);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3040c f16402b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f16403c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f16404d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f16405e;

    /* renamed from: f */
    private int f16406f;

    /* renamed from: g */
    private int f16407g;

    /* renamed from: h */
    private int f16408h;

    /* renamed from: i */
    private int f16409i;

    /* renamed from: j */
    private int f16410j;

    /* renamed from: k */
    private int f16411k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f16412l;

    /* renamed from: m */
    private Timer f16413m;

    /* renamed from: n */
    private TimerTask f16414n;

    /* renamed from: o */
    private boolean f16415o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C3039b f16416p;

    /* renamed from: q */
    private boolean f16417q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ViewPagerAdapter f16418r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C3038a f16419s;

    /* renamed from: flyme.support.v4.view.BannerViewPager$a */
    public static abstract class C3038a {
        /* renamed from: a */
        public abstract int mo24904a();

        /* renamed from: a */
        public abstract View mo24905a(int i);
    }

    public BannerViewPager(Context context) {
        this(context, (AttributeSet) null);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16410j = 0;
        this.f16411k = 0;
        this.f16412l = false;
        this.f16415o = true;
        this.f16416p = new C3039b(this);
        this.f16417q = false;
        this.f16418r = null;
        this.f16419s = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BannerViewPager);
        this.f16403c = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzPageWidth, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_view_pager_width));
        this.f16404d = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzPageSpacing, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_view_pager_spacing));
        this.f16405e = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzPageLeftOffset, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_viewpager_left_offset));
        this.f16408h = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzMultyPagePaddingTop, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_viewpager_multy_padding_top));
        this.f16409i = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzMultyPagePaddingBottom, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_viewpager_multy_padding_bottom));
        this.f16407g = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzSinglePagePaddingTop, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_viewpager_single_padding_top));
        this.f16406f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzSinglePagePaddingBottom, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_viewpager_single_padding_bottom));
        this.f16410j = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzSinglePageHeight, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_viewpager_on_page_height));
        this.f16411k = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BannerViewPager_mzMultyPageHeight, context.getResources().getDimensionPixelOffset(R.dimen.mz_banner_viewpager_height));
        obtainStyledAttributes.recycle();
        m18023m();
    }

    /* renamed from: flyme.support.v4.view.BannerViewPager$b */
    private class C3039b extends Handler {

        /* renamed from: b */
        private WeakReference<BannerViewPager> f16426b;

        public C3039b(BannerViewPager bannerViewPager) {
            this.f16426b = new WeakReference<>(bannerViewPager);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            BannerViewPager bannerViewPager = (BannerViewPager) this.f16426b.get();
            if (bannerViewPager != null && BannerViewPager.this.f16412l && message.what == 1) {
                int currentItem = bannerViewPager.getCurrentItem() + 1;
                if (currentItem == 5040) {
                    bannerViewPager.setCurrentItem((int) MsgField.MSG_TYPE_RENDER_SIZE, false);
                } else {
                    bannerViewPager.setCurrentItem(currentItem, 448);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo24887a() {
        this.f16415o = true;
        if (this.f16413m != null) {
            this.f16413m.cancel();
            this.f16413m = null;
        }
        if (this.f16414n != null) {
            this.f16414n.cancel();
            this.f16414n = null;
        }
    }

    /* renamed from: b */
    public void mo24888b() {
        if (this.f16415o && this.f16412l) {
            this.f16415o = false;
            this.f16413m = new Timer();
            this.f16414n = new TimerTask() {
                public void run() {
                    BannerViewPager.this.f16416p.sendEmptyMessage(1);
                }
            };
            this.f16413m.schedule(this.f16414n, 4500, 4500);
        }
    }

    /* renamed from: m */
    private void m18023m() {
        setFlipMode(ViewPager.FlipMode.FLIP_MODE_DEFAULT);
        setInterpolator(f16401a);
        this.f16402b = new C3040c();
        setPageTransformer(true, this.f16402b);
        setOverScrollMode(2);
        setClipToPadding(false);
        setMinAutoFlingDistance(0.2f);
        setOffscreenPageLimit(2);
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        if (this.f16419s == null || this.f16419s.mo24904a() <= 1) {
            super.measureChild(view, i, i2);
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(this.f16403c, 1073741824), i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f16419s == null || this.f16419s.mo24904a() <= 1) {
            setPadding(this.f16406f, this.f16407g, this.f16406f, this.f16406f);
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f16410j + this.f16406f, 1073741824));
            return;
        }
        setPadding(0, this.f16408h, 0, this.f16409i);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f16411k + this.f16408h + this.f16409i, 1073741824));
    }

    public void setBannerAdapter(C3038a aVar) {
        this.f16419s = aVar;
        this.f16418r = new ViewPagerAdapter();
        setAdapter(this.f16418r);
        setCurrentItem(MsgField.MSG_TYPE_RENDER_SIZE);
    }

    public void setPageWidth(int i) {
        this.f16403c = i;
        requestLayout();
    }

    public void setMultyPageHeight(int i) {
        this.f16411k = i;
        requestLayout();
    }

    public C3038a getBannerAdapter() {
        return this.f16419s;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        mo24967h();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestLayout();
        mo24888b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo24887a();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (i != 0) {
            mo24887a();
        } else {
            mo24888b();
        }
    }

    public void setScrolling(boolean z) {
        this.f16417q = z;
    }

    public void setAutoFling(boolean z) {
        this.f16412l = z;
        if (!z) {
            mo24887a();
        } else {
            mo24888b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo24886a(float f) {
        return (this.f16419s == null || this.f16419s.mo24904a() <= 0 || !this.f16402b.mo24909b()) ? f : f * this.f16402b.f16431e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo24889c() {
        if (this.f16419s == null || this.f16419s.mo24904a() <= 0 || getCurrentItem() % this.f16419s.mo24904a() != this.f16419s.mo24904a() - 1 || this.f16412l) {
            return true;
        }
        return false;
    }

    /* renamed from: flyme.support.v4.view.BannerViewPager$c */
    private class C3040c implements ViewPager.C3055f {

        /* renamed from: b */
        private boolean f16428b = true;

        /* renamed from: c */
        private float f16429c = 0.0f;

        /* renamed from: d */
        private boolean f16430d = false;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public float f16431e = 1.0f;

        /* renamed from: a */
        private int m18036a(float f, float f2, float f3, float f4, float f5) {
            return (int) (f3 + (((f4 - f3) * (f5 - f)) / (f2 - f)));
        }

        public C3040c() {
            mo24907a();
        }

        /* renamed from: a */
        public void mo24907a() {
            this.f16429c = 0.0f;
            this.f16429c = 0.0f;
        }

        /* renamed from: a */
        private boolean m18038a(View view) {
            if (BannerViewPager.this.f16419s == null || BannerViewPager.this.f16419s.mo24904a() <= 0 || BannerViewPager.this.f16418r.m18028a(view) % BannerViewPager.this.f16419s.mo24904a() != 0) {
                return false;
            }
            return true;
        }

        /* renamed from: b */
        private boolean m18039b(View view) {
            if (BannerViewPager.this.f16419s == null || BannerViewPager.this.f16419s.mo24904a() <= 1 || BannerViewPager.this.f16418r.m18028a(view) % BannerViewPager.this.f16419s.mo24904a() != BannerViewPager.this.f16419s.mo24904a() - 1) {
                return false;
            }
            return true;
        }

        /* renamed from: c */
        private boolean m18040c(View view) {
            if (BannerViewPager.this.f16419s == null || BannerViewPager.this.f16419s.mo24904a() <= 2 || BannerViewPager.this.f16418r.m18028a(view) % BannerViewPager.this.f16419s.mo24904a() != BannerViewPager.this.f16419s.mo24904a() - 2) {
                return false;
            }
            return true;
        }

        /* renamed from: d */
        private boolean m18041d(View view) {
            return BannerViewPager.this.f16419s != null && BannerViewPager.this.f16419s.mo24904a() > 2 && BannerViewPager.this.f16418r.m18028a(view) % BannerViewPager.this.f16419s.mo24904a() == 1;
        }

        /* renamed from: a */
        private int m18037a(float[] fArr, float[] fArr2, float f) {
            int i = 0;
            int i2 = 1;
            if (f > fArr[0]) {
                if (f < fArr[fArr.length - 1]) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= fArr2.length - 1) {
                            break;
                        }
                        int i4 = i3 + 1;
                        if (f <= fArr[i4] && f >= fArr[i3]) {
                            i = i3;
                            i2 = i4;
                            break;
                        }
                        i3 = i4;
                    }
                } else {
                    i = fArr.length - 2;
                    i2 = fArr.length - 1;
                }
            }
            return m18036a(fArr[i], fArr[i2], fArr2[i], fArr2[i2], f);
        }

        @TargetApi(21)
        /* renamed from: a */
        public void mo24908a(View view, float f) {
            float f2;
            if (BannerViewPager.this.f16419s == null || BannerViewPager.this.f16419s.mo24904a() != 1) {
                float measuredWidth = (float) ((BannerViewPager.this.getMeasuredWidth() - BannerViewPager.this.f16403c) - BannerViewPager.this.f16404d);
                float f3 = (float) (-(((BannerViewPager.this.getMeasuredWidth() - BannerViewPager.this.f16403c) - BannerViewPager.this.f16404d) - BannerViewPager.this.f16405e));
                int unused = BannerViewPager.this.f16405e;
                float[] fArr = {-1.0f, 0.0f, 1.0f};
                float[] fArr2 = {measuredWidth, (float) BannerViewPager.this.f16405e, f3};
                if (BannerViewPager.this.f16412l || BannerViewPager.this.f16419s == null || BannerViewPager.this.f16419s.mo24904a() <= 2) {
                    if (m18039b(view) && this.f16428b) {
                        fArr2[0] = measuredWidth;
                        if (f > 1.0f) {
                            this.f16428b = false;
                        }
                    }
                } else if (m18040c(view)) {
                    if (BannerViewPager.this.f16419s.mo24904a() == 3) {
                        fArr2 = new float[]{(float) (((BannerViewPager.this.getMeasuredWidth() * 2) - BannerViewPager.this.f16404d) - (BannerViewPager.this.f16403c * 2)), measuredWidth * 2.0f, (float) BannerViewPager.this.f16405e, f3, f3};
                        fArr = new float[]{-2.0f, -1.0f, 0.0f, 1.0f, 2.0f};
                    } else {
                        fArr = new float[]{-2.0f, -1.0f, 0.0f, 1.0f};
                        fArr2 = new float[]{(float) (((BannerViewPager.this.getMeasuredWidth() * 2) - BannerViewPager.this.f16404d) - (BannerViewPager.this.f16403c * 2)), measuredWidth * 2.0f, (float) BannerViewPager.this.f16405e, f3};
                    }
                } else if (m18039b(view)) {
                    fArr = new float[]{-1.0f, 0.0f, 1.0f, 2.0f};
                    fArr2 = new float[]{measuredWidth, measuredWidth, f3, (f3 + f3) - ((float) BannerViewPager.this.f16405e)};
                } else if (m18038a(view)) {
                    if (this.f16429c != 1.0f || f <= 0.8f || f >= 1.0f) {
                        this.f16430d = false;
                        fArr2 = new float[]{measuredWidth, (float) BannerViewPager.this.f16405e, (float) BannerViewPager.this.f16405e, measuredWidth};
                        fArr = new float[]{-1.0f, 0.0f, 0.7f, 0.8f};
                    } else {
                        this.f16430d = true;
                        this.f16431e = f - 0.5f;
                        fArr = new float[]{0.8f, 1.0f};
                        fArr2 = new float[]{measuredWidth, measuredWidth};
                    }
                    if (((float) ((int) f)) == f) {
                        f2 = f;
                    } else {
                        f2 = this.f16429c;
                    }
                    this.f16429c = f2;
                } else if (m18041d(view)) {
                    fArr = new float[]{-1.0f, 0.0f, 1.0f, 2.0f};
                    fArr2 = new float[]{measuredWidth, (float) BannerViewPager.this.f16405e, f3, f3};
                }
                view.setTranslationX((float) m18037a(fArr, fArr2, f));
                return;
            }
            view.setTranslationX(0.0f);
        }

        /* renamed from: b */
        public boolean mo24909b() {
            return this.f16430d;
        }
    }

    /* renamed from: flyme.support.v4.view.BannerViewPager$ViewPagerAdapter */
    class ViewPagerAdapter extends PagerAdapter {

        /* renamed from: b */
        private HashMap<Integer, View> f16422b = new HashMap<>();

        /* renamed from: c */
        private HashMap<Integer, View> f16423c = new HashMap<>();

        /* renamed from: d */
        private final int f16424d = 5;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        ViewPagerAdapter() {
        }

        public int getCount() {
            if (BannerViewPager.this.f16419s != null) {
                return BannerViewPager.this.f16419s.mo24904a() <= 1 ? 1 : 5040;
            }
            return 0;
        }

        /* renamed from: b */
        private int m18031b() {
            if (BannerViewPager.this.f16419s == null) {
                return 0;
            }
            int a = BannerViewPager.this.f16419s.mo24904a();
            if (a == 1) {
                return a;
            }
            while (a < 5) {
                a *= 2;
            }
            return a;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view = this.f16422b.get(Integer.valueOf(i));
            if (view != null) {
                viewGroup.removeView(view);
                this.f16422b.remove(Integer.valueOf(i));
            }
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (BannerViewPager.this.f16419s == null || BannerViewPager.this.f16419s.mo24904a() <= 0) {
                return null;
            }
            int b = i % m18031b();
            View a = m18030a(b);
            if (a == null) {
                a = BannerViewPager.this.f16419s.mo24905a(i % BannerViewPager.this.f16419s.mo24904a());
                this.f16423c.put(Integer.valueOf(b), a);
            }
            if (a.getParent() != null) {
                destroyItem(viewGroup, getItemPosition(a), a);
            }
            if (viewGroup.getChildCount() == 0) {
                viewGroup.addView(a);
            } else if ((getItemPosition(viewGroup.getChildAt(viewGroup.getChildCount() - 1)) + 1) % m18031b() == i % m18031b()) {
                viewGroup.addView(a);
            } else {
                viewGroup.addView(a, 0);
            }
            this.f16422b.put(Integer.valueOf(i), a);
            return a;
        }

        /* renamed from: a */
        public void mo24903a() {
            if (BannerViewPager.this.f16402b != null) {
                BannerViewPager.this.f16402b.mo24907a();
                this.f16422b.clear();
                this.f16423c.clear();
                BannerViewPager.this.removeAllViews();
            }
        }

        public void notifyDataSetChanged() {
            mo24903a();
            super.notifyDataSetChanged();
        }

        public int getItemPosition(Object obj) {
            for (Map.Entry next : this.f16422b.entrySet()) {
                if (obj == next.getValue()) {
                    return ((Integer) next.getKey()).intValue();
                }
            }
            return -2;
        }

        /* renamed from: a */
        private View m18030a(int i) {
            if (BannerViewPager.this.f16419s != null) {
                return this.f16423c.get(Integer.valueOf(i));
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int m18028a(View view) {
            if (BannerViewPager.this.f16419s.mo24904a() >= 1) {
                return getItemPosition(view) % m18031b();
            }
            return -1;
        }
    }
}
