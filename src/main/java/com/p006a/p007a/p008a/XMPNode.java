package com.p006a.p007a.p008a;

import com.meizu.camera.MeizuCamera;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.p010b.PropertyOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.a.a.a.o */
public class XMPNode implements Comparable {

    /* renamed from: a */
    static final /* synthetic */ boolean f78a = (!XMPNode.class.desiredAssertionStatus());

    /* renamed from: b */
    private String f79b;

    /* renamed from: c */
    private String f80c;

    /* renamed from: d */
    private XMPNode f81d;

    /* renamed from: e */
    private List f82e;

    /* renamed from: f */
    private List f83f;

    /* renamed from: g */
    private PropertyOptions f84g;

    /* renamed from: h */
    private boolean f85h;

    /* renamed from: i */
    private boolean f86i;

    /* renamed from: j */
    private boolean f87j;

    /* renamed from: k */
    private boolean f88k;

    public XMPNode(String str, String str2, PropertyOptions dVar) {
        this.f82e = null;
        this.f83f = null;
        this.f84g = null;
        this.f79b = str;
        this.f80c = str2;
        this.f84g = dVar;
    }

    public XMPNode(String str, PropertyOptions dVar) {
        this(str, (String) null, dVar);
    }

    /* renamed from: a */
    public void mo7552a() {
        this.f84g = null;
        this.f79b = null;
        this.f80c = null;
        this.f82e = null;
        this.f83f = null;
    }

    /* renamed from: b */
    public XMPNode mo7557b() {
        return this.f81d;
    }

    /* renamed from: a */
    public XMPNode mo7550a(int i) {
        return (XMPNode) m171w().get(i - 1);
    }

    /* renamed from: a */
    public void mo7554a(XMPNode oVar) throws XMPException {
        m167e(oVar.mo7583l());
        oVar.mo7577f(this);
        m171w().add(oVar);
    }

    /* renamed from: a */
    public void mo7553a(int i, XMPNode oVar) throws XMPException {
        m167e(oVar.mo7583l());
        oVar.mo7577f(this);
        m171w().add(i - 1, oVar);
    }

    /* renamed from: b */
    public void mo7560b(int i, XMPNode oVar) {
        oVar.mo7577f(this);
        m171w().set(i - 1, oVar);
    }

    /* renamed from: b */
    public void mo7559b(int i) {
        m171w().remove(i - 1);
        mo7564c();
    }

    /* renamed from: b */
    public void mo7561b(XMPNode oVar) {
        m171w().remove(oVar);
        mo7564c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7564c() {
        if (this.f82e.isEmpty()) {
            this.f82e = null;
        }
    }

    /* renamed from: d */
    public void mo7570d() {
        this.f82e = null;
    }

    /* renamed from: e */
    public int mo7574e() {
        if (this.f82e != null) {
            return this.f82e.size();
        }
        return 0;
    }

    /* renamed from: a */
    public XMPNode mo7551a(String str) {
        return m166a(m171w(), str);
    }

    /* renamed from: c */
    public XMPNode mo7563c(int i) {
        return (XMPNode) m172x().get(i - 1);
    }

    /* renamed from: f */
    public int mo7576f() {
        if (this.f83f != null) {
            return this.f83f.size();
        }
        return 0;
    }

    /* renamed from: c */
    public void mo7565c(XMPNode oVar) throws XMPException {
        m168f(oVar.mo7583l());
        oVar.mo7577f(this);
        oVar.mo7585n().mo7632c(true);
        mo7585n().mo7630b(true);
        if (oVar.m169u()) {
            this.f84g.mo7634d(true);
            m172x().add(0, oVar);
        } else if (oVar.m170v()) {
            this.f84g.mo7636e(true);
            m172x().add(this.f84g.mo7633c() ? 1 : 0, oVar);
        } else {
            m172x().add(oVar);
        }
    }

    /* renamed from: d */
    public void mo7571d(XMPNode oVar) {
        PropertyOptions n = mo7585n();
        if (oVar.m169u()) {
            n.mo7634d(false);
        } else if (oVar.m170v()) {
            n.mo7636e(false);
        }
        m172x().remove(oVar);
        if (this.f83f.isEmpty()) {
            n.mo7630b(false);
            this.f83f = null;
        }
    }

    /* renamed from: g */
    public void mo7578g() {
        PropertyOptions n = mo7585n();
        n.mo7630b(false);
        n.mo7634d(false);
        n.mo7636e(false);
        this.f83f = null;
    }

    /* renamed from: b */
    public XMPNode mo7558b(String str) {
        return m166a(this.f83f, str);
    }

    /* renamed from: h */
    public boolean mo7579h() {
        return this.f82e != null && this.f82e.size() > 0;
    }

    /* renamed from: i */
    public Iterator mo7580i() {
        if (this.f82e != null) {
            return m171w().iterator();
        }
        return Collections.EMPTY_LIST.listIterator();
    }

    /* renamed from: j */
    public boolean mo7581j() {
        return this.f83f != null && this.f83f.size() > 0;
    }

    /* renamed from: k */
    public Iterator mo7582k() {
        if (this.f83f == null) {
            return Collections.EMPTY_LIST.iterator();
        }
        final Iterator it = m172x().iterator();
        return new Iterator() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public Object next() {
                return it.next();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove() is not allowed due to the internal contraints");
            }
        };
    }

    public Object clone() {
        PropertyOptions dVar;
        try {
            dVar = new PropertyOptions(mo7585n().mo7619f());
        } catch (XMPException unused) {
            dVar = new PropertyOptions();
        }
        XMPNode oVar = new XMPNode(this.f79b, this.f80c, dVar);
        mo7575e(oVar);
        return oVar;
    }

    /* renamed from: e */
    public void mo7575e(XMPNode oVar) {
        try {
            Iterator i = mo7580i();
            while (i.hasNext()) {
                oVar.mo7554a((XMPNode) ((XMPNode) i.next()).clone());
            }
            Iterator k = mo7582k();
            while (k.hasNext()) {
                oVar.mo7565c((XMPNode) ((XMPNode) k.next()).clone());
            }
        } catch (XMPException unused) {
            if (!f78a) {
                throw new AssertionError();
            }
        }
    }

    public int compareTo(Object obj) {
        if (mo7585n().mo7647k()) {
            return this.f80c.compareTo(((XMPNode) obj).mo7584m());
        }
        return this.f79b.compareTo(((XMPNode) obj).mo7583l());
    }

    /* renamed from: l */
    public String mo7583l() {
        return this.f79b;
    }

    /* renamed from: c */
    public void mo7566c(String str) {
        this.f79b = str;
    }

    /* renamed from: m */
    public String mo7584m() {
        return this.f80c;
    }

    /* renamed from: d */
    public void mo7572d(String str) {
        this.f80c = str;
    }

    /* renamed from: n */
    public PropertyOptions mo7585n() {
        if (this.f84g == null) {
            this.f84g = new PropertyOptions();
        }
        return this.f84g;
    }

    /* renamed from: a */
    public void mo7555a(PropertyOptions dVar) {
        this.f84g = dVar;
    }

    /* renamed from: o */
    public boolean mo7586o() {
        return this.f85h;
    }

    /* renamed from: a */
    public void mo7556a(boolean z) {
        this.f85h = z;
    }

    /* renamed from: p */
    public boolean mo7587p() {
        return this.f86i;
    }

    /* renamed from: b */
    public void mo7562b(boolean z) {
        this.f86i = z;
    }

    /* renamed from: q */
    public boolean mo7588q() {
        return this.f87j;
    }

    /* renamed from: c */
    public void mo7567c(boolean z) {
        this.f87j = z;
    }

    /* renamed from: r */
    public boolean mo7589r() {
        return this.f88k;
    }

    /* renamed from: d */
    public void mo7573d(boolean z) {
        this.f88k = z;
    }

    /* renamed from: s */
    public void mo7590s() {
        if (mo7581j()) {
            XMPNode[] oVarArr = (XMPNode[]) m172x().toArray(new XMPNode[mo7576f()]);
            int i = 0;
            while (oVarArr.length > i && ("xml:lang".equals(oVarArr[i].mo7583l()) || "rdf:type".equals(oVarArr[i].mo7583l()))) {
                oVarArr[i].mo7590s();
                i++;
            }
            Arrays.sort(oVarArr, i, oVarArr.length);
            ListIterator listIterator = this.f83f.listIterator();
            for (int i2 = 0; i2 < oVarArr.length; i2++) {
                listIterator.next();
                listIterator.set(oVarArr[i2]);
                oVarArr[i2].mo7590s();
            }
        }
        if (mo7579h()) {
            if (!mo7585n().mo7639g()) {
                Collections.sort(this.f82e);
            }
            Iterator i3 = mo7580i();
            while (i3.hasNext()) {
                ((XMPNode) i3.next()).mo7590s();
            }
        }
    }

    /* renamed from: u */
    private boolean m169u() {
        return "xml:lang".equals(this.f79b);
    }

    /* renamed from: v */
    private boolean m170v() {
        return "rdf:type".equals(this.f79b);
    }

    /* renamed from: w */
    private List m171w() {
        if (this.f82e == null) {
            this.f82e = new ArrayList(0);
        }
        return this.f82e;
    }

    /* renamed from: t */
    public List mo7591t() {
        return Collections.unmodifiableList(new ArrayList(m171w()));
    }

    /* renamed from: x */
    private List m172x() {
        if (this.f83f == null) {
            this.f83f = new ArrayList(0);
        }
        return this.f83f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo7577f(XMPNode oVar) {
        this.f81d = oVar;
    }

    /* renamed from: a */
    private XMPNode m166a(List list, String str) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            XMPNode oVar = (XMPNode) it.next();
            if (oVar.mo7583l().equals(str)) {
                return oVar;
            }
        }
        return null;
    }

    /* renamed from: e */
    private void m167e(String str) throws XMPException {
        if (!"[]".equals(str) && mo7551a(str) != null) {
            throw new XMPException("Duplicate property or field node '" + str + "'", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
        }
    }

    /* renamed from: f */
    private void m168f(String str) throws XMPException {
        if (!"[]".equals(str) && mo7558b(str) != null) {
            throw new XMPException("Duplicate '" + str + "' qualifier", MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY);
        }
    }
}
