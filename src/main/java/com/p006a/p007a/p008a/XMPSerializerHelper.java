package com.p006a.p007a.p008a;

import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.p010b.SerializeOptions;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* renamed from: com.a.a.a.s */
public class XMPSerializerHelper {
    /* renamed from: a */
    public static void m254a(XMPMetaImpl mVar, OutputStream outputStream, SerializeOptions eVar) throws XMPException {
        if (eVar == null) {
            eVar = new SerializeOptions();
        }
        if (eVar.mo7662h()) {
            mVar.mo7525a();
        }
        new XMPSerializerRDF().mo7606a((XMPMeta) mVar, outputStream, eVar);
    }

    /* renamed from: a */
    public static byte[] m255a(XMPMetaImpl mVar, SerializeOptions eVar) throws XMPException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        m254a(mVar, byteArrayOutputStream, eVar);
        return byteArrayOutputStream.toByteArray();
    }
}
