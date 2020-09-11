package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.Utils.EasyGlUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.nio.ByteBuffer;

public class TextureFilter extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int[] fFrame = new int[1];
    private int[] fTexture = new int[1];
    private int height = 0;
    private int[] mCameraTexture = new int[1];
    private float[] mCoordOM = new float[16];
    private CameraFilter mFilter;
    private SurfaceTexture mSurfaceTexture;
    private ByteBuffer tBuffer;
    private int width = 0;

    public void initBuffer() {
    }

    public TextureFilter(Resources resources) {
        super(resources);
        this.mFilter = new CameraFilter(resources);
        Log.i("FunnySnapFlow", "TextureFilter()");
    }

    public void setCoordMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9163, new Class[]{float[].class}, Void.TYPE).isSupported) {
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
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9164, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mFilter.setFlag(i);
        }
    }

    public void setMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9165, new Class[]{float[].class}, Void.TYPE).isSupported) {
            this.mFilter.setMatrix(fArr);
        }
    }

    public int getOutputTexture() {
        return this.fTexture[0];
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9166, new Class[0], Void.TYPE).isSupported) {
            boolean glIsEnabled = GLES20.glIsEnabled(2929);
            if (glIsEnabled) {
                GLES20.glDisable(2929);
            }
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mCoordOM);
                this.mFilter.setCoordMatrix(this.mCoordOM);
            }
            EasyGlUtils.bindFrameTexture(this.fFrame[0], this.fTexture[0]);
            GLES20.glViewport(0, 0, this.width, this.height);
            this.mFilter.setTextureId(getTextureId());
            this.mFilter.draw();
            EasyGlUtils.unBindFrameBuffer();
            if (glIsEnabled) {
                GLES20.glEnable(2929);
            }
        }
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9167, new Class[0], Void.TYPE).isSupported) {
            this.mFilter.create();
        }
    }

    public void onSizeChanged(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, changeQuickRedirect, false, 9168, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.mFilter.setSize(i, i2);
            if (this.width != i || this.height != i2) {
                this.width = i;
                this.height = i2;
                deleteFrameBuffer();
                GLES20.glGenFramebuffers(1, this.fFrame, 0);
                EasyGlUtils.genTexturesWithParameter(1, this.fTexture, 0, 6408, i, i2);
            }
        }
    }

    private void deleteFrameBuffer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9169, new Class[0], Void.TYPE).isSupported) {
            GLES20.glDeleteFramebuffers(1, this.fFrame, 0);
            GLES20.glDeleteTextures(1, this.fTexture, 0);
        }
    }
}
