package com.meizu.media.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.baidu.p020ar.base.MsgField;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class ListPreference extends CameraPreference {

    /* renamed from: c */
    public static ChangeQuickRedirect f6778c;

    /* renamed from: b */
    private final String f6779b;

    /* renamed from: d */
    protected boolean f6780d = false;

    /* renamed from: e */
    private String f6781e;

    /* renamed from: f */
    private final CharSequence[] f6782f;

    /* renamed from: g */
    private CharSequence[] f6783g;

    /* renamed from: h */
    private CharSequence[] f6784h;

    /* renamed from: i */
    private CharSequence[] f6785i;

    /* renamed from: j */
    private CharSequence[] f6786j;

    public ListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, 0, 0);
        String str = (String) CameraUtil.m15830a(obtainStyledAttributes.getString(3));
        if ((DeviceHelper.f13910bJ == CameraController.CameraApi.API1 && "pref_camera_flashmode_key_v1".equals(str)) || (DeviceHelper.f13910bJ == CameraController.CameraApi.API2 && "pref_camera_flashmode_key_v2".equals(str))) {
            str = "pref_camera_flashmode_key";
        }
        this.f6779b = str;
        TypedValue peekValue = obtainStyledAttributes.peekValue(0);
        if (peekValue == null || peekValue.type != 1) {
            this.f6782f = new CharSequence[1];
            this.f6782f[0] = obtainStyledAttributes.getString(0);
        } else {
            this.f6782f = obtainStyledAttributes.getTextArray(0);
        }
        m6604a(obtainStyledAttributes.getTextArray(1));
        m6605b(obtainStyledAttributes.getTextArray(2));
        m6607c(obtainStyledAttributes.getTextArray(1));
        m6608d(obtainStyledAttributes.getTextArray(2));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: h */
    public String mo17822h() {
        return this.f6779b;
    }

    /* renamed from: i */
    public CharSequence[] mo17823i() {
        return this.f6785i;
    }

    /* renamed from: a */
    public void mo17818a(CharSequence charSequence) {
        this.f6782f[0] = charSequence;
    }

    /* renamed from: a */
    private void m6604a(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            charSequenceArr = new CharSequence[0];
        }
        this.f6783g = charSequenceArr;
    }

    /* renamed from: b */
    private void m6605b(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            charSequenceArr = new CharSequence[0];
        }
        this.f6784h = charSequenceArr;
    }

    /* renamed from: c */
    private void m6607c(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            charSequenceArr = new CharSequence[0];
        }
        this.f6785i = charSequenceArr;
    }

    /* renamed from: d */
    private void m6608d(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            charSequenceArr = new CharSequence[0];
        }
        this.f6786j = charSequenceArr;
    }

    /* renamed from: j */
    public String mo17824j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6778c, false, 1101, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (!this.f6780d) {
            this.f6780d = true;
            SharedPreferences b = mo19373b();
            if (b == null) {
                return null;
            }
            this.f6781e = b.getString(this.f6779b, mo17811c());
        }
        return this.f6781e;
    }

    /* renamed from: k */
    public String mo17825k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6778c, false, 1102, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        this.f6781e = mo19373b().getString(this.f6779b, mo17811c());
        return this.f6781e;
    }

    /* renamed from: c */
    private String mo17811c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6778c, false, 1103, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        for (int i = 0; i < this.f6782f.length; i++) {
            for (CharSequence equals : this.f6784h) {
                if (equals.equals(this.f6782f[i])) {
                    return this.f6782f[i].toString();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo17819a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f6778c, false, 1104, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (mo17820b(str) >= 0) {
                this.f6781e = str;
                mo17821c(str);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public void mo17817a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6778c;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1105, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            mo17819a(this.f6786j[i].toString());
        }
    }

    /* renamed from: b */
    public int mo17820b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f6778c, false, 1106, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int length = this.f6786j.length;
        for (int i = 0; i < length; i++) {
            if (CameraUtil.m15862a((Object) this.f6786j[i], (Object) str)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: l */
    public int mo17826l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6778c, false, 1107, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo17820b(mo17824j());
    }

    /* renamed from: c */
    public void mo17821c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f6778c, false, MsgField.MSG_AUTH_FAIL, new Class[]{String.class}, Void.TYPE).isSupported) {
            SharedPreferences.Editor edit = mo19373b().edit();
            edit.putString(this.f6779b, str);
            edit.apply();
        }
    }

    /* renamed from: m */
    public void mo17827m() {
        this.f6780d = false;
    }
}
