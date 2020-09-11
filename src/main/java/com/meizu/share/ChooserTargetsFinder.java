package com.meizu.share;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.meizu.share.p079b.ChooserTargets;

/* renamed from: com.meizu.share.a */
public interface ChooserTargetsFinder {
    /* renamed from: a */
    ChooserTargets mo23918a(Context context, Intent intent, Intent[] intentArr);

    @WorkerThread
    /* renamed from: a */
    ChooserTargets mo23919a(ChooserTargets aVar);
}
