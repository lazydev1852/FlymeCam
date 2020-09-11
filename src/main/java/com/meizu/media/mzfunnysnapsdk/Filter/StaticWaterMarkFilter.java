package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.media.mzfunnysnapsdk.Utils.MatrixUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class StaticWaterMarkFilter extends NoFilter {
    public static ChangeQuickRedirect changeQuickRedirect = null;
    private static final int sRatio = 8;
    private static final int sWaterWidth = 90;

    /* renamed from: h */
    private int f15602h;
    private int height;
    private Bitmap mBitmap;
    private NoFilter mFilter;
    private boolean mNeedFlipY;
    private float scaleFactorX;
    private int[] textures = new int[1];

    /* renamed from: w */
    private int f15603w;
    private int width;

    /* renamed from: x */
    private int f15604x;

    /* renamed from: y */
    private int f15605y;

    public StaticWaterMarkFilter(Resources resources, int i, int i2, boolean z) {
        super(resources);
        this.mFilter = new NoFilter(resources) {
            public static ChangeQuickRedirect changeQuickRedirect;

            public void onClear() {
            }
        };
        this.width = i;
        this.height = i2;
        this.mNeedFlipY = z;
        if (i < i2) {
            this.scaleFactorX = ((float) i) / 720.0f;
        } else {
            this.scaleFactorX = ((float) i2) / 720.0f;
        }
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9148, new Class[0], Void.TYPE).isSupported) {
            super.onCreate();
            this.mFilter.create();
            createTexture();
            if (this.mNeedFlipY) {
                setPosition((int) (this.scaleFactorX * 40.0f), (int) ((((float) this.height) - (this.scaleFactorX * 30.0f)) - (this.scaleFactorX * 90.0f)), (int) (this.scaleFactorX * 90.0f), (int) (this.scaleFactorX * 90.0f));
            } else {
                setPosition((int) (this.scaleFactorX * 40.0f), (int) (this.scaleFactorX * 30.0f), (int) (this.scaleFactorX * 90.0f), (int) (this.scaleFactorX * 90.0f));
            }
        }
    }

    public void onClear() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9149, new Class[0], Void.TYPE).isSupported) {
            super.onClear();
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9150, new Class[0], Void.TYPE).isSupported) {
            super.draw();
            GLES20.glViewport(this.f15604x, this.f15605y, this.f15603w == 0 ? this.mBitmap.getWidth() : this.f15603w, this.f15602h == 0 ? this.mBitmap.getHeight() : this.f15602h);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            this.mFilter.draw();
            GLES20.glDisable(3042);
            GLES20.glViewport(0, 0, this.width, this.height);
        }
    }

    public void onSizeChanged(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9151, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.width = i;
            this.height = i2;
            this.mFilter.setSize(i, i2);
        }
    }

    public void setWaterMark(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9152, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
            }
            this.mBitmap = bitmap;
        }
    }

    private void createTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9153, new Class[0], Void.TYPE).isSupported && this.mBitmap != null) {
            GLES20.glGenTextures(1, this.textures, 0);
            GLES20.glBindTexture(3553, this.textures[0]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, this.mBitmap, 0);
            if (this.mNeedFlipY) {
                MatrixUtils.flip(this.mFilter.getMatrix(), false, true);
            }
            this.mFilter.setTextureId(this.textures[0]);
        }
    }

    private void setPosition(int i, int i2, int i3, int i4) {
        this.f15604x = i;
        this.f15605y = i2;
        this.f15603w = i3;
        this.f15602h = i4;
    }
}
