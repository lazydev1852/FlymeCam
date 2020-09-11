package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.loc.n */
public final class DBOperation {

    /* renamed from: d */
    private static Map<Class<? extends DBCreator>, DBCreator> f3383d = new HashMap();

    /* renamed from: a */
    private DB f3384a;

    /* renamed from: b */
    private SQLiteDatabase f3385b;

    /* renamed from: c */
    private DBCreator f3386c;

    public DBOperation(Context context, DBCreator mVar) {
        try {
            this.f3384a = new DB(context.getApplicationContext(), mVar.mo13139a(), mVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f3386c = mVar;
    }

    /* renamed from: a */
    private static ContentValues m3891a(Object obj, EntityClass aoVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : m3898a(obj.getClass(), aoVar.mo13027b())) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(EntityField.class);
            if (annotation != null) {
                EntityField apVar = (EntityField) annotation;
                switch (apVar.mo13029b()) {
                    case 1:
                        contentValues.put(apVar.mo13028a(), Short.valueOf(field.getShort(obj)));
                        break;
                    case 2:
                        contentValues.put(apVar.mo13028a(), Integer.valueOf(field.getInt(obj)));
                        break;
                    case 3:
                        contentValues.put(apVar.mo13028a(), Float.valueOf(field.getFloat(obj)));
                        break;
                    case 4:
                        contentValues.put(apVar.mo13028a(), Double.valueOf(field.getDouble(obj)));
                        break;
                    case 5:
                        contentValues.put(apVar.mo13028a(), Long.valueOf(field.getLong(obj)));
                        break;
                    case 6:
                        contentValues.put(apVar.mo13028a(), (String) field.get(obj));
                        break;
                    case 7:
                        try {
                            contentValues.put(apVar.mo13028a(), (byte[]) field.get(obj));
                            break;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        }
                }
            }
        }
        return contentValues;
    }

    /* renamed from: a */
    private SQLiteDatabase m3892a() {
        try {
            if (this.f3385b == null || this.f3385b.isReadOnly()) {
                if (this.f3385b != null) {
                    this.f3385b.close();
                }
                this.f3385b = this.f3384a.getWritableDatabase();
            }
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "dbs", "gwd");
        }
        return this.f3385b;
    }

    /* renamed from: a */
    private SQLiteDatabase m3893a(boolean z) {
        try {
            if (this.f3385b == null) {
                this.f3385b = this.f3384a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                BasicLogHandler.m3844a(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.f3385b;
    }

    /* renamed from: a */
    public static synchronized DBCreator m3894a(Class<? extends DBCreator> cls) throws IllegalAccessException, InstantiationException {
        DBCreator mVar;
        synchronized (DBOperation.class) {
            if (f3383d.get(cls) == null) {
                f3383d.put(cls, cls.newInstance());
            }
            mVar = f3383d.get(cls);
        }
        return mVar;
    }

    /* renamed from: a */
    private static <T> T m3895a(Cursor cursor, Class<T> cls, EntityClass aoVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj;
        Field[] a = m3898a((Class<?>) cls, aoVar.mo13027b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(EntityField.class);
            if (annotation != null) {
                EntityField apVar = (EntityField) annotation;
                int b = apVar.mo13029b();
                int columnIndex = cursor.getColumnIndex(apVar.mo13028a());
                switch (b) {
                    case 1:
                        obj = Short.valueOf(cursor.getShort(columnIndex));
                        break;
                    case 2:
                        obj = Integer.valueOf(cursor.getInt(columnIndex));
                        break;
                    case 3:
                        obj = Float.valueOf(cursor.getFloat(columnIndex));
                        break;
                    case 4:
                        obj = Double.valueOf(cursor.getDouble(columnIndex));
                        break;
                    case 5:
                        obj = Long.valueOf(cursor.getLong(columnIndex));
                        break;
                    case 6:
                        obj = cursor.getString(columnIndex);
                        break;
                    case 7:
                        obj = cursor.getBlob(columnIndex);
                        break;
                }
                field.set(newInstance, obj);
            }
        }
        return newInstance;
    }

    /* renamed from: a */
    private static <T> String m3896a(EntityClass aoVar) {
        if (aoVar == null) {
            return null;
        }
        return aoVar.mo13026a();
    }

    /* renamed from: a */
    public static String m3897a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : map.keySet()) {
            if (z) {
                sb.append(next);
                sb.append(" = '");
                sb.append(map.get(next));
                sb.append("'");
                z = false;
            } else {
                sb.append(" and ");
                sb.append(next);
                sb.append(" = '");
                sb.append(map.get(next));
                sb.append("'");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static Field[] m3898a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    /* renamed from: b */
    private static <T> EntityClass m3899b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(EntityClass.class);
        if (!(annotation != null)) {
            return null;
        }
        return (EntityClass) annotation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x00fc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0065, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00d7 A[SYNTHETIC, Splitter:B:86:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00e9 A[Catch:{ Throwable -> 0x00f1 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.util.List<T> mo13299a(java.lang.String r13, java.lang.Class<T> r14, boolean r15) {
        /*
            r12 = this;
            com.loc.m r0 = r12.f3386c
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            com.loc.ao r2 = m3899b(r14)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = m3896a((com.loc.EntityClass) r2)     // Catch:{ all -> 0x00fd }
            android.database.sqlite.SQLiteDatabase r3 = r12.f3385b     // Catch:{ all -> 0x00fd }
            if (r3 != 0) goto L_0x001a
            android.database.sqlite.SQLiteDatabase r3 = r12.m3893a((boolean) r15)     // Catch:{ all -> 0x00fd }
            r12.f3385b = r3     // Catch:{ all -> 0x00fd }
        L_0x001a:
            android.database.sqlite.SQLiteDatabase r3 = r12.f3385b     // Catch:{ all -> 0x00fd }
            if (r3 == 0) goto L_0x00fb
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00fd }
            if (r3 != 0) goto L_0x00fb
            if (r13 != 0) goto L_0x0028
            goto L_0x00fb
        L_0x0028:
            r11 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.f3385b     // Catch:{ Throwable -> 0x00a1, all -> 0x009e }
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r13
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00a1, all -> 0x009e }
            if (r13 != 0) goto L_0x0068
            android.database.sqlite.SQLiteDatabase r14 = r12.f3385b     // Catch:{ Throwable -> 0x0066 }
            r14.close()     // Catch:{ Throwable -> 0x0066 }
            r12.f3385b = r11     // Catch:{ Throwable -> 0x0066 }
            if (r13 == 0) goto L_0x004e
            r13.close()     // Catch:{ Throwable -> 0x0044 }
            goto L_0x004e
        L_0x0044:
            r13 = move-exception
            if (r15 != 0) goto L_0x004e
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x004e:
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x005a }
            if (r13 == 0) goto L_0x0064
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x005a }
            r13.close()     // Catch:{ Throwable -> 0x005a }
            r12.f3385b = r11     // Catch:{ Throwable -> 0x005a }
            goto L_0x0064
        L_0x005a:
            r13 = move-exception
            if (r15 != 0) goto L_0x0064
            java.lang.String r14 = "dbs"
            java.lang.String r15 = "sld"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x0066:
            r14 = move-exception
            goto L_0x00a3
        L_0x0068:
            boolean r3 = r13.moveToNext()     // Catch:{ Throwable -> 0x0066 }
            if (r3 == 0) goto L_0x0076
            java.lang.Object r3 = m3895a((android.database.Cursor) r13, r14, (com.loc.EntityClass) r2)     // Catch:{ Throwable -> 0x0066 }
            r1.add(r3)     // Catch:{ Throwable -> 0x0066 }
            goto L_0x0068
        L_0x0076:
            if (r13 == 0) goto L_0x0086
            r13.close()     // Catch:{ Throwable -> 0x007c }
            goto L_0x0086
        L_0x007c:
            r13 = move-exception
            if (r15 != 0) goto L_0x0086
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x0086:
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x0093 }
            if (r13 == 0) goto L_0x00f9
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x0093 }
            r13.close()     // Catch:{ Throwable -> 0x0093 }
            r12.f3385b = r11     // Catch:{ Throwable -> 0x0093 }
            goto L_0x00f9
        L_0x0093:
            r13 = move-exception
            if (r15 != 0) goto L_0x00f9
            java.lang.String r14 = "dbs"
            java.lang.String r15 = "sld"
        L_0x009a:
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
            goto L_0x00f9
        L_0x009e:
            r14 = move-exception
            r13 = r11
            goto L_0x00ae
        L_0x00a1:
            r14 = move-exception
            r13 = r11
        L_0x00a3:
            if (r15 != 0) goto L_0x00d5
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "sld"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r14, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ad }
            goto L_0x00d5
        L_0x00ad:
            r14 = move-exception
        L_0x00ae:
            if (r13 == 0) goto L_0x00be
            r13.close()     // Catch:{ Throwable -> 0x00b4 }
            goto L_0x00be
        L_0x00b4:
            r13 = move-exception
            if (r15 != 0) goto L_0x00be
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "sld"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r13, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x00be:
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x00ca }
            if (r13 == 0) goto L_0x00d4
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x00ca }
            r13.close()     // Catch:{ Throwable -> 0x00ca }
            r12.f3385b = r11     // Catch:{ Throwable -> 0x00ca }
            goto L_0x00d4
        L_0x00ca:
            r13 = move-exception
            if (r15 != 0) goto L_0x00d4
            java.lang.String r15 = "dbs"
            java.lang.String r1 = "sld"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r13, (java.lang.String) r15, (java.lang.String) r1)     // Catch:{ all -> 0x00fd }
        L_0x00d4:
            throw r14     // Catch:{ all -> 0x00fd }
        L_0x00d5:
            if (r13 == 0) goto L_0x00e5
            r13.close()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00e5
        L_0x00db:
            r13 = move-exception
            if (r15 != 0) goto L_0x00e5
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x00e5:
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x00f1 }
            if (r13 == 0) goto L_0x00f9
            android.database.sqlite.SQLiteDatabase r13 = r12.f3385b     // Catch:{ Throwable -> 0x00f1 }
            r13.close()     // Catch:{ Throwable -> 0x00f1 }
            r12.f3385b = r11     // Catch:{ Throwable -> 0x00f1 }
            goto L_0x00f9
        L_0x00f1:
            r13 = move-exception
            if (r15 != 0) goto L_0x00f9
            java.lang.String r14 = "dbs"
            java.lang.String r15 = "sld"
            goto L_0x009a
        L_0x00f9:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x00fb:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x00fd:
            r13 = move-exception
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DBOperation.mo13299a(java.lang.String, java.lang.Class, boolean):java.util.List");
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final <T> void mo13300a(T t) {
        synchronized (this.f3386c) {
            this.f3385b = m3892a();
            if (this.f3385b != null) {
                try {
                    SQLiteDatabase sQLiteDatabase = this.f3385b;
                    EntityClass b = m3899b(t.getClass());
                    String a = m3896a(b);
                    if (!TextUtils.isEmpty(a) && t != null) {
                        if (sQLiteDatabase != null) {
                            ContentValues a2 = m3891a((Object) t, b);
                            if (a2 != null) {
                                sQLiteDatabase.insert(a, (String) null, a2);
                            }
                        }
                    }
                    if (this.f3385b != null) {
                        this.f3385b.close();
                        this.f3385b = null;
                    }
                } catch (Throwable th) {
                    try {
                        BasicLogHandler.m3844a(th, "dbs", "itd");
                        if (this.f3385b != null) {
                            this.f3385b.close();
                        }
                    } catch (Throwable th2) {
                        if (this.f3385b != null) {
                            this.f3385b.close();
                            this.f3385b = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo13301a(Object obj, String str) {
        synchronized (this.f3386c) {
            List<?> a = mo13299a(str, obj.getClass(), false);
            if (a != null) {
                if (a.size() != 0) {
                    mo13303a(str, obj);
                }
            }
            mo13300a(obj);
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final <T> void mo13302a(String str, Class<T> cls) {
        synchronized (this.f3386c) {
            String a = m3896a(m3899b(cls));
            if (!TextUtils.isEmpty(a)) {
                this.f3385b = m3892a();
                if (this.f3385b != null) {
                    try {
                        this.f3385b.delete(a, str, (String[]) null);
                        if (this.f3385b != null) {
                            this.f3385b.close();
                            this.f3385b = null;
                        }
                    } catch (Throwable th) {
                        try {
                            BasicLogHandler.m3844a(th, "dbs", "dld");
                            if (this.f3385b != null) {
                                this.f3385b.close();
                            }
                        } catch (Throwable th2) {
                            if (this.f3385b != null) {
                                this.f3385b.close();
                                this.f3385b = null;
                            }
                            throw th2;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final <T> void mo13303a(String str, Object obj) {
        synchronized (this.f3386c) {
            if (obj != null) {
                EntityClass b = m3899b(obj.getClass());
                String a = m3896a(b);
                if (!TextUtils.isEmpty(a)) {
                    ContentValues a2 = m3891a(obj, b);
                    if (a2 != null) {
                        this.f3385b = m3892a();
                        if (this.f3385b != null) {
                            try {
                                this.f3385b.update(a, a2, str, (String[]) null);
                                if (this.f3385b != null) {
                                    this.f3385b.close();
                                    this.f3385b = null;
                                }
                            } catch (Throwable th) {
                                try {
                                    BasicLogHandler.m3844a(th, "dbs", "udd");
                                    if (this.f3385b != null) {
                                        this.f3385b.close();
                                    }
                                } catch (Throwable th2) {
                                    if (this.f3385b != null) {
                                        this.f3385b.close();
                                        this.f3385b = null;
                                    }
                                    throw th2;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final <T> List<T> mo13304b(String str, Class<T> cls) {
        return mo13299a(str, cls, false);
    }
}
