package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import com.loc.DownloadManager;
import com.loc.DynamicPlugin;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.loc.r */
public final class DexDownLoad implements DownloadManager.C1050a {

    /* renamed from: a */
    protected DexDownloadItem f3392a;

    /* renamed from: b */
    protected SDKInfo f3393b;

    /* renamed from: c */
    protected String f3394c;

    /* renamed from: d */
    protected RandomAccessFile f3395d;

    /* renamed from: e */
    protected Context f3396e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DownloadManager f3397f;

    /* renamed from: com.loc.r$a */
    /* compiled from: DexDownLoad */
    class C1113a implements Runnable {

        /* renamed from: b */
        private int f3399b = 0;

        /* renamed from: c */
        private DBOperation f3400c;

        /* renamed from: d */
        private String f3401d;

        C1113a() {
        }

        C1113a(DBOperation nVar) {
            this.f3400c = nVar;
        }

        public final void run() {
            String str;
            String str2;
            switch (this.f3399b) {
                case 0:
                    try {
                        if (DexDownLoad.this.mo13310b()) {
                            StatisticsEntity avVar = new StatisticsEntity(DexDownLoad.this.f3396e, DexDownLoad.this.f3393b.mo13272a(), DexDownLoad.this.f3393b.mo13274b(), "O008");
                            avVar.mo13034a("{\"param_int_first\":0}");
                            StatisticsManager.m3067a(avVar, DexDownLoad.this.f3396e);
                            DexDownLoad.this.f3397f.mo13005a(DexDownLoad.this);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        str = "dDownLoad";
                        str2 = "run()";
                        break;
                    }
                case 1:
                case 2:
                    try {
                        DexFileManager.m3930a(DexDownLoad.this.f3396e, this.f3400c, DexDownLoad.this.f3393b, DexDownLoad.this.f3394c, DexDownLoad.this.f3392a.f3406e);
                        DexFileManager.m3929a(DexDownLoad.this.f3396e, DexDownLoad.this.f3393b);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        str = "dDownLoad";
                        str2 = "onFinish2";
                        break;
                    }
                case 3:
                    try {
                        DexFileManager.m3930a(DexDownLoad.this.f3396e, this.f3400c, DexDownLoad.this.f3393b, DexDownLoad.this.f3394c, this.f3401d);
                        DexFileManager.m3929a(DexDownLoad.this.f3396e, DexDownLoad.this.f3393b);
                        return;
                    } catch (Throwable th3) {
                        BasicLogHandler.m3844a(th3, "dDownLoad", "processDownloadedFile()");
                        return;
                    }
                default:
                    return;
            }
            BasicLogHandler.m3844a(th, str, str2);
        }
    }

    public DexDownLoad(Context context, DexDownloadItem sVar, SDKInfo diVar) {
        try {
            this.f3396e = context.getApplicationContext();
            this.f3393b = diVar;
            if (sVar != null) {
                this.f3392a = sVar;
                this.f3397f = new DownloadManager(new DexDownLoadRequest(this.f3392a));
                this.f3394c = DexFileManager.m3926a(context, this.f3392a.f3403b);
            }
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    /* renamed from: a */
    public final void mo13309a() {
        try {
            LoaderFactory.m3976b().mo13332a().submit(new C1113a());
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "dDownLoad", "startDownload()");
        }
    }

    /* renamed from: a */
    public final void mo13006a(byte[] bArr, long j) {
        try {
            if (this.f3395d == null) {
                File file = new File(this.f3394c);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f3395d = new RandomAccessFile(file, "rw");
            }
            this.f3395d.seek(j);
            this.f3395d.write(bArr);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "dDownLoad", "onDownload()");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b A[Catch:{ Throwable -> 0x0068 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo13310b() {
        /*
            r5 = this;
            com.loc.s r0 = r5.f3392a
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.loc.s r0 = r5.f3392a
            boolean r0 = r0.mo13315c()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            android.content.Context r3 = r5.f3396e     // Catch:{ Throwable -> 0x0068 }
            boolean r3 = com.loc.C1107dj.m3822b((android.content.Context) r3)     // Catch:{ Throwable -> 0x0068 }
            if (r3 != 0) goto L_0x0067
            com.loc.di r3 = r5.f3393b     // Catch:{ Throwable -> 0x0068 }
            com.loc.s r4 = r5.f3392a     // Catch:{ Throwable -> 0x0068 }
            boolean r3 = com.loc.C1120z.m3987a((com.loc.SDKInfo) r3, (com.loc.DexDownloadItem) r4)     // Catch:{ Throwable -> 0x0068 }
            if (r3 == 0) goto L_0x0067
            com.loc.s r3 = r5.f3392a     // Catch:{ Throwable -> 0x0068 }
            boolean r3 = com.loc.C1120z.m3990a((com.loc.DexDownloadItem) r3)     // Catch:{ Throwable -> 0x0068 }
            if (r3 == 0) goto L_0x0067
            android.content.Context r3 = r5.f3396e     // Catch:{ Throwable -> 0x0068 }
            boolean r0 = com.loc.C1120z.m3986a((android.content.Context) r3, (boolean) r0)     // Catch:{ Throwable -> 0x0068 }
            if (r0 == 0) goto L_0x0067
            android.content.Context r0 = r5.f3396e     // Catch:{ Throwable -> 0x0068 }
            com.loc.s r3 = r5.f3392a     // Catch:{ Throwable -> 0x0068 }
            com.loc.di r4 = r5.f3393b     // Catch:{ Throwable -> 0x0068 }
            boolean r0 = com.loc.C1120z.m3985a(r0, r3, r4)     // Catch:{ Throwable -> 0x0068 }
            if (r0 != 0) goto L_0x0067
            android.content.Context r0 = r5.f3396e     // Catch:{ Throwable -> 0x0068 }
            com.loc.di r3 = r5.f3393b     // Catch:{ Throwable -> 0x0068 }
            com.loc.s r3 = r5.f3392a     // Catch:{ Throwable -> 0x0068 }
            boolean r4 = r3.mo13316d()     // Catch:{ Throwable -> 0x0068 }
            if (r4 == 0) goto L_0x004d
        L_0x004b:
            r0 = 1
            goto L_0x0059
        L_0x004d:
            boolean r3 = r3.mo13317e()     // Catch:{ Throwable -> 0x0068 }
            boolean r0 = com.loc.C1107dj.m3816a((android.content.Context) r0, (boolean) r3)     // Catch:{ Throwable -> 0x0068 }
            if (r0 != 0) goto L_0x0058
            goto L_0x004b
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 == 0) goto L_0x0067
            android.content.Context r0 = r5.f3396e     // Catch:{ Throwable -> 0x0068 }
            com.loc.di r3 = r5.f3393b     // Catch:{ Throwable -> 0x0068 }
            java.lang.String r3 = r3.mo13272a()     // Catch:{ Throwable -> 0x0068 }
            com.loc.DexFileManager.m3936b(r0, r3)     // Catch:{ Throwable -> 0x0068 }
            return r1
        L_0x0067:
            return r2
        L_0x0068:
            r0 = move-exception
            java.lang.String r1 = "dDownLoad"
            java.lang.String r3 = "isNeedDownload()"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DexDownLoad.mo13310b():boolean");
    }

    /* renamed from: c */
    public final void mo13007c() {
        try {
            C1120z.m3982a((Closeable) this.f3395d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    public final void mo13008d() {
        try {
            if (this.f3395d != null) {
                C1120z.m3982a((Closeable) this.f3395d);
                String b = this.f3392a.mo13314b();
                if (C1120z.m3991a(this.f3394c, b)) {
                    String str = this.f3392a.f3405d;
                    DBOperation nVar = new DBOperation(this.f3396e, DynamicFileDBCreator.m3942b());
                    nVar.mo13301a((Object) new DynamicPlugin.C1116a(this.f3392a.f3403b, b, this.f3392a.f3404c, str, this.f3392a.f3406e).mo13327a("copy").mo13328a(), DynamicPlugin.m3947a(this.f3392a.f3403b, this.f3392a.f3404c, str, this.f3392a.f3406e));
                    SharedPreferences.Editor edit = this.f3396e.getSharedPreferences(this.f3392a.f3404c, 0).edit();
                    edit.clear();
                    edit.commit();
                    try {
                        LoaderFactory.m3976b().mo13332a().submit(new C1113a(nVar));
                    } catch (Throwable th) {
                        BasicLogHandler.m3844a(th, "dDownLoad", "onFinish1");
                    }
                    StatisticsEntity avVar = new StatisticsEntity(this.f3396e, this.f3393b.mo13272a(), this.f3393b.mo13274b(), "O008");
                    avVar.mo13034a("{\"param_int_first\":1}");
                    StatisticsManager.m3067a(avVar, this.f3396e);
                    return;
                }
                try {
                    new File(this.f3394c).delete();
                } catch (Throwable th2) {
                    BasicLogHandler.m3844a(th2, "dDownLoad", "onFinish");
                }
            }
        } catch (Throwable th3) {
            BasicLogHandler.m3844a(th3, "dDownLoad", "onFinish()");
        }
    }

    /* renamed from: e */
    public final void mo13009e() {
    }
}
