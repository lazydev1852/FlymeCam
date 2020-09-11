package com.meizu.share.activity;

import android.content.Context;
import android.content.Intent;
import com.meizu.share.p079b.ChooserTargets;
import com.meizu.share.p079b.DisplayResolveInfo;
import java.util.List;

/* renamed from: com.meizu.share.activity.a */
public class ChooserContract {

    /* renamed from: com.meizu.share.activity.a$a */
    /* compiled from: ChooserContract */
    interface C2820a {
        /* renamed from: a */
        void mo23971a(Context context, Intent intent, Intent[] intentArr);

        /* renamed from: a */
        void mo23972a(Context context, ChooserTargets aVar);

        /* renamed from: a */
        void mo23973a(List<DisplayResolveInfo> list);
    }

    /* renamed from: com.meizu.share.activity.a$b */
    /* compiled from: ChooserContract */
    interface C2821b {
        /* renamed from: a */
        void mo23954a(ChooserTargets aVar, boolean z, boolean z2);
    }
}
