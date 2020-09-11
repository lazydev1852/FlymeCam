package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.AnimationPart;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.FacePoint2D;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FaceArcsoft;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.media.mzfunnysnapsdk.MZUtil.MzAdaptiveParamsArc;
import com.meizu.media.mzfunnysnapsdk.StickerLoader.C2777StickerLoader;
import com.meizu.media.mzfunnysnapsdk.StickerLoader.HDStickerGlobalParams;
import com.meizu.media.mzfunnysnapsdk.Utils.MatrixUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class StaticStickerAsFilter extends BaseFilter {
    private static final String TAG = "StaticStickerAsFilter";
    public static ChangeQuickRedirect changeQuickRedirect;
    private FaceArcsoft.Face[] faces_readout;

    /* renamed from: h */
    private float f15600h;
    private int height = GlobalParams.DEFAULT_HEIGHT;
    private NoFilter mFilter;
    private float[] mModelMatrix = new float[16];
    private MzAdaptiveParamsArc mMzAdaptiveParams;
    private float[] mProjectMatrix = new float[16];
    private float[] mViewMatrix = new float[16];
    private float[] mvpMatrix = new float[16];
    float[] mvpMatrix_temp = new float[16];
    float ratio;
    private int[] textures = new int[1];

    /* renamed from: w */
    private float f15601w;
    private int width = GlobalParams.DEFAULT_WIDTH;

    public StaticStickerAsFilter(Resources resources, int i, int i2, FaceArcsoft.Face[] faceArr) {
        super(resources, true);
        this.faces_readout = faceArr;
        this.width = i;
        this.height = i2;
        this.mFilter = new NoFilter(resources) {
            public static ChangeQuickRedirect changeQuickRedirect;

            public void onClear() {
            }
        };
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9140, new Class[0], Void.TYPE).isSupported) {
            createProgramByAssetsFile("shader/base_vertex.sh", "shader/base_fragment.sh");
            this.mFilter.create();
            this.mFilter.setTextureId(createTextureID());
            Matrix.setLookAtM(this.mViewMatrix, 0, 0.0f, 0.0f, -3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            GLES20.glViewport(0, 0, this.width, this.height);
            this.ratio = ((float) this.width) / ((float) this.height);
            Matrix.frustumM(this.mProjectMatrix, 0, -this.ratio, this.ratio, -1.0f, 1.0f, 3.0f, 7.0f);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            Matrix.multiplyMM(this.mvpMatrix, 0, this.mProjectMatrix, 0, this.mViewMatrix, 0);
            this.mMzAdaptiveParams = new MzAdaptiveParamsArc();
        }
    }

    public void onClear() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9141, new Class[0], Void.TYPE).isSupported) {
            super.onClear();
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9142, new Class[0], Void.TYPE).isSupported) {
            super.draw();
            GLES20.glViewport(0, 0, this.width, this.height);
            Matrix.setIdentityM(this.mvpMatrix_temp, 0);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            if (this.faces_readout != null && GlobalParams.isStickerReadyToRender) {
                Log.i("FunnySnapFlowHD", "faces_readout!=null & ReadyToRender: ture");
                GLES20.glViewport(0, 0, this.width, this.height);
                if (this.faces_readout != null) {
                    Log.i("FunnySnapFlowHD", "faces_readout not null");
                    float[] fArr = HDStickerGlobalParams.getInstance().eyesAngle;
                    float[] fArr2 = HDStickerGlobalParams.getInstance().scaleFactor;
                    int[] align = C2777StickerLoader.getInstance().getAlign();
                    if (C2777StickerLoader.getInstance().mZipSticker != null) {
                        int size = C2777StickerLoader.getInstance().mZipSticker.size();
                        for (int i = 0; i < this.faces_readout.length; i++) {
                            for (int i2 = 0; i2 < size; i2++) {
                                if (align != null && align[i2] == 0) {
                                    C2777StickerLoader.getInstance();
                                    setPicture(C2777StickerLoader.getInstance().mZipSticker.get(i2).bitmap.part_array.get(C2777StickerLoader.mTimerCount[i2].getFrameCurrent()));
                                    this.f15601w = (float) C2777StickerLoader.getInstance().mZipSticker.get(i2).bitmap.part_array.get(0).getWidth();
                                    this.f15600h = (float) C2777StickerLoader.getInstance().mZipSticker.get(i2).bitmap.part_array.get(0).getHeight();
                                    Matrix.setIdentityM(this.mModelMatrix, 0);
                                    AnimationPart animationPart = C2777StickerLoader.getInstance().mZipSticker.get(i2).json;
                                    FacePoint2D facePoint2D = animationPart.position_X;
                                    FacePoint2D facePoint2D2 = animationPart.position_Y;
                                    float f = (this.faces_readout[i].points[facePoint2D.index].x + this.faces_readout[i].points[facePoint2D2.index].x) / 2.0f;
                                    float f2 = (this.faces_readout[i].points[facePoint2D.index].y + this.faces_readout[i].points[facePoint2D2.index].y) / 2.0f;
                                    if (!(fArr2 == null || fArr == null)) {
                                        float f3 = fArr2[i] * (((float) this.width) / ((float) GlobalParams.WIDTH));
                                        this.mMzAdaptiveParams.updateHDRenderParams(f, f2, fArr[i], GlobalParams.SCREEN_ANGLE);
                                        Matrix.translateM(this.mModelMatrix, 0, this.mMzAdaptiveParams.location1, this.mMzAdaptiveParams.location2, 0.0f);
                                        this.mModelMatrix = MatrixUtils.rotate(this.mModelMatrix, this.mMzAdaptiveParams.rotateAngle);
                                        float f4 = C2777StickerLoader.getInstance().mZipSticker.get(i2).json.localScale;
                                        PointF[] anchorCenter = C2777StickerLoader.getInstance().getAnchorCenter();
                                        Matrix.translateM(this.mModelMatrix, 0, (((anchorCenter[i2].x - (this.f15601w / 2.0f)) * f4) / ((float) this.width)) * 2.0f * this.ratio * f3, -((((anchorCenter[i2].y - (this.f15600h / 2.0f)) * f4) / ((float) this.height)) * 2.0f * f3), 0.0f);
                                        this.mModelMatrix = MatrixUtils.flip(this.mModelMatrix, true, true);
                                        Matrix.scaleM(this.mModelMatrix, 0, (f3 / ((float) this.width)) * this.f15601w * this.ratio * f4, (f3 / ((float) this.height)) * this.f15600h * f4, 1.0f);
                                        Matrix.multiplyMM(this.mvpMatrix_temp, 0, this.mvpMatrix, 0, this.mModelMatrix, 0);
                                        this.mFilter.setMatrix(this.mvpMatrix_temp);
                                        this.mFilter.draw();
                                        Log.i("FunnySnapFlowHD", "draw()");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Matrix.setIdentityM(this.mvpMatrix_temp, 0);
            this.mvpMatrix_temp = MatrixUtils.flip(this.mvpMatrix_temp, false, true);
            if (GlobalParams.isStickerReadyToRender) {
                int[] align2 = C2777StickerLoader.getInstance().getAlign();
                if (C2777StickerLoader.getInstance().mZipSticker != null) {
                    int size2 = C2777StickerLoader.getInstance().mZipSticker.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        C2777StickerLoader.getInstance();
                        Bitmap bitmap = C2777StickerLoader.getInstance().mZipSticker.get(i3).bitmap.part_array.get(C2777StickerLoader.mTimerCount[i3].getFrameCurrent());
                        setPicture(bitmap);
                        this.f15601w = (float) bitmap.getWidth();
                        this.f15600h = (float) bitmap.getHeight();
                        float f5 = this.f15600h / this.f15601w;
                        switch (align2[i3]) {
                            case 1:
                                GLES20.glViewport(0, 0, this.width, this.height);
                                this.mFilter.setMatrix(this.mvpMatrix_temp);
                                this.mFilter.draw();
                                break;
                            case 2:
                                GLES20.glViewport(0, 0, this.width, (int) (((float) this.width) * f5));
                                this.mFilter.setMatrix(this.mvpMatrix_temp);
                                this.mFilter.draw();
                                break;
                            case 3:
                                int i4 = (int) (((float) this.width) * f5);
                                GLES20.glViewport(0, this.height - i4, this.width, i4);
                                this.mFilter.setMatrix(this.mvpMatrix_temp);
                                this.mFilter.draw();
                                break;
                            case 4:
                                GLES20.glViewport(0, 0, (int) (((float) this.height) / f5), this.height);
                                this.mFilter.setMatrix(this.mvpMatrix_temp);
                                this.mFilter.draw();
                                break;
                            case 5:
                                int i5 = (int) (((float) this.height) / f5);
                                GLES20.glViewport(this.width - i5, 0, i5, this.height);
                                this.mFilter.setMatrix(this.mvpMatrix_temp);
                                this.mFilter.draw();
                                break;
                        }
                    }
                }
            }
            GLES20.glDisable(3042);
            GLES20.glViewport(0, 0, this.width, this.height);
            GLES20.glDisable(3042);
            GLES20.glViewport(0, 0, this.width, this.height);
        }
    }

    public void setStickerMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9143, new Class[]{float[].class}, Void.TYPE).isSupported) {
            this.mFilter.setMatrix(fArr);
        }
    }

    public void onSizeChanged(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9144, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.width = i;
            this.height = i2;
            GLES20.glViewport(0, 0, i, i2);
        }
    }

    private void createTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9145, new Class[0], Void.TYPE).isSupported && C2777StickerLoader.getInstance().mZipSticker != null && C2777StickerLoader.getInstance().mZipSticker.get(0).bitmap.part_array.get(0) != null) {
            if (!GLES20.glIsTexture(this.textures[0])) {
                GLES20.glGenTextures(1, this.textures, 0);
            }
            GLES20.glBindTexture(3553, this.textures[0]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, C2777StickerLoader.getInstance().mZipSticker.get(0).bitmap.part_array.get(0), 0);
            GLES20.glBindTexture(3553, 0);
        }
    }

    private int createTextureID() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9146, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!GLES20.glIsTexture(this.textures[0])) {
            GLES20.glGenTextures(1, this.textures, 0);
        }
        GLES20.glBindTexture(3553, this.textures[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindTexture(3553, 0);
        return this.textures[0];
    }

    public void setPicture(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9147, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            if (!GLES20.glIsTexture(this.textures[0])) {
                GLES20.glGenTextures(1, this.textures, 0);
            }
            GLES20.glBindTexture(3553, this.textures[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, PackUtils.FIXED_BUFFER_SIZE, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            GLES20.glBindTexture(3553, 0);
            this.mFilter.setTextureId(this.textures[0]);
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        this.f15601w = (float) i3;
        this.f15600h = (float) i4;
    }
}
