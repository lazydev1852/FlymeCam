package com.p006a.p007a;

import com.p006a.p007a.p008a.p009a.C0423c;
import com.p006a.p007a.p008a.p009a.XMPPath;

/* renamed from: com.a.a.f */
public final class XMPPathFactory {
    /* renamed from: a */
    public static String m373a(String str, int i) throws XMPException {
        if (i > 0) {
            return str + '[' + i + ']';
        } else if (i == -1) {
            return str + "[last()]";
        } else {
            throw new XMPException("Array index must be larger than zero", 104);
        }
    }

    /* renamed from: a */
    public static String m374a(String str, String str2) throws XMPException {
        m375a(str);
        m376b(str2);
        XMPPath a = C0423c.m33a(str, str2);
        if (a.mo7486a() == 2) {
            return '/' + a.mo7487a(1).mo7494b();
        }
        throw new XMPException("The field name must be simple", 102);
    }

    /* renamed from: a */
    private static void m375a(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty field namespace URI", 101);
        }
    }

    /* renamed from: b */
    private static void m376b(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty f name", 102);
        }
    }
}
