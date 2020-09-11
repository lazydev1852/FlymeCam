package com.baidu.p020ar.recg;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.recg.fea.C0827b;
import com.baidu.p020ar.recg.fea.C0829d;
import com.baidu.p020ar.recg.fea.C0830e;
import com.baidu.p020ar.recg.fea.C0831f;
import com.baidu.p020ar.resloader.C0884e;
import com.baidu.p020ar.resloader.C0886f;
import com.baidu.p020ar.task.HttpTaskUtility;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.ARSDKInfo;
import com.baidu.p020ar.util.UrlUtils;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.baidu.ar.recg.ImageRecognitionManager */
public class ImageRecognitionManager implements C0830e {

    /* renamed from: a */
    private static final String f1959a = "ImageRecognitionManager";

    /* renamed from: f */
    private static volatile boolean f1960f = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0831f f1961b = new C0831f();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f1962c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ImageRecognitionCallback f1963d;

    /* renamed from: e */
    private C0884e f1964e;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f1965g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f1966h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f1967i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0829d f1968j;

    /* renamed from: a */
    private static void m2172a(boolean z) {
        f1960f = z;
    }

    public void initRecognition(Context context, ImageRecognitionCallback imageRecognitionCallback) {
        this.f1962c = context;
        this.f1963d = imageRecognitionCallback;
        this.f1964e = new C0884e(this.f1962c);
        if (this.f1961b != null) {
            this.f1961b.mo10390a((C0830e) this);
            HashMap hashMap = new HashMap();
            HttpTaskUtility.addBasicInfo(context, (HashMap<String, String>) hashMap);
            hashMap.put(HttpConstants.HTTP_ENGINE_VERSION, String.valueOf(ARSDKInfo.getVersionCode()));
            hashMap.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
            hashMap.put(HttpConstants.CUID, ARConfig.getCUID());
            this.f1961b.mo10392a(UrlUtils.getDeviceRecgUrl(), (HashMap<String, String>) hashMap);
        }
    }

    public void onFeatureFilesInit(boolean z) {
        m2172a(z);
        if (this.f1963d != null) {
            this.f1963d.onFeatureDBInit(z);
        }
    }

    public void onFeatureFilesUnzip(boolean z) {
        if (!z) {
            ARLog.m2695d("unzip failed");
        } else if (this.f1961b != null) {
            this.f1961b.mo10391a(this.f1966h, this.f1967i);
        }
    }

    public void onFeatureJsonParse(boolean z) {
    }

    public void onFeaturesClear(boolean z) {
        m2172a(!z);
    }

    public void onResourceDownload(boolean z, String str) {
        if (z) {
            new C0827b(this.f1962c).mo10373a(str);
        }
        if (this.f1963d != null) {
            this.f1963d.onResourceDownload(z);
        }
    }

    public void onResourceRequest(C0829d dVar) {
        if (dVar == null || this.f1962c == null || this.f1963d == null) {
            ARLog.m2696e("onResourceRequest error!!! response == null");
            return;
        }
        try {
            this.f1968j = dVar;
            this.f1963d.onSoLoadDownloadStart();
            this.f1964e.mo10571a((C0886f) new C0821a());
            this.f1964e.mo10570a((C0884e.C0885a) new C0884e.C0885a() {
                /* renamed from: a */
                public void mo8857a(boolean z) {
                    if (ImageRecognitionManager.this.f1963d != null) {
                        ImageRecognitionManager.this.f1963d.onSoLoadState(z);
                    }
                    if (ImageRecognitionManager.this.f1968j.mo10383a()) {
                        String a = new C0827b(ImageRecognitionManager.this.f1962c).mo10372a();
                        String c = ImageRecognitionManager.this.f1968j.mo10386d().mo10378c();
                        String substring = ImageRecognitionManager.this.f1968j.mo10386d().mo10376b().substring(ImageRecognitionManager.this.f1968j.mo10386d().mo10376b().lastIndexOf("/"));
                        ImageRecognitionManager imageRecognitionManager = ImageRecognitionManager.this;
                        String unused = imageRecognitionManager.f1965g = ARFileUtils.getARCachePath() + "/feature";
                        ImageRecognitionManager imageRecognitionManager2 = ImageRecognitionManager.this;
                        String unused2 = imageRecognitionManager2.f1966h = ImageRecognitionManager.this.f1965g + "/fea.json";
                        ImageRecognitionManager imageRecognitionManager3 = ImageRecognitionManager.this;
                        String unused3 = imageRecognitionManager3.f1967i = ImageRecognitionManager.this.f1965g + "/fea";
                        File file = new File(ImageRecognitionManager.this.f1965g + "/" + substring);
                        if (ImageRecognitionManager.this.f1961b != null) {
                            if (TextUtils.isEmpty(a) || !a.equals(c) || !file.exists()) {
                                if (ImageRecognitionManager.this.f1963d != null) {
                                    ImageRecognitionManager.this.f1963d.onFeatureDownloadStart();
                                }
                                ImageRecognitionManager.this.f1961b.mo10389a(ImageRecognitionManager.this.f1968j.mo10386d(), ImageRecognitionManager.this.f1965g);
                            } else {
                                ImageRecognitionManager.this.f1961b.mo10394b(ImageRecognitionManager.this.f1968j.mo10386d(), ImageRecognitionManager.this.f1965g);
                            }
                        }
                    }
                    if (ImageRecognitionManager.this.f1963d != null) {
                        ImageRecognitionManager.this.f1963d.onResourceRequest(ImageRecognitionManager.this.f1968j.mo10383a(), ImageRecognitionManager.this.f1968j.mo10384b(), ImageRecognitionManager.this.f1968j.mo10385c());
                    }
                }
            });
            if (dVar.mo10386d() != null) {
                this.f1964e.mo10574a(dVar.mo10386d().mo10374a());
            } else if (this.f1963d != null) {
                this.f1963d.onResourceRequest(this.f1968j.mo10383a(), this.f1968j.mo10384b(), this.f1968j.mo10385c());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onThreadQuit() {
    }

    public void onYuvImageSearch(boolean z, String str, String str2) {
        if (this.f1963d != null) {
            this.f1963d.onRecognizeResult(z, str, str2);
        }
    }

    public void recognizeFrame(int i, int i2, byte[] bArr) {
        if (f1960f && this.f1961b != null) {
            this.f1961b.mo10388a(i, i2, bArr);
        }
    }

    public void release() {
        this.f1962c = null;
        this.f1963d = null;
        if (this.f1964e != null) {
            this.f1964e.mo10569a();
        }
    }

    public void startRecognition() {
        if (!TextUtils.isEmpty(this.f1966h) && !TextUtils.isEmpty(this.f1967i) && this.f1961b != null) {
            this.f1961b.mo10390a((C0830e) this);
            this.f1961b.mo10391a(this.f1966h, this.f1967i);
        }
    }

    public void stopRecognition() {
        if (this.f1961b != null) {
            this.f1961b.mo10387a();
            this.f1961b.mo10393b();
        }
    }
}
