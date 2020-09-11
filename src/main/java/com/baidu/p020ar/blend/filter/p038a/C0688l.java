package com.baidu.p020ar.blend.filter.p038a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.gpuimage.p039a.C0729l;
import java.util.Map;

/* renamed from: com.baidu.ar.blend.filter.a.l */
public class C0688l implements C0694q {
    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        Bitmap decodeFile;
        if (filterData != null) {
            String d = filterData.mo9943d();
            float f = 64.0f;
            if (filterData.mo9947h() != null) {
                f = (float) filterData.mo9947h().optDouble("dimension", 64.0d);
            }
            if (!TextUtils.isEmpty(d) && (decodeFile = BitmapFactory.decodeFile(d)) != null && !decodeFile.isRecycled()) {
                C0729l lVar = new C0729l();
                lVar.mo10040a(decodeFile);
                lVar.mo10039a(f);
                return lVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        Object obj;
        if (map != null && gVar != null && (gVar instanceof C0729l) && (obj = map.get("dimension")) != null) {
            if (obj instanceof String) {
                try {
                    ((C0729l) gVar).mo10039a(Float.valueOf((String) obj).floatValue());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (obj instanceof Float) {
                ((C0729l) gVar).mo10039a(((Float) obj).floatValue());
            }
        }
    }
}
