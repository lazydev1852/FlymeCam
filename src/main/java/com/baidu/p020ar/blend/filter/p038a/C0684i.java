package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.gpuimage.p039a.C0725i;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.a.i */
public class C0684i implements C0694q {
    /* renamed from: a */
    private void m1682a(C0725i iVar, float f) {
        iVar.mo10032a(f);
    }

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        float f = 1.0f;
        JSONObject h = filterData.mo9947h();
        if (h != null) {
            f = (float) h.optDouble("blur_radius_in_pixels", 1.0d);
        }
        C0725i iVar = new C0725i();
        m1682a(iVar, f);
        return iVar;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        if (map != null && gVar != null && (gVar instanceof C0725i)) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            String c = C0700d.m1763c(map);
            try {
                if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("blur_radius_in_pixels")) {
                    m1682a((C0725i) gVar, Float.parseFloat(c));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
