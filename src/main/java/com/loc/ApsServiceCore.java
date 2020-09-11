package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.amap.api.location.APSServiceBase;

/* renamed from: com.loc.cs */
public class ApsServiceCore implements APSServiceBase {

    /* renamed from: a */
    ApsManager f3111a = null;

    /* renamed from: b */
    Context f3112b = null;

    /* renamed from: c */
    Messenger f3113c = null;

    public ApsServiceCore(Context context) {
        this.f3112b = context.getApplicationContext();
        this.f3111a = new ApsManager(this.f3112b);
    }

    /* renamed from: a */
    public int mo8608a(Intent intent, int i, int i2) {
        return 0;
    }

    /* renamed from: a */
    public IBinder mo8609a(Intent intent) {
        this.f3111a.mo13210b(intent);
        this.f3111a.mo13206a(intent);
        this.f3113c = new Messenger(this.f3111a.mo13209b());
        return this.f3113c.getBinder();
    }

    /* renamed from: a */
    public void mo8610a() {
        try {
            ApsManager.m3581f();
            this.f3111a.f3091j = C1079cp.m3529c();
            this.f3111a.f3092k = C1079cp.m3518b();
            this.f3111a.mo13205a();
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "onCreate");
        }
    }

    /* renamed from: b */
    public void mo8611b() {
        try {
            if (this.f3111a != null) {
                this.f3111a.mo13209b().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
