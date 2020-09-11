package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.loc.ba */
public final class HeaderAddStrategy extends UpdateDataStrategy {

    /* renamed from: a */
    private Context f2626a;

    /* renamed from: b */
    private String f2627b;

    /* renamed from: e */
    private EncryptProcessor f2628e;

    /* renamed from: f */
    private Object[] f2629f;

    public HeaderAddStrategy(Context context, UpdateDataStrategy beVar, EncryptProcessor aVar, String str, Object... objArr) {
        super(beVar);
        this.f2626a = context;
        this.f2627b = str;
        this.f2628e = aVar;
        this.f2629f = objArr;
    }

    /* renamed from: b */
    private String m3077b() {
        try {
            return String.format(C1107dj.m3824c(this.f2627b), this.f2629f);
        } catch (Throwable th) {
            th.printStackTrace();
            SDKLogHandler.m3867b(th, "ofm", "gpj");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo13039a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a = C1107dj.m3810a(bArr);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        Context context = this.f2626a;
        String a2 = C1107dj.m3810a(this.f2628e.mo12961a(C1107dj.m3818a(m3077b())));
        return C1107dj.m3818a("{\"pinfo\":\"" + a2 + "\",\"els\":[" + a + "]}");
    }
}
