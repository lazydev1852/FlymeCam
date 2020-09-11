package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.meizu.common.R;

public class ImageViewShadow extends ImageView {

    /* renamed from: a */
    private BlurMaskFilter f5459a;

    /* renamed from: b */
    private float f5460b;

    /* renamed from: c */
    private int[] f5461c;

    /* renamed from: d */
    private int f5462d;

    /* renamed from: e */
    private int f5463e;

    public ImageViewShadow(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageViewShadow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageViewShadow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageViewShadow, i, 0);
        setBlurRadius(obtainStyledAttributes.getFloat(R.styleable.ImageViewShadow_mcBlurRadius, 1.0f));
        setOffsetX(obtainStyledAttributes.getInt(R.styleable.ImageViewShadow_mcOffsetX, -Math.round(this.f5460b)));
        setOffsetY(obtainStyledAttributes.getInt(R.styleable.ImageViewShadow_mcOffsetY, -1));
        obtainStyledAttributes.recycle();
        this.f5459a = new BlurMaskFilter(this.f5460b, BlurMaskFilter.Blur.NORMAL);
        setImageShadowDrawable(getDrawable());
    }

    public void setImageShadowResource(int i) {
        Resources resources = getResources();
        Drawable drawable = resources.getDrawable(i);
        if (drawable != null) {
            setImageDrawable(m5819a(resources, drawable));
        }
    }

    public void setImageShadowDrawable(Drawable drawable) {
        if (drawable != null) {
            setImageDrawable(m5819a(getResources(), drawable));
        }
    }

    public void setBlurMaskFilter(BlurMaskFilter blurMaskFilter) {
        this.f5459a = blurMaskFilter;
        Drawable drawable = getDrawable();
        if (drawable != null) {
            setImageShadowDrawable(drawable);
        }
    }

    /* renamed from: a */
    private Drawable m5819a(Resources resources, Drawable drawable) {
        Bitmap a = m5818a(drawable);
        if (a == null) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(resources.getColor(R.color.mc_image_view_shadow));
        paint.setMaskFilter(this.f5459a);
        this.f5461c = new int[2];
        Bitmap extractAlpha = a.extractAlpha(paint, this.f5461c);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        paint2.setAlpha(52);
        canvas.drawBitmap(extractAlpha, (float) this.f5462d, (float) this.f5463e, paint2);
        canvas.drawBitmap(a, 0.0f, 0.0f, (Paint) null);
        return new BitmapDrawable(resources, createBitmap);
    }

    /* renamed from: a */
    private Bitmap m5818a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public float getBlurRadius() {
        return this.f5460b;
    }

    public void setBlurRadius(float f) {
        this.f5460b = f;
    }

    public int[] getOffsetXY() {
        return this.f5461c;
    }

    public int getOffsetX() {
        return this.f5462d;
    }

    public void setOffsetX(int i) {
        this.f5462d = i;
    }

    public int getOffsetY() {
        return this.f5463e;
    }

    public void setOffsetY(int i) {
        this.f5463e = i;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ImageViewShadow.class.getName());
    }
}
