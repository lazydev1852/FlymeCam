package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.core.internal.view.SupportMenu;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class RedTipView extends View implements Rotatable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14968a;

    /* renamed from: b */
    private boolean f14969b;

    /* renamed from: c */
    private int f14970c;

    /* renamed from: d */
    private int f14971d;

    /* renamed from: e */
    private int f14972e;

    /* renamed from: f */
    private int f14973f;

    /* renamed from: g */
    private long f14974g;

    /* renamed from: h */
    private long f14975h;

    /* renamed from: i */
    private Paint f14976i;

    /* renamed from: j */
    private Handler f14977j;

    public RedTipView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RedTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14969b = false;
        this.f14970c = 0;
        this.f14971d = 0;
        this.f14972e = 0;
        this.f14973f = 0;
        this.f14974g = 0;
        this.f14975h = 0;
        this.f14976i = new Paint();
        this.f14977j = new Handler(new Handler.Callback() {

            /* renamed from: a */
            public static ChangeQuickRedirect f14978a;

            public boolean handleMessage(Message message) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f14978a, false, 8784, new Class[]{Message.class}, Boolean.TYPE);
                if (proxy.isSupported) {
                    return ((Boolean) proxy.result).booleanValue();
                }
                if (message.what == 2) {
                    RedTipView.this.m16581a();
                }
                return true;
            }
        });
        this.f14976i.setColor(SupportMenu.CATEGORY_MASK);
        this.f14976i.setAntiAlias(true);
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14968a, false, 8780, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) getResources().getDimensionPixelSize(R.dimen.mz_mode_menu_item_badge_radius), this.f14976i);
        }
    }

    public void setOrientation(int i, boolean z) {
        boolean z2 = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f14968a, false, 8781, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
            if (i2 != this.f14972e) {
                this.f14972e = i2;
                if (z) {
                    this.f14973f = this.f14971d;
                    this.f14974g = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.f14972e - this.f14971d;
                    if (i3 < 0) {
                        i3 += 360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    if (i3 >= 0 && i3 != 180) {
                        z2 = true;
                    }
                    this.f14969b = z2;
                    this.f14970c = (Math.abs(i3) * 1000) / 180;
                    this.f14975h = this.f14974g + 180;
                    m16581a();
                    return;
                }
                this.f14971d = this.f14972e;
                setViewRotation(this.f14971d);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16581a() {
        if (!PatchProxy.proxy(new Object[0], this, f14968a, false, 8782, new Class[0], Void.TYPE).isSupported && this.f14971d != this.f14972e) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.f14975h) {
                int i = (int) (currentAnimationTimeMillis - this.f14974g);
                int i2 = this.f14973f;
                int i3 = this.f14970c;
                if (!this.f14969b) {
                    i = -i;
                }
                int i4 = i2 + ((i3 * i) / 1000);
                this.f14971d = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                setViewRotation(this.f14971d);
                this.f14977j.sendEmptyMessage(2);
                return;
            }
            this.f14971d = this.f14972e;
            setViewRotation(this.f14971d);
        }
    }

    private void setViewRotation(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14968a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8783, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setRotation((float) (-i));
            invalidate();
        }
    }
}
