package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.meizu.common.R;

public class RoundCornerImageView extends ImageView {

    /* renamed from: a */
    private Drawable f5958a;

    /* renamed from: b */
    private boolean f5959b;

    /* renamed from: c */
    private float f5960c;

    /* renamed from: d */
    private float f5961d;

    public RoundCornerImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView, i, 0);
        this.f5960c = obtainStyledAttributes.getFloat(R.styleable.RoundCornerImageView_mzCornerRadiusX, 0.0f);
        this.f5961d = obtainStyledAttributes.getFloat(R.styleable.RoundCornerImageView_mzCornerRadiusY, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f5958a != null && this.f5958a != getDrawable() && this.f5959b) {
            ((BitmapDrawable) this.f5958a).getBitmap().recycle();
            this.f5958a = null;
            this.f5959b = false;
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f5958a != null && this.f5958a != getDrawable() && this.f5959b) {
            ((BitmapDrawable) this.f5958a).getBitmap().recycle();
            this.f5958a = null;
            this.f5959b = false;
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.f5958a != null && this.f5958a != getDrawable() && this.f5959b) {
            ((BitmapDrawable) this.f5958a).getBitmap().recycle();
            this.f5958a = null;
            this.f5959b = false;
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f5958a != null && this.f5958a != getDrawable() && this.f5959b) {
            ((BitmapDrawable) this.f5958a).getBitmap().recycle();
            this.f5958a = null;
            this.f5959b = false;
        }
    }

    public void setRadius(float f, float f2) {
        if (getDrawable() == null || getDrawable() != this.f5958a) {
            this.f5960c = f;
            this.f5961d = f2;
            invalidate();
        }
    }

    public float getRadiusX() {
        return this.f5960c;
    }

    public float getRadiusY() {
        return this.f5961d;
    }

    /* renamed from: a */
    private void m6002a() {
        Bitmap bitmap;
        if (getDrawable() != null) {
            Drawable drawable = this.f5958a;
            boolean z = this.f5959b;
            this.f5959b = false;
            if (getDrawable() instanceof BitmapDrawable) {
                Bitmap bitmap2 = ((BitmapDrawable) getDrawable()).getBitmap();
                int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                if (bitmap2.getWidth() < measuredWidth && bitmap2.getHeight() < measuredHeight) {
                    bitmap = bitmap2;
                } else if (bitmap2.getWidth() < measuredWidth) {
                    bitmap = Bitmap.createBitmap(bitmap2, 0, (bitmap2.getHeight() - measuredHeight) / 2, bitmap2.getWidth(), measuredHeight);
                    this.f5959b = true;
                } else if (bitmap2.getHeight() < measuredHeight) {
                    bitmap = Bitmap.createBitmap(bitmap2, (bitmap2.getWidth() - measuredWidth) / 2, 0, measuredWidth, bitmap2.getHeight());
                    this.f5959b = true;
                } else {
                    bitmap = ThumbnailUtils.extractThumbnail(bitmap2, measuredWidth, measuredHeight);
                    if (bitmap != bitmap2) {
                        this.f5959b = true;
                    }
                }
                if (bitmap != null) {
                    if (this.f5960c == 0.0f || this.f5961d == 0.0f) {
                        this.f5958a = new BitmapDrawable(getContext().getResources(), bitmap);
                    } else {
                        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        int width = (measuredWidth - bitmap.getWidth()) / 2;
                        int height = (measuredHeight - bitmap.getHeight()) / 2;
                        Rect rect = new Rect(width, height, measuredWidth - width, measuredHeight - height);
                        RectF rectF = new RectF(new Rect(0, 0, measuredWidth, measuredHeight));
                        Paint paint = new Paint();
                        paint.setColor(Color.argb(255, 255, 255, 255));
                        paint.setAntiAlias(true);
                        canvas.drawRoundRect(rectF, this.f5960c, this.f5961d, paint);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
                        if (bitmap != bitmap2) {
                            bitmap.recycle();
                        }
                        this.f5958a = new BitmapDrawable(getContext().getResources(), createBitmap);
                        this.f5959b = true;
                    }
                    super.setImageDrawable(this.f5958a);
                }
            }
            if (drawable != null && z) {
                ((BitmapDrawable) drawable).getBitmap().recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f5958a != getDrawable()) {
            m6002a();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(RoundCornerImageView.class.getName());
    }
}
