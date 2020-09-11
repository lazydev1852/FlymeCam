package com.p006a.p007a.p008a;

import com.meizu.camera.MeizuCamera;
import com.p006a.p007a.XMPDateTime;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.XMPUtils;
import com.p006a.p007a.p008a.p009a.C0423c;
import com.p006a.p007a.p010b.ParseOptions;
import com.p006a.p007a.p010b.PropertyOptions;
import com.p006a.p007a.p011c.XMPAliasInfo;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.a.a.a.q */
public class XMPNormalizer {

    /* renamed from: a */
    private static Map f92a;

    static {
        m232a();
    }

    /* renamed from: a */
    static XMPMeta m231a(XMPMetaImpl mVar, ParseOptions cVar) throws XMPException {
        XMPNode b = mVar.mo7537b();
        m233a(mVar);
        m236a(b, cVar);
        m234a(b);
        m242e(b);
        return mVar;
    }

    /* renamed from: a */
    private static void m234a(XMPNode oVar) throws XMPException {
        if (oVar.mo7583l() != null && oVar.mo7583l().length() >= 36) {
            String lowerCase = oVar.mo7583l().toLowerCase();
            if (lowerCase.startsWith("uuid:")) {
                lowerCase = lowerCase.substring(5);
            }
            if (Utils.m109c(lowerCase)) {
                XMPNode a = XMPNodeUtils.m215a(oVar, C0423c.m33a("http://ns.adobe.com/xap/1.0/mm/", "InstanceID"), true, (PropertyOptions) null);
                if (a != null) {
                    a.mo7555a((PropertyOptions) null);
                    a.mo7572d("uuid:" + lowerCase);
                    a.mo7570d();
                    a.mo7578g();
                    oVar.mo7566c((String) null);
                    return;
                }
                throw new XMPException("Failure creating xmpMM:InstanceID", 9);
            }
        }
    }

    /* renamed from: a */
    private static void m233a(XMPMetaImpl mVar) throws XMPException {
        XMPNode b;
        XMPNodeUtils.m218a(mVar.mo7537b(), "http://purl.org/dc/elements/1.1/", true);
        Iterator i = mVar.mo7537b().mo7580i();
        while (i.hasNext()) {
            XMPNode oVar = (XMPNode) i.next();
            if ("http://purl.org/dc/elements/1.1/".equals(oVar.mo7583l())) {
                m239b(oVar);
            } else if ("http://ns.adobe.com/exif/1.0/".equals(oVar.mo7583l())) {
                m241d(oVar);
                XMPNode b2 = XMPNodeUtils.m224b(oVar, "exif:UserComment", false);
                if (b2 != null) {
                    m240c(b2);
                }
            } else if ("http://ns.adobe.com/xmp/1.0/DynamicMedia/".equals(oVar.mo7583l())) {
                XMPNode b3 = XMPNodeUtils.m224b(oVar, "xmpDM:copyright", false);
                if (b3 != null) {
                    m237a((XMPMeta) mVar, b3);
                }
            } else if ("http://ns.adobe.com/xap/1.0/rights/".equals(oVar.mo7583l()) && (b = XMPNodeUtils.m224b(oVar, "xmpRights:UsageTerms", false)) != null) {
                m240c(b);
            }
        }
    }

    /* renamed from: b */
    private static void m239b(XMPNode oVar) throws XMPException {
        for (int i = 1; i <= oVar.mo7574e(); i++) {
            XMPNode a = oVar.mo7550a(i);
            PropertyOptions dVar = (PropertyOptions) f92a.get(a.mo7583l());
            if (dVar != null) {
                if (a.mo7585n().mo7649m()) {
                    XMPNode oVar2 = new XMPNode(a.mo7583l(), dVar);
                    a.mo7566c("[]");
                    oVar2.mo7554a(a);
                    oVar.mo7560b(i, oVar2);
                    if (dVar.mo7645j() && !a.mo7585n().mo7633c()) {
                        a.mo7565c(new XMPNode("xml:lang", "x-default", (PropertyOptions) null));
                    }
                } else {
                    a.mo7585n().mo7614a(7680, false);
                    a.mo7585n().mo7628a(dVar);
                    if (dVar.mo7645j()) {
                        m240c(a);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private static void m240c(XMPNode oVar) throws XMPException {
        if (oVar != null && oVar.mo7585n().mo7639g()) {
            oVar.mo7585n().mo7640h(true).mo7642i(true).mo7644j(true);
            Iterator i = oVar.mo7580i();
            while (i.hasNext()) {
                XMPNode oVar2 = (XMPNode) i.next();
                if (oVar2.mo7585n().mo7648l()) {
                    i.remove();
                } else if (!oVar2.mo7585n().mo7633c()) {
                    String m = oVar2.mo7584m();
                    if (m == null || m.length() == 0) {
                        i.remove();
                    } else {
                        oVar2.mo7565c(new XMPNode("xml:lang", "x-repair", (PropertyOptions) null));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m236a(XMPNode oVar, ParseOptions cVar) throws XMPException {
        if (oVar.mo7587p()) {
            oVar.mo7562b(false);
            boolean b = cVar.mo7623b();
            for (XMPNode oVar2 : oVar.mo7591t()) {
                if (oVar2.mo7587p()) {
                    Iterator i = oVar2.mo7580i();
                    while (i.hasNext()) {
                        XMPNode oVar3 = (XMPNode) i.next();
                        if (oVar3.mo7588q()) {
                            oVar3.mo7567c(false);
                            XMPAliasInfo c = XMPMetaFactory.m367a().mo7599c(oVar3.mo7583l());
                            if (c != null) {
                                XMPNode oVar4 = null;
                                XMPNode a = XMPNodeUtils.m217a(oVar, c.mo7600a(), (String) null, true);
                                a.mo7556a(false);
                                XMPNode b2 = XMPNodeUtils.m224b(a, c.mo7601b() + c.mo7602c(), false);
                                if (b2 == null) {
                                    if (c.mo7603d().mo7608a()) {
                                        oVar3.mo7566c(c.mo7601b() + c.mo7602c());
                                        a.mo7554a(oVar3);
                                        i.remove();
                                    } else {
                                        XMPNode oVar5 = new XMPNode(c.mo7601b() + c.mo7602c(), c.mo7603d().mo7612d());
                                        a.mo7554a(oVar5);
                                        m238a(i, oVar3, oVar5);
                                    }
                                } else if (c.mo7603d().mo7608a()) {
                                    if (b) {
                                        m235a(oVar3, b2, true);
                                    }
                                    i.remove();
                                } else {
                                    if (c.mo7603d().mo7611c()) {
                                        int a2 = XMPNodeUtils.m213a(b2, "x-default");
                                        if (a2 != -1) {
                                            oVar4 = b2.mo7550a(a2);
                                        }
                                    } else if (b2.mo7579h()) {
                                        oVar4 = b2.mo7550a(1);
                                    }
                                    if (oVar4 == null) {
                                        m238a(i, oVar3, b2);
                                    } else {
                                        if (b) {
                                            m235a(oVar3, oVar4, true);
                                        }
                                        i.remove();
                                    }
                                }
                            }
                        }
                    }
                    oVar2.mo7562b(false);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m238a(Iterator it, XMPNode oVar, XMPNode oVar2) throws XMPException {
        if (oVar2.mo7585n().mo7645j()) {
            if (!oVar.mo7585n().mo7633c()) {
                oVar.mo7565c(new XMPNode("xml:lang", "x-default", (PropertyOptions) null));
            } else {
                throw new XMPException("Alias to x-default already has a language qualifier", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
            }
        }
        it.remove();
        oVar.mo7566c("[]");
        oVar2.mo7554a(oVar);
    }

    /* renamed from: d */
    private static void m241d(XMPNode oVar) throws XMPException {
        XMPNode b = XMPNodeUtils.m224b(oVar, "exif:GPSTimeStamp", false);
        if (b != null) {
            try {
                XMPDateTime e = XMPUtils.m391e(b.mo7584m());
                if (e.mo7469a() != 0 || e.mo7472b() != 0) {
                    return;
                }
                if (e.mo7474c() == 0) {
                    XMPNode b2 = XMPNodeUtils.m224b(oVar, "exif:DateTimeOriginal", false);
                    if (b2 == null) {
                        b2 = XMPNodeUtils.m224b(oVar, "exif:DateTimeDigitized", false);
                    }
                    XMPDateTime e2 = XMPUtils.m391e(b2.mo7584m());
                    Calendar i = e.mo7485i();
                    i.set(1, e2.mo7469a());
                    i.set(2, e2.mo7472b());
                    i.set(5, e2.mo7474c());
                    b.mo7572d(XMPUtils.m384a((XMPDateTime) new XMPDateTimeImpl(i)));
                }
            } catch (XMPException unused) {
            }
        }
    }

    /* renamed from: e */
    private static void m242e(XMPNode oVar) {
        Iterator i = oVar.mo7580i();
        while (i.hasNext()) {
            if (!((XMPNode) i.next()).mo7579h()) {
                i.remove();
            }
        }
    }

    /* renamed from: a */
    private static void m235a(XMPNode oVar, XMPNode oVar2, boolean z) throws XMPException {
        if (!oVar.mo7584m().equals(oVar2.mo7584m()) || oVar.mo7574e() != oVar2.mo7574e()) {
            throw new XMPException("Mismatch between alias and base nodes", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
        } else if (z || (oVar.mo7583l().equals(oVar2.mo7583l()) && oVar.mo7585n().equals(oVar2.mo7585n()) && oVar.mo7576f() == oVar2.mo7576f())) {
            Iterator i = oVar.mo7580i();
            Iterator i2 = oVar2.mo7580i();
            while (i.hasNext() && i2.hasNext()) {
                m235a((XMPNode) i.next(), (XMPNode) i2.next(), false);
            }
            Iterator k = oVar.mo7582k();
            Iterator k2 = oVar2.mo7582k();
            while (k.hasNext() && k2.hasNext()) {
                m235a((XMPNode) k.next(), (XMPNode) k2.next(), false);
            }
        } else {
            throw new XMPException("Mismatch between alias and base nodes", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
        }
    }

    /* renamed from: a */
    private static void m237a(XMPMeta dVar, XMPNode oVar) {
        try {
            XMPNode a = XMPNodeUtils.m218a(((XMPMetaImpl) dVar).mo7537b(), "http://purl.org/dc/elements/1.1/", true);
            String m = oVar.mo7584m();
            XMPNode b = XMPNodeUtils.m224b(a, "dc:rights", false);
            if (b != null) {
                if (b.mo7579h()) {
                    int a2 = XMPNodeUtils.m213a(b, "x-default");
                    if (a2 < 0) {
                        dVar.mo7533a("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", b.mo7550a(1).mo7584m(), (PropertyOptions) null);
                        a2 = XMPNodeUtils.m213a(b, "x-default");
                    }
                    XMPNode a3 = b.mo7550a(a2);
                    String m2 = a3.mo7584m();
                    int indexOf = m2.indexOf("\n\n");
                    if (indexOf >= 0) {
                        int i = indexOf + 2;
                        if (!m2.substring(i).equals(m)) {
                            a3.mo7572d(m2.substring(0, i) + m);
                        }
                    } else if (!m.equals(m2)) {
                        a3.mo7572d(m2 + "\n\n" + m);
                    }
                    oVar.mo7557b().mo7561b(oVar);
                }
            }
            dVar.mo7533a("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", "\n\n" + m, (PropertyOptions) null);
            oVar.mo7557b().mo7561b(oVar);
        } catch (XMPException unused) {
        }
    }

    /* renamed from: a */
    private static void m232a() {
        f92a = new HashMap();
        PropertyOptions dVar = new PropertyOptions();
        dVar.mo7638g(true);
        f92a.put("dc:contributor", dVar);
        f92a.put("dc:language", dVar);
        f92a.put("dc:publisher", dVar);
        f92a.put("dc:relation", dVar);
        f92a.put("dc:subject", dVar);
        f92a.put("dc:type", dVar);
        PropertyOptions dVar2 = new PropertyOptions();
        dVar2.mo7638g(true);
        dVar2.mo7640h(true);
        f92a.put("dc:creator", dVar2);
        f92a.put("dc:date", dVar2);
        PropertyOptions dVar3 = new PropertyOptions();
        dVar3.mo7638g(true);
        dVar3.mo7640h(true);
        dVar3.mo7642i(true);
        dVar3.mo7644j(true);
        f92a.put("dc:description", dVar3);
        f92a.put("dc:rights", dVar3);
        f92a.put("dc:title", dVar3);
    }
}
