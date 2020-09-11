package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.opengl.GLES20;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.Arrays;

public class ExternalOES extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    private float[] mCoordMatrix = Arrays.copyOf(f15599OM, 16);
    private int mHCoordMatrix;

    public void onSizeChanged(int i, int i2) {
    }

    public ExternalOES(Resources resources) {
        super(resources);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9086, new Class[0], Void.TYPE).isSupported) {
            createProgramByAssetsFile("shader/oes/externaloes_base_vertex.sh", "shader/oes/externaloes_base_fragment.sh");
            this.mHCoordMatrix = GLES20.glGetUniformLocation(this.mProgram, "vCoordMatrix");
        }
    }

    public void setCoordMatrix(float[] fArr) {
        this.mCoordMatrix = fArr;
    }

    public void onSetExpandData() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9087, new Class[0], Void.TYPE).isSupported) {
            super.onSetExpandData();
            GLES20.glUniformMatrix4fv(this.mHCoordMatrix, 1, false, this.mCoordMatrix, 0);
        }
    }

    public void onBindTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9088, new Class[0], Void.TYPE).isSupported) {
            GLES20.glActiveTexture(getTextureType() + 33984);
            GLES20.glBindTexture(36197, getTextureId());
            GLES20.glUniform1i(this.mHTexture, getTextureType());
        }
    }
}
