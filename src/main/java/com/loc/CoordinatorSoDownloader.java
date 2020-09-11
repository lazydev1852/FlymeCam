package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

/* renamed from: com.loc.db */
public class CoordinatorSoDownloader extends SDKCoordinatorDownload {

    /* renamed from: h */
    private boolean f3269h = false;

    /* renamed from: i */
    private boolean f3270i = true;

    public CoordinatorSoDownloader(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
    }

    /* renamed from: a */
    private static void m3691a(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(new byte[32]);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            byte[] bArr = new byte[1024];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    if (read == 1024) {
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr);
                    } else {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr2);
                    }
                    i += read;
                } else {
                    fileInputStream.close();
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void mo13257a() {
        if (this.f3306a != null && !TextUtils.isEmpty(this.f3306a.mo12967c()) && this.f3306a.mo12967c().endsWith("png") && this.f3306a.mo12967c().contains(C1107dj.m3807a(this.f3311f)) && !C1107dj.m3822b(this.f3311f)) {
            if ((this.f3269h || !C1107dj.m3816a(this.f3311f, this.f3270i)) && !f3303g && !new File(this.f3309d).exists()) {
                start();
            }
        }
    }

    /* renamed from: a */
    public final void mo13258a(boolean z) {
        this.f3269h = z;
    }

    /* renamed from: b */
    public final void mo13259b(boolean z) {
        this.f3270i = z;
    }

    /* renamed from: d */
    public final void mo13008d() {
        try {
            if (this.f3307b != null) {
                this.f3307b.close();
            }
            String a = MD5.m3759a(this.f3308c);
            if (a == null || !a.equalsIgnoreCase(this.f3310e)) {
                mo13270b();
                return;
            }
            File file = new File(this.f3309d);
            if (file.exists()) {
                mo13270b();
                return;
            }
            File file2 = new File(this.f3308c);
            if (file2.exists()) {
                m3691a(file2, file);
                mo13270b();
            }
        } catch (Throwable th) {
            mo13270b();
            File file3 = new File(this.f3309d);
            if (file3.exists()) {
                file3.delete();
            }
            BasicLogHandler.m3844a(th, "sdl", "ofs");
        }
    }
}
