package com.loc;

/* renamed from: com.loc.s */
public final class DexDownloadItem {

    /* renamed from: a */
    protected String f3402a;

    /* renamed from: b */
    String f3403b;

    /* renamed from: c */
    String f3404c;

    /* renamed from: d */
    String f3405d;

    /* renamed from: e */
    String f3406e;

    /* renamed from: f */
    int f3407f;

    /* renamed from: g */
    int f3408g;

    /* renamed from: h */
    private String f3409h;

    /* renamed from: i */
    private boolean f3410i;

    /* renamed from: j */
    private boolean f3411j;

    /* renamed from: k */
    private boolean f3412k;

    public DexDownloadItem(String str, String str2, boolean z) {
        this(str, str2, z, (byte) 0);
    }

    private DexDownloadItem(String str, String str2, boolean z, byte b) {
        this.f3410i = false;
        this.f3411j = false;
        this.f3412k = true;
        this.f3402a = str;
        this.f3409h = str2;
        this.f3410i = false;
        this.f3412k = z;
        try {
            String[] split = str.split("/");
            int length = split.length;
            if (length > 1) {
                this.f3403b = split[length - 1];
                String[] split2 = this.f3403b.split("_");
                this.f3404c = split2[0];
                this.f3405d = split2[2];
                this.f3406e = split2[1];
                this.f3407f = Integer.parseInt(split2[3]);
                this.f3408g = Integer.parseInt(split2[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo13312a() {
        return this.f3402a;
    }

    /* renamed from: a */
    public final void mo13313a(boolean z) {
        this.f3411j = z;
    }

    /* renamed from: b */
    public final String mo13314b() {
        return this.f3409h;
    }

    /* renamed from: c */
    public final boolean mo13315c() {
        return this.f3410i;
    }

    /* renamed from: d */
    public final boolean mo13316d() {
        return this.f3411j;
    }

    /* renamed from: e */
    public final boolean mo13317e() {
        return this.f3412k;
    }
}
