package com.meizu.update.p085c.p086a;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.update.p085c.CancelException;
import com.meizu.update.p085c.IDownloader;
import com.meizu.update.p085c.p088c.IFileChecker;
import com.meizu.update.p085c.p088c.IRetryTracker;
import com.meizu.update.p085c.p089d.DownloadUsageCollector;
import com.meizu.update.util.Loger;

/* renamed from: com.meizu.update.c.a.a */
public class RetryDownloader {

    /* renamed from: a */
    private IRetryTracker f16146a;

    /* renamed from: b */
    private IFileChecker f16147b;

    /* renamed from: c */
    private IDownloader f16148c;

    /* renamed from: d */
    private String f16149d;

    /* renamed from: e */
    private boolean f16150e;

    /* renamed from: f */
    private DownloadUsageCollector f16151f;

    public RetryDownloader(Context context, String str, IDownloader dVar, IRetryTracker eVar) {
        if (TextUtils.isEmpty(str) || dVar == null || eVar == null) {
            throw new IllegalArgumentException("Params cant be null!");
        }
        this.f16149d = str;
        this.f16148c = dVar;
        this.f16150e = false;
        this.f16146a = eVar;
        this.f16151f = new DownloadUsageCollector(context);
    }

    /* renamed from: a */
    public void mo24709a(IFileChecker dVar) {
        this.f16147b = dVar;
        this.f16148c.mo24713a(dVar);
    }

    /* renamed from: a */
    public void mo24708a() {
        this.f16150e = true;
        this.f16148c.mo24711a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02a5, code lost:
        r1.f16151f.mo24748b(r24.getPackageName(), r1.f16149d, r10, "User Canceled", r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        r0 = r3.mo24739c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009e, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a0, code lost:
        r4 = r0;
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
        m17570b();
        r0 = r3.mo24734a(r2, r1.f16149d);
        m17570b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        if (r0 != null) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        r0.mo24724a(r1.f16147b);
        r13 = r0.f16170a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if (r0.f16171b != null) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bc, code lost:
        r1.f16148c.mo24715a(r0.f16171b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c3, code lost:
        m17569a("Trans to proxy server request");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ca, code lost:
        if (r1.f16147b != null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cc, code lost:
        m17569a("Disable file checker!");
        r1.f16147b.mo24729a(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d6, code lost:
        r1.f16151f.mo24749c(r24.getPackageName(), r1.f16149d, r13, "Got relocate url", r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e6, code lost:
        r4 = r13;
        r0 = false;
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e9, code lost:
        r7 = r4;
        r5 = null;
        r13 = true;
        r4 = r0;
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f1, code lost:
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r1.f16151f.mo24747b(r24.getPackageName(), r1.f16149d, 100001, r4, "Cant trans to proxy server.", r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0109, code lost:
        r1.f16151f.mo24747b(r24.getPackageName(), r1.f16149d, 100001, r4, "Cant trans to proxy server.", r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0143, code lost:
        m17569a("Relocate and re proxy success");
        r4 = r0.f16170a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014c, code lost:
        if (r0.f16171b != null) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014e, code lost:
        r1.f16148c.mo24715a(r0.f16171b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b6, code lost:
        r5.mo24724a(r1.f16147b);
        r7 = r5.f16170a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01bf, code lost:
        if (r5.f16171b != null) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c1, code lost:
        r1.f16148c.mo24715a(r5.f16171b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c8, code lost:
        m17569a("Re proxy success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01cd, code lost:
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01cf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d0, code lost:
        r10 = r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:120:0x0240 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x028a */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0109 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01f7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x025f A[EDGE_INSN: B:158:0x025f->B:123:0x025f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049 A[ExcHandler: c (e com.meizu.update.c.c), Splitter:B:12:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[ExcHandler: f (e com.meizu.update.c.f), Splitter:B:12:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096 A[Catch:{ a -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0143 A[Catch:{ a -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b6 A[Catch:{ a -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01f8  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo24710a(android.content.Context r24) throws com.meizu.update.p085c.CancelException, com.meizu.update.p085c.LoadException {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            com.meizu.update.c.c.e r3 = r1.f16146a
            java.lang.String r0 = r1.f16149d
            com.meizu.update.c.c.d r4 = r1.f16147b
            r6 = 0
            if (r4 == 0) goto L_0x0019
            com.meizu.update.c.c.d r4 = r1.f16147b
            java.lang.String r4 = r4.mo24732d()
            r22 = r4
            r13 = 0
            r14 = 0
            r4 = r0
            goto L_0x001e
        L_0x0019:
            r4 = r0
            r13 = 0
            r14 = 0
            r22 = 0
        L_0x001e:
            r15 = 1
            r23.m17570b()     // Catch:{ a -> 0x02a0 }
            if (r3 == 0) goto L_0x0027
            r3.mo24735a()     // Catch:{ a -> 0x02a0 }
        L_0x0027:
            com.meizu.update.c.d r0 = r1.f16148c     // Catch:{ f -> 0x01d8, e -> 0x015b, g -> 0x011e, c -> 0x0076 }
            r0.mo24714a((java.lang.String) r4)     // Catch:{ f -> 0x01d8, e -> 0x015b, g -> 0x011e, c -> 0x0076 }
            com.meizu.update.c.d r0 = r1.f16148c     // Catch:{ f -> 0x01d8, e -> 0x015b, g -> 0x011e, c -> 0x0076 }
            boolean r16 = r0.mo24716a((boolean) r15)     // Catch:{ f -> 0x01d8, e -> 0x015b, g -> 0x011e, c -> 0x0076 }
            if (r16 != 0) goto L_0x0056
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ f -> 0x0053, e -> 0x004f, g -> 0x004b, c -> 0x0049 }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ f -> 0x0053, e -> 0x004f, g -> 0x004b, c -> 0x0049 }
            java.lang.String r9 = r1.f16149d     // Catch:{ f -> 0x0053, e -> 0x004f, g -> 0x004b, c -> 0x0049 }
            r10 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r12 = "Uncaugth http exception."
            r11 = r4
            r13 = r22
            r7.mo24747b(r8, r9, r10, r11, r12, r13)     // Catch:{ f -> 0x0053, e -> 0x004f, g -> 0x004b, c -> 0x0049 }
            r13 = 1
            goto L_0x006a
        L_0x0049:
            r0 = move-exception
            goto L_0x0079
        L_0x004b:
            r0 = move-exception
            r13 = 1
            goto L_0x0121
        L_0x004f:
            r0 = move-exception
            r13 = 1
            goto L_0x015e
        L_0x0053:
            r0 = move-exception
            goto L_0x01db
        L_0x0056:
            if (r14 != 0) goto L_0x005a
            if (r13 == 0) goto L_0x006a
        L_0x005a:
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ f -> 0x0053, e -> 0x0073, g -> 0x0070, c -> 0x0049 }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ f -> 0x0053, e -> 0x0073, g -> 0x0070, c -> 0x0049 }
            java.lang.String r9 = r1.f16149d     // Catch:{ f -> 0x0053, e -> 0x0073, g -> 0x0070, c -> 0x0049 }
            java.lang.String r11 = "Download success"
            r10 = r4
            r12 = r22
            r7.mo24746a(r8, r9, r10, r11, r12)     // Catch:{ f -> 0x0053, e -> 0x0073, g -> 0x0070, c -> 0x0049 }
        L_0x006a:
            r7 = r4
            r0 = 0
        L_0x006c:
            r4 = 0
            r5 = 0
            goto L_0x01f5
        L_0x0070:
            r0 = move-exception
            goto L_0x0121
        L_0x0073:
            r0 = move-exception
            goto L_0x015e
        L_0x0076:
            r0 = move-exception
            r16 = 0
        L_0x0079:
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ a -> 0x029d }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ a -> 0x029d }
            java.lang.String r9 = r1.f16149d     // Catch:{ a -> 0x029d }
            int r10 = r0.mo24725a()     // Catch:{ a -> 0x029d }
            java.lang.String r12 = r0.getMessage()     // Catch:{ a -> 0x029d }
            r11 = r4
            r13 = r22
            r7.mo24745a(r8, r9, r10, r11, r12, r13)     // Catch:{ a -> 0x029d }
            java.lang.String r0 = "Handle FileIllegalException!"
            r1.m17569a((java.lang.String) r0)     // Catch:{ a -> 0x029d }
            if (r3 == 0) goto L_0x0109
            java.lang.String r0 = r3.mo24739c()     // Catch:{ a -> 0x029d }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ a -> 0x029d }
            if (r7 != 0) goto L_0x00a3
            r4 = r0
            r0 = 1
            goto L_0x00e9
        L_0x00a3:
            r23.m17570b()     // Catch:{ a -> 0x029d }
            java.lang.String r0 = r1.f16149d     // Catch:{ a -> 0x029d }
            com.meizu.update.c.b.c r0 = r3.mo24734a(r2, r0)     // Catch:{ a -> 0x029d }
            r23.m17570b()     // Catch:{ a -> 0x029d }
            if (r0 == 0) goto L_0x00f4
            com.meizu.update.c.c.d r7 = r1.f16147b     // Catch:{ a -> 0x029d }
            r0.mo24724a(r7)     // Catch:{ a -> 0x029d }
            java.lang.String r13 = r0.f16170a     // Catch:{ a -> 0x029d }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r4 = r0.f16171b     // Catch:{ a -> 0x00f0 }
            if (r4 == 0) goto L_0x00c3
            com.meizu.update.c.d r4 = r1.f16148c     // Catch:{ a -> 0x00f0 }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r0 = r0.f16171b     // Catch:{ a -> 0x00f0 }
            r4.mo24715a((java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) r0)     // Catch:{ a -> 0x00f0 }
        L_0x00c3:
            java.lang.String r0 = "Trans to proxy server request"
            r1.m17569a((java.lang.String) r0)     // Catch:{ a -> 0x00f0 }
            com.meizu.update.c.c.d r0 = r1.f16147b     // Catch:{ a -> 0x00f0 }
            if (r0 == 0) goto L_0x00d6
            java.lang.String r0 = "Disable file checker!"
            r1.m17569a((java.lang.String) r0)     // Catch:{ a -> 0x00f0 }
            com.meizu.update.c.c.d r0 = r1.f16147b     // Catch:{ a -> 0x00f0 }
            r0.mo24729a((boolean) r6)     // Catch:{ a -> 0x00f0 }
        L_0x00d6:
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ a -> 0x00f0 }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ a -> 0x00f0 }
            java.lang.String r9 = r1.f16149d     // Catch:{ a -> 0x00f0 }
            java.lang.String r11 = "Got relocate url"
            r10 = r13
            r12 = r22
            r7.mo24749c(r8, r9, r10, r11, r12)     // Catch:{ a -> 0x00f0 }
            r4 = r13
            r0 = 0
            r14 = 1
        L_0x00e9:
            r7 = r4
            r5 = 0
            r13 = 1
            r4 = r0
            r0 = 0
            goto L_0x01f5
        L_0x00f0:
            r0 = move-exception
            r10 = r13
            goto L_0x02a3
        L_0x00f4:
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ a -> 0x029d }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ a -> 0x029d }
            java.lang.String r9 = r1.f16149d     // Catch:{ a -> 0x029d }
            r10 = 100001(0x186a1, float:1.40131E-40)
            java.lang.String r12 = "Cant trans to proxy server."
            r11 = r4
            r13 = r22
            r7.mo24747b(r8, r9, r10, r11, r12, r13)     // Catch:{ a -> 0x029d }
            goto L_0x029b
        L_0x0109:
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ a -> 0x029d }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ a -> 0x029d }
            java.lang.String r9 = r1.f16149d     // Catch:{ a -> 0x029d }
            r10 = 100001(0x186a1, float:1.40131E-40)
            java.lang.String r12 = "Cant trans to proxy server."
            r11 = r4
            r13 = r22
            r7.mo24747b(r8, r9, r10, r11, r12, r13)     // Catch:{ a -> 0x029d }
            goto L_0x029b
        L_0x011e:
            r0 = move-exception
            r16 = 0
        L_0x0121:
            java.lang.String r7 = r0.getMessage()     // Catch:{ a -> 0x02a0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ a -> 0x02a0 }
            r0.<init>()     // Catch:{ a -> 0x02a0 }
            java.lang.String r8 = "Relocate to: "
            r0.append(r8)     // Catch:{ a -> 0x02a0 }
            r0.append(r7)     // Catch:{ a -> 0x02a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ a -> 0x02a0 }
            r1.m17569a((java.lang.String) r0)     // Catch:{ a -> 0x02a0 }
            if (r3 == 0) goto L_0x0156
            if (r14 == 0) goto L_0x0156
            com.meizu.update.c.b.c r0 = r3.mo24737b(r2, r7)     // Catch:{ a -> 0x0296 }
            if (r0 == 0) goto L_0x0156
            java.lang.String r4 = "Relocate and re proxy success"
            r1.m17569a((java.lang.String) r4)     // Catch:{ a -> 0x0296 }
            java.lang.String r4 = r0.f16170a     // Catch:{ a -> 0x0296 }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r7 = r0.f16171b     // Catch:{ a -> 0x02a0 }
            if (r7 == 0) goto L_0x0157
            com.meizu.update.c.d r7 = r1.f16148c     // Catch:{ a -> 0x02a0 }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r0 = r0.f16171b     // Catch:{ a -> 0x02a0 }
            r7.mo24715a((java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) r0)     // Catch:{ a -> 0x02a0 }
            goto L_0x0157
        L_0x0156:
            r4 = r7
        L_0x0157:
            r7 = r4
            r0 = 1
            goto L_0x006c
        L_0x015b:
            r0 = move-exception
            r16 = 0
        L_0x015e:
            int r12 = r0.mo24752a()     // Catch:{ a -> 0x02a0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ a -> 0x02a0 }
            r7.<init>()     // Catch:{ a -> 0x02a0 }
            java.lang.String r8 = "LoadException: "
            r7.append(r8)     // Catch:{ a -> 0x02a0 }
            r7.append(r12)     // Catch:{ a -> 0x02a0 }
            java.lang.String r7 = r7.toString()     // Catch:{ a -> 0x02a0 }
            r1.m17569a((java.lang.String) r7)     // Catch:{ a -> 0x02a0 }
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ a -> 0x029d }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ a -> 0x029d }
            java.lang.String r9 = r1.f16149d     // Catch:{ a -> 0x029d }
            java.lang.String r13 = "Http response code error"
            r10 = r12
            r11 = r4
            r5 = r12
            r12 = r13
            r13 = r22
            r7.mo24747b(r8, r9, r10, r11, r12, r13)     // Catch:{ a -> 0x029d }
            if (r14 == 0) goto L_0x01d3
            r7 = 401(0x191, float:5.62E-43)
            if (r5 != r7) goto L_0x01d3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ a -> 0x029d }
            r7.<init>()     // Catch:{ a -> 0x029d }
            java.lang.String r8 = "Proxy auth exception:"
            r7.append(r8)     // Catch:{ a -> 0x029d }
            r7.append(r5)     // Catch:{ a -> 0x029d }
            java.lang.String r5 = r7.toString()     // Catch:{ a -> 0x029d }
            r1.m17569a((java.lang.String) r5)     // Catch:{ a -> 0x029d }
            com.meizu.update.c.c.e r5 = r1.f16146a     // Catch:{ a -> 0x029d }
            r5.mo24740d()     // Catch:{ a -> 0x029d }
            r23.m17570b()     // Catch:{ a -> 0x029d }
            java.lang.String r5 = r1.f16149d     // Catch:{ a -> 0x029d }
            com.meizu.update.c.b.c r5 = r3.mo24734a(r2, r5)     // Catch:{ a -> 0x029d }
            r23.m17570b()     // Catch:{ a -> 0x029d }
            if (r5 == 0) goto L_0x01d3
            com.meizu.update.c.c.d r7 = r1.f16147b     // Catch:{ a -> 0x029d }
            r5.mo24724a(r7)     // Catch:{ a -> 0x029d }
            java.lang.String r7 = r5.f16170a     // Catch:{ a -> 0x029d }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r4 = r5.f16171b     // Catch:{ a -> 0x01cf }
            if (r4 == 0) goto L_0x01c8
            com.meizu.update.c.d r4 = r1.f16148c     // Catch:{ a -> 0x01cf }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r5 = r5.f16171b     // Catch:{ a -> 0x01cf }
            r4.mo24715a((java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) r5)     // Catch:{ a -> 0x01cf }
        L_0x01c8:
            java.lang.String r4 = "Re proxy success"
            r1.m17569a((java.lang.String) r4)     // Catch:{ a -> 0x01cf }
            r4 = r7
            goto L_0x01d3
        L_0x01cf:
            r0 = move-exception
            r10 = r7
            goto L_0x02a3
        L_0x01d3:
            r5 = r0
            r7 = r4
            r0 = 0
            r4 = 0
            goto L_0x01f4
        L_0x01d8:
            r0 = move-exception
            r16 = 0
        L_0x01db:
            com.meizu.update.c.d.a r7 = r1.f16151f     // Catch:{ a -> 0x029d }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ a -> 0x029d }
            java.lang.String r9 = r1.f16149d     // Catch:{ a -> 0x029d }
            r10 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r12 = r0.getMessage()     // Catch:{ a -> 0x029d }
            r11 = r4
            r13 = r22
            r7.mo24747b(r8, r9, r10, r11, r12, r13)     // Catch:{ a -> 0x029d }
            r7 = r4
            r0 = 0
            r4 = 0
            r5 = 0
        L_0x01f4:
            r13 = 1
        L_0x01f5:
            if (r16 == 0) goto L_0x01f8
            return r15
        L_0x01f8:
            if (r3 == 0) goto L_0x0299
            boolean r8 = r3.mo24738b()     // Catch:{ a -> 0x0296 }
            if (r8 != 0) goto L_0x0220
            com.meizu.update.c.d.a r15 = r1.f16151f     // Catch:{ a -> 0x0296 }
            java.lang.String r16 = r24.getPackageName()     // Catch:{ a -> 0x0296 }
            java.lang.String r0 = r1.f16149d     // Catch:{ a -> 0x0296 }
            r18 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r20 = "Over max retry count, error end!"
            r17 = r0
            r19 = r7
            r21 = r22
            r15.mo24747b(r16, r17, r18, r19, r20, r21)     // Catch:{ a -> 0x0296 }
            java.lang.String r0 = "Over max retry count, error end!"
            r1.m17569a((java.lang.String) r0)     // Catch:{ a -> 0x0296 }
            if (r5 != 0) goto L_0x021f
            goto L_0x029b
        L_0x021f:
            throw r5     // Catch:{ a -> 0x0296 }
        L_0x0220:
            if (r0 != 0) goto L_0x0290
            if (r4 != 0) goto L_0x022f
            java.lang.String r0 = r3.mo24739c()     // Catch:{ a -> 0x0296 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ a -> 0x0296 }
            if (r4 != 0) goto L_0x022f
            r7 = r0
        L_0x022f:
            boolean r0 = com.meizu.update.util.Utility.m17990i(r24)     // Catch:{ a -> 0x0296 }
            r4 = 1000(0x3e8, double:4.94E-321)
            if (r0 != 0) goto L_0x0283
            r0 = 0
            r8 = 0
        L_0x0239:
            r9 = 10
            if (r0 >= r9) goto L_0x025f
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x0240 }
        L_0x0240:
            r23.m17570b()     // Catch:{ a -> 0x0296 }
            boolean r8 = com.meizu.update.util.Utility.m17990i(r24)     // Catch:{ a -> 0x0296 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ a -> 0x0296 }
            r9.<init>()     // Catch:{ a -> 0x0296 }
            java.lang.String r10 = "Wait network count: "
            r9.append(r10)     // Catch:{ a -> 0x0296 }
            int r0 = r0 + 1
            r9.append(r0)     // Catch:{ a -> 0x0296 }
            java.lang.String r9 = r9.toString()     // Catch:{ a -> 0x0296 }
            r1.m17571b(r9)     // Catch:{ a -> 0x0296 }
            if (r8 == 0) goto L_0x0239
        L_0x025f:
            if (r8 != 0) goto L_0x027d
            com.meizu.update.c.d.a r15 = r1.f16151f     // Catch:{ a -> 0x0296 }
            java.lang.String r16 = r24.getPackageName()     // Catch:{ a -> 0x0296 }
            java.lang.String r0 = r1.f16149d     // Catch:{ a -> 0x0296 }
            r18 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r20 = "No network, error end!"
            r17 = r0
            r19 = r7
            r21 = r22
            r15.mo24747b(r16, r17, r18, r19, r20, r21)     // Catch:{ a -> 0x0296 }
            java.lang.String r0 = "Wait network failed."
            r1.m17569a((java.lang.String) r0)     // Catch:{ a -> 0x0296 }
            goto L_0x029b
        L_0x027d:
            java.lang.String r0 = "Wait network success, go on."
            r1.m17571b(r0)     // Catch:{ a -> 0x0296 }
            goto L_0x0293
        L_0x0283:
            r0 = 0
        L_0x0284:
            r8 = 3
            if (r0 >= r8) goto L_0x0293
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x028a }
        L_0x028a:
            r23.m17570b()     // Catch:{ a -> 0x0296 }
            int r0 = r0 + 1
            goto L_0x0284
        L_0x0290:
            r3.mo24741e()     // Catch:{ a -> 0x0296 }
        L_0x0293:
            r4 = r7
            goto L_0x001e
        L_0x0296:
            r0 = move-exception
            r10 = r7
            goto L_0x02a2
        L_0x0299:
            if (r5 != 0) goto L_0x029c
        L_0x029b:
            return r6
        L_0x029c:
            throw r5     // Catch:{ a -> 0x0296 }
        L_0x029d:
            r0 = move-exception
            r10 = r4
            goto L_0x02a3
        L_0x02a0:
            r0 = move-exception
            r10 = r4
        L_0x02a2:
            r15 = r13
        L_0x02a3:
            if (r15 == 0) goto L_0x02b4
            com.meizu.update.c.d.a r7 = r1.f16151f
            java.lang.String r8 = r24.getPackageName()
            java.lang.String r9 = r1.f16149d
            java.lang.String r11 = "User Canceled"
            r12 = r22
            r7.mo24748b(r8, r9, r10, r11, r12)
        L_0x02b4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.p085c.p086a.RetryDownloader.mo24710a(android.content.Context):boolean");
    }

    /* renamed from: b */
    private void m17570b() throws CancelException {
        if (this.f16150e) {
            throw new CancelException();
        }
    }

    /* renamed from: a */
    private void m17569a(String str) {
        Loger.m17943d(str);
    }

    /* renamed from: b */
    private void m17571b(String str) {
        Loger.m17942c(str);
    }
}
