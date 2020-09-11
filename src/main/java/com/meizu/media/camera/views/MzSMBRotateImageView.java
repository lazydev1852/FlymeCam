package com.meizu.media.camera.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class MzSMBRotateImageView extends TwoStateImageView implements Rotatable {

    /* renamed from: a */
    private static final LogUtil.C2630a f14855a = new LogUtil.C2630a("MzSMBRotateImageView");

    /* renamed from: b */
    public static ChangeQuickRedirect f14856b;

    /* renamed from: d */
    private boolean f14857d = false;

    /* renamed from: e */
    private int f14858e = 0;

    /* renamed from: f */
    private int f14859f = 0;

    /* renamed from: g */
    private int f14860g = 0;

    /* renamed from: h */
    private int f14861h = 0;

    /* renamed from: i */
    private long f14862i = 0;

    /* renamed from: j */
    private long f14863j = 0;

    /* renamed from: k */
    private Handler f14864k = new Handler(new Handler.Callback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f14865a;

        public boolean handleMessage(Message message) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f14865a, false, 8668, new Class[]{Message.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (message.what == 2) {
                MzSMBRotateImageView.this.m16540a();
            }
            return true;
        }
    });

    public MzSMBRotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MzSMBRotateImageView(Context context) {
        super(context);
    }

    public void setOrientation(int i, boolean z) {
        boolean z2 = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f14856b, false, 8665, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
            if (i2 != this.f14860g) {
                this.f14860g = i2;
                if (z) {
                    this.f14861h = this.f14859f;
                    this.f14862i = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.f14860g - this.f14859f;
                    if (i3 < 0) {
                        i3 += 360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    if (i3 >= 0 && i3 != 180) {
                        z2 = true;
                    }
                    this.f14857d = z2;
                    this.f14858e = (Math.abs(i3) * 1000) / 180;
                    this.f14863j = this.f14862i + 180;
                    m16540a();
                    return;
                }
                this.f14859f = this.f14860g;
                setViewRotation(this.f14859f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16540a() {
        if (!PatchProxy.proxy(new Object[0], this, f14856b, false, 8666, new Class[0], Void.TYPE).isSupported && this.f14859f != this.f14860g) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.f14863j) {
                int i = (int) (currentAnimationTimeMillis - this.f14862i);
                int i2 = this.f14861h;
                int i3 = this.f14858e;
                if (!this.f14857d) {
                    i = -i;
                }
                int i4 = i2 + ((i3 * i) / 1000);
                this.f14859f = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                setViewRotation(this.f14859f);
                this.f14864k.sendEmptyMessage(2);
                return;
            }
            this.f14859f = this.f14860g;
            setViewRotation(this.f14859f);
        }
    }

    private void setViewRotation(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14856b;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8667, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setRotation((float) (-i));
            invalidate();
        }
    }
}
