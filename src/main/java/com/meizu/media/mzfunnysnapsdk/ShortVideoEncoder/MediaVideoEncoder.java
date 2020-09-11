package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.util.Log;
import android.view.Surface;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;

public class MediaVideoEncoder extends MediaEncoder {
    private static final float BPP = 0.25f;
    private static final boolean DEBUG = false;
    private static final int FRAME_RATE = 25;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "MediaVideoEncoder";
    public static ChangeQuickRedirect changeQuickRedirect;
    protected static int[] recognizedFormats = {2130708361};
    private final int mHeight;
    private RenderHandler mRenderHandler = RenderHandler.createHandler(TAG);
    private Surface mSurface;
    private final int mWidth;

    public MediaVideoEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener, int i, int i2) {
        super(mediaMuxerWrapper, mediaEncoderListener);
        this.mWidth = i;
        this.mHeight = i2;
    }

    public boolean frameAvailableSoon() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9304, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.mRenderHandler.draw();
        }
        return frameAvailableSoon;
    }

    public void prepare() throws IOException {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9305, new Class[0], Void.TYPE).isSupported) {
            this.mTrackIndex = -1;
            this.mIsEOS = false;
            this.mMuxerStarted = false;
            if (selectVideoCodec(MIME_TYPE) == null) {
                Log.e(TAG, "Unable to find an appropriate codec for video/avc");
                return;
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MIME_TYPE, this.mWidth, this.mHeight);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", calcBitRate());
            createVideoFormat.setInteger("frame-rate", 25);
            createVideoFormat.setInteger("i-frame-interval", 10);
            this.mMediaCodec = MediaCodec.createEncoderByType(MIME_TYPE);
            this.mMediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mSurface = this.mMediaCodec.createInputSurface();
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

    public void setEglContext(Resources resources, EGLContext eGLContext, int i, float[] fArr, int i2, int i3, Bitmap bitmap) {
        Object[] objArr = {resources, eGLContext, new Integer(i), fArr, new Integer(i2), new Integer(i3), bitmap};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9306, new Class[]{Resources.class, EGLContext.class, Integer.TYPE, float[].class, Integer.TYPE, Integer.TYPE, Bitmap.class}, Void.TYPE).isSupported) {
            this.mRenderHandler.setEglContext(resources, eGLContext, i, this.mSurface, true, fArr, this.mWidth, this.mHeight, bitmap);
            Log.i("FunnySnapFlowVideo", "mRender - set EGL");
        }
    }

    public void setVideoAngle(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9307, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mRenderHandler.setVideoAngle(i);
            Log.i("FunnySnapFlowVideo", "MediaVideoEncoder angle : " + i);
        }
    }

    public void setWaterMarkEnable(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9308, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.mRenderHandler.setWaterMarkEnable(z);
        }
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9309, new Class[0], Void.TYPE).isSupported) {
            if (this.mSurface != null) {
                this.mSurface.release();
                this.mSurface = null;
            }
            if (this.mRenderHandler != null) {
                this.mRenderHandler.release();
                this.mRenderHandler = null;
            }
            super.release();
        }
    }

    private int calcBitRate() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9310, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int i = (int) (((float) this.mWidth) * 6.25f * ((float) this.mHeight));
        Log.i(TAG, String.format("bitrate=%5.2f[Mbps]", new Object[]{Float.valueOf((((float) i) / 1024.0f) / 1024.0f)}));
        return i;
    }

    public static final MediaCodecInfo selectVideoCodec(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 9311, new Class[]{String.class}, MediaCodecInfo.class);
        if (proxy.isSupported) {
            return (MediaCodecInfo) proxy.result;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str) && selectColorFormat(codecInfoAt, str) > 0) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    public static final int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{mediaCodecInfo, str}, (Object) null, changeQuickRedirect, true, 9312, new Class[]{MediaCodecInfo.class, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        try {
            Thread.currentThread().setPriority(10);
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Thread.currentThread().setPriority(5);
            int i2 = 0;
            while (true) {
                if (i2 >= capabilitiesForType.colorFormats.length) {
                    i = 0;
                    break;
                }
                i = capabilitiesForType.colorFormats[i2];
                if (isRecognizedViewoFormat(i)) {
                    break;
                }
                i2++;
            }
            if (i == 0) {
                Log.e(TAG, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str);
            }
            return i;
        } catch (Throwable th) {
            Thread.currentThread().setPriority(5);
            throw th;
        }
    }

    private static final boolean isRecognizedViewoFormat(int i) {
        int length = recognizedFormats != null ? recognizedFormats.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (recognizedFormats[i2] == i) {
                return true;
            }
        }
        return false;
    }

    public void signalEndOfInputStream() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9313, new Class[0], Void.TYPE).isSupported) {
            this.mMediaCodec.signalEndOfInputStream();
            this.mIsEOS = true;
        }
    }
}
