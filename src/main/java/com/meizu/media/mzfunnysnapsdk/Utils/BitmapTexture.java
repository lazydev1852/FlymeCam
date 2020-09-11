package com.meizu.media.mzfunnysnapsdk.Utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class BitmapTexture {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int[] imageSize = new int[2];
    private int imageTextureId;

    public BitmapTexture loadBitmap(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9374, new Class[]{Bitmap.class}, BitmapTexture.class);
        if (proxy.isSupported) {
            return (BitmapTexture) proxy.result;
        }
        this.imageTextureId = EasyGlUtils.getTextureFromBitmap(bitmap, this.imageSize);
        return this;
    }

    public void setImageTextureId(int i) {
        this.imageTextureId = i;
    }

    public int getImageTextureId() {
        return this.imageTextureId;
    }

    public int getImageWidth() {
        return this.imageSize[0];
    }

    public int getImageHeight() {
        return this.imageSize[1];
    }

    public void destroy() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9375, new Class[0], Void.TYPE).isSupported) {
            GLES20.glDeleteTextures(1, new int[]{this.imageTextureId}, 0);
        }
    }
}
