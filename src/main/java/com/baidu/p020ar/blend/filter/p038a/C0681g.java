package com.baidu.p020ar.blend.filter.p038a;

import android.graphics.PointF;
import android.util.Log;
import com.baidu.p020ar.arplay.util.MsgParamsUtil;
import com.baidu.p020ar.blend.filter.C0700d;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.p037b.C0640a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.ar.blend.filter.a.g */
public class C0681g implements C0694q {
    /* renamed from: b */
    private void m1676b(C0712g gVar, Map<String, Object> map) {
        if (gVar != null) {
            FilterData.AdjustType a = C0700d.m1755a(map);
            String b = C0700d.m1761b(map);
            String c = C0700d.m1763c(map);
            Log.d("bdar", "bdar:params type =" + a.mo9948a() + ", key = " + b + ", value = " + c);
            try {
                switch (a) {
                    case INT:
                        gVar.mo9994a(b, Integer.parseInt(c));
                        return;
                    case FLOAT:
                        gVar.mo9993a(b, Float.parseFloat(c));
                        return;
                    case POINT:
                        float[] str2FloatArray = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray != null && str2FloatArray.length >= 2) {
                            gVar.mo9995a(b, new PointF(str2FloatArray[0], str2FloatArray[1]));
                            return;
                        }
                        return;
                    case VEC3:
                        float[] str2FloatArray2 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray2 != null && str2FloatArray2.length >= 3) {
                            gVar.mo9996a(b, str2FloatArray2);
                            return;
                        }
                        return;
                    case VEC4:
                        float[] str2FloatArray3 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray3 != null && str2FloatArray3.length >= 4) {
                            gVar.mo9999b(b, str2FloatArray3);
                            return;
                        }
                        return;
                    case SIZE:
                        return;
                    case MAP:
                        HashMap<String, Object> d = C0700d.m1764d(map);
                        if (d != null && d.size() != 0) {
                            for (Object next : d.values()) {
                                if (next != null && (next instanceof HashMap)) {
                                    m1676b(gVar, (HashMap) next);
                                }
                            }
                            return;
                        }
                        return;
                    case MAT3:
                        float[] str2FloatArray4 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray4 != null && str2FloatArray4.length == 9) {
                            gVar.mo10003c(b, str2FloatArray4);
                            return;
                        }
                        return;
                    case MAT4:
                        float[] str2FloatArray5 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray5 != null && str2FloatArray5.length == 16) {
                            gVar.mo10006d(b, str2FloatArray5);
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

    /* renamed from: a */
    public C0712g mo9922a(FilterData filterData) {
        if (filterData != null) {
            return new C0712g(C0640a.m1448a(filterData.mo9944e()), C0640a.m1448a(filterData.mo9945f()));
        }
        return null;
    }

    /* renamed from: a */
    public void mo9923a(C0712g gVar, Map<String, Object> map) {
        m1676b(gVar, map);
    }
}
