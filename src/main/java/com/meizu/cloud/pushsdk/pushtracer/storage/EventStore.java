package com.meizu.cloud.pushsdk.pushtracer.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.pushtracer.dataload.DataLoad;
import com.meizu.cloud.pushsdk.pushtracer.dataload.TrackerDataload;
import com.meizu.cloud.pushsdk.pushtracer.emitter.EmittableEvents;
import com.meizu.cloud.pushsdk.pushtracer.utils.Logger;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EventStore implements Store {
    private String TAG = EventStore.class.getSimpleName();
    private String[] allColumns = {"id", "eventData", "dateCreated"};
    private SQLiteDatabase database;
    private EventStoreHelper dbHelper;
    private long lastInsertedRowId = -1;
    private int sendLimit;

    public EventStore(Context context, int i) {
        this.dbHelper = EventStoreHelper.getInstance(context, getDataBaseName(context));
        open();
        this.sendLimit = i;
    }

    private String getDataBaseName(Context context) {
        String processName = MzSystemUtils.getProcessName(context);
        if (TextUtils.isEmpty(processName)) {
            return EventStoreHelper.DATABASE_NAME;
        }
        return processName + "_" + EventStoreHelper.DATABASE_NAME;
    }

    public void add(DataLoad dataLoad) {
        insertEvent(dataLoad);
    }

    public boolean isOpen() {
        return isDatabaseOpen();
    }

    public void open() {
        if (!isDatabaseOpen()) {
            try {
                this.database = this.dbHelper.getWritableDatabase();
                this.database.enableWriteAheadLogging();
            } catch (Exception e) {
                String str = this.TAG;
                Logger.m4855e(str, " open database error " + e.getMessage(), new Object[0]);
            }
        }
    }

    public void close() {
        this.dbHelper.close();
    }

    public long insertEvent(DataLoad dataLoad) {
        if (isDatabaseOpen()) {
            byte[] serialize = serialize(dataLoad.getMap());
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("eventData", serialize);
            this.lastInsertedRowId = this.database.insert("events", (String) null, contentValues);
        }
        String str = this.TAG;
        Logger.m4854d(str, "Added event to database: " + this.lastInsertedRowId, new Object[0]);
        return this.lastInsertedRowId;
    }

    public boolean removeEvent(long j) {
        int i;
        if (isDatabaseOpen()) {
            SQLiteDatabase sQLiteDatabase = this.database;
            i = sQLiteDatabase.delete("events", "id=" + j, (String[]) null);
        } else {
            i = -1;
        }
        String str = this.TAG;
        Logger.m4854d(str, "Removed event from database: " + j, new Object[0]);
        return i == 1;
    }

    public boolean removeAllEvents() {
        int delete = isDatabaseOpen() ? this.database.delete("events", (String) null, (String[]) null) : -1;
        Logger.m4854d(this.TAG, "Removing all events from database.", new Object[0]);
        return delete == 0;
    }

    public static byte[] serialize(Map<String, String> map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> deserializer(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Map<String, Object>> queryDatabase(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (isDatabaseOpen()) {
            Cursor query = this.database.query("events", this.allColumns, str, (String[]) null, (String) null, (String) null, str2);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", Long.valueOf(query.getLong(0)));
                hashMap.put("eventData", deserializer(query.getBlob(1)));
                hashMap.put("dateCreated", query.getString(2));
                query.moveToNext();
                arrayList.add(hashMap);
            }
            query.close();
        }
        return arrayList;
    }

    public long getSize() {
        if (isDatabaseOpen()) {
            return DatabaseUtils.queryNumEntries(this.database, "events");
        }
        return 0;
    }

    public long getLastInsertedRowId() {
        return this.lastInsertedRowId;
    }

    public EmittableEvents getEmittableEvents() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (Map next : getDescEventsInRange(this.sendLimit)) {
            TrackerDataload trackerDataload = new TrackerDataload();
            trackerDataload.addMap((Map) next.get("eventData"));
            linkedList.add((Long) next.get("id"));
            arrayList.add(trackerDataload);
        }
        return new EmittableEvents(arrayList, linkedList);
    }

    public Map<String, Object> getEvent(long j) {
        List<Map<String, Object>> queryDatabase = queryDatabase("id=" + j, (String) null);
        if (!queryDatabase.isEmpty()) {
            return queryDatabase.get(0);
        }
        return null;
    }

    public List<Map<String, Object>> getAllEvents() {
        return queryDatabase((String) null, (String) null);
    }

    public List<Map<String, Object>> getDescEventsInRange(int i) {
        return queryDatabase((String) null, "id ASC LIMIT " + i);
    }

    public boolean isDatabaseOpen() {
        return this.database != null && this.database.isOpen();
    }
}
