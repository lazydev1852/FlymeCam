package com.baidu.p020ar.recorder.p046d;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

/* renamed from: com.baidu.ar.recorder.d.a */
public class C0849a extends C0850b {

    /* renamed from: g */
    private static final String f2083g = "a";

    /* renamed from: h */
    private long f2084h = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10469a() {
        if (this.f2091f == 0) {
            this.f2091f = this.f2088c.presentationTimeUs;
        }
        this.f2088c.presentationTimeUs -= this.f2091f;
        if (this.f2088c.presentationTimeUs < this.f2084h) {
            MediaCodec.BufferInfo bufferInfo = this.f2088c;
            long j = this.f2084h + 10000;
            this.f2084h = j;
            bufferInfo.presentationTimeUs = j;
        }
        this.f2084h = this.f2088c.presentationTimeUs;
        Log.d(f2083g, "syncTimestamp mAudioEncoder = " + this.f2088c.size + "|" + this.f2088c.presentationTimeUs);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo10470a(C0851c cVar) {
        super.mo10470a(cVar);
    }

    /* renamed from: a */
    public void mo10471a(C0852d dVar, C0853e eVar) {
        boolean z = false;
        if (!(dVar == null || eVar == null)) {
            this.f2086a = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", dVar.mo10495l());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.mo10498o());
            mediaFormat.setInteger("channel-count", dVar.mo10496m());
            mediaFormat.setInteger("bitrate", dVar.mo10497n());
            mediaFormat.setInteger("max-input-size", dVar.mo10499p());
            try {
                this.f2087b = MediaCodec.createEncoderByType(dVar.mo10495l());
                this.f2087b.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.mo10487d()) {
                    this.f2090e = true;
                } else {
                    this.f2090e = false;
                }
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f2089d != null) {
            this.f2089d.mo10412a(z);
        }
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
}
