package com.loc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* renamed from: com.loc.bd */
public final class StatisticsPubDataStrategy extends UpdateDataStrategy {
    public StatisticsPubDataStrategy() {
    }

    public StatisticsPubDataStrategy(UpdateDataStrategy beVar) {
        super(beVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo13039a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a = C1107dj.m3818a(stringBuffer.toString());
        byte[] bArr2 = new byte[(a.length + bArr.length)];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(bArr, 0, bArr2, a.length, bArr.length);
        return bArr2;
    }
}
