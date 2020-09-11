package com.mediatek.mmsdk;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.mediatek.mmsdk.CameraEffect;
import com.mediatek.mmsdk.IEffectFactory;
import com.mediatek.mmsdk.IEffectHalClient;
import com.mediatek.mmsdk.IFeatureManager;
import com.mediatek.mmsdk.IMMSdkService;
import java.util.ArrayList;
import java.util.List;

public class CameraEffectManager {
    private static final String CAMERA_MM_SERVICE_BINDER_NAME = "media.mmsdk";
    private static final String TAG = "CameraEffectManager";
    private final Context mContext;
    private IEffectFactory mIEffectFactory;
    private IFeatureManager mIFeatureManager;
    private IMMSdkService mIMmsdkService;

    public CameraEffectManager(Context context) {
        this.mContext = context;
    }

    public CameraEffect openEffectHal(EffectHalVersion effectHalVersion, CameraEffect.StateCallback stateCallback, Handler handler) throws CameraEffectHalException {
        if (effectHalVersion != null) {
            if (handler == null) {
                if (Looper.myLooper() != null) {
                    handler = new Handler();
                } else {
                    throw new IllegalArgumentException("Looper doesn't exist in the calling thread");
                }
            }
            return openEffect(effectHalVersion, stateCallback, handler);
        }
        throw new IllegalArgumentException("effect version is null");
    }

    public List<EffectHalVersion> getSupportedVersion(String str) throws CameraEffectHalException {
        ArrayList arrayList = new ArrayList();
        getEffectFactory();
        try {
            this.mIEffectFactory.getSupportedVersion(str, arrayList);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException during getSupportedVersion", e);
        }
        return arrayList;
    }

    private CameraEffect openEffect(EffectHalVersion effectHalVersion, CameraEffect.StateCallback stateCallback, Handler handler) throws CameraEffectHalException {
        getMmSdkService();
        getFeatureManager();
        getEffectFactory();
        IEffectHalClient createEffectHalClient = createEffectHalClient(effectHalVersion);
        try {
            int init = createEffectHalClient.init();
            CameraEffectImpl cameraEffectImpl = new CameraEffectImpl(stateCallback, handler);
            try {
                int effectListener = createEffectHalClient.setEffectListener(cameraEffectImpl.getEffectHalListener());
                cameraEffectImpl.setRemoteCameraEffect(createEffectHalClient);
                Log.i(TAG, "[openEffect],version = " + effectHalVersion + ",initValue = " + init + ",setListenerValue = " + effectListener + ",cameraEffect = " + cameraEffectImpl);
                return cameraEffectImpl;
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException during setEffectListener", e);
                CameraEffectHalRuntimeException cameraEffectHalRuntimeException = new CameraEffectHalRuntimeException(106);
                cameraEffectImpl.setRemoteCameraEffectFail(cameraEffectHalRuntimeException);
                throw cameraEffectHalRuntimeException.asChecked();
            }
        } catch (RemoteException e2) {
            Log.e(TAG, "RemoteException during init", e2);
            throw new CameraEffectHalException(201);
        }
    }

    private IMMSdkService getMmSdkService() throws CameraEffectHalException {
        if (this.mIMmsdkService == null) {
            IBinder service = ServiceManager.getService("media.mmsdk");
            if (service != null) {
                this.mIMmsdkService = IMMSdkService.Stub.asInterface(service);
            } else {
                throw new CameraEffectHalException(101);
            }
        }
        return this.mIMmsdkService;
    }

    private IFeatureManager getFeatureManager() throws CameraEffectHalException {
        getMmSdkService();
        if (this.mIFeatureManager == null) {
            BinderHolder binderHolder = new BinderHolder();
            try {
                this.mIMmsdkService.connectFeatureManager(binderHolder);
                this.mIFeatureManager = IFeatureManager.Stub.asInterface(binderHolder.getBinder());
            } catch (RemoteException unused) {
                throw new CameraEffectHalException(102);
            }
        }
        return this.mIFeatureManager;
    }

    private IEffectFactory getEffectFactory() throws CameraEffectHalException {
        getFeatureManager();
        if (this.mIEffectFactory == null) {
            BinderHolder binderHolder = new BinderHolder();
            try {
                this.mIFeatureManager.getEffectFactory(binderHolder);
                this.mIEffectFactory = IEffectFactory.Stub.asInterface(binderHolder.getBinder());
            } catch (RemoteException unused) {
                throw new CameraEffectHalException(103);
            }
        }
        return this.mIEffectFactory;
    }

    private IEffectHalClient createEffectHalClient(EffectHalVersion effectHalVersion) throws CameraEffectHalException {
        getEffectFactory();
        BinderHolder binderHolder = new BinderHolder();
        try {
            this.mIEffectFactory.createEffectHalClient(effectHalVersion, binderHolder);
            return IEffectHalClient.Stub.asInterface(binderHolder.getBinder());
        } catch (RemoteException unused) {
            throw new CameraEffectHalException(105);
        }
    }
}
