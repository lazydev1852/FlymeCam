package com.meizu.cloud.pushsdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.base.reflect.ReflectClass;
import com.meizu.cloud.pushsdk.base.reflect.ReflectResult;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.impl.model.ControlMessage;
import com.meizu.cloud.pushsdk.pushtracer.QuickTracker;
import com.meizu.cloud.pushsdk.util.UxIPUtils;
import java.util.List;

public class NotificationService extends IntentService {
    private static final String TAG = "NotificationService";
    private Object newInstance;

    public NotificationService(String str) {
        super(str);
    }

    public NotificationService() {
        super(TAG);
    }

    public void onDestroy() {
        DebugLogger.m4829i(TAG, "NotificationService destroy");
        this.newInstance = null;
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Process.setThreadPriority(10);
        if (intent != null) {
            try {
                DebugLogger.m4829i(TAG, "onHandleIntentaction " + intent.getAction());
                String stringExtra = intent.getStringExtra("command_type");
                DebugLogger.m4827d(TAG, "-- command_type -- " + stringExtra);
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
                    String stringExtra2 = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
                    DebugLogger.m4829i(TAG, "control message is " + stringExtra2);
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        QuickTracker.init(this, new ControlMessage(stringExtra2, (String) null, (String) null).getStatics().getPushExtra());
                    }
                    reflectReceiver(intent);
                }
            } catch (Exception e) {
                DebugLogger.m4828e(TAG, "onHandleIntent error " + e.getMessage());
            }
        }
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public String getReceiver(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        return queryBroadcastReceivers.get(0).activityInfo.name;
    }

    public void reflectReceiver(Intent intent) {
        String receiver = getReceiver(getPackageName(), intent.getAction());
        if (TextUtils.isEmpty(receiver)) {
            UxIPUtils.notificationEvent(this, intent, "reflectReceiver sendbroadcast", 2005);
            DebugLogger.m4829i(TAG, " reflectReceiver error: receiver for: " + intent.getAction() + " not found, package: " + getPackageName());
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            return;
        }
        try {
            UxIPUtils.notificationEvent(this, intent, "reflectReceiver startservice", PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE);
            intent.setClassName(getPackageName(), receiver);
            ReflectResult newInstance2 = ReflectClass.forName(receiver).constructor((Class<?>[]) null).newInstance((Object[]) null);
            if (newInstance2.f4119ok && newInstance2.value != null) {
                DebugLogger.m4829i(TAG, "Reflect MzPushReceiver " + newInstance2.f4119ok);
                ReflectClass.forObject(newInstance2.value).method("onReceive", Context.class, Intent.class).invoke(newInstance2.value, getApplicationContext(), intent);
            }
        } catch (Exception e) {
            DebugLogger.m4829i(TAG, "reflect e: " + e);
            UxIPUtils.notificationEvent(this, intent, e.getMessage(), PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_ERROR);
        }
    }
}
