package com.meizu.media.camera;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.VoiceAssist;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.app.LocationManager;
import com.meizu.media.camera.app.PrivacyService;
import com.meizu.media.camera.app.StorageManagerImpl;
import com.meizu.media.camera.app.StorageProvider;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.mode.BackTraceMode;
import com.meizu.media.camera.mode.BarCodeMode;
import com.meizu.media.camera.mode.ManualMode;
import com.meizu.media.camera.mode.PortraitMode;
import com.meizu.media.camera.mode.SuperNightMode;
import com.meizu.media.camera.mode.TofMode;
import com.meizu.media.camera.mode.VideoMode;
import com.meizu.media.camera.p069f.CamModuleBurstListenerImpl;
import com.meizu.media.camera.p069f.CamModuleEfffectDataListenerImpl;
import com.meizu.media.camera.p069f.CamModuleIntentTaskListenerImpl;
import com.meizu.media.camera.p069f.CamModuleModeListenerImpl;
import com.meizu.media.camera.p069f.CamModuleParamsListenerImpl;
import com.meizu.media.camera.p069f.MzCamControllerImpl;
import com.meizu.media.camera.p071h.ModeExecutor;
import com.meizu.media.camera.simplify.MzSimplifyImageCaptureHandler;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.C2634am;
import com.meizu.media.camera.util.C2649i;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.IntentHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.UsageStatsScheduler;
import com.meizu.media.camera.views.OnScreenHint;
import com.meizu.media.camera.views.ToastHint;
import com.meizu.media.gallery.IThumbnailController;
import com.meizu.perf.sdk.PerfSdk;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchExecutor;
import com.meizu.savior.PatchManipulateImp;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.savior.SaviorCallBackSample;
import com.meizu.savior.SaviorJobScheduler;
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

public class CameraActivity extends ActivityBase {

    /* renamed from: j */
    public static ChangeQuickRedirect f6520j;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final LogUtil.C2630a f6521m = new LogUtil.C2630a("CameraActivity");

    /* renamed from: A */
    private LocationManager f6522A;

    /* renamed from: B */
    private Uri f6523B;

    /* renamed from: C */
    private String f6524C;

    /* renamed from: D */
    private boolean f6525D;

    /* renamed from: E */
    private PowerManager f6526E;

    /* renamed from: F */
    private PrivacyService f6527F;

    /* renamed from: G */
    private boolean f6528G = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public IThumbnailController f6529H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public boolean f6530I;

    /* renamed from: J */
    private boolean f6531J = false;

    /* renamed from: K */
    private boolean f6532K = false;

    /* renamed from: L */
    private boolean f6533L = false;

    /* renamed from: M */
    private boolean f6534M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public Uri f6535N;

    /* renamed from: O */
    private SaviorJobScheduler f6536O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public UsageStatsScheduler f6537P;

    /* renamed from: Q */
    private AlertDialog f6538Q;

    /* renamed from: R */
    private boolean f6539R = false;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public MediaSaveService f6540S;

    /* renamed from: T */
    private ServiceConnection f6541T = new ServiceConnection() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6569a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (!PatchProxy.proxy(new Object[]{componentName, iBinder}, this, f6569a, false, 702, new Class[]{ComponentName.class, IBinder.class}, Void.TYPE).isSupported) {
                MediaSaveService unused = CameraActivity.this.f6540S = ((MediaSaveService.C1638c) iBinder).mo17843a();
                CameraActivity.this.f6554k.mo18004a(CameraActivity.this.f6540S);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (!PatchProxy.proxy(new Object[]{componentName}, this, f6569a, false, 703, new Class[]{ComponentName.class}, Void.TYPE).isSupported && CameraActivity.this.f6540S != null) {
                CameraActivity.this.f6540S.mo17829a((MediaSaveService.C1637b) null);
                MediaSaveService unused = CameraActivity.this.f6540S = null;
            }
        }
    };

    /* renamed from: U */
    private CameraProxyV1.C2017a f6542U = new CameraProxyV1.C2017a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6585a;

        /* renamed from: a */
        public void mo17710a(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f6585a, false, 714, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                if (CameraActivity.this.mo17677n()) {
                    LogUtil.m15949b(CameraActivity.f6521m, "onDeviceOpenFailure isPaused");
                    return;
                }
                int i2 = R.string.cannot_connect_camera;
                if (DeviceHelper.f14049s || DeviceHelper.f14051u || DeviceHelper.f14050t) {
                    i2 = R.string.cannot_connect_camera_anyway;
                } else if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API2)) {
                    i2 = R.string.cannot_connect_camera_v2;
                }
                CameraUtil.m15840a((Activity) CameraActivity.this, i2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: V */
    public BroadcastReceiver f6543V = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6600a;

        public void onReceive(Context context, Intent intent) {
            if (PatchProxy.proxy(new Object[]{context, intent}, this, f6600a, false, 722, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported || CameraActivity.this.f6498b) {
                return;
            }
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 1);
                int intExtra2 = intent.getIntExtra("level", -1);
                int intExtra3 = intent.getIntExtra("plugged", 0);
                CameraActivity.this.f6554k.mo18058b(intExtra, intExtra3);
                CameraActivity.this.f6554k.mo18059b(intExtra2, intExtra, intExtra3);
            } else if ("com.android.systemui.ACTION_ENTER_SYSTEMUI".equals(intent.getAction())) {
                LogUtil.m15942a(CameraActivity.f6521m, "enter recnet....");
                CameraActivity.this.f6554k.mo17946i(false);
            } else if ("com.android.systemui.ACTION_QUIT_SYSTEMUI".equals(intent.getAction())) {
                LogUtil.m15942a(CameraActivity.f6521m, "quit recnet....");
                CameraActivity.this.f6554k.mo17946i(true);
            }
        }
    };

    /* renamed from: W */
    private BroadcastReceiver f6544W = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6602a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6602a, false, 723, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                LogUtil.m15949b(CameraActivity.f6521m, "receive finish message then finish Camera Activity");
                CameraActivity.this.finish();
            }
        }
    };

    /* renamed from: X */
    private BroadcastReceiver f6545X = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6604a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6604a, false, 724, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                boolean booleanExtra = intent.getBooleanExtra("available", false);
                LogUtil.C2630a D = CameraActivity.f6521m;
                LogUtil.m15952c(D, "Receive FlymeLab State available: " + booleanExtra);
                if (!booleanExtra) {
                    Settings.Global.putInt(CameraActivity.this.getContentResolver(), "enable_back_trace_mode", 0);
                    CameraActivity.this.finish();
                }
            }
        }
    };

    /* renamed from: Y */
    private BroadcastReceiver f6546Y = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6606a;

        public void onReceive(Context context, Intent intent) {
            Class[] clsArr = {Context.class, Intent.class};
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6606a, false, 725, clsArr, Void.TYPE).isSupported && !CameraActivity.this.f6498b && "android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED".equals(intent.getAction())) {
                CameraActivity.this.f6554k.mo18273w(DeviceUtil.m16199b(context));
            }
        }
    };

    /* renamed from: Z */
    private BroadcastReceiver f6547Z = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6608a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6608a, false, 726, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported && !CameraActivity.this.f6498b && intent.getAction().equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                if (!CameraActivity.this.mo17636c()) {
                    CameraActivity.this.f6554k.mo18043ab(true);
                }
                LogUtil.m15952c(CameraActivity.f6521m, "MEDIA_SCANNER_FINISHED");
            }
        }
    };

    /* renamed from: aa */
    private AudioManager.OnAudioFocusChangeListener f6548aa = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
        }
    };

    /* renamed from: ab */
    private StorageProvider.C1833a f6549ab = new StorageProvider.C1833a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6573a;

        /* renamed from: a */
        public void mo17703a(String str, String str2) {
            Class[] clsArr = {String.class, String.class};
            if (!PatchProxy.proxy(new Object[]{str, str2}, this, f6573a, false, 707, clsArr, Void.TYPE).isSupported) {
                LogUtil.C2630a D = CameraActivity.f6521m;
                LogUtil.m15954d(D, "onStorageStateChanged: " + str + "(" + str2 + ")");
                if (CameraActivity.this.mo17675l()) {
                    CameraActivity.this.mo17642h();
                }
                if ("ejecting".equals(str2)) {
                    CameraActivity.this.f6554k.mo18148cZ();
                }
            }
        }
    };

    /* renamed from: ac */
    private ServiceConnection f6550ac = new ServiceConnection() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6583a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (!PatchProxy.proxy(new Object[]{componentName, iBinder}, this, f6583a, false, 712, new Class[]{ComponentName.class, IBinder.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a D = CameraActivity.f6521m;
                LogUtil.m15942a(D, "onServiceConnected name = " + componentName + ", binder = " + iBinder);
                if (iBinder != null) {
                    boolean unused = CameraActivity.this.f6530I = true;
                } else {
                    boolean unused2 = CameraActivity.this.f6530I = false;
                }
                IThumbnailController unused3 = CameraActivity.this.f6529H = IThumbnailController.Stub.asInterface(iBinder);
                if (CameraActivity.this.f6529H != null) {
                    try {
                        CameraActivity.this.f6529H.registerCallback(CameraActivity.this.f6554k.mo18205dc());
                    } catch (RemoteException e) {
                        LogUtil.C2630a D2 = CameraActivity.f6521m;
                        LogUtil.m15949b(D2, "registerCb failed, " + e);
                    }
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (!PatchProxy.proxy(new Object[]{componentName}, this, f6583a, false, 713, new Class[]{ComponentName.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a D = CameraActivity.f6521m;
                LogUtil.m15942a(D, "onServiceDisconnected name = " + componentName);
                CameraActivity.this.m6423Q();
                IThumbnailController unused = CameraActivity.this.f6529H = null;
                boolean unused2 = CameraActivity.this.f6530I = false;
                CameraActivity.this.f6554k.mo18206dd();
            }
        }
    };

    /* renamed from: ad */
    private ContentObserver f6551ad = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f6587a;

        public void onChange(boolean z) {
            if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f6587a, false, 715, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                new AsyncTaskEx<Void, Void, Uri>() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f6589a;

                    /* renamed from: a */
                    public Uri mo17658a(Void... voidArr) {
                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f6589a, false, 716, new Class[]{Void[].class}, Uri.class);
                        return proxy.isSupported ? (Uri) proxy.result : MzThumbnail.m13613a(CameraActivity.this.getContentResolver());
                    }

                    /* renamed from: a */
                    public void mo17660a(Uri uri) {
                        if (!PatchProxy.proxy(new Object[]{uri}, this, f6589a, false, 717, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                            super.mo17660a(uri);
                            LogUtil.C2630a D = CameraActivity.f6521m;
                            LogUtil.m15942a(D, "media has been changed, gotoGallery uri = " + CameraActivity.this.f6535N + ", currentUri = " + uri);
                            if (CameraActivity.this.f6535N != null && !CameraActivity.this.f6535N.equals(uri)) {
                                CameraActivity.this.f6554k.mo18043ab(false);
                                Uri unused = CameraActivity.this.f6535N = uri;
                            }
                        }
                    }
                }.mo22610a(AsyncTaskEx.f13743q, (Params[]) new Void[0]);
            }
        }
    };

    /* renamed from: ae */
    private ContentObserver f6552ae = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f6591a;

        public void onChange(boolean z) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f6591a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 718, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                super.onChange(z);
                if (CameraActivity.this.f6565w != DeviceUtil.m16198b((Activity) CameraActivity.this)) {
                    int unused = CameraActivity.this.f6565w = DeviceUtil.m16198b((Activity) CameraActivity.this);
                    LogUtil.C2630a D = CameraActivity.f6521m;
                    LogUtil.m15942a(D, "current screen brightness mode = " + CameraActivity.this.f6565w);
                    if (CameraActivity.this.f6565w == 1) {
                        LogUtil.C2630a D2 = CameraActivity.f6521m;
                        LogUtil.m15942a(D2, "mLastModeScreenBrightness = " + CameraActivity.this.f6563u);
                        if (CameraActivity.this.f6563u == 0.0f) {
                            float unused2 = CameraActivity.this.f6564v = DeviceUtil.m16189a((Activity) CameraActivity.this);
                        } else {
                            float unused3 = CameraActivity.this.f6564v = CameraActivity.this.f6563u;
                        }
                        CameraActivity.this.m6428V();
                        return;
                    }
                    float unused4 = CameraActivity.this.f6563u = CameraActivity.this.f6564v;
                }
            }
        }
    };

    /* renamed from: af */
    private ContentObserver f6553af = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f6594a;

        public void onChange(boolean z) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f6594a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 719, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                super.onChange(z);
                if (CameraActivity.this.f6565w == 1) {
                    float unused = CameraActivity.this.f6564v = DeviceUtil.m16189a((Activity) CameraActivity.this);
                    LogUtil.C2630a D = CameraActivity.f6521m;
                    LogUtil.m15942a(D, "current screen brightness = " + CameraActivity.this.f6564v);
                    CameraActivity.this.m6428V();
                }
            }
        }
    };

    /* renamed from: k */
    protected MzCamModule f6554k;

    /* renamed from: l */
    protected ToastHint f6555l;

    /* renamed from: n */
    private CameraBinding f6556n;

    /* renamed from: o */
    private int f6557o;

    /* renamed from: p */
    private Intent f6558p;

    /* renamed from: q */
    private AlertDialog f6559q;

    /* renamed from: r */
    private boolean f6560r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C1596b f6561s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Handler f6562t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f6563u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f6564v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f6565w;

    /* renamed from: x */
    private StorageProvider f6566x;

    /* renamed from: y */
    private String f6567y;

    /* renamed from: z */
    private AudioManager f6568z;

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m6421O() {
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m6422P() {
    }

    /* renamed from: com.meizu.media.camera.CameraActivity$b */
    private class C1596b extends OrientationEventListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f6612a;

        public C1596b(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f6612a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 728, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i != -1 && !CameraActivity.this.f6498b) {
                CameraActivity.this.f6554k.mo18268u(i);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.CameraActivity$a */
    private static class C1595a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f6610a;

        /* renamed from: b */
        private WeakReference<CameraActivity> f6611b;

        public C1595a(CameraActivity cameraActivity, Looper looper) {
            super(looper);
            this.f6611b = new WeakReference<>(cameraActivity);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f6610a, false, 727, new Class[]{Message.class}, Void.TYPE).isSupported) {
                CameraActivity cameraActivity = (CameraActivity) this.f6611b.get();
                if (cameraActivity == null) {
                    LogUtil.m15952c(CameraActivity.f6521m, "cameraActivity is null !!!");
                    return;
                }
                switch (message.what) {
                    case 2:
                        if (!cameraActivity.mo17676m()) {
                            removeMessages(2);
                            sendEmptyMessageDelayed(2, 120000);
                            return;
                        } else if (ApiHelper.f14208i || ApiHelper.f14209j || cameraActivity.f6499c) {
                            LogUtil.m15952c(CameraActivity.f6521m, "Time out close Camera !!!");
                            cameraActivity.finish();
                            return;
                        } else {
                            LogUtil.m15952c(CameraActivity.f6521m, "Time out lock screen !!!");
                            cameraActivity.m6420N();
                            return;
                        }
                    case 3:
                        cameraActivity.m6415I();
                        return;
                    case 5:
                        cameraActivity.m6414H();
                        return;
                    case 6:
                        cameraActivity.m6411E();
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
                        intentFilter.addAction("com.android.systemui.ACTION_ENTER_SYSTEMUI");
                        intentFilter.addAction("com.android.systemui.ACTION_QUIT_SYSTEMUI");
                        cameraActivity.registerReceiver(cameraActivity.f6543V, intentFilter);
                        MzUpdateComponentTracker.m17662a(cameraActivity);
                        cameraActivity.m6413G();
                        return;
                    case 7:
                        cameraActivity.m6421O();
                        if (cameraActivity.f6537P == null) {
                            UsageStatsScheduler unused = cameraActivity.f6537P = new UsageStatsScheduler(cameraActivity.getApplicationContext());
                        }
                        cameraActivity.f6537P.mo22723a();
                        return;
                    case 8:
                        cameraActivity.m6422P();
                        return;
                    case 9:
                        cameraActivity.unregisterReceiver(cameraActivity.f6543V);
                        cameraActivity.m6412F();
                        MzUpdateComponentTracker.m17663b(cameraActivity);
                        return;
                    case 10:
                        cameraActivity.m6417K();
                        return;
                    case 11:
                        cameraActivity.mo17663B();
                        return;
                    case 12:
                        cameraActivity.m6426T();
                        return;
                    case 13:
                        cameraActivity.m6416J();
                        cameraActivity.mo17698y();
                        new ModeExecutor(cameraActivity.getApplicationContext()).mo20252a();
                        return;
                    case 14:
                        new ModeExecutor(cameraActivity.getApplicationContext()).mo20252a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: k */
    public boolean mo17674k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6520j, false, 646, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f6567y = Storage.m7750a().mo18683y();
        if (this.f6554k == null || this.f6566x == null) {
            return false;
        }
        if (!this.f6554k.mo18201dY() || !this.f6566x.mo18994b()) {
            Storage.m7750a().mo18630a(Storage.f7387b);
        } else {
            Storage.m7750a().mo18630a(Storage.f7388c);
        }
        if (IntentHelper.m16299a(getIntent(), "isVoiceQuery", false)) {
            Storage.m7750a().mo18677s();
        }
        if (TextUtils.equals(this.f6567y, Storage.m7750a().mo18683y())) {
            return false;
        }
        this.f6567y = Storage.m7750a().mo18683y();
        return true;
    }

    /* renamed from: l */
    public boolean mo17675l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6520j, false, 647, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6566x == null) {
            this.f6566x = new StorageManagerImpl();
            this.f6566x.mo18992a(this.f6549ab);
        }
        if (this.f6566x.mo18995c() != null) {
            String a = this.f6566x.mo18995c().mo19033a();
            if (!this.f6554k.mo18066b(a)) {
                this.f6554k.mo18121c(a);
            }
            Storage.m7750a().mo18640b(a);
            this.f6554k.mo18042aa(true);
        } else {
            this.f6554k.mo18121c("/storage/sdcard1");
            this.f6554k.mo18042aa(false);
        }
        return mo17674k();
    }

    /* renamed from: m */
    public boolean mo17676m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6520j, false, 648, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6554k != null) {
            return this.f6554k.mo18132cJ();
        }
        return true;
    }

    /* renamed from: n */
    public boolean mo17677n() {
        return this.f6498b;
    }

    /* renamed from: o */
    public void mo17678o() {
        this.f6533L = true;
    }

    /* renamed from: a */
    public void mo17668a(Uri uri, Rect rect) {
        if (!PatchProxy.proxy(new Object[]{uri, rect}, this, f6520j, false, 649, new Class[]{Uri.class, Rect.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f6521m;
            LogUtil.m15942a(aVar, "gotoGallery:" + uri);
            if (this.f6531J) {
                LogUtil.m15952c(f6521m, "Gallery has started");
                return;
            }
            if (!this.f6528G) {
                if (this.f6562t.hasMessages(11)) {
                    this.f6562t.removeMessages(11);
                }
                mo17663B();
            }
            try {
                Intent a = mo17665a(uri);
                if (this.f6499c) {
                    m6439a(a);
                }
                if (!Storage.m7750a().mo18684z()) {
                    if (Storage.m7750a().mo18607A()) {
                        a.putExtra("ThumbnailMode", true);
                        LogUtil.m15942a(f6521m, "putExtraThumbnailMode true");
                    } else {
                        a.putExtra("ThumbnailMode", false);
                        LogUtil.m15942a(f6521m, "putExtraThumbnailMode false");
                    }
                    if (m6430X()) {
                        a.putExtra("autoIncreaseBrightness", true);
                        a.putExtra("increaseBrightnessValue", 0.3f);
                    }
                    boolean z = this.f6554k.mo18194dR() % 180 == 0;
                    LogUtil.C2630a aVar2 = f6521m;
                    LogUtil.m15942a(aVar2, "gotoGallery: isVertical = " + z);
                    if (this.f6530I) {
                        a.putExtra("rect", rect);
                    }
                    startActivityForResult(a, 888);
                    if (z && this.f6530I) {
                        overridePendingTransition(0, 0);
                    }
                    m6424R();
                    this.f6531J = true;
                }
            } catch (ActivityNotFoundException unused) {
                LogUtil.m15949b(f6521m, "Could not start MZ Gallery try another.");
                Uri build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("bucketId", Storage.m7750a().mo18675q()).build();
                Intent intent = new Intent("android.intent.action.VIEW", build);
                intent.addFlags(67108864);
                try {
                    startActivity(intent);
                    this.f6531J = true;
                } catch (Exception unused2) {
                    m6425S();
                    this.f6535N = null;
                    this.f6531J = false;
                    LogUtil.C2630a aVar3 = f6521m;
                    LogUtil.m15949b(aVar3, "No other applications to handle Uri:" + build);
                }
            }
        }
    }

    /* renamed from: a */
    public Intent mo17665a(Uri uri) {
        String str;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uri}, this, f6520j, false, 650, new Class[]{Uri.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent("com.meizu.gallery.action.CAMERA_VIEW");
        intent.setType("image/*");
        intent.putExtra("GalleryBegin", this.f6554k.mo17920aq());
        LogUtil.C2630a aVar = f6521m;
        LogUtil.m15942a(aVar, "GalleryBegin:" + this.f6554k.mo17920aq());
        intent.putExtra("Rotation", this.f6554k.mo18194dR());
        if (TextUtils.isEmpty(this.f6524C)) {
            LogUtil.C2630a aVar2 = f6521m;
            LogUtil.m15942a(aVar2, "mCurrentUri = " + this.f6523B);
            if (this.f6523B == null) {
                if (uri == null) {
                    str = null;
                } else {
                    str = uri.toString();
                }
                intent.putExtra("Uri", str);
                this.f6535N = uri;
            } else {
                intent.putExtra("Uri", this.f6523B.toString());
                this.f6535N = this.f6523B;
            }
        } else {
            intent.putExtra("BucketId", this.f6524C);
        }
        intent.addFlags(524288);
        return intent;
    }

    /* renamed from: a */
    public static void m6439a(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, (Object) null, f6520j, true, 651, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            try {
                C2634am.m15993a(C2634am.m15992a((Object) intent, "mFlymeIntent"), "addSecureFlags", (Class<?>[]) new Class[]{Integer.TYPE}, new Object[]{48});
            } catch (Exception e) {
                LogUtil.m15955d(f6521m, "flymeIntent reflect error", e);
            }
            intent.putExtra("SecureCamera", true);
        }
    }

    /* renamed from: p */
    public MediaSaveService mo17689p() {
        return this.f6540S;
    }

    /* renamed from: a */
    public void mo17670a(String str, boolean z) {
        if (PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f6520j, false, 652, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported || this.f6527F == null) {
            return;
        }
        if (z) {
            this.f6527F.mo19024b(str);
        } else {
            this.f6527F.mo19021a(str);
        }
    }

    /* renamed from: a */
    public void mo17671a(List<String> list, boolean z) {
        if (PatchProxy.proxy(new Object[]{list, new Byte(z ? (byte) 1 : 0)}, this, f6520j, false, 653, new Class[]{List.class, Boolean.TYPE}, Void.TYPE).isSupported || this.f6527F == null) {
            return;
        }
        if (z) {
            this.f6527F.mo19025b(list);
        } else {
            this.f6527F.mo19022a(list);
        }
    }

    /* renamed from: b */
    public void mo17673b(Uri uri) {
        if (!PatchProxy.proxy(new Object[]{uri}, this, f6520j, false, 654, new Class[]{Uri.class}, Void.TYPE).isSupported) {
            if (uri == null) {
                this.f6523B = null;
                return;
            }
            String type = getContentResolver().getType(uri);
            if (type != null) {
                if (!this.f6525D) {
                    this.f6523B = uri;
                }
                if (type.startsWith("video/")) {
                    this.f6525D = false;
                    sendBroadcast(new Intent("android.hardware.action.NEW_VIDEO", uri));
                    CameraUtil.m15878b((Context) this, uri);
                } else if (type.startsWith("image/")) {
                    if (this.f6554k.mo18266t() || this.f6554k.mo18227dy()) {
                        this.f6523B = uri;
                    }
                    CameraUtil.m15844a((Context) this, uri);
                    CameraUtil.m15878b((Context) this, uri);
                } else if (!type.startsWith("application/stitching-preview")) {
                    LogUtil.C2630a aVar = f6521m;
                    LogUtil.m15949b(aVar, "Unknown new media with MIME type:" + type + ", uri:" + uri);
                }
                this.f6524C = null;
            }
        }
    }

    /* renamed from: a */
    public void mo17672a(boolean z) {
        this.f6525D = z;
    }

    /* renamed from: a */
    public void mo17669a(String str) {
        this.f6524C = str;
        this.f6523B = null;
    }

    /* renamed from: q */
    public String mo17690q() {
        return this.f6524C;
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m6411E() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 655, new Class[0], Void.TYPE).isSupported) {
            bindService(new Intent(this, MediaSaveService.class), this.f6541T, 1);
            if (PrivacyService.m8310a((Context) this) && PrivacyService.m8311b((Context) this)) {
                this.f6527F = new PrivacyService(this);
                this.f6527F.mo19020a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m6412F() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 656, new Class[0], Void.TYPE).isSupported) {
            if (this.f6541T != null) {
                unbindService(this.f6541T);
            }
            if (this.f6527F != null) {
                this.f6527F.mo19023b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m6413G() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 657, new Class[0], Void.TYPE).isSupported) {
            if (this.f6536O == null) {
                this.f6536O = new SaviorJobScheduler(this);
            }
            this.f6536O.scheduleJob();
        }
    }

    public void onTrimMemory(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6520j;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 658, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.onTrimMemory(i);
            if (i >= 60 && this.f6498b && (!ApiHelper.f14209j || !ApiHelper.f14208i)) {
                this.f6554k.mo18167cs();
            } else if (i >= 80) {
                LogUtil.m15942a(f6521m, "low memory finish !!!");
            }
        }
    }

    public void onNewIntent(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f6520j, false, 659, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            super.onNewIntent(intent);
            this.f6554k.mo17995a(intent, getContentResolver());
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6520j, false, 660, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            super.onCreate(bundle);
            if (mo17637d()) {
                i = 1;
            } else {
                if (DeviceHelper.f13856aI && DeviceHelper.f14043m && DeviceHelper.f13851aD && !BarCodeMode.m11237a(getIntent().getAction()) && !VideoMode.m12118c(getIntent().getAction()) && !BackTraceMode.m11156a(getIntent(), getContentResolver()) && !MzSimplifyImageCaptureHandler.m13135b(getIntent().getAction()) && !IntentHelper.m16299a(getIntent(), "isVoiceQuery", false) && !ManualMode.m11620a(getIntent().getAction()) && !PortraitMode.m11840a(getIntent().getAction()) && !TofMode.f11116b.mo20658a(getIntent().getAction()) && !SuperNightMode.m11955a(getIntent().getAction())) {
                    i2 = DeviceHelper.f13912bL;
                } else if (!PortraitMode.m11840a(getIntent().getAction()) || DeviceHelper.f13837Q) {
                    boolean a = TofMode.f11116b.mo20658a(getIntent().getAction());
                    i = 0;
                } else {
                    i2 = DeviceHelper.f13911bK;
                }
                i = i2;
            }
            PerfSdk.m16933a(getApplicationContext());
            CameraOptTask.m8349a(getApplicationContext(), CameraOptTask.m8335a(getApplicationContext(), i, IntentHelper.m16298a(getIntent(), getContentResolver()), false, false, (UUID) null, (Contants.CameraService.RequestCode) null));
            getWindow().getDecorView().setSystemUiVisibility(1792);
            boolean a2 = NavigationBarUtils.m15972a();
            NavigationBarUtils.m15974b(getApplicationContext());
            if (a2 != NavigationBarUtils.m15973a(getApplicationContext().getResources())) {
                CameraUtil.m15843a((Context) this);
            }
            this.f6556n = (CameraBinding) DataBindingUtil.setContentView(this, R.layout.camera);
            if (NavigationBarUtils.m15972a()) {
                NavigationBarUtils.m15969a(getWindow());
            }
            this.f6562t = new C1595a(this, getMainLooper());
            if (!DeviceUtil.m16197a((Context) this) || ("android.media.action.IMAGE_CAPTURE".equals(getIntent().getAction()) && DeviceUtil.m16202c())) {
                UsageStatsProxy3.init(getApplication(), PkgType.APP, "CQ6ADXDR9CCDBP1LEH0XB36Y");
                this.f6562t.sendEmptyMessageDelayed(13, 50);
                new PatchExecutor(getApplicationContext(), new PatchManipulateImp(), new SaviorCallBackSample()).start();
            } else {
                this.f6562t.sendEmptyMessageDelayed(3, 50);
                CameraUtil.m15891d(getApplicationContext());
            }
            if (CameraUtil.m15916v()) {
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 128 | 64);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6556n.f9506e.getLayoutParams();
                layoutParams.topMargin = CameraUtil.m15905k();
                this.f6556n.f9506e.setLayoutParams(layoutParams);
            }
            if ((CameraUtil.m15916v() || DeviceHelper.f13944br) && Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            if (this.f6556n.f9503b.getViewStub() != null) {
                this.f6556n.f9503b.getViewStub().inflate();
            }
            this.f6554k = new MzCamModule(new MzCamControllerImpl(), new CamModuleIntentTaskListenerImpl(), new CamModuleParamsListenerImpl(), new CamModuleModeListenerImpl(), new VoiceAssist.C1791b(), new CamModuleBurstListenerImpl(), new CamModuleEfffectDataListenerImpl());
            this.f6554k.mo18003a(this, this.f6556n);
            this.f6554k.mo18045ad(this.f6499c);
            this.f6562t.sendEmptyMessage(5);
            this.f6562t.sendEmptyMessageDelayed(11, 2000);
            this.f6568z = AndroidServices.m8287a().mo19003b();
            this.f6526E = AndroidServices.m8287a().mo19006e();
            C2649i.m16155a(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void m6414H() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 661, new Class[0], Void.TYPE).isSupported) {
            registerReceiver(this.f6546Y, new IntentFilter("android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED"));
            registerReceiver(this.f6544W, new IntentFilter("com.meizu.camera.ACTION_FINISH_ACTIVITY"));
            registerReceiver(this.f6545X, new IntentFilter("com.meizu.media.camera.action.flymelab.AVAILABLE_CHANGED"));
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter.addDataScheme("file");
            registerReceiver(this.f6547Z, intentFilter);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6520j, false, 662, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            this.f6554k.mo18000a(bundle);
            super.onSaveInstanceState(bundle);
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6520j, false, 663, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            this.f6554k.mo18063b(bundle);
            super.onRestoreInstanceState(bundle);
        }
    }

    /* renamed from: r */
    public void mo17691r() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 664, new Class[0], Void.TYPE).isSupported) {
            this.f6568z.requestAudioFocus(this.f6548aa, 3, 2);
        }
    }

    /* renamed from: s */
    public void mo17692s() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 665, new Class[0], Void.TYPE).isSupported) {
            this.f6568z.abandonAudioFocus(this.f6548aa);
        }
    }

    /* renamed from: t */
    public boolean mo17693t() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6520j, false, 666, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f6568z.isMusicActive();
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public void m6415I() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 667, new Class[0], Void.TYPE).isSupported) {
            CameraUtil.m15895e((Activity) this);
            PermissionDialogBuilder permissionDialogBuilder = new PermissionDialogBuilder(this);
            permissionDialogBuilder.mo25302a(mo17639f().getResources().getString(R.string.app_name), new String[]{"android.permission.INTERNET", "android.permission.RECORD_AUDIO", "android.permission.ACCESS_FINE_LOCATION"}, new String[]{getResources().getString(R.string.mz_cta_permission_net), getResources().getString(R.string.mz_cta_permission_audio), getResources().getString(R.string.mz_cta_permission_loc)});
            permissionDialogBuilder.mo25301a((PermissionDialogBuilder.C3129a) new PermissionDialogBuilder.C3129a() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6596a;

                /* renamed from: a */
                public void mo17717a(DialogInterface dialogInterface, boolean z, boolean z2) {
                    if (!PatchProxy.proxy(new Object[]{dialogInterface, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f6596a, false, 704, new Class[]{DialogInterface.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
                        LogUtil.C2630a D = CameraActivity.f6521m;
                        LogUtil.m15952c(D, "alwaysDeny: " + z + " allow: " + z2);
                        if (z2) {
                            if (!z) {
                                CameraSettings.m9779a(CameraActivity.this.getSharedPreferences(CameraActivity.this.getPackageName(), 0), 1);
                                UsageStatsProxy3.init(CameraActivity.this.getApplication(), PkgType.APP, "CQ6ADXDR9CCDBP1LEH0XB36Y");
                            }
                            CameraActivity.this.mo17698y();
                            if (CameraActivity.this.f6554k != null) {
                                CameraActivity.this.f6554k.mo17982V(true);
                                CameraActivity.this.f6554k.mo18125cC();
                            }
                            CameraActivity.this.m6416J();
                            new ModeExecutor(CameraActivity.this.getApplicationContext()).mo20252a();
                            new PatchExecutor(CameraActivity.this.getApplicationContext(), new PatchManipulateImp(), new SaviorCallBackSample()).start();
                            return;
                        }
                        CameraActivity.this.finish();
                    }
                }
            });
            this.f6538Q = permissionDialogBuilder.mo25305b();
            if (this.f6538Q != null) {
                this.f6538Q.getWindow().setFormat(-3);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.CameraActivity$c */
    private static class C1597c implements CheckListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f6614a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final WeakReference<CameraActivity> f6615b;

        public C1597c(CameraActivity cameraActivity) {
            this.f6615b = new WeakReference<>(cameraActivity);
        }

        /* renamed from: a */
        public void mo17726a(int i, final UpdateInfo updateInfo) {
            Object[] objArr = {new Integer(i), updateInfo};
            ChangeQuickRedirect changeQuickRedirect = f6614a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 729, new Class[]{Integer.TYPE, UpdateInfo.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a D = CameraActivity.f6521m;
                LogUtil.m15942a(D, "onCheckEnd:" + i);
                if (updateInfo != null) {
                    LogUtil.C2630a D2 = CameraActivity.f6521m;
                    LogUtil.m15942a(D2, "new version:" + updateInfo.mVersionName);
                    switch (i) {
                        case 0:
                            if (!updateInfo.mExistsUpdate) {
                                return;
                            }
                            if (this.f6615b.get() == null) {
                                LogUtil.m15942a(CameraActivity.f6521m, "camera activity  has been released");
                                return;
                            } else {
                                ((CameraActivity) this.f6615b.get()).f6562t.post(new Runnable() {

                                    /* renamed from: a */
                                    public static ChangeQuickRedirect f6616a;

                                    public void run() {
                                        if (!PatchProxy.proxy(new Object[0], this, f6616a, false, 730, new Class[0], Void.TYPE).isSupported) {
                                            if (C1597c.this.f6615b.get() == null) {
                                                LogUtil.m15942a(CameraActivity.f6521m, "camera activity  has been released");
                                            } else {
                                                MzUpdatePlatform.m17664a((Activity) C1597c.this.f6615b.get(), updateInfo);
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
    /* renamed from: J */
    public void m6416J() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 668, new Class[0], Void.TYPE).isSupported && !this.f6498b) {
            MzUpdatePlatform.m17665a(getApplicationContext(), (CheckListener) new C1597c(this));
        }
    }

    public void onUserInteraction() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 669, new Class[0], Void.TYPE).isSupported) {
            super.onUserInteraction();
            this.f6554k.mo18131cI();
            this.f6562t.removeMessages(2);
            this.f6562t.sendEmptyMessageDelayed(2, 120000);
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 670, new Class[0], Void.TYPE).isSupported) {
            this.f6498b = true;
            if (this.f6562t.hasMessages(7)) {
                this.f6562t.removeMessages(7);
            } else {
                this.f6562t.sendEmptyMessage(8);
            }
            if (this.f6562t.hasMessages(12)) {
                this.f6562t.removeMessages(12);
            }
            if (this.f6562t.hasMessages(14)) {
                this.f6562t.removeMessages(14);
            }
            if (m6430X()) {
                m6427U();
                if (!this.f6531J && !this.f6533L) {
                    m6429W();
                }
            }
            this.f6554k.mo18173cy();
            m6419M();
            super.onPause();
            this.f6554k.mo18174cz();
            this.f6562t.removeMessages(2);
            AsyncTaskEx.m15786a((Runnable) new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6598a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f6598a, false, 705, new Class[0], Void.TYPE).isSupported) {
                        CameraActivity.this.f6561s.disable();
                    }
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), intent}, this, f6520j, false, 671, new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, Void.TYPE).isSupported || i == 142) {
            return;
        }
        if (888 == i) {
            if (intent != null && intent.getBooleanExtra("isBackFromGallery", false)) {
                this.f6532K = true;
            }
            m6425S();
            this.f6554k.mo17991a(i, i2, intent);
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.f6554k.mo17991a(i, i2, intent);
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 672, new Class[0], Void.TYPE).isSupported) {
            this.f6498b = false;
            this.f6523B = null;
            this.f6524C = null;
            NavigationBarUtils.m15974b(getApplicationContext());
            this.f6554k.mo18123cA();
            super.onResume();
            this.f6554k.mo18124cB();
            this.f6562t.sendEmptyMessage(7);
            this.f6562t.removeMessages(2);
            if (m6430X()) {
                this.f6565w = DeviceUtil.m16198b((Activity) this);
                if (this.f6565w == 1) {
                    this.f6564v = DeviceUtil.m16189a((Activity) this);
                    if (!this.f6532K && !this.f6533L) {
                        m6428V();
                    }
                }
                this.f6562t.sendEmptyMessage(12);
            }
            this.f6562t.sendEmptyMessageDelayed(2, 120000);
            this.f6554k.mo18273w(DeviceUtil.m16199b((Context) this));
            this.f6531J = false;
            this.f6533L = false;
            this.f6539R = false;
            AsyncTaskEx.m15786a((Runnable) new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6571a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f6571a, false, 706, new Class[0], Void.TYPE).isSupported) {
                        C1596b unused = CameraActivity.this.f6561s = new C1596b(CameraActivity.this);
                        CameraActivity.this.f6561s.enable();
                    }
                }
            });
            if (this.f6538Q != null && this.f6538Q.isShowing()) {
                if (!DeviceUtil.m16197a((Context) this) || ("android.media.action.IMAGE_CAPTURE".equals(getIntent().getAction()) && DeviceUtil.m16202c())) {
                    this.f6538Q.dismiss();
                }
            }
        }
    }

    public void onStart() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 673, new Class[0], Void.TYPE).isSupported) {
            super.onStart();
            this.f6531J = false;
            this.f6539R = false;
            this.f6562t.sendEmptyMessage(6);
            if (!this.f6499c || !this.f6531J) {
                this.f6562t.sendEmptyMessageDelayed(11, 2000);
            }
            if (this.f6554k != null) {
                this.f6554k.mo18128cF();
            }
        }
    }

    public void onStop() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 674, new Class[0], Void.TYPE).isSupported) {
            super.onStop();
            if (this.f6562t.hasMessages(6)) {
                this.f6562t.removeMessages(6);
            } else {
                this.f6562t.sendEmptyMessage(9);
            }
            if (this.f6562t.hasMessages(11)) {
                this.f6562t.removeMessages(11);
            }
            if (this.f6554k != null) {
                this.f6554k.mo18129cG();
            }
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 675, new Class[0], Void.TYPE).isSupported) {
            if (this.f6562t.hasMessages(5)) {
                this.f6562t.removeMessages(5);
            } else {
                this.f6562t.sendEmptyMessage(10);
            }
            if (this.f6566x != null) {
                this.f6566x.mo18993b(this.f6549ab);
            }
            if (this.f6568z != null) {
                this.f6568z.abandonAudioFocus(this.f6548aa);
            }
            if (this.f6529H != null) {
                try {
                    this.f6529H.unregisterCallback(this.f6554k.mo18205dc());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            m6423Q();
            m6425S();
            this.f6529H = null;
            super.onDestroy();
            this.f6554k.mo18172cx();
            C2649i.m16157d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m6417K() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 676, new Class[0], Void.TYPE).isSupported) {
            unregisterReceiver(this.f6546Y);
            unregisterReceiver(this.f6544W);
            unregisterReceiver(this.f6545X);
            unregisterReceiver(this.f6547Z);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!PatchProxy.proxy(new Object[]{configuration}, this, f6520j, false, 677, new Class[]{Configuration.class}, Void.TYPE).isSupported) {
            super.onConfigurationChanged(configuration);
            this.f6554k.mo17996a(configuration);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Object[] objArr = {new Integer(i), keyEvent};
        ChangeQuickRedirect changeQuickRedirect = f6520j;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 678, new Class[]{Integer.TYPE, KeyEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6554k.mo18020a(i, keyEvent)) {
            return true;
        }
        if ((i == 84 || i == 82) && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Object[] objArr = {new Integer(i), keyEvent};
        ChangeQuickRedirect changeQuickRedirect = f6520j;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 679, new Class[]{Integer.TYPE, KeyEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f6554k.mo18065b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onBackPressed() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 680, new Class[0], Void.TYPE).isSupported && !this.f6554k.mo18130cH()) {
            super.onBackPressed();
        }
    }

    /* renamed from: u */
    public void mo17694u() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 682, new Class[0], Void.TYPE).isSupported && !this.f6498b) {
            super.finish();
        }
    }

    /* renamed from: v */
    public boolean mo17695v() {
        return this.f6560r;
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
            com.meizu.savior.ChangeQuickRedirect r3 = f6520j
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Long.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 683(0x2ab, float:9.57E-43)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            com.meizu.media.camera.MzCamModule r1 = r9.f6554k
            if (r1 == 0) goto L_0x0162
            com.meizu.media.camera.app.h r1 = r9.f6566x
            if (r1 != 0) goto L_0x002c
            goto L_0x0162
        L_0x002c:
            r1 = 0
            r2 = -1
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            r3 = -1
            r4 = 2
            r5 = 3
            if (r2 != 0) goto L_0x004a
            com.meizu.media.camera.MzCamModule r10 = r9.f6554k
            boolean r10 = r10.mo18201dY()
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
            com.meizu.media.camera.util.ac$a r10 = f6521m
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
            com.meizu.media.camera.MzCamModule r10 = r9.f6554k
            boolean r10 = r10.mo18201dY()
            if (r10 == 0) goto L_0x0057
            com.meizu.media.camera.app.h r10 = r9.f6566x
            com.meizu.media.camera.app.h$b r10 = r10.mo18996d()
            long r10 = r10.mo19036d()
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x00a2
            java.lang.String r1 = r9.m6418L()
            goto L_0x00ee
        L_0x00a2:
            r10 = 2131755785(0x7f100309, float:1.914246E38)
            java.lang.String r1 = r9.getString(r10)
            r10 = 1
            goto L_0x00ef
        L_0x00ab:
            com.meizu.media.camera.app.h r10 = r9.f6566x
            boolean r10 = r10.mo18994b()
            if (r10 == 0) goto L_0x00ea
            com.meizu.media.camera.MzCamModule r10 = r9.f6554k
            boolean r10 = r10.mo18201dY()
            if (r10 == 0) goto L_0x00ce
            com.meizu.media.camera.app.h r10 = r9.f6566x
            com.meizu.media.camera.app.h$b r10 = r10.mo18995c()
            long r10 = r10.mo19036d()
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x0057
            java.lang.String r1 = r9.m6418L()
            goto L_0x00ee
        L_0x00ce:
            com.meizu.media.camera.app.h r10 = r9.f6566x
            com.meizu.media.camera.app.h$b r10 = r10.mo18995c()
            long r10 = r10.mo19036d()
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x00e1
            java.lang.String r1 = r9.m6418L()
            goto L_0x00ee
        L_0x00e1:
            r10 = 2131755784(0x7f100308, float:1.9142457E38)
            java.lang.String r1 = r9.getString(r10)
            r10 = 2
            goto L_0x00ef
        L_0x00ea:
            java.lang.String r1 = r9.m6418L()
        L_0x00ee:
            r10 = 3
        L_0x00ef:
            r9.m6419M()
            if (r1 == 0) goto L_0x0161
            if (r10 != r3) goto L_0x0106
            boolean r10 = r9.f6498b
            if (r10 != 0) goto L_0x0161
            com.meizu.media.camera.views.q r10 = r9.m6442b((java.lang.String) r1)
            r9.f6555l = r10
            com.meizu.media.camera.views.q r10 = r9.f6555l
            r10.mo23395a()
            goto L_0x0161
        L_0x0106:
            if (r10 == r0) goto L_0x010c
            if (r10 == r4) goto L_0x010c
            if (r10 != r5) goto L_0x0161
        L_0x010c:
            flyme.support.v7.app.AlertDialog$Builder r11 = new flyme.support.v7.app.AlertDialog$Builder
            r11.<init>(r9)
            r11.mo25139b((java.lang.CharSequence) r1)
            r11.mo25133a((boolean) r8)
            r1 = 2131755205(0x7f1000c5, float:1.9141283E38)
            if (r10 != r0) goto L_0x0125
            com.meizu.media.camera.CameraActivity$12 r10 = new com.meizu.media.camera.CameraActivity$12
            r10.<init>()
            r11.mo25125a((int) r1, (android.content.DialogInterface.OnClickListener) r10)
            goto L_0x0145
        L_0x0125:
            if (r10 != r4) goto L_0x013b
            com.meizu.media.camera.CameraActivity$13 r10 = new com.meizu.media.camera.CameraActivity$13
            r10.<init>()
            r11.mo25125a((int) r1, (android.content.DialogInterface.OnClickListener) r10)
            r10 = 2131755204(0x7f1000c4, float:1.914128E38)
            com.meizu.media.camera.CameraActivity$14 r0 = new com.meizu.media.camera.CameraActivity$14
            r0.<init>()
            r11.mo25137b((int) r10, (android.content.DialogInterface.OnClickListener) r0)
            goto L_0x0145
        L_0x013b:
            if (r10 != r5) goto L_0x0145
            com.meizu.media.camera.CameraActivity$15 r10 = new com.meizu.media.camera.CameraActivity$15
            r10.<init>()
            r11.mo25125a((int) r1, (android.content.DialogInterface.OnClickListener) r10)
        L_0x0145:
            boolean r10 = r9.f6498b
            if (r10 != 0) goto L_0x0161
            com.meizu.media.camera.MzCamModule r10 = r9.f6554k
            boolean r10 = r10.mo18146cX()
            if (r10 == 0) goto L_0x0161
            flyme.support.v7.app.AlertDialog r10 = r11.mo25141b()
            r9.f6559q = r10
            flyme.support.v7.app.AlertDialog r10 = r9.f6559q
            r10.show()
            com.meizu.media.camera.MzCamModule r10 = r9.f6554k
            r10.mo18147cY()
        L_0x0161:
            return
        L_0x0162:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraActivity.mo17634a(long):void");
    }

    /* renamed from: b */
    private ToastHint m6442b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f6520j, false, 684, new Class[]{String.class}, ToastHint.class);
        return proxy.isSupported ? (ToastHint) proxy.result : OnScreenHint.m16862a(this, str);
    }

    /* renamed from: L */
    private String m6418L() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6520j, false, 685, new Class[0], String.class);
        return proxy.isSupported ? (String) proxy.result : getString(R.string.spaceIsLow_content);
    }

    /* renamed from: M */
    private void m6419M() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 686, new Class[0], Void.TYPE).isSupported) {
            if (this.f6555l != null) {
                this.f6555l.mo23398b();
                this.f6555l = null;
            }
            if (this.f6559q != null) {
                this.f6559q.dismiss();
                this.f6559q = null;
            }
        }
    }

    /* renamed from: a */
    public void mo17666a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6520j;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 687, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f6557o = i;
            setResult(i);
        }
    }

    /* renamed from: a */
    public void mo17667a(int i, Intent intent) {
        Object[] objArr = {new Integer(i), intent};
        ChangeQuickRedirect changeQuickRedirect = f6520j;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 688, new Class[]{Integer.TYPE, Intent.class}, Void.TYPE).isSupported) {
            this.f6557o = i;
            this.f6558p = intent;
            setResult(i, intent);
        }
    }

    /* renamed from: w */
    public CameraProxyV1.C2017a mo17696w() {
        return this.f6542U;
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m6420N() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 689, new Class[0], Void.TYPE).isSupported) {
            try {
                C2634am.m15993a((Object) this.f6526E, "goToSleep", (Class<?>[]) new Class[]{Long.TYPE}, new Object[]{Long.valueOf(SystemClock.uptimeMillis())});
            } catch (Exception e) {
                LogUtil.m15955d(f6521m, "lockScreen failed: ", e);
                finish();
            }
        }
    }

    /* renamed from: x */
    public AudioManager mo17697x() {
        return this.f6568z;
    }

    /* renamed from: y */
    public synchronized LocationManager mo17698y() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6520j, false, 691, new Class[0], LocationManager.class);
        if (proxy.isSupported) {
            return (LocationManager) proxy.result;
        }
        if (this.f6522A == null) {
            this.f6522A = new LocationManager(getApplication().getBaseContext());
        }
        return this.f6522A;
    }

    /* renamed from: z */
    public boolean mo17699z() {
        return this.f6531J;
    }

    /* renamed from: A */
    public IThumbnailController mo17662A() {
        return this.f6529H;
    }

    /* renamed from: B */
    public void mo17663B() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 692, new Class[0], Void.TYPE).isSupported && !this.f6528G) {
            Intent intent = new Intent("com.meizu.media.gallery.START");
            intent.setPackage("com.meizu.media.gallery");
            bindService(intent, this.f6550ac, 1);
            this.f6528G = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m6423Q() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 693, new Class[0], Void.TYPE).isSupported && this.f6528G) {
            LogUtil.m15952c(f6521m, "unbindGalleryService: ");
            try {
                unbindService(this.f6550ac);
            } catch (RuntimeException e) {
                LogUtil.C2630a aVar = f6521m;
                LogUtil.m15949b(aVar, "unbindGalleryService error:" + e.getMessage());
            }
            this.f6528G = false;
            this.f6530I = false;
        }
    }

    /* renamed from: R */
    private void m6424R() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 694, new Class[0], Void.TYPE).isSupported) {
            getContentResolver().registerContentObserver(Uri.parse("content://media/external"), true, this.f6551ad);
            this.f6534M = true;
        }
    }

    /* renamed from: S */
    private void m6425S() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 695, new Class[0], Void.TYPE).isSupported && this.f6534M) {
            LogUtil.m15942a(f6521m, "unregisterMediaObserver: ");
            getContentResolver().unregisterContentObserver(this.f6551ad);
            this.f6534M = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m6426T() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 696, new Class[0], Void.TYPE).isSupported) {
            getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness_mode"), true, this.f6552ae);
        }
    }

    /* renamed from: U */
    private void m6427U() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 697, new Class[0], Void.TYPE).isSupported) {
            getContentResolver().unregisterContentObserver(this.f6552ae);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m6428V() {
        if (PatchProxy.proxy(new Object[0], this, f6520j, false, 698, new Class[0], Void.TYPE).isSupported || !m6430X()) {
            return;
        }
        if (this.f6564v + 0.3f >= 1.0f) {
            DeviceUtil.m16192a(this, 1.0f, 1);
        } else {
            DeviceUtil.m16192a(this, this.f6564v + 0.3f, 1);
        }
    }

    /* renamed from: W */
    private void m6429W() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 699, new Class[0], Void.TYPE).isSupported && m6430X()) {
            DeviceUtil.m16192a(this, Float.NaN, 1);
        }
    }

    /* renamed from: X */
    private boolean m6430X() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6520j, false, MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13876ac || !CameraUtil.m15857a((Context) this, "com.meizu.media.gallery", 700008000)) {
            return false;
        }
        return true;
    }

    /* renamed from: C */
    public void mo17664C() {
        if (!PatchProxy.proxy(new Object[0], this, f6520j, false, 701, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f6521m, "gotoLutManager:");
            if (this.f6539R) {
                LogUtil.m15952c(f6521m, "LutManager has started");
                return;
            }
            try {
                Intent intent = new Intent("com.android.gallery.action.FILTER_MANAGER");
                intent.setPackage("com.meizu.media.gallery");
                intent.addFlags(268435456);
                intent.addFlags(536870912);
                startActivityForResult(intent, 666);
                m6424R();
                this.f6539R = true;
            } catch (ActivityNotFoundException unused) {
                LogUtil.m15949b(f6521m, "Could not start LutManager");
                this.f6539R = false;
            }
        }
    }
}
