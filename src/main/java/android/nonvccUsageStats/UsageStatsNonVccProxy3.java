package android.nonvccUsageStats;

import android.content.Context;
import android.nonvccUsageStats.INonVccStatsInterfaces;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class UsageStatsNonVccProxy3 {
    /* access modifiers changed from: private */
    public static String TAG = "UsageStatsNonVccProxy3";
    private static final Object lock = new Object();
    private static UsageStatsNonVccProxy3 usageStatsNonVccProxy;
    private ScheduledExecutorService executorService;
    private Context mContext;

    private UsageStatsNonVccProxy3(Context context) {
        if (context != null) {
            this.mContext = context;
            this.executorService = Executors.newSingleThreadScheduledExecutor();
            return;
        }
        throw new IllegalArgumentException("The context is null!");
    }

    /* access modifiers changed from: private */
    public INonVccStatsInterfaces getRemote() {
        try {
            Object[] objArr = {"flyme_novccusagestats"};
            Method method = Class.forName("android.os.ServiceManager").getMethod("getService", getParamsTypes(objArr));
            method.setAccessible(true);
            IBinder iBinder = (IBinder) method.invoke((Object) null, objArr);
            if (iBinder != null) {
                INonVccStatsInterfaces asInterface = INonVccStatsInterfaces.Stub.asInterface(iBinder);
                String str = TAG;
                Log.d(str, "UsageStatsNonVccProxy3 getRemote, return " + asInterface);
                return asInterface;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "UsageStatsNonVccProxy3 getRemote, return null");
        return null;
    }

    private Class<?>[] getParamsTypes(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    public static UsageStatsNonVccProxy3 getInstance(Context context) {
        if (usageStatsNonVccProxy == null) {
            synchronized (lock) {
                if (usageStatsNonVccProxy == null) {
                    usageStatsNonVccProxy = new UsageStatsNonVccProxy3(context);
                }
            }
        }
        return usageStatsNonVccProxy;
    }

    public void onOsEvent(final String str, final String str2, final Map<String, String> map) {
        String str3 = TAG;
        Log.d(str3, "onOsEvent eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (!TextUtils.isEmpty(str)) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    INonVccStatsInterfaces access$000 = UsageStatsNonVccProxy3.this.getRemote();
                    if (access$000 != null) {
                        try {
                            access$000.onOsEvent(str, str2, map);
                        } catch (RemoteException e) {
                            String access$100 = UsageStatsNonVccProxy3.TAG;
                            Log.w(access$100, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                        }
                    }
                }
            });
        }
    }

    public void onOsEventRealtime(final String str, final String str2, final Map<String, String> map) {
        String str3 = TAG;
        Log.d(str3, "onOsEventRealtime eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (!TextUtils.isEmpty(str)) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    INonVccStatsInterfaces access$000 = UsageStatsNonVccProxy3.this.getRemote();
                    if (access$000 != null) {
                        try {
                            access$000.onOsEventRealtime(str, str2, map);
                        } catch (RemoteException e) {
                            String access$100 = UsageStatsNonVccProxy3.TAG;
                            Log.w(access$100, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                        }
                    }
                }
            });
        }
    }

    public void onAppEvent(String str, String str2, Map<String, String> map, String str3) {
        String str4 = TAG;
        Log.d(str4, "onAppEvent eventName: " + str + ", pageName: " + str2 + ", properties: " + map + ", customPackageName: " + str3);
        if (!TextUtils.isEmpty(str)) {
            final String str5 = str;
            final String str6 = str2;
            final Map<String, String> map2 = map;
            final String str7 = str3;
            this.executorService.execute(new Runnable() {
                public void run() {
                    INonVccStatsInterfaces access$000 = UsageStatsNonVccProxy3.this.getRemote();
                    if (access$000 != null) {
                        try {
                            access$000.onAppEvent(str5, str6, map2, str7);
                        } catch (RemoteException e) {
                            String access$100 = UsageStatsNonVccProxy3.TAG;
                            Log.w(access$100, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                        }
                    }
                }
            });
        }
    }

    public void onAppEventRealtime(String str, String str2, Map<String, String> map, String str3) {
        String str4 = TAG;
        Log.d(str4, "onAppEventRealtime eventName: " + str + ", pageName: " + str2 + ", properties: " + map + ", customPackageName: " + str3);
        if (!TextUtils.isEmpty(str)) {
            final String str5 = str;
            final String str6 = str2;
            final Map<String, String> map2 = map;
            final String str7 = str3;
            this.executorService.execute(new Runnable() {
                public void run() {
                    INonVccStatsInterfaces access$000 = UsageStatsNonVccProxy3.this.getRemote();
                    if (access$000 != null) {
                        try {
                            access$000.onAppEventRealtime(str5, str6, map2, str7);
                        } catch (RemoteException e) {
                            String access$100 = UsageStatsNonVccProxy3.TAG;
                            Log.w(access$100, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                        }
                    }
                }
            });
        }
    }
}
