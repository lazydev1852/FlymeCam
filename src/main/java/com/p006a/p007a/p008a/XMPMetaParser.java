package com.p006a.p007a.p008a;

import com.meizu.camera.MeizuCamera;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.p010b.ParseOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* renamed from: com.a.a.a.n */
public class XMPMetaParser {

    /* renamed from: a */
    private static final Object f76a = new Object();

    /* renamed from: b */
    private static DocumentBuilderFactory f77b = m159a();

    /* renamed from: a */
    public static XMPMeta m158a(Object obj, ParseOptions cVar) throws XMPException {
        ParameterAsserts.m64a(obj);
        if (cVar == null) {
            cVar = new ParseOptions();
        }
        Object[] a = m164a(m165b(obj, cVar), cVar.mo7622a(), new Object[3]);
        if (a == null || a[1] != f76a) {
            return new XMPMetaImpl();
        }
        XMPMetaImpl a2 = ParseRDF.m71a((Node) a[0]);
        a2.mo7527a((String) a[2]);
        return !cVar.mo7626g() ? XMPNormalizer.m231a(a2, cVar) : a2;
    }

    /* renamed from: b */
    private static Document m165b(Object obj, ParseOptions cVar) throws XMPException {
        if (obj instanceof InputStream) {
            return m161a((InputStream) obj, cVar);
        }
        if (obj instanceof byte[]) {
            return m160a(new ByteBuffer((byte[]) obj), cVar);
        }
        return m162a((String) obj, cVar);
    }

    /* renamed from: a */
    private static Document m161a(InputStream inputStream, ParseOptions cVar) throws XMPException {
        if (!cVar.mo7625d() && !cVar.mo7624c()) {
            return m163a(new InputSource(inputStream));
        }
        try {
            return m160a(new ByteBuffer(inputStream), cVar);
        } catch (IOException e) {
            throw new XMPException("Error reading the XML-file", MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, e);
        }
    }

    /* renamed from: a */
    private static Document m160a(ByteBuffer bVar, ParseOptions cVar) throws XMPException {
        try {
            return m163a(new InputSource(bVar.mo7500a()));
        } catch (XMPException e) {
            if (e.mo7671a() == 201 || e.mo7671a() == 204) {
                if (cVar.mo7625d()) {
                    bVar = Latin1Converter.m62a(bVar);
                }
                if (!cVar.mo7624c()) {
                    return m163a(new InputSource(bVar.mo7500a()));
                }
                try {
                    return m163a(new InputSource(new FixASCIIControlsReader(new InputStreamReader(bVar.mo7500a(), bVar.mo7505c()))));
                } catch (UnsupportedEncodingException unused) {
                    throw new XMPException("Unsupported Encoding", 9, e);
                }
            } else {
                throw e;
            }
        }
    }

    /* renamed from: a */
    private static Document m162a(String str, ParseOptions cVar) throws XMPException {
        try {
            return m163a(new InputSource(new StringReader(str)));
        } catch (XMPException e) {
            if (e.mo7671a() == 201 && cVar.mo7624c()) {
                return m163a(new InputSource(new FixASCIIControlsReader(new StringReader(str))));
            }
            throw e;
        }
    }

    /* renamed from: a */
    private static Document m163a(InputSource inputSource) throws XMPException {
        try {
            DocumentBuilder newDocumentBuilder = f77b.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler((ErrorHandler) null);
            return newDocumentBuilder.parse(inputSource);
        } catch (SAXException e) {
            throw new XMPException("XML parsing failure", 201, e);
        } catch (ParserConfigurationException e2) {
            throw new XMPException("XML Parser not correctly configured", 0, e2);
        } catch (IOException e3) {
            throw new XMPException("Error reading the XML-file", MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, e3);
        }
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.Object[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object[] m164a(org.w3c.dom.Node r7, boolean r8, java.lang.Object[] r9) {
        /*
            org.w3c.dom.NodeList r7 = r7.getChildNodes()
            r0 = 0
            r1 = 0
        L_0x0006:
            int r2 = r7.getLength()
            if (r1 >= r2) goto L_0x0084
            org.w3c.dom.Node r2 = r7.item(r1)
            short r3 = r2.getNodeType()
            r4 = 7
            if (r4 != r3) goto L_0x002c
            r3 = r2
            org.w3c.dom.ProcessingInstruction r3 = (org.w3c.dom.ProcessingInstruction) r3
            java.lang.String r5 = r3.getTarget()
            java.lang.String r6 = "xpacket"
            if (r5 != r6) goto L_0x002c
            if (r9 == 0) goto L_0x0081
            r2 = 2
            java.lang.String r3 = r3.getData()
            r9[r2] = r3
            goto L_0x0081
        L_0x002c:
            r3 = 3
            short r5 = r2.getNodeType()
            if (r3 == r5) goto L_0x0081
            short r3 = r2.getNodeType()
            if (r4 == r3) goto L_0x0081
            java.lang.String r3 = r2.getNamespaceURI()
            java.lang.String r4 = r2.getLocalName()
            java.lang.String r5 = "xmpmeta"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0051
            java.lang.String r5 = "xapmeta"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x005e
        L_0x0051:
            java.lang.String r5 = "adobe:ns:meta/"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x005e
            java.lang.Object[] r7 = m164a(r2, r0, r9)
            return r7
        L_0x005e:
            if (r8 != 0) goto L_0x007a
            java.lang.String r5 = "RDF"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x007a
            if (r9 == 0) goto L_0x0079
            r9[r0] = r2
            java.lang.Object r7 = f76a
            r8 = 1
            r9[r8] = r7
        L_0x0079:
            return r9
        L_0x007a:
            java.lang.Object[] r2 = m164a(r2, r8, r9)
            if (r2 == 0) goto L_0x0081
            return r2
        L_0x0081:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0084:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p006a.p007a.p008a.XMPMetaParser.m164a(org.w3c.dom.Node, boolean, java.lang.Object[]):java.lang.Object[]");
    }

    /* renamed from: a */
    private static DocumentBuilderFactory m159a() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        newInstance.setIgnoringComments(true);
        try {
            newInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
        } catch (Exception unused) {
        }
        return newInstance;
    }
}
