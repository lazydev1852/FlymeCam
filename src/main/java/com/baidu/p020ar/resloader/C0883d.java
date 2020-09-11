package com.baidu.p020ar.resloader;

import com.baidu.p020ar.slam.ARSlamJniClient;

/* renamed from: com.baidu.ar.resloader.d */
public class C0883d implements C0886f {

    /* renamed from: a */
    private static boolean f2199a = false;

    /* renamed from: a */
    public boolean mo10342a() {
        return !f2199a;
    }

    /* renamed from: b */
    public String mo10343b() {
        return "libARSlamClient.so";
    }

    /* renamed from: c */
    public boolean mo10344c() {
        try {
            ARSlamJniClient.slamReset();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
