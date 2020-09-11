package com.baidu.p020ar.recorder.p046d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import com.baidu.p020ar.recorder.p049g.C0871a;
import java.nio.ByteBuffer;

/* renamed from: com.baidu.ar.recorder.d.e */
public class C0853e {

    /* renamed from: a */
    private static final String f2110a = "e";

    /* renamed from: e */
    private static volatile C0853e f2111e;

    /* renamed from: b */
    private MediaMuxer f2112b;

    /* renamed from: c */
    private volatile boolean f2113c = false;

    /* renamed from: d */
    private C0854f f2114d;

    private C0853e() {
    }

    /* renamed from: a */
    public static C0853e m2424a() {
        if (f2111e == null) {
            synchronized (C0853e.class) {
                if (f2111e == null) {
                    f2111e = new C0853e();
                }
            }
        }
        return f2111e;
    }

    /* renamed from: f */
    private static void m2425f() {
        f2111e = null;
    }

    /* renamed from: a */
    public synchronized int mo10500a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f2112b.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e(f2110a, "addMuxerTrack error!!!");
        return -1;
    }

    /* renamed from: a */
    public boolean mo10501a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i == -1) {
            return false;
        }
        try {
            this.f2112b.writeSampleData(i, byteBuffer, bufferInfo);
            return true;
        } catch (Exception unused) {
            Log.e(f2110a, "startMuxer error!!!");
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo10502a(String str, int i, C0854f fVar) {
        if (!C0871a.m2530b(str)) {
            C0871a.m2529a(str);
        }
        try {
            this.f2112b = new MediaMuxer(str, i);
            this.f2114d = fVar;
            this.f2113c = false;
            return true;
        } catch (Exception e) {
            Log.e(f2110a, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo10503b() {
        return this.f2113c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.util.Log.e(f2110a, "startMuxer error!!!");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000e */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10504c() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            r1 = 1
            android.media.MediaMuxer r2 = r3.f2112b     // Catch:{ Exception -> 0x000e }
            r2.start()     // Catch:{ Exception -> 0x000e }
            r3.f2113c = r1     // Catch:{ Exception -> 0x000e }
            r0 = 1
            goto L_0x0015
        L_0x000c:
            r0 = move-exception
            goto L_0x0020
        L_0x000e:
            java.lang.String r1 = f2110a     // Catch:{ all -> 0x000c }
            java.lang.String r2 = "startMuxer error!!!"
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x000c }
        L_0x0015:
            com.baidu.ar.recorder.d.f r1 = r3.f2114d     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x001e
            com.baidu.ar.recorder.d.f r1 = r3.f2114d     // Catch:{ all -> 0x000c }
            r1.mo10416a(r0)     // Catch:{ all -> 0x000c }
        L_0x001e:
            monitor-exit(r3)
            return
        L_0x0020:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.recorder.p046d.C0853e.mo10504c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.util.Log.e(f2110a, "stopMuxer error!!!");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000d */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10505d() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            android.media.MediaMuxer r1 = r3.f2112b     // Catch:{ Exception -> 0x000d }
            r1.stop()     // Catch:{ Exception -> 0x000d }
            r3.f2113c = r0     // Catch:{ Exception -> 0x000d }
            r0 = 1
            goto L_0x0014
        L_0x000b:
            r0 = move-exception
            goto L_0x001f
        L_0x000d:
            java.lang.String r1 = f2110a     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "stopMuxer error!!!"
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x000b }
        L_0x0014:
            com.baidu.ar.recorder.d.f r1 = r3.f2114d     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x001d
            com.baidu.ar.recorder.d.f r1 = r3.f2114d     // Catch:{ all -> 0x000b }
            r1.mo10417b(r0)     // Catch:{ all -> 0x000b }
        L_0x001d:
            monitor-exit(r3)
            return
        L_0x001f:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.recorder.p046d.C0853e.mo10505d():void");
    }

    /* renamed from: e */
    public void mo10506e() {
        if (!this.f2113c) {
            this.f2112b.release();
            this.f2112b = null;
            m2425f();
        }
    }
}
