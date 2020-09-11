package com.meizu.media.camera;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import com.meizu.media.camera.FloatWindowManager;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class FloatWindowService extends Service {

    /* renamed from: a */
    public static ChangeQuickRedirect f6748a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f6749b = new LogUtil.C2630a("FloatWindowService");

    /* renamed from: c */
    private Handler f6750c = new C1631a();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, f6748a, false, 1002, new Class[0], Void.TYPE).isSupported) {
            super.onCreate();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent, new Integer(i), new Integer(i2)}, this, f6748a, false, 1003, new Class[]{Intent.class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (intent != null) {
            this.f6750c.removeMessages(2);
            Message obtainMessage = this.f6750c.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = intent;
            this.f6750c.sendMessage(obtainMessage);
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f6748a, false, 1004, new Class[0], Void.TYPE).isSupported) {
            super.onDestroy();
        }
    }

    /* renamed from: com.meizu.media.camera.FloatWindowService$a */
    private class C1631a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f6751a;

        /* renamed from: c */
        private PowerManager f6753c = AndroidServices.m8287a().mo19006e();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public PowerManager.WakeLock f6754d = this.f6753c.newWakeLock(268435462, FloatWindowService.f6749b.toString());
        /* access modifiers changed from: private */

        /* renamed from: e */
        public FloatWindowManager f6755e;

        public C1631a() {
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f6751a, false, 1006, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        LogUtil.m15952c(FloatWindowService.f6749b, "MSG_SHOW_WINDOW");
                        Intent intent = (Intent) message.obj;
                        Uri uri = (Uri) intent.getParcelableExtra("uri");
                        int intExtra = intent.getIntExtra("jpgRotation", 0);
                        int intExtra2 = intent.getIntExtra("picture_ratio", 1);
                        boolean booleanExtra = intent.getBooleanExtra("picture_postview", false);
                        final Intent intent2 = (Intent) intent.getParcelableExtra("gallery_intent");
                        if (this.f6755e == null) {
                            this.f6755e = new FloatWindowManager(FloatWindowService.this.getApplicationContext());
                        }
                        this.f6755e.mo20108c();
                        this.f6755e.mo20106a((FloatWindowManager.C2076b) new FloatWindowManager.C2076b() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f6756a;

                            /* renamed from: a */
                            public void mo17800a() {
                                if (!PatchProxy.proxy(new Object[0], this, f6756a, false, 1007, new Class[0], Void.TYPE).isSupported && intent2 != null) {
                                    boolean isKeyguardLocked = AndroidServices.m8287a().mo19005d().isKeyguardLocked();
                                    boolean isKeyguardSecure = AndroidServices.m8287a().mo19005d().isKeyguardSecure();
                                    LogUtil.C2630a a = FloatWindowService.f6749b;
                                    LogUtil.m15952c(a, "click isKeyguardLocked:" + isKeyguardLocked + ", isKeyguardSecure:" + isKeyguardSecure);
                                    if (isKeyguardLocked && isKeyguardSecure) {
                                        CameraActivity.m6439a(intent2);
                                    }
                                    intent2.setFlags(268468224);
                                    UsageStatsHelper.m16042a(FloatWindowService.this.getApplicationContext()).mo22695b("click_thumbnail");
                                    FloatWindowService.this.getApplicationContext().startActivity(intent2);
                                    C1631a.this.removeMessages(2);
                                    C1631a.this.sendEmptyMessage(2);
                                }
                            }

                            /* renamed from: b */
                            public void mo17801b() {
                                if (!PatchProxy.proxy(new Object[0], this, f6756a, false, 1008, new Class[0], Void.TYPE).isSupported) {
                                    LogUtil.m15952c(FloatWindowService.f6749b, "onShowAnimStart");
                                    C1631a.this.f6754d.acquire();
                                }
                            }

                            /* renamed from: c */
                            public void mo17802c() {
                                if (!PatchProxy.proxy(new Object[0], this, f6756a, false, 1009, new Class[0], Void.TYPE).isSupported) {
                                    LogUtil.m15952c(FloatWindowService.f6749b, "onShowAnimEnd");
                                }
                            }

                            /* renamed from: d */
                            public void mo17803d() {
                                if (!PatchProxy.proxy(new Object[0], this, f6756a, false, 1010, new Class[0], Void.TYPE).isSupported) {
                                    LogUtil.m15952c(FloatWindowService.f6749b, "onDismissAnimStart");
                                }
                            }

                            /* renamed from: e */
                            public void mo17804e() {
                                if (!PatchProxy.proxy(new Object[0], this, f6756a, false, 1011, new Class[0], Void.TYPE).isSupported) {
                                    LogUtil.m15952c(FloatWindowService.f6749b, "onDismissAnimEnd");
                                    C1631a.this.removeMessages(2);
                                    C1631a.this.f6755e.mo20107b();
                                    C1631a.this.f6754d.release();
                                }
                            }
                        });
                        if (!this.f6755e.mo20109d()) {
                            this.f6755e.mo20104a(FloatWindowService.this.getApplicationContext());
                        }
                        this.f6755e.mo20105a(uri, intExtra, intExtra2, booleanExtra);
                        removeMessages(2);
                        sendEmptyMessageDelayed(2, 8000);
                        return;
                    case 2:
                        LogUtil.m15952c(FloatWindowService.f6749b, "MSG_HIDE_WINDOW");
                        this.f6755e.mo20103a();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
