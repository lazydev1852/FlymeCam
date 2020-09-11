package com.baidu.p020ar.p035b;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.aip.auth.Auth;
import com.baidu.aip.auth.AuthException;
import com.baidu.p020ar.bean.DuMixARConfig;

/* renamed from: com.baidu.ar.b.a */
public class C0602a {

    /* renamed from: a */
    private static Auth f969a;

    /* renamed from: a */
    public static String m1215a() {
        return ExifInterface.GPS_MEASUREMENT_3D;
    }

    /* renamed from: a */
    public static String m1216a(Context context) {
        try {
            if (f969a == null) {
                f969a = new Auth();
            }
            String token = f969a.getToken(context);
            if (TextUtils.isEmpty(token) || !token.contains("-")) {
                return token;
            }
            String substring = token.substring(0, token.lastIndexOf("-"));
            return substring + "-" + DuMixARConfig.getAipAppId();
        } catch (AuthException unused) {
            return null;
        }
    }
}
