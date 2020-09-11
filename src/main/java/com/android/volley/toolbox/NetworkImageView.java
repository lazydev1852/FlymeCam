package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.android.volley.toolbox.ImageLoader;

public class NetworkImageView extends ImageView {

    /* renamed from: a */
    private String f349a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f350b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f351c;

    /* renamed from: d */
    private ImageLoader f352d;

    /* renamed from: e */
    private ImageLoader.C0466c f353e;

    public NetworkImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @MainThread
    public void setImageUrl(String str, ImageLoader kVar) {
        Threads.m722a();
        this.f349a = str;
        this.f352d = kVar;
        mo8716a(false);
    }

    public void setDefaultImageResId(int i) {
        this.f350b = i;
    }

    public void setErrorImageResId(int i) {
        this.f351c = i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8716a(final boolean r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.widget.ImageView$ScaleType r7 = r8.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x002a
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L_0x001f
            r2 = 1
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002a:
            r2 = 0
        L_0x002b:
            r5 = 0
        L_0x002c:
            if (r2 == 0) goto L_0x0031
            if (r5 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            if (r0 != 0) goto L_0x0039
            if (r1 != 0) goto L_0x0039
            if (r3 != 0) goto L_0x0039
            return
        L_0x0039:
            java.lang.String r3 = r8.f349a
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0051
            com.android.volley.toolbox.k$c r9 = r8.f353e
            if (r9 == 0) goto L_0x004d
            com.android.volley.toolbox.k$c r9 = r8.f353e
            r9.mo8761a()
            r9 = 0
            r8.f353e = r9
        L_0x004d:
            r8.m620a()
            return
        L_0x0051:
            com.android.volley.toolbox.k$c r3 = r8.f353e
            if (r3 == 0) goto L_0x0074
            com.android.volley.toolbox.k$c r3 = r8.f353e
            java.lang.String r3 = r3.mo8763c()
            if (r3 == 0) goto L_0x0074
            com.android.volley.toolbox.k$c r3 = r8.f353e
            java.lang.String r3 = r3.mo8763c()
            java.lang.String r6 = r8.f349a
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x006c
            return
        L_0x006c:
            com.android.volley.toolbox.k$c r3 = r8.f353e
            r3.mo8761a()
            r8.m620a()
        L_0x0074:
            if (r2 == 0) goto L_0x0077
            r0 = 0
        L_0x0077:
            if (r5 == 0) goto L_0x007b
            r6 = 0
            goto L_0x007c
        L_0x007b:
            r6 = r1
        L_0x007c:
            com.android.volley.toolbox.k r2 = r8.f352d
            java.lang.String r3 = r8.f349a
            com.android.volley.toolbox.NetworkImageView$1 r4 = new com.android.volley.toolbox.NetworkImageView$1
            r4.<init>(r9)
            r5 = r0
            com.android.volley.toolbox.k$c r9 = r2.mo8750a((java.lang.String) r3, (com.android.volley.toolbox.ImageLoader.C0467d) r4, (int) r5, (int) r6, (android.widget.ImageView.ScaleType) r7)
            r8.f353e = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.NetworkImageView.mo8716a(boolean):void");
    }

    /* renamed from: a */
    private void m620a() {
        if (this.f350b != 0) {
            setImageResource(this.f350b);
        } else {
            setImageBitmap((Bitmap) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        mo8716a(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.f353e != null) {
            this.f353e.mo8761a();
            setImageBitmap((Bitmap) null);
            this.f353e = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
