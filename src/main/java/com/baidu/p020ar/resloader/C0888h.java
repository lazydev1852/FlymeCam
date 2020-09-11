package com.baidu.p020ar.resloader;

import android.text.TextUtils;
import com.baidu.p020ar.util.ARLog;
import java.io.File;

/* renamed from: com.baidu.ar.resloader.h */
public class C0888h {
    /* renamed from: a */
    private static String m2571a(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so")) {
            return str.substring("lib".length(), str.lastIndexOf(".so"));
        }
        return null;
    }

    /* renamed from: a */
    public static void m2572a() {
        C0879b bVar = new C0879b();
        if (!bVar.mo10344c()) {
            m2573a((C0886f) bVar);
        }
    }

    /* renamed from: a */
    public static void m2573a(C0886f fVar) {
        String str;
        String a = m2571a(fVar.mo10343b());
        if (TextUtils.isEmpty(a)) {
            str = "[SoLoad] so file name is invalid";
        } else {
            System.loadLibrary(a);
            if (!fVar.mo10344c()) {
                str = "[SoLoad] so load error";
            } else {
                return;
            }
        }
        ARLog.m2696e(str);
    }

    /* renamed from: a */
    public static boolean m2574a(File file) {
        try {
            if (!file.exists()) {
                return false;
            }
            System.load(file.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static void m2575b() {
        C0883d dVar = new C0883d();
        if (!dVar.mo10344c()) {
            m2573a((C0886f) dVar);
        }
    }
}
