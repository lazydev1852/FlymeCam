package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder;

import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Environment;
import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MediaMuxerWrapper {
    private static final boolean DEBUG = false;
    private static final String DIR_NAME = "AVRecSample";
    private static final String TAG = "MediaMuxerWrapper";
    public static ChangeQuickRedirect changeQuickRedirect;
    private static final SimpleDateFormat mDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    private MediaEncoder mAudioEncoder;
    private int mEncoderCount;
    private boolean mIsStarted;
    private final MediaMuxer mMediaMuxer;
    private String mOutputPath;
    private ShortVideoCallback mShortVideoallback = null;
    private int mStatredCount;
    private MediaEncoder mVideoEncoder;

    public MediaMuxerWrapper(String str) throws IOException {
        this.mOutputPath = str;
        this.mMediaMuxer = new MediaMuxer(this.mOutputPath, 0);
        this.mStatredCount = 0;
        this.mEncoderCount = 0;
        this.mIsStarted = false;
    }

    public void setCallback(ShortVideoCallback shortVideoCallback) {
        this.mShortVideoallback = shortVideoCallback;
    }

    public String getOutputPath() {
        return this.mOutputPath;
    }

    public void prepare() throws IOException {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9294, new Class[0], Void.TYPE).isSupported) {
            if (this.mVideoEncoder != null) {
                this.mVideoEncoder.prepare();
            }
            if (this.mAudioEncoder != null) {
                this.mAudioEncoder.prepare();
            }
        }
    }

    public void startRecording() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9295, new Class[0], Void.TYPE).isSupported) {
            if (this.mVideoEncoder != null) {
                this.mVideoEncoder.startRecording();
            }
            if (this.mAudioEncoder != null) {
                this.mAudioEncoder.startRecording();
            }
            if (this.mShortVideoallback != null) {
                this.mShortVideoallback.onRecordingState(0);
            }
        }
    }

    public void stopRecording() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9296, new Class[0], Void.TYPE).isSupported) {
            if (this.mVideoEncoder != null) {
                this.mVideoEncoder.stopRecording();
            }
            this.mVideoEncoder = null;
            if (this.mAudioEncoder != null) {
                this.mAudioEncoder.stopRecording();
            }
            this.mAudioEncoder = null;
            if (this.mShortVideoallback != null) {
                this.mShortVideoallback.onRecordingState(1);
            }
        }
    }

    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }

    /* access modifiers changed from: package-private */
    public void addEncoder(MediaEncoder mediaEncoder) {
        int i = 1;
        if (!PatchProxy.proxy(new Object[]{mediaEncoder}, this, changeQuickRedirect, false, 9297, new Class[]{MediaEncoder.class}, Void.TYPE).isSupported) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                if (this.mVideoEncoder == null) {
                    this.mVideoEncoder = mediaEncoder;
                } else {
                    throw new IllegalArgumentException("Video encoder already added.");
                }
            } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
                throw new IllegalArgumentException("unsupported encoder");
            } else if (this.mAudioEncoder == null) {
                this.mAudioEncoder = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            int i2 = this.mVideoEncoder != null ? 1 : 0;
            if (this.mAudioEncoder == null) {
                i = 0;
            }
            this.mEncoderCount = i2 + i;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean start() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9298, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.mStatredCount++;
        if (this.mEncoderCount > 0 && this.mStatredCount == this.mEncoderCount) {
            this.mMediaMuxer.start();
            this.mIsStarted = true;
            notifyAll();
        }
        return this.mIsStarted;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stop() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0034 }
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect     // Catch:{ all -> 0x0034 }
            r4 = 0
            r5 = 9299(0x2453, float:1.303E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0034 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0034 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            int r1 = r8.mStatredCount     // Catch:{ all -> 0x0034 }
            int r1 = r1 + -1
            r8.mStatredCount = r1     // Catch:{ all -> 0x0034 }
            int r1 = r8.mEncoderCount     // Catch:{ all -> 0x0034 }
            if (r1 <= 0) goto L_0x0032
            int r1 = r8.mStatredCount     // Catch:{ all -> 0x0034 }
            if (r1 > 0) goto L_0x0032
            android.media.MediaMuxer r1 = r8.mMediaMuxer     // Catch:{ all -> 0x0034 }
            r1.stop()     // Catch:{ all -> 0x0034 }
            android.media.MediaMuxer r1 = r8.mMediaMuxer     // Catch:{ all -> 0x0034 }
            r1.release()     // Catch:{ all -> 0x0034 }
            r8.mIsStarted = r0     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r8)
            return
        L_0x0034:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaMuxerWrapper.stop():void");
    }

    /* access modifiers changed from: package-private */
    public synchronized int addTrack(MediaFormat mediaFormat) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{mediaFormat}, this, changeQuickRedirect, false, 9300, new Class[]{MediaFormat.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        } else if (!this.mIsStarted) {
            return this.mMediaMuxer.addTrack(mediaFormat);
        } else {
            throw new IllegalStateException("muxer already started");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void writeSampleData(int r10, java.nio.ByteBuffer r11, android.media.MediaCodec.BufferInfo r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0042 }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x0042 }
            r2.<init>(r10)     // Catch:{ all -> 0x0042 }
            r3 = 0
            r1[r3] = r2     // Catch:{ all -> 0x0042 }
            r2 = 1
            r1[r2] = r11     // Catch:{ all -> 0x0042 }
            r4 = 2
            r1[r4] = r12     // Catch:{ all -> 0x0042 }
            com.meizu.savior.ChangeQuickRedirect r5 = changeQuickRedirect     // Catch:{ all -> 0x0042 }
            r6 = 0
            r7 = 9301(0x2455, float:1.3033E-41)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0042 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0042 }
            r0[r3] = r8     // Catch:{ all -> 0x0042 }
            java.lang.Class<java.nio.ByteBuffer> r3 = java.nio.ByteBuffer.class
            r0[r2] = r3     // Catch:{ all -> 0x0042 }
            java.lang.Class<android.media.MediaCodec$BufferInfo> r2 = android.media.MediaCodec.BufferInfo.class
            r0[r4] = r2     // Catch:{ all -> 0x0042 }
            java.lang.Class r8 = java.lang.Void.TYPE     // Catch:{ all -> 0x0042 }
            r2 = r9
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r0
            r7 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0037
            monitor-exit(r9)
            return
        L_0x0037:
            int r0 = r9.mStatredCount     // Catch:{ all -> 0x0042 }
            if (r0 <= 0) goto L_0x0040
            android.media.MediaMuxer r0 = r9.mMediaMuxer     // Catch:{ all -> 0x0042 }
            r0.writeSampleData(r10, r11, r12)     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r9)
            return
        L_0x0042:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaMuxerWrapper.writeSampleData(int, java.nio.ByteBuffer, android.media.MediaCodec$BufferInfo):void");
    }

    public static final File getCaptureFile(String str, String str2) {
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, changeQuickRedirect2, true, 9302, new Class[]{String.class, String.class}, File.class);
        if (proxy.isSupported) {
            return (File) proxy.result;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(str), DIR_NAME);
        Log.d(TAG, "path=" + file.toString());
        file.mkdirs();
        if (!file.canWrite()) {
            return null;
        }
        return new File(file, getDateTimeString() + str2);
    }

    private static final String getDateTimeString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9303, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return mDateTimeFormat.format(new GregorianCalendar().getTime());
    }
}
