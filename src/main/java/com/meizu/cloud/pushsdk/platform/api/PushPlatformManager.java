package com.meizu.cloud.pushsdk.platform.api;

import android.content.Context;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.StrategyMessage;
import com.meizu.cloud.pushsdk.platform.pushstrategy.NotificationClearStrategy;
import com.meizu.cloud.pushsdk.platform.pushstrategy.RegisterStatusStrategy;
import com.meizu.cloud.pushsdk.platform.pushstrategy.SubScribeAliasStrategy;
import com.meizu.cloud.pushsdk.platform.pushstrategy.SubScribeTagStrategy;
import com.meizu.cloud.pushsdk.platform.pushstrategy.SwitchStatusStrategy;
import com.meizu.cloud.pushsdk.platform.pushstrategy.UnRegisterStatusStrategy;
import com.meizu.cloud.pushsdk.pushtracer.emitter.classic.Executor;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;

public class PushPlatformManager {
    private static final String TAG = "PushPlatformManager";
    private static PushPlatformManager mInstance;
    private boolean enableRPC;
    private ScheduledExecutorService executorService;
    private Context mContext;
    private NotificationClearStrategy notificationClearStrategy;
    private PushAPI pushAPI;
    private RegisterStatusStrategy registerStatusStrategy;
    private SubScribeAliasStrategy subScribeAliasStrategy;
    private SubScribeTagStrategy subScribeTagStrategy;
    private SwitchStatusStrategy switchStatusStrategy;
    private UnRegisterStatusStrategy unRegisterStatusStrategy;

    public PushPlatformManager(Context context, boolean z) {
        this(context, z, true);
    }

    public PushPlatformManager(Context context, boolean z, boolean z2) {
        this.enableRPC = true;
        this.mContext = context.getApplicationContext();
        this.pushAPI = new PushAPI(this.mContext);
        if (z) {
            this.executorService = (ScheduledExecutorService) Executor.getExecutor();
        }
        this.enableRPC = z2;
        this.registerStatusStrategy = new RegisterStatusStrategy(this.mContext, this.pushAPI, this.executorService, z2);
        this.unRegisterStatusStrategy = new UnRegisterStatusStrategy(this.mContext, this.pushAPI, this.executorService, z2);
        this.switchStatusStrategy = new SwitchStatusStrategy(this.mContext, this.pushAPI, this.executorService, z2);
        this.subScribeTagStrategy = new SubScribeTagStrategy(this.mContext, this.pushAPI, this.executorService, z2);
        this.subScribeAliasStrategy = new SubScribeAliasStrategy(this.mContext, this.pushAPI, this.executorService, z2);
        this.notificationClearStrategy = new NotificationClearStrategy(this.mContext, this.executorService, z2);
    }

    public static PushPlatformManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (PushPlatformManager.class) {
                if (mInstance == null) {
                    mInstance = new PushPlatformManager(context, true);
                }
            }
        }
        return mInstance;
    }

    public void enableRemoteInvoker(boolean z) {
        this.registerStatusStrategy.setSupportRemoteInvoke(z);
        this.unRegisterStatusStrategy.setSupportRemoteInvoke(z);
        this.switchStatusStrategy.setSupportRemoteInvoke(z);
        this.subScribeAliasStrategy.setSupportRemoteInvoke(z);
        this.subScribeTagStrategy.setSupportRemoteInvoke(z);
    }

    public boolean dispatcherStrategyMessage(StrategyMessage strategyMessage) {
        if (strategyMessage == null) {
            return true;
        }
        int strategyType = strategyMessage.getStrategyType();
        if (strategyType == 2) {
            return register(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName());
        }
        if (strategyType != 4) {
            if (strategyType != 8) {
                if (strategyType != 16) {
                    if (strategyType == 32) {
                        return unRegister(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName());
                    }
                    if (strategyType != 64) {
                        return true;
                    }
                    if (strategyMessage.getStrategyChildType() == 0) {
                        return clearAllNotification(strategyMessage.getPackageName());
                    }
                    if (1 == strategyMessage.getStrategyChildType()) {
                        return clearNotification(strategyMessage.getPackageName(), Integer.valueOf(strategyMessage.getParams()).intValue());
                    } else if (2 == strategyMessage.getStrategyChildType()) {
                        return clearNotifyKey(strategyMessage.getPackageName(), strategyMessage.getParams());
                    } else {
                        return true;
                    }
                } else if (strategyMessage.getStrategyChildType() == 0) {
                    return switchPush(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId(), 0, "1".equals(strategyMessage.getParams()));
                } else if (1 == strategyMessage.getStrategyChildType()) {
                    return switchPush(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId(), 1, "1".equals(strategyMessage.getParams()));
                } else if (3 == strategyMessage.getStrategyChildType()) {
                    return switchPush(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId(), "1".equals(strategyMessage.getParams()));
                } else if (2 == strategyMessage.getStrategyChildType()) {
                    return checkPush(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId());
                } else {
                    return true;
                }
            } else if (strategyMessage.getStrategyChildType() == 0) {
                return subScribeAlias(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId(), strategyMessage.getParams());
            } else if (1 == strategyMessage.getStrategyChildType()) {
                return unSubScribeAlias(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId(), strategyMessage.getParams());
            } else if (2 == strategyMessage.getStrategyChildType()) {
                return checkSubScribeAlias(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId());
            } else {
                return true;
            }
        } else if (strategyMessage.getStrategyChildType() == 0) {
            return subScribeTags(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId(), strategyMessage.getParams());
        } else if (3 == strategyMessage.getStrategyChildType()) {
            return checkSubScribeTags(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId());
        } else {
            if (1 == strategyMessage.getStrategyChildType()) {
                return unSubScribeTags(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId(), strategyMessage.getParams());
            } else if (2 == strategyMessage.getStrategyChildType()) {
                return unSubScribeAllTags(strategyMessage.getAppId(), strategyMessage.getAppKey(), strategyMessage.getPackageName(), strategyMessage.getPushId());
            } else {
                return true;
            }
        }
    }

    public boolean register(String str, String str2, String str3) {
        this.registerStatusStrategy.setAppId(str);
        this.registerStatusStrategy.setAppKey(str2);
        this.registerStatusStrategy.setStrategyPackageNanme(str3);
        return this.registerStatusStrategy.process();
    }

    public boolean unRegister(String str, String str2, String str3) {
        this.unRegisterStatusStrategy.setAppId(str);
        this.unRegisterStatusStrategy.setAppKey(str2);
        this.unRegisterStatusStrategy.setStrategyPackageNanme(str3);
        return this.unRegisterStatusStrategy.process();
    }

    public void unRegisterAdvance(String str, String str2) {
        ANResponse unRegister = this.pushAPI.unRegister(str, str2);
        if (unRegister == null) {
            return;
        }
        if (unRegister.isSuccess()) {
            Context context = this.mContext;
            PlatformMessageSender.changePreference(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + PushConstants.KEY_PUSH_ID, "");
            DebugLogger.m4828e(TAG, "unregisetr advance pakcage " + str + " result " + unRegister.getResult());
            return;
        }
        DebugLogger.m4828e(TAG, "unregisetr advance pakcage " + str + " error " + unRegister.getError());
    }

    public boolean checkPush(String str, String str2, String str3, String str4) {
        this.switchStatusStrategy.setAppId(str);
        this.switchStatusStrategy.setAppKey(str2);
        this.switchStatusStrategy.setStrategyPackageNanme(str3);
        this.switchStatusStrategy.setPushId(str4);
        this.switchStatusStrategy.setSwitchType(2);
        return this.switchStatusStrategy.process();
    }

    public boolean switchPush(String str, String str2, String str3, String str4, int i, boolean z) {
        this.switchStatusStrategy.setAppId(str);
        this.switchStatusStrategy.setAppKey(str2);
        this.switchStatusStrategy.setStrategyPackageNanme(str3);
        this.switchStatusStrategy.setPushId(str4);
        this.switchStatusStrategy.setSwitchType(i);
        this.switchStatusStrategy.setSwitcher(z);
        return this.switchStatusStrategy.process();
    }

    public boolean switchPush(String str, String str2, String str3, String str4, boolean z) {
        this.switchStatusStrategy.setAppId(str);
        this.switchStatusStrategy.setAppKey(str2);
        this.switchStatusStrategy.setStrategyPackageNanme(str3);
        this.switchStatusStrategy.setPushId(str4);
        this.switchStatusStrategy.setSwitchType(3);
        this.switchStatusStrategy.setSwitcher(z);
        return this.switchStatusStrategy.process();
    }

    public boolean subScribeTags(String str, String str2, String str3, String str4, String str5) {
        this.subScribeTagStrategy.setAppId(str);
        this.subScribeTagStrategy.setAppKey(str2);
        this.subScribeTagStrategy.setStrategyPackageNanme(str3);
        this.subScribeTagStrategy.setPushId(str4);
        this.subScribeTagStrategy.setSubTagType(0);
        this.subScribeTagStrategy.setSubTags(str5);
        return this.subScribeTagStrategy.process();
    }

    public boolean unSubScribeTags(String str, String str2, String str3, String str4, String str5) {
        this.subScribeTagStrategy.setAppId(str);
        this.subScribeTagStrategy.setAppKey(str2);
        this.subScribeTagStrategy.setStrategyPackageNanme(str3);
        this.subScribeTagStrategy.setPushId(str4);
        this.subScribeTagStrategy.setSubTagType(1);
        this.subScribeTagStrategy.setSubTags(str5);
        return this.subScribeTagStrategy.process();
    }

    public boolean unSubScribeAllTags(String str, String str2, String str3, String str4) {
        this.subScribeTagStrategy.setAppId(str);
        this.subScribeTagStrategy.setAppKey(str2);
        this.subScribeTagStrategy.setStrategyPackageNanme(str3);
        this.subScribeTagStrategy.setPushId(str4);
        this.subScribeTagStrategy.setSubTagType(2);
        return this.subScribeTagStrategy.process();
    }

    public boolean checkSubScribeTags(String str, String str2, String str3, String str4) {
        this.subScribeTagStrategy.setAppId(str);
        this.subScribeTagStrategy.setAppKey(str2);
        this.subScribeTagStrategy.setStrategyPackageNanme(str3);
        this.subScribeTagStrategy.setPushId(str4);
        this.subScribeTagStrategy.setSubTagType(3);
        return this.subScribeTagStrategy.process();
    }

    public boolean subScribeAlias(String str, String str2, String str3, String str4, String str5) {
        this.subScribeAliasStrategy.setAppId(str);
        this.subScribeAliasStrategy.setAppKey(str2);
        this.subScribeAliasStrategy.setStrategyPackageNanme(str3);
        this.subScribeAliasStrategy.setPushId(str4);
        this.subScribeAliasStrategy.setSubAliasType(0);
        this.subScribeAliasStrategy.setAlias(str5);
        return this.subScribeAliasStrategy.process();
    }

    public boolean unSubScribeAlias(String str, String str2, String str3, String str4, String str5) {
        this.subScribeAliasStrategy.setAppId(str);
        this.subScribeAliasStrategy.setAppKey(str2);
        this.subScribeAliasStrategy.setStrategyPackageNanme(str3);
        this.subScribeAliasStrategy.setPushId(str4);
        this.subScribeAliasStrategy.setSubAliasType(1);
        this.subScribeAliasStrategy.setAlias(str5);
        return this.subScribeAliasStrategy.process();
    }

    public boolean checkSubScribeAlias(String str, String str2, String str3, String str4) {
        this.subScribeAliasStrategy.setAppId(str);
        this.subScribeAliasStrategy.setAppKey(str2);
        this.subScribeAliasStrategy.setStrategyPackageNanme(str3);
        this.subScribeAliasStrategy.setPushId(str4);
        this.subScribeAliasStrategy.setSubAliasType(2);
        return this.subScribeAliasStrategy.process();
    }

    public boolean clearNotification(String str, int... iArr) {
        NotificationClearStrategy notificationClearStrategy2 = new NotificationClearStrategy(this.mContext, this.executorService, this.enableRPC);
        notificationClearStrategy2.setNotifyId(iArr);
        notificationClearStrategy2.setStrategyPackageNanme(str);
        notificationClearStrategy2.setClearType(1);
        return notificationClearStrategy2.process();
    }

    public boolean clearAllNotification(String str) {
        NotificationClearStrategy notificationClearStrategy2 = new NotificationClearStrategy(this.mContext, this.executorService, this.enableRPC);
        notificationClearStrategy2.setClearType(0);
        notificationClearStrategy2.setStrategyPackageNanme(str);
        return notificationClearStrategy2.process();
    }

    public boolean clearNotifyKey(String str, String str2) {
        NotificationClearStrategy notificationClearStrategy2 = new NotificationClearStrategy(this.mContext, this.executorService, this.enableRPC);
        notificationClearStrategy2.setClearType(2);
        notificationClearStrategy2.setNotifyKey(str2);
        notificationClearStrategy2.setStrategyPackageNanme(str);
        return notificationClearStrategy2.process();
    }

    public ANResponse<String> uploadLogFile(String str, String str2, String str3, File file) {
        return this.pushAPI.uploadLogFile(str, str2, str3, file);
    }
}
