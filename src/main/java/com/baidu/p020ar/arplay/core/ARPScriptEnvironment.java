package com.baidu.p020ar.arplay.core;

import android.text.TextUtils;
import android.util.Log;
import com.mediatek.util.MtkPatterns;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.ar.arplay.core.ARPScriptEnvironment */
public class ARPScriptEnvironment {
    public static final String KEY_AR_KEY = "ar_key";
    public static final String KEY_AR_TYPE = "ar_type";
    public static final String KEY_DATA_PIP_IMU = "imu";
    public static final String KEY_DATA_PIP_SLAM = "slam";
    public static final String KEY_DATA_PIP_TRACK = "track";
    private static ARPScriptEnvironment mInstance;
    private Map mDataPip = new HashMap();
    private Map mEnvironment = new HashMap();
    private Lock mLock = new ReentrantLock();

    public static ARPScriptEnvironment getInstance() {
        ARPScriptEnvironment aRPScriptEnvironment;
        if (mInstance != null) {
            return mInstance;
        }
        synchronized (ARPScriptEnvironment.class) {
            if (mInstance == null) {
                mInstance = new ARPScriptEnvironment();
            }
            aRPScriptEnvironment = mInstance;
        }
        return aRPScriptEnvironment;
    }

    static native Object nativeGetSharedEnvironment();

    static native void nativeSetDataPip(Object obj);

    static native void nativeSetSharedEnvironment(Object obj);

    public static void setSharedEnvironment(Map map) {
        if (map != null) {
            nativeSetSharedEnvironment(map);
        }
    }

    public Object getSharedEnvironmentValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock();
        Object nativeGetSharedEnvironment = nativeGetSharedEnvironment();
        this.mLock.unlock();
        if (nativeGetSharedEnvironment instanceof HashMap) {
            return ((HashMap) nativeGetSharedEnvironment).get(str);
        }
        return null;
    }

    public void release() {
        if (this.mEnvironment != null) {
            this.mEnvironment.clear();
        }
        if (this.mDataPip != null) {
            this.mDataPip.clear();
        }
    }

    public void setDataPipKV(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            if (obj == null) {
                this.mDataPip.remove(str);
            }
            this.mDataPip.put(str, obj);
            nativeSetDataPip(this.mDataPip);
        }
    }

    public void setLocalEnvironmentKV(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            if (obj == null) {
                this.mEnvironment.remove(str);
            }
            this.mEnvironment.put(str, obj);
        }
    }

    public void setSharedEnvironmentKV(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.mLock.lock();
            if (obj == null) {
                this.mEnvironment.remove(str);
            }
            this.mEnvironment.put(str, obj);
            nativeSetSharedEnvironment(this.mEnvironment);
            this.mLock.unlock();
        }
    }

    public void syncSharedEnvironmentData() {
        this.mLock.lock();
        nativeSetSharedEnvironment(this.mEnvironment);
        this.mLock.unlock();
    }

    public void testEnvironmentData() {
        nativeGetSharedEnvironment();
        Log.e("ARPScriptEnvironment", "getSharedEnvironmentValue(KEY_AR_KEY) :" + getSharedEnvironmentValue("ar_key"));
        getSharedEnvironmentValue("test");
        Log.e("ARPScriptEnvironment", MtkPatterns.KEY_URLDATA_END);
    }
}
