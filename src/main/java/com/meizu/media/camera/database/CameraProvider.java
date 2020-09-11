package com.meizu.media.camera.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.p020ar.base.MsgField;
import com.meizu.media.camera.database.CameraContract;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.Constants;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class CameraProvider extends ContentProvider {

    /* renamed from: a */
    public static ChangeQuickRedirect f9483a;

    /* renamed from: b */
    private static final LogUtil.C2630a f9484b = new LogUtil.C2630a("CameraProvider");

    /* renamed from: d */
    private static final UriMatcher f9485d = new UriMatcher(-1);

    /* renamed from: e */
    private static final ProjectionMap f9486e = ProjectionMap.m9987a().mo19974a("_id").mo19974a("category_id").mo19974a("nameCN").mo19974a("nameTW").mo19974a("nameEN").mo19974a("has_update").mo19975a();

    /* renamed from: f */
    private static final ProjectionMap f9487f = ProjectionMap.m9987a().mo19974a("_id").mo19974a("sticker_id").mo19974a("category_id").mo19974a("icon_url").mo19974a("icon").mo19974a("size").mo19974a("md5").mo19974a("download").mo19974a("download_time").mo19974a("used").mo19974a("cp").mo19974a("has_music").mo19974a("is_fake").mo19974a("hot_order").mo19974a("stick_order").mo19975a();

    /* renamed from: g */
    private static final ProjectionMap f9488g = ProjectionMap.m9987a().mo19974a("_id").mo19974a("sticker_id").mo19974a("name").mo19974a("url").mo19974a("icon_url").mo19974a("icon").mo19974a(Constants.KEY_LINK).mo19974a("link_img_url").mo19974a("link_img").mo19974a("md5").mo19974a("download").mo19974a("download_time").mo19974a("used").mo19974a("has_music").mo19974a("need_update").mo19974a("is_fake").mo19974a("clickable").mo19974a("stick_order").mo19975a();

    /* renamed from: c */
    private CameraDatabaseHelper f9489c;

    public String getType(Uri uri) {
        return null;
    }

    static {
        f9485d.addURI("com.meizu.flyme.camera", "stickerCategory", 1000);
        f9485d.addURI("com.meizu.flyme.camera", "sticker", MsgField.IMSG_SAVE_PICTURE);
        f9485d.addURI("com.meizu.flyme.camera", "sticker/*", 3000);
        f9485d.addURI("com.meizu.flyme.camera", "arSticker", 4000);
        f9485d.addURI("com.meizu.flyme.camera", "arSticker/*", 5000);
    }

    public boolean onCreate() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9483a, false, 3421, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f9489c = CameraDatabaseHelper.m9978a(getContext());
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r20, java.lang.String[] r21, java.lang.String r22, java.lang.String[] r23, java.lang.String r24) {
        /*
            r19 = this;
            r0 = r20
            r1 = 5
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r9 = 0
            r2[r9] = r0
            r10 = 1
            r2[r10] = r21
            r3 = 2
            r2[r3] = r22
            r4 = 3
            r2[r4] = r23
            r5 = 4
            r2[r5] = r24
            com.meizu.savior.ChangeQuickRedirect r6 = f9483a
            java.lang.Class[] r7 = new java.lang.Class[r1]
            java.lang.Class<android.net.Uri> r1 = android.net.Uri.class
            r7[r9] = r1
            java.lang.Class<java.lang.String[]> r1 = java.lang.String[].class
            r7[r10] = r1
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r7[r3] = r1
            java.lang.Class<java.lang.String[]> r1 = java.lang.String[].class
            r7[r4] = r1
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r7[r5] = r1
            java.lang.Class<android.database.Cursor> r8 = android.database.Cursor.class
            r5 = 0
            r1 = 3422(0xd5e, float:4.795E-42)
            r3 = r19
            r4 = r6
            r6 = r1
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r2, r3, r4, r5, r6, r7, r8)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0042
            java.lang.Object r0 = r1.result
            android.database.Cursor r0 = (android.database.Cursor) r0
            return r0
        L_0x0042:
            r1 = r19
            com.meizu.media.camera.database.b r2 = r1.f9489c
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()
            android.database.sqlite.SQLiteQueryBuilder r3 = new android.database.sqlite.SQLiteQueryBuilder
            r3.<init>()
            r16 = 0
            android.content.UriMatcher r4 = f9485d
            int r4 = r4.match(r0)
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r4 == r5) goto L_0x00ae
            r5 = 2000(0x7d0, float:2.803E-42)
            if (r4 == r5) goto L_0x00a3
            r5 = 3000(0xbb8, float:4.204E-42)
            if (r4 == r5) goto L_0x008c
            r5 = 4000(0xfa0, float:5.605E-42)
            if (r4 == r5) goto L_0x0081
            r5 = 5000(0x1388, float:7.006E-42)
            if (r4 == r5) goto L_0x006c
            goto L_0x00bf
        L_0x006c:
            java.lang.String r4 = r20.getLastPathSegment()
            com.meizu.media.camera.database.c r5 = f9488g
            r3.setProjectionMap(r5)
            java.lang.String r5 = "ar_sticker"
            r3.setTables(r5)
            java.lang.String r5 = "sticker_id=?"
            java.lang.String[] r6 = new java.lang.String[r10]
            r6[r9] = r4
            goto L_0x00a0
        L_0x0081:
            com.meizu.media.camera.database.c r4 = f9488g
            r3.setProjectionMap(r4)
            java.lang.String r4 = "ar_sticker"
            r3.setTables(r4)
            goto L_0x00bf
        L_0x008c:
            java.lang.String r4 = r20.getLastPathSegment()
            com.meizu.media.camera.database.c r5 = f9487f
            r3.setProjectionMap(r5)
            java.lang.String r5 = "sticker"
            r3.setTables(r5)
            java.lang.String r5 = "sticker_id=?"
            java.lang.String[] r6 = new java.lang.String[r10]
            r6[r9] = r4
        L_0x00a0:
            r14 = r5
            r15 = r6
            goto L_0x00c3
        L_0x00a3:
            com.meizu.media.camera.database.c r4 = f9487f
            r3.setProjectionMap(r4)
            java.lang.String r4 = "sticker"
            r3.setTables(r4)
            goto L_0x00bf
        L_0x00ae:
            com.meizu.media.camera.util.ac$a r4 = f9484b
            java.lang.String r5 = "query STICKER_CATEGORY"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r5)
            com.meizu.media.camera.database.c r4 = f9486e
            r3.setProjectionMap(r4)
            java.lang.String r4 = "sticker_category"
            r3.setTables(r4)
        L_0x00bf:
            r14 = r22
            r15 = r23
        L_0x00c3:
            r17 = 0
            r11 = r3
            r12 = r2
            r13 = r21
            r18 = r24
            android.database.Cursor r2 = r11.query(r12, r13, r14, r15, r16, r17, r18)
            if (r2 == 0) goto L_0x00dc
            android.content.Context r3 = r19.getContext()
            android.content.ContentResolver r3 = r3.getContentResolver()
            r2.setNotificationUri(r3, r0)
        L_0x00dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.database.CameraProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX INFO: finally extract failed */
    public Uri insert(Uri uri, ContentValues contentValues) {
        long j;
        Uri uri2 = uri;
        ContentValues contentValues2 = contentValues;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uri2, contentValues2}, this, f9483a, false, 3423, new Class[]{Uri.class, ContentValues.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        SQLiteDatabase writableDatabase = this.f9489c.getWritableDatabase();
        int match = f9485d.match(uri2);
        long j2 = 0;
        if (match == 1000) {
            try {
                j = writableDatabase.insert("sticker_category", (String) null, contentValues2);
                LogUtil.C2630a aVar = f9484b;
                LogUtil.m15942a(aVar, "insert id:" + j);
                mo19959a(CameraContract.C2037c.f9493a);
            } catch (SQLiteConstraintException e) {
                LogUtil.m15950b(f9484b, "insert error", e);
                e.printStackTrace();
                return null;
            }
        } else if (match == 2000) {
            Boolean asBoolean = contentValues2.getAsBoolean("update_if_exist");
            boolean booleanValue = asBoolean != null ? asBoolean.booleanValue() : false;
            contentValues2.remove("update_if_exist");
            if (!booleanValue) {
                try {
                    j = writableDatabase.insert("sticker", (String) null, contentValues2);
                } catch (SQLiteConstraintException e2) {
                    LogUtil.C2630a aVar2 = f9484b;
                    LogUtil.m15949b(aVar2, "insert error:" + e2.getMessage());
                    e2.printStackTrace();
                    return null;
                }
            } else {
                String asString = contentValues2.getAsString("sticker_id");
                String asString2 = contentValues2.getAsString("category_id");
                Cursor query = writableDatabase.query("sticker", new String[]{"category_id"}, "sticker_id=?", new String[]{asString}, (String) null, (String) null, (String) null);
                boolean z = false;
                while (query.moveToNext()) {
                    try {
                        String string = query.getString(0);
                        if (!string.contains(asString2)) {
                            LogUtil.C2630a aVar3 = f9484b;
                            LogUtil.m15942a(aVar3, "categoryId:" + asString2 + "  categId:" + string);
                            StringBuilder sb = new StringBuilder();
                            sb.append(string);
                            sb.append(asString2);
                            asString2 = sb.toString();
                            contentValues2.put("category_id", asString2);
                            writableDatabase.update("sticker", contentValues2, "sticker_id=?", new String[]{asString});
                            z = true;
                        }
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
                LogUtil.C2630a aVar4 = f9484b;
                LogUtil.m15942a(aVar4, "insert STICKER update:" + z);
                if (!z) {
                    try {
                        j2 = writableDatabase.insert("sticker", (String) null, contentValues2);
                    } catch (SQLiteConstraintException e3) {
                        LogUtil.C2630a aVar5 = f9484b;
                        LogUtil.m15949b(aVar5, "insert error:" + e3.getMessage());
                        e3.printStackTrace();
                        return null;
                    }
                }
                j = j2;
            }
        } else if (match == 4000) {
            try {
                j = writableDatabase.insert("ar_sticker", (String) null, contentValues2);
                LogUtil.C2630a aVar6 = f9484b;
                LogUtil.m15942a(aVar6, "insert id:" + j);
                mo19959a(CameraContract.C2035a.f9491a);
            } catch (SQLiteConstraintException e4) {
                LogUtil.m15950b(f9484b, "insert error", e4);
                e4.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException("The uri is not match! uri:" + uri2);
        }
        return ContentUris.withAppendedId(uri2, j);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uri, str, strArr}, this, f9483a, false, 3424, new Class[]{Uri.class, String.class, String[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        SQLiteDatabase writableDatabase = this.f9489c.getWritableDatabase();
        int match = f9485d.match(uri);
        if (match == 1000) {
            int delete = writableDatabase.delete("sticker_category", str, strArr);
            mo19959a(CameraContract.C2037c.f9493a);
            return delete;
        } else if (match == 2000) {
            int delete2 = writableDatabase.delete("sticker", str, strArr);
            LogUtil.C2630a aVar = f9484b;
            LogUtil.m15942a(aVar, "delete STICKER count:" + delete2);
            return delete2;
        } else if (match == 3000) {
            int delete3 = writableDatabase.delete("sticker", "sticker_id=?", new String[]{uri.getLastPathSegment()});
            LogUtil.C2630a aVar2 = f9484b;
            LogUtil.m15942a(aVar2, "delete STICKER count:" + delete3);
            return delete3;
        } else if (match == 4000) {
            int delete4 = writableDatabase.delete("ar_sticker", str, strArr);
            LogUtil.C2630a aVar3 = f9484b;
            LogUtil.m15942a(aVar3, "delete AR_Sticker count:" + delete4);
            return delete4;
        } else if (match == 5000) {
            int delete5 = writableDatabase.delete("ar_sticker", "sticker_id=?", new String[]{uri.getLastPathSegment()});
            LogUtil.C2630a aVar4 = f9484b;
            LogUtil.m15942a(aVar4, "delete AR_STICKER count:" + delete5);
            return delete5;
        } else {
            throw new IllegalArgumentException("The uri is not match! uri:" + uri);
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        boolean z;
        ChangeQuickRedirect changeQuickRedirect = f9483a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uri, contentValues, str, strArr}, this, changeQuickRedirect, false, 3425, new Class[]{Uri.class, ContentValues.class, String.class, String[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        SQLiteDatabase writableDatabase = this.f9489c.getWritableDatabase();
        Boolean asBoolean = contentValues.getAsBoolean("notify_change");
        if (asBoolean == null) {
            z = true;
        } else {
            z = asBoolean.booleanValue();
        }
        contentValues.remove("notify_change");
        int match = f9485d.match(uri);
        if (match == 1000) {
            int update = writableDatabase.update("sticker_category", contentValues, str, strArr);
            if (z) {
                mo19959a(CameraContract.C2037c.f9493a);
            }
            return update;
        } else if (match == 2000) {
            int update2 = writableDatabase.update("sticker", contentValues, str, strArr);
            if (z) {
                mo19959a(uri);
            }
            return update2;
        } else if (match == 3000) {
            int update3 = writableDatabase.update("sticker", contentValues, "sticker_id=?", new String[]{uri.getLastPathSegment()});
            if (z) {
                mo19959a(uri);
            }
            return update3;
        } else if (match == 4000) {
            int update4 = writableDatabase.update("ar_sticker", contentValues, str, strArr);
            if (z) {
                mo19959a(uri);
            }
            return update4;
        } else if (match == 5000) {
            int update5 = writableDatabase.update("ar_sticker", contentValues, "sticker_id=?", new String[]{uri.getLastPathSegment()});
            if (z) {
                mo19959a(uri);
            }
            return update5;
        } else {
            throw new IllegalArgumentException("The uri is not match! uri:" + uri);
        }
    }

    /* renamed from: a */
    public void mo19959a(Uri uri) {
        if (!PatchProxy.proxy(new Object[]{uri}, this, f9483a, false, 3428, new Class[]{Uri.class}, Void.TYPE).isSupported) {
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        }
    }

    public void onLowMemory() {
        if (!PatchProxy.proxy(new Object[0], this, f9483a, false, 3432, new Class[0], Void.TYPE).isSupported) {
            super.onLowMemory();
        }
    }
}
