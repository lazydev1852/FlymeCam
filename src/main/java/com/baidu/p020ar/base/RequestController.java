package com.baidu.p020ar.base;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.bean.ARResource;
import com.baidu.p020ar.parser.ParserJson;
import com.baidu.p020ar.resloader.C0883d;
import com.baidu.p020ar.resloader.C0884e;
import com.baidu.p020ar.resloader.C0886f;
import com.baidu.p020ar.resloader.C0887g;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.task.DownLoaderTask;
import com.baidu.p020ar.task.HttpHandle;
import com.baidu.p020ar.task.HttpResponseListener;
import com.baidu.p020ar.task.HttpTaskUtility;
import com.baidu.p020ar.test.C0903a;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.ArResourceUtils;
import com.baidu.p020ar.util.Constants;
import com.baidu.p020ar.util.NetworkUtil;
import com.baidu.p020ar.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.base.RequestController */
public class RequestController implements C0887g {

    /* renamed from: a */
    private static boolean f970a = false;

    /* renamed from: b */
    private DownLoaderTask f971b;

    /* renamed from: c */
    private HttpHandle f972c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0608c f973d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0606a f974e;

    /* renamed from: f */
    private Context f975f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f976g = false;

    /* renamed from: h */
    private ARResource f977h;

    /* renamed from: i */
    private C0884e f978i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0884e.C0885a f979j;

    /* renamed from: k */
    private C0607b f980k;

    /* renamed from: l */
    private boolean f981l = false;

    /* renamed from: m */
    private long f982m;

    /* renamed from: com.baidu.ar.base.RequestController$a */
    private static class C0606a implements ActionResponseListener<String> {

        /* renamed from: a */
        private WeakReference<RequestController> f986a;

        public C0606a(RequestController requestController) {
            this.f986a = new WeakReference<>(requestController);
        }

        /* renamed from: a */
        public void mo9501a() {
            this.f986a.clear();
        }

        /* renamed from: a */
        public void onResponse(String str) {
            if (this.f986a != null && this.f986a.get() != null) {
                ((RequestController) this.f986a.get()).m1227b(str);
            }
        }

        public void onErrorResponse(String str) {
            if (this.f986a != null && this.f986a.get() != null) {
                ((RequestController) this.f986a.get()).m1230c(str);
            }
        }

        public void onProgress(int i) {
            ARLog.m2695d("onProgress: " + i);
        }

        public void onUpdate(boolean z, float f) {
            ARLog.m2695d("onUpdate: isUpdate=" + z + ", size=" + f);
        }
    }

    /* renamed from: com.baidu.ar.base.RequestController$b */
    public interface C0607b {
        /* renamed from: a */
        void mo8858a(ARResource aRResource);
    }

    /* renamed from: com.baidu.ar.base.RequestController$c */
    private static class C0608c implements HttpResponseListener<JSONObject> {

        /* renamed from: a */
        private WeakReference<RequestController> f987a;

        public C0608c(RequestController requestController) {
            this.f987a = new WeakReference<>(requestController);
        }

        /* renamed from: a */
        public void mo9503a() {
            this.f987a.clear();
        }

        /* renamed from: a */
        public void onResponse(JSONObject jSONObject) {
            if (this.f987a != null && this.f987a.get() != null) {
                ((RequestController) this.f987a.get()).m1223a(jSONObject);
            }
        }

        public void onErrorResponse(String str) {
            if (this.f987a != null && this.f987a.get() != null) {
                ((RequestController) this.f987a.get()).m1222a(str);
            }
        }
    }

    public RequestController(Context context) {
        if (context != null) {
            this.f975f = context.getApplicationContext();
            this.f978i = new C0884e(this.f975f);
            this.f978i.mo10571a((C0886f) new C0883d());
            this.f978i.mo10572a((C0887g) this);
        }
    }

    /* renamed from: a */
    private void m1218a() {
        if (f970a) {
            m1225b();
            return;
        }
        ARLog.m2695d("queryArType");
        C0618d.m1298a(2300);
        this.f973d = new C0608c(this);
        this.f972c = HttpTaskUtility.doQueryArResource(this.f975f, this.f973d);
        if (this.f972c == null) {
            ARLog.m2696e("Http Request Occur Error! Please Check");
        }
    }

    /* renamed from: a */
    private void m1221a(ARResource aRResource) {
        int i;
        if (aRResource.getErrCode() != 1044) {
            Log.e("bdar", "error code = " + aRResource.getErrCode() + ", error msg = " + aRResource.getErrMsg());
            i = MsgField.MSG_ON_QUERY_RESOURCE_ERROR_SERVER;
        } else {
            i = 1801;
        }
        C0618d.m1300a(i, aRResource.getErrMsg());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1222a(String str) {
        if (!this.f981l) {
            C0618d.m1298a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
            if (!this.f976g) {
                ARLog.m2696e("http error msg = " + str);
                C0618d.m1299a(2301, (Object) this);
                this.f972c = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1223a(JSONObject jSONObject) {
        if (!this.f981l && !this.f976g) {
            ARResource parseARResource = ParserJson.parseARResource(jSONObject);
            if (parseARResource == null) {
                ARLog.m2696e("ARResource parse error!");
                C0618d.m1298a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
            } else if (parseARResource.getErrCode() != 0) {
                m1221a(parseARResource);
                C0618d.m1298a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
            } else if (parseARResource.isRefused() || !parseARResource.isHardwareSatisfied()) {
                C0618d.m1299a((int) MsgField.IMSG_DEVICE_NOT_SUPPORT, (Object) parseARResource);
                C0618d.m1298a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
            } else {
                this.f977h = parseARResource;
                this.f972c = null;
                startDownload();
            }
        }
    }

    /* renamed from: b */
    private void m1225b() {
        this.f973d = new C0608c(this);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                RequestController.this.f973d.onResponse(C0903a.m2659a(ARConfig.getARType()));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1227b(String str) {
        if (!this.f981l) {
            this.f977h.setCaseConfigJsonInfo(str);
            try {
                this.f977h.setResFilePath((String) new JSONObject(str).opt("unzip_path"));
                this.f977h.setZipFilePath(ARFileUtils.getARCaseMainZipFullPath(this.f977h.getKey(), this.f977h.getVersionCode()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!this.f976g) {
                C0618d.m1298a((int) MsgField.MSG_ON_DOWNLOAD_RES_SUCCESS);
                if (this.f980k != null) {
                    this.f980k.mo8858a(this.f977h);
                }
                Log.e("qatest", "查询下载: " + (System.currentTimeMillis() - this.f982m) + " ms");
            }
        }
    }

    /* renamed from: c */
    private void m1228c() {
        this.f974e = new C0606a(this);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                RequestController.this.f974e.onResponse(ArResourceUtils.generateResult(C0903a.m2658a()));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1230c(String str) {
        if (!this.f981l && !this.f976g) {
            Log.e("bdar", "download res error: " + str);
            C0618d.m1299a((int) MsgField.MSG_ON_DOWNLOAD_RES_ERROR, (Object) this);
        }
    }

    public static void setLoadLocalArRes(boolean z) {
        f970a = z;
    }

    public void cancelDownloadTask() {
        if (this.f971b != null) {
            this.f971b.setPause(false);
            this.f971b.cancel(true);
            this.f971b = null;
        }
        if (this.f978i != null) {
            this.f978i.mo10569a();
        }
    }

    public void cancelQueryRes() {
        if (this.f972c != null) {
            this.f972c.finish();
            this.f972c = null;
        }
        if (this.f973d != null) {
            this.f973d.mo9503a();
        }
        if (this.f974e != null) {
            this.f974e.mo9501a();
        }
    }

    public void downloadArResource() {
        if (f970a) {
            m1228c();
        } else if (this.f977h == null) {
            ARLog.m2696e("ERROR!! bundle data is null");
        } else {
            String[] multiResourceUrl = this.f977h.getMultiResourceUrl();
            if (multiResourceUrl != null && multiResourceUrl.length != 0) {
                String str = multiResourceUrl[0];
                if (!TextUtils.isEmpty(str)) {
                    this.f974e = new C0606a(this);
                    ContentResolver contentResolver = null;
                    if (this.f975f != null) {
                        contentResolver = this.f975f.getContentResolver();
                    }
                    String aRCaseMainZipFullPath = ARFileUtils.getARCaseMainZipFullPath(this.f977h.getKey(), this.f977h.getVersionCode());
                    this.f971b = DownLoaderTask.doDownLoadWork(this.f977h.getKey(), aRCaseMainZipFullPath, str, Constants.RE_EXTRACT, contentResolver, this.f974e);
                    C0618d.m1299a((int) MsgField.MSG_ON_DOWNLOAD_RES, (Object) this);
                }
            }
        }
    }

    public void downloadCodeResource() {
        ARResource aRResource = this.f977h;
        if (aRResource == null || this.f978i == null) {
            ARLog.m2696e("ERROR!! bundle data is null");
            return;
        }
        C0618d.m1298a((int) MsgField.MSG_ON_DOWNLOAD_SO);
        String codeDownloadUrl = aRResource.getCodeDownloadUrl();
        this.f978i.mo10570a((C0884e.C0885a) new C0884e.C0885a() {
            /* renamed from: a */
            public void mo8857a(boolean z) {
                if (RequestController.this.f979j != null) {
                    RequestController.this.f979j.mo8857a(z);
                }
                if (z) {
                    RequestController.this.downloadArResource();
                } else if (!RequestController.this.f976g) {
                    C0618d.m1299a((int) MsgField.MSG_ON_DOWNLOAD_SO_ERROR, (Object) RequestController.this);
                    ARLog.m2695d(MsgField.SMSG_SO_DOWNLOAD_ERROR);
                }
            }
        });
        this.f978i.mo10574a(codeDownloadUrl);
    }

    public DownLoaderTask getDownloadTask() {
        return this.f971b;
    }

    public void onPause() {
        this.f976g = true;
        if (this.f971b != null) {
            this.f971b.cancel(true);
        }
    }

    public void onResume() {
        this.f976g = false;
    }

    public void onSoLoadSuccess() {
        C0618d.m1298a((int) MsgField.MSG_STAT_SOLOAD_LOAD_SUCCESS);
    }

    public void onSoloadDownloadFailure() {
        C0618d.m1298a((int) MsgField.MSG_STAT_SOLOAD_DOWNLOAD_FAILURE);
    }

    public void onSoloadDownloadStart() {
        C0618d.m1298a((int) MsgField.MSG_STAT_SOLOAD_START_DOWNLOAD);
    }

    public void onSoloadDownloadSuccess() {
        C0618d.m1298a((int) MsgField.MSG_STAT_SOLOAD_DOWNLOAD_SUCCESS);
    }

    public void onSoloadFialure() {
        C0618d.m1298a((int) MsgField.MSG_STAT_SOLOAD_LOAD_FAILURE);
    }

    public void onSoloadLoadStart() {
        C0618d.m1298a((int) MsgField.MSG_STAT_SOLOAD_START);
    }

    public void release() {
        onPause();
        cancelQueryRes();
        cancelDownloadTask();
        this.f976g = false;
        this.f981l = true;
    }

    public void setARResource(ARResource aRResource) {
        this.f977h = aRResource;
    }

    public void setOnARResourceRequestListener(C0607b bVar) {
        this.f980k = bVar;
    }

    public void setOnSoLoadCallback(C0884e.C0885a aVar) {
        this.f979j = aVar;
    }

    public void start() {
        if (f970a) {
            startRequest();
        } else if (ARConfig.getARType() == 6 || ARConfig.getARType() == 7) {
            ARResource aRResource = new ARResource();
            aRResource.setType(ARConfig.getARType());
            if (this.f980k != null) {
                this.f980k.mo8858a(aRResource);
            }
        } else if (!NetworkUtil.isNetworkConnected(this.f975f)) {
            Log.e("bdar", "No network");
            C0618d.m1299a((int) MsgField.MSG_NO_NETWORK_FOR_START_QUERY_RES, (Object) this);
        } else if (NetworkUtil.isWifiNetworkConnected(this.f975f)) {
            startRequest();
        } else if (NetworkUtil.isMobileNetworkConnected(this.f975f)) {
            C0618d.m1299a((int) MsgField.MSG_MOBILE_NETWORK_FOR_START_QUERY_RES, (Object) this);
        }
    }

    public void startDownload() {
        if (f970a) {
            downloadCodeResource();
            return;
        }
        C0618d.m1298a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_SUCCESS);
        if (NetworkUtil.isNetworkConnected(this.f975f)) {
            downloadCodeResource();
            return;
        }
        Log.e("bdar", "No network");
        C0618d.m1299a((int) MsgField.MSG_NO_NETWORK_FOR_DOWNLOAD_RES, (Object) this);
    }

    public void startRequest() {
        this.f982m = System.currentTimeMillis();
        if (!this.f976g) {
            if (this.f977h == null) {
                m1218a();
            } else if (this.f977h.getResFilePath() != null) {
                m1227b(this.f977h.getResFilePath());
            } else {
                startDownload();
            }
        }
    }
}
