package com.meizu.share.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.meizu.share.ChooserTargetsFinder;
import com.meizu.share.activity.ChooserContract;
import com.meizu.share.p079b.ChooserTargets;
import com.meizu.share.p079b.DisplayResolveInfo;
import com.meizu.share.utils.Executor;
import java.util.List;

/* renamed from: com.meizu.share.activity.b */
public class SharePresenter implements ChooserContract.C2820a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ChooserContract.C2821b f15725a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ChooserTargetsFinder f15726b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f15727c = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public void mo23973a(List<DisplayResolveInfo> list) {
    }

    public SharePresenter(@NonNull ChooserContract.C2821b bVar, @NonNull ChooserTargetsFinder aVar) {
        this.f15725a = bVar;
        this.f15726b = aVar;
    }

    /* renamed from: a */
    public void mo23971a(Context context, Intent intent, Intent[] intentArr) {
        this.f15725a.mo23954a(this.f15726b.mo23918a(context, intent, intentArr), false, false);
    }

    /* renamed from: a */
    public void mo23972a(Context context, final ChooserTargets aVar) {
        Executor.m17171a().mo24011b(new Runnable() {
            public void run() {
                final ChooserTargets a = SharePresenter.this.f15726b.mo23919a(aVar);
                SharePresenter.this.f15727c.post(new Runnable() {
                    public void run() {
                        SharePresenter.this.f15725a.mo23954a(a, true, true);
                    }
                });
            }
        });
    }
}
