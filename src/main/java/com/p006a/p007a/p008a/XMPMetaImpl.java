package com.p006a.p007a.p008a;

import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.XMPPathFactory;
import com.p006a.p007a.XMPUtils;
import com.p006a.p007a.p008a.p009a.C0423c;
import com.p006a.p007a.p010b.PropertyOptions;
import com.p006a.p007a.p011c.XMPProperty;

/* renamed from: com.a.a.a.m */
public class XMPMetaImpl implements XMPMeta {

    /* renamed from: a */
    static final /* synthetic */ boolean f70a = (!XMPMetaImpl.class.desiredAssertionStatus());

    /* renamed from: b */
    private XMPNode f71b;

    /* renamed from: c */
    private String f72c;

    public XMPMetaImpl() {
        this.f72c = null;
        this.f71b = new XMPNode((String) null, (String) null, (PropertyOptions) null);
    }

    public XMPMetaImpl(XMPNode oVar) {
        this.f72c = null;
        this.f71b = oVar;
    }

    /* renamed from: c */
    public boolean mo7542c(String str, String str2) {
        try {
            ParameterAsserts.m67c(str);
            ParameterAsserts.m66b(str2);
            if (XMPNodeUtils.m215a(this.f71b, C0423c.m33a(str, str2), false, (PropertyOptions) null) != null) {
                return true;
            }
            return false;
        } catch (XMPException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public XMPProperty mo7523a(String str, String str2, int i) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m65a(str2);
        return mo7544d(str, XMPPathFactory.m373a(str2, i));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        throw new com.p006a.p007a.XMPException("Language qualifier must be first", 102);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (r3 != false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e4, code lost:
        if (r3 != false) goto L_0x0169;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7533a(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, com.p006a.p007a.p010b.PropertyOptions r12) throws com.p006a.p007a.XMPException {
        /*
            r6 = this;
            com.p006a.p007a.p008a.ParameterAsserts.m67c(r7)
            com.p006a.p007a.p008a.ParameterAsserts.m65a((java.lang.String) r8)
            com.p006a.p007a.p008a.ParameterAsserts.m69e(r10)
            r12 = 0
            if (r9 == 0) goto L_0x0011
            java.lang.String r9 = com.p006a.p007a.p008a.Utils.m102a((java.lang.String) r9)
            goto L_0x0012
        L_0x0011:
            r9 = r12
        L_0x0012:
            java.lang.String r10 = com.p006a.p007a.p008a.Utils.m102a((java.lang.String) r10)
            com.a.a.a.a.b r7 = com.p006a.p007a.p008a.p009a.C0423c.m33a((java.lang.String) r7, (java.lang.String) r8)
            com.a.a.a.o r8 = r6.f71b
            com.a.a.b.d r0 = new com.a.a.b.d
            r1 = 7680(0x1e00, float:1.0762E-41)
            r0.<init>(r1)
            r1 = 1
            com.a.a.a.o r7 = com.p006a.p007a.p008a.XMPNodeUtils.m215a((com.p006a.p007a.p008a.XMPNode) r8, (com.p006a.p007a.p008a.p009a.XMPPath) r7, (boolean) r1, (com.p006a.p007a.p010b.PropertyOptions) r0)
            r8 = 102(0x66, float:1.43E-43)
            if (r7 == 0) goto L_0x0178
            com.a.a.b.d r0 = r7.mo7585n()
            boolean r0 = r0.mo7645j()
            if (r0 != 0) goto L_0x0056
            boolean r0 = r7.mo7579h()
            if (r0 != 0) goto L_0x004e
            com.a.a.b.d r0 = r7.mo7585n()
            boolean r0 = r0.mo7643i()
            if (r0 == 0) goto L_0x004e
            com.a.a.b.d r0 = r7.mo7585n()
            r0.mo7644j(r1)
            goto L_0x0056
        L_0x004e:
            com.a.a.c r7 = new com.a.a.c
            java.lang.String r9 = "Specified property is no alt-text array"
            r7.<init>(r9, r8)
            throw r7
        L_0x0056:
            java.util.Iterator r0 = r7.mo7580i()
        L_0x005a:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0097
            java.lang.Object r2 = r0.next()
            com.a.a.a.o r2 = (com.p006a.p007a.p008a.XMPNode) r2
            boolean r4 = r2.mo7581j()
            if (r4 == 0) goto L_0x008f
            java.lang.String r4 = "xml:lang"
            com.a.a.a.o r5 = r2.mo7563c((int) r1)
            java.lang.String r5 = r5.mo7583l()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008f
            java.lang.String r4 = "x-default"
            com.a.a.a.o r5 = r2.mo7563c((int) r1)
            java.lang.String r5 = r5.mo7584m()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x005a
            r8 = 1
            goto L_0x0099
        L_0x008f:
            com.a.a.c r7 = new com.a.a.c
            java.lang.String r9 = "Language qualifier must be first"
            r7.<init>(r9, r8)
            throw r7
        L_0x0097:
            r2 = r12
            r8 = 0
        L_0x0099:
            if (r2 == 0) goto L_0x00a7
            int r0 = r7.mo7574e()
            if (r0 <= r1) goto L_0x00a7
            r7.mo7561b((com.p006a.p007a.p008a.XMPNode) r2)
            r7.mo7553a((int) r1, (com.p006a.p007a.p008a.XMPNode) r2)
        L_0x00a7:
            java.lang.Object[] r9 = com.p006a.p007a.p008a.XMPNodeUtils.m226b((com.p006a.p007a.p008a.XMPNode) r7, (java.lang.String) r9, (java.lang.String) r10)
            r0 = r9[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r9 = r9[r1]
            com.a.a.a.o r9 = (com.p006a.p007a.p008a.XMPNode) r9
            java.lang.String r3 = "x-default"
            boolean r3 = r3.equals(r10)
            switch(r0) {
                case 0: goto L_0x015f;
                case 1: goto L_0x0104;
                case 2: goto L_0x00e8;
                case 3: goto L_0x00e1;
                case 4: goto L_0x00d1;
                case 5: goto L_0x00ca;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            com.a.a.c r7 = new com.a.a.c
            r8 = 9
            java.lang.String r9 = "Unexpected result from ChooseLocalizedText"
            r7.<init>(r9, r8)
            throw r7
        L_0x00ca:
            com.p006a.p007a.p008a.XMPNodeUtils.m223a((com.p006a.p007a.p008a.XMPNode) r7, (java.lang.String) r10, (java.lang.String) r11)
            if (r3 == 0) goto L_0x016a
            goto L_0x0169
        L_0x00d1:
            if (r2 == 0) goto L_0x00dc
            int r9 = r7.mo7574e()
            if (r9 != r1) goto L_0x00dc
            r2.mo7572d((java.lang.String) r11)
        L_0x00dc:
            com.p006a.p007a.p008a.XMPNodeUtils.m223a((com.p006a.p007a.p008a.XMPNode) r7, (java.lang.String) r10, (java.lang.String) r11)
            goto L_0x016a
        L_0x00e1:
            com.p006a.p007a.p008a.XMPNodeUtils.m223a((com.p006a.p007a.p008a.XMPNode) r7, (java.lang.String) r10, (java.lang.String) r11)
            if (r3 == 0) goto L_0x016a
            goto L_0x0169
        L_0x00e8:
            if (r8 == 0) goto L_0x00ff
            if (r2 == r9) goto L_0x00ff
            if (r2 == 0) goto L_0x00ff
            java.lang.String r10 = r2.mo7584m()
            java.lang.String r12 = r9.mo7584m()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x00ff
            r2.mo7572d((java.lang.String) r11)
        L_0x00ff:
            r9.mo7572d((java.lang.String) r11)
            goto L_0x016a
        L_0x0104:
            if (r3 != 0) goto L_0x0121
            if (r8 == 0) goto L_0x011d
            if (r2 == r9) goto L_0x011d
            if (r2 == 0) goto L_0x011d
            java.lang.String r10 = r2.mo7584m()
            java.lang.String r12 = r9.mo7584m()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x011d
            r2.mo7572d((java.lang.String) r11)
        L_0x011d:
            r9.mo7572d((java.lang.String) r11)
            goto L_0x016a
        L_0x0121:
            boolean r10 = f70a
            if (r10 != 0) goto L_0x0130
            if (r8 == 0) goto L_0x012a
            if (r2 != r9) goto L_0x012a
            goto L_0x0130
        L_0x012a:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x0130:
            java.util.Iterator r9 = r7.mo7580i()
        L_0x0134:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0159
            java.lang.Object r10 = r9.next()
            com.a.a.a.o r10 = (com.p006a.p007a.p008a.XMPNode) r10
            if (r10 == r2) goto L_0x0134
            java.lang.String r0 = r10.mo7584m()
            if (r2 == 0) goto L_0x014d
            java.lang.String r3 = r2.mo7584m()
            goto L_0x014e
        L_0x014d:
            r3 = r12
        L_0x014e:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0155
            goto L_0x0134
        L_0x0155:
            r10.mo7572d((java.lang.String) r11)
            goto L_0x0134
        L_0x0159:
            if (r2 == 0) goto L_0x016a
            r2.mo7572d((java.lang.String) r11)
            goto L_0x016a
        L_0x015f:
            java.lang.String r8 = "x-default"
            com.p006a.p007a.p008a.XMPNodeUtils.m223a((com.p006a.p007a.p008a.XMPNode) r7, (java.lang.String) r8, (java.lang.String) r11)
            if (r3 != 0) goto L_0x0169
            com.p006a.p007a.p008a.XMPNodeUtils.m223a((com.p006a.p007a.p008a.XMPNode) r7, (java.lang.String) r10, (java.lang.String) r11)
        L_0x0169:
            r8 = 1
        L_0x016a:
            if (r8 != 0) goto L_0x0177
            int r8 = r7.mo7574e()
            if (r8 != r1) goto L_0x0177
            java.lang.String r8 = "x-default"
            com.p006a.p007a.p008a.XMPNodeUtils.m223a((com.p006a.p007a.p008a.XMPNode) r7, (java.lang.String) r8, (java.lang.String) r11)
        L_0x0177:
            return
        L_0x0178:
            com.a.a.c r7 = new com.a.a.c
            java.lang.String r9 = "Failed to find or create array node"
            r7.<init>(r9, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p006a.p007a.p008a.XMPMetaImpl.mo7533a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.a.a.b.d):void");
    }

    /* renamed from: d */
    public XMPProperty mo7544d(String str, String str2) throws XMPException {
        return mo7541c(str, str2, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public XMPProperty mo7541c(String str, String str2, int i) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m66b(str2);
        final XMPNode a = XMPNodeUtils.m215a(this.f71b, C0423c.m33a(str, str2), false, (PropertyOptions) null);
        if (a == null) {
            return null;
        }
        if (i == 0 || !a.mo7585n().mo7648l()) {
            final Object a2 = m131a(i, a);
            return new XMPProperty() {
                /* renamed from: a */
                public Object mo7548a() {
                    return a2;
                }

                public String toString() {
                    return a2.toString();
                }
            };
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Object mo7545d(String str, String str2, int i) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m66b(str2);
        XMPNode a = XMPNodeUtils.m215a(this.f71b, C0423c.m33a(str, str2), false, (PropertyOptions) null);
        if (a == null) {
            return null;
        }
        if (i == 0 || !a.mo7585n().mo7648l()) {
            return m131a(i, a);
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    /* renamed from: e */
    public Boolean mo7546e(String str, String str2) throws XMPException {
        return (Boolean) mo7545d(str, str2, 1);
    }

    /* renamed from: a */
    public void mo7534a(String str, String str2, boolean z) throws XMPException {
        mo7531a(str, str2, (Object) z ? "True" : "False", (PropertyOptions) null);
    }

    /* renamed from: f */
    public Integer mo7547f(String str, String str2) throws XMPException {
        return (Integer) mo7545d(str, str2, 2);
    }

    /* renamed from: b */
    public void mo7539b(String str, String str2, int i) throws XMPException {
        mo7531a(str, str2, (Object) new Integer(i), (PropertyOptions) null);
    }

    /* renamed from: a */
    public byte[] mo7536a(String str, String str2) throws XMPException {
        return (byte[]) mo7545d(str, str2, 7);
    }

    /* renamed from: b */
    public String mo7538b(String str, String str2) throws XMPException {
        return (String) mo7545d(str, str2, 0);
    }

    /* renamed from: a */
    public void mo7535a(String str, String str2, byte[] bArr) throws XMPException {
        mo7531a(str, str2, (Object) bArr, (PropertyOptions) null);
    }

    /* renamed from: a */
    public XMPProperty mo7524a(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m70f(str2);
        return mo7544d(str, str2 + XMPPathFactory.m374a(str3, str4));
    }

    /* renamed from: a */
    public void mo7529a(String str, String str2, int i, String str3, PropertyOptions dVar) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m65a(str2);
        XMPNode a = XMPNodeUtils.m215a(this.f71b, C0423c.m33a(str, str2), false, (PropertyOptions) null);
        if (a != null) {
            m132a(a, i, str3, dVar, false);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    /* renamed from: a */
    public void mo7528a(String str, String str2, int i, String str3) throws XMPException {
        mo7529a(str, str2, i, str3, (PropertyOptions) null);
    }

    /* renamed from: a */
    public void mo7531a(String str, String str2, Object obj, PropertyOptions dVar) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m66b(str2);
        PropertyOptions a = XMPNodeUtils.m219a(dVar, obj);
        XMPNode a2 = XMPNodeUtils.m215a(this.f71b, C0423c.m33a(str, str2), true, a);
        if (a2 != null) {
            mo7526a(a2, obj, a, false);
            return;
        }
        throw new XMPException("Specified property does not exist", 102);
    }

    /* renamed from: a */
    public void mo7530a(String str, String str2, Object obj) throws XMPException {
        mo7531a(str, str2, obj, (PropertyOptions) null);
    }

    /* renamed from: b */
    public void mo7540b(String str, String str2, String str3, String str4, String str5, PropertyOptions dVar) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m70f(str2);
        mo7531a(str, str2 + XMPPathFactory.m374a(str3, str4), (Object) str5, dVar);
    }

    /* renamed from: a */
    public void mo7532a(String str, String str2, String str3, String str4, String str5) throws XMPException {
        mo7540b(str, str2, str3, str4, str5, (PropertyOptions) null);
    }

    /* renamed from: a */
    public void mo7527a(String str) {
        this.f72c = str;
    }

    public Object clone() {
        return new XMPMetaImpl((XMPNode) this.f71b.clone());
    }

    /* renamed from: a */
    public void mo7525a() {
        this.f71b.mo7590s();
    }

    /* renamed from: b */
    public XMPNode mo7537b() {
        return this.f71b;
    }

    /* renamed from: a */
    private void m132a(XMPNode oVar, int i, String str, PropertyOptions dVar, boolean z) throws XMPException {
        XMPNode oVar2 = new XMPNode("[]", (PropertyOptions) null);
        PropertyOptions a = XMPNodeUtils.m219a(dVar, (Object) str);
        int e = z ? oVar.mo7574e() + 1 : oVar.mo7574e();
        if (i == -1) {
            i = e;
        }
        if (1 > i || i > e) {
            throw new XMPException("Array index out of bounds", 104);
        }
        if (!z) {
            oVar.mo7559b(i);
        }
        oVar.mo7553a(i, oVar2);
        mo7526a(oVar2, (Object) str, a, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7526a(XMPNode oVar, Object obj, PropertyOptions dVar, boolean z) throws XMPException {
        if (z) {
            oVar.mo7552a();
        }
        oVar.mo7585n().mo7628a(dVar);
        if (!oVar.mo7585n().mo7648l()) {
            XMPNodeUtils.m222a(oVar, obj);
        } else if (obj == null || obj.toString().length() <= 0) {
            oVar.mo7570d();
        } else {
            throw new XMPException("Composite nodes can't have values", 102);
        }
    }

    /* renamed from: a */
    private Object m131a(int i, XMPNode oVar) throws XMPException {
        String m = oVar.mo7584m();
        switch (i) {
            case 1:
                return new Boolean(XMPUtils.m387a(m));
            case 2:
                return new Integer(XMPUtils.m388b(m));
            case 3:
                return new Long(XMPUtils.m389c(m));
            case 4:
                return new Double(XMPUtils.m390d(m));
            case 5:
                return XMPUtils.m391e(m);
            case 6:
                return XMPUtils.m391e(m).mo7485i();
            case 7:
                return XMPUtils.m392f(m);
            default:
                if (m == null && !oVar.mo7585n().mo7648l()) {
                    m = "";
                }
                return m;
        }
    }
}
