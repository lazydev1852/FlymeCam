package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.loc.a */
public abstract class EncryptProcessor {

    /* renamed from: a */
    EncryptProcessor f2499a;

    EncryptProcessor() {
    }

    EncryptProcessor(EncryptProcessor aVar) {
        this.f2499a = aVar;
    }

    /* renamed from: a */
    public final byte[] mo12961a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        if (this.f2499a != null) {
            bArr = this.f2499a.mo12961a(bArr);
        }
        return mo12962b(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract byte[] mo12962b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
}
