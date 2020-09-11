package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Collections;

public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f15055a;

    /* renamed from: A */
    private float f15056A;

    /* renamed from: B */
    private float f15057B;

    /* renamed from: C */
    private float f15058C;

    /* renamed from: D */
    private int f15059D;

    /* renamed from: E */
    private boolean f15060E;

    /* renamed from: F */
    private int f15061F;

    /* renamed from: G */
    private float f15062G;

    /* renamed from: H */
    private int f15063H;

    /* renamed from: I */
    private int f15064I;

    /* renamed from: J */
    private float f15065J;

    /* renamed from: K */
    private float f15066K;

    /* renamed from: L */
    private float f15067L;

    /* renamed from: M */
    private int f15068M;

    /* renamed from: N */
    private int f15069N;

    /* renamed from: O */
    private int f15070O;

    /* renamed from: P */
    private boolean f15071P;

    /* renamed from: Q */
    private int f15072Q;

    /* renamed from: R */
    private int f15073R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public boolean f15074S;

    /* renamed from: T */
    private float f15075T;

    /* renamed from: U */
    private Paint f15076U;

    /* renamed from: V */
    private SparseArray<Boolean> f15077V;

    /* renamed from: b */
    private Context f15078b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ViewPager f15079c;

    /* renamed from: d */
    private ArrayList<String> f15080d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LinearLayout f15081e;

    /* renamed from: f */
    private int f15082f;

    /* renamed from: g */
    private int f15083g;

    /* renamed from: h */
    private float f15084h;

    /* renamed from: i */
    private int f15085i;

    /* renamed from: j */
    private Rect f15086j;

    /* renamed from: k */
    private Rect f15087k;

    /* renamed from: l */
    private GradientDrawable f15088l;

    /* renamed from: m */
    private Paint f15089m;

    /* renamed from: n */
    private Paint f15090n;

    /* renamed from: o */
    private Paint f15091o;

    /* renamed from: p */
    private Paint f15092p;

    /* renamed from: q */
    private Path f15093q;

    /* renamed from: r */
    private int f15094r;

    /* renamed from: s */
    private float f15095s;

    /* renamed from: t */
    private boolean f15096t;

    /* renamed from: u */
    private float f15097u;

    /* renamed from: v */
    private int f15098v;

    /* renamed from: w */
    private float f15099w;

    /* renamed from: x */
    private float f15100x;

    /* renamed from: y */
    private float f15101y;

    /* renamed from: z */
    private float f15102z;

    public void onPageScrollStateChanged(int i) {
    }

    public SlidingTabLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SlidingTabLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15086j = new Rect();
        this.f15087k = new Rect();
        this.f15088l = new GradientDrawable();
        this.f15089m = new Paint(1);
        this.f15090n = new Paint(1);
        this.f15091o = new Paint(1);
        this.f15092p = new Paint(1);
        this.f15093q = new Path();
        this.f15094r = 0;
        this.f15076U = new Paint(1);
        this.f15077V = new SparseArray<>();
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f15078b = context;
        this.f15081e = new LinearLayout(context);
        addView(this.f15081e);
        m16629a(context, attributeSet);
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
            if (!"-1".equals(attributeValue) && !"-2".equals(attributeValue)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
                this.f15073R = obtainStyledAttributes.getDimensionPixelSize(0, -2);
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: a */
    private void m16629a(Context context, AttributeSet attributeSet) {
        float f;
        if (!PatchProxy.proxy(new Object[]{context, attributeSet}, this, f15055a, false, 8838, new Class[]{Context.class, AttributeSet.class}, Void.TYPE).isSupported) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTabLayout);
            this.f15094r = obtainStyledAttributes.getInt(11, 0);
            this.f15098v = obtainStyledAttributes.getColor(3, Color.parseColor(this.f15094r == 2 ? "#4B6A87" : "#ffffff"));
            if (this.f15094r == 1) {
                f = 4.0f;
            } else {
                f = (float) (this.f15094r == 2 ? -1 : 2);
            }
            this.f15099w = obtainStyledAttributes.getDimension(6, (float) mo23185a(f));
            this.f15100x = obtainStyledAttributes.getDimension(12, (float) mo23185a(this.f15094r == 1 ? 10.0f : -1.0f));
            this.f15101y = obtainStyledAttributes.getDimension(4, (float) mo23185a(this.f15094r == 2 ? -1.0f : 0.0f));
            this.f15102z = obtainStyledAttributes.getDimension(8, (float) mo23185a(0.0f));
            float f2 = 7.0f;
            this.f15056A = obtainStyledAttributes.getDimension(10, (float) mo23185a(this.f15094r == 2 ? 7.0f : 0.0f));
            this.f15057B = obtainStyledAttributes.getDimension(9, (float) mo23185a(0.0f));
            if (this.f15094r != 2) {
                f2 = 0.0f;
            }
            this.f15058C = obtainStyledAttributes.getDimension(7, (float) mo23185a(f2));
            this.f15059D = obtainStyledAttributes.getInt(5, 80);
            this.f15060E = obtainStyledAttributes.getBoolean(13, false);
            this.f15061F = obtainStyledAttributes.getColor(22, Color.parseColor("#ffffff"));
            this.f15062G = obtainStyledAttributes.getDimension(24, (float) mo23185a(0.0f));
            this.f15063H = obtainStyledAttributes.getInt(23, 80);
            this.f15064I = obtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
            this.f15065J = obtainStyledAttributes.getDimension(2, (float) mo23185a(0.0f));
            this.f15066K = obtainStyledAttributes.getDimension(1, (float) mo23185a(12.0f));
            this.f15067L = obtainStyledAttributes.getDimension(21, (float) mo23189b(14.0f));
            this.f15068M = obtainStyledAttributes.getColor(19, Color.parseColor("#ffffff"));
            this.f15069N = obtainStyledAttributes.getColor(20, Color.parseColor("#AAffffff"));
            this.f15070O = obtainStyledAttributes.getInt(18, 0);
            this.f15071P = obtainStyledAttributes.getBoolean(17, false);
            this.f15096t = obtainStyledAttributes.getBoolean(15, false);
            this.f15097u = obtainStyledAttributes.getDimension(16, (float) mo23185a(-1.0f));
            this.f15095s = obtainStyledAttributes.getDimension(14, (float) ((this.f15096t || this.f15097u > 0.0f) ? mo23185a(0.0f) : mo23185a(20.0f)));
            obtainStyledAttributes.recycle();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (!PatchProxy.proxy(new Object[]{viewPager}, this, f15055a, false, 8839, new Class[]{ViewPager.class}, Void.TYPE).isSupported) {
            if (viewPager == null || viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
            }
            this.f15079c = viewPager;
            this.f15079c.removeOnPageChangeListener(this);
            this.f15079c.addOnPageChangeListener(this);
            mo23186a();
        }
    }

    public void setViewPager(ViewPager viewPager, String[] strArr) {
        Class[] clsArr = {ViewPager.class, String[].class};
        if (!PatchProxy.proxy(new Object[]{viewPager, strArr}, this, f15055a, false, 8840, clsArr, Void.TYPE).isSupported) {
            if (viewPager == null || viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
            } else if (strArr == null || strArr.length == 0) {
                throw new IllegalStateException("Titles can not be EMPTY !");
            } else if (strArr.length == viewPager.getAdapter().getCount()) {
                this.f15079c = viewPager;
                this.f15080d = new ArrayList<>();
                Collections.addAll(this.f15080d, strArr);
                this.f15079c.removeOnPageChangeListener(this);
                this.f15079c.addOnPageChangeListener(this);
                mo23186a();
            } else {
                throw new IllegalStateException("Titles length must be the same as the page count !");
            }
        }
    }

    public void setViewPager(ViewPager viewPager, String[] strArr, FragmentActivity fragmentActivity, ArrayList<Fragment> arrayList) {
        if (!PatchProxy.proxy(new Object[]{viewPager, strArr, fragmentActivity, arrayList}, this, f15055a, false, 8841, new Class[]{ViewPager.class, String[].class, FragmentActivity.class, ArrayList.class}, Void.TYPE).isSupported) {
            if (viewPager == null) {
                throw new IllegalStateException("ViewPager can not be NULL !");
            } else if (strArr == null || strArr.length == 0) {
                throw new IllegalStateException("Titles can not be EMPTY !");
            } else {
                this.f15079c = viewPager;
                this.f15079c.setAdapter(new InnerPagerAdapter(fragmentActivity.getSupportFragmentManager(), arrayList, strArr));
                this.f15079c.removeOnPageChangeListener(this);
                this.f15079c.addOnPageChangeListener(this);
                mo23186a();
            }
        }
    }

    /* renamed from: a */
    public void mo23186a() {
        if (!PatchProxy.proxy(new Object[0], this, f15055a, false, 8842, new Class[0], Void.TYPE).isSupported) {
            this.f15081e.removeAllViews();
            this.f15085i = this.f15080d == null ? this.f15079c.getAdapter().getCount() : this.f15080d.size();
            for (int i = 0; i < this.f15085i; i++) {
                m16628a(i, (this.f15080d == null ? this.f15079c.getAdapter().getPageTitle(i) : this.f15080d.get(i)).toString(), View.inflate(this.f15078b, R.layout.sliding_layout_tab, (ViewGroup) null));
            }
            m16632b();
        }
    }

    /* renamed from: a */
    private void m16628a(int i, String str, View view) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), str, view}, this, f15055a, false, 8844, new Class[]{Integer.TYPE, String.class, View.class}, Void.TYPE).isSupported) {
            TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
            if (!(textView == null || str == null)) {
                textView.setText(str);
            }
            view.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f15103a;

                public void onClick(View view) {
                    int indexOfChild;
                    if (!PatchProxy.proxy(new Object[]{view}, this, f15103a, false, 8887, new Class[]{View.class}, Void.TYPE).isSupported && (indexOfChild = SlidingTabLayout.this.f15081e.indexOfChild(view)) != -1 && SlidingTabLayout.this.f15079c.getCurrentItem() != indexOfChild) {
                        if (SlidingTabLayout.this.f15074S) {
                            SlidingTabLayout.this.f15079c.setCurrentItem(indexOfChild, false);
                        } else {
                            SlidingTabLayout.this.f15079c.setCurrentItem(indexOfChild);
                        }
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = this.f15096t ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
            if (this.f15097u > 0.0f) {
                layoutParams = new LinearLayout.LayoutParams((int) this.f15097u, -1);
            }
            this.f15081e.addView(view, i, layoutParams);
        }
    }

    /* renamed from: b */
    private void m16632b() {
        if (!PatchProxy.proxy(new Object[0], this, f15055a, false, 8845, new Class[0], Void.TYPE).isSupported) {
            int i = 0;
            while (i < this.f15085i) {
                TextView textView = (TextView) this.f15081e.getChildAt(i).findViewById(R.id.tv_tab_title);
                if (textView != null) {
                    textView.setTextColor(i == this.f15082f ? this.f15068M : this.f15069N);
                    textView.setTextSize(0, this.f15067L);
                    textView.setPadding((int) this.f15095s, 0, (int) this.f15095s, 0);
                    if (this.f15071P) {
                        textView.setText(textView.getText().toString().toUpperCase());
                    }
                    if (this.f15070O == 2) {
                        textView.getPaint().setFakeBoldText(true);
                    } else if (this.f15070O == 0) {
                        textView.getPaint().setFakeBoldText(false);
                    }
                }
                i++;
            }
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        Object[] objArr = {new Integer(i), new Float(f), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8846, new Class[]{Integer.TYPE, Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15082f = i;
            this.f15084h = f;
            m16634c();
            invalidate();
        }
    }

    public void onPageSelected(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8847, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            m16633b(i);
            this.f15083g = i;
            invalidate();
        }
    }

    /* renamed from: c */
    private void m16634c() {
        if (!PatchProxy.proxy(new Object[0], this, f15055a, false, 8848, new Class[0], Void.TYPE).isSupported && this.f15085i > 0 && this.f15081e.getChildAt(this.f15082f) != null) {
            int width = (int) (this.f15084h * ((float) this.f15081e.getChildAt(this.f15082f).getWidth()));
            int left = this.f15081e.getChildAt(this.f15082f).getLeft() + width;
            if (this.f15082f > 0 || width > 0) {
                m16636d();
                left = (left - ((getWidth() / 2) - getPaddingLeft())) + ((this.f15087k.right - this.f15087k.left) / 2);
            }
            if (left != this.f15072Q) {
                this.f15072Q = left;
                scrollTo(left, 0);
            }
        }
    }

    /* renamed from: b */
    private void m16633b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f15055a, false, 8849, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            int i2 = 0;
            while (i2 < this.f15085i) {
                View childAt = this.f15081e.getChildAt(i2);
                boolean z = i2 == i;
                TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
                if (textView != null) {
                    textView.setTextColor(z ? this.f15068M : this.f15069N);
                    if (this.f15070O == 1) {
                        textView.getPaint().setFakeBoldText(z);
                    }
                }
                i2++;
            }
        }
    }

    /* renamed from: d */
    private void m16636d() {
        if (!PatchProxy.proxy(new Object[0], this, f15055a, false, 8850, new Class[0], Void.TYPE).isSupported) {
            View childAt = this.f15081e.getChildAt(this.f15082f);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.f15094r == 0 && this.f15060E) {
                this.f15076U.setTextSize(this.f15067L);
                this.f15075T = ((right - left) - this.f15076U.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f;
            }
            if (this.f15082f < this.f15085i - 1) {
                View childAt2 = this.f15081e.getChildAt(this.f15082f + 1);
                float left2 = (float) childAt2.getLeft();
                float right2 = (float) childAt2.getRight();
                left += this.f15084h * (left2 - left);
                right += this.f15084h * (right2 - right);
                if (this.f15094r == 0 && this.f15060E) {
                    this.f15076U.setTextSize(this.f15067L);
                    this.f15075T += this.f15084h * ((((right2 - left2) - this.f15076U.measureText(((TextView) childAt2.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f) - this.f15075T);
                }
            }
            int i = (int) left;
            this.f15086j.left = i;
            int i2 = (int) right;
            this.f15086j.right = i2;
            if (this.f15094r == 0 && this.f15060E) {
                this.f15086j.left = (int) ((left + this.f15075T) - 1.0f);
                this.f15086j.right = (int) ((right - this.f15075T) - 1.0f);
            }
            this.f15087k.left = i;
            this.f15087k.right = i2;
            if (this.f15100x >= 0.0f) {
                float left3 = ((float) childAt.getLeft()) + ((((float) childAt.getWidth()) - this.f15100x) / 2.0f);
                if (this.f15082f < this.f15085i - 1) {
                    left3 += this.f15084h * ((float) ((childAt.getWidth() / 2) + (this.f15081e.getChildAt(this.f15082f + 1).getWidth() / 2)));
                }
                this.f15086j.left = (int) left3;
                this.f15086j.right = (int) (((float) this.f15086j.left) + this.f15100x);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{canvas2}, this, f15055a, false, 8851, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
            if (!isInEditMode() && this.f15085i > 0) {
                int height = getHeight();
                int paddingLeft = getPaddingLeft();
                int i2 = 0;
                while (i2 < this.f15085i) {
                    if (i2 == this.f15083g) {
                        this.f15091o.setColor(getResources().getColor(R.color.mz_funny_snap_item_bg));
                    } else {
                        this.f15091o.setColor(i);
                    }
                    View childAt = this.f15081e.getChildAt(i2);
                    canvas.drawRoundRect((float) (childAt.getLeft() + paddingLeft), 0.0f, (float) (childAt.getRight() + paddingLeft), (float) height, 36.0f, 36.0f, this.f15091o);
                    i2++;
                    canvas2 = canvas2;
                    i = 0;
                }
                Canvas canvas3 = canvas2;
                if (this.f15065J > 0.0f) {
                    this.f15090n.setStrokeWidth(this.f15065J);
                    this.f15090n.setColor(this.f15064I);
                    int i3 = 0;
                    for (int i4 = 1; i3 < this.f15085i - i4; i4 = 1) {
                        View childAt2 = this.f15081e.getChildAt(i3);
                        canvas.drawLine((float) (childAt2.getRight() + paddingLeft), this.f15066K, (float) (childAt2.getRight() + paddingLeft), ((float) height) - this.f15066K, this.f15090n);
                        i3++;
                        paddingLeft = paddingLeft;
                        canvas3 = canvas3;
                    }
                }
                Canvas canvas4 = canvas3;
                int i5 = paddingLeft;
                if (this.f15062G > 0.0f) {
                    this.f15089m.setColor(this.f15061F);
                    if (this.f15063H == 80) {
                        float f = (float) height;
                        canvas.drawRect((float) i5, f - this.f15062G, (float) (this.f15081e.getWidth() + i5), f, this.f15089m);
                    } else {
                        canvas.drawRect((float) i5, 0.0f, (float) (this.f15081e.getWidth() + i5), this.f15062G, this.f15089m);
                    }
                }
                m16636d();
                if (this.f15094r == 1) {
                    if (this.f15099w > 0.0f) {
                        this.f15092p.setColor(this.f15098v);
                        this.f15093q.reset();
                        float f2 = (float) height;
                        this.f15093q.moveTo((float) (i5 + this.f15086j.left), f2);
                        this.f15093q.lineTo((float) (i5 + (this.f15086j.left / 2) + (this.f15086j.right / 2)), f2 - this.f15099w);
                        this.f15093q.lineTo((float) (i5 + this.f15086j.right), f2);
                        this.f15093q.close();
                        canvas4.drawPath(this.f15093q, this.f15092p);
                    }
                } else if (this.f15094r == 2) {
                    if (this.f15099w < 0.0f) {
                        this.f15099w = (((float) height) - this.f15056A) - this.f15058C;
                    }
                    if (this.f15099w > 0.0f) {
                        if (this.f15101y < 0.0f || this.f15101y > this.f15099w / 2.0f) {
                            this.f15101y = this.f15099w / 2.0f;
                        }
                        this.f15088l.setColor(this.f15098v);
                        this.f15088l.setBounds(i5 + ((int) this.f15102z) + this.f15086j.left, (int) this.f15056A, (int) (((float) (this.f15086j.right + i5)) - this.f15057B), (int) (this.f15056A + this.f15099w));
                        this.f15088l.setCornerRadius(this.f15101y);
                        this.f15088l.draw(canvas4);
                    }
                } else if (this.f15099w > 0.0f) {
                    this.f15088l.setColor(this.f15098v);
                    if (this.f15059D == 80) {
                        this.f15088l.setBounds(i5 + ((int) this.f15102z) + this.f15086j.left, (height - ((int) this.f15099w)) - ((int) this.f15058C), (this.f15086j.right + i5) - ((int) this.f15057B), height - ((int) this.f15058C));
                    } else {
                        this.f15088l.setBounds(i5 + ((int) this.f15102z) + this.f15086j.left, (int) this.f15056A, (this.f15086j.right + i5) - ((int) this.f15057B), ((int) this.f15099w) + ((int) this.f15056A));
                    }
                    this.f15088l.setCornerRadius(this.f15101y);
                    this.f15088l.draw(canvas4);
                }
            }
        }
    }

    public void setCurrentTab(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8852, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15082f = i;
            this.f15083g = i;
            this.f15079c.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8853, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15082f = i;
            this.f15083g = i;
            this.f15079c.setCurrentItem(i, z);
        }
    }

    public void setIndicatorStyle(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8854, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15094r = i;
            invalidate();
        }
    }

    public void setTabPadding(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8855, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15095s = (float) mo23185a(f);
            m16632b();
        }
    }

    public void setTabSpaceEqual(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8856, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15096t = z;
            m16632b();
        }
    }

    public void setTabWidth(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8857, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15097u = (float) mo23185a(f);
            m16632b();
        }
    }

    public void setIndicatorColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8858, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15098v = i;
            invalidate();
        }
    }

    public void setIndicatorHeight(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8859, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15099w = (float) mo23185a(f);
            invalidate();
        }
    }

    public void setIndicatorWidth(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8860, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15100x = (float) mo23185a(f);
            invalidate();
        }
    }

    public void setIndicatorCornerRadius(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8861, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15101y = (float) mo23185a(f);
            invalidate();
        }
    }

    public void setIndicatorGravity(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8862, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15059D = i;
            invalidate();
        }
    }

    public void setIndicatorMargin(float f, float f2, float f3, float f4) {
        if (!PatchProxy.proxy(new Object[]{new Float(f), new Float(f2), new Float(f3), new Float(f4)}, this, f15055a, false, 8863, new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            this.f15102z = (float) mo23185a(f);
            this.f15056A = (float) mo23185a(f2);
            this.f15057B = (float) mo23185a(f3);
            this.f15058C = (float) mo23185a(f4);
            invalidate();
        }
    }

    public void setIndicatorWidthEqualTitle(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8864, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15060E = z;
            invalidate();
        }
    }

    public void setUnderlineColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8865, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15061F = i;
            invalidate();
        }
    }

    public void setUnderlineHeight(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8866, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15062G = (float) mo23185a(f);
            invalidate();
        }
    }

    public void setUnderlineGravity(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8867, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15063H = i;
            invalidate();
        }
    }

    public void setDividerColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8868, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15064I = i;
            invalidate();
        }
    }

    public void setDividerWidth(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8869, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15065J = (float) mo23185a(f);
            invalidate();
        }
    }

    public void setDividerPadding(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8870, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15066K = (float) mo23185a(f);
            invalidate();
        }
    }

    public void setTextsize(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8871, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15067L = (float) mo23189b(f);
            m16632b();
        }
    }

    public void setTextSelectColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8872, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15068M = i;
            m16632b();
        }
    }

    public void setTextUnselectColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8873, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15069N = i;
            m16632b();
        }
    }

    public void setTextBold(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8874, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15070O = i;
            m16632b();
        }
    }

    public void setTextAllCaps(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8875, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15071P = z;
            m16632b();
        }
    }

    public void setSnapOnTabClick(boolean z) {
        this.f15074S = z;
    }

    public int getTabCount() {
        return this.f15085i;
    }

    public int getCurrentTab() {
        return this.f15082f;
    }

    public int getIndicatorStyle() {
        return this.f15094r;
    }

    public float getTabPadding() {
        return this.f15095s;
    }

    public float getTabWidth() {
        return this.f15097u;
    }

    public int getIndicatorColor() {
        return this.f15098v;
    }

    public float getIndicatorHeight() {
        return this.f15099w;
    }

    public float getIndicatorWidth() {
        return this.f15100x;
    }

    public float getIndicatorCornerRadius() {
        return this.f15101y;
    }

    public float getIndicatorMarginLeft() {
        return this.f15102z;
    }

    public float getIndicatorMarginTop() {
        return this.f15056A;
    }

    public float getIndicatorMarginRight() {
        return this.f15057B;
    }

    public float getIndicatorMarginBottom() {
        return this.f15058C;
    }

    public int getUnderlineColor() {
        return this.f15061F;
    }

    public float getUnderlineHeight() {
        return this.f15062G;
    }

    public int getDividerColor() {
        return this.f15064I;
    }

    public float getDividerWidth() {
        return this.f15065J;
    }

    public float getDividerPadding() {
        return this.f15066K;
    }

    public float getTextsize() {
        return this.f15067L;
    }

    public int getTextSelectColor() {
        return this.f15068M;
    }

    public int getTextUnselectColor() {
        return this.f15069N;
    }

    public int getTextBold() {
        return this.f15070O;
    }

    /* renamed from: a */
    public void mo23188a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8877, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (i >= this.f15085i) {
                i = this.f15085i - 1;
            }
            MsgView msgView = (MsgView) this.f15081e.getChildAt(i).findViewById(R.id.rtv_msg_tip);
            if (msgView != null) {
                m16630a(msgView, i2);
                if (this.f15077V.get(i) == null || !this.f15077V.get(i).booleanValue()) {
                    setMsgMargin(i, -4.0f, -2.0f);
                    this.f15077V.put(i, true);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo23187a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f15055a, false, 8878, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i >= this.f15085i) {
                i = this.f15085i - 1;
            }
            mo23188a(i, 0);
        }
    }

    public void setMsgMargin(int i, float f, float f2) {
        float f3;
        int i2 = 0;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Float(f), new Float(f2)}, this, f15055a, false, 8880, new Class[]{Integer.TYPE, Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            if (i >= this.f15085i) {
                i = this.f15085i - 1;
            }
            View childAt = this.f15081e.getChildAt(i);
            MsgView msgView = (MsgView) childAt.findViewById(R.id.rtv_msg_tip);
            if (msgView != null) {
                this.f15076U.setTextSize(this.f15067L);
                float measureText = this.f15076U.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString());
                float descent = this.f15076U.descent() - this.f15076U.ascent();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) msgView.getLayoutParams();
                if (this.f15097u >= 0.0f) {
                    f3 = this.f15097u / 2.0f;
                    measureText /= 2.0f;
                } else {
                    f3 = this.f15095s;
                }
                marginLayoutParams.leftMargin = (int) (f3 + measureText + ((float) mo23185a(f)));
                if (this.f15073R > 0) {
                    i2 = (((int) (((float) this.f15073R) - descent)) / 2) - mo23185a(f2);
                }
                marginLayoutParams.topMargin = i2;
                msgView.setLayoutParams(marginLayoutParams);
            }
        }
    }

    class InnerPagerAdapter extends FragmentPagerAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f15105a;

        /* renamed from: c */
        private ArrayList<Fragment> f15107c = new ArrayList<>();

        /* renamed from: d */
        private String[] f15108d;

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public InnerPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            this.f15107c = arrayList;
            this.f15108d = strArr;
        }

        public int getCount() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f15105a, false, 8888, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f15107c.size();
        }

        public CharSequence getPageTitle(int i) {
            return this.f15108d[i];
        }

        public Fragment getItem(int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f15105a, false, 8889, new Class[]{Integer.TYPE}, Fragment.class);
            return proxy.isSupported ? (Fragment) proxy.result : this.f15107c.get(i);
        }
    }

    public Parcelable onSaveInstanceState() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f15055a, false, 8882, new Class[0], Parcelable.class);
        if (proxy.isSupported) {
            return (Parcelable) proxy.result;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f15082f);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!PatchProxy.proxy(new Object[]{parcelable}, this, f15055a, false, 8883, new Class[]{Parcelable.class}, Void.TYPE).isSupported) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                this.f15082f = bundle.getInt("mCurrentTab");
                parcelable = bundle.getParcelable("instanceState");
                if (this.f15082f != 0 && this.f15081e.getChildCount() > 0) {
                    this.f15083g = this.f15082f;
                    m16633b(this.f15082f);
                    m16634c();
                }
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    /* renamed from: a */
    public int mo23185a(float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f)}, this, f15055a, false, 8884, new Class[]{Float.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) ((f * this.f15078b.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public int mo23189b(float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f)}, this, f15055a, false, 8885, new Class[]{Float.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) ((f * this.f15078b.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: a */
    private void m16630a(MsgView msgView, int i) {
        Object[] objArr = {msgView, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15055a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8886, new Class[]{MsgView.class, Integer.TYPE}, Void.TYPE).isSupported && msgView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) msgView.getLayoutParams();
            DisplayMetrics displayMetrics = msgView.getResources().getDisplayMetrics();
            msgView.setVisibility(0);
            if (i <= 0) {
                msgView.setStrokeWidth(0);
                msgView.setText("");
                layoutParams.width = (int) (displayMetrics.density * 5.0f);
                layoutParams.height = (int) (displayMetrics.density * 5.0f);
                msgView.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = (int) (displayMetrics.density * 18.0f);
            if (i > 0 && i < 10) {
                layoutParams.width = (int) (displayMetrics.density * 18.0f);
                msgView.setText(i + "");
            } else if (i <= 9 || i >= 100) {
                layoutParams.width = -2;
                msgView.setPadding((int) (displayMetrics.density * 6.0f), 0, (int) (displayMetrics.density * 6.0f), 0);
                msgView.setText("99+");
            } else {
                layoutParams.width = -2;
                msgView.setPadding((int) (displayMetrics.density * 6.0f), 0, (int) (displayMetrics.density * 6.0f), 0);
                msgView.setText(i + "");
            }
            msgView.setLayoutParams(layoutParams);
        }
    }
}
