package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.meizu.media.mzfunnysnapsdk.Utils.BitmapUtil;
import com.meizu.media.mzfunnysnapsdk.Utils.EasyGlUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class LookupFilter extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    private float intensity = 1.0f;
    private Bitmap mBitmap;
    private int mHIntensity;
    private int mHMaskImage;
    private int[] mastTextures = new int[1];

    public void onSizeChanged(int i, int i2) {
    }

    public LookupFilter(Resources resources) {
        super(resources);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9101, new Class[0], Void.TYPE).isSupported) {
            createProgramByAssetsFile("shader/beauty/lookup.vert", "shader/beauty/lookup.frag");
            this.mHMaskImage = GLES20.glGetUniformLocation(this.mProgram, "maskTexture");
            this.mHIntensity = GLES20.glGetUniformLocation(this.mProgram, "intensity");
            EasyGlUtils.genTexturesWithParameter(1, this.mastTextures, 0, 6408, 512, 512);
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9102, new Class[0], Void.TYPE).isSupported) {
            super.draw();
        }
    }

    public void setIntensity(float f) {
        this.intensity = f;
    }

    public void setFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9103, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i < 0 || i > 100) {
                i = 100;
            }
            this.intensity = (((float) i) / 100.0f) * Math.abs(1.2f);
        }
    }

    public void setMaskImage(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9104, new Class[]{String.class}, Void.TYPE).isSupported) {
            try {
                this.mBitmap = BitmapUtil.readZipFile(this.mRes.getAssets(), str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setMaskImage(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9105, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            this.mBitmap = bitmap;
            onSetExpandData();
        }
    }

    public void onBindTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9106, new Class[0], Void.TYPE).isSupported) {
            super.onBindTexture();
        }
    }

    public void onSetExpandData() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9107, new Class[0], Void.TYPE).isSupported) {
            super.onSetExpandData();
            GLES20.glUniform1f(this.mHIntensity, this.intensity);
            if (this.mastTextures[0] != 0) {
                GLES20.glActiveTexture(getTextureType() + 33984 + 1);
                GLES20.glBindTexture(3553, this.mastTextures[0]);
                if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
                    GLUtils.texImage2D(3553, 0, this.mBitmap, 0);
                    this.mBitmap.recycle();
                }
                GLES20.glUniform1i(this.mHMaskImage, getTextureType() + 1);
            }
        }
    }
}
