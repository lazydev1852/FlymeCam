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
import com.meizu.media.mzfunnysnapsdk.StickerLoader.StickerGlobalParams;
import com.meizu.media.mzfunnysnapsdk.Utils.MatrixUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class StickerAsFilter extends BaseFilter {
    private static final String TAG = "StickerAsFilter";
    public static ChangeQuickRedirect changeQuickRedirect;

    /* renamed from: h */
    private float f15606h;
    private int height = GlobalParams.DEFAULT_HEIGHT;
    private NoFilter mFilter;
    private float[] mModelMatrix = new float[16];
    private MzAdaptiveParamsArc mMzAdaptiveParams;
    private float[] mProjectMatrix = new float[16];
    private float[] mViewMatrix = new float[16];
    private float[] mvpMatrix = new float[16];
    private float[] mvpMatrix_temp = new float[16];
    float ratio;
    private int[] textures = new int[1];

    /* renamed from: w */
    private float f15607w;
    private int width = GlobalParams.DEFAULT_WIDTH;

    public StickerAsFilter(Resources resources) {
        super(resources, true);
        this.mFilter = new NoFilter(resources) {
            public static ChangeQuickRedirect changeQuickRedirect;

            public void onClear() {
            }
        };
        Log.i("FunnySnapFlow", "StickerAsFilter()");
    }

    public void changeSticker(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9154, new Class[]{String.class}, Void.TYPE).isSupported) {
            C2777StickerLoader.getInstance().selectSticker(str);
        }
    }

    public void updataStickerFilterRatio(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9155, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.ratio = ((float) i) / ((float) i2);
            this.width = i;
            this.height = i2;
            if (GlobalParams.SCREEN_ANGLE_temp == 90 || GlobalParams.SCREEN_ANGLE_temp == 270) {
                GlobalParams.WIDTH = GlobalParams.DEFAULT_HEIGHT;
                GlobalParams.HEIGHT = GlobalParams.DEFAULT_WIDTH;
            }
            if (GlobalParams.SCREEN_ANGLE_temp == 180 || GlobalParams.SCREEN_ANGLE_temp == 0) {
                GlobalParams.WIDTH = GlobalParams.DEFAULT_WIDTH;
                GlobalParams.HEIGHT = GlobalParams.DEFAULT_HEIGHT;
            }
            Matrix.frustumM(this.mProjectMatrix, 0, -this.ratio, this.ratio, -1.0f, 1.0f, 3.0f, 7.0f);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            Matrix.multiplyMM(this.mvpMatrix, 0, this.mProjectMatrix, 0, this.mViewMatrix, 0);
        }
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9156, new Class[0], Void.TYPE).isSupported) {
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
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9157, new Class[0], Void.TYPE).isSupported) {
            super.onClear();
        }
    }

    public void draw() {
        float[] fArr;
        int[] align;
        int i = 0;
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9158, new Class[0], Void.TYPE).isSupported) {
            super.draw();
            if (StickerGlobalParams.getInstance().faces_readout != null && GlobalParams.isStickerReadyToRender) {
                GLES20.glViewport(0, 0, this.width, this.height);
                FaceArcsoft.Face[] faceArr = StickerGlobalParams.getInstance().faces_readout;
                if (faceArr != null) {
                    float[] fArr2 = StickerGlobalParams.getInstance().eyesAngle;
                    if (fArr2 != null && (fArr = StickerGlobalParams.getInstance().scaleFactor) != null && (align = C2777StickerLoader.getInstance().getAlign()) != null) {
                        if (C2777StickerLoader.getInstance().mZipSticker != null) {
                            int size = C2777StickerLoader.getInstance().mZipSticker.size();
                            for (int i2 = 0; i2 < faceArr.length; i2++) {
                                for (int i3 = 0; i3 < size; i3++) {
                                    if (align[i3] == 0) {
                                        C2777StickerLoader.getInstance();
                                        setPicture(C2777StickerLoader.getInstance().mZipSticker.get(i3).bitmap.part_array.get(C2777StickerLoader.mTimerCount[i3].getFrameCurrent()));
                                        this.f15607w = (float) C2777StickerLoader.getInstance().mZipSticker.get(i3).bitmap.part_array.get(0).getWidth();
                                        this.f15606h = (float) C2777StickerLoader.getInstance().mZipSticker.get(i3).bitmap.part_array.get(0).getHeight();
                                        Matrix.setIdentityM(this.mModelMatrix, 0);
                                        AnimationPart animationPart = C2777StickerLoader.getInstance().mZipSticker.get(i3).json;
                                        FacePoint2D facePoint2D = animationPart.position_X;
                                        FacePoint2D facePoint2D2 = animationPart.position_Y;
                                        this.mMzAdaptiveParams.updateParams((faceArr[i2].points[facePoint2D.index].x + faceArr[i2].points[facePoint2D2.index].x) / 2.0f, (faceArr[i2].points[facePoint2D.index].y + faceArr[i2].points[facePoint2D2.index].y) / 2.0f, fArr2[i2], GlobalParams.SCREEN_ANGLE);
                                        Matrix.translateM(this.mModelMatrix, 0, this.mMzAdaptiveParams.location1, this.mMzAdaptiveParams.location2, 0.0f);
                                        this.mModelMatrix = MatrixUtils.rotate(this.mModelMatrix, this.mMzAdaptiveParams.rotateAngle);
                                        float f = C2777StickerLoader.getInstance().mZipSticker.get(i3).json.localScale;
                                        PointF[] anchorCenter = C2777StickerLoader.getInstance().getAnchorCenter();
                                        Matrix.translateM(this.mModelMatrix, 0, (((anchorCenter[i3].x - (this.f15607w / 2.0f)) * f) / ((float) this.width)) * 2.0f * this.ratio * fArr[i2], -((((anchorCenter[i3].y - (this.f15606h / 2.0f)) * f) / ((float) this.height)) * 2.0f * fArr[i2]), 0.0f);
                                        this.mModelMatrix = MatrixUtils.flip(this.mModelMatrix, true, true);
                                        Matrix.scaleM(this.mModelMatrix, 0, (fArr[i2] / ((float) this.width)) * this.f15607w * this.ratio * f, (fArr[i2] / ((float) this.height)) * this.f15606h * f, 1.0f);
                                        Matrix.multiplyMM(this.mvpMatrix_temp, 0, this.mvpMatrix, 0, this.mModelMatrix, 0);
                                        this.mFilter.setMatrix(this.mvpMatrix_temp);
                                        this.mFilter.draw();
                                    }
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            Matrix.setIdentityM(this.mvpMatrix_temp, 0);
            this.mvpMatrix_temp = MatrixUtils.flip(this.mvpMatrix_temp, false, true);
            if (GlobalParams.isStickerReadyToRender && C2777StickerLoader.getInstance().mZipSticker != null) {
                int size2 = C2777StickerLoader.getInstance().mZipSticker.size();
                int[] align2 = C2777StickerLoader.getInstance().getAlign();
                while (i < size2) {
                    C2777StickerLoader.getInstance();
                    int frameCurrent = C2777StickerLoader.mTimerCount[i].getFrameCurrent();
                    if (C2777StickerLoader.getInstance().mZipSticker != null && C2777StickerLoader.getInstance().mZipSticker.get(i) != null && C2777StickerLoader.getInstance().mZipSticker.get(i).bitmap != null && C2777StickerLoader.getInstance().mZipSticker.get(i).bitmap.part_array != null && C2777StickerLoader.getInstance().mZipSticker.get(i).bitmap.part_array.get(frameCurrent) != null) {
                        Bitmap bitmap = C2777StickerLoader.getInstance().mZipSticker.get(i).bitmap.part_array.get(frameCurrent);
                        setPicture(bitmap);
                        this.f15607w = (float) bitmap.getWidth();
                        this.f15606h = (float) bitmap.getHeight();
                        float f2 = this.f15606h / this.f15607w;
                        if (align2[i] != 0) {
                            this.mMzAdaptiveParams.updateAlignParams(align2[i], f2);
                            GLES20.glViewport(this.mMzAdaptiveParams.viewportParam1, this.mMzAdaptiveParams.viewportParam2, this.mMzAdaptiveParams.viewportParam3, this.mMzAdaptiveParams.viewportParam4);
                            this.mFilter.setMatrix(this.mvpMatrix_temp);
                            this.mFilter.draw();
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setStickerMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9159, new Class[]{float[].class}, Void.TYPE).isSupported) {
            this.mFilter.setMatrix(fArr);
        }
    }

    public void onSizeChanged(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9160, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.width = i;
            this.height = i2;
            GLES20.glViewport(0, 0, i, i2);
        }
    }

    private int createTextureID() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9161, new Class[0], Integer.TYPE);
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
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9162, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
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
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        this.f15607w = (float) i3;
        this.f15606h = (float) i4;
    }
}
