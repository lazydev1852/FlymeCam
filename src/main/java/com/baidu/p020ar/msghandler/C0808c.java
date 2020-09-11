package com.baidu.p020ar.msghandler;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.arplay.util.MsgParamsUtil;
import com.baidu.p020ar.blend.blender.C0654c;
import com.baidu.p020ar.blend.filter.C0674a;
import com.baidu.p020ar.blend.filter.C0701e;
import com.baidu.p020ar.blend.filter.configdata.FilterData;
import com.baidu.p020ar.blend.filter.p038a.C0692p;
import com.baidu.p020ar.blend.filter.p038a.C0694q;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.util.Debug;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.msghandler.c */
public class C0808c implements C0811d {

    /* renamed from: a */
    C0654c f1893a;

    /* renamed from: b */
    String f1894b;

    public C0808c(String str, C0654c cVar) {
        this.f1893a = cVar;
        this.f1894b = str;
        C0701e.m1768a().mo9974a(this.f1894b);
    }

    /* renamed from: a */
    private static FilterData m2117a(String str, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        String obj2String = MsgParamsUtil.obj2String(map.get("source_file"), (String) null);
        String obj2String2 = MsgParamsUtil.obj2String(map.get("vertex_shader"), (String) null);
        String obj2String3 = MsgParamsUtil.obj2String(map.get("fragment_shader"), (String) null);
        FilterData filterData = new FilterData();
        filterData.mo9933a(MsgParamsUtil.obj2Int(map.get("pass_id"), -1));
        filterData.mo9935a(FilterData.PassType.m1730a(MsgParamsUtil.obj2String(map.get("pass_type"), (String) null)));
        filterData.mo9934a(FilterData.PassSubType.m1728a(MsgParamsUtil.obj2String(map.get("sub_type"), (String) null)));
        if (!TextUtils.isEmpty(obj2String)) {
            filterData.mo9936a(str != null ? str.concat(obj2String) : null);
        }
        if (!TextUtils.isEmpty(obj2String2)) {
            filterData.mo9940b(str != null ? str.concat(obj2String2) : null);
        }
        if (!TextUtils.isEmpty(obj2String3)) {
            filterData.mo9942c(str != null ? str.concat(obj2String3) : null);
        }
        try {
            String[] str2StringArray = MsgParamsUtil.str2StringArray(MsgParamsUtil.obj2String(map.get("multi_source_files"), (String) null));
            if (!(str2StringArray == null || str2StringArray.length == 0)) {
                ArrayList arrayList = new ArrayList();
                for (String add : str2StringArray) {
                    arrayList.add(add);
                }
                filterData.mo9937a((List<String>) arrayList);
            }
            filterData.mo9938a(new JSONObject(MsgParamsUtil.obj2HashMap(map.get("params"), (HashMap<String, Object>) null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filterData;
    }

    /* renamed from: a */
    private void m2118a() {
        this.f1893a.mo9858f();
    }

    /* renamed from: a */
    private void m2119a(int i, String str) {
        Debug.print("bdar:techniqueId = " + i);
        this.f1893a.mo9849a(C0701e.m1768a().mo9973a(i), str);
    }

    /* renamed from: a */
    private void m2120a(int i, String str, String str2) {
        C0674a a = C0701e.m1768a().mo9973a(i);
        if (a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            boolean equals = str2.equals("0");
            if (str.equals("reality_target")) {
                a.mo9899b(equals);
            } else if (str.equals("virtual_target")) {
                a.mo9905c(equals);
            } else if (str.equals("mix_target")) {
                a.mo9909d(equals);
            } else {
                a.mo9893a(equals);
            }
        }
    }

    /* renamed from: a */
    private void m2121a(int i, String str, Map<String, Object> map) {
        C0712g a;
        Debug.print("bdar:techniqueId = " + i);
        C0674a a2 = C0701e.m1768a().mo9973a(i);
        if (a2 != null) {
            FilterData a3 = m2117a(a2.mo9887a(), map);
            int a4 = a3.mo9932a();
            C0694q a5 = C0692p.m1703a(a3);
            if (a5 != null && (a = a5.mo9922a(a3)) != null && !TextUtils.isEmpty(str)) {
                if (str.equals("reality_target")) {
                    if (a2.mo9913f() == null || a2.mo9913f().get(Integer.valueOf(a4)) == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(Integer.valueOf(a4), a3);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(Integer.valueOf(a4), a);
                        a2.mo9892a((Map<Integer, FilterData>) hashMap);
                        a2.mo9908d((Map<Integer, C0712g>) hashMap2);
                        return;
                    }
                    a2.mo9889a(a4, a3);
                    a2.mo9890a(a4, a);
                } else if (str.equals("virtual_target")) {
                    if (a2.mo9916g() == null || a2.mo9916g().get(Integer.valueOf(a4)) == null) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put(Integer.valueOf(a4), a3);
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put(Integer.valueOf(a4), a);
                        a2.mo9898b((Map<Integer, FilterData>) hashMap3);
                        a2.mo9912e((Map<Integer, C0712g>) hashMap4);
                        return;
                    }
                    a2.mo9896b(a4, a3);
                    a2.mo9897b(a4, a);
                } else if (!str.equals("mix_target")) {
                } else {
                    if (a2.mo9918h() == null || a2.mo9918h().get(Integer.valueOf(a4)) == null) {
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put(Integer.valueOf(a4), a3);
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put(Integer.valueOf(a4), a);
                        a2.mo9904c((Map<Integer, FilterData>) hashMap5);
                        a2.mo9915f((Map<Integer, C0712g>) hashMap6);
                        return;
                    }
                    a2.mo9902c(a4, a3);
                    a2.mo9903c(a4, a);
                }
            }
        }
    }

    /* renamed from: a */
    private void m2122a(String str) {
        C0701e.m1768a().mo9975a(str, (C0701e.C0704a<C0674a>) new C0701e.C0704a<C0674a>() {
            /* renamed from: a */
            public void mo9978a(C0674a aVar) {
                if (aVar != null && C0808c.this.f1893a != null) {
                    C0808c.this.f1893a.mo9849a(aVar, (String) null);
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2123a(java.lang.String r4, int r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r3 = this;
            com.baidu.ar.blend.blender.c r0 = r3.f1893a
            com.baidu.ar.blend.filter.a r0 = r0.mo9859g()
            if (r0 == 0) goto L_0x009d
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x009d
            java.lang.String r1 = "reality_target"
            boolean r1 = r4.equals(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0041
            java.util.Map r4 = r0.mo9913f()
            if (r4 == 0) goto L_0x0091
            java.util.Map r4 = r0.mo9919i()
            if (r4 == 0) goto L_0x0091
            java.util.Map r4 = r0.mo9913f()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r4.get(r1)
            r2 = r4
            com.baidu.ar.blend.filter.configdata.FilterData r2 = (com.baidu.p020ar.blend.filter.configdata.FilterData) r2
            java.util.Map r4 = r0.mo9919i()
        L_0x0036:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r4.get(r5)
            com.baidu.ar.blend.gpuimage.a.g r4 = (com.baidu.p020ar.blend.gpuimage.p039a.C0712g) r4
            goto L_0x0092
        L_0x0041:
            java.lang.String r1 = "virtual_target"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0069
            java.util.Map r4 = r0.mo9916g()
            if (r4 == 0) goto L_0x0091
            java.util.Map r4 = r0.mo9920j()
            if (r4 == 0) goto L_0x0091
            java.util.Map r4 = r0.mo9916g()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r4.get(r1)
            r2 = r4
            com.baidu.ar.blend.filter.configdata.FilterData r2 = (com.baidu.p020ar.blend.filter.configdata.FilterData) r2
            java.util.Map r4 = r0.mo9920j()
            goto L_0x0036
        L_0x0069:
            java.lang.String r1 = "mix_target"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0091
            java.util.Map r4 = r0.mo9918h()
            if (r4 == 0) goto L_0x0091
            java.util.Map r4 = r0.mo9921k()
            if (r4 == 0) goto L_0x0091
            java.util.Map r4 = r0.mo9918h()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r4.get(r1)
            r2 = r4
            com.baidu.ar.blend.filter.configdata.FilterData r2 = (com.baidu.p020ar.blend.filter.configdata.FilterData) r2
            java.util.Map r4 = r0.mo9921k()
            goto L_0x0036
        L_0x0091:
            r4 = r2
        L_0x0092:
            if (r2 == 0) goto L_0x009d
            if (r4 == 0) goto L_0x009d
            com.baidu.ar.blend.filter.a.q r5 = com.baidu.p020ar.blend.filter.p038a.C0692p.m1703a(r2)
            r5.mo9923a(r4, r6)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.msghandler.C0808c.m2123a(java.lang.String, int, java.util.Map):void");
    }

    /* renamed from: b */
    private void m2124b(int i, String str) {
        C0674a a = C0701e.m1768a().mo9973a(i);
        if (a != null && !TextUtils.isEmpty(str)) {
            a.mo9893a(str.equals("0"));
        }
    }

    /* renamed from: b */
    private void m2125b(int i, String str, Map<String, Object> map) {
        C0712g a;
        C0712g a2;
        C0712g a3;
        Debug.print("bdar:techniqueId = " + i);
        C0674a a4 = C0701e.m1768a().mo9973a(i);
        if (a4 != null) {
            FilterData a5 = m2117a(a4.mo9887a(), map);
            int a6 = a5.mo9932a();
            C0694q a7 = C0692p.m1703a(a5);
            if (a7 != null && !TextUtils.isEmpty(str)) {
                if (str.equals("reality_target")) {
                    if (a4.mo9913f() != null && a4.mo9913f().get(Integer.valueOf(a6)) == null && (a3 = a7.mo9922a(a5)) != null) {
                        a4.mo9889a(a6, a5);
                        a4.mo9890a(a6, a3);
                    }
                } else if (str.equals("virtual_target")) {
                    if (a4.mo9916g() != null && a4.mo9916g().get(Integer.valueOf(a6)) == null && (a2 = a7.mo9922a(a5)) != null) {
                        a4.mo9896b(a6, a5);
                        a4.mo9897b(a6, a2);
                    }
                } else if (str.equals("mix_target") && a4.mo9918h() != null && a4.mo9918h().get(Integer.valueOf(a6)) == null && (a = a7.mo9922a(a5)) != null) {
                    a4.mo9902c(a6, a5);
                    a4.mo9903c(a6, a);
                }
            }
        }
    }

    /* renamed from: c */
    private void m2126c(int i, String str, Map<String, Object> map) {
        Debug.print("bdar:techniqueId = " + i);
        C0674a a = C0701e.m1768a().mo9973a(i);
        if (a != null) {
            int a2 = m2117a(a.mo9887a(), map).mo9932a();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("reality_target")) {
                a.mo9895b(a2);
                a.mo9911e(a2);
            } else if (str.equals("virtual_target")) {
                a.mo9901c(a2);
                a.mo9914f(a2);
            } else if (str.equals("mix_target")) {
                a.mo9907d(a2);
                a.mo9917g(a2);
            }
        }
    }

    public void parseComponentData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            int obj2Int = MsgParamsUtil.obj2Int(hashMap.get("action"), -1);
            Log.e("lua  ", " ArBridge.LuaSdkBridgeMessageType = " + obj2Int);
            switch (obj2Int) {
                case ComponentMessageType.MSG_TYPE_FILTER_START:
                    m2122a(MsgParamsUtil.obj2String(hashMap.get("file_path"), (String) null));
                    return;
                case ComponentMessageType.MSG_TYPE_FILTER_STOP:
                    m2118a();
                    return;
                case ComponentMessageType.MSG_TYPE_FILTER_UPDATE:
                    m2119a(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), (String) null);
                    return;
                case ComponentMessageType.MSG_TYPE_FILTER_DISABLE_TECHNIQUE:
                    m2124b(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get("disable"), "0"));
                    return;
                case ComponentMessageType.MSG_TYPE_FILTER_RESET:
                    switch (FilterData.ResetType.m1732a(MsgParamsUtil.obj2Int(hashMap.get("reset_type"), -1))) {
                        case UPDATE:
                            m2121a(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get("target"), (String) null), (Map<String, Object>) MsgParamsUtil.obj2HashMap(hashMap.get("pass"), (HashMap<String, Object>) null));
                            return;
                        case ADD:
                            m2125b(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get("target"), (String) null), MsgParamsUtil.obj2HashMap(hashMap.get("pass"), (HashMap<String, Object>) null));
                            return;
                        case DELETE:
                            m2126c(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get("target"), (String) null), MsgParamsUtil.obj2HashMap(hashMap.get("pass"), (HashMap<String, Object>) null));
                            return;
                        default:
                            return;
                    }
                case ComponentMessageType.MSG_TYPE_FILTER_DISABLE_TARGET:
                    m2120a(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get("target"), (String) null), MsgParamsUtil.obj2String(hashMap.get("disable"), "0"));
                    return;
                case ComponentMessageType.MSG_TYPE_FILTER_ADJUST:
                    try {
                        m2123a(MsgParamsUtil.obj2String(hashMap.get("target"), (String) null), Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("pass_id"), "-1")).intValue(), (Map<String, Object>) MsgParamsUtil.obj2HashMap(hashMap.get("adjust_params"), (HashMap<String, Object>) null));
                        return;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void release() {
        C0701e.m1768a().mo9976c();
        C0701e.m1772b();
        this.f1893a = null;
    }
}
