package com.meizu.media.camera.p070g;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.view.Surface;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.text.C3467f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000bH\u0002J,\u0010!\u001a\u00020\"2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0002J\u001a\u0010'\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010'\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0006H\u0002JH\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020%J\u0010\u00105\u001a\u00020\"2\b\u00106\u001a\u0004\u0018\u00010%J\u0006\u00107\u001a\u00020\"J\b\u00108\u001a\u00020\"H\u0002J\u0006\u00109\u001a\u00020\"J\u000e\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006="}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/HWRecorder;", "", "()V", "mABufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "mALastPts", "", "mAStartTime", "mATrackIndex", "", "mAudioEncoder", "Landroid/media/MediaCodec;", "mHasLocked", "", "mIsInitialized", "mMuxer", "Landroid/media/MediaMuxer;", "mMuxerStarted", "mRecordingPause", "<set-?>", "Landroid/view/Surface;", "mSurface", "getMSurface", "()Landroid/view/Surface;", "mVBufferInfo", "mVLastPts", "mVTrackIndex", "mVideoEncoder", "videoStartTime", "getVideoStartTime", "()J", "addTrackIndex", "encoder", "doRecord", "", "bufferInfo", "data", "", "pts", "drainEncoder", "init", "width", "height", "colorFormat", "sampleRate", "channels", "dstFilePath", "", "needSurface", "profile", "Lcom/meizu/media/camera/MzCamcorderProfileManager;", "recordImage", "image", "recordSample", "sample", "recordSurface", "release", "stop", "updateRecordingPauseStatus", "pasue", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.g.b */
public final class HWRecorder {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public static final int f10135A = 2;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public static final int f10136B = 0;
    @NotNull

    /* renamed from: C */
    private static final String f10137C = f10137C;
    @NotNull

    /* renamed from: D */
    private static final String f10138D = f10138D;

    /* renamed from: a */
    public static ChangeQuickRedirect f10139a = null;

    /* renamed from: b */
    public static final C2081a f10140b = new C2081a((DefaultConstructorMarker) null);

    /* renamed from: s */
    private static final LogUtil.C2630a f10141s = new LogUtil.C2630a("HWRecorder");

    /* renamed from: t */
    private static final long f10142t = ((long) ComponentMessageType.MSG_TYPE_ON_SHAKE);

    /* renamed from: u */
    private static final Object f10143u = new Object();

    /* renamed from: v */
    private static final int f10144v = f10144v;

    /* renamed from: w */
    private static final int f10145w = 30;

    /* renamed from: x */
    private static final int f10146x = 5;

    /* renamed from: y */
    private static final int f10147y = f10147y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public static final int f10148z = 1;

    /* renamed from: c */
    private MediaMuxer f10149c;

    /* renamed from: d */
    private MediaCodec f10150d;

    /* renamed from: e */
    private MediaCodec f10151e;

    /* renamed from: f */
    private MediaCodec.BufferInfo f10152f;

    /* renamed from: g */
    private MediaCodec.BufferInfo f10153g;

    /* renamed from: h */
    private boolean f10154h;

    /* renamed from: i */
    private long f10155i;

    /* renamed from: j */
    private long f10156j;

    /* renamed from: k */
    private long f10157k;

    /* renamed from: l */
    private long f10158l;

    /* renamed from: m */
    private int f10159m;

    /* renamed from: n */
    private int f10160n;

    /* renamed from: o */
    private volatile boolean f10161o;

    /* renamed from: p */
    private boolean f10162p;

    /* renamed from: q */
    private boolean f10163q;
    @Nullable

    /* renamed from: r */
    private Surface f10164r;

    /* renamed from: a */
    public final long mo20121a() {
        return this.f10155i;
    }

    @Nullable
    /* renamed from: b */
    public final Surface mo20125b() {
        return this.f10164r;
    }

    /* renamed from: a */
    public final void mo20124a(@NotNull byte[] bArr) {
        long j;
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f10139a, false, 4468, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bArr, "image");
            if (((int) this.f10155i) == -1) {
                this.f10155i = System.nanoTime();
                j = 0;
            } else {
                j = (System.nanoTime() - this.f10155i) / ((long) 1000);
            }
            if (j <= this.f10157k) {
                j += (this.f10157k - j) + ((long) 1000);
            }
            long j2 = j;
            this.f10157k = j2;
            m10411a(this.f10150d, this.f10152f, bArr, j2);
        }
    }

    /* renamed from: a */
    public final void mo20122a(int i, int i2, int i3, int i4, int i5, @NotNull String str, boolean z, @Nullable MzCamcorderProfileManager mVar) throws Exception {
        boolean z2;
        MediaFormat mediaFormat;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i5;
        String str2 = str;
        boolean z3 = z;
        if (!PatchProxy.proxy(new Object[]{new Integer(i6), new Integer(i7), new Integer(i8), new Integer(i4), new Integer(i9), str2, new Byte(z3 ? (byte) 1 : 0), mVar}, this, f10139a, false, 4469, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Boolean.TYPE, MzCamcorderProfileManager.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str2, "dstFilePath");
            LogUtil.m15956e(f10141s, "Recorder init start");
            if (f10140b.m10425a(f10137C) == null || f10140b.m10425a(f10138D) == null) {
                LogUtil.m15956e(f10141s, "cannot find suitable codec");
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(f10137C, i6, i7);
            if (mVar != null) {
                LogUtil.C2630a aVar = f10141s;
                LogUtil.m15956e(aVar, "videoFormat init framerate: " + mVar.mo20365d() + "profile.videoBitRate" + mVar.mo20367f());
                createVideoFormat.setInteger("frame-rate", mVar.mo20365d());
                createVideoFormat.setInteger("bitrate", mVar.mo20367f());
                if (Build.VERSION.SDK_INT >= 24) {
                    createVideoFormat.setInteger("color-range", 2);
                    z2 = true;
                    createVideoFormat.setInteger("color-standard", 1);
                    createVideoFormat.setInteger("color-transfer", 3);
                } else {
                    z2 = true;
                }
            } else {
                z2 = true;
                createVideoFormat.setInteger("bitrate", f10144v);
                createVideoFormat.setInteger("frame-rate", f10145w);
            }
            createVideoFormat.setInteger("i-frame-interval", f10146x);
            createVideoFormat.setInteger("color-format", i8);
            this.f10150d = MediaCodec.createEncoderByType(f10137C);
            MediaCodec mediaCodec = this.f10150d;
            if (mediaCodec == null) {
                C3443i.m21151a();
            }
            mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, z2 ? 1 : 0);
            if (z3) {
                LogUtil.m15956e(f10141s, "Recorder createInputSurface start");
                MediaCodec mediaCodec2 = this.f10150d;
                if (mediaCodec2 == null) {
                    C3443i.m21151a();
                }
                this.f10164r = mediaCodec2.createInputSurface();
                LogUtil.m15956e(f10141s, "Recorder createInputSurface end");
            }
            MediaCodec mediaCodec3 = this.f10150d;
            if (mediaCodec3 == null) {
                C3443i.m21151a();
            }
            mediaCodec3.start();
            if (mVar != null) {
                LogUtil.C2630a aVar2 = f10141s;
                LogUtil.m15956e(aVar2, "audioFormat init audioSampleRate: " + mVar.mo20371j() + "profile.audioChannels" + mVar.mo20372k());
                mediaFormat = MediaFormat.createAudioFormat(f10138D, mVar.mo20371j(), mVar.mo20372k());
                C3443i.m21152a((Object) mediaFormat, "MediaFormat.createAudioF…e, profile.audioChannels)");
                mediaFormat.setInteger("bitrate", mVar.mo20370i());
            } else {
                mediaFormat = MediaFormat.createAudioFormat(f10138D, i4, i9);
                C3443i.m21152a((Object) mediaFormat, "MediaFormat.createAudioF…AC, sampleRate, channels)");
                mediaFormat.setInteger("bitrate", f10147y);
            }
            mediaFormat.setInteger("aac-profile", 2);
            this.f10151e = MediaCodec.createEncoderByType(f10138D);
            MediaCodec mediaCodec4 = this.f10151e;
            if (mediaCodec4 == null) {
                C3443i.m21151a();
            }
            mediaCodec4.configure(mediaFormat, (Surface) null, (MediaCrypto) null, z2);
            MediaCodec mediaCodec5 = this.f10151e;
            if (mediaCodec5 == null) {
                C3443i.m21151a();
            }
            mediaCodec5.start();
            File file = new File(str2);
            if (file.exists() && !file.delete()) {
                LogUtil.m15956e(f10141s, "delete file failed");
            }
            this.f10149c = new MediaMuxer(str2, 0);
            this.f10161o = false;
            this.f10159m = -1;
            this.f10160n = -1;
            this.f10155i = -1;
            this.f10156j = -1;
            this.f10157k = -1;
            this.f10158l = -1;
            this.f10152f = new MediaCodec.BufferInfo();
            this.f10153g = new MediaCodec.BufferInfo();
            this.f10154h = z2;
            LogUtil.m15952c(f10141s, "Recorder initialized");
        }
    }

    /* renamed from: c */
    public final void mo20127c() {
        long j;
        if (!PatchProxy.proxy(new Object[0], this, f10139a, false, 4470, new Class[0], Void.TYPE).isSupported) {
            if (((int) this.f10155i) == -1) {
                this.f10155i = System.nanoTime();
                j = 0;
            } else {
                j = (System.nanoTime() - this.f10155i) / ((long) 1000);
            }
            if (j <= this.f10157k) {
                j += (this.f10157k - j) + ((long) 1000);
            }
            this.f10157k = j;
            MediaCodec mediaCodec = this.f10150d;
            if (mediaCodec == null) {
                C3443i.m21151a();
            }
            m10410a(mediaCodec, this.f10152f, j);
        }
    }

    /* renamed from: b */
    public final void mo20126b(@Nullable byte[] bArr) {
        long j;
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f10139a, false, 4471, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if (((int) this.f10156j) == -1) {
                this.f10156j = System.nanoTime();
                j = 0;
            } else {
                j = (System.nanoTime() - this.f10156j) / ((long) 1000);
            }
            if (j <= this.f10158l) {
                j += (this.f10158l - j) + ((long) 1000);
            }
            long j2 = j;
            this.f10158l = j2;
            MediaCodec mediaCodec = this.f10151e;
            MediaCodec.BufferInfo bufferInfo = this.f10153g;
            if (bArr == null) {
                C3443i.m21151a();
            }
            m10411a(mediaCodec, bufferInfo, bArr, j2);
        }
    }

    /* renamed from: a */
    private final void m10411a(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, byte[] bArr, long j) {
        Object[] objArr = {mediaCodec, bufferInfo, bArr, new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f10139a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4472, new Class[]{MediaCodec.class, MediaCodec.BufferInfo.class, byte[].class, Long.TYPE}, Void.TYPE).isSupported && this.f10154h) {
            if (mediaCodec == null) {
                C3443i.m21151a();
            }
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(f10142t);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                C3443i.m21152a((Object) inputBuffers, "encoder.inputBuffers");
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
            }
            m10409a(mediaCodec, bufferInfo);
        }
    }

    /* renamed from: a */
    private final void m10409a(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) {
        if (!PatchProxy.proxy(new Object[]{mediaCodec, bufferInfo}, this, f10139a, false, 4473, new Class[]{MediaCodec.class, MediaCodec.BufferInfo.class}, Void.TYPE).isSupported) {
            int i = C3443i.m21154a((Object) mediaCodec, (Object) this.f10150d) ? this.f10159m : this.f10160n;
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            C3443i.m21152a((Object) outputBuffers, "encoder.outputBuffers");
            while (true) {
                if (bufferInfo == null) {
                    C3443i.m21151a();
                }
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, f10142t);
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = mediaCodec.getOutputBuffers();
                    C3443i.m21152a((Object) outputBuffers, "encoder.outputBuffers");
                } else if (dequeueOutputBuffer == -2) {
                    i = m10408a(mediaCodec);
                } else if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer < 0) {
                        LogUtil.C2630a aVar = f10141s;
                        LogUtil.m15956e(aVar, "drainEncoder unexpected result: " + dequeueOutputBuffer);
                    } else if ((bufferInfo.flags & 2) == 0) {
                        if (bufferInfo.size != 0) {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                LogUtil.C2630a aVar2 = f10141s;
                                LogUtil.m15949b(aVar2, "drainEncoder get outputBuffer " + dequeueOutputBuffer + " was null");
                                return;
                            }
                            synchronized (f10143u) {
                                if (!this.f10161o) {
                                    try {
                                        this.f10163q = true;
                                        f10143u.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                Unit tVar = Unit.f18749a;
                            }
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            MediaMuxer mediaMuxer = this.f10149c;
                            if (mediaMuxer == null) {
                                C3443i.m21151a();
                            }
                            mediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
                        }
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        continue;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m10410a(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, long j) {
        if (!PatchProxy.proxy(new Object[]{mediaCodec, bufferInfo, new Long(j)}, this, f10139a, false, 4474, new Class[]{MediaCodec.class, MediaCodec.BufferInfo.class, Long.TYPE}, Void.TYPE).isSupported) {
            int i = C3443i.m21154a((Object) mediaCodec, (Object) this.f10150d) ? this.f10159m : this.f10160n;
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            C3443i.m21152a((Object) outputBuffers, "encoder.outputBuffers");
            while (true) {
                if (bufferInfo == null) {
                    C3443i.m21151a();
                }
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, f10142t);
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = mediaCodec.getOutputBuffers();
                    C3443i.m21152a((Object) outputBuffers, "encoder.outputBuffers");
                } else if (dequeueOutputBuffer == -2) {
                    i = m10408a(mediaCodec);
                } else if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer < 0) {
                        LogUtil.C2630a aVar = f10141s;
                        LogUtil.m15956e(aVar, "drainEncoder unexpected result: " + dequeueOutputBuffer);
                    } else if ((bufferInfo.flags & 2) == 0) {
                        if (bufferInfo.size != 0) {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                LogUtil.C2630a aVar2 = f10141s;
                                LogUtil.m15949b(aVar2, "drainEncoder get outputBuffer " + dequeueOutputBuffer + " was null");
                                return;
                            }
                            synchronized (f10143u) {
                                if (!this.f10161o) {
                                    try {
                                        this.f10163q = true;
                                        f10143u.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                Unit tVar = Unit.f18749a;
                            }
                            bufferInfo.presentationTimeUs = j;
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            MediaMuxer mediaMuxer = this.f10149c;
                            if (mediaMuxer == null) {
                                C3443i.m21151a();
                            }
                            mediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
                        }
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        continue;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final int m10408a(MediaCodec mediaCodec) {
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{mediaCodec}, this, f10139a, false, 4475, new Class[]{MediaCodec.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        synchronized (f10143u) {
            MediaFormat outputFormat = mediaCodec.getOutputFormat();
            C3443i.m21152a((Object) outputFormat, "encoder.outputFormat");
            if (f10140b.mo20130a(outputFormat) == f10148z) {
                MediaMuxer mediaMuxer = this.f10149c;
                if (mediaMuxer == null) {
                    C3443i.m21151a();
                }
                this.f10159m = mediaMuxer.addTrack(outputFormat);
                i = this.f10159m;
            } else {
                MediaMuxer mediaMuxer2 = this.f10149c;
                if (mediaMuxer2 == null) {
                    C3443i.m21151a();
                }
                this.f10160n = mediaMuxer2.addTrack(outputFormat);
                i = this.f10160n;
            }
            if (!(this.f10159m == -1 || this.f10160n == -1)) {
                MediaMuxer mediaMuxer3 = this.f10149c;
                if (mediaMuxer3 == null) {
                    C3443i.m21151a();
                }
                mediaMuxer3.start();
                this.f10161o = true;
                f10143u.notifyAll();
                LogUtil.m15952c(f10141s, "MediaMuxer has added all track, notifyAll");
            }
            Unit tVar = Unit.f18749a;
        }
        return i;
    }

    /* renamed from: a */
    public final void mo20123a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10139a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4476, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f10162p = z;
            synchronized (f10143u) {
                LogUtil.C2630a aVar = f10141s;
                LogUtil.m15942a(aVar, "recordingPause ? " + this.f10162p + ", hasLock ? " + this.f10163q);
                if (!this.f10162p && this.f10163q) {
                    f10143u.notifyAll();
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: d */
    public final void mo20128d() {
        if (!PatchProxy.proxy(new Object[0], this, f10139a, false, 4477, new Class[0], Void.TYPE).isSupported) {
            try {
                m10415h();
            } catch (Exception e) {
                LogUtil.C2630a aVar = f10141s;
                StringBuilder sb = new StringBuilder();
                sb.append("stop exception occur: ");
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    C3443i.m21151a();
                }
                sb.append(localizedMessage);
                LogUtil.m15949b(aVar, sb.toString());
            }
            if (this.f10154h) {
                LogUtil.m15952c(f10141s, "Recorder released");
            }
            this.f10154h = false;
        }
    }

    /* renamed from: h */
    private final void m10415h() throws Exception {
        if (!PatchProxy.proxy(new Object[0], this, f10139a, false, 4478, new Class[0], Void.TYPE).isSupported) {
            if (this.f10150d != null) {
                MediaCodec mediaCodec = this.f10150d;
                if (mediaCodec == null) {
                    C3443i.m21151a();
                }
                mediaCodec.stop();
                MediaCodec mediaCodec2 = this.f10150d;
                if (mediaCodec2 == null) {
                    C3443i.m21151a();
                }
                mediaCodec2.release();
                this.f10150d = null;
            }
            if (this.f10151e != null) {
                MediaCodec mediaCodec3 = this.f10151e;
                if (mediaCodec3 == null) {
                    C3443i.m21151a();
                }
                mediaCodec3.stop();
                MediaCodec mediaCodec4 = this.f10151e;
                if (mediaCodec4 == null) {
                    C3443i.m21151a();
                }
                mediaCodec4.release();
                this.f10151e = null;
            }
            if (this.f10149c != null) {
                MediaMuxer mediaMuxer = this.f10149c;
                if (mediaMuxer == null) {
                    C3443i.m21151a();
                }
                mediaMuxer.stop();
                MediaMuxer mediaMuxer2 = this.f10149c;
                if (mediaMuxer2 == null) {
                    C3443i.m21151a();
                }
                mediaMuxer2.release();
                this.f10149c = null;
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/HWRecorder$Companion;", "", "()V", "DEFAULT_BITRATE", "", "DEFAULT_BITRATE_AUDIO", "DEFAULT_FRAME_INTERVAL", "DEFAULT_FRAME_RATE", "DEFAULT_TIMEOUT", "", "MEDIA_TYPE_AUDIO", "getMEDIA_TYPE_AUDIO", "()I", "MEDIA_TYPE_UNKNOWN", "getMEDIA_TYPE_UNKNOWN", "MEDIA_TYPE_VIDEO", "getMEDIA_TYPE_VIDEO", "MIME_TYPE_AAC", "", "getMIME_TYPE_AAC", "()Ljava/lang/String;", "MIME_TYPE_AVC", "getMIME_TYPE_AVC", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "sLock", "Ljava/lang/Object;", "getCodecInfo", "Landroid/media/MediaCodecInfo;", "mimeType", "getMediaType", "format", "Landroid/media/MediaFormat;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.b$a */
    /* compiled from: HWRecorder.kt */
    public static final class C2081a {

        /* renamed from: a */
        public static ChangeQuickRedirect f10165a;

        private C2081a() {
        }

        public /* synthetic */ C2081a(DefaultConstructorMarker gVar) {
            this();
        }

        /* renamed from: a */
        public final int mo20129a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10165a, false, 4479, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : HWRecorder.f10148z;
        }

        /* renamed from: b */
        public final int mo20131b() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10165a, false, 4480, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : HWRecorder.f10135A;
        }

        /* renamed from: c */
        public final int mo20132c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10165a, false, 4481, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : HWRecorder.f10136B;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final MediaCodecInfo m10425a(String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f10165a, false, 4484, new Class[]{String.class}, MediaCodecInfo.class);
            if (proxy.isSupported) {
                return (MediaCodecInfo) proxy.result;
            }
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            C3443i.m21152a((Object) codecInfos, "mediaCodecInfos");
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                C3443i.m21152a((Object) mediaCodecInfo, "codecInfo");
                if (mediaCodecInfo.isEncoder()) {
                    for (String a : mediaCodecInfo.getSupportedTypes()) {
                        if (C3467f.m21229a(a, str, true)) {
                            return mediaCodecInfo;
                        }
                    }
                    continue;
                }
            }
            return null;
        }

        /* renamed from: a */
        public final int mo20130a(@NotNull MediaFormat mediaFormat) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{mediaFormat}, this, f10165a, false, 4485, new Class[]{MediaFormat.class}, Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            C3443i.m21155b(mediaFormat, "format");
            String string = mediaFormat.getString("mime");
            if (string == null) {
                return mo20132c();
            }
            if (C3467f.m21232b(string, "video/", false, 2, (Object) null)) {
                return mo20129a();
            }
            if (C3467f.m21232b(string, "audio/", false, 2, (Object) null)) {
                return mo20131b();
            }
            return mo20132c();
        }
    }
}
