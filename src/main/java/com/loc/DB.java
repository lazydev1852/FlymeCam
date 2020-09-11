package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.loc.o */
public final class DB extends SQLiteOpenHelper {

    /* renamed from: b */
    private static boolean f3387b = true;

    /* renamed from: c */
    private static boolean f3388c = false;

    /* renamed from: a */
    private DBCreator f3389a;

    public DB(Context context, String str, DBCreator mVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f3389a = mVar;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f3389a.mo13140a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        DBCreator mVar = this.f3389a;
    }
}
