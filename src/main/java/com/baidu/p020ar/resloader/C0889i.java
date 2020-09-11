package com.baidu.p020ar.resloader;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.baidu.ar.resloader.i */
public class C0889i {

    /* renamed from: a */
    private SharedPreferences f2206a;

    public C0889i(Context context) {
        this.f2206a = context.getSharedPreferences("ar_so_info", 0);
    }

    /* renamed from: c */
    private SharedPreferences m2576c() {
        return this.f2206a;
    }

    /* renamed from: a */
    public String mo10576a() {
        return m2576c().getString("so_version", "");
    }

    /* renamed from: a */
    public void mo10577a(String str) {
        m2576c().edit().putString("so_version", str).commit();
    }

    /* renamed from: b */
    public String mo10578b() {
        return m2576c().getString("ar_sdk_version", "");
    }

    /* renamed from: b */
    public void mo10579b(String str) {
        m2576c().edit().putString("ar_sdk_version", str).commit();
    }
}
