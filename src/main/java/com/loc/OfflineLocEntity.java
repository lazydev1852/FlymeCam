package com.loc;

import android.content.Context;

/* renamed from: com.loc.at */
public final class OfflineLocEntity {

    /* renamed from: a */
    private Context f2602a;

    /* renamed from: b */
    private SDKInfo f2603b;

    /* renamed from: c */
    private String f2604c;

    public OfflineLocEntity(Context context, SDKInfo diVar, String str) {
        this.f2602a = context.getApplicationContext();
        this.f2603b = diVar;
        this.f2604c = str;
    }

    /* renamed from: a */
    private static String m3055a(Context context, SDKInfo diVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(diVar.mo13275c());
            sb.append("\",\"product\":\"");
            sb.append(diVar.mo13272a());
            sb.append("\",\"nt\":\"");
            sb.append(DeviceInfo.m3715e(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final byte[] mo13031a() {
        return C1107dj.m3818a(m3055a(this.f2602a, this.f2603b, this.f2604c));
    }
}
