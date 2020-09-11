package com.meizu.media.camera.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class RotateAnimLayout extends FrameLayout implements Rotatable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14995a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14996b = new LogUtil.C2630a("RotateAnimLayout");

    /* renamed from: c */
    private boolean f14997c = false;

    /* renamed from: d */
    private int f14998d = 0;

    /* renamed from: e */
    private int f14999e = 0;

    /* renamed from: f */
    private int f15000f = 0;

    /* renamed from: g */
    private int f15001g = 0;

    /* renamed from: h */
    private long f15002h = 0;

    /* renamed from: i */
    private long f15003i = 0;

    /* renamed from: j */
    private Handler f15004j = new Handler(new Handler.Callback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f15005a;

        public boolean handleMessage(Message message) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f15005a, false, 8813, new Class[]{Message.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (message.what == 2) {
                RotateAnimLayout.this.m16610a();
            }
            return true;
        }
    });

    public RotateAnimLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public RotateAnimLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotateAnimLayout(Context context) {
        super(context);
    }

    public void setOrientation(int i, boolean z) {
        boolean z2 = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f14995a, false, 8810, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
            if (i2 != this.f15000f) {
                this.f15000f = i2;
                if (z) {
                    this.f15001g = this.f14999e;
                    this.f15002h = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.f15000f - this.f14999e;
                    if (i3 < 0) {
                        i3 += 360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    if (i3 >= 0 && i3 != 180) {
                        z2 = true;
                    }
                    this.f14997c = z2;
                    this.f14998d = (Math.abs(i3) * 1000) / 180;
                    this.f15003i = this.f15002h + 180;
                    m16610a();
                    return;
                }
                this.f14999e = this.f15000f;
                setViewRotation(this.f14999e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16610a() {
        if (!PatchProxy.proxy(new Object[0], this, f14995a, false, 8811, new Class[0], Void.TYPE).isSupported && this.f14999e != this.f15000f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.f15003i) {
                int i = (int) (currentAnimationTimeMillis - this.f15002h);
                int i2 = this.f15001g;
                int i3 = this.f14998d;
                if (!this.f14997c) {
                    i = -i;
                }
                int i4 = i2 + ((i3 * i) / 1000);
                this.f14999e = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                setViewRotation(this.f14999e);
                this.f15004j.sendEmptyMessage(2);
                return;
            }
            this.f14999e = this.f15000f;
            setViewRotation(this.f14999e);
        }
    }

    private void setViewRotation(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14995a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8812, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setRotation((float) (-i));
            invalidate();
        }
    }
}
