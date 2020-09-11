package com.meizu.media.mzfunnysnapsdk.MZUtil;

import com.meizu.savior.ChangeQuickRedirect;

public class MzAdaptiveParamsArc {
    public static ChangeQuickRedirect changeQuickRedirect;
    public float location1 = 0.0f;
    public float location2 = 0.0f;
    public float rotateAngle;
    private float scaleOfViewCube = 1.0f;
    private float scaleOfViewCube_Type1 = 1.0f;
    public int viewportParam1 = 0;
    public int viewportParam2 = 0;
    public int viewportParam3 = 0;
    public int viewportParam4 = 0;

    public void updateParams(float f, float f2, float f3, int i) {
        int i2 = GlobalParams.WIDTH;
        int i3 = GlobalParams.HEIGHT;
        float f4 = ((float) GlobalParams.DEFAULT_WIDTH) / ((float) GlobalParams.DEFAULT_HEIGHT);
        if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
            if (GlobalParams.CameraID == 1) {
                if (i == 0) {
                    float f5 = ((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = -f5;
                    this.rotateAngle = f3 + 270.0f;
                } else if (i == 90) {
                    float f6 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = -f6;
                    this.rotateAngle = f3 + 270.0f;
                } else if (i == 180) {
                    float f7 = ((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = -f7;
                    this.rotateAngle = f3 + 270.0f;
                } else if (i == 270) {
                    float f8 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = -f8;
                    this.rotateAngle = f3 + 270.0f;
                }
            } else if (GlobalParams.CameraID != 0) {
            } else {
                if (i == 0) {
                    float f9 = ((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = f9;
                    this.rotateAngle = -(f3 + 90.0f);
                } else if (i == 90) {
                    float f10 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = f10;
                    this.rotateAngle = -(f3 + 90.0f);
                } else if (i == 180) {
                    float f11 = ((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = f11;
                    this.rotateAngle = -(f3 + 90.0f);
                } else if (i == 270) {
                    float f12 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                    this.location2 = f12;
                    this.rotateAngle = -(f3 + 90.0f);
                }
            }
        } else if (GlobalParams.FRAME_TYPE != GlobalParams.FRAME_TYPE_TWO) {
        } else {
            if (i == 0) {
                this.location1 = -(((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                this.location2 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = -f3;
            } else if (i == 90) {
                this.location1 = -(((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                this.location2 = ((f2 / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = -f3;
            } else if (i == 180) {
                this.location1 = -(((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                this.location2 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = -f3;
            } else if (i == 270) {
                this.location1 = -(((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                this.location2 = ((f2 / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = -f3;
            }
        }
    }

    public void updateAlignParams(int i, float f) {
        int i2 = GlobalParams.DEFAULT_WIDTH;
        int i3 = GlobalParams.DEFAULT_HEIGHT;
        switch (i) {
            case 1:
                this.viewportParam1 = 0;
                this.viewportParam2 = 0;
                this.viewportParam3 = i2;
                this.viewportParam4 = i3;
                return;
            case 2:
                this.viewportParam1 = 0;
                this.viewportParam2 = 0;
                this.viewportParam3 = GlobalParams.DEFAULT_WIDTH;
                this.viewportParam4 = (int) (((float) i2) * f);
                return;
            case 3:
                int i4 = (int) (((float) i2) * f);
                this.viewportParam1 = 0;
                this.viewportParam2 = i3 - i4;
                this.viewportParam3 = GlobalParams.DEFAULT_WIDTH;
                this.viewportParam4 = i4;
                return;
            case 4:
                this.viewportParam1 = 0;
                this.viewportParam2 = 0;
                this.viewportParam3 = (int) (((float) i3) / f);
                this.viewportParam4 = i3;
                return;
            case 5:
                int i5 = (int) (((float) i3) / f);
                this.viewportParam1 = i2 - i5;
                this.viewportParam2 = 0;
                this.viewportParam3 = i5;
                this.viewportParam4 = i3;
                return;
            default:
                return;
        }
    }

    public void updateHDRenderParams(float f, float f2, float f3, int i) {
        float f4 = f3;
        int i2 = i;
        int i3 = GlobalParams.WIDTH;
        int i4 = GlobalParams.HEIGHT;
        float f5 = ((float) GlobalParams.DEFAULT_WIDTH) / ((float) GlobalParams.DEFAULT_HEIGHT);
        if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
            if (GlobalParams.CameraID == 1) {
                if (i2 == 0) {
                    float f6 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f5;
                    this.location2 = -f6;
                    this.rotateAngle = f4 + 270.0f;
                } else if (i2 == 90) {
                    this.location1 = -(((((f / ((float) i3)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f5);
                    this.location2 = -(((f2 / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube);
                    this.rotateAngle = f4 + 180.0f;
                } else if (i2 == 180) {
                    float f7 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f5);
                    this.location2 = f7;
                    this.rotateAngle = f4 + 90.0f;
                } else if (i2 == 270) {
                    this.location1 = ((((f / ((float) i3)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f5;
                    this.location2 = ((f2 / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.rotateAngle = f4;
                }
            } else if (GlobalParams.CameraID != 0) {
            } else {
                if (i2 == 0) {
                    float f8 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f5;
                    this.location2 = f8;
                    this.rotateAngle = -(f4 + 90.0f);
                } else if (i2 == 90) {
                    this.location1 = ((((f / ((float) i3)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f5;
                    this.location2 = -(((f2 / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube);
                    this.rotateAngle = -(f4 + 180.0f);
                } else if (i2 == 180) {
                    float f9 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f5);
                    this.location2 = -f9;
                    this.rotateAngle = -(f4 + 270.0f);
                } else if (i2 == 270) {
                    this.location1 = -(((((f / ((float) i3)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f5);
                    this.location2 = ((f2 / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.rotateAngle = -f4;
                }
            }
        } else if (GlobalParams.FRAME_TYPE != GlobalParams.FRAME_TYPE_TWO) {
        } else {
            if (i2 == 0) {
                this.location1 = -(((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f5);
                this.location2 = ((f2 / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = -f4;
            } else if (i2 == 90) {
                float f10 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.location1 = ((((f2 / ((float) i3)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f5;
                this.location2 = f10;
                this.rotateAngle = -(f4 + 90.0f);
            } else if (i2 == 180) {
                this.location1 = ((f / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f5;
                this.location2 = -(((f2 / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube);
                this.rotateAngle = (-f4) + 180.0f;
            } else if (i2 == 270) {
                float f11 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.location1 = -(((((f2 / ((float) i3)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f5);
                this.location2 = -f11;
                this.rotateAngle = -(f4 + 270.0f);
            }
        }
    }
}
