package com.mediatek.anr;

import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.util.Printer;
import java.util.HashMap;

public final class AnrAppManagerImpl extends AnrAppManager {
    private static final String TAG = "AnrAppManager";
    private static Object lock = new Object();
    private static AnrAppManagerImpl sInstance = null;
    protected static HashMap<String, MessageLogger> sMap = new HashMap<>();
    private static MessageLogger sSingletonLogger = null;

    public static AnrAppManagerImpl getInstance() {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new AnrAppManagerImpl();
                }
            }
        }
        return sInstance;
    }

    public void setMessageLogger(Looper looper) {
        if ("eng".equals(Build.TYPE)) {
            looper.setMessageLogging(newMessageLogger(false));
        }
    }

    public void dumpMessage(boolean z) {
        if (z) {
            dumpAllMessageHistory();
        } else {
            dumpMessageHistory();
        }
    }

    public static Printer newMessageLogger(boolean z) {
        sSingletonLogger = new MessageLogger(z);
        return sSingletonLogger;
    }

    public static Printer newMessageLogger(boolean z, String str) {
        if (sMap.containsKey(str)) {
            sMap.remove(str);
        }
        MessageLogger messageLogger = new MessageLogger(z, str);
        sMap.put(str, messageLogger);
        return messageLogger;
    }

    public static void dumpMessageHistory() {
        if (sSingletonLogger == null) {
            Log.i(TAG, "!!! It is not under singleton mode, U can't use it. !!!\n");
            try {
                AnrManagerNative.getDefault().informMessageDump("!!! It is not under singleton mode, U can't use it. !!!\n", Process.myPid());
            } catch (RemoteException e) {
                Log.i(TAG, "informMessageDump exception " + e);
            }
        } else {
            sSingletonLogger.dumpMessageHistory();
        }
    }

    public static void dumpAllMessageHistory() {
        if (sSingletonLogger != null) {
            Log.i(TAG, "!!! It is under multiple instance mode, but you are in singleton usage style. !!!\n");
            try {
                AnrManagerNative.getDefault().informMessageDump("!!! It is under multiple instance mode,but you are in singleton usage style. !!!\n", Process.myPid());
            } catch (RemoteException e) {
                Log.i(TAG, "informMessageDump exception " + e);
            }
        } else if (sMap == null) {
            Log.i(TAG, String.format("!!! DumpAll, sMap is null\n", new Object[0]));
            try {
                AnrManagerNative.getDefault().informMessageDump("!!! DumpAll, sMap is null\n", Process.myPid());
            } catch (RemoteException e2) {
                Log.i(TAG, "informMessageDump exception " + e2);
            }
        } else {
            for (String next : sMap.keySet()) {
                Log.i(TAG, String.format(">>> DumpByName, Thread name: %s dump is starting <<<\n", new Object[]{next}));
                sMap.get(next).setInitStr(String.format(">>> DumpByName, Thread name: %s dump is starting <<<\n", new Object[]{next}));
                sMap.get(next).dumpMessageHistory();
            }
        }
    }
}
