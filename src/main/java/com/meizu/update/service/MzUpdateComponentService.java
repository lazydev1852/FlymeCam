package com.meizu.update.service;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.p020ar.parser.ARResourceKey;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.update.ComponentTrackerImpl;
import com.meizu.update.ServerManager;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.UpdateEndListener;
import com.meizu.update.display.DisplayBase;
import com.meizu.update.display.InstallDisplayManager;
import com.meizu.update.display.UdResultDisplayManager;
import com.meizu.update.display.UpdateDialogActivityWrapper;
import com.meizu.update.iresponse.MzUpdateResponse;
import com.meizu.update.p083a.FileCacheHelper;
import com.meizu.update.p085c.CancelException;
import com.meizu.update.p085c.Downloader;
import com.meizu.update.p085c.LoadException;
import com.meizu.update.p085c.p086a.RetryDownloader;
import com.meizu.update.p085c.p088c.DownloadFileChecker;
import com.meizu.update.p085c.p088c.DownloadRetryTracker;
import com.meizu.update.p085c.p088c.IFileChecker;
import com.meizu.update.p085c.p088c.PluginFileChecker;
import com.meizu.update.p091e.StateManager;
import com.meizu.update.push.MzucPushUsageCollector;
import com.meizu.update.push.UpdatePushManager;
import com.meizu.update.usage.UpdateUsageCollector;
import com.meizu.update.usage.VerifyUsageCollector;
import com.meizu.update.util.ForegroundUtil;
import com.meizu.update.util.HttpLoadException;
import com.meizu.update.util.Loger;
import com.meizu.update.util.PluginUpdateInfo;
import com.meizu.update.util.Utility;
import java.io.File;
import java.util.List;

public class MzUpdateComponentService extends Service {

    /* renamed from: a */
    private static long f16310a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RetryDownloader f16311b;

    /* renamed from: c */
    private volatile Looper f16312c;

    /* renamed from: d */
    private volatile C3031a f16313d;

    /* renamed from: e */
    private Handler f16314e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NetworkStatusReceiver f16315f = new NetworkStatusReceiver();

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: com.meizu.update.service.MzUpdateComponentService$a */
    private final class C3031a extends Handler {
        public C3031a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: type inference failed for: r1v19, types: [android.os.Parcelable] */
        /* JADX WARNING: type inference failed for: r1v27, types: [android.os.Parcelable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r12) {
            /*
                r11 = this;
                java.lang.Object r0 = r12.obj
                android.content.Intent r0 = (android.content.Intent) r0
                android.os.Bundle r0 = r0.getExtras()
                int r1 = r12.what
                r2 = 0
                r3 = 0
                r4 = 1
                switch(r1) {
                    case 0: goto L_0x012f;
                    case 1: goto L_0x00a0;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x004b;
                    case 4: goto L_0x0044;
                    case 5: goto L_0x0038;
                    case 6: goto L_0x0012;
                    default: goto L_0x0010;
                }
            L_0x0010:
                goto L_0x012f
            L_0x0012:
                com.meizu.update.util.UpdateProcessMutexHelper.m17951a(r4)
                java.lang.String r1 = "response"
                boolean r1 = r0.containsKey(r1)
                if (r1 == 0) goto L_0x0026
                java.lang.String r1 = "response"
                android.os.Parcelable r1 = r0.getParcelable(r1)
                r3 = r1
                com.meizu.update.iresponse.MzUpdateResponse r3 = (com.meizu.update.iresponse.MzUpdateResponse) r3
            L_0x0026:
                java.lang.String r1 = "update_info_plugin"
                android.os.Parcelable r0 = r0.getParcelable(r1)
                com.meizu.update.util.PluginUpdateInfo r0 = (com.meizu.update.util.PluginUpdateInfo) r0
                com.meizu.update.service.MzUpdateComponentService r1 = com.meizu.update.service.MzUpdateComponentService.this
                r1.m17850a((com.meizu.update.util.PluginUpdateInfo) r0, (com.meizu.update.iresponse.MzUpdateResponse) r3)
                com.meizu.update.util.UpdateProcessMutexHelper.m17951a(r2)
                goto L_0x012f
            L_0x0038:
                com.meizu.update.service.MzUpdateComponentService r0 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.p083a.UpdateInfoCache.m17546c(r0)
                com.meizu.update.service.MzUpdateComponentService r0 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.p083a.FileCacheHelper.m17529a((android.content.Context) r0)
                goto L_0x012f
            L_0x0044:
                com.meizu.update.service.MzUpdateComponentService r0 = com.meizu.update.service.MzUpdateComponentService.this
                r0.m17862c()
                goto L_0x012f
            L_0x004b:
                com.meizu.update.service.MzUpdateComponentService r0 = com.meizu.update.service.MzUpdateComponentService.this
                r0.m17832a()
                goto L_0x012f
            L_0x0052:
                com.meizu.update.util.UpdateProcessMutexHelper.m17951a(r4)
                java.lang.String r1 = "apk_path"
                java.lang.String r1 = r0.getString(r1)
                java.lang.String r5 = "response"
                boolean r5 = r0.containsKey(r5)
                if (r5 == 0) goto L_0x006b
                java.lang.String r3 = "response"
                android.os.Parcelable r3 = r0.getParcelable(r3)
                com.meizu.update.iresponse.MzUpdateResponse r3 = (com.meizu.update.iresponse.MzUpdateResponse) r3
            L_0x006b:
                java.lang.String r5 = "update_info"
                android.os.Parcelable r5 = r0.getParcelable(r5)
                com.meizu.update.UpdateInfo r5 = (com.meizu.update.UpdateInfo) r5
                java.lang.String r6 = "from_notification"
                boolean r6 = r0.containsKey(r6)
                if (r6 == 0) goto L_0x0088
                com.meizu.update.service.MzUpdateComponentService r6 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.usage.UpdateUsageCollector r6 = com.meizu.update.usage.UpdateUsageCollector.m17913a(r6)
                com.meizu.update.usage.UpdateUsageCollector$UpdateAction r7 = com.meizu.update.usage.UpdateUsageCollector.UpdateAction.Install_Yes
                java.lang.String r8 = r5.mVersionName
                r6.mo24855a(r7, r8)
            L_0x0088:
                java.lang.String r6 = "should_notify"
                boolean r6 = r0.containsKey(r6)
                if (r6 == 0) goto L_0x0096
                java.lang.String r4 = "should_notify"
                boolean r4 = r0.getBoolean(r4)
            L_0x0096:
                com.meizu.update.service.MzUpdateComponentService r0 = com.meizu.update.service.MzUpdateComponentService.this
                r0.m17859b(r5, r1, r3, r4)
                com.meizu.update.util.UpdateProcessMutexHelper.m17951a(r2)
                goto L_0x012f
            L_0x00a0:
                com.meizu.update.util.UpdateProcessMutexHelper.m17951a(r4)
                java.lang.String r1 = "response"
                boolean r1 = r0.containsKey(r1)
                if (r1 == 0) goto L_0x00b4
                java.lang.String r1 = "response"
                android.os.Parcelable r1 = r0.getParcelable(r1)
                r3 = r1
                com.meizu.update.iresponse.MzUpdateResponse r3 = (com.meizu.update.iresponse.MzUpdateResponse) r3
            L_0x00b4:
                r7 = r3
                java.lang.String r1 = "update_info"
                android.os.Parcelable r1 = r0.getParcelable(r1)
                r6 = r1
                com.meizu.update.UpdateInfo r6 = (com.meizu.update.UpdateInfo) r6
                java.lang.String r1 = "from_notification"
                boolean r1 = r0.containsKey(r1)
                if (r1 == 0) goto L_0x00df
                com.meizu.update.service.MzUpdateComponentService r1 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.usage.UpdateUsageCollector r1 = com.meizu.update.usage.UpdateUsageCollector.m17913a(r1)
                com.meizu.update.usage.UpdateUsageCollector$UpdateAction r3 = com.meizu.update.usage.UpdateUsageCollector.UpdateAction.UpdateAlert_Yes
                java.lang.String r5 = r6.mVersionName
                com.meizu.update.service.MzUpdateComponentService r8 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.service.MzUpdateComponentService r9 = com.meizu.update.service.MzUpdateComponentService.this
                java.lang.String r9 = r9.getPackageName()
                java.lang.String r8 = com.meizu.update.util.Utility.m17970b((android.content.Context) r8, (java.lang.String) r9)
                r1.mo24856a(r3, r5, r8)
            L_0x00df:
                java.lang.String r1 = "should_notify"
                boolean r1 = r0.containsKey(r1)
                if (r1 == 0) goto L_0x00ed
                java.lang.String r1 = "should_notify"
                boolean r4 = r0.getBoolean(r1)
            L_0x00ed:
                if (r4 != 0) goto L_0x0101
                com.meizu.update.service.MzUpdateComponentService r1 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.service.MzUpdateComponentService r3 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.service.MzUpdateComponentService$NetworkStatusReceiver r3 = r3.f16315f
                android.content.IntentFilter r5 = new android.content.IntentFilter
                java.lang.String r8 = "android.net.conn.CONNECTIVITY_CHANGE"
                r5.<init>(r8)
                r1.registerReceiver(r3, r5)
            L_0x0101:
                com.meizu.update.service.MzUpdateComponentService r1 = com.meizu.update.service.MzUpdateComponentService.this
                java.lang.String r1 = com.meizu.update.p083a.FileCacheHelper.m17538c((android.content.Context) r1)
                java.lang.String r3 = "download_root_path"
                boolean r3 = r0.containsKey(r3)
                if (r3 == 0) goto L_0x0117
                java.lang.String r1 = "download_root_path"
                java.lang.String r0 = r0.getString(r1)
                r8 = r0
                goto L_0x0118
            L_0x0117:
                r8 = r1
            L_0x0118:
                com.meizu.update.service.MzUpdateComponentService r5 = com.meizu.update.service.MzUpdateComponentService.this
                r10 = 0
                r9 = r4
                r5.m17842a((com.meizu.update.UpdateInfo) r6, (com.meizu.update.iresponse.MzUpdateResponse) r7, (java.lang.String) r8, (boolean) r9, (boolean) r10)
                if (r4 != 0) goto L_0x012c
                com.meizu.update.service.MzUpdateComponentService r0 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.service.MzUpdateComponentService r1 = com.meizu.update.service.MzUpdateComponentService.this
                com.meizu.update.service.MzUpdateComponentService$NetworkStatusReceiver r1 = r1.f16315f
                r0.unregisterReceiver(r1)
            L_0x012c:
                com.meizu.update.util.UpdateProcessMutexHelper.m17951a(r2)
            L_0x012f:
                com.meizu.update.service.MzUpdateComponentService r0 = com.meizu.update.service.MzUpdateComponentService.this
                int r12 = r12.arg1
                r0.stopSelf(r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.service.MzUpdateComponentService.C3031a.handleMessage(android.os.Message):void");
        }
    }

    private class NetworkStatusReceiver extends BroadcastReceiver {
        private NetworkStatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (Utility.m17992k(context) && MzUpdateComponentService.this.f16311b != null) {
                Loger.m17943d("NetWork changes to MobileData , try to cancel download!");
                MzUpdateComponentService.this.f16311b.mo24708a();
                StateManager.m17775c(6);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        Loger.m17943d("onCreate");
        HandlerThread handlerThread = new HandlerThread("MzUpdateComponentService[InternalTread]");
        handlerThread.start();
        this.f16312c = handlerThread.getLooper();
        this.f16313d = new C3031a(this.f16312c);
        this.f16314e = new Handler(getMainLooper());
    }

    public void onDestroy() {
        super.onDestroy();
        Loger.m17943d("onDestroy");
        this.f16312c.quit();
        stopForeground(true);
    }

    public void onTaskRemoved(Intent intent) {
        Loger.m17941b("onTaskRemoved");
        new NotifyManager(this, (UpdateInfo) null).mo24845f();
        super.onTaskRemoved(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Loger.m17941b("onStartCommand");
        if (Build.VERSION.SDK_INT >= 26) {
            Loger.m17941b("MzUpdateComponentService start foreground");
            startForeground(-2147483647, new NotifyManager(this, (UpdateInfo) null).mo24854o());
        }
        try {
            m17840a(intent, i2);
            return 2;
        } catch (Exception e) {
            Loger.m17943d("handleCommand Exception reason : " + e.getMessage());
            stopSelf(i2);
            return 2;
        }
    }

    /* renamed from: a */
    private void m17840a(Intent intent, int i) {
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            if (extras.containsKey("action")) {
                int i2 = extras.getInt("action");
                Loger.m17942c("handle command : " + i2);
                if (m17853a(i2)) {
                    Loger.m17943d("Request too fast, skip action: " + i2);
                    return;
                }
                switch (i2) {
                    case 0:
                        m17841a((UpdateInfo) extras.getParcelable("update_info"));
                        m17833a(0, intent, i);
                        return;
                    case 1:
                        m17833a(1, intent, i);
                        return;
                    case 2:
                        m17833a(2, intent, i);
                        return;
                    case 3:
                        m17833a(3, intent, i);
                        return;
                    case 4:
                        m17864c((UpdateInfo) extras.getParcelable("update_info"));
                        m17833a(0, intent, i);
                        return;
                    case 5:
                        m17869d((UpdateInfo) extras.getParcelable("update_info"));
                        m17833a(0, intent, i);
                        return;
                    case 7:
                        m17871e((UpdateInfo) extras.getParcelable("update_info"));
                        m17833a(0, intent, i);
                        return;
                    case 8:
                        m17874f((UpdateInfo) extras.getParcelable("update_info"));
                        m17833a(0, intent, i);
                        return;
                    case 9:
                        m17856b();
                        m17833a(0, intent, i);
                        return;
                    case 10:
                        m17833a(4, intent, i);
                        return;
                    case 11:
                        UpdateInfo generateNoUpdateInfo = UpdateInfo.generateNoUpdateInfo();
                        generateNoUpdateInfo.mPackageName = getPackageName();
                        generateNoUpdateInfo.mVersionName = Utility.m17970b((Context) this, getPackageName());
                        m17858b(generateNoUpdateInfo);
                        m17833a(5, intent, i);
                        return;
                    case 12:
                        m17875g((UpdateInfo) extras.getParcelable("update_info"));
                        m17833a(0, intent, i);
                        return;
                    case 13:
                        m17846a((UpdateInfo) extras.getParcelable("update_info"), extras.getBoolean("notify_is_silent"));
                        m17833a(0, intent, i);
                        return;
                    case 14:
                        m17833a(5, intent, i);
                        return;
                    case 15:
                        m17833a(6, intent, i);
                        return;
                    case 16:
                        sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                        new NotifyManager(this, (UpdateInfo) null).mo24845f();
                        if (Utility.m17991j(this)) {
                            m17833a(1, intent, i);
                            return;
                        }
                        UpdateDialogActivityWrapper.m17717a(this, (UpdateInfo) extras.getParcelable("update_info"), 3);
                        m17833a(0, intent, i);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m17853a(int i) {
        if (i != 7 && i != 4 && i != 8 && i != 5 && i != 12) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - f16310a < 500) {
            return true;
        }
        f16310a = SystemClock.elapsedRealtime();
        return false;
    }

    /* renamed from: a */
    private void m17833a(int i, Intent intent, int i2) {
        this.f16313d.sendMessage(this.f16313d.obtainMessage(i, i2, 0, intent));
    }

    /* renamed from: a */
    private static void m17835a(Context context, Intent intent) {
        if (context == null || intent == null) {
            Loger.m17943d("MzUpdateComponentService startService return");
        } else if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* renamed from: a */
    public static final void m17834a(Context context) {
        Loger.m17940b(context, "Handle push msg");
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 3);
        m17835a(context, intent);
    }

    /* renamed from: b */
    public static final void m17857b(Context context) {
        Loger.m17940b(context, "Request push register");
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 10);
        m17835a(context, intent);
    }

    /* renamed from: a */
    public static final void m17836a(Context context, UpdateInfo updateInfo, MzUpdateResponse mzUpdateResponse) {
        m17837a(context, updateInfo, mzUpdateResponse, (String) null, true);
    }

    /* renamed from: a */
    public static final void m17837a(Context context, UpdateInfo updateInfo, MzUpdateResponse mzUpdateResponse, String str, boolean z) {
        Intent b = m17855b(context, updateInfo, false);
        if (mzUpdateResponse != null) {
            b.putExtra(UxipConstants.PREFERENCES_KEY_RESPONSE, mzUpdateResponse);
        }
        if (!TextUtils.isEmpty(str)) {
            b.putExtra("download_root_path", str);
        }
        b.putExtra("should_notify", z);
        m17835a(context, b);
    }

    /* renamed from: b */
    private static final Intent m17855b(Context context, UpdateInfo updateInfo, boolean z) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 1);
        intent.putExtra("update_info", updateInfo);
        if (z) {
            intent.putExtra("from_notification", true);
        }
        return intent;
    }

    /* renamed from: a */
    public static final PendingIntent m17827a(Context context, UpdateInfo updateInfo) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 16);
        intent.putExtra("update_info", updateInfo);
        return m17826a(context, 1, intent);
    }

    /* renamed from: a */
    private static final Intent m17830a(Context context, UpdateInfo updateInfo, String str, MzUpdateResponse mzUpdateResponse, boolean z, boolean z2) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 2);
        intent.putExtra("update_info", updateInfo);
        intent.putExtra("apk_path", str);
        intent.putExtra("should_notify", z2);
        if (mzUpdateResponse != null) {
            intent.putExtra(UxipConstants.PREFERENCES_KEY_RESPONSE, mzUpdateResponse);
        }
        if (z) {
            intent.putExtra("from_notification", true);
        }
        return intent;
    }

    /* renamed from: a */
    public static final void m17838a(Context context, UpdateInfo updateInfo, String str, MzUpdateResponse mzUpdateResponse) {
        m17839a(context, updateInfo, str, mzUpdateResponse, true);
    }

    /* renamed from: a */
    public static final void m17839a(Context context, UpdateInfo updateInfo, String str, MzUpdateResponse mzUpdateResponse, boolean z) {
        m17835a(context, m17830a(context, updateInfo, str, mzUpdateResponse, false, z));
    }

    /* renamed from: a */
    public static final PendingIntent m17828a(Context context, UpdateInfo updateInfo, String str) {
        return m17826a(context, 2, m17830a(context, updateInfo, str, (MzUpdateResponse) null, true, true));
    }

    /* renamed from: b */
    public static final PendingIntent m17854b(Context context, UpdateInfo updateInfo) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 4);
        intent.putExtra("update_info", updateInfo);
        return m17826a(context, 4, intent);
    }

    /* renamed from: c */
    public static final PendingIntent m17861c(Context context, UpdateInfo updateInfo) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 5);
        intent.putExtra("update_info", updateInfo);
        return m17826a(context, 5, intent);
    }

    /* renamed from: a */
    public static final PendingIntent m17829a(Context context, UpdateInfo updateInfo, boolean z) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 13);
        intent.putExtra("update_info", updateInfo);
        intent.putExtra("notify_is_silent", z);
        return m17826a(context, 13, intent);
    }

    /* renamed from: d */
    public static final PendingIntent m17866d(Context context, UpdateInfo updateInfo) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 7);
        intent.putExtra("update_info", updateInfo);
        return m17826a(context, 7, intent);
    }

    /* renamed from: e */
    public static final PendingIntent m17870e(Context context, UpdateInfo updateInfo) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 8);
        intent.putExtra("update_info", updateInfo);
        return m17826a(context, 8, intent);
    }

    /* renamed from: c */
    public static final void m17863c(Context context) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 9);
        m17835a(context, intent);
    }

    /* renamed from: d */
    public static final void m17868d(Context context) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 14);
        m17835a(context, intent);
    }

    /* renamed from: f */
    public static final PendingIntent m17873f(Context context, UpdateInfo updateInfo) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 11);
        intent.putExtra("update_info", updateInfo);
        return m17826a(context, 11, intent);
    }

    /* renamed from: a */
    private static final PendingIntent m17826a(Context context, int i, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            return PendingIntent.getForegroundService(context, i, intent, 134217728);
        }
        return PendingIntent.getService(context, i, intent, 134217728);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17832a() {
        String str;
        if (!Utility.m17983e()) {
            PowerManager powerManager = (PowerManager) getSystemService(ARResourceKey.HTTP_POWER);
            PowerManager.WakeLock newWakeLock = powerManager != null ? powerManager.newWakeLock(1, "MzUpdateComponent[PushCheck]") : null;
            if (newWakeLock != null) {
                Loger.m17938a(this, "acquire wake lock for push check.");
                newWakeLock.acquire();
            }
            try {
                Loger.m17938a(this, "onPushUpdate check...");
                long elapsedRealtime = SystemClock.elapsedRealtime();
                UpdateInfo updateInfo = null;
                HttpLoadException dVar = null;
                int i = 3;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0 || SystemClock.elapsedRealtime() - elapsedRealtime > 60000) {
                        break;
                    }
                    Loger.m17938a(this, "start check try:" + i2);
                    try {
                        updateInfo = ServerManager.m17694b(this, getPackageName());
                    } catch (HttpLoadException e) {
                        dVar = e;
                    }
                    if (updateInfo != null) {
                        break;
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException unused) {
                    }
                    i = i2;
                }
                UpdateInfo updateInfo2 = updateInfo;
                MzucPushUsageCollector aVar = new MzucPushUsageCollector(this);
                if (updateInfo2 != null) {
                    Loger.m17938a(this, "push update check end:" + updateInfo2.mExistsUpdate);
                    if (updateInfo2.mExistsUpdate) {
                        StateManager.m17775c(3);
                        if (UpdatePushManager.m17821c(this, updateInfo2.mVersionName)) {
                            Loger.m17943d("on push while version skip: " + updateInfo2.mVersionName);
                            aVar.mo24819d("Version skip: " + updateInfo2.mVersionName);
                        } else if (!Utility.m17991j(this) || Utility.m17994m(this) <= 15) {
                            aVar.mo24817b("New Version: " + updateInfo2.mVersionName);
                            m17841a(updateInfo2);
                            Loger.m17943d("onPush: Condition of silent downloading is not satisfied: isWifiActive : " + Utility.m17991j(this) + " Current Battery percentage :" + Utility.m17994m(this) + "notify to update!");
                        } else {
                            aVar.mo24818c("New Version: " + updateInfo2.mVersionName);
                            m17842a(updateInfo2, (MzUpdateResponse) null, FileCacheHelper.m17538c((Context) this), false, true);
                            Loger.m17943d("onPush: Condition of silent downloading is satisfied : Start download");
                        }
                    } else {
                        Loger.m17942c("on push while no update!");
                        StateManager.m17775c(2);
                        FileCacheHelper.m17529a((Context) this);
                        aVar.mo24816a("No update!");
                    }
                } else {
                    StateManager.m17775c(2);
                    if (dVar == null) {
                        dVar = new HttpLoadException("Unknown Exception!");
                    }
                    aVar.mo24815a(dVar.mo24874b() ? dVar.mo24873a() : 100000, dVar.getMessage());
                    Loger.m17938a(this, "push update check return null");
                }
            } finally {
                if (newWakeLock != null) {
                    newWakeLock.release();
                    StringBuilder sb = new StringBuilder();
                    str = "wake lock state after release:";
                    sb.append(str);
                    sb.append(newWakeLock.isHeld());
                    Loger.m17938a(this, sb.toString());
                }
            }
        }
    }

    /* renamed from: a */
    private void m17841a(UpdateInfo updateInfo) {
        if (updateInfo != null) {
            new NotifyManager(this, updateInfo).mo24835a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17850a(PluginUpdateInfo pluginUpdateInfo, MzUpdateResponse mzUpdateResponse) {
        if (pluginUpdateInfo != null) {
            FileCacheHelper.m17531a(this, pluginUpdateInfo.mPluginPackageName, pluginUpdateInfo.mVersionName, pluginUpdateInfo.mPluginType);
            String b = FileCacheHelper.m17534b(this, pluginUpdateInfo.mPluginPackageName, pluginUpdateInfo.mVersionName, pluginUpdateInfo.mPluginType);
            if (new File(b).exists()) {
                Loger.m17942c("pluginFile exists!");
                m17851a(pluginUpdateInfo, b, mzUpdateResponse);
                return;
            }
            String a = FileCacheHelper.m17526a(this, pluginUpdateInfo.mPluginPackageName, pluginUpdateInfo.mVersionName);
            Downloader bVar = new Downloader(pluginUpdateInfo.mUpdateUrl, a, (List<Pair<String, String>>) null, (List<Pair<String, String>>) null);
            DownloadRetryTracker bVar2 = new DownloadRetryTracker(5);
            bVar2.mo24736a(pluginUpdateInfo.mUpdateUrl2);
            this.f16311b = new RetryDownloader(this, pluginUpdateInfo.mUpdateUrl, bVar, bVar2);
            this.f16311b.mo24709a((IFileChecker) mo24822a((Context) this, pluginUpdateInfo));
            try {
                if (this.f16311b.mo24710a((Context) this)) {
                    if (FileCacheHelper.m17541d(a, b)) {
                        m17851a(pluginUpdateInfo, b, mzUpdateResponse);
                        return;
                    }
                    Loger.m17943d("plugin file can't rename!");
                    File file = new File(a);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } catch (CancelException unused) {
                if (mzUpdateResponse != null) {
                    mzUpdateResponse.mo24802b();
                    return;
                }
                return;
            } catch (LoadException e) {
                e.printStackTrace();
            }
            if (mzUpdateResponse != null) {
                mzUpdateResponse.mo24802b();
            }
            Loger.m17943d("DownLoad Failed!");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17842a(UpdateInfo updateInfo, MzUpdateResponse mzUpdateResponse, String str, final boolean z, boolean z2) {
        if (updateInfo != null) {
            final NotifyManager aVar = new NotifyManager(this, updateInfo);
            FileCacheHelper.m17532a(str, updateInfo.mVersionName);
            String b = FileCacheHelper.m17536b(str, updateInfo.mVersionName);
            if (Utility.m17977c(this, b)) {
                aVar.mo24845f();
                if (z2) {
                    m17843a(updateInfo, b);
                } else {
                    m17844a(updateInfo, b, mzUpdateResponse, !z);
                }
                StateManager.m17775c(5);
                return;
            }
            File file = new File(b);
            if (file.exists()) {
                file.delete();
            }
            if (z) {
                aVar.mo24836a(0, 0);
            }
            String c = FileCacheHelper.m17539c(str, updateInfo.mVersionName);
            Downloader bVar = new Downloader(updateInfo.mUpdateUrl, c, (List<Pair<String, String>>) null, (List<Pair<String, String>>) null);
            bVar.mo24712a((Downloader.C2981a) new Downloader.C2981a() {
                /* renamed from: a */
                public void mo24717a(int i, long j) {
                    if (z) {
                        aVar.mo24836a(i, j);
                    }
                    StateManager.m17776d(i);
                }
            });
            DownloadRetryTracker bVar2 = new DownloadRetryTracker(5);
            bVar2.mo24736a(updateInfo.mUpdateUrl2);
            this.f16311b = new RetryDownloader(this, updateInfo.mUpdateUrl, bVar, bVar2);
            this.f16311b.mo24709a((IFileChecker) mo24823g(this, updateInfo));
            try {
                StateManager.m17775c(4);
                if (this.f16311b.mo24710a((Context) this)) {
                    String packageName = getPackageName();
                    PackageInfo d = Utility.m17978d(this, c);
                    if (!TextUtils.isEmpty(packageName) && d != null && !packageName.equalsIgnoreCase(d.packageName)) {
                        VerifyUsageCollector.m17923a((Context) this).mo24863a(packageName, d.packageName);
                    }
                    if (!Utility.m17977c(this, c) || !FileCacheHelper.m17541d(c, b)) {
                        Loger.m17943d("download apk cant parse or rename!");
                        File file2 = new File(c);
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } else {
                        aVar.mo24845f();
                        StateManager.m17775c(5);
                        if (z2) {
                            m17843a(updateInfo, b);
                            return;
                        } else {
                            m17844a(updateInfo, b, mzUpdateResponse, !z);
                            return;
                        }
                    }
                }
            } catch (CancelException unused) {
                aVar.mo24845f();
                if (mzUpdateResponse != null) {
                    mzUpdateResponse.mo24802b();
                    return;
                }
                return;
            } catch (LoadException e) {
                e.printStackTrace();
            }
            if (mzUpdateResponse != null) {
                mzUpdateResponse.mo24802b();
            }
            Loger.m17943d("DownLoad Failed!");
            UpdateUsageCollector.m17913a(this).mo24855a(UpdateUsageCollector.UpdateAction.Download_Failure, updateInfo.mVersionName);
            if (z) {
                aVar.mo24841c();
            }
            StateManager.m17775c(6);
        } else if (mzUpdateResponse != null) {
            mzUpdateResponse.mo24800a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public DownloadFileChecker mo24823g(Context context, UpdateInfo updateInfo) {
        return new DownloadFileChecker(context, updateInfo.mVerifyMode, context.getPackageName(), updateInfo.mSizeByte, updateInfo.mDigest, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public PluginFileChecker mo24822a(Context context, PluginUpdateInfo pluginUpdateInfo) {
        return new PluginFileChecker(context, pluginUpdateInfo.mVerifyMode, pluginUpdateInfo.mSizeByte, pluginUpdateInfo.mDigest);
    }

    /* renamed from: a */
    private void m17844a(final UpdateInfo updateInfo, final String str, MzUpdateResponse mzUpdateResponse, final boolean z) {
        if (mzUpdateResponse != null) {
            mzUpdateResponse.mo24801a(str);
        } else if (!m17872e((Context) this)) {
            Context a = ComponentTrackerImpl.m17519a();
            if (a != null) {
                Loger.m17943d("start dialog for tracker : " + a);
                final boolean z2 = z;
                final Context context = a;
                final UpdateInfo updateInfo2 = updateInfo;
                final String str2 = str;
                m17852a((Runnable) new Runnable() {
                    public void run() {
                        boolean z = false;
                        DisplayBase eVar = z2 ? new UdResultDisplayManager(context, updateInfo2, str2, false) : new InstallDisplayManager(context, (UpdateEndListener) null, updateInfo2, str2);
                        if (!(context instanceof Activity)) {
                            z = true;
                        }
                        eVar.mo24763a(z);
                        eVar.mo24764b();
                    }
                });
                return;
            }
            m17845a(updateInfo, str, mzUpdateResponse, false, !z);
        } else if (ForegroundUtil.m17932a(this)) {
            Loger.m17943d("start system dialog for : " + getPackageName());
            m17852a((Runnable) new Runnable() {
                public void run() {
                    DisplayBase eVar = z ? new UdResultDisplayManager(MzUpdateComponentService.this.getApplicationContext(), updateInfo, str, true) : new InstallDisplayManager(MzUpdateComponentService.this.getApplicationContext(), (UpdateEndListener) null, updateInfo, str);
                    eVar.mo24763a(true);
                    eVar.mo24764b();
                }
            });
        } else {
            m17845a(updateInfo, str, mzUpdateResponse, false, !z);
        }
    }

    /* renamed from: a */
    private void m17851a(PluginUpdateInfo pluginUpdateInfo, String str, MzUpdateResponse mzUpdateResponse) {
        if (mzUpdateResponse != null) {
            mzUpdateResponse.mo24801a(str);
        } else {
            Loger.m17943d("Response is null, skip!!");
        }
    }

    /* renamed from: a */
    private void m17843a(UpdateInfo updateInfo, String str) {
        if (updateInfo != null) {
            new NotifyManager(this, updateInfo).mo24842c(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17859b(UpdateInfo updateInfo, String str, MzUpdateResponse mzUpdateResponse, boolean z) {
        if (updateInfo != null && !TextUtils.isEmpty(str)) {
            m17845a(updateInfo, str, mzUpdateResponse, true, z);
        } else if (mzUpdateResponse != null) {
            mzUpdateResponse.mo24804d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17845a(com.meizu.update.UpdateInfo r9, java.lang.String r10, com.meizu.update.iresponse.MzUpdateResponse r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "start install , should notify is "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.meizu.update.util.Loger.m17941b(r0)
            r0 = 8
            com.meizu.update.p091e.StateManager.m17775c(r0)
            com.meizu.update.service.a r4 = new com.meizu.update.service.a
            r4.<init>(r8, r9)
            android.content.pm.PackageManager r0 = r8.getPackageManager()
            java.lang.String r1 = "android.permission.INSTALL_PACKAGES"
            java.lang.String r2 = r8.getPackageName()
            int r0 = r0.checkPermission(r1, r2)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            r3 = 9
            if (r0 == 0) goto L_0x00a6
            java.lang.String r0 = r8.getPackageName()
            boolean r0 = com.meizu.update.util.Utility.m17984e(r8, r0)
            if (r0 == 0) goto L_0x00a6
            if (r13 == 0) goto L_0x0049
            r4.mo24840b()
            com.meizu.update.p090d.AppRestartManager.m17699a(r8, r9)
        L_0x0049:
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r0 < r5) goto L_0x0054
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.m17778a(r8, r10)
            goto L_0x0058
        L_0x0054:
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.m17784b(r8, r10)
        L_0x0058:
            com.meizu.update.install.InstallHelper$InstallStatus r5 = com.meizu.update.install.InstallHelper.InstallStatus.SUCCESS
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0079
            com.meizu.update.usage.UpdateUsageCollector r0 = com.meizu.update.usage.UpdateUsageCollector.m17913a(r8)
            com.meizu.update.usage.UpdateUsageCollector$UpdateAction r5 = com.meizu.update.usage.UpdateUsageCollector.UpdateAction.Install_Complete
            java.lang.String r6 = r9.mVersionName
            r0.mo24855a(r5, r6)
            if (r13 == 0) goto L_0x0070
            r4.mo24844e()
        L_0x0070:
            if (r11 == 0) goto L_0x0075
            r11.mo24803c()
        L_0x0075:
            com.meizu.update.p091e.StateManager.m17775c(r2)
            goto L_0x00a1
        L_0x0079:
            com.meizu.update.install.InstallHelper$InstallStatus r5 = com.meizu.update.install.InstallHelper.InstallStatus.FAILED
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x00a3
            com.meizu.update.usage.UpdateUsageCollector r0 = com.meizu.update.usage.UpdateUsageCollector.m17913a(r8)
            com.meizu.update.usage.UpdateUsageCollector$UpdateAction r5 = com.meizu.update.usage.UpdateUsageCollector.UpdateAction.Install_Failure
            java.lang.String r6 = r9.mVersionName
            java.lang.String r7 = r8.getPackageName()
            java.lang.String r7 = com.meizu.update.util.Utility.m17970b((android.content.Context) r8, (java.lang.String) r7)
            r0.mo24856a(r5, r6, r7)
            if (r13 == 0) goto L_0x0099
            r4.mo24843d()
        L_0x0099:
            if (r11 == 0) goto L_0x009e
            r11.mo24804d()
        L_0x009e:
            com.meizu.update.p091e.StateManager.m17775c(r3)
        L_0x00a1:
            r0 = 1
            goto L_0x00a7
        L_0x00a3:
            r4.mo24845f()
        L_0x00a6:
            r0 = 0
        L_0x00a7:
            if (r0 != 0) goto L_0x0101
            if (r13 == 0) goto L_0x00ae
            r4.mo24840b()
        L_0x00ae:
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.m17779a((android.content.Context) r8, (java.lang.String) r10, (boolean) r13)
            com.meizu.update.install.InstallHelper$InstallStatus r5 = com.meizu.update.install.InstallHelper.InstallStatus.SUCCESS
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00d3
            com.meizu.update.usage.UpdateUsageCollector r0 = com.meizu.update.usage.UpdateUsageCollector.m17913a(r8)
            com.meizu.update.usage.UpdateUsageCollector$UpdateAction r3 = com.meizu.update.usage.UpdateUsageCollector.UpdateAction.Install_Complete
            java.lang.String r5 = r9.mVersionName
            r0.mo24855a(r3, r5)
            if (r13 == 0) goto L_0x00ca
            r4.mo24844e()
        L_0x00ca:
            if (r11 == 0) goto L_0x00cf
            r11.mo24803c()
        L_0x00cf:
            com.meizu.update.p091e.StateManager.m17775c(r2)
            goto L_0x00fb
        L_0x00d3:
            com.meizu.update.install.InstallHelper$InstallStatus r5 = com.meizu.update.install.InstallHelper.InstallStatus.FAILED
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x00fd
            com.meizu.update.usage.UpdateUsageCollector r0 = com.meizu.update.usage.UpdateUsageCollector.m17913a(r8)
            com.meizu.update.usage.UpdateUsageCollector$UpdateAction r2 = com.meizu.update.usage.UpdateUsageCollector.UpdateAction.Install_Failure
            java.lang.String r5 = r9.mVersionName
            java.lang.String r6 = r8.getPackageName()
            java.lang.String r6 = com.meizu.update.util.Utility.m17970b((android.content.Context) r8, (java.lang.String) r6)
            r0.mo24856a(r2, r5, r6)
            if (r13 == 0) goto L_0x00f3
            r4.mo24843d()
        L_0x00f3:
            if (r11 == 0) goto L_0x00f8
            r11.mo24804d()
        L_0x00f8:
            com.meizu.update.p091e.StateManager.m17775c(r3)
        L_0x00fb:
            r0 = 1
            goto L_0x0101
        L_0x00fd:
            r4.mo24845f()
            r0 = 0
        L_0x0101:
            if (r0 != 0) goto L_0x0147
            r13 = 10
            com.meizu.update.p091e.StateManager.m17775c(r13)
            if (r11 == 0) goto L_0x010e
            r11.mo24806e()
            goto L_0x0147
        L_0x010e:
            android.content.Context r3 = com.meizu.update.ComponentTrackerImpl.m17519a()
            if (r3 == 0) goto L_0x0135
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "start system install for tracker : "
            r11.append(r12)
            r11.append(r3)
            java.lang.String r11 = r11.toString()
            com.meizu.update.util.Loger.m17943d(r11)
            com.meizu.update.service.MzUpdateComponentService$4 r11 = new com.meizu.update.service.MzUpdateComponentService$4
            r1 = r11
            r2 = r8
            r5 = r10
            r6 = r9
            r1.<init>(r3, r4, r5, r6)
            r8.m17852a((java.lang.Runnable) r11)
            goto L_0x0147
        L_0x0135:
            if (r12 != 0) goto L_0x013b
            r4.mo24837a((java.lang.String) r10)
            goto L_0x0147
        L_0x013b:
            android.content.Intent r9 = com.meizu.update.install.InstallHelper.m17786c(r8, r10)
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            r9.addFlags(r10)
            r8.startActivity(r9)
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.service.MzUpdateComponentService.m17845a(com.meizu.update.UpdateInfo, java.lang.String, com.meizu.update.iresponse.MzUpdateResponse, boolean, boolean):void");
    }

    /* renamed from: b */
    private void m17858b(UpdateInfo updateInfo) {
        if (updateInfo != null) {
            StateManager.m17775c(0);
            UpdateUsageCollector.m17913a(this).mo24855a(UpdateUsageCollector.UpdateAction.Install_Complete, updateInfo.mVersionName);
            new NotifyManager(this, updateInfo).mo24844e();
            return;
        }
        Loger.m17943d("notifyUpdateFinish info null");
    }

    /* renamed from: c */
    private void m17864c(UpdateInfo updateInfo) {
        if (updateInfo != null) {
            UpdateDialogActivityWrapper.m17717a(this, updateInfo, 4);
        }
    }

    /* renamed from: d */
    private void m17869d(UpdateInfo updateInfo) {
        if (updateInfo != null) {
            UpdateDialogActivityWrapper.m17717a(this, updateInfo, 3);
        }
    }

    /* renamed from: a */
    private void m17846a(UpdateInfo updateInfo, boolean z) {
        if (updateInfo != null) {
            new NotifyManager(this, updateInfo).mo24845f();
        }
        if (z) {
            UpdateUsageCollector.m17913a(this).mo24856a(UpdateUsageCollector.UpdateAction.Install_No, updateInfo.mVersionName, Utility.m17970b((Context) this, getPackageName()));
        } else {
            UpdateUsageCollector.m17913a(this).mo24856a(UpdateUsageCollector.UpdateAction.UpdateAlert_No, updateInfo.mVersionName, Utility.m17970b((Context) this, getPackageName()));
        }
        UpdatePushManager.m17825f(this, updateInfo.mVersionName);
    }

    /* renamed from: e */
    private void m17871e(UpdateInfo updateInfo) {
        if (updateInfo != null) {
            UpdateDialogActivityWrapper.m17717a(this, updateInfo, 1);
        }
    }

    /* renamed from: f */
    private void m17874f(UpdateInfo updateInfo) {
        if (updateInfo != null) {
            UpdateDialogActivityWrapper.m17717a(this, updateInfo, 2);
        }
    }

    /* renamed from: b */
    private void m17856b() {
        new NotifyManager(this, (UpdateInfo) null).mo24845f();
        if (this.f16311b != null) {
            this.f16311b.mo24708a();
            StateManager.m17775c(7);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17862c() {
        String pushId = PushManager.getPushId(this);
        if (TextUtils.isEmpty(pushId)) {
            return;
        }
        if (ServerManager.m17697c(this, pushId)) {
            UpdatePushManager.m17814a((Context) this, true);
        } else {
            Loger.m17943d("register push error.");
        }
    }

    /* renamed from: a */
    private void m17852a(Runnable runnable) {
        this.f16314e.post(runnable);
    }

    /* renamed from: e */
    private static boolean m17872e(Context context) {
        if (context == null) {
            Loger.m17942c("canCheckAppRunningForeground context is null");
            return false;
        } else if (!Utility.m17984e(context, context.getPackageName())) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: g */
    private void m17875g(UpdateInfo updateInfo) {
        UpdateDialogActivityWrapper.m17717a(this, updateInfo, 5);
    }

    /* renamed from: h */
    public static final PendingIntent m17876h(Context context, UpdateInfo updateInfo) {
        Intent intent = new Intent(context, MzUpdateComponentService.class);
        intent.putExtra("action", 12);
        intent.putExtra("update_info", updateInfo);
        return m17826a(context, 12, intent);
    }
}
