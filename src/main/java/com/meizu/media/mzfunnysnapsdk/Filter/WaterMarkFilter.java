package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class WaterMarkFilter extends NoFilter {
    public static ChangeQuickRedirect changeQuickRedirect;

    /* renamed from: h */
    private int f15608h;
    private int height;
    private Bitmap mBitmap;
    private NoFilter mFilter;
    float[] mModelMatrix = new float[16];
    public float rotateAngle;
    private int[] textures = new int[1];

    /* renamed from: w */
    private int f15609w;
    private int width;

    /* renamed from: x */
    private int f15610x;

    /* renamed from: y */
    private int f15611y;

    public WaterMarkFilter(Resources resources) {
        super(resources);
        this.mFilter = new NoFilter(resources) {
            public static ChangeQuickRedirect changeQuickRedirect;

            public void onClear() {
            }
        };
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9178, new Class[0], Void.TYPE).isSupported) {
            super.onCreate();
            this.mFilter.create();
            createTexture();
            setPosition(40, 30, 90, 90);
        }
    }

    public void onClear() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9179, new Class[0], Void.TYPE).isSupported) {
            super.onClear();
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9180, new Class[0], Void.TYPE).isSupported) {
            super.draw();
            this.rotateAngle = 180.0f;
            GLES20.glViewport(this.f15610x, this.f15611y, this.f15609w == 0 ? this.mBitmap.getWidth() : this.f15609w, this.f15608h == 0 ? this.mBitmap.getHeight() : this.f15608h);
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
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9181, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.width = i;
            this.height = i2;
            this.mFilter.setSize(i, i2);
        }
    }

    public void setStickerMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9182, new Class[]{float[].class}, Void.TYPE).isSupported) {
            this.mFilter.setMatrix(fArr);
        }
    }

    public void setWaterMark(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9183, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
            }
            this.mBitmap = bitmap;
        }
    }

    private void createTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9184, new Class[0], Void.TYPE).isSupported && this.mBitmap != null) {
            GLES20.glGenTextures(1, this.textures, 0);
            GLES20.glBindTexture(3553, this.textures[0]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, this.mBitmap, 0);
            this.mFilter.setTextureId(this.textures[0]);
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        this.f15610x = i;
        this.f15611y = i2;
        this.f15609w = i3;
        this.f15608h = i4;
    }
}
