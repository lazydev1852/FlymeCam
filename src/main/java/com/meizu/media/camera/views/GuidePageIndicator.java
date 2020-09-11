package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.meizu.media.camera.R;
import com.meizu.media.camera.p077ui.MzGuideUI;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class GuidePageIndicator extends View implements MzGuideUI.PageIndicator {

    /* renamed from: a */
    public static ChangeQuickRedirect f14597a;

    /* renamed from: b */
    private int f14598b;

    /* renamed from: c */
    private int f14599c;

    /* renamed from: d */
    private int f14600d;

    /* renamed from: e */
    private int f14601e;

    /* renamed from: f */
    private int f14602f;

    /* renamed from: g */
    private Paint f14603g;

    /* renamed from: h */
    private Paint f14604h;

    /* renamed from: i */
    private Paint f14605i;

    /* renamed from: j */
    private ViewPager f14606j;

    /* renamed from: k */
    private ViewPager.OnPageChangeListener f14607k;

    /* renamed from: l */
    private int f14608l;

    /* renamed from: m */
    private int f14609m;

    /* renamed from: n */
    private float f14610n;

    /* renamed from: o */
    private int f14611o;

    /* renamed from: p */
    private boolean f14612p;

    /* renamed from: q */
    private int f14613q;

    /* renamed from: r */
    private float f14614r;

    /* renamed from: s */
    private int f14615s;

    /* renamed from: t */
    private boolean f14616t;

    /* renamed from: u */
    private boolean f14617u;

    /* renamed from: a */
    private float m16438a(float f, float f2, float f3, int i) {
        return i < 0 ? f2 - ((f2 - f) * f3) : f + ((f2 - f) * f3);
    }

    public GuidePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public GuidePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14614r = -1.0f;
        this.f14615s = -1;
        this.f14617u = false;
        if (!isInEditMode()) {
            m16440b();
            this.f14613q = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    /* renamed from: b */
    private void m16440b() {
        if (!PatchProxy.proxy(new Object[0], this, f14597a, false, 8381, new Class[0], Void.TYPE).isSupported) {
            m16441c();
            m16442d();
        }
    }

    /* renamed from: c */
    private void m16441c() {
        if (!PatchProxy.proxy(new Object[0], this, f14597a, false, 8382, new Class[0], Void.TYPE).isSupported) {
            this.f14603g = new Paint(1);
            this.f14603g.setStyle(Paint.Style.FILL);
            this.f14604h = new Paint(1);
            this.f14604h.setStyle(Paint.Style.STROKE);
            this.f14605i = new Paint(1);
            this.f14605i.setStyle(Paint.Style.FILL);
        }
    }

    /* renamed from: d */
    private void m16442d() {
        if (!PatchProxy.proxy(new Object[0], this, f14597a, false, 8383, new Class[0], Void.TYPE).isSupported) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.circle_indicator_page_color);
            int color2 = resources.getColor(R.color.circle_indicator_fill_color);
            int color3 = resources.getColor(R.color.circle_indicator_stroke_color);
            float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(R.dimen.default_circle_indicator_radius);
            float dimension3 = resources.getDimension(R.dimen.default_circle_indicator_max_radius);
            this.f14601e = color2;
            this.f14602f = color;
            this.f14603g.setColor(color);
            this.f14604h.setColor(color3);
            this.f14604h.setStrokeWidth(dimension);
            this.f14605i.setColor(color2);
            this.f14598b = (int) dimension2;
            this.f14599c = (int) dimension3;
            this.f14612p = true;
            this.f14600d = (int) ((float) ((int) resources.getDimension(R.dimen.default_circle_indicator_spacing)));
        }
    }

    public void onMeasure(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f14597a, false, 8384, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, i2);
            int count = getCount();
            setMeasuredDimension(resolveSizeAndState(getPaddingLeft() + getPaddingRight() + (count * 2 * this.f14598b) + ((count - 1) * this.f14600d) + 1, i, 0), resolveSizeAndState((Math.max(this.f14598b, this.f14599c) * 2) + getPaddingTop() + getPaddingBottom() + 1, i2, 0));
        }
    }

    public void onDraw(Canvas canvas) {
        int count;
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14597a, false, 8385, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
            if (this.f14606j != null && (count = getCount()) != 0) {
                if (this.f14608l >= count) {
                    setCurrentItem(count - 1);
                    return;
                }
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                float f = (float) ((this.f14598b * 2) + this.f14600d);
                float f2 = (float) (paddingTop + this.f14598b);
                float f3 = (float) (paddingLeft + this.f14598b);
                float f4 = (float) this.f14598b;
                if (this.f14604h.getStrokeWidth() > 0.0f) {
                    f4 -= this.f14604h.getStrokeWidth() / 2.0f;
                }
                this.f14603g.setColor(this.f14602f);
                int i = this.f14612p ? this.f14609m : this.f14608l;
                for (int i2 = 0; i2 < count; i2++) {
                    if (!(i == i2 || ((i == count - 1 && i2 == 0) || i2 == i + 1))) {
                        float f5 = (((float) i2) * f) + f3;
                        if (this.f14603g.getAlpha() > 0) {
                            canvas.drawCircle(f5, f2, f4, this.f14603g);
                        }
                        if (f4 != ((float) this.f14598b)) {
                            canvas.drawCircle(f5, f2, (float) this.f14598b, this.f14604h);
                        }
                    }
                }
                float f6 = ((float) (this.f14612p ? this.f14609m : this.f14608l)) * f;
                if (!this.f14612p) {
                    f6 += this.f14610n * f;
                }
                float f7 = f6 + f3;
                int a = m16439a(this.f14602f, this.f14601e, this.f14610n, -1);
                float a2 = m16438a((float) this.f14598b, (float) this.f14599c, this.f14610n, -1);
                this.f14605i.setColor(a);
                canvas.drawCircle(f7, f2, a2, this.f14605i);
                if (this.f14608l != count - 1) {
                    f3 = f7 + f;
                }
                int a3 = m16439a(this.f14602f, this.f14601e, this.f14610n, 1);
                float a4 = m16438a((float) this.f14598b, (float) this.f14599c, this.f14610n, 1);
                this.f14605i.setColor(a3);
                canvas.drawCircle(f3, f2, a4, this.f14605i);
            }
        }
    }

    private int getCount() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14597a, false, 8386, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f14606j == null || this.f14606j.getAdapter() == null) {
            return 0;
        }
        if (!this.f14617u || this.f14606j.getAdapter().getCount() <= 1) {
            return this.f14606j.getAdapter().getCount();
        }
        return this.f14606j.getAdapter().getCount() / 2;
    }

    /* renamed from: a */
    private int m16439a(int i, int i2, float f, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Float(f), new Integer(i3)}, this, f14597a, false, 8387, new Class[]{Integer.TYPE, Integer.TYPE, Float.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int alpha = Color.alpha(i);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        int alpha2 = Color.alpha(i2);
        if (i3 < 0) {
            i4 = Math.round(((float) red2) - (((float) (red2 - red)) * f));
            i7 = Math.round(((float) green2) - (((float) (green2 - green)) * f));
            i6 = Math.round(((float) blue2) - (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha2) - (((float) (alpha2 - alpha)) * f));
        } else {
            i4 = Math.round(((float) red) + (((float) (red2 - red)) * f));
            i7 = Math.round(((float) green) + (((float) (green2 - green)) * f));
            i6 = Math.round(((float) blue) + (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha) + (((float) (alpha2 - alpha)) * f));
        }
        return Color.argb(i5, i4, i7, i6);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14597a, false, 8388, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f14606j == null || getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.f14615s = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f14614r = motionEvent.getX();
                break;
            case 1:
            case 3:
                if (!this.f14616t) {
                    int count = getCount();
                    float width = (float) getWidth();
                    float f = width / 2.0f;
                    float f2 = width / 6.0f;
                    if (this.f14608l > 0 && motionEvent.getX() < f - f2) {
                        if (action != 3) {
                            this.f14606j.setCurrentItem(this.f14608l - 1);
                        }
                        return true;
                    } else if (this.f14608l < count - 1 && motionEvent.getX() > f + f2) {
                        if (action != 3) {
                            this.f14606j.setCurrentItem(this.f14608l + 1);
                        }
                        return true;
                    }
                }
                this.f14616t = false;
                this.f14615s = -1;
                if (this.f14606j.isFakeDragging()) {
                    try {
                        this.f14606j.endFakeDrag();
                        break;
                    } catch (Exception e) {
                        Log.w("CirclePageIndicator", "", e);
                        break;
                    }
                }
                break;
            case 2:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14615s));
                float f3 = x - this.f14614r;
                if (!this.f14616t && Math.abs(f3) > ((float) this.f14613q)) {
                    this.f14616t = true;
                }
                if (this.f14616t) {
                    this.f14614r = x;
                    if (this.f14606j.isFakeDragging() || this.f14606j.beginFakeDrag()) {
                        try {
                            this.f14606j.fakeDragBy(f3);
                            break;
                        } catch (Exception e2) {
                            Log.d("CirclePageIndicator", "", e2);
                            break;
                        }
                    }
                }
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f14614r = MotionEventCompat.getX(motionEvent, actionIndex);
                this.f14615s = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, actionIndex2) == this.f14615s) {
                    if (actionIndex2 == 0) {
                        i = 1;
                    }
                    this.f14615s = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f14614r = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14615s));
                break;
        }
        return true;
    }

    public int getIndicatorWidth() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14597a, false, 8389, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return getPaddingLeft() + getPaddingRight() + (getCount() * 2 * this.f14598b) + ((getCount() - 1) * this.f14600d) + 1;
    }

    public int getIndicatorHeight() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14597a, false, 8390, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (Math.max(this.f14598b, this.f14599c) * 2) + getPaddingTop() + getPaddingBottom() + 1;
    }

    public void setPageColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8391, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14603g.setColor(i);
            invalidate();
        }
    }

    public int getPageColor() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14597a, false, 8392, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f14603g.getColor();
    }

    public void setFillColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8393, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14605i.setColor(i);
            invalidate();
        }
    }

    public int getFillColor() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14597a, false, 8394, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f14605i.getColor();
    }

    public void setStrokeColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8395, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14604h.setColor(i);
            invalidate();
        }
    }

    public int getStrokeColor() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14597a, false, 8396, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f14604h.getColor();
    }

    public void setStrokeWidth(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8397, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f14604h.setStrokeWidth(f);
            invalidate();
        }
    }

    public float getStrokeWidth() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14597a, false, 8398, new Class[0], Float.TYPE);
        return proxy.isSupported ? ((Float) proxy.result).floatValue() : this.f14604h.getStrokeWidth();
    }

    public void setRadius(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8399, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14598b = i;
            invalidate();
        }
    }

    public float getRadius() {
        return (float) this.f14598b;
    }

    public void setDoubleCount(boolean z) {
        this.f14617u = z;
    }

    public float getSpacing() {
        return (float) this.f14600d;
    }

    public void setSpacing(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8400, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14600d = i;
            invalidate();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (!PatchProxy.proxy(new Object[]{viewPager}, this, f14597a, false, 8401, new Class[]{ViewPager.class}, Void.TYPE).isSupported && this.f14606j != viewPager) {
            if (this.f14606j != null) {
                this.f14606j.setOnPageChangeListener((ViewPager.OnPageChangeListener) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f14606j = viewPager;
                this.f14606j.setOnPageChangeListener(this);
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (!PatchProxy.proxy(new Object[]{viewPager, new Integer(i)}, this, f14597a, false, 8402, new Class[]{ViewPager.class, Integer.TYPE}, Void.TYPE).isSupported) {
            setViewPager(viewPager);
            setCurrentItem(i);
        }
    }

    public void setCurrentItem(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8403, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f14606j != null) {
                this.f14606j.setCurrentItem(i);
                this.f14608l = i;
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager has not been bound.");
        }
    }

    /* renamed from: a */
    public void mo22902a() {
        if (!PatchProxy.proxy(new Object[0], this, f14597a, false, 8404, new Class[0], Void.TYPE).isSupported) {
            invalidate();
        }
    }

    public void onPageScrollStateChanged(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8405, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14611o = i;
            if (this.f14607k != null) {
                this.f14607k.onPageScrollStateChanged(i);
            }
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        Object[] objArr = {new Integer(i), new Float(f), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8406, new Class[]{Integer.TYPE, Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.f14606j != null) {
            if (!this.f14617u || this.f14606j.getAdapter().getCount() <= 1) {
                this.f14608l = i;
            } else {
                this.f14608l = i % (this.f14606j.getAdapter().getCount() / 2);
            }
            this.f14609m = this.f14608l;
            this.f14610n = f;
            invalidate();
            if (this.f14607k != null) {
                this.f14607k.onPageScrolled(i, f, i2);
            }
        }
    }

    public void onPageSelected(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14597a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8407, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && getCount() > 1) {
            if (this.f14612p || this.f14611o == 0) {
                if (!this.f14617u || this.f14606j.getAdapter().getCount() <= 1) {
                    this.f14608l = i;
                } else {
                    this.f14608l = i % (this.f14606j.getAdapter().getCount() / 2);
                }
                this.f14609m = this.f14608l;
                invalidate();
            }
            if (this.f14607k != null) {
                this.f14607k.onPageSelected(i);
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f14607k = onPageChangeListener;
    }
}
