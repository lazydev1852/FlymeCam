package com.meizu.media.camera.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class RotatableLayout extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14991a;

    /* renamed from: b */
    private int f14992b;

    /* renamed from: c */
    private int f14993c = -1;

    /* renamed from: d */
    private boolean f14994d = false;

    /* renamed from: b */
    private static boolean m16602b(int i, int i2) {
        return (i & i2) == i2;
    }

    public RotatableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16603c();
    }

    public RotatableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16603c();
    }

    public RotatableLayout(Context context) {
        super(context);
        m16603c();
    }

    /* renamed from: c */
    private void m16603c() {
        if (!PatchProxy.proxy(new Object[0], this, f14991a, false, 8796, new Class[0], Void.TYPE).isSupported) {
            this.f14992b = getResources().getConfiguration().orientation;
        }
    }

    public void onAttachedToWindow() {
        int i = 0;
        if (!PatchProxy.proxy(new Object[0], this, f14991a, false, 8797, new Class[0], Void.TYPE).isSupported) {
            super.onAttachedToWindow();
            if (this.f14993c == -1) {
                this.f14994d = CameraUtil.m15886c((Activity) getContext());
                if (this.f14994d) {
                    if (this.f14992b != 1) {
                        i = 90;
                    }
                    this.f14993c = i;
                } else {
                    if (this.f14992b != 2) {
                        i = 270;
                    }
                    this.f14993c = i;
                }
                m16605d();
            }
        }
    }

    /* renamed from: d */
    private void m16605d() {
        if (!PatchProxy.proxy(new Object[0], this, f14991a, false, 8798, new Class[0], Void.TYPE).isSupported && this.f14993c != -1) {
            int b = CameraUtil.m15867b((Activity) getContext());
            int i = ((b - this.f14993c) + 360) % 360;
            if (i != 0) {
                if (i == 180) {
                    this.f14993c = b;
                    mo23160b();
                    return;
                }
                boolean a = m16600a(this.f14993c, b);
                this.f14993c = b;
                mo23159a(a);
            }
        }
    }

    public int getUnifiedRotation() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14991a, false, 8799, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int b = CameraUtil.m15867b((Activity) getContext());
        return !this.f14994d ? (b + 90) % 360 : b;
    }

    /* renamed from: a */
    public void mo23158a() {
        if (!PatchProxy.proxy(new Object[0], this, f14991a, false, 8800, new Class[0], Void.TYPE).isSupported) {
            int b = CameraUtil.m15867b((Activity) getContext());
            if (((b - this.f14993c) + 360) % 360 == 180) {
                this.f14993c = b;
                mo23160b();
                requestLayout();
            }
        }
    }

    public void onWindowVisibilityChanged(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14991a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8801, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i == 0) {
            mo23158a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!PatchProxy.proxy(new Object[]{configuration}, this, f14991a, false, 8802, new Class[]{Configuration.class}, Void.TYPE).isSupported) {
            super.onConfigurationChanged(configuration);
            m16605d();
        }
    }

    /* renamed from: a */
    public void mo23159a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14991a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8803, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            layoutParams.height = i;
            layoutParams.width = i2;
            setLayoutParams(layoutParams);
            mo23161b(z);
        }
    }

    /* renamed from: b */
    public void mo23161b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f14991a, false, 8804, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                m16599a(getChildAt(i), z);
            }
        }
    }

    /* renamed from: b */
    public void mo23160b() {
        if (!PatchProxy.proxy(new Object[0], this, f14991a, false, 8805, new Class[0], Void.TYPE).isSupported) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                m16604c(getChildAt(i));
            }
        }
    }

    /* renamed from: a */
    public static boolean m16600a(int i, int i2) {
        return i == (i2 + 90) % 360;
    }

    /* renamed from: a */
    public static void m16599a(View view, boolean z) {
        if (!PatchProxy.proxy(new Object[]{view, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14991a, true, 8806, new Class[]{View.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                m16598a(view);
            } else {
                m16601b(view);
            }
        }
    }

    /* renamed from: a */
    public static void m16598a(View view) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{view}, (Object) null, f14991a, true, 8807, new Class[]{View.class}, Void.TYPE).isSupported && view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int i2 = layoutParams.gravity;
            if (m16602b(i2, 3)) {
                i = 48;
            }
            if (m16602b(i2, 5)) {
                i |= 80;
            }
            if (m16602b(i2, 48)) {
                i |= 5;
            }
            if (m16602b(i2, 80)) {
                i |= 3;
            }
            if (m16602b(i2, 17)) {
                i |= 17;
            }
            if (m16602b(i2, 1)) {
                i |= 16;
            }
            if (m16602b(i2, 16)) {
                i |= 1;
            }
            layoutParams.gravity = i;
            int i3 = layoutParams.leftMargin;
            int i4 = layoutParams.rightMargin;
            int i5 = layoutParams.topMargin;
            layoutParams.leftMargin = layoutParams.bottomMargin;
            layoutParams.rightMargin = i5;
            layoutParams.topMargin = i3;
            layoutParams.bottomMargin = i4;
            int i6 = layoutParams.width;
            layoutParams.width = layoutParams.height;
            layoutParams.height = i6;
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: b */
    public static void m16601b(View view) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{view}, (Object) null, f14991a, true, 8808, new Class[]{View.class}, Void.TYPE).isSupported && view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int i2 = layoutParams.gravity;
            if (m16602b(i2, 5)) {
                i = 48;
            }
            if (m16602b(i2, 3)) {
                i |= 80;
            }
            if (m16602b(i2, 48)) {
                i |= 3;
            }
            if (m16602b(i2, 80)) {
                i |= 5;
            }
            if (m16602b(i2, 17)) {
                i |= 17;
            }
            if (m16602b(i2, 1)) {
                i |= 16;
            }
            if (m16602b(i2, 16)) {
                i |= 1;
            }
            layoutParams.gravity = i;
            int i3 = layoutParams.leftMargin;
            int i4 = layoutParams.rightMargin;
            int i5 = layoutParams.topMargin;
            int i6 = layoutParams.bottomMargin;
            layoutParams.leftMargin = i5;
            layoutParams.rightMargin = i6;
            layoutParams.topMargin = i4;
            layoutParams.bottomMargin = i3;
            int i7 = layoutParams.width;
            layoutParams.width = layoutParams.height;
            layoutParams.height = i7;
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: c */
    public static void m16604c(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, (Object) null, f14991a, true, 8809, new Class[]{View.class}, Void.TYPE).isSupported) {
            m16598a(view);
            m16598a(view);
        }
    }
}
