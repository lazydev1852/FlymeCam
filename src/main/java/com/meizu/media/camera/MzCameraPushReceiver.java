package com.meizu.media.camera;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.update.PlatformImpl;
import com.meizu.update.component.MzUpdatePlatform;
import com.meizu.update.push.PushReceiver;

public class MzCameraPushReceiver extends PushReceiver {

    /* renamed from: a */
    public static ChangeQuickRedirect f7073a;

    public void onMessage(Context context, String str) {
        Class[] clsArr = {Context.class, String.class};
        if (!PatchProxy.proxy(new Object[]{context, str}, this, f7073a, false, 1653, clsArr, Void.TYPE).isSupported) {
            MzUpdatePlatform.m17667a(context, str);
        }
    }

    public void onMessage(Context context, Intent intent) {
        Class[] clsArr = {Context.class, Intent.class};
        if (!PatchProxy.proxy(new Object[]{context, intent}, this, f7073a, false, 1654, clsArr, Void.TYPE).isSupported) {
            MzUpdatePlatform.m17666a(context, intent);
        }
    }

    public void onRegister(Context context, String str) {
        Class[] clsArr = {Context.class, String.class};
        if (!PatchProxy.proxy(new Object[]{context, str}, this, f7073a, false, 1655, clsArr, Void.TYPE).isSupported && !TextUtils.isEmpty(str)) {
            PlatformImpl.m17563a(context);
        }
    }

    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        Class[] clsArr = {Context.class, RegisterStatus.class};
        if (!PatchProxy.proxy(new Object[]{context, registerStatus}, this, f7073a, false, 1656, clsArr, Void.TYPE).isSupported && !TextUtils.isEmpty(registerStatus.getPushId())) {
            PlatformImpl.m17563a(context);
        }
    }
}
