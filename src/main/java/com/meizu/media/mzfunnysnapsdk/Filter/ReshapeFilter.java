package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FaceArcsoft;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.media.mzfunnysnapsdk.StickerLoader.StickerGlobalParams;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.HashMap;

public class ReshapeFilter extends BaseFilter {
    private static final float DEFAULT_EYE_RADIUS = 0.17f;
    private static final float DEFAULT_FACE_RADIUS = 0.17f;
    private static final float EYES_RESHAPE_DEFAULT = 0.05f;
    private static final float EYES_RESHAPE_MAX = 0.25f;
    private static final float EYES_RESHAPE_MIN = 0.05f;
    private static final float FACE_RESHAPE_DEFAULT = 1.0f;
    private static final float FACE_RESHAPE_MAX = 1.0f;
    private static final float FACE_RESHAPE_MIN = 0.25f;
    public static ChangeQuickRedirect changeQuickRedirect;
    private static final float[] deltaArrayParam = {1.2f, 1.0f, 0.8f};
    private static final int[] leftContourPointsIndex = {6, 11, 13};
    private static final int[] rightContourPointsIndex = {26, 21, 19};
    private float aspectRatio = (((float) GlobalParams.DEFAULT_HEIGHT) / ((float) GlobalParams.DEFAULT_WIDTH));
    private int height;
    private float mEyeRadius;
    private float mEyeScale;
    private float mEyeScale_temp;
    private float mFaceRadius;
    private float mFaceScale;
    private final HashMap<String, Integer> mHandleMap = new HashMap<>();
    private float originFaceScale_temp;
    float[] scaleFactor = StickerGlobalParams.getInstance().scaleFactor;
    private int width;

    public ReshapeFilter(Resources resources) {
        super(resources);
        Log.i("FunnySnapFlow", "ReshapeFilter()");
    }

    public void setFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9118, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i < 0 || i > 100) {
                i = 100;
            }
            float f = ((float) i) / 100.0f;
            float abs = 1.0f - (Math.abs(0.75f) * f);
            float abs2 = (f * Math.abs(0.2f)) + 0.05f;
            Log.i("mz0424", "reshape_Flag:" + abs2 + ",faceReshapeFactor:" + abs);
            this.mEyeScale_temp = abs2;
            this.originFaceScale_temp = (abs * ((float) GlobalParams.DEFAULT_WIDTH)) / 720.0f;
            GlobalParams.eyesScale = this.mEyeScale_temp;
            GlobalParams.faceScale = this.originFaceScale_temp;
        }
    }

    public void setEyeScale(float f) {
        this.mEyeScale = f;
    }

    public void setFaceScale(float f) {
        this.mFaceScale = f;
    }

    public void updataReshapeFilterRatio(int i, int i2) {
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
        this.aspectRatio = ((float) this.height) / ((float) this.width);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9119, new Class[0], Void.TYPE).isSupported) {
            createProgramByAssetsFile("shader/base_vertex.sh", "shader/beauty/reshape_fragment.frag");
            this.width = GlobalParams.WIDTH;
            this.height = GlobalParams.HEIGHT;
            this.mEyeRadius = 0.17f;
            this.mFaceRadius = 0.17f;
            setFlag(70);
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9120, new Class[0], Void.TYPE).isSupported) {
            if (GlobalParams.faces_readout_current != null) {
                FaceArcsoft.Face[] faceArr = GlobalParams.faces_readout_current;
                if (faceArr != null) {
                    StickerGlobalParams.getInstance().updateParameters(GlobalParams.faces_readout_current);
                    float f = StickerGlobalParams.getInstance().scaleFactor != null ? StickerGlobalParams.getInstance().scaleFactor[0] : 0.8f;
                    if (f > 0.8f) {
                        f = 0.8f;
                    }
                    float f2 = 0.17f * f;
                    this.mEyeRadius = f2;
                    this.mEyeScale = this.mEyeScale_temp * f;
                    this.mFaceRadius = f2;
                    this.mFaceScale = this.originFaceScale_temp / f;
                    pre_draw();
                    float[] fArr = {this.mFaceScale * deltaArrayParam[0], this.mFaceScale * deltaArrayParam[0], this.mFaceScale * deltaArrayParam[0]};
                    if (GlobalParams.FRAME_TYPE != GlobalParams.FRAME_TYPE_ONE) {
                        int i = GlobalParams.SCREEN_ANGLE;
                        if (i == 0) {
                            writeVariableIntoShader(fArr, faceArr, 1);
                        } else if (i == 90) {
                            writeVariableIntoShader(fArr, faceArr, 1);
                        } else if (i == 180) {
                            writeVariableIntoShader(fArr, faceArr, 1);
                        } else if (i == 270) {
                            writeVariableIntoShader(fArr, faceArr, 1);
                        }
                    } else if (GlobalParams.CameraID == 1) {
                        int i2 = GlobalParams.SCREEN_ANGLE;
                        if (i2 == 0) {
                            writeVariableIntoShader(fArr, faceArr, 7);
                        } else if (i2 == 90) {
                            writeVariableIntoShader(fArr, faceArr, 7);
                        } else if (i2 == 180) {
                            writeVariableIntoShader(fArr, faceArr, 7);
                        } else if (i2 == 270) {
                            writeVariableIntoShader(fArr, faceArr, 7);
                        }
                    } else {
                        int i3 = GlobalParams.SCREEN_ANGLE;
                        if (i3 == 0) {
                            writeVariableIntoShader(fArr, faceArr, 6);
                        } else if (i3 == 90) {
                            writeVariableIntoShader(fArr, faceArr, 6);
                        } else if (i3 == 180) {
                            writeVariableIntoShader(fArr, faceArr, 6);
                        } else if (i3 == 270) {
                            writeVariableIntoShader(fArr, faceArr, 6);
                        }
                    }
                }
                GLES20.glUniform1f(getHandle("faceWarpRadius"), this.mFaceRadius);
                GLES20.glUniform1f(getHandle("eyeScaleRadius"), this.mEyeRadius);
                GLES20.glUniform1f(getHandle("eyeScaleFactor"), this.mEyeScale);
                GLES20.glUniform1f(getHandle("aspectRatio"), this.aspectRatio);
                onDraw();
                return;
            }
            StickerGlobalParams.getInstance().updateParameters((FaceArcsoft.Face[]) null);
        }
    }

    public void pre_draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9121, new Class[0], Void.TYPE).isSupported) {
            super.pre_draw();
        }
    }

    public void onDraw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9122, new Class[0], Void.TYPE).isSupported) {
            super.onDraw();
        }
    }

    public void onSizeChanged(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getHandle(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9123, new Class[]{String.class}, Integer.TYPE);
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
        if (!PatchProxy.proxy(new Object[]{str, pointF, new Integer(i)}, this, changeQuickRedirect, false, 9124, new Class[]{String.class, PointF.class, Integer.TYPE}, Void.TYPE).isSupported) {
            float[] fArr = new float[2];
            switch (i) {
                case 1:
                    fArr[0] = pointF.x / ((float) this.width);
                    fArr[1] = pointF.y / ((float) this.height);
                    break;
                case 2:
                    fArr[0] = 1.0f - (pointF.x / ((float) this.width));
                    fArr[1] = pointF.y / ((float) this.height);
                    break;
                case 3:
                    fArr[0] = 1.0f - (pointF.x / ((float) this.width));
                    fArr[1] = 1.0f - (pointF.y / ((float) this.height));
                    break;
                case 4:
                    fArr[0] = pointF.x / ((float) this.width);
                    fArr[1] = 1.0f - (pointF.y / ((float) this.height));
                    break;
                case 5:
                    fArr[0] = pointF.y / ((float) this.width);
                    fArr[1] = pointF.x / ((float) this.height);
                    break;
                case 6:
                    fArr[0] = 1.0f - (pointF.y / ((float) this.width));
                    fArr[1] = pointF.x / ((float) this.height);
                    break;
                case 7:
                    fArr[0] = 1.0f - (pointF.y / ((float) this.width));
                    fArr[1] = 1.0f - (pointF.x / ((float) this.height));
                    break;
                case 8:
                    fArr[0] = pointF.y / ((float) this.width);
                    fArr[1] = 1.0f - (pointF.x / ((float) this.height));
                    break;
            }
            GLES20.glUniform2fv(getHandle(str), 1, fArr, 0);
        }
    }

    public void writeVariableIntoShader(float[] fArr, FaceArcsoft.Face[] faceArr, int i) {
        Object[] objArr = {fArr, faceArr, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9125, new Class[]{float[].class, FaceArcsoft.Face[].class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (GlobalParams.BEAUTY_QUALITY == GlobalParams.BEAUTY_QUALITY_HIGH) {
                for (int i2 = 0; i2 < leftContourPointsIndex.length; i2++) {
                    GLES20.glUniform1i(getHandle("boolFaceScale"), 1);
                    writePointsIntoShader("leftContourPoints_vec[" + i2 + "]", faceArr[0].points[leftContourPointsIndex[i2]], i);
                    writePointsIntoShader("rightContourPoints_vec[" + i2 + "]", faceArr[0].points[rightContourPointsIndex[i2]], i);
                    int i3 = this.mProgram;
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(i3, "deltaArray[" + i2 + "]"), fArr[i2]);
                }
            } else {
                GLES20.glUniform1i(getHandle("boolFaceScale"), 0);
            }
            writePointsIntoShader("leftEyeCenter", faceArr[0].points[104], i);
            writePointsIntoShader("rightEyeCenter", faceArr[0].points[105], i);
        }
    }
}
