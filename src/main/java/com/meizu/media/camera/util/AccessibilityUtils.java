package com.meizu.media.camera.util;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.util.a */
public class AccessibilityUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f14059a;

    /* renamed from: a */
    public static void m15931a(View view, CharSequence charSequence) {
        Class[] clsArr = {View.class, CharSequence.class};
        if (PatchProxy.proxy(new Object[]{view, charSequence}, (Object) null, f14059a, true, 7723, clsArr, Void.TYPE).isSupported || view == null) {
            return;
        }
        if (ApiHelper.f14202c) {
            view.announceForAccessibility(charSequence);
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(64);
            new AccessibilityRecordCompat(obtain).setSource(view);
            obtain.setClassName(view.getClass().getName());
            obtain.setPackageName(view.getContext().getPackageName());
            obtain.setEnabled(view.isEnabled());
            obtain.getText().add(charSequence);
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }
}
