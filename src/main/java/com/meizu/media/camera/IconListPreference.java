package com.meizu.media.camera;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class IconListPreference extends ListPreference {

    /* renamed from: b */
    public static ChangeQuickRedirect f6770b;

    /* renamed from: e */
    private int f6771e;

    /* renamed from: f */
    private int[] f6772f;

    /* renamed from: g */
    private int[] f6773g;

    /* renamed from: h */
    private int[] f6774h;

    /* renamed from: i */
    private int[] f6775i;

    /* renamed from: j */
    private int[] f6776j;

    public IconListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IconListPreference, 0, 0);
        Resources resources = context.getResources();
        this.f6771e = obtainStyledAttributes.getResourceId(5, 0);
        this.f6772f = m6598a(resources, obtainStyledAttributes.getResourceId(2, 0));
        this.f6773g = m6598a(resources, obtainStyledAttributes.getResourceId(4, 0));
        this.f6774h = m6598a(resources, obtainStyledAttributes.getResourceId(3, 0));
        this.f6775i = m6598a(resources, obtainStyledAttributes.getResourceId(0, 0));
        this.f6776j = m6598a(resources, obtainStyledAttributes.getResourceId(1, 0));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    public int[] mo17811c() {
        return this.f6772f;
    }

    /* renamed from: d */
    public int[] mo17812d() {
        return this.f6773g;
    }

    /* renamed from: e */
    public int[] mo17813e() {
        return this.f6776j;
    }

    /* renamed from: a */
    private int[] m6598a(Resources resources, int i) {
        Object[] objArr = {resources, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6770b;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 1093, new Class[]{Resources.class, Integer.TYPE}, int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        if (i == 0) {
            return null;
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        int length = obtainTypedArray.length();
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }

    /* renamed from: f */
    public int mo17814f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6770b, false, 1095, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int l = mo17826l();
        return l == -1 ? l : this.f6774h[l];
    }

    /* renamed from: g */
    public int mo17815g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6770b, false, 1096, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int l = mo17826l();
        return l == -1 ? l : this.f6775i[l];
    }
}
