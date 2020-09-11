package com.p006a.p007a.p008a.p009a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.a.a.a.a.b */
public class XMPPath {

    /* renamed from: a */
    private List f42a = new ArrayList(5);

    /* renamed from: a */
    public void mo7488a(XMPPathSegment dVar) {
        this.f42a.add(dVar);
    }

    /* renamed from: a */
    public XMPPathSegment mo7487a(int i) {
        return (XMPPathSegment) this.f42a.get(i);
    }

    /* renamed from: a */
    public int mo7486a() {
        return this.f42a.size();
    }

    public String toString() {
        int a;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < mo7486a(); i++) {
            stringBuffer.append(mo7487a(i));
            if (i < mo7486a() - 1 && ((a = mo7487a(i + 1).mo7490a()) == 1 || a == 2)) {
                stringBuffer.append('/');
            }
        }
        return stringBuffer.toString();
    }
}
