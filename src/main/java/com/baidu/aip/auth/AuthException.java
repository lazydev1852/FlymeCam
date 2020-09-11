package com.baidu.aip.auth;

import com.meizu.savior.Constants;

public class AuthException extends Throwable {

    /* renamed from: a */
    public static String f442a = "Load jni so library error";

    /* renamed from: b */
    public static String f443b = "network error";

    /* renamed from: c */
    public static String f444c = "token data error";
    private int mErrorCode;
    private String mMessage;

    public AuthException(int i, String str) {
        super(m761a(i, str));
        this.mErrorCode = i;
        this.mMessage = str;
    }

    /* renamed from: a */
    private static String m761a(int i, String str) {
        return Constants.ARRAY_TYPE + i + "] " + str;
    }
}
