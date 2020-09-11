package com.meizu.update;

import android.content.Context;
import android.content.Intent;
import com.meizu.update.component.CheckListener;
import com.meizu.update.component.UpdateEndListener;
import com.meizu.update.display.DisplayBase;
import com.meizu.update.display.UdResultDisplayManager;
import com.meizu.update.display.UpdateDisplayManager;
import com.meizu.update.iresponse.MzUpdateResponse;
import com.meizu.update.p083a.FileCacheHelper;
import com.meizu.update.p084b.RoamingManager;
import com.meizu.update.p084b.UnblockUiChecker;
import com.meizu.update.p091e.StateManager;
import com.meizu.update.push.UpdatePushManager;
import com.meizu.update.service.MzUpdateComponentService;
import com.meizu.update.util.Loger;
import com.meizu.update.util.UpdateProcessMutexHelper;
import com.meizu.update.util.Utility;

/* renamed from: com.meizu.update.c */
public class PlatformImpl {
    /* renamed from: a */
    public static final void m17564a(Context context, CheckListener aVar, long j, boolean z) {
        new UnblockUiChecker(context, aVar, j).mo24706a(z);
        m17568b(context);
    }

    /* renamed from: a */
    public static final UcDisplayDialog m17561a(Context context, UpdateEndListener eVar, UpdateInfo updateInfo, boolean z, boolean z2) {
        return m17562a(context, eVar, updateInfo, z, z2, (String) null, (String) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.meizu.update.display.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.meizu.update.display.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.meizu.update.display.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.meizu.update.display.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.meizu.update.UcDisplayDialog m17562a(android.content.Context r3, com.meizu.update.component.UpdateEndListener r4, com.meizu.update.UpdateInfo r5, boolean r6, boolean r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0045
            boolean r1 = r5.mExistsUpdate
            if (r1 != 0) goto L_0x0008
            goto L_0x0045
        L_0x0008:
            boolean r1 = com.meizu.update.util.UpdateProcessMutexHelper.m17952a()
            if (r1 == 0) goto L_0x0014
            java.lang.String r3 = "request display while update in process, skip!"
            com.meizu.update.util.Loger.m17943d(r3)
            return r0
        L_0x0014:
            java.lang.String r0 = r5.mVersionName
            java.lang.String r0 = com.meizu.update.p083a.FileCacheHelper.m17533b((android.content.Context) r3, (java.lang.String) r0)
            boolean r1 = com.meizu.update.util.Utility.m17977c(r3, r0)
            r2 = 0
            if (r1 == 0) goto L_0x002e
            r4 = 5
            com.meizu.update.p091e.StateManager.m17775c(r4)
            com.meizu.update.display.e r4 = new com.meizu.update.display.e
            r4.<init>(r3, r5, r0, r2)
            r4.mo24791b((boolean) r7)
            goto L_0x0037
        L_0x002e:
            com.meizu.update.display.f r0 = new com.meizu.update.display.f
            r0.<init>(r3, r4, r5, r2)
            r0.mo24792b((boolean) r7)
            r4 = r0
        L_0x0037:
            r4.mo24763a((boolean) r6)
            r4.mo24762a((java.lang.String) r8)
            r4.mo24765b(r9)
            com.meizu.update.e r3 = r4.mo24764b()
            return r3
        L_0x0045:
            java.lang.String r3 = "request display while no update!"
            com.meizu.update.util.Loger.m17943d(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.PlatformImpl.m17562a(android.content.Context, com.meizu.update.component.e, com.meizu.update.UpdateInfo, boolean, boolean, java.lang.String, java.lang.String):com.meizu.update.e");
    }

    /* renamed from: a */
    public static final boolean m17567a(Context context, String str) {
        if (!UpdatePushManager.m17816a(context, str)) {
            return false;
        }
        MzUpdateComponentService.m17834a(context);
        return true;
    }

    /* renamed from: a */
    public static final boolean m17566a(Context context, Intent intent) {
        if (!UpdatePushManager.m17815a(context, intent)) {
            return false;
        }
        MzUpdateComponentService.m17834a(context);
        return true;
    }

    /* renamed from: a */
    public static final void m17563a(Context context) {
        UpdatePushManager.m17813a(context);
    }

    /* renamed from: b */
    public static final void m17568b(Context context) {
        UpdatePushManager.m17818b(context, false);
    }

    /* renamed from: a */
    public static final void m17565a(Context context, UpdateEndListener eVar, UpdateInfo updateInfo, boolean z, String str, String str2) {
        if (context == null) {
            throw new NullPointerException("context can't be null!");
        } else if (updateInfo == null || !updateInfo.mExistsUpdate) {
            Loger.m17943d("request display while no update!");
        } else if (!Utility.m17967a(context, updateInfo)) {
            MzUpdateComponentService.m17868d(context);
        } else if (UpdateProcessMutexHelper.m17952a()) {
            Loger.m17943d("request display while update in process, skip!");
        } else {
            String b = FileCacheHelper.m17533b(context, updateInfo.mVersionName);
            DisplayBase displayBase = null;
            if (Utility.m17977c(context, b)) {
                StateManager.m17775c(5);
                Loger.m17943d("Apk file exists!");
                displayBase = new UdResultDisplayManager(context, updateInfo, b, false);
            } else if (!Utility.m17991j(context) || Utility.m17994m(context) <= 15) {
                Loger.m17943d("Condition of silent downloading is not satisfied: isWifiActive : " + Utility.m17991j(context) + " Current Battery percentage :" + Utility.m17994m(context));
                RoamingManager.m17557c(context);
                if (RoamingManager.m17556b(context)) {
                    RoamingManager.m17558d(context);
                    displayBase = new UpdateDisplayManager(context, (UpdateEndListener) null, updateInfo, false);
                } else {
                    Loger.m17943d("Not reach the max ignores times!");
                }
            } else {
                Loger.m17943d("Condition of silent downloading is satisfied : Start download");
                RoamingManager.m17558d(context);
                MzUpdateComponentService.m17837a(context, updateInfo, (MzUpdateResponse) null, (String) null, false);
            }
            if (displayBase != null) {
                displayBase.mo24763a(z);
                displayBase.mo24762a(str);
                displayBase.mo24765b(str2);
                displayBase.mo24764b();
            }
        }
    }
}
