package com.meizu.media.camera.camcontroller;

import com.android.p012ex.camera2.p013a.TimeoutRuntimeException;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.meizu.media.camera.camcontroller.c */
public class CameraLock extends Semaphore {

    /* renamed from: a */
    public static ChangeQuickRedirect f9119a;

    /* renamed from: b */
    private static final LogUtil.C2630a f9120b = new LogUtil.C2630a("CameraLock");

    public CameraLock(int i) {
        super(i, true);
    }

    /* renamed from: a */
    public void mo19728a(String str) throws InterruptedException {
        if (!PatchProxy.proxy(new Object[]{str}, this, f9119a, false, 3227, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f9120b;
            LogUtil.m15942a(aVar, str + " is trying acquire, " + this);
            if (tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                LogUtil.C2630a aVar2 = f9120b;
                LogUtil.m15942a(aVar2, str + " has acquired lock, " + this);
                return;
            }
            throw new TimeoutRuntimeException("Time out waiting to " + str);
        }
    }

    /* renamed from: b */
    public void mo19729b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f9119a, false, 3228, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (availablePermits() >= 1) {
                LogUtil.C2630a aVar = f9120b;
                LogUtil.m15942a(aVar, str + " return, availablePermits is " + availablePermits());
                return;
            }
            release();
            LogUtil.C2630a aVar2 = f9120b;
            LogUtil.m15942a(aVar2, str + " released");
        }
    }
}
