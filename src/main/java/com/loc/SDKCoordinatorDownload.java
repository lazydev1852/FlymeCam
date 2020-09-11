package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.loc.DownloadManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

@Deprecated
/* renamed from: com.loc.dh */
public class SDKCoordinatorDownload extends Thread implements DownloadManager.C1050a {

    /* renamed from: g */
    protected static boolean f3303g = false;

    /* renamed from: i */
    private static String f3304i = "sodownload";

    /* renamed from: j */
    private static String f3305j = "sofail";

    /* renamed from: a */
    protected C1105a f3306a;

    /* renamed from: b */
    protected RandomAccessFile f3307b;

    /* renamed from: c */
    protected String f3308c;

    /* renamed from: d */
    protected String f3309d;

    /* renamed from: e */
    protected String f3310e;

    /* renamed from: f */
    protected Context f3311f;

    /* renamed from: h */
    private DownloadManager f3312h = new DownloadManager(this.f3306a);

    /* renamed from: com.loc.dh$a */
    /* compiled from: SDKCoordinatorDownload */
    public static class C1105a extends Request {

        /* renamed from: a */
        private String f3313a;

        C1105a(String str) {
            this.f3313a = str;
        }

        /* renamed from: a */
        public final Map<String, String> mo12965a() {
            return null;
        }

        /* renamed from: b */
        public final Map<String, String> mo12966b() {
            return null;
        }

        /* renamed from: c */
        public final String mo12967c() {
            return this.f3313a;
        }
    }

    public SDKCoordinatorDownload(Context context, String str, String str2, String str3) {
        this.f3311f = context;
        this.f3310e = str3;
        this.f3308c = m3773a(context, str + "temp.so");
        this.f3309d = m3773a(context, "libwgs2gcj.so");
        this.f3306a = new C1105a(str2);
    }

    /* renamed from: a */
    public static String m3773a(Context context, String str) {
        String a = C1107dj.m3807a(context);
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + MD5.m3762b(a) + File.separator + str;
    }

    /* renamed from: a */
    public void mo13257a() {
        if (this.f3306a != null && !TextUtils.isEmpty(this.f3306a.mo12967c()) && this.f3306a.mo12967c().contains("libJni_wgs2gcj.so") && this.f3306a.mo12967c().contains(C1107dj.m3807a(this.f3311f)) && !new File(this.f3309d).exists()) {
            start();
        }
    }

    /* renamed from: a */
    public final void mo13006a(byte[] bArr, long j) {
        try {
            if (this.f3307b == null) {
                File file = new File(this.f3308c);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f3307b = new RandomAccessFile(file, "rw");
            }
        } catch (FileNotFoundException e) {
            SDKLogHandler.m3867b((Throwable) e, "sdl", "oDd");
            mo13270b();
        } catch (Throwable th) {
            mo13270b();
            SDKLogHandler.m3867b(th, "sdl", "oDd");
            return;
        }
        if (this.f3307b != null) {
            try {
                this.f3307b.seek(j);
                this.f3307b.write(bArr);
            } catch (IOException e2) {
                mo13270b();
                SDKLogHandler.m3867b((Throwable) e2, "sdl", "oDd");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo13270b() {
        File file = new File(this.f3308c);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: c */
    public final void mo13007c() {
        try {
            if (this.f3307b != null) {
                this.f3307b.close();
            }
            mo13270b();
            File file = new File(m3773a(this.f3311f, "tempfile"));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdir();
                }
                file.createNewFile();
            }
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "sdl", "oe");
        }
    }

    /* renamed from: d */
    public void mo13008d() {
        try {
            if (this.f3307b != null) {
                this.f3307b.close();
            }
            String a = MD5.m3759a(this.f3308c);
            if (a == null || !a.equalsIgnoreCase(this.f3310e)) {
                mo13270b();
            } else if (new File(this.f3309d).exists()) {
                mo13270b();
            } else {
                new File(this.f3308c).renameTo(new File(this.f3309d));
            }
        } catch (Throwable th) {
            mo13270b();
            File file = new File(this.f3309d);
            if (file.exists()) {
                file.delete();
            }
            SDKLogHandler.m3867b(th, "sdl", "ofs");
        }
    }

    /* renamed from: e */
    public final void mo13009e() {
        mo13270b();
    }

    public void run() {
        try {
            File file = new File(m3773a(this.f3311f, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.f3312h.mo13005a(this);
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "sdl", "run");
            mo13270b();
        }
    }
}
