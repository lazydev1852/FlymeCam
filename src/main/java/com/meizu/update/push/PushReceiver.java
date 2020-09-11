package com.meizu.update.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.update.PlatformImpl;
import com.meizu.update.component.MzUpdatePlatform;
import com.meizu.update.util.Loger;

public class PushReceiver extends MzPushMessageReceiver {
    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
    }

    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
    }

    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
    }

    public void onMessage(Context context, String str) {
        MzUpdatePlatform.m17667a(context, str);
    }

    public void onMessage(Context context, Intent intent) {
        MzUpdatePlatform.m17666a(context, intent);
    }

    public void onRegister(Context context, String str) {
        Loger.m17942c("onRegister : " + str);
        if (!TextUtils.isEmpty(str)) {
            PlatformImpl.m17563a(context);
        }
    }

    public void onUnRegister(Context context, boolean z) {
        Loger.m17943d("onUnRegister");
    }

    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
        Loger.m17942c("onPushStatus");
    }

    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        if (!TextUtils.isEmpty(registerStatus.getPushId())) {
            PlatformImpl.m17563a(context);
        }
    }
}
