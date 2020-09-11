package com.baidu.p020ar.blend.filter;

import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.configdata.C0697a;
import com.baidu.p020ar.blend.filter.configdata.C0698b;
import com.baidu.p020ar.blend.filter.configdata.C0699c;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.filter.p038a.C0692p;
import com.baidu.p020ar.blend.filter.p038a.C0694q;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.d */
public final class C0700d {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r2.get("adjust_value_type");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.p020ar.blend.filter.configdata.FilterData.AdjustType m1755a(java.util.Map<java.lang.String, java.lang.Object> r2) {
        /*
            com.baidu.ar.blend.filter.configdata.FilterData$AdjustType r0 = com.baidu.p020ar.blend.filter.configdata.FilterData.AdjustType.NONE
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = "adjust_value_type"
            java.lang.Object r2 = r2.get(r1)
            if (r2 == 0) goto L_0x001a
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x001a
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.baidu.ar.blend.filter.configdata.FilterData$AdjustType r0 = com.baidu.p020ar.blend.filter.configdata.FilterData.AdjustType.m1726a(r2)
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.filter.C0700d.m1755a(java.util.Map):com.baidu.ar.blend.filter.configdata.FilterData$AdjustType");
    }

    /* renamed from: a */
    private static C0697a m1756a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("filter_group_id", -1);
        C0697a aVar = new C0697a();
        aVar.mo9955a(str);
        aVar.mo9953a(optInt);
        boolean z = false;
        if (jSONObject.optInt("disable_filter_group", 0) == 0) {
            z = true;
        }
        aVar.mo9956a(z);
        aVar.mo9954a(m1760b(str, jSONObject.optJSONObject("reality_target")));
        aVar.mo9958b(m1760b(str, jSONObject.optJSONObject("virtual_target")));
        aVar.mo9959c(m1760b(str, jSONObject.optJSONObject("mix_target")));
        return aVar;
    }

    /* renamed from: a */
    public static C0699c m1757a(String str, String str2) {
        C0699c cVar;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str2);
            cVar = new C0699c();
            try {
                cVar.mo9969a(jSONObject.optInt("start_filter_group_id", -1));
                JSONArray optJSONArray = jSONObject.optJSONArray("filter_group_set");
                if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0697a a = m1756a(str, optJSONArray.optJSONObject(i));
                        if (a != null) {
                            hashMap.put(Integer.valueOf(a.mo9957b()), a);
                        }
                    }
                    cVar.mo9971a((Map<Integer, C0697a>) hashMap);
                }
                cVar.mo9970a(str);
                return cVar;
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                return cVar;
            }
        } catch (JSONException e2) {
            e = e2;
            cVar = null;
            e.printStackTrace();
            return cVar;
        }
    }

    /* renamed from: a */
    public static Map<Integer, C0674a> m1758a(List<C0697a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (C0697a next : list) {
            if (next != null) {
                C0674a aVar = new C0674a();
                aVar.mo9891a(next.mo9952a());
                aVar.mo9893a(next.mo9960c());
                aVar.mo9888a(next.mo9957b());
                C0698b d = next.mo9961d();
                if (d != null) {
                    aVar.mo9899b(d.mo9966a());
                    HashMap hashMap2 = new HashMap();
                    aVar.mo9908d(m1759a((Map<Integer, FilterData>) hashMap2, d));
                    aVar.mo9892a((Map<Integer, FilterData>) hashMap2);
                }
                C0698b e = next.mo9962e();
                if (e != null) {
                    aVar.mo9905c(e.mo9966a());
                    HashMap hashMap3 = new HashMap();
                    aVar.mo9912e(m1759a((Map<Integer, FilterData>) hashMap3, e));
                    aVar.mo9898b((Map<Integer, FilterData>) hashMap3);
                }
                C0698b f = next.mo9963f();
                if (f != null) {
                    aVar.mo9909d(f.mo9966a());
                    HashMap hashMap4 = new HashMap();
                    aVar.mo9915f(m1759a((Map<Integer, FilterData>) hashMap4, f));
                    aVar.mo9904c((Map<Integer, FilterData>) hashMap4);
                }
                hashMap.put(Integer.valueOf(aVar.mo9894b()), aVar);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<Integer, C0712g> m1759a(Map<Integer, FilterData> map, C0698b bVar) {
        C0712g a;
        HashMap hashMap = new HashMap();
        if (!(bVar == null || bVar.mo9967b() == null || bVar.mo9967b().size() == 0)) {
            hashMap = new HashMap();
            List<FilterData> b = bVar.mo9967b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                FilterData filterData = b.get(i);
                C0694q a2 = C0692p.m1703a(filterData);
                if (!(a2 == null || (a = a2.mo9922a(filterData)) == null)) {
                    hashMap.put(Integer.valueOf(filterData.mo9932a()), a);
                    map.put(Integer.valueOf(filterData.mo9932a()), filterData);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private static C0698b m1760b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0698b bVar = new C0698b();
        bVar.mo9965a(jSONObject.optInt("disable_pass_list", 0) == 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("pass_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return bVar;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            FilterData c = m1762c(str, optJSONArray.optJSONObject(i));
            if (c != null) {
                arrayList.add(c);
            }
        }
        bVar.mo9964a((List<FilterData>) arrayList);
        return bVar;
    }

    /* renamed from: b */
    public static String m1761b(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("adjust_key")) == null || !(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    /* renamed from: c */
    private static FilterData m1762c(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("source_file");
        String optString2 = jSONObject.optString("vertex_shader");
        String optString3 = jSONObject.optString("fragment_shader");
        FilterData filterData = new FilterData();
        filterData.mo9933a(jSONObject.optInt("pass_id"));
        filterData.mo9935a(FilterData.PassType.m1730a(jSONObject.optString("pass_type")));
        filterData.mo9934a(FilterData.PassSubType.m1728a(jSONObject.optString("sub_type")));
        if (!TextUtils.isEmpty(optString)) {
            filterData.mo9936a(str != null ? str.concat(optString) : null);
        }
        if (!TextUtils.isEmpty(optString2)) {
            filterData.mo9940b(str != null ? str.concat(optString2) : null);
        }
        if (!TextUtils.isEmpty(optString3)) {
            filterData.mo9942c(str != null ? str.concat(optString3) : null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("multi_source_files");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString4 = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString4)) {
                    arrayList.add(str != null ? str.concat(optString4) : null);
                }
            }
            filterData.mo9937a((List<String>) arrayList);
        }
        filterData.mo9938a(jSONObject.optJSONObject("params"));
        return filterData;
    }

    /* renamed from: c */
    public static String m1763c(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("adjust_value")) == null || !(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    /* renamed from: d */
    public static HashMap<String, Object> m1764d(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("adjust_value")) == null || !(obj instanceof HashMap)) {
            return null;
        }
        return (HashMap) obj;
    }
}
