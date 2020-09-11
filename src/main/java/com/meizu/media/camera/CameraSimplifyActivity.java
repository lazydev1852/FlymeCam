package com.meizu.media.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import com.google.zxing.pdf417.PDF417Common;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.app.LocationManager;
import com.meizu.media.camera.app.PrivacyService;
import com.meizu.media.camera.app.StorageManagerImpl;
import com.meizu.media.camera.app.StorageProvider;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.databinding.CameraSimplifyBinding;
import com.meizu.media.camera.mode.BackTraceMode;
import com.meizu.media.camera.mode.BarCodeMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.mode.VideoMode;
import com.meizu.media.camera.simplify.MzSimplifyImageCaptureHandler;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.C2634am;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.IntentHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.views.OnScreenHint;
import com.meizu.media.camera.views.ToastHint;
import com.meizu.perf.sdk.PerfSdk;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchExecutor;
import com.meizu.savior.PatchManipulateImp;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.savior.SaviorCallBackSample;
import com.meizu.statsapp.p081v3.PkgType;
import com.meizu.statsapp.p081v3.UsageStatsProxy3;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.CheckListener;
import com.meizu.update.component.MzUpdateComponentTracker;
import com.meizu.update.component.MzUpdatePlatform;
import flyme.support.p093v7.app.AlertDialog;
import flyme.support.p093v7.app.PermissionDialogBuilder;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.UUID;

public class CameraSimplifyActivity extends ActivityBase {

    /* renamed from: j */
    public static ChangeQuickRedirect f6654j;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final LogUtil.C2630a f6655m = new LogUtil.C2630a("CameraSimplifyActivity");

    /* renamed from: A */
    private Uri f6656A;

    /* renamed from: B */
    private String f6657B;

    /* renamed from: C */
    private boolean f6658C;

    /* renamed from: D */
    private PowerManager f6659D;

    /* renamed from: E */
    private PrivacyService f6660E;

    /* renamed from: F */
    private boolean f6661F = false;

    /* renamed from: G */
    private boolean f6662G = false;

    /* renamed from: H */
    private boolean f6663H = false;

    /* renamed from: I */
    private boolean f6664I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public Uri f6665J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public MediaSaveService f6666K;

    /* renamed from: L */
    private ServiceConnection f6667L = new ServiceConnection() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6694a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (!PatchProxy.proxy(new Object[]{componentName, iBinder}, this, f6694a, false, 926, new Class[]{ComponentName.class, IBinder.class}, Void.TYPE).isSupported) {
                MediaSaveService unused = CameraSimplifyActivity.this.f6666K = ((MediaSaveService.C1638c) iBinder).mo17843a();
                CameraSimplifyActivity.this.f6679k.mo18390a(CameraSimplifyActivity.this.f6666K);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (!PatchProxy.proxy(new Object[]{componentName}, this, f6694a, false, 927, new Class[]{ComponentName.class}, Void.TYPE).isSupported && CameraSimplifyActivity.this.f6666K != null) {
                CameraSimplifyActivity.this.f6666K.mo17829a((MediaSaveService.C1637b) null);
                MediaSaveService unused = CameraSimplifyActivity.this.f6666K = null;
            }
        }
    };

    /* renamed from: M */
    private CameraProxyV1.C2017a f6668M = new CameraProxyV1.C2017a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6710a;

        /* renamed from: a */
        public void mo17710a(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f6710a, false, 938, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                if (CameraSimplifyActivity.this.mo17752n()) {
                    LogUtil.m15949b(CameraSimplifyActivity.f6655m, "onDeviceOpenFailure isPaused");
                    return;
                }
                int i2 = R.string.cannot_connect_camera;
                if (DeviceHelper.f14049s || DeviceHelper.f14051u || DeviceHelper.f14050t) {
                    i2 = R.string.cannot_connect_camera_anyway;
                } else if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API2)) {
                    i2 = R.string.cannot_connect_camera_v2;
                }
                CameraUtil.m15840a((Activity) CameraSimplifyActivity.this, i2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: N */
    public BroadcastReceiver f6669N = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6717a;

        public void onReceive(Context context, Intent intent) {
            if (PatchProxy.proxy(new Object[]{context, intent}, this, f6717a, false, 939, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported || CameraSimplifyActivity.this.f6498b) {
                return;
            }
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 1);
                int intExtra2 = intent.getIntExtra("level", -1);
                int intExtra3 = intent.getIntExtra("plugged", 0);
                CameraSimplifyActivity.this.f6679k.mo18453b(intExtra, intExtra3);
                CameraSimplifyActivity.this.f6679k.mo18378a(intExtra2, intExtra, intExtra3);
            } else if ("com.android.systemui.ACTION_ENTER_SYSTEMUI".equals(intent.getAction())) {
                LogUtil.m15942a(CameraSimplifyActivity.f6655m, "enter recnet....");
                CameraSimplifyActivity.this.f6679k.mo18489n(false);
            } else if ("com.android.systemui.ACTION_QUIT_SYSTEMUI".equals(intent.getAction())) {
                LogUtil.m15942a(CameraSimplifyActivity.f6655m, "quit recnet....");
                CameraSimplifyActivity.this.f6679k.mo18489n(true);
            }
        }
    };

    /* renamed from: O */
    private BroadcastReceiver f6670O = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6719a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6719a, false, 940, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                LogUtil.m15949b(CameraSimplifyActivity.f6655m, "receive finish message then finish Camera Activity");
                CameraSimplifyActivity.this.finish();
            }
        }
    };

    /* renamed from: P */
    private BroadcastReceiver f6671P = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6721a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6721a, false, 941, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                boolean booleanExtra = intent.getBooleanExtra("available", false);
                LogUtil.C2630a z = CameraSimplifyActivity.f6655m;
                LogUtil.m15952c(z, "Receive FlymeLab State available: " + booleanExtra);
                if (!booleanExtra) {
                    Settings.Global.putInt(CameraSimplifyActivity.this.getContentResolver(), "enable_back_trace_mode", 0);
                    CameraSimplifyActivity.this.finish();
                }
            }
        }
    };

    /* renamed from: Q */
    private BroadcastReceiver f6672Q = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6723a;

        public void onReceive(Context context, Intent intent) {
            Class[] clsArr = {Context.class, Intent.class};
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6723a, false, 942, clsArr, Void.TYPE).isSupported && !CameraSimplifyActivity.this.f6498b && "android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED".equals(intent.getAction())) {
                CameraSimplifyActivity.this.f6679k.mo18470f(DeviceUtil.m16199b(context));
            }
        }
    };

    /* renamed from: R */
    private BroadcastReceiver f6673R = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6725a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6725a, false, 943, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported && !CameraSimplifyActivity.this.f6498b && intent.getAction().equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                if (!CameraSimplifyActivity.this.mo17636c()) {
                    CameraSimplifyActivity.this.f6679k.mo18471f(true);
                }
                LogUtil.m15952c(CameraSimplifyActivity.f6655m, "MEDIA_SCANNER_FINISHED");
            }
        }
    };

    /* renamed from: S */
    private AudioManager.OnAudioFocusChangeListener f6674S = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
        }
    };

    /* renamed from: T */
    private StorageProvider.C1833a f6675T = new StorageProvider.C1833a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6729a;

        /* renamed from: a */
        public void mo17703a(String str, String str2) {
            Class[] clsArr = {String.class, String.class};
            if (!PatchProxy.proxy(new Object[]{str, str2}, this, f6729a, false, 930, clsArr, Void.TYPE).isSupported) {
                LogUtil.C2630a z = CameraSimplifyActivity.f6655m;
                LogUtil.m15954d(z, "onStorageStateChanged: " + str + "(" + str2 + ")");
                if (CameraSimplifyActivity.this.mo17750l()) {
                    CameraSimplifyActivity.this.mo17642h();
                }
                if ("ejecting".equals(str2)) {
                    CameraSimplifyActivity.this.f6679k.mo18422aR();
                }
            }
        }
    };

    /* renamed from: U */
    private ContentObserver f6676U = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f6704a;

        public void onChange(boolean z) {
            if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f6704a, false, 935, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                Uri a = MzThumbnail.m13613a(CameraSimplifyActivity.this.getContentResolver());
                LogUtil.C2630a z2 = CameraSimplifyActivity.f6655m;
                LogUtil.m15942a(z2, "media has been changed, gotoGallery uri = " + CameraSimplifyActivity.this.f6665J + ", currentUri = " + a);
                if (CameraSimplifyActivity.this.f6665J != null && !CameraSimplifyActivity.this.f6665J.equals(a)) {
                    CameraSimplifyActivity.this.f6679k.mo18471f(false);
                    Uri unused = CameraSimplifyActivity.this.f6665J = a;
                }
            }
        }
    };

    /* renamed from: V */
    private ContentObserver f6677V = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f6706a;

        public void onChange(boolean z) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f6706a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 936, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                super.onChange(z);
                if (CameraSimplifyActivity.this.f6689v != DeviceUtil.m16198b((Activity) CameraSimplifyActivity.this)) {
                    int unused = CameraSimplifyActivity.this.f6689v = DeviceUtil.m16198b((Activity) CameraSimplifyActivity.this);
                    LogUtil.C2630a z2 = CameraSimplifyActivity.f6655m;
                    LogUtil.m15942a(z2, "current screen brightness mode = " + CameraSimplifyActivity.this.f6689v);
                    if (CameraSimplifyActivity.this.f6689v == 1) {
                        LogUtil.C2630a z3 = CameraSimplifyActivity.f6655m;
                        LogUtil.m15942a(z3, "mLastModeScreenBrightness = " + CameraSimplifyActivity.this.f6687t);
                        if (CameraSimplifyActivity.this.f6687t == 0.0f) {
                            float unused2 = CameraSimplifyActivity.this.f6688u = DeviceUtil.m16189a((Activity) CameraSimplifyActivity.this);
                        } else {
                            float unused3 = CameraSimplifyActivity.this.f6688u = CameraSimplifyActivity.this.f6687t;
                        }
                        CameraSimplifyActivity.this.m6533M();
                        return;
                    }
                    float unused4 = CameraSimplifyActivity.this.f6687t = CameraSimplifyActivity.this.f6688u;
                }
            }
        }
    };

    /* renamed from: W */
    private ContentObserver f6678W = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f6708a;

        public void onChange(boolean z) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f6708a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 937, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                super.onChange(z);
                if (CameraSimplifyActivity.this.f6689v == 1) {
                    float unused = CameraSimplifyActivity.this.f6688u = DeviceUtil.m16189a((Activity) CameraSimplifyActivity.this);
                    LogUtil.C2630a z2 = CameraSimplifyActivity.f6655m;
                    LogUtil.m15942a(z2, "current screen brightness = " + CameraSimplifyActivity.this.f6688u);
                    CameraSimplifyActivity.this.m6533M();
                }
            }
        }
    };

    /* renamed from: k */
    protected MzSimplifyCamModule f6679k;

    /* renamed from: l */
    protected ToastHint f6680l;

    /* renamed from: n */
    private int f6681n;

    /* renamed from: o */
    private Intent f6682o;

    /* renamed from: p */
    private AlertDialog f6683p;

    /* renamed from: q */
    private boolean f6684q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C1625b f6685r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Handler f6686s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f6687t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f6688u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f6689v;

    /* renamed from: w */
    private StorageProvider f6690w;

    /* renamed from: x */
    private String f6691x;

    /* renamed from: y */
    private AudioManager f6692y;

    /* renamed from: z */
    private LocationManager f6693z;

    /* renamed from: com.meizu.media.camera.CameraSimplifyActivity$b */
    private class C1625b extends OrientationEventListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f6733a;

        public C1625b(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f6733a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 946, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i != -1 && !CameraSimplifyActivity.this.f6498b) {
                CameraSimplifyActivity.this.f6679k.mo18452b(i);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.CameraSimplifyActivity$a */
    private static class C1624a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f6731a;

        /* renamed from: b */
        private WeakReference<CameraSimplifyActivity> f6732b;

        public C1624a(CameraSimplifyActivity cameraSimplifyActivity, Looper looper) {
            super(looper);
            this.f6732b = new WeakReference<>(cameraSimplifyActivity);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f6731a, false, 945, new Class[]{Message.class}, Void.TYPE).isSupported) {
                CameraSimplifyActivity cameraSimplifyActivity = (CameraSimplifyActivity) this.f6732b.get();
                if (cameraSimplifyActivity == null) {
                    LogUtil.m15952c(CameraSimplifyActivity.f6655m, "cameraActivity is null !!!");
                    return;
                }
                switch (message.what) {
                    case 2:
                        if (!cameraSimplifyActivity.mo17751m()) {
                            removeMessages(2);
                            sendEmptyMessageDelayed(2, 120000);
                            return;
                        } else if (ApiHelper.f14208i || ApiHelper.f14209j || cameraSimplifyActivity.f6499c) {
                            LogUtil.m15952c(CameraSimplifyActivity.f6655m, "Time out close Camera !!!");
                            cameraSimplifyActivity.finish();
                            return;
                        } else {
                            LogUtil.m15952c(CameraSimplifyActivity.f6655m, "Time out lock screen !!!");
                            cameraSimplifyActivity.m6529I();
                            return;
                        }
                    case 3:
                        cameraSimplifyActivity.m6524D();
                        return;
                    case 5:
                        cameraSimplifyActivity.m6523C();
                        return;
                    case 6:
                        cameraSimplifyActivity.m6521A();
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
                        intentFilter.addAction("com.android.systemui.ACTION_ENTER_SYSTEMUI");
                        intentFilter.addAction("com.android.systemui.ACTION_QUIT_SYSTEMUI");
                        cameraSimplifyActivity.registerReceiver(cameraSimplifyActivity.f6669N, intentFilter);
                        MzUpdateComponentTracker.m17662a(cameraSimplifyActivity);
                        return;
                    case 9:
                        cameraSimplifyActivity.unregisterReceiver(cameraSimplifyActivity.f6669N);
                        cameraSimplifyActivity.m6522B();
                        MzUpdateComponentTracker.m17663b(cameraSimplifyActivity);
                        return;
                    case 10:
                        cameraSimplifyActivity.m6526F();
                        return;
                    case 12:
                        cameraSimplifyActivity.m6531K();
                        return;
                    case 13:
                        cameraSimplifyActivity.m6525E();
                        cameraSimplifyActivity.mo17772x();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: k */
    public boolean mo17749k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6654j, false, 878, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f6691x = Storage.m7750a().mo18683y();
        if (this.f6679k == null || this.f6690w == null) {
            return false;
        }
        if (!this.f6679k.mo18364O() || !this.f6690w.mo18994b()) {
            Storage.m7750a().mo18630a(Storage.f7387b);
        } else {
            Storage.m7750a().mo18630a(Storage.f7388c);
        }
        if (IntentHelper.m16299a(getIntent(), "isVoiceQuery", false)) {
            Storage.m7750a().mo18677s();
        }
        if (TextUtils.equals(this.f6691x, Storage.m7750a().mo18683y())) {
            return false;
        }
        this.f6691x = Storage.m7750a().mo18683y();
        return true;
    }

    /* renamed from: l */
    public boolean mo17750l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6654j, false, 879, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6690w == null) {
            this.f6690w = new StorageManagerImpl();
            this.f6690w.mo18992a(this.f6675T);
        }
        if (this.f6690w.mo18995c() != null) {
            String a = this.f6690w.mo18995c().mo19033a();
            if (!this.f6679k.mo18404a(a)) {
                this.f6679k.mo18457b(a);
            }
            Storage.m7750a().mo18640b(a);
            this.f6679k.mo18469e(true);
        } else {
            this.f6679k.mo18457b("/storage/sdcard1");
            this.f6679k.mo18469e(false);
        }
        return mo17749k();
    }

    /* renamed from: m */
    public boolean mo17751m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6654j, false, 880, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6679k != null) {
            return this.f6679k.mo18505z();
        }
        return true;
    }

    /* renamed from: n */
    public boolean mo17752n() {
        return this.f6498b;
    }

    /* renamed from: o */
    public void mo17753o() {
        this.f6663H = true;
    }

    /* renamed from: p */
    public MediaSaveService mo17764p() {
        return this.f6666K;
    }

    /* renamed from: a */
    public void mo17746a(String str, boolean z) {
        if (PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f6654j, false, 881, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported || this.f6660E == null) {
            return;
        }
        if (z) {
            this.f6660E.mo19024b(str);
        } else {
            this.f6660E.mo19021a(str);
        }
    }

    /* renamed from: a */
    public void mo17747a(List<String> list, boolean z) {
        if (PatchProxy.proxy(new Object[]{list, new Byte(z ? (byte) 1 : 0)}, this, f6654j, false, 882, new Class[]{List.class, Boolean.TYPE}, Void.TYPE).isSupported || this.f6660E == null) {
            return;
        }
        if (z) {
            this.f6660E.mo19025b(list);
        } else {
            this.f6660E.mo19022a(list);
        }
    }

    /* renamed from: a */
    public void mo17745a(Uri uri) {
        if (!PatchProxy.proxy(new Object[]{uri}, this, f6654j, false, 883, new Class[]{Uri.class}, Void.TYPE).isSupported) {
            if (uri == null) {
                this.f6656A = null;
                return;
            }
            String type = getContentResolver().getType(uri);
            if (type != null) {
                if (!this.f6658C) {
                    this.f6656A = uri;
                }
                if (type.startsWith("video/")) {
                    this.f6658C = false;
                    sendBroadcast(new Intent("android.hardware.action.NEW_VIDEO", uri));
                    CameraUtil.m15878b((Context) this, uri);
                } else if (type.startsWith("image/")) {
                    if (this.f6679k.mo18451az()) {
                        this.f6656A = uri;
                    }
                    CameraUtil.m15844a((Context) this, uri);
                    CameraUtil.m15878b((Context) this, uri);
                } else if (!type.startsWith("application/stitching-preview")) {
                    LogUtil.C2630a aVar = f6655m;
                    LogUtil.m15949b(aVar, "Unknown new media with MIME type:" + type + ", uri:" + uri);
                }
                this.f6657B = null;
            }
        }
    }

    /* renamed from: a */
    public void mo17748a(boolean z) {
        this.f6658C = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m6521A() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 884, new Class[0], Void.TYPE).isSupported) {
            bindService(new Intent(this, MediaSaveService.class), this.f6667L, 1);
            if (PrivacyService.m8310a((Context) this) && PrivacyService.m8311b((Context) this)) {
                this.f6660E = new PrivacyService(this);
                this.f6660E.mo19020a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m6522B() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 885, new Class[0], Void.TYPE).isSupported) {
            if (this.f6667L != null) {
                unbindService(this.f6667L);
            }
            if (this.f6660E != null) {
                this.f6660E.mo19023b();
            }
        }
    }

    public void onTrimMemory(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6654j;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 886, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.onTrimMemory(i);
            if (i >= 60 && this.f6498b && (!ApiHelper.f14209j || !ApiHelper.f14208i)) {
                this.f6679k.mo18480j();
            } else if (i >= 80) {
                LogUtil.m15942a(f6655m, "low memory finish !!!");
            }
        }
    }

    public void onNewIntent(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f6654j, false, 887, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            super.onNewIntent(intent);
            this.f6679k.mo18382a(intent, getContentResolver());
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6654j, false, 888, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            super.onCreate(bundle);
            if (mo17637d()) {
                i = 1;
            } else {
                i = (!DeviceHelper.f13856aI || !DeviceHelper.f14043m || !DeviceHelper.f13851aD || BarCodeMode.m11237a(getIntent().getAction()) || VideoMode.m12118c(getIntent().getAction()) || BackTraceMode.m11156a(getIntent(), getContentResolver()) || MzSimplifyImageCaptureHandler.m13135b(getIntent().getAction()) || IntentHelper.m16299a(getIntent(), "isVoiceQuery", false)) ? 0 : DeviceHelper.f13912bL;
            }
            PerfSdk.m16933a(getApplicationContext());
            CameraOptTask.m8349a(getApplicationContext(), CameraOptTask.m8335a(getApplicationContext(), i, (CameraModeType.ModeType) null, false, false, (UUID) null, (Contants.CameraService.RequestCode) null));
            getWindow().getDecorView().setSystemUiVisibility(1792);
            boolean a = NavigationBarUtils.m15972a();
            NavigationBarUtils.m15974b(getApplicationContext());
            if (a != NavigationBarUtils.m15973a(getApplicationContext().getResources())) {
                CameraUtil.m15843a((Context) this);
            }
            CameraSimplifyBinding cameraSimplifyBinding = (CameraSimplifyBinding) DataBindingUtil.setContentView(this, R.layout.camera_simplify);
            if (NavigationBarUtils.m15972a()) {
                NavigationBarUtils.m15969a(getWindow());
            }
            this.f6686s = new C1624a(this, getMainLooper());
            if (!DeviceUtil.m16197a((Context) this) || ("android.media.action.IMAGE_CAPTURE".equals(getIntent().getAction()) && DeviceUtil.m16202c())) {
                UsageStatsProxy3.init(getApplication(), PkgType.APP, "CQ6ADXDR9CCDBP1LEH0XB36Y");
                this.f6686s.sendEmptyMessageDelayed(13, 50);
                new PatchExecutor(getApplicationContext(), new PatchManipulateImp(), new SaviorCallBackSample()).start();
            } else {
                this.f6686s.sendEmptyMessageDelayed(3, 50);
            }
            if (CameraUtil.m15916v()) {
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 128 | 64);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cameraSimplifyBinding.f9529b.getLayoutParams();
                layoutParams.topMargin = CameraUtil.m15905k();
                cameraSimplifyBinding.f9529b.setLayoutParams(layoutParams);
            }
            if ((CameraUtil.m15916v() || DeviceHelper.f13944br) && Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            this.f6679k = new MzSimplifyCamModule();
            this.f6679k.mo18389a(this, cameraSimplifyBinding);
            this.f6679k.mo18483k(this.f6499c);
            this.f6686s.sendEmptyMessage(5);
            this.f6692y = AndroidServices.m8287a().mo19003b();
            this.f6659D = AndroidServices.m8287a().mo19006e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m6523C() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 889, new Class[0], Void.TYPE).isSupported) {
            registerReceiver(this.f6672Q, new IntentFilter("android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED"));
            registerReceiver(this.f6670O, new IntentFilter("com.meizu.camera.ACTION_FINISH_ACTIVITY"));
            registerReceiver(this.f6671P, new IntentFilter("com.meizu.media.camera.action.flymelab.AVAILABLE_CHANGED"));
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter.addDataScheme("file");
            registerReceiver(this.f6673R, intentFilter);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6654j, false, 890, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            this.f6679k.mo18385a(bundle);
            super.onSaveInstanceState(bundle);
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6654j, false, 891, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            this.f6679k.mo18456b(bundle);
            super.onRestoreInstanceState(bundle);
        }
    }

    /* renamed from: q */
    public void mo17765q() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 892, new Class[0], Void.TYPE).isSupported) {
            this.f6692y.requestAudioFocus(this.f6674S, 3, 2);
        }
    }

    /* renamed from: r */
    public void mo17766r() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 893, new Class[0], Void.TYPE).isSupported) {
            this.f6692y.abandonAudioFocus(this.f6674S);
        }
    }

    /* renamed from: s */
    public boolean mo17767s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6654j, false, 894, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f6692y.isMusicActive();
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m6524D() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 895, new Class[0], Void.TYPE).isSupported) {
            CameraUtil.m15895e((Activity) this);
            PermissionDialogBuilder permissionDialogBuilder = new PermissionDialogBuilder(this);
            permissionDialogBuilder.mo25302a(mo17639f().getResources().getString(R.string.app_name), new String[]{"android.permission.INTERNET", "android.permission.RECORD_AUDIO", "android.permission.ACCESS_FINE_LOCATION"}, new String[]{getResources().getString(R.string.mz_cta_permission_net), getResources().getString(R.string.mz_cta_permission_audio), getResources().getString(R.string.mz_cta_permission_loc)});
            permissionDialogBuilder.mo25301a((PermissionDialogBuilder.C3129a) new PermissionDialogBuilder.C3129a() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6713a;

                /* renamed from: a */
                public void mo17717a(DialogInterface dialogInterface, boolean z, boolean z2) {
                    if (!PatchProxy.proxy(new Object[]{dialogInterface, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f6713a, false, 944, new Class[]{DialogInterface.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
                        LogUtil.C2630a z3 = CameraSimplifyActivity.f6655m;
                        LogUtil.m15952c(z3, "alwaysDeny: " + z + " allow: " + z2);
                        if (z2) {
                            if (!z) {
                                CameraSettings.m9779a(CameraSimplifyActivity.this.getSharedPreferences(CameraSimplifyActivity.this.getPackageName(), 0), 1);
                                UsageStatsProxy3.init(CameraSimplifyActivity.this.getApplication(), PkgType.APP, "CQ6ADXDR9CCDBP1LEH0XB36Y");
                            }
                            CameraSimplifyActivity.this.mo17772x();
                            if (CameraSimplifyActivity.this.f6679k != null) {
                                CameraSimplifyActivity.this.f6679k.mo18463c(true);
                                CameraSimplifyActivity.this.f6679k.mo18497r();
                            }
                            CameraSimplifyActivity.this.m6525E();
                            new PatchExecutor(CameraSimplifyActivity.this.getApplicationContext(), new PatchManipulateImp(), new SaviorCallBackSample()).start();
                            return;
                        }
                        CameraSimplifyActivity.this.finish();
                    }
                }
            });
            AlertDialog a = permissionDialogBuilder.mo25300a();
            a.getWindow().setFormat(-3);
            a.show();
        }
    }

    /* renamed from: com.meizu.media.camera.CameraSimplifyActivity$c */
    private static class C1626c implements CheckListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f6735a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final WeakReference<CameraSimplifyActivity> f6736b;

        public C1626c(CameraSimplifyActivity cameraSimplifyActivity) {
            this.f6736b = new WeakReference<>(cameraSimplifyActivity);
        }

        /* renamed from: a */
        public void mo17726a(int i, final UpdateInfo updateInfo) {
            Object[] objArr = {new Integer(i), updateInfo};
            ChangeQuickRedirect changeQuickRedirect = f6735a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 947, new Class[]{Integer.TYPE, UpdateInfo.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a z = CameraSimplifyActivity.f6655m;
                LogUtil.m15942a(z, "onCheckEnd:" + i);
                if (updateInfo != null) {
                    LogUtil.C2630a z2 = CameraSimplifyActivity.f6655m;
                    LogUtil.m15942a(z2, "new version:" + updateInfo.mVersionName);
                    switch (i) {
                        case 0:
                            if (!updateInfo.mExistsUpdate) {
                                return;
                            }
                            if (this.f6736b.get() == null) {
                                LogUtil.m15942a(CameraSimplifyActivity.f6655m, "camera activity  has been released");
                                return;
                            } else {
                                ((CameraSimplifyActivity) this.f6736b.get()).f6686s.post(new Runnable() {

                                    /* renamed from: a */
                                    public static ChangeQuickRedirect f6737a;

                                    public void run() {
                                        if (!PatchProxy.proxy(new Object[0], this, f6737a, false, 948, new Class[0], Void.TYPE).isSupported) {
                                            if (C1626c.this.f6736b.get() == null) {
                                                LogUtil.m15942a(CameraSimplifyActivity.f6655m, "camera activity  has been released");
                                            } else {
                                                MzUpdatePlatform.m17664a((Activity) C1626c.this.f6736b.get(), updateInfo);
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m6525E() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 896, new Class[0], Void.TYPE).isSupported) {
            MzUpdatePlatform.m17665a(getApplicationContext(), (CheckListener) new C1626c(this));
        }
    }

    public void onUserInteraction() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 897, new Class[0], Void.TYPE).isSupported) {
            super.onUserInteraction();
            this.f6679k.mo18504y();
            this.f6686s.removeMessages(2);
            this.f6686s.sendEmptyMessageDelayed(2, 120000);
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 898, new Class[0], Void.TYPE).isSupported) {
            this.f6498b = true;
            if (this.f6686s.hasMessages(12)) {
                this.f6686s.removeMessages(12);
            }
            if (m6535O()) {
                m6532L();
                if (!this.f6661F && !this.f6663H) {
                    m6534N();
                }
            }
            this.f6679k.mo18488n();
            m6528H();
            super.onPause();
            this.f6679k.mo18490o();
            this.f6686s.removeMessages(2);
            AsyncTaskEx.m15786a((Runnable) new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6715a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f6715a, false, PDF417Common.MAX_CODEWORDS_IN_BARCODE, new Class[0], Void.TYPE).isSupported) {
                        CameraSimplifyActivity.this.f6685r.disable();
                    }
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), intent}, this, f6654j, false, 899, new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, Void.TYPE).isSupported || i == 142) {
            return;
        }
        if (888 == i) {
            if (intent != null && intent.getBooleanExtra("isBackFromGallery", false)) {
                this.f6662G = true;
            }
            m6530J();
            this.f6679k.mo18380a(i, i2, intent);
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.f6679k.mo18380a(i, i2, intent);
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 900, new Class[0], Void.TYPE).isSupported) {
            this.f6498b = false;
            this.f6656A = null;
            this.f6657B = null;
            NavigationBarUtils.m15974b(getApplicationContext());
            this.f6679k.mo18495p();
            super.onResume();
            this.f6679k.mo18496q();
            this.f6686s.removeMessages(2);
            if (m6535O()) {
                this.f6689v = DeviceUtil.m16198b((Activity) this);
                if (this.f6689v == 1) {
                    this.f6688u = DeviceUtil.m16189a((Activity) this);
                    if (!this.f6662G && !this.f6663H) {
                        m6533M();
                    }
                }
                this.f6686s.sendEmptyMessage(12);
            }
            this.f6686s.sendEmptyMessageDelayed(2, 120000);
            this.f6679k.mo18470f(DeviceUtil.m16199b((Context) this));
            this.f6661F = false;
            this.f6663H = false;
            AsyncTaskEx.m15786a((Runnable) new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6727a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f6727a, false, PDF417Common.NUMBER_OF_CODEWORDS, new Class[0], Void.TYPE).isSupported) {
                        C1625b unused = CameraSimplifyActivity.this.f6685r = new C1625b(CameraSimplifyActivity.this);
                        CameraSimplifyActivity.this.f6685r.enable();
                    }
                }
            });
        }
    }

    public void onStart() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 901, new Class[0], Void.TYPE).isSupported) {
            super.onStart();
            this.f6661F = false;
            this.f6686s.sendEmptyMessage(6);
            if (this.f6679k != null) {
                this.f6679k.mo18501v();
            }
        }
    }

    public void onStop() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 902, new Class[0], Void.TYPE).isSupported) {
            super.onStop();
            if (this.f6686s.hasMessages(6)) {
                this.f6686s.removeMessages(6);
            } else {
                this.f6686s.sendEmptyMessage(9);
            }
            if (this.f6679k != null) {
                this.f6679k.mo18500u();
            }
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 903, new Class[0], Void.TYPE).isSupported) {
            if (this.f6686s.hasMessages(5)) {
                this.f6686s.removeMessages(5);
            } else {
                this.f6686s.sendEmptyMessage(10);
            }
            if (this.f6690w != null) {
                this.f6690w.mo18993b(this.f6675T);
            }
            if (this.f6692y != null) {
                this.f6692y.abandonAudioFocus(this.f6674S);
            }
            m6530J();
            super.onDestroy();
            this.f6679k.mo18486m();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m6526F() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 904, new Class[0], Void.TYPE).isSupported) {
            unregisterReceiver(this.f6672Q);
            unregisterReceiver(this.f6670O);
            unregisterReceiver(this.f6671P);
            unregisterReceiver(this.f6673R);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!PatchProxy.proxy(new Object[]{configuration}, this, f6654j, false, 905, new Class[]{Configuration.class}, Void.TYPE).isSupported) {
            super.onConfigurationChanged(configuration);
            this.f6679k.mo18383a(configuration);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Object[] objArr = {new Integer(i), keyEvent};
        ChangeQuickRedirect changeQuickRedirect = f6654j;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 906, new Class[]{Integer.TYPE, KeyEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6679k.mo18403a(i, keyEvent)) {
            return true;
        }
        if ((i == 84 || i == 82) && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Object[] objArr = {new Integer(i), keyEvent};
        ChangeQuickRedirect changeQuickRedirect = f6654j;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 907, new Class[]{Integer.TYPE, KeyEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6679k.mo18459b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onBackPressed() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 908, new Class[0], Void.TYPE).isSupported && !this.f6679k.mo18502w()) {
            super.onBackPressed();
        }
    }

    /* renamed from: t */
    public void mo17768t() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 910, new Class[0], Void.TYPE).isSupported && !this.f6498b) {
            super.finish();
        }
    }

    /* renamed from: u */
    public boolean mo17769u() {
        return this.f6684q;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17634a(long r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r10)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f6654j
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Long.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 911(0x38f, float:1.277E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            com.meizu.media.camera.MzSimplifyCamModule r1 = r9.f6679k
            if (r1 == 0) goto L_0x015d
            com.meizu.media.camera.app.h r1 = r9.f6690w
            if (r1 != 0) goto L_0x002c
            goto L_0x015d
        L_0x002c:
            r1 = 0
            r2 = -1
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            r3 = -1
            r4 = 2
            r5 = 3
            if (r2 != 0) goto L_0x004a
            com.meizu.media.camera.MzSimplifyCamModule r10 = r9.f6679k
            boolean r10 = r10.mo18364O()
            if (r10 == 0) goto L_0x0042
            r10 = 2131755731(0x7f1002d3, float:1.914235E38)
            goto L_0x0045
        L_0x0042:
            r10 = 2131755787(0x7f10030b, float:1.9142463E38)
        L_0x0045:
            java.lang.String r1 = r9.getString(r10)
            goto L_0x0057
        L_0x004a:
            r6 = -2
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x005a
            r10 = 2131755767(0x7f1002f7, float:1.9142423E38)
            java.lang.String r1 = r9.getString(r10)
        L_0x0057:
            r10 = -1
            goto L_0x00ef
        L_0x005a:
            r6 = -3
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0068
            r10 = 2131755047(0x7f100027, float:1.9140962E38)
            java.lang.String r1 = r9.getString(r10)
            goto L_0x0057
        L_0x0068:
            r6 = -4
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0076
            com.meizu.media.camera.util.ac$a r10 = f6655m
            java.lang.String r11 = "updateStorageHint NOT_WRITABLE"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r11)
            goto L_0x0057
        L_0x0076:
            r6 = 105906176(0x6500000, double:5.2324603E-316)
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 > 0) goto L_0x0057
            com.meizu.media.camera.Storage r10 = com.meizu.media.camera.Storage.m7750a()
            boolean r10 = r10.mo18682x()
            if (r10 == 0) goto L_0x00ab
            com.meizu.media.camera.MzSimplifyCamModule r10 = r9.f6679k
            boolean r10 = r10.mo18364O()
            if (r10 == 0) goto L_0x0057
            com.meizu.media.camera.app.h r10 = r9.f6690w
            com.meizu.media.camera.app.h$b r10 = r10.mo18996d()
            long r10 = r10.mo19036d()
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x00a2
            java.lang.String r1 = r9.m6527G()
            goto L_0x00ee
        L_0x00a2:
            r10 = 2131755785(0x7f100309, float:1.914246E38)
            java.lang.String r1 = r9.getString(r10)
            r10 = 1
            goto L_0x00ef
        L_0x00ab:
            com.meizu.media.camera.app.h r10 = r9.f6690w
            boolean r10 = r10.mo18994b()
            if (r10 == 0) goto L_0x00ea
            com.meizu.media.camera.MzSimplifyCamModule r10 = r9.f6679k
            boolean r10 = r10.mo18364O()
            if (r10 == 0) goto L_0x00ce
            com.meizu.media.camera.app.h r10 = r9.f6690w
            com.meizu.media.camera.app.h$b r10 = r10.mo18995c()
            long r10 = r10.mo19036d()
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x0057
            java.lang.String r1 = r9.m6527G()
            goto L_0x00ee
        L_0x00ce:
            com.meizu.media.camera.app.h r10 = r9.f6690w
            com.meizu.media.camera.app.h$b r10 = r10.mo18995c()
            long r10 = r10.mo19036d()
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x00e1
            java.lang.String r1 = r9.m6527G()
            goto L_0x00ee
        L_0x00e1:
            r10 = 2131755784(0x7f100308, float:1.9142457E38)
            java.lang.String r1 = r9.getString(r10)
            r10 = 2
            goto L_0x00ef
        L_0x00ea:
            java.lang.String r1 = r9.m6527G()
        L_0x00ee:
            r10 = 3
        L_0x00ef:
            r9.m6528H()
            if (r1 == 0) goto L_0x015c
            if (r10 != r3) goto L_0x0106
            boolean r10 = r9.f6498b
            if (r10 != 0) goto L_0x015c
            com.meizu.media.camera.views.q r10 = r9.m6542a((java.lang.String) r1)
            r9.f6680l = r10
            com.meizu.media.camera.views.q r10 = r9.f6680l
            r10.mo23395a()
            goto L_0x015c
        L_0x0106:
            if (r10 == r0) goto L_0x010c
            if (r10 == r4) goto L_0x010c
            if (r10 != r5) goto L_0x015c
        L_0x010c:
            flyme.support.v7.app.AlertDialog$Builder r11 = new flyme.support.v7.app.AlertDialog$Builder
            r11.<init>(r9)
            r11.mo25139b((java.lang.CharSequence) r1)
            r11.mo25133a((boolean) r8)
            r1 = 2131755205(0x7f1000c5, float:1.9141283E38)
            if (r10 != r0) goto L_0x0125
            com.meizu.media.camera.CameraSimplifyActivity$10 r10 = new com.meizu.media.camera.CameraSimplifyActivity$10
            r10.<init>()
            r11.mo25125a((int) r1, (android.content.DialogInterface.OnClickListener) r10)
            goto L_0x0145
        L_0x0125:
            if (r10 != r4) goto L_0x013b
            com.meizu.media.camera.CameraSimplifyActivity$11 r10 = new com.meizu.media.camera.CameraSimplifyActivity$11
            r10.<init>()
            r11.mo25125a((int) r1, (android.content.DialogInterface.OnClickListener) r10)
            r10 = 2131755204(0x7f1000c4, float:1.914128E38)
            com.meizu.media.camera.CameraSimplifyActivity$12 r0 = new com.meizu.media.camera.CameraSimplifyActivity$12
            r0.<init>()
            r11.mo25137b((int) r10, (android.content.DialogInterface.OnClickListener) r0)
            goto L_0x0145
        L_0x013b:
            if (r10 != r5) goto L_0x0145
            com.meizu.media.camera.CameraSimplifyActivity$13 r10 = new com.meizu.media.camera.CameraSimplifyActivity$13
            r10.<init>()
            r11.mo25125a((int) r1, (android.content.DialogInterface.OnClickListener) r10)
        L_0x0145:
            boolean r10 = r9.f6498b
            if (r10 != 0) goto L_0x015c
            com.meizu.media.camera.MzSimplifyCamModule r10 = r9.f6679k
            boolean r10 = r10.mo18416aL()
            if (r10 == 0) goto L_0x015c
            flyme.support.v7.app.AlertDialog r10 = r11.mo25141b()
            r9.f6683p = r10
            flyme.support.v7.app.AlertDialog r10 = r9.f6683p
            r10.show()
        L_0x015c:
            return
        L_0x015d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraSimplifyActivity.mo17634a(long):void");
    }

    /* renamed from: a */
    private ToastHint m6542a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f6654j, false, 912, new Class[]{String.class}, ToastHint.class);
        return proxy.isSupported ? (ToastHint) proxy.result : OnScreenHint.m16862a(this, str);
    }

    /* renamed from: G */
    private String m6527G() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6654j, false, 913, new Class[0], String.class);
        return proxy.isSupported ? (String) proxy.result : getString(R.string.spaceIsLow_content);
    }

    /* renamed from: H */
    private void m6528H() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 914, new Class[0], Void.TYPE).isSupported) {
            if (this.f6680l != null) {
                this.f6680l.mo23398b();
                this.f6680l = null;
            }
            if (this.f6683p != null) {
                this.f6683p.dismiss();
                this.f6683p = null;
            }
        }
    }

    /* renamed from: a */
    public void mo17743a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6654j;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 915, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f6681n = i;
            setResult(i);
        }
    }

    /* renamed from: a */
    public void mo17744a(int i, Intent intent) {
        Object[] objArr = {new Integer(i), intent};
        ChangeQuickRedirect changeQuickRedirect = f6654j;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 916, new Class[]{Integer.TYPE, Intent.class}, Void.TYPE).isSupported) {
            this.f6681n = i;
            this.f6682o = intent;
            setResult(i, intent);
        }
    }

    /* renamed from: v */
    public CameraProxyV1.C2017a mo17770v() {
        return this.f6668M;
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public void m6529I() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 917, new Class[0], Void.TYPE).isSupported) {
            try {
                C2634am.m15993a((Object) this.f6659D, "goToSleep", (Class<?>[]) new Class[]{Long.TYPE}, new Object[]{Long.valueOf(SystemClock.uptimeMillis())});
            } catch (Exception e) {
                LogUtil.m15955d(f6655m, "lockScreen failed: ", e);
                finish();
            }
        }
    }

    /* renamed from: w */
    public AudioManager mo17771w() {
        return this.f6692y;
    }

    /* renamed from: x */
    public synchronized LocationManager mo17772x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6654j, false, 918, new Class[0], LocationManager.class);
        if (proxy.isSupported) {
            return (LocationManager) proxy.result;
        }
        if (this.f6693z == null) {
            this.f6693z = new LocationManager(getApplication().getBaseContext());
        }
        return this.f6693z;
    }

    /* renamed from: y */
    public boolean mo17773y() {
        return this.f6661F;
    }

    /* renamed from: J */
    private void m6530J() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 920, new Class[0], Void.TYPE).isSupported && this.f6664I) {
            LogUtil.m15942a(f6655m, "unregisterMediaObserver: ");
            getContentResolver().unregisterContentObserver(this.f6676U);
            this.f6664I = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m6531K() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 921, new Class[0], Void.TYPE).isSupported) {
            getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness_mode"), true, this.f6677V);
        }
    }

    /* renamed from: L */
    private void m6532L() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 922, new Class[0], Void.TYPE).isSupported) {
            getContentResolver().unregisterContentObserver(this.f6677V);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m6533M() {
        if (PatchProxy.proxy(new Object[0], this, f6654j, false, 923, new Class[0], Void.TYPE).isSupported || !m6535O()) {
            return;
        }
        if (this.f6688u + 0.3f >= 1.0f) {
            DeviceUtil.m16192a(this, 1.0f, 1);
        } else {
            DeviceUtil.m16192a(this, this.f6688u + 0.3f, 1);
        }
    }

    /* renamed from: N */
    private void m6534N() {
        if (!PatchProxy.proxy(new Object[0], this, f6654j, false, 924, new Class[0], Void.TYPE).isSupported && m6535O()) {
            DeviceUtil.m16192a(this, Float.NaN, 1);
        }
    }

    /* renamed from: O */
    private boolean m6535O() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6654j, false, 925, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13876ac || !CameraUtil.m15857a((Context) this, "com.meizu.media.gallery", 700008000)) {
            return false;
        }
        return true;
    }
}
