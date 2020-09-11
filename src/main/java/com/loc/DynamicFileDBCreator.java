package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.loc.v */
public final class DynamicFileDBCreator implements DBCreator {

    /* renamed from: a */
    private static DynamicFileDBCreator f3420a;

    private DynamicFileDBCreator() {
    }

    /* renamed from: b */
    public static synchronized DynamicFileDBCreator m3942b() {
        DynamicFileDBCreator vVar;
        synchronized (DynamicFileDBCreator.class) {
            if (f3420a == null) {
                f3420a = new DynamicFileDBCreator();
            }
            vVar = f3420a;
        }
        return vVar;
    }

    /* renamed from: a */
    public final String mo13139a() {
        return "dafile.db";
    }

    /* renamed from: a */
    public final void mo13140a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "DynamicFileDBCreator", "onCreate");
        }
    }
}
