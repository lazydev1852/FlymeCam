package com.meizu.cloud.pushsdk.analytics.secure;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpKeyMgr {
    private static final int IV_SIZE = 16;
    private static final int KEY_SIZE = 16;
    private static final String TAG = "HttpKeyMgr";
    private static HttpKeyMgr instance;
    private static final Object lock = new Object();
    private byte[] aKey;
    private byte[] aKey64;

    /* renamed from: iv */
    byte[] f4113iv;
    private long lastResetKeysTime = 0;
    private Context mContext;
    private PublicKey publicKey;
    private byte[] rKey;
    private byte[] rKey64;
    private byte[] sKey64;
    byte[] salt;
    String seedText = "88&*5a9*4&a122ek";
    private SharedPreferences spKey;
    private SharedPreferences spPublicKey;

    private HttpKeyMgr(Context context) {
        this.mContext = context;
        this.spKey = context.getSharedPreferences("com.x.y.1", 0);
        this.spPublicKey = context.getSharedPreferences("com.x.y.2", 0);
        Integer.parseInt(this.spKey.getString("keyTimeout", "0"));
        this.spKey.getLong("createDate", 0);
        loadKeys();
        if (this.rKey == null || (this.rKey != null && this.rKey.length == 0)) {
            this.publicKey = loadPublicKey(this.mContext);
            if (this.publicKey != null) {
                generateKeys();
                return;
            }
            this.spKey.edit().clear().apply();
            try {
                downloadPublicKey();
                this.publicKey = loadPublicKey(this.mContext);
                if (this.publicKey != null) {
                    generateKeys();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (this.aKey == null || (this.aKey != null && this.aKey.length == 0)) {
            this.publicKey = loadPublicKey(this.mContext);
            if (this.publicKey != null) {
                generateAkey();
            }
        }
    }

    public static void init(Context context) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new HttpKeyMgr(context);
                }
            }
        }
    }

    public static HttpKeyMgr get() {
        if (instance != null) {
            return instance;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private PublicKey loadPublicKey(Context context) {
        sLogD("load publicKey from preference");
        String string = this.spPublicKey.getString("publicKey", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 2)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void downloadPublicKey() throws IOException {
        InputStream inputStream;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://norma-external-collect.meizu.com/android/exchange/getpublickey.do").openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            try {
                sLogD("code = " + httpURLConnection.getResponseCode());
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        String stringByInputStream = getStringByInputStream(inputStream);
                        sLogD("body = " + stringByInputStream);
                        JSONObject jSONObject = new JSONObject(stringByInputStream);
                        if (jSONObject.getInt("code") == 200) {
                            String string = jSONObject.getString("value");
                            SharedPreferences.Editor edit = this.spPublicKey.edit();
                            edit.putString("publicKey", string);
                            edit.apply();
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                inputStream = null;
                th = th4;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (MalformedURLException unused3) {
        }
    }

    private void loadKeys() {
        sLogD("loadKeys");
        String string = this.spKey.getString("sKey64", "");
        sLogD("saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.sKey64 = string.getBytes();
        }
        String string2 = this.spKey.getString("aKey64", "");
        sLogD("saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            this.aKey64 = string2.getBytes();
            this.aKey = Base64.decode(this.aKey64, 2);
        }
        String string3 = this.spKey.getString("rKey64", "");
        sLogD("saved rKey64: " + string3);
        if (!TextUtils.isEmpty(string3)) {
            this.rKey64 = string3.getBytes();
            this.rKey = Base64.decode(this.rKey64, 2);
            sLogD("saved rKey: " + new String(this.rKey));
        }
    }

    private void clearKeys() {
        this.rKey = null;
        this.aKey = null;
        this.rKey64 = null;
        this.aKey64 = null;
        this.sKey64 = null;
        SharedPreferences.Editor edit = this.spKey.edit();
        edit.clear();
        edit.apply();
    }

    private void clearPublicKey() {
        SharedPreferences.Editor edit = this.spPublicKey.edit();
        edit.clear();
        edit.apply();
        this.publicKey = null;
    }

    private SecretKey deriveKeySecurely(String str, int i) {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), readFromPreferenceOrCreateRandom("salt", 16), 100, i * 8)).getEncoded(), "AES");
        } catch (Exception e) {
            throw new RuntimeException("Deal with exceptions properly!", e);
        }
    }

    private byte[] readFromPreferenceOrCreateRandom(String str, int i) {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("com.x.y.1", 0);
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            byte[] decode = Base64.decode(string, 2);
            if (decode.length == i) {
                return decode;
            }
        }
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, Base64.encodeToString(bArr, 2));
        edit.apply();
        return bArr;
    }

    private void generateKeys() {
        generateRkey();
        generateAkey();
    }

    private void generateRkey() {
        try {
            KeyGenerator instance2 = KeyGenerator.getInstance("AES");
            instance2.init(128);
            this.rKey = instance2.generateKey().getEncoded();
            this.rKey64 = Base64.encode(this.rKey, 2);
            sLogD("***** rKey64: " + new String(this.rKey64));
            SharedPreferences.Editor edit = this.spKey.edit();
            edit.putString("rKey64", new String(this.rKey64));
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateAkey() {
        try {
            Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance2.init(1, this.publicKey);
            this.aKey = instance2.doFinal(this.rKey);
            this.aKey64 = Base64.encode(this.aKey, 2);
            sLogD("***** aKey64: " + new String(this.aKey64));
            SharedPreferences.Editor edit = this.spKey.edit();
            edit.putString("aKey64", new String(this.aKey64));
            edit.apply();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (InvalidKeyException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getStringByInputStream(java.io.InputStream r4) {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x0005:
            int r1 = r4.read()     // Catch:{ IOException -> 0x001d, all -> 0x0018 }
            r2 = -1
            if (r1 == r2) goto L_0x0010
            r0.write(r1)     // Catch:{ IOException -> 0x001d, all -> 0x0018 }
            goto L_0x0005
        L_0x0010:
            java.lang.String r4 = r0.toString()     // Catch:{ IOException -> 0x001d, all -> 0x0018 }
            r0.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0021
        L_0x0018:
            r4 = move-exception
            r0.close()     // Catch:{ IOException -> 0x001c }
        L_0x001c:
            throw r4
        L_0x001d:
            r0.close()     // Catch:{ IOException -> 0x0020 }
        L_0x0020:
            r4 = 0
        L_0x0021:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.analytics.secure.HttpKeyMgr.getStringByInputStream(java.io.InputStream):java.lang.String");
    }

    public byte[] encrypt(byte[] bArr) {
        if (this.rKey == null || (this.rKey != null && this.rKey.length == 0)) {
            sLogE("rKey null!");
            return null;
        } else if (bArr == null || (bArr != null && bArr.length == 0)) {
            sLogE("input null!");
            return null;
        } else {
            sLogD(">>>>>>>>>> encrypt input >>>>>>>>>>\n" + new String(Base64.encode(bArr, 2)));
            sLogD("<<<<<<<<<< encrypt input <<<<<<<<<<");
            try {
                Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance2.init(1, new SecretKeySpec(this.rKey, "AES"), new IvParameterSpec(this.rKey));
                byte[] doFinal = instance2.doFinal(bArr);
                sLogD(">>>>>>>>>> encrypt output >>>>>>>>>>\n" + new String(Base64.encode(doFinal, 2)));
                sLogD("<<<<<<<<<< encrypt output <<<<<<<<<<");
                return doFinal;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            } catch (InvalidAlgorithmParameterException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    public byte[] decrypt(byte[] bArr) {
        if (this.rKey == null || (this.rKey != null && this.rKey.length == 0)) {
            sLogE("rKey null!");
            return null;
        } else if (bArr == null || (bArr != null && bArr.length == 0)) {
            sLogE("input null!");
            return null;
        } else {
            sLogD(">>>>>>>>>> decrypt input >>>>>>>>>>\n" + new String(Base64.encode(bArr, 0)));
            sLogD("<<<<<<<<<< decrypt input <<<<<<<<<<");
            try {
                Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance2.init(2, new SecretKeySpec(this.rKey, "AES"), new IvParameterSpec(this.rKey));
                byte[] doFinal = instance2.doFinal(bArr);
                sLogD(">>>>>>>>>> decrypt output >>>>>>>>>>\n" + new String(Base64.encode(doFinal, 0)));
                sLogD("<<<<<<<<<< decrypt output <<<<<<<<<<");
                return doFinal;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            } catch (InvalidAlgorithmParameterException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    public void saveSKey(String str) {
        this.sKey64 = str.getBytes();
        SharedPreferences.Editor edit = this.spKey.edit();
        edit.putString("sKey64", new String(this.sKey64));
        edit.apply();
    }

    public void saveKeyTimeout(String str) {
        SharedPreferences.Editor edit = this.spKey.edit();
        edit.putString("keyTimeout", str);
        edit.putLong("createDate", System.currentTimeMillis());
        edit.apply();
    }

    public synchronized void reInitKeys() {
        sLogD("reInitKeys");
        if (this.lastResetKeysTime == 0 || System.currentTimeMillis() - this.lastResetKeysTime > 180000) {
            clearPublicKey();
            clearKeys();
            this.lastResetKeysTime = System.currentTimeMillis();
            try {
                downloadPublicKey();
                this.publicKey = loadPublicKey(this.mContext);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (this.publicKey != null) {
                generateKeys();
            }
        }
    }

    public byte[] getaKey64() {
        return this.aKey64;
    }

    public byte[] getsKey64() {
        return this.sKey64;
    }

    private void sLogD(String str) {
        DebugLogger.m4827d(TAG, str);
    }

    private void sLogE(String str) {
        DebugLogger.m4828e(TAG, str);
    }
}
