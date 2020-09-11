package com.baidu.p020ar.blend.filter;

import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.ar.blend.filter.a */
public class C0674a {

    /* renamed from: a */
    private String f1384a;

    /* renamed from: b */
    private int f1385b;

    /* renamed from: c */
    private boolean f1386c;

    /* renamed from: d */
    private boolean f1387d;

    /* renamed from: e */
    private boolean f1388e;

    /* renamed from: f */
    private boolean f1389f;

    /* renamed from: g */
    private Map<Integer, FilterData> f1390g;

    /* renamed from: h */
    private Map<Integer, FilterData> f1391h;

    /* renamed from: i */
    private Map<Integer, FilterData> f1392i;

    /* renamed from: j */
    private Map<Integer, C0712g> f1393j;

    /* renamed from: k */
    private Map<Integer, C0712g> f1394k;

    /* renamed from: l */
    private Map<Integer, C0712g> f1395l;

    /* renamed from: m */
    private List<C0712g> f1396m = new ArrayList();

    /* renamed from: n */
    private List<C0712g> f1397n = new ArrayList();

    /* renamed from: o */
    private List<C0712g> f1398o = new ArrayList();

    /* renamed from: l */
    private List<C0712g> m1625l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0712g());
        return arrayList;
    }

    /* renamed from: a */
    public String mo9887a() {
        return this.f1384a;
    }

    /* renamed from: a */
    public synchronized void mo9888a(int i) {
        this.f1385b = i;
    }

    /* renamed from: a */
    public void mo9889a(int i, FilterData filterData) {
        if (this.f1390g != null) {
            this.f1390g.put(Integer.valueOf(i), filterData);
        }
    }

    /* renamed from: a */
    public void mo9890a(int i, C0712g gVar) {
        if (this.f1393j != null) {
            this.f1393j.put(Integer.valueOf(i), gVar);
        }
    }

    /* renamed from: a */
    public void mo9891a(String str) {
        this.f1384a = str;
    }

    /* renamed from: a */
    public void mo9892a(Map<Integer, FilterData> map) {
        this.f1390g = map;
    }

    /* renamed from: a */
    public synchronized void mo9893a(boolean z) {
        this.f1386c = z;
    }

    /* renamed from: b */
    public synchronized int mo9894b() {
        return this.f1385b;
    }

    /* renamed from: b */
    public void mo9895b(int i) {
        if (this.f1390g != null) {
            this.f1390g.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: b */
    public void mo9896b(int i, FilterData filterData) {
        if (this.f1391h != null) {
            this.f1391h.put(Integer.valueOf(i), filterData);
        }
    }

    /* renamed from: b */
    public void mo9897b(int i, C0712g gVar) {
        if (this.f1394k != null) {
            this.f1394k.put(Integer.valueOf(i), gVar);
        }
    }

    /* renamed from: b */
    public void mo9898b(Map<Integer, FilterData> map) {
        this.f1391h = map;
    }

    /* renamed from: b */
    public synchronized void mo9899b(boolean z) {
        this.f1387d = z;
    }

    /* renamed from: c */
    public synchronized List<C0712g> mo9900c() {
        if (!this.f1386c || !this.f1387d || this.f1393j == null || this.f1393j.size() == 0) {
            return m1625l();
        }
        this.f1396m.clear();
        this.f1396m.addAll(this.f1393j.values());
        return this.f1396m;
    }

    /* renamed from: c */
    public void mo9901c(int i) {
        if (this.f1391h != null) {
            this.f1391h.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    public void mo9902c(int i, FilterData filterData) {
        if (this.f1392i != null) {
            this.f1392i.put(Integer.valueOf(i), filterData);
        }
    }

    /* renamed from: c */
    public void mo9903c(int i, C0712g gVar) {
        if (this.f1395l != null) {
            this.f1395l.put(Integer.valueOf(i), gVar);
        }
    }

    /* renamed from: c */
    public void mo9904c(Map<Integer, FilterData> map) {
        this.f1392i = map;
    }

    /* renamed from: c */
    public synchronized void mo9905c(boolean z) {
        this.f1388e = z;
    }

    /* renamed from: d */
    public List<C0712g> mo9906d() {
        if (!this.f1386c || !this.f1388e || this.f1394k == null || this.f1394k.size() == 0) {
            return m1625l();
        }
        this.f1397n.clear();
        this.f1397n.addAll(this.f1394k.values());
        return this.f1397n;
    }

    /* renamed from: d */
    public void mo9907d(int i) {
        if (this.f1392i != null) {
            this.f1392i.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: d */
    public void mo9908d(Map<Integer, C0712g> map) {
        this.f1393j = map;
    }

    /* renamed from: d */
    public synchronized void mo9909d(boolean z) {
        this.f1389f = z;
    }

    /* renamed from: e */
    public synchronized List<C0712g> mo9910e() {
        if (!this.f1386c || !this.f1389f || this.f1395l == null || this.f1395l.size() == 0) {
            return m1625l();
        }
        this.f1398o.clear();
        this.f1398o.addAll(this.f1395l.values());
        return this.f1398o;
    }

    /* renamed from: e */
    public void mo9911e(int i) {
        if (this.f1393j != null) {
            this.f1393j.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: e */
    public void mo9912e(Map<Integer, C0712g> map) {
        this.f1394k = map;
    }

    /* renamed from: f */
    public Map<Integer, FilterData> mo9913f() {
        return this.f1390g;
    }

    /* renamed from: f */
    public void mo9914f(int i) {
        if (this.f1394k != null) {
            this.f1394k.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: f */
    public void mo9915f(Map<Integer, C0712g> map) {
        this.f1395l = map;
    }

    /* renamed from: g */
    public Map<Integer, FilterData> mo9916g() {
        return this.f1391h;
    }

    /* renamed from: g */
    public void mo9917g(int i) {
        if (this.f1395l != null) {
            this.f1395l.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: h */
    public Map<Integer, FilterData> mo9918h() {
        return this.f1392i;
    }

    /* renamed from: i */
    public Map<Integer, C0712g> mo9919i() {
        return this.f1393j;
    }

    /* renamed from: j */
    public Map<Integer, C0712g> mo9920j() {
        return this.f1394k;
    }

    /* renamed from: k */
    public Map<Integer, C0712g> mo9921k() {
        return this.f1395l;
    }
}
