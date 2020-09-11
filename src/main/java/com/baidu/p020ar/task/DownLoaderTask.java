package com.baidu.p020ar.task;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.p020ar.util.ARLog;

/* renamed from: com.baidu.ar.task.DownLoaderTask */
public class DownLoaderTask extends AsyncTask<String, Integer, String> {

    /* renamed from: g */
    private static long f2285g;

    /* renamed from: a */
    private String f2286a = "";

    /* renamed from: b */
    private String f2287b = null;

    /* renamed from: c */
    private ActionResponseListener<String> f2288c;

    /* renamed from: d */
    private boolean f2289d = false;

    /* renamed from: e */
    private boolean f2290e;

    /* renamed from: f */
    private ContentResolver f2291f;

    /* renamed from: h */
    private long f2292h;

    public DownLoaderTask(String str, String str2, boolean z, long j, ActionResponseListener<String> actionResponseListener) {
        this.f2286a = str;
        this.f2287b = str2;
        this.f2288c = actionResponseListener;
        this.f2290e = z;
        this.f2292h = j;
    }

    public DownLoaderTask(String str, String str2, boolean z, ContentResolver contentResolver, long j, ActionResponseListener<String> actionResponseListener) {
        this.f2286a = str;
        this.f2287b = str2;
        this.f2288c = actionResponseListener;
        this.f2290e = z;
        this.f2291f = contentResolver;
        this.f2292h = j;
    }

    /* renamed from: a */
    private void m2642a() {
        while (this.f2289d) {
            ARLog.m2695d("mIsPause = " + this.f2289d);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r4 = r4.list();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2643a(java.lang.String r3, java.io.File r4) {
        /*
            r2 = this;
            boolean r0 = r4.exists()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r4.isDirectory()
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            java.lang.String[] r4 = r4.list()
            if (r4 == 0) goto L_0x0024
            int r4 = r4.length
            if (r4 != 0) goto L_0x0019
            goto L_0x0024
        L_0x0019:
            java.lang.String r4 = ".successUnzip.txt"
            boolean r3 = com.baidu.p020ar.util.ARFileUtils.checkKeyInFile(r3, r4)
            if (r3 != 0) goto L_0x0022
            return r1
        L_0x0022:
            r3 = 0
            return r3
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.task.DownLoaderTask.m2643a(java.lang.String, java.io.File):boolean");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:67:0x0115=Splitter:B:67:0x0115, B:61:0x010c=Splitter:B:61:0x010c} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2644b(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.File r0 = new java.io.File
            r0.<init>(r12)
            int r2 = r12.length()
            r3 = 4
            if (r2 > r3) goto L_0x0015
            return r1
        L_0x0015:
            java.lang.String r2 = r11.f2286a
            java.lang.String r2 = com.baidu.p020ar.util.ARFileUtils.getARCaseDirPath(r2)
            java.io.File r3 = new java.io.File
            r3.<init>(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bdar: unzipFilePath "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.baidu.p020ar.util.ARLog.m2696e(r4)
            java.io.File r4 = new java.io.File
            java.lang.String r5 = r11.f2286a
            java.lang.String r5 = com.baidu.p020ar.util.ARFileUtils.getARCaseFullPath(r5)
            r4.<init>(r5)
            java.lang.String r12 = com.baidu.p020ar.util.MD5Utils.md5(r12)
            boolean r5 = r11.f2290e
            if (r5 != 0) goto L_0x0058
            boolean r5 = r11.m2643a(r12, r4)
            if (r5 == 0) goto L_0x0057
            boolean r5 = r4.exists()
            if (r5 == 0) goto L_0x0058
            com.baidu.p020ar.util.ARFileUtils.deleteDir(r4)
            goto L_0x0058
        L_0x0057:
            return r2
        L_0x0058:
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x0113, IOException -> 0x010a, all -> 0x0107 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x0113, IOException -> 0x010a, all -> 0x0107 }
            java.util.Enumeration r0 = r4.entries()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
        L_0x0061:
            boolean r5 = r0.hasMoreElements()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            if (r5 == 0) goto L_0x00f6
            r11.m2642a()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.Object r5 = r0.nextElement()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.util.zip.ZipEntry r5 = (java.util.zip.ZipEntry) r5     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r6 = r5.getName()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r7 = "../"
            boolean r6 = r6.contains(r7)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            if (r6 == 0) goto L_0x007d
            goto L_0x0061
        L_0x007d:
            boolean r6 = r5.isDirectory()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            if (r6 == 0) goto L_0x0084
            goto L_0x0061
        L_0x0084:
            java.io.File r6 = new java.io.File     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r7 = r5.getName()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            r6.<init>(r3, r7)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            boolean r7 = r6.exists()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            if (r7 == 0) goto L_0x00a0
            long r7 = r6.length()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            long r9 = r5.getSize()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x00a0
            goto L_0x0061
        L_0x00a0:
            java.io.File r7 = r6.getParentFile()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            boolean r7 = r7.exists()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            if (r7 != 0) goto L_0x00d9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            r7.<init>()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r8 = "file path = "
            r7.append(r8)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r8 = r6.getAbsolutePath()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            r7.append(r8)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r8 = ", parent path = "
            r7.append(r8)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.io.File r8 = r6.getParentFile()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            r7.append(r8)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.lang.String r7 = r7.toString()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            com.baidu.p020ar.util.ARLog.m2695d(r7)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            java.io.File r7 = r6.getParentFile()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            r7.mkdirs()     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
        L_0x00d9:
            java.io.InputStream r5 = r4.getInputStream(r5)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
            com.baidu.p020ar.util.IoUtils.copyStream((java.io.InputStream) r5, (java.io.File) r6)     // Catch:{ IOException -> 0x00e7 }
        L_0x00e0:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r5)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            goto L_0x0061
        L_0x00e5:
            r12 = move-exception
            goto L_0x00f2
        L_0x00e7:
            r6 = move-exception
            goto L_0x00ee
        L_0x00e9:
            r12 = move-exception
            r5 = r1
            goto L_0x00f2
        L_0x00ec:
            r6 = move-exception
            r5 = r1
        L_0x00ee:
            r6.printStackTrace()     // Catch:{ all -> 0x00e5 }
            goto L_0x00e0
        L_0x00f2:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r5)     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
            throw r12     // Catch:{ ZipException -> 0x0105, IOException -> 0x0103 }
        L_0x00f6:
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r4)
            boolean r0 = r11.f2290e
            if (r0 != 0) goto L_0x0102
            java.lang.String r0 = ".successUnzip.txt"
            com.baidu.p020ar.util.ARFileUtils.putKeyToFile(r12, r0)
        L_0x0102:
            return r2
        L_0x0103:
            r12 = move-exception
            goto L_0x010c
        L_0x0105:
            r12 = move-exception
            goto L_0x0115
        L_0x0107:
            r12 = move-exception
            r4 = r1
            goto L_0x011d
        L_0x010a:
            r12 = move-exception
            r4 = r1
        L_0x010c:
            r12.printStackTrace()     // Catch:{ all -> 0x011c }
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r4)
            return r1
        L_0x0113:
            r12 = move-exception
            r4 = r1
        L_0x0115:
            r12.printStackTrace()     // Catch:{ all -> 0x011c }
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r4)
            return r1
        L_0x011c:
            r12 = move-exception
        L_0x011d:
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.task.DownLoaderTask.m2644b(java.lang.String):java.lang.String");
    }

    public static DownLoaderTask doDownLoadWork(String str, String str2, String str3, boolean z, ContentResolver contentResolver, ActionResponseListener<String> actionResponseListener) {
        f2285g = System.currentTimeMillis();
        DownLoaderTask downLoaderTask = new DownLoaderTask(str, str2, z, contentResolver, f2285g, actionResponseListener);
        downLoaderTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str3});
        return downLoaderTask;
    }

    public static DownLoaderTask doDownLoadWork(String str, String str2, String str3, boolean z, ActionResponseListener<String> actionResponseListener) {
        f2285g = System.currentTimeMillis();
        DownLoaderTask downLoaderTask = new DownLoaderTask(str, str2, z, f2285g, actionResponseListener);
        downLoaderTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str3});
        return downLoaderTask;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (android.text.TextUtils.isEmpty(r13) == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        com.baidu.p020ar.base.C0618d.m1298a((int) com.baidu.p020ar.base.MsgField.MSG_STAT_FIRST_LOAD_FILE_MANAGE_FAILURE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x016a, code lost:
        if (android.text.TextUtils.isEmpty(r13) != false) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f7 A[Catch:{ IOException -> 0x0145, all -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0139 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doInBackground(java.lang.String... r13) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x0185
            int r1 = r13.length
            if (r1 <= 0) goto L_0x0185
            r1 = 0
            r13 = r13[r1]
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 == 0) goto L_0x0010
            return r0
        L_0x0010:
            android.content.ContentResolver r2 = r12.f2291f
            if (r2 == 0) goto L_0x0019
            android.content.ContentResolver r2 = r12.f2291f
            com.baidu.p020ar.util.ARFileUtils.hideARResourceFile(r2)
        L_0x0019:
            java.lang.String r2 = r12.f2287b
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0022
            return r0
        L_0x0022:
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r12.f2287b
            r2.<init>(r3)
            java.io.File r3 = r2.getParentFile()
            com.baidu.p020ar.util.FileUtils.ensureDir(r3)
            int r3 = com.baidu.p020ar.util.HttpUtils.getLength(r13)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "download length = "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.baidu.p020ar.util.ARLog.m2695d(r4)
            if (r3 > 0) goto L_0x004b
            return r0
        L_0x004b:
            boolean r4 = r2.exists()
            r5 = 9002(0x232a, float:1.2614E-41)
            r6 = 9001(0x2329, float:1.2613E-41)
            r7 = 9000(0x2328, float:1.2612E-41)
            if (r4 == 0) goto L_0x008a
            long r8 = (long) r3
            long r10 = r2.length()
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 != 0) goto L_0x0086
            java.lang.String r4 = r12.f2287b
            boolean r4 = com.baidu.p020ar.util.ZipUtils.isZipFile(r4)
            if (r4 == 0) goto L_0x0086
            com.baidu.p020ar.base.C0618d.m1298a((int) r7)
            java.lang.String r13 = r12.f2287b
            java.lang.String r13 = r12.m2644b(r13)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L_0x007b
        L_0x0077:
            com.baidu.p020ar.base.C0618d.m1298a((int) r6)
            goto L_0x007e
        L_0x007b:
            com.baidu.p020ar.base.C0618d.m1298a((int) r5)
        L_0x007e:
            r12.m2642a()
            java.lang.String r13 = com.baidu.p020ar.util.ArResourceUtils.generateResult(r13)
            return r13
        L_0x0086:
            r2.delete()
            goto L_0x0097
        L_0x008a:
            java.io.File r4 = r2.getParentFile()
            boolean r4 = com.baidu.p020ar.util.FileUtils.ensureDirectoryExist(r4)
            if (r4 == 0) goto L_0x0180
            r2.createNewFile()     // Catch:{ IOException -> 0x0176 }
        L_0x0097:
            java.io.File r2 = new java.io.File
            java.lang.String r4 = r12.f2286a
            java.lang.String r4 = com.baidu.p020ar.util.ARFileUtils.getARCaseFullPath(r4)
            r2.<init>(r4)
            boolean r4 = r2.exists()
            if (r4 == 0) goto L_0x00ab
            com.baidu.p020ar.util.ARFileUtils.deleteDir(r2)
        L_0x00ab:
            r2 = 9003(0x232b, float:1.2616E-41)
            com.baidu.p020ar.base.C0618d.m1298a((int) r2)
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            r2.<init>(r13)     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            java.net.URLConnection r13 = r2.openConnection()     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            r2 = 10000(0x2710, float:1.4013E-41)
            r13.setConnectTimeout(r2)     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            java.lang.String r2 = "Range"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            r4.<init>()     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            java.lang.String r8 = "bytes=0-"
            r4.append(r8)     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            r4.append(r3)     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            r13.setRequestProperty(r2, r3)     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            java.lang.String r3 = r12.f2287b     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            java.lang.String r4 = "rw"
            r2.<init>(r3, r4)     // Catch:{ IOException -> 0x014d, all -> 0x014a }
            r3 = 0
            r2.seek(r3)     // Catch:{ IOException -> 0x0148 }
            r3 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r3]     // Catch:{ IOException -> 0x0148 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0148 }
            java.io.InputStream r13 = r13.getInputStream()     // Catch:{ IOException -> 0x0148 }
            r8.<init>(r13, r3)     // Catch:{ IOException -> 0x0148 }
            r13 = 0
        L_0x00f0:
            int r9 = r8.read(r4, r1, r3)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            r10 = -1
            if (r9 == r10) goto L_0x0139
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            r10.<init>()     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            java.lang.String r11 = "one while read start n ="
            r10.append(r11)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            r10.append(r9)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            com.baidu.p020ar.util.ARLog.m2695d(r10)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            r2.write(r4, r1, r9)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            int r13 = r13 + r9
            r12.m2642a()     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            boolean r9 = r12.isCancelled()     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            if (r9 == 0) goto L_0x0124
            java.lang.String r13 = "cancelled"
            com.baidu.p020ar.util.ARLog.m2695d(r13)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r8)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r2)
            return r0
        L_0x0124:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            r9.<init>()     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            java.lang.String r10 = "one while read end count = "
            r9.append(r10)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            r9.append(r13)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            com.baidu.p020ar.util.ARLog.m2695d(r9)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            goto L_0x00f0
        L_0x0139:
            r13 = 9004(0x232c, float:1.2617E-41)
            com.baidu.p020ar.base.C0618d.m1298a((int) r13)     // Catch:{ IOException -> 0x0145, all -> 0x0142 }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r8)
            goto L_0x015a
        L_0x0142:
            r13 = move-exception
            r0 = r8
            goto L_0x016f
        L_0x0145:
            r13 = move-exception
            r0 = r8
            goto L_0x014f
        L_0x0148:
            r13 = move-exception
            goto L_0x014f
        L_0x014a:
            r13 = move-exception
            r2 = r0
            goto L_0x016f
        L_0x014d:
            r13 = move-exception
            r2 = r0
        L_0x014f:
            r13.printStackTrace()     // Catch:{ all -> 0x016e }
            r13 = 9005(0x232d, float:1.2619E-41)
            com.baidu.p020ar.base.C0618d.m1298a((int) r13)     // Catch:{ all -> 0x016e }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
        L_0x015a:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r2)
            com.baidu.p020ar.base.C0618d.m1298a((int) r7)
            java.lang.String r13 = r12.f2287b
            java.lang.String r13 = r12.m2644b(r13)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L_0x007b
            goto L_0x0077
        L_0x016e:
            r13 = move-exception
        L_0x016f:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r2)
            throw r13
        L_0x0176:
            r13 = move-exception
            java.lang.String r1 = "create zip file error!"
            com.baidu.p020ar.util.ARLog.m2696e(r1)
            r13.printStackTrace()
            return r0
        L_0x0180:
            java.lang.String r13 = "create file error!"
            com.baidu.p020ar.util.ARLog.m2696e(r13)
        L_0x0185:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.task.DownLoaderTask.doInBackground(java.lang.String[]):java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str) || this.f2292h != f2285g || "{}".equals(str)) {
            this.f2288c.onErrorResponse("download error!");
        } else {
            this.f2288c.onResponse(str);
        }
    }

    public boolean isPause() {
        return this.f2289d;
    }

    public void setPause(boolean z) {
        this.f2289d = z;
    }
}
