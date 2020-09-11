package com.baidu.p020ar.util;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.baidu.ar.util.RSAEncrypt */
public class RSAEncrypt {
    public static String encrypt(String str, String str2) {
        if (str == null) {
            return null;
        }
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2))));
        return new String(Base64.encode(instance.doFinal(str.getBytes(Charset.forName(IoUtils.UTF_8)))));
    }
}
