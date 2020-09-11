package com.meizu.media.camera;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.media.SoundPool;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.aa */
public class SoundClips {

    /* renamed from: a */
    public static ChangeQuickRedirect f7494a;

    /* renamed from: b */
    private static final int f7495b = ApiHelper.m16125a(MediaActionSound.class, "SHUTTER_CLICK_BURST", (Class<?>) null, -1);

    /* renamed from: com.meizu.media.camera.aa$a */
    /* compiled from: SoundClips */
    public interface C1785a {
        /* renamed from: a */
        void mo18760a();

        /* renamed from: a */
        void mo18761a(int i);
    }

    /* renamed from: a */
    public static C1785a m7934a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f7494a, true, 2114, new Class[]{Context.class}, C1785a.class);
        return proxy.isSupported ? (C1785a) proxy.result : new C1786b(context);
    }

    /* renamed from: a */
    public static int m7933a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7494a, true, 2115, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (ApiHelper.f14208i) {
            return 4;
        }
        return ApiHelper.m16125a(AudioManager.class, "STREAM_SYSTEM_ENFORCED", (Class<?>) null, 2);
    }

    /* renamed from: com.meizu.media.camera.aa$b */
    /* compiled from: SoundClips */
    private static class C1786b implements SoundPool.OnLoadCompleteListener, C1785a {

        /* renamed from: a */
        public static ChangeQuickRedirect f7496a;

        /* renamed from: b */
        private static final LogUtil.C2630a f7497b = new LogUtil.C2630a("SoundPoolPlayer");

        /* renamed from: c */
        private static final String[] f7498c = {"sound/mz_focus.ogg", "sound/mz_video_start.ogg", "sound/mz_video_stop.ogg", "sound/mz_shutter.ogg", "sound/mz_burst.ogg", "sound/mz_pano_start.ogg", "sound/mz_pano_finish.ogg", "sound/mz_barcode_recognize.ogg"};

        /* renamed from: d */
        private final int[] f7499d = {0, 1, 2, 3, 4, 5, 6, 7};

        /* renamed from: e */
        private Context f7500e;

        /* renamed from: f */
        private SoundPool f7501f;

        /* renamed from: g */
        private final int[] f7502g;

        /* renamed from: h */
        private final boolean[] f7503h;

        /* renamed from: i */
        private int f7504i;

        public C1786b(Context context) {
            this.f7500e = context;
            this.f7504i = 0;
            this.f7501f = new SoundPool(1, SoundClips.m7933a(), 0);
            this.f7501f.setOnLoadCompleteListener(this);
            this.f7502g = new int[f7498c.length];
            this.f7503h = new boolean[f7498c.length];
            for (int i = 0; i < f7498c.length; i++) {
                this.f7502g[i] = m7937a(this.f7500e, f7498c[i]);
                this.f7503h[i] = false;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo18760a() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0034 }
                com.meizu.savior.ChangeQuickRedirect r3 = f7496a     // Catch:{ all -> 0x0034 }
                r4 = 0
                r5 = 2118(0x846, float:2.968E-42)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0034 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0034 }
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0034 }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                android.media.SoundPool r0 = r8.f7501f     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0032
                com.meizu.media.camera.util.ac$a r0 = f7497b     // Catch:{ all -> 0x0034 }
                java.lang.String r1 = "release start"
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0034 }
                android.media.SoundPool r0 = r8.f7501f     // Catch:{ all -> 0x0034 }
                r0.release()     // Catch:{ all -> 0x0034 }
                com.meizu.media.camera.util.ac$a r0 = f7497b     // Catch:{ all -> 0x0034 }
                java.lang.String r1 = "release end"
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0034 }
                r0 = 0
                r8.f7501f = r0     // Catch:{ all -> 0x0034 }
            L_0x0032:
                monitor-exit(r8)
                return
            L_0x0034:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.SoundClips.C1786b.mo18760a():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            com.meizu.media.camera.util.LogUtil.m15949b(f7497b, "mSoundPool has been released");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0088 */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0072=Splitter:B:18:0x0072, B:27:0x0098=Splitter:B:27:0x0098} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo18761a(int r9) {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x00b5 }
                java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x00b5 }
                r2.<init>(r9)     // Catch:{ all -> 0x00b5 }
                r3 = 0
                r1[r3] = r2     // Catch:{ all -> 0x00b5 }
                com.meizu.savior.ChangeQuickRedirect r4 = f7496a     // Catch:{ all -> 0x00b5 }
                r5 = 0
                r6 = 2119(0x847, float:2.97E-42)
                java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x00b5 }
                java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00b5 }
                r0[r3] = r2     // Catch:{ all -> 0x00b5 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x00b5 }
                r2 = r8
                r3 = r4
                r4 = r5
                r5 = r6
                r6 = r0
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00b5 }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x0028
                monitor-exit(r8)
                return
            L_0x0028:
                if (r9 < 0) goto L_0x0098
                int[] r0 = r8.f7499d     // Catch:{ all -> 0x00b5 }
                int r0 = r0.length     // Catch:{ all -> 0x00b5 }
                if (r9 < r0) goto L_0x0030
                goto L_0x0098
            L_0x0030:
                int[] r0 = r8.f7499d     // Catch:{ all -> 0x00b5 }
                r9 = r0[r9]     // Catch:{ all -> 0x00b5 }
                com.meizu.media.camera.util.ac$a r0 = f7497b     // Catch:{ all -> 0x00b5 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                r1.<init>()     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "play index:"
                r1.append(r2)     // Catch:{ all -> 0x00b5 }
                r1.append(r9)     // Catch:{ all -> 0x00b5 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b5 }
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00b5 }
                int[] r0 = r8.f7502g     // Catch:{ all -> 0x00b5 }
                r0 = r0[r9]     // Catch:{ all -> 0x00b5 }
                if (r0 != 0) goto L_0x0065
                int[] r0 = r8.f7502g     // Catch:{ all -> 0x00b5 }
                android.content.Context r1 = r8.f7500e     // Catch:{ all -> 0x00b5 }
                java.lang.String[] r2 = f7498c     // Catch:{ all -> 0x00b5 }
                r2 = r2[r9]     // Catch:{ all -> 0x00b5 }
                int r1 = r8.m7937a(r1, r2)     // Catch:{ all -> 0x00b5 }
                r0[r9] = r1     // Catch:{ all -> 0x00b5 }
                int[] r0 = r8.f7502g     // Catch:{ all -> 0x00b5 }
                r9 = r0[r9]     // Catch:{ all -> 0x00b5 }
                r8.f7504i = r9     // Catch:{ all -> 0x00b5 }
                goto L_0x008f
            L_0x0065:
                boolean[] r0 = r8.f7503h     // Catch:{ all -> 0x00b5 }
                boolean r0 = r0[r9]     // Catch:{ all -> 0x00b5 }
                if (r0 != 0) goto L_0x0072
                int[] r0 = r8.f7502g     // Catch:{ all -> 0x00b5 }
                r9 = r0[r9]     // Catch:{ all -> 0x00b5 }
                r8.f7504i = r9     // Catch:{ all -> 0x00b5 }
                goto L_0x008f
            L_0x0072:
                android.media.SoundPool r0 = r8.f7501f     // Catch:{ NullPointerException -> 0x0088 }
                if (r0 == 0) goto L_0x008f
                android.media.SoundPool r1 = r8.f7501f     // Catch:{ NullPointerException -> 0x0088 }
                int[] r0 = r8.f7502g     // Catch:{ NullPointerException -> 0x0088 }
                r2 = r0[r9]     // Catch:{ NullPointerException -> 0x0088 }
                r3 = 1065353216(0x3f800000, float:1.0)
                r4 = 1065353216(0x3f800000, float:1.0)
                r5 = 0
                r6 = 0
                r7 = 1065353216(0x3f800000, float:1.0)
                r1.play(r2, r3, r4, r5, r6, r7)     // Catch:{ NullPointerException -> 0x0088 }
                goto L_0x008f
            L_0x0088:
                com.meizu.media.camera.util.ac$a r9 = f7497b     // Catch:{ all -> 0x00b5 }
                java.lang.String r0 = "mSoundPool has been released"
                com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r9, (java.lang.String) r0)     // Catch:{ all -> 0x00b5 }
            L_0x008f:
                com.meizu.media.camera.util.ac$a r9 = f7497b     // Catch:{ all -> 0x00b5 }
                java.lang.String r0 = "play end"
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r9, (java.lang.String) r0)     // Catch:{ all -> 0x00b5 }
                monitor-exit(r8)
                return
            L_0x0098:
                com.meizu.media.camera.util.ac$a r0 = f7497b     // Catch:{ all -> 0x00b5 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                r1.<init>()     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Resource ID not found for action:"
                r1.append(r2)     // Catch:{ all -> 0x00b5 }
                r1.append(r9)     // Catch:{ all -> 0x00b5 }
                java.lang.String r9 = " in play()."
                r1.append(r9)     // Catch:{ all -> 0x00b5 }
                java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00b5 }
                com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r9)     // Catch:{ all -> 0x00b5 }
                monitor-exit(r8)
                return
            L_0x00b5:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.SoundClips.C1786b.mo18761a(int):void");
        }

        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            if (!PatchProxy.proxy(new Object[]{soundPool, new Integer(i), new Integer(i2)}, this, f7496a, false, 2120, new Class[]{SoundPool.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                if (i2 != 0) {
                    LogUtil.C2630a aVar = f7497b;
                    LogUtil.m15949b(aVar, "loading sound tracks failed (status=" + i2 + ")");
                    for (int i3 = 0; i3 < this.f7502g.length; i3++) {
                        if (this.f7502g[i3] == i) {
                            this.f7502g[i3] = 0;
                            return;
                        }
                    }
                    return;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= this.f7502g.length) {
                        break;
                    } else if (this.f7502g[i4] == i) {
                        this.f7503h[i4] = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i == this.f7504i) {
                    this.f7504i = 0;
                    if (this.f7501f != null) {
                        this.f7501f.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[SYNTHETIC, Splitter:B:24:0x0054] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x005f A[SYNTHETIC, Splitter:B:30:0x005f] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int m7937a(android.content.Context r11, java.lang.String r12) {
            /*
                r10 = this;
                r0 = 2
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r11
                r9 = 1
                r1[r9] = r12
                com.meizu.savior.ChangeQuickRedirect r3 = f7496a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<android.content.Context> r0 = android.content.Context.class
                r6[r8] = r0
                java.lang.Class<java.lang.String> r0 = java.lang.String.class
                r6[r9] = r0
                java.lang.Class r7 = java.lang.Integer.TYPE
                r4 = 0
                r5 = 2121(0x849, float:2.972E-42)
                r2 = r10
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r0.isSupported
                if (r1 == 0) goto L_0x002c
                java.lang.Object r11 = r0.result
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                return r11
            L_0x002c:
                r0 = 0
                android.content.res.AssetManager r11 = r11.getAssets()     // Catch:{ IOException -> 0x004e }
                android.content.res.AssetFileDescriptor r11 = r11.openFd(r12)     // Catch:{ IOException -> 0x004e }
                android.media.SoundPool r12 = r10.f7501f     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
                int r12 = r12.load(r11, r9)     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
                if (r11 == 0) goto L_0x0045
                r11.close()     // Catch:{ IOException -> 0x0041 }
                goto L_0x0045
            L_0x0041:
                r11 = move-exception
                r11.printStackTrace()
            L_0x0045:
                return r12
            L_0x0046:
                r12 = move-exception
                r0 = r11
                goto L_0x005d
            L_0x0049:
                r12 = move-exception
                r0 = r11
                goto L_0x004f
            L_0x004c:
                r12 = move-exception
                goto L_0x005d
            L_0x004e:
                r12 = move-exception
            L_0x004f:
                r12.printStackTrace()     // Catch:{ all -> 0x004c }
                if (r0 == 0) goto L_0x005c
                r0.close()     // Catch:{ IOException -> 0x0058 }
                goto L_0x005c
            L_0x0058:
                r11 = move-exception
                r11.printStackTrace()
            L_0x005c:
                return r8
            L_0x005d:
                if (r0 == 0) goto L_0x0067
                r0.close()     // Catch:{ IOException -> 0x0063 }
                goto L_0x0067
            L_0x0063:
                r11 = move-exception
                r11.printStackTrace()
            L_0x0067:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.SoundClips.C1786b.m7937a(android.content.Context, java.lang.String):int");
        }
    }
}
