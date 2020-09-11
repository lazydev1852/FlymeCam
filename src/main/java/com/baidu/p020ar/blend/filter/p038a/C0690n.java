package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.gpuimage.p039a.C0731n;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.a.n */
public class C0690n implements C0694q {
    /* renamed from: a */
    private void m1697a(C0731n nVar, float f) {
        nVar.mo10045a(f);
    }

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        float f = 1.0f;
        JSONObject h = filterData.mo9947h();
        if (h != null) {
            f = (float) h.optDouble("saturation", 1.0d);
        }
        C0731n nVar = new C0731n();
        m1697a(nVar, f);
        return nVar;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        if (map != null && gVar != null && (gVar instanceof C0731n)) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            String c = C0700d.m1763c(map);
            try {
                if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("saturation")) {
                    m1697a((C0731n) gVar, Float.parseFloat(c));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
