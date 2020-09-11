package com.meizu.media.camera;

import com.meizu.media.camera.util.CameraSizeUtil;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.v */
public class MzVideoSizeManager {

    /* renamed from: a */
    private String[] f14384a;

    /* renamed from: b */
    private String[] f14385b;

    /* renamed from: c */
    private String[] f14386c;

    /* renamed from: d */
    private String[] f14387d;

    public MzVideoSizeManager() {
        ArrayList<String> a = CameraSizeUtil.m16176a(0);
        m16303c((String[]) a.toArray(new String[a.size()]));
        MzCamcorderProfileManager mVar = new MzCamcorderProfileManager();
        ArrayList arrayList = new ArrayList();
        for (String valueOf : a) {
            mVar.mo20361a(0, Integer.valueOf(valueOf).intValue());
            int b = mVar.mo20363b();
            int c = mVar.mo20364c();
            arrayList.add(b + "x" + c);
        }
        m16301a((String[]) arrayList.toArray(new String[arrayList.size()]));
        ArrayList<String> a2 = CameraSizeUtil.m16176a(1);
        m16304d((String[]) a2.toArray(new String[a2.size()]));
        ArrayList arrayList2 = new ArrayList();
        for (String valueOf2 : a2) {
            mVar.mo20361a(1, Integer.valueOf(valueOf2).intValue());
            int b2 = mVar.mo20363b();
            int c2 = mVar.mo20364c();
            arrayList2.add(b2 + "x" + c2);
        }
        m16302b((String[]) arrayList2.toArray(new String[arrayList2.size()]));
    }

    /* renamed from: a */
    private void m16301a(String[] strArr) {
        this.f14386c = strArr;
    }

    /* renamed from: b */
    private void m16302b(String[] strArr) {
        this.f14387d = strArr;
    }

    /* renamed from: c */
    private void m16303c(String[] strArr) {
        this.f14384a = strArr;
    }

    /* renamed from: d */
    private void m16304d(String[] strArr) {
        this.f14385b = strArr;
    }

    /* renamed from: a */
    public String[] mo22760a() {
        return this.f14387d;
    }

    /* renamed from: b */
    public String[] mo22761b() {
        return this.f14386c;
    }

    /* renamed from: c */
    public String[] mo22762c() {
        return this.f14384a;
    }

    /* renamed from: d */
    public String[] mo22763d() {
        return this.f14385b;
    }
}
