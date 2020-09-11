package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.meizu.media.mzfunnysnapsdk.Filter.NoFilter;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.ShortVideoUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class ShortVideoFilter extends NoFilter {
    public static ChangeQuickRedirect changeQuickRedirect = null;
    private static final int sRatio = 8;
    private static final int sWaterWidth = 90;

    /* renamed from: h */
    private int f15614h;
    private int height;
    private Bitmap mBitmap;
    private final NoFilter mFilter;
    private boolean mIsWaterMark = false;

    /* renamed from: w */
    private int f15615w;
    private int width;

    /* renamed from: x */
    private int f15616x;

    /* renamed from: y */
    private int f15617y;

    public ShortVideoFilter(Resources resources) {
        super(resources);
        this.mFilter = new NoFilter(resources) {
            public static ChangeQuickRedirect changeQuickRedirect;

            public void onClear() {
            }
        };
    }

    public void setEnableWaterMark(boolean z) {
        this.mIsWaterMark = z;
    }

    public void setWaterMark(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9323, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
            }
            this.mBitmap = bitmap;
        }
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9324, new Class[0], Void.TYPE).isSupported) {
            super.onCreate();
            this.mFilter.create();
            createTexture();
        }
    }

    public void onSizeChanged(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, changeQuickRedirect, false, 9325, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.width = i;
            this.height = i2;
            float f = i < i2 ? ((float) i) / 720.0f : ((float) i2) / 720.0f;
            int i3 = (int) (f * 90.0f);
            setPosition((int) (40.0f * f), (int) (30.0f * f), i3, i3);
            this.mFilter.setSize(i, i2);
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9326, new Class[0], Void.TYPE).isSupported) {
            super.draw();
            if (this.mBitmap != null && this.mIsWaterMark) {
                GLES20.glViewport(this.f15616x, this.f15617y, this.f15615w == 0 ? this.mBitmap.getWidth() : this.f15615w, this.f15614h == 0 ? this.mBitmap.getHeight() : this.f15614h);
                GLES20.glDisable(2929);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(1, 771);
                this.mFilter.draw();
                GLES20.glDisable(3042);
                GLES20.glViewport(0, 0, this.width, this.height);
            }
        }
    }

    private void createTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9327, new Class[0], Void.TYPE).isSupported && this.mBitmap != null) {
            this.mFilter.setTextureId(new int[]{ShortVideoUtils.setPictureToTextureID(this.mBitmap)}[0]);
        }
    }

    private void setPosition(int i, int i2, int i3, int i4) {
        this.f15616x = i;
        this.f15617y = i2;
        this.f15615w = i3;
        this.f15614h = i4;
    }
}
