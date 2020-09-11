package com.meizu.media.camera;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.mediatek.media.MtkMediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class Storage {

    /* renamed from: a */
    public static ChangeQuickRedirect f7386a;

    /* renamed from: b */
    public static final String f7387b = Environment.getExternalStorageDirectory().toString();

    /* renamed from: c */
    public static String f7388c = "/storage/sdcard1";

    /* renamed from: d */
    private static final LogUtil.C2630a f7389d = new LogUtil.C2630a("Storage");

    /* renamed from: f */
    private static final String f7390f = ("FunnyCam" + File.separator + "Stickers");

    /* renamed from: g */
    private static final String f7391g = ("FunnyCam" + File.separator + "ARStickers");

    /* renamed from: h */
    private static Storage f7392h;

    /* renamed from: n */
    private static Uri f7393n;

    /* renamed from: e */
    private String f7394e = f7387b;

    /* renamed from: i */
    private final Map<String, Long> f7395i = new HashMap();

    /* renamed from: j */
    private boolean f7396j = false;

    /* renamed from: k */
    private boolean f7397k = false;

    /* renamed from: l */
    private final Map<Long, CameraController.C1880f[]> f7398l = new HashMap();

    /* renamed from: m */
    private Rect f7399m;

    public enum DIRECTION {
        DEFAUTL,
        BURST,
        BACKTRACE,
        DOCUMENTS,
        REFOCUS,
        VIDEO,
        SELFIE,
        PANORAMA,
        AR;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    private Storage() {
    }

    /* renamed from: a */
    public static Storage m7750a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7386a, true, 2122, new Class[0], Storage.class);
        if (proxy.isSupported) {
            return (Storage) proxy.result;
        }
        if (f7392h == null) {
            f7392h = new Storage();
        }
        return f7392h;
    }

    /* renamed from: a */
    public void mo18630a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2123, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f7394e = str;
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15952c(aVar, "setStoragePath " + this.f7394e);
        }
    }

    /* renamed from: b */
    public void mo18640b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2124, new Class[]{String.class}, Void.TYPE).isSupported) {
            f7388c = str;
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15952c(aVar, "updateSdcardPath " + str);
        }
    }

    /* renamed from: a */
    private static void m7754a(ContentValues contentValues, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{contentValues, new Integer(i), new Integer(i2)}, (Object) null, f7386a, true, 2125, new Class[]{ContentValues.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && ApiHelper.f14204e) {
            contentValues.put("width", Integer.valueOf(i));
            contentValues.put("height", Integer.valueOf(i2));
        }
    }

    /* renamed from: a */
    public static void m7757a(String str, byte[] bArr) {
        Class[] clsArr = {String.class, byte[].class};
        if (!PatchProxy.proxy(new Object[]{str, bArr}, (Object) null, f7386a, true, 2126, clsArr, Void.TYPE).isSupported) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        LogUtil.m15950b(f7389d, "Failed to write data", e);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                LogUtil.m15950b(f7389d, "Failed to write data", e);
                fileOutputStream.close();
            }
        }
    }

    /* renamed from: a */
    public static void m7756a(String str, Bitmap bitmap, int i) {
        Object[] objArr = {str, bitmap, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 2127, new Class[]{String.class, Bitmap.class, Integer.TYPE}, Void.TYPE).isSupported) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        LogUtil.m15950b(f7389d, "Failed to write data", e);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                LogUtil.m15950b(f7389d, "Failed to write data", e);
                fileOutputStream.close();
            }
        }
    }

    /* renamed from: a */
    public String mo18626a(boolean z, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), str}, this, f7386a, false, 2128, new Class[]{Boolean.TYPE, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return z ? mo18648d(str) : mo18644c(str);
    }

    /* renamed from: a */
    public synchronized void mo18627a(int i, byte[] bArr, String str) {
        DataOutputStream dataOutputStream;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), bArr, str}, this, f7386a, false, 2130, new Class[]{Integer.TYPE, byte[].class, String.class}, Void.TYPE).isSupported) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str, true);
                try {
                    dataOutputStream = new DataOutputStream(fileOutputStream2);
                } catch (Exception e) {
                    e = e;
                    dataOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    try {
                        LogUtil.m15942a(f7389d, "save dualCamData failed");
                        e.printStackTrace();
                        CameraUtil.m15853a((Closeable) fileOutputStream);
                        CameraUtil.m15853a((Closeable) dataOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        CameraUtil.m15853a((Closeable) fileOutputStream);
                        CameraUtil.m15853a((Closeable) dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    CameraUtil.m15853a((Closeable) fileOutputStream);
                    CameraUtil.m15853a((Closeable) dataOutputStream);
                    throw th;
                }
                try {
                    dataOutputStream.writeInt(bArr.length + 5);
                    dataOutputStream.write(i);
                    dataOutputStream.write(bArr);
                    CameraUtil.m15853a((Closeable) fileOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    LogUtil.m15942a(f7389d, "save dualCamData failed");
                    e.printStackTrace();
                    CameraUtil.m15853a((Closeable) fileOutputStream);
                    CameraUtil.m15853a((Closeable) dataOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    CameraUtil.m15853a((Closeable) fileOutputStream);
                    CameraUtil.m15853a((Closeable) dataOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                dataOutputStream = null;
                LogUtil.m15942a(f7389d, "save dualCamData failed");
                e.printStackTrace();
                CameraUtil.m15853a((Closeable) fileOutputStream);
                CameraUtil.m15853a((Closeable) dataOutputStream);
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
                CameraUtil.m15853a((Closeable) fileOutputStream);
                CameraUtil.m15853a((Closeable) dataOutputStream);
                throw th;
            }
            CameraUtil.m15853a((Closeable) dataOutputStream);
        }
    }

    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.io.ByteArrayInputStream] */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e8 A[SYNTHETIC, Splitter:B:50:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f0 A[Catch:{ IOException -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f5 A[Catch:{ IOException -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fa A[Catch:{ IOException -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0104 A[SYNTHETIC, Splitter:B:66:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010c A[Catch:{ IOException -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0111 A[Catch:{ IOException -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0116 A[Catch:{ IOException -> 0x0108 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo18633a(byte[] r12, java.lang.String r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0127 }
            r2 = 0
            r1[r2] = r12     // Catch:{ all -> 0x0127 }
            r8 = 1
            r1[r8] = r13     // Catch:{ all -> 0x0127 }
            com.meizu.savior.ChangeQuickRedirect r3 = f7386a     // Catch:{ all -> 0x0127 }
            r4 = 0
            r5 = 2131(0x853, float:2.986E-42)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0127 }
            java.lang.Class<byte[]> r0 = byte[].class
            r6[r2] = r0     // Catch:{ all -> 0x0127 }
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0     // Catch:{ all -> 0x0127 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0127 }
            r2 = r11
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0127 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0127 }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r11)
            return
        L_0x0026:
            if (r12 == 0) goto L_0x011e
            int r0 = r12.length     // Catch:{ all -> 0x0127 }
            if (r0 != 0) goto L_0x002d
            goto L_0x011e
        L_0x002d:
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x00d8, all -> 0x00d3 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x00d8, all -> 0x00d3 }
            com.meizu.media.camera.util.ag r2 = new com.meizu.media.camera.util.ag     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            int r3 = r2.mo22664a()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            int r4 = r2.mo22664a()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            int r5 = r2.mo22664a()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            int r6 = r2.mo22664a()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            com.meizu.media.camera.util.ac$a r7 = f7389d     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            r9.<init>()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.lang.String r10 = "data len="
            r9.append(r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            int r10 = r12.length     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            r9.append(r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.lang.String r10 = " mainOfs="
            r9.append(r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            r9.append(r3)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.lang.String r10 = " mainSize="
            r9.append(r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            r9.append(r4)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.lang.String r10 = " subOfs="
            r9.append(r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            r9.append(r5)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.lang.String r10 = " subSize="
            r9.append(r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            r9.append(r6)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r7, (java.lang.String) r9)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            r7.<init>(r13, r8)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            java.io.DataOutputStream r13 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            r13.<init>(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            int r0 = r4 + 5
            r13.writeInt(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r0 = 3
            r13.write(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r13.write(r12, r3, r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            int r0 = r6 + 5
            r13.writeInt(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r0 = 4
            r13.write(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r13.write(r12, r5, r6)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r1.close()     // Catch:{ IOException -> 0x00b1 }
            r2.close()     // Catch:{ IOException -> 0x00b1 }
            r7.close()     // Catch:{ IOException -> 0x00b1 }
            r13.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00fd
        L_0x00b1:
            r12 = move-exception
        L_0x00b2:
            r12.printStackTrace()     // Catch:{ all -> 0x0127 }
            goto L_0x00fd
        L_0x00b7:
            r12 = move-exception
            goto L_0x0101
        L_0x00ba:
            r12 = move-exception
            goto L_0x00d1
        L_0x00bc:
            r12 = move-exception
            r13 = r0
            goto L_0x0101
        L_0x00bf:
            r12 = move-exception
            r13 = r0
            goto L_0x00d1
        L_0x00c2:
            r12 = move-exception
            r13 = r0
            goto L_0x0102
        L_0x00c5:
            r12 = move-exception
            r13 = r0
            r7 = r13
            goto L_0x00d1
        L_0x00c9:
            r12 = move-exception
            r13 = r0
            r2 = r13
            goto L_0x0102
        L_0x00cd:
            r12 = move-exception
            r13 = r0
            r2 = r13
            r7 = r2
        L_0x00d1:
            r0 = r1
            goto L_0x00dc
        L_0x00d3:
            r12 = move-exception
            r13 = r0
            r1 = r13
            r2 = r1
            goto L_0x0102
        L_0x00d8:
            r12 = move-exception
            r13 = r0
            r2 = r13
            r7 = r2
        L_0x00dc:
            com.meizu.media.camera.util.ac$a r1 = f7389d     // Catch:{ all -> 0x00ff }
            java.lang.String r3 = "save dualCamData failed"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r3)     // Catch:{ all -> 0x00ff }
            r12.printStackTrace()     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x00ee
            r0.close()     // Catch:{ IOException -> 0x00ec }
            goto L_0x00ee
        L_0x00ec:
            r12 = move-exception
            goto L_0x00b2
        L_0x00ee:
            if (r2 == 0) goto L_0x00f3
            r2.close()     // Catch:{ IOException -> 0x00ec }
        L_0x00f3:
            if (r7 == 0) goto L_0x00f8
            r7.close()     // Catch:{ IOException -> 0x00ec }
        L_0x00f8:
            if (r13 == 0) goto L_0x00fd
            r13.close()     // Catch:{ IOException -> 0x00ec }
        L_0x00fd:
            monitor-exit(r11)
            return
        L_0x00ff:
            r12 = move-exception
            r1 = r0
        L_0x0101:
            r0 = r7
        L_0x0102:
            if (r1 == 0) goto L_0x010a
            r1.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x010a
        L_0x0108:
            r13 = move-exception
            goto L_0x011a
        L_0x010a:
            if (r2 == 0) goto L_0x010f
            r2.close()     // Catch:{ IOException -> 0x0108 }
        L_0x010f:
            if (r0 == 0) goto L_0x0114
            r0.close()     // Catch:{ IOException -> 0x0108 }
        L_0x0114:
            if (r13 == 0) goto L_0x011d
            r13.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x011d
        L_0x011a:
            r13.printStackTrace()     // Catch:{ all -> 0x0127 }
        L_0x011d:
            throw r12     // Catch:{ all -> 0x0127 }
        L_0x011e:
            com.meizu.media.camera.util.ac$a r12 = f7389d     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = "save dualCamData, data is null or empty!"
            com.meizu.media.camera.util.LogUtil.m15956e(r12, r13)     // Catch:{ all -> 0x0127 }
            monitor-exit(r11)
            return
        L_0x0127:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.mo18633a(byte[], java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0159  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri mo18617a(android.content.ContentResolver r26, java.lang.String r27, long r28, android.location.Location r30, int r31, com.meizu.media.camera.p067d.ExifInterface r32, byte[] r33, android.graphics.Bitmap r34, android.graphics.Point[] r35, java.lang.String r36, int r37, int r38, com.meizu.media.camera.p064a.XmpMetaData r39) {
        /*
            r25 = this;
            r0 = r32
            r1 = r33
            r2 = r34
            r3 = r35
            r7 = r36
            r4 = r39
            r5 = 13
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r6 = 0
            r8[r6] = r26
            r14 = 1
            r8[r14] = r27
            java.lang.Long r9 = new java.lang.Long
            r12 = r28
            r9.<init>(r12)
            r15 = 2
            r8[r15] = r9
            r9 = 3
            r8[r9] = r30
            java.lang.Integer r10 = new java.lang.Integer
            r11 = r31
            r10.<init>(r11)
            r16 = 4
            r8[r16] = r10
            r10 = 5
            r8[r10] = r0
            r17 = 6
            r8[r17] = r1
            r18 = 7
            r8[r18] = r2
            r19 = 8
            r8[r19] = r3
            r20 = 9
            r8[r20] = r7
            java.lang.Integer r10 = new java.lang.Integer
            r12 = r37
            r10.<init>(r12)
            r13 = 10
            r8[r13] = r10
            java.lang.Integer r10 = new java.lang.Integer
            r12 = r38
            r10.<init>(r12)
            r22 = 11
            r8[r22] = r10
            r10 = 12
            r8[r10] = r4
            com.meizu.savior.ChangeQuickRedirect r23 = f7386a
            java.lang.Class[] r5 = new java.lang.Class[r5]
            java.lang.Class<android.content.ContentResolver> r24 = android.content.ContentResolver.class
            r5[r6] = r24
            java.lang.Class<java.lang.String> r24 = java.lang.String.class
            r5[r14] = r24
            java.lang.Class r24 = java.lang.Long.TYPE
            r5[r15] = r24
            java.lang.Class<android.location.Location> r24 = android.location.Location.class
            r5[r9] = r24
            java.lang.Class r9 = java.lang.Integer.TYPE
            r5[r16] = r9
            java.lang.Class<com.meizu.media.camera.d.c> r9 = com.meizu.media.camera.p067d.ExifInterface.class
            r21 = 5
            r5[r21] = r9
            java.lang.Class<byte[]> r9 = byte[].class
            r5[r17] = r9
            java.lang.Class<android.graphics.Bitmap> r9 = android.graphics.Bitmap.class
            r5[r18] = r9
            java.lang.Class<android.graphics.Point[]> r9 = android.graphics.Point[].class
            r5[r19] = r9
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r5[r20] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r5[r13] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r5[r22] = r9
            java.lang.Class<com.meizu.media.camera.a.g> r9 = com.meizu.media.camera.p064a.XmpMetaData.class
            r5[r10] = r9
            java.lang.Class<android.net.Uri> r17 = android.net.Uri.class
            r13 = 0
            r18 = 2132(0x854, float:2.988E-42)
            r9 = r25
            r10 = r23
            r11 = r13
            r12 = r18
            r13 = r5
            r5 = 1
            r14 = r17
            com.meizu.savior.PatchProxyResult r8 = com.meizu.savior.PatchProxy.proxy(r8, r9, r10, r11, r12, r13, r14)
            boolean r9 = r8.isSupported
            if (r9 == 0) goto L_0x00b2
            java.lang.Object r0 = r8.result
            android.net.Uri r0 = (android.net.Uri) r0
            return r0
        L_0x00b2:
            if (r3 == 0) goto L_0x0179
            if (r2 != 0) goto L_0x00b8
            goto L_0x0179
        L_0x00b8:
            r8 = 100
            if (r0 == 0) goto L_0x00ca
            r0.mo19848a((android.graphics.Bitmap) r2, (java.lang.String) r7, (int) r8)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00cd
        L_0x00c0:
            r0 = move-exception
            r8 = r0
            com.meizu.media.camera.util.ac$a r0 = f7389d
            java.lang.String r9 = "Failed to write cropBitmap"
            com.meizu.media.camera.util.LogUtil.m15950b(r0, r9, r8)
            goto L_0x00cd
        L_0x00ca:
            m7756a((java.lang.String) r7, (android.graphics.Bitmap) r2, (int) r8)
        L_0x00cd:
            int r8 = r34.getWidth()
            int r9 = r34.getHeight()
            r2 = 0
            r10 = 0
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x013a }
            r11.<init>(r7, r5)     // Catch:{ Exception -> 0x013a }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0133, all -> 0x0131 }
            r2.<init>(r11)     // Catch:{ Exception -> 0x0133, all -> 0x0131 }
            com.meizu.media.camera.util.ac$a r0 = f7389d     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r5.<init>()     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            java.lang.String r10 = "addDocumentData: points.length = "
            r5.append(r10)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            int r10 = r3.length     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r5.append(r10)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            java.lang.String r10 = ", originData.length = "
            r5.append(r10)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            int r10 = r1.length     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r5.append(r10)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            int r0 = r3.length     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            int r0 = r0 * 2
            int r0 = r0 * 4
            r2.writeInt(r0)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r0 = 0
        L_0x010a:
            int r5 = r3.length     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            if (r0 >= r5) goto L_0x011e
            r5 = r3[r0]     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            int r5 = r5.x     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r2.writeInt(r5)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r5 = r3[r0]     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            int r5 = r5.y     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r2.writeInt(r5)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            int r0 = r0 + 1
            goto L_0x010a
        L_0x011e:
            int r0 = r1.length     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r2.writeInt(r0)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            r2.write(r1)     // Catch:{ Exception -> 0x012e, all -> 0x012c }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r11)
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)
            goto L_0x0157
        L_0x012c:
            r0 = move-exception
            goto L_0x0172
        L_0x012e:
            r0 = move-exception
            r10 = r2
            goto L_0x0134
        L_0x0131:
            r0 = move-exception
            goto L_0x0138
        L_0x0133:
            r0 = move-exception
        L_0x0134:
            r2 = r11
            goto L_0x013b
        L_0x0136:
            r0 = move-exception
            r11 = r2
        L_0x0138:
            r2 = r10
            goto L_0x0172
        L_0x013a:
            r0 = move-exception
        L_0x013b:
            com.meizu.media.camera.util.ac$a r3 = f7389d     // Catch:{ all -> 0x0136 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r5.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r11 = "write document bitmap failed, e = "
            r5.append(r11)     // Catch:{ all -> 0x0136 }
            r5.append(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0136 }
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0136 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r10)
        L_0x0157:
            if (r4 == 0) goto L_0x015c
            com.meizu.media.camera.util.XmpUtilHelper.m16123a((java.lang.String) r7, (com.meizu.media.camera.p064a.XmpMetaData) r4)
        L_0x015c:
            int r10 = r1.length
            boolean[] r11 = new boolean[r6]
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r5 = r31
            r6 = r10
            r7 = r36
            r10 = r11
            android.net.Uri r0 = m7749a(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0172:
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r11)
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)
            throw r0
        L_0x0179:
            com.meizu.media.camera.util.ac$a r2 = f7389d
            java.lang.String r3 = "no documents when capturing"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            if (r0 == 0) goto L_0x0190
            r0.mo19856a((byte[]) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x0186 }
            goto L_0x0193
        L_0x0186:
            r0 = move-exception
            r2 = r0
            com.meizu.media.camera.util.ac$a r0 = f7389d
            java.lang.String r3 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r0, r3, r2)
            goto L_0x0193
        L_0x0190:
            m7757a((java.lang.String) r7, (byte[]) r1)
        L_0x0193:
            if (r4 == 0) goto L_0x0198
            com.meizu.media.camera.util.XmpUtilHelper.m16123a((java.lang.String) r7, (com.meizu.media.camera.p064a.XmpMetaData) r4)
        L_0x0198:
            int r8 = r1.length
            boolean[] r10 = new boolean[r6]
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r5 = r31
            r6 = r8
            r7 = r36
            r8 = r37
            r9 = r38
            android.net.Uri r0 = m7749a(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.mo18617a(android.content.ContentResolver, java.lang.String, long, android.location.Location, int, com.meizu.media.camera.d.c, byte[], android.graphics.Bitmap, android.graphics.Point[], java.lang.String, int, int, com.meizu.media.camera.a.g):android.net.Uri");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri mo18615a(android.content.ContentResolver r23, java.lang.String r24, long r25, android.location.Location r27, int r28, com.meizu.media.camera.p067d.ExifInterface r29, byte[] r30, int r31, int r32, boolean r33, com.meizu.media.camera.p064a.XmpMetaData r34) {
        /*
            r22 = this;
            r2 = r24
            r0 = r29
            r1 = r30
            r9 = r33
            r10 = r34
            r3 = 11
            java.lang.Object[] r11 = new java.lang.Object[r3]
            r8 = 0
            r11[r8] = r23
            r4 = 1
            r11[r4] = r2
            java.lang.Long r5 = new java.lang.Long
            r6 = r25
            r5.<init>(r6)
            r12 = 2
            r11[r12] = r5
            r5 = 3
            r11[r5] = r27
            java.lang.Integer r13 = new java.lang.Integer
            r15 = r28
            r13.<init>(r15)
            r14 = 4
            r11[r14] = r13
            r13 = 5
            r11[r13] = r0
            r16 = 6
            r11[r16] = r1
            java.lang.Integer r13 = new java.lang.Integer
            r15 = r31
            r13.<init>(r15)
            r17 = 7
            r11[r17] = r13
            java.lang.Integer r13 = new java.lang.Integer
            r15 = r32
            r13.<init>(r15)
            r18 = 8
            r11[r18] = r13
            java.lang.Byte r13 = new java.lang.Byte
            r13.<init>(r9)
            r19 = 9
            r11[r19] = r13
            r13 = 10
            r11[r13] = r10
            com.meizu.savior.ChangeQuickRedirect r20 = f7386a
            java.lang.Class[] r3 = new java.lang.Class[r3]
            java.lang.Class<android.content.ContentResolver> r21 = android.content.ContentResolver.class
            r3[r8] = r21
            java.lang.Class<java.lang.String> r21 = java.lang.String.class
            r3[r4] = r21
            java.lang.Class r4 = java.lang.Long.TYPE
            r3[r12] = r4
            java.lang.Class<android.location.Location> r4 = android.location.Location.class
            r3[r5] = r4
            java.lang.Class r4 = java.lang.Integer.TYPE
            r3[r14] = r4
            java.lang.Class<com.meizu.media.camera.d.c> r4 = com.meizu.media.camera.p067d.ExifInterface.class
            r5 = 5
            r3[r5] = r4
            java.lang.Class<byte[]> r4 = byte[].class
            r3[r16] = r4
            java.lang.Class r4 = java.lang.Integer.TYPE
            r3[r17] = r4
            java.lang.Class r4 = java.lang.Integer.TYPE
            r3[r18] = r4
            java.lang.Class r4 = java.lang.Boolean.TYPE
            r3[r19] = r4
            java.lang.Class<com.meizu.media.camera.a.g> r4 = com.meizu.media.camera.p064a.XmpMetaData.class
            r3[r13] = r4
            java.lang.Class<android.net.Uri> r17 = android.net.Uri.class
            r14 = 0
            r4 = 2133(0x855, float:2.989E-42)
            r12 = r22
            r13 = r20
            r15 = r4
            r16 = r3
            com.meizu.savior.PatchProxyResult r3 = com.meizu.savior.PatchProxy.proxy(r11, r12, r13, r14, r15, r16, r17)
            boolean r4 = r3.isSupported
            if (r4 == 0) goto L_0x009f
            java.lang.Object r0 = r3.result
            android.net.Uri r0 = (android.net.Uri) r0
            return r0
        L_0x009f:
            r12 = r22
            java.lang.String r11 = r12.mo18626a((boolean) r9, (java.lang.String) r2)
            if (r0 == 0) goto L_0x00c5
            r5 = 0
            r3 = r29
            r4 = r30
            r6 = r31
            r7 = r32
            r13 = 0
            r8 = r28
            r9 = r33
            m7755a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00bc }
            r0.mo19856a((byte[]) r1, (java.lang.String) r11)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c9
        L_0x00bc:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r3 = f7389d
            java.lang.String r4 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r3, r4, r0)
            goto L_0x00c9
        L_0x00c5:
            r13 = 0
            m7757a((java.lang.String) r11, (byte[]) r1)
        L_0x00c9:
            if (r10 == 0) goto L_0x00ce
            com.meizu.media.camera.util.XmpUtilHelper.m16123a((java.lang.String) r11, (com.meizu.media.camera.p064a.XmpMetaData) r10)
        L_0x00ce:
            int r7 = r1.length
            boolean[] r0 = new boolean[r13]
            r1 = r23
            r2 = r24
            r3 = r25
            r5 = r27
            r6 = r28
            r8 = r11
            r9 = r31
            r10 = r32
            r11 = r0
            android.net.Uri r0 = m7749a(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.mo18615a(android.content.ContentResolver, java.lang.String, long, android.location.Location, int, com.meizu.media.camera.d.c, byte[], int, int, boolean, com.meizu.media.camera.a.g):android.net.Uri");
    }

    /* renamed from: a */
    public void mo18631a(String str, ExifInterface cVar, byte[] bArr) {
        Class[] clsArr = {String.class, ExifInterface.class, byte[].class};
        if (!PatchProxy.proxy(new Object[]{str, cVar, bArr}, this, f7386a, false, 2134, clsArr, Void.TYPE).isSupported) {
            if (cVar != null) {
                try {
                    cVar.mo19856a(bArr, str);
                } catch (Exception e) {
                    LogUtil.m15950b(f7389d, "Failed to write data", e);
                }
            } else {
                m7757a(str, bArr);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18632a(java.lang.String r23, com.meizu.media.camera.p067d.ExifInterface r24, byte[] r25, int r26, int r27, int r28, int r29, boolean r30, java.lang.Boolean r31) {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = 9
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r15 = 0
            r9[r15] = r0
            r14 = 1
            r9[r14] = r1
            r16 = 2
            r9[r16] = r2
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r3)
            r13 = 3
            r9[r13] = r10
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r4)
            r11 = 4
            r9[r11] = r10
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r5)
            r12 = 5
            r9[r12] = r10
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r6)
            r17 = 6
            r9[r17] = r10
            java.lang.Byte r10 = new java.lang.Byte
            r10.<init>(r7)
            r18 = 7
            r9[r18] = r10
            r10 = 8
            r9[r10] = r31
            com.meizu.savior.ChangeQuickRedirect r19 = f7386a
            java.lang.Class[] r8 = new java.lang.Class[r8]
            java.lang.Class<java.lang.String> r20 = java.lang.String.class
            r8[r15] = r20
            java.lang.Class<com.meizu.media.camera.d.c> r20 = com.meizu.media.camera.p067d.ExifInterface.class
            r8[r14] = r20
            java.lang.Class<byte[]> r20 = byte[].class
            r8[r16] = r20
            java.lang.Class r20 = java.lang.Integer.TYPE
            r8[r13] = r20
            java.lang.Class r20 = java.lang.Integer.TYPE
            r8[r11] = r20
            java.lang.Class r11 = java.lang.Integer.TYPE
            r8[r12] = r11
            java.lang.Class r11 = java.lang.Integer.TYPE
            r8[r17] = r11
            java.lang.Class r11 = java.lang.Boolean.TYPE
            r8[r18] = r11
            java.lang.Class<java.lang.Boolean> r11 = java.lang.Boolean.class
            r8[r10] = r11
            java.lang.Class r17 = java.lang.Void.TYPE
            r12 = 0
            r18 = 2135(0x857, float:2.992E-42)
            r10 = r22
            r11 = r19
            r13 = r18
            r14 = r8
            r8 = 0
            r15 = r17
            com.meizu.savior.PatchProxyResult r9 = com.meizu.savior.PatchProxy.proxy(r9, r10, r11, r12, r13, r14, r15)
            boolean r9 = r9.isSupported
            if (r9 == 0) goto L_0x008c
            return
        L_0x008c:
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream
            r10 = 1024(0x400, float:1.435E-42)
            r9.<init>(r10)
            if (r5 == r3) goto L_0x009a
            r10 = 1
            com.meizu.media.cameraAlgorithm.yuv.YuvUtil.convertNv21torealyuv(r2, r3, r4, r5, r10)
            goto L_0x009b
        L_0x009a:
            r10 = 1
        L_0x009b:
            byte[] r2 = com.meizu.media.cameraAlgorithm.yuv.YuvUtil.rotateNV21Data(r2, r3, r4, r6, r7)
            r5 = 90
            if (r6 == r5) goto L_0x00a7
            r5 = 270(0x10e, float:3.78E-43)
            if (r6 != r5) goto L_0x00ac
        L_0x00a7:
            r21 = r4
            r4 = r3
            r3 = r21
        L_0x00ac:
            android.graphics.YuvImage r5 = new android.graphics.YuvImage
            r6 = 17
            r7 = 3
            int[] r7 = new int[r7]
            r7[r8] = r3
            r7[r10] = r3
            r7[r16] = r3
            r25 = r5
            r26 = r2
            r27 = r6
            r28 = r3
            r29 = r4
            r30 = r7
            r25.<init>(r26, r27, r28, r29, r30)
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>(r8, r8, r3, r4)
            r3 = 75
            r5.compressToJpeg(r6, r3, r9)
            boolean r3 = r31.booleanValue()
            if (r3 == 0) goto L_0x00e2
            boolean r3 = com.meizu.media.camera.CameraOptTask.m8417t()
            if (r3 != 0) goto L_0x00e2
            com.meizu.media.camera.util.C2649i.m16157d()
            goto L_0x00ea
        L_0x00e2:
            int r3 = r2.length
            com.meizu.media.camera.util.i r3 = com.meizu.media.camera.util.C2649i.m16153a((int) r3)
            r3.mo22731a((byte[]) r2)
        L_0x00ea:
            byte[] r2 = r9.toByteArray()
            if (r1 == 0) goto L_0x00fe
            r1.mo19856a((byte[]) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x00f4 }
            goto L_0x0101
        L_0x00f4:
            r0 = move-exception
            r1 = r0
            com.meizu.media.camera.util.ac$a r0 = f7389d
            java.lang.String r2 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r0, r2, r1)
            goto L_0x0101
        L_0x00fe:
            m7757a((java.lang.String) r0, (byte[]) r2)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.mo18632a(java.lang.String, com.meizu.media.camera.d.c, byte[], int, int, int, int, boolean, java.lang.Boolean):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri mo18616a(android.content.ContentResolver r22, java.lang.String r23, long r24, android.location.Location r26, int r27, com.meizu.media.camera.p067d.ExifInterface r28, byte[] r29, int r30, int r31, boolean r32, boolean r33) {
        /*
            r21 = this;
            r2 = r23
            r0 = r28
            r1 = r29
            r9 = r32
            r3 = r33
            r4 = 11
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r8 = 0
            r10[r8] = r22
            r5 = 1
            r10[r5] = r2
            java.lang.Long r6 = new java.lang.Long
            r14 = r24
            r6.<init>(r14)
            r7 = 2
            r10[r7] = r6
            r6 = 3
            r10[r6] = r26
            java.lang.Integer r11 = new java.lang.Integer
            r13 = r27
            r11.<init>(r13)
            r12 = 4
            r10[r12] = r11
            r11 = 5
            r10[r11] = r0
            r16 = 6
            r10[r16] = r1
            java.lang.Integer r11 = new java.lang.Integer
            r14 = r30
            r11.<init>(r14)
            r15 = 7
            r10[r15] = r11
            java.lang.Integer r11 = new java.lang.Integer
            r14 = r31
            r11.<init>(r14)
            r17 = 8
            r10[r17] = r11
            java.lang.Byte r11 = new java.lang.Byte
            r11.<init>(r9)
            r18 = 9
            r10[r18] = r11
            java.lang.Byte r11 = new java.lang.Byte
            r11.<init>(r3)
            r19 = 10
            r10[r19] = r11
            com.meizu.savior.ChangeQuickRedirect r20 = f7386a
            java.lang.Class[] r4 = new java.lang.Class[r4]
            java.lang.Class<android.content.ContentResolver> r11 = android.content.ContentResolver.class
            r4[r8] = r11
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r4[r5] = r11
            java.lang.Class r5 = java.lang.Long.TYPE
            r4[r7] = r5
            java.lang.Class<android.location.Location> r5 = android.location.Location.class
            r4[r6] = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            r4[r12] = r5
            java.lang.Class<com.meizu.media.camera.d.c> r5 = com.meizu.media.camera.p067d.ExifInterface.class
            r6 = 5
            r4[r6] = r5
            java.lang.Class<byte[]> r5 = byte[].class
            r4[r16] = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            r4[r15] = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            r4[r17] = r5
            java.lang.Class r5 = java.lang.Boolean.TYPE
            r4[r18] = r5
            java.lang.Class r5 = java.lang.Boolean.TYPE
            r4[r19] = r5
            java.lang.Class<android.net.Uri> r16 = android.net.Uri.class
            r5 = 0
            r6 = 2136(0x858, float:2.993E-42)
            r11 = r21
            r12 = r20
            r13 = r5
            r14 = r6
            r15 = r4
            com.meizu.savior.PatchProxyResult r4 = com.meizu.savior.PatchProxy.proxy(r10, r11, r12, r13, r14, r15, r16)
            boolean r5 = r4.isSupported
            if (r5 == 0) goto L_0x00a3
            java.lang.Object r0 = r4.result
            android.net.Uri r0 = (android.net.Uri) r0
            return r0
        L_0x00a3:
            r12 = r21
            java.lang.String r10 = r12.mo18626a((boolean) r9, (java.lang.String) r2)
            if (r0 == 0) goto L_0x010f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0105 }
            r4.<init>()     // Catch:{ Exception -> 0x0105 }
            java.lang.String r5 = "dual_camera"
            r4.append(r5)     // Catch:{ Exception -> 0x0105 }
            if (r3 == 0) goto L_0x00ba
            java.lang.String r3 = "|deviceMarkOn"
            goto L_0x00bc
        L_0x00ba:
            java.lang.String r3 = ""
        L_0x00bc:
            r4.append(r3)     // Catch:{ Exception -> 0x0105 }
            java.lang.String r11 = r4.toString()     // Catch:{ Exception -> 0x0105 }
            r5 = 0
            r3 = r28
            r4 = r29
            r6 = r30
            r7 = r31
            r13 = 0
            r8 = r27
            r9 = r32
            m7755a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0103 }
            r0.mo19856a((byte[]) r1, (java.lang.String) r10)     // Catch:{ Exception -> 0x0103 }
            androidx.exifinterface.media.ExifInterface r0 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x0103 }
            r0.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r3 = "UserComment"
            r0.setAttribute(r3, r11)     // Catch:{ Exception -> 0x0103 }
            r0.saveAttributes()     // Catch:{ Exception -> 0x0103 }
            com.meizu.media.camera.util.ac$a r0 = f7389d     // Catch:{ Exception -> 0x0103 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103 }
            r3.<init>()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = "addImage TAG_USER_COMMENT :"
            r3.append(r4)     // Catch:{ Exception -> 0x0103 }
            r3.append(r11)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = ", path:"
            r3.append(r4)     // Catch:{ Exception -> 0x0103 }
            r3.append(r10)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0103 }
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)     // Catch:{ Exception -> 0x0103 }
            goto L_0x0113
        L_0x0103:
            r0 = move-exception
            goto L_0x0107
        L_0x0105:
            r0 = move-exception
            r13 = 0
        L_0x0107:
            com.meizu.media.camera.util.ac$a r3 = f7389d
            java.lang.String r4 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r3, r4, r0)
            goto L_0x0113
        L_0x010f:
            r13 = 0
            m7757a((java.lang.String) r10, (byte[]) r1)
        L_0x0113:
            int r7 = r1.length
            boolean[] r11 = new boolean[r13]
            r1 = r22
            r2 = r23
            r3 = r24
            r5 = r26
            r6 = r27
            r8 = r10
            r9 = r30
            r10 = r31
            android.net.Uri r0 = m7749a(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.mo18616a(android.content.ContentResolver, java.lang.String, long, android.location.Location, int, com.meizu.media.camera.d.c, byte[], int, int, boolean, boolean):android.net.Uri");
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0382  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri mo18613a(android.content.ContentResolver r35, java.lang.String r36, long r37, android.location.Location r39, int r40, com.meizu.media.camera.p067d.ExifInterface r41, android.graphics.Bitmap r42, int r43, int r44, boolean r45, boolean r46, java.lang.String r47, java.lang.Object... r48) {
        /*
            r34 = this;
            r8 = r34
            r10 = r36
            r11 = r37
            r0 = r41
            r9 = r42
            r14 = r45
            r15 = r46
            r7 = r48
            r1 = 13
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r17 = 0
            r2[r17] = r35
            r6 = 1
            r2[r6] = r10
            java.lang.Long r3 = new java.lang.Long
            r3.<init>(r11)
            r5 = 2
            r2[r5] = r3
            r19 = 3
            r2[r19] = r39
            java.lang.Integer r3 = new java.lang.Integer
            r4 = r40
            r3.<init>(r4)
            r4 = 4
            r2[r4] = r3
            r3 = 5
            r2[r3] = r0
            r20 = 6
            r2[r20] = r9
            java.lang.Integer r3 = new java.lang.Integer
            r4 = r43
            r3.<init>(r4)
            r23 = 7
            r2[r23] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r4 = r44
            r3.<init>(r4)
            r24 = 8
            r2[r24] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r14)
            r25 = 9
            r2[r25] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r15)
            r26 = 10
            r2[r26] = r3
            r3 = 11
            r2[r3] = r47
            r27 = 12
            r2[r27] = r7
            com.meizu.savior.ChangeQuickRedirect r27 = f7386a
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.ContentResolver> r28 = android.content.ContentResolver.class
            r1[r17] = r28
            java.lang.Class<java.lang.String> r28 = java.lang.String.class
            r1[r6] = r28
            java.lang.Class r28 = java.lang.Long.TYPE
            r1[r5] = r28
            java.lang.Class<android.location.Location> r28 = android.location.Location.class
            r1[r19] = r28
            java.lang.Class r28 = java.lang.Integer.TYPE
            r22 = 4
            r1[r22] = r28
            java.lang.Class<com.meizu.media.camera.d.c> r28 = com.meizu.media.camera.p067d.ExifInterface.class
            r21 = 5
            r1[r21] = r28
            java.lang.Class<android.graphics.Bitmap> r28 = android.graphics.Bitmap.class
            r1[r20] = r28
            java.lang.Class r20 = java.lang.Integer.TYPE
            r1[r23] = r20
            java.lang.Class r20 = java.lang.Integer.TYPE
            r1[r24] = r20
            java.lang.Class r20 = java.lang.Boolean.TYPE
            r1[r25] = r20
            java.lang.Class r20 = java.lang.Boolean.TYPE
            r1[r26] = r20
            java.lang.Class<java.lang.String> r20 = java.lang.String.class
            r1[r3] = r20
            java.lang.Class<java.lang.Object[]> r3 = java.lang.Object[].class
            r20 = 12
            r1[r20] = r3
            java.lang.Class<android.net.Uri> r20 = android.net.Uri.class
            r23 = 0
            r24 = 2137(0x859, float:2.995E-42)
            r25 = r1
            r1 = r2
            r2 = r34
            r3 = r27
            r13 = 4
            r4 = r23
            r13 = 2
            r5 = r24
            r6 = r25
            r13 = r7
            r7 = r20
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x00cb
            java.lang.Object r0 = r1.result
            android.net.Uri r0 = (android.net.Uri) r0
            return r0
        L_0x00cb:
            java.lang.String r7 = r8.mo18626a((boolean) r14, (java.lang.String) r10)
            r1 = 0
            if (r13 == 0) goto L_0x00e2
            int r2 = r13.length
            r3 = 2
            if (r2 != r3) goto L_0x00e2
            r2 = r13[r17]
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = (com.meizu.media.camera.mode.CameraModeType.ModeType) r2
            r6 = 1
            r3 = r13[r6]
            com.meizu.media.camera.a.g r3 = (com.meizu.media.camera.p064a.XmpMetaData) r3
            r5 = r2
            r4 = r3
            goto L_0x00e5
        L_0x00e2:
            r6 = 1
            r4 = r1
            r5 = r4
        L_0x00e5:
            if (r13 == 0) goto L_0x011b
            int r2 = r13.length
            r3 = 4
            if (r2 != r3) goto L_0x011b
            r1 = r13[r17]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = r13[r6]
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r3 = 2
            r3 = r13[r3]
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r13 = r13[r19]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r6 = r8.mo18622a((java.lang.String) r10, (long) r11)
            r29 = r1
            com.meizu.media.camera.util.ac$a r1 = f7389d
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r6)
            r31 = r4
            r4 = r6
            r1 = r13
            r6 = r29
            r13 = 0
            goto L_0x0163
        L_0x011b:
            if (r13 == 0) goto L_0x015c
            int r2 = r13.length
            r3 = 5
            if (r2 != r3) goto L_0x015c
            r1 = r13[r17]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r6 = 1
            r2 = r13[r6]
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r3 = 2
            r3 = r13[r3]
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r19 = r13[r19]
            java.lang.String r19 = (java.lang.String) r19
            r20 = 4
            r13 = r13[r20]
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            java.lang.String r6 = r8.mo18622a((java.lang.String) r10, (long) r11)
            r30 = r1
            com.meizu.media.camera.util.ac$a r1 = f7389d
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r6)
            r31 = r4
            r4 = r6
            r1 = r19
            r6 = r30
            goto L_0x0163
        L_0x015c:
            r31 = r4
            r2 = 0
            r3 = 0
            r6 = 0
            r13 = 0
            r4 = r1
        L_0x0163:
            if (r15 == 0) goto L_0x0195
            r32 = r5
            java.io.File r5 = new java.io.File
            r5.<init>(r7)
            boolean r19 = r5.exists()
            if (r19 == 0) goto L_0x0197
            android.net.Uri r0 = android.net.Uri.fromFile(r5)
            com.meizu.media.camera.util.ac$a r1 = f7389d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The file already exists path:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = ", uri:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            return r0
        L_0x0195:
            r32 = r5
        L_0x0197:
            if (r0 == 0) goto L_0x01ce
            r2 = 0
            r1 = r41
            r3 = r42
            r13 = r31
            r4 = r43
            r15 = r32
            r5 = r44
            r33 = r6
            r6 = r40
            r8 = r7
            r7 = r45
            m7755a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01c1 }
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP     // Catch:{ Exception -> 0x01c1 }
            boolean r1 = r1.equals(r15)     // Catch:{ Exception -> 0x01c1 }
            if (r1 == 0) goto L_0x01bb
            r1 = 100
            goto L_0x01bd
        L_0x01bb:
            r1 = 90
        L_0x01bd:
            r0.mo19848a((android.graphics.Bitmap) r9, (java.lang.String) r8, (int) r1)     // Catch:{ Exception -> 0x01c1 }
            goto L_0x01c9
        L_0x01c1:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r1 = f7389d
            java.lang.String r2 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r1, r2, r0)
        L_0x01c9:
            r5 = r13
            r6 = r33
            goto L_0x0380
        L_0x01ce:
            r33 = r6
            r8 = r7
            r5 = r31
            r0 = r32
            com.meizu.media.camera.mode.CameraModeType$ModeType r6 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP     // Catch:{ Exception -> 0x0373 }
            boolean r6 = r6.equals(r0)     // Catch:{ Exception -> 0x0373 }
            r7 = 85
            if (r6 == 0) goto L_0x01e2
            r6 = 100
            goto L_0x01e4
        L_0x01e2:
            r6 = 85
        L_0x01e4:
            m7756a((java.lang.String) r8, (android.graphics.Bitmap) r9, (int) r6)     // Catch:{ Exception -> 0x0373 }
            if (r15 == 0) goto L_0x02e0
            if (r13 == 0) goto L_0x0241
            if (r1 != 0) goto L_0x01f0
            java.lang.String r1 = "|deviceMarkOn"
            goto L_0x0201
        L_0x01f0:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0373 }
            r6.<init>()     // Catch:{ Exception -> 0x0373 }
            java.lang.String r13 = "|deviceMarkOn,"
            r6.append(r13)     // Catch:{ Exception -> 0x0373 }
            r6.append(r1)     // Catch:{ Exception -> 0x0373 }
            java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x0373 }
        L_0x0201:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0373 }
            r6.<init>()     // Catch:{ Exception -> 0x0373 }
            java.lang.String r13 = "tof_camera_no_deal"
            r6.append(r13)     // Catch:{ Exception -> 0x0373 }
            if (r2 == 0) goto L_0x020e
            goto L_0x0210
        L_0x020e:
            java.lang.String r1 = ""
        L_0x0210:
            r6.append(r1)     // Catch:{ Exception -> 0x0373 }
            if (r3 == 0) goto L_0x0218
            java.lang.String r1 = "|timeMarkOn"
            goto L_0x021a
        L_0x0218:
            java.lang.String r1 = ""
        L_0x021a:
            r6.append(r1)     // Catch:{ Exception -> 0x0373 }
            java.lang.String r1 = "|"
            r6.append(r1)     // Catch:{ Exception -> 0x0373 }
            r6.append(r4)     // Catch:{ Exception -> 0x0373 }
            java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x0373 }
            com.meizu.media.camera.d.c r2 = new com.meizu.media.camera.d.c     // Catch:{ Exception -> 0x0373 }
            r2.<init>()     // Catch:{ Exception -> 0x0373 }
            r2.mo19852a((java.lang.String) r8)     // Catch:{ Exception -> 0x0373 }
            int r3 = com.meizu.media.camera.p067d.ExifInterface.f9346ae     // Catch:{ Exception -> 0x0373 }
            com.meizu.media.camera.d.h r3 = r2.mo19845a((int) r3, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0373 }
            r2.mo19846a((com.meizu.media.camera.p067d.ExifTag) r3)     // Catch:{ Exception -> 0x0373 }
            r2.mo19848a((android.graphics.Bitmap) r9, (java.lang.String) r8, (int) r7)     // Catch:{ Exception -> 0x0373 }
            r6 = r33
            goto L_0x02b9
        L_0x0241:
            r6 = r33
            if (r6 == 0) goto L_0x02a4
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r13 = com.meizu.media.camera.util.DeviceHelper.f13858aK     // Catch:{ Exception -> 0x0371 }
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r14 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE     // Catch:{ Exception -> 0x0371 }
            if (r13 == r14) goto L_0x02a4
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r13 = com.meizu.media.camera.util.DeviceHelper.f13858aK     // Catch:{ Exception -> 0x0371 }
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r14 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG     // Catch:{ Exception -> 0x0371 }
            if (r13 == r14) goto L_0x02a4
            if (r1 != 0) goto L_0x0256
            java.lang.String r1 = "|deviceMarkOn"
            goto L_0x0267
        L_0x0256:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0371 }
            r13.<init>()     // Catch:{ Exception -> 0x0371 }
            java.lang.String r14 = "|deviceMarkOn,"
            r13.append(r14)     // Catch:{ Exception -> 0x0371 }
            r13.append(r1)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r1 = r13.toString()     // Catch:{ Exception -> 0x0371 }
        L_0x0267:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0371 }
            r13.<init>()     // Catch:{ Exception -> 0x0371 }
            java.lang.String r14 = "dual_camera_no_deal"
            r13.append(r14)     // Catch:{ Exception -> 0x0371 }
            if (r2 == 0) goto L_0x0274
            goto L_0x0276
        L_0x0274:
            java.lang.String r1 = ""
        L_0x0276:
            r13.append(r1)     // Catch:{ Exception -> 0x0371 }
            if (r3 == 0) goto L_0x027e
            java.lang.String r1 = "|timeMarkOn"
            goto L_0x0280
        L_0x027e:
            java.lang.String r1 = ""
        L_0x0280:
            r13.append(r1)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r1 = "|"
            r13.append(r1)     // Catch:{ Exception -> 0x0371 }
            r13.append(r4)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r1 = r13.toString()     // Catch:{ Exception -> 0x0371 }
            com.meizu.media.camera.d.c r2 = new com.meizu.media.camera.d.c     // Catch:{ Exception -> 0x0371 }
            r2.<init>()     // Catch:{ Exception -> 0x0371 }
            r2.mo19852a((java.lang.String) r8)     // Catch:{ Exception -> 0x0371 }
            int r3 = com.meizu.media.camera.p067d.ExifInterface.f9346ae     // Catch:{ Exception -> 0x0371 }
            com.meizu.media.camera.d.h r3 = r2.mo19845a((int) r3, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0371 }
            r2.mo19846a((com.meizu.media.camera.p067d.ExifTag) r3)     // Catch:{ Exception -> 0x0371 }
            r2.mo19848a((android.graphics.Bitmap) r9, (java.lang.String) r8, (int) r7)     // Catch:{ Exception -> 0x0371 }
            goto L_0x02b9
        L_0x02a4:
            androidx.exifinterface.media.ExifInterface r1 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x0371 }
            r1.<init>((java.lang.String) r8)     // Catch:{ Exception -> 0x0371 }
            if (r47 == 0) goto L_0x02ae
            r2 = r47
            goto L_0x02b0
        L_0x02ae:
            java.lang.String r2 = "processing"
        L_0x02b0:
            java.lang.String r3 = "UserComment"
            r1.setAttribute(r3, r2)     // Catch:{ Exception -> 0x0371 }
            r1.saveAttributes()     // Catch:{ Exception -> 0x0371 }
            r1 = r2
        L_0x02b9:
            com.meizu.media.camera.util.ac$a r2 = f7389d     // Catch:{ Exception -> 0x0371 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0371 }
            r3.<init>()     // Catch:{ Exception -> 0x0371 }
            java.lang.String r4 = "addImage isQuaDualCam:"
            r3.append(r4)     // Catch:{ Exception -> 0x0371 }
            r3.append(r6)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r4 = ", TAG_USER_COMMENT:"
            r3.append(r4)     // Catch:{ Exception -> 0x0371 }
            r3.append(r1)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r1 = ", path:"
            r3.append(r1)     // Catch:{ Exception -> 0x0371 }
            r3.append(r8)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0371 }
            com.meizu.media.camera.util.LogUtil.m15952c(r2, r1)     // Catch:{ Exception -> 0x0371 }
            goto L_0x02e2
        L_0x02e0:
            r6 = r33
        L_0x02e2:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP     // Catch:{ Exception -> 0x0371 }
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0371 }
            if (r0 == 0) goto L_0x0380
            androidx.exifinterface.media.ExifInterface r0 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x0371 }
            r0.<init>((java.lang.String) r8)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r1 = "UserComment"
            java.lang.String r2 = "end"
            r0.setAttribute(r1, r2)     // Catch:{ Exception -> 0x0371 }
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "yyyy:MM:dd kk:mm:ss"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0371 }
            java.lang.Long r2 = java.lang.Long.valueOf(r37)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "Make"
            java.lang.String r3 = "Meizu"
            r0.setAttribute(r2, r3)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "Model"
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0371 }
            r0.setAttribute(r2, r3)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "Software"
            java.lang.String r3 = "Meizu Camera"
            r0.setAttribute(r2, r3)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "DateTime"
            r0.setAttribute(r2, r1)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "DateTimeDigitized"
            r0.setAttribute(r2, r1)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "DateTimeOriginal"
            r0.setAttribute(r2, r1)     // Catch:{ Exception -> 0x0371 }
            if (r39 == 0) goto L_0x036d
            java.lang.String r2 = "GPSLatitude"
            double r3 = r39.getLatitude()     // Catch:{ Exception -> 0x0371 }
            java.lang.String r3 = com.meizu.media.camera.util.FormatUtil.m16269a((double) r3)     // Catch:{ Exception -> 0x0371 }
            r0.setAttribute(r2, r3)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "GPSLatitudeRef"
            double r3 = r39.getLatitude()     // Catch:{ Exception -> 0x0371 }
            r13 = 0
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x0347
            java.lang.String r3 = "N"
            goto L_0x0349
        L_0x0347:
            java.lang.String r3 = "S"
        L_0x0349:
            r0.setAttribute(r2, r3)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "GPSLongitude"
            double r3 = r39.getLongitude()     // Catch:{ Exception -> 0x0371 }
            java.lang.String r3 = com.meizu.media.camera.util.FormatUtil.m16269a((double) r3)     // Catch:{ Exception -> 0x0371 }
            r0.setAttribute(r2, r3)     // Catch:{ Exception -> 0x0371 }
            java.lang.String r2 = "GPSLongitudeRef"
            double r3 = r39.getLongitude()     // Catch:{ Exception -> 0x0371 }
            r13 = 0
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x0368
            java.lang.String r3 = "E"
            goto L_0x036a
        L_0x0368:
            java.lang.String r3 = "W"
        L_0x036a:
            r0.setAttribute(r2, r3)     // Catch:{ Exception -> 0x0371 }
        L_0x036d:
            r0.saveAttributes()     // Catch:{ Exception -> 0x0371 }
            goto L_0x0380
        L_0x0371:
            r0 = move-exception
            goto L_0x0376
        L_0x0373:
            r0 = move-exception
            r6 = r33
        L_0x0376:
            r0.printStackTrace()
            com.meizu.media.camera.util.ac$a r2 = f7389d
            java.lang.String r3 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r2, r3, r0)
        L_0x0380:
            if (r5 == 0) goto L_0x0385
            com.meizu.media.camera.util.XmpUtilHelper.m16123a((java.lang.String) r8, (com.meizu.media.camera.p064a.XmpMetaData) r5)
        L_0x0385:
            r15 = 0
            r2 = 1
            boolean[] r0 = new boolean[r2]
            r0[r17] = r6
            r9 = r35
            r10 = r36
            r11 = r37
            r13 = r39
            r14 = r40
            r16 = r8
            r17 = r43
            r18 = r44
            r19 = r0
            android.net.Uri r0 = m7749a(r9, r10, r11, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.mo18613a(android.content.ContentResolver, java.lang.String, long, android.location.Location, int, com.meizu.media.camera.d.c, android.graphics.Bitmap, int, int, boolean, boolean, java.lang.String, java.lang.Object[]):android.net.Uri");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri mo18614a(android.content.ContentResolver r30, java.lang.String r31, long r32, android.location.Location r34, int r35, com.meizu.media.camera.p067d.ExifInterface r36, com.meizu.media.camera.p064a.XmpMetaData r37, byte[] r38, int r39, int r40, boolean r41, boolean r42, boolean r43, boolean r44) {
        /*
            r29 = this;
            r2 = r31
            r0 = r36
            r1 = r37
            r10 = r38
            r9 = r41
            r11 = r42
            r12 = r43
            r3 = 14
            java.lang.Object[] r13 = new java.lang.Object[r3]
            r4 = 0
            r13[r4] = r30
            r5 = 1
            r13[r5] = r2
            java.lang.Long r6 = new java.lang.Long
            r7 = r32
            r6.<init>(r7)
            r14 = 2
            r13[r14] = r6
            r6 = 3
            r13[r6] = r34
            java.lang.Integer r15 = new java.lang.Integer
            r6 = r35
            r15.<init>(r6)
            r16 = 4
            r13[r16] = r15
            r15 = 5
            r13[r15] = r0
            r17 = 6
            r13[r17] = r1
            r18 = 7
            r13[r18] = r10
            java.lang.Integer r15 = new java.lang.Integer
            r14 = r39
            r15.<init>(r14)
            r19 = 8
            r13[r19] = r15
            java.lang.Integer r15 = new java.lang.Integer
            r5 = r40
            r15.<init>(r5)
            r23 = 9
            r13[r23] = r15
            java.lang.Byte r15 = new java.lang.Byte
            r15.<init>(r9)
            r24 = 10
            r13[r24] = r15
            java.lang.Byte r15 = new java.lang.Byte
            r15.<init>(r11)
            r25 = 11
            r13[r25] = r15
            java.lang.Byte r15 = new java.lang.Byte
            r15.<init>(r12)
            r26 = 12
            r13[r26] = r15
            java.lang.Byte r15 = new java.lang.Byte
            r4 = r44
            r15.<init>(r4)
            r4 = 13
            r13[r4] = r15
            com.meizu.savior.ChangeQuickRedirect r15 = f7386a
            java.lang.Class[] r3 = new java.lang.Class[r3]
            java.lang.Class<android.content.ContentResolver> r28 = android.content.ContentResolver.class
            r27 = 0
            r3[r27] = r28
            java.lang.Class<java.lang.String> r27 = java.lang.String.class
            r22 = 1
            r3[r22] = r27
            java.lang.Class r22 = java.lang.Long.TYPE
            r21 = 2
            r3[r21] = r22
            java.lang.Class<android.location.Location> r21 = android.location.Location.class
            r20 = 3
            r3[r20] = r21
            java.lang.Class r20 = java.lang.Integer.TYPE
            r3[r16] = r20
            java.lang.Class<com.meizu.media.camera.d.c> r16 = com.meizu.media.camera.p067d.ExifInterface.class
            r20 = 5
            r3[r20] = r16
            java.lang.Class<com.meizu.media.camera.a.g> r16 = com.meizu.media.camera.p064a.XmpMetaData.class
            r3[r17] = r16
            java.lang.Class<byte[]> r16 = byte[].class
            r3[r18] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r3[r19] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r3[r23] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r3[r24] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r3[r25] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r3[r26] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r3[r4] = r16
            java.lang.Class<android.net.Uri> r19 = android.net.Uri.class
            r16 = 0
            r17 = 2138(0x85a, float:2.996E-42)
            r14 = r29
            r18 = r3
            com.meizu.savior.PatchProxyResult r3 = com.meizu.savior.PatchProxy.proxy(r13, r14, r15, r16, r17, r18, r19)
            boolean r4 = r3.isSupported
            if (r4 == 0) goto L_0x00d4
            java.lang.Object r0 = r3.result
            android.net.Uri r0 = (android.net.Uri) r0
            return r0
        L_0x00d4:
            r13 = r29
            java.lang.String r14 = r13.mo18626a((boolean) r9, (java.lang.String) r2)
            if (r0 == 0) goto L_0x0143
            r15 = 0
            r3 = r36
            r4 = r38
            r5 = r15
            r6 = r39
            r7 = r40
            r8 = r35
            r9 = r41
            m7755a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x013a }
            if (r12 == 0) goto L_0x0108
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            r3.<init>()     // Catch:{ Exception -> 0x013a }
            java.lang.String r4 = "dual_camera"
            r3.append(r4)     // Catch:{ Exception -> 0x013a }
            if (r11 == 0) goto L_0x00fe
            java.lang.String r4 = "|deviceMarkOn"
            goto L_0x0100
        L_0x00fe:
            java.lang.String r4 = ""
        L_0x0100:
            r3.append(r4)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x013a }
            goto L_0x010a
        L_0x0108:
            java.lang.String r3 = "end"
        L_0x010a:
            int r4 = com.meizu.media.camera.p067d.ExifInterface.f9346ae     // Catch:{ Exception -> 0x013a }
            com.meizu.media.camera.d.h r4 = r0.mo19845a((int) r4, (java.lang.Object) r3)     // Catch:{ Exception -> 0x013a }
            r0.mo19846a((com.meizu.media.camera.p067d.ExifTag) r4)     // Catch:{ Exception -> 0x013a }
            com.meizu.media.camera.util.ac$a r4 = f7389d     // Catch:{ Exception -> 0x013a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            r5.<init>()     // Catch:{ Exception -> 0x013a }
            java.lang.String r6 = "updateImage TAG_USER_COMMENT:"
            r5.append(r6)     // Catch:{ Exception -> 0x013a }
            r5.append(r3)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = ", path:"
            r5.append(r3)     // Catch:{ Exception -> 0x013a }
            r5.append(r14)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x013a }
            com.meizu.media.camera.util.LogUtil.m15952c(r4, r3)     // Catch:{ Exception -> 0x013a }
            r0.mo19856a((byte[]) r10, (java.lang.String) r14)     // Catch:{ Exception -> 0x013a }
            if (r1 == 0) goto L_0x014b
            com.meizu.media.camera.util.XmpUtilHelper.m16123a((java.lang.String) r14, (com.meizu.media.camera.p064a.XmpMetaData) r1)     // Catch:{ Exception -> 0x013a }
            goto L_0x014b
        L_0x013a:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r1 = f7389d
            java.lang.String r3 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r1, r3, r0)
            goto L_0x014b
        L_0x0143:
            m7757a((java.lang.String) r14, (byte[]) r10)
            if (r1 == 0) goto L_0x014b
            com.meizu.media.camera.util.XmpUtilHelper.m16123a((java.lang.String) r14, (com.meizu.media.camera.p064a.XmpMetaData) r1)
        L_0x014b:
            int r7 = r10.length
            r1 = r30
            r2 = r31
            r3 = r32
            r5 = r34
            r6 = r35
            r8 = r14
            r9 = r39
            r10 = r40
            android.net.Uri r0 = m7748a((android.content.ContentResolver) r1, (java.lang.String) r2, (long) r3, (android.location.Location) r5, (int) r6, (int) r7, (java.lang.String) r8, (int) r9, (int) r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.mo18614a(android.content.ContentResolver, java.lang.String, long, android.location.Location, int, com.meizu.media.camera.d.c, com.meizu.media.camera.a.g, byte[], int, int, boolean, boolean, boolean, boolean):android.net.Uri");
    }

    /* renamed from: a */
    public static Uri m7748a(ContentResolver contentResolver, String str, long j, Location location, int i, int i2, String str2, int i3, int i4) {
        Uri uri;
        Uri uri2;
        ContentResolver contentResolver2 = contentResolver;
        String str3 = str;
        long j2 = j;
        String str4 = str2;
        int i5 = i3;
        int i6 = i4;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{contentResolver2, str3, new Long(j2), location, new Integer(i), new Integer(i2), str4, new Integer(i5), new Integer(i6)}, (Object) null, f7386a, true, 2139, new Class[]{ContentResolver.class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        LogUtil.m15942a(f7389d, "mediastore updateimage date is : " + j2);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(new File(str4).lastModified());
        ContentValues contentValues = new ContentValues(9);
        contentValues.put(PushConstants.TITLE, str3);
        contentValues.put("_display_name", str3 + ".jpg");
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(seconds));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(i));
        contentValues.put("_data", str4);
        contentValues.put("_size", Long.valueOf(new File(str4).length()));
        m7754a(contentValues, i5, i6);
        if (location != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
        }
        long o = m7750a().mo18671o(str4);
        LogUtil.m15942a(f7389d, " getUriId path:" + str4 + "uriId:" + o);
        if (o != -1) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(String.valueOf(o)).build();
        } else {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            LogUtil.m15942a(f7389d, " no uriId");
        }
        String[] strArr = {str4};
        try {
            int update = contentResolver2.update(uri, contentValues, "_data=?", strArr);
            LogUtil.m15952c(f7389d, "updated count:" + update + " where:" + "_data=?" + "  selectionArgs:" + str4 + " uri:" + uri);
            if (update != 0) {
                LogUtil.m15952c(f7389d, "start query uri");
                Cursor query = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", strArr, (String) null);
                if (query == null || !query.moveToFirst()) {
                    uri2 = null;
                } else {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(String.valueOf(query.getInt(query.getColumnIndex("_id")))).build();
                    try {
                        query.close();
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } else {
                LogUtil.m15952c(f7389d, "start insert");
                uri2 = contentResolver2.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
        } catch (Throwable th2) {
            th = th2;
            uri2 = null;
            LogUtil.m15949b(f7389d, "Failed to write MediaStore" + th);
            LogUtil.m15952c(f7389d, "updateImage path : " + str4);
            LogUtil.m15952c(f7389d, "updateImage uri : " + uri2);
            return uri2;
        }
        LogUtil.m15952c(f7389d, "updateImage path : " + str4);
        LogUtil.m15952c(f7389d, "updateImage uri : " + uri2);
        return uri2;
    }

    /* renamed from: b */
    public Uri mo18636b() {
        return f7393n;
    }

    /* renamed from: c */
    public void mo18646c() {
        f7393n = null;
    }

    /* renamed from: a */
    public static Uri m7749a(ContentResolver contentResolver, String str, long j, Location location, int i, int i2, String str2, int i3, int i4, boolean... zArr) {
        Uri uri;
        ContentResolver contentResolver2 = contentResolver;
        String str3 = str;
        String str4 = str2;
        int i5 = i3;
        int i6 = i4;
        boolean[] zArr2 = zArr;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{contentResolver2, str3, new Long(j), location, new Integer(i), new Integer(i2), str4, new Integer(i5), new Integer(i6), zArr2}, (Object) null, f7386a, true, 2140, new Class[]{ContentResolver.class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, boolean[].class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(new File(str4).lastModified());
        ContentValues contentValues = new ContentValues(9);
        contentValues.put(PushConstants.TITLE, str3);
        contentValues.put("_display_name", str3 + ".jpg");
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(seconds));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(i));
        contentValues.put("_data", str4);
        m7754a(contentValues, i5, i6);
        if (location != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
        }
        try {
            uri = contentResolver2.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Throwable th) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15949b(aVar, "Failed to write MediaStore" + th);
            uri = null;
        }
        if (zArr2 == null || zArr2.length < 1) {
            LogUtil.m15952c(f7389d, "no need to set dualCamUri");
        } else if (zArr2[0]) {
            f7393n = uri;
        }
        LogUtil.C2630a aVar2 = f7389d;
        LogUtil.m15952c(aVar2, "addImage path : " + str4);
        LogUtil.C2630a aVar3 = f7389d;
        LogUtil.m15952c(aVar3, "addImage uri : " + uri);
        return uri;
    }

    /* renamed from: a */
    public ContentValues mo18609a(long j, String str, String str2, int i, int i2, int i3, int i4, Location location) {
        String str3 = str;
        String str4 = str2;
        Object[] objArr = {new Long(j), str3, str4, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4), location};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2142, new Class[]{Long.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Location.class}, ContentValues.class);
        if (proxy.isSupported) {
            return (ContentValues) proxy.result;
        }
        String a = mo18623a(str4, str3);
        ContentValues contentValues = new ContentValues(11);
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("_data", a);
        contentValues.put(PushConstants.TITLE, str4);
        contentValues.put("_display_name", str4 + ".jpg");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(i));
        contentValues.put("width", Integer.valueOf(i3));
        contentValues.put("height", Integer.valueOf(i4));
        if (location != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
        }
        return contentValues;
    }

    /* renamed from: b */
    public ContentValues mo18635b(long j, String str, String str2, int i, int i2, int i3, int i4, Location location) {
        String str3 = str;
        String str4 = str2;
        Object[] objArr = {new Long(j), str3, str4, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4), location};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2143, new Class[]{Long.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Location.class}, ContentValues.class);
        if (proxy.isSupported) {
            return (ContentValues) proxy.result;
        }
        String b = mo18639b(str4, str3);
        ContentValues contentValues = new ContentValues(11);
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("_data", b);
        contentValues.put(PushConstants.TITLE, str4);
        contentValues.put("_display_name", str4 + ".jpg");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(i));
        contentValues.put("width", Integer.valueOf(i3));
        contentValues.put("height", Integer.valueOf(i4));
        if (location != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
        }
        return contentValues;
    }

    /* renamed from: a */
    public Uri mo18618a(ContentResolver contentResolver, ArrayList<ContentValues> arrayList) {
        Uri uri;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{contentResolver, arrayList}, this, f7386a, false, 2144, new Class[]{ContentResolver.class, ArrayList.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        for (int i = 0; i <= size - 1; i++) {
            contentValuesArr[i] = arrayList.get(i);
        }
        try {
            LogUtil.m15952c(f7389d, "insertBurstImage start");
            uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayList.get(0));
            try {
                contentResolver.bulkInsert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValuesArr);
                LogUtil.m15952c(f7389d, "insertBurstImage end");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            uri = null;
            LogUtil.m15949b(f7389d, "Failed to update burst image" + th);
            LogUtil.m15952c(f7389d, "insertBurstImage uri : " + uri);
            return uri;
        }
        LogUtil.m15952c(f7389d, "insertBurstImage uri : " + uri);
        return uri;
    }

    /* renamed from: a */
    public Uri mo18612a(ContentResolver contentResolver, long j, String str, String str2, int i, int i2, int i3, int i4, Location location) {
        Uri uri;
        ContentResolver contentResolver2 = contentResolver;
        String str3 = str;
        String str4 = str2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{contentResolver2, new Long(j), str3, str4, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4), location}, this, f7386a, false, 2145, new Class[]{ContentResolver.class, Long.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Location.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        String a = mo18624a(str4, str3, false);
        ContentValues contentValues = new ContentValues(11);
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("_data", a);
        contentValues.put(PushConstants.TITLE, str4);
        contentValues.put("_display_name", str4 + ".jpg");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(i));
        contentValues.put("width", Integer.valueOf(i3));
        contentValues.put("height", Integer.valueOf(i4));
        if (location != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
        }
        try {
            uri = contentResolver2.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Throwable th) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15949b(aVar, "Failed to update burst image" + th);
            uri = null;
        }
        LogUtil.C2630a aVar2 = f7389d;
        LogUtil.m15952c(aVar2, "insertRefocusImage uri : " + uri);
        return uri;
    }

    /* renamed from: a */
    public Uri mo18611a(ContentResolver contentResolver, long j, String str, int i, long j2, int i2, int i3, Location location) {
        Uri uri;
        ContentResolver contentResolver2 = contentResolver;
        String str2 = str;
        Object[] objArr = {contentResolver2, new Long(j), str2, new Integer(i), new Long(j2), new Integer(i2), new Integer(i3), location};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2146, new Class[]{ContentResolver.class, Long.TYPE, String.class, Integer.TYPE, Long.TYPE, Integer.TYPE, Integer.TYPE, Location.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        String f = mo18654f(str2);
        ContentValues contentValues = new ContentValues(9);
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("_data", f);
        contentValues.put(PushConstants.TITLE, str2);
        contentValues.put("_display_name", str2 + ".jpg");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(i));
        contentValues.put("width", Integer.valueOf(i2));
        contentValues.put("height", Integer.valueOf(i3));
        if (location != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
        }
        LogUtil.m15952c(f7389d, "start insertPanoImage");
        try {
            uri = contentResolver2.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Throwable th) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15949b(aVar, "Failed to update panorama image" + th);
            uri = null;
        }
        LogUtil.C2630a aVar2 = f7389d;
        LogUtil.m15952c(aVar2, "insertPanoImage uri : " + uri);
        return uri;
    }

    /* renamed from: a */
    public Uri mo18610a(ContentResolver contentResolver, long j, String str, int i, int i2, int i3) {
        Uri uri;
        ContentResolver contentResolver2 = contentResolver;
        String str2 = str;
        Object[] objArr = {contentResolver2, new Long(j), str2, new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2147, new Class[]{ContentResolver.class, Long.TYPE, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        String e = mo18651e(str2);
        ContentValues contentValues = new ContentValues(9);
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("_data", e);
        contentValues.put(PushConstants.TITLE, str2);
        contentValues.put("_display_name", str2 + ".gif");
        contentValues.put("mime_type", "image/gif");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(i));
        contentValues.put("width", Integer.valueOf(i2));
        contentValues.put("height", Integer.valueOf(i3));
        try {
            uri = contentResolver2.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Throwable th) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15949b(aVar, "Failed to update gif image" + th);
            uri = null;
        }
        LogUtil.C2630a aVar2 = f7389d;
        LogUtil.m15952c(aVar2, "insertGifImage uri : " + uri);
        return uri;
    }

    /* renamed from: a */
    public static void m7753a(ContentResolver contentResolver, Uri uri) {
        Class[] clsArr = {ContentResolver.class, Uri.class};
        if (!PatchProxy.proxy(new Object[]{contentResolver, uri}, (Object) null, f7386a, true, 2148, clsArr, Void.TYPE).isSupported) {
            try {
                contentResolver.delete(uri, (String) null, (String[]) null);
            } catch (Throwable unused) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to delete image: " + uri);
            }
        }
    }

    /* renamed from: d */
    public String mo18647d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2149, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return new File(f7387b, Environment.DIRECTORY_DCIM).toString() + "/.Dual_camera";
    }

    /* renamed from: C */
    private String m7741C() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2150, new Class[0], String.class);
        return proxy.isSupported ? (String) proxy.result : new File(this.f7394e, Environment.DIRECTORY_DCIM).toString();
    }

    /* renamed from: e */
    public String mo18650e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2151, new Class[0], String.class);
        return proxy.isSupported ? (String) proxy.result : m7741C();
    }

    /* renamed from: f */
    public String mo18653f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2152, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Selfie";
    }

    /* renamed from: g */
    public String mo18655g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2153, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Burst";
    }

    /* renamed from: h */
    public String mo18657h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2154, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/BackTrace";
    }

    /* renamed from: i */
    public String mo18659i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2155, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Camera";
    }

    /* renamed from: j */
    public String mo18661j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2156, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Refocus";
    }

    /* renamed from: k */
    public String mo18663k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2157, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Mms";
    }

    /* renamed from: l */
    public String mo18665l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2158, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Video";
    }

    /* renamed from: m */
    public String mo18667m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2159, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/.Gif";
    }

    /* renamed from: n */
    public String mo18669n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2160, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/AR";
    }

    /* renamed from: o */
    public String mo18672o() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2162, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Panorama";
    }

    /* renamed from: p */
    public String mo18673p() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2163, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + "/Documents";
    }

    /* renamed from: c */
    public String mo18644c(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2164, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + '/' + str + ".jpg";
    }

    /* renamed from: d */
    public String mo18648d(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2168, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18653f() + '/' + str + ".jpg";
    }

    /* renamed from: e */
    public String mo18651e(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2170, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18650e() + '/' + str + ".gif";
    }

    /* renamed from: f */
    public String mo18654f(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2171, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18672o() + '/' + str + ".jpg";
    }

    /* renamed from: a */
    public String mo18625a(String str, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f7386a, false, 2172, new Class[]{String.class, Boolean.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (z) {
            return mo18669n() + '/' + str;
        }
        return mo18669n() + '/' + str + ".jpg";
    }

    /* renamed from: g */
    public String mo18656g(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2173, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18673p() + '/' + str + ".jpg";
    }

    /* renamed from: a */
    public String mo18622a(String str, long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Long(j)}, this, f7386a, false, 2174, new Class[]{String.class, Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18647d() + '/' + str + j;
    }

    /* renamed from: a */
    public String mo18623a(String str, String str2) {
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, this, changeQuickRedirect, false, 2175, new Class[]{String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (TextUtils.isEmpty(str2)) {
            return mo18655g() + "/" + str + ".jpg";
        }
        return mo18655g() + '/' + str2 + '/' + str + ".jpg";
    }

    /* renamed from: b */
    public String mo18639b(String str, String str2) {
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, this, changeQuickRedirect, false, 2176, new Class[]{String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (TextUtils.isEmpty(str2)) {
            return mo18657h() + "/" + str + ".jpg";
        }
        return mo18657h() + '/' + str2 + '/' + str + ".jpg";
    }

    /* renamed from: c */
    public String mo18645c(String str, String str2) {
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, this, changeQuickRedirect, false, 2177, new Class[]{String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (TextUtils.isEmpty(str2)) {
            return mo18657h() + "/." + str + ".jpg.tmp";
        }
        return mo18657h() + "/" + str2 + "/." + str + ".jpg.tmp";
    }

    /* renamed from: a */
    public String mo18624a(String str, String str2, boolean z) {
        Object[] objArr = {str, str2, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2178, new Class[]{String.class, String.class, Boolean.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (TextUtils.isEmpty(str2)) {
            return mo18661j() + '/' + str + ".jpg";
        } else if (z) {
            return mo18661j() + '/' + str2 + '/' + str;
        } else {
            return mo18661j() + '/' + str2 + '/' + str + ".jpg";
        }
    }

    /* renamed from: h */
    public String mo18658h(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2179, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18663k() + '/' + str;
    }

    /* renamed from: i */
    public String mo18660i(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2180, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mo18665l() + '/' + str;
    }

    /* renamed from: q */
    public String mo18675q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2181, new Class[0], String.class);
        return proxy.isSupported ? (String) proxy.result : String.valueOf(mo18650e().toLowerCase().hashCode());
    }

    /* renamed from: a */
    public static String m7752a(boolean z, DIRECTION direction) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), direction}, (Object) null, f7386a, true, 2182, new Class[]{Boolean.TYPE, DIRECTION.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String file = new File(z ? f7388c : f7387b, Environment.DIRECTORY_DCIM).toString();
        switch (direction) {
            case BURST:
                return file + "/Burst";
            case BACKTRACE:
                return file + "/BackTrace";
            case DOCUMENTS:
                return file + "/Documents";
            case REFOCUS:
                return file + "/Refocus";
            case VIDEO:
                return file + "/Video";
            case SELFIE:
                return file + "/Selfie";
            case PANORAMA:
                return file + "/Panorama";
            case AR:
                return file + "/AR";
            default:
                return file;
        }
    }

    /* renamed from: a */
    public static String m7751a(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, (Object) null, f7386a, true, 2183, new Class[]{Boolean.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : String.valueOf(m7752a(z, DIRECTION.DEFAUTL).toLowerCase(Locale.ENGLISH).hashCode());
    }

    /* renamed from: b */
    public static String m7758b(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, (Object) null, f7386a, true, 2184, new Class[]{Boolean.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : String.valueOf(m7752a(z, DIRECTION.VIDEO).toLowerCase(Locale.ENGLISH).hashCode());
    }

    /* renamed from: j */
    public String mo18662j(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2185, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return String.valueOf((mo18657h() + '/' + str).toLowerCase(Locale.ENGLISH).hashCode());
    }

    /* renamed from: k */
    public String mo18664k(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2186, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return String.valueOf((mo18655g() + '/' + str).toLowerCase(Locale.ENGLISH).hashCode());
    }

    /* renamed from: c */
    public static String m7759c(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, (Object) null, f7386a, true, 2187, new Class[]{Boolean.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : String.valueOf(m7752a(z, DIRECTION.AR).toLowerCase(Locale.ENGLISH).hashCode());
    }

    /* renamed from: a */
    public String mo18620a(Context context, long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, new Long(j)}, this, f7386a, false, 2188, new Class[]{Context.class, Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String format = new SimpleDateFormat(context.getString(R.string.video_file_name_format)).format(new Date(j));
        if (TextUtils.isEmpty(format) || format.indexOf(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED) < 0) {
            return format;
        }
        String substring = format.substring(0, 1);
        String substring2 = format.substring(4, format.length());
        return substring + substring2;
    }

    /* renamed from: l */
    public boolean mo18666l(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2189, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return new File(mo18655g() + '/' + str).mkdirs();
    }

    /* renamed from: m */
    public boolean mo18668m(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2190, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return new File(mo18657h() + '/' + str).mkdirs();
    }

    /* renamed from: r */
    public void mo18676r() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2191, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18661j());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create " + file.getPath());
            }
        }
    }

    /* renamed from: n */
    public boolean mo18670n(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2192, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return new File(mo18661j() + '/' + str).mkdirs();
    }

    /* renamed from: D */
    private void m7742D() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2193, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18647d());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create dualCamera folder " + file.getPath());
            }
        }
    }

    /* renamed from: E */
    private void m7743E() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2194, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18655g());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create " + file.getPath());
            }
        }
    }

    /* renamed from: F */
    private void m7744F() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2197, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18653f());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create mirror folder " + file.getPath());
            }
        }
    }

    /* renamed from: G */
    private void m7745G() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2198, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18672o());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create pano folder " + file.getPath());
            }
        }
    }

    /* renamed from: H */
    private void m7746H() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2199, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18657h());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create backtrace folder " + file.getPath());
            }
        }
    }

    /* renamed from: s */
    public void mo18677s() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2200, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18659i());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create GTS test folder " + file.getPath());
            }
        }
    }

    /* renamed from: I */
    private void m7747I() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2201, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18673p());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create document folder " + file.getPath());
            }
        }
    }

    /* renamed from: t */
    public long mo18678t() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, PushConstants.DELAY_NOTIFICATION, new Class[0], Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        String externalStorageState = Environment.getExternalStorageState();
        LogUtil.C2630a aVar = f7389d;
        LogUtil.m15942a(aVar, "External storage state=" + externalStorageState);
        if ("checking".equals(externalStorageState)) {
            return -2;
        }
        if (!"mounted".equals(externalStorageState)) {
            return -1;
        }
        File file = new File(mo18650e());
        file.mkdirs();
        if (!file.isDirectory() || !file.canWrite()) {
            return -4;
        }
        m7743E();
        m7744F();
        m7745G();
        if (DeviceHelper.f13856aI) {
            m7742D();
        }
        m7746H();
        m7747I();
        try {
            StatFs statFs = new StatFs(mo18650e());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            LogUtil.m15953c(f7389d, "Fail to access external storage", e);
            return -3;
        }
    }

    /* renamed from: u */
    public void mo18679u() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2203, new Class[0], Void.TYPE).isSupported) {
            String externalStorageState = Environment.getExternalStorageState();
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15942a(aVar, "External storage state=" + externalStorageState);
            if (!"checking".equals(externalStorageState) && "mounted".equals(externalStorageState)) {
                File file = new File(mo18650e());
                file.mkdirs();
                if (file.isDirectory() && file.canWrite()) {
                    m7743E();
                    m7744F();
                    m7745G();
                    m7746H();
                    m7747I();
                    if (DeviceHelper.f13856aI) {
                        m7742D();
                    }
                }
            }
        }
    }

    /* renamed from: v */
    public void mo18680v() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2204, new Class[0], Void.TYPE).isSupported) {
            File file = new File(mo18663k());
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create " + file.getPath());
            }
            if (!file.isDirectory() || !file.canWrite()) {
                LogUtil.m15949b(f7389d, "Directory is not available !!!");
            }
        }
    }

    /* renamed from: w */
    public void mo18681w() {
        if (!PatchProxy.proxy(new Object[0], this, f7386a, false, 2205, new Class[0], Void.TYPE).isSupported) {
            File file = new File(m7741C(), "100ANDRO");
            if (!file.exists() && !file.mkdirs()) {
                LogUtil.C2630a aVar = f7389d;
                LogUtil.m15949b(aVar, "Failed to create " + file.getPath());
            }
        }
    }

    /* renamed from: x */
    public boolean mo18682x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7386a, false, 2206, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f7394e.equals(f7388c);
    }

    /* renamed from: y */
    public String mo18683y() {
        return this.f7394e;
    }

    /* renamed from: a */
    public String mo18621a(Context context, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, this, f7386a, false, 2207, new Class[]{Context.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        File[] listFiles = new File(context.getFilesDir().getAbsolutePath() + File.separator + f7390f).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file = listFiles[i];
            String substring = file.getName().substring(0, file.getName().lastIndexOf("."));
            String substring2 = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            if (!str.equals(substring) || !"zip".equals(substring2)) {
                i++;
            } else if (file.exists()) {
                return file.getAbsolutePath();
            } else {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public String mo18638b(Context context, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, this, f7386a, false, 2208, new Class[]{Context.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        File[] listFiles = new File(context.getFilesDir().getAbsolutePath() + File.separator + f7390f).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file = listFiles[i];
            String substring = file.getName().substring(0, file.getName().lastIndexOf("."));
            String substring2 = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            if (!str.equals(substring) || "zip".equals(substring2)) {
                i++;
            } else if (file.exists()) {
                return file.getAbsolutePath();
            } else {
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public String mo18643c(Context context, String str) {
        File[] listFiles;
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, this, changeQuickRedirect, false, 2209, new Class[]{Context.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + f7391g + File.separator + str);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return null;
        }
        return file.getAbsolutePath();
    }

    /* renamed from: a */
    public String mo18619a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, this, f7386a, false, 2210, new Class[]{Context.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + f7391g;
    }

    /* renamed from: b */
    public String mo18637b(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, this, f7386a, false, 2211, new Class[]{Context.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + f7390f;
    }

    /* renamed from: c */
    public String mo18642c(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, this, f7386a, false, 2212, new Class[]{Context.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "ARLib";
    }

    /* renamed from: b */
    public synchronized void mo18641b(String str, long j) {
        if (!PatchProxy.proxy(new Object[]{str, new Long(j)}, this, f7386a, false, 2213, new Class[]{String.class, Long.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15942a(aVar, " addUriId path:" + str + "uriid" + j);
            this.f7395i.put(str, Long.valueOf(j));
        }
    }

    /* renamed from: o */
    public synchronized long mo18671o(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2214, new Class[]{String.class}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        Long l = this.f7395i.get(str);
        if (l == null) {
            return -1;
        }
        return l.longValue();
    }

    /* renamed from: p */
    public synchronized void mo18674p(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f7386a, false, 2215, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15942a(aVar, " remove path:" + str);
            this.f7395i.remove(str);
        }
    }

    /* renamed from: z */
    public synchronized boolean mo18684z() {
        return this.f7396j;
    }

    /* renamed from: d */
    public synchronized void mo18649d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2217, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15942a(aVar, " setWriteExifStatus:" + z);
            this.f7396j = z;
        }
    }

    /* renamed from: A */
    public synchronized boolean mo18607A() {
        return this.f7397k;
    }

    /* renamed from: e */
    public synchronized void mo18652e(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2218, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15942a(aVar, " setThumbnailMode:" + z);
            this.f7397k = z;
        }
    }

    /* renamed from: a */
    public synchronized void mo18628a(long j, CameraController.C1880f[] fVarArr) {
        Object[] objArr = {new Long(j), fVarArr};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2219, new Class[]{Long.TYPE, CameraController.C1880f[].class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7389d;
            LogUtil.m15942a(aVar, " saveFaceData date:" + j);
            this.f7398l.put(Long.valueOf(j), fVarArr);
        }
    }

    /* renamed from: a */
    public synchronized CameraController.C1880f[] mo18634a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f7386a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2220, new Class[]{Long.TYPE}, CameraController.C1880f[].class);
        if (proxy.isSupported) {
            return (CameraController.C1880f[]) proxy.result;
        }
        CameraController.C1880f[] fVarArr = this.f7398l.get(Long.valueOf(j));
        if (fVarArr == null) {
            return null;
        }
        this.f7398l.remove(Long.valueOf(j));
        return fVarArr;
    }

    /* renamed from: a */
    public void mo18629a(Rect rect) {
        this.f7399m = rect;
    }

    /* renamed from: B */
    public Rect mo18608B() {
        return this.f7399m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m7755a(com.meizu.media.camera.p067d.ExifInterface r18, byte[] r19, android.graphics.Bitmap r20, int r21, int r22, int r23, boolean r24) {
        /*
            r0 = r18
            r1 = r19
            r2 = r23
            r3 = r24
            r4 = 7
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r6 = 0
            r5[r6] = r0
            r7 = 1
            r5[r7] = r1
            r8 = 2
            r5[r8] = r20
            java.lang.Integer r9 = new java.lang.Integer
            r13 = r21
            r9.<init>(r13)
            r10 = 3
            r5[r10] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r14 = r22
            r9.<init>(r14)
            r11 = 4
            r5[r11] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r2)
            r15 = 5
            r5[r15] = r9
            java.lang.Byte r9 = new java.lang.Byte
            r9.<init>(r3)
            r16 = 6
            r5[r16] = r9
            com.meizu.savior.ChangeQuickRedirect r9 = f7386a
            java.lang.Class[] r4 = new java.lang.Class[r4]
            java.lang.Class<com.meizu.media.camera.d.c> r17 = com.meizu.media.camera.p067d.ExifInterface.class
            r4[r6] = r17
            java.lang.Class<byte[]> r6 = byte[].class
            r4[r7] = r6
            java.lang.Class<android.graphics.Bitmap> r6 = android.graphics.Bitmap.class
            r4[r8] = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            r4[r10] = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            r4[r11] = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            r4[r15] = r6
            java.lang.Class r6 = java.lang.Boolean.TYPE
            r4[r16] = r6
            java.lang.Class r11 = java.lang.Void.TYPE
            r6 = 0
            r8 = 1
            r10 = 2223(0x8af, float:3.115E-42)
            r7 = r9
            r9 = r10
            r10 = r4
            com.meizu.savior.PatchProxyResult r4 = com.meizu.savior.PatchProxy.proxy(r5, r6, r7, r8, r9, r10, r11)
            boolean r4 = r4.isSupported
            if (r4 == 0) goto L_0x006b
            return
        L_0x006b:
            boolean r4 = r18.mo19864b()
            if (r4 != 0) goto L_0x00bb
            int r4 = com.meizu.media.camera.util.CameraUtil.m15903i()
            float r4 = (float) r4
            if (r1 == 0) goto L_0x00b1
            int r5 = java.lang.Math.min(r21, r22)
            float r5 = (float) r5
            float r5 = r5 / r4
            int r5 = (int) r5
            int r5 = java.lang.Integer.highestOneBit(r5)
            android.graphics.Bitmap r6 = com.meizu.media.camera.util.CameraUtil.m15873b((byte[]) r1, (int) r5)
            if (r2 != 0) goto L_0x008e
            if (r3 == 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r1 = r6
            goto L_0x00af
        L_0x008e:
            android.graphics.Matrix r11 = new android.graphics.Matrix
            r11.<init>()
            float r1 = (float) r2
            r11.preRotate(r1)
            if (r3 == 0) goto L_0x00a0
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = 1065353216(0x3f800000, float:1.0)
            r11.setScale(r1, r2)
        L_0x00a0:
            r7 = 0
            r8 = 0
            int r9 = r6.getWidth()
            int r10 = r6.getHeight()
            r12 = 0
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)
        L_0x00af:
            r12 = r1
            goto L_0x00b3
        L_0x00b1:
            r12 = r20
        L_0x00b3:
            int r1 = (int) r4
            android.graphics.Bitmap r1 = android.media.ThumbnailUtils.extractThumbnail(r12, r1, r1)
            r0.mo19860a((android.graphics.Bitmap) r1)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Storage.m7755a(com.meizu.media.camera.d.c, byte[], android.graphics.Bitmap, int, int, int, boolean):void");
    }
}
