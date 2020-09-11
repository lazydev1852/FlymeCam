package com.p006a.p007a.p008a.p009a;

import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.p008a.Utils;
import com.p006a.p007a.p011c.XMPAliasInfo;

/* renamed from: com.a.a.a.a.c */
/* compiled from: XMPPathParser */
public final class C0423c {
    /* renamed from: a */
    public static XMPPath m33a(String str, String str2) throws XMPException {
        XMPPathSegment dVar;
        if (str == null || str2 == null) {
            throw new XMPException("Parameter must not be null", 4);
        }
        XMPPath bVar = new XMPPath();
        XMPPathParser aVar = new XMPPathParser();
        aVar.f37a = str2;
        m37a(str, aVar, bVar);
        while (aVar.f41e < str2.length()) {
            aVar.f40d = aVar.f41e;
            m36a(str2, aVar);
            aVar.f41e = aVar.f40d;
            if (str2.charAt(aVar.f40d) != '[') {
                dVar = m34a(aVar);
            } else {
                dVar = m38b(aVar);
            }
            if (dVar.mo7490a() == 1) {
                if (dVar.mo7494b().charAt(0) == '@') {
                    dVar.mo7492a("?" + dVar.mo7494b().substring(1));
                    if (!"?xml:lang".equals(dVar.mo7494b())) {
                        throw new XMPException("Only xml:lang allowed with '@'", 102);
                    }
                }
                if (dVar.mo7494b().charAt(0) == '?') {
                    aVar.f38b++;
                    dVar.mo7491a(2);
                }
                m35a(aVar.f37a.substring(aVar.f38b, aVar.f39c));
            } else if (dVar.mo7490a() != 6) {
                continue;
            } else {
                if (dVar.mo7494b().charAt(1) == '@') {
                    dVar.mo7492a("[?" + dVar.mo7494b().substring(2));
                    if (!dVar.mo7494b().startsWith("[?xml:lang=")) {
                        throw new XMPException("Only xml:lang allowed with '@'", 102);
                    }
                }
                if (dVar.mo7494b().charAt(1) == '?') {
                    aVar.f38b++;
                    dVar.mo7491a(5);
                    m35a(aVar.f37a.substring(aVar.f38b, aVar.f39c));
                }
            }
            bVar.mo7488a(dVar);
        }
        return bVar;
    }

    /* renamed from: a */
    private static void m36a(String str, XMPPathParser aVar) throws XMPException {
        if (str.charAt(aVar.f40d) == '/') {
            aVar.f40d++;
            if (aVar.f40d >= str.length()) {
                throw new XMPException("Empty XMPPath segment", 102);
            }
        }
        if (str.charAt(aVar.f40d) == '*') {
            aVar.f40d++;
            if (aVar.f40d >= str.length() || str.charAt(aVar.f40d) != '[') {
                throw new XMPException("Missing '[' after '*'", 102);
            }
        }
    }

    /* renamed from: a */
    private static XMPPathSegment m34a(XMPPathParser aVar) throws XMPException {
        aVar.f38b = aVar.f40d;
        while (aVar.f41e < aVar.f37a.length() && "/[*".indexOf(aVar.f37a.charAt(aVar.f41e)) < 0) {
            aVar.f41e++;
        }
        aVar.f39c = aVar.f41e;
        if (aVar.f41e != aVar.f40d) {
            return new XMPPathSegment(aVar.f37a.substring(aVar.f40d, aVar.f41e), 1);
        }
        throw new XMPException("Empty XMPPath segment", 102);
    }

    /* renamed from: b */
    private static XMPPathSegment m38b(XMPPathParser aVar) throws XMPException {
        XMPPathSegment dVar;
        aVar.f41e++;
        if ('0' > aVar.f37a.charAt(aVar.f41e) || aVar.f37a.charAt(aVar.f41e) > '9') {
            while (aVar.f41e < aVar.f37a.length() && aVar.f37a.charAt(aVar.f41e) != ']' && aVar.f37a.charAt(aVar.f41e) != '=') {
                aVar.f41e++;
            }
            if (aVar.f41e >= aVar.f37a.length()) {
                throw new XMPException("Missing ']' or '=' for array index", 102);
            } else if (aVar.f37a.charAt(aVar.f41e) != ']') {
                aVar.f38b = aVar.f40d + 1;
                aVar.f39c = aVar.f41e;
                aVar.f41e++;
                char charAt = aVar.f37a.charAt(aVar.f41e);
                if (charAt == '\'' || charAt == '\"') {
                    aVar.f41e++;
                    while (aVar.f41e < aVar.f37a.length()) {
                        if (aVar.f37a.charAt(aVar.f41e) == charAt) {
                            if (aVar.f41e + 1 >= aVar.f37a.length() || aVar.f37a.charAt(aVar.f41e + 1) != charAt) {
                                break;
                            }
                            aVar.f41e++;
                        }
                        aVar.f41e++;
                    }
                    if (aVar.f41e < aVar.f37a.length()) {
                        aVar.f41e++;
                        dVar = new XMPPathSegment((String) null, 6);
                    } else {
                        throw new XMPException("No terminating quote for array selector", 102);
                    }
                } else {
                    throw new XMPException("Invalid quote in array selector", 102);
                }
            } else if ("[last()".equals(aVar.f37a.substring(aVar.f40d, aVar.f41e))) {
                dVar = new XMPPathSegment((String) null, 4);
            } else {
                throw new XMPException("Invalid non-numeric array index", 102);
            }
        } else {
            while (aVar.f41e < aVar.f37a.length() && '0' <= aVar.f37a.charAt(aVar.f41e) && aVar.f37a.charAt(aVar.f41e) <= '9') {
                aVar.f41e++;
            }
            dVar = new XMPPathSegment((String) null, 3);
        }
        if (aVar.f41e >= aVar.f37a.length() || aVar.f37a.charAt(aVar.f41e) != ']') {
            throw new XMPException("Missing ']' for array index", 102);
        }
        aVar.f41e++;
        dVar.mo7492a(aVar.f37a.substring(aVar.f40d, aVar.f41e));
        return dVar;
    }

    /* renamed from: a */
    private static void m37a(String str, XMPPathParser aVar, XMPPath bVar) throws XMPException {
        while (aVar.f41e < aVar.f37a.length() && "/[*".indexOf(aVar.f37a.charAt(aVar.f41e)) < 0) {
            aVar.f41e++;
        }
        if (aVar.f41e != aVar.f40d) {
            String b = m39b(str, aVar.f37a.substring(aVar.f40d, aVar.f41e));
            XMPAliasInfo c = XMPMetaFactory.m367a().mo7599c(b);
            if (c == null) {
                bVar.mo7488a(new XMPPathSegment(str, Integer.MIN_VALUE));
                bVar.mo7488a(new XMPPathSegment(b, 1));
                return;
            }
            bVar.mo7488a(new XMPPathSegment(c.mo7600a(), Integer.MIN_VALUE));
            XMPPathSegment dVar = new XMPPathSegment(m39b(c.mo7600a(), c.mo7602c()), 1);
            dVar.mo7493a(true);
            dVar.mo7495b(c.mo7603d().mo7619f());
            bVar.mo7488a(dVar);
            if (c.mo7603d().mo7611c()) {
                XMPPathSegment dVar2 = new XMPPathSegment("[?xml:lang='x-default']", 5);
                dVar2.mo7493a(true);
                dVar2.mo7495b(c.mo7603d().mo7619f());
                bVar.mo7488a(dVar2);
            } else if (c.mo7603d().mo7610b()) {
                XMPPathSegment dVar3 = new XMPPathSegment("[1]", 3);
                dVar3.mo7493a(true);
                dVar3.mo7495b(c.mo7603d().mo7619f());
                bVar.mo7488a(dVar3);
            }
        } else {
            throw new XMPException("Empty initial XMPPath step", 102);
        }
    }

    /* renamed from: a */
    private static void m35a(String str) throws XMPException {
        int indexOf = str.indexOf(58);
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (Utils.m111e(substring)) {
                if (XMPMetaFactory.m367a().mo7598b(substring) == null) {
                    throw new XMPException("Unknown namespace prefix for qualified name", 102);
                }
                return;
            }
        }
        throw new XMPException("Ill-formed qualified name", 102);
    }

    /* renamed from: b */
    private static void m40b(String str) throws XMPException {
        if (!Utils.m110d(str)) {
            throw new XMPException("Bad XML name", 102);
        }
    }

    /* renamed from: b */
    private static String m39b(String str, String str2) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Schema namespace URI is required", 101);
        } else if (str2.charAt(0) == '?' || str2.charAt(0) == '@') {
            throw new XMPException("Top level name must not be a qualifier", 102);
        } else if (str2.indexOf(47) >= 0 || str2.indexOf(91) >= 0) {
            throw new XMPException("Top level name must be simple", 102);
        } else {
            String a = XMPMetaFactory.m367a().mo7595a(str);
            if (a != null) {
                int indexOf = str2.indexOf(58);
                if (indexOf < 0) {
                    m40b(str2);
                    return a + str2;
                }
                m40b(str2.substring(0, indexOf));
                m40b(str2.substring(indexOf));
                String substring = str2.substring(0, indexOf + 1);
                String a2 = XMPMetaFactory.m367a().mo7595a(str);
                if (a2 == null) {
                    throw new XMPException("Unknown schema namespace prefix", 101);
                } else if (substring.equals(a2)) {
                    return str2;
                } else {
                    throw new XMPException("Schema namespace URI and prefix mismatch", 101);
                }
            } else {
                throw new XMPException("Unregistered schema namespace URI", 101);
            }
        }
    }
}
