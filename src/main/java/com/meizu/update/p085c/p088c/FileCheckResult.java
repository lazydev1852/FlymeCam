package com.meizu.update.p085c.p088c;

/* renamed from: com.meizu.update.c.c.c */
public class FileCheckResult {

    /* renamed from: a */
    private final boolean f16188a;

    /* renamed from: b */
    private final String f16189b;

    private FileCheckResult(boolean z, String str) {
        this.f16188a = z;
        this.f16189b = str;
    }

    /* renamed from: a */
    protected static FileCheckResult m17616a() {
        return new FileCheckResult(true, (String) null);
    }

    /* renamed from: a */
    protected static FileCheckResult m17617a(String str) {
        return new FileCheckResult(false, str);
    }

    /* renamed from: b */
    public boolean mo24742b() {
        return this.f16188a;
    }

    /* renamed from: c */
    public String mo24743c() {
        return this.f16189b;
    }
}
