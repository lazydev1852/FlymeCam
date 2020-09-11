package com.meizu.statsapp.p081v3.lib.plugin.emitter.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.statsapp.p081v3.lib.plugin.IVccOfflineStatsCallback;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.Emitter;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterMessageBuilder;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.local.storage.LocalEventStore;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.remote.V3RemoteServiceRequester;
import com.meizu.statsapp.p081v3.lib.plugin.net.HttpSecureRequester;
import com.meizu.statsapp.p081v3.lib.plugin.net.NetResponse;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.sdk.UmidFetcher;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetRequestUtil;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter */
public class V3OfflineEmitter extends Emitter implements V3RemoteServiceRequester.IRemoteConnCallback {
    private static final int FLUSH_INTERVAL_HOUR = 300000;
    private static final String TAG = "V3OfflineEmitter";
    /* access modifiers changed from: private */
    public boolean emitterConfigUpdateSuccessful = false;
    /* access modifiers changed from: private */
    public SharedPreferences.Editor mEditor;
    /* access modifiers changed from: private */
    public ScheduledExecutorService mExecutorService = Executors.newScheduledThreadPool(1);
    /* access modifiers changed from: private */
    public String mPackageName;
    /* access modifiers changed from: private */
    public SharedPreferences mSP;
    private VccOfflineStatsCallback mVccOfflineStatsCallback;
    /* access modifiers changed from: private */
    public long rowId = 0;

    public void onServiceDisconnected() {
    }

    public void setEncrypt(boolean z) {
    }

    static /* synthetic */ long access$208(V3OfflineEmitter v3OfflineEmitter) {
        long j = v3OfflineEmitter.rowId;
        v3OfflineEmitter.rowId = 1 + j;
        return j;
    }

    public V3OfflineEmitter(Context context, String str) {
        super(context, str);
        this.mPackageName = context.getPackageName();
        try {
            String curProcessName = FlymeOSUtils.getCurProcessName(context);
            if (curProcessName == null || curProcessName.equals(context.getPackageName())) {
                this.mSP = this.mContext.getSharedPreferences("com.meizu.statsapp.v3.events_cache", 0);
            } else {
                Context context2 = this.mContext;
                this.mSP = context2.getSharedPreferences("com.meizu.statsapp.v3.events_cache_" + curProcessName, 0);
            }
            this.mEditor = this.mSP.edit();
            this.mExecutorService.execute(new Runnable() {
                public void run() {
                    if (V3OfflineEmitter.this.mSP.getAll().size() >= 500) {
                        Logger.m17378d(V3OfflineEmitter.TAG, "Sp data more than 500, into the clear.");
                        V3OfflineEmitter.this.mEditor.clear().commit();
                    }
                    Log.d(V3OfflineEmitter.TAG, "init thread:" + Thread.currentThread().getName());
                    for (Map.Entry<String, ?> key : V3OfflineEmitter.this.mSP.getAll().entrySet()) {
                        long parseInt = (long) Integer.parseInt((String) key.getKey());
                        if (V3OfflineEmitter.this.rowId < parseInt) {
                            long unused = V3OfflineEmitter.this.rowId = parseInt;
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mVccOfflineStatsCallback = new VccOfflineStatsCallback();
        V3RemoteServiceRequester.getInstance(context).setRemoteConnCallback(this);
    }

    public void init() {
        Logger.m17378d(TAG, "remoteInit, packageName; " + this.mPackageName + ", config: " + this.emitterConfig);
        this.mExecutorService.execute(new Runnable() {
            public void run() {
                boolean unused = V3OfflineEmitter.this.emitterConfigUpdateSuccessful = V3RemoteServiceRequester.getInstance(V3OfflineEmitter.this.mContext).emitterUpdateConfig(V3OfflineEmitter.this.mPackageName, V3OfflineEmitter.this.emitterConfig);
                V3OfflineEmitter.this.migrateOldEventsIfNecessary();
            }
        });
    }

    /* access modifiers changed from: private */
    public void migrateOldEventsIfNecessary() {
        if (this.mContext.getDatabasePath("statsapp_v3.db").exists()) {
            try {
                Logger.m17378d(TAG, "migrateOldEventsIfNecessary begin");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                LocalEventStore localEventStore = new LocalEventStore(this.mContext);
                Iterator<EmittableEvent> it = localEventStore.getEventsMax500().iterator();
                while (it.hasNext()) {
                    EmittableEvent next = it.next();
                    arrayList.add(Long.valueOf(next.getId()));
                    arrayList2.add(next.getPayload());
                    localEventStore.removeEvent(next.getId());
                }
                Logger.m17378d(TAG, "migrate ids: " + Arrays.toString(arrayList.toArray()));
                bulkAdd(arrayList, arrayList2);
                this.mContext.deleteDatabase("statsapp_v3.db");
                Logger.m17378d(TAG, "migrateOldEventsIfNecessary end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateConfig(boolean z, boolean z2, boolean z3, boolean z4, long j, int i, long j2, int i2) {
        super.updateConfig(z, z2, z3, z4, j, i, j2, i2);
        Logger.m17378d(TAG, "remoteUpdateConfig, packageName; " + this.mPackageName + ", config: " + this.emitterConfig);
        this.mExecutorService.execute(new Runnable() {
            public void run() {
                boolean unused = V3OfflineEmitter.this.emitterConfigUpdateSuccessful = V3RemoteServiceRequester.getInstance(V3OfflineEmitter.this.mContext).emitterUpdateConfig(V3OfflineEmitter.this.mPackageName, V3OfflineEmitter.this.emitterConfig);
            }
        });
    }

    public void add(final TrackerPayload trackerPayload) {
        if (this.emitterConfig.isActive()) {
            this.mExecutorService.execute(new Runnable() {
                public void run() {
                    Log.d(V3OfflineEmitter.TAG, "add thread:" + Thread.currentThread().getName());
                    if (!V3OfflineEmitter.this.emitterConfigUpdateSuccessful) {
                        boolean unused = V3OfflineEmitter.this.emitterConfigUpdateSuccessful = V3RemoteServiceRequester.getInstance(V3OfflineEmitter.this.mContext).emitterUpdateConfig(V3OfflineEmitter.this.mPackageName, V3OfflineEmitter.this.emitterConfig);
                    }
                    V3OfflineEmitter.access$208(V3OfflineEmitter.this);
                    Logger.m17378d(V3OfflineEmitter.TAG, "add rowId:" + V3OfflineEmitter.this.rowId + ",payload:" + trackerPayload.toString());
                    V3RemoteServiceRequester.getInstance(V3OfflineEmitter.this.mContext).emitterAddEvent(V3OfflineEmitter.this.mPackageName, V3OfflineEmitter.this.rowId, trackerPayload);
                    V3OfflineEmitter.this.mEditor.putString(String.valueOf(V3OfflineEmitter.this.rowId), trackerPayload.toString()).commit();
                    if (V3OfflineEmitter.this.mSP.getAll().size() >= 25) {
                        V3OfflineEmitter.this.sendCachedEventsIfNecessary();
                    }
                }
            });
        }
    }

    public void addRealtime(final TrackerPayload trackerPayload) {
        if (this.emitterConfig.isActive()) {
            this.mExecutorService.execute(new Runnable() {
                public void run() {
                    Log.d(V3OfflineEmitter.TAG, "addRealtime thread:" + Thread.currentThread().getName());
                    V3OfflineEmitter.access$208(V3OfflineEmitter.this);
                    Logger.m17378d(V3OfflineEmitter.TAG, "addRealtime rowId:" + V3OfflineEmitter.this.rowId + ",payload:" + trackerPayload.toString());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new EmittableEvent((String) null, V3OfflineEmitter.this.rowId, trackerPayload));
                    if (!V3OfflineEmitter.this.sendData(arrayList, UxipConstants.REALTIME_UPLOAD)) {
                        Logger.m17378d(V3OfflineEmitter.TAG, "convert fail realtime event to batch event, eventId: " + V3OfflineEmitter.this.rowId);
                        V3RemoteServiceRequester.getInstance(V3OfflineEmitter.this.mContext).emitterAddEvent(V3OfflineEmitter.this.mPackageName, V3OfflineEmitter.this.rowId, trackerPayload);
                        V3OfflineEmitter.this.mEditor.putString(String.valueOf(V3OfflineEmitter.this.rowId), trackerPayload.toString()).commit();
                    }
                }
            });
        }
    }

    public void addNeartime(TrackerPayload trackerPayload) {
        Logger.m17378d(TAG, "addNeartime payload:" + trackerPayload.toString());
        addRealtime(trackerPayload);
    }

    @Deprecated
    public void flush() {
        Logger.m17378d(TAG, "flush");
        if (this.mSP.getAll().size() > 0) {
            Logger.m17378d(TAG, "flush sp data");
            addCachedEventsToRemote(true);
        }
    }

    public void updateEventSource(final String str, final String str2) {
        this.mExecutorService.execute(new Runnable() {
            public void run() {
                V3RemoteServiceRequester.getInstance(V3OfflineEmitter.this.mContext).emitterUpdateEventSource(str, str2);
            }
        });
    }

    public String getUMID() {
        return V3RemoteServiceRequester.getInstance(this.mContext).emitterGetUmid(this.mPackageName);
    }

    public void onServiceConnected() {
        V3RemoteServiceRequester.getInstance(this.mContext).setCallback(this.mPackageName, this.mVccOfflineStatsCallback);
        addCachedEventsToRemote(false);
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter$VccOfflineStatsCallback */
    private class VccOfflineStatsCallback extends IVccOfflineStatsCallback.Stub {
        public void onRealInsertH5Event(String str, long j) throws RemoteException {
        }

        private VccOfflineStatsCallback() {
        }

        public void onRealInsertEvent(String str, final long j) throws RemoteException {
            Logger.m17378d(V3OfflineEmitter.TAG, "onRealInsertEvent2Remote, eventId:" + j);
            V3OfflineEmitter.this.mExecutorService.execute(new Runnable() {
                public void run() {
                    Log.d(V3OfflineEmitter.TAG, "onRealInsertEvent thread:" + Thread.currentThread().getName());
                    V3OfflineEmitter.this.mEditor.remove(String.valueOf(j)).commit();
                }
            });
        }

        public void onRealBulkInsertEvents(String str, final List list) throws RemoteException {
            Logger.m17378d(V3OfflineEmitter.TAG, "onRealBulkInsertEvents, eventIds:" + Arrays.toString(list.toArray()));
            V3OfflineEmitter.this.mExecutorService.execute(new Runnable() {
                public void run() {
                    Log.d(V3OfflineEmitter.TAG, "onRealBulkInsertEvents thread:" + Thread.currentThread().getName());
                    for (Long valueOf : list) {
                        V3OfflineEmitter.this.mEditor.remove(String.valueOf(valueOf));
                    }
                    if (!list.isEmpty()) {
                        V3OfflineEmitter.this.mEditor.commit();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void sendCachedEventsIfNecessary() {
        this.mExecutorService.execute(new Runnable() {
            public void run() {
                Log.d(V3OfflineEmitter.TAG, "sendCachedEventsIfNecessary thread:" + Thread.currentThread().getName());
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (Map.Entry next : V3OfflineEmitter.this.mSP.getAll().entrySet()) {
                    long parseInt = (long) Integer.parseInt((String) next.getKey());
                    TrackerPayload fromString = TrackerPayload.fromString((String) next.getValue());
                    if (fromString != null) {
                        arrayList.add(new EmittableEvent((String) null, parseInt, fromString));
                        i++;
                    }
                    if (i >= 200) {
                        break;
                    }
                }
                Logger.m17378d(V3OfflineEmitter.TAG, "number of cached events > 50, send " + arrayList.size() + " by myself");
                if (V3OfflineEmitter.this.sendData(arrayList, UxipConstants.BATCH_UPLOAD)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        V3OfflineEmitter.this.mEditor.remove(String.valueOf(((EmittableEvent) it.next()).getId()));
                    }
                    if (!arrayList.isEmpty()) {
                        V3OfflineEmitter.this.mEditor.commit();
                    }
                    Logger.m17378d(V3OfflineEmitter.TAG, "number of cached events > 50, sent successfully");
                } else if (V3OfflineEmitter.this.mSP.getAll().size() >= 500) {
                    Logger.m17378d(V3OfflineEmitter.TAG, "Sp data more than 500, into the clear.");
                    V3OfflineEmitter.this.mEditor.clear().commit();
                }
            }
        });
    }

    private void addCachedEventsToRemote(final boolean z) {
        this.mExecutorService.execute(new Runnable() {
            public void run() {
                Object obj;
                Log.d(V3OfflineEmitter.TAG, "addCachedEventsToRemote thread:" + Thread.currentThread().getName());
                Logger.m17378d(V3OfflineEmitter.TAG, "addCachedEventsToRemote begin");
                Map<String, ?> all = V3OfflineEmitter.this.mSP.getAll();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry next : all.entrySet()) {
                    long parseInt = (long) Integer.parseInt((String) next.getKey());
                    TrackerPayload fromString = TrackerPayload.fromString((String) next.getValue());
                    if (fromString != null) {
                        if (!z && (obj = fromString.getMap().get("time")) != null && (obj instanceof Long)) {
                            long currentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
                            if (currentTimeMillis >= 0 && currentTimeMillis < 300000) {
                            }
                        }
                        arrayList.add(Long.valueOf(parseInt));
                        arrayList2.add(fromString);
                    }
                }
                V3OfflineEmitter.this.bulkAdd(arrayList, arrayList2);
                Logger.m17378d(V3OfflineEmitter.TAG, "addCachedEventsToRemote end");
            }
        });
    }

    /* access modifiers changed from: private */
    public void bulkAdd(List<Long> list, List<TrackerPayload> list2) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != 0 && i2 % 10 == 0) {
                i++;
                int i3 = i2 - 10;
                V3RemoteServiceRequester.getInstance(this.mContext).emitterBulkAddEvents(this.mPackageName, list.subList(i3, i2), list2.subList(i3, i2));
                Logger.m17378d(TAG, "addCachedEventToRemote 1, eventIds:" + Arrays.toString(list.subList(i3, i2).toArray()));
            }
        }
        int i4 = i * 10;
        if (i4 < list.size()) {
            int size = list.size();
            V3RemoteServiceRequester.getInstance(this.mContext).emitterBulkAddEvents(this.mPackageName, list.subList(i4, size), list2.subList(i4, size));
            Logger.m17378d(TAG, "addCachedEventToRemote 2, eventIds:" + Arrays.toString(list.subList(i4, size).toArray()));
        }
    }

    /* access modifiers changed from: private */
    public boolean sendData(ArrayList<EmittableEvent> arrayList, String str) {
        boolean z = false;
        if (!NetInfoUtils.isOnline(this.mContext)) {
            Logger.m17378d(TAG, "sendData--> no network");
            return false;
        }
        String fetchOrRequestUMID = UmidFetcher.getInstance(this.mContext).fetchOrRequestUMID();
        if (TextUtils.isEmpty(fetchOrRequestUMID)) {
            Logger.m17378d(TAG, "Not flushing data to Server because no umid");
            return false;
        }
        String pkgKey = this.emitterConfig.getPkgKey();
        if (TextUtils.isEmpty(pkgKey)) {
            Logger.m17378d(TAG, "Not flushing data to Server because no pkgKey");
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            EmittableEvent emittableEvent = arrayList.get(i);
            emittableEvent.getPayload().add(Parameters.CSEQ, Long.valueOf(emittableEvent.getId()));
            emittableEvent.getPayload().add("umid", fetchOrRequestUMID);
            arrayList2.add(Long.valueOf(emittableEvent.getId()));
            arrayList3.add(emittableEvent.getPayload());
        }
        Logger.m17378d(TAG, "sendData eventIds: " + Arrays.toString(arrayList2.toArray()));
        byte[] bytes = EmitterMessageBuilder.buildEvents(arrayList3).getBytes();
        Logger.m17378d(TAG, "origData size: " + bytes.length);
        byte[] compress = C2943Utils.compress(bytes);
        String buildUri = buildUri(UxipConstants.UPLOAD_URL + pkgKey + str, compress);
        StringBuilder sb = new StringBuilder();
        sb.append("sendData buildUri ");
        sb.append(buildUri);
        Logger.m17378d(TAG, sb.toString());
        NetResponse postMultipart = HttpSecureRequester.getInstance(this.mContext).postMultipart(buildUri, (Map<String, String>) null, compress);
        if (postMultipart == null || postMultipart.getResponseBody() == null) {
            return false;
        }
        try {
            int i2 = new JSONObject(postMultipart.getResponseBody()).getInt("code");
            if (i2 == 200) {
                try {
                    Logger.m17378d(TAG, "Successfully posted to " + UxipConstants.UPLOAD_URL + pkgKey + str);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Response is: ");
                    sb2.append(postMultipart);
                    Logger.m17378d(TAG, sb2.toString());
                    return true;
                } catch (JSONException e) {
                    e = e;
                    z = true;
                    Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
                    return z;
                }
            } else if (i2 != 415) {
                return false;
            } else {
                Logger.m17378d(TAG, "415 data error " + postMultipart);
                return false;
            }
        } catch (JSONException e2) {
            e = e2;
        }
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
}
