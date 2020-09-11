package com.meizu.update.display;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.R;
import com.meizu.update.component.UpdateEndListener;
import com.meizu.update.display.DisplayBase;
import com.meizu.update.install.InstallHelper;
import com.meizu.update.iresponse.IMzUpdateResponse;
import com.meizu.update.iresponse.MzUpdateResponse;
import com.meizu.update.service.MzUpdateComponentService;
import com.meizu.update.usage.UpdateUsageCollector;
import com.meizu.update.util.Utility;
import com.meizu.update.util.WidgetHelper;

/* renamed from: com.meizu.update.display.c */
public class InstallDisplayManager extends DisplayBase {

    /* renamed from: e */
    private String f16254e;

    /* renamed from: f */
    private Handler f16255f;

    /* renamed from: g */
    private UpdateEndListener f16256g;

    /* renamed from: h */
    private ProgressDialog f16257h;

    /* renamed from: i */
    private IMzUpdateResponse f16258i = new IMzUpdateResponse.C3024a() {
        /* renamed from: b */
        public void mo24785b(int i, Bundle bundle) throws RemoteException {
        }

        /* renamed from: a */
        public void mo24784a(final int i, Bundle bundle) throws RemoteException {
            InstallDisplayManager.this.m17735a((Runnable) new Runnable() {
                public void run() {
                    InstallDisplayManager.this.m17731a(i);
                }
            });
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo24770g() {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17731a(int i) {
        m17739l();
        switch (i) {
            case 1:
                m17736i();
                return;
            case 2:
                m17737j();
                return;
            case 3:
                m17740m();
                return;
            default:
                return;
        }
    }

    public InstallDisplayManager(Context context, UpdateEndListener eVar, UpdateInfo updateInfo, String str) {
        super(context, updateInfo);
        if (!TextUtils.isEmpty(str)) {
            this.f16256g = eVar;
            this.f16254e = str;
            if (this.f16256g != null) {
                this.f16255f = new Handler(context.getMainLooper());
                this.f16257h = WidgetHelper.m18007a(context);
                this.f16257h.setMessage(context.getString(R.string.mzuc_installing));
                this.f16257h.setCancelable(false);
                this.f16257h.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalArgumentException("params cant be null!");
    }

    /* renamed from: a */
    public DisplayBase.DisplayInfo mo24760a() {
        String format = TextUtils.isEmpty(mo24767d()) ? String.format(this.f16219a.getString(R.string.mzuc_download_finish_s), new Object[]{Utility.m17989h(this.f16219a), this.f16220b.mVersionName}) : mo24767d();
        String e = TextUtils.isEmpty(mo24768e()) ? null : mo24768e();
        String string = this.f16219a.getString(R.string.mzuc_install_immediately);
        String string2 = this.f16219a.getString(R.string.mzuc_install_later);
        UpdateUsageCollector.m17913a(this.f16219a).mo24855a(UpdateUsageCollector.UpdateAction.Download_Done, this.f16220b.mVersionName);
        return new DisplayBase.DisplayInfo(format, (String) null, e, string, string2, (String) null, new DisplayBase.DisplayInfo.SelectedListener() {
            /* renamed from: a */
            public void mo24777a(DisplayBase.DisplayInfo.SelectedListener.SelectedCode selectedCode) {
                switch (C30125.f16267a[selectedCode.ordinal()]) {
                    case 1:
                        UpdateUsageCollector.m17913a(InstallDisplayManager.this.f16219a).mo24855a(UpdateUsageCollector.UpdateAction.Install_Yes, InstallDisplayManager.this.f16220b.mVersionName);
                        InstallDisplayManager.this.mo24783h();
                        return;
                    case 2:
                        UpdateUsageCollector.m17913a(InstallDisplayManager.this.f16219a).mo24855a(UpdateUsageCollector.UpdateAction.Install_No, InstallDisplayManager.this.f16220b.mVersionName);
                        InstallDisplayManager.this.m17736i();
                        return;
                    case 3:
                        UpdateUsageCollector.m17913a(InstallDisplayManager.this.f16219a).mo24855a(UpdateUsageCollector.UpdateAction.Install_No, InstallDisplayManager.this.f16220b.mVersionName);
                        InstallDisplayManager.this.m17736i();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* renamed from: com.meizu.update.display.c$5 */
    /* compiled from: InstallDisplayManager */
    static /* synthetic */ class C30125 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16267a = new int[DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode[] r0 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16267a = r0
                int[] r0 = f16267a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f16267a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f16267a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.CANCELED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.display.InstallDisplayManager.C30125.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m17736i() {
        if (this.f16256g != null) {
            this.f16256g.mo24755a(1, this.f16220b);
        }
    }

    /* renamed from: j */
    private void m17737j() {
        if (this.f16256g != null) {
            this.f16256g.mo24755a(3, this.f16220b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo24783h() {
        m17738k();
        MzUpdateComponentService.m17838a(this.f16219a, this.f16220b, this.f16254e, this.f16256g != null ? new MzUpdateResponse(this.f16258i) : null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17735a(Runnable runnable) {
        this.f16255f.post(runnable);
    }

    /* renamed from: k */
    private void m17738k() {
        try {
            if (this.f16257h != null) {
                this.f16257h.show();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: l */
    private void m17739l() {
        try {
            if (this.f16257h != null && this.f16257h.isShowing()) {
                this.f16257h.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: m */
    private void m17740m() {
        InstallHelper.m17782a(this.f16219a, this.f16254e, this.f16220b);
        this.f16255f.postDelayed(new Runnable() {
            public void run() {
                WidgetHelper.m18005a(InstallDisplayManager.this.f16219a, InstallDisplayManager.this.f16219a.getString(R.string.mzuc_install_cancel_tip), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InstallDisplayManager.this.m17736i();
                    }
                }, new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        InstallDisplayManager.this.m17736i();
                    }
                });
            }
        }, 1000);
    }
}
