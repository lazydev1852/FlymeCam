package com.baidu.p020ar.util;

import android.content.Context;
import com.baidu.p020ar.task.HttpTaskUtility;

/* renamed from: com.baidu.ar.util.DeviceSupportAbility */
public final class DeviceSupportAbility {
    public static String getBlacklistParams(Context context, String str) {
        return HttpTaskUtility.getHttpParamsForMM(context);
    }
}
