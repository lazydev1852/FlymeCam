package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0710e;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.a.h */
public class C0683h implements C0694q {
    /* renamed from: a */
    private void m1679a(C0710e eVar, float f) {
        eVar.mo9987a(f);
    }

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        float f = 0.0f;
        JSONObject h = filterData.mo9947h();
        if (h != null) {
            f = (float) h.optDouble("exposure", 0.0d);
        }
        C0710e eVar = new C0710e();
        m1679a(eVar, f);
        return eVar;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        if (map != null && gVar != null && (gVar instanceof C0710e)) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            String c = C0700d.m1763c(map);
            try {
                if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("exposure")) {
                    m1679a((C0710e) gVar, Float.parseFloat(c));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
