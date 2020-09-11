package com.loc;

import java.io.File;

/* renamed from: com.loc.bg */
public final class FileNumUpdateStrategy extends UpdateStrategy {

    /* renamed from: b */
    private int f2637b;

    /* renamed from: c */
    private String f2638c;

    public FileNumUpdateStrategy(int i, String str, UpdateStrategy bkVar) {
        super(bkVar);
        this.f2637b = i;
        this.f2638c = str;
    }

    /* renamed from: a */
    private static int m3088a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "fus", "gfn");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo13042a() {
        return m3088a(this.f2638c) >= this.f2637b;
    }
}
