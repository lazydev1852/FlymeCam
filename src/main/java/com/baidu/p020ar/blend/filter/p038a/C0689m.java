package com.baidu.p020ar.blend.filter.p038a;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.gpuimage.p040b.C0746a;
import com.baidu.p020ar.blend.p037b.C0640a;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.ar.blend.filter.a.m */
public class C0689m implements C0694q {
    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        List<String> g = filterData.mo9946g();
        String a = C0640a.m1448a(filterData.mo9945f());
        String[] strArr = g != null ? new String[g.size()] : null;
        if (!(g == null || strArr == null)) {
            g.toArray(strArr);
        }
        if (g == null || g.size() == 0 || TextUtils.isEmpty(a)) {
            return null;
        }
        return new C0746a(strArr, a);
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
    }
}
