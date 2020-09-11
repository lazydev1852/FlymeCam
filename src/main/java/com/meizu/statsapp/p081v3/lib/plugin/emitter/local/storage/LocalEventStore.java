package com.meizu.statsapp.p081v3.lib.plugin.emitter.local.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EventBean;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.secure.SimpleCryptoAES;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.local.storage.LocalEventStore */
public class LocalEventStore {
    private static final String TAG = "LocalEventStore";
    private final int CLEAR_KEEP_LIMIT = 1000;
    private final int CLEAR_THRESHOLD = ComponentMessageType.MSG_TYPE_ON_SHAKE;
    private final int ONCE_EMIT_LIMIT = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private boolean encrypt = true;
    private Context mContext;
    private LocalEventStoreHelper mDBHelper;
    private SQLiteDatabase mDatabase;

    public LocalEventStore(Context context) {
        this.mContext = context;
        SimpleCryptoAES.init(context);
        this.mDBHelper = LocalEventStoreHelper.getInstance(context);
        open();
        if (isDatabaseOpen()) {
            Logger.m17378d(TAG, "DB Path:" + this.mDatabase.getPath());
        }
    }

    private synchronized void open() {
        if (!isDatabaseOpen()) {
            try {
                this.mDatabase = this.mDBHelper.getWritableDatabase();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return;
    }

    private boolean isDatabaseOpen() {
        boolean z = this.mDatabase != null && this.mDatabase.isOpen();
        if (!z) {
            Logger.m17378d(TAG, "database NOT open!");
        }
        return z;
    }

    public synchronized void close() {
        this.mDBHelper.close();
    }

    public synchronized void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public synchronized long insertEvent(TrackerPayload trackerPayload) {
        long j;
        j = -1;
        if (isDatabaseOpen()) {
            try {
                EventBean fromPayload = EventBean.fromPayload(this.encrypt ? 2 : 0, trackerPayload);
                ContentValues contentValues = new ContentValues();
                contentValues.put(LocalEventStoreHelper.COLUMN_SESSION_ID, fromPayload.getSessionId());
                contentValues.put(LocalEventStoreHelper.COLUMN_EVENT_SOURCE, fromPayload.getEventSource());
                contentValues.put(LocalEventStoreHelper.COLUMN_ENCRYPT, Integer.valueOf(fromPayload.getEncrypt()));
                contentValues.put("eventData", fromPayload.getEventData());
                j = this.mDatabase.insert("events", (String) null, contentValues);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Logger.m17378d(TAG, "Added event:" + j);
        return j;
    }

    public synchronized void updateLastResetTime(long j) {
        if (isDatabaseOpen()) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(LocalEventStoreHelper.COLUMN_LAST_RESET_TIME, Long.valueOf(j));
                if (getSize(LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, (String) null) == 1) {
                    this.mDatabase.update(LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, contentValues, (String) null, (String[]) null);
                } else {
                    this.mDatabase.insertWithOnConflict(LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, (String) null, contentValues, 4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return;
    }

    public synchronized void updateTraffic(int i) {
        if (isDatabaseOpen()) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(LocalEventStoreHelper.COLUMN_TRAFFIC, Integer.valueOf(i));
                if (getSize(LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, (String) null) == 1) {
                    this.mDatabase.update(LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, contentValues, (String) null, (String[]) null);
                } else {
                    this.mDatabase.insertWithOnConflict(LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, (String) null, contentValues, 4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return;
    }

    public synchronized long getLastResetTime() {
        long j;
        j = 0;
        if (isDatabaseOpen()) {
            Cursor cursor = null;
            try {
                Cursor query = this.mDatabase.query(true, LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, new String[]{LocalEventStoreHelper.COLUMN_LAST_RESET_TIME}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                try {
                    if (query.moveToFirst()) {
                        j = query.getLong(0);
                    }
                    CommonUtils.closeQuietly(query);
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    CommonUtils.closeQuietly(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                CommonUtils.closeQuietly(cursor);
                return j;
            }
        }
        return j;
    }

    public synchronized int getTraffic() {
        int i;
        i = 0;
        if (isDatabaseOpen()) {
            Cursor cursor = null;
            try {
                Cursor query = this.mDatabase.query(true, LocalEventStoreHelper.TABLE_EMITTER_MISCELLANEOUS, new String[]{LocalEventStoreHelper.COLUMN_TRAFFIC}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                try {
                    if (query.moveToFirst()) {
                        i = query.getInt(0);
                    }
                    CommonUtils.closeQuietly(query);
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    CommonUtils.closeQuietly(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                CommonUtils.closeQuietly(cursor);
                return i;
            }
        }
        return i;
    }

    public synchronized boolean removeEvent(long j) {
        boolean z;
        int i = -1;
        if (isDatabaseOpen()) {
            try {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                i = sQLiteDatabase.delete("events", "eventId=" + j, (String[]) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Logger.m17378d(TAG, "Removed event, eventId:" + j);
        z = true;
        if (i != 1) {
            z = false;
        }
        return z;
    }

    public synchronized void clearOldEventsIfNecessary() {
        if (isDatabaseOpen()) {
            try {
                long eventsCount = getEventsCount((String) null);
                if (eventsCount > 10000) {
                    Logger.m17378d(TAG, "clear old events, amount of events currently in the database: " + eventsCount);
                    this.mDatabase.execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return;
    }

    private synchronized List<EventBean> queryDatabase(String str, String str2, String str3) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (isDatabaseOpen()) {
            Cursor cursor = null;
            try {
                Cursor cursor2 = this.mDatabase.query(str, (String[]) null, str2, (String[]) null, (String) null, (String) null, str3);
                try {
                    if (cursor2.getCount() > 0) {
                        cursor2.moveToFirst();
                        while (!cursor2.isAfterLast()) {
                            EventBean eventBean = new EventBean();
                            eventBean.setId((long) cursor2.getInt(cursor2.getColumnIndex(LocalEventStoreHelper.COLUMN_EVENT_ID)));
                            eventBean.setSessionId(cursor2.getString(cursor2.getColumnIndex(LocalEventStoreHelper.COLUMN_SESSION_ID)));
                            eventBean.setEventSource(cursor2.getString(cursor2.getColumnIndex(LocalEventStoreHelper.COLUMN_EVENT_SOURCE)));
                            eventBean.setEncrypt(cursor2.getInt(cursor2.getColumnIndex(LocalEventStoreHelper.COLUMN_ENCRYPT)));
                            eventBean.setEventData(cursor2.getString(cursor2.getColumnIndex("eventData")));
                            eventBean.setDateCreated(cursor2.getString(cursor2.getColumnIndex("dateCreated")));
                            arrayList.add(eventBean);
                            cursor2.moveToNext();
                        }
                    }
                    CommonUtils.closeQuietly(cursor2);
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeQuietly(cursor2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                CommonUtils.closeQuietly(cursor);
                return arrayList;
            }
        }
        return arrayList;
    }

    private synchronized long getSize(String str, String str2) {
        if (isDatabaseOpen()) {
            try {
                return DatabaseUtils.queryNumEntries(this.mDatabase, str, str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0;
    }

    public synchronized ArrayList<EmittableEvent> getEmittableEvents() {
        ArrayList<EmittableEvent> arrayList;
        arrayList = new ArrayList<>();
        if (isDatabaseOpen()) {
            try {
                for (EventBean next : getAscEventsLimit((String) null, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)) {
                    long id = next.getId();
                    TrackerPayload payload = EventBean.toPayload(next);
                    if (payload != null) {
                        arrayList.add(new EmittableEvent("", id, payload));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<EmittableEvent> getEventsMax500() {
        ArrayList<EmittableEvent> arrayList;
        arrayList = new ArrayList<>();
        if (isDatabaseOpen()) {
            try {
                for (EventBean next : getAscEventsLimit((String) null, 500)) {
                    long id = next.getId();
                    TrackerPayload payload = EventBean.toPayload(next);
                    if (payload != null) {
                        arrayList.add(new EmittableEvent("", id, payload));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public synchronized long getEventsCount(String str) {
        if (isDatabaseOpen()) {
            try {
                return DatabaseUtils.queryNumEntries(this.mDatabase, "events", str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0;
    }

    public synchronized EventBean getEventByRowId(long j) {
        if (isDatabaseOpen()) {
            try {
                List<EventBean> queryDatabase = queryDatabase("events", "eventId=" + j, (String) null);
                if (!queryDatabase.isEmpty()) {
                    return queryDatabase.get(0);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public synchronized List<EventBean> getEvents(long j, int i) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList();
        }
        return queryDatabase("events", "eventId >= " + j, "eventId ASC LIMIT " + i);
    }

    public synchronized List<EventBean> getDescEventsLimit(String str, int i) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList();
        }
        return queryDatabase("events", str, "eventId DESC LIMIT " + i);
    }

    public synchronized List<EventBean> getAscEventsLimit(String str, int i) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList();
        }
        return queryDatabase("events", str, "eventId ASC LIMIT " + i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean updateEventSource(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.isDatabaseOpen()     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Throwable -> 0x0036 }
            r0.<init>()     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r2 = "eventSource"
            r0.put(r2, r7)     // Catch:{ Throwable -> 0x0036 }
            android.database.sqlite.SQLiteDatabase r7 = r5.mDatabase     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r2 = "events"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0036 }
            r3.<init>()     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r4 = "eventSessionId='"
            r3.append(r4)     // Catch:{ Throwable -> 0x0036 }
            r3.append(r6)     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r6 = "'"
            r3.append(r6)     // Catch:{ Throwable -> 0x0036 }
            java.lang.String r6 = r3.toString()     // Catch:{ Throwable -> 0x0036 }
            r3 = 0
            int r6 = r7.update(r2, r0, r6, r3)     // Catch:{ Throwable -> 0x0036 }
            if (r6 <= 0) goto L_0x0034
            r1 = 1
        L_0x0034:
            monitor-exit(r5)
            return r1
        L_0x0036:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r5)
            return r1
        L_0x003c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.emitter.local.storage.LocalEventStore.updateEventSource(java.lang.String, java.lang.String):boolean");
    }
}
