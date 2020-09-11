package com.baidu.p020ar.blend.p037b;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.baidu.ar.blend.b.a */
public final class C0640a {
    /* renamed from: a */
    public static String m1447a(File file) {
        FileInputStream fileInputStream;
        if (m1451c(file)) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
                try {
                    e.printStackTrace();
                    C0641b.m1454a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    C0641b.m1454a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                C0641b.m1454a((Closeable) fileInputStream);
                throw th;
            }
            try {
                String a = C0641b.m1452a((InputStream) fileInputStream);
                C0641b.m1454a((Closeable) fileInputStream);
                return a;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                C0641b.m1454a((Closeable) fileInputStream);
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m1448a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m1447a(new File(str));
    }

    /* renamed from: b */
    public static InputStream m1449b(File file) {
        if (m1451c(file)) {
            try {
                return new FileInputStream(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    public static InputStream m1450b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m1449b(new File(str));
    }

    /* renamed from: c */
    public static boolean m1451c(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
