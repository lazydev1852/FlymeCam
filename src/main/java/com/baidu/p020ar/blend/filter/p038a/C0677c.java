package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0708c;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.a.c */
public class C0677c implements C0694q {
    /* renamed from: a */
    private void m1667a(C0708c cVar, float f) {
        cVar.mo9986a(f);
    }

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        float f = 1.0f;
        JSONObject h = filterData.mo9947h();
        if (h != null) {
            f = (float) h.optDouble("contrast", 1.0d);
        }
        C0708c cVar = new C0708c();
        m1667a(cVar, f);
        return cVar;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        if (map != null && gVar != null && (gVar instanceof C0708c)) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            String c = C0700d.m1763c(map);
            try {
                if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("contrast")) {
                    m1667a((C0708c) gVar, Float.parseFloat(c));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
