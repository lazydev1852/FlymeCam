package com.meizu.sharewidget.p080a;

import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import java.util.List;

/* renamed from: com.meizu.sharewidget.a.g */
public class ShareWidgetPositionProtect {
    /* renamed from: a */
    public static List<ResolveInfo> m17274a(List<ResolveInfo> list) {
        if (list == null) {
            return null;
        }
        boolean z = true;
        for (int i = 0; i < 2 && z; i++) {
            int i2 = 0;
            while (i2 < list.size()) {
                ResolveInfo resolveInfo = list.get(i2);
                ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
                String str = componentInfo.packageName;
                if (!"com.meizu.share".equals(str) || !componentInfo.name.equals("com.meizu.share.BluetoothOppLauncherActivity")) {
                    if ("com.meizu.filemanager".equals(str) && componentInfo.name.equals("com.meizu.flyme.filemanager.qrcode.ui.QrFilesCheckActivity") && i2 > 8 && resolveInfo != null) {
                        list.remove(resolveInfo);
                        list.add(8, resolveInfo);
                    }
                    i2++;
                } else {
                    if (i2 > 9 && resolveInfo != null) {
                        list.remove(resolveInfo);
                        list.add(9, resolveInfo);
                    }
                    i2++;
                }
                z = true;
            }
            z = false;
        }
        return list;
    }
}
