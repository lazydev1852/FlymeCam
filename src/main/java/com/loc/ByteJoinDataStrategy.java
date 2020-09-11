package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.loc.ay */
public final class ByteJoinDataStrategy extends UpdateDataStrategy {

    /* renamed from: a */
    ByteArrayOutputStream f2624a = new ByteArrayOutputStream();

    public ByteJoinDataStrategy() {
    }

    public ByteJoinDataStrategy(UpdateDataStrategy beVar) {
        super(beVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo13039a(byte[] bArr) {
        byte[] byteArray = this.f2624a.toByteArray();
        try {
            this.f2624a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f2624a = new ByteArrayOutputStream();
        return byteArray;
    }

    /* renamed from: b */
    public final void mo13040b(byte[] bArr) {
        try {
            this.f2624a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
