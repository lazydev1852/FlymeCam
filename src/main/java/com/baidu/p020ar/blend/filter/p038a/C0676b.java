package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0705a;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.a.b */
public class C0676b implements C0694q {
    /* renamed from: a */
    private void m1664a(C0705a aVar, float f) {
        aVar.mo9981a(f);
    }

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        float f = 0.0f;
        JSONObject h = filterData.mo9947h();
        if (h != null) {
            f = (float) h.optDouble("brightness", 0.0d);
        }
        C0705a aVar = new C0705a();
        m1664a(aVar, f);
        return aVar;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        if (map != null && gVar != null && (gVar instanceof C0705a)) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            String c = C0700d.m1763c(map);
            Log.d("bdar", "bdar:params type =" + a.mo9948a() + ", key = " + b + ", value = " + c);
            try {
                if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("brightness")) {
                    m1664a((C0705a) gVar, Float.parseFloat(c));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
