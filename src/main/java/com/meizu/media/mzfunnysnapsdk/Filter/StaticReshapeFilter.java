package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FaceArcsoft;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.media.mzfunnysnapsdk.StickerLoader.HDStickerGlobalParams;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.HashMap;

public class StaticReshapeFilter extends BaseFilter {
    private static final float DEFAULT_EYE_RADIUS = 0.17f;
    private static final float DEFAULT_FACE_RADIUS = 0.17f;
    public static ChangeQuickRedirect changeQuickRedirect;
    private float aspectRatio;
    private float[] deltaArrayParam = {1.2f, 1.0f, 0.8f};
    private FaceArcsoft.Face[] faces_readout_reshape;
    private int height;
    private int[] leftContourPointsIndex = {6, 11, 13};
    private float mEyeRadius = 0.17f;
    private float mEyeScale;
    private float mFaceRadius;
    private float mFaceRadius_temp = 0.17f;
    private float mFaceScale;
    private final HashMap<String, Integer> mHandleMap = new HashMap<>();
    private float originFaceScale = 0.5f;
    private int preview_height = GlobalParams.HEIGHT;
    private int preview_width = GlobalParams.WIDTH;
    private int[] rightContourPointsIndex = {26, 21, 19};
    private int width;

    public StaticReshapeFilter(Resources resources, int i, int i2, FaceArcsoft.Face[] faceArr) {
        super(resources);
        this.width = i;
        this.height = i2;
        this.faces_readout_reshape = faceArr;
        this.aspectRatio = ((float) this.preview_height) / ((float) this.preview_width);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9133, new Class[0], Void.TYPE).isSupported) {
            createProgramByAssetsFile("shader/base_vertex.sh", "shader/beauty/reshape_fragment.frag");
            this.originFaceScale = (this.originFaceScale * ((float) GlobalParams.DEFAULT_WIDTH)) / 720.0f;
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9134, new Class[0], Void.TYPE).isSupported) {
            Log.i("FunnySnapFlowHD", "HD reshape draw, begin");
            if (this.faces_readout_reshape != null) {
                float f = HDStickerGlobalParams.getInstance().scaleFactor != null ? HDStickerGlobalParams.getInstance().scaleFactor[0] : 0.8f;
                if (f > 0.8f) {
                    f = 0.8f;
                }
                float f2 = ((float) this.width) / ((float) GlobalParams.WIDTH);
                float f3 = 0.17f * f;
                this.mEyeRadius = f3;
                this.mEyeScale = GlobalParams.eyesScale * f;
                this.mFaceRadius = f3;
                this.mFaceScale = (GlobalParams.faceScale / f) * f2;
                pre_draw();
                float[] fArr = {this.mFaceScale * this.deltaArrayParam[0], this.mFaceScale * this.deltaArrayParam[0], this.mFaceScale * this.deltaArrayParam[0]};
                Log.i("FunnySnapFlowHD", "deltaArray:" + this.deltaArrayParam[0]);
                if (GlobalParams.FRAME_TYPE != GlobalParams.FRAME_TYPE_ONE) {
                    int i = GlobalParams.SCREEN_ANGLE;
                    if (i == 0) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 1);
                    } else if (i == 90) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 6);
                    } else if (i == 180) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 3);
                    } else if (i == 270) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 5);
                    }
                } else if (GlobalParams.CameraID == 1) {
                    int i2 = GlobalParams.SCREEN_ANGLE;
                    if (i2 == 0) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 7);
                    } else if (i2 == 90) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 2);
                    } else if (i2 == 180) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 8);
                    } else if (i2 == 270) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 4);
                    }
                } else {
                    int i3 = GlobalParams.SCREEN_ANGLE;
                    if (i3 == 0) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 6);
                    } else if (i3 == 90) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 3);
                    } else if (i3 == 180) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 5);
                    } else if (i3 == 270) {
                        writeVariableIntoShader(fArr, this.faces_readout_reshape, 1);
                    }
                }
            }
            GLES20.glUniform1f(getHandle("faceWarpRadius"), this.mFaceRadius_temp);
            GLES20.glUniform1f(getHandle("eyeScaleRadius"), this.mEyeRadius);
            GLES20.glUniform1f(getHandle("eyeScaleFactor"), this.mEyeScale);
            GLES20.glUniform1f(getHandle("aspectRatio"), this.aspectRatio);
            Log.i("FunnySnapFlowHD", "faceWarpRadius:" + this.mFaceRadius_temp);
            onDraw();
        }
    }

    public void pre_draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9135, new Class[0], Void.TYPE).isSupported) {
            super.pre_draw();
        }
    }

    public void onDraw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9136, new Class[0], Void.TYPE).isSupported) {
            super.onDraw();
        }
    }

    public void onSizeChanged(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getHandle(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9137, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        Integer num = this.mHandleMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, str);
        if (glGetAttribLocation == -1) {
            glGetAttribLocation = GLES20.glGetUniformLocation(this.mProgram, str);
        }
        if (glGetAttribLocation != -1) {
            this.mHandleMap.put(str, Integer.valueOf(glGetAttribLocation));
            return glGetAttribLocation;
        }
        throw new IllegalStateException("Could not get attrib or uniform location for " + str);
    }

    public void writePointsIntoShader(String str, PointF pointF, int i) {
        if (!PatchProxy.proxy(new Object[]{str, pointF, new Integer(i)}, this, changeQuickRedirect, false, 9138, new Class[]{String.class, PointF.class, Integer.TYPE}, Void.TYPE).isSupported) {
            float[] fArr = new float[2];
            switch (i) {
                case 1:
                    fArr[0] = pointF.x / ((float) this.preview_width);
                    fArr[1] = pointF.y / ((float) this.preview_height);
                    break;
                case 2:
                    fArr[0] = pointF.x / ((float) this.preview_width);
                    fArr[1] = 1.0f - (pointF.y / ((float) this.preview_height));
                    break;
                case 3:
                    fArr[0] = 1.0f - (pointF.x / ((float) this.preview_width));
                    fArr[1] = 1.0f - (pointF.y / ((float) this.preview_height));
                    break;
                case 4:
                    fArr[0] = 1.0f - (pointF.x / ((float) this.preview_width));
                    fArr[1] = pointF.y / ((float) this.preview_height);
                    break;
                case 5:
                    fArr[0] = pointF.y / ((float) this.preview_width);
                    fArr[1] = 1.0f - (pointF.x / ((float) this.preview_height));
                    break;
                case 6:
                    fArr[0] = 1.0f - (pointF.y / ((float) this.preview_width));
                    fArr[1] = pointF.x / ((float) this.preview_height);
                    break;
                case 7:
                    fArr[0] = 1.0f - (pointF.y / ((float) this.preview_width));
                    fArr[1] = 1.0f - (pointF.x / ((float) this.preview_height));
                    break;
                case 8:
                    fArr[0] = pointF.y / ((float) this.preview_width);
                    fArr[1] = pointF.x / ((float) this.preview_height);
                    break;
            }
            GLES20.glUniform2fv(getHandle(str), 1, fArr, 0);
        }
    }

    public void writeVariableIntoShader(float[] fArr, FaceArcsoft.Face[] faceArr, int i) {
        Object[] objArr = {fArr, faceArr, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9139, new Class[]{float[].class, FaceArcsoft.Face[].class, Integer.TYPE}, Void.TYPE).isSupported) {
            GLES20.glUniform1i(getHandle("boolFaceScale"), 0);
            writePointsIntoShader("leftEyeCenter", faceArr[0].points[104], i);
            writePointsIntoShader("rightEyeCenter", faceArr[0].points[105], i);
        }
    }
}
