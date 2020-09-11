package com.meizu.media.camera.agegender;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.mediatek.util.MtkPatterns;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.agegender.a */
public class AgeGenderEngine {

    /* renamed from: a */
    public static ChangeQuickRedirect f7570a = null;

    /* renamed from: b */
    public static int f7571b = 1;

    /* renamed from: c */
    public static int f7572c = 2;

    /* renamed from: d */
    public static int f7573d = 3;

    /* renamed from: e */
    public static int f7574e;

    /* renamed from: f */
    private static final LogUtil.C2630a f7575f = new LogUtil.C2630a("AgeGenderEngine");

    /* renamed from: g */
    private HandlerThread f7576g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f7577h;

    /* renamed from: i */
    private boolean f7578i = false;

    /* renamed from: j */
    private C1795a f7579j = null;

    /* renamed from: k */
    private boolean f7580k = false;

    /* renamed from: l */
    private final Object f7581l = new Object();

    /* renamed from: com.meizu.media.camera.agegender.a$a */
    /* compiled from: AgeGenderEngine */
    public interface C1795a {
        /* renamed from: a */
        void mo18808a();

        /* renamed from: b */
        void mo18809b();

        /* renamed from: c */
        void mo18810c();
    }

    public AgeGenderEngine(C1795a aVar) {
        this.f7579j = aVar;
    }

    /* renamed from: a */
    public void mo18802a(C1795a aVar) {
        this.f7579j = aVar;
    }

    /* renamed from: a */
    public void mo18801a() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2288, new Class[0], Void.TYPE).isSupported) {
            if (this.f7580k) {
                LogUtil.m15942a(f7575f, "thread has been init");
                return;
            }
            LogUtil.m15942a(f7575f, "initThread");
            this.f7576g = new HandlerThread("AgeGenderEngine");
            this.f7576g.start();
            this.f7577h = new Handler(this.f7576g.getLooper()) {

                /* renamed from: a */
                public static ChangeQuickRedirect f7582a;

                public void handleMessage(Message message) {
                    if (!PatchProxy.proxy(new Object[]{message}, this, f7582a, false, 2297, new Class[]{Message.class}, Void.TYPE).isSupported) {
                        switch (message.what) {
                            case 0:
                                AgeGenderEngine.this.m8017f();
                                break;
                            case 1:
                                break;
                            case 2:
                                if (AgeGenderEngine.this.f7577h != null) {
                                    AgeGenderEngine.this.f7577h.removeMessages(1);
                                    AgeGenderEngine.this.m8019h();
                                    return;
                                }
                                return;
                            case 3:
                                if (AgeGenderEngine.this.f7577h != null) {
                                    AgeGenderEngine.this.f7577h.removeMessages(1);
                                }
                                AgeGenderEngine.this.m8020i();
                                return;
                            default:
                                return;
                        }
                        AgeGenderEngine.this.m8018g();
                        if (AgeGenderEngine.this.f7577h != null) {
                            AgeGenderEngine.this.f7577h.removeMessages(1);
                            AgeGenderEngine.this.f7577h.sendEmptyMessageDelayed(1, 200);
                        }
                    }
                }
            };
            this.f7577h.sendEmptyMessage(0);
            this.f7580k = true;
        }
    }

    /* renamed from: b */
    public void mo18803b() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2290, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f7581l) {
                if (this.f7577h != null) {
                    LogUtil.m15952c(f7575f, MtkPatterns.KEY_URLDATA_START);
                    Message message = new Message();
                    message.what = 1;
                    this.f7577h.sendMessage(message);
                    this.f7578i = true;
                }
            }
        }
    }

    /* renamed from: c */
    public void mo18804c() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2291, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f7581l) {
                if (this.f7577h != null) {
                    LogUtil.m15952c(f7575f, "cancel");
                    Message message = new Message();
                    message.what = 2;
                    this.f7577h.sendMessage(message);
                    this.f7578i = false;
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo18805d() {
        return this.f7578i;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m8017f() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2292, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f7575f, "initEstimation");
            synchronized (this.f7581l) {
                if (this.f7579j != null) {
                    this.f7579j.mo18808a();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m8018g() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2293, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f7581l) {
                if (this.f7579j != null) {
                    this.f7579j.mo18809b();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m8019h() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2294, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f7581l) {
                LogUtil.m15952c(f7575f, "stopEstimation");
                if (this.f7579j != null) {
                    this.f7579j.mo18810c();
                }
            }
        }
    }

    /* renamed from: e */
    public void mo18806e() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2295, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f7575f, "release");
            if (this.f7580k) {
                this.f7580k = false;
                if (this.f7577h != null) {
                    this.f7577h.sendEmptyMessage(3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m8020i() {
        if (!PatchProxy.proxy(new Object[0], this, f7570a, false, 2296, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f7581l) {
                this.f7578i = false;
                m8019h();
                if (this.f7576g.getLooper() != null) {
                    LogUtil.m15952c(f7575f, "quit");
                    this.f7576g.getLooper().quit();
                    this.f7577h = null;
                    this.f7579j = null;
                }
            }
        }
    }
}
