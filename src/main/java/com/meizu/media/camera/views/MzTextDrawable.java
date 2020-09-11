package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.views.k */
public class MzTextDrawable extends Drawable {

    /* renamed from: a */
    public static ChangeQuickRedirect f15488a;

    /* renamed from: b */
    private String f15489b;

    /* renamed from: c */
    private TextPaint f15490c = new TextPaint();

    /* renamed from: d */
    private float f15491d;

    /* renamed from: e */
    private float f15492e;

    /* renamed from: f */
    private float f15493f;

    /* renamed from: g */
    private float f15494g;

    /* renamed from: h */
    private View f15495h;

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public MzTextDrawable(Context context, String str) {
        this.f15489b = str;
        this.f15490c.setAntiAlias(true);
        this.f15490c.setColor(-1);
        this.f15490c.setTextSize(ContextBuilder.m6349a(context, true, true).getResources().getDimension(R.dimen.mz_font_size_18sp));
        this.f15491d = (-this.f15490c.ascent()) - this.f15490c.descent();
        this.f15492e = this.f15490c.measureText(this.f15489b);
    }

    /* renamed from: a */
    public void mo23383a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15488a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8705, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f15490c != null) {
            this.f15490c.setColor(i);
        }
    }

    /* renamed from: a */
    public void mo23385a(View view) {
        this.f15495h = view;
    }

    public void draw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15488a, false, 8706, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f15495h.getWidth() != 0) {
            if (this.f15493f == 0.0f) {
                this.f15493f = (((float) this.f15495h.getWidth()) - this.f15492e) / 2.0f;
                this.f15494g = (((float) this.f15495h.getHeight()) + this.f15491d) / 2.0f;
            }
            canvas.drawText(this.f15489b, this.f15493f, this.f15494g, this.f15490c);
        }
    }

    /* renamed from: a */
    public void mo23384a(Typeface typeface) {
        if (!PatchProxy.proxy(new Object[]{typeface}, this, f15488a, false, 8707, new Class[]{Typeface.class}, Void.TYPE).isSupported) {
            this.f15490c.setTypeface(typeface);
        }
    }
}
