package com.meizu.update.display;

import android.content.Context;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.R;
import com.meizu.update.display.DisplayBase;
import com.meizu.update.service.MzUpdateComponentService;
import com.meizu.update.service.NotifyManager;
import com.meizu.update.usage.UpdateUsageCollector;

/* renamed from: com.meizu.update.display.a */
public class DownloadingDisplayManager extends DisplayBase {
    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo24770g() {
        return false;
    }

    public DownloadingDisplayManager(Context context, UpdateInfo updateInfo) {
        super(context, updateInfo);
    }

    /* renamed from: a */
    public DisplayBase.DisplayInfo mo24760a() {
        String string = this.f16219a.getString(R.string.mzuc_downloading);
        return new DisplayBase.DisplayInfo(string, (String) null, NotifyManager.m17888b(this.f16220b, this.f16219a) + " , " + this.f16220b.mSize, this.f16219a.getResources().getString(R.string.mzuc_delete), this.f16219a.getResources().getString(R.string.mzuc_cancel), (String) null, new DisplayBase.DisplayInfo.SelectedListener() {
            /* renamed from: a */
            public void mo24777a(DisplayBase.DisplayInfo.SelectedListener.SelectedCode selectedCode) {
                switch (C30022.f16250a[selectedCode.ordinal()]) {
                    case 1:
                        UpdateUsageCollector.m17913a(DownloadingDisplayManager.this.f16219a).mo24855a(UpdateUsageCollector.UpdateAction.Download_Del, DownloadingDisplayManager.this.f16220b.mVersionName);
                        DownloadingDisplayManager.this.m17720h();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* renamed from: com.meizu.update.display.a$2 */
    /* compiled from: DownloadingDisplayManager */
    static /* synthetic */ class C30022 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16250a = new int[DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode[] r0 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16250a = r0
                int[] r0 = f16250a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f16250a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f16250a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.CANCELED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.display.DownloadingDisplayManager.C30022.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m17720h() {
        MzUpdateComponentService.m17863c(this.f16219a);
    }
}
