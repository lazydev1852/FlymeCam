package com.meizu.cloud.pushsdk.platform;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.impl.model.PlatformMessage;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.UxIPUtils;
import java.util.Iterator;
import java.util.List;

public class PlatformMessageSender {
    public static final String TAG = "PlatformMessageSender";

    private interface OnUpdateIntent {
        BasicPushStatus getBasicStatus();

        String getBasicStatusExtra();

        String getMethod();
    }

    public static void sendPushStatus(Context context, String str, final PushSwitchStatus pushSwitchStatus) {
        sendPlatformStatus(context, str, new OnUpdateIntent() {
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS;
            }

            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS;
            }

            public BasicPushStatus getBasicStatus() {
                return pushSwitchStatus;
            }
        });
    }

    public static void sendRegisterStatus(Context context, String str, final RegisterStatus registerStatus) {
        sendPlatformStatus(context, str, new OnUpdateIntent() {
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS;
            }

            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS;
            }

            public BasicPushStatus getBasicStatus() {
                return registerStatus;
            }
        });
    }

    public static void sendUnRegisterStatus(Context context, String str, final UnRegisterStatus unRegisterStatus) {
        sendPlatformStatus(context, str, new OnUpdateIntent() {
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS;
            }

            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS;
            }

            public BasicPushStatus getBasicStatus() {
                return unRegisterStatus;
            }
        });
    }

    public static void sendSubTags(Context context, String str, final SubTagsStatus subTagsStatus) {
        sendPlatformStatus(context, str, new OnUpdateIntent() {
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS;
            }

            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS;
            }

            public BasicPushStatus getBasicStatus() {
                return subTagsStatus;
            }
        });
    }

    public static void sendSubAlias(Context context, String str, final SubAliasStatus subAliasStatus) {
        sendPlatformStatus(context, str, new OnUpdateIntent() {
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS;
            }

            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS;
            }

            public BasicPushStatus getBasicStatus() {
                return subAliasStatus;
            }
        });
    }

    private static void sendPlatformStatus(Context context, String str, OnUpdateIntent onUpdateIntent) {
        Intent intent = new Intent();
        intent.addCategory(str);
        intent.setPackage(str);
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, onUpdateIntent.getMethod());
        intent.putExtra(onUpdateIntent.getBasicStatusExtra(), onUpdateIntent.getBasicStatus());
        MzSystemUtils.sendMessageFromBroadcast(context, intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, str);
        MzSystemUtils.sendMessageFromBroadcast(context, new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START"), (String) null, str);
    }

    public static void switchPushMessageSetting(Context context, int i, boolean z, String str) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        DebugLogger.m4829i(TAG, context.getPackageName() + " switchPushMessageSetting cloudVersion_name " + appVersionName);
        if (!TextUtils.isEmpty(appVersionName) && appVersionName.startsWith("6")) {
            Intent intent = new Intent(PushConstants.MZ_PUSH_ON_MESSAGE_SWITCH_SETTING);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_TYPE, i);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_STATUS, z);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_PACKAGE_NAME, str);
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            context.startService(intent);
        }
    }

    public static void launchStartActivity(Context context, String str, String str2, String str3) {
        PlatformMessage buildPlatformMessage = UxIPUtils.buildPlatformMessage(str3);
        MessageV3 parse = MessageV3.parse(str, str, buildPlatformMessage.getPushTimesTamp(), buildPlatformMessage.getDeviceId(), buildPlatformMessage.getTaskId(), buildPlatformMessage.getSeqId(), str2);
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, parse);
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
            intent.setClassName(str, "com.meizu.cloud.pushsdk.NotificationService");
        }
        intent.putExtra("command_type", "reflect_receiver");
        DebugLogger.m4829i(TAG, "start notification service " + parse);
        try {
            context.startService(intent);
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "launchStartActivity error " + e.getMessage());
        }
    }

    public static void changePreference(Context context, String str, String str2, String str3) {
        try {
            Intent intent = new Intent();
            intent.setPackage(findService(context, PushConstants.MZ_PUSH_ON_MESSAGE_CHANGE_PREFERENCE));
            intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_CHANGE_PREFERENCE);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_PREFERENCE_NAME, str);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_PREFERENCE_KEY, str2);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_PREFERENCE_VALUE, str3);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_PREFERENCE_VALUE_TYPE, 0);
            context.startService(intent);
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "start RemoteService error " + e.getMessage());
        }
    }

    protected static String findService(Context context, String str) {
        List<ResolveInfo> queryIntentServices;
        String str2;
        String str3 = null;
        if (!TextUtils.isEmpty(str) && (queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(str), 0)) != null) {
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
            str3 = (!TextUtils.isEmpty(str3) || queryIntentServices.size() <= 0) ? str2 : queryIntentServices.get(0).serviceInfo.packageName;
        }
        DebugLogger.m4829i(TAG, "current process packageName " + str3);
        return str3;
    }
}
