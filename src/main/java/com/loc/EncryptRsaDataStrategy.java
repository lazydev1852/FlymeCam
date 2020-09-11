package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.loc.az */
public final class EncryptRsaDataStrategy extends UpdateDataStrategy {

    /* renamed from: a */
    private EncryptProcessor f2625a = new RSAAESEncryptProcessor();

    public EncryptRsaDataStrategy() {
    }

    public EncryptRsaDataStrategy(UpdateDataStrategy beVar) {
        super(beVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo13039a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f2625a.mo12961a(bArr);
    }
}
