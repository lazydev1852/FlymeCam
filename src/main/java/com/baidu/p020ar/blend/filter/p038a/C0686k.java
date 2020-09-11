package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.gpuimage.p039a.C0728k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.a.k */
public class C0686k implements C0694q {
    /* renamed from: a */
    private void m1687a(C0728k kVar, float f) {
        kVar.mo10036b(f);
    }

    /* renamed from: a */
    private void m1688a(C0728k kVar, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals("hue")) {
                try {
                    m1687a(kVar, Float.valueOf(str2).floatValue());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (str.equals("brightness")) {
                m1689b(kVar, Float.valueOf(str2).floatValue());
            } else if (str.equals("saturation")) {
                m1690c(kVar, Float.valueOf(str2).floatValue());
            }
        }
    }

    /* renamed from: b */
    private void m1689b(C0728k kVar, float f) {
        kVar.mo10038d(f);
    }

    /* renamed from: c */
    private void m1690c(C0728k kVar, float f) {
        kVar.mo10037c(f);
    }

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        float f;
        if (filterData == null) {
            return null;
        }
        float f2 = 0.0f;
        JSONObject h = filterData.mo9947h();
        float f3 = 1.0f;
        if (h != null) {
            f2 = (float) h.optDouble("hue", 0.0d);
            f3 = (float) h.optDouble("saturation", 1.0d);
            f = (float) h.optDouble("brightness", 1.0d);
        } else {
            f = 1.0f;
        }
        C0728k kVar = new C0728k();
        m1687a(kVar, f2);
        m1689b(kVar, f);
        m1690c(kVar, f3);
        return kVar;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        if (map != null && gVar != null && (gVar instanceof C0728k)) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            try {
                switch (a) {
                    case FLOAT:
                        m1688a((C0728k) gVar, b, C0700d.m1763c(map));
                        return;
                    case MAP:
                        HashMap<String, Object> d = C0700d.m1764d(map);
                        if (d != null && d.size() != 0) {
                            for (Object next : d.values()) {
                                if (next != null && (next instanceof HashMap)) {
                                    HashMap hashMap = (HashMap) next;
                                    FilterData.AdjustType a2 = C0700d.m1755a((Map<String, Object>) hashMap);
                                    String b2 = C0700d.m1761b(hashMap);
                                    String c = C0700d.m1763c(hashMap);
                                    if (a2 == FilterData.AdjustType.FLOAT) {
                                        m1688a((C0728k) gVar, b2, c);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }
}
