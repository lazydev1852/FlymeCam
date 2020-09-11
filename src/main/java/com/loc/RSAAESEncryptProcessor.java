package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.loc.d */
public final class RSAAESEncryptProcessor extends EncryptProcessor {
    public RSAAESEncryptProcessor() {
    }

    public RSAAESEncryptProcessor(EncryptProcessor aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final byte[] mo12962b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return C1102dd.m3739a(bArr);
    }
}
