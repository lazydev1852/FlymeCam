package com.meizu.cloud.pushsdk.notification.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class NotificationUtils {
    private static final String TAG = "NotificationUtils";
    private static Object lock = new Object();
    private static Field mFlymeNotification;
    private static Field mInternalApp;
    private static Field mReplyIntent;

    static {
        try {
            mFlymeNotification = Notification.class.getDeclaredField("mFlymeNotification");
            mInternalApp = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            mInternalApp.setAccessible(true);
            mReplyIntent = Notification.class.getDeclaredField("replyIntent");
            mReplyIntent.setAccessible(true);
        } catch (NoSuchFieldException e) {
            DebugLogger.m4828e(TAG, "init NotificationUtils error " + e.getMessage());
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static void setReplyIntent(Notification notification, PendingIntent pendingIntent) {
        if (mReplyIntent != null) {
            try {
                mReplyIntent.set(notification, pendingIntent);
            } catch (IllegalAccessException e) {
                DebugLogger.m4828e(TAG, "setReplyIntent error " + e.getMessage());
            }
        }
    }

    public static void setInternalApp(Notification notification, boolean z) {
        if (mFlymeNotification != null && mInternalApp != null) {
            try {
                mInternalApp.set(mFlymeNotification.get(notification), Integer.valueOf(z ? 1 : 0));
            } catch (IllegalAccessException e) {
                DebugLogger.m4828e(TAG, "setInternalApp error " + e.getMessage());
            }
        }
    }

    public static void clearNotification(Context context, String str, int i) {
        synchronized (lock) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                DebugLogger.m4829i(TAG, "clear clearNotification notifyId " + i);
                notificationManager.cancel(i);
                Set<String> notifyIdByPackageName = PushPreferencesUtils.getNotifyIdByPackageName(context, str);
                if (notifyIdByPackageName != null) {
                    notifyIdByPackageName.remove(String.valueOf(i));
                }
                PushPreferencesUtils.putNotifyIdByPackageName(context, str, notifyIdByPackageName);
            }
        }
    }

    public static void clearAllNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public static void clearNotification(Context context, String str) {
        synchronized (lock) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null && !TextUtils.isEmpty(str)) {
                Set<String> notifyIdByPackageName = PushPreferencesUtils.getNotifyIdByPackageName(context, str);
                if (notifyIdByPackageName != null) {
                    for (String next : notifyIdByPackageName) {
                        DebugLogger.m4829i(TAG, "clear notifyId " + next + " notification");
                        notificationManager.cancel(Integer.parseInt(next));
                    }
                    notifyIdByPackageName.clear();
                }
                PushPreferencesUtils.putNotifyIdByPackageName(context, str, notifyIdByPackageName);
            }
        }
    }

    public static void storeNotifyIdByPackageName(Context context, String str, int i) {
        synchronized (lock) {
            Set notifyIdByPackageName = PushPreferencesUtils.getNotifyIdByPackageName(context, str);
            if (notifyIdByPackageName == null) {
                notifyIdByPackageName = new HashSet();
            }
            notifyIdByPackageName.add(String.valueOf(i));
            DebugLogger.m4829i(TAG, "store notifyId " + i);
            PushPreferencesUtils.putNotifyIdByPackageName(context, str, notifyIdByPackageName);
        }
    }

    public static void removeNotifyIdByPackageName(Context context, String str, int i) {
        synchronized (lock) {
            Set<String> notifyIdByPackageName = PushPreferencesUtils.getNotifyIdByPackageName(context, str);
            if (notifyIdByPackageName != null) {
                notifyIdByPackageName.remove(String.valueOf(i));
                DebugLogger.m4829i(TAG, "remove notifyId " + i);
                PushPreferencesUtils.putNotifyIdByPackageName(context, str, notifyIdByPackageName);
            }
        }
    }

    public static boolean removeNotifyKey(Context context, String str, String str2) {
        synchronized (lock) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int notifyIdByNotifyKey = PushPreferencesUtils.getNotifyIdByNotifyKey(context, str, str2);
            DebugLogger.m4828e(TAG, "removeNotifyKey " + str2 + " notifyId " + notifyIdByNotifyKey);
            removeNotifyIdByPackageName(context, str, notifyIdByNotifyKey);
            boolean removeNotifyKey = PushPreferencesUtils.removeNotifyKey(context, str, str2);
            return removeNotifyKey;
        }
    }
}
