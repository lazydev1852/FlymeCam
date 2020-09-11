package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.asus.msa.p016a.C0470a;

@Keep
public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final String TAG = "SupplementaryDIDManager";
    public boolean isBinded = false;
    public Context mContext;
    public C0470a mDidService;
    public C0472a mListener;
    public ServiceConnection mServiceConnection = new ServiceConnection() {
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        public native void onServiceDisconnected(ComponentName componentName);
    };

    public SupplementaryDIDManager(Context context) {
        this.mContext = context;
    }

    public static native /* synthetic */ boolean access$000();

    public static native /* synthetic */ C0470a access$102(SupplementaryDIDManager supplementaryDIDManager, C0470a aVar);

    public static native /* synthetic */ void access$200(SupplementaryDIDManager supplementaryDIDManager, boolean z);

    private native void notifyAllListeners(boolean z);

    public native void deInit();

    public native void init(C0472a aVar);

    public native void showLog(boolean z);
}
