package com.meizu.media.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.c */
public abstract class CameraPreference {

    /* renamed from: a */
    public static ChangeQuickRedirect f8213a;

    /* renamed from: b */
    private final String f8214b;

    /* renamed from: c */
    private SharedPreferences f8215c;

    /* renamed from: d */
    private final Context f8216d;

    public CameraPreference(Context context, AttributeSet attributeSet) {
        this.f8216d = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraPreference, 0, 0);
        this.f8214b = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public String mo18346a() {
        return this.f8214b;
    }

    /* renamed from: b */
    public SharedPreferences mo19373b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8213a, false, 864, new Class[0], SharedPreferences.class);
        if (proxy.isSupported) {
            return (SharedPreferences) proxy.result;
        }
        if (this.f8215c == null) {
            this.f8215c = ComboPreferences.m10003a(this.f8216d.getApplicationContext());
        }
        return this.f8215c;
    }
}
