package com.meizu.statsrpk.p082a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsrpk.a.b */
public class RpkEventStoreHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f16020a = "com.meizu.statsrpk.a.b";

    /* renamed from: b */
    private static RpkEventStoreHelper f16021b;

    /* renamed from: a */
    public static synchronized RpkEventStoreHelper m17399a(Context context) {
        RpkEventStoreHelper bVar;
        synchronized (RpkEventStoreHelper.class) {
            if (f16021b == null) {
                f16021b = new RpkEventStoreHelper(context.getApplicationContext());
            }
            bVar = f16021b;
        }
        return bVar;
    }

    private RpkEventStoreHelper(Context context) {
        super(context, "statsrpk.db", (SQLiteDatabase.CursorFactory) null, 1);
        Logger.m17378d(f16020a, "DATABASE_VERSION 1");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'events' (eventId INTEGER PRIMARY KEY autoincrement, rpkPkgName TEXT, appKey TEXT, encrypt INTEGER, eventSessionId TEXT, eventData TEXT, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP, unique(eventId))");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String str = f16020a;
        Logger.m17378d(str, "Upgrading database from version " + i + " to " + i2);
    }
}
