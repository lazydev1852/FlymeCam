package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Process;
import android.util.Log;
import android.view.Surface;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaAudioEncoder extends MediaEncoder {
    /* access modifiers changed from: private */
    public static final int[] AUDIO_SOURCES = {1, 0, 5, 7, 6};
    private static final int BIT_RATE = 64000;
    private static final boolean DEBUG = false;
    public static final int FRAMES_PER_BUFFER = 25;
    private static final String MIME_TYPE = "audio/mp4a-latm";
    public static final int SAMPLES_PER_FRAME = 1024;
    private static final int SAMPLE_RATE = 44100;
    private static final String TAG = "MediaAudioEncoder";
    public static ChangeQuickRedirect changeQuickRedirect;
    private AudioThread mAudioThread = null;

    public MediaAudioEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener) {
        super(mediaMuxerWrapper, mediaEncoderListener);
    }

    public void prepare() throws IOException {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9279, new Class[0], Void.TYPE).isSupported) {
            this.mTrackIndex = -1;
            this.mIsEOS = false;
            this.mMuxerStarted = false;
            if (selectAudioCodec(MIME_TYPE) == null) {
                Log.e(TAG, "Unable to find an appropriate codec for audio/mp4a-latm");
                return;
            }
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(MIME_TYPE, SAMPLE_RATE, 1);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("channel-mask", 16);
            createAudioFormat.setInteger("bitrate", BIT_RATE);
            createAudioFormat.setInteger("channel-count", 1);
            this.mMediaCodec = MediaCodec.createEncoderByType(MIME_TYPE);
            this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mMediaCodec.start();
            if (this.mListener != null) {
                try {
                    this.mListener.onPrepared(this);
                } catch (Exception e) {
                    Log.e(TAG, "prepare:", e);
                }
            }
        }
    }

    public void startRecording() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9280, new Class[0], Void.TYPE).isSupported) {
            super.startRecording();
            if (this.mAudioThread == null) {
                this.mAudioThread = new AudioThread();
                this.mAudioThread.start();
            }
        }
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9281, new Class[0], Void.TYPE).isSupported) {
            if (this.mAudioThread != null) {
                this.mAudioThread.interrupt();
                this.mAudioThread = null;
            }
            super.release();
        }
    }

    private class AudioThread extends Thread {
        public static ChangeQuickRedirect changeQuickRedirect;

        private AudioThread() {
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9283, new Class[0], Void.TYPE).isSupported) {
                Process.setThreadPriority(-19);
                try {
                    Log.i(MediaAudioEncoder.TAG, "AudioThread first ");
                    int minBufferSize = AudioRecord.getMinBufferSize(MediaAudioEncoder.SAMPLE_RATE, 16, 2);
                    int i = 25600;
                    if (25600 < minBufferSize) {
                        i = ((minBufferSize / 1024) + 1) * 1024 * 2;
                    }
                    AudioRecord audioRecord = null;
                    for (int audioRecord2 : MediaAudioEncoder.AUDIO_SOURCES) {
                        try {
                            AudioRecord audioRecord3 = new AudioRecord(audioRecord2, MediaAudioEncoder.SAMPLE_RATE, 16, 2, i);
                            if (audioRecord3.getState() != 1) {
                                audioRecord3 = null;
                            }
                            audioRecord = audioRecord3;
                        } catch (Exception unused) {
                            audioRecord = null;
                        }
                        if (audioRecord != null) {
                            break;
                        }
                    }
                    if (audioRecord != null) {
                        try {
                            if (MediaAudioEncoder.this.mIsCapturing) {
                                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                                audioRecord.startRecording();
                                while (MediaAudioEncoder.this.mIsCapturing && !MediaAudioEncoder.this.mRequestStop && !MediaAudioEncoder.this.mIsEOS) {
                                    allocateDirect.clear();
                                    int read = audioRecord.read(allocateDirect, 1024);
                                    if (read > 0) {
                                        allocateDirect.position(read);
                                        allocateDirect.flip();
                                        MediaAudioEncoder.this.encode(allocateDirect, read, MediaAudioEncoder.this.getPTSUs());
                                        MediaAudioEncoder.this.frameAvailableSoon();
                                    }
                                }
                                MediaAudioEncoder.this.frameAvailableSoon();
                                audioRecord.stop();
                            }
                            audioRecord.release();
                        } catch (Throwable th) {
                            audioRecord.release();
                            throw th;
                        }
                    } else {
                        Log.e(MediaAudioEncoder.TAG, "failed to initialize AudioRecord");
                    }
                    Log.i(MediaAudioEncoder.TAG, "AudioThread second ");
                } catch (Exception e) {
                    Log.e(MediaAudioEncoder.TAG, "AudioThread#run", e);
                }
            }
        }
    }

    private static final MediaCodecInfo selectAudioCodec(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 9282, new Class[]{String.class}, MediaCodecInfo.class);
        if (proxy.isSupported) {
            return (MediaCodecInfo) proxy.result;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
