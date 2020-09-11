package com.baidu.p020ar.resloader;

import com.baidu.p020ar.arplay.core.ARPEngine;

/* renamed from: com.baidu.ar.resloader.b */
public class C0879b implements C0886f {

    /* renamed from: a */
    private static boolean f2187a = false;

    /* renamed from: a */
    public boolean mo10342a() {
        return !f2187a;
    }

    /* renamed from: b */
    public String mo10343b() {
        return "libAREngineCpp.so";
    }

    /* renamed from: c */
    public boolean mo10344c() {
        try {
            return ARPEngine.libraryHasLoaded();
        } catch (Throwable unused) {
            return false;
        }
    }
}
