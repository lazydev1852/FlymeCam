package com.meizu.update.p084b;

import android.content.Context;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.update.CdnCheckInfo;
import com.meizu.update.ServerManager;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.CheckListener;
import com.meizu.update.p083a.FileCacheHelper;
import com.meizu.update.p091e.StateManager;
import com.meizu.update.push.UpdatePushManager;
import com.meizu.update.service.NotifyManager;
import com.meizu.update.usage.CommonUsageCollector;
import com.meizu.update.util.GlobalAppUpdateHelper;
import com.meizu.update.util.Loger;
import com.meizu.update.util.Utility;

/* renamed from: com.meizu.update.b.a */
public class BaseChecker {

    /* renamed from: a */
    private Context f16140a;

    /* renamed from: b */
    private CheckListener f16141b;

    /* renamed from: c */
    private long f16142c;

    protected BaseChecker(Context context, CheckListener aVar, long j) {
        if (context == null || aVar == null) {
            throw new IllegalArgumentException("listener and context cant be null");
        }
        this.f16141b = aVar;
        this.f16140a = context;
        this.f16142c = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public UpdateInfo mo24703a(boolean z) {
        CdnCheckInfo b;
        if (z) {
            StateManager.m17775c(1);
        }
        FileCacheHelper.m17537b(this.f16140a);
        NotifyManager.m17883a(this.f16140a);
        boolean i = Utility.m17990i(this.f16140a);
        if (Utility.m17983e()) {
            StateManager.m17775c(2);
            return UpdateInfo.generateNoUpdateInfo();
        } else if (!CheckInterval.m17551a(this.f16140a, this.f16142c)) {
            Loger.m17943d("check interval interrupt");
            return UpdateInfo.generateNoUpdateInfo();
        } else {
            GlobalAppUpdateHelper cVar = new GlobalAppUpdateHelper();
            if (Utility.m17987f() && !z && !cVar.mo24872a(this.f16140a.getPackageName())) {
                Loger.m17943d("Update record doesn't exist!");
                return UpdateInfo.generateNoUpdateInfo();
            } else if (!i) {
                Loger.m17942c("request check no network : " + this.f16140a.getPackageName());
                StateManager.m17775c(2);
                return null;
            } else {
                CommonUsageCollector.m17918a(this.f16140a).mo24859a(this.f16140a.getPackageName(), Utility.m17970b(this.f16140a, this.f16140a.getPackageName()));
                Context context = this.f16140a;
                Loger.m17938a(context, "start check update for :" + this.f16140a.getPackageName());
                if (!z && (b = ServerManager.m17693b(this.f16140a)) != null) {
                    Context context2 = this.f16140a;
                    Loger.m17938a(context2, "check cdn result---> isDelay:" + b.mDelay);
                    if (b.mDelay) {
                        return UpdateInfo.generateNoUpdateInfo();
                    }
                }
                UpdateInfo a = ServerManager.m17683a(this.f16140a);
                if (!z) {
                    CheckInterval.m17552b(this.f16140a);
                }
                if (a != null) {
                    Context context3 = this.f16140a;
                    Loger.m17938a(context3, "check update result :" + a.mExistsUpdate + SystemInfoUtil.COMMA + a.mVersionName);
                    if (!a.mExistsUpdate) {
                        StateManager.m17775c(2);
                        FileCacheHelper.m17529a(this.f16140a);
                    } else {
                        StateManager.m17775c(3);
                        if (UpdatePushManager.m17821c(this.f16140a, a.mVersionName) && !z) {
                            Loger.m17942c("skip version: " + a.mVersionName);
                            a.mExistsUpdate = false;
                        }
                    }
                } else {
                    StateManager.m17775c(2);
                    Loger.m17938a(this.f16140a, "check update return null");
                }
                return a;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24704a() {
        this.f16141b.mo17726a(2, (UpdateInfo) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24705a(UpdateInfo updateInfo) {
        this.f16141b.mo17726a(0, updateInfo);
    }
}
