package com.meizu.media.camera.util;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.meizu.media.camera.util.Entry;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.meizu.media.camera.util.s */
public class EntrySchema {

    /* renamed from: a */
    public static ChangeQuickRedirect f14327a;

    /* renamed from: e */
    private static final String[] f14328e = {"TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "REAL", "REAL", "NONE"};

    /* renamed from: b */
    protected final C2657a[] f14329b;

    /* renamed from: c */
    protected final String[] f14330c;

    /* renamed from: d */
    protected final String[] f14331d;

    /* renamed from: f */
    private final String f14332f;

    /* renamed from: g */
    private final boolean f14333g;

    public EntrySchema(Class<? extends Entry> cls) {
        boolean z;
        int i;
        C2657a[] b = m16250b((Class<? extends Object>) cls);
        this.f14332f = m16247a((Class<? extends Object>) cls);
        this.f14329b = b;
        int i2 = 0;
        String[] strArr = new String[0];
        if (b != null) {
            strArr = new String[b.length];
            i = 0;
            z = false;
            for (int i3 = 0; i3 != b.length; i3++) {
                C2657a aVar = b[i3];
                strArr[i3] = aVar.f14335b;
                z = aVar.f14339f ? true : z;
                if (aVar.f14342i) {
                    i++;
                }
            }
        } else {
            i = 0;
            z = false;
        }
        this.f14330c = strArr;
        this.f14333g = z;
        this.f14331d = new String[i];
        int length = b.length;
        int i4 = 0;
        while (i2 < length) {
            C2657a aVar2 = b[i2];
            if (aVar2.f14342i) {
                this.f14331d[i4] = aVar2.f14335b;
                i2++;
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public String mo22747a() {
        return this.f14332f;
    }

    /* renamed from: a */
    private void m16248a(SQLiteDatabase sQLiteDatabase, String str) {
        Class[] clsArr = {SQLiteDatabase.class, String.class};
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase, str}, this, f14327a, false, 8053, clsArr, Void.TYPE).isSupported) {
            sQLiteDatabase.execSQL(str);
        }
    }

    /* renamed from: a */
    public void mo22748a(SQLiteDatabase sQLiteDatabase) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f14327a, false, 8055, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            String str = this.f14332f;
            if (str == null) {
                z = false;
            }
            C2644av.m16100a(z);
            StringBuilder sb = new StringBuilder("CREATE TABLE ");
            sb.append(str);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
            StringBuilder sb2 = new StringBuilder();
            for (C2657a aVar : this.f14329b) {
                if (!aVar.mo22751a()) {
                    sb.append(',');
                    sb.append(aVar.f14335b);
                    sb.append(' ');
                    sb.append(f14328e[aVar.f14336c]);
                    if (!TextUtils.isEmpty(aVar.f14340g)) {
                        sb.append(" DEFAULT ");
                        sb.append(aVar.f14340g);
                    }
                    if (aVar.f14338e) {
                        if (sb2.length() == 0) {
                            sb2.append(aVar.f14335b);
                        } else {
                            sb2.append(',');
                            sb2.append(aVar.f14335b);
                        }
                    }
                }
            }
            if (sb2.length() > 0) {
                sb.append(",UNIQUE(");
                sb.append(sb2);
                sb.append(')');
            }
            sb.append(");");
            m16248a(sQLiteDatabase, sb.toString());
            sb.setLength(0);
            for (C2657a aVar2 : this.f14329b) {
                if (aVar2.f14337d) {
                    sb.append("CREATE INDEX ");
                    sb.append(str);
                    sb.append("_index_");
                    sb.append(aVar2.f14335b);
                    sb.append(" ON ");
                    sb.append(str);
                    sb.append(" (");
                    sb.append(aVar2.f14335b);
                    sb.append(");");
                    m16248a(sQLiteDatabase, sb.toString());
                    sb.setLength(0);
                }
            }
            if (this.f14333g) {
                String str2 = str + "_fulltext";
                sb.append("CREATE VIRTUAL TABLE ");
                sb.append(str2);
                sb.append(" USING FTS3 (_id INTEGER PRIMARY KEY");
                for (C2657a aVar3 : this.f14329b) {
                    if (aVar3.f14339f) {
                        String str3 = aVar3.f14335b;
                        sb.append(',');
                        sb.append(str3);
                        sb.append(" TEXT");
                    }
                }
                sb.append(");");
                m16248a(sQLiteDatabase, sb.toString());
                sb.setLength(0);
                StringBuilder sb3 = new StringBuilder("INSERT OR REPLACE INTO ");
                sb3.append(str2);
                sb3.append(" (_id");
                for (C2657a aVar4 : this.f14329b) {
                    if (aVar4.f14339f) {
                        sb3.append(',');
                        sb3.append(aVar4.f14335b);
                    }
                }
                sb3.append(") VALUES (new._id");
                for (C2657a aVar5 : this.f14329b) {
                    if (aVar5.f14339f) {
                        sb3.append(",new.");
                        sb3.append(aVar5.f14335b);
                    }
                }
                sb3.append(");");
                String sb4 = sb3.toString();
                sb.append("CREATE TRIGGER ");
                sb.append(str);
                sb.append("_insert_trigger AFTER INSERT ON ");
                sb.append(str);
                sb.append(" FOR EACH ROW BEGIN ");
                sb.append(sb4);
                sb.append("END;");
                m16248a(sQLiteDatabase, sb.toString());
                sb.setLength(0);
                sb.append("CREATE TRIGGER ");
                sb.append(str);
                sb.append("_update_trigger AFTER UPDATE ON ");
                sb.append(str);
                sb.append(" FOR EACH ROW BEGIN ");
                sb.append(sb4);
                sb.append("END;");
                m16248a(sQLiteDatabase, sb.toString());
                sb.setLength(0);
                sb.append("CREATE TRIGGER ");
                sb.append(str);
                sb.append("_delete_trigger AFTER DELETE ON ");
                sb.append(str);
                sb.append(" FOR EACH ROW BEGIN DELETE FROM ");
                sb.append(str2);
                sb.append(" WHERE _id = old._id; END;");
                m16248a(sQLiteDatabase, sb.toString());
                sb.setLength(0);
            }
        }
    }

    /* renamed from: b */
    public void mo22749b(SQLiteDatabase sQLiteDatabase) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f14327a, false, 8056, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            String str = this.f14332f;
            StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ");
            sb.append(str);
            sb.append(';');
            m16248a(sQLiteDatabase, sb.toString());
            sb.setLength(0);
            if (this.f14333g) {
                sb.append("DROP TABLE IF EXISTS ");
                sb.append(str);
                sb.append("_fulltext");
                sb.append(';');
                m16248a(sQLiteDatabase, sb.toString());
            }
        }
    }

    /* renamed from: a */
    private String m16247a(Class<? extends Object> cls) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cls}, this, f14327a, false, 8057, new Class[]{Class.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        Entry.Table table = (Entry.Table) cls.getAnnotation(Entry.Table.class);
        if (table == null) {
            return null;
        }
        return table.value();
    }

    /* renamed from: b */
    private C2657a[] m16250b(Class<? extends Object> cls) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cls}, this, f14327a, false, 8058, new Class[]{Class.class}, C2657a[].class);
        if (proxy.isSupported) {
            return (C2657a[]) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            m16249a(cls2, (ArrayList<C2657a>) arrayList);
        }
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C2657a) it.next()).f14343j = i;
            i++;
        }
        return (C2657a[]) arrayList.toArray(new C2657a[arrayList.size()]);
    }

    /* renamed from: a */
    private void m16249a(Class<? extends Object> cls, ArrayList<C2657a> arrayList) {
        int i;
        ArrayList<C2657a> arrayList2 = arrayList;
        if (!PatchProxy.proxy(new Object[]{cls, arrayList2}, this, f14327a, false, 8059, new Class[]{Class.class, ArrayList.class}, Void.TYPE).isSupported) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (int i2 = 0; i2 != declaredFields.length; i2++) {
                Field field = declaredFields[i2];
                Entry.Column column = (Entry.Column) field.getAnnotation(Entry.Column.class);
                if (column != null) {
                    Class<?> type = field.getType();
                    if (type == String.class) {
                        i = 0;
                    } else if (type == Boolean.TYPE) {
                        i = 1;
                    } else if (type == Short.TYPE) {
                        i = 2;
                    } else if (type == Integer.TYPE) {
                        i = 3;
                    } else if (type == Long.TYPE) {
                        i = 4;
                    } else if (type == Float.TYPE) {
                        i = 5;
                    } else if (type == Double.TYPE) {
                        i = 6;
                    } else if (type == byte[].class) {
                        i = 7;
                    } else {
                        throw new IllegalArgumentException("Unsupported field type for column: " + type.getName());
                    }
                    arrayList2.add(new C2657a(column.value(), i, column.indexed(), column.unique(), column.fullText(), column.defaultValue(), column.visible(), field, arrayList.size()));
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.util.s$a */
    /* compiled from: EntrySchema */
    public static final class C2657a implements Comparable<C2657a> {

        /* renamed from: a */
        public static ChangeQuickRedirect f14334a;

        /* renamed from: b */
        public final String f14335b;

        /* renamed from: c */
        public final int f14336c;

        /* renamed from: d */
        public final boolean f14337d;

        /* renamed from: e */
        public final boolean f14338e;

        /* renamed from: f */
        public final boolean f14339f;

        /* renamed from: g */
        public final String f14340g;

        /* renamed from: h */
        public final Field f14341h;

        /* renamed from: i */
        public final boolean f14342i;

        /* renamed from: j */
        public int f14343j;

        public C2657a(String str, int i, boolean z, boolean z2, boolean z3, String str2, boolean z4, Field field, int i2) {
            this.f14335b = str.toLowerCase();
            this.f14336c = i;
            this.f14337d = z;
            this.f14338e = z2;
            this.f14339f = z3;
            this.f14340g = str2;
            this.f14341h = field;
            this.f14343j = i2;
            this.f14342i = z4;
            field.setAccessible(true);
        }

        /* renamed from: a */
        public boolean mo22751a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14334a, false, 8060, new Class[0], Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "_id".equals(this.f14335b);
        }

        /* renamed from: a */
        public int compareTo(C2657a aVar) {
            if (this.f14342i != aVar.f14342i) {
                return this.f14342i ? -1 : 1;
            }
            return this.f14343j - aVar.f14343j;
        }
    }
}
