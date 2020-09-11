package com.meizu.media.camera;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.perf.sdk.PerfSdk;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.w */
public class PerfSdkManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f14388a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14389b = new LogUtil.C2630a("PerfSdkManager");

    /* renamed from: c */
    private ActivityBase f14390c;

    /* renamed from: d */
    private HandlerThread f14391d;

    /* renamed from: e */
    private Handler f14392e;

    public PerfSdkManager(ActivityBase activityBase) {
        this.f14390c = activityBase;
    }

    /* renamed from: a */
    public void mo22764a() {
        if (!PatchProxy.proxy(new Object[0], this, f14388a, false, 2065, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f14389b, "init");
            this.f14391d = new HandlerThread("PerfSdkManager");
            this.f14391d.start();
            this.f14392e = new Handler(this.f14391d.getLooper()) {

                /* renamed from: a */
                public static ChangeQuickRedirect f14393a;

                public void handleMessage(Message message) {
                    if (!PatchProxy.proxy(new Object[]{message}, this, f14393a, false, 2072, new Class[]{Message.class}, Void.TYPE).isSupported) {
                        switch (message.what) {
                            case 0:
                                Bundle data = message.getData();
                                PerfSdkManager.this.m16313c(data.getString("scene"), data.getInt("threadid"));
                                return;
                            case 1:
                                Bundle data2 = message.getData();
                                PerfSdkManager.this.m16314d(data2.getString("scene"), data2.getInt("threadid"));
                                return;
                            case 2:
                                PerfSdkManager.this.m16312c();
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
        }
    }

    /* renamed from: a */
    public void mo22765a(String str, int i) {
        Object[] objArr = {str, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14388a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2066, new Class[]{String.class, Integer.TYPE}, Void.TYPE).isSupported && this.f14392e != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("scene", str);
            bundle.putInt("threadid", i);
            message.setData(bundle);
            message.what = 0;
            this.f14392e.sendMessage(message);
        }
    }

    /* renamed from: b */
    public void mo22767b(String str, int i) {
        if (!PatchProxy.proxy(new Object[]{str, new Integer(i)}, this, f14388a, false, 2067, new Class[]{String.class, Integer.TYPE}, Void.TYPE).isSupported && this.f14392e != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("scene", str);
            bundle.putInt("threadid", i);
            message.setData(bundle);
            message.what = 1;
            this.f14392e.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16313c(String str, int i) {
        if (!PatchProxy.proxy(new Object[]{str, new Integer(i)}, this, f14388a, false, 2068, new Class[]{String.class, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14389b;
            LogUtil.m15952c(aVar, "requestBoostAffinity scene : " + str + " currentThread:" + i);
            if (i != -1) {
                PerfSdk.m16934b(this.f14390c).mo23820a(str, 65537, new int[]{i});
                return;
            }
            PerfSdk.m16934b(this.f14390c).mo23820a(str, 65537, (int[]) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16314d(String str, int i) {
        if (!PatchProxy.proxy(new Object[]{str, new Integer(i)}, this, f14388a, false, 2069, new Class[]{String.class, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14389b;
            LogUtil.m15952c(aVar, "cancelBoostAffinity scene : " + str + " currentThread:" + i);
            if (i != -1) {
                PerfSdk.m16934b(this.f14390c).mo23821a(str, new int[]{i});
                return;
            }
            PerfSdk.m16934b(this.f14390c).mo23821a(str, (int[]) null);
        }
    }

    /* renamed from: b */
    public void mo22766b() {
        if (!PatchProxy.proxy(new Object[0], this, f14388a, false, 2070, new Class[0], Void.TYPE).isSupported) {
            this.f14390c = null;
            if (this.f14392e != null) {
                this.f14392e.sendEmptyMessage(2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16312c() {
        if (!PatchProxy.proxy(new Object[0], this, f14388a, false, 2071, new Class[0], Void.TYPE).isSupported && this.f14391d.getLooper() != null) {
            LogUtil.m15952c(f14389b, "quit");
            this.f14391d.getLooper().quit();
        }
    }
}
