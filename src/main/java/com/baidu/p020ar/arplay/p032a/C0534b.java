package com.baidu.p020ar.arplay.p032a;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.ar.arplay.a.b */
public class C0534b {

    /* renamed from: a */
    private static int f691a = 1;

    /* renamed from: b */
    private static int f692b = 2;

    /* renamed from: c */
    private static int f693c = 3;

    /* renamed from: d */
    private Map<String, String> f694d = new HashMap();

    /* renamed from: e */
    private Map<String, String> f695e = new HashMap();

    /* renamed from: f */
    private SharedPreferences f696f;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo9047a(int r2, java.lang.String r3) {
        /*
            r1 = this;
            int r0 = f691a
            if (r2 != r0) goto L_0x000d
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f694d
        L_0x0006:
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x002d
        L_0x000d:
            int r0 = f692b
            if (r2 != r0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f695e
            goto L_0x0006
        L_0x0014:
            int r0 = f693c
            if (r2 != r0) goto L_0x002c
            android.content.SharedPreferences r2 = r1.f696f
            if (r2 == 0) goto L_0x0025
            android.content.SharedPreferences r2 = r1.f696f
            java.lang.String r0 = ""
            java.lang.String r2 = r2.getString(r3, r0)
            goto L_0x002d
        L_0x0025:
            java.lang.String r2 = "TAG"
            java.lang.String r3 = "prefs data store is null"
            android.util.Log.e(r2, r3)
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = ""
        L_0x0031:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.p032a.C0534b.mo9047a(int, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public void mo9048a() {
        this.f694d.clear();
    }

    /* renamed from: a */
    public void mo9049a(int i, String str, String str2) {
        Map<String, String> map;
        if (i == f691a) {
            map = this.f694d;
        } else if (i == f692b) {
            map = this.f695e;
        } else if (i != f693c) {
            return;
        } else {
            if (this.f696f != null) {
                this.f696f.edit().putString(str, str2).commit();
                return;
            } else {
                Log.e("TAG", "prefs data store is null");
                return;
            }
        }
        map.put(str, str2);
    }

    /* renamed from: a */
    public void mo9050a(SharedPreferences sharedPreferences) {
        this.f696f = sharedPreferences;
    }
}
