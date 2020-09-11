package com.baidu.p020ar.recg.fea;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.recg.ImgRecognitionClient;
import com.baidu.p020ar.recg.RecognitionResult;
import com.baidu.p020ar.util.C0919Utils;
import com.baidu.p020ar.util.FileUtils;
import com.baidu.p020ar.util.HttpUtils;
import com.baidu.p020ar.util.MD5Utils;
import com.baidu.p020ar.util.ZipUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.ar.recg.fea.f */
public class C0831f implements C0826a {

    /* renamed from: a */
    private static final String f2001a = "f";

    /* renamed from: f */
    private static volatile boolean f2002f = false;

    /* renamed from: g */
    private static volatile boolean f2003g = false;

    /* renamed from: b */
    private HandlerThread f2004b;

    /* renamed from: c */
    private Handler f2005c;

    /* renamed from: d */
    private C0830e f2006d;

    /* renamed from: e */
    private List<FeatureResource> f2007e;

    /* renamed from: com.baidu.ar.recg.fea.f$a */
    private class C0832a {

        /* renamed from: a */
        C0828c f2008a;

        /* renamed from: b */
        String f2009b;

        C0832a(C0828c cVar, String str) {
            this.f2008a = cVar;
            this.f2009b = str;
        }
    }

    /* renamed from: com.baidu.ar.recg.fea.f$b */
    private static class C0833b extends Handler {

        /* renamed from: a */
        private C0826a f2011a;

        public C0833b(Looper looper, C0826a aVar) {
            super(looper);
            this.f2011a = aVar;
        }

        public void handleMessage(Message message) {
            this.f2011a.mo10371a(message);
        }
    }

    /* renamed from: com.baidu.ar.recg.fea.f$c */
    private class C0834c {

        /* renamed from: a */
        String f2012a;

        /* renamed from: b */
        HashMap<String, String> f2013b;

        C0834c(String str, HashMap<String, String> hashMap) {
            this.f2012a = str;
            this.f2013b = hashMap;
        }
    }

    public C0831f() {
        m2255c();
    }

    /* renamed from: a */
    private ArrayList<File> m2246a(File file) {
        File[] listFiles = file.listFiles();
        ArrayList<File> arrayList = new ArrayList<>();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (!file2.isFile()) {
                    m2246a(file2);
                } else if (C0919Utils.isUTF8(file2.getPath())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m2247a(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            if (file.exists()) {
                this.f2007e = m2252b(FileUtils.readFileText(file));
                if (this.f2007e != null && this.f2007e.size() > 0) {
                    z = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f2006d != null) {
            this.f2006d.onFeatureJsonParse(z);
        }
    }

    /* renamed from: a */
    private static void m2248a(boolean z) {
        f2003g = z;
    }

    /* renamed from: a */
    private boolean m2249a(File file, File file2) {
        FileUtils.deleteDir(new File(file.toString() + "/fea"));
        boolean unzip = ZipUtils.unzip(file2, file);
        if (!unzip) {
            Log.e(f2001a, "handleDownloadResource unzip failed");
        }
        return unzip;
    }

    /* renamed from: a */
    private String[] m2250a(ArrayList<File> arrayList) {
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr[i] = arrayList.get(i).getPath();
        }
        return strArr;
    }

    /* renamed from: b */
    private File m2251b(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str + str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[Catch:{ JSONException -> 0x001e }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.baidu.p020ar.recg.fea.FeatureResource> m2252b(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0021
            java.lang.String r0 = "success"
            boolean r0 = r6.contains(r0)     // Catch:{ JSONException -> 0x001e }
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = "feaList"
            boolean r0 = r6.contains(r0)     // Catch:{ JSONException -> 0x001e }
            if (r0 == 0) goto L_0x0021
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001e }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x001e }
            java.lang.String r6 = "feaList"
            org.json.JSONArray r6 = r0.getJSONArray(r6)     // Catch:{ JSONException -> 0x001e }
            goto L_0x0027
        L_0x001e:
            r6 = move-exception
            goto L_0x0149
        L_0x0021:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x001e }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x001e }
            r6 = r0
        L_0x0027:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x001e }
            r0.<init>()     // Catch:{ JSONException -> 0x001e }
            int r1 = r6.length()     // Catch:{ JSONException -> 0x001e }
            if (r1 <= 0) goto L_0x0148
            r1 = 0
        L_0x0033:
            int r2 = r6.length()     // Catch:{ JSONException -> 0x001e }
            if (r1 >= r2) goto L_0x0148
            org.json.JSONObject r2 = r6.getJSONObject(r1)     // Catch:{ JSONException -> 0x001e }
            com.baidu.ar.recg.fea.FeatureResource r3 = new com.baidu.ar.recg.fea.FeatureResource     // Catch:{ JSONException -> 0x001e }
            r3.<init>()     // Catch:{ JSONException -> 0x001e }
            java.lang.String r4 = "arFileName"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x0053
            java.lang.String r4 = "arFileName"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10348a(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x0053:
            java.lang.String r4 = "arKey"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x0064
            java.lang.String r4 = "arKey"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10350b(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x0064:
            java.lang.String r4 = "arType"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x0075
            java.lang.String r4 = "arType"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10352c(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x0075:
            java.lang.String r4 = "contentId"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x0086
            java.lang.String r4 = "contentId"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10353d(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x0086:
            java.lang.String r4 = "contentTitle"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x0097
            java.lang.String r4 = "contentTitle"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10355e(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x0097:
            java.lang.String r4 = "contentVersionId"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x00a8
            java.lang.String r4 = "contentVersionId"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10356f(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x00a8:
            java.lang.String r4 = "createUser"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x00b9
            java.lang.String r4 = "createUser"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10357g(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x00b9:
            java.lang.String r4 = "os"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x00ca
            java.lang.String r4 = "os"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10358h(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x00ca:
            java.lang.String r4 = "sdkMax"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x00db
            java.lang.String r4 = "sdkMax"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10359i(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x00db:
            java.lang.String r4 = "sdkMin"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x00ec
            java.lang.String r4 = "sdkMin"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10360j(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x00ec:
            java.lang.String r4 = "tag"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x00fd
            java.lang.String r4 = "tag"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10361k(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x00fd:
            java.lang.String r4 = "arId"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x010e
            java.lang.String r4 = "arId"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10362l(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x010e:
            java.lang.String r4 = "imageUrl"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x011f
            java.lang.String r4 = "imageUrl"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10363m(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x011f:
            java.lang.String r4 = "imageMd5"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x0130
            java.lang.String r4 = "imageMd5"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10364n(r4)     // Catch:{ JSONException -> 0x001e }
        L_0x0130:
            java.lang.String r4 = "onlineStatus"
            boolean r4 = r2.has(r4)     // Catch:{ JSONException -> 0x001e }
            if (r4 == 0) goto L_0x0141
            java.lang.String r4 = "onlineStatus"
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x001e }
            r3.mo10365o(r2)     // Catch:{ JSONException -> 0x001e }
        L_0x0141:
            r0.add(r3)     // Catch:{ JSONException -> 0x001e }
            int r1 = r1 + 1
            goto L_0x0033
        L_0x0148:
            return r0
        L_0x0149:
            r6.printStackTrace()
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.recg.fea.C0831f.m2252b(java.lang.String):java.util.List");
    }

    /* renamed from: b */
    private void m2253b(int i, int i2, byte[] bArr) {
        RecognitionResult recognitionResult;
        if (f2002f) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                recognitionResult = ImgRecognitionClient.recogniseImage(bArr, i, i2);
            } catch (Throwable unused) {
                recognitionResult = null;
            }
            Log.e("qatest", "本地识图: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            boolean z = false;
            String str = "";
            String str2 = "";
            if (recognitionResult != null && this.f2007e != null && this.f2007e.size() > 0) {
                String str3 = recognitionResult.fileName;
                if (!TextUtils.isEmpty(str3)) {
                    Iterator<FeatureResource> it = this.f2007e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeatureResource next = it.next();
                        if (str3.equals(next.mo10347a())) {
                            z = true;
                            str = next.mo10349b();
                            str2 = next.mo10351c();
                            break;
                        }
                    }
                }
            }
            if (this.f2006d != null && !f2003g) {
                this.f2006d.onYuvImageSearch(z, str, str2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080 A[Catch:{ JSONException -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[Catch:{ JSONException -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1 A[Catch:{ JSONException -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2254b(java.lang.String r4, java.util.HashMap<java.lang.String, java.lang.String> r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r5 == 0) goto L_0x003d
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x000f:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            r0.append(r2)
            java.lang.String r2 = "="
            r0.append(r2)
            java.lang.Object r1 = r1.getValue()
            r0.append(r1)
            java.lang.String r1 = "&"
            r0.append(r1)
            goto L_0x000f
        L_0x0034:
            java.lang.String r5 = "&"
            int r5 = r0.lastIndexOf(r5)
            r0.deleteCharAt(r5)
        L_0x003d:
            java.lang.String r5 = r0.toString()
            java.lang.String r4 = com.baidu.p020ar.util.HttpUtils.post(r4, r5)
            com.baidu.ar.recg.fea.d r5 = new com.baidu.ar.recg.fea.d
            r5.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e3 }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x00e3 }
            java.lang.String r4 = "errorNum"
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x00e3 }
            r1 = 0
            r2 = 1
            if (r4 == 0) goto L_0x0066
            java.lang.String r4 = "errorNum"
            int r4 = r0.getInt(r4)     // Catch:{ JSONException -> 0x00e3 }
            if (r4 != 0) goto L_0x0062
            r1 = 1
        L_0x0062:
            r5.mo10382a((boolean) r1)     // Catch:{ JSONException -> 0x00e3 }
            goto L_0x0078
        L_0x0066:
            java.lang.String r4 = "err_code"
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x00e3 }
            if (r4 == 0) goto L_0x0078
            java.lang.String r4 = "err_code"
            int r4 = r0.getInt(r4)     // Catch:{ JSONException -> 0x00e3 }
            if (r4 != 0) goto L_0x0062
            r1 = 1
            goto L_0x0062
        L_0x0078:
            java.lang.String r4 = "errorMsg"
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x00e3 }
            if (r4 == 0) goto L_0x008a
            java.lang.String r4 = "errorMsg"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ JSONException -> 0x00e3 }
        L_0x0086:
            r5.mo10381a((java.lang.String) r4)     // Catch:{ JSONException -> 0x00e3 }
            goto L_0x0099
        L_0x008a:
            java.lang.String r4 = "err_msg"
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x00e3 }
            if (r4 == 0) goto L_0x0099
            java.lang.String r4 = "err_msg"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ JSONException -> 0x00e3 }
            goto L_0x0086
        L_0x0099:
            java.lang.String r4 = "data"
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x00e3 }
            if (r4 == 0) goto L_0x00e7
            java.lang.String r4 = "data"
            org.json.JSONObject r4 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x00e3 }
            com.baidu.ar.recg.fea.c r0 = new com.baidu.ar.recg.fea.c     // Catch:{ JSONException -> 0x00e3 }
            r0.<init>()     // Catch:{ JSONException -> 0x00e3 }
            java.lang.String r1 = "url"
            boolean r1 = r4.has(r1)     // Catch:{ JSONException -> 0x00e3 }
            if (r1 == 0) goto L_0x00bd
            java.lang.String r1 = "url"
            java.lang.String r1 = r4.getString(r1)     // Catch:{ JSONException -> 0x00e3 }
            r0.mo10377b(r1)     // Catch:{ JSONException -> 0x00e3 }
        L_0x00bd:
            java.lang.String r1 = "ar_code_url"
            boolean r1 = r4.has(r1)     // Catch:{ JSONException -> 0x00e3 }
            if (r1 == 0) goto L_0x00ce
            java.lang.String r1 = "ar_code_url"
            java.lang.String r1 = r4.getString(r1)     // Catch:{ JSONException -> 0x00e3 }
            r0.mo10375a(r1)     // Catch:{ JSONException -> 0x00e3 }
        L_0x00ce:
            java.lang.String r1 = "md5"
            boolean r1 = r4.has(r1)     // Catch:{ JSONException -> 0x00e3 }
            if (r1 == 0) goto L_0x00df
            java.lang.String r1 = "md5"
            java.lang.String r4 = r4.getString(r1)     // Catch:{ JSONException -> 0x00e3 }
            r0.mo10379c(r4)     // Catch:{ JSONException -> 0x00e3 }
        L_0x00df:
            r5.mo10380a((com.baidu.p020ar.recg.fea.C0828c) r0)     // Catch:{ JSONException -> 0x00e3 }
            goto L_0x00e7
        L_0x00e3:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00e7:
            com.baidu.ar.recg.fea.e r4 = r3.f2006d
            if (r4 == 0) goto L_0x00f0
            com.baidu.ar.recg.fea.e r4 = r3.f2006d
            r4.onResourceRequest(r5)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.recg.fea.C0831f.m2254b(java.lang.String, java.util.HashMap):void");
    }

    /* renamed from: c */
    private void m2255c() {
        if (!m2259d()) {
            this.f2004b = new HandlerThread("FeatureSearchThread");
            this.f2004b.start();
            this.f2005c = new C0833b(this.f2004b.getLooper(), this);
        }
    }

    /* renamed from: c */
    private void m2256c(C0828c cVar, String str) {
        File b = m2251b(str, cVar.mo10376b().substring(cVar.mo10376b().lastIndexOf("/")));
        boolean a = (!b.exists() || b.length() <= 0) ? false : m2249a(b.getParentFile(), b);
        if (this.f2006d != null) {
            this.f2006d.onFeatureFilesUnzip(a);
        }
    }

    /* renamed from: c */
    private void m2257c(String str) {
        boolean z;
        ArrayList<File> a;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (!file.exists() || !file.isDirectory() || (a = m2246a(file)) == null || a.size() <= 0) {
                    z = false;
                } else {
                    try {
                        z = ImgRecognitionClient.init(m2250a(a));
                    } catch (Throwable unused) {
                        z = false;
                    }
                    f2002f = z;
                }
                if (this.f2006d != null) {
                    this.f2006d.onFeatureFilesInit(z);
                }
            }
        } catch (Throwable unused2) {
            if (this.f2006d != null) {
                this.f2006d.onFeatureFilesInit(false);
            }
        }
    }

    /* renamed from: d */
    private void m2258d(C0828c cVar, String str) {
        File b = m2251b(str, cVar.mo10376b().substring(cVar.mo10376b().lastIndexOf("/")));
        FileUtils.deleteFileIfExist(b);
        boolean downloadFile = HttpUtils.downloadFile(cVar.mo10376b(), b);
        if (downloadFile) {
            try {
                String fileMD5String = MD5Utils.getFileMD5String(b);
                downloadFile = !TextUtils.isEmpty(fileMD5String) && fileMD5String.equals(cVar.mo10378c());
                if (!downloadFile) {
                    FileUtils.deleteFileIfExist(b);
                    Log.e(f2001a, "handleDownloadResource md5 failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (downloadFile && !(downloadFile = m2249a(b.getParentFile(), b))) {
            Log.e(f2001a, "handleDownloadResource unzip failed");
        }
        if (this.f2006d != null) {
            this.f2006d.onResourceDownload(downloadFile, cVar.mo10378c());
        }
    }

    /* renamed from: d */
    private boolean m2259d() {
        return this.f2004b != null && this.f2004b.isAlive();
    }

    /* renamed from: e */
    private void m2260e() {
        boolean z;
        if (this.f2007e != null) {
            this.f2007e.clear();
            this.f2007e = null;
        }
        boolean z2 = false;
        try {
            z = ImgRecognitionClient.release();
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            z2 = true;
        }
        f2002f = z2;
        if (this.f2006d != null) {
            this.f2006d.onFeaturesClear(z);
        }
    }

    /* renamed from: f */
    private void m2261f() {
        if (this.f2004b != null) {
            this.f2004b.getLooper().quit();
        }
        if (this.f2006d != null) {
            this.f2006d.onThreadQuit();
            this.f2006d = null;
        }
        this.f2004b = null;
        this.f2005c = null;
    }

    /* renamed from: a */
    public void mo10387a() {
        m2248a(true);
        if (this.f2005c != null) {
            this.f2005c.removeMessages(1006);
            this.f2005c.sendMessage(this.f2005c.obtainMessage(ARPMessageType.MSG_TYPE_RESUME_MUSIC));
        }
    }

    /* renamed from: a */
    public void mo10388a(int i, int i2, byte[] bArr) {
        if (this.f2005c != null) {
            this.f2005c.removeMessages(1006);
            this.f2005c.sendMessage(this.f2005c.obtainMessage(1006, i, i2, bArr));
        }
    }

    /* renamed from: a */
    public void mo10371a(Message message) {
        if (message != null) {
            switch (message.what) {
                case 1001:
                    C0834c cVar = (C0834c) message.obj;
                    m2254b(cVar.f2012a, cVar.f2013b);
                    return;
                case 1002:
                    C0832a aVar = (C0832a) message.obj;
                    m2258d(aVar.f2008a, aVar.f2009b);
                    return;
                case 1003:
                    m2247a((String) message.obj);
                    return;
                case 1004:
                    m2257c((String) message.obj);
                    return;
                case ARPMessageType.MSG_TYPE_RESUME_MUSIC:
                    m2260e();
                    return;
                case 1006:
                    m2253b(message.arg1, message.arg2, (byte[]) message.obj);
                    return;
                case 1007:
                    m2261f();
                    return;
                case 1008:
                    C0832a aVar2 = (C0832a) message.obj;
                    m2256c(aVar2.f2008a, aVar2.f2009b);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo10389a(C0828c cVar, String str) {
        if (this.f2005c != null) {
            this.f2005c.sendMessage(this.f2005c.obtainMessage(1002, new C0832a(cVar, str)));
        }
    }

    /* renamed from: a */
    public void mo10390a(C0830e eVar) {
        this.f2006d = eVar;
    }

    /* renamed from: a */
    public void mo10391a(String str, String str2) {
        m2248a(false);
        if (this.f2005c != null) {
            this.f2005c.sendMessage(this.f2005c.obtainMessage(1003, str));
            this.f2005c.sendMessage(this.f2005c.obtainMessage(1004, str2));
        }
    }

    /* renamed from: a */
    public void mo10392a(String str, HashMap<String, String> hashMap) {
        if (this.f2005c != null) {
            this.f2005c.removeMessages(1007);
            this.f2005c.sendMessage(this.f2005c.obtainMessage(1001, new C0834c(str, hashMap)));
        }
    }

    /* renamed from: b */
    public void mo10393b() {
        if (this.f2005c != null) {
            this.f2005c.sendMessage(this.f2005c.obtainMessage(1007));
        }
    }

    /* renamed from: b */
    public void mo10394b(C0828c cVar, String str) {
        if (this.f2005c != null) {
            this.f2005c.sendMessage(this.f2005c.obtainMessage(1008, new C0832a(cVar, str)));
        }
    }
}
