package com.meizu.update.p085c.p088c;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.update.p085c.p087b.RelocateHelper;
import com.meizu.update.p085c.p087b.RelocateProxyInfo;
import com.meizu.update.p085c.p087b.TransformUrlInfo;
import com.meizu.update.util.Loger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.update.c.c.b */
public class DownloadRetryTracker implements IRetryTracker {

    /* renamed from: a */
    private final int f16181a;

    /* renamed from: b */
    private boolean f16182b = false;

    /* renamed from: c */
    private int f16183c = -1;

    /* renamed from: d */
    private List<String> f16184d;

    /* renamed from: e */
    private int f16185e = 0;

    /* renamed from: f */
    private boolean f16186f = false;

    /* renamed from: g */
    private int f16187g = 0;

    /* renamed from: b */
    public TransformUrlInfo mo24737b(Context context, String str) {
        return null;
    }

    public DownloadRetryTracker(int i) {
        this.f16181a = i;
    }

    /* renamed from: a */
    public void mo24735a() {
        this.f16183c++;
        if (this.f16186f) {
            this.f16186f = false;
            int i = this.f16187g + 1;
            this.f16187g = i;
            if (i <= 10) {
                Loger.m17942c("Reduce download time while relocate 302: " + this.f16187g);
                this.f16183c = this.f16183c + -1;
            }
        }
        Loger.m17942c("start download time: " + (this.f16183c + 1));
    }

    /* renamed from: b */
    public boolean mo24738b() {
        return this.f16183c < this.f16181a;
    }

    /* renamed from: a */
    public void mo24736a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f16184d == null) {
                this.f16184d = new ArrayList(1);
            } else {
                this.f16184d.clear();
            }
            this.f16184d.add(str);
            this.f16185e = 0;
            return;
        }
        this.f16184d = null;
    }

    /* renamed from: c */
    public String mo24739c() {
        if (this.f16184d == null || this.f16184d.size() <= this.f16185e) {
            return null;
        }
        List<String> list = this.f16184d;
        int i = this.f16185e;
        this.f16185e = i + 1;
        return list.get(i);
    }

    /* renamed from: a */
    public TransformUrlInfo mo24734a(Context context, String str) {
        if (!this.f16182b) {
            RelocateProxyInfo a = new RelocateHelper().mo24718a(context);
            if (a != null) {
                this.f16187g = 0;
                this.f16182b = true;
                TransformUrlInfo a2 = a.mo24720a(str);
                if (a2 != null) {
                    Loger.m17943d("Transform url success: " + a2.f16170a);
                    return a2;
                }
                Loger.m17943d("Cant transform url: " + str + ", proxy: " + a);
                return null;
            }
            Loger.m17943d("Get relocate ip failed!");
            return null;
        }
        Loger.m17943d("Relocate had used before!");
        return null;
    }

    /* renamed from: d */
    public void mo24740d() {
        if (this.f16182b) {
            this.f16182b = false;
        }
        RelocateHelper.m17588a();
    }

    /* renamed from: e */
    public void mo24741e() {
        this.f16186f = true;
    }
}
