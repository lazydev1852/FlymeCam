package com.meizu.media.camera.app;

import android.app.KeyguardManager;
import android.app.job.JobScheduler;
import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.storage.StorageManager;
import android.view.WindowManager;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.parser.ARResourceKey;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.app.c */
public class AndroidServices {

    /* renamed from: a */
    public static ChangeQuickRedirect f7923a;

    /* renamed from: b */
    private static LogUtil.C2630a f7924b = new LogUtil.C2630a("AndroidServices");

    /* renamed from: c */
    private final Context f7925c;

    /* renamed from: com.meizu.media.camera.app.c$a */
    /* compiled from: AndroidServices */
    private static class C1830a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final AndroidServices f7926a = new AndroidServices(AndroidContext.m8284a().mo19002b());
    }

    /* renamed from: a */
    public static AndroidServices m8287a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7923a, true, 2500, new Class[0], AndroidServices.class);
        return proxy.isSupported ? (AndroidServices) proxy.result : C1830a.f7926a;
    }

    private AndroidServices(Context context) {
        this.f7925c = context;
    }

    /* renamed from: b */
    public AudioManager mo19003b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.MSG_OPEN_URL, new Class[0], AudioManager.class);
        return proxy.isSupported ? (AudioManager) proxy.result : (AudioManager) m8288a("audio");
    }

    /* renamed from: c */
    public DisplayManager mo19004c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.MSG_ON_DEVICE_IR_RESULT, new Class[0], DisplayManager.class);
        return proxy.isSupported ? (DisplayManager) proxy.result : (DisplayManager) m8288a("display");
    }

    /* renamed from: d */
    public KeyguardManager mo19005d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.MSG_MOBILE_NETWORK_FOR_START_QUERY_RES, new Class[0], KeyguardManager.class);
        return proxy.isSupported ? (KeyguardManager) proxy.result : (KeyguardManager) m8288a("keyguard");
    }

    /* renamed from: e */
    public PowerManager mo19006e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.MSG_CAMERA_BACK, new Class[0], PowerManager.class);
        return proxy.isSupported ? (PowerManager) proxy.result : (PowerManager) m8288a(ARResourceKey.HTTP_POWER);
    }

    /* renamed from: f */
    public SensorManager mo19007f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.MSG_VOLUME_CLOSE, new Class[0], SensorManager.class);
        return proxy.isSupported ? (SensorManager) proxy.result : (SensorManager) m8288a("sensor");
    }

    /* renamed from: g */
    public WindowManager mo19008g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.MSG_VOLUME_OPEN, new Class[0], WindowManager.class);
        return proxy.isSupported ? (WindowManager) proxy.result : (WindowManager) m8288a("window");
    }

    /* renamed from: h */
    public StorageManager mo19009h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.MSG_CONTAINMUSIC_SUPPORTFRONTCAMERA, new Class[0], StorageManager.class);
        return proxy.isSupported ? (StorageManager) proxy.result : (StorageManager) m8288a("storage");
    }

    /* renamed from: i */
    public JobScheduler mo19010i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7923a, false, MsgField.IMSG_ON_DEVICE_IR_TIMERR_START, new Class[0], JobScheduler.class);
        return proxy.isSupported ? (JobScheduler) proxy.result : (JobScheduler) m8288a("jobscheduler");
    }

    /* renamed from: a */
    private Object m8288a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7923a, false, MsgField.MSG_SWITCH_CAMERA, new Class[]{String.class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object systemService = this.f7925c.getSystemService(str);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 10) {
                LogUtil.C2630a aVar = f7924b;
                LogUtil.m15956e(aVar, "Warning: providing system service " + str + " took " + currentTimeMillis2 + Parameters.MESSAGE_SEQ);
            }
            return systemService;
        } catch (Exception unused) {
            return null;
        }
    }
}
