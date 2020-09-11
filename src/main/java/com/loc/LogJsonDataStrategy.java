package com.loc;

import com.baidu.p020ar.util.SystemInfoUtil;

/* renamed from: com.loc.bb */
public final class LogJsonDataStrategy extends UpdateDataStrategy {

    /* renamed from: a */
    private StringBuilder f2630a = new StringBuilder();

    /* renamed from: b */
    private boolean f2631b = true;

    public LogJsonDataStrategy() {
    }

    public LogJsonDataStrategy(UpdateDataStrategy beVar) {
        super(beVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo13039a(byte[] bArr) {
        byte[] a = C1107dj.m3818a(this.f2630a.toString());
        this.f2636d = a;
        this.f2631b = true;
        this.f2630a.delete(0, this.f2630a.length());
        return a;
    }

    /* renamed from: b */
    public final void mo13040b(byte[] bArr) {
        String a = C1107dj.m3810a(bArr);
        if (this.f2631b) {
            this.f2631b = false;
        } else {
            this.f2630a.append(SystemInfoUtil.COMMA);
        }
        StringBuilder sb = this.f2630a;
        sb.append("{\"log\":\"");
        sb.append(a);
        sb.append("\"}");
    }
}
