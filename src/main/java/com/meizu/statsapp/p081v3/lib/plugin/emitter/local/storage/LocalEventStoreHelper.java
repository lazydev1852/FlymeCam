package com.meizu.statsapp.p081v3.lib.plugin.emitter.local.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.local.storage.LocalEventStoreHelper */
public class LocalEventStoreHelper extends SQLiteOpenHelper {
    public static final String COLUMN_DATE_CREATED = "dateCreated";
    public static final String COLUMN_ENCRYPT = "encrypt";
    public static final String COLUMN_EVENT_DATA = "eventData";
    public static final String COLUMN_EVENT_ID = "eventId";
    public static final String COLUMN_EVENT_SOURCE = "eventSource";
    public static final String COLUMN_LAST_RESET_TIME = "lastResetTime";
    public static final String COLUMN_SESSION_ID = "eventSessionId";
    public static final String COLUMN_TRAFFIC = "traffic";
    private static final String DATABASE_NAME = "statsapp_v3.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_EMITTER_MISCELLANEOUS = "emitterMiscellaneous";
    public static final String TABLE_EVENTS = "events";
    private static final String TAG = "com.meizu.statsapp.v3.lib.plugin.emitter.local.storage.LocalEventStoreHelper";
    private static final String queryCreateEmitterMiscellaneousTable = "CREATE TABLE IF NOT EXISTS 'emitterMiscellaneous' (lastResetTime BIGINT, traffic INTEGER)";
    private static final String queryCreateTable = "CREATE TABLE IF NOT EXISTS 'events' (eventId INTEGER PRIMARY KEY autoincrement, encrypt INTEGER, eventSessionId TEXT, eventSource TEXT, eventData TEXT, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
    private static final String queryDropEmitterMiscellaneousTable = "DROP TABLE IF EXISTS 'emitterMiscellaneous'";
    private static final String queryDropTable = "DROP TABLE IF EXISTS 'events'";
    private static LocalEventStoreHelper sInstance;

    public static synchronized LocalEventStoreHelper getInstance(Context context) {
        LocalEventStoreHelper localEventStoreHelper;
        String str;
        synchronized (LocalEventStoreHelper.class) {
            if (sInstance == null) {
                String curProcessName = FlymeOSUtils.getCurProcessName(context);
                if (curProcessName == null || curProcessName.equals(context.getPackageName())) {
                    str = DATABASE_NAME;
                } else {
                    str = "statsapp_v3.db_" + curProcessName;
                }
                sInstance = new LocalEventStoreHelper(context.getApplicationContext(), str);
            }
            localEventStoreHelper = sInstance;
        }
        return localEventStoreHelper;
    }

    private LocalEventStoreHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(queryCreateTable);
        sQLiteDatabase.execSQL(queryCreateEmitterMiscellaneousTable);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String str = TAG;
        Logger.m17378d(str, "Upgrading database from version " + i + " to " + i2);
    }
}
