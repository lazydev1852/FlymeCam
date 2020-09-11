package com.meizu.update.display;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.R;
import com.meizu.update.display.DisplayBase;
import com.meizu.update.iresponse.MzUpdateResponse;
import com.meizu.update.push.UpdatePushManager;
import com.meizu.update.service.MzUpdateComponentService;
import com.meizu.update.usage.UpdateUsageCollector;
import com.meizu.update.util.Utility;

/* renamed from: com.meizu.update.display.e */
public class UdResultDisplayManager extends DisplayBase {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f16271e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f16272f = false;

    public UdResultDisplayManager(Context context, UpdateInfo updateInfo, String str, boolean z) {
        super(context, updateInfo);
        this.f16271e = str;
        mo24763a(z);
    }

    /* renamed from: b */
    public void mo24791b(boolean z) {
        this.f16272f = z;
    }

    /* renamed from: a */
    public DisplayBase.DisplayInfo mo24760a() {
        String format = TextUtils.isEmpty(mo24767d()) ? String.format(this.f16219a.getString(R.string.mzuc_found_update_s), new Object[]{this.f16220b.mVersionName}) : mo24767d();
        String e = TextUtils.isEmpty(mo24768e()) ? this.f16220b.mVersionDesc : mo24768e();
        String string = this.f16219a.getString(R.string.mzuc_install_immediately);
        String string2 = this.f16219a.getResources().getString(R.string.mzuc_install_later);
        UpdateUsageCollector.m17913a(this.f16219a).mo24855a(UpdateUsageCollector.UpdateAction.UpdateDisplay_Alert_Silent, this.f16220b.mVersionName);
        return new DisplayBase.DisplayInfo(format, (String) null, e, string, string2, (String) null, new DisplayBase.DisplayInfo.SelectedListener() {
            /* renamed from: a */
            public void mo24777a(DisplayBase.DisplayInfo.SelectedListener.SelectedCode selectedCode) {
                switch (C30142.f16274a[selectedCode.ordinal()]) {
                    case 1:
                        UpdateUsageCollector.m17913a(UdResultDisplayManager.this.f16219a).mo24856a(UpdateUsageCollector.UpdateAction.Install_Yes, UdResultDisplayManager.this.f16220b.mVersionName, Utility.m17970b(UdResultDisplayManager.this.f16219a, UdResultDisplayManager.this.f16219a.getPackageName()));
                        MzUpdateComponentService.m17838a(UdResultDisplayManager.this.f16219a, UdResultDisplayManager.this.f16220b, UdResultDisplayManager.this.f16271e, (MzUpdateResponse) null);
                        return;
                    case 2:
                        UpdateUsageCollector.m17913a(UdResultDisplayManager.this.f16219a).mo24856a(UpdateUsageCollector.UpdateAction.Install_No, UdResultDisplayManager.this.f16220b.mVersionName, Utility.m17970b(UdResultDisplayManager.this.f16219a, UdResultDisplayManager.this.f16219a.getPackageName()));
                        if (!UdResultDisplayManager.this.f16272f) {
                            UpdatePushManager.m17825f(UdResultDisplayManager.this.f16219a, UdResultDisplayManager.this.f16220b.mVersionName);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* renamed from: com.meizu.update.display.e$2 */
    /* compiled from: UdResultDisplayManager */
    static /* synthetic */ class C30142 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16274a = new int[DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode[] r0 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16274a = r0
                int[] r0 = f16274a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f16274a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.display.UdResultDisplayManager.C30142.<clinit>():void");
        }
    }
}
