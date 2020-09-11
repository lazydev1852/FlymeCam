package com.meizu.media.camera.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class TextCheckableView extends AppCompatTextView implements Checkable, Rotatable {

    /* renamed from: a */
    public static ChangeQuickRedirect f15120a;

    /* renamed from: b */
    private boolean f15121b;

    /* renamed from: c */
    private int f15122c;

    /* renamed from: d */
    private int f15123d;

    /* renamed from: e */
    private int f15124e;

    /* renamed from: f */
    private int f15125f;

    /* renamed from: g */
    private long f15126g;

    /* renamed from: h */
    private long f15127h;

    /* renamed from: i */
    private int f15128i;

    /* renamed from: j */
    private int f15129j;

    /* renamed from: k */
    private boolean f15130k;

    /* renamed from: l */
    private Handler f15131l;

    public TextCheckableView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextCheckableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextCheckableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15121b = false;
        this.f15122c = 0;
        this.f15123d = 0;
        this.f15124e = 0;
        this.f15125f = 0;
        this.f15126g = 0;
        this.f15127h = 0;
        this.f15131l = new Handler(new Handler.Callback() {

            /* renamed from: a */
            public static ChangeQuickRedirect f15132a;

            public boolean handleMessage(Message message) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f15132a, false, 8903, new Class[]{Message.class}, Boolean.TYPE);
                if (proxy.isSupported) {
                    return ((Boolean) proxy.result).booleanValue();
                }
                if (message.what == 2) {
                    TextCheckableView.this.m16643a();
                }
                return true;
            }
        });
        this.f15128i = getResources().getColor(R.color.mz_settting_item_select_color);
        this.f15129j = getResources().getColor(R.color.mz_more_mode_item_unselected_color);
    }

    public void setChecked(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15120a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8898, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f15130k != z) {
            this.f15130k = z;
            if (z) {
                setTextColor(this.f15128i);
            } else {
                setTextColor(this.f15129j);
            }
        }
    }

    public boolean isChecked() {
        return this.f15130k;
    }

    public void toggle() {
        if (!PatchProxy.proxy(new Object[0], this, f15120a, false, 8899, new Class[0], Void.TYPE).isSupported) {
            setChecked(!this.f15130k);
        }
    }

    public void setOrientation(int i, boolean z) {
        boolean z2 = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f15120a, false, 8900, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
            if (i2 != this.f15124e) {
                this.f15124e = i2;
                if (z) {
                    this.f15125f = this.f15123d;
                    this.f15126g = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.f15124e - this.f15123d;
                    if (i3 < 0) {
                        i3 += 360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    if (i3 >= 0 && i3 != 180) {
                        z2 = true;
                    }
                    this.f15121b = z2;
                    this.f15122c = (Math.abs(i3) * 1000) / 180;
                    this.f15127h = this.f15126g + 180;
                    m16643a();
                    return;
                }
                this.f15123d = this.f15124e;
                setViewRotation(this.f15123d);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16643a() {
        if (!PatchProxy.proxy(new Object[0], this, f15120a, false, 8901, new Class[0], Void.TYPE).isSupported && this.f15123d != this.f15124e) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.f15127h) {
                int i = (int) (currentAnimationTimeMillis - this.f15126g);
                int i2 = this.f15125f;
                int i3 = this.f15122c;
                if (!this.f15121b) {
                    i = -i;
                }
                int i4 = i2 + ((i3 * i) / 1000);
                this.f15123d = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                setViewRotation(this.f15123d);
                this.f15131l.sendEmptyMessage(2);
                return;
            }
            this.f15123d = this.f15124e;
            setViewRotation(this.f15123d);
        }
    }

    private void setViewRotation(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15120a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8902, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setRotation((float) (-i));
            invalidate();
        }
    }
}
