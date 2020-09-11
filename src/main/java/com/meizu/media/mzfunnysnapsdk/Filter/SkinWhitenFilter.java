package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.opengl.GLES20;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.arcsoft.livebroadcast.ArcSpotlightFaceAlignment;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.camera.MeizuCamera;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.nio.ByteBuffer;

public class SkinWhitenFilter extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int height = 960;
    private float intensity;
    private int mHIntensity;
    private int mTexelHeightUniformLocation;
    private int mTexelWidthUniformLocation;
    private int[] mToneCurveTexture = {-1};
    private int mToneCurveTextureUniformLocation;
    private int width = 720;

    public void onSizeChanged(int i, int i2) {
    }

    public SkinWhitenFilter(Resources resources) {
        super(resources);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9131, new Class[0], Void.TYPE).isSupported) {
            createProgramByAssetsFile("shader/base_vertex.sh", "shader/beauty/skinwhiten_fragment.frag");
            this.mToneCurveTextureUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "curve");
            this.mTexelWidthUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "texelWidthOffset");
            this.mTexelHeightUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "texelHeightOffset");
            this.mHIntensity = GLES20.glGetUniformLocation(this.mProgram, "intensity");
            GLES20.glUniform1f(this.mTexelWidthUniformLocation, 1.0f / ((float) this.width));
            GLES20.glUniform1f(this.mTexelHeightUniformLocation, 1.0f / ((float) this.height));
            GLES20.glActiveTexture(33988);
            GLES20.glGenTextures(1, this.mToneCurveTexture, 0);
            GLES20.glBindTexture(3553, this.mToneCurveTexture[0]);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            byte[] bArr = new byte[1024];
            int[] iArr = {95, 95, 96, 97, 97, 98, 99, 99, 100, 101, 101, 102, 103, 104, 104, 105, 106, 106, 107, 108, 108, 109, 110, 111, 111, 112, 113, 113, 114, 115, 115, 116, 117, 117, 118, 119, 120, 120, 121, ArcSpotlightFaceAlignment.ASL_OUTLINE_POINT_COUNT, ArcSpotlightFaceAlignment.ASL_OUTLINE_POINT_COUNT, 123, 124, 124, 125, Opcodes.IAND, 127, 127, 128, 129, 129, 130, 131, 131, 132, 133, 133, 134, 135, 136, 136, 137, 138, 138, 139, 140, 140, 141, 142, 143, 143, 144, 145, 145, 146, 147, 147, Opcodes.LCMP, Opcodes.FCMPL, Opcodes.FCMPL, 150, Opcodes.DCMPL, 152, 152, Opcodes.IFEQ, Opcodes.IFNE, Opcodes.IFNE, 155, 156, 156, 157, Opcodes.IFLE, Opcodes.IF_ICMPEQ, Opcodes.IF_ICMPEQ, Opcodes.IF_ICMPNE, Opcodes.IF_ICMPLT, Opcodes.IF_ICMPLT, Opcodes.IF_ICMPGE, Opcodes.IF_ICMPGT, Opcodes.IF_ICMPGT, 164, Opcodes.IF_ACMPEQ, Opcodes.IF_ACMPEQ, Opcodes.IF_ACMPNE, Opcodes.GOTO, 168, 168, Opcodes.RET, 170, 170, 171, 172, 172, 173, 174, 175, 175, Opcodes.ARETURN, Opcodes.RETURN, Opcodes.RETURN, Opcodes.GETSTATIC, 179, 179, 180, Opcodes.PUTFIELD, Opcodes.PUTFIELD, Opcodes.INVOKEVIRTUAL, Opcodes.INVOKESPECIAL, Opcodes.INVOKESTATIC, Opcodes.INVOKESTATIC, Opcodes.INVOKEINTERFACE, 186, 186, Opcodes.NEW, 188, 188, 189, 190, 191, 191, Opcodes.CHECKCAST, Opcodes.INSTANCEOF, Opcodes.INSTANCEOF, 194, 195, 195, 196, 197, 197, Opcodes.IFNULL, Opcodes.IFNONNULL, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 201, 202, 202, MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY, MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 216, 216, 217, 218, 218, 219, 220, 220, 221, 222, 223, 223, 224, 225, 225, 226, 227, 227, 228, 229, 229, 230, 231, 232, 232, 233, 234, 234, 235, 236, 236, 237, 238, 239, 239, 240, 241, 241, 242, 243, 243, 244, 245, 245, 246, 247, 248, 248, 249, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 251, 252, 252, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255};
            int[] iArr2 = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 23, 23, 23, 24, 24, 24, 25, 25, 25, 25, 26, 26, 27, 27, 28, 28, 28, 28, 29, 29, 30, 29, 31, 31, 31, 31, 32, 32, 33, 33, 34, 34, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39, 39, 40, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 47, 47, 48, 48, 49, 50, 51, 51, 52, 52, 53, 53, 54, 55, 55, 56, 57, 57, 58, 59, 60, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 88, 89, 90, 91, 93, 94, 95, 96, 97, 98, 100, 101, 103, 104, 105, 107, 108, 110, 111, 113, 115, 116, 118, 119, 120, ArcSpotlightFaceAlignment.ASL_OUTLINE_POINT_COUNT, 123, 125, 127, 128, 130, 132, 134, 135, 137, 139, 141, 143, 144, 146, Opcodes.LCMP, 150, 152, Opcodes.IFNE, 156, Opcodes.IFLE, Opcodes.IF_ICMPNE, Opcodes.IF_ICMPGT, Opcodes.IF_ACMPEQ, Opcodes.GOTO, Opcodes.RET, 171, 173, 175, Opcodes.GETSTATIC, 180, Opcodes.INVOKEVIRTUAL, Opcodes.INVOKEINTERFACE, Opcodes.NEW, 189, Opcodes.CHECKCAST, 194, 197, Opcodes.IFNONNULL, 201, MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, 206, 209, 211, 214, 216, 219, 221, 224, 226, 229, 232, 234, 236, 239, 241, 245, 247, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 252, 255};
            for (int i = 0; i < 256; i++) {
                int i2 = i * 4;
                bArr[i2] = (byte) iArr[i];
                bArr[i2 + 1] = (byte) iArr[i];
                bArr[i2 + 2] = (byte) iArr2[i];
                bArr[i2 + 3] = -1;
            }
            GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(bArr));
        }
    }

    public void setIntensity(float f) {
        this.intensity = f;
    }

    public void onSetExpandData() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9132, new Class[0], Void.TYPE).isSupported) {
            super.onSetExpandData();
            GLES20.glUniform1f(this.mHIntensity, this.intensity);
            if (this.mToneCurveTexture[0] != -1) {
                GLES20.glActiveTexture(33988);
                GLES20.glBindTexture(3553, this.mToneCurveTexture[0]);
                GLES20.glUniform1i(this.mToneCurveTextureUniformLocation, 4);
            }
        }
    }
}
