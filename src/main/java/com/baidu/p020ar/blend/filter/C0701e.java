package com.baidu.p020ar.blend.filter;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.configdata.C0699c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.ar.blend.filter.e */
public class C0701e {

    /* renamed from: f */
    private static volatile C0701e f1463f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0674a f1464a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map<Integer, C0674a> f1465b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0699c f1466c;

    /* renamed from: d */
    private String f1467d;

    /* renamed from: e */
    private String f1468e;

    /* renamed from: com.baidu.ar.blend.filter.e$a */
    public interface C0704a<T> {
        /* renamed from: a */
        void mo9978a(T t);
    }

    private C0701e() {
    }

    /* renamed from: a */
    public static C0701e m1768a() {
        if (f1463f == null) {
            synchronized (C0701e.class) {
                if (f1463f == null) {
                    f1463f = new C0701e();
                }
            }
        }
        return f1463f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1769a(C0674a aVar, C0704a<C0674a> aVar2) {
        if (aVar2 != null) {
            aVar2.mo9978a(aVar);
        }
    }

    /* renamed from: b */
    public static void m1772b() {
        synchronized (C0701e.class) {
            f1463f = null;
        }
    }

    /* renamed from: a */
    public C0674a mo9973a(int i) {
        return this.f1465b.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo9974a(String str) {
        this.f1467d = str;
    }

    /* renamed from: a */
    public void mo9975a(String str, final C0704a<C0674a> aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f1468e = str;
            new C0695b(new C0704a<C0699c>() {
                /* renamed from: a */
                public void mo9978a(C0699c cVar) {
                    if (cVar != null && !cVar.equals(C0701e.this.f1466c)) {
                        C0699c unused = C0701e.this.f1466c = cVar;
                        try {
                            if (C0701e.this.f1466c.mo9972b() == null || C0701e.this.f1466c.mo9972b().size() == 0) {
                                C0701e.this.m1769a((C0674a) null, (C0704a<C0674a>) aVar);
                                return;
                            }
                            C0696c cVar2 = new C0696c(new C0704a<Map<Integer, C0674a>>() {
                                /* renamed from: a */
                                public void mo9978a(Map<Integer, C0674a> map) {
                                    if (map != null) {
                                        try {
                                            if (map.size() != 0) {
                                                C0701e.this.f1465b.putAll(map);
                                                C0701e.this.f1466c.mo9968a();
                                                C0674a unused = C0701e.this.f1464a = (C0674a) C0701e.this.f1465b.get(Integer.valueOf(C0701e.this.f1466c.mo9968a()));
                                                C0701e.this.m1769a(C0701e.this.f1464a, (C0704a<C0674a>) aVar);
                                                return;
                                            }
                                        } catch (NullPointerException e) {
                                            e.printStackTrace();
                                            C0701e.this.m1769a((C0674a) null, (C0704a<C0674a>) aVar);
                                            return;
                                        }
                                    }
                                    C0701e.this.m1769a((C0674a) null, (C0704a<C0674a>) aVar);
                                }
                            });
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(C0701e.this.f1466c.mo9972b().values());
                            cVar2.execute(new List[]{arrayList});
                            return;
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                    C0701e.this.m1769a((C0674a) null, (C0704a<C0674a>) aVar);
                }
            }).execute(new String[]{this.f1467d, this.f1468e});
            return;
        }
        m1769a((C0674a) null, aVar);
    }

    /* renamed from: c */
    public void mo9976c() {
        this.f1464a = null;
        this.f1465b.clear();
        this.f1466c = null;
        this.f1467d = null;
        this.f1468e = null;
    }
}
