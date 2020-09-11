package com.android.p012ex.camera2.portability.p015b;

import com.android.p012ex.camera2.portability.p014a.Log;

/* renamed from: com.android.ex.camera2.portability.b.a */
public final class SystemProperties {

    /* renamed from: a */
    private static final Log.C0440a f283a = new Log.C0440a("SysProps");

    /* renamed from: a */
    public static String m562a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception e) {
            Log.m557a(f283a, "Exception while getting system property: ", e);
            return str2;
        }
    }
}
