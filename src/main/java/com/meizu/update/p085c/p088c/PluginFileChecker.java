package com.meizu.update.p085c.p088c;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.update.util.Loger;

/* renamed from: com.meizu.update.c.c.f */
public class PluginFileChecker implements IFileChecker {

    /* renamed from: a */
    private Context f16190a;

    /* renamed from: b */
    private int f16191b;

    /* renamed from: c */
    private long f16192c;

    /* renamed from: d */
    private String f16193d;

    /* renamed from: e */
    private boolean f16194e = true;

    /* renamed from: f */
    private boolean f16195f = false;

    /* renamed from: d */
    public String mo24732d() {
        return null;
    }

    public PluginFileChecker(Context context, int i, long j, String str) {
        this.f16190a = context;
        this.f16191b = i;
        this.f16192c = j;
        this.f16193d = str;
        m17636b("Checker limit:" + toString());
    }

    /* renamed from: a */
    public void mo24729a(boolean z) {
        this.f16194e = z;
    }

    /* renamed from: a */
    public FileCheckResult mo24726a(long j, long j2) {
        if (this.f16194e) {
            boolean z = false;
            this.f16195f = j2 <= 0;
            if (this.f16192c > 0 && !this.f16195f && m17635a(1)) {
                long j3 = j + j2;
                if (j3 == this.f16192c) {
                    z = true;
                }
                if (!z) {
                    String str = "File length not match(" + this.f16192c + "->" + j3 + ")";
                    m17636b(str);
                    return FileCheckResult.m17617a(str);
                }
            }
        }
        return FileCheckResult.m17616a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.update.p085c.p088c.FileCheckResult mo24727a(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = r7.f16194e
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = r7.f16193d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0088
            r0 = 2
            boolean r0 = r7.m17635a((int) r0)
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = com.meizu.update.util.Md5Helper.m17945a((java.lang.String) r8)
            java.lang.String r3 = r7.f16193d
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 != 0) goto L_0x0049
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Whole md5 not match("
            r8.append(r1)
            java.lang.String r1 = r7.f16193d
            r8.append(r1)
            java.lang.String r1 = "->"
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = ")"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.m17636b(r8)
            com.meizu.update.c.c.c r8 = com.meizu.update.p085c.p088c.FileCheckResult.m17617a(r8)
            return r8
        L_0x0049:
            r0 = 1
            goto L_0x0089
        L_0x004b:
            r0 = 4
            boolean r0 = r7.m17635a((int) r0)
            if (r0 == 0) goto L_0x0088
            r0 = 1048576(0x100000, float:1.469368E-39)
            java.lang.String r0 = com.meizu.update.util.Md5Helper.m17946a(r8, r0)
            java.lang.String r3 = r7.f16193d
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 != 0) goto L_0x0049
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "HeadTail md5 not match("
            r8.append(r1)
            java.lang.String r1 = r7.f16193d
            r8.append(r1)
            java.lang.String r1 = "->"
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = ")"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.m17636b(r8)
            com.meizu.update.c.c.c r8 = com.meizu.update.p085c.p088c.FileCheckResult.m17617a(r8)
            return r8
        L_0x0088:
            r0 = 0
        L_0x0089:
            if (r0 != 0) goto L_0x00d8
            long r3 = r7.f16192c
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d8
            boolean r0 = r7.f16195f
            if (r0 == 0) goto L_0x00d8
            boolean r0 = r7.m17635a((int) r2)
            if (r0 == 0) goto L_0x00d8
            r7.f16195f = r1
            long r3 = com.meizu.update.util.Utility.m17955a((java.lang.String) r8)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d8
            long r5 = r7.f16192c
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x00ae
            r1 = 1
        L_0x00ae:
            if (r1 != 0) goto L_0x00d8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Download File length not match("
            r8.append(r0)
            long r0 = r7.f16192c
            r8.append(r0)
            java.lang.String r0 = "->"
            r8.append(r0)
            r8.append(r3)
            java.lang.String r0 = ")"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.m17636b(r8)
            com.meizu.update.c.c.c r8 = com.meizu.update.p085c.p088c.FileCheckResult.m17617a(r8)
            return r8
        L_0x00d8:
            com.meizu.update.c.c.c r8 = com.meizu.update.p085c.p088c.FileCheckResult.m17616a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.p085c.p088c.PluginFileChecker.mo24727a(java.lang.String):com.meizu.update.c.c.c");
    }

    /* renamed from: a */
    public String mo24728a() {
        if (TextUtils.isEmpty(this.f16193d) || !m17635a(2)) {
            return null;
        }
        return this.f16193d;
    }

    /* renamed from: b */
    public String mo24730b() {
        if (TextUtils.isEmpty(this.f16193d) || !m17635a(4)) {
            return null;
        }
        return this.f16193d;
    }

    /* renamed from: c */
    public long mo24731c() {
        if (this.f16192c <= 0 || !m17635a(1)) {
            return 0;
        }
        return this.f16192c;
    }

    /* renamed from: a */
    private boolean m17635a(int i) {
        return (i & this.f16191b) > 0;
    }

    public String toString() {
        String str = "";
        if (m17635a(1)) {
            str = str + "size ";
        }
        if (m17635a(4)) {
            str = str + "1mmd5";
        }
        if (m17635a(2)) {
            str = str + "md5";
        }
        return "verify_mode=" + str + ",size=" + this.f16192c + ",md5=" + this.f16193d;
    }

    /* renamed from: b */
    private void m17636b(String str) {
        Loger.m17943d(str);
    }
}
