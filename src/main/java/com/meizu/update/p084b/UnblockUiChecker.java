package com.meizu.update.p084b;

import android.content.Context;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.CheckListener;

/* renamed from: com.meizu.update.b.d */
public class UnblockUiChecker {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BaseChecker f16143a;

    public UnblockUiChecker(Context context, CheckListener aVar, long j) {
        this.f16143a = new BaseChecker(context, aVar, j);
    }

    /* renamed from: a */
    public void mo24706a(final boolean z) {
        new Thread(new Runnable() {
            public void run() {
                UpdateInfo a = UnblockUiChecker.this.f16143a.mo24703a(z);
                if (a != null) {
                    UnblockUiChecker.this.f16143a.mo24705a(a);
                } else {
                    UnblockUiChecker.this.f16143a.mo24704a();
                }
            }
        }).start();
    }
}
