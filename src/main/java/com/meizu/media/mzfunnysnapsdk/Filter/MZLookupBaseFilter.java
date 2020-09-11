package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.meizu.media.mzfunnysnapsdk.Utils.BitmapTexture;
import com.meizu.media.mzfunnysnapsdk.Utils.EasyGlUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MZLookupBaseFilter extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    protected BitmapTexture[] externalBitmapTextures;
    protected int[] externalTextureHandles;
    protected Bitmap[] mBitmap;
    protected String mFragPath;
    protected String mVertPath;
    protected int surfaceHeight;
    protected int surfaceWidth;
    protected int textureSize = 0;
    private int uTextureSamplerHandle;

    public MZLookupBaseFilter(Resources resources) {
        super(resources);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9110, new Class[0], Void.TYPE).isSupported) {
            this.mVertPath = "shader/base_simple.glsl";
            createProgramByAssetsFile(this.mVertPath, this.mFragPath);
            this.uTextureSamplerHandle = GLES20.glGetAttribLocation(this.mProgram, "sTexture");
            this.externalTextureHandles = new int[this.textureSize];
            for (int i = 0; i < this.textureSize; i++) {
                int[] iArr = this.externalTextureHandles;
                int i2 = this.mProgram;
                iArr[i] = GLES20.glGetUniformLocation(i2, "sTexture" + (i + 2));
            }
        }
    }

    public void onSizeChanged(int i, int i2) {
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
    }

    public void onBindTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9111, new Class[0], Void.TYPE).isSupported) {
            super.onBindTexture();
            int i = 0;
            while (i < this.textureSize) {
                int i2 = i + 1;
                EasyGlUtils.bindTexture2D(this.externalBitmapTextures[i].getImageTextureId(), 33984 + i2, this.externalTextureHandles[i], i2);
                i = i2;
            }
            EasyGlUtils.bindTexture2D(getTextureId(), 33984, this.uTextureSamplerHandle, 0);
        }
    }

    public void onSetExpandData() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9112, new Class[0], Void.TYPE).isSupported) {
            super.onSetExpandData();
        }
    }

    public void onDraw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9113, new Class[0], Void.TYPE).isSupported) {
            super.onDraw();
        }
    }
}
