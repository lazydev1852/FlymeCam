package com.meizu.media.camera.util;

import com.mediatek.accessor.packer.PackUtils;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.p010b.SerializeOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.util.aw */
public class XmpUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14193a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14194b = new LogUtil.C2630a("XmpUtil");

    /* renamed from: com.meizu.media.camera.util.aw$a */
    /* compiled from: XmpUtil */
    private static class C2646a {

        /* renamed from: a */
        public int f14195a;

        /* renamed from: b */
        public int f14196b;

        /* renamed from: c */
        public byte[] f14197c;

        private C2646a() {
        }
    }

    /* renamed from: a */
    public static XMPMeta m16113a(InputStream inputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream}, (Object) null, f14193a, true, 8265, new Class[]{InputStream.class}, XMPMeta.class);
        if (proxy.isSupported) {
            return (XMPMeta) proxy.result;
        }
        List<C2646a> a = m16114a(inputStream, true);
        if (a == null) {
            return null;
        }
        for (C2646a next : a) {
            if (m16119a(next.f14197c)) {
                byte[] bArr = new byte[(m16120b(next.f14197c) - 29)];
                System.arraycopy(next.f14197c, 29, bArr, 0, bArr.length);
                try {
                    return XMPMetaFactory.m365a(bArr);
                } catch (XMPException e) {
                    LogUtil.m15943a(f14194b, "XMP parse error", (Throwable) e);
                    return null;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a A[SYNTHETIC, Splitter:B:32:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090 A[SYNTHETIC, Splitter:B:37:0x0090] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m16118a(java.lang.String r10, com.p006a.p007a.XMPMeta r11) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            r9 = 1
            r1[r9] = r11
            com.meizu.savior.ChangeQuickRedirect r3 = f14193a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0
            java.lang.Class<com.a.a.d> r0 = com.p006a.p007a.XMPMeta.class
            r6[r9] = r0
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r2 = 0
            r4 = 1
            r5 = 8266(0x204a, float:1.1583E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002c
            java.lang.Object r10 = r0.result
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            return r10
        L_0x002c:
            java.lang.String r0 = r10.toLowerCase()
            java.lang.String r1 = ".jpg"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L_0x004c
            java.lang.String r0 = r10.toLowerCase()
            java.lang.String r1 = ".jpeg"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L_0x004c
            com.meizu.media.camera.util.ac$a r10 = f14194b
            java.lang.String r11 = "XMP parse: only jpeg file is supported"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r11)
            return r8
        L_0x004c:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0094 }
            r0.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0094 }
            java.util.List r0 = m16114a((java.io.InputStream) r0, (boolean) r8)     // Catch:{ FileNotFoundException -> 0x0094 }
            java.util.List r11 = m16115a((java.util.List<com.meizu.media.camera.util.XmpUtil.C2646a>) r0, (com.p006a.p007a.XMPMeta) r11)     // Catch:{ FileNotFoundException -> 0x0094 }
            if (r11 != 0) goto L_0x005c
            return r8
        L_0x005c:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0071 }
            r1.<init>(r10)     // Catch:{ IOException -> 0x0071 }
            m16116a((java.io.OutputStream) r1, (java.util.List<com.meizu.media.camera.util.XmpUtil.C2646a>) r11)     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r1.close()     // Catch:{ IOException -> 0x0068 }
        L_0x0068:
            return r9
        L_0x0069:
            r10 = move-exception
            r0 = r1
            goto L_0x008e
        L_0x006c:
            r11 = move-exception
            r0 = r1
            goto L_0x0072
        L_0x006f:
            r10 = move-exception
            goto L_0x008e
        L_0x0071:
            r11 = move-exception
        L_0x0072:
            com.meizu.media.camera.util.ac$a r1 = f14194b     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r2.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "Write file failed:"
            r2.append(r3)     // Catch:{ all -> 0x006f }
            r2.append(r10)     // Catch:{ all -> 0x006f }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x006f }
            com.meizu.media.camera.util.LogUtil.m15943a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r10, (java.lang.Throwable) r11)     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x008d
            r0.close()     // Catch:{ IOException -> 0x008d }
        L_0x008d:
            return r8
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            r0.close()     // Catch:{ IOException -> 0x0093 }
        L_0x0093:
            throw r10
        L_0x0094:
            r11 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f14194b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Could not read file: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15950b(r0, r10, r11)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.XmpUtil.m16118a(java.lang.String, com.a.a.d):boolean");
    }

    /* renamed from: a */
    public static boolean m16117a(InputStream inputStream, OutputStream outputStream, XMPMeta dVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream, outputStream, dVar}, (Object) null, f14193a, true, 8267, new Class[]{InputStream.class, OutputStream.class, XMPMeta.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        List<C2646a> a = m16115a(m16114a(inputStream, false), dVar);
        if (a == null) {
            return false;
        }
        try {
            m16116a(outputStream, a);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
            return true;
        } catch (IOException e) {
            LogUtil.m15943a(f14194b, "Write to stream failed", (Throwable) e);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused2) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static void m16116a(OutputStream outputStream, List<C2646a> list) throws IOException {
        Class[] clsArr = {OutputStream.class, List.class};
        if (!PatchProxy.proxy(new Object[]{outputStream, list}, (Object) null, f14193a, true, 8268, clsArr, Void.TYPE).isSupported) {
            outputStream.write(255);
            outputStream.write(216);
            for (C2646a next : list) {
                outputStream.write(255);
                outputStream.write(next.f14195a);
                if (next.f14196b > 0) {
                    outputStream.write(next.f14196b >> 8);
                    outputStream.write(next.f14196b & 255);
                }
                outputStream.write(next.f14197c);
            }
        }
    }

    /* renamed from: a */
    private static List<C2646a> m16115a(List<C2646a> list, XMPMeta dVar) {
        int i = 1;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{list, dVar}, (Object) null, f14193a, true, 8269, new Class[]{List.class, XMPMeta.class}, List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (list == null || list.size() <= 1) {
            return null;
        }
        try {
            SerializeOptions eVar = new SerializeOptions();
            eVar.mo7654b(true);
            eVar.mo7651a(true);
            byte[] a = XMPMetaFactory.m369a(dVar, eVar);
            if (a.length > 65502) {
                return null;
            }
            byte[] bArr = new byte[(a.length + 29)];
            System.arraycopy(PackUtils.XMP_HEADER_START.getBytes(), 0, bArr, 0, 29);
            System.arraycopy(a, 0, bArr, 29, a.length);
            C2646a aVar = new C2646a();
            aVar.f14195a = 225;
            aVar.f14196b = bArr.length + 2;
            aVar.f14197c = bArr;
            int i2 = 0;
            while (i2 < list.size()) {
                if (list.get(i2).f14195a != 225 || !m16119a(list.get(i2).f14197c)) {
                    i2++;
                } else {
                    list.set(i2, aVar);
                    return list;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (list.get(0).f14195a != 225) {
                i = 0;
            }
            arrayList.addAll(list.subList(0, i));
            arrayList.add(aVar);
            arrayList.addAll(list.subList(i, list.size()));
            return arrayList;
        } catch (XMPException e) {
            LogUtil.m15943a(f14194b, "Serialize xmp failed", (Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m16119a(byte[] bArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, (Object) null, f14193a, true, 8270, new Class[]{byte[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (bArr.length < 29) {
            return false;
        }
        try {
            byte[] bArr2 = new byte[29];
            System.arraycopy(bArr, 0, bArr2, 0, 29);
            return new String(bArr2, "UTF-8").equals(PackUtils.XMP_HEADER_START);
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* renamed from: b */
    private static int m16120b(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 1; length--) {
            if (bArr[length] == 62 && bArr[length - 1] != 63) {
                return length + 1;
            }
        }
        return bArr.length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0069, code lost:
        if (r10 != false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r10 = new com.meizu.media.camera.util.XmpUtil.C2646a((com.meizu.media.camera.util.XmpUtil.C26451) null);
        r10.f14195a = r3;
        r10.f14196b = -1;
        r10.f14197c = new byte[r9.available()];
        r9.read(r10.f14197c, 0, r10.f14197c.length);
        r1.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (r9 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r9.close();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.meizu.media.camera.util.XmpUtil.C2646a> m16114a(java.io.InputStream r9, boolean r10) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r9
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r10)
            r3 = 1
            r1[r3] = r2
            com.meizu.savior.ChangeQuickRedirect r4 = f14193a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.io.InputStream> r0 = java.io.InputStream.class
            r6[r8] = r0
            java.lang.Class r0 = java.lang.Boolean.TYPE
            r6[r3] = r0
            java.lang.Class<java.util.List> r7 = java.util.List.class
            r2 = 0
            r0 = 1
            r5 = 8271(0x204f, float:1.159E-41)
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002f
            java.lang.Object r9 = r0.result
            java.util.List r9 = (java.util.List) r9
            return r9
        L_0x002f:
            r0 = 0
            int r1 = r9.read()     // Catch:{ IOException -> 0x00d7 }
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L_0x00cf
            int r1 = r9.read()     // Catch:{ IOException -> 0x00d7 }
            r3 = 216(0xd8, float:3.03E-43)
            if (r1 == r3) goto L_0x0042
            goto L_0x00cf
        L_0x0042:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ IOException -> 0x00d7 }
            r1.<init>()     // Catch:{ IOException -> 0x00d7 }
        L_0x0047:
            int r3 = r9.read()     // Catch:{ IOException -> 0x00d7 }
            r4 = -1
            if (r3 == r4) goto L_0x00c9
            if (r3 == r2) goto L_0x0056
            if (r9 == 0) goto L_0x0055
            r9.close()     // Catch:{ IOException -> 0x0055 }
        L_0x0055:
            return r0
        L_0x0056:
            int r3 = r9.read()     // Catch:{ IOException -> 0x00d7 }
            if (r3 != r2) goto L_0x005d
            goto L_0x0056
        L_0x005d:
            if (r3 != r4) goto L_0x0065
            if (r9 == 0) goto L_0x0064
            r9.close()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            return r0
        L_0x0065:
            r5 = 218(0xda, float:3.05E-43)
            if (r3 != r5) goto L_0x008d
            if (r10 != 0) goto L_0x0087
            com.meizu.media.camera.util.aw$a r10 = new com.meizu.media.camera.util.aw$a     // Catch:{ IOException -> 0x00d7 }
            r10.<init>()     // Catch:{ IOException -> 0x00d7 }
            r10.f14195a = r3     // Catch:{ IOException -> 0x00d7 }
            r10.f14196b = r4     // Catch:{ IOException -> 0x00d7 }
            int r2 = r9.available()     // Catch:{ IOException -> 0x00d7 }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00d7 }
            r10.f14197c = r2     // Catch:{ IOException -> 0x00d7 }
            byte[] r2 = r10.f14197c     // Catch:{ IOException -> 0x00d7 }
            byte[] r3 = r10.f14197c     // Catch:{ IOException -> 0x00d7 }
            int r3 = r3.length     // Catch:{ IOException -> 0x00d7 }
            r9.read(r2, r8, r3)     // Catch:{ IOException -> 0x00d7 }
            r1.add(r10)     // Catch:{ IOException -> 0x00d7 }
        L_0x0087:
            if (r9 == 0) goto L_0x008c
            r9.close()     // Catch:{ IOException -> 0x008c }
        L_0x008c:
            return r1
        L_0x008d:
            int r5 = r9.read()     // Catch:{ IOException -> 0x00d7 }
            int r6 = r9.read()     // Catch:{ IOException -> 0x00d7 }
            if (r5 == r4) goto L_0x00c3
            if (r6 != r4) goto L_0x009a
            goto L_0x00c3
        L_0x009a:
            int r4 = r5 << 8
            r4 = r4 | r6
            if (r10 == 0) goto L_0x00ab
            r5 = 225(0xe1, float:3.15E-43)
            if (r3 != r5) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            int r4 = r4 + -2
            long r3 = (long) r4     // Catch:{ IOException -> 0x00d7 }
            r9.skip(r3)     // Catch:{ IOException -> 0x00d7 }
            goto L_0x0047
        L_0x00ab:
            com.meizu.media.camera.util.aw$a r5 = new com.meizu.media.camera.util.aw$a     // Catch:{ IOException -> 0x00d7 }
            r5.<init>()     // Catch:{ IOException -> 0x00d7 }
            r5.f14195a = r3     // Catch:{ IOException -> 0x00d7 }
            r5.f14196b = r4     // Catch:{ IOException -> 0x00d7 }
            int r4 = r4 + -2
            byte[] r3 = new byte[r4]     // Catch:{ IOException -> 0x00d7 }
            r5.f14197c = r3     // Catch:{ IOException -> 0x00d7 }
            byte[] r3 = r5.f14197c     // Catch:{ IOException -> 0x00d7 }
            r9.read(r3, r8, r4)     // Catch:{ IOException -> 0x00d7 }
            r1.add(r5)     // Catch:{ IOException -> 0x00d7 }
            goto L_0x0047
        L_0x00c3:
            if (r9 == 0) goto L_0x00c8
            r9.close()     // Catch:{ IOException -> 0x00c8 }
        L_0x00c8:
            return r0
        L_0x00c9:
            if (r9 == 0) goto L_0x00ce
            r9.close()     // Catch:{ IOException -> 0x00ce }
        L_0x00ce:
            return r1
        L_0x00cf:
            if (r9 == 0) goto L_0x00d4
            r9.close()     // Catch:{ IOException -> 0x00d4 }
        L_0x00d4:
            return r0
        L_0x00d5:
            r10 = move-exception
            goto L_0x00e5
        L_0x00d7:
            r10 = move-exception
            com.meizu.media.camera.util.ac$a r1 = f14194b     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = "Could not parse file."
            com.meizu.media.camera.util.LogUtil.m15943a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2, (java.lang.Throwable) r10)     // Catch:{ all -> 0x00d5 }
            if (r9 == 0) goto L_0x00e4
            r9.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00e4:
            return r0
        L_0x00e5:
            if (r9 == 0) goto L_0x00ea
            r9.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00ea:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.XmpUtil.m16114a(java.io.InputStream, boolean):java.util.List");
    }
}
