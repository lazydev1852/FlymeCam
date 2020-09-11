package com.meizu.media.camera.simplify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.ArrayList;
import java.util.Iterator;

public class MzSimplifySmartbarContainer extends ViewGroup {

    /* renamed from: a */
    public static ChangeQuickRedirect f11705a;

    /* renamed from: b */
    private int f11706b;

    /* renamed from: c */
    private int f11707c;

    /* renamed from: d */
    private int f11708d = getResources().getDimensionPixelSize(R.dimen.mz_smartbar_padding);

    /* renamed from: e */
    private int f11709e = (getResources().getDrawable(R.drawable.mz_ic_tab_mode).getIntrinsicWidth() + (this.f11708d * 2));

    /* renamed from: f */
    private int f11710f;

    /* renamed from: g */
    private ArrayList<View> f11711g = new ArrayList<>();

    /* renamed from: h */
    private ArrayList<Integer> f11712h = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<View> f11713i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<View> f11714j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<View> f11715k = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<Integer> f11716l = new ArrayList<>();

    /* renamed from: m */
    private ArrayList<Integer> f11717m = new ArrayList<>();

    /* renamed from: n */
    private Animation f11718n;

    /* renamed from: o */
    private Animation f11719o;

    /* renamed from: p */
    private int f11720p;

    /* renamed from: q */
    private boolean f11721q = true;

    public MzSimplifySmartbarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11718n = AnimationUtils.loadAnimation(context, R.anim.mz_smart_bar_button_hide);
        this.f11719o = AnimationUtils.loadAnimation(context, R.anim.mz_smart_bar_button_show);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f11705a, false, 6088, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            m12778a();
            m12780b();
            if ((this.f11710f > 0 || this.f11713i.size() > 0) && this.f11721q) {
                this.f11706b = i3 - i;
                this.f11707c = i4 - i2;
                m12781c();
                m12782d();
            }
        }
    }

    public void onViewAdded(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f11705a, false, 6089, new Class[]{View.class}, Void.TYPE).isSupported) {
            super.onViewAdded(view);
            this.f11711g.add(view);
            this.f11712h.add(Integer.valueOf(view.getVisibility()));
        }
    }

    public void setNeedLayout(boolean z) {
        this.f11721q = z;
    }

    /* renamed from: a */
    private void m12779a(View view, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f11705a, false, 6090, new Class[]{View.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            view.layout(i, i2, i3 + i, i4 + i2);
        }
    }

    /* renamed from: a */
    private void m12778a() {
        if (!PatchProxy.proxy(new Object[0], this, f11705a, false, 6091, new Class[0], Void.TYPE).isSupported) {
            this.f11713i.clear();
            this.f11714j.clear();
            this.f11715k.clear();
            this.f11716l.clear();
            this.f11710f = 0;
        }
    }

    /* renamed from: b */
    private void m12780b() {
        if (!PatchProxy.proxy(new Object[0], this, f11705a, false, 6092, new Class[0], Void.TYPE).isSupported) {
            int size = this.f11711g.size();
            for (int i = 0; i < size; i++) {
                View view = this.f11711g.get(i);
                int visibility = view.getVisibility();
                if (visibility != this.f11712h.get(i).intValue()) {
                    if (visibility == 0) {
                        this.f11714j.add(view);
                    } else {
                        this.f11713i.add(view);
                    }
                    this.f11712h.set(i, Integer.valueOf(visibility));
                }
                if (visibility == 0) {
                    this.f11710f++;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12781c() {
        /*
            r13 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f11705a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 6093(0x17cd, float:8.538E-42)
            r2 = r13
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int r1 = r13.getChildCount()
            java.util.ArrayList<java.lang.Integer> r2 = r13.f11717m
            boolean r2 = r2.isEmpty()
            r3 = 0
            r4 = 0
        L_0x0022:
            if (r3 >= r1) goto L_0x00c3
            android.view.View r6 = r13.getChildAt(r3)
            int r5 = r6.getVisibility()
            r7 = -1
            if (r5 != 0) goto L_0x00aa
            int r4 = r4 + 1
            int r5 = r13.f11710f
            r8 = 1
            if (r5 != r8) goto L_0x004d
            int r5 = r13.getChildCount()
            int r5 = r5 - r8
            if (r3 != r5) goto L_0x004b
            int r5 = r13.f11710f
            int r8 = r13.getChildCount()
            if (r5 != r8) goto L_0x004b
            int r5 = r13.f11706b
            int r8 = r13.f11709e
            int r5 = r5 - r8
            goto L_0x0066
        L_0x004b:
            r8 = 0
            goto L_0x0067
        L_0x004d:
            int r5 = r13.f11709e
            int r9 = r4 + -1
            int r5 = r5 * r9
            r10 = 2
            if (r4 < r10) goto L_0x0066
            int r10 = r13.f11706b
            int r11 = r13.f11709e
            int r12 = r13.f11710f
            int r11 = r11 * r12
            int r10 = r10 - r11
            int r10 = r10 * r9
            int r9 = r13.f11710f
            int r9 = r9 - r8
            int r10 = r10 / r9
            int r5 = r5 + r10
        L_0x0066:
            r8 = r5
        L_0x0067:
            if (r2 == 0) goto L_0x0073
            java.util.ArrayList<java.lang.Integer> r5 = r13.f11717m
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r5.add(r7)
            goto L_0x009c
        L_0x0073:
            java.util.ArrayList<java.lang.Integer> r5 = r13.f11717m
            java.lang.Object r5 = r5.get(r3)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 == r7) goto L_0x0093
            if (r5 == r8) goto L_0x0093
            java.util.ArrayList<android.view.View> r7 = r13.f11715k
            r7.add(r6)
            java.util.ArrayList<java.lang.Integer> r7 = r13.f11716l
            int r5 = r8 - r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.add(r5)
        L_0x0093:
            java.util.ArrayList<java.lang.Integer> r5 = r13.f11717m
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r5.set(r3, r7)
        L_0x009c:
            r9 = 0
            int r10 = r13.f11709e
            int r11 = r13.f11707c
            r5 = r13
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r5.m12779a(r6, r7, r8, r9, r10)
            goto L_0x00bf
        L_0x00aa:
            if (r2 == 0) goto L_0x00b6
            java.util.ArrayList<java.lang.Integer> r5 = r13.f11717m
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r5.add(r6)
            goto L_0x00bf
        L_0x00b6:
            java.util.ArrayList<java.lang.Integer> r5 = r13.f11717m
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r5.set(r3, r6)
        L_0x00bf:
            int r3 = r3 + 1
            goto L_0x0022
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifySmartbarContainer.m12781c():void");
    }

    /* renamed from: d */
    private void m12782d() {
        if (!PatchProxy.proxy(new Object[0], this, f11705a, false, 6094, new Class[0], Void.TYPE).isSupported) {
            if (this.f11720p < 1) {
                this.f11720p++;
                return;
            }
            for (int i = 0; i < this.f11715k.size(); i++) {
                TranslateAnimation translateAnimation = new TranslateAnimation((float) (-this.f11716l.get(i).intValue()), 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(300);
                translateAnimation.setInterpolator(getContext(), R.anim.mz_smart_bar_button_interpolator);
                this.f11715k.get(i).startAnimation(translateAnimation);
            }
            Iterator<View> it = this.f11713i.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() == 0) {
                    next.startAnimation(this.f11718n);
                }
            }
            Iterator<View> it2 = this.f11714j.iterator();
            while (it2.hasNext()) {
                it2.next().startAnimation(this.f11719o);
            }
        }
    }
}
