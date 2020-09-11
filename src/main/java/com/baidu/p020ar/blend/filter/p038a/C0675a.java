package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.gpuimage.p039a.C0734q;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.a.a */
public class C0675a implements C0694q {
    /* renamed from: a */
    private void m1661a(C0734q qVar, float f) {
        qVar.mo10047a(f);
    }

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        float f = 0.7f;
        JSONObject h = filterData.mo9947h();
        if (h != null) {
            f = (float) h.optDouble("intensity", 0.7d);
        }
        C0734q qVar = new C0734q();
        m1661a(qVar, f);
        return qVar;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        if (map != null && gVar != null && (gVar instanceof C0734q)) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            String c = C0700d.m1763c(map);
            try {
                if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("intensity")) {
                    m1661a((C0734q) gVar, Float.parseFloat(c));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
