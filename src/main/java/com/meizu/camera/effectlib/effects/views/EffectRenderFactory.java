package com.meizu.camera.effectlib.effects.views;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.p059b.ColorTableRender;
import com.meizu.camera.effectlib.effects.p059b.EffectBaseRender;
import com.meizu.camera.effectlib.effects.p059b.LutRender;
import com.meizu.camera.effectlib.effects.p059b.SceneRender;
import com.meizu.camera.effectlib.effects.p059b.VfbColorTableRender;
import com.meizu.camera.effectlib.effects.p059b.VfbLutRender;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.imageproc.effects.renders.VideoFaceBeautyRender;
import com.meizu.imageproc.effects.renders.VideoMakeupRender;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.camera.effectlib.effects.views.b */
public class EffectRenderFactory {

    /* renamed from: a */
    public static ChangeQuickRedirect f4043a;

    /* renamed from: b */
    public static final Uri f4044b = Uri.parse("content://com.meizu.media.gallery.filtermanager");

    /* renamed from: c */
    public static final Uri f4045c = Uri.parse("content://com.meizu.media.gallery.filtercomp");

    /* renamed from: e */
    private static EffectRenderFactory f4046e = null;

    /* renamed from: d */
    protected Context f4047d;

    /* renamed from: f */
    private final Map<String, C1191c> f4048f = new HashMap();

    /* renamed from: g */
    private ArrayList<String> f4049g = new ArrayList<>();

    /* renamed from: h */
    private final Object f4050h = new Object();

    /* renamed from: i */
    private String f4051i;

    /* renamed from: j */
    private int f4052j;

    /* renamed from: k */
    private boolean f4053k;

    /* renamed from: l */
    private boolean f4054l;

    /* renamed from: m */
    private boolean f4055m;

    /* renamed from: n */
    private C1189a f4056n;

    /* renamed from: o */
    private C1190b f4057o;

    /* renamed from: com.meizu.camera.effectlib.effects.views.b$b */
    /* compiled from: EffectRenderFactory */
    public interface C1190b {
        /* renamed from: a */
        void mo14341a();
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.b$c */
    /* compiled from: EffectRenderFactory */
    public class C1191c {

        /* renamed from: a */
        public static ChangeQuickRedirect f4060a;

        /* renamed from: c */
        private String f4062c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f4063d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f4064e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f4065f;

        private C1191c(String str, String str2, String str3, String str4) {
            this.f4062c = str;
            this.f4063d = str2;
            this.f4064e = str3;
            this.f4065f = str4;
        }

        /* renamed from: a */
        public String mo14342a() {
            return this.f4062c;
        }

        /* renamed from: b */
        public String mo14343b() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4060a, false, 337, new Class[0], String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if (EffectRenderContext.m4369h().mo14166K() == 1) {
                return this.f4064e;
            }
            return this.f4063d;
        }

        /* renamed from: c */
        public String mo14344c() {
            return this.f4064e;
        }

        /* renamed from: d */
        public String mo14345d() {
            return this.f4065f;
        }
    }

    private EffectRenderFactory() {
    }

    /* renamed from: a */
    public static EffectRenderFactory m4739a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f4043a, true, MsgConstants.TRACK_SHOW_CAPTURE, new Class[0], EffectRenderFactory.class);
        if (proxy.isSupported) {
            return (EffectRenderFactory) proxy.result;
        }
        if (f4046e == null) {
            f4046e = new EffectRenderFactory();
        }
        return f4046e;
    }

    /* renamed from: a */
    public static void m4741a(EffectRenderFactory bVar) {
        f4046e = bVar;
    }

    /* renamed from: a */
    public static EffectRenderFactory m4740a(Context context, String str, int i, boolean z, boolean z2, boolean z3) {
        Object[] objArr = {context, str, new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f4043a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, MsgConstants.TRACK_SHOW_RECG_NOTSANNER, new Class[]{Context.class, String.class, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, EffectRenderFactory.class);
        if (proxy.isSupported) {
            return (EffectRenderFactory) proxy.result;
        }
        EffectRenderFactory a = m4739a();
        a.mo14327b(context, str, i, z, z2, z3);
        a.m4745l();
        m4741a(a);
        return a;
    }

    /* renamed from: b */
    public void mo14327b(Context context, String str, int i, boolean z, boolean z2, boolean z3) {
        Context context2 = context;
        String str2 = str;
        int i2 = i;
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        Object[] objArr = {context2, str2, new Integer(i2), new Byte(z4 ? (byte) 1 : 0), new Byte(z5 ? (byte) 1 : 0), new Byte(z6 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f4043a;
        Class[] clsArr = {Context.class, String.class, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE};
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, MsgConstants.TRACK_HIDE_RECG_NOTSANNER, clsArr, Void.TYPE).isSupported) {
            this.f4047d = context2;
            this.f4051i = str2;
            this.f4052j = i2;
            this.f4053k = z4;
            this.f4054l = z5;
            this.f4055m = z6;
            this.f4056n = new C1189a(this.f4047d.getContentResolver(), this);
        }
    }

    /* renamed from: a */
    public void mo14324a(C1190b bVar) {
        this.f4057o = bVar;
    }

    /* renamed from: l */
    private void m4745l() {
        if (!PatchProxy.proxy(new Object[0], this, f4043a, false, MsgConstants.TRACK_CLOSE_RECG_NOTSANNER, new Class[0], Void.TYPE).isSupported) {
            mo14322a("BaseRender", "null", "null", "Mznone");
            mo14322a("DistortedRender", "null", "null", "Mzdistorted");
            mo14322a("ExtrusionRender", "null", "null", "Mzextrusion");
            mo14322a("MirrorRender", "null", "null", "Mzmirror");
            mo14322a("TemperatureRender", "null", "null", "Mztemperature");
            mo14322a("TimetunnelRender", "null", "null", "Mztimetunnel");
            mo14322a("XrayRender", "null", "null", "Mzxray");
            mo14322a("BlurRender", "null", "null", "Mzblur");
            mo14322a("FaceBeautyRender", "null", "null", "Mzfacebeauty");
            mo14322a("VideoFaceBeautyRender", "null", "null", "Mzvfacebeauty");
            mo14322a("VideoMakeupRender", "null", "null", "Mzmake up");
            mo14322a("NegativeRender", "null", "null", "Mznegative");
            mo14322a("SceneRender", "null", "null", "Mznormalscene");
            mo14322a("ColorTableRender", "landscapescene.zip", "null", "Mzblue");
            mo14322a("ColorTableRender", "foodscene.zip", "null", "Mzfood");
            mo14322a("ColorTableRender", "landscapescene.zip", "null", "Mzgrass");
            mo14322a("ColorTableRender", "textscene.zip", "null", "Mztext");
            mo14322a("ColorTableRender", "landscapescene.zip", "null", "Mzlandscape");
            mo14322a("VfbColorTableRender", "foodscene.zip", "null", "Mzvfbfood");
            mo14322a("VfbColorTableRender", "landscapescene.zip", "null", "Mzvfbblue");
            mo14322a("VfbColorTableRender", "landscapescene.zip", "null", "Mzvfbgrass");
            mo14322a("VfbColorTableRender", "textscene.zip", "null", "Mzvfbtext");
            mo14322a("VfbColorTableRender", "landscapescene.zip", "null", "Mzvfblandscape");
            mo14322a("EffectBaseRender", "null", "null", "Mzeffectnone");
            mo14322a("ColorTableRender", "menglong.zip", "menglongfront.zip", "Mzmenglong");
            mo14322a("ColorTableRender", "heise.zip", "heisefront.zip", "Mzheise");
            mo14322a("ColorTableRender", "fanchase.zip", "fanchasefront.zip", "Mzfanchase");
            mo14322a("ColorTableRender", "fanchanuan.zip", "fanchanuanfront.zip", "fMzanchanuan");
            mo14322a("ColorTableRender", "nense.zip", "nensefront.zip", "Mznense");
            mo14322a("ColorTableRender", "xianming.zip", "xianmingfront.zip", "Mzxianming");
            mo14322a("ColorTableRender", "nuanse.zip", "nuansefront.zip", "Mznuanse");
            mo14322a("ColorTableRender", "yinse.zip", "yinsefront.zip", "Mzyinse");
            mo14322a("ColorTableRender", "fanchanen.zip", "fanchanenfront.zip", "Mzfanchanen");
            mo14322a("VfbColorTableRender", "menglong.zip", "menglongfront.zip", "Mzvfbmenglong");
            mo14322a("VfbColorTableRender", "heise.zip", "heisefront.zip", "Mzvfbheise");
            mo14322a("VfbColorTableRender", "fanchase.zip", "fanchasefront.zip", "Mzvfbfanchase");
            mo14322a("VfbColorTableRender", "fanchanuan.zip", "fanchanuanfront.zip", "Mzvfbfanchanuan");
            mo14322a("VfbColorTableRender", "nense.zip", "nensefront.zip", "Mzvfbnense");
            mo14322a("VfbColorTableRender", "xianming.zip", "xianmingfront.zip", "Mzvfbxianming");
            mo14322a("VfbColorTableRender", "nuanse.zip", "nuansefront.zip", "Mzvfbnuanse");
            mo14322a("VfbColorTableRender", "yinse.zip", "yinsefront.zip", "Mzvfbyinse");
            mo14322a("VfbColorTableRender", "fanchanen.zip", "fanchanenfront.zip", "Mzvfbfanchanen");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0073, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m4742a(java.lang.String r10, com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c r11, boolean r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0074 }
            r2 = 0
            r1[r2] = r10     // Catch:{ all -> 0x0074 }
            r3 = 1
            r1[r3] = r11     // Catch:{ all -> 0x0074 }
            java.lang.Byte r4 = new java.lang.Byte     // Catch:{ all -> 0x0074 }
            r4.<init>(r12)     // Catch:{ all -> 0x0074 }
            r5 = 2
            r1[r5] = r4     // Catch:{ all -> 0x0074 }
            com.meizu.savior.ChangeQuickRedirect r4 = f4043a     // Catch:{ all -> 0x0074 }
            r6 = 0
            r7 = 318(0x13e, float:4.46E-43)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0074 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r0[r2] = r8     // Catch:{ all -> 0x0074 }
            java.lang.Class<com.meizu.camera.effectlib.effects.views.b$c> r2 = com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c.class
            r0[r3] = r2     // Catch:{ all -> 0x0074 }
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0074 }
            r0[r5] = r2     // Catch:{ all -> 0x0074 }
            java.lang.Class r8 = java.lang.Void.TYPE     // Catch:{ all -> 0x0074 }
            r2 = r9
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r0
            r7 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0074 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0037
            monitor-exit(r9)
            return
        L_0x0037:
            if (r11 == 0) goto L_0x0072
            if (r12 == 0) goto L_0x0040
            java.util.Map<java.lang.String, com.meizu.camera.effectlib.effects.views.b$c> r12 = r9.f4048f     // Catch:{ all -> 0x0074 }
            r12.remove(r10)     // Catch:{ all -> 0x0074 }
        L_0x0040:
            java.lang.String r12 = "EffectRenderFactory"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r0.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = " addRenderType：name "
            r0.append(r1)     // Catch:{ all -> 0x0074 }
            r0.append(r10)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = " renderType.getRenderNameEn() "
            r0.append(r1)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r11.mo14345d()     // Catch:{ all -> 0x0074 }
            r0.append(r1)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = "renderType "
            r0.append(r1)     // Catch:{ all -> 0x0074 }
            r0.append(r11)     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0074 }
            android.util.Log.d(r12, r0)     // Catch:{ all -> 0x0074 }
            java.util.Map<java.lang.String, com.meizu.camera.effectlib.effects.views.b$c> r12 = r9.f4048f     // Catch:{ all -> 0x0074 }
            r12.put(r10, r11)     // Catch:{ all -> 0x0074 }
            r9.m4743b((java.lang.String) r10)     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r9)
            return
        L_0x0074:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderFactory.m4742a(java.lang.String, com.meizu.camera.effectlib.effects.views.b$c, boolean):void");
    }

    /* renamed from: b */
    private synchronized C1191c m4743b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f4043a, false, MsgConstants.TRACK_CLOSE_TRACK_ALGO, new Class[]{String.class}, C1191c.class);
        if (proxy.isSupported) {
            return (C1191c) proxy.result;
        }
        return this.f4048f.get(str);
    }

    /* renamed from: b */
    public String mo14326b() {
        return this.f4051i;
    }

    /* renamed from: c */
    public int mo14328c() {
        return this.f4052j;
    }

    /* renamed from: d */
    public boolean mo14331d() {
        return this.f4053k;
    }

    /* renamed from: e */
    public boolean mo14333e() {
        return this.f4054l;
    }

    /* renamed from: f */
    public boolean mo14334f() {
        return this.f4055m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c mo14322a(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 4
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0071 }
            r8 = 0
            r1[r8] = r11     // Catch:{ all -> 0x0071 }
            r9 = 1
            r1[r9] = r12     // Catch:{ all -> 0x0071 }
            r2 = 2
            r1[r2] = r13     // Catch:{ all -> 0x0071 }
            r3 = 3
            r1[r3] = r14     // Catch:{ all -> 0x0071 }
            com.meizu.savior.ChangeQuickRedirect r4 = f4043a     // Catch:{ all -> 0x0071 }
            r5 = 0
            r6 = 320(0x140, float:4.48E-43)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r8] = r7     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r9] = r7     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r2] = r7     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r0[r3] = r2     // Catch:{ all -> 0x0071 }
            java.lang.Class<com.meizu.camera.effectlib.effects.views.b$c> r7 = com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c.class
            r2 = r10
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0071 }
            boolean r1 = r0.isSupported     // Catch:{ all -> 0x0071 }
            if (r1 == 0) goto L_0x003c
            java.lang.Object r11 = r0.result     // Catch:{ all -> 0x0071 }
            com.meizu.camera.effectlib.effects.views.b$c r11 = (com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c) r11     // Catch:{ all -> 0x0071 }
            monitor-exit(r10)
            return r11
        L_0x003c:
            com.meizu.camera.effectlib.effects.views.b$c r0 = r10.m4743b((java.lang.String) r14)     // Catch:{ all -> 0x0071 }
            if (r0 != 0) goto L_0x0054
            com.meizu.camera.effectlib.effects.views.b$c r0 = new com.meizu.camera.effectlib.effects.views.b$c     // Catch:{ all -> 0x0071 }
            r7 = 0
            r1 = r0
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x0071 }
            if (r11 == 0) goto L_0x006f
            r10.m4742a(r14, r0, r8)     // Catch:{ all -> 0x0071 }
            goto L_0x006f
        L_0x0054:
            java.lang.String r1 = r0.mo14344c()     // Catch:{ all -> 0x0071 }
            boolean r1 = r1.equals(r13)     // Catch:{ all -> 0x0071 }
            if (r1 != 0) goto L_0x006f
            com.meizu.camera.effectlib.effects.views.b$c r0 = new com.meizu.camera.effectlib.effects.views.b$c     // Catch:{ all -> 0x0071 }
            r8 = 0
            r2 = r0
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x0071 }
            if (r11 == 0) goto L_0x006f
            r10.m4742a(r14, r0, r9)     // Catch:{ all -> 0x0071 }
        L_0x006f:
            monitor-exit(r10)
            return r0
        L_0x0071:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderFactory.mo14322a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.meizu.camera.effectlib.effects.views.b$c");
    }

    /* renamed from: a */
    public C1191c mo14321a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f4043a, false, 321, new Class[]{String.class}, C1191c.class);
        return proxy.isSupported ? (C1191c) proxy.result : m4743b(str);
    }

    /* renamed from: a */
    public synchronized BaseRender mo14320a(C1191c cVar, EffectRenderContext.MapType mapType, String str, boolean z) {
        BaseRender a;
        BaseRender aVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar, mapType, str, new Byte(z ? (byte) 1 : 0)}, this, f4043a, false, 322, new Class[]{C1191c.class, EffectRenderContext.MapType.class, String.class, Boolean.TYPE}, BaseRender.class);
        if (proxy.isSupported) {
            return (BaseRender) proxy.result;
        }
        if (z) {
            Log.e("EffectRenderFactory", str + " com.meizu.camera.effectlib.effects.renders." + cVar.mo14345d());
        }
        a = EffectRenderContext.m4369h().mo14170a(cVar.mo14345d(), mapType);
        if (a == null) {
            Log.e("EffectRenderFactory", str + " create com.meizu.camera.effectlib.effects.renders." + cVar.mo14345d());
            try {
                if ("VideoFaceBeautyRender".equals(cVar.mo14342a())) {
                    aVar = VideoFaceBeautyRender.m6376g();
                } else if ("BaseRender".equals(cVar.mo14342a())) {
                    aVar = new BaseRender();
                } else if ("EffectBaseRender".equals(cVar.mo14342a())) {
                    aVar = new EffectBaseRender();
                } else if ("VideoMakeupRender".equals(cVar.mo14342a())) {
                    aVar = new VideoMakeupRender();
                } else if ("SceneRender".equals(cVar.mo14342a())) {
                    aVar = new SceneRender();
                } else if ("ColorTableRender".equals(cVar.mo14342a())) {
                    aVar = new ColorTableRender();
                } else if ("VfbColorTableRender".equals(cVar.mo14342a())) {
                    aVar = new VfbColorTableRender();
                } else if ("LutRender".equals(cVar.mo14342a())) {
                    aVar = new LutRender();
                } else if ("VfbLutRender".equals(cVar.mo14342a())) {
                    aVar = new VfbLutRender();
                } else {
                    aVar = new BaseRender();
                }
                a = aVar;
                if (a != null) {
                    a.mo14041a(cVar, this.f4047d, cVar.mo14343b(), this.f4051i);
                    EffectRenderContext.m4369h().mo14184a(cVar.mo14345d(), a, mapType);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    /* renamed from: a */
    public synchronized BaseRender mo14319a(C1191c cVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f4043a, false, 323, new Class[]{C1191c.class}, BaseRender.class);
        if (proxy.isSupported) {
            return (BaseRender) proxy.result;
        }
        return mo14320a(cVar, EffectRenderContext.MapType.PREVIEW, "getPreviewRender", true);
    }

    /* renamed from: b */
    public synchronized BaseRender mo14325b(C1191c cVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f4043a, false, 324, new Class[]{C1191c.class}, BaseRender.class);
        if (proxy.isSupported) {
            return (BaseRender) proxy.result;
        }
        return mo14320a(m4744f(cVar), EffectRenderContext.MapType.PREVIEW, "getPreviewRenderWithVfb", false);
    }

    /* renamed from: c */
    public synchronized BaseRender mo14329c(C1191c cVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f4043a, false, 325, new Class[]{C1191c.class}, BaseRender.class);
        if (proxy.isSupported) {
            return (BaseRender) proxy.result;
        }
        return mo14320a(cVar, EffectRenderContext.MapType.EFFECT, "getEffectRender", true);
    }

    /* renamed from: d */
    public synchronized BaseRender mo14330d(C1191c cVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f4043a, false, 326, new Class[]{C1191c.class}, BaseRender.class);
        if (proxy.isSupported) {
            return (BaseRender) proxy.result;
        }
        return mo14320a(cVar, EffectRenderContext.MapType.VIDEO, "getVideoRender", true);
    }

    /* renamed from: e */
    public synchronized BaseRender mo14332e(C1191c cVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f4043a, false, 327, new Class[]{C1191c.class}, BaseRender.class);
        if (proxy.isSupported) {
            return (BaseRender) proxy.result;
        }
        return mo14320a(cVar, EffectRenderContext.MapType.VIDEO, "getRecordRender", true);
    }

    /* renamed from: g */
    public void mo14335g() {
        if (!PatchProxy.proxy(new Object[0], this, f4043a, false, 330, new Class[0], Void.TYPE).isSupported) {
            Log.d("EffectRenderFactory", "release");
            if (this.f4057o != null) {
                this.f4057o = null;
            }
            if (this.f4056n != null) {
                this.f4056n.cancelOperation(1008);
                this.f4056n = null;
            }
            if (this.f4049g != null) {
                this.f4049g.clear();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b9, code lost:
        if (r1.equals("Mzfood") != false) goto L_0x00d1;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c m4744f(com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f4043a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.camera.effectlib.effects.views.b$c> r2 = com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c.class
            r6[r8] = r2
            java.lang.Class<com.meizu.camera.effectlib.effects.views.b$c> r7 = com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c.class
            r4 = 0
            r5 = 331(0x14b, float:4.64E-43)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0021
            java.lang.Object r10 = r1.result
            com.meizu.camera.effectlib.effects.views.b$c r10 = (com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c) r10
            return r10
        L_0x0021:
            java.lang.String r1 = r10.mo14345d()
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case -1995464818: goto L_0x00c6;
                case -1974826073: goto L_0x00bc;
                case -1974704213: goto L_0x00b3;
                case -1974465915: goto L_0x00a8;
                case -1974296454: goto L_0x009e;
                case -1085288439: goto L_0x0094;
                case -1084744527: goto L_0x008a;
                case -1079198596: goto L_0x007f;
                case -1068920701: goto L_0x0074;
                case -33769446: goto L_0x006a;
                case 220492065: goto L_0x005e;
                case 846632192: goto L_0x0052;
                case 918966675: goto L_0x0046;
                case 1095532208: goto L_0x003a;
                case 1392586120: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x00d0
        L_0x002f:
            java.lang.String r0 = "Mzfanchase"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 7
            goto L_0x00d1
        L_0x003a:
            java.lang.String r0 = "fMzanchanuan"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 8
            goto L_0x00d1
        L_0x0046:
            java.lang.String r0 = "Mznuanse"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 11
            goto L_0x00d1
        L_0x0052:
            java.lang.String r0 = "Mzxianming"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 10
            goto L_0x00d1
        L_0x005e:
            java.lang.String r0 = "Mzfanchanen"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 13
            goto L_0x00d1
        L_0x006a:
            java.lang.String r0 = "Mzmenglong"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 5
            goto L_0x00d1
        L_0x0074:
            java.lang.String r0 = "Mzyinse"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 12
            goto L_0x00d1
        L_0x007f:
            java.lang.String r0 = "Mznense"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 9
            goto L_0x00d1
        L_0x008a:
            java.lang.String r0 = "Mzheise"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 6
            goto L_0x00d1
        L_0x0094:
            java.lang.String r0 = "Mzgrass"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 4
            goto L_0x00d1
        L_0x009e:
            java.lang.String r0 = "Mztext"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 2
            goto L_0x00d1
        L_0x00a8:
            java.lang.String r0 = "Mznone"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 14
            goto L_0x00d1
        L_0x00b3:
            java.lang.String r3 = "Mzfood"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00d0
            goto L_0x00d1
        L_0x00bc:
            java.lang.String r0 = "Mzblue"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 0
            goto L_0x00d1
        L_0x00c6:
            java.lang.String r0 = "Mzlandscape"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d0
            r0 = 3
            goto L_0x00d1
        L_0x00d0:
            r0 = -1
        L_0x00d1:
            switch(r0) {
                case 0: goto L_0x015a;
                case 1: goto L_0x0153;
                case 2: goto L_0x014c;
                case 3: goto L_0x0145;
                case 4: goto L_0x013e;
                case 5: goto L_0x0137;
                case 6: goto L_0x0130;
                case 7: goto L_0x0129;
                case 8: goto L_0x0122;
                case 9: goto L_0x011b;
                case 10: goto L_0x0114;
                case 11: goto L_0x010d;
                case 12: goto L_0x0106;
                case 13: goto L_0x00ff;
                case 14: goto L_0x00f8;
                default: goto L_0x00d4;
            }
        L_0x00d4:
            java.lang.String r0 = "VfbLutRender"
            java.lang.String r1 = r10.f4063d
            java.lang.String r2 = r10.f4064e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "vfb"
            r3.append(r4)
            java.lang.String r10 = r10.f4065f
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14322a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r10)
            return r10
        L_0x00f8:
            java.lang.String r10 = "Mzeffectnone"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x00ff:
            java.lang.String r10 = "Mzvfbfanchanen"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0106:
            java.lang.String r10 = "Mzvfbyinse"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x010d:
            java.lang.String r10 = "Mzvfbnuanse"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0114:
            java.lang.String r10 = "Mzvfbxianming"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x011b:
            java.lang.String r10 = "Mzvfbnense"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0122:
            java.lang.String r10 = "Mzvfbfanchanuan"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0129:
            java.lang.String r10 = "Mzvfbfanchase"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0130:
            java.lang.String r10 = "Mzvfbheise"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0137:
            java.lang.String r10 = "Mzvfbmenglong"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x013e:
            java.lang.String r10 = "Mzvfbgrass"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0145:
            java.lang.String r10 = "Mzvfblandscape"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x014c:
            java.lang.String r10 = "Mzvfbtext"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x0153:
            java.lang.String r10 = "Mzvfbfood"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        L_0x015a:
            java.lang.String r10 = "Mzvfbblue"
            com.meizu.camera.effectlib.effects.views.b$c r10 = r9.mo14321a((java.lang.String) r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderFactory.m4744f(com.meizu.camera.effectlib.effects.views.b$c):com.meizu.camera.effectlib.effects.views.b$c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14336h() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002b }
            com.meizu.savior.ChangeQuickRedirect r3 = f4043a     // Catch:{ all -> 0x002b }
            r4 = 0
            r5 = 332(0x14c, float:4.65E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x002b }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x002b }
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002b }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            com.meizu.camera.effectlib.effects.views.b$a r0 = r8.f4056n     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0029
            com.meizu.camera.effectlib.effects.views.b$a r0 = new com.meizu.camera.effectlib.effects.views.b$a     // Catch:{ all -> 0x002b }
            android.content.Context r1 = r8.f4047d     // Catch:{ all -> 0x002b }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x002b }
            r0.<init>(r1, r8)     // Catch:{ all -> 0x002b }
            r8.f4056n = r0     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r8)
            return
        L_0x002b:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderFactory.mo14336h():void");
    }

    /* renamed from: i */
    public synchronized void mo14337i() {
        if (!PatchProxy.proxy(new Object[0], this, f4043a, false, 333, new Class[0], Void.TYPE).isSupported) {
            try {
                if (this.f4056n != null) {
                    Log.i("EffectRenderFactory", "searchLut");
                    this.f4056n.startQuery(1008, (Object) null, f4044b, (String[]) null, (String) null, (String[]) null, (String) null);
                }
            } catch (Throwable th) {
                Log.i("EffectRenderFactory", "startQuery fail : " + f4044b.toString() + "" + th.getMessage());
                th.printStackTrace();
            }
        } else {
            return;
        }
    }

    /* renamed from: j */
    public boolean mo14338j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4043a, false, 334, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Cursor query = this.f4047d.getContentResolver().query(f4045c, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            query.close();
            return true;
        }
        Log.i("EffectRenderFactory", "Gallery not support Lut");
        return false;
    }

    /* renamed from: k */
    public synchronized ArrayList<String> mo14339k() {
        ArrayList<String> arrayList;
        synchronized (this.f4050h) {
            arrayList = this.f4049g;
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void mo14323a(Cursor cursor) {
        if (!PatchProxy.proxy(new Object[]{cursor}, this, f4043a, false, 335, new Class[]{Cursor.class}, Void.TYPE).isSupported) {
            synchronized (this.f4050h) {
                if (cursor != null) {
                    try {
                        this.f4049g.clear();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("name"));
                            int i = cursor.getInt(cursor.getColumnIndex("_id"));
                            String str = string + "_" + i;
                            Uri withAppendedId = ContentUris.withAppendedId(f4044b, (long) i);
                            Log.i("EffectRenderFactory", "loadLutRenderTypes: " + withAppendedId);
                            this.f4049g.add(m4739a().mo14322a("LutRender", withAppendedId.toString(), withAppendedId.toString(), str).mo14345d());
                        }
                        if (this.f4057o != null) {
                            this.f4057o.mo14341a();
                        }
                    } catch (Throwable th) {
                        while (true) {
                        }
                        throw th;
                    }
                }
            }
            return;
        }
        return;
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.b$a */
    /* compiled from: EffectRenderFactory */
    static class C1189a extends AsyncQueryHandler {

        /* renamed from: a */
        public static ChangeQuickRedirect f4058a;

        /* renamed from: b */
        private final WeakReference<EffectRenderFactory> f4059b;

        public C1189a(ContentResolver contentResolver, EffectRenderFactory bVar) {
            super(contentResolver);
            this.f4059b = new WeakReference<>(bVar);
        }

        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            Object[] objArr = {new Integer(i), obj, cursor};
            ChangeQuickRedirect changeQuickRedirect = f4058a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 336, new Class[]{Integer.TYPE, Object.class, Cursor.class}, Void.TYPE).isSupported) {
                super.onQueryComplete(i, obj, cursor);
                if (i == 1008) {
                    try {
                        Log.d("EffectRenderFactory", Thread.currentThread().getName());
                        ((EffectRenderFactory) this.f4059b.get()).mo14323a(cursor);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        }
    }
}
