package com.meizu.media.camera.p071h;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.RemoteException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.baidu.p020ar.base.MsgField;
import com.meizu.camera.effectlib.utils.C1198Utils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.meizu.media.camera.bean.ARSticker;
import com.meizu.media.camera.bean.Sticker;
import com.meizu.media.camera.database.CameraContract;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.BitmapUtils;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.MD5Util;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.Constants;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.meizu.media.camera.h.c */
public class StickerNetworkManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f10332a;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final LogUtil.C2630a f10333j = new LogUtil.C2630a("StickerNetwork");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f10334b;

    /* renamed from: c */
    private RequestQueue f10335c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2119c f10336d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2117a f10337e;

    /* renamed from: f */
    private C2118b f10338f;

    /* renamed from: g */
    private boolean f10339g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f10340h;

    /* renamed from: i */
    private boolean f10341i = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ARLibUpdateListener f10342k;

    /* renamed from: com.meizu.media.camera.h.c$a */
    /* compiled from: StickerNetworkManager */
    public interface C2117a {
        /* renamed from: a */
        void mo20281a();

        /* renamed from: a */
        void mo20282a(String str);

        /* renamed from: a */
        void mo20283a(String str, boolean z);

        /* renamed from: b */
        void mo20284b(String str);

        /* renamed from: c */
        void mo20285c(String str);
    }

    /* renamed from: com.meizu.media.camera.h.c$b */
    /* compiled from: StickerNetworkManager */
    public interface C2118b {
        /* renamed from: G */
        void mo20286G();
    }

    /* renamed from: com.meizu.media.camera.h.c$c */
    /* compiled from: StickerNetworkManager */
    public interface C2119c {
        /* renamed from: a */
        void mo20287a();

        /* renamed from: a */
        void mo20288a(String str);

        /* renamed from: a */
        void mo20289a(String str, boolean z, boolean z2);

        /* renamed from: b */
        void mo20290b(String str);
    }

    /* renamed from: b */
    static /* synthetic */ int m10616b(StickerNetworkManager cVar) {
        int i = cVar.f10340h;
        cVar.f10340h = i - 1;
        return i;
    }

    public StickerNetworkManager(Context context) {
        this.f10334b = context.getApplicationContext();
        this.f10335c = Volley.m723a(this.f10334b);
        mo20264b();
    }

    /* renamed from: a */
    public void mo20257a(C2119c cVar, C2118b bVar) {
        this.f10336d = cVar;
        this.f10338f = bVar;
    }

    /* renamed from: a */
    public void mo20256a(C2117a aVar, C2118b bVar) {
        this.f10337e = aVar;
        this.f10338f = bVar;
    }

    /* renamed from: a */
    public void mo20254a() {
        if (!PatchProxy.proxy(new Object[0], this, f10332a, false, 5348, new Class[0], Void.TYPE).isSupported && this.f10335c != null && this.f10341i) {
            LogUtil.m15952c(f10333j, "StickerNetwork stop");
            this.f10335c.mo8706a((Object) f10333j);
            this.f10335c.mo8707b();
            if (this.f10338f != null) {
                this.f10338f.mo20286G();
            }
            this.f10341i = false;
        }
    }

    /* renamed from: b */
    public final void mo20264b() {
        if (!PatchProxy.proxy(new Object[0], this, f10332a, false, 5349, new Class[0], Void.TYPE).isSupported && this.f10335c != null && !this.f10341i) {
            LogUtil.m15952c(f10333j, "StickerNetwork start");
            this.f10335c.mo8704a();
            this.f10341i = true;
        }
    }

    /* renamed from: c */
    public void mo20266c() {
        if (!PatchProxy.proxy(new Object[0], this, f10332a, false, 5350, new Class[0], Void.TYPE).isSupported) {
            mo20254a();
            this.f10335c = null;
        }
    }

    /* renamed from: d */
    public void mo20268d() {
        if (!PatchProxy.proxy(new Object[0], this, f10332a, false, 5351, new Class[0], Void.TYPE).isSupported) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ContentProviderOperation.newDelete(CameraContract.C2037c.f9493a).withSelection("category_id<>?", new String[]{String.valueOf(-1)}).build());
            C21041 r2 = new Utf8StringRequest(1, "http://api.photos.meizu.com/funny/category.do", new Response.C0452b(arrayList) {
                private final /* synthetic */ ArrayList f$1;

                {
                    this.f$1 = r2;
                }

                public final void onResponse(Object obj) {
                    StickerNetworkManager.this.m10613a(this.f$1, (String) obj);
                }
            }, new Response.C0451a() {
                public final void onErrorResponse(VolleyError tVar) {
                    StickerNetworkManager.this.m10604a(tVar);
                }
            }) {

                /* renamed from: a */
                public static ChangeQuickRedirect f10343a;

                public Map<String, String> getParams() {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10343a, false, 5382, new Class[0], Map.class);
                    if (proxy.isSupported) {
                        return (Map) proxy.result;
                    }
                    HashMap hashMap = new HashMap();
                    long j = StickerNetworkManager.this.f10334b.getSharedPreferences(StickerNetworkManager.this.f10334b.getPackageName(), 0).getLong("last_req_time", 0);
                    LogUtil.C2630a i = StickerNetworkManager.f10333j;
                    LogUtil.m15942a(i, "lastReqTime:" + j);
                    hashMap.put("preTime", String.valueOf(j));
                    StickerNetworkManager.this.m10615a((Map<String, String>) hashMap);
                    hashMap.put("sign", MD5Util.m15963a(C1198Utils.getFunnySecretKey(StickerNetworkManager.this.f10334b), hashMap));
                    return hashMap;
                }
            };
            if (this.f10335c != null) {
                r2.setTag(f10333j);
                this.f10335c.mo8703a(r2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10613a(ArrayList arrayList, String str) {
        if (!PatchProxy.proxy(new Object[]{arrayList, str}, this, f10332a, false, 5381, new Class[]{ArrayList.class, String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10333j;
            LogUtil.m15952c(aVar, "result:" + str);
            JSONObject d = m10625d(str);
            if (d == null) {
                LogUtil.m15949b(f10333j, "jsonObject is null!");
            } else if (d.getInteger("code").intValue() == 200) {
                JSONArray jSONArray = d.getJSONArray("value");
                if (jSONArray == null || jSONArray.size() == 0) {
                    LogUtil.m15949b(f10333j, "values is null or empty!");
                    return;
                }
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("category_id", jSONObject.getInteger("id"));
                        contentValues.put("nameCN", jSONObject.getString("name"));
                        contentValues.put("nameTW", jSONObject.getString("nameCHT"));
                        contentValues.put("nameEN", jSONObject.getString("nameEN"));
                        contentValues.put("has_update", Integer.valueOf(jSONObject.getBooleanValue("update") ? 1 : 0));
                        mo20258a(String.valueOf(jSONObject.getInteger("id")));
                        arrayList.add(ContentProviderOperation.newInsert(CameraContract.C2037c.f9493a).withValues(contentValues).build());
                    }
                }
                if (arrayList.size() > 1) {
                    try {
                        this.f10334b.getContentResolver().applyBatch("com.meizu.flyme.camera", arrayList);
                        this.f10334b.getSharedPreferences(this.f10334b.getPackageName(), 0).edit().putLong("last_req_time", System.currentTimeMillis()).apply();
                    } catch (RemoteException e) {
                        LogUtil.m15950b(f10333j, "DB RemoteException!", e);
                    } catch (OperationApplicationException e2) {
                        LogUtil.m15950b(f10333j, "OperationApplicationException!", e2);
                    } catch (SQLiteConstraintException e3) {
                        LogUtil.m15943a(f10333j, "requestStickerList", (Throwable) e3);
                    }
                } else {
                    LogUtil.m15949b(f10333j, "There is no category data from server, don't update db!");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20258a(java.lang.String r19) {
        /*
            r18 = this;
            r8 = r18
            r9 = r19
            r10 = 1
            java.lang.Object[] r1 = new java.lang.Object[r10]
            r11 = 0
            r1[r11] = r9
            com.meizu.savior.ChangeQuickRedirect r3 = f10332a
            java.lang.Class[] r6 = new java.lang.Class[r10]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r11] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5352(0x14e8, float:7.5E-42)
            r2 = r18
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1 = 0
            r2 = 2
            android.content.Context r0 = r8.f10334b     // Catch:{ Exception -> 0x00df }
            android.content.ContentResolver r12 = r0.getContentResolver()     // Catch:{ Exception -> 0x00df }
            android.net.Uri r13 = com.meizu.media.camera.database.CameraContract.C2036b.f9492a     // Catch:{ Exception -> 0x00df }
            java.lang.String r0 = "sticker_id"
            java.lang.String r3 = "icon_url"
            java.lang.String r6 = "download"
            java.lang.String r7 = "md5"
            java.lang.String[] r14 = new java.lang.String[]{r0, r3, r6, r7}     // Catch:{ Exception -> 0x00df }
            java.lang.String r15 = "category_id LIKE ? AND is_fake=?"
            java.lang.String[] r0 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00df }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00df }
            r3.<init>()     // Catch:{ Exception -> 0x00df }
            java.lang.String r6 = "%["
            r3.append(r6)     // Catch:{ Exception -> 0x00df }
            r3.append(r9)     // Catch:{ Exception -> 0x00df }
            java.lang.String r6 = "]%"
            r3.append(r6)     // Catch:{ Exception -> 0x00df }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00df }
            r0[r11] = r3     // Catch:{ Exception -> 0x00df }
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x00df }
            r0[r10] = r3     // Catch:{ Exception -> 0x00df }
            r17 = 0
            r16 = r0
            android.database.Cursor r3 = r12.query(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x00df }
        L_0x006c:
            if (r3 == 0) goto L_0x00d5
            boolean r0 = r3.moveToNext()     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            if (r0 == 0) goto L_0x00d5
            com.meizu.media.camera.bean.Sticker r0 = new com.meizu.media.camera.bean.Sticker     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            r0.<init>()     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            java.lang.String r1 = "download"
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            int r1 = r3.getInt(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            java.lang.String r6 = "sticker_id"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            int r6 = r3.getInt(r6)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            r0.mo19343a((int) r6)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            com.meizu.media.camera.bean.Sticker$DownloadState r6 = com.meizu.media.camera.bean.Sticker.DownloadState.DOWNLOADED     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            int r6 = r6.ordinal()     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            if (r1 == r6) goto L_0x00be
            com.meizu.media.camera.bean.Sticker$DownloadState r6 = com.meizu.media.camera.bean.Sticker.DownloadState.REFRESHING     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            int r6 = r6.ordinal()     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            if (r1 != r6) goto L_0x00a1
            goto L_0x00be
        L_0x00a1:
            java.lang.String r1 = "download"
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            int r1 = r3.getInt(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            if (r1 != 0) goto L_0x006c
            java.lang.String r1 = "icon_url"
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            r0.mo19346a((java.lang.String) r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            r4.add(r0)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            goto L_0x006c
        L_0x00be:
            java.lang.String r1 = "md5"
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            r0.mo19350b((java.lang.String) r1)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            r5.add(r0)     // Catch:{ Exception -> 0x00d2, all -> 0x00cf }
            goto L_0x006c
        L_0x00cf:
            r0 = move-exception
            goto L_0x0150
        L_0x00d2:
            r0 = move-exception
            r1 = r3
            goto L_0x00e0
        L_0x00d5:
            if (r3 == 0) goto L_0x00ec
            r3.close()
            goto L_0x00ec
        L_0x00db:
            r0 = move-exception
            r3 = r1
            goto L_0x0150
        L_0x00df:
            r0 = move-exception
        L_0x00e0:
            com.meizu.media.camera.util.ac$a r3 = f10333j     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "Query last stickers error!"
            com.meizu.media.camera.util.LogUtil.m15950b(r3, r6, r0)     // Catch:{ all -> 0x00db }
            if (r1 == 0) goto L_0x00ec
            r1.close()
        L_0x00ec:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            android.net.Uri r0 = com.meizu.media.camera.database.CameraContract.C2036b.f9492a
            android.content.ContentProviderOperation$Builder r0 = android.content.ContentProviderOperation.newDelete(r0)
            java.lang.String r1 = "category_id LIKE ? AND is_fake=?"
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "%["
            r3.append(r7)
            r3.append(r9)
            java.lang.String r7 = "]%"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r2[r11] = r3
            java.lang.String r3 = java.lang.String.valueOf(r10)
            r2[r10] = r3
            android.content.ContentProviderOperation$Builder r0 = r0.withSelection(r1, r2)
            android.content.ContentProviderOperation r0 = r0.build()
            r6.add(r0)
            com.meizu.media.camera.h.c$6 r0 = new com.meizu.media.camera.h.c$6
            r7 = 1
            java.lang.String r10 = "http://api.photos.meizu.com/funny/stickers.do"
            com.meizu.media.camera.h.-$$Lambda$c$FUvUsMB2nrvoG6W85Cs6Ru8_OtQ r11 = new com.meizu.media.camera.h.-$$Lambda$c$FUvUsMB2nrvoG6W85Cs6Ru8_OtQ
            r1 = r11
            r2 = r18
            r3 = r19
            r1.<init>(r3, r4, r5, r6)
            com.meizu.media.camera.h.-$$Lambda$c$RpCbYX6uTLYknaGm-tU5NTlrULw r6 = new com.meizu.media.camera.h.-$$Lambda$c$RpCbYX6uTLYknaGm-tU5NTlrULw
            r6.<init>()
            r1 = r0
            r3 = r7
            r4 = r10
            r5 = r11
            r7 = r19
            r1.<init>(r3, r4, r5, r6, r7)
            com.android.volley.n r1 = r8.f10335c
            if (r1 == 0) goto L_0x014f
            com.meizu.media.camera.util.ac$a r1 = f10333j
            r0.setTag(r1)
            com.android.volley.n r1 = r8.f10335c
            r1.mo8703a(r0)
        L_0x014f:
            return
        L_0x0150:
            if (r3 == 0) goto L_0x0155
            r3.close()
        L_0x0155:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p071h.StickerNetworkManager.mo20258a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10612a(String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, String str2) {
        String str3 = str;
        ArrayList arrayList4 = arrayList3;
        String str4 = str2;
        if (!PatchProxy.proxy(new Object[]{str3, arrayList, arrayList2, arrayList4, str4}, this, f10332a, false, 5380, new Class[]{String.class, ArrayList.class, ArrayList.class, ArrayList.class, String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10333j;
            LogUtil.m15952c(aVar, "requestStickerList categoryId:" + str3);
            LogUtil.C2630a aVar2 = f10333j;
            LogUtil.m15952c(aVar2, "requestStickerList result:" + str4);
            JSONObject d = m10625d(str4);
            if (d == null) {
                LogUtil.m15949b(f10333j, "jsonObject is null!");
            } else if (d.getInteger("code").intValue() == 200) {
                JSONArray jSONArray = d.getJSONArray("value");
                if (jSONArray == null || jSONArray.size() == 0) {
                    LogUtil.m15949b(f10333j, "values is null or empty!");
                    return;
                }
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        Sticker sticker = new Sticker();
                        sticker.mo19343a(jSONObject.getInteger("id").intValue());
                        sticker.mo19346a(jSONObject.getString("icon"));
                        sticker.mo19349b(jSONObject.getInteger("size").intValue());
                        sticker.mo19350b(jSONObject.getString("md5"));
                        sticker.mo19353c(jSONObject.getString("cp"));
                        sticker.mo19347a(jSONObject.getInteger("music").intValue() == 1);
                        arrayList5.add(sticker);
                    }
                }
                LogUtil.C2630a aVar3 = f10333j;
                LogUtil.m15942a(aVar3, "lastInWebStickerList.size:" + arrayList.size());
                LogUtil.C2630a aVar4 = f10333j;
                LogUtil.m15942a(aVar4, "pendingDownloadStickers.size:" + arrayList5.size());
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Sticker sticker2 = (Sticker) it.next();
                    Iterator it2 = arrayList5.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Sticker sticker3 = (Sticker) it2.next();
                        if (sticker3.mo19342a() != sticker2.mo19342a() || sticker3.mo19352c().equals(sticker2.mo19352c())) {
                            if (sticker3.mo19342a() == sticker2.mo19342a() && !sticker3.mo19348b().equals(sticker2.mo19348b())) {
                                LogUtil.C2630a aVar5 = f10333j;
                                LogUtil.m15952c(aVar5, "Sticker icon to be refresh: " + sticker3.mo19342a());
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("icon_url", sticker3.mo19348b());
                                arrayList4.add(ContentProviderOperation.newUpdate(CameraContract.C2036b.f9492a).withValues(contentValues).withSelection("sticker_id =?", new String[]{String.valueOf(sticker3.mo19342a())}).build());
                                mo20265b(sticker3.mo19348b());
                                break;
                            }
                        } else {
                            LogUtil.C2630a aVar6 = f10333j;
                            LogUtil.m15952c(aVar6, "Sticker need to be refresh: " + sticker3.mo19342a());
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("download", Integer.valueOf(Sticker.DownloadState.REFRESHING.ordinal()));
                            contentValues2.put("icon_url", sticker3.mo19348b());
                            arrayList4.add(ContentProviderOperation.newUpdate(CameraContract.C2036b.f9492a).withValues(contentValues2).withSelection("sticker_id =?", new String[]{String.valueOf(sticker3.mo19342a())}).build());
                            mo20260a(String.valueOf(sticker3.mo19342a()), sticker3.mo19352c(), sticker3.mo19354d(), sticker3.mo19355e(), false);
                            mo20265b(sticker3.mo19348b());
                            break;
                        }
                    }
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Sticker sticker4 = (Sticker) it3.next();
                    Iterator it4 = arrayList5.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        Sticker sticker5 = (Sticker) it4.next();
                        if (sticker5.mo19342a() == sticker4.mo19342a() && sticker5.mo19348b().equals(sticker4.mo19348b())) {
                            it4.remove();
                            it3.remove();
                            break;
                        }
                    }
                }
                LogUtil.m15942a(f10333j, "after remove same data");
                LogUtil.C2630a aVar7 = f10333j;
                LogUtil.m15942a(aVar7, "lastInWebStickerList.size:" + arrayList.size());
                LogUtil.C2630a aVar8 = f10333j;
                LogUtil.m15942a(aVar8, "pendingDownloadStickers.size:" + arrayList5.size());
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    arrayList4.add(ContentProviderOperation.newDelete(CameraContract.C2036b.f9492a).withSelection("sticker_id =?", new String[]{String.valueOf(((Sticker) it5.next()).mo19342a())}).build());
                }
                Iterator it6 = arrayList5.iterator();
                while (it6.hasNext()) {
                    Sticker sticker6 = (Sticker) it6.next();
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("sticker_id", Integer.valueOf(sticker6.mo19342a()));
                    contentValues3.put("category_id", Constants.ARRAY_TYPE + str3 + "]");
                    contentValues3.put("icon_url", sticker6.mo19348b());
                    contentValues3.put("size", Integer.valueOf(sticker6.mo19354d()));
                    contentValues3.put("md5", sticker6.mo19352c());
                    contentValues3.put("cp", sticker6.mo19356f());
                    contentValues3.put("has_music", Integer.valueOf(sticker6.mo19355e() ? 1 : 0));
                    contentValues3.put("update_if_exist", true);
                    contentValues3.put("1".equals(str3) ? "hot_order" : "stick_order", Integer.valueOf(arrayList5.indexOf(sticker6) + 1));
                    arrayList4.add(ContentProviderOperation.newInsert(CameraContract.C2036b.f9492a).withValues(contentValues3).build());
                    arrayList6.add(sticker6.mo19348b());
                }
                LogUtil.m15942a(f10333j, "requestStickerList");
                LogUtil.C2630a aVar9 = f10333j;
                LogUtil.m15942a(aVar9, "operations:" + arrayList3.size());
                LogUtil.C2630a aVar10 = f10333j;
                LogUtil.m15942a(aVar10, "iconUrlList:" + arrayList6.size());
                if (arrayList3.size() > 1) {
                    try {
                        this.f10334b.getContentResolver().applyBatch("com.meizu.flyme.camera", arrayList4);
                        m10621b((ArrayList<String>) arrayList6);
                    } catch (RemoteException e) {
                        LogUtil.m15950b(f10333j, "DB RemoteException!", e);
                    } catch (OperationApplicationException e2) {
                        LogUtil.m15950b(f10333j, "OperationApplicationException!", e2);
                    } catch (SQLiteConstraintException e3) {
                        LogUtil.m15943a(f10333j, "requestStickerList", (Throwable) e3);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20260a(String str, String str2, int i, boolean z, boolean z2) {
        String str3 = str;
        Object[] objArr = {str3, str2, new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10332a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5353, new Class[]{String.class, String.class, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            final String str4 = str;
            C21147 r0 = new Utf8StringRequest(1, "http://api.photos.meizu.com/funny/download.do", new Response.C0452b(str, str2, i, z, z2) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ boolean f$4;
                private final /* synthetic */ boolean f$5;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void onResponse(Object obj) {
                    StickerNetworkManager.this.m10608a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (String) obj);
                }
            }, new Response.C0451a(str3) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onErrorResponse(VolleyError tVar) {
                    StickerNetworkManager.this.m10624c(this.f$1, tVar);
                }
            }) {

                /* renamed from: a */
                public static ChangeQuickRedirect f10378a;

                public Map<String, String> getParams() {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10378a, false, 5388, new Class[0], Map.class);
                    if (proxy.isSupported) {
                        return (Map) proxy.result;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("stickerId", str4);
                    StickerNetworkManager.this.m10615a((Map<String, String>) hashMap);
                    hashMap.put("sign", MD5Util.m15963a(C1198Utils.getFunnySecretKey(StickerNetworkManager.this.f10334b), hashMap));
                    return hashMap;
                }
            };
            r0.setRetryPolicy(new DefaultRetryPolicy(MsgField.IMSG_SAVE_PICTURE, 1, 1.0f));
            if (this.f10335c != null) {
                r0.setTag(f10333j);
                this.f10335c.mo8703a(r0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10608a(String str, String str2, int i, boolean z, boolean z2, String str3) {
        String str4 = str;
        String str5 = str3;
        Object[] objArr = {str4, str2, new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), str5};
        ChangeQuickRedirect changeQuickRedirect = f10332a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5379, new Class[]{String.class, String.class, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10333j;
            LogUtil.m15952c(aVar, "StickerFile url:" + str5);
            JSONObject d = m10625d(str5);
            if (d == null) {
                LogUtil.m15949b(f10333j, "jsonObject is null!");
            } else if (d.getInteger("code").intValue() == 200) {
                String string = d.getString("value");
                if (this.f10336d == null || (string != null && string.length() > 0)) {
                    m10610a(str, string, str2, i, z, z2);
                } else {
                    this.f10336d.mo20290b(str4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10624c(String str, VolleyError tVar) {
        Class[] clsArr = {String.class, VolleyError.class};
        if (!PatchProxy.proxy(new Object[]{str, tVar}, this, f10332a, false, 5378, clsArr, Void.TYPE).isSupported) {
            m10604a(tVar);
            if (this.f10336d != null) {
                this.f10336d.mo20290b(str);
            }
        }
    }

    /* renamed from: a */
    private void m10610a(String str, String str2, String str3, int i, boolean z, boolean z2) {
        String str4 = str;
        String str5 = str2;
        if (!PatchProxy.proxy(new Object[]{str4, str5, str3, new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f10332a, false, 5354, new Class[]{String.class, String.class, String.class, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "url:" + str5);
            LogUtil.m15942a(f10333j, "stickerId:" + str4);
            String[] split = str5.split("\\.");
            String str6 = "";
            if (split.length > 0) {
                str6 = "." + split[split.length - 1];
            }
            Uri parse = Uri.parse(str2);
            String scheme = parse.getScheme();
            if ("http".equals(scheme) || "https".equals(scheme)) {
                LogUtil.m15942a(f10333j, "uri.getScheme():" + parse.getScheme());
                final File file = new File(this.f10334b.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), str4 + str6);
                if (file.exists()) {
                    file.delete();
                }
                $$Lambda$c$_NL2x3GRRfXQkzlvp4SJA5jYYm0 r3 = new Response.C0451a(str4) {
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onErrorResponse(VolleyError tVar) {
                        StickerNetworkManager.this.m10619b(this.f$1, tVar);
                    }
                };
                final String str7 = str3;
                final int i2 = i;
                final String str8 = str;
                final boolean z3 = z;
                C21158 r13 = r0;
                final boolean z4 = z2;
                C21158 r0 = new Request<byte[]>(str2, r3) {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10381a;

                    /* renamed from: a */
                    public void deliverResponse(byte[] bArr) {
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d A[SYNTHETIC, Splitter:B:20:0x006d] */
                    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
                    /* JADX WARNING: Removed duplicated region for block: B:42:0x0156  */
                    /* JADX WARNING: Removed duplicated region for block: B:48:0x01a0 A[SYNTHETIC, Splitter:B:48:0x01a0] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public com.android.volley.Response<byte[]> parseNetworkResponse(com.android.volley.NetworkResponse r11) {
                        /*
                            r10 = this;
                            r0 = 1
                            java.lang.Object[] r1 = new java.lang.Object[r0]
                            r8 = 0
                            r1[r8] = r11
                            com.meizu.savior.ChangeQuickRedirect r3 = f10381a
                            java.lang.Class[] r6 = new java.lang.Class[r0]
                            java.lang.Class<com.android.volley.k> r2 = com.android.volley.NetworkResponse.class
                            r6[r8] = r2
                            java.lang.Class<com.android.volley.o> r7 = com.android.volley.Response.class
                            r4 = 0
                            r5 = 5389(0x150d, float:7.552E-42)
                            r2 = r10
                            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                            boolean r2 = r1.isSupported
                            if (r2 == 0) goto L_0x0021
                            java.lang.Object r11 = r1.result
                            com.android.volley.o r11 = (com.android.volley.Response) r11
                            return r11
                        L_0x0021:
                            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.String r2 = "Download completed!"
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            r2.<init>()
                            java.lang.String r3 = "Thread:"
                            r2.append(r3)
                            java.lang.Thread r3 = java.lang.Thread.currentThread()
                            java.lang.String r3 = r3.getName()
                            r2.append(r3)
                            java.lang.String r2 = r2.toString()
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                            r1 = 0
                            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0067 }
                            java.io.File r3 = r4     // Catch:{ IOException -> 0x0067 }
                            r2.<init>(r3)     // Catch:{ IOException -> 0x0067 }
                            byte[] r1 = r11.f326b     // Catch:{ IOException -> 0x005f, all -> 0x005b }
                            r2.write(r1)     // Catch:{ IOException -> 0x005f, all -> 0x005b }
                            r2.close()     // Catch:{ IOException -> 0x0071 }
                            goto L_0x0075
                        L_0x005b:
                            r11 = move-exception
                            r1 = r2
                            goto L_0x019e
                        L_0x005f:
                            r1 = move-exception
                            r9 = r2
                            r2 = r1
                            r1 = r9
                            goto L_0x0068
                        L_0x0064:
                            r11 = move-exception
                            goto L_0x019e
                        L_0x0067:
                            r2 = move-exception
                        L_0x0068:
                            r2.printStackTrace()     // Catch:{ all -> 0x0064 }
                            if (r1 == 0) goto L_0x0075
                            r1.close()     // Catch:{ IOException -> 0x0071 }
                            goto L_0x0075
                        L_0x0071:
                            r1 = move-exception
                            r1.printStackTrace()
                        L_0x0075:
                            java.io.File r1 = r4
                            java.lang.String r1 = com.meizu.media.camera.util.MD5Util.m15962a(r1)
                            java.lang.String r2 = r5
                            boolean r1 = r2.equals(r1)
                            if (r1 == 0) goto L_0x0156
                            byte[] r1 = r11.f326b
                            int r1 = r1.length
                            int r2 = r6
                            if (r1 == r2) goto L_0x008c
                            goto L_0x0156
                        L_0x008c:
                            boolean r1 = r8
                            if (r1 == 0) goto L_0x00ab
                            java.lang.String r1 = r7
                            java.io.File r2 = r4
                            java.lang.String r2 = r2.getAbsolutePath()
                            com.meizu.media.camera.Storage r3 = com.meizu.media.camera.Storage.m7750a()
                            com.meizu.media.camera.h.c r4 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r4 = r4.f10334b
                            java.lang.String r3 = r3.mo18637b((android.content.Context) r4)
                            boolean r1 = com.meizu.media.camera.util.FileUtil.m16261a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3)
                            goto L_0x00c3
                        L_0x00ab:
                            java.io.File r1 = r4
                            java.lang.String r1 = r1.getAbsolutePath()
                            com.meizu.media.camera.Storage r2 = com.meizu.media.camera.Storage.m7750a()
                            com.meizu.media.camera.h.c r3 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r3 = r3.f10334b
                            java.lang.String r2 = r2.mo18637b((android.content.Context) r3)
                            boolean r1 = com.meizu.media.camera.util.FileUtil.m16265b(r1, r2)
                        L_0x00c3:
                            com.meizu.media.camera.util.ac$a r2 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r4 = "cut:"
                            r3.append(r4)
                            r3.append(r1)
                            java.lang.String r3 = r3.toString()
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
                            if (r1 == 0) goto L_0x014b
                            android.content.ContentValues r1 = new android.content.ContentValues
                            r1.<init>()
                            java.lang.String r2 = "download"
                            r3 = 2
                            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                            r1.put(r2, r3)
                            java.lang.String r2 = "download_time"
                            long r3 = java.lang.System.currentTimeMillis()
                            java.lang.Long r3 = java.lang.Long.valueOf(r3)
                            r1.put(r2, r3)
                            boolean r2 = r9
                            if (r2 != 0) goto L_0x010f
                            java.lang.String r2 = "md5"
                            java.lang.String r3 = r5
                            r1.put(r2, r3)
                            java.lang.String r2 = "size"
                            int r3 = r6
                            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                            r1.put(r2, r3)
                        L_0x010f:
                            com.meizu.media.camera.h.c r2 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r2 = r2.f10334b
                            android.content.ContentResolver r2 = r2.getContentResolver()
                            android.net.Uri r3 = com.meizu.media.camera.database.CameraContract.C2036b.f9492a
                            java.lang.String r4 = "sticker_id=?"
                            java.lang.String[] r0 = new java.lang.String[r0]
                            java.lang.String r5 = r7
                            r0[r8] = r5
                            r2.update(r3, r1, r4, r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.p071h.StickerNetworkManager.m10616b((com.meizu.media.camera.p071h.StickerNetworkManager) r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            int r0 = r0.f10340h
                            com.meizu.media.camera.util.CameraUtil.m15876b((int) r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$c r0 = r0.f10336d
                            if (r0 == 0) goto L_0x014b
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$c r0 = r0.f10336d
                            java.lang.String r1 = r7
                            boolean r2 = r8
                            boolean r3 = r9
                            r0.mo20289a(r1, r2, r3)
                        L_0x014b:
                            byte[] r0 = r11.f326b
                            com.android.volley.b$a r11 = com.android.volley.toolbox.HttpHeaderParser.m669a((com.android.volley.NetworkResponse) r11)
                            com.android.volley.o r11 = com.android.volley.Response.m610a(r0, r11)
                            return r11
                        L_0x0156:
                            java.io.File r1 = r4
                            r1.delete()
                            com.meizu.media.camera.h.c r1 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r1 = r1.f10334b
                            android.content.ContentResolver r1 = r1.getContentResolver()
                            android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2036b.f9492a
                            java.lang.String r3 = "sticker_id=?"
                            java.lang.String[] r0 = new java.lang.String[r0]
                            java.lang.String r4 = r7
                            r0[r8] = r4
                            r1.delete(r2, r3, r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.p071h.StickerNetworkManager.m10616b((com.meizu.media.camera.p071h.StickerNetworkManager) r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            int r0 = r0.f10340h
                            com.meizu.media.camera.util.CameraUtil.m15876b((int) r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$c r0 = r0.f10336d
                            if (r0 == 0) goto L_0x0193
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$c r0 = r0.f10336d
                            java.lang.String r1 = r7
                            r0.mo20288a(r1)
                        L_0x0193:
                            byte[] r0 = r11.f326b
                            com.android.volley.b$a r11 = com.android.volley.toolbox.HttpHeaderParser.m669a((com.android.volley.NetworkResponse) r11)
                            com.android.volley.o r11 = com.android.volley.Response.m610a(r0, r11)
                            return r11
                        L_0x019e:
                            if (r1 == 0) goto L_0x01a8
                            r1.close()     // Catch:{ IOException -> 0x01a4 }
                            goto L_0x01a8
                        L_0x01a4:
                            r0 = move-exception
                            r0.printStackTrace()
                        L_0x01a8:
                            throw r11
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p071h.StickerNetworkManager.C21158.parseNetworkResponse(com.android.volley.k):com.android.volley.o");
                    }
                };
                if (this.f10335c != null) {
                    r13.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
                    r13.setTag(f10333j);
                    this.f10335c.mo8703a(r13);
                }
                if (this.f10340h == 0) {
                    this.f10339g = false;
                }
                this.f10340h++;
                CameraUtil.m15876b(this.f10340h);
                if (this.f10340h > 1) {
                    this.f10339g = true;
                    return;
                }
                return;
            }
            LogUtil.m15949b(f10333j, "uri is not a HTTP/HTTPS URI, url:" + str5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10619b(String str, VolleyError tVar) {
        if (!PatchProxy.proxy(new Object[]{str, tVar}, this, f10332a, false, 5377, new Class[]{String.class, VolleyError.class}, Void.TYPE).isSupported) {
            m10604a(tVar);
            this.f10340h--;
            CameraUtil.m15876b(this.f10340h);
            if (this.f10336d != null) {
                this.f10336d.mo20290b(str);
            }
        }
    }

    /* renamed from: b */
    private void m10621b(ArrayList<String> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f10332a, false, 5355, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                ImageRequest lVar = new ImageRequest(next, new Response.C0452b(next, arrayList) {
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ ArrayList f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onResponse(Object obj) {
                        StickerNetworkManager.this.m10611a(this.f$1, this.f$2, (Bitmap) obj);
                    }
                }, 0, 0, Bitmap.Config.ARGB_8888, new Response.C0451a() {
                    public final void onErrorResponse(VolleyError tVar) {
                        StickerNetworkManager.this.m10604a(tVar);
                    }
                });
                lVar.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
                if (this.f10335c != null) {
                    lVar.setTag(f10333j);
                    this.f10335c.mo8703a(lVar);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10611a(final String str, final ArrayList arrayList, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{str, arrayList, bitmap}, this, f10332a, false, 5376, new Class[]{String.class, ArrayList.class, Bitmap.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "downloadIcon onResponse");
            new AsyncTaskEx<Bitmap, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10389a;

                /* renamed from: a */
                public Void mo17658a(Bitmap... bitmapArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmapArr}, this, f10389a, false, 5390, new Class[]{Bitmap[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("icon", BitmapUtils.m16146b(bitmapArr[0]));
                    contentValues.put("notify_change", false);
                    StickerNetworkManager.this.f10334b.getContentResolver().update(CameraContract.C2036b.f9492a, contentValues, "icon_url=?", new String[]{str});
                    if (StickerNetworkManager.this.f10336d == null || arrayList.indexOf(str) != arrayList.size() - 1) {
                        return null;
                    }
                    StickerNetworkManager.this.f10336d.mo20287a();
                    return null;
                }
            }.mo22614c((Params[]) new Bitmap[]{bitmap});
        }
    }

    /* renamed from: b */
    public void mo20265b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10332a, false, 5356, new Class[]{String.class}, Void.TYPE).isSupported) {
            ImageRequest lVar = new ImageRequest(str, new Response.C0452b(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onResponse(Object obj) {
                    StickerNetworkManager.this.m10618b(this.f$1, (Bitmap) obj);
                }
            }, 0, 0, Bitmap.Config.ARGB_8888, new Response.C0451a() {
                public final void onErrorResponse(VolleyError tVar) {
                    StickerNetworkManager.this.m10604a(tVar);
                }
            });
            lVar.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
            if (this.f10335c != null) {
                lVar.setTag(f10333j);
                this.f10335c.mo8703a(lVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10618b(final String str, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{str, bitmap}, this, f10332a, false, 5375, new Class[]{String.class, Bitmap.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "downloadIcon onResponse");
            new AsyncTaskEx<Bitmap, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10345a;

                /* renamed from: a */
                public Void mo17658a(Bitmap... bitmapArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmapArr}, this, f10345a, false, 5391, new Class[]{Bitmap[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("icon", BitmapUtils.m16146b(bitmapArr[0]));
                    StickerNetworkManager.this.f10334b.getContentResolver().update(CameraContract.C2036b.f9492a, contentValues, "icon_url=?", new String[]{str});
                    if (StickerNetworkManager.this.f10336d == null) {
                        return null;
                    }
                    StickerNetworkManager.this.f10336d.mo20287a();
                    return null;
                }
            }.mo22614c((Params[]) new Bitmap[]{bitmap});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10604a(VolleyError tVar) {
        if (!PatchProxy.proxy(new Object[]{tVar}, this, f10332a, false, 5357, new Class[]{VolleyError.class}, Void.TYPE).isSupported && tVar != null && tVar.f347a != null) {
            String str = null;
            String valueOf = String.valueOf(tVar.f347a.f325a);
            try {
                str = new String(tVar.f347a.f326b, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
            LogUtil.C2630a aVar = f10333j;
            LogUtil.m15949b(aVar, "statusCode:" + valueOf);
            LogUtil.C2630a aVar2 = f10333j;
            LogUtil.m15949b(aVar2, "errorMsg:" + str);
            tVar.printStackTrace();
        }
    }

    /* renamed from: e */
    public int mo20269e() {
        return this.f10340h;
    }

    /* renamed from: f */
    public boolean mo20270f() {
        return this.f10339g;
    }

    /* renamed from: a */
    public void mo20255a(ARLibUpdateListener aVar) {
        this.f10342k = aVar;
    }

    /* renamed from: g */
    public void mo20271g() {
        if (!PatchProxy.proxy(new Object[0], this, f10332a, false, 5358, new Class[0], Void.TYPE).isSupported) {
            C210611 r1 = new Utf8StringRequest(1, "http://api.photos.meizu.com/ar/sdk.do", new Response.C0452b() {
                public final void onResponse(Object obj) {
                    StickerNetworkManager.this.m10628e((String) obj);
                }
            }, new Response.C0451a() {
                public final void onErrorResponse(VolleyError tVar) {
                    StickerNetworkManager.this.m10623c(tVar);
                }
            }) {

                /* renamed from: a */
                public static ChangeQuickRedirect f10348a;

                public Map<String, String> getParams() {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10348a, false, 5392, new Class[0], Map.class);
                    if (proxy.isSupported) {
                        return (Map) proxy.result;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("preTime", String.valueOf(StickerNetworkManager.this.f10334b.getSharedPreferences(StickerNetworkManager.this.f10334b.getPackageName(), 0).getLong("ar_lib_last_req_time", 0)));
                    hashMap.put("arch", DeviceHelper.f13846Z ? "arm64" : "armeabi");
                    StickerNetworkManager.this.m10615a((Map<String, String>) hashMap);
                    hashMap.put("sign", MD5Util.m15963a(C1198Utils.getFunnySecretKey(StickerNetworkManager.this.f10334b), hashMap));
                    return hashMap;
                }
            };
            if (this.f10335c != null) {
                r1.setTag(f10333j);
                this.f10335c.mo8703a(r1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m10628e(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10332a, false, 5374, new Class[]{String.class}, Void.TYPE).isSupported) {
            JSONObject d = m10625d(str);
            if (d == null) {
                LogUtil.m15949b(f10333j, "requestARRuntimeLib jsonObject is null!");
                if (this.f10342k != null) {
                    this.f10342k.mo18335a();
                }
            } else if (d.getInteger("code").intValue() == 200) {
                JSONObject jSONObject = d.getJSONObject("value");
                if (jSONObject == null) {
                    LogUtil.m15949b(f10333j, "requestARRuntimeLib obj is null!");
                    if (this.f10342k != null) {
                        this.f10342k.mo18335a();
                    }
                } else if (jSONObject.getBoolean("update").booleanValue()) {
                    LogUtil.C2630a aVar = f10333j;
                    LogUtil.m15942a(aVar, "ar lib needs update arch: " + jSONObject.getString("architecture"));
                    CameraUtil.m15854a(true);
                    mo20261a(jSONObject.getString("url"), jSONObject.getString("md5"), System.currentTimeMillis(), jSONObject.getString("name"));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10623c(VolleyError tVar) {
        if (!PatchProxy.proxy(new Object[]{tVar}, this, f10332a, false, 5373, new Class[]{VolleyError.class}, Void.TYPE).isSupported) {
            if (this.f10342k != null) {
                this.f10342k.mo18335a();
            }
            m10604a(tVar);
        }
    }

    /* renamed from: a */
    public void mo20261a(String str, String str2, long j, String str3) {
        String str4 = str3;
        if (!PatchProxy.proxy(new Object[]{str, str2, new Long(j), str4}, this, f10332a, false, 5359, new Class[]{String.class, String.class, Long.TYPE, String.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "start download AR lib version: " + str4);
            String[] split = str.split("\\.");
            String str5 = "";
            if (split.length > 0) {
                str5 = "." + split[split.length - 1];
            }
            String scheme = Uri.parse(str).getScheme();
            if ("http".equals(scheme) || "https".equals(scheme)) {
                final File file = new File(this.f10334b.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "lib" + str5);
                if (file.exists()) {
                    file.delete();
                }
                final String str6 = str2;
                final long j2 = j;
                final String str7 = str3;
                C210712 r0 = new Request<byte[]>(str, new Response.C0451a() {
                    public final void onErrorResponse(VolleyError tVar) {
                        StickerNetworkManager.this.m10617b(tVar);
                    }
                }) {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10350a;

                    /* renamed from: a */
                    public void deliverResponse(byte[] bArr) {
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d A[SYNTHETIC, Splitter:B:20:0x006d] */
                    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
                    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
                    /* JADX WARNING: Removed duplicated region for block: B:37:0x0113 A[SYNTHETIC, Splitter:B:37:0x0113] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public com.android.volley.Response<byte[]> parseNetworkResponse(com.android.volley.NetworkResponse r11) {
                        /*
                            r10 = this;
                            r0 = 1
                            java.lang.Object[] r1 = new java.lang.Object[r0]
                            r8 = 0
                            r1[r8] = r11
                            com.meizu.savior.ChangeQuickRedirect r3 = f10350a
                            java.lang.Class[] r6 = new java.lang.Class[r0]
                            java.lang.Class<com.android.volley.k> r2 = com.android.volley.NetworkResponse.class
                            r6[r8] = r2
                            java.lang.Class<com.android.volley.o> r7 = com.android.volley.Response.class
                            r4 = 0
                            r5 = 5393(0x1511, float:7.557E-42)
                            r2 = r10
                            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                            boolean r2 = r1.isSupported
                            if (r2 == 0) goto L_0x0021
                            java.lang.Object r11 = r1.result
                            com.android.volley.o r11 = (com.android.volley.Response) r11
                            return r11
                        L_0x0021:
                            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.String r2 = "Download completed!"
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            r2.<init>()
                            java.lang.String r3 = "Thread:"
                            r2.append(r3)
                            java.lang.Thread r3 = java.lang.Thread.currentThread()
                            java.lang.String r3 = r3.getName()
                            r2.append(r3)
                            java.lang.String r2 = r2.toString()
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                            r1 = 0
                            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0067 }
                            java.io.File r3 = r4     // Catch:{ IOException -> 0x0067 }
                            r2.<init>(r3)     // Catch:{ IOException -> 0x0067 }
                            byte[] r1 = r11.f326b     // Catch:{ IOException -> 0x005f, all -> 0x005b }
                            r2.write(r1)     // Catch:{ IOException -> 0x005f, all -> 0x005b }
                            r2.close()     // Catch:{ IOException -> 0x0071 }
                            goto L_0x0075
                        L_0x005b:
                            r11 = move-exception
                            r1 = r2
                            goto L_0x0111
                        L_0x005f:
                            r1 = move-exception
                            r9 = r2
                            r2 = r1
                            r1 = r9
                            goto L_0x0068
                        L_0x0064:
                            r11 = move-exception
                            goto L_0x0111
                        L_0x0067:
                            r2 = move-exception
                        L_0x0068:
                            r2.printStackTrace()     // Catch:{ all -> 0x0064 }
                            if (r1 == 0) goto L_0x0075
                            r1.close()     // Catch:{ IOException -> 0x0071 }
                            goto L_0x0075
                        L_0x0071:
                            r1 = move-exception
                            r1.printStackTrace()
                        L_0x0075:
                            java.io.File r1 = r4
                            java.lang.String r1 = com.meizu.media.camera.util.MD5Util.m15962a(r1)
                            java.lang.String r2 = r5
                            boolean r1 = r2.equals(r1)
                            if (r1 != 0) goto L_0x0093
                            java.io.File r0 = r4
                            r0.delete()
                            byte[] r0 = r11.f326b
                            com.android.volley.b$a r11 = com.android.volley.toolbox.HttpHeaderParser.m669a((com.android.volley.NetworkResponse) r11)
                            com.android.volley.o r11 = com.android.volley.Response.m610a(r0, r11)
                            return r11
                        L_0x0093:
                            com.meizu.media.camera.Storage r1 = com.meizu.media.camera.Storage.m7750a()
                            com.meizu.media.camera.h.c r2 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r2 = r2.f10334b
                            java.lang.String r1 = r1.mo18642c((android.content.Context) r2)
                            java.lang.String r2 = ""
                            java.io.File r3 = r4
                            java.lang.String r3 = r3.getAbsolutePath()
                            boolean r0 = com.meizu.media.camera.util.FileUtil.m16262a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r1, (boolean) r0)
                            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            r2.<init>()
                            java.lang.String r3 = "cut:"
                            r2.append(r3)
                            r2.append(r0)
                            java.lang.String r2 = r2.toString()
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                            if (r0 == 0) goto L_0x0106
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r0 = r0.f10334b
                            com.meizu.media.camera.h.c r1 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r1 = r1.f10334b
                            java.lang.String r1 = r1.getPackageName()
                            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r8)
                            android.content.SharedPreferences$Editor r0 = r0.edit()
                            java.lang.String r1 = "ar_lib_last_req_time"
                            long r2 = r6
                            android.content.SharedPreferences$Editor r0 = r0.putLong(r1, r2)
                            java.lang.String r1 = "ar_lib_version"
                            java.lang.String r2 = r8
                            android.content.SharedPreferences$Editor r0 = r0.putString(r1, r2)
                            r0.apply()
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.a r0 = r0.f10342k
                            if (r0 == 0) goto L_0x0103
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.a r0 = r0.f10342k
                            r0.mo18336b()
                        L_0x0103:
                            com.meizu.media.camera.util.CameraUtil.m15854a((boolean) r8)
                        L_0x0106:
                            byte[] r0 = r11.f326b
                            com.android.volley.b$a r11 = com.android.volley.toolbox.HttpHeaderParser.m669a((com.android.volley.NetworkResponse) r11)
                            com.android.volley.o r11 = com.android.volley.Response.m610a(r0, r11)
                            return r11
                        L_0x0111:
                            if (r1 == 0) goto L_0x011b
                            r1.close()     // Catch:{ IOException -> 0x0117 }
                            goto L_0x011b
                        L_0x0117:
                            r0 = move-exception
                            r0.printStackTrace()
                        L_0x011b:
                            throw r11
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p071h.StickerNetworkManager.C210712.parseNetworkResponse(com.android.volley.k):com.android.volley.o");
                    }
                };
                if (this.f10335c != null) {
                    r0.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
                    r0.setTag(f10333j);
                    this.f10335c.mo8703a(r0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10617b(VolleyError tVar) {
        if (!PatchProxy.proxy(new Object[]{tVar}, this, f10332a, false, 5372, new Class[]{VolleyError.class}, Void.TYPE).isSupported) {
            if (this.f10342k != null) {
                this.f10342k.mo18335a();
            }
            CameraUtil.m15854a(false);
            m10604a(tVar);
        }
    }

    /* renamed from: h */
    public void mo20272h() {
        Cursor query;
        if (!PatchProxy.proxy(new Object[0], this, f10332a, false, 5360, new Class[0], Void.TYPE).isSupported) {
            ArrayList arrayList = new ArrayList();
            try {
                query = this.f10334b.getContentResolver().query(CameraContract.C2035a.f9491a, new String[]{"sticker_id", "icon_url", "download", "md5"}, "is_fake=?", new String[]{String.valueOf(0)}, (String) null);
                while (query != null) {
                    if (!query.moveToNext()) {
                        break;
                    }
                    ARSticker aRSticker = new ARSticker();
                    aRSticker.mo19316a(query.getInt(query.getColumnIndex("sticker_id")));
                    arrayList.add(aRSticker);
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                LogUtil.m15950b(f10333j, "Query last ar stickers error!", e);
            } catch (Throwable th) {
                r4.addSuppressed(th);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(ContentProviderOperation.newDelete(CameraContract.C2035a.f9491a).withSelection("is_fake=?", new String[]{String.valueOf(1)}).build());
            C210813 r4 = new Utf8StringRequest(1, "http://api.photos.meizu.com/ar/stickers.do", new Response.C0452b(arrayList, arrayList2) {
                private final /* synthetic */ ArrayList f$1;
                private final /* synthetic */ ArrayList f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onResponse(Object obj) {
                    StickerNetworkManager.this.m10614a(this.f$1, this.f$2, (String) obj);
                }
            }, new Response.C0451a() {
                public final void onErrorResponse(VolleyError tVar) {
                    StickerNetworkManager.this.m10604a(tVar);
                }
            }) {

                /* renamed from: a */
                public static ChangeQuickRedirect f10356a;

                public Map<String, String> getParams() throws AuthFailureError {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10356a, false, 5394, new Class[0], Map.class);
                    if (proxy.isSupported) {
                        return (Map) proxy.result;
                    }
                    HashMap hashMap = new HashMap();
                    StickerNetworkManager.this.m10615a((Map<String, String>) hashMap);
                    hashMap.put("preTime", String.valueOf(StickerNetworkManager.this.f10334b.getSharedPreferences(StickerNetworkManager.this.f10334b.getPackageName(), 0).getLong("ar_sticker_last_req_time", 0)));
                    hashMap.put("sign", MD5Util.m15963a(C1198Utils.getFunnySecretKey(StickerNetworkManager.this.f10334b), hashMap));
                    return hashMap;
                }
            };
            if (this.f10335c != null) {
                r4.setTag(f10333j);
                this.f10335c.mo8703a(r4);
                return;
            }
            return;
        }
        return;
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10614a(ArrayList arrayList, ArrayList arrayList2, String str) {
        if (!PatchProxy.proxy(new Object[]{arrayList, arrayList2, str}, this, f10332a, false, 5371, new Class[]{ArrayList.class, ArrayList.class, String.class}, Void.TYPE).isSupported) {
            JSONObject d = m10625d(str);
            if (d == null) {
                LogUtil.m15949b(f10333j, "ar sticker list jsonObject is null!");
            } else if (d.getInteger("code").intValue() == 200) {
                JSONArray jSONArray = d.getJSONArray("value");
                if (jSONArray == null || jSONArray.size() == 0) {
                    LogUtil.m15949b(f10333j, "ar sticker values is null or empty!");
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        ARSticker aRSticker = new ARSticker();
                        aRSticker.mo19316a(jSONObject.getInteger("id").intValue());
                        aRSticker.mo19319a(jSONObject.getString("icon"));
                        aRSticker.mo19326c(jSONObject.getString("name"));
                        aRSticker.mo19331e(jSONObject.getString("md5"));
                        aRSticker.mo19334f(jSONObject.getString(Constants.KEY_LINK));
                        aRSticker.mo19323b(jSONObject.getString("linkPic"));
                        aRSticker.mo19329d(jSONObject.getString("url"));
                        aRSticker.mo19324b(jSONObject.getBoolean("update").booleanValue());
                        arrayList3.add(aRSticker);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ARSticker aRSticker2 = (ARSticker) it.next();
                    Iterator it2 = arrayList3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ARSticker aRSticker3 = (ARSticker) it2.next();
                        if (aRSticker3.mo19315a() == aRSticker2.mo19315a()) {
                            if (aRSticker3.mo19340l()) {
                                LogUtil.C2630a aVar = f10333j;
                                LogUtil.m15952c(aVar, "AR Sticker need to be refresh: " + aRSticker3.mo19315a());
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("download", Integer.valueOf(ARSticker.DownloadState.REFRESHING.ordinal()));
                                contentValues.put("url", aRSticker3.mo19333f());
                                contentValues.put("icon_url", aRSticker3.mo19321b());
                                arrayList2.add(ContentProviderOperation.newUpdate(CameraContract.C2035a.f9491a).withValues(contentValues).withSelection("sticker_id =?", new String[]{String.valueOf(aRSticker3.mo19315a())}).build());
                                mo20267c(aRSticker3.mo19321b());
                            } else {
                                it2.remove();
                                it.remove();
                            }
                        }
                    }
                }
                LogUtil.m15942a(f10333j, "after remove same data");
                LogUtil.C2630a aVar2 = f10333j;
                LogUtil.m15942a(aVar2, "localStickerList.size:" + arrayList.size());
                LogUtil.C2630a aVar3 = f10333j;
                LogUtil.m15942a(aVar3, "pendingDownloadStickers.size:" + arrayList3.size());
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ARSticker aRSticker4 = (ARSticker) it3.next();
                    if (!"-1".equals(Integer.toString(aRSticker4.mo19315a()))) {
                        arrayList2.add(ContentProviderOperation.newDelete(CameraContract.C2035a.f9491a).withSelection("sticker_id =?", new String[]{String.valueOf(aRSticker4.mo19315a())}).build());
                    }
                }
                Iterator it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    ARSticker aRSticker5 = (ARSticker) it4.next();
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("sticker_id", Integer.valueOf(aRSticker5.mo19315a()));
                    contentValues2.put("icon_url", aRSticker5.mo19321b());
                    contentValues2.put("url", aRSticker5.mo19333f());
                    contentValues2.put("name", aRSticker5.mo19328d());
                    contentValues2.put("md5", aRSticker5.mo19335g());
                    contentValues2.put(Constants.KEY_LINK, aRSticker5.mo19339k());
                    contentValues2.put("link_img_url", aRSticker5.mo19325c());
                    contentValues2.put("need_update", Boolean.valueOf(aRSticker5.mo19340l()));
                    arrayList2.add(ContentProviderOperation.newInsert(CameraContract.C2035a.f9491a).withValues(contentValues2).build());
                }
                if (arrayList2.size() > 1) {
                    try {
                        this.f10334b.getContentResolver().applyBatch("com.meizu.flyme.camera", arrayList2);
                        this.f10334b.getSharedPreferences(this.f10334b.getPackageName(), 0).edit().putLong("ar_sticker_last_req_time", System.currentTimeMillis()).apply();
                        mo20263a((ArrayList<ARSticker>) arrayList3);
                    } catch (RemoteException e) {
                        LogUtil.m15950b(f10333j, "DB RemoteException!", e);
                    } catch (OperationApplicationException e2) {
                        LogUtil.m15950b(f10333j, "OperationApplicationException!", e2);
                    } catch (SQLiteConstraintException e3) {
                        LogUtil.m15943a(f10333j, "request AR StickerList", (Throwable) e3);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20263a(ArrayList<ARSticker> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f10332a, false, 5361, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
            Iterator<ARSticker> it = arrayList.iterator();
            while (it.hasNext()) {
                ARSticker next = it.next();
                String b = next.mo19321b();
                String c = next.mo19325c();
                String valueOf = String.valueOf(next.mo19315a());
                ImageRequest lVar = new ImageRequest(b, new Response.C0452b(b, valueOf) {
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onResponse(Object obj) {
                        StickerNetworkManager.this.m10620b(this.f$1, this.f$2, (Bitmap) obj);
                    }
                }, 0, 0, Bitmap.Config.ARGB_8888, new Response.C0451a() {
                    public final void onErrorResponse(VolleyError tVar) {
                        StickerNetworkManager.this.m10604a(tVar);
                    }
                });
                lVar.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
                if (this.f10335c != null) {
                    lVar.setTag(f10333j);
                    this.f10335c.mo8703a(lVar);
                }
                if (c != null) {
                    mo20259a(valueOf, c);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10620b(final String str, final String str2, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{str, str2, bitmap}, this, f10332a, false, 5370, new Class[]{String.class, String.class, Bitmap.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "download AR icon onResponse");
            new AsyncTaskEx<Bitmap, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10358a;

                /* renamed from: a */
                public Void mo17658a(Bitmap... bitmapArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmapArr}, this, f10358a, false, 5383, new Class[]{Bitmap[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("icon", BitmapUtils.m16146b(bitmapArr[0]));
                    contentValues.put("notify_change", false);
                    StickerNetworkManager.this.f10334b.getContentResolver().update(CameraContract.C2035a.f9491a, contentValues, "icon_url=?", new String[]{str});
                    if (StickerNetworkManager.this.f10337e == null) {
                        return null;
                    }
                    StickerNetworkManager.this.f10337e.mo20285c(str2);
                    return null;
                }
            }.mo22614c((Params[]) new Bitmap[]{bitmap});
        }
    }

    /* renamed from: c */
    public void mo20267c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10332a, false, 5362, new Class[]{String.class}, Void.TYPE).isSupported) {
            ImageRequest lVar = new ImageRequest(str, new Response.C0452b(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onResponse(Object obj) {
                    StickerNetworkManager.this.m10606a(this.f$1, (Bitmap) obj);
                }
            }, 0, 0, Bitmap.Config.ARGB_8888, new Response.C0451a() {
                public final void onErrorResponse(VolleyError tVar) {
                    StickerNetworkManager.this.m10604a(tVar);
                }
            });
            lVar.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
            if (this.f10335c != null) {
                lVar.setTag(f10333j);
                this.f10335c.mo8703a(lVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10606a(final String str, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{str, bitmap}, this, f10332a, false, 5369, new Class[]{String.class, Bitmap.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "download AR Icon onResponse");
            new AsyncTaskEx<Bitmap, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10362a;

                /* renamed from: a */
                public Void mo17658a(Bitmap... bitmapArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmapArr}, this, f10362a, false, 5384, new Class[]{Bitmap[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("icon", BitmapUtils.m16146b(bitmapArr[0]));
                    StickerNetworkManager.this.f10334b.getContentResolver().update(CameraContract.C2035a.f9491a, contentValues, "icon_url=?", new String[]{str});
                    if (StickerNetworkManager.this.f10337e == null) {
                        return null;
                    }
                    StickerNetworkManager.this.f10337e.mo20281a();
                    return null;
                }
            }.mo22614c((Params[]) new Bitmap[]{bitmap});
        }
    }

    /* renamed from: a */
    public void mo20259a(String str, String str2) {
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f10332a, false, 5363, new Class[]{String.class, String.class}, Void.TYPE).isSupported) {
            ImageRequest lVar = new ImageRequest(str2, new Response.C0452b(str2, str) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onResponse(Object obj) {
                    StickerNetworkManager.this.m10609a(this.f$1, this.f$2, (Bitmap) obj);
                }
            }, 0, 0, Bitmap.Config.ARGB_8888, new Response.C0451a() {
                public final void onErrorResponse(VolleyError tVar) {
                    StickerNetworkManager.this.m10604a(tVar);
                }
            });
            lVar.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
            if (this.f10335c != null) {
                lVar.setTag(f10333j);
                this.f10335c.mo8703a(lVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10609a(final String str, final String str2, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{str, str2, bitmap}, this, f10332a, false, 5368, new Class[]{String.class, String.class, Bitmap.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "download link img onResponse");
            new AsyncTaskEx<Bitmap, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10365a;

                /* renamed from: a */
                public Void mo17658a(Bitmap... bitmapArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmapArr}, this, f10365a, false, 5385, new Class[]{Bitmap[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("link_img", BitmapUtils.m16146b(bitmapArr[0]));
                    StickerNetworkManager.this.f10334b.getContentResolver().update(CameraContract.C2035a.f9491a, contentValues, "link_img_url=?", new String[]{str});
                    if (StickerNetworkManager.this.f10337e == null) {
                        return null;
                    }
                    StickerNetworkManager.this.f10337e.mo20285c(str2);
                    return null;
                }
            }.mo22614c((Params[]) new Bitmap[]{bitmap});
        }
    }

    /* renamed from: a */
    public void mo20262a(String str, String str2, String str3, boolean z) {
        if (!PatchProxy.proxy(new Object[]{str, str2, str3, new Byte(z ? (byte) 1 : 0)}, this, f10332a, false, 5364, new Class[]{String.class, String.class, String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10333j, "url:" + str2);
            LogUtil.m15942a(f10333j, "stickerId:" + str);
            String[] split = str2.split("\\.");
            String str4 = "";
            if (split.length > 0) {
                str4 = "." + split[split.length - 1];
            }
            Uri parse = Uri.parse(str2);
            String scheme = parse.getScheme();
            if ("http".equals(scheme) || "https".equals(scheme)) {
                LogUtil.m15942a(f10333j, "uri.getScheme():" + parse.getScheme());
                final File file = new File(this.f10334b.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), str + str4);
                if (file.exists()) {
                    file.delete();
                }
                final String str5 = str3;
                final String str6 = str;
                final boolean z2 = z;
                C21125 r0 = new Request<byte[]>(str2, new Response.C0451a(str) {
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onErrorResponse(VolleyError tVar) {
                        StickerNetworkManager.this.m10607a(this.f$1, tVar);
                    }
                }) {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10369a;

                    /* renamed from: a */
                    public void deliverResponse(byte[] bArr) {
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d A[SYNTHETIC, Splitter:B:20:0x006d] */
                    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
                    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd  */
                    /* JADX WARNING: Removed duplicated region for block: B:53:0x0190 A[SYNTHETIC, Splitter:B:53:0x0190] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public com.android.volley.Response<byte[]> parseNetworkResponse(com.android.volley.NetworkResponse r11) {
                        /*
                            r10 = this;
                            r0 = 1
                            java.lang.Object[] r1 = new java.lang.Object[r0]
                            r8 = 0
                            r1[r8] = r11
                            com.meizu.savior.ChangeQuickRedirect r3 = f10369a
                            java.lang.Class[] r6 = new java.lang.Class[r0]
                            java.lang.Class<com.android.volley.k> r2 = com.android.volley.NetworkResponse.class
                            r6[r8] = r2
                            java.lang.Class<com.android.volley.o> r7 = com.android.volley.Response.class
                            r4 = 0
                            r5 = 5386(0x150a, float:7.547E-42)
                            r2 = r10
                            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                            boolean r2 = r1.isSupported
                            if (r2 == 0) goto L_0x0021
                            java.lang.Object r11 = r1.result
                            com.android.volley.o r11 = (com.android.volley.Response) r11
                            return r11
                        L_0x0021:
                            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.String r2 = "AR Sticker file Download completed!"
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            r2.<init>()
                            java.lang.String r3 = "Thread:"
                            r2.append(r3)
                            java.lang.Thread r3 = java.lang.Thread.currentThread()
                            java.lang.String r3 = r3.getName()
                            r2.append(r3)
                            java.lang.String r2 = r2.toString()
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                            r1 = 0
                            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0067 }
                            java.io.File r3 = r4     // Catch:{ IOException -> 0x0067 }
                            r2.<init>(r3)     // Catch:{ IOException -> 0x0067 }
                            byte[] r1 = r11.f326b     // Catch:{ IOException -> 0x005f, all -> 0x005b }
                            r2.write(r1)     // Catch:{ IOException -> 0x005f, all -> 0x005b }
                            r2.close()     // Catch:{ IOException -> 0x0071 }
                            goto L_0x0075
                        L_0x005b:
                            r11 = move-exception
                            r1 = r2
                            goto L_0x018e
                        L_0x005f:
                            r1 = move-exception
                            r9 = r2
                            r2 = r1
                            r1 = r9
                            goto L_0x0068
                        L_0x0064:
                            r11 = move-exception
                            goto L_0x018e
                        L_0x0067:
                            r2 = move-exception
                        L_0x0068:
                            r2.printStackTrace()     // Catch:{ all -> 0x0064 }
                            if (r1 == 0) goto L_0x0075
                            r1.close()     // Catch:{ IOException -> 0x0071 }
                            goto L_0x0075
                        L_0x0071:
                            r1 = move-exception
                            r1.printStackTrace()
                        L_0x0075:
                            java.io.File r1 = r4
                            java.lang.String r1 = com.meizu.media.camera.util.MD5Util.m15962a(r1)
                            java.lang.String r2 = r5
                            boolean r1 = r2.equals(r1)
                            if (r1 != 0) goto L_0x00bd
                            java.io.File r1 = r4
                            r1.delete()
                            com.meizu.media.camera.h.c r1 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r1 = r1.f10334b
                            android.content.ContentResolver r1 = r1.getContentResolver()
                            android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2035a.f9491a
                            java.lang.String r3 = "sticker_id=?"
                            java.lang.String[] r0 = new java.lang.String[r0]
                            java.lang.String r4 = r6
                            r0[r8] = r4
                            r1.delete(r2, r3, r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$a r0 = r0.f10337e
                            if (r0 == 0) goto L_0x00b2
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$a r0 = r0.f10337e
                            java.lang.String r1 = r6
                            r0.mo20282a(r1)
                        L_0x00b2:
                            byte[] r0 = r11.f326b
                            com.android.volley.b$a r11 = com.android.volley.toolbox.HttpHeaderParser.m669a((com.android.volley.NetworkResponse) r11)
                            com.android.volley.o r11 = com.android.volley.Response.m610a(r0, r11)
                            return r11
                        L_0x00bd:
                            java.lang.String r1 = r6
                            java.io.File r2 = r4
                            java.lang.String r2 = r2.getAbsolutePath()
                            com.meizu.media.camera.Storage r3 = com.meizu.media.camera.Storage.m7750a()
                            com.meizu.media.camera.h.c r4 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r4 = r4.f10334b
                            java.lang.String r3 = r3.mo18619a((android.content.Context) r4)
                            boolean r1 = com.meizu.media.camera.util.FileUtil.m16262a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (boolean) r8)
                            com.meizu.media.camera.util.ac$a r2 = com.meizu.media.camera.p071h.StickerNetworkManager.f10333j
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r4 = "cut:"
                            r3.append(r4)
                            r3.append(r1)
                            java.lang.String r3 = r3.toString()
                            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
                            if (r1 == 0) goto L_0x0183
                            android.content.ContentValues r1 = new android.content.ContentValues
                            r1.<init>()
                            java.lang.String r2 = "download"
                            com.meizu.media.camera.bean.ARSticker$DownloadState r3 = com.meizu.media.camera.bean.ARSticker.DownloadState.DOWNLOADED
                            int r3 = r3.ordinal()
                            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                            r1.put(r2, r3)
                            java.lang.String r2 = "download_time"
                            long r3 = java.lang.System.currentTimeMillis()
                            java.lang.Long r3 = java.lang.Long.valueOf(r3)
                            r1.put(r2, r3)
                            com.meizu.media.camera.h.c r2 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r2 = r2.f10334b
                            java.lang.String r3 = r6
                            com.alibaba.fastjson.JSONObject r2 = com.meizu.media.camera.util.FileUtil.m16256a((android.content.Context) r2, (java.lang.String) r3)
                            if (r2 == 0) goto L_0x014c
                            java.lang.String r3 = "has_music"
                            java.lang.String r4 = "ismusic"
                            java.lang.Boolean r4 = r2.getBoolean(r4)
                            boolean r4 = r4.booleanValue()
                            if (r4 == 0) goto L_0x0131
                            java.lang.String r4 = "1"
                            goto L_0x0133
                        L_0x0131:
                            java.lang.String r4 = "0"
                        L_0x0133:
                            r1.put(r3, r4)
                            java.lang.String r3 = "clickable"
                            java.lang.String r4 = "isclick"
                            java.lang.Boolean r2 = r2.getBoolean(r4)
                            boolean r2 = r2.booleanValue()
                            if (r2 == 0) goto L_0x0147
                            java.lang.String r2 = "1"
                            goto L_0x0149
                        L_0x0147:
                            java.lang.String r2 = "0"
                        L_0x0149:
                            r1.put(r3, r2)
                        L_0x014c:
                            boolean r2 = r7
                            if (r2 != 0) goto L_0x0157
                            java.lang.String r2 = "md5"
                            java.lang.String r3 = r5
                            r1.put(r2, r3)
                        L_0x0157:
                            com.meizu.media.camera.h.c r2 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            android.content.Context r2 = r2.f10334b
                            android.content.ContentResolver r2 = r2.getContentResolver()
                            android.net.Uri r3 = com.meizu.media.camera.database.CameraContract.C2035a.f9491a
                            java.lang.String r4 = "sticker_id=?"
                            java.lang.String[] r0 = new java.lang.String[r0]
                            java.lang.String r5 = r6
                            r0[r8] = r5
                            r2.update(r3, r1, r4, r0)
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$a r0 = r0.f10337e
                            if (r0 == 0) goto L_0x0183
                            com.meizu.media.camera.h.c r0 = com.meizu.media.camera.p071h.StickerNetworkManager.this
                            com.meizu.media.camera.h.c$a r0 = r0.f10337e
                            java.lang.String r1 = r6
                            boolean r2 = r7
                            r0.mo20283a(r1, r2)
                        L_0x0183:
                            byte[] r0 = r11.f326b
                            com.android.volley.b$a r11 = com.android.volley.toolbox.HttpHeaderParser.m669a((com.android.volley.NetworkResponse) r11)
                            com.android.volley.o r11 = com.android.volley.Response.m610a(r0, r11)
                            return r11
                        L_0x018e:
                            if (r1 == 0) goto L_0x0198
                            r1.close()     // Catch:{ IOException -> 0x0194 }
                            goto L_0x0198
                        L_0x0194:
                            r0 = move-exception
                            r0.printStackTrace()
                        L_0x0198:
                            throw r11
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p071h.StickerNetworkManager.C21125.parseNetworkResponse(com.android.volley.k):com.android.volley.o");
                    }
                };
                if (this.f10335c != null) {
                    r0.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
                    r0.setTag(f10333j);
                    this.f10335c.mo8703a(r0);
                    return;
                }
                return;
            }
            LogUtil.m15949b(f10333j, "uri is not a HTTP/HTTPS URI, url:" + str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10607a(String str, VolleyError tVar) {
        Class[] clsArr = {String.class, VolleyError.class};
        if (!PatchProxy.proxy(new Object[]{str, tVar}, this, f10332a, false, 5367, clsArr, Void.TYPE).isSupported) {
            m10604a(tVar);
            if (this.f10337e != null) {
                this.f10337e.mo20284b(str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10615a(Map<String, String> map) {
        String str;
        if (!PatchProxy.proxy(new Object[]{map}, this, f10332a, false, 5365, new Class[]{Map.class}, Void.TYPE).isSupported) {
            if (DeviceUtil.m16201c(this.f10334b) == null) {
                str = "0123456789abc";
            } else {
                str = DeviceUtil.m16201c(this.f10334b);
            }
            map.put("imei", str);
            map.put("sn", DeviceUtil.m16204d());
            map.put(NotifyType.VIBRATE, String.valueOf(8007017));
            map.put(Constants.PARAM_APK_VERSION_NAME, String.valueOf("8.7.17"));
            map.put(Parameters.f15985OS, String.valueOf(DeviceUtil.m16205e()));
            map.put("cts", String.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: d */
    private JSONObject m10625d(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f10332a, false, 5366, new Class[]{String.class}, JSONObject.class);
        if (proxy.isSupported) {
            return (JSONObject) proxy.result;
        }
        try {
            return JSON.parseObject(str);
        } catch (Exception e) {
            LogUtil.C2630a aVar = f10333j;
            LogUtil.m15949b(aVar, "JSON parse ERROR" + e.getMessage());
            return null;
        }
    }
}
