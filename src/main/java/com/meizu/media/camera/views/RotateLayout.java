package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class RotateLayout extends ViewGroup implements Rotatable {

    /* renamed from: a */
    public static ChangeQuickRedirect f15017a;

    /* renamed from: c */
    private static final LogUtil.C2630a f15018c = new LogUtil.C2630a("RotateLayout");

    /* renamed from: b */
    protected View f15019b;

    /* renamed from: d */
    private int f15020d;

    /* renamed from: e */
    private Matrix f15021e = new Matrix();

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public RotateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(17170445);
    }

    public void onFinishInflate() {
        if (!PatchProxy.proxy(new Object[0], this, f15017a, false, 8817, new Class[0], Void.TYPE).isSupported) {
            super.onFinishInflate();
            this.f15019b = getChildAt(0);
            this.f15019b.setPivotX(0.0f);
            this.f15019b.setPivotY(0.0f);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f15017a, false, 8818, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            int i7 = this.f15020d;
            if (i7 != 0) {
                if (i7 != 90) {
                    if (i7 != 180) {
                        if (i7 != 270) {
                            return;
                        }
                    }
                }
                this.f15019b.layout(0, 0, i6, i5);
                return;
            }
            this.f15019b.layout(0, 0, i5, i6);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r8 = 0
            r1[r8] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r11)
            r3 = 1
            r1[r3] = r2
            com.meizu.savior.ChangeQuickRedirect r4 = f15017a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r0 = java.lang.Integer.TYPE
            r6[r8] = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            r6[r3] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r0 = 0
            r5 = 8819(0x2273, float:1.2358E-41)
            r2 = r9
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0030
            return
        L_0x0030:
            int r0 = r9.f15020d
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 180(0xb4, float:2.52E-43)
            r3 = 90
            if (r0 == 0) goto L_0x0054
            if (r0 == r3) goto L_0x0042
            if (r0 == r2) goto L_0x0054
            if (r0 == r1) goto L_0x0042
            r10 = 0
            goto L_0x0065
        L_0x0042:
            android.view.View r0 = r9.f15019b
            r9.measureChild(r0, r11, r10)
            android.view.View r10 = r9.f15019b
            int r8 = r10.getMeasuredHeight()
            android.view.View r10 = r9.f15019b
            int r10 = r10.getMeasuredWidth()
            goto L_0x0065
        L_0x0054:
            android.view.View r0 = r9.f15019b
            r9.measureChild(r0, r10, r11)
            android.view.View r10 = r9.f15019b
            int r8 = r10.getMeasuredWidth()
            android.view.View r10 = r9.f15019b
            int r10 = r10.getMeasuredHeight()
        L_0x0065:
            r9.setMeasuredDimension(r8, r10)
            int r11 = r9.f15020d
            r0 = 0
            if (r11 == 0) goto L_0x0099
            if (r11 == r3) goto L_0x008d
            if (r11 == r2) goto L_0x0080
            if (r11 == r1) goto L_0x0074
            goto L_0x00a3
        L_0x0074:
            android.view.View r10 = r9.f15019b
            float r11 = (float) r8
            r10.setTranslationX(r11)
            android.view.View r10 = r9.f15019b
            r10.setTranslationY(r0)
            goto L_0x00a3
        L_0x0080:
            android.view.View r11 = r9.f15019b
            float r0 = (float) r8
            r11.setTranslationX(r0)
            android.view.View r11 = r9.f15019b
            float r10 = (float) r10
            r11.setTranslationY(r10)
            goto L_0x00a3
        L_0x008d:
            android.view.View r11 = r9.f15019b
            r11.setTranslationX(r0)
            android.view.View r11 = r9.f15019b
            float r10 = (float) r10
            r11.setTranslationY(r10)
            goto L_0x00a3
        L_0x0099:
            android.view.View r10 = r9.f15019b
            r10.setTranslationX(r0)
            android.view.View r10 = r9.f15019b
            r10.setTranslationY(r0)
        L_0x00a3:
            android.view.View r10 = r9.f15019b
            int r11 = r9.f15020d
            int r11 = -r11
            float r11 = (float) r11
            r10.setRotation(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.RotateLayout.onMeasure(int, int):void");
    }

    public void setOrientation(int i, boolean z) {
        int i2;
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15017a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8820, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f15020d != (i2 = i % 360)) {
            this.f15020d = i2;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f15020d;
    }
}
