package com.loc;

import android.text.TextUtils;
import com.baidu.p020ar.constants.HttpConstants;
import java.net.Proxy;
import java.util.Map;

/* renamed from: com.loc.am */
public abstract class Request {

    /* renamed from: c */
    int f2584c = HttpConstants.HTTP_CONNECT_TIMEOUT;

    /* renamed from: d */
    int f2585d = HttpConstants.HTTP_CONNECT_TIMEOUT;

    /* renamed from: e */
    Proxy f2586e = null;

    /* renamed from: a */
    public abstract Map<String, String> mo12965a();

    /* renamed from: a */
    public final void mo13021a(int i) {
        this.f2584c = i;
    }

    /* renamed from: a */
    public final void mo13022a(Proxy proxy) {
        this.f2586e = proxy;
    }

    /* renamed from: b */
    public abstract Map<String, String> mo12966b();

    /* renamed from: b */
    public final void mo13023b(int i) {
        this.f2585d = i;
    }

    /* renamed from: c */
    public abstract String mo12967c();

    /* renamed from: d */
    public byte[] mo12997d() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String mo13024k() {
        return "";
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final boolean mo13025l() {
        return !TextUtils.isEmpty(mo13024k());
    }
}
