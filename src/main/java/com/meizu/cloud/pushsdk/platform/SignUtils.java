package com.meizu.cloud.pushsdk.platform;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

public class SignUtils {
    public static String getSignature(Map<String, String> map, String str) {
        Set<Map.Entry> entrySet = new TreeMap(map).entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : entrySet) {
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append((String) entry.getValue());
        }
        sb.append(str);
        return parseStrToMd5L32(sb.toString());
    }

    public static String parseStrToMd5L32(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
