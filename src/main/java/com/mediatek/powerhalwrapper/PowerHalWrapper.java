package com.mediatek.powerhalwrapper;

import android.os.IHwBinder;
import android.os.Trace;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import vendor.mediatek.hardware.power.V1_1.IPower;
import vendor.mediatek.hardware.power.V1_1.MtkHintOp;

public class PowerHalWrapper {
    private static boolean AMS_BOOST_ACT_SWITCH = true;
    private static boolean AMS_BOOST_PACK_SWITCH = true;
    private static boolean AMS_BOOST_PROCESS_CREATE = true;
    private static final int AMS_BOOST_TIME = 2000;
    private static boolean EXT_PEAK_PERF_MODE = false;
    private static final String TAG = "PowerHalWrapper";
    /* access modifiers changed from: private */
    public static PowerProxyDeathRecipient mPowerDeathRecipient;
    /* access modifiers changed from: private */
    public static IPower mPowerProxy;
    private static int pboost_timeout;
    private static int pextpeak_period;
    private static int waltActSwitch;
    private static int waltPackSwitch;
    private static int waltProcessCreate;

    public PowerHalWrapper() {
        if (mPowerProxy == null) {
            Log.e(TAG, TAG);
            try {
                mPowerProxy = IPower.CC.getService();
                mPowerDeathRecipient = PowerProxyDeathRecipient.getInstance();
                if (!(mPowerProxy == null || mPowerDeathRecipient == null)) {
                    Log.e(TAG, "DeathRecipient");
                    mPowerProxy.linkToDeath(mPowerDeathRecipient, 0);
                }
                if (mPowerProxy != null) {
                    pextpeak_period = mPowerProxy.querySysInfo(11, 0);
                    Log.e(TAG, "pextpeak_period: " + pextpeak_period);
                    mtkWaltSort();
                }
            } catch (Exception unused) {
                mPowerProxy = null;
                mPowerDeathRecipient = null;
            }
        }
    }

    private static final class PowerProxyDeathRecipient implements IHwBinder.DeathRecipient {
        private static Object lock = new Object();
        private static volatile PowerProxyDeathRecipient sInstance;

        public static PowerProxyDeathRecipient getInstance() {
            if (sInstance == null) {
                synchronized (lock) {
                    if (sInstance == null) {
                        sInstance = new PowerProxyDeathRecipient();
                    }
                }
            }
            return sInstance;
        }

        private PowerProxyDeathRecipient() {
        }

        public void serviceDied(long j) {
            PowerHalWrapper.log("Power Hal serviceDied");
            IPower unused = PowerHalWrapper.mPowerProxy = null;
            sInstance = null;
            if (PowerHalWrapper.mPowerProxy == null) {
                try {
                    IPower unused2 = PowerHalWrapper.mPowerProxy = IPower.CC.getService();
                    PowerProxyDeathRecipient unused3 = PowerHalWrapper.mPowerDeathRecipient = getInstance();
                    if (PowerHalWrapper.mPowerProxy != null && PowerHalWrapper.mPowerDeathRecipient != null) {
                        Log.e(PowerHalWrapper.TAG, "PowerHalWrapperDeathRecipient");
                        PowerHalWrapper.mPowerProxy.linkToDeath(PowerHalWrapper.mPowerDeathRecipient, 0);
                    }
                } catch (Exception unused4) {
                    IPower unused5 = PowerHalWrapper.mPowerProxy = null;
                }
            }
        }
    }

    private void mtkWaltSort() {
        if (mPowerProxy != null) {
            int i = 12;
            while (i < 18) {
                try {
                    int querySysInfo = mPowerProxy.querySysInfo(i, 0);
                    switch (querySysInfo) {
                        case 10:
                            waltProcessCreate = mPowerProxy.querySysInfo(i + 1, 0);
                            Log.e(TAG, "<mtkWaltSort> i:" + i + " ,waltScn:" + querySysInfo + " ,period:" + waltProcessCreate);
                            break;
                        case 11:
                            waltPackSwitch = mPowerProxy.querySysInfo(i + 1, 0);
                            Log.e(TAG, "<mtkWaltSort> i:" + i + " ,waltScn:" + querySysInfo + " ,period:" + waltPackSwitch);
                            break;
                        case 12:
                            waltActSwitch = mPowerProxy.querySysInfo(i + 1, 0);
                            Log.e(TAG, "<mtkWaltSort> i:" + i + " ,waltScn:" + querySysInfo + " ,period:" + waltActSwitch);
                            break;
                    }
                    i += 2;
                } catch (Exception unused) {
                    mPowerProxy = null;
                    return;
                }
            }
        }
    }

    private void mtkPowerHint(int i, int i2) {
        if (mPowerProxy != null) {
            try {
                mPowerProxy.mtkPowerHint(i, i2);
            } catch (Exception unused) {
                mPowerProxy = null;
            }
        }
    }

    private void mtkCusPowerHint(int i, int i2) {
        if (mPowerProxy != null) {
            try {
                mPowerProxy.mtkCusPowerHint(i, i2);
            } catch (Exception unused) {
                mPowerProxy = null;
            }
        }
    }

    public void galleryBoostEnable(int i) {
        Log.e(TAG, "<galleryBoostEnable> do boost with " + i + Parameters.MESSAGE_SEQ);
        mtkPowerHint(18, i);
    }

    public void setRotationBoost(int i) {
        Log.e(TAG, "<setRotation> do boost with " + i + Parameters.MESSAGE_SEQ);
        mtkPowerHint(14, i);
    }

    public void setSpeedDownload(int i) {
        Log.e(TAG, "<setSpeedDownload> do boost with " + i + Parameters.MESSAGE_SEQ);
        mtkPowerHint(25, i);
    }

    public void setFpsGo(boolean z) {
        Log.e(TAG, "<setFpsGo> enable:" + z);
        if (z) {
            mtkPowerHint(22, 0);
        } else {
            mtkPowerHint(22, MtkHintOp.MTK_HINT_ALWAYS_ENABLE);
        }
    }

    public void setInstallationBoost(boolean z) {
        Log.e(TAG, "<setInstallationBoost> enable:" + z);
        if (z) {
            mtkPowerHint(23, 15000);
        } else {
            mtkPowerHint(23, 0);
        }
    }

    public void amsBoostResume(String str, String str2) {
        Trace.asyncTraceBegin(64, "amPerfBoost", 0);
        if (mPowerProxy != null) {
            try {
                mPowerProxy.mtkPowerHint(24, 0);
                if (str != null) {
                    if (str.equalsIgnoreCase(str2)) {
                        AMS_BOOST_ACT_SWITCH = true;
                        if (EXT_PEAK_PERF_MODE) {
                            EXT_PEAK_PERF_MODE = false;
                            mPowerProxy.mtkPowerHint(10, 0);
                        }
                        mPowerProxy.mtkPowerHint(12, 2000);
                        return;
                    }
                }
                AMS_BOOST_PACK_SWITCH = true;
                if (EXT_PEAK_PERF_MODE) {
                    EXT_PEAK_PERF_MODE = false;
                    mPowerProxy.mtkPowerHint(10, 0);
                }
                mPowerProxy.mtkPowerHint(11, 2000);
            } catch (Exception unused) {
                mPowerProxy = null;
            }
        }
    }

    public void amsBoostProcessCreate(String str, String str2) {
        if (str.compareTo(PushConstants.INTENT_ACTIVITY_NAME) == 0) {
            Trace.asyncTraceBegin(64, "amPerfBoost", 0);
            AMS_BOOST_PROCESS_CREATE = true;
            if (mPowerProxy != null) {
                try {
                    mPowerProxy.mtkPowerHint(24, 0);
                    mPowerProxy.mtkPowerHint(10, 2000);
                } catch (Exception unused) {
                    mPowerProxy = null;
                }
            }
        }
    }

    public void amsBoostStop() {
        int i = pextpeak_period;
        if (AMS_BOOST_PACK_SWITCH) {
            AMS_BOOST_PACK_SWITCH = false;
            if (mPowerProxy != null) {
                try {
                    mPowerProxy.mtkPowerHint(11, 0);
                    if (waltPackSwitch > 0) {
                        mPowerProxy.mtkPowerHint(24, waltPackSwitch);
                    }
                } catch (Exception unused) {
                    mPowerProxy = null;
                }
            }
        }
        if (AMS_BOOST_ACT_SWITCH) {
            AMS_BOOST_ACT_SWITCH = false;
            if (mPowerProxy != null) {
                try {
                    mPowerProxy.mtkPowerHint(12, 0);
                    if (waltActSwitch > 0) {
                        mPowerProxy.mtkPowerHint(24, waltActSwitch);
                    }
                } catch (Exception unused2) {
                    mPowerProxy = null;
                }
            }
        }
        if (AMS_BOOST_PROCESS_CREATE) {
            AMS_BOOST_PROCESS_CREATE = false;
            if (mPowerProxy != null) {
                try {
                    pboost_timeout = mPowerProxy.querySysInfo(10, 0);
                    if (i > 0) {
                        EXT_PEAK_PERF_MODE = true;
                        if (pboost_timeout > 0) {
                            i += pboost_timeout;
                            Log.e(TAG, "<amsBoostStop> duration: " + i + "ms, pboost_timeout: " + pboost_timeout);
                            pboost_timeout = 0;
                        }
                        Log.e(TAG, "<amsBoostStop> duration: " + i + Parameters.MESSAGE_SEQ);
                        mPowerProxy.mtkPowerHint(24, 0);
                        mPowerProxy.mtkPowerHint(10, i);
                    } else {
                        mPowerProxy.mtkPowerHint(10, 0);
                        if (waltProcessCreate > 0) {
                            mPowerProxy.mtkPowerHint(24, waltProcessCreate);
                        }
                    }
                } catch (Exception unused3) {
                    mPowerProxy = null;
                }
            }
        }
        Trace.asyncTraceEnd(64, "amPerfBoost", 0);
    }

    public void amsBoostNotify(int i, String str, String str2) {
        if (mPowerProxy != null) {
            try {
                mPowerProxy.notifyAppState(str2, str, i, 1);
            } catch (Exception unused) {
                mPowerProxy = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void log(String str) {
        Log.d("@M_PowerHalWrapper", "[PerfServiceWrapper] " + str + " ");
    }

    private static void loge(String str) {
        Log.e("@M_PowerHalWrapper", "[PerfServiceWrapper] ERR: " + str + " ");
    }
}
