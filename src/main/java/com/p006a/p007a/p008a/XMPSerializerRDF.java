package com.p006a.p007a.p008a;

import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.XMPSchemaRegistry;
import com.p006a.p007a.p010b.SerializeOptions;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.a.a.a.t */
public class XMPSerializerRDF {

    /* renamed from: a */
    static final Set f102a = new HashSet(Arrays.asList(new String[]{"xml:lang", "rdf:resource", "rdf:ID", "rdf:bagID", "rdf:nodeID"}));

    /* renamed from: b */
    private XMPMetaImpl f103b;

    /* renamed from: c */
    private CountOutputStream f104c;

    /* renamed from: d */
    private OutputStreamWriter f105d;

    /* renamed from: e */
    private SerializeOptions f106e;

    /* renamed from: f */
    private int f107f = 1;

    /* renamed from: g */
    private int f108g;

    /* renamed from: a */
    public void mo7606a(XMPMeta dVar, OutputStream outputStream, SerializeOptions eVar) throws XMPException {
        try {
            this.f104c = new CountOutputStream(outputStream);
            this.f105d = new OutputStreamWriter(this.f104c, eVar.mo7670p());
            this.f103b = (XMPMetaImpl) dVar;
            this.f106e = eVar;
            this.f108g = eVar.mo7668n();
            this.f105d = new OutputStreamWriter(this.f104c, eVar.mo7670p());
            mo7605a();
            String b = m267b();
            this.f105d.flush();
            m256a(b.length());
            m261a(b);
            this.f105d.flush();
            this.f104c.close();
        } catch (IOException unused) {
            throw new XMPException("Error writing to the OutputStream", 0);
        }
    }

    /* renamed from: a */
    private void m256a(int i) throws XMPException, IOException {
        if (this.f106e.mo7661g()) {
            int a = this.f104c.mo7506a() + (i * this.f107f);
            if (a <= this.f108g) {
                this.f108g -= a;
            } else {
                throw new XMPException("Can't fit into specified packet size", 107);
            }
        }
        this.f108g /= this.f107f;
        int length = this.f106e.mo7667m().length();
        if (this.f108g >= length) {
            this.f108g -= length;
            while (true) {
                int i2 = length + 100;
                if (this.f108g >= i2) {
                    m257a(100, ' ');
                    m278f();
                    this.f108g -= i2;
                } else {
                    m257a(this.f108g, ' ');
                    m278f();
                    return;
                }
            }
        } else {
            m257a(this.f108g, ' ');
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7605a() throws XMPException {
        if (this.f106e.mo7663i() || this.f106e.mo7664j()) {
            this.f107f = 2;
        }
        if (this.f106e.mo7661g()) {
            if (this.f106e.mo7652a() || this.f106e.mo7659d()) {
                throw new XMPException("Inconsistent options for exact size serialize", 103);
            } else if ((this.f106e.mo7668n() & (this.f107f - 1)) != 0) {
                throw new XMPException("Exact size must be a multiple of the Unicode element", 103);
            }
        } else if (this.f106e.mo7655b()) {
            if (!this.f106e.mo7652a() && !this.f106e.mo7659d()) {
                this.f108g = 0;
                return;
            }
            throw new XMPException("Inconsistent options for read-only packet", 103);
        } else if (!this.f106e.mo7652a()) {
            if (this.f108g == 0) {
                this.f108g = this.f107f * 2048;
            }
            if (this.f106e.mo7659d() && !this.f103b.mo7542c("http://ns.adobe.com/xap/1.0/", "Thumbnails")) {
                this.f108g += this.f107f * ComponentMessageType.MSG_TYPE_ON_SHAKE;
            }
        } else if (!this.f106e.mo7659d()) {
            this.f108g = 0;
        } else {
            throw new XMPException("Inconsistent options for non-packet serialize", 103);
        }
    }

    /* renamed from: b */
    private String m267b() throws IOException, XMPException {
        if (!this.f106e.mo7652a()) {
            m268b(0);
            m261a("<?xpacket begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>");
            m278f();
        }
        m268b(0);
        m261a("<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"");
        if (!this.f106e.mo7669o()) {
            m261a(XMPMetaFactory.m371c().mo7672a());
        }
        m261a("\">");
        m278f();
        m268b(1);
        m261a("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">");
        m278f();
        if (this.f106e.mo7656c()) {
            m277e();
        } else {
            m272c();
        }
        m268b(1);
        m261a("</rdf:RDF>");
        m278f();
        m268b(0);
        m261a("</x:xmpmeta>");
        m278f();
        String str = "";
        if (this.f106e.mo7652a()) {
            return str;
        }
        for (int k = this.f106e.mo7665k(); k > 0; k--) {
            str = str + this.f106e.mo7666l();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str + "<?xpacket end=\"");
        sb.append(this.f106e.mo7655b() ? 'r' : 'w');
        return sb.toString() + "\"?>";
    }

    /* renamed from: c */
    private void m272c() throws IOException, XMPException {
        if (this.f103b.mo7537b().mo7574e() > 0) {
            Iterator i = this.f103b.mo7537b().mo7580i();
            while (i.hasNext()) {
                m269b((XMPNode) i.next());
            }
            return;
        }
        m268b(2);
        m261a("<rdf:Description rdf:about=");
        m276d();
        m261a("/>");
        m278f();
    }

    /* renamed from: d */
    private void m276d() throws IOException {
        m273c(34);
        String l = this.f103b.mo7537b().mo7583l();
        if (l != null) {
            m263a(l, true);
        }
        m273c(34);
    }

    /* renamed from: e */
    private void m277e() throws IOException, XMPException {
        m268b(2);
        m261a("<rdf:Description rdf:about=");
        m276d();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        Iterator i = this.f103b.mo7537b().mo7580i();
        while (i.hasNext()) {
            m259a((XMPNode) i.next(), (Set) hashSet, 4);
        }
        boolean z = true;
        Iterator i2 = this.f103b.mo7537b().mo7580i();
        while (i2.hasNext()) {
            z &= m264a((XMPNode) i2.next(), 3);
        }
        if (!z) {
            m273c(62);
            m278f();
            Iterator i3 = this.f103b.mo7537b().mo7580i();
            while (i3.hasNext()) {
                m270b((XMPNode) i3.next(), 3);
            }
            m268b(2);
            m261a("</rdf:Description>");
            m278f();
            return;
        }
        m261a("/>");
        m278f();
    }

    /* renamed from: a */
    private boolean m264a(XMPNode oVar, int i) throws IOException {
        Iterator i2 = oVar.mo7580i();
        boolean z = true;
        while (i2.hasNext()) {
            XMPNode oVar2 = (XMPNode) i2.next();
            if (m275c(oVar2)) {
                m278f();
                m268b(i);
                m261a(oVar2.mo7583l());
                m261a("=\"");
                m263a(oVar2.mo7584m(), true);
                m273c(34);
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0004 A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m270b(com.p006a.p007a.p008a.XMPNode r11, int r12) throws java.io.IOException, com.p006a.p007a.XMPException {
        /*
            r10 = this;
            java.util.Iterator r11 = r11.mo7580i()
        L_0x0004:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00cc
            java.lang.Object r0 = r11.next()
            com.a.a.a.o r0 = (com.p006a.p007a.p008a.XMPNode) r0
            boolean r1 = r10.m275c((com.p006a.p007a.p008a.XMPNode) r0)
            if (r1 == 0) goto L_0x0017
            goto L_0x0004
        L_0x0017:
            java.lang.String r1 = r0.mo7583l()
            java.lang.String r2 = "[]"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0025
            java.lang.String r1 = "rdf:li"
        L_0x0025:
            r10.m268b((int) r12)
            r2 = 60
            r10.m273c((int) r2)
            r10.m261a((java.lang.String) r1)
            java.util.Iterator r2 = r0.mo7582k()
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0037:
            boolean r6 = r2.hasNext()
            r7 = 1
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r2.next()
            com.a.a.a.o r6 = (com.p006a.p007a.p008a.XMPNode) r6
            java.util.Set r8 = f102a
            java.lang.String r9 = r6.mo7583l()
            boolean r8 = r8.contains(r9)
            if (r8 != 0) goto L_0x0052
            r4 = 1
            goto L_0x0037
        L_0x0052:
            java.lang.String r5 = "rdf:resource"
            java.lang.String r8 = r6.mo7583l()
            boolean r5 = r5.equals(r8)
            r8 = 32
            r10.m273c((int) r8)
            java.lang.String r8 = r6.mo7583l()
            r10.m261a((java.lang.String) r8)
            java.lang.String r8 = "=\""
            r10.m261a((java.lang.String) r8)
            java.lang.String r6 = r6.mo7584m()
            r10.m263a((java.lang.String) r6, (boolean) r7)
            r6 = 34
            r10.m273c((int) r6)
            goto L_0x0037
        L_0x007a:
            if (r4 == 0) goto L_0x0080
            r10.m258a((int) r12, (com.p006a.p007a.p008a.XMPNode) r0)
            goto L_0x00ad
        L_0x0080:
            com.a.a.b.d r2 = r0.mo7585n()
            boolean r2 = r2.mo7648l()
            if (r2 != 0) goto L_0x00a0
            java.lang.Object[] r0 = r10.m266a((com.p006a.p007a.p008a.XMPNode) r0)
            r2 = r0[r3]
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r0 = r0[r7]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r7 = r0.booleanValue()
            r0 = r2
            goto L_0x00b3
        L_0x00a0:
            com.a.a.b.d r2 = r0.mo7585n()
            boolean r2 = r2.mo7639g()
            if (r2 == 0) goto L_0x00af
            r10.m274c(r0, r12)
        L_0x00ad:
            r0 = 1
            goto L_0x00b3
        L_0x00af:
            boolean r0 = r10.m265a((com.p006a.p007a.p008a.XMPNode) r0, (int) r12, (boolean) r5)
        L_0x00b3:
            if (r0 == 0) goto L_0x0004
            if (r7 == 0) goto L_0x00ba
            r10.m268b((int) r12)
        L_0x00ba:
            java.lang.String r0 = "</"
            r10.m261a((java.lang.String) r0)
            r10.m261a((java.lang.String) r1)
            r0 = 62
            r10.m273c((int) r0)
            r10.m278f()
            goto L_0x0004
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p006a.p007a.p008a.XMPSerializerRDF.m270b(com.a.a.a.o, int):void");
    }

    /* renamed from: a */
    private Object[] m266a(XMPNode oVar) throws IOException {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.TRUE;
        if (oVar.mo7585n().mo7629a()) {
            m261a(" rdf:resource=\"");
            m263a(oVar.mo7584m(), true);
            m261a("\"/>");
            m278f();
            bool = Boolean.FALSE;
        } else if (oVar.mo7584m() == null || oVar.mo7584m().length() == 0) {
            m261a("/>");
            m278f();
            bool = Boolean.FALSE;
        } else {
            m273c(62);
            m263a(oVar.mo7584m(), false);
            bool2 = Boolean.FALSE;
        }
        return new Object[]{bool, bool2};
    }

    /* renamed from: c */
    private void m274c(XMPNode oVar, int i) throws IOException, XMPException {
        m273c(62);
        m278f();
        int i2 = i + 1;
        m271b(oVar, true, i2);
        if (oVar.mo7585n().mo7645j()) {
            XMPNodeUtils.m225b(oVar);
        }
        m270b(oVar, i + 2);
        m271b(oVar, false, i2);
    }

    /* renamed from: a */
    private boolean m265a(XMPNode oVar, int i, boolean z) throws XMPException, IOException {
        Iterator i2 = oVar.mo7580i();
        boolean z2 = false;
        boolean z3 = false;
        while (i2.hasNext()) {
            if (m275c((XMPNode) i2.next())) {
                z2 = true;
            } else {
                z3 = true;
            }
            if (z2 && z3) {
                break;
            }
        }
        if (z && z3) {
            throw new XMPException("Can't mix rdf:resource qualifier and element fields", 202);
        } else if (!oVar.mo7579h()) {
            m261a(" rdf:parseType=\"Resource\"/>");
            m278f();
            return false;
        } else if (!z3) {
            m264a(oVar, i + 1);
            m261a("/>");
            m278f();
            return false;
        } else {
            if (!z2) {
                m261a(" rdf:parseType=\"Resource\">");
                m278f();
                m270b(oVar, i + 1);
            } else {
                m273c(62);
                m278f();
                int i3 = i + 1;
                m268b(i3);
                m261a("<rdf:Description");
                m264a(oVar, i + 2);
                m261a(">");
                m278f();
                m270b(oVar, i3);
                m268b(i3);
                m261a("</rdf:Description>");
                m278f();
            }
            return true;
        }
    }

    /* renamed from: a */
    private void m258a(int i, XMPNode oVar) throws IOException, XMPException {
        m261a(" rdf:parseType=\"Resource\">");
        m278f();
        int i2 = i + 1;
        m260a(oVar, true, i2);
        Iterator k = oVar.mo7582k();
        while (k.hasNext()) {
            m260a((XMPNode) k.next(), false, i2);
        }
    }

    /* renamed from: b */
    private void m269b(XMPNode oVar) throws IOException, XMPException {
        m268b(2);
        m261a("<rdf:Description rdf:about=");
        m276d();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        m259a(oVar, (Set) hashSet, 4);
        m273c(62);
        m278f();
        Iterator i = oVar.mo7580i();
        while (i.hasNext()) {
            m260a((XMPNode) i.next(), false, 3);
        }
        m268b(2);
        m261a("</rdf:Description>");
        m278f();
    }

    /* renamed from: a */
    private void m259a(XMPNode oVar, Set set, int i) throws IOException {
        if (oVar.mo7585n().mo7647k()) {
            m262a(oVar.mo7584m().substring(0, oVar.mo7584m().length() - 1), oVar.mo7583l(), set, i);
        } else if (oVar.mo7585n().mo7635d()) {
            Iterator i2 = oVar.mo7580i();
            while (i2.hasNext()) {
                m262a(((XMPNode) i2.next()).mo7583l(), (String) null, set, i);
            }
        }
        Iterator i3 = oVar.mo7580i();
        while (i3.hasNext()) {
            m259a((XMPNode) i3.next(), set, i);
        }
        Iterator k = oVar.mo7582k();
        while (k.hasNext()) {
            XMPNode oVar2 = (XMPNode) k.next();
            m262a(oVar2.mo7583l(), (String) null, set, i);
            m259a(oVar2, set, i);
        }
    }

    /* renamed from: a */
    private void m262a(String str, String str2, Set set, int i) throws IOException {
        if (str2 == null) {
            QName jVar = new QName(str);
            if (jVar.mo7518a()) {
                str = jVar.mo7519b();
                XMPSchemaRegistry a = XMPMetaFactory.m367a();
                str2 = a.mo7598b(str + SystemInfoUtil.COLON);
                m262a(str, str2, set, i);
            } else {
                return;
            }
        }
        if (!set.contains(str)) {
            m278f();
            m268b(i);
            m261a("xmlns:");
            m261a(str);
            m261a("=\"");
            m261a(str2);
            m273c(34);
            set.add(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m260a(com.p006a.p007a.p008a.XMPNode r12, boolean r13, int r14) throws java.io.IOException, com.p006a.p007a.XMPException {
        /*
            r11 = this;
            java.lang.String r0 = r12.mo7583l()
            if (r13 == 0) goto L_0x0009
            java.lang.String r0 = "rdf:value"
            goto L_0x0013
        L_0x0009:
            java.lang.String r1 = "[]"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0013
            java.lang.String r0 = "rdf:li"
        L_0x0013:
            r11.m268b((int) r14)
            r1 = 60
            r11.m273c((int) r1)
            r11.m261a((java.lang.String) r0)
            java.util.Iterator r1 = r12.mo7582k()
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0025:
            boolean r5 = r1.hasNext()
            r6 = 34
            r7 = 32
            r8 = 1
            if (r5 == 0) goto L_0x006a
            java.lang.Object r5 = r1.next()
            com.a.a.a.o r5 = (com.p006a.p007a.p008a.XMPNode) r5
            java.util.Set r9 = f102a
            java.lang.String r10 = r5.mo7583l()
            boolean r9 = r9.contains(r10)
            if (r9 != 0) goto L_0x0044
            r3 = 1
            goto L_0x0025
        L_0x0044:
            java.lang.String r4 = "rdf:resource"
            java.lang.String r9 = r5.mo7583l()
            boolean r4 = r4.equals(r9)
            if (r13 != 0) goto L_0x0025
            r11.m273c((int) r7)
            java.lang.String r7 = r5.mo7583l()
            r11.m261a((java.lang.String) r7)
            java.lang.String r7 = "=\""
            r11.m261a((java.lang.String) r7)
            java.lang.String r5 = r5.mo7584m()
            r11.m263a((java.lang.String) r5, (boolean) r8)
            r11.m273c((int) r6)
            goto L_0x0025
        L_0x006a:
            r1 = 202(0xca, float:2.83E-43)
            r5 = 62
            if (r3 == 0) goto L_0x00a9
            if (r13 != 0) goto L_0x00a9
            if (r4 != 0) goto L_0x00a1
            java.lang.String r13 = " rdf:parseType=\"Resource\">"
            r11.m261a((java.lang.String) r13)
            r11.m278f()
            int r13 = r14 + 1
            r11.m260a((com.p006a.p007a.p008a.XMPNode) r12, (boolean) r8, (int) r13)
            java.util.Iterator r12 = r12.mo7582k()
        L_0x0085:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0169
            java.lang.Object r1 = r12.next()
            com.a.a.a.o r1 = (com.p006a.p007a.p008a.XMPNode) r1
            java.util.Set r3 = f102a
            java.lang.String r4 = r1.mo7583l()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x0085
            r11.m260a((com.p006a.p007a.p008a.XMPNode) r1, (boolean) r2, (int) r13)
            goto L_0x0085
        L_0x00a1:
            com.a.a.c r12 = new com.a.a.c
            java.lang.String r13 = "Can't mix rdf:resource and general qualifiers"
            r12.<init>(r13, r1)
            throw r12
        L_0x00a9:
            com.a.a.b.d r13 = r12.mo7585n()
            boolean r13 = r13.mo7648l()
            if (r13 != 0) goto L_0x00fe
            com.a.a.b.d r13 = r12.mo7585n()
            boolean r13 = r13.mo7629a()
            if (r13 == 0) goto L_0x00d3
            java.lang.String r13 = " rdf:resource=\""
            r11.m261a((java.lang.String) r13)
            java.lang.String r12 = r12.mo7584m()
            r11.m263a((java.lang.String) r12, (boolean) r8)
            java.lang.String r12 = "\"/>"
            r11.m261a((java.lang.String) r12)
            r11.m278f()
            goto L_0x01b3
        L_0x00d3:
            java.lang.String r13 = r12.mo7584m()
            if (r13 == 0) goto L_0x00f4
            java.lang.String r13 = ""
            java.lang.String r1 = r12.mo7584m()
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x00e6
            goto L_0x00f4
        L_0x00e6:
            r11.m273c((int) r5)
            java.lang.String r12 = r12.mo7584m()
            r11.m263a((java.lang.String) r12, (boolean) r2)
            r2 = 1
            r8 = 0
            goto L_0x01b3
        L_0x00f4:
            java.lang.String r12 = "/>"
            r11.m261a((java.lang.String) r12)
            r11.m278f()
            goto L_0x01b3
        L_0x00fe:
            com.a.a.b.d r13 = r12.mo7585n()
            boolean r13 = r13.mo7639g()
            if (r13 == 0) goto L_0x013a
            r11.m273c((int) r5)
            r11.m278f()
            int r13 = r14 + 1
            r11.m271b(r12, r8, r13)
            com.a.a.b.d r1 = r12.mo7585n()
            boolean r1 = r1.mo7645j()
            if (r1 == 0) goto L_0x0120
            com.p006a.p007a.p008a.XMPNodeUtils.m225b(r12)
        L_0x0120:
            java.util.Iterator r1 = r12.mo7580i()
        L_0x0124:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0136
            java.lang.Object r3 = r1.next()
            com.a.a.a.o r3 = (com.p006a.p007a.p008a.XMPNode) r3
            int r4 = r14 + 2
            r11.m260a((com.p006a.p007a.p008a.XMPNode) r3, (boolean) r2, (int) r4)
            goto L_0x0124
        L_0x0136:
            r11.m271b(r12, r2, r13)
            goto L_0x0169
        L_0x013a:
            if (r4 != 0) goto L_0x016b
            boolean r13 = r12.mo7579h()
            if (r13 != 0) goto L_0x014b
            java.lang.String r12 = " rdf:parseType=\"Resource\"/>"
            r11.m261a((java.lang.String) r12)
            r11.m278f()
            goto L_0x01b3
        L_0x014b:
            java.lang.String r13 = " rdf:parseType=\"Resource\">"
            r11.m261a((java.lang.String) r13)
            r11.m278f()
            java.util.Iterator r12 = r12.mo7580i()
        L_0x0157:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0169
            java.lang.Object r13 = r12.next()
            com.a.a.a.o r13 = (com.p006a.p007a.p008a.XMPNode) r13
            int r1 = r14 + 1
            r11.m260a((com.p006a.p007a.p008a.XMPNode) r13, (boolean) r2, (int) r1)
            goto L_0x0157
        L_0x0169:
            r2 = 1
            goto L_0x01b3
        L_0x016b:
            java.util.Iterator r12 = r12.mo7580i()
        L_0x016f:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01ab
            java.lang.Object r13 = r12.next()
            com.a.a.a.o r13 = (com.p006a.p007a.p008a.XMPNode) r13
            boolean r3 = r11.m275c((com.p006a.p007a.p008a.XMPNode) r13)
            if (r3 == 0) goto L_0x01a3
            r11.m278f()
            int r3 = r14 + 1
            r11.m268b((int) r3)
            r11.m273c((int) r7)
            java.lang.String r3 = r13.mo7583l()
            r11.m261a((java.lang.String) r3)
            java.lang.String r3 = "=\""
            r11.m261a((java.lang.String) r3)
            java.lang.String r13 = r13.mo7584m()
            r11.m263a((java.lang.String) r13, (boolean) r8)
            r11.m273c((int) r6)
            goto L_0x016f
        L_0x01a3:
            com.a.a.c r12 = new com.a.a.c
            java.lang.String r13 = "Can't mix rdf:resource and complex fields"
            r12.<init>(r13, r1)
            throw r12
        L_0x01ab:
            java.lang.String r12 = "/>"
            r11.m261a((java.lang.String) r12)
            r11.m278f()
        L_0x01b3:
            if (r2 == 0) goto L_0x01c8
            if (r8 == 0) goto L_0x01ba
            r11.m268b((int) r14)
        L_0x01ba:
            java.lang.String r12 = "</"
            r11.m261a((java.lang.String) r12)
            r11.m261a((java.lang.String) r0)
            r11.m273c((int) r5)
            r11.m278f()
        L_0x01c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p006a.p007a.p008a.XMPSerializerRDF.m260a(com.a.a.a.o, boolean, int):void");
    }

    /* renamed from: b */
    private void m271b(XMPNode oVar, boolean z, int i) throws IOException {
        if (z || oVar.mo7579h()) {
            m268b(i);
            m261a(z ? "<rdf:" : "</rdf:");
            if (oVar.mo7585n().mo7643i()) {
                m261a("Alt");
            } else if (oVar.mo7585n().mo7641h()) {
                m261a("Seq");
            } else {
                m261a("Bag");
            }
            if (!z || oVar.mo7579h()) {
                m261a(">");
            } else {
                m261a("/>");
            }
            m278f();
        }
    }

    /* renamed from: a */
    private void m263a(String str, boolean z) throws IOException {
        m261a(Utils.m103a(str, z, true));
    }

    /* renamed from: c */
    private boolean m275c(XMPNode oVar) {
        return !oVar.mo7581j() && !oVar.mo7585n().mo7629a() && !oVar.mo7585n().mo7648l() && !"[]".equals(oVar.mo7583l());
    }

    /* renamed from: b */
    private void m268b(int i) throws IOException {
        for (int k = this.f106e.mo7665k() + i; k > 0; k--) {
            this.f105d.write(this.f106e.mo7666l());
        }
    }

    /* renamed from: c */
    private void m273c(int i) throws IOException {
        this.f105d.write(i);
    }

    /* renamed from: a */
    private void m261a(String str) throws IOException {
        this.f105d.write(str);
    }

    /* renamed from: a */
    private void m257a(int i, char c) throws IOException {
        while (i > 0) {
            this.f105d.write(c);
            i--;
        }
    }

    /* renamed from: f */
    private void m278f() throws IOException {
        this.f105d.write(this.f106e.mo7667m());
    }
}
