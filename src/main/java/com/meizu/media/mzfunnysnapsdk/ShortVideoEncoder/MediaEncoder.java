package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder;

import android.media.MediaCodec;
import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class MediaEncoder implements Runnable {
    private static final boolean DEBUG = false;
    protected static final int MSG_FRAME_AVAILABLE = 1;
    protected static final int MSG_STOP_RECORDING = 9;
    private static final String TAG = "MediaEncoder";
    protected static final int TIMEOUT_USEC = 10000;
    public static ChangeQuickRedirect changeQuickRedirect;
    private MediaCodec.BufferInfo mBufferInfo;
    protected volatile boolean mIsCapturing;
    protected boolean mIsEOS;
    protected final MediaEncoderListener mListener;
    protected MediaCodec mMediaCodec;
    protected boolean mMuxerStarted;
    private int mRequestDrain;
    protected volatile boolean mRequestStop;
    protected final Object mSync = new Object();
    protected int mTrackIndex;
    protected final WeakReference<MediaMuxerWrapper> mWeakMuxer;
    private long prevOutputPTSUs = 0;

    public interface MediaEncoderListener {
        void onPrepared(MediaEncoder mediaEncoder);

        void onStopped(MediaEncoder mediaEncoder);
    }

    /* access modifiers changed from: package-private */
    public abstract void prepare() throws IOException;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaEncoder(com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaMuxerWrapper r3, com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder.MediaEncoderListener r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.mSync = r0
            r0 = 0
            r2.prevOutputPTSUs = r0
            if (r4 == 0) goto L_0x0051
            if (r3 == 0) goto L_0x0049
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.mWeakMuxer = r0
            r3.addEncoder(r2)
            r2.mListener = r4
            java.lang.Object r3 = r2.mSync
            monitor-enter(r3)
            android.media.MediaCodec$BufferInfo r4 = new android.media.MediaCodec$BufferInfo     // Catch:{ all -> 0x0046 }
            r4.<init>()     // Catch:{ all -> 0x0046 }
            r2.mBufferInfo = r4     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = "FunnySnapFlowVideo"
            java.lang.String r0 = "Media Encoder"
            android.util.Log.i(r4, r0)     // Catch:{ all -> 0x0046 }
            java.lang.Thread r4 = new java.lang.Thread     // Catch:{ all -> 0x0046 }
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x0046 }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x0046 }
            r4.start()     // Catch:{ all -> 0x0046 }
            java.lang.Object r4 = r2.mSync     // Catch:{ InterruptedException -> 0x0044 }
            r4.wait()     // Catch:{ InterruptedException -> 0x0044 }
        L_0x0044:
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            return
        L_0x0046:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            throw r4
        L_0x0049:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaMuxerWrapper is null"
            r3.<init>(r4)
            throw r3
        L_0x0051:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaEncoderListener is null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder.<init>(com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaMuxerWrapper, com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder$MediaEncoderListener):void");
    }

    public String getOutputPath() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9284, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        MediaMuxerWrapper mediaMuxerWrapper = (MediaMuxerWrapper) this.mWeakMuxer.get();
        String outputPath = mediaMuxerWrapper != null ? mediaMuxerWrapper.getOutputPath() : null;
        Log.i("FunnySnapFlowVideo", "Media Encoder - getOutputPath()" + outputPath);
        return outputPath;
    }

    public boolean frameAvailableSoon() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9285, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        synchronized (this.mSync) {
            if (this.mIsCapturing) {
                if (!this.mRequestStop) {
                    this.mRequestDrain++;
                    this.mSync.notifyAll();
                    return true;
                }
            }
            Log.i("FunnySnapFlowVideo", "Media Encoder - frameAvailable false");
            return false;
        }
    }

    public void run() {
        boolean z;
        boolean z2;
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9286, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.mSync) {
                this.mRequestStop = false;
                this.mRequestDrain = 0;
                this.mSync.notify();
            }
            Log.i("FunnySnapFlowVideo", " Media Encoder - run");
            while (true) {
                synchronized (this.mSync) {
                    z = this.mRequestStop;
                    z2 = this.mRequestDrain > 0;
                    if (z2) {
                        this.mRequestDrain--;
                    }
                }
                if (z) {
                    drain();
                    signalEndOfInputStream();
                    drain();
                    release();
                    break;
                } else if (z2) {
                    drain();
                } else {
                    synchronized (this.mSync) {
                        try {
                            this.mSync.wait();
                            try {
                            } finally {
                                while (true) {
                                }
                            }
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            synchronized (this.mSync) {
                this.mRequestStop = true;
                this.mIsCapturing = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startRecording() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9287, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.mSync) {
                this.mIsCapturing = true;
                this.mRequestStop = false;
                this.mSync.notifyAll();
                Log.i("FunnySnapFlowVideo", "Media Encoder-startRecording()");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopRecording() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 9288(0x2448, float:1.3015E-41)
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.Object r0 = r8.mSync
            monitor-enter(r0)
            boolean r1 = r8.mIsCapturing     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r8.mRequestStop     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0022
            goto L_0x0033
        L_0x0022:
            java.lang.String r1 = "FunnySnapFlowVideo"
            java.lang.String r2 = "Media Encoder-stopRecording()"
            android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0035 }
            r1 = 1
            r8.mRequestStop = r1     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r8.mSync     // Catch:{ all -> 0x0035 }
            r1.notifyAll()     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder.stopRecording():void");
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9289, new Class[0], Void.TYPE).isSupported) {
            try {
                this.mListener.onStopped(this);
            } catch (Exception e) {
                Log.e(TAG, "failed onStopped", e);
            }
            Log.i("FunnySnapFlowVideo", "Media Encoder-release()");
            this.mIsCapturing = false;
            if (this.mMediaCodec != null) {
                try {
                    this.mMediaCodec.stop();
                    this.mMediaCodec.release();
                    this.mMediaCodec = null;
                } catch (Exception e2) {
                    Log.e(TAG, "failed releasing MediaCodec", e2);
                }
            }
            if (this.mMuxerStarted) {
                MediaMuxerWrapper mediaMuxerWrapper = this.mWeakMuxer != null ? (MediaMuxerWrapper) this.mWeakMuxer.get() : null;
                if (mediaMuxerWrapper != null) {
                    try {
                        mediaMuxerWrapper.stop();
                    } catch (Exception e3) {
                        Log.e(TAG, "failed stopping muxer", e3);
                    }
                }
            }
            this.mBufferInfo = null;
        }
    }

    public void signalEndOfInputStream() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9290, new Class[0], Void.TYPE).isSupported) {
            Log.i("FunnySnapFlowVideo", "Media Encoder - signal End Of InputStream");
            encode((ByteBuffer) null, 0, getPTSUs());
        }
    }

    public void encode(ByteBuffer byteBuffer, int i, long j) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i2 = i;
        Object[] objArr = {byteBuffer2, new Integer(i2), new Long(j)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9291, new Class[]{ByteBuffer.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported && this.mIsCapturing) {
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            while (this.mIsCapturing) {
                int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer3 = inputBuffers[dequeueInputBuffer];
                    byteBuffer3.clear();
                    if (byteBuffer2 != null) {
                        byteBuffer3.put(byteBuffer2);
                    }
                    if (i2 <= 0) {
                        this.mIsEOS = true;
                        this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                        return;
                    }
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
                    return;
                }
                long j2 = j;
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0084 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 9292(0x244c, float:1.3021E-41)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            android.media.MediaCodec r1 = r8.mMediaCodec
            if (r1 != 0) goto L_0x001b
            return
        L_0x001b:
            android.media.MediaCodec r1 = r8.mMediaCodec
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()
            java.lang.ref.WeakReference<com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaMuxerWrapper> r2 = r8.mWeakMuxer
            java.lang.Object r2 = r2.get()
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaMuxerWrapper r2 = (com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaMuxerWrapper) r2
            if (r2 != 0) goto L_0x0033
            java.lang.String r0 = "MediaEncoder"
            java.lang.String r1 = "muxer is unexpectedly null"
            android.util.Log.w(r0, r1)
            return
        L_0x0033:
            r3 = r1
            r1 = 0
        L_0x0035:
            boolean r4 = r8.mIsCapturing
            if (r4 == 0) goto L_0x00fc
            android.media.MediaCodec r4 = r8.mMediaCodec
            android.media.MediaCodec$BufferInfo r5 = r8.mBufferInfo
            r6 = 10000(0x2710, double:4.9407E-320)
            int r4 = r4.dequeueOutputBuffer(r5, r6)
            r5 = -1
            if (r4 != r5) goto L_0x0051
            boolean r4 = r8.mIsEOS
            if (r4 != 0) goto L_0x0035
            int r1 = r1 + 1
            r4 = 5
            if (r1 <= r4) goto L_0x0035
            goto L_0x00fc
        L_0x0051:
            r5 = -3
            if (r4 != r5) goto L_0x005b
            android.media.MediaCodec r3 = r8.mMediaCodec
            java.nio.ByteBuffer[] r3 = r3.getOutputBuffers()
            goto L_0x0035
        L_0x005b:
            r5 = -2
            if (r4 != r5) goto L_0x0094
            boolean r4 = r8.mMuxerStarted
            if (r4 != 0) goto L_0x008c
            android.media.MediaCodec r4 = r8.mMediaCodec
            android.media.MediaFormat r4 = r4.getOutputFormat()
            int r4 = r2.addTrack(r4)
            r8.mTrackIndex = r4
            r4 = 1
            r8.mMuxerStarted = r4
            boolean r4 = r2.start()
            if (r4 != 0) goto L_0x0035
            monitor-enter(r2)
        L_0x0078:
            boolean r4 = r2.isStarted()     // Catch:{ all -> 0x0089 }
            if (r4 != 0) goto L_0x0087
            r4 = 100
            r2.wait(r4)     // Catch:{ InterruptedException -> 0x0084 }
            goto L_0x0078
        L_0x0084:
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            goto L_0x00fc
        L_0x0087:
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            goto L_0x0035
        L_0x0089:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            throw r0
        L_0x008c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "format changed twice"
            r0.<init>(r1)
            throw r0
        L_0x0094:
            if (r4 >= 0) goto L_0x0097
            goto L_0x0035
        L_0x0097:
            r5 = r3[r4]
            if (r5 == 0) goto L_0x00e0
            android.media.MediaCodec$BufferInfo r6 = r8.mBufferInfo
            int r6 = r6.flags
            r6 = r6 & 2
            if (r6 == 0) goto L_0x00a7
            android.media.MediaCodec$BufferInfo r6 = r8.mBufferInfo
            r6.size = r0
        L_0x00a7:
            android.media.MediaCodec$BufferInfo r6 = r8.mBufferInfo
            int r6 = r6.size
            if (r6 == 0) goto L_0x00d0
            boolean r1 = r8.mMuxerStarted
            if (r1 == 0) goto L_0x00c8
            android.media.MediaCodec$BufferInfo r1 = r8.mBufferInfo
            long r6 = r8.getPTSUs()
            r1.presentationTimeUs = r6
            int r1 = r8.mTrackIndex
            android.media.MediaCodec$BufferInfo r6 = r8.mBufferInfo
            r2.writeSampleData(r1, r5, r6)
            android.media.MediaCodec$BufferInfo r1 = r8.mBufferInfo
            long r5 = r1.presentationTimeUs
            r8.prevOutputPTSUs = r5
            r1 = 0
            goto L_0x00d0
        L_0x00c8:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "drain:muxer hasn't started"
            r0.<init>(r1)
            throw r0
        L_0x00d0:
            android.media.MediaCodec r5 = r8.mMediaCodec
            r5.releaseOutputBuffer(r4, r0)
            android.media.MediaCodec$BufferInfo r4 = r8.mBufferInfo
            int r4 = r4.flags
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0035
            r8.mIsCapturing = r0
            goto L_0x00fc
        L_0x00e0:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " was null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder.drain():void");
    }

    public long getPTSUs() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9293, new Class[0], Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        long nanoTime = System.nanoTime() / 1000;
        return nanoTime < this.prevOutputPTSUs ? nanoTime + (this.prevOutputPTSUs - nanoTime) : nanoTime;
    }
}
