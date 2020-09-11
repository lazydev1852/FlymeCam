package com.meizu.share;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import com.meizu.share.p079b.DisplayResolveInfo;
import com.meizu.sharewidget.p080a.C2866d;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.meizu.share.d */
public class LogUtils {

    /* renamed from: a */
    private static boolean f15741a = false;

    /* renamed from: a */
    public static void m17125a() {
        try {
            f15741a = ((Boolean) C2866d.m17252a("android.os.SystemProperties").mo24065a("getBoolean", String.class, Boolean.TYPE).mo24067a((Object) null, "sdk.debug.chooser", false)).booleanValue();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m17128a(String str) {
        Log.d("ChooserActivity", str);
    }

    /* renamed from: b */
    public static void m17130b(String str) {
        Log.e("ChooserActivity", str);
    }

    /* renamed from: a */
    public static void m17126a(Intent intent) {
        m17127a(intent, "");
    }

    /* renamed from: a */
    public static void m17127a(Intent intent, String str) {
        Log.d("ChooserActivity", str + "------------------------------------");
        Log.d("ChooserActivity", str + intent.toString());
        Bundle extras = intent.getExtras();
        if (f15741a && extras != null && extras.keySet() != null) {
            Log.d("ChooserActivity", str + "Extras:");
            for (String str2 : extras.keySet()) {
                if (extras.get(str2) instanceof Intent) {
                    Log.d("ChooserActivity", str + str2 + "=");
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("        ");
                    m17127a((Intent) extras.get(str2), sb.toString());
                } else if (extras.get(str2) == null || !extras.get(str2).getClass().isArray()) {
                    Log.d("ChooserActivity", str + str2 + "=" + extras.get(str2));
                } else {
                    Log.d("ChooserActivity", str + str2 + "=" + Arrays.deepToString((Object[]) extras.get(str2)));
                }
            }
        }
    }

    /* renamed from: a */
    public static void m17129a(String str, List<ResolveInfo> list) {
        Log.d("ChooserActivity", "------------------------------------");
        Log.d("ChooserActivity", str + ", size=" + list.size());
        if (f15741a) {
            for (int i = 0; i < list.size(); i++) {
                Log.d("ChooserActivity", String.format("%-3d %s", new Object[]{Integer.valueOf(i), list.get(i).toString()}));
            }
        }
    }

    /* renamed from: b */
    public static void m17131b(String str, List<DisplayResolveInfo> list) {
        Log.d("ChooserActivity", "------------------------------------");
        Log.d("ChooserActivity", str + ", size=" + list.size());
        if (f15741a) {
            for (int i = 0; i < list.size(); i++) {
                Log.d("ChooserActivity", String.format("%-3d %s", new Object[]{Integer.valueOf(i), list.get(i).toString()}));
            }
        }
    }
}
