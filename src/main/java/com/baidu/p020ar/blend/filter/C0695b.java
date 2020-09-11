package com.baidu.p020ar.blend.filter;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.p020ar.blend.filter.C0701e;
import com.baidu.p020ar.blend.filter.configdata.C0699c;
import com.baidu.p020ar.blend.p037b.C0640a;

/* renamed from: com.baidu.ar.blend.filter.b */
public class C0695b extends AsyncTask<String, Integer, C0699c> {

    /* renamed from: a */
    C0701e.C0704a<C0699c> f1403a;

    public C0695b(C0701e.C0704a<C0699c> aVar) {
        this.f1403a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0699c doInBackground(String... strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return C0700d.m1757a(str, C0640a.m1448a(str.concat(str2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C0699c cVar) {
        if (this.f1403a != null) {
            this.f1403a.mo9978a(cVar);
        }
    }
}
