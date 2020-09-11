package com.meizu.media.camera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.mediatek.camcorder.CamcorderProfileEx;
import com.meizu.media.camera.adapter.TypeItem;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.List;

/* renamed from: com.meizu.media.camera.adapter.b */
public abstract class MyTypeAdapter<T extends TypeItem> extends BaseAdapter {

    /* renamed from: a */
    public static ChangeQuickRedirect f7558a;

    /* renamed from: b */
    protected LayoutInflater f7559b = LayoutInflater.from(this.f7560c);

    /* renamed from: c */
    protected final Context f7560c;

    /* renamed from: d */
    protected final List<T> f7561d;

    /* renamed from: e */
    protected final int[] f7562e;

    /* renamed from: f */
    protected final int[] f7563f;

    /* renamed from: a */
    public abstract void mo18787a(ViewHolder dVar, int i, int i2, T t);

    public long getItemId(int i) {
        return (long) i;
    }

    public MyTypeAdapter(Context context, int[] iArr, int[] iArr2, List<T> list) {
        this.f7560c = context;
        this.f7562e = iArr2;
        this.f7561d = list;
        this.f7563f = iArr;
    }

    public int getCount() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7558a, false, 2248, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f7561d.size();
    }

    /* renamed from: a */
    public T getItem(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f7558a, false, 2249, new Class[]{Integer.TYPE}, TypeItem.class);
        return proxy.isSupported ? (TypeItem) proxy.result : (TypeItem) this.f7561d.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Object[] objArr = {new Integer(i), view, viewGroup};
        ChangeQuickRedirect changeQuickRedirect = f7558a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, CamcorderProfileEx.SLOW_MOTION_FHD_60FPS, new Class[]{Integer.TYPE, View.class, ViewGroup.class}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        int itemViewType = getItemViewType(i);
        ViewHolder a = m8001a(i, view, viewGroup, itemViewType);
        mo18787a(a, i, itemViewType, getItem(i));
        return a.mo18795a();
    }

    public int getItemViewType(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f7558a, false, CamcorderProfileEx.SLOW_MOTION_FHD_120FPS, new Class[]{Integer.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : ((TypeItem) this.f7561d.get(i)).mo18794a();
    }

    public int getViewTypeCount() {
        return this.f7563f.length;
    }

    /* renamed from: a */
    private ViewHolder m8001a(int i, View view, ViewGroup viewGroup, int i2) {
        Object[] objArr = {new Integer(i), view, viewGroup, new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f7558a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2252, new Class[]{Integer.TYPE, View.class, ViewGroup.class, Integer.TYPE}, ViewHolder.class);
        if (proxy.isSupported) {
            return (ViewHolder) proxy.result;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= getViewTypeCount()) {
                i3 = 0;
                break;
            } else if (this.f7563f[i3] == i2) {
                break;
            } else {
                i3++;
            }
        }
        return ViewHolder.m8005a(this.f7560c, i, view, viewGroup, this.f7562e[i3]);
    }
}
