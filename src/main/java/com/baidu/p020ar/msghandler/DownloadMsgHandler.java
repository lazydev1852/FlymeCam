package com.baidu.p020ar.msghandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.base.C0618d;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.bean.C0625c;
import com.baidu.p020ar.load.downloader.IDownloadParamsParser;
import com.baidu.p020ar.parser.ARResourceKey;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.NetworkUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.msghandler.DownloadMsgHandler */
public class DownloadMsgHandler {
    public static final int LOAD_STATUS_DOWNLOAD_ANSWER = 3021;
    public static final int LOAD_STATUS_DOWNLOAD_RETRY_SHOWDIALOG = 3010;
    public static final String SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_IF_DOWNLOAD = "if_download";
    public static final String SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_RES_PATH = "download_batchid";

    /* renamed from: a */
    String f1862a;

    /* renamed from: b */
    C0625c f1863b;

    /* renamed from: c */
    private Context f1864c;

    /* renamed from: d */
    private String f1865d;

    /* renamed from: com.baidu.ar.msghandler.DownloadMsgHandler$a */
    private static class C0798a implements ActionResponseListener<String> {

        /* renamed from: a */
        String f1866a;

        /* renamed from: b */
        boolean f1867b;

        /* renamed from: c */
        int f1868c = 70;

        /* renamed from: d */
        int f1869d = -1;

        C0798a(String str, boolean z, String str2) {
            this.f1866a = str;
            this.f1867b = z;
            if (str2.equalsIgnoreCase("gzip")) {
                this.f1868c = 70;
            } else {
                this.f1868c = 90;
            }
        }

        /* renamed from: a */
        public void onResponse(String str) {
            try {
                if (new JSONObject(str).getInt("id") != 0) {
                    DownloadMsgHandler.responseEngineDownload(this.f1866a, -1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.f1866a, -1);
            }
        }

        public void onErrorResponse(String str) {
        }

        public void onProgress(int i) {
            if (this.f1867b) {
                int i2 = (int) ((((float) (i * this.f1868c)) * 1.0f) / 100.0f);
                if (i2 > this.f1869d) {
                    DownloadMsgHandler.responseEngineDownloadProgress(this.f1866a, i2);
                }
                this.f1869d = i2;
            }
        }

        public void onUpdate(boolean z, float f) {
        }
    }

    /* renamed from: com.baidu.ar.msghandler.DownloadMsgHandler$b */
    private static class C0799b implements IDownloadParamsParser {

        /* renamed from: a */
        String f1870a;

        public C0799b(String str) {
            this.f1870a = str;
        }

        public IDownloadParamsParser.DownloadParam parser(String str) {
            IDownloadParamsParser.DownloadParam downloadParam = new IDownloadParamsParser.DownloadParam();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errorNum", -1) == 0) {
                    String optString = jSONObject.optString("data");
                    if (!TextUtils.isEmpty(optString)) {
                        downloadParam.mErrorCode = 0;
                        downloadParam.mDownloadUrl = optString;
                        return downloadParam;
                    }
                }
                downloadParam.mErrorCode = 100;
            } catch (Exception e) {
                e.printStackTrace();
                downloadParam.mErrorCode = 100;
            }
            return downloadParam;
        }
    }

    /* renamed from: com.baidu.ar.msghandler.DownloadMsgHandler$c */
    private static class C0800c implements ActionResponseListener<String> {

        /* renamed from: a */
        String f1871a;

        /* renamed from: b */
        boolean f1872b;

        /* renamed from: c */
        int f1873c = 30;

        /* renamed from: d */
        int f1874d = -1;

        C0800c(String str, boolean z, String str2) {
            this.f1871a = str;
            this.f1872b = z;
            if (str2.equalsIgnoreCase("gzip")) {
                this.f1873c = 30;
            } else {
                this.f1873c = 10;
            }
        }

        /* renamed from: a */
        public void onResponse(String str) {
            try {
                if (new JSONObject(str).getInt("id") == 0) {
                    DownloadMsgHandler.responseEngineDownload(this.f1871a, 0);
                } else {
                    DownloadMsgHandler.responseEngineDownload(this.f1871a, -1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.f1871a, -1);
            }
        }

        public void onErrorResponse(String str) {
        }

        public void onProgress(int i) {
            if (this.f1872b) {
                int i2 = (100 - this.f1873c) + ((int) ((((float) (i * this.f1873c)) * 1.0f) / 100.0f));
                if (i2 > this.f1874d) {
                    DownloadMsgHandler.responseEngineDownloadProgress(this.f1871a, i2);
                }
                this.f1874d = i2;
            }
        }

        public void onUpdate(boolean z, float f) {
        }
    }

    /* renamed from: com.baidu.ar.msghandler.DownloadMsgHandler$d */
    private static class C0801d implements ActionResponseListener<String> {

        /* renamed from: a */
        String f1875a;

        /* renamed from: b */
        IDownloadParamsParser f1876b;

        C0801d(String str, IDownloadParamsParser iDownloadParamsParser) {
            this.f1875a = str;
            this.f1876b = iDownloadParamsParser;
        }

        /* renamed from: a */
        public void onResponse(String str) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("id") == 0) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("httpResult"));
                    if (jSONObject2.optInt("errorNum", -1) != 0) {
                        str2 = this.f1875a;
                    } else if (this.f1876b.parser(jSONObject2.toString()).mErrorCode != 0) {
                        str2 = this.f1875a;
                    } else {
                        return;
                    }
                } else {
                    str2 = this.f1875a;
                }
                DownloadMsgHandler.responseEngineDownload(str2, -1);
            } catch (Exception e) {
                e.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.f1875a, -1);
            }
        }

        public void onErrorResponse(String str) {
        }

        public void onProgress(int i) {
        }

        public void onUpdate(boolean z, float f) {
        }
    }

    public DownloadMsgHandler(String str, Context context) {
        this.f1862a = str;
        this.f1864c = (Context) new WeakReference(context).get();
    }

    public static void responseEngineDownload(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put(ARResourceKey.HTTP_RET, Integer.valueOf(i));
        ARLog.m2696e("bdar:responseEngineDownload requestId:" + str + " result:" + i);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_RES_RESPONE, hashMap);
    }

    public static void responseEngineDownloadProgress(String str, int i) {
        ARLog.m2696e("bdar:DownloadMsgHandler:responseEngineDownloadProgress progress = " + i);
        HashMap hashMap = new HashMap();
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(5002, hashMap);
    }

    public void cancelDownloadBatch() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(LOAD_STATUS_DOWNLOAD_ANSWER));
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_IF_DOWNLOAD, 0);
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_RES_PATH, getResPath());
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public String getResPath() {
        return this.f1865d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleDownloadMsg(java.util.HashMap<java.lang.String, java.lang.Object> r24) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            java.lang.String r2 = "res_path"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "request_id"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "need_progress"
            java.lang.Object r0 = r0.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L_0x0026
            r0 = 0
            goto L_0x0027
        L_0x0026:
            r0 = 1
        L_0x0027:
            com.baidu.ar.bean.c r6 = r1.f1863b
            r7 = -1
            if (r6 != 0) goto L_0x0030
            responseEngineDownload(r3, r7)
            return
        L_0x0030:
            com.baidu.ar.bean.c r6 = r1.f1863b
            java.lang.String r8 = r2.toLowerCase()
            com.baidu.ar.bean.c$a r6 = r6.mo9701a((java.lang.String) r8)
            if (r6 != 0) goto L_0x0040
            responseEngineDownload(r3, r7)
            return
        L_0x0040:
            java.lang.String r10 = r6.mo9705b()
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 == 0) goto L_0x004e
            responseEngineDownload(r3, r7)
            return
        L_0x004e:
            java.lang.String r8 = "local"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x005a
            responseEngineDownload(r3, r5)
            return
        L_0x005a:
            java.lang.String r5 = r6.mo9707c()
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            if (r8 == 0) goto L_0x0068
            responseEngineDownload(r3, r7)
            return
        L_0x0068:
            java.lang.String r8 = ""
            r9 = 0
            java.lang.String r11 = "gzip"
            boolean r11 = r5.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x007e
            java.lang.String r8 = ".zip"
            java.lang.String r2 = r1.f1862a
            java.lang.String r2 = com.baidu.p020ar.util.ARFileUtils.getARCaseDirPath(r2)
        L_0x007b:
            r16 = r2
            goto L_0x00a8
        L_0x007e:
            java.lang.String r11 = "identity"
            boolean r11 = r5.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00a6
            java.lang.String r8 = "."
            int r8 = r2.lastIndexOf(r8)
            java.lang.String r8 = r2.substring(r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = r1.f1862a
            java.lang.String r11 = com.baidu.p020ar.util.ARFileUtils.getARCaseFullPath(r11)
            r9.append(r11)
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            goto L_0x007b
        L_0x00a6:
            r16 = r9
        L_0x00a8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r9 = r1.f1862a
            java.lang.String r9 = com.baidu.p020ar.util.ARFileUtils.getARCaseTempDir(r9)
            r2.append(r9)
            java.lang.String r9 = java.io.File.separator
            r2.append(r9)
            java.lang.String r9 = r6.mo9705b()
            r2.append(r9)
            r2.append(r8)
            java.lang.String r14 = r2.toString()
            com.baidu.ar.msghandler.DownloadMsgHandler$b r13 = new com.baidu.ar.msghandler.DownloadMsgHandler$b
            r13.<init>(r10)
            com.baidu.ar.msghandler.DownloadMsgHandler$d r2 = new com.baidu.ar.msghandler.DownloadMsgHandler$d
            r2.<init>(r3, r13)
            com.baidu.ar.msghandler.DownloadMsgHandler$a r15 = new com.baidu.ar.msghandler.DownloadMsgHandler$a
            r15.<init>(r3, r0, r5)
            com.baidu.ar.msghandler.DownloadMsgHandler$c r12 = new com.baidu.ar.msghandler.DownloadMsgHandler$c
            r12.<init>(r3, r0, r5)
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            java.lang.String r0 = "query_url"
            java.lang.String r5 = com.baidu.p020ar.util.UrlUtils.getStepLoadingBatchUrl()
            java.lang.String r8 = "?id="
            java.lang.String r5 = r5.concat(r8)
            java.lang.String r8 = r6.mo9705b()
            java.lang.String r5 = r5.concat(r8)
            r11.putString(r0, r5)
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            android.content.Context r0 = r1.f1864c     // Catch:{ JSONException -> 0x0104 }
            com.baidu.p020ar.task.HttpTaskUtility.addBasicInfo((android.content.Context) r0, (org.json.JSONObject) r5)     // Catch:{ JSONException -> 0x0104 }
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0108:
            java.lang.String r0 = "query_params"
            java.lang.String r5 = r5.toString()
            r11.putString(r0, r5)
            java.lang.String r0 = "query_request_mode"
            r11.putInt(r0, r4)
            java.lang.String r0 = "cuid"
            java.lang.String r4 = com.baidu.p020ar.bean.ARConfig.getCUID()
            r11.putString(r0, r4)
            java.lang.String r0 = r6.mo9703a()
            r1.f1865d = r0
            boolean r0 = r23.isNetworkConnect()
            if (r0 != 0) goto L_0x012f
            responseEngineDownload(r3, r7)
            return
        L_0x012f:
            com.baidu.ar.load.downloader.DownloadManager r8 = com.baidu.p020ar.load.downloader.DownloadManager.getInstance()
            java.lang.String r9 = r1.f1862a
            r0 = 0
            com.baidu.ar.load.DownloadTask$FileStoreStrategy r3 = com.baidu.p020ar.load.DownloadTask.FileStoreStrategy.SKIP
            r17 = 0
            com.baidu.ar.load.FileManageTask$FileMergeStrategy r18 = com.baidu.p020ar.load.FileManageTask.FileMergeStrategy.SKIP
            r19 = 0
            r4 = r12
            r12 = r0
            r5 = r15
            r15 = r3
            r20 = r2
            r21 = r5
            r22 = r4
            r8.downloadRes(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.msghandler.DownloadMsgHandler.handleDownloadMsg(java.util.HashMap):void");
    }

    public boolean isNetworkConnect() {
        if (this.f1864c != null) {
            return NetworkUtil.isNetworkConnected(this.f1864c);
        }
        return false;
    }

    public void onDownloadError() {
        C0618d.m1299a((int) MsgField.MSG_ON_LOAD_BATCH_RETRY, (Object) this);
    }

    public void parseAndExcuteDownloadMsg(HashMap<String, Object> hashMap) {
        handleDownloadMsg(hashMap);
    }

    public void release() {
        this.f1864c = null;
    }

    public void retryDownloadBatch() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(LOAD_STATUS_DOWNLOAD_ANSWER));
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_IF_DOWNLOAD, 1);
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_RES_PATH, getResPath());
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public void setResConfigs(C0625c cVar) {
        this.f1863b = cVar;
    }
}
