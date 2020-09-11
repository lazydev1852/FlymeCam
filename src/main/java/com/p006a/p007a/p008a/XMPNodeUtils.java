package com.p006a.p007a.p008a;

import com.p006a.p007a.XMPDateTime;
import com.p006a.p007a.XMPDateTimeFactory;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.XMPUtils;
import com.p006a.p007a.p008a.p009a.XMPPath;
import com.p006a.p007a.p008a.p009a.XMPPathSegment;
import com.p006a.p007a.p010b.PropertyOptions;
import java.util.GregorianCalendar;
import java.util.Iterator;

/* renamed from: com.a.a.a.p */
public class XMPNodeUtils {

    /* renamed from: a */
    static final /* synthetic */ boolean f91a = (!XMPNodeUtils.class.desiredAssertionStatus());

    private XMPNodeUtils() {
    }

    /* renamed from: a */
    static XMPNode m218a(XMPNode oVar, String str, boolean z) throws XMPException {
        return m217a(oVar, str, (String) null, z);
    }

    /* renamed from: a */
    static XMPNode m217a(XMPNode oVar, String str, String str2, boolean z) throws XMPException {
        if (f91a || oVar.mo7557b() == null) {
            XMPNode a = oVar.mo7551a(str);
            if (a == null && z) {
                a = new XMPNode(str, new PropertyOptions().mo7646k(true));
                a.mo7556a(true);
                String a2 = XMPMetaFactory.m367a().mo7595a(str);
                if (a2 == null) {
                    if (str2 == null || str2.length() == 0) {
                        throw new XMPException("Unregistered schema namespace URI", 101);
                    }
                    a2 = XMPMetaFactory.m367a().mo7596a(str, str2);
                }
                a.mo7572d(a2);
                oVar.mo7554a(a);
            }
            return a;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    static XMPNode m224b(XMPNode oVar, String str, boolean z) throws XMPException {
        if (!oVar.mo7585n().mo7647k() && !oVar.mo7585n().mo7635d()) {
            if (!oVar.mo7586o()) {
                throw new XMPException("Named children only allowed for schemas and structs", 102);
            } else if (oVar.mo7585n().mo7639g()) {
                throw new XMPException("Named children not allowed for arrays", 102);
            } else if (z) {
                oVar.mo7585n().mo7637f(true);
            }
        }
        XMPNode a = oVar.mo7551a(str);
        if (a == null && z) {
            XMPNode oVar2 = new XMPNode(str, new PropertyOptions());
            oVar2.mo7556a(true);
            oVar.mo7554a(oVar2);
            a = oVar2;
        }
        if (f91a || a != null || !z) {
            return a;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    static XMPNode m215a(XMPNode oVar, XMPPath bVar, boolean z, PropertyOptions dVar) throws XMPException {
        XMPNode oVar2;
        if (bVar == null || bVar.mo7486a() == 0) {
            throw new XMPException("Empty XMPPath", 102);
        }
        XMPNode a = m218a(oVar, bVar.mo7487a(0).mo7494b(), z);
        if (a == null) {
            return null;
        }
        if (a.mo7586o()) {
            a.mo7556a(false);
            oVar2 = a;
        } else {
            oVar2 = null;
        }
        XMPNode oVar3 = oVar2;
        XMPNode oVar4 = a;
        int i = 1;
        while (i < bVar.mo7486a()) {
            try {
                oVar4 = m216a(oVar4, bVar.mo7487a(i), z);
                if (oVar4 == null) {
                    if (z) {
                        m221a(oVar3);
                    }
                    return null;
                }
                if (oVar4.mo7586o()) {
                    oVar4.mo7556a(false);
                    if (i == 1 && bVar.mo7487a(i).mo7496c() && bVar.mo7487a(i).mo7497d() != 0) {
                        oVar4.mo7585n().mo7614a(bVar.mo7487a(i).mo7497d(), true);
                    } else if (i < bVar.mo7486a() - 1 && bVar.mo7487a(i).mo7490a() == 1 && !oVar4.mo7585n().mo7648l()) {
                        oVar4.mo7585n().mo7637f(true);
                    }
                    if (oVar3 == null) {
                        oVar3 = oVar4;
                    }
                }
                i++;
            } catch (XMPException e) {
                if (oVar3 != null) {
                    m221a(oVar3);
                }
                throw e;
            }
        }
        if (oVar3 != null) {
            oVar4.mo7585n().mo7628a(dVar);
            oVar4.mo7555a(oVar4.mo7585n());
        }
        return oVar4;
    }

    /* renamed from: a */
    static void m221a(XMPNode oVar) {
        XMPNode b = oVar.mo7557b();
        if (oVar.mo7585n().mo7631b()) {
            b.mo7571d(oVar);
        } else {
            b.mo7561b(oVar);
        }
        if (!b.mo7579h() && b.mo7585n().mo7647k()) {
            b.mo7557b().mo7561b(b);
        }
    }

    /* renamed from: a */
    static void m222a(XMPNode oVar, Object obj) {
        String a = m220a(obj);
        if (!oVar.mo7585n().mo7631b() || !"xml:lang".equals(oVar.mo7583l())) {
            oVar.mo7572d(a);
        } else {
            oVar.mo7572d(Utils.m102a(a));
        }
    }

    /* renamed from: a */
    static PropertyOptions m219a(PropertyOptions dVar, Object obj) throws XMPException {
        if (dVar == null) {
            dVar = new PropertyOptions();
        }
        if (dVar.mo7645j()) {
            dVar.mo7642i(true);
        }
        if (dVar.mo7643i()) {
            dVar.mo7640h(true);
        }
        if (dVar.mo7641h()) {
            dVar.mo7638g(true);
        }
        if (!dVar.mo7648l() || obj == null || obj.toString().length() <= 0) {
            dVar.mo7617c(dVar.mo7619f());
            return dVar;
        }
        throw new XMPException("Structs and arrays can't have values", 103);
    }

    /* renamed from: a */
    static String m220a(Object obj) {
        String str;
        if (obj == null) {
            str = null;
        } else if (obj instanceof Boolean) {
            str = XMPUtils.m385a(((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            str = XMPUtils.m382a(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            str = XMPUtils.m383a(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            str = XMPUtils.m381a(((Double) obj).doubleValue());
        } else if (obj instanceof XMPDateTime) {
            str = XMPUtils.m384a((XMPDateTime) obj);
        } else if (obj instanceof GregorianCalendar) {
            str = XMPUtils.m384a(XMPDateTimeFactory.m281a((GregorianCalendar) obj));
        } else if (obj instanceof byte[]) {
            str = XMPUtils.m386a((byte[]) obj);
        } else {
            str = obj.toString();
        }
        if (str != null) {
            return Utils.m112f(str);
        }
        return null;
    }

    /* renamed from: a */
    private static XMPNode m216a(XMPNode oVar, XMPPathSegment dVar, boolean z) throws XMPException {
        int i;
        int a = dVar.mo7490a();
        if (a == 1) {
            return m224b(oVar, dVar.mo7494b(), z);
        }
        if (a == 2) {
            return m228c(oVar, dVar.mo7494b().substring(1), z);
        }
        if (oVar.mo7585n().mo7639g()) {
            if (a == 3) {
                i = m230d(oVar, dVar.mo7494b(), z);
            } else if (a == 4) {
                i = oVar.mo7574e();
            } else if (a == 6) {
                String[] b = Utils.m107b(dVar.mo7494b());
                i = m227c(oVar, b[0], b[1]);
            } else if (a == 5) {
                String[] b2 = Utils.m107b(dVar.mo7494b());
                i = m214a(oVar, b2[0], b2[1], dVar.mo7497d());
            } else {
                throw new XMPException("Unknown array indexing step in FollowXPathStep", 9);
            }
            if (1 > i || i > oVar.mo7574e()) {
                return null;
            }
            return oVar.mo7550a(i);
        }
        throw new XMPException("Indexing applied to non-array", 102);
    }

    /* renamed from: c */
    private static XMPNode m228c(XMPNode oVar, String str, boolean z) throws XMPException {
        if (f91a || !str.startsWith("?")) {
            XMPNode b = oVar.mo7558b(str);
            if (b != null || !z) {
                return b;
            }
            XMPNode oVar2 = new XMPNode(str, (PropertyOptions) null);
            oVar2.mo7556a(true);
            oVar.mo7565c(oVar2);
            return oVar2;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    private static int m230d(XMPNode oVar, String str, boolean z) throws XMPException {
        try {
            int parseInt = Integer.parseInt(str.substring(1, str.length() - 1));
            if (parseInt >= 1) {
                if (z && parseInt == oVar.mo7574e() + 1) {
                    XMPNode oVar2 = new XMPNode("[]", (PropertyOptions) null);
                    oVar2.mo7556a(true);
                    oVar.mo7554a(oVar2);
                }
                return parseInt;
            }
            throw new XMPException("Array index must be larger than zero", 102);
        } catch (NumberFormatException unused) {
            throw new XMPException("Array index not digits.", 102);
        }
    }

    /* renamed from: c */
    private static int m227c(XMPNode oVar, String str, String str2) throws XMPException {
        int i = 1;
        int i2 = -1;
        while (i <= oVar.mo7574e() && i2 < 0) {
            XMPNode a = oVar.mo7550a(i);
            if (a.mo7585n().mo7635d()) {
                int i3 = 1;
                while (true) {
                    if (i3 > a.mo7574e()) {
                        break;
                    }
                    XMPNode a2 = a.mo7550a(i3);
                    if (str.equals(a2.mo7583l()) && str2.equals(a2.mo7584m())) {
                        i2 = i;
                        break;
                    }
                    i3++;
                }
                i++;
            } else {
                throw new XMPException("Field selector must be used on array of struct", 102);
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static int m214a(XMPNode oVar, String str, String str2, int i) throws XMPException {
        if ("xml:lang".equals(str)) {
            int a = m213a(oVar, Utils.m102a(str2));
            if (a >= 0 || (i & 4096) <= 0) {
                return a;
            }
            XMPNode oVar2 = new XMPNode("[]", (PropertyOptions) null);
            oVar2.mo7565c(new XMPNode("xml:lang", "x-default", (PropertyOptions) null));
            oVar.mo7553a(1, oVar2);
            return 1;
        }
        for (int i2 = 1; i2 < oVar.mo7574e(); i2++) {
            Iterator k = oVar.mo7550a(i2).mo7582k();
            while (k.hasNext()) {
                XMPNode oVar3 = (XMPNode) k.next();
                if (str.equals(oVar3.mo7583l()) && str2.equals(oVar3.mo7584m())) {
                    return i2;
                }
            }
        }
        return -1;
    }

    /* renamed from: b */
    static void m225b(XMPNode oVar) {
        if (oVar.mo7585n().mo7645j()) {
            int i = 2;
            while (i <= oVar.mo7574e()) {
                XMPNode a = oVar.mo7550a(i);
                if (!a.mo7581j() || !"x-default".equals(a.mo7563c(1).mo7584m())) {
                    i++;
                } else {
                    try {
                        oVar.mo7559b(i);
                        oVar.mo7553a(1, a);
                    } catch (XMPException unused) {
                        if (!f91a) {
                            throw new AssertionError();
                        }
                    }
                    if (i == 2) {
                        oVar.mo7550a(2).mo7572d(a.mo7584m());
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    static void m229c(XMPNode oVar) {
        if (oVar.mo7585n().mo7643i() && oVar.mo7579h()) {
            boolean z = false;
            Iterator i = oVar.mo7580i();
            while (true) {
                if (i.hasNext()) {
                    if (((XMPNode) i.next()).mo7585n().mo7633c()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                oVar.mo7585n().mo7644j(true);
                m225b(oVar);
            }
        }
    }

    /* renamed from: a */
    static void m223a(XMPNode oVar, String str, String str2) throws XMPException {
        XMPNode oVar2 = new XMPNode("[]", str2, (PropertyOptions) null);
        XMPNode oVar3 = new XMPNode("xml:lang", str, (PropertyOptions) null);
        oVar2.mo7565c(oVar3);
        if (!"x-default".equals(oVar3.mo7584m())) {
            oVar.mo7554a(oVar2);
        } else {
            oVar.mo7553a(1, oVar2);
        }
    }

    /* renamed from: b */
    static Object[] m226b(XMPNode oVar, String str, String str2) throws XMPException {
        if (!oVar.mo7585n().mo7645j()) {
            throw new XMPException("Localized text array is not alt-text", 102);
        } else if (!oVar.mo7579h()) {
            return new Object[]{new Integer(0), null};
        } else {
            Iterator i = oVar.mo7580i();
            XMPNode oVar2 = null;
            XMPNode oVar3 = null;
            int i2 = 0;
            while (i.hasNext()) {
                XMPNode oVar4 = (XMPNode) i.next();
                if (oVar4.mo7585n().mo7648l()) {
                    throw new XMPException("Alt-text array item is not simple", 102);
                } else if (!oVar4.mo7581j() || !"xml:lang".equals(oVar4.mo7563c(1).mo7583l())) {
                    throw new XMPException("Alt-text array item has no language qualifier", 102);
                } else {
                    String m = oVar4.mo7563c(1).mo7584m();
                    if (str2.equals(m)) {
                        return new Object[]{new Integer(1), oVar4};
                    } else if (str != null && m.startsWith(str)) {
                        if (oVar2 == null) {
                            oVar2 = oVar4;
                        }
                        i2++;
                    } else if ("x-default".equals(m)) {
                        oVar3 = oVar4;
                    }
                }
            }
            if (i2 == 1) {
                return new Object[]{new Integer(2), oVar2};
            } else if (i2 > 1) {
                return new Object[]{new Integer(3), oVar2};
            } else if (oVar3 != null) {
                return new Object[]{new Integer(4), oVar3};
            } else {
                return new Object[]{new Integer(5), oVar.mo7550a(1)};
            }
        }
    }

    /* renamed from: a */
    static int m213a(XMPNode oVar, String str) throws XMPException {
        if (oVar.mo7585n().mo7639g()) {
            for (int i = 1; i <= oVar.mo7574e(); i++) {
                XMPNode a = oVar.mo7550a(i);
                if (a.mo7581j() && "xml:lang".equals(a.mo7563c(1).mo7583l()) && str.equals(a.mo7563c(1).mo7584m())) {
                    return i;
                }
            }
            return -1;
        }
        throw new XMPException("Language item must be used on array", 102);
    }
}
