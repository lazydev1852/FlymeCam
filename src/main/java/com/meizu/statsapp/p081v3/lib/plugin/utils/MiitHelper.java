package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.content.Context;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.supplier.IdSupplier;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.MiitHelper */
public class MiitHelper implements IIdentifierListener {
    private static final String TAG = "IDIdentifier";
    private AppIdsUpdater mAppIdsUpdateListener;

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.MiitHelper$AppIdsUpdater */
    public interface AppIdsUpdater {
        void OnIdsAvalid(boolean z, String str, String str2, String str3, String str4);
    }

    public MiitHelper(AppIdsUpdater appIdsUpdater) {
        this.mAppIdsUpdateListener = appIdsUpdater;
    }

    public void getDeviceIds(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        int CallFromReflect = CallFromReflect(context);
        Logger.m17378d(TAG, "getDeviceIds call time:" + (System.currentTimeMillis() - currentTimeMillis));
        if (!(CallFromReflect == 1008612 || CallFromReflect == 1008613 || CallFromReflect == 1008611)) {
        }
        Logger.m17378d(TAG, "getDeviceIds value: " + String.valueOf(CallFromReflect));
    }

    private int CallFromReflect(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this);
    }

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        if (idSupplier != null) {
            String oaid = idSupplier.getOAID();
            String vaid = idSupplier.getVAID();
            String aaid = idSupplier.getAAID();
            idSupplier.shutDown();
            if (this.mAppIdsUpdateListener != null) {
                this.mAppIdsUpdateListener.OnIdsAvalid(z, "", oaid, vaid, aaid);
            }
        }
    }
}
