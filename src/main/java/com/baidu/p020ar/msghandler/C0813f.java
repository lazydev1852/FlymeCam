package com.baidu.p020ar.msghandler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.load.QueryTask;
import com.baidu.p020ar.load.downloader.DownloadManager;
import com.baidu.p020ar.load.util.DownloadConstants;
import com.baidu.p020ar.load.util.ResponseUtil;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.NetworkUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.baidu.ar.msghandler.f */
public class C0813f {

    /* renamed from: a */
    private String f1899a;

    /* renamed from: b */
    private Context f1900b;

    /* renamed from: com.baidu.ar.msghandler.f$a */
    private static class C0814a implements ActionResponseListener<String> {

        /* renamed from: a */
        String f1901a;

        C0814a(String str) {
            this.f1901a = str;
        }

        /* renamed from: a */
        public void onResponse(String str) {
            if (TextUtils.isEmpty(str)) {
                C0813f.m2134a(this.f1901a, "{}");
                return;
            }
            if (ResponseUtil.getIdFromResponse(str) == 0) {
                String httpResultFromResponse = ResponseUtil.getHttpResultFromResponse(str);
                if (!TextUtils.isEmpty(httpResultFromResponse)) {
                    C0813f.m2134a(this.f1901a, httpResultFromResponse);
                    return;
                }
            }
            C0813f.m2134a(this.f1901a, "{}");
        }

        public void onErrorResponse(String str) {
        }

        public void onProgress(int i) {
        }

        public void onUpdate(boolean z, float f) {
        }
    }

    public C0813f(String str, Context context) {
        this.f1899a = str;
        this.f1900b = (Context) new WeakReference(context).get();
    }

    /* renamed from: a */
    public static void m2133a(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(MsgField.MSG_STAT_FIRST_LOAD_FILE_MANAGE_FAILURE));
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* renamed from: a */
    public static void m2134a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(MsgField.MSG_STAT_START_DOWNLOAD_3D_RES));
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put("data", str2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* renamed from: a */
    public void mo10289a() {
        this.f1900b = null;
    }

    /* renamed from: a */
    public void mo10290a(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get(StatisticConstants.REQUEST_ID);
        if (TextUtils.isEmpty(str)) {
            ARLog.m2696e("requestId can not be null!");
            return;
        }
        String str2 = (String) hashMap.get("request_method");
        String str3 = (String) hashMap.get("url");
        String str4 = (String) hashMap.get(PushConstants.CONTENT);
        int i = 1;
        if (!mo10291b()) {
            m2133a(str, 1);
        } else if (str3 == null || !str3.contains("https://")) {
            m2133a(str, 2);
        } else if (str2 == null) {
            m2133a(str, 2);
        } else {
            if (str2.equals("get") || str2.equals("GET")) {
                i = 0;
            } else if (!str2.equals("post") && !str2.equals("POST")) {
                m2133a(str, 2);
                return;
            }
            C0814a aVar = new C0814a(str);
            Bundle bundle = new Bundle();
            bundle.putString(DownloadConstants.QUERY_URL, str3);
            bundle.putString(DownloadConstants.QUERY_PARAMS, str4);
            bundle.putInt(DownloadConstants.QUERY_REQUEST_MODE, i);
            DownloadManager.getInstance().doQuery(this.f1899a, str, bundle, (QueryTask.ExtraOperateListener) null, aVar);
        }
    }

    /* renamed from: b */
    public boolean mo10291b() {
        if (this.f1900b != null) {
            return NetworkUtil.isNetworkConnected(this.f1900b);
        }
        return false;
    }
}
