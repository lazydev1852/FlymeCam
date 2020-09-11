package com.loc;

import android.content.Context;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.loc.q */
public final class SDKDBOperation {

    /* renamed from: a */
    private DBOperation f3390a;

    /* renamed from: b */
    private Context f3391b;

    public SDKDBOperation(Context context, boolean z) {
        this.f3391b = context;
        this.f3390a = m3908a(this.f3391b, z);
    }

    /* renamed from: a */
    private static DBOperation m3908a(Context context, boolean z) {
        try {
            return new DBOperation(context, DBOperation.m3894a((Class<? extends DBCreator>) LogDBCreator.class));
        } catch (Throwable th) {
            if (!z) {
                SDKLogHandler.m3867b(th, "sd", "gdb");
            }
            return null;
        }
    }

    /* renamed from: a */
    public final List<SDKInfo> mo13307a() {
        try {
            return this.f3390a.mo13299a(SDKInfo.m3786g(), SDKInfo.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final void mo13308a(SDKInfo diVar) {
        if (diVar != null) {
            try {
                boolean z = false;
                if (this.f3390a == null) {
                    this.f3390a = m3908a(this.f3391b, false);
                }
                String a = SDKInfo.m3783a(diVar.mo13272a());
                List<SDKInfo> b = this.f3390a.mo13304b(a, SDKInfo.class);
                if (b != null) {
                    if (b.size() != 0) {
                        Iterator<SDKInfo> it = b.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().equals(diVar)) {
                                    break;
                                }
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            this.f3390a.mo13303a(a, (Object) diVar);
                            return;
                        }
                        return;
                    }
                }
                this.f3390a.mo13300a(diVar);
            } catch (Throwable th) {
                SDKLogHandler.m3867b(th, "sd", AdvanceSetting.NETWORK_TYPE);
            }
        }
    }
}
