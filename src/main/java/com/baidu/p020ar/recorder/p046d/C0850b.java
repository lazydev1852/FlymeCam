package com.baidu.p020ar.recorder.p046d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;

/* renamed from: com.baidu.ar.recorder.d.b */
public abstract class C0850b {

    /* renamed from: g */
    private static final String f2085g = "b";

    /* renamed from: a */
    protected C0853e f2086a;

    /* renamed from: b */
    protected MediaCodec f2087b;

    /* renamed from: c */
    protected MediaCodec.BufferInfo f2088c = new MediaCodec.BufferInfo();

    /* renamed from: d */
    protected C0851c f2089d;

    /* renamed from: e */
    protected boolean f2090e;

    /* renamed from: f */
    protected long f2091f = 0;

    /* renamed from: h */
    private int f2092h = -1;

    /* renamed from: i */
    private boolean f2093i = false;

    /* renamed from: a */
    private boolean m2388a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.f2087b.getInputBuffers()[i];
        if (byteBuffer2.capacity() < byteBuffer.capacity()) {
            return false;
        }
        byteBuffer2.position(0);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.flip();
        this.f2088c.offset = 0;
        this.f2088c.size = i2;
        this.f2088c.presentationTimeUs = j / 1000;
        return true;
    }

    /* renamed from: b */
    private void m2389b(boolean z) {
        String str;
        String str2;
        try {
            MediaCodec mediaCodec = this.f2087b;
            loop0:
            while (true) {
                ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
                while (true) {
                    int dequeueOutputBuffer = this.f2087b.dequeueOutputBuffer(this.f2088c, 10000);
                    if (dequeueOutputBuffer == -1) {
                        if (z) {
                            Log.d(f2085g, "no output available, spinning to await EOS");
                        } else {
                            return;
                        }
                    } else if (dequeueOutputBuffer == -3) {
                        break;
                    } else if (dequeueOutputBuffer == -2) {
                        if (this.f2086a.mo10503b()) {
                            str = f2085g;
                            str2 = "format changed twice!!!!";
                            break loop0;
                        }
                        MediaFormat outputFormat = this.f2087b.getOutputFormat();
                        String str3 = f2085g;
                        Log.d(str3, "encoder output format changed: " + outputFormat);
                        this.f2092h = this.f2086a.mo10500a(outputFormat);
                        this.f2093i = true;
                        if (this.f2089d != null) {
                            this.f2089d.mo10414c(this.f2093i);
                        }
                        if (this.f2090e) {
                            this.f2086a.mo10504c();
                        }
                    } else if (dequeueOutputBuffer < 0) {
                        String str4 = f2085g;
                        Log.w(str4, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer != null) {
                            if ((this.f2088c.flags & 2) != 0) {
                                Log.d(f2085g, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                                this.f2088c.size = 0;
                            }
                            if (this.f2088c.size != 0) {
                                if (this.f2086a.mo10503b()) {
                                    byteBuffer.position(this.f2088c.offset);
                                    byteBuffer.limit(this.f2088c.offset + this.f2088c.size);
                                    mo10469a();
                                    this.f2086a.mo10501a(this.f2092h, byteBuffer, this.f2088c);
                                } else {
                                    Log.d(f2085g, "drainEncoder wait for mMuxer start !!!");
                                }
                            }
                            this.f2087b.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if ((this.f2088c.flags & 4) != 0) {
                                if (z) {
                                    if (this.f2090e) {
                                        this.f2086a.mo10505d();
                                    }
                                    if (this.f2089d != null) {
                                        this.f2089d.mo10415d(true);
                                        return;
                                    }
                                    return;
                                }
                                str = f2085g;
                                str2 = "reached end of stream unexpectedly";
                            }
                        } else {
                            throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                        }
                    }
                }
                mediaCodec = this.f2087b;
            }
            Log.e(str, str2);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo10469a();

    /* renamed from: a */
    public void mo10470a(C0851c cVar) {
        this.f2089d = cVar;
    }

    /* renamed from: a */
    public void mo10472a(boolean z) {
        if (z) {
            if (this.f2086a != null && this.f2086a.mo10503b()) {
                this.f2087b.signalEndOfInputStream();
            } else if (this.f2089d != null) {
                this.f2089d.mo10415d(true);
                return;
            } else {
                return;
            }
        }
        m2389b(z);
    }

    /* renamed from: a */
    public void mo10473a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        try {
            if (!this.f2093i || this.f2092h != -1) {
                int dequeueInputBuffer = this.f2087b.dequeueInputBuffer(10000);
                if (dequeueInputBuffer < 0) {
                    Log.d(f2085g, "drainBuffer encode input buffer not available");
                } else if (z) {
                    Log.d(f2085g, "drainBuffer sending EOS to drainBufferEncoder");
                    this.f2087b.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                } else if (m2388a(dequeueInputBuffer, byteBuffer, i, j)) {
                    this.f2087b.queueInputBuffer(dequeueInputBuffer, this.f2088c.offset, this.f2088c.size, this.f2088c.presentationTimeUs, 0);
                } else {
                    return;
                }
                m2389b(z);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo10474b() {
        try {
            this.f2087b.release();
            this.f2087b = null;
            this.f2086a = null;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void mo10475c() {
        try {
            this.f2087b.stop();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void mo10476d() {
        try {
            this.f2087b.start();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (this.f2089d != null) {
            this.f2089d.mo10413b(true);
        }
    }
}
