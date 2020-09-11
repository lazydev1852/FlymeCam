package com.meizu.media.camera.p068e;

import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.e.c */
public final class FBStorage {

    /* renamed from: a */
    public static ChangeQuickRedirect f9921a;

    /* renamed from: b */
    private static FBStorage f9922b;

    /* renamed from: c */
    private static final LogUtil.C2630a f9923c = new LogUtil.C2630a("FBStorage");

    private FBStorage() {
    }

    /* renamed from: a */
    public static FBStorage m10036a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f9921a, true, 4040, new Class[0], FBStorage.class);
        if (proxy.isSupported) {
            return (FBStorage) proxy.result;
        }
        if (f9922b == null) {
            f9922b = new FBStorage();
        }
        return f9922b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x013c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri mo20007a(android.content.ContentResolver r23, java.lang.String r24, long r25, android.location.Location r27, int r28, com.meizu.media.camera.p067d.ExifInterface r29, byte[] r30, int r31, int r32, boolean r33, com.meizu.media.camera.p064a.XmpMetaData r34) {
        /*
            r22 = this;
            r2 = r24
            r0 = r29
            r1 = r30
            r9 = r31
            r10 = r32
            r3 = r33
            r4 = r34
            r5 = 11
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r6 = 0
            r11[r6] = r23
            r8 = 1
            r11[r8] = r2
            java.lang.Long r12 = new java.lang.Long
            r14 = r25
            r12.<init>(r14)
            r13 = 2
            r11[r13] = r12
            r12 = 3
            r11[r12] = r27
            java.lang.Integer r12 = new java.lang.Integer
            r15 = r28
            r12.<init>(r15)
            r14 = 4
            r11[r14] = r12
            r12 = 5
            r11[r12] = r0
            r16 = 6
            r11[r16] = r1
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r9)
            r17 = 7
            r11[r17] = r12
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r10)
            r18 = 8
            r11[r18] = r12
            java.lang.Byte r12 = new java.lang.Byte
            r12.<init>(r3)
            r19 = 9
            r11[r19] = r12
            r12 = 10
            r11[r12] = r4
            com.meizu.savior.ChangeQuickRedirect r20 = f9921a
            java.lang.Class[] r5 = new java.lang.Class[r5]
            java.lang.Class<android.content.ContentResolver> r21 = android.content.ContentResolver.class
            r5[r6] = r21
            java.lang.Class<java.lang.String> r21 = java.lang.String.class
            r5[r8] = r21
            java.lang.Class r8 = java.lang.Long.TYPE
            r5[r13] = r8
            java.lang.Class<android.location.Location> r8 = android.location.Location.class
            r13 = 3
            r5[r13] = r8
            java.lang.Class r8 = java.lang.Integer.TYPE
            r5[r14] = r8
            java.lang.Class<com.meizu.media.camera.d.c> r8 = com.meizu.media.camera.p067d.ExifInterface.class
            r13 = 5
            r5[r13] = r8
            java.lang.Class<byte[]> r8 = byte[].class
            r5[r16] = r8
            java.lang.Class r8 = java.lang.Integer.TYPE
            r5[r17] = r8
            java.lang.Class r8 = java.lang.Integer.TYPE
            r5[r18] = r8
            java.lang.Class r8 = java.lang.Boolean.TYPE
            r5[r19] = r8
            java.lang.Class<com.meizu.media.camera.a.g> r8 = com.meizu.media.camera.p064a.XmpMetaData.class
            r5[r12] = r8
            java.lang.Class<android.net.Uri> r17 = android.net.Uri.class
            r14 = 0
            r8 = 4041(0xfc9, float:5.663E-42)
            r12 = r22
            r13 = r20
            r15 = r8
            r16 = r5
            com.meizu.savior.PatchProxyResult r5 = com.meizu.savior.PatchProxy.proxy(r11, r12, r13, r14, r15, r16, r17)
            boolean r8 = r5.isSupported
            if (r8 == 0) goto L_0x00a0
            java.lang.Object r0 = r5.result
            android.net.Uri r0 = (android.net.Uri) r0
            return r0
        L_0x00a0:
            com.meizu.media.camera.util.ac$a r5 = f9923c
            java.lang.String r8 = "addImage"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r8)
            com.meizu.media.camera.Storage r5 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r8 = r5.mo18626a((boolean) r3, (java.lang.String) r2)
            com.meizu.media.camera.Storage r5 = com.meizu.media.camera.Storage.m7750a()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r2)
            java.lang.String r12 = "_temp"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.String r3 = r5.mo18626a((boolean) r3, (java.lang.String) r11)
            if (r0 == 0) goto L_0x012b
            com.meizu.media.camera.util.ac$a r5 = f9923c     // Catch:{ Exception -> 0x0120 }
            java.lang.String r11 = "writeFile"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x0120 }
            int r5 = com.meizu.media.camera.p068e.AlorgrithmManager.m10026b(r3, r1, r9, r10)     // Catch:{ Exception -> 0x0120 }
            if (r5 == 0) goto L_0x00e5
            com.meizu.media.camera.util.ac$a r5 = f9923c     // Catch:{ Exception -> 0x0120 }
            java.lang.String r11 = "not support libjpeg"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x0120 }
            android.graphics.Bitmap r5 = com.meizu.media.camera.p068e.AlorgrithmManager.m10017a((byte[]) r30)     // Catch:{ Exception -> 0x0120 }
            com.meizu.media.camera.p068e.AlorgrithmManager.m10020a((java.lang.String) r3, (android.graphics.Bitmap) r5)     // Catch:{ Exception -> 0x0120 }
        L_0x00e5:
            com.meizu.media.camera.util.ac$a r5 = f9923c     // Catch:{ Exception -> 0x0120 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            r11.<init>()     // Catch:{ Exception -> 0x0120 }
            java.lang.String r12 = " beforeWriteExif:"
            r11.append(r12)     // Catch:{ Exception -> 0x0120 }
            r11.append(r8)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0120 }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x0120 }
            r12 = r22
            r12.mo20009a(r3, r8, r0)     // Catch:{ Exception -> 0x011e }
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()     // Catch:{ Exception -> 0x011e }
            r0.mo18649d((boolean) r6)     // Catch:{ Exception -> 0x011e }
            com.meizu.media.camera.util.ac$a r0 = f9923c     // Catch:{ Exception -> 0x011e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011e }
            r3.<init>()     // Catch:{ Exception -> 0x011e }
            java.lang.String r5 = " afterWriteExif:"
            r3.append(r5)     // Catch:{ Exception -> 0x011e }
            r3.append(r8)     // Catch:{ Exception -> 0x011e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x011e }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x011e }
            goto L_0x013a
        L_0x011e:
            r0 = move-exception
            goto L_0x0123
        L_0x0120:
            r0 = move-exception
            r12 = r22
        L_0x0123:
            com.meizu.media.camera.util.ac$a r3 = f9923c
            java.lang.String r5 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r3, r5, r0)
            goto L_0x013a
        L_0x012b:
            r12 = r22
            com.meizu.media.camera.util.ac$a r0 = f9923c
            java.lang.String r3 = "writeFile"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r3)
            com.meizu.media.camera.Storage.m7750a()
            com.meizu.media.camera.Storage.m7757a((java.lang.String) r8, (byte[]) r1)
        L_0x013a:
            if (r4 == 0) goto L_0x013f
            com.meizu.media.camera.util.XmpUtilHelper.m16123a((java.lang.String) r8, (com.meizu.media.camera.p064a.XmpMetaData) r4)
        L_0x013f:
            com.meizu.media.camera.Storage.m7750a()
            int r0 = r1.length
            boolean[] r11 = new boolean[r6]
            r1 = r23
            r2 = r24
            r3 = r25
            r5 = r27
            r6 = r28
            r7 = r0
            r9 = r31
            r10 = r32
            android.net.Uri r0 = com.meizu.media.camera.Storage.m7749a(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p068e.FBStorage.mo20007a(android.content.ContentResolver, java.lang.String, long, android.location.Location, int, com.meizu.media.camera.d.c, byte[], int, int, boolean, com.meizu.media.camera.a.g):android.net.Uri");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri mo20008a(android.content.ContentResolver r22, java.lang.String r23, long r24, android.location.Location r26, int r27, com.meizu.media.camera.p067d.ExifInterface r28, byte[] r29, int r30, int r31, boolean r32, boolean r33, boolean r34, boolean r35) {
        /*
            r21 = this;
            r2 = r23
            r0 = r28
            r1 = r29
            r9 = r30
            r10 = r31
            r3 = r32
            r4 = 13
            java.lang.Object[] r11 = new java.lang.Object[r4]
            r5 = 0
            r11[r5] = r22
            r7 = 1
            r11[r7] = r2
            java.lang.Long r8 = new java.lang.Long
            r14 = r24
            r8.<init>(r14)
            r12 = 2
            r11[r12] = r8
            r8 = 3
            r11[r8] = r26
            java.lang.Integer r13 = new java.lang.Integer
            r15 = r27
            r13.<init>(r15)
            r14 = 4
            r11[r14] = r13
            r13 = 5
            r11[r13] = r0
            r16 = 6
            r11[r16] = r1
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r9)
            r17 = 7
            r11[r17] = r13
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r10)
            r18 = 8
            r11[r18] = r13
            java.lang.Byte r13 = new java.lang.Byte
            r13.<init>(r3)
            r19 = 9
            r11[r19] = r13
            java.lang.Byte r13 = new java.lang.Byte
            r14 = r33
            r13.<init>(r14)
            r14 = 10
            r11[r14] = r13
            java.lang.Byte r13 = new java.lang.Byte
            r14 = r34
            r13.<init>(r14)
            r14 = 11
            r11[r14] = r13
            java.lang.Byte r13 = new java.lang.Byte
            r14 = r35
            r13.<init>(r14)
            r14 = 12
            r11[r14] = r13
            com.meizu.savior.ChangeQuickRedirect r13 = f9921a
            java.lang.Class[] r4 = new java.lang.Class[r4]
            java.lang.Class<android.content.ContentResolver> r20 = android.content.ContentResolver.class
            r4[r5] = r20
            java.lang.Class<java.lang.String> r20 = java.lang.String.class
            r4[r7] = r20
            java.lang.Class r7 = java.lang.Long.TYPE
            r4[r12] = r7
            java.lang.Class<android.location.Location> r7 = android.location.Location.class
            r4[r8] = r7
            java.lang.Class r7 = java.lang.Integer.TYPE
            r8 = 4
            r4[r8] = r7
            java.lang.Class<com.meizu.media.camera.d.c> r7 = com.meizu.media.camera.p067d.ExifInterface.class
            r8 = 5
            r4[r8] = r7
            java.lang.Class<byte[]> r7 = byte[].class
            r4[r16] = r7
            java.lang.Class r7 = java.lang.Integer.TYPE
            r4[r17] = r7
            java.lang.Class r7 = java.lang.Integer.TYPE
            r4[r18] = r7
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4[r19] = r7
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r8 = 10
            r4[r8] = r7
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r8 = 11
            r4[r8] = r7
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4[r14] = r7
            java.lang.Class<android.net.Uri> r17 = android.net.Uri.class
            r14 = 0
            r7 = 4042(0xfca, float:5.664E-42)
            r12 = r21
            r15 = r7
            r16 = r4
            com.meizu.savior.PatchProxyResult r4 = com.meizu.savior.PatchProxy.proxy(r11, r12, r13, r14, r15, r16, r17)
            boolean r7 = r4.isSupported
            if (r7 == 0) goto L_0x00c5
            java.lang.Object r0 = r4.result
            android.net.Uri r0 = (android.net.Uri) r0
            return r0
        L_0x00c5:
            com.meizu.media.camera.Storage r4 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r8 = r4.mo18626a((boolean) r3, (java.lang.String) r2)
            com.meizu.media.camera.Storage r4 = com.meizu.media.camera.Storage.m7750a()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r2)
            java.lang.String r11 = "_temp"
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            java.lang.String r3 = r4.mo18626a((boolean) r3, (java.lang.String) r7)
            if (r0 == 0) goto L_0x0151
            int r4 = com.meizu.media.camera.p068e.AlorgrithmManager.m10026b(r3, r1, r9, r10)     // Catch:{ Exception -> 0x0146 }
            if (r4 == 0) goto L_0x00fc
            com.meizu.media.camera.util.ac$a r4 = f9923c     // Catch:{ Exception -> 0x0146 }
            java.lang.String r7 = "not support libjpeg"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x0146 }
            android.graphics.Bitmap r4 = com.meizu.media.camera.p068e.AlorgrithmManager.m10017a((byte[]) r29)     // Catch:{ Exception -> 0x0146 }
            com.meizu.media.camera.p068e.AlorgrithmManager.m10020a((java.lang.String) r3, (android.graphics.Bitmap) r4)     // Catch:{ Exception -> 0x0146 }
        L_0x00fc:
            com.meizu.media.camera.util.ac$a r4 = f9923c     // Catch:{ Exception -> 0x0146 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0146 }
            r7.<init>()     // Catch:{ Exception -> 0x0146 }
            java.lang.String r11 = " beforeWriteExif:"
            r7.append(r11)     // Catch:{ Exception -> 0x0146 }
            r7.append(r8)     // Catch:{ Exception -> 0x0146 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0146 }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x0146 }
            r11 = r21
            r11.mo20009a(r3, r8, r0)     // Catch:{ Exception -> 0x0144 }
            androidx.exifinterface.media.ExifInterface r0 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x0144 }
            r0.<init>((java.lang.String) r8)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r3 = "UserComment"
            java.lang.String r4 = "end"
            r0.setAttribute(r3, r4)     // Catch:{ Exception -> 0x0144 }
            r0.saveAttributes()     // Catch:{ Exception -> 0x0144 }
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()     // Catch:{ Exception -> 0x0144 }
            r0.mo18649d((boolean) r5)     // Catch:{ Exception -> 0x0144 }
            com.meizu.media.camera.util.ac$a r0 = f9923c     // Catch:{ Exception -> 0x0144 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0144 }
            r3.<init>()     // Catch:{ Exception -> 0x0144 }
            java.lang.String r4 = " afterWriteExif:"
            r3.append(r4)     // Catch:{ Exception -> 0x0144 }
            r3.append(r8)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0144 }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0144 }
            goto L_0x0159
        L_0x0144:
            r0 = move-exception
            goto L_0x0149
        L_0x0146:
            r0 = move-exception
            r11 = r21
        L_0x0149:
            com.meizu.media.camera.util.ac$a r3 = f9923c
            java.lang.String r4 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r3, r4, r0)
            goto L_0x0159
        L_0x0151:
            r11 = r21
            com.meizu.media.camera.Storage.m7750a()
            com.meizu.media.camera.Storage.m7757a((java.lang.String) r8, (byte[]) r1)
        L_0x0159:
            com.meizu.media.camera.Storage.m7750a()
            int r7 = r1.length
            r1 = r22
            r2 = r23
            r3 = r24
            r5 = r26
            r6 = r27
            r9 = r30
            r10 = r31
            android.net.Uri r0 = com.meizu.media.camera.Storage.m7748a((android.content.ContentResolver) r1, (java.lang.String) r2, (long) r3, (android.location.Location) r5, (int) r6, (int) r7, (java.lang.String) r8, (int) r9, (int) r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p068e.FBStorage.mo20008a(android.content.ContentResolver, java.lang.String, long, android.location.Location, int, com.meizu.media.camera.d.c, byte[], int, int, boolean, boolean, boolean, boolean):android.net.Uri");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009b A[SYNTHETIC, Splitter:B:34:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac A[SYNTHETIC, Splitter:B:40:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0102 A[SYNTHETIC, Splitter:B:57:0x0102] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x00a0=Splitter:B:37:0x00a0, B:31:0x008f=Splitter:B:31:0x008f} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20009a(java.lang.String r12, java.lang.String r13, com.meizu.media.camera.p067d.ExifInterface r14) {
        /*
            r11 = this;
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r12
            r9 = 1
            r1[r9] = r13
            r2 = 2
            r1[r2] = r14
            com.meizu.savior.ChangeQuickRedirect r3 = f9921a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r9] = r0
            java.lang.Class<com.meizu.media.camera.d.c> r0 = com.meizu.media.camera.p067d.ExifInterface.class
            r6[r2] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4043(0xfcb, float:5.665E-42)
            r2 = r11
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x002b
            return
        L_0x002b:
            com.meizu.media.camera.util.ac$a r0 = f9923c
            java.lang.String r1 = "writefinalExif"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0056 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x0056 }
            long r1 = r1.length()     // Catch:{ Exception -> 0x0056 }
            int r1 = (int) r1
            com.meizu.media.camera.util.ac$a r2 = f9923c     // Catch:{ Exception -> 0x0054 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0054 }
            r3.<init>()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r4 = "filesize:"
            r3.append(r4)     // Catch:{ Exception -> 0x0054 }
            r3.append(r1)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0054 }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0054 }
            goto L_0x0062
        L_0x0054:
            r2 = move-exception
            goto L_0x0058
        L_0x0056:
            r2 = move-exception
            r1 = 0
        L_0x0058:
            com.meizu.media.camera.util.ac$a r3 = f9923c
            java.lang.String r4 = "file not exist"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)
            r2.printStackTrace()
        L_0x0062:
            byte[] r1 = new byte[r1]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x009f, IOException -> 0x008e }
            r2.<init>(r12)     // Catch:{ FileNotFoundException -> 0x009f, IOException -> 0x008e }
            r2.read(r1)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0081, all -> 0x007d }
            r2.close()     // Catch:{ IOException -> 0x0071 }
            r8 = 1
            goto L_0x00af
        L_0x0071:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r2 = f9923c
            java.lang.String r3 = "file close fail"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            r0.printStackTrace()
            goto L_0x00af
        L_0x007d:
            r12 = move-exception
            r0 = r2
            goto L_0x0100
        L_0x0081:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
            goto L_0x008f
        L_0x0086:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
            goto L_0x00a0
        L_0x008b:
            r12 = move-exception
            goto L_0x0100
        L_0x008e:
            r2 = move-exception
        L_0x008f:
            com.meizu.media.camera.util.ac$a r3 = f9923c     // Catch:{ all -> 0x008b }
            java.lang.String r4 = "file read fail"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)     // Catch:{ all -> 0x008b }
            r2.printStackTrace()     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x00af
            r0.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x00af
        L_0x009f:
            r2 = move-exception
        L_0x00a0:
            com.meizu.media.camera.util.ac$a r3 = f9923c     // Catch:{ all -> 0x008b }
            java.lang.String r4 = "file not exist"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)     // Catch:{ all -> 0x008b }
            r2.printStackTrace()     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x00af
            r0.close()     // Catch:{ IOException -> 0x0071 }
        L_0x00af:
            com.meizu.media.camera.util.ac$a r0 = f9923c     // Catch:{ Exception -> 0x00ce }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ce }
            r2.<init>()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r3 = "delete tempfile:"
            r2.append(r3)     // Catch:{ Exception -> 0x00ce }
            r2.append(r12)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ce }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x00ce }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r12)     // Catch:{ Exception -> 0x00ce }
            r0.delete()     // Catch:{ Exception -> 0x00ce }
            goto L_0x00d9
        L_0x00ce:
            r12 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f9923c
            java.lang.String r2 = "file delete fail"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)
            r12.printStackTrace()
        L_0x00d9:
            if (r14 == 0) goto L_0x00f1
            com.meizu.media.camera.Storage r12 = com.meizu.media.camera.Storage.m7750a()
            r12.mo18649d((boolean) r9)
            if (r8 != r9) goto L_0x00f8
            r14.mo19856a((byte[]) r1, (java.lang.String) r13)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00f8
        L_0x00e8:
            r12 = move-exception
            com.meizu.media.camera.util.ac$a r13 = f9923c
            java.lang.String r14 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r13, r14, r12)
            goto L_0x00f8
        L_0x00f1:
            com.meizu.media.camera.util.ac$a r12 = f9923c
            java.lang.String r13 = "exif not found"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r13)
        L_0x00f8:
            com.meizu.media.camera.util.ac$a r12 = f9923c
            java.lang.String r13 = "writefinalExif end"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r13)
            return
        L_0x0100:
            if (r0 == 0) goto L_0x0111
            r0.close()     // Catch:{ IOException -> 0x0106 }
            goto L_0x0111
        L_0x0106:
            r13 = move-exception
            com.meizu.media.camera.util.ac$a r14 = f9923c
            java.lang.String r0 = "file close fail"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r14, (java.lang.String) r0)
            r13.printStackTrace()
        L_0x0111:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p068e.FBStorage.mo20009a(java.lang.String, java.lang.String, com.meizu.media.camera.d.c):void");
    }
}
