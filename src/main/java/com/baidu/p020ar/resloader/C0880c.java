package com.baidu.p020ar.resloader;

import android.content.Context;
import com.baidu.p020ar.resloader.C0884e;
import com.baidu.p020ar.util.ARSDKInfo;
import com.baidu.p020ar.util.FileUtils;
import com.baidu.p020ar.util.HttpUtils;
import com.baidu.p020ar.util.IoUtils;
import com.baidu.p020ar.util.UiThreadUtil;
import com.baidu.p020ar.util.ZipUtils;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.io.File;

/* renamed from: com.baidu.ar.resloader.c */
public class C0880c extends Thread {

    /* renamed from: a */
    private String f2188a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0884e.C0885a f2189b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0889i f2190c;

    /* renamed from: d */
    private final File f2191d;

    /* renamed from: e */
    private volatile boolean f2192e = false;

    /* renamed from: f */
    private C0884e f2193f;

    /* renamed from: g */
    private C0887g f2194g;

    public C0880c(Context context, C0884e eVar, String str, C0884e.C0885a aVar, C0889i iVar, C0887g gVar) {
        this.f2193f = eVar;
        this.f2191d = C0884e.m2552a(context);
        this.f2188a = str;
        this.f2189b = aVar;
        this.f2190c = iVar;
        this.f2194g = gVar;
    }

    /* renamed from: a */
    private void m2544a(final boolean z, final C0890j jVar) {
        if (z) {
            if (this.f2194g != null) {
                this.f2194g.onSoLoadSuccess();
            }
        } else if (this.f2194g != null) {
            this.f2194g.onSoloadFialure();
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (z) {
                    C0880c.this.f2190c.mo10579b(String.valueOf(ARSDKInfo.getVersionCode()));
                    C0880c.this.f2190c.mo10577a(jVar.f2207a);
                }
                if (!C0880c.this.mo10565b() && C0880c.this.f2189b != null) {
                    C0880c.this.f2189b.mo8857a(z);
                }
            }
        });
    }

    /* renamed from: a */
    private boolean m2545a(String str, File file) {
        if (this.f2194g != null) {
            this.f2194g.onSoloadDownloadStart();
        }
        return HttpUtils.downloadFile(str, file, new IoUtils.Operation() {
            public boolean isCancelled() {
                return C0880c.this.mo10565b();
            }

            public void progress(long j, long j2) {
            }
        });
    }

    /* renamed from: a */
    public void mo10564a() {
        this.f2192e = true;
        this.f2189b = null;
    }

    /* renamed from: b */
    public boolean mo10565b() {
        return this.f2192e;
    }

    public void run() {
        super.run();
        C0890j jVar = new C0890j();
        jVar.f2208b = this.f2188a;
        jVar.f2207a = C0884e.m2554b(this.f2188a);
        String str = jVar.f2208b;
        File file = new File(this.f2191d, jVar.f2207a);
        File file2 = new File(file, "res.zip");
        FileUtils.ensureParent(file2);
        boolean a = m2545a(str, file2);
        if (mo10565b()) {
            FileUtils.deleteDir(file);
            return;
        }
        if (a) {
            if (this.f2194g != null) {
                this.f2194g.onSoloadDownloadSuccess();
            }
        } else if (this.f2194g != null) {
            this.f2194g.onSoloadDownloadFailure();
        }
        if (a && ZipUtils.unzip(file2, file)) {
            if (this.f2193f.mo10575b(new File(file, Parameters.RESOLUTION))) {
                m2544a(true, jVar);
                return;
            }
        }
        m2544a(false, (C0890j) null);
    }
}
