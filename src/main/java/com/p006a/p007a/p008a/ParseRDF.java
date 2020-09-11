package com.p006a.p007a.p008a;

import com.meizu.camera.MeizuCamera;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.XMPSchemaRegistry;
import com.p006a.p007a.p010b.PropertyOptions;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* renamed from: com.a.a.a.h */
public class ParseRDF {

    /* renamed from: a */
    static final /* synthetic */ boolean f55a = (!ParseRDF.class.desiredAssertionStatus());

    /* renamed from: b */
    private static boolean m82b(int i) {
        return 10 <= i && i <= 12;
    }

    /* renamed from: c */
    private static boolean m87c(int i) {
        return 1 <= i && i <= 7;
    }

    /* renamed from: a */
    static XMPMetaImpl m71a(Node node) throws XMPException {
        XMPMetaImpl mVar = new XMPMetaImpl();
        m77a(mVar, node);
        return mVar;
    }

    /* renamed from: a */
    static void m77a(XMPMetaImpl mVar, Node node) throws XMPException {
        if (node.hasAttributes()) {
            m75a(mVar, mVar.mo7537b(), node);
            return;
        }
        throw new XMPException("Invalid attributes of rdf:RDF element", 202);
    }

    /* renamed from: a */
    private static void m75a(XMPMetaImpl mVar, XMPNode oVar, Node node) throws XMPException {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item = node.getChildNodes().item(i);
            if (!m83b(item)) {
                m76a(mVar, oVar, item, true);
            }
        }
    }

    /* renamed from: a */
    private static void m76a(XMPMetaImpl mVar, XMPNode oVar, Node node, boolean z) throws XMPException {
        int c = m84c(node);
        if (c != 8 && c != 0) {
            throw new XMPException("Node element must be rdf:Description or typed node", 202);
        } else if (!z || c != 0) {
            m81b(mVar, oVar, node, z);
            m86c(mVar, oVar, node, z);
        } else {
            throw new XMPException("Top level typed node not allowed", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
        }
    }

    /* renamed from: b */
    private static void m81b(XMPMetaImpl mVar, XMPNode oVar, Node node, boolean z) throws XMPException {
        int i = 0;
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                int c = m84c(item);
                if (c != 0) {
                    if (c != 6) {
                        switch (c) {
                            case 2:
                            case 3:
                                break;
                            default:
                                throw new XMPException("Invalid nodeElement attribute", 202);
                        }
                    }
                    if (i <= 0) {
                        i++;
                        if (z && c == 3) {
                            if (oVar.mo7583l() == null || oVar.mo7583l().length() <= 0) {
                                oVar.mo7566c(item.getNodeValue());
                            } else if (!oVar.mo7583l().equals(item.getNodeValue())) {
                                throw new XMPException("Mismatched top level rdf:about values", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
                            }
                        }
                    } else {
                        throw new XMPException("Mutally exclusive about, ID, nodeID attributes", 202);
                    }
                } else {
                    m72a(mVar, oVar, item, item.getNodeValue(), z);
                }
            }
        }
    }

    /* renamed from: c */
    private static void m86c(XMPMetaImpl mVar, XMPNode oVar, Node node, boolean z) throws XMPException {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item = node.getChildNodes().item(i);
            if (!m83b(item)) {
                if (item.getNodeType() == 1) {
                    m88d(mVar, oVar, item, z);
                } else {
                    throw new XMPException("Expected property element node not found", 202);
                }
            }
        }
    }

    /* renamed from: d */
    private static void m88d(XMPMetaImpl mVar, XMPNode oVar, Node node, boolean z) throws XMPException {
        if (m79a(m84c(node))) {
            NamedNodeMap attributes = node.getAttributes();
            ArrayList<String> arrayList = null;
            for (int i = 0; i < attributes.getLength(); i++) {
                Node item = attributes.item(i);
                if ("xmlns".equals(item.getPrefix()) || (item.getPrefix() == null && "xmlns".equals(item.getNodeName()))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(item.getNodeName());
                }
            }
            if (arrayList != null) {
                for (String removeNamedItem : arrayList) {
                    attributes.removeNamedItem(removeNamedItem);
                }
            }
            if (attributes.getLength() > 3) {
                m92h(mVar, oVar, node, z);
                return;
            }
            int i2 = 0;
            while (i2 < attributes.getLength()) {
                Node item2 = attributes.item(i2);
                String localName = item2.getLocalName();
                String namespaceURI = item2.getNamespaceURI();
                String nodeValue = item2.getNodeValue();
                if ("xml:lang".equals(item2.getNodeName()) && (!"ID".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI))) {
                    i2++;
                } else if ("datatype".equals(localName) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                    m90f(mVar, oVar, node, z);
                    return;
                } else if (!"parseType".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                    m92h(mVar, oVar, node, z);
                    return;
                } else if ("Literal".equals(nodeValue)) {
                    m74a();
                    return;
                } else if ("Resource".equals(nodeValue)) {
                    m91g(mVar, oVar, node, z);
                    return;
                } else if ("Collection".equals(nodeValue)) {
                    m80b();
                    return;
                } else {
                    m85c();
                    return;
                }
            }
            if (node.hasChildNodes()) {
                for (int i3 = 0; i3 < node.getChildNodes().getLength(); i3++) {
                    if (node.getChildNodes().item(i3).getNodeType() != 3) {
                        m89e(mVar, oVar, node, z);
                        return;
                    }
                }
                m90f(mVar, oVar, node, z);
                return;
            }
            m92h(mVar, oVar, node, z);
            return;
        }
        throw new XMPException("Invalid property element name", 202);
    }

    /* renamed from: e */
    private static void m89e(XMPMetaImpl mVar, XMPNode oVar, Node node, boolean z) throws XMPException {
        if (!z || !"iX:changes".equals(node.getNodeName())) {
            XMPNode a = m72a(mVar, oVar, node, "", z);
            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                Node item = node.getAttributes().item(i);
                if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                    String localName = item.getLocalName();
                    String namespaceURI = item.getNamespaceURI();
                    if ("xml:lang".equals(item.getNodeName())) {
                        m73a(a, "xml:lang", item.getNodeValue());
                    } else if (!"ID".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                        throw new XMPException("Invalid attribute for resource property element", 202);
                    }
                }
            }
            boolean z2 = false;
            for (int i2 = 0; i2 < node.getChildNodes().getLength(); i2++) {
                Node item2 = node.getChildNodes().item(i2);
                if (!m83b(item2)) {
                    if (item2.getNodeType() == 1 && !z2) {
                        boolean equals = "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(item2.getNamespaceURI());
                        String localName2 = item2.getLocalName();
                        if (equals && "Bag".equals(localName2)) {
                            a.mo7585n().mo7638g(true);
                        } else if (equals && "Seq".equals(localName2)) {
                            a.mo7585n().mo7638g(true).mo7640h(true);
                        } else if (!equals || !"Alt".equals(localName2)) {
                            a.mo7585n().mo7637f(true);
                            if (!equals && !"Description".equals(localName2)) {
                                String namespaceURI2 = item2.getNamespaceURI();
                                if (namespaceURI2 != null) {
                                    m73a(a, "rdf:type", namespaceURI2 + ':' + localName2);
                                } else {
                                    throw new XMPException("All XML elements must be in a namespace", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
                                }
                            }
                        } else {
                            a.mo7585n().mo7638g(true).mo7640h(true).mo7642i(true);
                        }
                        m76a(mVar, a, item2, false);
                        if (a.mo7589r()) {
                            m78a(a);
                        } else if (a.mo7585n().mo7643i()) {
                            XMPNodeUtils.m229c(a);
                        }
                        z2 = true;
                    } else if (z2) {
                        throw new XMPException("Invalid child of resource property element", 202);
                    } else {
                        throw new XMPException("Children of resource property element must be XML elements", 202);
                    }
                }
            }
            if (!z2) {
                throw new XMPException("Missing child of resource property element", 202);
            }
        }
    }

    /* renamed from: f */
    private static void m90f(XMPMetaImpl mVar, XMPNode oVar, Node node, boolean z) throws XMPException {
        XMPNode a = m72a(mVar, oVar, node, (String) null, z);
        int i = 0;
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String namespaceURI = item.getNamespaceURI();
                String localName = item.getLocalName();
                if ("xml:lang".equals(item.getNodeName())) {
                    m73a(a, "xml:lang", item.getNodeValue());
                } else if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI) || (!"ID".equals(localName) && !"datatype".equals(localName))) {
                    throw new XMPException("Invalid attribute for literal property element", 202);
                }
            }
        }
        String str = "";
        while (i < node.getChildNodes().getLength()) {
            Node item2 = node.getChildNodes().item(i);
            if (item2.getNodeType() == 3) {
                str = str + item2.getNodeValue();
                i++;
            } else {
                throw new XMPException("Invalid child of literal property element", 202);
            }
        }
        a.mo7572d(str);
    }

    /* renamed from: a */
    private static void m74a() throws XMPException {
        throw new XMPException("ParseTypeLiteral property element not allowed", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
    }

    /* renamed from: g */
    private static void m91g(XMPMetaImpl mVar, XMPNode oVar, Node node, boolean z) throws XMPException {
        XMPNode a = m72a(mVar, oVar, node, "", z);
        a.mo7585n().mo7637f(true);
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node item = node.getAttributes().item(i);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String localName = item.getLocalName();
                String namespaceURI = item.getNamespaceURI();
                if ("xml:lang".equals(item.getNodeName())) {
                    m73a(a, "xml:lang", item.getNodeValue());
                } else if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI) || (!"ID".equals(localName) && !"parseType".equals(localName))) {
                    throw new XMPException("Invalid attribute for ParseTypeResource property element", 202);
                }
            }
        }
        m86c(mVar, a, node, false);
        if (a.mo7589r()) {
            m78a(a);
        }
    }

    /* renamed from: b */
    private static void m80b() throws XMPException {
        throw new XMPException("ParseTypeCollection property element not allowed", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
    }

    /* renamed from: c */
    private static void m85c() throws XMPException {
        throw new XMPException("ParseTypeOther property element not allowed", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f0  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m92h(com.p006a.p007a.p008a.XMPMetaImpl r14, com.p006a.p007a.p008a.XMPNode r15, org.w3c.dom.Node r16, boolean r17) throws com.p006a.p007a.XMPException {
        /*
            r0 = r14
            boolean r1 = r16.hasChildNodes()
            r2 = 202(0xca, float:2.83E-43)
            if (r1 != 0) goto L_0x0165
            r1 = 0
            r3 = 0
            r6 = r3
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x0011:
            org.w3c.dom.NamedNodeMap r9 = r16.getAttributes()
            int r9 = r9.getLength()
            r10 = 2
            r11 = 1
            if (r3 >= r9) goto L_0x00b5
            org.w3c.dom.NamedNodeMap r9 = r16.getAttributes()
            org.w3c.dom.Node r9 = r9.item(r3)
            java.lang.String r12 = "xmlns"
            java.lang.String r13 = r9.getPrefix()
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x00b1
            java.lang.String r12 = r9.getPrefix()
            if (r12 != 0) goto L_0x0045
            java.lang.String r12 = "xmlns"
            java.lang.String r13 = r9.getNodeName()
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0045
            goto L_0x00b1
        L_0x0045:
            int r12 = m84c((org.w3c.dom.Node) r9)
            r13 = 203(0xcb, float:2.84E-43)
            if (r12 == 0) goto L_0x007f
            if (r12 == r10) goto L_0x00b1
            switch(r12) {
                case 5: goto L_0x0066;
                case 6: goto L_0x005a;
                default: goto L_0x0052;
            }
        L_0x0052:
            com.a.a.c r0 = new com.a.a.c
            java.lang.String r1 = "Unrecognized attribute of empty property element"
            r0.<init>(r1, r2)
            throw r0
        L_0x005a:
            if (r5 != 0) goto L_0x005e
            r8 = 1
            goto L_0x00b1
        L_0x005e:
            com.a.a.c r0 = new com.a.a.c
            java.lang.String r1 = "Empty property element can't have both rdf:resource and rdf:nodeID"
            r0.<init>(r1, r2)
            throw r0
        L_0x0066:
            if (r8 != 0) goto L_0x0077
            if (r4 != 0) goto L_0x006f
            if (r4 != 0) goto L_0x006d
            r6 = r9
        L_0x006d:
            r5 = 1
            goto L_0x00b1
        L_0x006f:
            com.a.a.c r0 = new com.a.a.c
            java.lang.String r1 = "Empty property element can't have both rdf:value and rdf:resource"
            r0.<init>(r1, r13)
            throw r0
        L_0x0077:
            com.a.a.c r0 = new com.a.a.c
            java.lang.String r1 = "Empty property element can't have both rdf:resource and rdf:nodeID"
            r0.<init>(r1, r2)
            throw r0
        L_0x007f:
            java.lang.String r10 = "value"
            java.lang.String r12 = r9.getLocalName()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x00a4
            java.lang.String r10 = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
            java.lang.String r12 = r9.getNamespaceURI()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x00a4
            if (r5 != 0) goto L_0x009c
            r6 = r9
            r4 = 1
            goto L_0x00b1
        L_0x009c:
            com.a.a.c r0 = new com.a.a.c
            java.lang.String r1 = "Empty property element can't have both rdf:value and rdf:resource"
            r0.<init>(r1, r13)
            throw r0
        L_0x00a4:
            java.lang.String r10 = "xml:lang"
            java.lang.String r9 = r9.getNodeName()
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00b1
            r7 = 1
        L_0x00b1:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x00b5:
            java.lang.String r3 = ""
            r8 = r15
            r9 = r16
            r12 = r17
            com.a.a.a.o r3 = m72a(r14, r15, r9, r3, r12)
            if (r4 != 0) goto L_0x00cf
            if (r5 == 0) goto L_0x00c5
            goto L_0x00cf
        L_0x00c5:
            if (r7 == 0) goto L_0x00e4
            com.a.a.b.d r4 = r3.mo7585n()
            r4.mo7637f(r11)
            goto L_0x00e5
        L_0x00cf:
            if (r6 == 0) goto L_0x00d6
            java.lang.String r5 = r6.getNodeValue()
            goto L_0x00d8
        L_0x00d6:
            java.lang.String r5 = ""
        L_0x00d8:
            r3.mo7572d((java.lang.String) r5)
            if (r4 != 0) goto L_0x00e4
            com.a.a.b.d r4 = r3.mo7585n()
            r4.mo7627a((boolean) r11)
        L_0x00e4:
            r11 = 0
        L_0x00e5:
            r4 = 0
        L_0x00e6:
            org.w3c.dom.NamedNodeMap r5 = r16.getAttributes()
            int r5 = r5.getLength()
            if (r4 >= r5) goto L_0x0164
            org.w3c.dom.NamedNodeMap r5 = r16.getAttributes()
            org.w3c.dom.Node r5 = r5.item(r4)
            if (r5 == r6) goto L_0x0161
            java.lang.String r7 = "xmlns"
            java.lang.String r8 = r5.getPrefix()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0161
            java.lang.String r7 = r5.getPrefix()
            if (r7 != 0) goto L_0x0119
            java.lang.String r7 = "xmlns"
            java.lang.String r8 = r5.getNodeName()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0119
            goto L_0x0161
        L_0x0119:
            int r7 = m84c((org.w3c.dom.Node) r5)
            if (r7 == 0) goto L_0x0136
            if (r7 == r10) goto L_0x0161
            switch(r7) {
                case 5: goto L_0x012c;
                case 6: goto L_0x0161;
                default: goto L_0x0124;
            }
        L_0x0124:
            com.a.a.c r0 = new com.a.a.c
            java.lang.String r1 = "Unrecognized attribute of empty property element"
            r0.<init>(r1, r2)
            throw r0
        L_0x012c:
            java.lang.String r7 = "rdf:resource"
            java.lang.String r5 = r5.getNodeValue()
            m73a((com.p006a.p007a.p008a.XMPNode) r3, (java.lang.String) r7, (java.lang.String) r5)
            goto L_0x0161
        L_0x0136:
            if (r11 != 0) goto L_0x0144
            java.lang.String r7 = r5.getNodeName()
            java.lang.String r5 = r5.getNodeValue()
            m73a((com.p006a.p007a.p008a.XMPNode) r3, (java.lang.String) r7, (java.lang.String) r5)
            goto L_0x0161
        L_0x0144:
            java.lang.String r7 = "xml:lang"
            java.lang.String r8 = r5.getNodeName()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x015a
            java.lang.String r7 = "xml:lang"
            java.lang.String r5 = r5.getNodeValue()
            m73a((com.p006a.p007a.p008a.XMPNode) r3, (java.lang.String) r7, (java.lang.String) r5)
            goto L_0x0161
        L_0x015a:
            java.lang.String r7 = r5.getNodeValue()
            m72a(r14, r3, r5, r7, r1)
        L_0x0161:
            int r4 = r4 + 1
            goto L_0x00e6
        L_0x0164:
            return
        L_0x0165:
            com.a.a.c r0 = new com.a.a.c
            java.lang.String r1 = "Nested content not allowed with rdf:resource or property attributes"
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p006a.p007a.p008a.ParseRDF.m92h(com.a.a.a.m, com.a.a.a.o, org.w3c.dom.Node, boolean):void");
    }

    /* renamed from: a */
    private static XMPNode m72a(XMPMetaImpl mVar, XMPNode oVar, Node node, String str, boolean z) throws XMPException {
        XMPSchemaRegistry a = XMPMetaFactory.m367a();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI != null) {
            if ("http://purl.org/dc/1.1/".equals(namespaceURI)) {
                namespaceURI = "http://purl.org/dc/elements/1.1/";
            }
            String a2 = a.mo7595a(namespaceURI);
            if (a2 == null) {
                a2 = a.mo7596a(namespaceURI, node.getPrefix() != null ? node.getPrefix() : "_dflt");
            }
            String str2 = a2 + node.getLocalName();
            PropertyOptions dVar = new PropertyOptions();
            boolean z2 = false;
            if (z) {
                oVar = XMPNodeUtils.m217a(mVar.mo7537b(), namespaceURI, "_dflt", true);
                oVar.mo7556a(false);
                if (a.mo7599c(str2) != null) {
                    mVar.mo7537b().mo7562b(true);
                    oVar.mo7562b(true);
                    z2 = true;
                }
            }
            boolean equals = "rdf:li".equals(str2);
            boolean equals2 = "rdf:value".equals(str2);
            XMPNode oVar2 = new XMPNode(str2, str, dVar);
            oVar2.mo7567c(z2);
            if (!equals2) {
                oVar.mo7554a(oVar2);
            } else {
                oVar.mo7553a(1, oVar2);
            }
            if (equals2) {
                if (z || !oVar.mo7585n().mo7635d()) {
                    throw new XMPException("Misplaced rdf:value element", 202);
                }
                oVar.mo7573d(true);
            }
            if (equals) {
                if (oVar.mo7585n().mo7639g()) {
                    oVar2.mo7566c("[]");
                } else {
                    throw new XMPException("Misplaced rdf:li element", 202);
                }
            }
            return oVar2;
        }
        throw new XMPException("XML namespace required for all elements and attributes", 202);
    }

    /* renamed from: a */
    private static XMPNode m73a(XMPNode oVar, String str, String str2) throws XMPException {
        if ("xml:lang".equals(str)) {
            str2 = Utils.m102a(str2);
        }
        XMPNode oVar2 = new XMPNode(str, str2, (PropertyOptions) null);
        oVar.mo7565c(oVar2);
        return oVar2;
    }

    /* renamed from: a */
    private static void m78a(XMPNode oVar) throws XMPException {
        if (f55a || (oVar.mo7585n().mo7635d() && oVar.mo7579h())) {
            XMPNode a = oVar.mo7550a(1);
            if (f55a || "rdf:value".equals(a.mo7583l())) {
                if (a.mo7585n().mo7633c()) {
                    if (!oVar.mo7585n().mo7633c()) {
                        XMPNode c = a.mo7563c(1);
                        a.mo7571d(c);
                        oVar.mo7565c(c);
                    } else {
                        throw new XMPException("Redundant xml:lang for rdf:value element", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
                    }
                }
                for (int i = 1; i <= a.mo7576f(); i++) {
                    oVar.mo7565c(a.mo7563c(i));
                }
                for (int i2 = 2; i2 <= oVar.mo7574e(); i2++) {
                    oVar.mo7565c(oVar.mo7550a(i2));
                }
                if (f55a || oVar.mo7585n().mo7635d() || oVar.mo7589r()) {
                    oVar.mo7573d(false);
                    oVar.mo7585n().mo7637f(false);
                    oVar.mo7585n().mo7628a(a.mo7585n());
                    oVar.mo7572d(a.mo7584m());
                    oVar.mo7570d();
                    Iterator i3 = a.mo7580i();
                    while (i3.hasNext()) {
                        oVar.mo7554a((XMPNode) i3.next());
                    }
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private static boolean m83b(Node node) {
        if (node.getNodeType() != 3) {
            return false;
        }
        String nodeValue = node.getNodeValue();
        for (int i = 0; i < nodeValue.length(); i++) {
            if (!Character.isWhitespace(nodeValue.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m79a(int i) {
        if (i == 8 || m82b(i)) {
            return false;
        }
        return !m87c(i);
    }

    /* renamed from: c */
    private static int m84c(Node node) {
        String localName = node.getLocalName();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI == null && (("about".equals(localName) || "ID".equals(localName)) && (node instanceof Attr) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(((Attr) node).getOwnerElement().getNamespaceURI()))) {
            namespaceURI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        }
        if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
            return 0;
        }
        if (AppIconSetting.LARGE_ICON_URL.equals(localName)) {
            return 9;
        }
        if ("parseType".equals(localName)) {
            return 4;
        }
        if ("Description".equals(localName)) {
            return 8;
        }
        if ("about".equals(localName)) {
            return 3;
        }
        if ("resource".equals(localName)) {
            return 5;
        }
        if ("RDF".equals(localName)) {
            return 1;
        }
        if ("ID".equals(localName)) {
            return 2;
        }
        if ("nodeID".equals(localName)) {
            return 6;
        }
        if ("datatype".equals(localName)) {
            return 7;
        }
        if ("aboutEach".equals(localName)) {
            return 10;
        }
        if ("aboutEachPrefix".equals(localName)) {
            return 11;
        }
        return "bagID".equals(localName) ? 12 : 0;
    }
}
