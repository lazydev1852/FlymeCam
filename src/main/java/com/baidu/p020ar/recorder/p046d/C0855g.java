package com.baidu.p020ar.recorder.p046d;

import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

/* renamed from: com.baidu.ar.recorder.d.g */
public class C0855g extends C0850b {

    /* renamed from: g */
    private static final String f2115g = "g";

    /* renamed from: h */
    private Surface f2116h;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10469a() {
        if (this.f2091f == 0) {
            this.f2091f = this.f2088c.presentationTimeUs;
        }
        this.f2088c.presentationTimeUs -= this.f2091f;
        Log.d(f2115g, "syncTimestamp mVideoEncoder = " + this.f2088c.size + "|" + this.f2088c.presentationTimeUs);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo10470a(C0851c cVar) {
        super.mo10470a(cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10507a(com.baidu.p020ar.recorder.p046d.C0852d r4, com.baidu.p020ar.recorder.p046d.C0853e r5) {
        /*
            r3 = this;
            r0 = 1
            if (r4 == 0) goto L_0x0059
            if (r5 == 0) goto L_0x0059
            r3.f2086a = r5
            java.lang.String r5 = r4.mo10490g()
            int r1 = r4.mo10488e()
            int r2 = r4.mo10489f()
            android.media.MediaFormat r5 = android.media.MediaFormat.createVideoFormat(r5, r1, r2)
            java.lang.String r1 = "color-format"
            r2 = 2130708361(0x7f000789, float:1.701803E38)
            r5.setInteger(r1, r2)
            java.lang.String r1 = "bitrate"
            int r2 = r4.mo10491h()
            r5.setInteger(r1, r2)
            java.lang.String r1 = "frame-rate"
            int r2 = r4.mo10492i()
            r5.setInteger(r1, r2)
            java.lang.String r1 = "i-frame-interval"
            int r2 = r4.mo10493j()
            r5.setInteger(r1, r2)
            java.lang.String r4 = r4.mo10490g()     // Catch:{ Exception -> 0x0055 }
            android.media.MediaCodec r4 = android.media.MediaCodec.createEncoderByType(r4)     // Catch:{ Exception -> 0x0055 }
            r3.f2087b = r4     // Catch:{ Exception -> 0x0055 }
            android.media.MediaCodec r4 = r3.f2087b     // Catch:{ Exception -> 0x0055 }
            r1 = 0
            r4.configure(r5, r1, r1, r0)     // Catch:{ Exception -> 0x0055 }
            android.media.MediaCodec r4 = r3.f2087b     // Catch:{ Exception -> 0x0055 }
            android.view.Surface r4 = r4.createInputSurface()     // Catch:{ Exception -> 0x0055 }
            r3.f2116h = r4     // Catch:{ Exception -> 0x0055 }
            r3.f2090e = r0     // Catch:{ Exception -> 0x0055 }
            goto L_0x005a
        L_0x0055:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0059:
            r0 = 0
        L_0x005a:
            com.baidu.ar.recorder.d.c r4 = r3.f2089d
            if (r4 == 0) goto L_0x0063
            com.baidu.ar.recorder.d.c r4 = r3.f2089d
            r4.mo10412a(r0)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.recorder.p046d.C0855g.mo10507a(com.baidu.ar.recorder.d.d, com.baidu.ar.recorder.d.e):void");
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo10472a(boolean z) {
        super.mo10472a(z);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo10473a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.mo10473a(z, byteBuffer, i, j);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo10474b() {
        super.mo10474b();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo10475c() {
        super.mo10475c();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo10476d() {
        super.mo10476d();
    }

    /* renamed from: e */
    public Surface mo10508e() {
        return this.f2116h;
    }
}
