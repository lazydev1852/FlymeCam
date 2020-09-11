package com.meizu.share;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

/* renamed from: com.meizu.share.j */
public class ShareIntentModifier implements IntentModifier {
    /* renamed from: a */
    public Intent mo23976a(Intent intent) {
        return intent;
    }

    /* renamed from: a */
    public Intent mo23977a(Intent intent, ResolveInfo resolveInfo) {
        intent.setFlags(intent.getFlags() & -8388609);
        intent.addFlags(1);
        intent.addFlags(16777216);
        intent.addFlags(33554432);
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
            intent.addFlags(134742016);
        }
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
        return intent;
    }
}
