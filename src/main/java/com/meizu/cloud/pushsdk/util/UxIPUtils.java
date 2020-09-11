package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.p020ar.constants.HttpConstants;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.impl.model.PlatformMessage;
import com.meizu.cloud.pushsdk.handler.impl.model.Statics;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.pushtracer.QuickTracker;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import com.meizu.cloud.pushsdk.pushtracer.emitter.RequestCallback;
import com.meizu.cloud.pushsdk.pushtracer.event.PushEvent;
import com.meizu.cloud.pushsdk.pushtracer.utils.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class UxIPUtils {
    private static final String TAG = "UxIPUtils";

    public static void init(Context context) {
    }

    public static void notificationEvent(Context context, String str, int i, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            onRecordMessageFlow(context, context.getPackageName(), str3, str2, PushManager.TAG, str, i);
        }
    }

    public static void notificationEvent(Context context, Intent intent, String str, int i) {
        notificationEvent(context, intent, PushManager.TAG, str, i);
    }

    public static void notificationEvent(Context context, Intent intent, String str, String str2, int i) {
        if (!TextUtils.isEmpty(getTaskId(intent))) {
            onRecordMessageFlow(context, context.getPackageName(), intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), getTaskId(intent), str, str2, i);
        }
    }

    public static String getTaskId(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        try {
            MPushMessage mPushMessage = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            if (mPushMessage != null) {
                return mPushMessage.getTaskId();
            }
            return stringExtra;
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "paese MessageV2 error " + e.getMessage());
            return "no push platform task";
        }
    }

    public static void onRecordMessageFlow(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Statics.TASK_ID, str3);
        hashMap.put("deviceId", str2);
        hashMap.put(HttpConstants.TIMESTAMP, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("package_name", str);
        hashMap.put("pushsdk_version", str4);
        hashMap.put("push_info", str5);
        hashMap.put("push_info_type", String.valueOf(i));
        onLogEvent(context, false, "notification_service_message", hashMap);
    }

    public static void onShowPushMessageEvent(Context context, String str, String str2) {
        PlatformMessage buildPlatformMessage = buildPlatformMessage(str2);
        onShowPushMessageEvent(context, str, buildPlatformMessage.getDeviceId(), buildPlatformMessage.getTaskId(), buildPlatformMessage.getSeqId(), buildPlatformMessage.getPushTimesTamp());
    }

    public static PlatformMessage buildPlatformMessage(String str) {
        PlatformMessage platformMessage = new PlatformMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = null;
                String string = jSONObject.has("task_id") ? jSONObject.getString("task_id") : null;
                String string2 = jSONObject.has(PlatformMessage.PLATFORM_SEQ_ID) ? jSONObject.getString(PlatformMessage.PLATFORM_SEQ_ID) : null;
                String string3 = jSONObject.has(PlatformMessage.PLATFORM_PUSH_TIMESTAMP) ? jSONObject.getString(PlatformMessage.PLATFORM_PUSH_TIMESTAMP) : null;
                if (jSONObject.has("device_id")) {
                    str2 = jSONObject.getString("device_id");
                }
                return PlatformMessage.builder().taskId(string).deviceId(str2).pushTimesTamp(string3).seqId(string2).build();
            } catch (Exception unused) {
                DebugLogger.m4828e(TAG, "the platformExtra parse error");
            }
        } else {
            DebugLogger.m4828e(TAG, "the platformExtra is empty");
            return platformMessage;
        }
    }

    public static void onShowPushMessageEvent(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, true, str, str2, str3, str4, Parameters.SHOW_PUSH_MESSAGE, str5);
    }

    public static void onDeletePushMessageEvent(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, true, str, str2, str3, str4, Parameters.DELETE_PUSH_MESSAGE, str5);
    }

    public static void onReceivePushMessageEvent(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, false, str, str2, str3, str4, Parameters.RECEIVE_PUSH_EVNET, str5);
    }

    public static void onReceiveThroughMessage(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, true, str, str2, str3, str4, Parameters.RECEIVE_PUSH_EVNET, str5);
    }

    public static void onClickPushMessageEvent(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, true, str, str2, str3, str4, Parameters.CLICK_PUSH_MESSAGE, str5);
    }

    public static void onInvalidPushMessage(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, true, str, str2, str3, str4, Parameters.INVALID_PUSH_MESSAGE, str5);
    }

    public static void onShowInBoxPushMessage(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, false, str, str2, str3, str4, Parameters.SHOWINBOX_PUSH_MESSAGE, str5);
    }

    public static void onNoShowPushMessage(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, false, str, str2, str3, str4, Parameters.NOSHOW_PUSH_MESSAGE, str5);
    }

    public static void onReceiveServerMessage(Context context, String str, String str2, String str3, String str4, String str5) {
        onLogEvent(context, false, str, str2, str3, str4, Parameters.RECEIVER_SERVER_MESSAGE, str5);
    }

    public static void onLogEvent(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put(Parameters.EVENT_NAME, str5);
        hashMap.put(Parameters.TASK_ID, str3);
        hashMap.put("di", str2);
        if (TextUtils.isEmpty(str6)) {
            str6 = String.valueOf(System.currentTimeMillis() / 1000);
        }
        hashMap.put("ts", str6);
        hashMap.put(Parameters.PACKAGE_NAME, str);
        hashMap.put(Parameters.PUSH_SDK_VERSION, PushManager.TAG);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(Parameters.SEQ_ID, str4);
        }
        if (!remotePushTracker(context, hashMap)) {
            onLogEvent(context, z, str5, hashMap);
        }
    }

    public static void onLogEvent(Context context, boolean z, String str, Map<String, String> map) {
        DebugLogger.m4828e(TAG, "onLogEvent eventName [" + str + "] properties = " + map);
        if (!"notification_service_message".equals(str)) {
            QuickTracker.getAndroidTrackerClassic(context, (RequestCallback) null).track(((PushEvent.Builder) PushEvent.builder().eventName(str).timestamp(Long.valueOf(map.get("ts")).longValue())).eventCreateTime(String.valueOf(System.currentTimeMillis() / 1000)).deviceId(map.get("di")).packageName(map.get(Parameters.PACKAGE_NAME)).pushsdkVersion(map.get(Parameters.PUSH_SDK_VERSION)).taskId(map.get(Parameters.TASK_ID)).seqId(TextUtils.isEmpty(map.get(Parameters.SEQ_ID)) ? "" : map.get(Parameters.SEQ_ID)).messageSeq(String.valueOf(PushPreferencesUtils.getMessageSeqInCrease(context, map.get(Parameters.PACKAGE_NAME)))).build(), z);
        }
    }

    private static boolean remotePushTracker(Context context, Map<String, String> map) {
        String str;
        String str2;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION), 0);
        String str3 = null;
        if (queryIntentServices != null) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                }
                ResolveInfo next = it.next();
                if ("com.meizu.cloud".equals(next.serviceInfo.packageName)) {
                    str2 = next.serviceInfo.packageName;
                    str3 = next.serviceInfo.name;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str3) || queryIntentServices.size() <= 0) {
                str = str3;
                str3 = str2;
            } else {
                str3 = queryIntentServices.get(0).serviceInfo.packageName;
                str = queryIntentServices.get(0).serviceInfo.name;
            }
        } else {
            str = null;
        }
        DebugLogger.m4829i(TAG, "current process packageName " + str3);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String jSONObject = Util.mapToJSONObject(map).toString();
            Intent intent = new Intent();
            intent.setPackage(str3);
            intent.setAction(PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION);
            intent.putExtra(PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA, jSONObject);
            context.startService(intent);
            DebugLogger.m4829i(TAG, "Start tracker data in mz_tracker process " + jSONObject);
            return true;
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "start RemoteService error " + e.getMessage());
            return false;
        }
    }
}
