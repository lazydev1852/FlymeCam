package org.p113a.p114a.p115a.p117b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;
import org.p113a.p114a.p115a.p116a.C3571a;
import org.p113a.p114a.p115a.p116a.C3572b;

/* renamed from: org.a.a.a.b.a */
public class C3573a {
    /* renamed from: a */
    public static MessageDigest m21777a() {
        return m21778a(MessageDigestAlgorithms.MD5);
    }

    /* renamed from: a */
    public static MessageDigest m21778a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public static byte[] m21779a(byte[] bArr) {
        return m21777a().digest(bArr);
    }

    /* renamed from: b */
    public static byte[] m21780b(String str) {
        return m21779a(C3572b.m21775a(str));
    }

    /* renamed from: c */
    public static String m21781c(String str) {
        return C3571a.m21774b(m21780b(str));
    }
}
