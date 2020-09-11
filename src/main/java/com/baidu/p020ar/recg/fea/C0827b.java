package com.baidu.p020ar.recg.fea;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.baidu.ar.recg.fea.b */
public class C0827b {

    /* renamed from: a */
    private final Context f1993a;

    public C0827b(Context context) {
        this.f1993a = context;
    }

    /* renamed from: b */
    private SharedPreferences m2230b() {
        if (this.f1993a == null) {
            return null;
        }
        return this.f1993a.getSharedPreferences("fea_res_info", 0);
    }

    /* renamed from: a */
    public String mo10372a() {
        SharedPreferences b = m2230b();
        return b == null ? "" : b.getString("fea_res_md5", "");
    }

    /* renamed from: a */
    public void mo10373a(String str) {
        SharedPreferences b = m2230b();
        if (b != null && b.edit() != null) {
            b.edit().putString("fea_res_md5", str).apply();
        }
    }
}
