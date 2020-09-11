package com.baidu.p020ar.resloader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.ARSDKInfo;
import com.baidu.p020ar.util.FileUtils;
import com.baidu.p020ar.util.MD5Utils;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.ar.resloader.e */
public class C0884e {

    /* renamed from: a */
    private final Context f2200a;

    /* renamed from: b */
    private C0880c f2201b;

    /* renamed from: c */
    private C0885a f2202c;

    /* renamed from: d */
    private C0889i f2203d;

    /* renamed from: e */
    private List<C0886f> f2204e = new ArrayList();

    /* renamed from: f */
    private C0887g f2205f;

    /* renamed from: com.baidu.ar.resloader.e$a */
    public interface C0885a {
        /* renamed from: a */
        void mo8857a(boolean z);
    }

    public C0884e(Context context) {
        this.f2200a = context;
        this.f2203d = new C0889i(context);
    }

    /* renamed from: a */
    public static File m2552a(Context context) {
        File file = new File(context.getFilesDir(), "baiduarsolib");
        FileUtils.ensureParent(file);
        return file;
    }

    /* renamed from: a */
    private void m2553a(boolean z) {
        if (this.f2202c != null) {
            this.f2202c.mo8857a(z);
        }
    }

    /* renamed from: b */
    public static String m2554b(String str) {
        return MD5Utils.md5(str);
    }

    /* renamed from: b */
    private boolean m2555b() {
        for (C0886f c : this.f2204e) {
            if (!c.mo10344c()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private void m2556c() {
        for (C0886f next : this.f2204e) {
            if (!next.mo10342a()) {
                C0888h.m2573a(next);
            }
        }
    }

    /* renamed from: c */
    private void m2557c(String str) {
        mo10569a();
        try {
            this.f2201b = new C0880c(this.f2200a, this, str, this.f2202c, this.f2203d, this.f2205f);
            this.f2201b.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private boolean m2558c(File file) {
        if (!file.exists()) {
            return false;
        }
        for (C0886f next : this.f2204e) {
            if (next.mo10342a() && !new File(file, next.mo10343b()).exists()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private boolean m2559d() {
        for (C0886f a : this.f2204e) {
            if (a.mo10342a()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo10569a() {
        if (this.f2201b != null) {
            this.f2201b.mo10564a();
            this.f2201b = null;
        }
    }

    /* renamed from: a */
    public void mo10570a(C0885a aVar) {
        this.f2202c = aVar;
    }

    /* renamed from: a */
    public void mo10571a(C0886f fVar) {
        this.f2204e.add(fVar);
    }

    /* renamed from: a */
    public void mo10572a(C0887g gVar) {
        this.f2205f = gVar;
    }

    /* renamed from: a */
    public void mo10573a(File file) {
        boolean b = mo10575b(file);
        m2553a(b);
        if (b) {
            if (this.f2205f != null) {
                this.f2205f.onSoLoadSuccess();
            }
        } else if (this.f2205f != null) {
            this.f2205f.onSoloadFialure();
        }
    }

    /* renamed from: a */
    public void mo10574a(String str) {
        ARLog.m2695d("bdar: url = " + str);
        if (m2555b()) {
            m2553a(true);
            return;
        }
        m2556c();
        if (!m2559d()) {
            m2553a(true);
            return;
        }
        if (this.f2205f != null) {
            this.f2205f.onSoloadLoadStart();
        }
        if (TextUtils.isEmpty(str)) {
            ARLog.m2696e("bdar: So URL is NULL!!!!");
            m2553a(false);
            if (this.f2205f != null) {
                this.f2205f.onSoloadFialure();
            }
        } else if (!TextUtils.equals(this.f2203d.mo10578b(), String.valueOf(ARSDKInfo.getVersionCode()))) {
            m2557c(str);
        } else {
            String a = this.f2203d.mo10576a();
            String b = m2554b(str);
            if (!TextUtils.isEmpty(a) && TextUtils.equals(a, b)) {
                File file = new File(m2552a(this.f2200a), a);
                if (file.exists()) {
                    File file2 = new File(file, Parameters.RESOLUTION);
                    if (m2558c(file2)) {
                        mo10573a(file2);
                        return;
                    }
                    this.f2203d.mo10577a("");
                }
            }
            m2557c(str);
        }
    }

    /* renamed from: b */
    public boolean mo10575b(File file) {
        for (C0886f next : this.f2204e) {
            if (next.mo10342a() && !C0888h.m2574a(new File(file, next.mo10343b()))) {
                return false;
            }
        }
        return m2555b();
    }
}
