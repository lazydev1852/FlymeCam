package com.p006a.p007a;

import com.p006a.p007a.p008a.XMPMetaImpl;
import com.p006a.p007a.p008a.XMPMetaParser;
import com.p006a.p007a.p008a.XMPSchemaRegistryImpl;
import com.p006a.p007a.p008a.XMPSerializerHelper;
import com.p006a.p007a.p010b.ParseOptions;
import com.p006a.p007a.p010b.SerializeOptions;

/* renamed from: com.a.a.e */
public final class XMPMetaFactory {

    /* renamed from: a */
    private static XMPSchemaRegistry f118a = new XMPSchemaRegistryImpl();

    /* renamed from: b */
    private static XMPVersionInfo f119b = null;

    /* renamed from: a */
    public static XMPSchemaRegistry m367a() {
        return f118a;
    }

    /* renamed from: b */
    public static XMPMeta m370b() {
        return new XMPMetaImpl();
    }

    /* renamed from: a */
    public static XMPMeta m365a(byte[] bArr) throws XMPException {
        return m366a(bArr, (ParseOptions) null);
    }

    /* renamed from: a */
    public static XMPMeta m366a(byte[] bArr, ParseOptions cVar) throws XMPException {
        return XMPMetaParser.m158a((Object) bArr, cVar);
    }

    /* renamed from: a */
    public static byte[] m369a(XMPMeta dVar, SerializeOptions eVar) throws XMPException {
        m368a(dVar);
        return XMPSerializerHelper.m255a((XMPMetaImpl) dVar, eVar);
    }

    /* renamed from: a */
    private static void m368a(XMPMeta dVar) {
        if (!(dVar instanceof XMPMetaImpl)) {
            throw new UnsupportedOperationException("The serializing service works onlywith the XMPMeta implementation of this library");
        }
    }

    /* renamed from: c */
    public static synchronized XMPVersionInfo m371c() {
        XMPVersionInfo iVar;
        synchronized (XMPMetaFactory.class) {
            if (f119b == null) {
                try {
                    f119b = new XMPVersionInfo() {
                        /* renamed from: a */
                        public String mo7672a() {
                            return "Adobe XMP Core 5.1.0-jc003";
                        }

                        public String toString() {
                            return "Adobe XMP Core 5.1.0-jc003";
                        }
                    };
                } catch (Throwable th) {
                    System.out.println(th);
                }
            }
            iVar = f119b;
        }
        return iVar;
    }
}
