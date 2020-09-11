package com.baidu.p020ar.recorder.p049g;

import java.io.File;

/* renamed from: com.baidu.ar.recorder.g.a */
public class C0871a {

    /* renamed from: a */
    private static final String f2171a = "a";

    /* renamed from: a */
    public static void m2529a(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    /* renamed from: b */
    public static boolean m2530b(String str) {
        return new File(str).delete();
    }
}
