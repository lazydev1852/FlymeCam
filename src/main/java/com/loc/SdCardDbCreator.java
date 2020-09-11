package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.loc.bx */
public class SdCardDbCreator implements DBCreator {
    /* renamed from: a */
    public final String mo13139a() {
        return "alsn20170807.db";
    }

    /* renamed from: a */
    public final void mo13140a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "SdCardDbCreator", "onCreate");
        }
    }
}
