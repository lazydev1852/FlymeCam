package com.baidu.p020ar.msghandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* renamed from: com.baidu.ar.msghandler.e */
public class C0812e {

    /* renamed from: a */
    private static C0812e f1897a;

    /* renamed from: b */
    private Handler f1898b;

    private C0812e() {
    }

    /* renamed from: a */
    public static C0812e m2129a() {
        if (f1897a == null) {
            f1897a = new C0812e();
        }
        return f1897a;
    }

    /* renamed from: b */
    private void m2130b(int i, Bundle bundle) {
        if (this.f1898b != null) {
            Message obtainMessage = this.f1898b.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.setData(bundle);
            this.f1898b.sendMessage(obtainMessage);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        if (r2 != 999999) goto L_0x000e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10287a(int r2, android.os.Bundle r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = 30000(0x7530, float:4.2039E-41)
            if (r2 == r0) goto L_0x000b
            r0 = 999999(0xf423f, float:1.401297E-39)
            if (r2 == r0) goto L_0x000b
            goto L_0x000e
        L_0x000b:
            r1.m2130b(r0, r3)     // Catch:{ all -> 0x0010 }
        L_0x000e:
            monitor-exit(r1)
            return
        L_0x0010:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.msghandler.C0812e.mo10287a(int, android.os.Bundle):void");
    }

    /* renamed from: a */
    public void mo10288a(Handler handler) {
        this.f1898b = handler;
    }
}
