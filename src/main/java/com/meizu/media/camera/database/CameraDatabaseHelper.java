package com.meizu.media.camera.database;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.util.BitmapUtils;
import com.meizu.media.camera.util.FileUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.media.camera.database.b */
public class CameraDatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f9494a;

    /* renamed from: b */
    private static LogUtil.C2630a f9495b = new LogUtil.C2630a("DatabaseHelper");

    /* renamed from: c */
    private static volatile CameraDatabaseHelper f9496c = null;

    /* renamed from: d */
    private Context f9497d;

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: a */
    public static CameraDatabaseHelper m9978a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f9494a, true, 3408, new Class[]{Context.class}, CameraDatabaseHelper.class);
        if (proxy.isSupported) {
            return (CameraDatabaseHelper) proxy.result;
        }
        if (f9496c == null) {
            synchronized (CameraDatabaseHelper.class) {
                if (f9496c == null) {
                    f9496c = new CameraDatabaseHelper(context, "camera.db", (SQLiteDatabase.CursorFactory) null, 3);
                }
            }
        }
        return f9496c;
    }

    private CameraDatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f9497d = context;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f9494a, false, 3409, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f9495b, "onCreate");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sticker_category (_id INTEGER PRIMARY KEY AUTOINCREMENT,category_id INTEGER UNIQUE, nameCN TEXT, nameTW TEXT, nameEN TEXT, has_update INTEGER NOT NULL DEFAULT 0 );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sticker (_id INTEGER PRIMARY KEY AUTOINCREMENT,sticker_id INTEGER UNIQUE, category_id TEXT, icon_url TEXT, icon BLOB, size TEXT, md5 TEXT, cp TEXT, download INTEGER NOT NULL DEFAULT 0, download_time TEXT, used INTEGER NOT NULL DEFAULT 0, is_fake INTEGER NOT NULL DEFAULT 0, has_music INTEGER NOT NULL DEFAULT 0, hot_order INTEGER NOT NULL DEFAULT 0, stick_order INTEGER NOT NULL DEFAULT 0 );");
            m9980a(sQLiteDatabase);
            m9982b(sQLiteDatabase);
            m9985e(sQLiteDatabase);
        }
    }

    /* renamed from: a */
    private void m9980a(SQLiteDatabase sQLiteDatabase) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f9494a, false, 3410, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            Resources resources = this.f9497d.getResources();
            Resources a = m9977a(resources, Locale.ENGLISH);
            String string = a.getString(R.string.mz_funny_cam_sticker_category_my);
            String string2 = a.getString(R.string.mz_funny_cam_sticker_category_hot);
            m9979a(resources);
            Resources a2 = m9977a(resources, Locale.CHINA);
            String string3 = a2.getString(R.string.mz_funny_cam_sticker_category_my);
            String string4 = a2.getString(R.string.mz_funny_cam_sticker_category_hot);
            m9979a(resources);
            Resources a3 = m9977a(resources, Locale.TAIWAN);
            String string5 = a3.getString(R.string.mz_funny_cam_sticker_category_my);
            String string6 = a3.getString(R.string.mz_funny_cam_sticker_category_hot);
            m9979a(resources);
            sQLiteDatabase.execSQL("INSERT INTO sticker_category (category_id, nameCN, nameTW, nameEN) VALUES('-1','" + string3 + "','" + string5 + "','" + string + "');");
            sQLiteDatabase.execSQL("INSERT INTO sticker_category (category_id, nameCN, nameTW, nameEN) VALUES('1','" + string4 + "','" + string6 + "','" + string2 + "');");
        }
    }

    /* renamed from: b */
    private void m9982b(SQLiteDatabase sQLiteDatabase) {
        BufferedReader bufferedReader;
        Bitmap bitmap;
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f9494a, false, 3411, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.f9497d.getAssets().open("sticker/default_sticker_info.json"), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
                bufferedReader = null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (bufferedReader != null) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                JSONArray jSONArray = new JSONArray(stringBuffer.toString());
                int length = jSONArray.length();
                LogUtil.m15942a(f9495b, "insertDefaultStiker size:" + length);
                long currentTimeMillis = System.currentTimeMillis();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("sticker_id");
                    String string2 = jSONObject.getString("category_id");
                    String string3 = jSONObject.getString("icon_file_name");
                    try {
                        bitmap = BitmapFactory.decodeStream(this.f9497d.getAssets().open("sticker" + File.separator + string3));
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        bitmap = null;
                    }
                    String string4 = jSONObject.getString("cp");
                    int i2 = jSONObject.getInt("has_music");
                    SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT INTO sticker (sticker_id, category_id, icon, cp, download, download_time, used, has_music, hot_order) VALUES(?,?,?,?,?,?,?,?,?)");
                    compileStatement.clearBindings();
                    compileStatement.bindString(1, string);
                    compileStatement.bindString(2, string2);
                    compileStatement.bindBlob(3, BitmapUtils.m16146b(bitmap));
                    compileStatement.bindString(4, string4);
                    compileStatement.bindString(5, String.valueOf(2));
                    compileStatement.bindString(6, String.valueOf(currentTimeMillis - ((long) i)));
                    compileStatement.bindString(7, String.valueOf(1));
                    compileStatement.bindString(8, String.valueOf(i2));
                    compileStatement.bindString(9, String.valueOf(i - length));
                    compileStatement.executeInsert();
                    FileUtil.m16257a(this.f9497d, "sticker/" + string + ".zip", Storage.m7750a().mo18637b(this.f9497d));
                    compileStatement.close();
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            m9983c(sQLiteDatabase);
        }
    }

    /* renamed from: c */
    private void m9983c(SQLiteDatabase sQLiteDatabase) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f9494a, false, 3412, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            for (int i = 4; i < 11; i++) {
                SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT INTO sticker (sticker_id, category_id, is_fake) VALUES(?,?,?)");
                compileStatement.clearBindings();
                compileStatement.bindString(1, String.valueOf(0 - i));
                compileStatement.bindString(2, "[1]");
                compileStatement.bindString(3, String.valueOf(1));
                compileStatement.executeInsert();
                compileStatement.close();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x01b6 A[SYNTHETIC, Splitter:B:40:0x01b6] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d8 A[SYNTHETIC, Splitter:B:46:0x01d8] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9981a(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r10
            r8 = 1
            r1[r8] = r11
            com.meizu.savior.ChangeQuickRedirect r3 = f9494a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.database.sqlite.SQLiteDatabase> r4 = android.database.sqlite.SQLiteDatabase.class
            r6[r2] = r4
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 3413(0xd55, float:4.783E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0024
            return
        L_0x0024:
            r1 = 0
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0199 }
            android.content.Context r4 = r9.f9497d     // Catch:{ Exception -> 0x0199 }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x0199 }
            java.lang.String r5 = "arsticker/defaultARSticker.zip"
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ Exception -> 0x0199 }
            com.meizu.media.camera.Storage r5 = com.meizu.media.camera.Storage.m7750a()     // Catch:{ Exception -> 0x0199 }
            android.content.Context r6 = r9.f9497d     // Catch:{ Exception -> 0x0199 }
            java.lang.String r5 = r5.mo18619a((android.content.Context) r6)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r6 = "-1"
            boolean r4 = com.meizu.media.camera.util.FileUtil.m16259a((java.lang.String) r6, (java.io.InputStream) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0199 }
            if (r4 != 0) goto L_0x0048
            return
        L_0x0048:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0199 }
            r4.<init>()     // Catch:{ Exception -> 0x0199 }
            r4.append(r5)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x0199 }
            r4.append(r6)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r6 = "-1"
            r4.append(r6)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x0199 }
            r4.append(r6)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r6 = "config.json"
            r4.append(r6)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0199 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0199 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0199 }
            boolean r6 = r6.exists()     // Catch:{ Exception -> 0x0199 }
            if (r6 != 0) goto L_0x007b
            com.meizu.media.camera.util.ac$a r10 = f9495b     // Catch:{ Exception -> 0x0199 }
            java.lang.String r11 = "ar config.json not exist!"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x0199 }
            return
        L_0x007b:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0199 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0199 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r7 = "UTF-8"
            r4.<init>(r6, r7)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r4.<init>()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
        L_0x0091:
            java.lang.String r7 = r1.readLine()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            if (r7 == 0) goto L_0x009b
            r4.append(r7)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            goto L_0x0091
        L_0x009b:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r4 = "version"
            r1.getString(r4)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r4 = "isclick"
            boolean r4 = r1.getBoolean(r4)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r7 = "ismusic"
            boolean r1 = r1.getBoolean(r7)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r7.<init>()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r7.append(r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r7.append(r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r5 = "-1"
            r7.append(r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r7.append(r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r5 = "icon.png"
            r7.append(r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFile(r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r7.<init>()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = " INTO "
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "ar_sticker"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = " ("
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "sticker_id"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = ", "
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "icon"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = ", "
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "download"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = ", "
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "download_time"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = ", "
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "used"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = ", "
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "has_music"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = ", "
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = "clickable"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = ") VALUES(?,?,?,?,?,?,?)"
            r7.append(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            android.database.sqlite.SQLiteStatement r11 = r10.compileStatement(r11)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r11.clearBindings()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            java.lang.String r7 = "-1"
            r11.bindString(r8, r7)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            byte[] r5 = com.meizu.media.camera.util.BitmapUtils.m16146b(r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r11.bindBlob(r0, r5)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r5 = 3
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r11.bindString(r5, r0)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r0 = 4
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r11.bindString(r0, r2)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r0 = 5
            java.lang.String r2 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r11.bindString(r0, r2)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r0 = 6
            if (r1 == 0) goto L_0x016b
            java.lang.String r1 = "1"
            goto L_0x016d
        L_0x016b:
            java.lang.String r1 = "0"
        L_0x016d:
            r11.bindString(r0, r1)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r0 = 7
            if (r4 == 0) goto L_0x0176
            java.lang.String r1 = "1"
            goto L_0x0178
        L_0x0176:
            java.lang.String r1 = "0"
        L_0x0178:
            r11.bindString(r0, r1)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r11.executeInsert()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r11.close()     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r9.m9984d(r10)     // Catch:{ Exception -> 0x0193, all -> 0x0191 }
            r6.close()     // Catch:{ IOException -> 0x0188 }
            goto L_0x01d5
        L_0x0188:
            r10 = move-exception
            com.meizu.media.camera.util.ac$a r11 = f9495b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x01c2
        L_0x0191:
            r10 = move-exception
            goto L_0x01d6
        L_0x0193:
            r10 = move-exception
            r1 = r6
            goto L_0x019a
        L_0x0196:
            r10 = move-exception
            r6 = r1
            goto L_0x01d6
        L_0x0199:
            r10 = move-exception
        L_0x019a:
            com.meizu.media.camera.util.ac$a r11 = f9495b     // Catch:{ all -> 0x0196 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0196 }
            r0.<init>()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "insert ar sticker err: "
            r0.append(r2)     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0196 }
            r0.append(r10)     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0196 }
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r11, (java.lang.String) r10)     // Catch:{ all -> 0x0196 }
            if (r1 == 0) goto L_0x01d5
            r1.close()     // Catch:{ IOException -> 0x01ba }
            goto L_0x01d5
        L_0x01ba:
            r10 = move-exception
            com.meizu.media.camera.util.ac$a r11 = f9495b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x01c2:
            java.lang.String r1 = "close inStream err: "
            r0.append(r1)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r11, (java.lang.String) r10)
        L_0x01d5:
            return
        L_0x01d6:
            if (r6 == 0) goto L_0x01f7
            r6.close()     // Catch:{ IOException -> 0x01dc }
            goto L_0x01f7
        L_0x01dc:
            r11 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f9495b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "close inStream err: "
            r1.append(r2)
            java.lang.String r11 = r11.getMessage()
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r11)
        L_0x01f7:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.database.CameraDatabaseHelper.m9981a(android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    /* renamed from: d */
    private void m9984d(SQLiteDatabase sQLiteDatabase) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f9494a, false, 3414, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            for (int i = 2; i < 9; i++) {
                SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT INTO ar_sticker (sticker_id, is_fake) VALUES(?,?)");
                compileStatement.clearBindings();
                compileStatement.bindString(1, String.valueOf(0 - i));
                compileStatement.bindString(2, String.valueOf(1));
                compileStatement.executeInsert();
                compileStatement.close();
            }
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f9494a, false, 3415, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            super.onOpen(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase, new Integer(i), new Integer(i2)}, this, f9494a, false, 3416, new Class[]{SQLiteDatabase.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f9495b;
            LogUtil.m15942a(aVar, "onUpgrade oldVersion: " + i + "  newVersion: " + i2);
            while (i < i2) {
                switch (i) {
                    case 1:
                        m9985e(sQLiteDatabase);
                        break;
                    case 2:
                        m9986f(sQLiteDatabase);
                        break;
                }
                i++;
            }
        }
    }

    /* renamed from: e */
    private void m9985e(SQLiteDatabase sQLiteDatabase) {
        if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f9494a, false, 3417, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f9495b, "upgradeToVersion2");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ar_sticker (_id INTEGER PRIMARY KEY AUTOINCREMENT,sticker_id INTEGER UNIQUE, name TEXT, url TEXT, icon_url TEXT, icon BLOB, link TEXT, link_img_url TEXT, link_img BLOB, md5 TEXT, download INTEGER NOT NULL DEFAULT 0, is_fake INTEGER NOT NULL DEFAULT 0, download_time TEXT, used INTEGER NOT NULL DEFAULT 0, has_music INTEGER NOT NULL DEFAULT 0, clickable INTEGER NOT NULL DEFAULT 0, need_update INTEGER NOT NULL DEFAULT 0, stick_order INTEGER NOT NULL DEFAULT 0 );");
            m9981a(sQLiteDatabase, "INSERT");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0135 A[SYNTHETIC, Splitter:B:40:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0157 A[SYNTHETIC, Splitter:B:46:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9986f(android.database.sqlite.SQLiteDatabase r9) {
        /*
            r8 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            com.meizu.savior.ChangeQuickRedirect r3 = f9494a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.database.sqlite.SQLiteDatabase> r0 = android.database.sqlite.SQLiteDatabase.class
            r6[r2] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 3418(0xd5a, float:4.79E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x001d
            return
        L_0x001d:
            com.meizu.media.camera.util.ac$a r0 = f9495b
            java.lang.String r1 = "upgradeToVersion3"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            r0 = 0
            android.content.Context r1 = r8.f9497d     // Catch:{ Exception -> 0x0118 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x0118 }
            java.lang.String r2 = "arsticker/defaultARSticker.zip"
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ Exception -> 0x0118 }
            com.meizu.media.camera.Storage r2 = com.meizu.media.camera.Storage.m7750a()     // Catch:{ Exception -> 0x0118 }
            android.content.Context r3 = r8.f9497d     // Catch:{ Exception -> 0x0118 }
            java.lang.String r2 = r2.mo18619a((android.content.Context) r3)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r3 = "-1"
            boolean r1 = com.meizu.media.camera.util.FileUtil.m16259a((java.lang.String) r3, (java.io.InputStream) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0118 }
            if (r1 != 0) goto L_0x0044
            return
        L_0x0044:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0118 }
            r1.<init>()     // Catch:{ Exception -> 0x0118 }
            r1.append(r2)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x0118 }
            r1.append(r3)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r3 = "-1"
            r1.append(r3)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x0118 }
            r1.append(r3)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r3 = "config.json"
            r1.append(r3)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0118 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0118 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0118 }
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x0118 }
            if (r3 != 0) goto L_0x0077
            com.meizu.media.camera.util.ac$a r9 = f9495b     // Catch:{ Exception -> 0x0118 }
            java.lang.String r1 = "ar config.json not exist!"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r9, (java.lang.String) r1)     // Catch:{ Exception -> 0x0118 }
            return
        L_0x0077:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0118 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0118 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r4 = "UTF-8"
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r1.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
        L_0x008d:
            java.lang.String r4 = r0.readLine()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x0097
            r1.append(r4)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            goto L_0x008d
        L_0x0097:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = "isclick"
            boolean r1 = r0.getBoolean(r1)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r4 = "ismusic"
            boolean r0 = r0.getBoolean(r4)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r4.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r4.append(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r4.append(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = "-1"
            r4.append(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r4.append(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = "icon.png"
            r4.append(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r4.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r5 = "icon"
            byte[] r2 = com.meizu.media.camera.util.BitmapUtils.m16146b(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r4.put(r5, r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = "has_music"
            if (r0 == 0) goto L_0x00e5
            java.lang.String r0 = "1"
            goto L_0x00e7
        L_0x00e5:
            java.lang.String r0 = "0"
        L_0x00e7:
            r4.put(r2, r0)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = "clickable"
            if (r1 == 0) goto L_0x00f1
            java.lang.String r1 = "1"
            goto L_0x00f3
        L_0x00f1:
            java.lang.String r1 = "0"
        L_0x00f3:
            r4.put(r0, r1)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = "sticker_id=?"
            java.lang.String r1 = "-1"
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = "ar_sticker"
            r9.update(r2, r4, r0, r1)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r3.close()     // Catch:{ IOException -> 0x0107 }
            goto L_0x0154
        L_0x0107:
            r9 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f9495b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x0141
        L_0x0110:
            r9 = move-exception
            goto L_0x0155
        L_0x0112:
            r9 = move-exception
            r0 = r3
            goto L_0x0119
        L_0x0115:
            r9 = move-exception
            r3 = r0
            goto L_0x0155
        L_0x0118:
            r9 = move-exception
        L_0x0119:
            com.meizu.media.camera.util.ac$a r1 = f9495b     // Catch:{ all -> 0x0115 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r2.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "update default ar sticker err: "
            r2.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0115 }
            r2.append(r9)     // Catch:{ all -> 0x0115 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x0115 }
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r9)     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x0154
            r0.close()     // Catch:{ IOException -> 0x0139 }
            goto L_0x0154
        L_0x0139:
            r9 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f9495b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x0141:
            java.lang.String r2 = "close inStream err: "
            r1.append(r2)
            java.lang.String r9 = r9.getMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r9)
        L_0x0154:
            return
        L_0x0155:
            if (r3 == 0) goto L_0x0176
            r3.close()     // Catch:{ IOException -> 0x015b }
            goto L_0x0176
        L_0x015b:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r1 = f9495b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "close inStream err: "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r0)
        L_0x0176:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.database.CameraDatabaseHelper.m9986f(android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: a */
    private Resources m9977a(Resources resources, Locale locale) {
        ChangeQuickRedirect changeQuickRedirect = f9494a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{resources, locale}, this, changeQuickRedirect, false, 3419, new Class[]{Resources.class, Locale.class}, Resources.class);
        if (proxy.isSupported) {
            return (Resources) proxy.result;
        }
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.locale = locale;
        return new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
    }

    /* renamed from: a */
    private void m9979a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f9494a, false, 3420, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.locale = this.f9497d.getResources().getConfiguration().locale;
            new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
        }
    }
}
