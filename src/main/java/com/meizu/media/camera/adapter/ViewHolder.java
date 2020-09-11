package com.meizu.media.camera.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.adapter.d */
public final class ViewHolder {

    /* renamed from: a */
    public static ChangeQuickRedirect f7565a;

    /* renamed from: b */
    private final SparseArray<View> f7566b = new SparseArray<>();

    /* renamed from: c */
    private final int f7567c;

    /* renamed from: d */
    private final Context f7568d;

    /* renamed from: e */
    private final View f7569e;

    private ViewHolder(Context context, int i, ViewGroup viewGroup, int i2) {
        this.f7568d = context;
        this.f7567c = i;
        this.f7569e = LayoutInflater.from(context).inflate(i2, viewGroup, false);
        this.f7569e.setTag(this);
    }

    /* renamed from: a */
    public static ViewHolder m8005a(Context context, int i, View view, ViewGroup viewGroup, int i2) {
        Object[] objArr = {context, new Integer(i), view, viewGroup, new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f7565a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 2276, new Class[]{Context.class, Integer.TYPE, View.class, ViewGroup.class, Integer.TYPE}, ViewHolder.class);
        if (proxy.isSupported) {
            return (ViewHolder) proxy.result;
        }
        if (view == null) {
            return new ViewHolder(context, i, viewGroup, i2);
        }
        return (ViewHolder) view.getTag();
    }

    /* renamed from: a */
    public View mo18795a() {
        return this.f7569e;
    }

    /* renamed from: a */
    public <T extends View> T mo18796a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7565a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2277, new Class[]{Integer.TYPE}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        T t = (View) this.f7566b.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.f7569e.findViewById(i);
        this.f7566b.put(i, findViewById);
        return findViewById;
    }

    /* renamed from: a */
    public void mo18799a(int i, String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f7565a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2278, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            ((TextView) mo18796a(i)).setText(str);
        }
    }

    /* renamed from: a */
    public void mo18797a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f7565a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2279, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            ((TextView) mo18796a(i)).setText(i2);
        }
    }

    /* renamed from: a */
    public void mo18798a(int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Object[] objArr = {new Integer(i), onCheckedChangeListener};
        ChangeQuickRedirect changeQuickRedirect = f7565a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2285, new Class[]{Integer.TYPE, CompoundButton.OnCheckedChangeListener.class}, Void.TYPE).isSupported) {
            ((CompoundButton) mo18796a(i)).setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    /* renamed from: a */
    public void mo18800a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7565a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2287, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f7569e != null) {
            this.f7569e.setEnabled(z);
        }
    }
}
