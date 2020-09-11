package com.meizu.statsapp.p081v3.lib.plugin.secure;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.secure.SimpleCryptoAES */
public class SimpleCryptoAES {
    private static final int IV_SIZE = 16;
    private static final int KEY_SIZE = 32;
    private static SimpleCryptoAES instance;
    private static final Object lock = new Object();
    private final String PREFERENCE_SIMPLE_CRYPTO_AES_KEY_FILE = "com.meizu.statsapp.v3.simple_crypto_AES";
    private Context context;

    /* renamed from: iv */
    private byte[] f15997iv;
    private byte[] salt;

    private SimpleCryptoAES(Context context2) {
        this.context = context2;
        this.salt = readFromPreferenceOrCreateRandom("salt", 32);
        this.f15997iv = readFromPreferenceOrCreateRandom("iv", 16);
    }

    public static void init(Context context2) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new SimpleCryptoAES(context2);
                }
            }
        }
    }

    public static SimpleCryptoAES get() {
        if (instance != null) {
            return instance;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    public String encrypt(String str, String str2, int i) throws Exception {
        if (i == 1) {
            SecretKey derivesKeyWithSHA1PRNG = derivesKeyWithSHA1PRNG(str.getBytes());
            Cipher instance2 = Cipher.getInstance("AES");
            instance2.init(1, derivesKeyWithSHA1PRNG);
            return toHex(instance2.doFinal(str2.getBytes()));
        } else if (i != 2) {
            return null;
        } else {
            Cipher instance3 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance3.init(1, deriveKeySecurely(str, 32), new IvParameterSpec(this.f15997iv));
            return toHex(instance3.doFinal(str2.getBytes()));
        }
    }

    public String decrypt(String str, String str2, int i) throws Exception {
        if (i == 1) {
            SecretKey derivesKeyWithSHA1PRNG = derivesKeyWithSHA1PRNG(str.getBytes());
            Cipher instance2 = Cipher.getInstance("AES");
            instance2.init(2, derivesKeyWithSHA1PRNG);
            return new String(instance2.doFinal(toByte(str2)));
        } else if (i != 2) {
            return null;
        } else {
            Cipher instance3 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance3.init(2, deriveKeySecurely(str, 32), new IvParameterSpec(this.f15997iv));
            return new String(instance3.doFinal(toByte(str2)));
        }
    }

    private static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append("0123456789ABCDEF".charAt((bArr[i] >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(bArr[i] & 15));
        }
        return stringBuffer.toString();
    }

    private static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    private static byte[] deriveRawKeyWithSHA1PRNG(byte[] bArr) throws Exception {
        KeyGenerator instance2 = KeyGenerator.getInstance("AES");
        SecureRandom instance3 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance3.setSeed(bArr);
        instance2.init(128, instance3);
        return instance2.generateKey().getEncoded();
    }

    private static SecretKey derivesKeyWithSHA1PRNG(byte[] bArr) throws Exception {
        KeyGenerator instance2 = KeyGenerator.getInstance("AES");
        SecureRandom instance3 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance3.setSeed(bArr);
        instance2.init(128, instance3);
        return instance2.generateKey();
    }

    @TargetApi(19)
    private static SecretKey deriveKeyInsecurely(String str, int i) {
        return new SecretKeySpec(InsecureSHA1PRNGKeyDerivator.deriveInsecureKey(str.getBytes(StandardCharsets.UTF_8), i), "AES");
    }

    private SecretKey deriveKeySecurely(String str, int i) {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), this.salt, 100, i * 8)).getEncoded(), "AES");
        } catch (Exception e) {
            throw new RuntimeException("Deal with exceptions properly!", e);
        }
    }

    private byte[] readFromPreferenceOrCreateRandom(String str, int i) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("com.meizu.statsapp.v3.simple_crypto_AES", 0);
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
        edit.commit();
        return bArr;
    }
}
