package com.meizu.media.camera;

import android.content.Context;
import android.util.AttributeSet;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Iterator;

public class PreferenceGroup extends CameraPreference {

    /* renamed from: b */
    public static ChangeQuickRedirect f7361b;

    /* renamed from: c */
    private ArrayList<CameraPreference> f7362c = new ArrayList<>();

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public void mo18592a(CameraPreference cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, this, f7361b, false, 2073, new Class[]{CameraPreference.class}, Void.TYPE).isSupported) {
            this.f7362c.add(cVar);
        }
    }

    /* renamed from: a */
    public CameraPreference mo18591a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f7361b, false, 2075, new Class[]{Integer.TYPE}, CameraPreference.class);
        return proxy.isSupported ? (CameraPreference) proxy.result : this.f7362c.get(i);
    }

    /* renamed from: c */
    public int mo18594c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7361b, false, 2076, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f7362c.size();
    }

    /* renamed from: a */
    public ListPreference mo18590a(String str) {
        ListPreference a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7361b, false, 2078, new Class[]{String.class}, ListPreference.class);
        if (proxy.isSupported) {
            return (ListPreference) proxy.result;
        }
        Iterator<CameraPreference> it = this.f7362c.iterator();
        while (it.hasNext()) {
            CameraPreference next = it.next();
            if (next instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) next;
                if (listPreference.mo17822h().equals(str)) {
                    return listPreference;
                }
            } else if ((next instanceof PreferenceGroup) && (a = ((PreferenceGroup) next).mo18590a(str)) != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: b */
    public IconListPreference mo18593b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7361b, false, 2079, new Class[]{String.class}, IconListPreference.class);
        if (proxy.isSupported) {
            return (IconListPreference) proxy.result;
        }
        Iterator<CameraPreference> it = this.f7362c.iterator();
        while (it.hasNext()) {
            CameraPreference next = it.next();
            if (next instanceof IconListPreference) {
                IconListPreference iconListPreference = (IconListPreference) next;
                if (iconListPreference.mo17822h().equals(str)) {
                    return iconListPreference;
                }
            }
        }
        return null;
    }
}
