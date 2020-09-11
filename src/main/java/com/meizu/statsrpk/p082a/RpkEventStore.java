package com.meizu.statsrpk.p082a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EventBean;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.local.storage.LocalEventStoreHelper;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.secure.SimpleCryptoAES;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.statsrpk.a.a */
public class RpkEventStore {

    /* renamed from: a */
    private static String f16013a = "a";

    /* renamed from: b */
    private final int f16014b = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;

    /* renamed from: c */
    private final int f16015c = ComponentMessageType.MSG_TYPE_ON_SHAKE;

    /* renamed from: d */
    private final int f16016d = 1000;

    /* renamed from: e */
    private SQLiteDatabase f16017e;

    /* renamed from: f */
    private RpkEventStoreHelper f16018f;

    /* renamed from: g */
    private Context f16019g;

    public RpkEventStore(Context context) {
        this.f16019g = context;
        SimpleCryptoAES.init(context);
        this.f16018f = RpkEventStoreHelper.m17399a(context);
        m17391c();
        String str = f16013a;
        Logger.m17378d(str, "DB Path:" + this.f16017e.getPath());
    }

    /* renamed from: c */
    private synchronized void m17391c() {
        if (!m17392d()) {
            this.f16017e = this.f16018f.getWritableDatabase();
            this.f16017e.enableWriteAheadLogging();
        }
    }

    /* renamed from: d */
    private boolean m17392d() {
        return this.f16017e != null && this.f16017e.isOpen();
    }

    /* renamed from: a */
    public synchronized long mo24590a(String str, String str2, TrackerPayload trackerPayload) {
        long j;
        if (m17392d()) {
            try {
                EventBean fromPayload = EventBean.fromPayload(CommonUtils.isDebugMode(this.f16019g) ? 0 : 2, trackerPayload);
                ContentValues contentValues = new ContentValues();
                contentValues.put("appKey", str);
                contentValues.put("rpkPkgName", str2);
                contentValues.put(LocalEventStoreHelper.COLUMN_SESSION_ID, fromPayload.getSessionId());
                contentValues.put(LocalEventStoreHelper.COLUMN_ENCRYPT, Integer.valueOf(fromPayload.getEncrypt()));
                contentValues.put("eventData", fromPayload.getEventData());
                j = this.f16017e.insertWithOnConflict("events", (String) null, contentValues, 5);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Logger.m17378d(f16013a, "succ add event, inserted:" + j);
        }
        j = -1;
        Logger.m17378d(f16013a, "succ add event, inserted:" + j);
        return j;
    }

    /* renamed from: a */
    public synchronized boolean mo24592a(String str, long j) {
        boolean z;
        int i = -1;
        if (m17392d()) {
            try {
                SQLiteDatabase sQLiteDatabase = this.f16017e;
                i = sQLiteDatabase.delete("events", "appKey='" + str + "' and " + LocalEventStoreHelper.COLUMN_EVENT_ID + "=" + j, (String[]) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String str2 = f16013a;
        Logger.m17378d(str2, "Removed event, appKey:" + str + ", eventId:" + j);
        z = true;
        if (i != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized void mo24591a() {
        if (m17392d()) {
            try {
                long a = m17388a("events", (String) null);
                if (a > 10000) {
                    String str = f16013a;
                    Logger.m17378d(str, "clear old events, amount of events currently in the database: " + a);
                    this.f16017e.execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return;
    }

    /* renamed from: a */
    private synchronized List<EventBean> m17390a(String str, String str2, String str3) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (m17392d()) {
            Cursor cursor = null;
            try {
                Cursor cursor2 = this.f16017e.query(str, (String[]) null, str2, (String[]) null, (String) null, (String) null, str3);
                try {
                    if (cursor2.getCount() > 0) {
                        cursor2.moveToFirst();
                        while (!cursor2.isAfterLast()) {
                            EventBean eventBean = new EventBean();
                            eventBean.setId((long) cursor2.getInt(cursor2.getColumnIndex(LocalEventStoreHelper.COLUMN_EVENT_ID)));
                            eventBean.setSessionId(cursor2.getString(cursor2.getColumnIndex(LocalEventStoreHelper.COLUMN_SESSION_ID)));
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

    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0037=Splitter:B:12:0x0037, B:22:0x0049=Splitter:B:22:0x0049} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<java.lang.String> mo24594b() {
        /*
            r13 = this;
            monitor-enter(r13)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x004f }
            r0.<init>()     // Catch:{ all -> 0x004f }
            boolean r1 = r13.m17392d()     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004d
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.f16017e     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            r3 = 1
            java.lang.String r4 = "events"
            java.lang.String r5 = "appKey"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            r2.moveToFirst()     // Catch:{ Throwable -> 0x003b }
        L_0x0025:
            boolean r1 = r2.isAfterLast()     // Catch:{ Throwable -> 0x003b }
            if (r1 != 0) goto L_0x0037
            r1 = 0
            java.lang.String r1 = r2.getString(r1)     // Catch:{ Throwable -> 0x003b }
            r0.add(r1)     // Catch:{ Throwable -> 0x003b }
            r2.moveToNext()     // Catch:{ Throwable -> 0x003b }
            goto L_0x0025
        L_0x0037:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r2)     // Catch:{ all -> 0x004f }
            goto L_0x004d
        L_0x003b:
            r1 = move-exception
            goto L_0x0044
        L_0x003d:
            r0 = move-exception
            r2 = r1
            goto L_0x0049
        L_0x0040:
            r2 = move-exception
            r12 = r2
            r2 = r1
            r1 = r12
        L_0x0044:
            r1.printStackTrace()     // Catch:{ all -> 0x0048 }
            goto L_0x0037
        L_0x0048:
            r0 = move-exception
        L_0x0049:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r2)     // Catch:{ all -> 0x004f }
            throw r0     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r13)
            return r0
        L_0x004f:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsrpk.p082a.RpkEventStore.mo24594b():java.util.List");
    }

    /* renamed from: a */
    public synchronized long mo24589a(String str) {
        return m17388a("events", "appKey='" + str + "'");
    }

    /* renamed from: a */
    private synchronized long m17388a(String str, String str2) {
        return DatabaseUtils.queryNumEntries(this.f16017e, str, str2);
    }

    /* renamed from: b */
    public synchronized ArrayList<EmittableEvent> mo24593b(String str) {
        ArrayList<EmittableEvent> arrayList;
        arrayList = new ArrayList<>();
        for (EventBean next : m17389a("appKey='" + str + "'", (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)) {
            long id = next.getId();
            TrackerPayload payload = EventBean.toPayload(next);
            if (payload != null) {
                arrayList.add(new EmittableEvent("", id, payload));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private synchronized List<EventBean> m17389a(String str, int i) {
        return m17390a("events", str, "eventId ASC LIMIT " + i);
    }
}
