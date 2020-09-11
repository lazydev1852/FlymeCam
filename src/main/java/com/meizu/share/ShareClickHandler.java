package com.meizu.share;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

/* renamed from: com.meizu.share.h */
public class ShareClickHandler implements OnTargetClickHandler {
    /* renamed from: a */
    public void mo24002a(Activity activity, Intent intent, ResolveInfo resolveInfo, List<ResolveInfo> list, boolean z) {
        if (activity != null && !activity.isFinishing()) {
            activity.startActivity(intent);
        }
    }
}
