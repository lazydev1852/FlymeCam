package com.meizu.media.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.TimingLoggerUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

public abstract class ActivityBase extends Activity {

    /* renamed from: a */
    public static ChangeQuickRedirect f6489a;

    /* renamed from: g */
    public static int f6490g = 101;

    /* renamed from: h */
    public static int f6491h = 102;

    /* renamed from: i */
    public static String f6492i = "launcher_request_code";
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final LogUtil.C2630a f6493j = new LogUtil.C2630a("ActivityBase");

    /* renamed from: k */
    private static final ArrayList<ActivityBase> f6494k = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final ArrayList<ActivityBase> f6495l = new ArrayList<>();

    /* renamed from: u */
    private static BroadcastReceiver f6496u = null;

    /* renamed from: v */
    private static boolean f6497v = true;

    /* renamed from: b */
    protected boolean f6498b;

    /* renamed from: c */
    protected boolean f6499c;

    /* renamed from: d */
    protected boolean f6500d;

    /* renamed from: e */
    protected boolean f6501e;

    /* renamed from: f */
    protected boolean f6502f;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f6503m = 105906176;

    /* renamed from: n */
    private int f6504n;

    /* renamed from: o */
    private boolean f6505o = false;

    /* renamed from: p */
    private final BroadcastReceiver f6506p = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6511a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6511a, false, 610, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                String action = intent.getAction();
                if (action.equals("android.intent.action.MEDIA_MOUNTED") || action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_CHECKING") || action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                    ActivityBase.this.mo17642h();
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final Object f6507q = new Object();

    /* renamed from: r */
    private Context f6508r;

    /* renamed from: s */
    private BroadcastReceiver f6509s = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6513a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6513a, false, 611, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                LogUtil.m15952c(ActivityBase.f6493j, intent.getAction());
                if (!ActivityBase.this.f6500d && "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    return;
                }
                if ("flyme.intent.action.ACTION_SHOW_LOCK_HOME".equals(intent.getAction())) {
                    ActivityBase.this.f6500d = true;
                    return;
                }
                if (ActivityBase.f6495l.size() > 1) {
                    LogUtil.m15942a(ActivityBase.f6493j, "screen is off,destroy previous secure activity");
                    ActivityBase.f6495l.remove(ActivityBase.this);
                }
                ActivityBase.this.finish();
            }
        }
    };

    /* renamed from: t */
    private BroadcastReceiver f6510t = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6515a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6515a, false, 612, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported && ActivityBase.this.f6499c) {
                if (ActivityBase.f6495l.size() > 1) {
                    ActivityBase.f6495l.remove(ActivityBase.this);
                }
                ActivityBase.this.finish();
            }
        }
    };

    /* renamed from: com.meizu.media.camera.ActivityBase$a */
    protected interface C1573a {
        /* renamed from: a */
        void mo17661a(long j);
    }

    /* renamed from: a */
    public abstract void mo17634a(long j);

    public int mzNightModeUseOf() {
        return 0;
    }

    /* renamed from: a */
    public static boolean m6392a() {
        return f6497v;
    }

    /* renamed from: b */
    public static void m6394b() {
        f6497v = false;
    }

    /* renamed from: c */
    public boolean mo17636c() {
        return this.f6499c;
    }

    /* renamed from: d */
    public boolean mo17637d() {
        return this.f6501e;
    }

    public void onCreate(Bundle bundle) {
        Uri data;
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6489a, false, 595, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            TimingLoggerUtil.m16031a("startUp");
            super.onCreate(bundle);
            LogUtil.C2630a aVar = f6493j;
            LogUtil.m15952c(aVar, "mActivitys:" + f6494k.size() + " mSecureActivitys:" + f6495l.size());
            if (this instanceof SecureCameraActivity) {
                f6495l.add(this);
                if (f6495l.size() > 1) {
                    LogUtil.m15942a(f6493j, "destory previous secure activity");
                    f6495l.remove(0).finish();
                }
            } else {
                f6494k.add(this);
                if (f6494k.size() > 1) {
                    LogUtil.m15942a(f6493j, "destory previous activity");
                    f6494k.remove(0).finish();
                }
                if (f6495l.size() > 1) {
                    LogUtil.m15942a(f6493j, "destory previous secure activity");
                    f6495l.remove(0).finish();
                }
            }
            try {
                Intent intent = getIntent();
                String action = intent.getAction();
                LogUtil.C2630a aVar2 = f6493j;
                LogUtil.m15952c(aVar2, "onCreate action:" + action);
                if ("android.media.action.STILL_IMAGE_CAMERA".equals(action)) {
                    LogUtil.m15942a(LogUtil.f14072b, "Started from lock screen!");
                }
                this.f6504n = intent.getIntExtra(f6492i, f6490g);
                if ("android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(action)) {
                    this.f6499c = true;
                } else if ("android.media.action.IMAGE_CAPTURE_SECURE".equals(action)) {
                    this.f6499c = true;
                } else if ("meizu.intent.action.USE_FRONT_CAMERA".equals(action)) {
                    this.f6501e = true;
                } else if ("meizu.intent.action.USE_FRONT_CAMERA_SECURE".equals(action)) {
                    this.f6501e = true;
                    this.f6499c = true;
                } else if (!"meizu.intent.action.DOUBLE_CLICK_OPEN_CAMERA".equals(action)) {
                    if ("android.intent.action.VIEW".equals(action) && (data = intent.getData()) != null && "flyme_3dtouch".equals(data.getScheme()) && "/mirror".equals(data.getPath())) {
                        this.f6501e = true;
                    }
                    this.f6499c = intent.getBooleanExtra("secure_camera", false);
                } else if (AndroidServices.m8287a().mo19005d().isKeyguardLocked()) {
                    this.f6499c = true;
                }
                if (intent.getIntExtra("android.intent.extras.CAMERA_FACING", -1) == 1) {
                    this.f6501e = true;
                }
                if (intent.getBooleanExtra("android.intent.extra.USE_FRONT_CAMERA", false) || intent.getBooleanExtra("com.google.assistant.extra.USE_FRONT_CAMERA", false)) {
                    this.f6501e = true;
                }
                if (this.f6499c) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    intentFilter.addAction("android.intent.action.USER_PRESENT");
                    intentFilter.addAction("flyme.intent.action.ACTION_SHOW_LOCK_HOME");
                    intentFilter.setPriority(999);
                    registerReceiver(this.f6509s, intentFilter);
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("com.meizu.media.gallery.ENTER_SHARE");
                    registerReceiver(this.f6510t, intentFilter2);
                }
                this.f6502f = AndroidServices.m8287a().mo19005d().isKeyguardLocked();
            } catch (Exception unused) {
                LogUtil.m15952c(f6493j, "Base Act exception");
            }
        }
    }

    public void setContentView(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6489a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 596, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setContentView(LayoutInflater.from(mo17639f()).inflate(i, (ViewGroup) null, true));
        }
    }

    public void onBackPressed() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 597, new Class[0], Void.TYPE).isSupported) {
            super.onBackPressed();
        }
    }

    public void finishAfterTransition() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 598, new Class[0], Void.TYPE).isSupported) {
            super.finishAfterTransition();
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 599, new Class[0], Void.TYPE).isSupported) {
            super.onDestroy();
            if (this.f6499c) {
                unregisterReceiver(this.f6509s);
                unregisterReceiver(this.f6510t);
            }
            if (this instanceof SecureCameraActivity) {
                LogUtil.m15942a(f6493j, "onDestroy SecureCameraActivity");
                f6495l.remove(this);
                return;
            }
            LogUtil.m15942a(f6493j, "onDestroy CameraActivity");
            f6494k.remove(this);
        }
    }

    public void onAttachedToWindow() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 600, new Class[0], Void.TYPE).isSupported) {
            if (this.f6499c) {
                getWindow().addFlags(524288);
            }
            super.onAttachedToWindow();
        }
    }

    public void onDetachedFromWindow() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 601, new Class[0], Void.TYPE).isSupported) {
            if (this.f6499c) {
                getWindow().clearFlags(524288);
            }
            super.onDetachedFromWindow();
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 602, new Class[0], Void.TYPE).isSupported) {
            super.onPause();
            if (this.f6505o) {
                unregisterReceiver(this.f6506p);
                this.f6505o = false;
            }
        }
    }

    public void onRestart() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 603, new Class[0], Void.TYPE).isSupported) {
            super.onRestart();
        }
    }

    public void onStop() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 604, new Class[0], Void.TYPE).isSupported) {
            super.onStop();
        }
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 605, new Class[0], Void.TYPE).isSupported) {
            if (!TimingLoggerUtil.m16034b("startUp")) {
                TimingLoggerUtil.m16031a("startUp");
            }
            super.onResume();
            mo17638e();
        }
    }

    /* renamed from: e */
    public void mo17638e() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 606, new Class[0], Void.TYPE).isSupported && !this.f6505o) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
            intentFilter.addDataScheme("file");
            registerReceiver(this.f6506p, intentFilter);
            this.f6505o = true;
        }
    }

    /* renamed from: a */
    public void mo17635a(final C1573a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f6489a, false, 607, new Class[]{C1573a.class}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Long>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6517a;

                /* renamed from: a */
                public Long mo17658a(Void... voidArr) {
                    Long valueOf;
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f6517a, false, 613, new Class[]{Void[].class}, Long.class);
                    if (proxy.isSupported) {
                        return (Long) proxy.result;
                    }
                    synchronized (ActivityBase.this.f6507q) {
                        long unused = ActivityBase.this.f6503m = Storage.m7750a().mo18678t();
                        valueOf = Long.valueOf(ActivityBase.this.f6503m);
                    }
                    return valueOf;
                }

                /* renamed from: a */
                public void mo17660a(Long l) {
                    if (!PatchProxy.proxy(new Object[]{l}, this, f6517a, false, 614, new Class[]{Long.class}, Void.TYPE).isSupported) {
                        ActivityBase.this.mo17634a(l.longValue());
                        if (aVar == null || ActivityBase.this.f6498b) {
                            LogUtil.m15954d(ActivityBase.f6493j, "ignoring storage callback after activity pause");
                        } else {
                            aVar.mo17661a(l.longValue());
                        }
                    }
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: f */
    public Context mo17639f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6489a, false, 608, new Class[0], Context.class);
        if (proxy.isSupported) {
            return (Context) proxy.result;
        }
        if (this.f6508r == null) {
            this.f6508r = ContextBuilder.m6349a(this, true, true);
        }
        return this.f6508r;
    }

    /* renamed from: g */
    public long mo17641g() {
        return this.f6503m;
    }

    /* renamed from: h */
    public void mo17642h() {
        if (!PatchProxy.proxy(new Object[0], this, f6489a, false, 609, new Class[0], Void.TYPE).isSupported) {
            mo17635a((C1573a) null);
        }
    }
}
