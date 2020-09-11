package com.meizu.update.p085c.p087b;

import android.text.TextUtils;
import android.util.Pair;
import com.meizu.update.p085c.p088c.IFileChecker;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.update.c.b.c */
public class TransformUrlInfo {

    /* renamed from: a */
    public String f16170a;

    /* renamed from: b */
    public List<Pair<String, String>> f16171b;

    public TransformUrlInfo(String str, List<Pair<String, String>> list) {
        this.f16170a = str;
        this.f16171b = list;
    }

    /* renamed from: a */
    public void mo24724a(IFileChecker dVar) {
        if (dVar != null) {
            String a = dVar.mo24728a();
            String b = dVar.mo24730b();
            long c = dVar.mo24731c();
            if (!TextUtils.isEmpty(a) || !TextUtils.isEmpty(b) || c > 0) {
                if (this.f16171b == null) {
                    this.f16171b = new ArrayList(2);
                }
                if (!TextUtils.isEmpty(a)) {
                    this.f16171b.add(new Pair("Mz_md5", a));
                }
                if (!TextUtils.isEmpty(b)) {
                    this.f16171b.add(new Pair("Mz_partial_md5", b));
                }
                if (c > 0) {
                    this.f16171b.add(new Pair("Mz_size", String.valueOf(c)));
                }
            }
        }
    }
}
