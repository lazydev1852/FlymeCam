package com.meizu.media.mzfunnysnapsdk.MZUtil;

import com.meizu.savior.ChangeQuickRedirect;

public enum GlError {
    OK(0, "ok"),
    ConfigErr(101, "config not support");
    
    public static ChangeQuickRedirect changeQuickRedirect;
    int code;
    String msg;

    private GlError(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int value() {
        return this.code;
    }

    public String toString() {
        return this.msg;
    }
}
