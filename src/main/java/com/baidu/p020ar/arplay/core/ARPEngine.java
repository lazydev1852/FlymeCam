package com.baidu.p020ar.arplay.core;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.p032a.C0509a;
import com.baidu.p020ar.arplay.p032a.C0534b;
import com.baidu.p020ar.arplay.p032a.C0537e;
import com.baidu.p020ar.arplay.representation.Matrix;
import com.baidu.p020ar.arplay.representation.Matrixf4x4;
import com.baidu.p020ar.arplay.representation.Quaternion;
import com.baidu.p020ar.arplay.representation.Vector3f;
import com.baidu.p020ar.arplay.representation.Vector4f;
import com.baidu.p020ar.arplay.webview.GLWebViewManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.ar.arplay.core.ARPEngine */
public class ARPEngine {
    private static final String LOWEST_VERSION_KEY = "compatible_version";
    public static final String MYTAG = "tracking_data_debug";
    private static final String TAG = "EngineLogger";
    private static ARPEngine self;
    private final int mARTypeCloudSameSearch = 7;
    private final int mARTypeIMU = 8;
    private final int mARTypeLocalSameSearch = 6;
    private final int mARTypeSlam = 5;
    private final int mARTypeTracking = 0;
    private final int mARTypeUnknow = -1;
    private C0577a mArGLEngineCtl;
    private C0509a.C0525b mAudioPlayerCallback = new C0509a.C0525b() {
        /* renamed from: a */
        public void mo9003a(Exception exc) {
            C0509a.m927c();
        }

        /* renamed from: a */
        public void mo9004a(boolean z) {
            C0509a.m927c();
        }
    };
    private List<C0569c> mCaseProcessList = new LinkedList();
    private long mCurrentGLThreadID = -1;
    private C0534b mDataStore;
    private int mDeviceOrientation = -1;
    /* access modifiers changed from: private */
    public int mFPS = 0;
    /* access modifiers changed from: private */
    public boolean mHasResumeByUser = false;
    private C0568b mHtmlCallback;
    private int mImuType = 0;
    private C0570d mInteraction = null;
    private boolean mIsAppBackground = false;
    /* access modifiers changed from: private */
    public boolean mIsCaseCreated = false;
    private boolean mIsInitNative = false;
    private OrientationEventListener mOrientationEventListener;
    private TouchOrientation mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
    private C0571e mUpdateCallback;
    private C0572f mVideoCallback;

    /* renamed from: com.baidu.ar.arplay.core.ARPEngine$TouchOrientation */
    public enum TouchOrientation {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPEngine$a */
    public interface C0567a {
        /* renamed from: a */
        void mo9184a(Bitmap bitmap);
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPEngine$b */
    public interface C0568b {
        /* renamed from: a */
        boolean mo9185a(int i, int i2);
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPEngine$c */
    public interface C0569c {
        /* renamed from: a */
        void mo9186a();

        /* renamed from: b */
        void mo9187b();
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPEngine$d */
    public interface C0570d {
        /* renamed from: a */
        void mo9188a(float f, float f2, float f3);
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPEngine$e */
    public interface C0571e {
        /* renamed from: a */
        void mo8920a();
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPEngine$f */
    public interface C0572f {
        /* renamed from: a */
        void mo9086a(String str, int i, String str2, String str3);
    }

    private ARPEngine() {
    }

    /* access modifiers changed from: private */
    public void afterCaseCreate() {
        if (this.mCaseProcessList != null) {
            for (C0569c next : this.mCaseProcessList) {
                if (next != null) {
                    next.mo9187b();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void beforeCaseCreate() {
        if (this.mCaseProcessList != null) {
            for (C0569c next : this.mCaseProcessList) {
                if (next != null) {
                    next.mo9186a();
                }
            }
        }
    }

    private static void executeOnGLResLoadThread(Object obj, Runnable runnable) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine != null) {
            aRPEngine.executeOnGLResLoadThread(runnable);
        }
    }

    private void executeOnGLResLoadThread(Runnable runnable) {
        queueResLoadEvent(runnable);
    }

    private static void executeOnGLThread(Object obj, Runnable runnable) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine != null) {
            aRPEngine.executeOnGLThread(runnable);
        }
    }

    private int getARType() {
        Object sharedEnvironmentValue = ARPScriptEnvironment.getInstance().getSharedEnvironmentValue("userinfo");
        if (sharedEnvironmentValue == null || !(sharedEnvironmentValue instanceof HashMap)) {
            return 0;
        }
        HashMap hashMap = (HashMap) sharedEnvironmentValue;
        if (hashMap.get("ar_type") instanceof Integer) {
            return ((Integer) hashMap.get("ar_type")).intValue();
        }
        return 0;
    }

    public static synchronized ARPEngine getInstance() {
        ARPEngine aRPEngine;
        synchronized (ARPEngine.class) {
            if (self == null) {
                self = new ARPEngine();
            }
            aRPEngine = self;
        }
        return aRPEngine;
    }

    private static String getValue(Object obj, int i, String str) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        return aRPEngine == null ? "" : aRPEngine.getValue(i, str);
    }

    public static native boolean libraryHasLoaded();

    private native void nativeFinalize();

    private native void nativeInterruptLoading();

    private native void nativeSetup(Object obj);

    public static void onInteractionFinish(Object obj, float f, float f2, float f3) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine != null) {
            aRPEngine.onInteractionFinish(f, f2, f3);
        }
    }

    private void saveInteractionInfoInEnvironment() {
        HashMap hashMap;
        String str;
        HashMap hashMap2;
        int aRType = getARType();
        if (aRType == 8) {
            hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            hashMap3.put("gesture_scroll", "interaction_space_move");
            hashMap3.put("gesture_two_finger_scroll", "interaction_rotate");
            hashMap3.put("gesture_two_finger_pinch", "interaction_scale_down");
            hashMap3.put("gesture_two_finger_unpinch", "interaction_scale_up");
            hashMap2.put("continuous_mapping", hashMap3);
            hashMap4.put("limit_radius_invariant", 1);
            hashMap2.put("space_move_config", hashMap4);
        } else {
            if (aRType == 0 || aRType == 6 || aRType == 7) {
                hashMap2 = new HashMap();
                HashMap hashMap5 = new HashMap();
                hashMap = new HashMap();
                hashMap5.put("gesture_scroll", "interaction_space_move");
                hashMap5.put("gesture_two_finger_scroll", "interaction_rotate");
                hashMap5.put("gesture_two_finger_pinch", "interaction_scale_down");
                hashMap5.put("gesture_two_finger_unpinch", "interaction_scale_up");
                hashMap2.put("continuous_mapping", hashMap5);
                hashMap.put("limit_radius_invariant", 0);
                str = "space_move_config";
            } else if (aRType == 5) {
                hashMap2 = new HashMap();
                HashMap hashMap6 = new HashMap();
                hashMap6.put("gesture_scroll", "interaction_plane_move");
                hashMap6.put("gesture_two_finger_scroll", "interaction_rotate");
                hashMap6.put("gesture_two_finger_pinch", "interaction_scale_down");
                hashMap6.put("gesture_two_finger_unpinch", "interaction_scale_up");
                hashMap2.put("continuous_mapping", hashMap6);
                HashMap hashMap7 = new HashMap();
                hashMap7.put("limit_radius", 1);
                hashMap7.put("radius_min", Float.valueOf(0.0f));
                hashMap7.put("radius_max", Float.valueOf(3000.0f));
                hashMap7.put("limit_step_length", 1);
                hashMap7.put("step_length", Float.valueOf(80.0f));
                hashMap7.put("limit_far_frustum", 1);
                hashMap7.put("move_leave_callback", 1);
                hashMap2.put("plane_move_config", hashMap7);
                HashMap hashMap8 = new HashMap();
                hashMap8.put("limit_world_axis", 1);
                hashMap8.put("world_axis", "y");
                hashMap2.put("rotate_config", hashMap8);
                hashMap = new HashMap();
                hashMap.put("limit_distance_factor", 1);
                str = "scale_config";
            } else {
                return;
            }
            hashMap2.put(str, hashMap);
        }
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap2);
    }

    /* access modifiers changed from: private */
    public void setInteractionConfigAfterSceneCreate() {
        Vector3f vector3f;
        boolean isDriverdByARPVersion = isDriverdByARPVersion();
        if (getARType() == 5) {
            ARPNode b = getCurrentScene().mo9205b();
            if (!isDriverdByARPVersion) {
                ARPInteractionConfig.m1073a(new Vector3f(0.0f, 0.0f, 1.0f), 0.0f);
                vector3f = new Vector3f(0.0f, 0.0f, 1.0f);
                if (b == null) {
                    return;
                }
            } else {
                vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
                if (b == null) {
                    return;
                }
            }
            b.mo9192b(vector3f);
        }
    }

    /* access modifiers changed from: private */
    public void setInteractionConfigBeforeSceneCreate() {
        saveInteractionInfoInEnvironment();
    }

    private static void setValue(Object obj, int i, String str, String str2) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine != null) {
            aRPEngine.setValue(i, str, str2);
        }
    }

    private static void updateVideoFrame(Object obj, String str, int i, String str2, String str3) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine != null) {
            aRPEngine.updateVideoFrame(str, i, str2, str3);
        }
    }

    public static boolean updateWebViewFrame(Object obj, int i, int i2) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine == null) {
            return false;
        }
        return aRPEngine.updateWebViewFrame(i, i2);
    }

    public boolean bindTexture(boolean z, int i, String str) {
        return nativeBindTexture(z, i, str);
    }

    public void clearARMemory() {
        if (this.mDataStore != null) {
            this.mDataStore.mo9048a();
        }
    }

    public void clearResLoadEventAndWait() {
        if (this.mArGLEngineCtl != null) {
            this.mArGLEngineCtl.mo9231a();
        }
    }

    public void clearScreen() {
        executeOnGLThread(new Runnable() {
            public void run() {
                ARPEngine.this.nativeClearScreen();
            }
        });
    }

    public boolean configFrameBuffers(int[] iArr) {
        return updateFrameBuffers(iArr);
    }

    public int createSceneAppWithViewPortSize(String str, HashMap<String, Object> hashMap, int i, int i2, float f) {
        int caseId = getCaseId();
        final String str2 = str;
        final int i3 = caseId;
        final HashMap<String, Object> hashMap2 = hashMap;
        final int i4 = i;
        final int i5 = i2;
        final float f2 = f;
        executeOnGLThread(new Runnable() {
            public void run() {
                System.currentTimeMillis();
                boolean unused = ARPEngine.this.mIsCaseCreated = true;
                ARPEngine.this.setInteractionConfigBeforeSceneCreate();
                ARPEngine.this.beforeCaseCreate();
                ARPEngine.this.nativeCreateCase(str2, i3, hashMap2, i4, i5, f2);
                ARPEngine.this.afterCaseCreate();
                ARPEngine.this.setInteractionConfigAfterSceneCreate();
            }
        });
        return caseId;
    }

    public void destroySceneApp() {
        if (this.mArGLEngineCtl != null) {
            this.mIsCaseCreated = false;
            this.mUpdateCallback = null;
            ARPMessage.getInstance().receiveMsgFromEngine(0, -2, (HashMap<String, Object>) null, 0);
            nativeInterruptLoading();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            C05658 r3 = new Runnable() {
                public void run() {
                    synchronized (this) {
                        ARPEngine.this.clearResLoadEventAndWait();
                        ARPEngine.this.nativeDestroyCase();
                        ARPCamera.m1059c();
                        atomicBoolean.set(true);
                        notify();
                    }
                }
            };
            executeOnGLThread(r3);
            try {
                synchronized (r3) {
                    while (!atomicBoolean.get()) {
                        r3.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setImuType(0);
            this.mVideoCallback = null;
            C0509a.m918a().mo8983a(this.mAudioPlayerCallback);
            this.mAudioPlayerCallback = null;
            C0537e.m1013a().mo9072c();
            ARPMessage.getInstance().release();
            GLWebViewManager.getInstance().release();
            ARPScriptEnvironment.getInstance().release();
            this.mCaseProcessList.clear();
        }
    }

    public void executeOnGLThread(Runnable runnable) {
        if (this.mArGLEngineCtl == null) {
            return;
        }
        if (this.mArGLEngineCtl.mo9235b() == Thread.currentThread().getId()) {
            runnable.run();
        } else {
            this.mArGLEngineCtl.mo9236b(runnable);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finalize() {
        /*
            r1 = this;
            super.finalize()
            monitor-enter(r1)
            boolean r0 = r1.mIsInitNative     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000b
            r1.nativeFinalize()     // Catch:{ Throwable -> 0x000b }
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.core.ARPEngine.finalize():void");
    }

    public C0577a getArGLEngineCtl() {
        return this.mArGLEngineCtl;
    }

    /* access modifiers changed from: package-private */
    public native int getCaseId();

    public ARPScene getCurrentScene() {
        long nativeGetCurrentScene = nativeGetCurrentScene();
        ARPScene aRPScene = new ARPScene();
        aRPScene.mo9203a(nativeGetCurrentScene);
        return aRPScene;
    }

    public int getFps() {
        executeOnGLThread(new Runnable() {
            public void run() {
                int unused = ARPEngine.this.mFPS = ARPEngine.this.nativeGetFps();
            }
        });
        return this.mFPS;
    }

    public int getImuType() {
        return this.mImuType;
    }

    public int getTextureId(String str) {
        return nativeGetTextureId(str);
    }

    public String getValue(int i, String str) {
        if (this.mDataStore != null) {
            return this.mDataStore.mo9047a(i, str);
        }
        Log.e("ARPEngine", "get value error!");
        return "";
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        if (this.mDataStore == null) {
            this.mDataStore = new C0534b();
            this.mDataStore.mo9050a(sharedPreferences);
        }
    }

    public void interruptEngine() {
        if (this.mArGLEngineCtl != null) {
            nativeInterruptLoading();
        }
    }

    public boolean isAppBackground() {
        return this.mIsAppBackground;
    }

    public boolean isCaseCreated() {
        return this.mIsCaseCreated;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r0 = (java.lang.String) r0.get(LOWEST_VERSION_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isDriverdByARPVersion() {
        /*
            r3 = this;
            com.baidu.ar.arplay.core.ARPScriptEnvironment r0 = com.baidu.p020ar.arplay.core.ARPScriptEnvironment.getInstance()
            java.lang.String r1 = "caseinfo"
            java.lang.Object r0 = r0.getSharedEnvironmentValue(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0035
            boolean r2 = r0 instanceof java.util.HashMap
            if (r2 == 0) goto L_0x0035
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.String r2 = "compatible_version"
            java.lang.Object r2 = r0.get(r2)
            boolean r2 = r2 instanceof java.lang.String
            if (r2 == 0) goto L_0x0035
            java.lang.String r2 = "compatible_version"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = ""
            if (r0 != r2) goto L_0x002a
            return r1
        L_0x002a:
            java.lang.String r2 = "2.0.0"
            int r0 = r0.compareTo(r2)
            if (r0 >= 0) goto L_0x0033
            return r1
        L_0x0033:
            r0 = 1
            return r0
        L_0x0035:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.core.ARPEngine.isDriverdByARPVersion():boolean");
    }

    /* access modifiers changed from: package-private */
    public native boolean nativeBindTexture(boolean z, int i, String str);

    /* access modifiers changed from: package-private */
    public native void nativeClearScreen();

    /* access modifiers changed from: package-private */
    public native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3, float f);

    /* access modifiers changed from: package-private */
    public native void nativeDestroyCase();

    /* access modifiers changed from: package-private */
    public native long nativeGetCurrentScene();

    /* access modifiers changed from: package-private */
    public native int nativeGetFps();

    /* access modifiers changed from: package-private */
    public native int nativeGetTextureId(String str);

    /* access modifiers changed from: package-private */
    public native void nativeOnPause();

    /* access modifiers changed from: package-private */
    public native void nativeOnPauseByUser();

    /* access modifiers changed from: package-private */
    public native void nativeOnResume();

    /* access modifiers changed from: package-private */
    public native void nativeOnResumeByUser();

    /* access modifiers changed from: package-private */
    public native void nativeReset();

    /* access modifiers changed from: package-private */
    public native void nativeSetSize(int i, int i2);

    /* access modifiers changed from: package-private */
    public native void nativeSmallGameDestroy();

    /* access modifiers changed from: package-private */
    public native int nativeSmallGameGetFPS();

    /* access modifiers changed from: package-private */
    public native void nativeSmallGameOnPause();

    /* access modifiers changed from: package-private */
    public native void nativeSmallGameOnResume();

    /* access modifiers changed from: package-private */
    public native void nativeSmallGameUpdate();

    /* access modifiers changed from: package-private */
    public native void nativeUpdate();

    public void onGestureUpdate(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9) {
        final int i5 = i;
        final long j2 = j;
        final int i6 = i2;
        final float f10 = f;
        final float f11 = f2;
        final float f12 = f3;
        final float f13 = f4;
        final int i7 = i3;
        final float f14 = f5;
        final float f15 = f6;
        final float f16 = f7;
        final float f17 = f8;
        final int i8 = i4;
        final float f18 = f9;
        C05625 r17 = r0;
        C05625 r0 = new Runnable(this) {

            /* renamed from: o */
            final /* synthetic */ ARPEngine f781o;

            {
                this.f781o = r4;
            }

            public void run() {
                ARPEngine aRPEngine = this.f781o;
                ARPEngine aRPEngine2 = aRPEngine;
                aRPEngine2.onGestureUpdateNative(i5, j2, i6, f10, f11, f12, f13, i7, f14, f15, f16, f17, i8, f18, false);
            }
        };
        executeOnGLThread(r17);
    }

    /* access modifiers changed from: package-private */
    public native void onGestureUpdateNative(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9, boolean z);

    public void onGestureUpdateWithScaleFinish(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9, boolean z) {
        final int i5 = i;
        final long j2 = j;
        final int i6 = i2;
        final float f10 = f;
        final float f11 = f2;
        final float f12 = f3;
        final float f13 = f4;
        final int i7 = i3;
        final float f14 = f5;
        final float f15 = f6;
        final float f16 = f7;
        final float f17 = f8;
        final int i8 = i4;
        final float f18 = f9;
        final boolean z2 = z;
        C05636 r18 = r0;
        C05636 r0 = new Runnable(this) {

            /* renamed from: p */
            final /* synthetic */ ARPEngine f797p;

            {
                this.f797p = r4;
            }

            public void run() {
                ARPEngine aRPEngine = this.f797p;
                ARPEngine aRPEngine2 = aRPEngine;
                aRPEngine2.onGestureUpdateNative(i5, j2, i6, f10, f11, f12, f13, i7, f14, f15, f16, f17, i8, f18, z2);
            }
        };
        executeOnGLThread(r18);
    }

    public void onInteractionFinish(float f, float f2, float f3) {
        if (this.mInteraction != null) {
            this.mInteraction.mo9188a(f, f2, f3);
        }
    }

    public void onPause() {
        if (this.mOrientationEventListener != null) {
            this.mOrientationEventListener.disable();
        }
        executeOnGLThread(new Runnable() {
            public void run() {
                ARPEngine.this.nativeOnPause();
            }
        });
    }

    public void onPauseByUser() {
        this.mHasResumeByUser = false;
        executeOnGLThread(new Runnable() {
            public void run() {
                ARPEngine.this.nativeOnPauseByUser();
            }
        });
    }

    public void onResume() {
        executeOnGLThread(new Runnable() {
            public void run() {
                ARPEngine.this.nativeOnResume();
            }
        });
        if (this.mHasResumeByUser) {
            onResumeByUser();
            this.mHasResumeByUser = false;
        }
    }

    public void onResumeByUser() {
        if (this.mArGLEngineCtl == null) {
            this.mHasResumeByUser = true;
        }
        executeOnGLThread(new Runnable() {
            public void run() {
                boolean unused = ARPEngine.this.mHasResumeByUser = false;
                ARPEngine.this.nativeOnResumeByUser();
            }
        });
    }

    public void onTouchUpdate(int i, float f, float f2, float f3, float f4, long j, int i2, float f5) {
        final int i3 = i;
        final float f6 = f;
        final float f7 = f2;
        final float f8 = f3;
        final float f9 = f4;
        final long j2 = j;
        final int i4 = i2;
        final float f10 = f5;
        executeOnGLThread(new Runnable() {
            public void run() {
                ARPEngine.this.onTouchUpdateNative(i3, f6, f7, f8, f9, j2, i4, f10);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public native void onTouchUpdateNative(int i, float f, float f2, float f3, float f4, long j, int i2, float f5);

    public void queueResLoadEvent(Runnable runnable) {
        if (this.mArGLEngineCtl != null) {
            this.mArGLEngineCtl.mo9233a(runnable);
        }
    }

    public void registerCaseProcess(C0569c cVar) {
        if (this.mCaseProcessList != null) {
            this.mCaseProcessList.add(cVar);
        }
    }

    public void reset() {
        executeOnGLThread(new Runnable() {
            public void run() {
                ARPEngine.this.nativeReset();
            }
        });
    }

    public void sceneRotateToCamera() {
        ARPCamera a = getCurrentScene().mo9202a();
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrixValues(a.mo9089b());
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        Matrix.invertM(matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
        ARPNode b = getCurrentScene().mo9205b();
        if (b == null) {
            Log.e("sceneRotateToCamera", "current scene root node is null!");
            return;
        }
        Vector3f vector3f = new Vector3f(0.0f, -1.0f, 0.0f);
        boolean isDriverdByARPVersion = isDriverdByARPVersion();
        if (isDriverdByARPVersion) {
            vector3f.setXYZ(0.0f, 0.0f, 1.0f);
        }
        Vector4f f = b.mo9195f();
        Quaternion quaternion = new Quaternion();
        quaternion.setAxisAngleRad(new Vector3f(f.mo9392x(), f.mo9394y(), f.mo9396z()), (double) f.getW());
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        matrixf4x43.setMatrixValues(quaternion.getMatrix4x4().getMatrix());
        Vector3f vector3f2 = new Vector3f();
        Matrix.multiplyMV3(vector3f2.toArray(), matrixf4x43.getMatrix(), vector3f.toArray(), 1.0f);
        Vector3f vector3f3 = new Vector3f();
        Vector3f vector3f4 = new Vector3f(0.0f, 0.0f, -1.0f);
        matrixf4x42.setW0(0.0f);
        matrixf4x42.setW1(0.0f);
        matrixf4x42.setW2(0.0f);
        matrixf4x42.setW3(1.0f);
        Matrix.multiplyMV3(vector3f3.toArray(), matrixf4x42.getMatrix(), vector3f4.toArray(), 1.0f);
        Vector3f vector3f5 = new Vector3f();
        if (isDriverdByARPVersion) {
            vector3f3.setY(0.0f);
            vector3f5.setXYZ(0.0f, 1.0f, 0.0f);
        } else {
            vector3f3.setZ(0.0f);
            vector3f5.setXYZ(0.0f, 0.0f, 1.0f);
        }
        vector3f3.normalize();
        vector3f3.multiplyByScalar(-1.0f);
        Quaternion a2 = ARPNumber.m1081a(vector3f2, vector3f3);
        a2.multiplyByQuat(quaternion);
        Vector4f vector4f = new Vector4f();
        a2.toAxisAngle(vector4f);
        vector4f.setW((float) Math.toRadians((double) vector4f.mo9390w()));
        b.mo9191a(vector4f);
    }

    public void sceneWorldPositionToOrigin() {
        ARPNode b = getCurrentScene().mo9205b();
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 0.0f);
        if (b != null) {
            b.mo9190a(vector3f);
        }
    }

    public void setArEngineCtl(C0577a aVar) {
        this.mArGLEngineCtl = aVar;
        ARPMessage.getInstance().setArEngineCtl(aVar);
        synchronized (this) {
            if (this.mArGLEngineCtl != null && !this.mIsInitNative) {
                nativeSetup(new WeakReference(this));
                this.mIsInitNative = true;
            }
        }
    }

    @Deprecated
    public void setEnginGLJniEnv() {
    }

    public void setGLThreadID(long j) {
        this.mCurrentGLThreadID = j;
    }

    public synchronized void setHtmlUpdateCallback(C0568b bVar) {
        this.mHtmlCallback = bVar;
    }

    public void setImuType(int i) {
        this.mImuType = i;
    }

    public void setInteraction(C0570d dVar) {
        this.mInteraction = dVar;
    }

    public void setIsAppBackground(boolean z) {
        this.mIsAppBackground = z;
    }

    public void setSize(final int i, final int i2) {
        executeOnGLThread(new Runnable() {
            public void run() {
                ARPEngine.this.nativeSetSize(i, i2);
            }
        });
    }

    public void setTouchOrientation(TouchOrientation touchOrientation) {
        this.mTouchOrientation = touchOrientation;
    }

    public synchronized void setUpdateCallback(C0571e eVar) {
        this.mUpdateCallback = eVar;
    }

    public void setValue(int i, String str, String str2) {
        if (this.mDataStore != null) {
            this.mDataStore.mo9049a(i, str, str2);
        } else {
            Log.e("ARPEngine", "set value error!");
        }
    }

    public synchronized void setVideoUpdateCallback(C0572f fVar) {
        this.mVideoCallback = fVar;
    }

    public void smallGameDestroy() {
        nativeSmallGameDestroy();
    }

    public int smallGameGetFPS() {
        return nativeSmallGameGetFPS();
    }

    public void smallGameUpdate() {
        nativeSmallGameUpdate();
    }

    @Deprecated
    public void surfaceViewCapture(C0567a aVar) {
        if (aVar != null) {
            aVar.mo9184a((Bitmap) null);
        }
    }

    public void update() {
        if (this.mUpdateCallback != null) {
            this.mUpdateCallback.mo8920a();
        }
        nativeUpdate();
    }

    public boolean updateFbos(int[] iArr) {
        return updateFrameBuffers(iArr);
    }

    /* access modifiers changed from: package-private */
    public native boolean updateFrameBuffers(int[] iArr);

    public void updateVideoFrame(String str, int i, String str2, String str3) {
        if (this.mVideoCallback != null) {
            this.mVideoCallback.mo9086a(str, i, str2, str3);
        }
    }

    public boolean updateWebViewFrame(int i, int i2) {
        if (this.mHtmlCallback != null) {
            return this.mHtmlCallback.mo9185a(i, i2);
        }
        return false;
    }
}
