package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.loc.be */
public abstract class UpdateDataStrategy {

    /* renamed from: c */
    UpdateDataStrategy f2635c;

    /* renamed from: d */
    byte[] f2636d = null;

    UpdateDataStrategy() {
    }

    UpdateDataStrategy(UpdateDataStrategy beVar) {
        this.f2635c = beVar;
    }

    /* renamed from: a */
    public final byte[] mo13041a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        UpdateDataStrategy beVar = this;
        while (true) {
            byte[] a = beVar.mo13039a(beVar.f2636d);
            if (beVar.f2635c == null) {
                return a;
            }
            beVar.f2635c.f2636d = a;
            beVar = beVar.f2635c;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract byte[] mo13039a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    /* renamed from: b */
    public void mo13040b(byte[] bArr) {
    }
}
