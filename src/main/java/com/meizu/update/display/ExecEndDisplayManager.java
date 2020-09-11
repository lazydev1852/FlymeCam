package com.meizu.update.display;

import android.content.Context;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.R;
import com.meizu.update.display.DisplayBase;
import com.meizu.update.iresponse.MzUpdateResponse;
import com.meizu.update.service.MzUpdateComponentService;
import com.meizu.update.service.NotifyManager;

/* renamed from: com.meizu.update.display.b */
public class ExecEndDisplayManager extends DisplayBase {

    /* renamed from: e */
    private boolean f16251e;

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m17726h() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo24770g() {
        return false;
    }

    public ExecEndDisplayManager(Context context, UpdateInfo updateInfo, boolean z) {
        super(context, updateInfo);
        this.f16251e = z;
    }

    /* renamed from: a */
    public DisplayBase.DisplayInfo mo24760a() {
        String string;
        String string2;
        String b = NotifyManager.m17888b(this.f16220b, this.f16219a);
        if (this.f16251e) {
            string = this.f16219a.getString(R.string.mzuc_download_fail);
            string2 = this.f16219a.getResources().getString(R.string.mzuc_cancel_download);
        } else {
            string = this.f16219a.getString(R.string.mzuc_install_fail);
            string2 = this.f16219a.getResources().getString(R.string.mzuc_cancel_install);
        }
        return new DisplayBase.DisplayInfo(b, (String) null, string, this.f16219a.getResources().getString(R.string.mzuc_retry), string2, (String) null, new DisplayBase.DisplayInfo.SelectedListener() {
            /* renamed from: a */
            public void mo24777a(DisplayBase.DisplayInfo.SelectedListener.SelectedCode selectedCode) {
                switch (C30042.f16253a[selectedCode.ordinal()]) {
                    case 1:
                        ExecEndDisplayManager.this.m17727i();
                        return;
                    case 2:
                        ExecEndDisplayManager.this.m17726h();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* renamed from: com.meizu.update.display.b$2 */
    /* compiled from: ExecEndDisplayManager */
    static /* synthetic */ class C30042 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16253a = new int[DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode[] r0 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16253a = r0
                int[] r0 = f16253a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f16253a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f16253a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.CANCELED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.display.ExecEndDisplayManager.C30042.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m17727i() {
        MzUpdateComponentService.m17836a(this.f16219a, this.f16220b, (MzUpdateResponse) null);
    }
}
