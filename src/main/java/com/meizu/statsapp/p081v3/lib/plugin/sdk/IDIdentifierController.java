package com.meizu.statsapp.p081v3.lib.plugin.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.flyme.openidsdk.OpenIdHelper;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.MiitHelper;
import com.meizu.statsapp.p081v3.lib.plugin.utils.MzOpenIdHelper;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.sdk.IDIdentifierController */
public class IDIdentifierController implements MiitHelper.AppIdsUpdater {
    /* access modifiers changed from: private */
    public static int GET_DEVICE_ID = Opcodes.IFEQ;
    private static final String SP_FILENAME_ID_IDENTIFIER = "sp_id_identifier";
    private static final String SP_KEY_AAID = "aaid";
    private static final String SP_KEY_OAID = "oaid";
    private static final String SP_KEY_UDID = "udid";
    private static final String SP_KEY_VAID = "vaid";
    private static final String TAG = "IDIdentifierController";
    private static String sAAID;
    private static IDIdentifierController sInstance;
    private static final Object sLock = new Object();
    private static String sOAID;
    private static String sUDID;
    private static String sVAID;
    private boolean isSupportID = false;
    /* access modifiers changed from: private */
    public Context mContext;
    private SharedPreferences.Editor mEditor;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public MiitHelper mMiitHelper;
    private SharedPreferences mSharedPreferences;

    private IDIdentifierController(Context context) {
        this.mContext = context;
        this.mSharedPreferences = this.mContext.getSharedPreferences(SP_FILENAME_ID_IDENTIFIER, 0);
        this.mEditor = this.mSharedPreferences.edit();
        this.mMiitHelper = new MiitHelper(this);
        this.mHandler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != IDIdentifierController.GET_DEVICE_ID) {
                    return;
                }
                if (FlymeOSUtils.kaiJiXiangDao(IDIdentifierController.this.mContext) || !FlymeOSUtils.isCTA()) {
                    IDIdentifierController.this.mMiitHelper.getDeviceIds(IDIdentifierController.this.mContext);
                } else {
                    Log.d(IDIdentifierController.TAG, "Not yet through the boot guide ，so ignore it '[getDeviceIds]");
                }
            }
        };
    }

    public static IDIdentifierController getInstance(Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new IDIdentifierController(context);
                }
            }
        }
        return sInstance;
    }

    public void init() {
        if ((FlymeOSUtils.isBrandMeizu() && !FlymeOSUtils.isPreFlyme8()) || C2943Utils.isAndroidQ()) {
            fetchDeviceID(0);
        }
    }

    private void fetchDeviceID(int i) {
        if (this.mHandler.hasMessages(GET_DEVICE_ID)) {
            this.mHandler.removeMessages(GET_DEVICE_ID);
        }
        this.mHandler.sendEmptyMessageDelayed(GET_DEVICE_ID, (long) i);
    }

    public String getUDID() {
        if (!TextUtils.isEmpty(sUDID)) {
            return sUDID;
        }
        sUDID = readLocalUDID();
        if (TextUtils.isEmpty(sUDID)) {
            if (C2943Utils.isAndroidQ()) {
                Logger.m17378d(TAG, "fetch safeManager.");
                sUDID = MzOpenIdHelper.queryUDID(this.mContext);
            }
            if (TextUtils.isEmpty(sUDID) && this.isSupportID) {
                try {
                    sUDID = OpenIdHelper.m6338a(this.mContext);
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(sUDID)) {
                this.mEditor.putString("udid", sUDID).commit();
            }
        }
        return sUDID;
    }

    public String getOAID() {
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        fetchDeviceID(1000);
        sOAID = readLocalOAID();
        return sOAID;
    }

    public String getVAID() {
        if (!TextUtils.isEmpty(sVAID)) {
            return sVAID;
        }
        fetchDeviceID(1000);
        sVAID = readLocalVAID();
        return sVAID;
    }

    public String getAAID() {
        if (!TextUtils.isEmpty(sAAID)) {
            return sAAID;
        }
        sAAID = readLocalAAID();
        return sAAID;
    }

    public void OnIdsAvalid(boolean z, String str, String str2, String str3, String str4) {
        Logger.m17378d(TAG, "isSupport:" + z + " udid:" + str + " oaid:" + str2 + " vaid:" + str3 + " aaid:" + str4);
        this.isSupportID = z;
        if (z) {
            updateLocal(str2, str3, str4);
        } else {
            Log.i(TAG, "ID Identifier does not suppor.");
        }
    }

    private String readLocalUDID() {
        return this.mSharedPreferences.getString("udid", "");
    }

    private String readLocalOAID() {
        return this.mSharedPreferences.getString("oaid", "");
    }

    private String readLocalVAID() {
        return this.mSharedPreferences.getString("vaid", "");
    }

    private String readLocalAAID() {
        return this.mSharedPreferences.getString("aaid", "");
    }

    private void updateLocal(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            sOAID = str;
            if (!readLocalOAID().equals(str)) {
                this.mEditor.putString("oaid", str).commit();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sVAID = str2;
            if (!readLocalOAID().equals(str2)) {
                this.mEditor.putString("vaid", str2).commit();
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            sAAID = str3;
            if (!readLocalOAID().equals(str3)) {
                this.mEditor.putString("aaid", str3).commit();
            }
        }
    }
}
