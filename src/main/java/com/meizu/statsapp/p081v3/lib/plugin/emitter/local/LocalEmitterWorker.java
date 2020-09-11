package com.meizu.statsapp.p081v3.lib.plugin.emitter.local;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.meizu.statsapp.p081v3.InitConfig;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterConfig;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterWorker;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EventBean;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.local.storage.LocalEventStore;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.receiver.EnvironmentReceiver;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetRequestUtil;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.local.LocalEmitterWorker */
public class LocalEmitterWorker extends EmitterWorker implements EnvironmentReceiver.IEnvListener {
    private static final String TAG = "LocalEmitterWorker";
    private final int NEARTIME = 1;
    private final int NORMASEND_BACKGROUND = 6;
    private final int NORMASEND_NET = 3;
    private final int NORMASEND_POWER = 4;
    private final int NORMASEND_START = 1;
    private final int NORMASEND_THRESHOLD = 2;
    private final int NORMASEND_TIMER = 5;
    /* access modifiers changed from: private */
    public EmitterConfig emitterConfig;
    /* access modifiers changed from: private */
    public LocalEventStore eventStore;
    private ScheduledExecutorService executorService;
    private AtomicBoolean isBusy;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<Long> nearTimeIds;
    /* access modifiers changed from: private */
    public Handler neartimeSendHandler;
    /* access modifiers changed from: private */
    public Handler normaSendHandler;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<Long> realTimeIds;
    /* access modifiers changed from: private */
    public Handler realtimeSendHandler;

    public LocalEmitterWorker(final Context context, EmitterConfig emitterConfig2) {
        super(context);
        this.emitterConfig = emitterConfig2;
        this.executorService = Executors.newScheduledThreadPool(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.eventStore = new LocalEventStore(context);
        Logger.m17378d(TAG, "##### LocalEmitterWorker, " + (System.currentTimeMillis() - currentTimeMillis));
        this.isBusy = new AtomicBoolean(false);
        this.realTimeIds = new CopyOnWriteArrayList<>(new ArrayList());
        this.nearTimeIds = new CopyOnWriteArrayList<>(new ArrayList());
        HandlerThread handlerThread = new HandlerThread("LocalEmitterWorker.normaSend");
        handlerThread.start();
        this.normaSendHandler = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                LocalEmitterWorker.this.eventStore.clearOldEventsIfNecessary();
                if (!FlymeOSUtils.kaiJiXiangDao(context)) {
                    Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker NORMASEND --> 还未完成开机向导");
                } else if (!NetInfoUtils.isOnline(context)) {
                    Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker NORMASEND no network");
                } else {
                    if (message.what == 1) {
                        ArrayList<EmittableEvent> emittableEvents = LocalEmitterWorker.this.eventStore.getEmittableEvents();
                        if (emittableEvents.size() >= 6) {
                            LocalEmitterWorker.this.normalSend(emittableEvents);
                            Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker NORMASEND_" + message.what);
                        }
                    } else if (message.what == 2) {
                        if (LocalEmitterWorker.this.cacheCheck()) {
                            LocalEmitterWorker.this.normalSend(LocalEmitterWorker.this.eventStore.getEmittableEvents());
                            Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker NORMASEND_" + message.what);
                        }
                    } else if (message.what == 3 || message.what == 4 || message.what == 5 || message.what == 6) {
                        LocalEmitterWorker.this.normalSend(LocalEmitterWorker.this.eventStore.getEmittableEvents());
                        Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker NORMASEND_" + message.what);
                    }
                    LocalEmitterWorker.this.normaSendHandler.removeMessages(5);
                    if (LocalEmitterWorker.this.emitterConfig.getFlushDelayInterval() > 0) {
                        LocalEmitterWorker.this.normaSendHandler.sendEmptyMessageDelayed(5, LocalEmitterWorker.this.emitterConfig.getFlushDelayInterval());
                    }
                }
            }
        };
        HandlerThread handlerThread2 = new HandlerThread("LocalEmitterWorker.realtimeSend");
        handlerThread2.start();
        this.realtimeSendHandler = new Handler(handlerThread2.getLooper());
        HandlerThread handlerThread3 = new HandlerThread("LocalEmitterWorker.neartimeSend");
        handlerThread3.start();
        this.neartimeSendHandler = new Handler(handlerThread3.getLooper()) {
            public void handleMessage(Message message) {
                TrackerPayload payload;
                if (!FlymeOSUtils.kaiJiXiangDao(context)) {
                    Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker NEARTIME SEND --> 还未完成开机向导");
                } else if (message.what == 1) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = LocalEmitterWorker.this.nearTimeIds.iterator();
                    while (it.hasNext()) {
                        long longValue = ((Long) it.next()).longValue();
                        EventBean eventByRowId = LocalEmitterWorker.this.eventStore.getEventByRowId(longValue);
                        if (!(eventByRowId == null || (payload = EventBean.toPayload(eventByRowId)) == null)) {
                            arrayList.add(new EmittableEvent("", longValue, payload));
                            arrayList2.add(Long.valueOf(longValue));
                        }
                    }
                    if (InitConfig.sendEventSync) {
                        LocalEmitterWorker.this.syncSendData(arrayList, false, UxipConstants.REALTIME_UPLOAD);
                    } else {
                        LocalEmitterWorker.this.sendData(arrayList, false, UxipConstants.REALTIME_UPLOAD);
                    }
                    LocalEmitterWorker.this.nearTimeIds.removeAll(arrayList2);
                    Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker NEARTIME SEND");
                }
            }
        };
        EnvironmentReceiver.getInstance(context).addEnvListener(this);
        resetMobileTrafficIf();
        Logger.m17378d(TAG, "##### LocalEmitterWorker 2, " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void init() {
        Logger.m17378d(TAG, "EmitterWorker init");
        this.executorService.execute(new Runnable() {
            public void run() {
                if (LocalEmitterWorker.this.emitterConfig.isFlushOnStart()) {
                    LocalEmitterWorker.this.normaSendHandler.sendEmptyMessage(1);
                }
                if (LocalEmitterWorker.this.emitterConfig.getFlushDelayInterval() > 0) {
                    LocalEmitterWorker.this.normaSendHandler.sendEmptyMessageDelayed(5, LocalEmitterWorker.this.emitterConfig.getFlushDelayInterval());
                }
            }
        });
    }

    public void updateConfig(final EmitterConfig emitterConfig2) {
        this.executorService.execute(new Runnable() {
            public void run() {
                EmitterConfig unused = LocalEmitterWorker.this.emitterConfig = emitterConfig2;
                LocalEmitterWorker.this.normaSendHandler.removeMessages(5);
                if (LocalEmitterWorker.this.emitterConfig.getFlushDelayInterval() > 0) {
                    LocalEmitterWorker.this.normaSendHandler.sendEmptyMessageDelayed(5, LocalEmitterWorker.this.emitterConfig.getFlushDelayInterval());
                }
            }
        });
    }

    public void add(final TrackerPayload trackerPayload) {
        this.executorService.execute(new Runnable() {
            public void run() {
                LocalEmitterWorker.this.eventStore.insertEvent(trackerPayload);
                LocalEmitterWorker.this.normaSendHandler.sendEmptyMessage(2);
            }
        });
    }

    public void addRealtime(final TrackerPayload trackerPayload) {
        this.executorService.execute(new Runnable() {
            public void run() {
                long insertEvent = LocalEmitterWorker.this.eventStore.insertEvent(trackerPayload);
                LocalEmitterWorker.this.realTimeIds.add(Long.valueOf(insertEvent));
                Logger.m17378d(LocalEmitterWorker.TAG, "insert realtime event id:" + insertEvent);
                if (!FlymeOSUtils.kaiJiXiangDao(LocalEmitterWorker.this.context)) {
                    Logger.m17378d(LocalEmitterWorker.TAG, "EmitterWorker REALTIME SEND --> 还未完成开机向导");
                } else {
                    LocalEmitterWorker.this.realtimeSendHandler.post(new Runnable() {
                        public void run() {
                            Iterator it = LocalEmitterWorker.this.realTimeIds.iterator();
                            while (it.hasNext()) {
                                long longValue = ((Long) it.next()).longValue();
                                ArrayList arrayList = new ArrayList();
                                EventBean eventByRowId = LocalEmitterWorker.this.eventStore.getEventByRowId(longValue);
                                if (eventByRowId != null) {
                                    arrayList.add(new EmittableEvent("", eventByRowId.getId(), trackerPayload));
                                    Logger.m17378d(LocalEmitterWorker.TAG, "realtime send");
                                    if (InitConfig.sendEventSync) {
                                        LocalEmitterWorker.this.syncSendData(arrayList, false, UxipConstants.REALTIME_UPLOAD);
                                    } else {
                                        LocalEmitterWorker.this.sendData(arrayList, false, UxipConstants.REALTIME_UPLOAD);
                                    }
                                    LocalEmitterWorker.this.realTimeIds.remove(Long.valueOf(longValue));
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public void addNeartime(final TrackerPayload trackerPayload) {
        this.executorService.execute(new Runnable() {
            public void run() {
                LocalEmitterWorker.this.nearTimeIds.add(Long.valueOf(LocalEmitterWorker.this.eventStore.insertEvent(trackerPayload)));
                if (!LocalEmitterWorker.this.neartimeSendHandler.hasMessages(1)) {
                    LocalEmitterWorker.this.neartimeSendHandler.sendEmptyMessageDelayed(1, (long) (LocalEmitterWorker.this.emitterConfig.getNeartimeInterval() * 1000));
                }
            }
        });
    }

    public void flush() {
        this.executorService.execute(new Runnable() {
            public void run() {
                LocalEmitterWorker.this.normaSendHandler.sendEmptyMessage(6);
            }
        });
    }

    public void environmentChanged(String str) {
        Logger.m17378d(TAG, "environmentChanged. changeName: " + str);
        if (EnvironmentReceiver.CHANGE_NAME_NETWORKCONNECT.equals(str)) {
            if (this.emitterConfig.isFlushOnReconnect()) {
                this.normaSendHandler.sendEmptyMessage(3);
            }
        } else if (EnvironmentReceiver.CHANGE_NAME_POWER.equals(str) && this.emitterConfig.isFlushOnCharge()) {
            this.normaSendHandler.sendEmptyMessage(4);
        }
    }

    /* access modifiers changed from: private */
    public void normalSend(ArrayList<EmittableEvent> arrayList) {
        Iterator<EmittableEvent> it = arrayList.iterator();
        while (it.hasNext()) {
            EmittableEvent next = it.next();
            if (this.realTimeIds.contains(Long.valueOf(next.getId())) || this.nearTimeIds.contains(Long.valueOf(next.getId()))) {
                it.remove();
            }
        }
        Logger.m17378d(TAG, "normalSend");
        if (InitConfig.sendEventSync) {
            syncSendData(arrayList, true, UxipConstants.BATCH_UPLOAD);
        } else {
            sendData(arrayList, true, UxipConstants.BATCH_UPLOAD);
        }
    }

    /* access modifiers changed from: private */
    public void syncSendData(ArrayList<EmittableEvent> arrayList, boolean z, String str) {
        if (this.isBusy.compareAndSet(false, true)) {
            sendData(arrayList, z, str);
            this.isBusy.compareAndSet(true, false);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendData(java.util.ArrayList<com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent> r12, boolean r13, java.lang.String r14) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x01d9
            int r0 = r12.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x01d9
        L_0x000a:
            android.content.Context r0 = r11.context
            com.meizu.statsapp.v3.lib.plugin.sdk.UmidFetcher r0 = com.meizu.statsapp.p081v3.lib.plugin.sdk.UmidFetcher.getInstance(r0)
            java.lang.String r0 = r0.fetchOrRequestUMID()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0022
            java.lang.String r12 = "LocalEmitterWorker"
            java.lang.String r13 = "Not flushing data to Server because no umid"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r13)
            return
        L_0x0022:
            com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig r1 = r11.emitterConfig
            java.lang.String r1 = r1.getPkgKey()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0036
            java.lang.String r12 = "LocalEmitterWorker"
            java.lang.String r13 = "Not flushing data to Server because no pkgKey"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r13)
            return
        L_0x0036:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            r5 = 0
        L_0x0042:
            int r6 = r12.size()
            if (r5 >= r6) goto L_0x007d
            java.lang.Object r6 = r12.get(r5)
            com.meizu.statsapp.v3.lib.plugin.emitter.EmittableEvent r6 = (com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent) r6
            long r7 = r6.getId()
            com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r9 = r6.getPayload()
            java.lang.String r10 = "cseq"
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r9.add(r10, r7)
            com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r7 = r6.getPayload()
            java.lang.String r8 = "umid"
            r7.add(r8, r0)
            long r7 = r6.getId()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r2.add(r7)
            com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r6 = r6.getPayload()
            r3.add(r6)
            int r5 = r5 + 1
            goto L_0x0042
        L_0x007d:
            java.lang.String r12 = "LocalEmitterWorker"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "sendData eventIds: "
            r0.append(r5)
            java.lang.Object[] r5 = r2.toArray()
            java.lang.String r5 = java.util.Arrays.toString(r5)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r0)
            java.lang.String r12 = com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterMessageBuilder.buildEvents(r3)
            byte[] r12 = r12.getBytes()
            java.lang.String r0 = "LocalEmitterWorker"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "origData size: "
            r3.append(r5)
            int r5 = r12.length
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r3)
            byte[] r12 = com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils.compress(r12)
            if (r13 == 0) goto L_0x00c7
            boolean r13 = r11.mobileTrafficCheck(r12)
            if (r13 != 0) goto L_0x00c7
            return
        L_0x00c7:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants.UPLOAD_URL
            r13.append(r0)
            r13.append(r1)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r13 = r11.buildUri(r13, r12)
            java.lang.String r0 = "LocalEmitterWorker"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "sendData buildUri "
            r3.append(r5)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r3)
            android.content.Context r0 = r11.context
            com.meizu.statsapp.v3.lib.plugin.net.HttpSecureRequester r0 = com.meizu.statsapp.p081v3.lib.plugin.net.HttpSecureRequester.getInstance(r0)
            r3 = 0
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r12 = r0.postMultipart(r13, r3, r12)
            if (r12 == 0) goto L_0x0197
            java.lang.String r13 = r12.getResponseBody()
            if (r13 == 0) goto L_0x0197
            r13 = 1
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0170 }
            java.lang.String r3 = r12.getResponseBody()     // Catch:{ JSONException -> 0x0170 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0170 }
            java.lang.String r3 = "code"
            int r0 = r0.getInt(r3)     // Catch:{ JSONException -> 0x0170 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x0154
            java.lang.String r0 = "LocalEmitterWorker"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0151 }
            r3.<init>()     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r4 = "Successfully posted to "
            r3.append(r4)     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r4 = com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants.UPLOAD_URL     // Catch:{ JSONException -> 0x0151 }
            r3.append(r4)     // Catch:{ JSONException -> 0x0151 }
            r3.append(r1)     // Catch:{ JSONException -> 0x0151 }
            r3.append(r14)     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0151 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r3)     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r0 = "LocalEmitterWorker"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0151 }
            r3.<init>()     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r4 = "Response is: "
            r3.append(r4)     // Catch:{ JSONException -> 0x0151 }
            r3.append(r12)     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r12 = r3.toString()     // Catch:{ JSONException -> 0x0151 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r12)     // Catch:{ JSONException -> 0x0151 }
            goto L_0x016e
        L_0x0151:
            r12 = move-exception
            r4 = 1
            goto L_0x0171
        L_0x0154:
            r3 = 415(0x19f, float:5.82E-43)
            if (r0 != r3) goto L_0x0197
            java.lang.String r0 = "LocalEmitterWorker"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0151 }
            r3.<init>()     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r4 = "415 data error "
            r3.append(r4)     // Catch:{ JSONException -> 0x0151 }
            r3.append(r12)     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r12 = r3.toString()     // Catch:{ JSONException -> 0x0151 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r12)     // Catch:{ JSONException -> 0x0151 }
        L_0x016e:
            r4 = 1
            goto L_0x0197
        L_0x0170:
            r12 = move-exception
        L_0x0171:
            java.lang.String r13 = "LocalEmitterWorker"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Exception: "
            r0.append(r3)
            java.lang.String r3 = r12.toString()
            r0.append(r3)
            java.lang.String r3 = " - Cause: "
            r0.append(r3)
            java.lang.Throwable r12 = r12.getCause()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17382w(r13, r12)
        L_0x0197:
            if (r4 == 0) goto L_0x01ba
            java.lang.String r12 = "LocalEmitterWorker"
            java.lang.String r13 = "deleting sent events from DB."
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r13)
            java.util.Iterator r12 = r2.iterator()
        L_0x01a4:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01d8
            java.lang.Object r13 = r12.next()
            java.lang.Long r13 = (java.lang.Long) r13
            long r13 = r13.longValue()
            com.meizu.statsapp.v3.lib.plugin.emitter.local.storage.LocalEventStore r0 = r11.eventStore
            r0.removeEvent(r13)
            goto L_0x01a4
        L_0x01ba:
            java.lang.String r12 = "LocalEmitterWorker"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Response is null or failed, unexpected failure posting to "
            r13.append(r0)
            java.lang.String r0 = com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants.UPLOAD_URL
            r13.append(r0)
            r13.append(r1)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r13)
        L_0x01d8:
            return
        L_0x01d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.emitter.local.LocalEmitterWorker.sendData(java.util.ArrayList, boolean, java.lang.String):void");
    }

    private String buildUri(String str, byte[] bArr) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        HashMap hashMap = new HashMap();
        String md5 = C2943Utils.getMD5(bArr);
        buildUpon.appendQueryParameter("md5", md5);
        hashMap.put("md5", md5);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String valueOf = String.valueOf(currentTimeMillis);
        buildUpon.appendQueryParameter("ts", valueOf);
        String valueOf2 = String.valueOf(currentTimeMillis + ((long) new Random().nextInt()));
        buildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        hashMap.put("ts", valueOf);
        hashMap.put(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        buildUpon.appendQueryParameter("sign", NetRequestUtil.sign("POST", str, hashMap, (Map<String, String>) null));
        return buildUpon.toString();
    }

    /* access modifiers changed from: private */
    public boolean cacheCheck() {
        long eventsCount = this.eventStore.getEventsCount((String) null);
        int flushCacheLimit = this.emitterConfig.getFlushCacheLimit();
        Logger.m17378d(TAG, "cacheCheck ------------------ eventSize:" + eventsCount + ", flushCacheLimit:" + flushCacheLimit);
        return eventsCount >= ((long) flushCacheLimit);
    }

    private void resetMobileTrafficIf() {
        long currentTimeMillis = System.currentTimeMillis();
        long lastResetTime = this.eventStore.getLastResetTime();
        long abs = Math.abs(currentTimeMillis - lastResetTime);
        Logger.m17378d(TAG, "beforeFlush ------------------ now:" + currentTimeMillis + ", lastResetTime:" + lastResetTime + ", intervalTime:" + abs + ", resetTrafficInterval:" + 86400000);
        if (abs >= 86400000) {
            Logger.m17378d(TAG, "do reset traffic");
            this.eventStore.updateTraffic(0);
            this.eventStore.updateLastResetTime(currentTimeMillis);
        }
    }

    private boolean mobileTrafficCheck(byte[] bArr) {
        int length = bArr.length;
        Logger.m17378d(TAG, "mobileTrafficCheck ------------------ flushSize:" + length);
        if (length == 0) {
            Logger.m17378d(TAG, "Not flushing data to Server because no flush data");
            return false;
        }
        boolean isWiFiWorking = NetInfoUtils.isWiFiWorking(this.context);
        int traffic = this.eventStore.getTraffic();
        long flushMobileTrafficLimit = this.emitterConfig.getFlushMobileTrafficLimit();
        Logger.m17378d(TAG, "mobileTrafficCheck ------------------ isWifi:" + isWiFiWorking + ", currentTraffic:" + traffic + ", mobileTrafficLimit:" + flushMobileTrafficLimit);
        if (isWiFiWorking) {
            Logger.m17378d(TAG, "flushing data to server in WiFi mode");
        } else if (flushMobileTrafficLimit < 0) {
            return true;
        } else {
            int i = traffic + length;
            if (((long) i) > flushMobileTrafficLimit) {
                Logger.m17378d(TAG, "Not flushing data to server because exceed mobileTrafficLimit");
                return false;
            }
            this.eventStore.updateTraffic(i);
            Logger.m17378d(TAG, "flushing data to server currentTraffic:" + traffic + ", flushSize:" + length);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean updateEventSource(String str, String str2) {
        return this.eventStore.updateEventSource(str, str2);
    }

    public void setEncrypt(boolean z) {
        this.eventStore.setEncrypt(z);
    }
}
