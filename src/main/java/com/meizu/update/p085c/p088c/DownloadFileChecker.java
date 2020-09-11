package com.meizu.update.p085c.p088c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.meizu.update.util.Loger;
import com.meizu.update.util.Md5Helper;
import com.meizu.update.util.Utility;

/* renamed from: com.meizu.update.c.c.a */
public class DownloadFileChecker implements IFileChecker {

    /* renamed from: a */
    private Context f16173a;

    /* renamed from: b */
    private int f16174b;

    /* renamed from: c */
    private String f16175c;

    /* renamed from: d */
    private long f16176d;

    /* renamed from: e */
    private String f16177e;

    /* renamed from: f */
    private int f16178f;

    /* renamed from: g */
    private boolean f16179g = true;

    /* renamed from: h */
    private boolean f16180h = false;

    public DownloadFileChecker(Context context, int i, String str, long j, String str2, int i2) {
        this.f16173a = context;
        this.f16174b = i;
        this.f16175c = str;
        this.f16176d = j;
        this.f16177e = str2;
        this.f16178f = i2;
        m17600b("Checker limit:" + toString());
    }

    /* renamed from: a */
    public String mo24728a() {
        if (TextUtils.isEmpty(this.f16177e) || !m17599a(2)) {
            return null;
        }
        return this.f16177e;
    }

    /* renamed from: b */
    public String mo24730b() {
        if (TextUtils.isEmpty(this.f16177e) || !m17599a(4)) {
            return null;
        }
        return this.f16177e;
    }

    /* renamed from: c */
    public long mo24731c() {
        if (this.f16176d <= 0 || !m17599a(1)) {
            return 0;
        }
        return this.f16176d;
    }

    /* renamed from: a */
    private boolean m17599a(int i) {
        return (i & this.f16174b) > 0;
    }

    /* renamed from: a */
    public FileCheckResult mo24726a(long j, long j2) {
        if (this.f16179g) {
            boolean z = false;
            this.f16180h = j2 <= 0;
            if (this.f16176d > 0 && !this.f16180h && m17599a(1)) {
                long j3 = j + j2;
                if (j3 == this.f16176d) {
                    z = true;
                }
                if (!z) {
                    String str = "File length not match(" + this.f16176d + "->" + j3 + ")";
                    m17600b(str);
                    return FileCheckResult.m17617a(str);
                }
            }
        }
        return FileCheckResult.m17616a();
    }

    /* renamed from: a */
    public FileCheckResult mo24727a(String str) {
        boolean z;
        if (this.f16179g) {
            boolean z2 = false;
            if (TextUtils.isEmpty(this.f16175c) || !m17599a(8)) {
                z = false;
            } else {
                PackageInfo d = Utility.m17978d(this.f16173a, str);
                if (d == null) {
                    String str2 = "File cant parse to package info(" + this.f16175c + "->" + this.f16178f + ")";
                    m17600b(str2);
                    return FileCheckResult.m17617a(str2);
                } else if (!this.f16175c.equalsIgnoreCase(d.packageName)) {
                    String str3 = "Package name not match(" + this.f16175c + "->" + d.packageName + ")";
                    m17600b(str3);
                    return FileCheckResult.m17617a(str3);
                } else {
                    if (this.f16178f > 0 && m17599a(16)) {
                        if (!(this.f16178f == d.versionCode)) {
                            String str4 = "Package version code not match(" + this.f16178f + "->" + d.versionCode + ")";
                            m17600b(str4);
                            return FileCheckResult.m17617a(str4);
                        }
                    }
                    z = true;
                }
            }
            if (!TextUtils.isEmpty(this.f16177e)) {
                if (m17599a(2)) {
                    String a = Md5Helper.m17945a(str);
                    if (!this.f16177e.equalsIgnoreCase(a)) {
                        String str5 = "Whole md5 not match(" + this.f16177e + "->" + a + ")";
                        m17600b(str5);
                        return FileCheckResult.m17617a(str5);
                    }
                } else if (m17599a(4)) {
                    String a2 = Md5Helper.m17946a(str, 1048576);
                    if (!this.f16177e.equalsIgnoreCase(a2)) {
                        String str6 = "HeadTail md5 not match(" + this.f16177e + "->" + a2 + ")";
                        m17600b(str6);
                        return FileCheckResult.m17617a(str6);
                    }
                }
                z = true;
            }
            if (!z && this.f16176d > 0 && this.f16180h && m17599a(1)) {
                this.f16180h = false;
                long a3 = Utility.m17955a(str);
                if (a3 > 0) {
                    if (a3 == this.f16176d) {
                        z2 = true;
                    }
                    if (!z2) {
                        String str7 = "Download File length not match(" + this.f16176d + "->" + a3 + ")";
                        m17600b(str7);
                        return FileCheckResult.m17617a(str7);
                    }
                }
            }
        }
        return FileCheckResult.m17616a();
    }

    /* renamed from: a */
    public void mo24729a(boolean z) {
        this.f16179g = z;
    }

    /* renamed from: d */
    public String mo24732d() {
        if (this.f16178f > 0) {
            return String.valueOf(this.f16178f);
        }
        return null;
    }

    /* renamed from: b */
    private void m17600b(String str) {
        Loger.m17943d(str);
    }

    public String toString() {
        String str = "";
        if (m17599a(1)) {
            str = str + "size ";
        }
        if (m17599a(4)) {
            str = str + "1mmd5 ";
        }
        if (m17599a(8)) {
            str = str + "pkg ";
        }
        if (m17599a(16)) {
            str = str + "vcode ";
        }
        if (m17599a(2)) {
            str = str + "md5 ";
        }
        if (TextUtils.isEmpty(str)) {
            str = "null";
        }
        return "verify_mode=" + str + ",pk=" + this.f16175c + ",size=" + this.f16176d + ",md5=" + this.f16177e + ",v_code=" + this.f16178f;
    }
}
