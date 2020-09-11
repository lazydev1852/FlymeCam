package com.mediatek.powerhalmgr;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.mediatek.powerhalmgr.IPowerHalMgr;

public class PowerHalMgrImpl extends PowerHalMgr {
    private static final int AMS_BOOST_TIME = 2000;
    private static final int GLSURFACE_BOOST_TIME = 10;
    private static final int RENDER_THREAD_UPDATE_DURATION = 400;
    private static final String TAG = "PowerHalMgrImpl";
    private static Object lock = new Object();
    private static PowerHalMgrImpl sInstance;
    private int inited = 0;
    private Context mContext;
    private long mPreviousTime = 0;
    private IPowerHalMgr sService = null;
    private int setTid = 0;

    public static native int nativeGetPid();

    public static native int nativeGetTid();

    private void init() {
        IBinder checkService;
        if (this.inited == 0 && (checkService = ServiceManager.checkService("power_hal_mgr_service")) != null) {
            this.sService = IPowerHalMgr.Stub.asInterface(checkService);
            if (this.sService != null) {
                this.inited = 1;
            } else {
                log("ERR: getService() sService is still null..");
            }
        }
    }

    public static PowerHalMgrImpl getInstance() {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new PowerHalMgrImpl();
                }
            }
        }
        return sInstance;
    }

    public int scnReg() {
        try {
            init();
            if (this.sService != null) {
                return this.sService.scnReg();
            }
            return -1;
        } catch (RemoteException e) {
            loge("ERR: RemoteException in scnReg:" + e);
            return -1;
        }
    }

    public void scnConfig(int i, int i2, int i3, int i4, int i5, int i6) {
        try {
            init();
            if (this.sService != null) {
                this.sService.scnConfig(i, i2, i3, i4, i5, i6);
            }
        } catch (RemoteException e) {
            loge("ERR: RemoteException in scnConfig:" + e);
        }
    }

    public void scnUnreg(int i) {
        try {
            init();
            if (this.sService != null) {
                this.sService.scnUnreg(i);
            }
        } catch (RemoteException e) {
            loge("ERR: RemoteException in scnUnreg:" + e);
        }
    }

    public void scnEnable(int i, int i2) {
        try {
            init();
            if (this.sService != null) {
                this.sService.scnEnable(i, i2);
            }
        } catch (RemoteException e) {
            loge("ERR: RemoteException in scnEnable:" + e);
        }
    }

    public void scnDisable(int i) {
        try {
            init();
            if (this.sService != null) {
                this.sService.scnDisable(i);
            }
        } catch (RemoteException e) {
            loge("ERR: RemoteException in scnDisable:" + e);
        }
    }

    private void log(String str) {
        Log.d("@M_PowerHalMgrImpl", "[PowerHalMgrImpl] " + str + " ");
    }

    private void loge(String str) {
        Log.e("@M_PowerHalMgrImpl", "[PowerHalMgrImpl] ERR: " + str + " ");
    }
}
