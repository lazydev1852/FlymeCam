package com.baidu.p020ar.blend.filter;

import android.os.AsyncTask;
import com.baidu.p020ar.blend.filter.C0701e;
import com.baidu.p020ar.blend.filter.configdata.C0697a;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.ar.blend.filter.c */
public class C0696c extends AsyncTask<List<C0697a>, Integer, Map<Integer, C0674a>> {

    /* renamed from: a */
    C0701e.C0704a<Map<Integer, C0674a>> f1404a;

    public C0696c(C0701e.C0704a<Map<Integer, C0674a>> aVar) {
        this.f1404a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<Integer, C0674a> doInBackground(List<C0697a>... listArr) {
        return C0700d.m1758a(listArr[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Map<Integer, C0674a> map) {
        if (this.f1404a != null) {
            this.f1404a.mo9978a(map);
        }
    }
}
