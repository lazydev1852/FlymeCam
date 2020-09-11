package com.meizu.update.p090d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.meizu.update.UpdateInfo;
import com.meizu.update.service.MzUpdateComponentService;

/* renamed from: com.meizu.update.d.a */
public class AppRestartManager {
    /* renamed from: a */
    public static void m17699a(Context context, UpdateInfo updateInfo) {
        try {
            PendingIntent f = MzUpdateComponentService.m17873f(context, updateInfo);
            Intent intent = new Intent("com.meizu.appupdate.intent.wakeup");
            intent.putExtra("PendingIntent", f);
            intent.setPackage("com.meizu.cloud");
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static Intent m17698a(Context context) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        } catch (Exception unused) {
            return null;
        }
    }
}
