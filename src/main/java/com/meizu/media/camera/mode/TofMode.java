package com.meizu.media.camera.mode;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import com.mediatek.media.MtkMediaStore;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.Thumbnail;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p070g.AudioRecorder;
import com.meizu.media.camera.p070g.HWRecorderWrapper;
import com.meizu.media.camera.p077ui.MzVideoUI;
import com.meizu.media.camera.singlebokeh.BokehAlorgrithmMgr;
import com.meizu.media.camera.singlebokeh.FaceRect;
import com.meizu.media.camera.stereobokeh.TofBokehMgr;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.cameraAlgorithm.yuv.YuvUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.p099b.AutoCloseable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001)\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0001\u0001B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u0011H\u0016J\u0010\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020EH\u0016J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GJ0\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001cH\u0002J(\u0010Q\u001a\u00020A2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\u001cJ\u0010\u0010W\u001a\u00020A2\u0006\u0010X\u001a\u00020\u0011H\u0002J\b\u0010Y\u001a\u00020AH\u0002J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020\u000eH\u0016J\n\u0010]\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010^\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010_H\u0016J\u0010\u0010a\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010_H\u0016J\n\u0010b\u001a\u0004\u0018\u00010SH\u0016J\b\u0010c\u001a\u00020AH\u0002J\b\u0010d\u001a\u00020\u0011H\u0016J\b\u0010e\u001a\u00020\u0011H\u0016J\u000e\u0010f\u001a\u00020A2\u0006\u0010g\u001a\u00020\u0011J\b\u0010h\u001a\u00020\u0011H\u0016J\b\u0010i\u001a\u00020\u001cH\u0016J\b\u0010j\u001a\u00020\u0011H\u0016J\b\u0010k\u001a\u00020AH\u0016J\b\u0010l\u001a\u00020AH\u0016J\u0018\u0010m\u001a\u00020A2\u0006\u0010n\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\u0011H\u0016J\b\u0010p\u001a\u00020AH\u0016J\b\u0010q\u001a\u00020AH\u0016J\"\u0010r\u001a\u00020A2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001cH\u0016J\b\u0010s\u001a\u00020AH\u0016J\u0012\u0010t\u001a\u00020A2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010u\u001a\u00020\u0011H\u0016J\b\u0010v\u001a\u00020AH\u0016J\u0012\u0010w\u001a\u00020A2\b\u0010x\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010y\u001a\u00020AH\u0016J\b\u0010z\u001a\u00020AH\u0016J\b\u0010{\u001a\u00020AH\u0016J\b\u0010|\u001a\u00020AH\u0016J\b\u0010}\u001a\u00020AH\u0016J\b\u0010~\u001a\u00020AH\u0016J\b\u0010\u001a\u00020AH\u0016JB\u0010\u0001\u001a\u00020A2\u0013\u0010\u0001\u001a\u000e\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020\u00112\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020AH\u0002J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020AH\u0002J\t\u0010\u0001\u001a\u00020AH\u0002J \u0010\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u00182\u0006\u0010R\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020\u001cR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo27294d2 = {"Lcom/meizu/media/camera/mode/TofMode;", "Lcom/meizu/media/camera/mode/CameraMode;", "Lcom/meizu/media/camera/mediacodec/AudioRecorder$AudioRecordCallback;", "Lcom/meizu/media/camera/stereobokeh/TofBokehMgr$RecordDataCallback;", "Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper$VideoSavedCallback;", "activity", "Lcom/meizu/media/camera/CameraActivity;", "paramsManager", "Lcom/meizu/media/camera/MzCamParamsManager;", "uicontroller", "Lcom/meizu/media/camera/MzUIController;", "mListener", "Lcom/meizu/media/camera/mode/CameraModeListener;", "type", "Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "(Lcom/meizu/media/camera/CameraActivity;Lcom/meizu/media/camera/MzCamParamsManager;Lcom/meizu/media/camera/MzUIController;Lcom/meizu/media/camera/mode/CameraModeListener;Lcom/meizu/media/camera/mode/CameraModeType$ModeType;)V", "isStoppingRecord", "", "mAudioRecorder", "Lcom/meizu/media/camera/mediacodec/AudioRecorder;", "mBokehengine", "", "mCanDoBokeh", "mCurrentVideoFilename", "", "mCurrentVideoValues", "Landroid/content/ContentValues;", "mDecodeHeight", "", "mDecodeWidth", "mImageReader", "Landroid/media/ImageReader;", "mImageReader2", "mInvalidValue", "mIsActivityPaused", "mIsCapture", "mIsRecordPortraitOn", "mIsRecording", "mMainHandler", "Lcom/meizu/media/camera/mode/TofMode$MyHandler;", "mOnVideoSavedListener", "com/meizu/media/camera/mode/TofMode$mOnVideoSavedListener$1", "Lcom/meizu/media/camera/mode/TofMode$mOnVideoSavedListener$1;", "mOrientation", "mPreviewFormat", "mPreviewHeight", "mPreviewWidth", "mRecordPause", "mRecordPauseStartTimes", "mRecordPauseTimes", "mRecorder", "Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper;", "mRecordingStartTime", "mRect", "Landroid/graphics/RectF;", "mReleased", "mSyncObject", "", "mSyncObjectImage1", "mSyncObjectImage2", "mTofBokehMgr", "Lcom/meizu/media/camera/stereobokeh/TofBokehMgr;", "mVideoUI", "Lcom/meizu/media/camera/ui/MzVideoUI;", "afterCameraResume", "", "canBurst", "capture", "uuid", "Ljava/util/UUID;", "cloneByteBuffer", "Ljava/nio/ByteBuffer;", "original", "convertDepthToFalseColor", "Landroid/graphics/Bitmap;", "depthBuffer", "Ljava/nio/ShortBuffer;", "w", "h", "stride", "scale", "doBokeh", "data", "", "width", "height", "rowstride", "enableShutterSound", "enable", "generateContentValues", "getFocusMode", "Lcom/meizu/media/camera/camcontroller/CameraController$FocusMode;", "getModeType", "getPictureSize", "getPreviewSurfaces", "", "Landroid/view/Surface;", "getPreviewSurfaces2", "getTofData", "initRecord", "isFlashTorchMode", "isModeWorking", "isRecordPortrait", "isOn", "needPlaySound", "needZsd", "onBackPressed", "onCameraClosed", "onCameraSwitched", "onModeMenuVisibilityChanged", "isVisible", "onModeChange", "onModeOutAnimStart", "onPreCameraSwitch", "onPreviewDataUpdate", "onPreviewStarted", "onRecordSample", "onShutterButtonClick", "onShutterButtonFocus", "onVideoSaved", "path", "pause", "pauseBeforeSuper", "pressRecordButton", "pressRecordPauseButton", "recordCaptureUsages", "release", "resume", "setFaces", "faces", "", "Lcom/meizu/media/camera/camcontroller/CameraController$FaceInfo;", "orientation", "isMirror", "cameraBound", "Landroid/graphics/Rect;", "([Lcom/meizu/media/camera/camcontroller/CameraController$FaceInfo;IZLandroid/graphics/Rect;)V", "stopPortraitRecording", "supportCountDown", "supportSquare", "updateRecordingTime", "updateUIController", "writeBitmap", "quality", "Companion", "MyHandler", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.mode.t */
public final class TofMode extends CameraMode implements AudioRecorder.C2077a, HWRecorderWrapper.C2083b, TofBokehMgr.C2373b {
    /* access modifiers changed from: private */

    /* renamed from: O */
    public static final LogUtil.C2630a f11114O = new LogUtil.C2630a("TofMode");

    /* renamed from: a */
    public static ChangeQuickRedirect f11115a;

    /* renamed from: b */
    public static final C2220a f11116b = new C2220a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final AudioRecorder f11117A = new AudioRecorder();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f11118B;

    /* renamed from: C */
    private int f11119C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public long f11120D;

    /* renamed from: E */
    private ContentValues f11121E = new ContentValues(12);

    /* renamed from: F */
    private int f11122F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public String f11123G;

    /* renamed from: H */
    private C2221b f11124H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f11125I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public int f11126J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public final Object f11127K = new Object();
    /* access modifiers changed from: private */

    /* renamed from: L */
    public final Object f11128L = new Object();

    /* renamed from: M */
    private final C2225f f11129M = new C2225f(this);
    /* access modifiers changed from: private */

    /* renamed from: N */
    public final CameraModeListener f11130N;

    /* renamed from: c */
    private boolean f11131c;

    /* renamed from: d */
    private ImageReader f11132d;

    /* renamed from: e */
    private ImageReader f11133e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TofBokehMgr f11134f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f11135g;

    /* renamed from: l */
    private boolean f11136l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Object f11137m = new Object();

    /* renamed from: n */
    private long f11138n = -1;

    /* renamed from: o */
    private long f11139o = -1;

    /* renamed from: p */
    private boolean f11140p;

    /* renamed from: q */
    private final RectF f11141q = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public MzVideoUI f11142r;

    /* renamed from: s */
    private boolean f11143s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f11144t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f11145u;

    /* renamed from: v */
    private boolean f11146v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f11147w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public long f11148x;

    /* renamed from: y */
    private long f11149y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final HWRecorderWrapper f11150z = new HWRecorderWrapper();

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: W */
    public void mo20544W() {
    }

    /* renamed from: n */
    public boolean mo20411n() {
        return false;
    }

    /* renamed from: t */
    public boolean mo20417t() {
        return false;
    }

    /* renamed from: u */
    public boolean mo20418u() {
        return false;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    @Nullable
    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TofMode(@NotNull CameraActivity cameraActivity, @NotNull MzCamParamsManager lVar, @NotNull MzUIController uVar, @NotNull CameraModeListener hVar, @NotNull CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        C3443i.m21155b(cameraActivity, PushConstants.INTENT_ACTIVITY_NAME);
        C3443i.m21155b(lVar, "paramsManager");
        C3443i.m21155b(uVar, "uicontroller");
        C3443i.m21155b(hVar, "mListener");
        C3443i.m21155b(modeType, "type");
        this.f11130N = hVar;
        LogUtil.m15952c(f11114O, "init");
        this.f11131c = false;
        if (this.f11134f == null) {
            this.f11134f = new TofBokehMgr(this.f11130N);
        }
        TofBokehMgr cVar = this.f11134f;
        if (cVar == null) {
            C3443i.m21151a();
        }
        cVar.mo21459a((TofBokehMgr.C2373b) this);
        m12016q();
        this.f11124H = new C2221b(this);
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J(\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, mo27294d2 = {"com/meizu/media/camera/mode/TofMode$mOnVideoSavedListener$1", "Lcom/meizu/media/camera/MediaSaveService$OnMediaSavedListener;", "onFileSaved", "", "file", "", "onFilesSaved", "files", "", "onGetThumbnail", "filePath", "inSampleSize", "", "orientation", "data", "", "onMediaSaved", "uri", "Landroid/net/Uri;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.t$f */
    /* compiled from: TofMode.kt */
    public static final class C2225f implements MediaSaveService.C1639d {

        /* renamed from: a */
        public static ChangeQuickRedirect f11160a;

        /* renamed from: b */
        final /* synthetic */ TofMode f11161b;

        /* renamed from: a */
        public void mo17846a(@NotNull String str, int i, int i2, @NotNull byte[] bArr) {
            Object[] objArr = {str, new Integer(i), new Integer(i2), bArr};
            ChangeQuickRedirect changeQuickRedirect = f11160a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5153, new Class[]{String.class, Integer.TYPE, Integer.TYPE, byte[].class}, Void.TYPE).isSupported) {
                C3443i.m21155b(str, "filePath");
                C3443i.m21155b(bArr, "data");
            }
        }

        /* renamed from: a */
        public void mo17847a(@NotNull List<String> list) {
            if (!PatchProxy.proxy(new Object[]{list}, this, f11160a, false, 5155, new Class[]{List.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(list, "files");
            }
        }

        C2225f(TofMode tVar) {
            this.f11161b = tVar;
        }

        /* renamed from: a */
        public void mo17844a(@Nullable Uri uri) {
            if (!PatchProxy.proxy(new Object[]{uri}, this, f11160a, false, 5152, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                Bitmap b = CameraUtil.m15872b(Thumbnail.m7941a(this.f11161b.f11123G, this.f11161b.f11118B, this.f11161b.f11150z.mo20133a()), 0, false);
                this.f11161b.f10787i.mo17673b(uri);
                this.f11161b.f10788j.mo21518a(uri);
                this.f11161b.f10788j.mo21515a(b);
                this.f11161b.f11123G = null;
            }
        }

        /* renamed from: a */
        public void mo17845a(@NotNull String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, f11160a, false, 5154, new Class[]{String.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(str, "file");
                this.f11161b.f10787i.mo17670a(str, true);
            }
        }
    }

    /* renamed from: a */
    public final void mo20654a(boolean z) {
        this.f11143s = z;
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11115a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5114, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            m12018r();
        }
    }

    /* renamed from: q */
    private final void m12016q() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5115, new Class[0], Void.TYPE).isSupported) {
            this.f11117A.mo20113a((AudioRecorder.C2077a) this);
            this.f11150z.mo20134a((HWRecorderWrapper.C2083b) this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ac  */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12018r() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f11115a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5116(0x13fc, float:7.169E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            r2 = 1
            if (r1 == 0) goto L_0x0051
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            java.lang.String r3 = "CameraController.getInstance().deviceProxy"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            int r1 = r1.mo19733b()
            if (r1 != r2) goto L_0x0051
            com.meizu.media.camera.u r1 = r8.mo20542U()
            int r3 = com.meizu.media.camera.MzUIController.f12303y
            r1.mo21592g((int) r3)
            com.meizu.media.camera.u r1 = r8.mo20542U()
            int r3 = com.meizu.media.camera.MzUIController.f12286h
            r1.mo21506a((int) r3)
            goto L_0x00a7
        L_0x0051:
            boolean r1 = r8.f11143s
            if (r1 == 0) goto L_0x0092
            com.meizu.media.camera.u r1 = r8.mo20542U()
            int r3 = com.meizu.media.camera.MzUIController.f12282d
            r1.mo21506a((int) r3)
            com.meizu.media.camera.u r1 = r8.mo20542U()
            r3 = 131660(0x2024c, float:1.84495E-40)
            r1.mo21592g((int) r3)
            com.meizu.media.camera.u r1 = r8.mo20542U()
            r1.mo21593g((boolean) r2)
            r8.m12002d((boolean) r0)
            com.meizu.media.camera.ui.ad r1 = r8.f11142r
            if (r1 != 0) goto L_0x00a7
            com.meizu.media.camera.mode.h r1 = r8.f11130N
            com.meizu.media.camera.ui.i r1 = r1.mo18267u()
            com.meizu.media.camera.ui.ad r1 = r1.mo22119ah()
            r8.f11142r = r1
            com.meizu.media.camera.ui.ad r1 = r8.f11142r
            if (r1 == 0) goto L_0x00a7
            com.meizu.media.camera.u r3 = r8.mo20542U()
            boolean[] r4 = new boolean[r2]
            r4[r0] = r2
            r1.mo21833a((com.meizu.media.camera.MzUIController) r3, (boolean[]) r4)
            goto L_0x00a7
        L_0x0092:
            com.meizu.media.camera.u r1 = r8.mo20542U()
            r3 = 524(0x20c, float:7.34E-43)
            r1.mo21506a((int) r3)
            com.meizu.media.camera.u r1 = r8.mo20542U()
            int r3 = com.meizu.media.camera.MzUIController.f12302x
            r1.mo21592g((int) r3)
            r8.m12002d((boolean) r2)
        L_0x00a7:
            boolean r1 = r8.f11143s
            if (r1 == 0) goto L_0x00ac
            return
        L_0x00ac:
            com.meizu.media.camera.u r1 = r8.f10788j
            r3 = 2
            r4 = 2131231265(0x7f080221, float:1.8078606E38)
            r1.mo21580d((int) r3, (int) r4)
            com.meizu.media.camera.u r1 = r8.f10788j
            r1.mo21581d((int) r2, (boolean) r2)
            com.meizu.media.camera.u r1 = r8.f10788j
            r1.mo21574c((int) r2, (boolean) r2)
            com.meizu.media.camera.u r1 = r8.f10788j
            r1.mo21593g((boolean) r0)
            com.meizu.media.camera.mode.h r0 = r8.f11130N
            com.meizu.media.camera.h r0 = r0.mo17914ak()
            if (r0 == 0) goto L_0x00d5
            com.meizu.media.camera.mode.h r0 = r8.f11130N
            com.meizu.media.camera.h r0 = r0.mo17914ak()
            r0.mo20230j(r2)
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.TofMode.m12018r():void");
    }

    @NotNull
    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    @NotNull
    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.TOF;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5117, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11114O, "release");
            this.f11130N.mo18052ak(false);
            this.f11130N.mo18055an(false);
            this.f11131c = true;
            this.f11143s = false;
            mo20542U().mo21559ax();
            C2221b bVar = this.f11124H;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages((Object) null);
            }
            m12002d(true);
            this.f11117A.mo20117e();
            this.f11117A.mo20113a((AudioRecorder.C2077a) null);
            this.f11150z.mo20134a((HWRecorderWrapper.C2083b) null);
            synchronized (this.f11137m) {
                if (this.f11134f != null) {
                    TofBokehMgr cVar = this.f11134f;
                    if (cVar == null) {
                        C3443i.m21151a();
                    }
                    cVar.mo21463c();
                    this.f11134f = null;
                }
                Unit tVar = Unit.f18749a;
            }
            synchronized (this.f11137m) {
                this.f11140p = false;
                if (this.f11138n != this.f11139o) {
                    BokehAlorgrithmMgr.uninit(this.f11138n, true);
                    this.f11138n = this.f11139o;
                }
                Unit tVar2 = Unit.f18749a;
            }
            if (this.f11130N.mo17914ak() != null) {
                this.f11130N.mo17914ak().mo20230j(false);
            }
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5118, new Class[0], Void.TYPE).isSupported) {
            C2221b bVar = this.f11124H;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages((Object) null);
            }
            this.f11135g = true;
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        this.f11135g = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0156, code lost:
        if (r0.mo18194dR() == 180) goto L_0x0158;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo20394a(@org.jetbrains.annotations.NotNull java.util.UUID r23) {
        /*
            r22 = this;
            r7 = r22
            r15 = r23
            r13 = 1
            java.lang.Object[] r0 = new java.lang.Object[r13]
            r14 = 0
            r0[r14] = r15
            com.meizu.savior.ChangeQuickRedirect r2 = f11115a
            java.lang.Class[] r5 = new java.lang.Class[r13]
            java.lang.Class<java.util.UUID> r1 = java.util.UUID.class
            r5[r14] = r1
            java.lang.Class r6 = java.lang.Boolean.TYPE
            r3 = 0
            r4 = 5119(0x13ff, float:7.173E-42)
            r1 = r22
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002a
            java.lang.Object r0 = r0.result
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x002a:
            java.lang.String r0 = "uuid"
            kotlin.jvm.p108b.C3443i.m21155b(r15, r0)
            com.meizu.media.camera.util.ac$a r0 = f11114O
            java.lang.String r1 = "capture"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            com.meizu.media.camera.mode.h r0 = r7.f11130N
            int r0 = r0.mo18211di()
            if (r0 == r13) goto L_0x020f
            com.meizu.media.camera.stereobokeh.c r0 = r7.f11134f
            if (r0 == 0) goto L_0x004c
            com.meizu.media.camera.stereobokeh.c r0 = r7.f11134f
            if (r0 != 0) goto L_0x0049
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0049:
            r0.mo21461b()
        L_0x004c:
            r7.f11136l = r13
            long r0 = java.lang.System.currentTimeMillis()
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            android.graphics.Point r2 = r2.mo19520j()
            if (r2 != 0) goto L_0x0069
            com.meizu.media.camera.util.ac$a r0 = f11114O
            java.lang.String r1 = "capture size is null!"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            return r13
        L_0x0069:
            boolean r3 = r7.f11143s
            if (r3 == 0) goto L_0x0073
            com.meizu.media.camera.CameraActivity r3 = r7.f10787i
            r3.mo17672a((boolean) r13)
            goto L_0x0078
        L_0x0073:
            com.meizu.media.camera.CameraActivity r3 = r7.f10787i
            r3.mo17672a((boolean) r14)
        L_0x0078:
            com.meizu.media.camera.mode.h r3 = r22.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.l r3 = r3.mo18195dS()
            r3.mo20318a((long) r0)
            java.lang.String r4 = "paramsManager"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            boolean r17 = r3.mo20347l()
            boolean r18 = r3.mo20349n()
            com.meizu.media.camera.Storage r3 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r4 = "Storage.getStorage()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r3.mo18652e((boolean) r13)
            com.meizu.media.camera.mode.h r3 = r7.f11130N
            com.meizu.media.camera.h r3 = r3.mo17914ak()
            r3.mo20242u()
            com.meizu.media.camera.l r3 = r22.mo20541T()
            r3.mo20341f()
            com.meizu.media.camera.l r3 = r22.mo20541T()
            r3.mo20350o()
            com.meizu.media.camera.CameraActivity r3 = r7.f10787i
            java.lang.String r4 = "mActivity"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r8 = r3.getApplicationContext()
            com.meizu.media.camera.mode.h r3 = r7.f11130N
            com.meizu.media.camera.app.e r3 = r3.mo18192dP()
            android.location.Location r9 = r3.mo19017a((long) r0)
            int r10 = r2.x
            int r11 = r2.y
            com.meizu.media.camera.mode.h r2 = r22.mo20539R()
            java.lang.String r3 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            int r2 = r2.mo18211di()
            com.meizu.media.camera.mode.h r3 = r22.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            int r3 = r3.mo18194dR()
            int r12 = com.meizu.media.camera.util.CameraUtil.m15882c((int) r2, (int) r3)
            r2 = 0
            r16 = 0
            boolean r3 = r7.f11143s
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r21 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_TOF_PICTURE
            r4 = 1
            r5 = 0
            r13 = r0
            r15 = r2
            r19 = r3
            r20 = r23
            android.content.Intent r0 = com.meizu.media.camera.CameraOptTask.m8338a((android.content.Context) r8, (android.location.Location) r9, (int) r10, (int) r11, (int) r12, (long) r13, (boolean) r15, (boolean) r16, (boolean) r17, (boolean) r18, (boolean) r19, (java.util.UUID) r20, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r21)
            com.meizu.media.camera.CameraActivity r1 = r7.f10787i
            android.content.Context r1 = (android.content.Context) r1
            com.meizu.media.camera.CameraOptTask.m8349a((android.content.Context) r1, (android.content.Intent) r0)
            com.meizu.media.camera.mode.h r0 = r7.f11130N
            int r0 = r0.mo18211di()
            r1 = -90
            r2 = 90
            r3 = 2
            if (r0 != r4) goto L_0x018a
            com.meizu.media.camera.u r0 = r22.mo20542U()
            java.lang.String r6 = "uiController"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r6)
            boolean r0 = r0.mo21615m()
            if (r0 == 0) goto L_0x018a
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r6 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r6)
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            boolean r0 = r0.mo22104aK()
            if (r0 == 0) goto L_0x0171
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r6 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r6)
            int r0 = r0.mo18194dR()
            if (r0 == 0) goto L_0x0158
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r6 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r6)
            int r0 = r0.mo18194dR()
            r6 = 180(0xb4, float:2.52E-43)
            if (r0 != r6) goto L_0x0171
        L_0x0158:
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r2 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r2)
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r2 != r6) goto L_0x016c
            r5 = 1
        L_0x016c:
            r0.mo22068a((int) r1, (int) r3, (boolean) r4, (boolean) r5)
            goto L_0x0209
        L_0x0171:
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r1 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r1 != r6) goto L_0x0185
            r5 = 1
        L_0x0185:
            r0.mo22067a((int) r2, (int) r3, (boolean) r5)
            goto L_0x0209
        L_0x018a:
            com.meizu.media.camera.mode.h r0 = r7.f11130N
            int r0 = r0.mo18211di()
            if (r0 != r4) goto L_0x01f2
            com.meizu.media.camera.u r0 = r22.mo20542U()
            java.lang.String r6 = "uiController"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r6)
            boolean r0 = r0.mo21615m()
            if (r0 != 0) goto L_0x01f2
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r6 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r6)
            int r0 = r0.mo18194dR()
            r6 = 270(0x10e, float:3.78E-43)
            if (r0 == r6) goto L_0x01da
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r6 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r6)
            int r0 = r0.mo18194dR()
            if (r0 != r2) goto L_0x01c2
            goto L_0x01da
        L_0x01c2:
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r2 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r2)
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r2 != r6) goto L_0x01d6
            r5 = 1
        L_0x01d6:
            r0.mo22067a((int) r1, (int) r3, (boolean) r5)
            goto L_0x0209
        L_0x01da:
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r1 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r1 != r6) goto L_0x01ee
            r5 = 1
        L_0x01ee:
            r0.mo22067a((int) r2, (int) r3, (boolean) r5)
            goto L_0x0209
        L_0x01f2:
            com.meizu.media.camera.mode.h r0 = r22.mo20539R()
            java.lang.String r1 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r1 != r6) goto L_0x0206
            r5 = 1
        L_0x0206:
            r0.mo22067a((int) r2, (int) r3, (boolean) r5)
        L_0x0209:
            com.meizu.media.camera.u r0 = r7.f10788j
            r0.mo21501X()
            return r4
        L_0x020f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.TofMode.mo20394a(java.util.UUID):boolean");
    }

    /* renamed from: v */
    public boolean mo20419v() {
        return !this.f11143s;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11115a, false, 5120, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f11145u) {
            return false;
        }
        m11989B();
        return true;
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5121, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            if (this.f10788j != null) {
                m12018r();
            }
            if (!this.f11143s && this.f11130N.mo18211di() != 1) {
                MzUIController U = mo20542U();
                CameraActivity cameraActivity = this.f10787i;
                C3443i.m21152a((Object) cameraActivity, "mActivity");
                U.mo21529a(cameraActivity.getResources().getString(R.string.mz_handle_focus_distance_hint), true, 5000);
            }
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5122, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            m12018r();
        }
    }

    /* renamed from: H */
    public void mo20383H() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5123, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11114O, "onCameraClosed");
            synchronized (this.f11137m) {
                this.f11140p = false;
                if (this.f11138n != this.f11139o) {
                    BokehAlorgrithmMgr.uninit(this.f11138n, true);
                    this.f11138n = this.f11139o;
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: Z */
    public void mo20451Z() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5124, new Class[0], Void.TYPE).isSupported) {
            super.mo20451Z();
            LogUtil.C2630a aVar = f11114O;
            LogUtil.m15942a(aVar, "onCameraSwitched: " + this.f11130N.mo18211di());
            if (this.f11130N.mo18211di() == 1) {
                synchronized (this.f11137m) {
                    if (this.f11134f != null) {
                        TofBokehMgr cVar = this.f11134f;
                        if (cVar == null) {
                            C3443i.m21151a();
                        }
                        cVar.mo21464d();
                    }
                    Unit tVar = Unit.f18749a;
                }
            }
        }
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5125, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11114O;
            LogUtil.m15942a(aVar, "onPreCameraSwitch: " + this.f11130N.mo18211di());
            this.f10788j.mo21641v(false);
            super.mo20379C();
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5126, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11114O, "onPreviewStarted");
            if (this.f11130N.mo18211di() == 1) {
                this.f10788j.mo21641v(true);
                this.f11140p = true;
                this.f11130N.mo18052ak(true);
                this.f11130N.mo18055an(false);
                if ((!CameraOptTask.m7849p() && DeviceHelper.f13878ae) || !CameraOptTask.m7846m()) {
                    CameraController g = CameraController.m8868g();
                    C3443i.m21152a((Object) g, "CameraController.getInstance()");
                    if (g.mo19522k() != null && this.f10788j != null && DeviceHelper.f13855aH) {
                        this.f10788j.mo21611l(true);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f11130N.mo18055an(true);
            this.f11130N.mo18052ak(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00dd, code lost:
        if (r1.mo19733b() == 1) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0108, code lost:
        if (r1.mo19733b() == 1) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x010a, code lost:
        r0.put("device_mark", com.meizu.media.camera.util.UsageStatsHelper.m16051e());
     */
    /* renamed from: I */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20384I() {
        /*
            r12 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f11115a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5127(0x1407, float:7.184E-42)
            r2 = r12
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.String r1 = "mode"
            java.lang.String r2 = "location"
            java.lang.String r3 = "voice"
            java.lang.String r4 = "meshline"
            java.lang.String r5 = "level"
            java.lang.String r6 = "time_mark"
            java.lang.String r7 = "count_down"
            java.lang.String r8 = "watch_projection"
            java.lang.String r9 = "sd_card"
            java.lang.String r10 = "mirror"
            java.lang.String r11 = "is_back_camera"
            java.lang.String[] r0 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11}
            com.meizu.media.camera.CameraActivity r1 = r12.f10787i
            android.content.Context r1 = (android.content.Context) r1
            com.meizu.media.camera.util.at r1 = com.meizu.media.camera.util.UsageStatsHelper.m16042a((android.content.Context) r1)
            java.util.Map r0 = r1.mo22688a((java.lang.String[]) r0)
            java.lang.String r1 = "usageMap"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = "capture_time"
            com.meizu.media.camera.mode.h r2 = r12.f11130N
            long r2 = r2.mo18186dJ()
            java.lang.String r2 = java.lang.Long.toString(r2)
            r0.put(r1, r2)
            java.lang.String r1 = "exposure"
            com.meizu.media.camera.mode.h r2 = r12.mo20539R()
            java.lang.String r3 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            com.meizu.media.camera.e r2 = r2.mo17902aE()
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9787d((com.meizu.media.camera.ComboPreferences) r2)
            r0.put(r1, r2)
            java.lang.String r1 = "face_num"
            com.meizu.media.camera.mode.h r2 = r12.f11130N
            com.meizu.media.camera.ui.i r2 = r2.mo18267u()
            int r2 = r2.mo22055R()
            java.lang.String r2 = java.lang.Integer.toString(r2)
            r0.put(r1, r2)
            java.lang.String r1 = "flash"
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            com.meizu.media.camera.camcontroller.CameraController$FlashMode r2 = r2.mo19534q()
            java.lang.String r2 = r2.key
            r0.put(r1, r2)
            java.lang.String r1 = "error mode"
            com.meizu.media.camera.mode.h r2 = r12.f11130N
            com.meizu.media.camera.h r2 = r2.mo17914ak()
            if (r2 == 0) goto L_0x00ae
            com.meizu.media.camera.mode.h r2 = r12.f11130N
            com.meizu.media.camera.h r2 = r2.mo17914ak()
            if (r2 == 0) goto L_0x00ae
            com.meizu.media.camera.camcontroller.CameraController$FocusMode r2 = r2.mo20225h()
            if (r2 == 0) goto L_0x00ae
            java.lang.String r1 = r2.getKey()
            java.lang.String r2 = "focus.key"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
        L_0x00ae:
            java.lang.String r2 = "focus_mode"
            r0.put(r2, r1)
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13879af
            r2 = 1
            if (r1 == 0) goto L_0x00df
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 == 0) goto L_0x00df
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            java.lang.String r3 = "CameraController.getInstance().deviceProxy"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            int r1 = r1.mo19733b()
            if (r1 != r2) goto L_0x010a
        L_0x00df:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13882ai
            if (r1 == 0) goto L_0x0113
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 == 0) goto L_0x0113
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            java.lang.String r3 = "CameraController.getInstance().deviceProxy"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            int r1 = r1.mo19733b()
            if (r1 != r2) goto L_0x0113
        L_0x010a:
            java.lang.String r1 = "device_mark"
            java.lang.String r2 = com.meizu.media.camera.util.UsageStatsHelper.m16051e()
            r0.put(r1, r2)
        L_0x0113:
            com.meizu.media.camera.CameraActivity r1 = r12.f10787i
            android.content.Context r1 = (android.content.Context) r1
            com.meizu.media.camera.util.at r1 = com.meizu.media.camera.util.UsageStatsHelper.m16042a((android.content.Context) r1)
            java.lang.String r2 = "capture_info"
            r1.mo22693a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.TofMode.mo20384I():void");
    }

    @Nullable
    /* renamed from: e */
    public List<Surface> mo20401e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11115a, false, 5128, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        synchronized (this.f11127K) {
            if (this.f11132d != null) {
                ImageReader imageReader = this.f11132d;
                if (imageReader == null) {
                    C3443i.m21151a();
                }
                imageReader.close();
            }
            Unit tVar = Unit.f18749a;
        }
        ArrayList arrayList = new ArrayList();
        CameraController g = CameraController.m8868g();
        C3443i.m21152a((Object) g, "cameraController");
        Point l = g.mo19524l();
        if (l != null) {
            int i = l.x;
            int i2 = l.y;
            this.f11118B = i;
            this.f11119C = i2;
            this.f11144t = 17;
            this.f11132d = ImageReader.newInstance(i, i2, 35, 2);
            ImageReader imageReader2 = this.f11132d;
            if (imageReader2 == null) {
                C3443i.m21151a();
            }
            CameraController g2 = CameraController.m8868g();
            C3443i.m21152a((Object) g2, "CameraController.getInstance()");
            imageReader2.setOnImageAvailableListener(new C2223d(this), g2.mo19518i());
            ImageReader imageReader3 = this.f11132d;
            if (imageReader3 == null) {
                C3443i.m21151a();
            }
            arrayList.add(imageReader3.getSurface());
        }
        return arrayList;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.t$d */
    /* compiled from: TofMode.kt */
    static final class C2223d implements ImageReader.OnImageAvailableListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11156a;

        /* renamed from: b */
        final /* synthetic */ TofMode f11157b;

        C2223d(TofMode tVar) {
            this.f11157b = tVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f9, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fb, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fc, code lost:
            r3 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00fe, code lost:
            kotlin.p099b.AutoCloseable.m20932a(r1, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0101, code lost:
            throw r0;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onImageAvailable(android.media.ImageReader r18) {
            /*
                r17 = this;
                r8 = r17
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r9 = 0
                r1[r9] = r18
                com.meizu.savior.ChangeQuickRedirect r3 = f11156a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<android.media.ImageReader> r2 = android.media.ImageReader.class
                r6[r9] = r2
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 5150(0x141e, float:7.217E-42)
                r2 = r17
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0020
                return
            L_0x0020:
                android.media.Image r1 = r18.acquireNextImage()
                java.lang.AutoCloseable r1 = (java.lang.AutoCloseable) r1
                r2 = 0
                r3 = r2
                java.lang.Throwable r3 = (java.lang.Throwable) r3
                r4 = r1
                android.media.Image r4 = (android.media.Image) r4     // Catch:{ Throwable -> 0x00fb }
                com.meizu.media.camera.mode.t r5 = r8.f11157b     // Catch:{ Throwable -> 0x00fb }
                boolean r5 = r5.f11135g     // Catch:{ Throwable -> 0x00fb }
                if (r5 == 0) goto L_0x0039
                kotlin.p099b.AutoCloseable.m20932a(r1, r3)
                return
            L_0x0039:
                r5 = r2
                java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5     // Catch:{ Throwable -> 0x00fb }
                r6 = r2
                byte[] r6 = (byte[]) r6     // Catch:{ Throwable -> 0x00fb }
                com.meizu.media.camera.mode.t r6 = r8.f11157b     // Catch:{ Throwable -> 0x00fb }
                java.lang.Object r6 = r6.f11127K     // Catch:{ Throwable -> 0x00fb }
                monitor-enter(r6)     // Catch:{ Throwable -> 0x00fb }
                java.lang.String r7 = "image"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r4, (java.lang.String) r7)     // Catch:{ all -> 0x00f6 }
                int r14 = r4.getWidth()     // Catch:{ all -> 0x00f6 }
                int r13 = r4.getHeight()     // Catch:{ all -> 0x00f6 }
                android.media.Image$Plane[] r7 = r4.getPlanes()     // Catch:{ all -> 0x00f6 }
                r7 = r7[r9]     // Catch:{ all -> 0x00f6 }
                java.lang.String r10 = "image.planes[0]"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ all -> 0x00f6 }
                int r7 = r7.getRowStride()     // Catch:{ all -> 0x00f6 }
                long r15 = r4.getTimestamp()     // Catch:{ all -> 0x00f6 }
                if (r14 == r7) goto L_0x006e
                byte[] r2 = com.meizu.media.camera.util.FormatUtil.m16273b(r4)     // Catch:{ all -> 0x00f6 }
                r11 = r2
                goto L_0x00a0
            L_0x006e:
                int r7 = r7 * r13
                int r7 = r7 * 3
                r5 = 2
                int r7 = r7 / r5
                java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r7)     // Catch:{ all -> 0x00f6 }
                if (r7 != 0) goto L_0x007d
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00f6 }
            L_0x007d:
                android.media.Image$Plane[] r10 = r4.getPlanes()     // Catch:{ all -> 0x00f6 }
                r9 = r10[r9]     // Catch:{ all -> 0x00f6 }
                java.nio.ByteBuffer r9 = r9.getBuffer()     // Catch:{ all -> 0x00f6 }
                java.nio.ByteBuffer r9 = r7.put(r9)     // Catch:{ all -> 0x00f6 }
                android.media.Image$Plane[] r10 = r4.getPlanes()     // Catch:{ all -> 0x00f6 }
                r5 = r10[r5]     // Catch:{ all -> 0x00f6 }
                java.nio.ByteBuffer r5 = r5.getBuffer()     // Catch:{ all -> 0x00f6 }
                r9.put(r5)     // Catch:{ all -> 0x00f6 }
                if (r7 == 0) goto L_0x009e
                byte[] r2 = r7.array()     // Catch:{ all -> 0x00f6 }
            L_0x009e:
                r11 = r2
                r5 = r7
            L_0x00a0:
                r4.close()     // Catch:{ all -> 0x00f6 }
                kotlin.t r2 = kotlin.Unit.f18749a     // Catch:{ all -> 0x00f6 }
                monitor-exit(r6)     // Catch:{ Throwable -> 0x00fb }
                com.meizu.media.camera.mode.t r2 = r8.f11157b     // Catch:{ Throwable -> 0x00fb }
                com.meizu.media.camera.mode.h r2 = r2.f11130N     // Catch:{ Throwable -> 0x00fb }
                int r2 = r2.mo18211di()     // Catch:{ Throwable -> 0x00fb }
                if (r2 != r0) goto L_0x00b8
                com.meizu.media.camera.mode.t r0 = r8.f11157b     // Catch:{ Throwable -> 0x00fb }
                r0.mo20656a((byte[]) r11, (int) r14, (int) r13, (int) r14)     // Catch:{ Throwable -> 0x00fb }
                goto L_0x00ea
            L_0x00b8:
                com.meizu.media.camera.mode.t r0 = r8.f11157b     // Catch:{ Throwable -> 0x00fb }
                java.lang.Object r2 = r0.f11137m     // Catch:{ Throwable -> 0x00fb }
                monitor-enter(r2)     // Catch:{ Throwable -> 0x00fb }
                com.meizu.media.camera.mode.t r0 = r8.f11157b     // Catch:{ all -> 0x00f3 }
                com.meizu.media.camera.stereobokeh.c r0 = r0.f11134f     // Catch:{ all -> 0x00f3 }
                if (r0 == 0) goto L_0x00e7
                com.meizu.media.camera.mode.t r0 = r8.f11157b     // Catch:{ all -> 0x00f3 }
                com.meizu.media.camera.mode.h r0 = r0.f11130N     // Catch:{ all -> 0x00f3 }
                boolean r0 = r0.mo18199dW()     // Catch:{ all -> 0x00f3 }
                if (r0 == 0) goto L_0x00e7
                com.meizu.media.camera.mode.t r0 = r8.f11157b     // Catch:{ all -> 0x00f3 }
                com.meizu.media.camera.stereobokeh.c r10 = r0.f11134f     // Catch:{ all -> 0x00f3 }
                if (r10 != 0) goto L_0x00de
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00f3 }
            L_0x00de:
                if (r11 != 0) goto L_0x00e3
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00f3 }
            L_0x00e3:
                r12 = r14
                r10.mo21460a((byte[]) r11, (int) r12, (int) r13, (int) r14, (long) r15)     // Catch:{ all -> 0x00f3 }
            L_0x00e7:
                kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ all -> 0x00f3 }
                monitor-exit(r2)     // Catch:{ Throwable -> 0x00fb }
            L_0x00ea:
                if (r5 == 0) goto L_0x00ef
                r5.clear()     // Catch:{ Throwable -> 0x00fb }
            L_0x00ef:
                kotlin.p099b.AutoCloseable.m20932a(r1, r3)
                return
            L_0x00f3:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ Throwable -> 0x00fb }
                throw r0     // Catch:{ Throwable -> 0x00fb }
            L_0x00f6:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ Throwable -> 0x00fb }
                throw r0     // Catch:{ Throwable -> 0x00fb }
            L_0x00f9:
                r0 = move-exception
                goto L_0x00fe
            L_0x00fb:
                r0 = move-exception
                r3 = r0
                throw r3     // Catch:{ all -> 0x00f9 }
            L_0x00fe:
                kotlin.p099b.AutoCloseable.m20932a(r1, r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.TofMode.C2223d.onImageAvailable(android.media.ImageReader):void");
        }
    }

    @Nullable
    /* renamed from: ai */
    public List<Surface> mo20554ai() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11115a, false, 5129, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        synchronized (this.f11128L) {
            if (this.f11133e != null) {
                ImageReader imageReader = this.f11133e;
                if (imageReader == null) {
                    C3443i.m21151a();
                }
                imageReader.close();
            }
            Unit tVar = Unit.f18749a;
        }
        ArrayList arrayList = new ArrayList();
        this.f11133e = ImageReader.newInstance(DeviceHelper.f14009da, DeviceHelper.f14010db, 1144402265, 2);
        ImageReader imageReader2 = this.f11133e;
        if (imageReader2 == null) {
            C3443i.m21151a();
        }
        CameraController g = CameraController.m8868g();
        C3443i.m21152a((Object) g, "CameraController.getInstance()");
        imageReader2.setOnImageAvailableListener(new C2224e(this), g.mo19518i());
        ImageReader imageReader3 = this.f11133e;
        if (imageReader3 == null) {
            C3443i.m21151a();
        }
        arrayList.add(imageReader3.getSurface());
        return arrayList;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.t$e */
    /* compiled from: TofMode.kt */
    static final class C2224e implements ImageReader.OnImageAvailableListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11158a;

        /* renamed from: b */
        final /* synthetic */ TofMode f11159b;

        C2224e(TofMode tVar) {
            this.f11159b = tVar;
        }

        public final void onImageAvailable(ImageReader imageReader) {
            int width;
            int height;
            int rowStride;
            long timestamp;
            ByteBuffer a;
            if (!PatchProxy.proxy(new Object[]{imageReader}, this, f11158a, false, 5151, new Class[]{ImageReader.class}, Void.TYPE).isSupported) {
                AutoCloseable acquireNextImage = imageReader.acquireNextImage();
                Throwable th = null;
                try {
                    Image image = (Image) acquireNextImage;
                    this.f11159b.f10788j.mo21641v(true);
                    if (this.f11159b.f11135g) {
                        AutoCloseable.m20932a(acquireNextImage, th);
                        return;
                    }
                    ByteBuffer byteBuffer = null;
                    synchronized (this.f11159b.f11128L) {
                        C3443i.m21152a((Object) image, "image");
                        width = image.getWidth();
                        height = image.getHeight();
                        Image.Plane plane = image.getPlanes()[0];
                        C3443i.m21152a((Object) plane, "image.planes[0]");
                        rowStride = plane.getRowStride();
                        timestamp = image.getTimestamp();
                        TofMode tVar = this.f11159b;
                        Image.Plane plane2 = image.getPlanes()[0];
                        C3443i.m21152a((Object) plane2, "image.planes[0]");
                        ByteBuffer buffer = plane2.getBuffer();
                        C3443i.m21152a((Object) buffer, "image.planes[0].buffer");
                        a = tVar.mo20653a(buffer);
                        image.close();
                        Unit tVar2 = Unit.f18749a;
                    }
                    if (this.f11159b.f11134f != null && this.f11159b.f11130N.mo18199dW()) {
                        if (a == null) {
                            C3443i.m21151a();
                        }
                        int remaining = a.remaining();
                        byte[] bArr = new byte[(height * rowStride)];
                        if (a == null) {
                            C3443i.m21151a();
                        }
                        a.get(bArr, 0, remaining);
                        TofBokehMgr g = this.f11159b.f11134f;
                        if (g == null) {
                            C3443i.m21151a();
                        }
                        g.mo21462b(bArr, width, height, rowStride, timestamp);
                    }
                    if (a != null) {
                        a.clear();
                    }
                    AutoCloseable.m20932a(acquireNextImage, th);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        AutoCloseable.m20932a(acquireNextImage, th3);
                        throw th4;
                    }
                }
            }
        }
    }

    /* renamed from: o */
    public void mo20412o() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5130, new Class[0], Void.TYPE).isSupported) {
            if (this.f11145u) {
                m11989B();
                return;
            }
            this.f11130N.mo18275x(1);
            C2221b bVar = this.f11124H;
            if (bVar == null) {
                C3443i.m21151a();
            }
            bVar.postDelayed(new C2226g(this), 200);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.t$g */
    /* compiled from: TofMode.kt */
    static final class C2226g implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11162a;

        /* renamed from: b */
        final /* synthetic */ TofMode f11163b;

        C2226g(TofMode tVar) {
            this.f11163b = tVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11162a, false, 5156, new Class[0], Void.TYPE).isSupported && !this.f11163b.f11145u) {
                this.f11163b.m11990K();
                HWRecorderWrapper k = this.f11163b.f11150z;
                int l = this.f11163b.f11125I;
                int m = this.f11163b.f11126J;
                int n = this.f11163b.f11144t;
                int a = this.f11163b.f11117A.mo20112a();
                int b = this.f11163b.f11117A.mo20114b();
                String p = this.f11163b.f11123G;
                if (p == null) {
                    C3443i.m21151a();
                }
                if (k.mo20137a(l, m, n, a, b, p, false, (MzCamcorderProfileManager) null)) {
                    this.f11163b.f11145u = true;
                    this.f11163b.f11147w = false;
                    this.f11163b.f11148x = 0;
                    this.f11163b.f11120D = SystemClock.uptimeMillis();
                    this.f11163b.f11117A.mo20115c();
                    this.f11163b.mo20542U().mo21532a(true, false);
                    this.f11163b.mo20542U().mo21569b(true, false);
                    this.f11163b.mo20542U().mo21631s();
                    MzVideoUI q = this.f11163b.f11142r;
                    if (q != null) {
                        q.mo21835a(true);
                    }
                    this.f11163b.m11991L();
                    LogUtil.m15952c(TofMode.f11114O, "start record");
                    return;
                }
                LogUtil.m15949b(TofMode.f11114O, "init recorder failed!");
            }
        }
    }

    /* renamed from: ad */
    public void mo20550ad() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5131, new Class[0], Void.TYPE).isSupported) {
            this.f11147w = !this.f11147w;
            if (!this.f11147w) {
                this.f11148x = (this.f11148x + SystemClock.uptimeMillis()) - this.f11149y;
                m11991L();
            } else {
                this.f11149y = SystemClock.uptimeMillis();
            }
            mo20542U().mo21601i(this.f11147w);
            this.f11150z.mo20135a(this.f11147w);
        }
    }

    /* renamed from: ac */
    public boolean mo20549ac() {
        return !this.f11145u;
    }

    @NotNull
    /* renamed from: a */
    public final ByteBuffer mo20653a(@NotNull ByteBuffer byteBuffer) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{byteBuffer}, this, f11115a, false, 5134, new Class[]{ByteBuffer.class}, ByteBuffer.class);
        if (proxy.isSupported) {
            return (ByteBuffer) proxy.result;
        }
        C3443i.m21155b(byteBuffer, "original");
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        byteBuffer.rewind();
        allocate.flip();
        C3443i.m21152a((Object) allocate, "clone");
        return allocate;
    }

    /* renamed from: a */
    public void mo20546a(@NotNull CameraController.C1880f<?>[] fVarArr, int i, boolean z, @Nullable Rect rect) {
        int i2;
        int i3;
        CameraController.C1880f<?>[] fVarArr2 = fVarArr;
        if (!PatchProxy.proxy(new Object[]{fVarArr2, new Integer(i), new Byte(z ? (byte) 1 : 0), rect}, this, f11115a, false, 5135, new Class[]{CameraController.C1880f[].class, Integer.TYPE, Boolean.TYPE, Rect.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(fVarArr2, "faces");
            int length = fVarArr2.length;
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            int w = h.mo14239w();
            EffectRenderContext h2 = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
            int x = h2.mo14240x();
            if (w < x) {
                i2 = w;
                i3 = x;
            } else {
                i3 = w;
                i2 = x;
            }
            Matrix matrix = new Matrix();
            f11116b.mo20657a(matrix, false, false, i, i3, i2);
            Matrix matrix2 = null;
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            if (g.mo19516h() == CameraController.CameraApi.API2 && rect != null) {
                matrix2 = new Matrix();
                matrix2.preTranslate(((float) (-rect.width())) / 2.0f, ((float) (-rect.height())) / 2.0f);
                matrix2.postScale(2000.0f / ((float) rect.width()), 2000.0f / ((float) rect.height()));
            }
            synchronized (this.f11137m) {
                if (this.f11130N.mo18211di() == 1) {
                    if (this.f11138n != this.f11139o) {
                        for (int i4 = 0; i4 < length; i4++) {
                            this.f11141q.set(new Rect(fVarArr2[i4].mo19557b().left, fVarArr2[i4].mo19557b().top, fVarArr2[i4].mo19557b().right, fVarArr2[i4].mo19557b().bottom));
                            if (matrix2 != null) {
                                matrix2.mapRect(this.f11141q);
                            }
                            matrix.mapRect(this.f11141q);
                            FaceRect cVar = new FaceRect((int) this.f11141q.bottom, (int) this.f11141q.left, (int) this.f11141q.right, (int) this.f11141q.top);
                            BokehAlorgrithmMgr.setFace(this.f11138n, length, i, cVar.mo21435b(), cVar.mo21437d(), cVar.mo21436c(), cVar.mo21434a(), i4);
                        }
                    } else {
                        return;
                    }
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: a */
    public final void mo20656a(@Nullable byte[] bArr, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3)}, this, f11115a, false, 5136, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f11137m) {
                if (this.f11130N.mo18185dI() && this.f11140p) {
                    if (this.f11138n == this.f11139o) {
                        this.f11138n = BokehAlorgrithmMgr.init(i, i2, i3, true);
                    }
                    if (bArr != null) {
                        System.currentTimeMillis();
                        BokehAlorgrithmMgr.previewProcess(this.f11138n, bArr, i, i2, i3, 0, 1.0f);
                        this.f11130N.mo18017a(bArr, i, i2, i3);
                    }
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: a */
    public void mo20118a(@Nullable byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f11115a, false, 5138, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if ((true ^ this.f11147w) && this.f11145u) {
                this.f11150z.mo20139b(bArr);
            }
        }
    }

    /* renamed from: a */
    public void mo20655a(@Nullable byte[] bArr, int i, int i2) {
        Object[] objArr = {bArr, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11115a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5139, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.f11145u) {
            if (this.f11122F != 0) {
                YuvUtil.rotateNV21Data(bArr, i, i2, this.f11122F, false);
            }
            HWRecorderWrapper cVar = this.f11150z;
            if (bArr == null) {
                C3443i.m21151a();
            }
            cVar.mo20136a(bArr);
        }
    }

    /* renamed from: a */
    public void mo20142a(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f11115a, false, 5140, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f11146v = false;
            this.f11145u = false;
            long uptimeMillis = (SystemClock.uptimeMillis() - this.f11120D) - this.f11148x;
            ContentValues contentValues = this.f11121E;
            if (str == null) {
                C3443i.m21151a();
            }
            contentValues.put("_size", Long.valueOf(new File(str).length()));
            this.f11121E.put("duration", Long.valueOf(uptimeMillis));
            CameraActivity cameraActivity = this.f10787i;
            C3443i.m21152a((Object) cameraActivity, "mActivity");
            cameraActivity.mo17689p().mo17830a(str, uptimeMillis, this.f11121E, this.f11129M, this.f11130N.mo18187dK());
        }
    }

    /* renamed from: k_ */
    public void mo20407k_() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5141, new Class[0], Void.TYPE).isSupported && this.f11145u) {
            m11989B();
        }
    }

    /* renamed from: l_ */
    public boolean mo20409l_() {
        return this.f11143s && this.f11145u;
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public final void m11989B() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5142, new Class[0], Void.TYPE).isSupported && !this.f11146v) {
            LogUtil.m15952c(f11114O, "stop record");
            this.f11146v = true;
            this.f11130N.mo18275x(2);
            mo20542U().mo21566b((int) R.string.mz_recording_save, true);
            mo20542U().mo21634t();
            this.f11117A.mo20116d();
            this.f11150z.mo20141d();
            mo20542U().mo21532a(false, false);
            mo20542U().mo21569b(false, false);
            MzVideoUI adVar = this.f11142r;
            if (adVar != null) {
                adVar.mo21834a("00:00:00", new boolean[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public final void m11990K() {
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5143, new Class[0], Void.TYPE).isSupported) {
            long currentTimeMillis = System.currentTimeMillis();
            String a = Storage.m7750a().mo18620a((Context) this.f10787i, currentTimeMillis);
            String str = a + ".mp4";
            this.f11123G = Storage.m7750a().mo18660i(str);
            File file = new File(Storage.m7750a().mo18665l());
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f11121E = new ContentValues(9);
            this.f11121E.put(PushConstants.TITLE, a);
            this.f11121E.put("_display_name", str);
            this.f11121E.put("datetaken", Long.valueOf(currentTimeMillis));
            this.f11121E.put("date_modified", Long.valueOf(currentTimeMillis / ((long) 1000)));
            this.f11121E.put("mime_type", "video/mp4");
            this.f11121E.put("_data", this.f11123G);
            this.f11121E.put("resolution", String.valueOf(this.f11118B) + "x" + String.valueOf(this.f11119C));
            this.f11121E.put("width", Integer.valueOf(this.f11118B));
            this.f11121E.put("height", Integer.valueOf(this.f11119C));
            int c = this.f11130N.mo18194dR() != -1 ? CameraUtil.m15882c(this.f11130N.mo18211di(), this.f11130N.mo18194dR()) : 0;
            this.f11125I = this.f11118B;
            this.f11126J = this.f11119C;
            if (((c / 90) & 1) == 1) {
                this.f11121E.put(MtkMediaStore.VideoColumns.ORIENTATION, 90);
                this.f11125I = this.f11119C;
                this.f11126J = this.f11118B;
            } else {
                this.f11121E.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
            }
            this.f11122F = c;
            this.f11121E.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(c));
            Location a2 = this.f11130N.mo18192dP().mo19017a(currentTimeMillis);
            if (a2 != null) {
                this.f11121E.put(Parameters.LATITUDE, Double.valueOf(a2.getLatitude()));
                this.f11121E.put(Parameters.LONGITUDE, Double.valueOf(a2.getLongitude()));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo27294d2 = {"com/meizu/media/camera/mode/TofMode$enableShutterSound$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.t$c */
    /* compiled from: TofMode.kt */
    public static final class C2222c extends AsyncTaskEx<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11154a;

        /* renamed from: b */
        final /* synthetic */ boolean f11155b;

        C2222c(boolean z) {
            this.f11155b = z;
        }

        @Nullable
        /* renamed from: a */
        public Void mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11154a, false, 5149, new Class[]{Void[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            C3443i.m21155b(voidArr, "params");
            CameraController.m8868g().mo19475a(this.f11155b);
            return null;
        }
    }

    /* renamed from: d */
    private final void m12002d(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11115a, false, 5144, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new C2222c(z).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public final void m11991L() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f11115a, false, 5145, new Class[0], Void.TYPE).isSupported && this.f11143s && this.f11145u && !this.f11147w && !this.f11146v) {
            long j = (long) 999;
            long max = Math.max(0, ((long) 600000) - ((SystemClock.uptimeMillis() - this.f11120D) - this.f11148x)) + j;
            if (this.f11142r != null) {
                String e = CameraUtil.m15894e(max - j);
                C3443i.m21152a((Object) e, "CameraUtil.remainSecondT…String(deltaAdjust - 999)");
                MzVideoUI adVar = this.f11142r;
                if (adVar == null) {
                    C3443i.m21151a();
                }
                adVar.mo21834a(e, true);
            }
            boolean z2 = this.f11145u;
            if (max - j <= 0) {
                z = true;
            }
            if (z && z2) {
                C2221b bVar = this.f11124H;
                if (bVar != null) {
                    bVar.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            C2221b bVar2 = this.f11124H;
            if (bVar2 != null) {
                bVar2.sendEmptyMessageDelayed(1, 1000);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo27294d2 = {"Lcom/meizu/media/camera/mode/TofMode$Companion;", "", "()V", "MAX_RECORD_DURATION", "", "MSG_STOP_RECORD", "MSG_UPDATE_RECORD_TIME", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "isTofIntent", "", "action", "", "prepareMatrix", "", "matrix", "Landroid/graphics/Matrix;", "mirror", "isWatchCamera", "displayOrientation", "viewWidth", "viewHeight", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.t$a */
    /* compiled from: TofMode.kt */
    public static final class C2220a {

        /* renamed from: a */
        public static ChangeQuickRedirect f11151a;

        private C2220a() {
        }

        public /* synthetic */ C2220a(DefaultConstructorMarker gVar) {
            this();
        }

        /* renamed from: a */
        public final void mo20657a(@NotNull Matrix matrix, boolean z, boolean z2, int i, int i2, int i3) {
            if (!PatchProxy.proxy(new Object[]{matrix, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3)}, this, f11151a, false, 5146, new Class[]{Matrix.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                C3443i.m21155b(matrix, "matrix");
                int i4 = -1;
                float f = (float) (z ? -1 : 1);
                if (!z2) {
                    i4 = 1;
                }
                matrix.setScale(f, (float) i4);
                float f2 = (float) i2;
                float f3 = (float) i3;
                matrix.postScale(f2 / 2000.0f, f3 / 2000.0f);
                matrix.postTranslate(f2 / 2.0f, f3 / 2.0f);
            }
        }

        /* renamed from: a */
        public final boolean mo20658a(@Nullable String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f11151a, false, 5147, new Class[]{String.class}, Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : C3443i.m21154a((Object) "meizu.intent.action.shortcut.TOF", (Object) str);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/media/camera/mode/TofMode$MyHandler;", "Landroid/os/Handler;", "tofMode", "Lcom/meizu/media/camera/mode/TofMode;", "(Lcom/meizu/media/camera/mode/TofMode;)V", "mTofModeWeakReference", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.t$b */
    /* compiled from: TofMode.kt */
    private static final class C2221b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f11152a;

        /* renamed from: b */
        private final WeakReference<TofMode> f11153b;

        public C2221b(@NotNull TofMode tVar) {
            C3443i.m21155b(tVar, "tofMode");
            this.f11153b = new WeakReference<>(tVar);
        }

        public void handleMessage(@NotNull Message message) {
            TofMode tVar;
            if (!PatchProxy.proxy(new Object[]{message}, this, f11152a, false, 5148, new Class[]{Message.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(message, NotificationCompat.CATEGORY_MESSAGE);
                if (this.f11153b.get() != null) {
                    if (message.what == 1) {
                        TofMode tVar2 = (TofMode) this.f11153b.get();
                        if (tVar2 != null) {
                            tVar2.m11991L();
                        }
                    } else if (message.what == 2 && (tVar = (TofMode) this.f11153b.get()) != null) {
                        tVar.m11989B();
                    }
                }
            }
        }
    }
}
