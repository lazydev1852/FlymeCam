package com.meizu.media.camera.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.p001os.IPowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Size;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.core.p005os.EnvironmentCompat;
import com.android.p012ex.camera2.portability.p015b.SystemProperties;
import com.baidu.p020ar.parser.ARResourceKey;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.savior.SaviorJobService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Locale;

/* renamed from: com.meizu.media.camera.util.o */
public class DeviceUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14266a;

    /* renamed from: b */
    private static LogUtil.C2630a f14267b = new LogUtil.C2630a("DeviceUtil");

    /* renamed from: c */
    private static Field f14268c;

    /* renamed from: d */
    private static int f14269d = -1;

    /* renamed from: e */
    private static int f14270e;

    /* renamed from: a */
    public static boolean m16197a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f14266a, true, 8001, new Class[]{Context.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (context.getSharedPreferences(context.getPackageName(), 0).getInt(SaviorJobService.CTA_PERMISSION, 0) != 0) {
            return false;
        }
        return !m16196a();
    }

    /* renamed from: a */
    public static String m16190a(String str, String str2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, f14266a, true, 8002, new Class[]{String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            return (String) C2634am.m15995a("android.os.SystemProperties", "get", (Class<?>[]) new Class[]{String.class, String.class}, new Object[]{str, EnvironmentCompat.MEDIA_UNKNOWN});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m16196a() {
        /*
            java.lang.Class<com.meizu.media.camera.util.o> r0 = com.meizu.media.camera.util.DeviceUtil.class
            monitor-enter(r0)
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0064 }
            r3 = 0
            com.meizu.savior.ChangeQuickRedirect r4 = f14266a     // Catch:{ all -> 0x0064 }
            r5 = 1
            r6 = 8003(0x1f43, float:1.1215E-41)
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch:{ all -> 0x0064 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0064 }
            com.meizu.savior.PatchProxyResult r2 = com.meizu.savior.PatchProxy.proxy(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0064 }
            boolean r3 = r2.isSupported     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x0022
            java.lang.Object r1 = r2.result     // Catch:{ all -> 0x0064 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0064 }
            monitor-exit(r0)
            return r1
        L_0x0022:
            int r2 = f14269d     // Catch:{ all -> 0x0064 }
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x005d
            java.lang.String r2 = "ro.product.locale.language"
            java.lang.String r3 = "null"
            java.lang.String r2 = m16190a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "zh"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0048
            java.lang.String r2 = "ro.product.locale.region"
            java.lang.String r3 = "null"
            java.lang.String r2 = m16190a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "CN"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x005b
        L_0x0048:
            java.lang.String r2 = "ro.product.locale"
            java.lang.String r3 = "null"
            java.lang.String r2 = m16190a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "zh-CN"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x005b
            f14269d = r4     // Catch:{ all -> 0x0064 }
            goto L_0x005d
        L_0x005b:
            f14269d = r1     // Catch:{ all -> 0x0064 }
        L_0x005d:
            int r2 = f14269d     // Catch:{ all -> 0x0064 }
            if (r2 != r4) goto L_0x0062
            r1 = 1
        L_0x0062:
            monitor-exit(r0)
            return r1
        L_0x0064:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.DeviceUtil.m16196a():boolean");
    }

    /* renamed from: b */
    public static int m16199b(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f14266a, true, 8004, new Class[]{Context.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        try {
            int intValue = ((Integer) C2634am.m15994a(C2634am.m15994a((Object) (DisplayManager) context.getSystemService("display"), "getWifiDisplayStatus", (Object[]) null), "getActiveDisplayState", (Object[]) null)).intValue();
            LogUtil.C2630a aVar = f14267b;
            LogUtil.m15952c(aVar, "wifiDisplay state : " + intValue);
            return intValue;
        } catch (Exception unused) {
            LogUtil.m15952c(f14267b, "exception getWifiDisplayState()");
            return 0;
        }
    }

    /* renamed from: a */
    public static void m16193a(ContentResolver contentResolver) {
        if (!PatchProxy.proxy(new Object[]{contentResolver}, (Object) null, f14266a, true, 8005, new Class[]{ContentResolver.class}, Void.TYPE).isSupported) {
            f14270e = Settings.System.getInt(contentResolver, "camera_sounds_enabled", 1);
            LogUtil.C2630a aVar = f14267b;
            LogUtil.m15952c(aVar, "sound state: " + f14270e);
        }
    }

    /* renamed from: b */
    public static boolean m16200b() {
        return f14270e == 1;
    }

    /* renamed from: c */
    public static boolean m16202c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14266a, true, 8006, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        String str = "";
        if (m16205e() >= 29) {
            str = SystemProperties.m562a("vendor.meizu.sys.cts_state", "");
        }
        if (str.isEmpty()) {
            str = SystemProperties.m562a("persist.sys.cts_state", "false");
        }
        return "true".equals(str);
    }

    /* renamed from: c */
    public static String m16201c(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f14266a, true, 8008, new Class[]{Context.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getDeviceId();
    }

    /* renamed from: d */
    public static String m16204d() {
        return Build.SERIAL;
    }

    /* renamed from: e */
    public static int m16205e() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: f */
    public static boolean m16206f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14266a, true, 8009, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return m16205e() >= 28;
    }

    /* renamed from: g */
    public static String m16207g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14266a, true, MsgConstants.IMU_IMU_OPEN, new Class[0], String.class);
        return proxy.isSupported ? (String) proxy.result : Locale.getDefault().getLanguage();
    }

    @RequiresApi(api = 21)
    /* renamed from: d */
    public static Size m16203d(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f14266a, true, 8012, new Class[]{Context.class}, Size.class);
        if (proxy.isSupported) {
            return (Size) proxy.result;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return new Size(point.x, point.y);
    }

    /* renamed from: a */
    public static void m16194a(View view, int i) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i)}, (Object) null, f14266a, true, 8013, new Class[]{View.class, Integer.TYPE}, Void.TYPE).isSupported && view != null && m16210j()) {
            LogUtil.C2630a aVar = f14267b;
            LogUtil.m15942a(aVar, "performHapticFeedback " + i);
            view.performHapticFeedback(i);
        }
    }

    /* renamed from: j */
    private static boolean m16210j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14266a, true, 8014, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            if (f14268c == null) {
                f14268c = Class.forName("flyme.config.FlymeFeature").getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
            }
            return f14268c.getBoolean((Object) null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static float m16189a(Activity activity) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity}, (Object) null, f14266a, true, 8016, new Class[]{Activity.class}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        try {
            return Settings.System.getFloat(activity.getContentResolver(), "screen_auto_brightness_adj");
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: b */
    public static int m16198b(Activity activity) {
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity}, (Object) null, f14266a, true, 8017, new Class[]{Activity.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        try {
            i = Settings.System.getInt(activity.getContentResolver(), "screen_brightness_mode");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            i = 1;
        }
        LogUtil.C2630a aVar = f14267b;
        LogUtil.m15942a(aVar, "get current screen brightness mode is " + i);
        return i;
    }

    /* renamed from: a */
    public static void m16191a(Activity activity, float f) {
        if (!PatchProxy.proxy(new Object[]{activity, new Float(f)}, (Object) null, f14266a, true, 8018, new Class[]{Activity.class, Float.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14267b;
            LogUtil.m15942a(aVar, "set screen brightness " + f);
            try {
                DisplayManager c = AndroidServices.m8287a().mo19004c();
                Class[] clsArr = {Float.TYPE};
                Object[] objArr = new Object[1];
                objArr[0] = Float.valueOf(Float.isNaN(f) ? Float.NaN : 0.3f);
                C2634am.m15993a((Object) c, "setTemporaryAutoBrightnessAdjustment", (Class<?>[]) clsArr, objArr);
            } catch (Exception e) {
                LogUtil.C2630a aVar2 = f14267b;
                LogUtil.m15949b(aVar2, "setTemporaryAutoBrightnessAdjustment by reflect failed, " + e.getMessage());
                try {
                    IPowerManager.Stub.asInterface((IBinder) C2634am.m15996a("android.os.ServiceManager", "getService", (Object[]) new String[]{ARResourceKey.HTTP_POWER})).setTemporaryScreenAutoBrightnessAdjustmentSettingOverride(f);
                } catch (Exception e2) {
                    LogUtil.C2630a aVar3 = f14267b;
                    LogUtil.m15949b(aVar3, "setAutoScreenBrightness by binder failed, " + e2.getMessage());
                } catch (NoSuchMethodError e3) {
                    LogUtil.C2630a aVar4 = f14267b;
                    LogUtil.m15949b(aVar4, "no method for setAutoScreenBrightness, " + e3.getMessage());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m16192a(Activity activity, float f, int i) {
        if (!PatchProxy.proxy(new Object[]{activity, new Float(f), new Integer(i)}, (Object) null, f14266a, true, 8019, new Class[]{Activity.class, Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14267b;
            LogUtil.m15942a(aVar, "update screen brightness " + f);
            if (i != 3) {
                switch (i) {
                    case 1:
                        m16191a(activity, f);
                        return;
                    default:
                        return;
                }
            } else {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.screenBrightness = f;
                activity.getWindow().setAttributes(attributes);
            }
        }
    }

    /* renamed from: h */
    public static float m16208h() {
        BufferedReader bufferedReader;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14266a, true, 8020, new Class[0], Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/class/meizu/pcb_temp/temp"));
            float round = ((float) Math.round((((float) Integer.parseInt(bufferedReader.readLine())) / 1000.0f) * 10.0f)) / 10.0f;
            bufferedReader.close();
            return round;
        } catch (Exception e) {
            LogUtil.C2630a aVar = f14267b;
            LogUtil.m15949b(aVar, "get temperature failed: " + e.getMessage());
            return 0.0f;
        } catch (Throwable th) {
            r1.addSuppressed(th);
        }
        throw th;
    }

    /* renamed from: i */
    public static boolean m16209i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14266a, true, 8021, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    /* renamed from: a */
    public static void m16195a(RuntimeException runtimeException) {
        if (!PatchProxy.proxy(new Object[]{runtimeException}, (Object) null, f14266a, true, 8022, new Class[]{RuntimeException.class}, Void.TYPE).isSupported) {
            LogUtil.m15949b(f14267b, "FATAL EXCEPTION :");
            if (!"VERBOSE".equals(SystemProperties.m562a("log.tag.MzCam_ErrorLog", (String) null))) {
                runtimeException.printStackTrace();
                Process.killProcess(Process.myPid());
                return;
            }
            throw runtimeException;
        }
    }
}
