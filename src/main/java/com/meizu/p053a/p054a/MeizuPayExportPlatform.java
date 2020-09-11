package com.meizu.p053a.p054a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.meizu.a.a.a */
public class MeizuPayExportPlatform {
    /* renamed from: a */
    public static boolean m4005a(Context context) {
        if (m4003a("", true).resolveActivity(context.getPackageManager()) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m4004a(Activity activity, int i, String str, boolean z) {
        try {
            activity.startActivityForResult(m4003a(str, z), i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static Intent m4003a(String str, boolean z) {
        Intent intent = new Intent("com.meizu.mznfcpay.PAY_CODE_ACTION");
        intent.putExtra("code", str);
        intent.putExtra("is_qr_code", z);
        return intent;
    }
}
