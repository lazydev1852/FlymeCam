package com.meizu.media.camera.views;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.Nullable;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BasePreferenceFragment extends PreferenceFragment {

    /* renamed from: a */
    public static ChangeQuickRedirect f14439a;

    /* renamed from: b */
    private final int f14440b;

    /* renamed from: c */
    private ArrayList<Preference> f14441c = new ArrayList<>();

    /* renamed from: a */
    public abstract void mo22800a(Activity activity);

    public BasePreferenceFragment(int i) {
        this.f14440b = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ChangeQuickRedirect changeQuickRedirect = f14439a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{layoutInflater, viewGroup, bundle}, this, changeQuickRedirect, false, 8289, new Class[]{LayoutInflater.class, ViewGroup.class, Bundle.class}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (onCreateView == null) {
            return null;
        }
        ListView listView = (ListView) onCreateView.findViewById(16908298);
        listView.setPadding(listView.getPaddingLeft(), CameraUtil.m15907m() + CameraUtil.m15906l(), listView.getPaddingRight(), listView.getPaddingBottom());
        listView.setClipToPadding(false);
        listView.setScrollBarStyle(0);
        addPreferencesFromResource(this.f14440b);
        return onCreateView;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f14439a, false, 8290, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            super.onActivityCreated(bundle);
            mo22800a(getActivity());
        }
    }

    /* renamed from: a */
    public Preference mo22799a(String str, Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        ChangeQuickRedirect changeQuickRedirect = f14439a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, onPreferenceChangeListener}, this, changeQuickRedirect, false, 8291, new Class[]{String.class, Preference.OnPreferenceChangeListener.class}, Preference.class);
        if (proxy.isSupported) {
            return (Preference) proxy.result;
        }
        Preference findPreference = findPreference(str);
        if (!(findPreference == null || onPreferenceChangeListener == null)) {
            findPreference.setOnPreferenceChangeListener(onPreferenceChangeListener);
            this.f14441c.add(findPreference);
        }
        return findPreference;
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f14439a, false, 8292, new Class[0], Void.TYPE).isSupported) {
            super.onDestroy();
            if (!this.f14441c.isEmpty()) {
                Iterator<Preference> it = this.f14441c.iterator();
                while (it.hasNext()) {
                    it.next().setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener) null);
                }
            }
        }
    }
}
