package com.meizu.media.camera.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class ModeItemView extends RelativeLayout implements Checkable, Rotatable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14739a;

    /* renamed from: b */
    private boolean f14740b;

    /* renamed from: c */
    private TextCheckableView f14741c;

    /* renamed from: d */
    private ImageCheckableView f14742d;

    /* renamed from: e */
    private boolean f14743e;

    /* renamed from: f */
    private int f14744f;

    /* renamed from: g */
    private int f14745g;

    /* renamed from: h */
    private int f14746h;

    /* renamed from: i */
    private int f14747i;

    /* renamed from: j */
    private long f14748j;

    /* renamed from: k */
    private long f14749k;

    /* renamed from: l */
    private Handler f14750l;

    public ModeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14743e = false;
        this.f14744f = 0;
        this.f14745g = 0;
        this.f14746h = 0;
        this.f14747i = 0;
        this.f14748j = 0;
        this.f14749k = 0;
        this.f14750l = new Handler(new Handler.Callback() {

            /* renamed from: a */
            public static ChangeQuickRedirect f14751a;

            public boolean handleMessage(Message message) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f14751a, false, 8487, new Class[]{Message.class}, Boolean.TYPE);
                if (proxy.isSupported) {
                    return ((Boolean) proxy.result).booleanValue();
                }
                if (message.what == 2) {
                    ModeItemView.this.m16485a();
                }
                return true;
            }
        });
    }

    public ModeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ModeItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onFinishInflate() {
        if (!PatchProxy.proxy(new Object[0], this, f14739a, false, 8481, new Class[0], Void.TYPE).isSupported) {
            super.onFinishInflate();
            this.f14742d = (ImageCheckableView) findViewById(R.id.mode_icon);
            this.f14741c = (TextCheckableView) findViewById(R.id.mode_name);
        }
    }

    public void setChecked(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8482, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f14740b != z) {
            this.f14740b = z;
            this.f14741c.setChecked(z);
            this.f14742d.setChecked(z);
        }
    }

    public boolean isChecked() {
        return this.f14740b;
    }

    public void toggle() {
        if (!PatchProxy.proxy(new Object[0], this, f14739a, false, 8483, new Class[0], Void.TYPE).isSupported) {
            setChecked(!this.f14740b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16485a() {
        if (!PatchProxy.proxy(new Object[0], this, f14739a, false, 8484, new Class[0], Void.TYPE).isSupported && this.f14745g != this.f14746h) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.f14749k) {
                int i = (int) (currentAnimationTimeMillis - this.f14748j);
                int i2 = this.f14747i;
                int i3 = this.f14744f;
                if (!this.f14743e) {
                    i = -i;
                }
                int i4 = i2 + ((i3 * i) / 1000);
                this.f14745g = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                setViewRotation(this.f14745g);
                if (!this.f14750l.hasMessages(2)) {
                    this.f14750l.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            this.f14745g = this.f14746h;
            setViewRotation(this.f14745g);
        }
    }

    private void setViewRotation(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14739a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8485, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setRotation((float) (-i));
            invalidate();
        }
    }

    public void setOrientation(int i, boolean z) {
        boolean z2 = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f14739a, false, 8486, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
            if (i2 != this.f14746h) {
                this.f14746h = i2;
                if (z) {
                    this.f14747i = this.f14745g;
                    this.f14748j = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.f14746h - this.f14745g;
                    if (i3 < 0) {
                        i3 += 360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    if (i3 >= 0 && i3 != 180) {
                        z2 = true;
                    }
                    this.f14743e = z2;
                    this.f14744f = (Math.abs(i3) * 1000) / 180;
                    this.f14749k = this.f14748j + 180;
                    m16485a();
                    return;
                }
                this.f14745g = this.f14746h;
                setViewRotation(this.f14745g);
            }
        }
    }
}
