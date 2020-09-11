package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzAdaptiveParams {
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
        if (GlobalParams.CameraID == 1) {
            if (i != 0) {
                if (i != 90) {
                    if (i != 180) {
                        if (i == 270) {
                            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                                float f5 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                                this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                                this.location2 = -f5;
                                this.rotateAngle = ((float) i) + f3;
                            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                                float f6 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                                this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                                this.location2 = f6;
                                this.rotateAngle = 180.0f - (((float) i) + f3);
                            }
                        }
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = -(((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                        this.location2 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube);
                        this.rotateAngle = ((float) i) + f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                        this.location2 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube);
                        this.rotateAngle = -(((float) i) + f3);
                    }
                } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                    float f7 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                    this.location2 = f7;
                    this.rotateAngle = ((float) i) + f3;
                } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                    float f8 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                    this.location2 = -f8;
                    this.rotateAngle = 180.0f - (((float) i) + f3);
                }
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.location1 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                this.location2 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = ((float) i) + f3;
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.location1 = -(((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                this.location2 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = -(((float) i) + f3);
            }
        } else if (GlobalParams.CameraID == 0) {
            int i4 = GlobalParams.SCREEN_ANGLE;
            if (i4 != 0) {
                if (i4 != 90) {
                    if (i4 != 180) {
                        if (i4 == 270) {
                            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                                float f9 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                                this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                                this.location2 = f9;
                                this.rotateAngle = (((float) (-i)) - f3) + 180.0f;
                            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                                float f10 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                                this.location1 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                                this.location2 = f10;
                                this.rotateAngle = (((float) (-i)) - f3) + 180.0f;
                            }
                        }
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                        this.location2 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube);
                        this.rotateAngle = ((float) (-i)) - f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                        this.location2 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube);
                        this.rotateAngle = ((float) (-i)) - f3;
                    }
                } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                    float f11 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                    this.location2 = -f11;
                    this.rotateAngle = (((float) (-i)) - f3) + 180.0f;
                } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                    float f12 = ((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                    this.location1 = -(((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                    this.location2 = -f12;
                    this.rotateAngle = (((float) (-i)) - f3) + 180.0f;
                }
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.location1 = -(((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                this.location2 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = ((float) (-i)) - f3;
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.location1 = -(((f / ((float) i2)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                this.location2 = ((f2 / ((float) i3)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                this.rotateAngle = ((float) (-i)) - f3;
            }
        }
    }

    public void updateStaticRenderParams(float f, float f2, float f3, int i, int i2, int i3) {
        Object[] objArr = {new Float(f), new Float(f2), new Float(f3), new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9227, new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            int i4 = GlobalParams.WIDTH;
            int i5 = GlobalParams.HEIGHT;
            float f4 = ((float) GlobalParams.DEFAULT_WIDTH) / ((float) GlobalParams.DEFAULT_HEIGHT);
            Log.d("mz0523", "GlobalParams.WIDTH: " + GlobalParams.WIDTH + ",GlobalParams.HEIGHT:" + GlobalParams.HEIGHT);
            if (GlobalParams.CameraID == 1) {
                Log.e("camera_direction", "front camera! ");
                if (i == 0) {
                    Log.e("camera_direction", "screenAngle: 0 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                } else if (i == 90) {
                    Log.e("camera_direction", "screenAngle: 90 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = ((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4;
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                } else if (i == 180) {
                    Log.e("camera_direction", "screenAngle: 180 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = ((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4;
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                } else if (i == 270) {
                    Log.e("camera_direction", "screenAngle: 270 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = ((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4;
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                }
            } else if (GlobalParams.CameraID == 0) {
                Log.e("camera_direction", "back camera! ");
                int i6 = GlobalParams.SCREEN_ANGLE;
                if (i6 == 0) {
                    Log.e("camera_direction", "screenAngle: 0 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = -(((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                } else if (i6 == 90) {
                    Log.e("camera_direction", "screenAngle: 90 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = -(((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                } else if (i6 == 180) {
                    Log.e("camera_direction", "screenAngle: 180 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = -(((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((f / ((float) i4)) - 0.5f) * 2.0f * this.scaleOfViewCube * f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                } else if (i6 == 270) {
                    Log.e("camera_direction", "screenAngle: 270 ");
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        this.location1 = -(((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                        this.location1 = -(((((f / ((float) i4)) - 0.5f) * 2.0f) * this.scaleOfViewCube) / f4);
                        this.location2 = ((f2 / ((float) i5)) - 0.5f) * 2.0f * this.scaleOfViewCube;
                        this.rotateAngle = -f3;
                    }
                }
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
}
