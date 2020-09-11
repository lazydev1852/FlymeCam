package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.MessageHandler;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.impl.MessageV2Handler;
import com.meizu.cloud.pushsdk.handler.impl.MessageV3Handler;
import com.meizu.cloud.pushsdk.handler.impl.RegisterMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.ThroughMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.UnRegisterMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.fileupload.LogUploadMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.notification.NotificationArrivedHandler;
import com.meizu.cloud.pushsdk.handler.impl.notification.NotificationClickMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.notification.NotificationDeleteMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.notification.NotificationStateMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.platform.PushSwitchStatusHandler;
import com.meizu.cloud.pushsdk.handler.impl.platform.ReceiveNotifyMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.platform.RegisterStatusHandler;
import com.meizu.cloud.pushsdk.handler.impl.platform.SubScribeAliasStatusHandler;
import com.meizu.cloud.pushsdk.handler.impl.platform.SubScribeTagsStatusHandler;
import com.meizu.cloud.pushsdk.handler.impl.platform.UnRegisterStatusHandler;
import com.meizu.cloud.pushsdk.handler.impl.schedule.ScheduleNotificationHandler;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PushMessageProxy {
    private static final String TAG = "PushMessageProxy";
    static volatile PushMessageProxy singleton;
    private Context context;
    private Map<Integer, MessageHandler> managerHashMap;
    /* access modifiers changed from: private */
    public Map<String, AbstractAppLogicListener> messageListenerMap;

    public PushMessageProxy(Context context2) {
        this(context2, (List<MessageHandler>) null);
    }

    public PushMessageProxy(Context context2, List<MessageHandler> list) {
        this(context2, list, (AbstractAppLogicListener) null);
    }

    public PushMessageProxy(Context context2, List<MessageHandler> list, AbstractAppLogicListener abstractAppLogicListener) {
        this.managerHashMap = new HashMap();
        this.messageListenerMap = null;
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            this.messageListenerMap = new HashMap();
            DefaultPushMessageListener defaultPushMessageListener = new DefaultPushMessageListener();
            if (list == null) {
                addHandler((MessageHandler) new MessageV3Handler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new MessageV2Handler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new ThroughMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new NotificationClickMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new RegisterMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new UnRegisterMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new NotificationDeleteMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new PushSwitchStatusHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new RegisterStatusHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new UnRegisterStatusHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new SubScribeAliasStatusHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new SubScribeTagsStatusHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new ScheduleNotificationHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new ReceiveNotifyMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new NotificationStateMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new LogUploadMessageHandler(context2, defaultPushMessageListener));
                addHandler((MessageHandler) new NotificationArrivedHandler(context2, defaultPushMessageListener));
                return;
            }
            addHandler(list);
            return;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public static PushMessageProxy with(Context context2) {
        if (singleton == null) {
            synchronized (PushMessageProxy.class) {
                if (singleton == null) {
                    DebugLogger.m4829i(TAG, "PushMessageProxy init");
                    singleton = new PushMessageProxy(context2);
                }
            }
        }
        return singleton;
    }

    public PushMessageProxy receiverListener(String str, AbstractAppLogicListener abstractAppLogicListener) {
        this.messageListenerMap.put(str, abstractAppLogicListener);
        return this;
    }

    public PushMessageProxy unReceiverListener(String str) {
        this.messageListenerMap.put(str, (Object) null);
        return this;
    }

    public PushMessageProxy addHandler(MessageHandler messageHandler) {
        this.managerHashMap.put(Integer.valueOf(messageHandler.getProcessorType()), messageHandler);
        return this;
    }

    public PushMessageProxy addHandler(List<MessageHandler> list) {
        if (list != null) {
            for (MessageHandler addHandler : list) {
                addHandler(addHandler);
            }
            return this;
        }
        throw new IllegalArgumentException("messageManagerList must not be null.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x004e A[Catch:{ Exception -> 0x0067 }, LOOP:0: B:5:0x004e->B:8:0x0064, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processMessage(android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "PushMessageProxy"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "is onMainThread "
            r1.append(r2)
            boolean r2 = r4.isOnMainThread()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r1)
            java.lang.String r0 = "method"
            java.lang.String r0 = r5.getStringExtra(r0)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "PushMessageProxy"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r2.<init>()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = "receive action "
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = r5.getAction()     // Catch:{ Exception -> 0x0067 }
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = " method "
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            r2.append(r0)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0067 }
            com.meizu.cloud.pushinternal.DebugLogger.m4829i(r1, r0)     // Catch:{ Exception -> 0x0067 }
            if (r5 == 0) goto L_0x0082
            java.util.Map<java.lang.Integer, com.meizu.cloud.pushsdk.handler.MessageHandler> r0 = r4.managerHashMap     // Catch:{ Exception -> 0x0067 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0067 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0067 }
        L_0x004e:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0067 }
            if (r1 == 0) goto L_0x0082
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0067 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x0067 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x0067 }
            com.meizu.cloud.pushsdk.handler.MessageHandler r1 = (com.meizu.cloud.pushsdk.handler.MessageHandler) r1     // Catch:{ Exception -> 0x0067 }
            boolean r1 = r1.sendMessage(r5)     // Catch:{ Exception -> 0x0067 }
            if (r1 == 0) goto L_0x004e
            goto L_0x0082
        L_0x0067:
            r5 = move-exception
            java.lang.String r0 = "PushMessageProxy"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "processMessage error "
            r1.append(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r5)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.PushMessageProxy.processMessage(android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public boolean isOnMainThread() {
        return Thread.currentThread() == this.context.getMainLooper().getThread();
    }

    public class DefaultPushMessageListener extends AbstractAppLogicListener {
        public DefaultPushMessageListener() {
        }

        public void onMessage(Context context, Intent intent) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onMessage(context, intent);
                }
            }
        }

        public void onRegister(Context context, String str) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onRegister(context, str);
                }
            }
        }

        public void onMessage(Context context, String str) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onMessage(context, str);
                }
            }
        }

        public void onMessage(Context context, String str, String str2) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onMessage(context, str, str2);
                }
            }
        }

        public void onUnRegister(Context context, boolean z) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onUnRegister(context, z);
                }
            }
        }

        public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onUpdateNotificationBuilder(pushNotificationBuilder);
                }
            }
        }

        public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onPushStatus(context, pushSwitchStatus);
                }
            }
        }

        public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onRegisterStatus(context, registerStatus);
                }
            }
        }

        public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onUnRegisterStatus(context, unRegisterStatus);
                }
            }
        }

        public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onSubTagsStatus(context, subTagsStatus);
                }
            }
        }

        public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onSubAliasStatus(context, subAliasStatus);
                }
            }
        }

        public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onNotificationClicked(context, mzPushMessage);
                }
            }
        }

        public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onNotificationArrived(context, mzPushMessage);
                }
            }
        }

        public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onNotificationDeleted(context, mzPushMessage);
                }
            }
        }

        public void onNotifyMessageArrived(Context context, String str) {
            for (Map.Entry value : PushMessageProxy.this.messageListenerMap.entrySet()) {
                AbstractAppLogicListener abstractAppLogicListener = (AbstractAppLogicListener) value.getValue();
                if (abstractAppLogicListener != null) {
                    abstractAppLogicListener.onNotifyMessageArrived(context, str);
                }
            }
        }
    }
}
