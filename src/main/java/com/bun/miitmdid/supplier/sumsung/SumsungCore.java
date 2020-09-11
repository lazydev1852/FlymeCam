package com.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Keep;
import com.bun.miitmdid.utils.C0932a;
import com.p017b.p018a.p019a.C0473a;

@Keep
public class SumsungCore {
    private static boolean DBG = false;
    private static String SAMSUNGTAG = "Samsung_DeviceIdService";
    private static String TAG = "SumsungCore library";
    private C0931a mCallerCallBack = null;
    private ServiceConnection mConnection;
    private Context mContext = null;
    private C0473a mDeviceidInterface;

    /* renamed from: com.bun.miitmdid.supplier.sumsung.SumsungCore$a */
    public interface C0931a {
    }

    public SumsungCore(Context context, C0931a aVar) {
        if (context != null) {
            this.mContext = context;
            this.mCallerCallBack = aVar;
            this.mConnection = new ServiceConnection() {
                public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

                public native void onServiceDisconnected(ComponentName componentName);
            };
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (this.mContext.bindService(intent, this.mConnection, 1)) {
                C0932a.m2754a(TAG, "bindService Successful!");
                Log.d(SAMSUNGTAG, "bindService Successful!");
                return;
            }
            C0932a.m2754a(TAG, "bindService Failed!");
            return;
        }
        throw new NullPointerException("Context can not be null.");
    }

    static native /* synthetic */ C0473a access$002(SumsungCore sumsungCore, C0473a aVar);

    static native /* synthetic */ C0931a access$100(SumsungCore sumsungCore);

    static native /* synthetic */ String access$200();

    public native String getAAID();

    public native String getOAID();

    public native String getUDID();

    public native String getVAID();

    public native boolean isSupported();

    public native void shutdown();
}
