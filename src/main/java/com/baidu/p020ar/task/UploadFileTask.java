package com.baidu.p020ar.task;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.p020ar.util.C0919Utils;
import com.baidu.p020ar.util.IoUtils;
import com.baidu.p020ar.util.MediaUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.baidu.ar.task.UploadFileTask */
public class UploadFileTask extends AsyncTask<String, Integer, C0901a> {

    /* renamed from: a */
    private static final String f2293a = "UploadFileTask";

    /* renamed from: b */
    private static final String f2294b = UUID.randomUUID().toString();

    /* renamed from: c */
    private long f2295c;

    /* renamed from: d */
    private String f2296d;

    /* renamed from: e */
    private String f2297e;

    /* renamed from: f */
    private String f2298f;

    /* renamed from: g */
    private Map<String, String> f2299g;

    /* renamed from: h */
    private String f2300h;

    /* renamed from: i */
    private OnFileUploadListener f2301i;

    public UploadFileTask(String str, String str2, String str3, Map<String, String> map, String str4, OnFileUploadListener onFileUploadListener) {
        this.f2296d = str;
        this.f2297e = str2;
        this.f2298f = str3;
        this.f2299g = map;
        this.f2300h = str4;
        this.f2301i = onFileUploadListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x031d A[SYNTHETIC, Splitter:B:105:0x031d] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02d6 A[SYNTHETIC, Splitter:B:72:0x02d6] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02ec A[SYNTHETIC, Splitter:B:81:0x02ec] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02f8 A[SYNTHETIC, Splitter:B:88:0x02f8] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x030e A[SYNTHETIC, Splitter:B:97:0x030e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x02d1=Splitter:B:69:0x02d1, B:85:0x02f3=Splitter:B:85:0x02f3} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.p020ar.task.C0901a m2650a() {
        /*
            r17 = this;
            r1 = r17
            com.baidu.ar.task.a r2 = new com.baidu.ar.task.a
            r2.<init>()
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r1.f2296d
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 == 0) goto L_0x0327
            long r6 = r3.length()
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0020
            goto L_0x0327
        L_0x0020:
            long r6 = r3.length()
            r1.f2295c = r6
            java.lang.String r6 = r1.f2300h     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            if (r6 == 0) goto L_0x004b
            java.lang.String r6 = r1.f2300h     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r7 = "video"
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            if (r6 == 0) goto L_0x004b
            java.lang.String r6 = r1.f2297e     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            if (r6 == 0) goto L_0x0045
            java.io.File r6 = new java.io.File     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r7 = r1.f2297e     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r6.<init>(r7)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            boolean r6 = r6.exists()     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            if (r6 != 0) goto L_0x004b
        L_0x0045:
            java.lang.String r6 = r17.m2652b()     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r1.f2297e = r6     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
        L_0x004b:
            java.net.URL r6 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r7 = r1.f2298f     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r6.<init>(r7)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r7 = 60000(0xea60, float:8.4078E-41)
            r6.setConnectTimeout(r7)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r6.setReadTimeout(r7)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r7 = 1
            r6.setDoInput(r7)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r6.setDoOutput(r7)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r10 = 0
            r6.setUseCaches(r10)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r11 = "POST"
            r6.setRequestMethod(r11)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r11 = "Charset"
            java.lang.String r12 = "utf-8"
            r6.setRequestProperty(r11, r12)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r11 = "Content-Type"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r12.<init>()     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r13 = "multipart/form-data;boundary="
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r13 = f2294b     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.lang.String r12 = r12.toString()     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r6.setRequestProperty(r11, r12)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r6.setChunkedStreamingMode(r10)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.io.DataOutputStream r11 = new java.io.DataOutputStream     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.io.OutputStream r12 = r6.getOutputStream()     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            r11.<init>(r12)     // Catch:{ MalformedURLException -> 0x02f0, IOException -> 0x02ce, all -> 0x02ca }
            java.util.Map<java.lang.String, java.lang.String> r12 = r1.f2299g     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.StringBuffer r12 = m2651a((java.util.Map<java.lang.String, java.lang.String>) r12)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r12 = r12.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r12 = r12.getBytes(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.write(r12)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            boolean r12 = r3.exists()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r12 == 0) goto L_0x02a7
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r12.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r13 = "--"
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r13 = f2294b     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r13 = "\r\n"
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r13.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = "Content-Disposition: form-data; name=\""
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = r1.f2300h     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = "\"; filename=\""
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = r3.getName()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = "\""
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = "\r\n"
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r13 = r13.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r13.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = "Content-Type: "
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = r1.f2300h     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r14 = "\r\n"
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r13 = r13.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r13 = "\r\n"
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r12 = r12.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r12 = r12.getBytes(r13)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.write(r12)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            boolean r12 = r3.exists()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r13 = 1024(0x400, float:1.435E-42)
            r14 = -1
            if (r12 == 0) goto L_0x017d
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r12.<init>(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r3 = new byte[r13]     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r15 = 0
        L_0x0133:
            int r4 = r12.read(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r4 == r14) goto L_0x015f
            r11.write(r3, r10, r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r16 = r6
            long r5 = (long) r4     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            long r8 = r8 + r5
            r4 = 100
            long r4 = r4 * r8
            float r4 = (float) r4     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 * r5
            long r5 = r1.f2295c     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            float r5 = (float) r5     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            float r4 = r4 / r5
            int r4 = (int) r4     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r4 <= r15) goto L_0x015b
            java.lang.Integer[] r5 = new java.lang.Integer[r7]     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5[r10] = r6     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r1.publishProgress(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
        L_0x015b:
            r15 = r4
            r6 = r16
            goto L_0x0133
        L_0x015f:
            r16 = r6
            java.lang.Integer[] r3 = new java.lang.Integer[r7]     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4 = 100
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r3[r10] = r4     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r1.publishProgress(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r12.close()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r3 = "\r\n"
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r3 = r3.getBytes(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.write(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            goto L_0x017f
        L_0x017d:
            r16 = r6
        L_0x017f:
            java.lang.String r3 = r1.f2297e     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r3 == 0) goto L_0x0217
            java.io.File r3 = new java.io.File     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = r1.f2297e     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            boolean r3 = r3.exists()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r3 == 0) goto L_0x0217
            java.io.File r3 = new java.io.File     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = r1.f2297e     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = "--"
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = f2294b     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = "\r\n"
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = "thumbImg"
            r1.f2300h = r5     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r6 = "Content-Disposition: form-data; name=\""
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r6 = r1.f2300h     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r6 = "\"; filename=\""
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r6 = r3.getName()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r6 = "\r\n"
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = "Content-Type: application/octet-stream\r\n"
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = "\r\n"
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r4 = r4.getBytes(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.write(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            boolean r4 = r3.exists()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r4 == 0) goto L_0x0217
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.<init>(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r3 = new byte[r13]     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
        L_0x01ff:
            int r5 = r4.read(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r5 == r14) goto L_0x0209
            r11.write(r3, r10, r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            goto L_0x01ff
        L_0x0209:
            r4.close()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r3 = "\r\n"
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r3 = r3.getBytes(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.write(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
        L_0x0217:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = "--"
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = f2294b     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = "--"
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = "\r\n"
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            byte[] r3 = r3.getBytes(r4)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.write(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.flush()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            int r3 = r16.getResponseCode()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x027a
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.io.InputStream r6 = r16.getInputStream()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5.<init>(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r6 = 512(0x200, float:7.175E-43)
            char[] r6 = new char[r6]     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
        L_0x025f:
            int r7 = r4.read(r6)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            if (r7 == r14) goto L_0x026e
            java.lang.String r8 = new java.lang.String     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r8.<init>(r6, r10, r7)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            goto L_0x025f
        L_0x026e:
            r4.close()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = r5.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r2.f2302a = r3     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r2.f2303b = r4     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            goto L_0x02a2
        L_0x027a:
            r2.f2302a = r3     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r4 = r16.getResponseMessage()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r2.f2303b = r4     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r5 = "request error ,and the code is : "
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.append(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r3 = " , reason is : "
            r4.append(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r3 = r16.getResponseMessage()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r4.append(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r3 = r4.toString()     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            com.baidu.p020ar.util.ARLog.m2696e(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
        L_0x02a2:
            r11.close()     // Catch:{ IOException -> 0x0312 }
            goto L_0x0317
        L_0x02a7:
            java.lang.String r3 = "file not exist"
            com.baidu.p020ar.util.ARLog.m2696e(r3)     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r3 = 10001(0x2711, float:1.4014E-41)
            r2.f2302a = r3     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            java.lang.String r3 = "file not found "
            r2.f2303b = r3     // Catch:{ MalformedURLException -> 0x02c6, IOException -> 0x02c2, all -> 0x02be }
            r11.close()     // Catch:{ IOException -> 0x02b8 }
            goto L_0x02bd
        L_0x02b8:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x02bd:
            return r2
        L_0x02be:
            r0 = move-exception
            r2 = r0
            goto L_0x031b
        L_0x02c2:
            r0 = move-exception
            r3 = r0
            r4 = r11
            goto L_0x02d1
        L_0x02c6:
            r0 = move-exception
            r3 = r0
            r4 = r11
            goto L_0x02f3
        L_0x02ca:
            r0 = move-exception
            r2 = r0
            r11 = 0
            goto L_0x031b
        L_0x02ce:
            r0 = move-exception
            r3 = r0
            r4 = 0
        L_0x02d1:
            r3.printStackTrace()     // Catch:{ all -> 0x0318 }
            if (r4 == 0) goto L_0x02e0
            r4.close()     // Catch:{ IOException -> 0x02db }
            r4 = 0
            goto L_0x02e0
        L_0x02db:
            r0 = move-exception
            r5 = r0
            r5.printStackTrace()     // Catch:{ all -> 0x0318 }
        L_0x02e0:
            r5 = 10001(0x2711, float:1.4014E-41)
            r2.f2302a = r5     // Catch:{ all -> 0x0318 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0318 }
            r2.f2303b = r3     // Catch:{ all -> 0x0318 }
            if (r4 == 0) goto L_0x0317
            r4.close()     // Catch:{ IOException -> 0x0312 }
            goto L_0x0317
        L_0x02f0:
            r0 = move-exception
            r3 = r0
            r4 = 0
        L_0x02f3:
            r3.printStackTrace()     // Catch:{ all -> 0x0318 }
            if (r4 == 0) goto L_0x0302
            r4.close()     // Catch:{ IOException -> 0x02fd }
            r4 = 0
            goto L_0x0302
        L_0x02fd:
            r0 = move-exception
            r5 = r0
            r5.printStackTrace()     // Catch:{ all -> 0x0318 }
        L_0x0302:
            r5 = 10002(0x2712, float:1.4016E-41)
            r2.f2302a = r5     // Catch:{ all -> 0x0318 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0318 }
            r2.f2303b = r3     // Catch:{ all -> 0x0318 }
            if (r4 == 0) goto L_0x0317
            r4.close()     // Catch:{ IOException -> 0x0312 }
            goto L_0x0317
        L_0x0312:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x0317:
            return r2
        L_0x0318:
            r0 = move-exception
            r2 = r0
            r11 = r4
        L_0x031b:
            if (r11 == 0) goto L_0x0326
            r11.close()     // Catch:{ IOException -> 0x0321 }
            goto L_0x0326
        L_0x0321:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x0326:
            throw r2
        L_0x0327:
            r3 = 10001(0x2711, float:1.4014E-41)
            r2.f2302a = r3
            java.lang.String r3 = "file not found "
            r2.f2303b = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.task.UploadFileTask.m2650a():com.baidu.ar.task.a");
    }

    /* renamed from: a */
    private static StringBuffer m2651a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry next : map.entrySet()) {
                if (next.getValue() != null) {
                    stringBuffer.append("--");
                    stringBuffer.append(f2294b);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"" + ((String) next.getKey()) + "\"" + SystemInfoUtil.LINE_END);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append(URLEncoder.encode((String) next.getValue(), IoUtils.UTF_8));
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    /* renamed from: b */
    private String m2652b() {
        Bitmap frameAtTime = MediaUtils.getFrameAtTime(this.f2296d, 250, 2);
        if (frameAtTime != null) {
            return C0919Utils.saveBitmap(frameAtTime, C0919Utils.getDir(), ".AR_video_thumbnail.jpg");
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0901a doInBackground(String... strArr) {
        return m2650a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C0901a aVar) {
        super.onPostExecute(aVar);
        if (aVar == null) {
            return;
        }
        if (aVar.f2302a == 200) {
            this.f2301i.onSuccess(aVar.f2302a, aVar.f2303b);
        } else {
            this.f2301i.onFailure(aVar.f2302a, aVar.f2303b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.f2301i.onProgressUpdate(numArr[0].intValue());
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        this.f2301i.onStartUpload();
    }
}
