package com.baidu.p020ar.resloader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.p020ar.bean.ARResource;
import com.baidu.p020ar.load.DownloadTask;
import com.baidu.p020ar.load.FileManageTask;
import com.baidu.p020ar.load.QueryTask;
import com.baidu.p020ar.load.downloader.DownloadManager;
import com.baidu.p020ar.load.downloader.IDownloadParamsParser;
import com.baidu.p020ar.load.util.DownloadConstants;
import com.baidu.p020ar.load.util.ResponseUtil;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.task.HttpTaskUtility;
import com.baidu.p020ar.util.ArResourceUtils;
import com.baidu.p020ar.util.Debug;
import com.baidu.p020ar.util.UrlUtils;

/* renamed from: com.baidu.ar.resloader.a */
public class C0872a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArCaseDownloadListener f2172a;

    /* renamed from: com.baidu.ar.resloader.a$a */
    private static class C0878a implements IDownloadParamsParser {

        /* renamed from: a */
        private ARResource f2186a;

        public C0878a(ARResource aRResource) {
            this.f2186a = aRResource;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
            r7 = r1.optJSONObject(com.baidu.p020ar.parser.ARResourceKey.HTTP_RET);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.baidu.p020ar.load.downloader.IDownloadParamsParser.DownloadParam parser(java.lang.String r7) {
            /*
                r6 = this;
                com.baidu.ar.load.downloader.IDownloadParamsParser$DownloadParam r0 = new com.baidu.ar.load.downloader.IDownloadParamsParser$DownloadParam
                r0.<init>()
                r1 = 100
                r0.mErrorCode = r1
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007d }
                r1.<init>(r7)     // Catch:{ JSONException -> 0x007d }
                java.lang.String r7 = "err_code"
                r2 = -1
                int r7 = r1.optInt(r7, r2)     // Catch:{ JSONException -> 0x007d }
                if (r7 != 0) goto L_0x0081
                java.lang.String r7 = "ret"
                org.json.JSONObject r7 = r1.optJSONObject(r7)     // Catch:{ JSONException -> 0x007d }
                java.lang.String r1 = "ar_resource_urls"
                org.json.JSONArray r1 = r7.optJSONArray(r1)     // Catch:{ JSONException -> 0x007d }
                if (r1 == 0) goto L_0x0081
                int r2 = r1.length()     // Catch:{ JSONException -> 0x007d }
                r3 = 1
                if (r2 < r3) goto L_0x0081
                r2 = 0
                java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x007d }
                boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x007d }
                if (r4 != 0) goto L_0x0081
                java.lang.String r4 = "version_code"
                java.lang.String r7 = r7.optString(r4)     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r4 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                r4.setVersionCode(r7)     // Catch:{ JSONException -> 0x007d }
                r0.mErrorCode = r2     // Catch:{ JSONException -> 0x007d }
                r0.mDownloadUrl = r1     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r7 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                java.lang.String r7 = r7.getKey()     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r4 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                java.lang.String r4 = r4.getVersionCode()     // Catch:{ JSONException -> 0x007d }
                java.lang.String r7 = com.baidu.p020ar.util.ARFileUtils.getARCaseMainZipFullPath(r7, r4)     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r4 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                java.lang.String r4 = r4.getKey()     // Catch:{ JSONException -> 0x007d }
                java.lang.String r4 = com.baidu.p020ar.util.ARFileUtils.getARCaseDirPath(r4)     // Catch:{ JSONException -> 0x007d }
                r0.mDownloadPath = r7     // Catch:{ JSONException -> 0x007d }
                r0.mFileManagePath = r4     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r5 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                r5.setZipFilePath(r7)     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r7 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                r7.setResFilePath(r4)     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r7 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                r7.setResourceUrl(r1)     // Catch:{ JSONException -> 0x007d }
                com.baidu.ar.bean.ARResource r7 = r6.f2186a     // Catch:{ JSONException -> 0x007d }
                java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x007d }
                r3[r2] = r1     // Catch:{ JSONException -> 0x007d }
                r7.setMultiResourceUrl(r3)     // Catch:{ JSONException -> 0x007d }
                return r0
            L_0x007d:
                r7 = move-exception
                r7.printStackTrace()
            L_0x0081:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.resloader.C0872a.C0878a.parser(java.lang.String):com.baidu.ar.load.downloader.IDownloadParamsParser$DownloadParam");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r2 = r0.optJSONObject(com.baidu.p020ar.parser.ARResourceKey.HTTP_RET).optJSONArray(com.baidu.p020ar.parser.ARResourceKey.HTTP_AR_MULTI_RESOURCE);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2533b(java.lang.String r2) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0024 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r2 = "err_code"
            r1 = -1
            int r2 = r0.optInt(r2, r1)     // Catch:{ Exception -> 0x0024 }
            if (r2 != 0) goto L_0x0028
            java.lang.String r2 = "ret"
            org.json.JSONObject r2 = r0.optJSONObject(r2)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r0 = "ar_resource_urls"
            org.json.JSONArray r2 = r2.optJSONArray(r0)     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x0028
            int r2 = r2.length()     // Catch:{ Exception -> 0x0024 }
            r0 = 1
            if (r2 < r0) goto L_0x0028
            return r0
        L_0x0024:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0028:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.resloader.C0872a.m2533b(java.lang.String):boolean");
    }

    /* renamed from: a */
    public void mo10558a(Context context, ARResource aRResource) {
        final ARResource aRResource2 = aRResource;
        final String key = aRResource.getKey();
        aRResource2.setDownloadStatus(0);
        Bundle bundle = new Bundle();
        bundle.putString(DownloadConstants.QUERY_URL, UrlUtils.getQueryResourceUrl());
        bundle.putInt(DownloadConstants.QUERY_REQUEST_MODE, 1);
        final Context context2 = context;
        C08731 r5 = new QueryTask.ExtraOperateListener() {
            public String excuteChangeResult(String str) {
                return HttpTaskUtility.getHttpParamsForCaseSwitch(context2, key);
            }
        };
        C0878a aVar = new C0878a(aRResource2);
        C08742 r13 = new ActionResponseListener<String>() {
            /* renamed from: a */
            public void onResponse(String str) {
                int idFromResponse = ResponseUtil.getIdFromResponse(str);
                Debug.print("Query:arkey:" + aRResource2.getKey() + ", onResponse id:" + idFromResponse);
                if (idFromResponse != 0) {
                    aRResource2.setDownloadStatus(-3);
                    if (C0872a.this.f2172a == null) {
                        return;
                    }
                } else if (!C0872a.m2533b(ResponseUtil.getHttpResultFromResponse(str))) {
                    aRResource2.setDownloadStatus(-3);
                    if (C0872a.this.f2172a == null) {
                        return;
                    }
                } else {
                    return;
                }
                C0872a.this.f2172a.onFinish(key, false, (String) null);
            }

            public void onErrorResponse(String str) {
                Debug.print("Query:arkey:" + aRResource2.getKey() + ", errorMsg:" + str);
            }

            public void onProgress(int i) {
                Debug.print("Query:arkey:" + aRResource2.getKey() + ", progress:" + i);
            }

            public void onUpdate(boolean z, float f) {
            }
        };
        C08753 r14 = new ActionResponseListener<String>() {
            /* renamed from: a */
            public void onResponse(String str) {
                int idFromResponse = ResponseUtil.getIdFromResponse(str);
                Debug.print("Download:arkey:" + aRResource2.getKey() + ", response id:" + idFromResponse);
                if (idFromResponse != 0) {
                    aRResource2.setDownloadStatus(-3);
                    if (C0872a.this.f2172a != null) {
                        C0872a.this.f2172a.onFinish(key, false, (String) null);
                    }
                }
            }

            public void onErrorResponse(String str) {
            }

            public void onProgress(int i) {
                Debug.print("Download:arkey:" + aRResource2.getKey() + ", progress:" + i);
                int i2 = i / 2;
                aRResource2.setDownloadStatus(i2);
                if (C0872a.this.f2172a != null) {
                    C0872a.this.f2172a.onProgress(key, i2);
                }
            }

            public void onUpdate(boolean z, float f) {
            }
        };
        C08764 r15 = new ActionResponseListener<String>() {
            /* renamed from: a */
            public void onResponse(String str) {
                int idFromResponse = ResponseUtil.getIdFromResponse(str);
                Debug.print("Unzip:arkey:" + aRResource2.getKey() + ", response id:" + idFromResponse);
                boolean z = idFromResponse == 0;
                aRResource2.setDownloadStatus(z ? -2 : -3);
                if (C0872a.this.f2172a != null) {
                    C0872a.this.f2172a.onFinish(key, z, ResponseUtil.getMsgFromResponse(str));
                }
            }

            public void onErrorResponse(String str) {
            }

            public void onProgress(int i) {
                Debug.print("Unzip:arkey:" + aRResource2.getKey() + ", progress:" + i);
                int i2 = (i / 2) + 50;
                aRResource2.setDownloadStatus(i2);
                if (C0872a.this.f2172a != null) {
                    C0872a.this.f2172a.onProgress(key, i2);
                }
            }

            public void onUpdate(boolean z, float f) {
            }
        };
        DownloadManager.getInstance().downloadRes(key, (String) null, bundle, r5, aVar, (String) null, DownloadTask.FileStoreStrategy.SKIP, (String) null, true, FileManageTask.FileMergeStrategy.SKIP, new FileManageTask.ExtraOperateListener() {
            public String excuteChangeResult(String str) {
                return ArResourceUtils.generateResult(str);
            }
        }, r13, r14, r15);
    }

    /* renamed from: a */
    public void mo10559a(ARResource aRResource) {
        if (aRResource == null) {
            Log.e("cancelDownload", "arResource can't null");
        } else {
            DownloadManager.getInstance().cancel(aRResource.getKey(), aRResource.getAcId());
        }
    }

    /* renamed from: a */
    public void mo10560a(ArCaseDownloadListener arCaseDownloadListener) {
        this.f2172a = arCaseDownloadListener;
    }
}
