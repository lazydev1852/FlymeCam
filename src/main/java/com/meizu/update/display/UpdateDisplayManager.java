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
import com.meizu.update.iresponse.IMzUpdateResponse;
import com.meizu.update.iresponse.MzUpdateResponse;
import com.meizu.update.push.UpdatePushManager;
import com.meizu.update.service.MzUpdateComponentService;
import com.meizu.update.usage.UpdateUsageCollector;
import com.meizu.update.util.Utility;
import com.meizu.update.util.WidgetHelper;

/* renamed from: com.meizu.update.display.f */
public class UpdateDisplayManager extends DisplayBase {

    /* renamed from: e */
    private UpdateEndListener f16275e;

    /* renamed from: f */
    private Handler f16276f;

    /* renamed from: g */
    private ProgressDialog f16277g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f16278h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f16279i;

    /* renamed from: j */
    private IMzUpdateResponse f16280j = new IMzUpdateResponse.C3024a() {
        /* renamed from: a */
        public void mo24784a(int i, Bundle bundle) throws RemoteException {
        }

        /* renamed from: b */
        public void mo24785b(final int i, final Bundle bundle) throws RemoteException {
            UpdateDisplayManager.this.m17756a((Runnable) new Runnable() {
                public void run() {
                    UpdateDisplayManager.this.m17752a(i, bundle);
                }
            });
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17752a(int i, Bundle bundle) {
        m17762m();
        if (this.f16278h) {
            mo24783h();
            return;
        }
        switch (i) {
            case 0:
                new InstallDisplayManager(this.f16219a, this.f16275e, this.f16220b, bundle.getString("apk_path")).mo24783h();
                return;
            case 1:
                mo24783h();
                return;
            case 2:
                m17759j();
                return;
            default:
                return;
        }
    }

    public UpdateDisplayManager(Context context, UpdateEndListener eVar, UpdateInfo updateInfo, boolean z) {
        super(context, updateInfo);
        mo24763a(z);
        this.f16275e = eVar;
        if (this.f16275e != null) {
            this.f16276f = new Handler(context.getMainLooper());
            this.f16277g = WidgetHelper.m18007a(context);
            this.f16277g.setMessage(context.getString(R.string.mzuc_downloading));
            this.f16277g.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    boolean unused = UpdateDisplayManager.this.f16278h = true;
                    UpdateUsageCollector.m17913a(UpdateDisplayManager.this.f16219a).mo24855a(UpdateUsageCollector.UpdateAction.Download_Del, UpdateDisplayManager.this.f16220b.mVersionName);
                    UpdateDisplayManager.this.m17760k();
                }
            });
        }
    }

    /* renamed from: b */
    public void mo24792b(boolean z) {
        this.f16279i = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo24783h() {
        if (this.f16275e != null) {
            this.f16275e.mo24755a(1, this.f16220b);
        }
    }

    /* renamed from: j */
    private void m17759j() {
        if (this.f16275e != null) {
            this.f16275e.mo24755a(2, this.f16220b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo24793i() {
        MzUpdateResponse mzUpdateResponse = this.f16275e != null ? new MzUpdateResponse(this.f16280j) : null;
        m17761l();
        MzUpdateComponentService.m17836a(this.f16219a, this.f16220b, mzUpdateResponse);
    }

    /* renamed from: a */
    public DisplayBase.DisplayInfo mo24760a() {
        String format = TextUtils.isEmpty(mo24767d()) ? String.format(this.f16219a.getString(R.string.mzuc_found_update_s), new Object[]{this.f16220b.mVersionName}) : mo24767d();
        String e = TextUtils.isEmpty(mo24768e()) ? this.f16220b.mVersionDesc : mo24768e();
        String string = Utility.m17991j(this.f16219a) ? this.f16219a.getResources().getString(R.string.mzuc_update_immediately) : String.format(this.f16219a.getResources().getString(R.string.mzuc_update_immediately_roaming), new Object[]{this.f16220b.mSize});
        String string2 = this.f16219a.getResources().getString(R.string.mzuc_update_later);
        UpdateUsageCollector.m17913a(this.f16219a).mo24857a(UpdateUsageCollector.UpdateAction.UpdateDisplay_Alert, this.f16220b.mVersionName, Utility.m17970b(this.f16219a, this.f16219a.getPackageName()), this.f16279i);
        return new DisplayBase.DisplayInfo(format, (String) null, e, string, string2, (String) null, new DisplayBase.DisplayInfo.SelectedListener() {
            /* renamed from: a */
            public void mo24777a(DisplayBase.DisplayInfo.SelectedListener.SelectedCode selectedCode) {
                switch (C30194.f16287a[selectedCode.ordinal()]) {
                    case 1:
                        UpdateUsageCollector.m17913a(UpdateDisplayManager.this.f16219a).mo24857a(UpdateUsageCollector.UpdateAction.UpdateAlert_Yes, UpdateDisplayManager.this.f16220b.mVersionName, Utility.m17970b(UpdateDisplayManager.this.f16219a, UpdateDisplayManager.this.f16219a.getPackageName()), UpdateDisplayManager.this.f16279i);
                        UpdateDisplayManager.this.mo24793i();
                        return;
                    case 2:
                        UpdateUsageCollector.m17913a(UpdateDisplayManager.this.f16219a).mo24857a(UpdateUsageCollector.UpdateAction.UpdateAlert_No, UpdateDisplayManager.this.f16220b.mVersionName, Utility.m17970b(UpdateDisplayManager.this.f16219a, UpdateDisplayManager.this.f16219a.getPackageName()), UpdateDisplayManager.this.f16279i);
                        if (!UpdateDisplayManager.this.f16279i) {
                            UpdatePushManager.m17825f(UpdateDisplayManager.this.f16219a, UpdateDisplayManager.this.f16220b.mVersionName);
                        }
                        UpdateDisplayManager.this.mo24783h();
                        return;
                    case 3:
                        UpdateUsageCollector.m17913a(UpdateDisplayManager.this.f16219a).mo24857a(UpdateUsageCollector.UpdateAction.UpdateAlert_No, UpdateDisplayManager.this.f16220b.mVersionName, Utility.m17970b(UpdateDisplayManager.this.f16219a, UpdateDisplayManager.this.f16219a.getPackageName()), UpdateDisplayManager.this.f16279i);
                        UpdateDisplayManager.this.mo24783h();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* renamed from: com.meizu.update.display.f$4 */
    /* compiled from: UpdateDisplayManager */
    static /* synthetic */ class C30194 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16287a = new int[DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode[] r0 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16287a = r0
                int[] r0 = f16287a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f16287a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f16287a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.meizu.update.display.DisplayBase$DisplayInfo$SelectedListener$SelectedCode r1 = com.meizu.update.display.DisplayBase.DisplayInfo.SelectedListener.SelectedCode.CANCELED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.display.UpdateDisplayManager.C30194.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17756a(Runnable runnable) {
        this.f16276f.post(runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m17760k() {
        MzUpdateComponentService.m17863c(this.f16219a);
    }

    /* renamed from: l */
    private void m17761l() {
        if (this.f16277g != null) {
            this.f16277g.show();
        }
    }

    /* renamed from: m */
    private void m17762m() {
        try {
            if (this.f16277g != null && this.f16277g.isShowing()) {
                this.f16277g.dismiss();
            }
        } catch (Exception unused) {
        }
    }
}
