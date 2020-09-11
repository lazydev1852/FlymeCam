package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder;

import android.graphics.Point;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaEncoder;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class MzShortVideoController {
    public static ChangeQuickRedirect changeQuickRedirect;
    private final MediaEncoder.MediaEncoderListener mMediaEncoderListener = new MediaEncoder.MediaEncoderListener() {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void onPrepared(MediaEncoder mediaEncoder) {
            if (!PatchProxy.proxy(new Object[]{mediaEncoder}, this, changeQuickRedirect, false, 9321, new Class[]{MediaEncoder.class}, Void.TYPE).isSupported && (mediaEncoder instanceof MediaVideoEncoder) && MzShortVideoController.this.mTextureController != null) {
                MzShortVideoController.this.mTextureController.setVideoEncoder((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (!PatchProxy.proxy(new Object[]{mediaEncoder}, this, changeQuickRedirect, false, 9322, new Class[]{MediaEncoder.class}, Void.TYPE).isSupported && (mediaEncoder instanceof MediaVideoEncoder) && MzShortVideoController.this.mTextureController != null) {
                MzShortVideoController.this.mTextureController.setVideoEncoder((MediaVideoEncoder) null);
            }
        }
    };
    private MediaMuxerWrapper mMuxer;
    private ShortVideoCallback mShortVideoCallback = null;
    /* access modifiers changed from: private */
    public TextureController mTextureController;

    public void setTextureController(TextureController textureController) {
        this.mTextureController = textureController;
    }

    public String getSaveVideoPath() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9317, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.mMuxer == null) {
            return null;
        }
        return this.mMuxer.getOutputPath();
    }

    public void setShortVideoCallback(ShortVideoCallback shortVideoCallback) {
        this.mShortVideoCallback = shortVideoCallback;
    }

    public void setWaterMarkEnable(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9318, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.mTextureController != null) {
            this.mTextureController.setWaterMarkEnable(z);
        }
    }

    public void startRecording(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9319, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (this.mTextureController == null) {
                Log.i("FunnySnapFlow", " ShortVideoCon mTextureCon == null");
                return;
            }
            Point shortVideoDataSize = this.mTextureController.getShortVideoDataSize();
            if (shortVideoDataSize != null) {
                try {
                    this.mMuxer = new MediaMuxerWrapper(str);
                    new MediaVideoEncoder(this.mMuxer, this.mMediaEncoderListener, shortVideoDataSize.x, shortVideoDataSize.y);
                    Log.i("FunnySnapFlow", " ShortVideoCon startRecording() :  w:" + shortVideoDataSize.x + ", h:" + shortVideoDataSize.y);
                    new MediaAudioEncoder(this.mMuxer, this.mMediaEncoderListener);
                    this.mMuxer.setCallback(this.mShortVideoCallback);
                    this.mMuxer.prepare();
                    this.mTextureController.startRecord();
                    this.mMuxer.startRecording();
                } catch (Exception e) {
                    Log.e("FunnySnapFlow", " ShortVideoCon startCapture:", e);
                }
            }
        }
    }

    public void stopRecording() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9320, new Class[0], Void.TYPE).isSupported && this.mTextureController != null) {
            Log.i("FunnySnapFlow", " ShortVideoCon stopRecording()");
            if (this.mMuxer != null) {
                this.mTextureController.stopRecord();
                this.mMuxer.stopRecording();
                this.mMuxer = null;
            }
        }
    }
}
