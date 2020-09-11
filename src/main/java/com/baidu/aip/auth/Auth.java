package com.baidu.aip.auth;

import android.content.Context;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.meizu.savior.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONException;
import org.json.JSONObject;

public class Auth {
    private static final String QUERY_TOKEN_AK_SK = "https://verify.baidubce.com/verify/1.0/token/sk?channel=ar";
    private static final String QUERY_TOKEN_BIN = "https://verify.baidubce.com/verify/1.0/token/bin?channel=ar";
    private static final int TYPE_AK_SK = 0;
    private static final int TYPE_LICENSE = 1;
    private static Throwable loadLibException;
    private C0475b mAipTokenListener;
    private String mAk;
    private int mAuthType = 1;
    private long mExpiresTime;
    private String mSk;
    private String mToken = null;

    public Auth() {
        System.loadLibrary("aip-native-auth");
    }

    private static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    private static String getAkSKInitBody(Context context, String str, String str2) {
        String md5 = md5(str2);
        byte[] init = init(context);
        return str + Constants.PACKNAME_END + md5 + Base64.encodeToString(init, 2);
    }

    private static String getBinInitBody(Context context) {
        return Base64.encodeToString(initWithBin(context), 2);
    }

    private static native byte[] init(Context context);

    private static native byte[] initWithBin(Context context);

    private boolean isTokenExpired() {
        return System.currentTimeMillis() > this.mExpiresTime;
    }

    private static String md5(String str) {
        try {
            return byteArrayToHex(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(NotificationCompat.CATEGORY_STATUS)) {
                int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                if (optInt == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        this.mToken = optJSONObject.getString("access_token");
                        this.mExpiresTime = System.currentTimeMillis() + (optJSONObject.optLong("expires_in") * 1000);
                        return;
                    }
                    return;
                }
                String optString = jSONObject.optString("message");
                Long valueOf = Long.valueOf(jSONObject.optLong("log_id"));
                throw new AuthException(optInt, optString + " logId: " + valueOf);
            }
            throw new AuthException(283505, AuthException.f444c);
        } catch (JSONException unused) {
            throw new AuthException(283505, AuthException.f444c);
        }
    }

    public Throwable getLoadLibException() {
        return loadLibException;
    }

    public String getToken(Context context) {
        String str;
        if (!isTokenExpired() && this.mToken != null) {
            return this.mToken;
        }
        String str2 = null;
        if (this.mAuthType == 0) {
            str2 = QUERY_TOKEN_AK_SK;
            str = getAkSKInitBody(context, this.mAk, this.mSk);
        } else {
            str = null;
        }
        if (this.mAuthType == 1) {
            str2 = QUERY_TOKEN_BIN;
            str = getBinInitBody(context);
        }
        parseJson(C0474a.m762a(str2, str));
        return this.mToken;
    }
}
