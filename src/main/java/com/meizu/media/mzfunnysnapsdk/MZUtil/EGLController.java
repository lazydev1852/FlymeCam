package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.media.mzfunnysnapsdk.Filter.BaseFilter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.IntBuffer;

public class EGLController {
    static final String TAG = "EGLController";
    public static ChangeQuickRedirect changeQuickRedirect;
    Bitmap mBitmap;
    private EGLer mEGLer = new EGLer();
    private BaseFilter mFilter;
    private int mHeight;
    String mThreadOwner;
    private int mWidth;

    public EGLController(Bitmap bitmap, BaseFilter baseFilter, String str) {
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.mThreadOwner = str;
        this.mBitmap = bitmap;
        this.mEGLer.eglInit(this.mWidth, this.mHeight);
        setFilter(baseFilter);
    }

    public void setThreadOwner(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9185, new Class[]{String.class}, Void.TYPE).isSupported) {
            Thread.currentThread().getName();
            this.mThreadOwner = str;
        }
    }

    public void setFilter(BaseFilter baseFilter) {
        if (!PatchProxy.proxy(new Object[]{baseFilter}, this, changeQuickRedirect, false, 9186, new Class[]{BaseFilter.class}, Void.TYPE).isSupported) {
            this.mFilter = baseFilter;
            if (Thread.currentThread().getName().equals(this.mThreadOwner)) {
                this.mFilter.create();
                this.mFilter.setSize(this.mWidth, this.mHeight);
            }
        }
    }

    public Bitmap getBitmap() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9187, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (this.mFilter == null || !Thread.currentThread().getName().equals(this.mThreadOwner)) {
            return null;
        }
        this.mFilter.setTextureId(createTexture(this.mBitmap));
        this.mFilter.draw();
        return convertToBitmap();
    }

    public void destroy() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9188, new Class[0], Void.TYPE).isSupported) {
            this.mEGLer.destroy();
        }
    }

    private Bitmap convertToBitmap() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9189, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        int[] iArr = new int[(this.mWidth * this.mHeight)];
        IntBuffer allocate = IntBuffer.allocate(this.mWidth * this.mHeight);
        this.mEGLer.mGL.glReadPixels(0, 0, this.mWidth, this.mHeight, 6408, 5121, allocate);
        int[] array = allocate.array();
        for (int i = 0; i < this.mHeight; i++) {
            System.arraycopy(array, this.mWidth * i, iArr, ((this.mHeight - i) - 1) * this.mWidth, this.mWidth);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(iArr));
        return createBitmap;
    }

    public void setInput(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    private int createTexture(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9190, new Class[]{Bitmap.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }
}
