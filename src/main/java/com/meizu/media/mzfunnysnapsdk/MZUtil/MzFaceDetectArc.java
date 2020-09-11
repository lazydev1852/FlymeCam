package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.graphics.PointF;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.arcsoft.livebroadcast.ArcSpotlightFaceAlignment;
import com.arcsoft.livebroadcast.ArcSpotlightFaceInfo;
import com.arcsoft.livebroadcast.ArcSpotlightFaceStatus;
import com.arcsoft.livebroadcast.ArcSpotlightOffscreen;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FaceArcsoft;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class MzFaceDetectArc {
    public static ChangeQuickRedirect changeQuickRedirect = null;
    private static MzFaceDetectArc instance = null;
    private static final int mFaceScale = 8;
    private ArcSpotlightFaceAlignment arcSpotlightFacAlignment = null;
    private ArcSpotlightFaceInfo arcSpotlightFaceInfo = null;
    private ArcSpotlightFaceStatus arcSpotlightFaceStatus;
    public int cameraHeight = 960;
    public int cameraWidth = 720;
    private String faceModelFullPath;
    public FaceArcsoft.Face[] faces;
    private boolean mFirstInitFlag = false;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("funnysnap face thread");
    /* access modifiers changed from: private */
    public boolean mIsInitFaceDetect = false;
    /* access modifiers changed from: private */
    public ArcSpotlightOffscreen srcOffscreen;
    private InitFaceDetectTask task;
    private int tempHeight = GlobalParams.DEFAULT_WIDTH;
    private int tempWidth = GlobalParams.DEFAULT_HEIGHT;

    private int getArcSoftDetectAngle() {
        return -1;
    }

    public MzFaceDetectArc() {
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public void initProcessor(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9228, new Class[]{String.class}, Void.TYPE).isSupported) {
            Log.i("FunnySnapFlow", " Camera UI initProcessor()");
            if (!this.mIsInitFaceDetect && !this.mFirstInitFlag) {
                this.mFirstInitFlag = true;
                this.faceModelFullPath = str;
                Log.i("FunnySnapFlow", " MzFaceDetectA initProcessor()");
                cancelTask();
                this.task = new InitFaceDetectTask();
                this.task.execute(new String[]{"init face detect arc!"});
            }
        }
    }

    public void cancelTask() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9229, new Class[0], Void.TYPE).isSupported && this.task != null && !this.task.isCancelled()) {
            this.task.cancel(true);
            this.task = null;
        }
    }

    public static MzFaceDetectArc getInstance() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9230, new Class[0], MzFaceDetectArc.class);
        if (proxy.isSupported) {
            return (MzFaceDetectArc) proxy.result;
        }
        if (instance == null) {
            synchronized (MzFaceDetectArc.class) {
                if (instance == null) {
                    instance = new MzFaceDetectArc();
                }
            }
        }
        return instance;
    }

    private void setCameraSize(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9231, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.cameraWidth != i || this.cameraHeight != i2) {
                this.cameraWidth = i;
                this.cameraHeight = i2;
                if (this.srcOffscreen != null) {
                    this.srcOffscreen = null;
                }
                if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                    this.srcOffscreen = new ArcSpotlightOffscreen(this.cameraWidth, this.cameraHeight, 2050);
                    Log.i("FunnySnapFlow", "setCameraSize() srcOffscreen NV21");
                } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                    this.srcOffscreen = new ArcSpotlightOffscreen(this.cameraWidth, this.cameraHeight, ArcSpotlightOffscreen.ASVL_PAF_RGB32_R8G8B8A8);
                    Log.i("FunnySnapFlow", "setCameraSize() srcOffscreen RGB32");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void initFacePP() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9232, new Class[0], Void.TYPE).isSupported) {
            release();
            this.arcSpotlightFacAlignment = new ArcSpotlightFaceAlignment();
            int initialize = this.arcSpotlightFacAlignment.initialize(this.faceModelFullPath, 10);
            if (initialize != 0) {
                this.mIsInitFaceDetect = false;
                Log.e("FunnySnapFlow", " arcSpotlightFacAlignment.initialize Error : " + initialize);
            }
            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.srcOffscreen = new ArcSpotlightOffscreen(this.cameraWidth, this.cameraHeight, 2050);
                Log.e("FunnySnapFlow", "FRAME_TYPE_ONE : cameraWidth : " + this.cameraWidth + "   cameraHeight : " + this.cameraHeight);
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.srcOffscreen = new ArcSpotlightOffscreen(this.cameraWidth, this.cameraHeight, ArcSpotlightOffscreen.ASVL_PAF_RGB32_R8G8B8A8);
                Log.e("FunnySnapFlow", "FRAME_TYPE_TWO : cameraWidth : " + this.cameraWidth + "   cameraHeight : " + this.cameraHeight);
            }
            this.arcSpotlightFaceInfo = new ArcSpotlightFaceInfo();
            this.arcSpotlightFaceStatus = new ArcSpotlightFaceStatus();
            Log.e("FunnySnapFlow", " arcSpotlightFacAlignment.initialize : " + initialize);
        }
    }

    public void faceDetection(byte[] bArr, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2)}, this, changeQuickRedirect, false, 9233, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.arcSpotlightFacAlignment == null || !this.mIsInitFaceDetect) {
                GlobalParams.faces_readout_current = null;
                Log.e("FunnySnapFlow", "faceDetection() arcSpotlightFacAlignment == null || mIsInitFaceDetect");
                return;
            }
            setCameraSize(i, i2);
            updateScreenAngle();
            if (this.srcOffscreen == null) {
                GlobalParams.faces_readout_current = null;
                Log.e("FunnySnapFlow", "faceDetection() srcOffscreen == null");
            } else if (bArr == null) {
                GlobalParams.faces_readout_current = null;
                Log.e("FunnySnapFlow", "faceDetection() data == null");
            } else {
                this.srcOffscreen.setData(bArr);
                final int arcSoftDetectAngle = getArcSoftDetectAngle();
                if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                    faceDetectOutput(this.srcOffscreen, this.cameraWidth, this.cameraHeight, arcSoftDetectAngle);
                } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                    this.mHandler.post(new Runnable() {
                        public static ChangeQuickRedirect changeQuickRedirect;

                        public void run() {
                            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9237, new Class[0], Void.TYPE).isSupported) {
                                MzFaceDetectArc.this.faceDetectOutput(MzFaceDetectArc.this.srcOffscreen, MzFaceDetectArc.this.cameraWidth, MzFaceDetectArc.this.cameraHeight, arcSoftDetectAngle);
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void faceDetectOutput(ArcSpotlightOffscreen arcSpotlightOffscreen, int i, int i2, int i3) {
        Object[] objArr = {arcSpotlightOffscreen, new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9234, new Class[]{ArcSpotlightOffscreen.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.arcSpotlightFacAlignment == null || !this.mIsInitFaceDetect) {
                GlobalParams.faces_readout_current = null;
                Log.e("FunnySnapFlow", "faceDetectOutput() arcSpotlightFacAlignment == null || mIsInitFaceDetect");
                return;
            }
            setCameraSize(i, i2);
            int process = this.arcSpotlightFacAlignment.process(arcSpotlightOffscreen, i3, 8, this.arcSpotlightFaceInfo, this.arcSpotlightFaceStatus);
            if (process != 0) {
                Log.e("FunnySnapFlow", " arcSpotlightFacAlignment.process Error :  " + process);
                GlobalParams.faces_readout_current = null;
            } else if (this.arcSpotlightFaceInfo == null) {
                Log.e("FunnySnapFlow", " arcSpotlightFaceInfo == null ");
                GlobalParams.faces_readout_current = null;
            } else {
                this.faces = FaceArcsoft.processFaceResult(this.arcSpotlightFaceInfo, this.arcSpotlightFaceStatus);
                if (this.faces == null) {
                    GlobalParams.faces_readout_current = null;
                } else if (this.faces.length > 0) {
                    for (int i4 = 0; i4 < this.faces.length; i4++) {
                        if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                            PointF pointF = this.faces[i4].points[26];
                            PointF pointF2 = this.faces[i4].points[6];
                            this.faces[i4].points[6] = pointF;
                            this.faces[i4].points[26] = pointF2;
                            PointF pointF3 = this.faces[i4].points[52];
                            PointF pointF4 = this.faces[i4].points[61];
                            this.faces[i4].points[61] = pointF3;
                            this.faces[i4].points[52] = pointF4;
                        } else if (GlobalParams.CameraID == 0) {
                            PointF pointF5 = this.faces[i4].points[26];
                            PointF pointF6 = this.faces[i4].points[6];
                            this.faces[i4].points[6] = pointF5;
                            this.faces[i4].points[26] = pointF6;
                            PointF pointF7 = this.faces[i4].points[52];
                            PointF pointF8 = this.faces[i4].points[61];
                            this.faces[i4].points[61] = pointF7;
                            this.faces[i4].points[52] = pointF8;
                        }
                    }
                    GlobalParams.faces_readout_current = this.faces;
                } else {
                    GlobalParams.faces_readout_current = null;
                }
            }
        }
    }

    public boolean getFaceDetectResult() {
        return GlobalParams.faces_readout_current != null && GlobalParams.faces_readout_current.length > 0;
    }

    public boolean getInitState() {
        return this.mIsInitFaceDetect;
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9235, new Class[0], Void.TYPE).isSupported) {
            this.mIsInitFaceDetect = false;
            if (this.arcSpotlightFacAlignment != null) {
                this.arcSpotlightFacAlignment.uninitialize();
                this.arcSpotlightFacAlignment = null;
            }
            if (this.srcOffscreen != null) {
                this.srcOffscreen = null;
            }
            if (this.arcSpotlightFaceInfo != null) {
                this.arcSpotlightFaceInfo = null;
            }
            if (this.arcSpotlightFaceStatus != null) {
                this.arcSpotlightFaceStatus = null;
            }
        }
    }

    private void updateScreenAngle() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9236, new Class[0], Void.TYPE).isSupported && GlobalParams.SCREEN_ANGLE != GlobalParams.SCREEN_ANGLE_temp) {
            if (GlobalParams.SCREEN_ANGLE_temp == 90 || GlobalParams.SCREEN_ANGLE_temp == 270) {
                GlobalParams.WIDTH = GlobalParams.DEFAULT_HEIGHT;
                GlobalParams.HEIGHT = GlobalParams.DEFAULT_WIDTH;
            }
            if (GlobalParams.SCREEN_ANGLE_temp == 180 || GlobalParams.SCREEN_ANGLE_temp == 0) {
                GlobalParams.WIDTH = GlobalParams.DEFAULT_WIDTH;
                GlobalParams.HEIGHT = GlobalParams.DEFAULT_HEIGHT;
            }
            GlobalParams.faces_readout_current = null;
            GlobalParams.SCREEN_ANGLE = GlobalParams.SCREEN_ANGLE_temp;
            Log.e("FunnySnapFlow", " GlobalParams.SCREEN_ANGLE rst= " + GlobalParams.SCREEN_ANGLE);
        }
    }

    public class InitFaceDetectTask extends AsyncTask<String, Void, String> {
        public static ChangeQuickRedirect changeQuickRedirect;

        public InitFaceDetectTask() {
            Log.e("mz0601", "InitFaceDetectTask()");
        }

        public String doInBackground(String... strArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, changeQuickRedirect, false, 9238, new Class[]{String[].class}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if (isCancelled()) {
                return null;
            }
            boolean unused = MzFaceDetectArc.this.mIsInitFaceDetect = false;
            Log.e("FunnySnapFlow", "initFacePP();: 1");
            MzFaceDetectArc.this.initFacePP();
            Log.e("FunnySnapFlow", "initFacePP();: 2");
            return strArr[0];
        }

        public void onPostExecute(String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9239, new Class[]{String.class}, Void.TYPE).isSupported) {
                boolean unused = MzFaceDetectArc.this.mIsInitFaceDetect = true;
                Log.e("FunnySnapFlow", "finish InitFaceDetectTask: " + str);
            }
        }
    }
}
