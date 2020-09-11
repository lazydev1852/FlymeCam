package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.MZUtil.MzFaceDetectArc;
import com.meizu.media.mzfunnysnapsdk.Utils.EasyGlUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;

public class TextureFilterMZ2 extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int[] fFrame = new int[1];
    private int[] fTexture = new int[this.fTextureSize];
    private int fTextureSize = 2;
    private int height = 0;
    private boolean isFirstDraw = true;
    private int[] mCameraTexture = new int[1];
    private float[] mCoordOM = new float[16];
    private CameraFilter mFilter;
    private SurfaceTexture mSurfaceTexture;
    private int nowTextureIndex = 0;
    private ByteBuffer tBuffer;
    private int width = 0;

    public void initBuffer() {
    }

    public TextureFilterMZ2(Resources resources) {
        super(resources);
        this.mFilter = new CameraFilter(resources);
        Log.i("FunnySnapFlow", "TextureFilterMZ2()");
    }

    public void setCoordMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9170, new Class[]{float[].class}, Void.TYPE).isSupported) {
            this.mFilter.setCoordMatrix(fArr);
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = surfaceTexture;
    }

    public SurfaceTexture getTexture() {
        return this.mSurfaceTexture;
    }

    public void setFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9171, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mFilter.setFlag(i);
        }
    }

    public void setMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9172, new Class[]{float[].class}, Void.TYPE).isSupported) {
            this.mFilter.setMatrix(fArr);
        }
    }

    public int getOutputTexture() {
        if (!this.isFirstDraw) {
            return this.fTexture[this.nowTextureIndex];
        }
        this.isFirstDraw = false;
        return this.fTexture[0];
    }

    private byte[] getTrackData(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect3, false, 9173, new Class[]{Integer.TYPE, Integer.TYPE}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        System.currentTimeMillis();
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, this.tBuffer);
        return this.tBuffer.array();
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9174, new Class[0], Void.TYPE).isSupported) {
            boolean glIsEnabled = GLES20.glIsEnabled(2929);
            if (glIsEnabled) {
                GLES20.glDisable(2929);
            }
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mCoordOM);
                this.mFilter.setCoordMatrix(this.mCoordOM);
            }
            this.mFilter.setTextureId(getTextureId());
            EasyGlUtils.bindFrameTexture(this.fFrame[0], this.fTexture[this.nowTextureIndex]);
            GLES20.glViewport(0, 0, this.width, this.height);
            this.mFilter.draw();
            if (MzFaceDetectArc.getInstance().getInitState()) {
                GLES20.glReadPixels(0, 0, this.width, this.height, 6408, 5121, this.tBuffer);
                MzFaceDetectArc.getInstance().faceDetection(this.tBuffer.array(), this.width, this.height);
            }
            GLES20.glViewport(0, 0, this.width, this.height);
            this.mFilter.draw();
            EasyGlUtils.unBindFrameBuffer();
            if (glIsEnabled) {
                GLES20.glEnable(2929);
            }
            this.nowTextureIndex ^= 1;
        }
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9175, new Class[0], Void.TYPE).isSupported) {
            this.mFilter.create();
            this.nowTextureIndex = 0;
        }
    }

    public void onSizeChanged(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, changeQuickRedirect, false, 9176, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.mFilter.setSize(i, i2);
            if (this.width != i || this.height != i2) {
                this.width = i;
                this.height = i2;
                deleteFrameBuffer();
                GLES20.glGenFramebuffers(1, this.fFrame, 0);
                EasyGlUtils.genTexturesWithParameter(this.fTextureSize, this.fTexture, 0, 6408, i, i2);
                if (this.tBuffer != null) {
                    this.tBuffer.clear();
                }
                this.tBuffer = ByteBuffer.allocate(i * i2 * 4);
            }
        }
    }

    private void deleteFrameBuffer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9177, new Class[0], Void.TYPE).isSupported) {
            GLES20.glDeleteFramebuffers(1, this.fFrame, 0);
            GLES20.glDeleteTextures(this.fTextureSize, this.fTexture, 0);
        }
    }
}
