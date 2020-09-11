package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.SurfaceHolder;
import com.meizu.media.mzfunnysnapsdk.Filter.BaseFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.GroupFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.NoFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.TextureFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.TextureFilterMZ2;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MediaVideoEncoder;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.ShortVideoUtils;
import com.meizu.media.mzfunnysnapsdk.Utils.EasyGlUtils;
import com.meizu.media.mzfunnysnapsdk.Utils.MatrixUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class TextureController implements GLSurfaceView.Renderer {
    public static ChangeQuickRedirect changeQuickRedirect;
    private boolean FLAG_RESIZE = true;
    /* access modifiers changed from: private */

    /* renamed from: SM */
    public float[] f15613SM = new float[16];
    private float[] callbackOM = new float[16];
    private boolean flip = true;
    private int frameCallbackHeight;
    private int frameCallbackWidth;
    private int indexOutput = 0;
    private AtomicBoolean isParamSet = new AtomicBoolean(false);
    private boolean isRecord = false;
    private boolean isShoot = false;
    private BaseFilter mBlackViewFilter;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Point mDataSize;
    private int mDirectionFlag = -1;
    private TextureFilter mEffectFilter;
    private TextureFilterMZ2 mEffectFilterMZ2;
    private int[] mExportFrame = new int[1];
    private int[] mExportTexture = new int[1];
    private FrameCallback mFrameCallback;
    private GLView mGLView;
    private GroupFilter mGroupFilter;
    public boolean mIsBlackViewShow = false;
    private int mOESTextureID = -1;
    private Renderer mRenderer;
    private int[] mShortVideoExportFrame = new int[1];
    /* access modifiers changed from: private */
    public int[] mShortVideoExportTexture = new int[1];
    private BaseFilter mShowFilter;
    private int mShowType = 1;
    private SurfaceTexture mSurfaceTexture;
    /* access modifiers changed from: private */
    public MediaVideoEncoder mVideoEncoder;
    /* access modifiers changed from: private */
    public Bitmap mWaterBitmap;
    /* access modifiers changed from: private */
    public boolean mWaterMarkEnable = true;
    private Point mWindowSize;
    private ByteBuffer[] outPutBuffer = new ByteBuffer[3];
    /* access modifiers changed from: private */
    public Object surface;

    public TextureController(Context context) {
        this.mContext = context;
        if (GlobalParams.FRAME_TYPE == 3) {
            GlobalParams.FRAME_TYPE = 2;
            GlobalParams.BEAUTY_QUALITY = GlobalParams.BEAUTY_QUALITY_LOW;
        }
        this.mOESTextureID = ShortVideoUtils.createTextureOESID();
        this.mSurfaceTexture = new SurfaceTexture(this.mOESTextureID);
        init();
    }

    public void surfaceCreated(Object obj) {
        if (!PatchProxy.proxy(new Object[]{obj}, this, changeQuickRedirect, false, 9240, new Class[]{Object.class}, Void.TYPE).isSupported) {
            this.surface = obj;
            this.mGLView.surfaceCreated((SurfaceHolder) null);
        }
    }

    public void surfaceChanged(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9241, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.mWindowSize.x = i;
            this.mWindowSize.y = i2;
            this.mGLView.surfaceChanged((SurfaceHolder) null, 0, i, i2);
        }
    }

    public void surfaceDestroyed() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9242, new Class[0], Void.TYPE).isSupported) {
            this.mGLView.surfaceDestroyed((SurfaceHolder) null);
        }
    }

    public void setShortVideoWaterBitmap(Bitmap bitmap) {
        this.mWaterBitmap = bitmap;
    }

    public Object getOutput() {
        return this.surface;
    }

    private void init() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9243, new Class[0], Void.TYPE).isSupported) {
            this.mGLView = new GLView(this.mContext);
            Log.i("FunnySnapFlow", "TextureCon() init()");
            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.mEffectFilter = new TextureFilter(this.mContext.getResources());
                this.mEffectFilter.setTextureId(this.mOESTextureID);
                this.mEffectFilter.setSurfaceTexture(this.mSurfaceTexture);
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.mEffectFilterMZ2 = new TextureFilterMZ2(this.mContext.getResources());
                this.mEffectFilterMZ2.setTextureId(this.mOESTextureID);
                this.mEffectFilterMZ2.setSurfaceTexture(this.mSurfaceTexture);
            }
            this.mShowFilter = new NoFilter(this.mContext.getResources());
            this.mBlackViewFilter = new NoFilter(this.mContext.getResources());
            this.mGroupFilter = new GroupFilter(this.mContext.getResources());
            this.mDataSize = new Point(GlobalParams.DEFAULT_WIDTH, GlobalParams.DEFAULT_HEIGHT);
            this.mWindowSize = new Point(GlobalParams.DEFAULT_WIDTH, GlobalParams.DEFAULT_HEIGHT);
        }
    }

    public void setDataSize(int i, int i2) {
        this.mDataSize.x = i;
        this.mDataSize.y = i2;
        this.FLAG_RESIZE = true;
    }

    public SurfaceTexture getTexture() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9244, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
            if (this.mEffectFilter != null) {
                return this.mEffectFilter.getTexture();
            }
            return null;
        } else if (GlobalParams.FRAME_TYPE != GlobalParams.FRAME_TYPE_TWO || this.mEffectFilterMZ2 == null) {
            return null;
        } else {
            return this.mEffectFilterMZ2.getTexture();
        }
    }

    public void setImageDirection(int i) {
        this.mDirectionFlag = i;
    }

    public void setRenderer(Renderer renderer) {
        this.mRenderer = renderer;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Class[] clsArr = {GL10.class, EGLConfig.class};
        if (!PatchProxy.proxy(new Object[]{gl10, eGLConfig}, this, changeQuickRedirect, false, 9245, clsArr, Void.TYPE).isSupported) {
            Log.i("FunnySnapFlow", "TextureCon onSurfaceCreated()");
            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.mEffectFilter.create();
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.mEffectFilterMZ2.create();
            }
            this.mGroupFilter.create();
            this.mShowFilter.create();
            this.mBlackViewFilter.create();
            if (!this.isParamSet.get()) {
                if (this.mRenderer != null) {
                    this.mRenderer.onSurfaceCreated(gl10, eGLConfig);
                }
                sdkParamSet();
            }
            calculateCallbackOM();
            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.mEffectFilter.setFlag(this.mDirectionFlag);
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.mEffectFilterMZ2.setFlag(this.mDirectionFlag);
            }
        }
    }

    private void deleteFrameBuffer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9246, new Class[0], Void.TYPE).isSupported) {
            GLES20.glDeleteFramebuffers(1, this.mExportFrame, 0);
            GLES20.glDeleteTextures(1, this.mExportTexture, 0);
            GLES20.glDeleteFramebuffers(1, this.mShortVideoExportFrame, 0);
            GLES20.glDeleteTextures(1, this.mShortVideoExportTexture, 0);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Object[] objArr = {gl10, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9247, new Class[]{GL10.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            deleteFrameBuffer();
            GLES20.glGenFramebuffers(1, this.mExportFrame, 0);
            EasyGlUtils.genTexturesWithParameter(1, this.mExportTexture, 0, 6408, this.mDataSize.x, this.mDataSize.y);
            GLES20.glGenFramebuffers(1, this.mShortVideoExportFrame, 0);
            EasyGlUtils.genTexturesWithParameter(1, this.mShortVideoExportTexture, 0, 6408, this.mDataSize.x, this.mDataSize.y);
            Log.i("FunnySnapFlow", "TextureCon onSurfaceChanged()");
            MatrixUtils.getMatrix(this.f15613SM, this.mShowType, this.mDataSize.x, this.mDataSize.y, i, i2);
            this.mShowFilter.setSize(i, i2);
            this.mShowFilter.setMatrix(this.f15613SM);
            this.mBlackViewFilter.setSize(i, i2);
            this.mBlackViewFilter.setMatrix(this.f15613SM);
            this.mGroupFilter.setSize(this.mDataSize.x, this.mDataSize.y);
            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.mEffectFilter.setSize(this.mDataSize.x, this.mDataSize.y);
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.mEffectFilterMZ2.setSize(this.mDataSize.x, this.mDataSize.y);
            }
            this.mShowFilter.setSize(this.mDataSize.x, this.mDataSize.y);
            if (this.mRenderer != null) {
                this.mRenderer.onSurfaceChanged(gl10, i, i2);
            }
        }
    }

    public void setBlackViewShow(boolean z) {
        this.mIsBlackViewShow = z;
    }

    public void onDrawFrame(GL10 gl10) {
        if (!PatchProxy.proxy(new Object[]{gl10}, this, changeQuickRedirect, false, 9248, new Class[]{GL10.class}, Void.TYPE).isSupported && this.isParamSet.get()) {
            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                this.mEffectFilter.draw();
                this.mGroupFilter.setTextureId(this.mEffectFilter.getOutputTexture());
            } else if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO) {
                this.mEffectFilterMZ2.draw();
                this.mGroupFilter.setTextureId(this.mEffectFilterMZ2.getOutputTexture());
            }
            this.mGroupFilter.draw();
            if (!this.mIsBlackViewShow) {
                GLES20.glViewport(0, 0, this.mWindowSize.x, this.mWindowSize.y);
                this.mShowFilter.setMatrix(this.f15613SM);
                this.mShowFilter.setTextureId(this.mGroupFilter.getOutputTexture());
                this.mShowFilter.draw();
                if (this.mRenderer != null) {
                    this.mRenderer.onDrawFrame(gl10);
                }
                callbackIfNeeded();
            } else {
                GLES20.glViewport(0, 0, this.mWindowSize.x, this.mWindowSize.y);
                this.mBlackViewFilter.draw();
                if (this.mRenderer != null) {
                    this.mRenderer.onDrawFrame(gl10);
                }
            }
            GLES20.glViewport(0, 0, this.frameCallbackWidth, this.frameCallbackHeight);
            EasyGlUtils.bindFrameTexture(this.mShortVideoExportFrame[0], this.mShortVideoExportTexture[0]);
            this.mShowFilter.setTextureId(this.mGroupFilter.getOutputTexture());
            this.mShowFilter.draw();
            EasyGlUtils.unBindFrameBuffer();
            this.flip = !this.flip;
            if (this.flip && this.isRecord && this.mVideoEncoder != null) {
                this.mVideoEncoder.frameAvailableSoon();
            }
            callbackIfNeeded();
        }
    }

    public void setWaterMarkEnable(boolean z) {
        this.mWaterMarkEnable = z;
    }

    public void setVideoEncoder(final MediaVideoEncoder mediaVideoEncoder) {
        if (!PatchProxy.proxy(new Object[]{mediaVideoEncoder}, this, changeQuickRedirect, false, 9249, new Class[]{MediaVideoEncoder.class}, Void.TYPE).isSupported) {
            this.mGLView.queueEvent(new Runnable() {
                public static ChangeQuickRedirect changeQuickRedirect;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9269, new Class[0], Void.TYPE).isSupported) {
                        if (mediaVideoEncoder != null) {
                            mediaVideoEncoder.setVideoAngle(GlobalParams.getScreenAngle());
                            mediaVideoEncoder.setWaterMarkEnable(TextureController.this.mWaterMarkEnable);
                            mediaVideoEncoder.setEglContext(TextureController.this.mContext.getResources(), EGL14.eglGetCurrentContext(), TextureController.this.mShortVideoExportTexture[0], TextureController.this.f15613SM, TextureController.this.mDataSize.x, TextureController.this.mDataSize.y, TextureController.this.mWaterBitmap);
                        }
                        MediaVideoEncoder unused = TextureController.this.mVideoEncoder = mediaVideoEncoder;
                    }
                }
            });
        }
    }

    public void addFilter(BaseFilter baseFilter) {
        if (!PatchProxy.proxy(new Object[]{baseFilter}, this, changeQuickRedirect, false, 9250, new Class[]{BaseFilter.class}, Void.TYPE).isSupported) {
            this.mGroupFilter.addFilter(baseFilter);
        }
    }

    public void removeFilter(BaseFilter baseFilter) {
        if (!PatchProxy.proxy(new Object[]{baseFilter}, this, changeQuickRedirect, false, 9251, new Class[]{BaseFilter.class}, Void.TYPE).isSupported) {
            this.mGroupFilter.removeFilter(baseFilter);
            this.mGroupFilter.updateFilter();
        }
    }

    public void removeFilter(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9252, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mGroupFilter.removeFilter(i);
            this.mGroupFilter.updateFilter();
        }
    }

    public void removeAllFilter() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9253, new Class[0], Void.TYPE).isSupported) {
            this.mGroupFilter.clearAll();
        }
    }

    public void setShowType(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9254, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mShowType = i;
            if (this.mWindowSize.x > 0 && this.mWindowSize.y > 0) {
                MatrixUtils.getMatrix(this.f15613SM, this.mShowType, this.mDataSize.x, this.mDataSize.y, this.mWindowSize.x, this.mWindowSize.y);
                this.mShowFilter.setMatrix(this.f15613SM);
                this.mShowFilter.setSize(this.mWindowSize.x, this.mWindowSize.y);
            }
        }
    }

    public void startRecord() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9255, new Class[0], Void.TYPE).isSupported) {
            this.isRecord = true;
            Log.i("FunnySnapFlow", "TextureCon startRecord()");
        }
    }

    public void stopRecord() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9256, new Class[0], Void.TYPE).isSupported) {
            this.isRecord = false;
            Log.i("FunnySnapFlow", "TextureCon stopRecord()");
        }
    }

    public void takePhoto() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9257, new Class[0], Void.TYPE).isSupported) {
            this.isShoot = true;
            Log.i("FunnySnapFlow", "TextureCon takePhoto()");
        }
    }

    public void setFrameCallback(int i, int i2, FrameCallback frameCallback) {
        Object[] objArr = {new Integer(i), new Integer(i2), frameCallback};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9258, new Class[]{Integer.TYPE, Integer.TYPE, FrameCallback.class}, Void.TYPE).isSupported) {
            this.frameCallbackWidth = i;
            this.frameCallbackHeight = i2;
            if (this.frameCallbackWidth <= 0 || this.frameCallbackHeight <= 0) {
                this.mFrameCallback = null;
                return;
            }
            if (this.outPutBuffer != null) {
                this.outPutBuffer = new ByteBuffer[3];
            }
            calculateCallbackOM();
            this.mFrameCallback = frameCallback;
        }
    }

    private void calculateCallbackOM() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9259, new Class[0], Void.TYPE).isSupported && this.frameCallbackHeight > 0 && this.frameCallbackWidth > 0 && this.mDataSize.x > 0 && this.mDataSize.y > 0) {
            MatrixUtils.getMatrix(this.callbackOM, 1, this.mDataSize.x, this.mDataSize.y, this.frameCallbackWidth, this.frameCallbackHeight);
            MatrixUtils.flip(this.callbackOM, false, true);
        }
    }

    public Point getWindowSize() {
        return this.mWindowSize;
    }

    public Point getShortVideoDataSize() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9260, new Class[0], Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        if (this.mDataSize == null) {
            return null;
        }
        Point point = new Point(this.mDataSize.x, this.mDataSize.y);
        int screenAngle = GlobalParams.getScreenAngle();
        if (screenAngle == 90 || screenAngle == 270) {
            point.x = this.mDataSize.y;
            point.y = this.mDataSize.x;
        }
        Log.i("mz0409", "mDataSize width : " + this.mDataSize.x + ", height : " + this.mDataSize.y);
        Log.i("mz0409", "point width : " + point.x + ", height : " + point.y);
        return point;
    }

    private void sdkParamSet() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9261, new Class[0], Void.TYPE).isSupported && !this.isParamSet.get() && this.mDataSize.x > 0 && this.mDataSize.y > 0) {
            this.isParamSet.set(true);
        }
    }

    private void callbackIfNeeded() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9262, new Class[0], Void.TYPE).isSupported && this.mFrameCallback != null && this.isShoot) {
            int i = this.indexOutput;
            this.indexOutput = i + 1;
            this.indexOutput = i >= 2 ? 0 : this.indexOutput;
            if (this.outPutBuffer[this.indexOutput] != null) {
                this.outPutBuffer[this.indexOutput] = null;
            }
            this.outPutBuffer[this.indexOutput] = ByteBuffer.allocate(this.frameCallbackWidth * this.frameCallbackHeight * 4);
            GLES20.glViewport(0, 0, this.frameCallbackWidth, this.frameCallbackHeight);
            EasyGlUtils.bindFrameTexture(this.mExportFrame[0], this.mExportTexture[0]);
            this.mShowFilter.setMatrix(this.callbackOM);
            this.mShowFilter.draw();
            frameCallback();
            this.isShoot = false;
            EasyGlUtils.unBindFrameBuffer();
            this.mShowFilter.setMatrix(this.f15613SM);
        }
    }

    private void frameCallback() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9263, new Class[0], Void.TYPE).isSupported) {
            GLES20.glReadPixels(0, 0, this.frameCallbackWidth, this.frameCallbackHeight, 6408, 5121, this.outPutBuffer[this.indexOutput]);
            if (this.mFrameCallback != null && this.outPutBuffer[this.indexOutput] != null) {
                this.mFrameCallback.onFrame(this.outPutBuffer[this.indexOutput].array(), 0);
            }
        }
    }

    public void create(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9264, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.mGLView.attachedToWindow();
            surfaceCreated(this.surface);
            surfaceChanged(i, i2);
        }
    }

    public void destroy() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9265, new Class[0], Void.TYPE).isSupported) {
            if (this.mRenderer != null) {
                this.mRenderer.onDestroy();
            }
            Log.i("FunnySnapFlow", "TextureCon destroy()");
            this.mGLView.surfaceDestroyed((SurfaceHolder) null);
            this.mGLView.detachedFromWindow();
            this.mGLView.clear();
        }
    }

    public void requestRender() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9266, new Class[0], Void.TYPE).isSupported) {
            this.mGLView.requestRender();
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9267, new Class[0], Void.TYPE).isSupported) {
            this.mGLView.onPause();
        }
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9268, new Class[0], Void.TYPE).isSupported) {
            this.mGLView.onResume();
        }
    }

    private class GLView extends GLSurfaceView {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void clear() {
        }

        public GLView(Context context) {
            super(context);
            init();
        }

        private void init() {
            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9270, new Class[0], Void.TYPE).isSupported) {
                setEGLWindowSurfaceFactory(new GLSurfaceView.EGLWindowSurfaceFactory() {
                    public static ChangeQuickRedirect changeQuickRedirect;

                    public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{egl10, eGLDisplay, eGLConfig, obj}, this, changeQuickRedirect, false, 9273, new Class[]{EGL10.class, EGLDisplay.class, EGLConfig.class, Object.class}, EGLSurface.class);
                        return proxy.isSupported ? (EGLSurface) proxy.result : egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, TextureController.this.surface, (int[]) null);
                    }

                    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
                        Class[] clsArr = {EGL10.class, EGLDisplay.class, EGLSurface.class};
                        if (!PatchProxy.proxy(new Object[]{egl10, eGLDisplay, eGLSurface}, this, changeQuickRedirect, false, 9274, clsArr, Void.TYPE).isSupported) {
                            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
                        }
                    }
                });
                setEGLContextClientVersion(2);
                setRenderer(TextureController.this);
                setRenderMode(0);
                setPreserveEGLContextOnPause(true);
            }
        }

        public void attachedToWindow() {
            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9271, new Class[0], Void.TYPE).isSupported) {
                super.onAttachedToWindow();
            }
        }

        public void detachedFromWindow() {
            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9272, new Class[0], Void.TYPE).isSupported) {
                super.onDetachedFromWindow();
            }
        }
    }
}
