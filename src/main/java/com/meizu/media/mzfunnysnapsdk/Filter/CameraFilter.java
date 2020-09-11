package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class CameraFilter extends ExternalOES {
    public static ChangeQuickRedirect changeQuickRedirect;

    public CameraFilter(Resources resources) {
        super(resources);
    }

    public void initBuffer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9081, new Class[0], Void.TYPE).isSupported) {
            super.initBuffer();
            movie();
        }
    }

    public void setFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9082, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setFlag(i);
            if (getFlag() == 1) {
                cameraFront();
            } else if (getFlag() == 0) {
                cameraBack();
            }
        }
    }

    private void cameraFront() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9083, new Class[0], Void.TYPE).isSupported) {
            this.mTexBuffer.clear();
            this.mTexBuffer.put(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f});
            this.mTexBuffer.position(0);
        }
    }

    private void cameraBack() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9084, new Class[0], Void.TYPE).isSupported) {
            this.mTexBuffer.clear();
            this.mTexBuffer.put(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f});
            this.mTexBuffer.position(0);
        }
    }

    private void movie() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9085, new Class[0], Void.TYPE).isSupported) {
            this.mTexBuffer.clear();
            this.mTexBuffer.put(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f});
            this.mTexBuffer.position(0);
        }
    }
}
