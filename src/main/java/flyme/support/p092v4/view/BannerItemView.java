package flyme.support.p092v4.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import com.meizu.flyme.palette.PrimaryColor;
import flyme.support.p092v4.viewpager.R;

/* renamed from: flyme.support.v4.view.BannerItemView */
public class BannerItemView extends RelativeLayout {

    /* renamed from: a */
    private ViewGroup f16375a;

    /* renamed from: b */
    private ViewGroup f16376b;

    /* renamed from: c */
    private ViewGroup f16377c;

    /* renamed from: d */
    private View f16378d;

    /* renamed from: e */
    private boolean f16379e;

    /* renamed from: f */
    private View f16380f;

    /* renamed from: g */
    private View f16381g;

    /* renamed from: h */
    private ViewGroup f16382h;

    /* renamed from: i */
    private int f16383i;

    /* renamed from: j */
    private TimeInterpolator f16384j;

    /* renamed from: k */
    private boolean f16385k;

    /* renamed from: l */
    private boolean f16386l;

    /* renamed from: m */
    private String f16387m;

    /* renamed from: n */
    private String f16388n;

    /* renamed from: o */
    private String f16389o;

    /* renamed from: p */
    private ObjectAnimator f16390p;

    /* renamed from: q */
    private ObjectAnimator f16391q;

    /* renamed from: r */
    private ObjectAnimator f16392r;

    /* renamed from: s */
    private ObjectAnimator f16393s;

    /* renamed from: t */
    private final long f16394t;

    /* renamed from: u */
    private final long f16395u;

    /* renamed from: v */
    private float f16396v;

    /* renamed from: w */
    private float f16397w;

    /* renamed from: x */
    private float f16398x;

    /* renamed from: y */
    private float f16399y;

    /* renamed from: z */
    private float f16400z;

    public BannerItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BannerItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16379e = false;
        this.f16383i = 0;
        this.f16385k = false;
        this.f16386l = false;
        this.f16387m = "scaleX";
        this.f16388n = "scaleY";
        this.f16389o = "alpha";
        this.f16394t = 128;
        this.f16395u = 352;
        this.f16396v = 1.0f;
        this.f16397w = 0.99f;
        this.f16398x = 0.97f;
        this.f16399y = 0.85f;
        this.f16400z = 0.7f;
        m18010a(context);
    }

    /* renamed from: a */
    private void m18010a(Context context) {
        View.inflate(context, R.layout.mz_f8_banner_itemview, this);
        this.f16377c = (ViewGroup) findViewById(R.id.mz_f8_banner_itemview_container);
        this.f16375a = (ViewGroup) findViewById(R.id.mz_f8_banner_itemview_primary_element_container);
        this.f16376b = (ViewGroup) findViewById(R.id.mz_f8_banner_itemview_primary_element);
        this.f16380f = findViewById(R.id.mz_f8_banner_itemview_shadow_view);
        this.f16381g = findViewById(R.id.mz_f8_banner_itemview_overlayer);
        this.f16382h = (ViewGroup) findViewById(R.id.mz_f8_banner_itemview_overlayout);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f16384j = new PathInterpolator(0.33f, 0.0f, 0.33f, 1.0f);
        } else {
            this.f16384j = new AccelerateDecelerateInterpolator();
        }
    }

    public View getContentChildView() {
        return this.f16378d;
    }

    public void setItemViewParams(int i, int i2) {
        if (this.f16377c != null) {
            ViewGroup.LayoutParams layoutParams = this.f16377c.getLayoutParams();
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            this.f16377c.setLayoutParams(layoutParams);
        }
        if (this.f16376b != null) {
            ViewGroup.LayoutParams layoutParams2 = this.f16376b.getLayoutParams();
            if (i > 0) {
                layoutParams2.width = i;
            }
            if (i2 > 0) {
                layoutParams2.height = Math.max(i2 - getResources().getDimensionPixelOffset(R.dimen.mz_banner_view_pager_primary_element_margin_bottom), 0);
            }
            this.f16376b.setLayoutParams(layoutParams2);
        }
        if (this.f16380f != null) {
            ViewGroup.LayoutParams layoutParams3 = this.f16380f.getLayoutParams();
            if (i2 > 0 && i2 < getResources().getDimensionPixelOffset(R.dimen.mz_banner_view_blur_effect_height)) {
                layoutParams3.height = i2;
                this.f16380f.setLayoutParams(layoutParams3);
            }
        }
        requestLayout();
    }

    public void setShadow(Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            Log.d("BannerItemView", "setShadow-->invisible");
            this.f16380f.setVisibility(4);
            this.f16381g.setVisibility(4);
            this.f16385k = false;
            return;
        }
        Log.d("BannerItemView", "setShadow-->visible");
        if (this.f16383i == 0 || z) {
            this.f16383i = m18008a(bitmap);
        }
        m18012a(this.f16380f, this.f16383i);
        this.f16380f.setAlpha(this.f16400z);
        this.f16380f.setVisibility(0);
        if (this.f16386l) {
            m18012a(this.f16381g, this.f16383i);
            this.f16381g.setAlpha(0.7f);
            this.f16381g.setVisibility(0);
        }
        this.f16385k = true;
    }

    public void setShadow(Bitmap bitmap) {
        setShadow(bitmap, false);
    }

    public void setShadowColor(int i) {
        m18012a(this.f16380f, i);
    }

    public void setOverLayer(boolean z) {
        this.f16386l = z;
        if (!this.f16386l) {
            this.f16381g.setVisibility(4);
        } else if (this.f16383i != 0) {
            m18012a(this.f16381g, this.f16383i);
            this.f16381g.setAlpha(0.7f);
            this.f16381g.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m18012a(View view, int i) {
        Drawable background;
        if (view != null && (background = view.getBackground()) != null) {
            background.mutate();
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
    }

    /* renamed from: a */
    private int m18008a(Bitmap bitmap) {
        Log.d("BannerItemView", "getColorForBitmap");
        return PrimaryColor.m6343a(bitmap);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0 && !this.f16385k) {
            setShadow(this.f16378d.getDrawingCache());
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!isEnabled() || !isClickable()) {
            return false;
        }
        switch (action) {
            case 0:
                m18014b(motionEvent);
                break;
            case 1:
            case 3:
                m18011a(motionEvent);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m18011a(MotionEvent motionEvent) {
        m18013b();
        this.f16391q.start();
        this.f16393s.start();
    }

    /* renamed from: b */
    private void m18014b(MotionEvent motionEvent) {
        m18009a();
        this.f16390p.start();
        this.f16392r.start();
    }

    /* renamed from: a */
    private void m18009a() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(this.f16387m, new float[]{this.f16396v, this.f16397w});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(this.f16388n, new float[]{this.f16396v, this.f16397w});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(this.f16388n, new float[]{this.f16396v, this.f16398x});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat(this.f16389o, new float[]{this.f16400z, this.f16399y});
        if (this.f16390p == null) {
            this.f16390p = ObjectAnimator.ofPropertyValuesHolder(this.f16376b, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.f16390p.setInterpolator(this.f16384j);
            this.f16390p.setDuration(128);
        } else {
            this.f16390p.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
        }
        if (this.f16392r == null) {
            this.f16392r = ObjectAnimator.ofPropertyValuesHolder(this.f16380f, new PropertyValuesHolder[]{ofFloat, ofFloat3, ofFloat4});
            this.f16392r.setInterpolator(this.f16384j);
            this.f16392r.setDuration(128);
            return;
        }
        this.f16392r.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat3, ofFloat4});
    }

    /* renamed from: b */
    private void m18013b() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(this.f16387m, new float[]{this.f16397w, this.f16396v});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(this.f16388n, new float[]{this.f16397w, this.f16396v});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(this.f16388n, new float[]{this.f16398x, this.f16396v});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat(this.f16389o, new float[]{this.f16399y, this.f16400z});
        if (this.f16391q == null) {
            this.f16391q = ObjectAnimator.ofPropertyValuesHolder(this.f16376b, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.f16391q.setInterpolator(this.f16384j);
            this.f16391q.setDuration(352);
        } else {
            this.f16391q.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
        }
        if (this.f16393s == null) {
            this.f16393s = ObjectAnimator.ofPropertyValuesHolder(this.f16380f, new PropertyValuesHolder[]{ofFloat, ofFloat3, ofFloat4});
            this.f16393s.setInterpolator(this.f16384j);
            this.f16393s.setDuration(352);
            return;
        }
        this.f16393s.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat3, ofFloat4});
    }
}
