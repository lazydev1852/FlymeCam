package com.meizu.media.camera.views;

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

public class MzSmartbarContainer extends ViewGroup {

    /* renamed from: a */
    public static ChangeQuickRedirect f14867a;

    /* renamed from: b */
    private int f14868b;

    /* renamed from: c */
    private int f14869c;

    /* renamed from: d */
    private int f14870d = getResources().getDimensionPixelSize(R.dimen.mz_smartbar_padding);

    /* renamed from: e */
    private int f14871e = (getResources().getDrawable(R.drawable.mz_ic_tab_mode).getIntrinsicWidth() + (this.f14870d * 2));

    /* renamed from: f */
    private int f14872f;

    /* renamed from: g */
    private ArrayList<View> f14873g = new ArrayList<>();

    /* renamed from: h */
    private ArrayList<Integer> f14874h = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<View> f14875i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<View> f14876j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<View> f14877k = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<Integer> f14878l = new ArrayList<>();

    /* renamed from: m */
    private ArrayList<Integer> f14879m = new ArrayList<>();

    /* renamed from: n */
    private Animation f14880n;

    /* renamed from: o */
    private Animation f14881o;

    /* renamed from: p */
    private int f14882p;

    /* renamed from: q */
    private boolean f14883q = true;

    public MzSmartbarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14880n = AnimationUtils.loadAnimation(context, R.anim.mz_smart_bar_button_hide);
        this.f14881o = AnimationUtils.loadAnimation(context, R.anim.mz_smart_bar_button_show);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f14867a, false, 8697, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            m16542a();
            m16544b();
            if ((this.f14872f > 0 || this.f14875i.size() > 0) && this.f14883q) {
                this.f14868b = i3 - i;
                this.f14869c = i4 - i2;
                m16545c();
                m16546d();
            }
        }
    }

    public void onViewAdded(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f14867a, false, 8698, new Class[]{View.class}, Void.TYPE).isSupported) {
            super.onViewAdded(view);
            this.f14873g.add(view);
            this.f14874h.add(Integer.valueOf(view.getVisibility()));
        }
    }

    public void setNeedLayout(boolean z) {
        this.f14883q = z;
    }

    /* renamed from: a */
    private void m16543a(View view, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f14867a, false, 8699, new Class[]{View.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            view.layout(i, i2, i3 + i, i4 + i2);
        }
    }

    /* renamed from: a */
    private void m16542a() {
        if (!PatchProxy.proxy(new Object[0], this, f14867a, false, 8700, new Class[0], Void.TYPE).isSupported) {
            this.f14875i.clear();
            this.f14876j.clear();
            this.f14877k.clear();
            this.f14878l.clear();
            this.f14872f = 0;
        }
    }

    /* renamed from: b */
    private void m16544b() {
        if (!PatchProxy.proxy(new Object[0], this, f14867a, false, 8701, new Class[0], Void.TYPE).isSupported) {
            int size = this.f14873g.size();
            for (int i = 0; i < size; i++) {
                View view = this.f14873g.get(i);
                int visibility = view.getVisibility();
                if (visibility != this.f14874h.get(i).intValue()) {
                    if (visibility == 0) {
                        this.f14876j.add(view);
                    } else {
                        this.f14875i.add(view);
                    }
                    this.f14874h.set(i, Integer.valueOf(visibility));
                }
                if (visibility == 0) {
                    this.f14872f++;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16545c() {
        /*
            r13 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f14867a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 8702(0x21fe, float:1.2194E-41)
            r2 = r13
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int r1 = r13.getChildCount()
            java.util.ArrayList<java.lang.Integer> r2 = r13.f14879m
            boolean r2 = r2.isEmpty()
            r3 = 0
            r4 = 0
        L_0x0022:
            if (r3 >= r1) goto L_0x00cb
            android.view.View r6 = r13.getChildAt(r3)
            int r5 = r6.getVisibility()
            r7 = -1
            if (r5 != 0) goto L_0x00b2
            int r4 = r4 + 1
            int r5 = r13.f14872f
            r8 = 2
            r9 = 1
            if (r5 != r9) goto L_0x0056
            int r5 = r13.getChildCount()
            int r5 = r5 - r9
            if (r3 != r5) goto L_0x0044
            int r5 = r13.f14868b
            int r8 = r13.f14871e
            int r5 = r5 - r8
            goto L_0x006e
        L_0x0044:
            int r5 = r6.getId()
            r9 = 2131296606(0x7f09015e, float:1.8211133E38)
            if (r5 != r9) goto L_0x004f
            r8 = 0
            goto L_0x006f
        L_0x004f:
            int r5 = r13.f14868b
            int r9 = r13.f14871e
            int r5 = r5 - r9
            int r5 = r5 / r8
            goto L_0x006e
        L_0x0056:
            int r5 = r13.f14871e
            int r10 = r4 + -1
            int r5 = r5 * r10
            if (r4 < r8) goto L_0x006e
            int r8 = r13.f14868b
            int r11 = r13.f14871e
            int r12 = r13.f14872f
            int r11 = r11 * r12
            int r8 = r8 - r11
            int r8 = r8 * r10
            int r10 = r13.f14872f
            int r10 = r10 - r9
            int r8 = r8 / r10
            int r5 = r5 + r8
        L_0x006e:
            r8 = r5
        L_0x006f:
            if (r2 == 0) goto L_0x007b
            java.util.ArrayList<java.lang.Integer> r5 = r13.f14879m
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r5.add(r7)
            goto L_0x00a4
        L_0x007b:
            java.util.ArrayList<java.lang.Integer> r5 = r13.f14879m
            java.lang.Object r5 = r5.get(r3)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 == r7) goto L_0x009b
            if (r5 == r8) goto L_0x009b
            java.util.ArrayList<android.view.View> r7 = r13.f14877k
            r7.add(r6)
            java.util.ArrayList<java.lang.Integer> r7 = r13.f14878l
            int r5 = r8 - r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.add(r5)
        L_0x009b:
            java.util.ArrayList<java.lang.Integer> r5 = r13.f14879m
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r5.set(r3, r7)
        L_0x00a4:
            r9 = 0
            int r10 = r13.f14871e
            int r11 = r13.f14869c
            r5 = r13
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r5.m16543a(r6, r7, r8, r9, r10)
            goto L_0x00c7
        L_0x00b2:
            if (r2 == 0) goto L_0x00be
            java.util.ArrayList<java.lang.Integer> r5 = r13.f14879m
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r5.add(r6)
            goto L_0x00c7
        L_0x00be:
            java.util.ArrayList<java.lang.Integer> r5 = r13.f14879m
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r5.set(r3, r6)
        L_0x00c7:
            int r3 = r3 + 1
            goto L_0x0022
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.MzSmartbarContainer.m16545c():void");
    }

    /* renamed from: d */
    private void m16546d() {
        if (!PatchProxy.proxy(new Object[0], this, f14867a, false, 8703, new Class[0], Void.TYPE).isSupported) {
            if (this.f14882p < 1) {
                this.f14882p++;
                return;
            }
            for (int i = 0; i < this.f14877k.size(); i++) {
                TranslateAnimation translateAnimation = new TranslateAnimation((float) (-this.f14878l.get(i).intValue()), 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(300);
                translateAnimation.setInterpolator(getContext(), R.anim.mz_smart_bar_button_interpolator);
                this.f14877k.get(i).startAnimation(translateAnimation);
            }
            Iterator<View> it = this.f14875i.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() == 0) {
                    next.startAnimation(this.f14880n);
                }
            }
            Iterator<View> it2 = this.f14876j.iterator();
            while (it2.hasNext()) {
                it2.next().startAnimation(this.f14881o);
            }
        }
    }

    /* renamed from: a */
    public void mo23096a(View view, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i), new Integer(i2)}, this, f14867a, false, 8704, new Class[]{View.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            TranslateAnimation translateAnimation = new TranslateAnimation((float) (i2 - i), 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setInterpolator(getContext(), R.anim.mz_smart_bar_button_interpolator);
            view.startAnimation(translateAnimation);
        }
    }
}
