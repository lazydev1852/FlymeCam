package com.baidu.p020ar.license;

/* renamed from: com.baidu.ar.license.ArsdkLicense */
public class ArsdkLicense {
    static {
        System.loadLibrary("arlicense");
    }

    public static native boolean checkLocalAuth(Object obj);
}
