package com.baidu.p020ar.audio;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.baidu.ar.audio.a */
public class C0599a {

    /* renamed from: a */
    private static final String f958a = "a";

    /* renamed from: j */
    private static volatile boolean f959j = false;

    /* renamed from: b */
    private AudioRecord f960b;

    /* renamed from: c */
    private AudioParams f961c;

    /* renamed from: d */
    private byte[] f962d = null;

    /* renamed from: e */
    private ArrayList<ByteBuffer> f963e = null;

    /* renamed from: f */
    private int f964f = 0;

    /* renamed from: g */
    private AudioCallback f965g;

    /* renamed from: h */
    private VolumeListener f966h;

    /* renamed from: i */
    private boolean f967i = false;

    /* renamed from: a */
    private void m1199a(long j) {
        if (j >= 20) {
            m1200a(false);
        } else if (C0600b.m1210a(this.f962d) != 0.0d) {
            m1200a(true);
        } else {
            return;
        }
        this.f967i = true;
    }

    /* renamed from: a */
    private void m1200a(boolean z) {
        if (this.f965g != null) {
            this.f965g.onAudioStart(z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1201e() {
        /*
            r5 = this;
            android.media.AudioRecord r0 = r5.f960b
            int r0 = r0.getState()
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x003b
            android.media.AudioRecord r0 = r5.f960b     // Catch:{ IllegalStateException -> 0x0030 }
            r0.startRecording()     // Catch:{ IllegalStateException -> 0x0030 }
            android.media.AudioRecord r0 = r5.f960b     // Catch:{ IllegalStateException -> 0x0030 }
            int r0 = r0.getRecordingState()     // Catch:{ IllegalStateException -> 0x0030 }
            r3 = 3
            if (r0 != r3) goto L_0x0019
            goto L_0x003c
        L_0x0019:
            java.lang.String r1 = f958a     // Catch:{ IllegalStateException -> 0x0030 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0030 }
            r3.<init>()     // Catch:{ IllegalStateException -> 0x0030 }
            java.lang.String r4 = "startAudioRecord state = "
            r3.append(r4)     // Catch:{ IllegalStateException -> 0x0030 }
            r3.append(r0)     // Catch:{ IllegalStateException -> 0x0030 }
            java.lang.String r0 = r3.toString()     // Catch:{ IllegalStateException -> 0x0030 }
            android.util.Log.e(r1, r0)     // Catch:{ IllegalStateException -> 0x0030 }
            goto L_0x003b
        L_0x0030:
            r0 = move-exception
            java.lang.String r1 = f958a
            java.lang.String r3 = "startAudioRecord error!!!"
            android.util.Log.e(r1, r3)
            r0.printStackTrace()
        L_0x003b:
            r1 = 0
        L_0x003c:
            f959j = r1
            if (r1 != 0) goto L_0x0043
            r5.m1200a((boolean) r2)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.audio.C0599a.m1201e():void");
    }

    /* renamed from: f */
    private void m1202f() {
        if (this.f961c.getFrameSize() > 0) {
            if (this.f963e == null) {
                this.f963e = new ArrayList<>();
                for (int i = 0; i < this.f961c.getFrameBufferCount(); i++) {
                    this.f963e.add(ByteBuffer.allocate(this.f961c.getFrameSize()));
                }
            }
            this.f964f = 0;
            if (this.f962d == null) {
                this.f962d = new byte[this.f961c.getFrameSize()];
            }
            int i2 = 0;
            while (f959j) {
                long nanoTime = System.nanoTime();
                int read = this.f960b.read(this.f962d, 0, this.f962d.length);
                if (this.f967i) {
                    ByteBuffer byteBuffer = this.f963e.get(this.f964f);
                    if (read == -3) {
                        Log.e(f958a, "Audio read error");
                    } else if (!(this.f965g == null || byteBuffer == null || byteBuffer.capacity() < read)) {
                        byteBuffer.clear();
                        byteBuffer.position(0);
                        byteBuffer.put(this.f962d, 0, read);
                        byteBuffer.flip();
                        this.f965g.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                    }
                    this.f964f++;
                    this.f964f %= this.f961c.getFrameBufferCount();
                    if (this.f966h != null) {
                        this.f966h.onRealtimeVolume((int) C0600b.m1214b(this.f962d));
                    }
                } else {
                    m1199a((long) i2);
                    i2++;
                }
            }
            this.f963e = null;
            this.f962d = null;
            try {
                this.f960b.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f965g != null) {
                this.f965g.onAudioStop(true);
            }
        }
    }

    /* renamed from: a */
    public void mo9464a() {
        m1201e();
        m1202f();
    }

    /* renamed from: a */
    public void mo9465a(AudioCallback audioCallback) {
        this.f965g = audioCallback;
    }

    /* renamed from: a */
    public void mo9466a(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.f960b = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.f961c = audioParams;
        this.f967i = false;
        if (this.f965g != null) {
            this.f965g.onAudioSetup(true);
        }
    }

    /* renamed from: a */
    public void mo9467a(VolumeListener volumeListener) {
        this.f966h = volumeListener;
    }

    /* renamed from: b */
    public void mo9468b() {
        f959j = false;
    }

    /* renamed from: c */
    public void mo9469c() {
        if (!f959j) {
            this.f960b.release();
            this.f960b = null;
            if (this.f965g != null) {
                this.f965g.onAudioRelease();
            }
            this.f965g = null;
            this.f966h = null;
        }
    }

    /* renamed from: d */
    public AudioParams mo9470d() {
        return this.f961c;
    }
}
