package com.meizu.media.camera.mode;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.p020ar.audio.AudioParams;
import com.baidu.p020ar.util.MsgConstants;
import com.mediatek.media.MtkMediaStore;
import com.mediatek.util.MtkPatterns;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.Thumbnail;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.p070g.AudioRecorder;
import com.meizu.media.camera.p070g.HWRecorderWrapper;
import com.meizu.media.camera.p077ui.MzNightVisionUI;
import com.meizu.media.camera.p077ui.MzVideoBaseUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.BitmapUtils;
import com.meizu.media.camera.util.C2644av;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.FormatUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.util.XmpUtilHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.p099b.AutoCloseable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001(\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0001\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020BH\u0016J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DJ\u0010\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\u0012H\u0002J\b\u0010K\u001a\u00020>H\u0002J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\rH\u0016J\n\u0010O\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010P\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010QH\u0016J\u000e\u0010S\u001a\u00020>2\u0006\u0010J\u001a\u00020\u0012J\b\u0010T\u001a\u00020>H\u0002J\b\u0010U\u001a\u00020>H\u0002J\b\u0010V\u001a\u00020\u0012H\u0016J\b\u0010W\u001a\u00020\u0012H\u0016J\b\u0010X\u001a\u00020\u0012H\u0016J\b\u0010Y\u001a\u00020\u0012H\u0016J\b\u0010Z\u001a\u00020\u0010H\u0016J\b\u0010[\u001a\u00020\u0012H\u0016J\b\u0010\\\u001a\u00020>H\u0016J\b\u0010]\u001a\u00020>H\u0016J\u0006\u0010^\u001a\u00020>J\u0018\u0010_\u001a\u00020>2\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0016J\b\u0010b\u001a\u00020>H\u0016J\b\u0010c\u001a\u00020>H\u0016J.\u0010d\u001a\u00020>2\u0006\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020,2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u0010J\b\u0010j\u001a\u00020>H\u0016J\b\u0010k\u001a\u00020>H\u0016J\u0012\u0010l\u001a\u00020>2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J\b\u0010o\u001a\u00020\u0012H\u0016J\b\u0010p\u001a\u00020>H\u0016J\u0012\u0010q\u001a\u00020>2\b\u0010e\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010r\u001a\u00020>H\u0016J\b\u0010s\u001a\u00020>H\u0016J\b\u0010t\u001a\u00020>H\u0016J\b\u0010u\u001a\u00020>H\u0016J\b\u0010v\u001a\u00020>H\u0002J\b\u0010w\u001a\u00020>H\u0016J\b\u0010x\u001a\u00020>H\u0016J\b\u0010y\u001a\u00020>H\u0016J\b\u0010z\u001a\u00020>H\u0002J\b\u0010{\u001a\u00020>H\u0002J\b\u0010|\u001a\u00020\u0012H\u0016J\b\u0010}\u001a\u00020\u0012H\u0016J\u0011\u0010~\u001a\u00020>2\u0007\u0010\u001a\u00030\u0001H\u0016J$\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010g\u001a\u00020\u00182\u0006\u0010f\u001a\u00020,2\u0006\u0010e\u001a\u00020\u0018H\u0002J\u0019\u0010\u0001\u001a\u00020>2\u0006\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020,H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J!\u0010\u0001\u001a\u00020>2\u0006\u0010e\u001a\u00020\u00182\u0007\u0010m\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0010R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo27294d2 = {"Lcom/meizu/media/camera/mode/NightVisionMode;", "Lcom/meizu/media/camera/mode/CameraMode;", "Lcom/meizu/media/camera/mediacodec/AudioRecorder$AudioRecordCallback;", "Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper$VideoSavedCallback;", "activity", "Lcom/meizu/media/camera/CameraActivity;", "paramsManager", "Lcom/meizu/media/camera/MzCamParamsManager;", "uicontroller", "Lcom/meizu/media/camera/MzUIController;", "mListener", "Lcom/meizu/media/camera/mode/CameraModeListener;", "type", "Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "(Lcom/meizu/media/camera/CameraActivity;Lcom/meizu/media/camera/MzCamParamsManager;Lcom/meizu/media/camera/MzUIController;Lcom/meizu/media/camera/mode/CameraModeListener;Lcom/meizu/media/camera/mode/CameraModeType$ModeType;)V", "ABANDON_FRAME_NUM", "", "isStoppingRecord", "", "mAbandonFrameCount", "mAudioRecorder", "Lcom/meizu/media/camera/mediacodec/AudioRecorder;", "mCurrentRecord", "mCurrentVideoFilename", "", "mCurrentVideoValues", "Landroid/content/ContentValues;", "mDecodeHeight", "mDecodeWidth", "mDoingCapture", "mImageReader", "Landroid/media/ImageReader;", "mImageReader2", "mIsActivityPaused", "mIsRecording", "mMainHandler", "Lcom/meizu/media/camera/mode/NightVisionMode$MyHandler;", "mNightVisionUI", "Lcom/meizu/media/camera/ui/MzNightVisionUI;", "mOnVideoSavedListener", "com/meizu/media/camera/mode/NightVisionMode$mOnVideoSavedListener$1", "Lcom/meizu/media/camera/mode/NightVisionMode$mOnVideoSavedListener$1;", "mOrientation", "mPicDate", "", "mPicHeight", "mPicPath", "mPicTitle", "mPicWidth", "mPreviewFormat", "mPreviewHeight", "mPreviewWidth", "mRecordPause", "mRecordPauseStartTimes", "mRecordPauseTimes", "mRecorder", "Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper;", "mRecordingStartTime", "mReleased", "mVideoBaseUI", "Lcom/meizu/media/camera/ui/MzVideoBaseUI;", "afterCameraResume", "", "canBurst", "capture", "uuid", "Ljava/util/UUID;", "cloneByteBuffer", "Ljava/nio/ByteBuffer;", "original", "convertDepth", "src", "", "enableShutterSound", "enable", "generateContentValues", "getFocusMode", "Lcom/meizu/media/camera/camcontroller/CameraController$FocusMode;", "getModeType", "getPictureSize", "getPreviewSurfaces2", "", "Landroid/view/Surface;", "handleRecordState", "initRecord", "initUI", "isFlashTorchMode", "isModeWorking", "isSingleTapUp", "needPlaySound", "needZsd", "onBackPressed", "onCameraClosed", "onCameraSwitched", "onDepthFrameAvailable", "onModeMenuVisibilityChanged", "isVisible", "onModeChange", "onModeOutAnimEnd", "onModeOutAnimStart", "onPictureTaken", "path", "date", "title", "width", "height", "onPreCameraSwitch", "onPreviewStarted", "onRecordSample", "data", "", "onShutterButtonClick", "onShutterButtonFocus", "onVideoSaved", "pause", "pauseBeforeSuper", "pressRecordButton", "pressRecordPauseButton", "recordCaptureInfo", "recordCaptureUsages", "release", "resume", "startRecording", "stopRecording", "supportCountDown", "supportSquare", "updateAspectRatio", "ratio", "", "updatePicContentValue", "Landroid/net/Uri;", "updatePicExifValues", "updateRecordingTime", "updateUIController", "writeBitmap", "Landroid/graphics/Bitmap;", "quality", "Companion", "MyHandler", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.mode.n */
public final class NightVisionMode extends CameraMode implements AudioRecorder.C2077a, HWRecorderWrapper.C2083b {
    /* access modifiers changed from: private */

    /* renamed from: L */
    public static final LogUtil.C2630a f10906L = new LogUtil.C2630a("NightVisionMode");

    /* renamed from: a */
    public static ChangeQuickRedirect f10907a;

    /* renamed from: b */
    public static final C2190a f10908b = new C2190a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f10909A;

    /* renamed from: B */
    private MzVideoBaseUI f10910B;

    /* renamed from: C */
    private boolean f10911C;

    /* renamed from: D */
    private String f10912D;

    /* renamed from: E */
    private long f10913E = -1;

    /* renamed from: F */
    private String f10914F;

    /* renamed from: G */
    private boolean f10915G = true;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public final int f10916H = 2;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f10917I;

    /* renamed from: J */
    private final C2194e f10918J = new C2194e(this);
    /* access modifiers changed from: private */

    /* renamed from: K */
    public final CameraModeListener f10919K;

    /* renamed from: c */
    private boolean f10920c;

    /* renamed from: d */
    private ImageReader f10921d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f10922e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MzNightVisionUI f10923f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f10924g = 42;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f10925l;

    /* renamed from: m */
    private boolean f10926m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f10927n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public long f10928o;

    /* renamed from: p */
    private long f10929p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final HWRecorderWrapper f10930q = new HWRecorderWrapper();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final AudioRecorder f10931r = new AudioRecorder();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f10932s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f10933t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public long f10934u;

    /* renamed from: v */
    private ContentValues f10935v = new ContentValues(12);
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f10936w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public String f10937x;

    /* renamed from: y */
    private C2191b f10938y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f10939z;

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: W */
    public void mo20544W() {
    }

    /* renamed from: m */
    public boolean mo20410m() {
        return true;
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

    /* renamed from: v */
    public boolean mo20419v() {
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
    public NightVisionMode(@NotNull CameraActivity cameraActivity, @NotNull MzCamParamsManager lVar, @NotNull MzUIController uVar, @NotNull CameraModeListener hVar, @NotNull CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        C3443i.m21155b(cameraActivity, PushConstants.INTENT_ACTIVITY_NAME);
        C3443i.m21155b(lVar, "paramsManager");
        C3443i.m21155b(uVar, "uicontroller");
        C3443i.m21155b(hVar, "mListener");
        C3443i.m21155b(modeType, "type");
        this.f10919K = hVar;
        LogUtil.m15952c(f10906L, "init");
        this.f10920c = false;
        m11687K();
        this.f10938y = new C2191b(this);
        if (this.f10910B == null) {
            this.f10910B = this.f10919K.mo18267u().mo22120ai();
        }
        if (this.f10923f == null) {
            this.f10923f = this.f10919K.mo18267u().mo22057T();
            MzNightVisionUI uVar2 = this.f10923f;
            if (uVar2 == null) {
                C3443i.m21151a();
            }
            MzUIController U = mo20542U();
            C3443i.m21152a((Object) U, "uiController");
            uVar2.mo22522a(U);
        }
        MzVideoBaseUI acVar = this.f10910B;
        if (acVar != null) {
            acVar.mo21822a();
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J(\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, mo27294d2 = {"com/meizu/media/camera/mode/NightVisionMode$mOnVideoSavedListener$1", "Lcom/meizu/media/camera/MediaSaveService$OnMediaSavedListener;", "onFileSaved", "", "file", "", "onFilesSaved", "files", "", "onGetThumbnail", "filePath", "inSampleSize", "", "orientation", "data", "", "onMediaSaved", "uri", "Landroid/net/Uri;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.n$e */
    /* compiled from: NightVisionMode.kt */
    public static final class C2194e implements MediaSaveService.C1639d {

        /* renamed from: a */
        public static ChangeQuickRedirect f10946a;

        /* renamed from: b */
        final /* synthetic */ NightVisionMode f10947b;

        /* renamed from: a */
        public void mo17846a(@NotNull String str, int i, int i2, @NotNull byte[] bArr) {
            Object[] objArr = {str, new Integer(i), new Integer(i2), bArr};
            ChangeQuickRedirect changeQuickRedirect = f10946a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4974, new Class[]{String.class, Integer.TYPE, Integer.TYPE, byte[].class}, Void.TYPE).isSupported) {
                C3443i.m21155b(str, "filePath");
                C3443i.m21155b(bArr, "data");
            }
        }

        /* renamed from: a */
        public void mo17847a(@NotNull List<String> list) {
            if (!PatchProxy.proxy(new Object[]{list}, this, f10946a, false, 4976, new Class[]{List.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(list, "files");
            }
        }

        C2194e(NightVisionMode nVar) {
            this.f10947b = nVar;
        }

        /* renamed from: a */
        public void mo17844a(@Nullable Uri uri) {
            if (!PatchProxy.proxy(new Object[]{uri}, this, f10946a, false, 4973, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                Bitmap b = CameraUtil.m15872b(Thumbnail.m7941a(this.f10947b.f10937x, this.f10947b.f10932s, this.f10947b.f10930q.mo20133a()), 0, false);
                this.f10947b.f10787i.mo17673b(uri);
                this.f10947b.f10788j.mo21518a(uri);
                this.f10947b.f10788j.mo21515a(b);
                this.f10947b.f10937x = null;
            }
        }

        /* renamed from: a */
        public void mo17845a(@NotNull String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, f10946a, false, 4975, new Class[]{String.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(str, "file");
                this.f10947b.f10787i.mo17670a(str, true);
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10907a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4933, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10906L;
            LogUtil.m15952c(aVar, "onModeMenuVisibilityChanged : isVisible" + z + "onModeChange" + z2);
            if (z || this.f10788j == null || (CameraModeType.m10957c(this.f10789k) && (!CameraModeType.m10957c(this.f10789k) || z2))) {
                mo20542U().mo21574c(16, false);
                mo20542U().mo21574c(256, false);
                return;
            }
            m11725r();
        }
    }

    /* renamed from: r */
    private final void m11725r() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4934, new Class[0], Void.TYPE).isSupported) {
            mo20542U().mo21506a(512);
            mo20542U().mo21592g(0);
            mo20542U().mo21589f(true);
            m11709d(false);
            if (this.f10923f == null) {
                this.f10923f = this.f10919K.mo18267u().mo22057T();
                MzNightVisionUI uVar = this.f10923f;
                if (uVar != null) {
                    MzUIController U = mo20542U();
                    C3443i.m21152a((Object) U, "uiController");
                    uVar.mo22522a(U);
                }
            }
            if (this.f10910B == null) {
                this.f10910B = this.f10919K.mo18267u().mo22120ai();
            }
            if (this.f10919K.mo17914ak() != null) {
                this.f10919K.mo17914ak().mo20230j(false);
            }
            if (this.f10915G) {
                mo20542U().mo21574c(16, true);
                mo20542U().mo21574c(256, false);
                mo20542U().mo21593g(true);
                return;
            }
            mo20542U().mo21574c(16, false);
            mo20542U().mo21574c(256, true);
            mo20542U().mo21593g(false);
        }
    }

    @NotNull
    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    @NotNull
    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.NightVision;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4935, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10906L, "release");
            this.f10919K.mo18054am(false);
            this.f10920c = true;
            if (this.f10919K.mo17914ak() != null) {
                this.f10919K.mo17914ak().mo20230j(false);
            }
            C2191b bVar = this.f10938y;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages((Object) null);
            }
            m11709d(true);
            this.f10931r.mo20117e();
            this.f10931r.mo20113a((AudioRecorder.C2077a) null);
            this.f10930q.mo20134a((HWRecorderWrapper.C2083b) null);
            MzVideoBaseUI acVar = this.f10910B;
            if (acVar != null) {
                acVar.mo21829e();
            }
            MzNightVisionUI uVar = this.f10923f;
            if (uVar != null) {
                uVar.mo22525b();
            }
            if (this.f10788j != null) {
                this.f10788j.mo21574c(16, false);
                this.f10788j.mo21574c(256, false);
                this.f10788j.mo21533a(false, false, false);
            }
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4936, new Class[0], Void.TYPE).isSupported) {
            C2191b bVar = this.f10938y;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages((Object) null);
            }
            this.f10922e = true;
            MzVideoBaseUI acVar = this.f10910B;
            if (acVar != null) {
                acVar.mo21824a(this.f10919K.mo18211di());
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4937, new Class[0], Void.TYPE).isSupported) {
            this.f10922e = false;
            MzVideoBaseUI acVar = this.f10910B;
            if (acVar != null) {
                acVar.mo21828d();
            }
        }
    }

    /* renamed from: a */
    public void mo20452a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f10907a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4938, new Class[]{Float.TYPE}, Void.TYPE).isSupported && this.f10910B != null) {
            MzVideoBaseUI acVar = this.f10910B;
            if (acVar == null) {
                C3443i.m21151a();
            }
            acVar.mo21823a(f);
        }
    }

    /* renamed from: a */
    public boolean mo20394a(@NotNull UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f10907a, false, 4939, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(uuid, "uuid");
        File file = new File(Storage.m7750a().mo18669n());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f10913E = this.f10919K.mo18186dJ();
        this.f10914F = CameraUtil.m15831a(this.f10913E);
        LogUtil.C2630a aVar = f10906L;
        LogUtil.m15942a(aVar, "capture: " + this.f10914F);
        this.f10912D = Storage.m7750a().mo18644c(this.f10914F);
        mo20539R().mo18275x(3);
        this.f10788j.mo21614m(false);
        if (this.f10919K.mo18194dR() != -1) {
            this.f10936w = CameraUtil.m15882c(this.f10919K.mo18211di(), this.f10919K.mo18194dR());
        }
        this.f10911C = true;
        return true;
    }

    /* renamed from: a */
    public final void mo20604a(@NotNull String str, long j, @NotNull String str2, int i, int i2) {
        String str3 = str;
        String str4 = str2;
        if (!PatchProxy.proxy(new Object[]{str3, new Long(j), str4, new Integer(i), new Integer(i2)}, this, f10907a, false, 4940, new Class[]{String.class, Long.TYPE, String.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(str3, "path");
            C3443i.m21155b(str4, PushConstants.TITLE);
            C2191b bVar = this.f10938y;
            if (bVar != null) {
                bVar.post(new C2195f(this, str2, j, str, i, i2));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.n$f */
    /* compiled from: NightVisionMode.kt */
    static final class C2195f implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10948a;

        /* renamed from: b */
        final /* synthetic */ NightVisionMode f10949b;

        /* renamed from: c */
        final /* synthetic */ String f10950c;

        /* renamed from: d */
        final /* synthetic */ long f10951d;

        /* renamed from: e */
        final /* synthetic */ String f10952e;

        /* renamed from: f */
        final /* synthetic */ int f10953f;

        /* renamed from: g */
        final /* synthetic */ int f10954g;

        C2195f(NightVisionMode nVar, String str, long j, String str2, int i, int i2) {
            this.f10949b = nVar;
            this.f10950c = str;
            this.f10951d = j;
            this.f10952e = str2;
            this.f10953f = i;
            this.f10954g = i2;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10948a, false, 4977, new Class[0], Void.TYPE).isSupported) {
                Uri a = this.f10949b.m11693a(this.f10950c, this.f10951d, this.f10952e);
                this.f10949b.m11701a(this.f10952e, this.f10951d);
                if (this.f10949b.f10787i != null) {
                    this.f10949b.f10787i.mo17673b(a);
                    this.f10949b.f10788j.mo21518a(a);
                    this.f10949b.f10919K.mo18122c(true);
                    this.f10949b.f10787i.mo17670a(this.f10952e, false);
                    this.f10949b.f10788j.mo21517a((Bitmap) null, (byte[]) null, this.f10952e, 0, 0, false, this.f10953f, this.f10954g, this.f10949b.f10919K.mo18200dX());
                }
            }
        }
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10907a, false, 4941, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f10925l) {
            return false;
        }
        m11689M();
        return true;
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4942, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            if (this.f10788j != null) {
                m11725r();
            }
            MzVideoBaseUI acVar = this.f10910B;
            if (acVar != null) {
                acVar.mo21826b();
            }
            MzNightVisionUI uVar = this.f10923f;
            if (uVar != null) {
                uVar.mo22521a();
            }
        }
    }

    /* renamed from: ag */
    public void mo20552ag() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4943, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10906L, "onModeOutAnimEnd");
            MzVideoBaseUI acVar = this.f10910B;
            if (acVar != null) {
                acVar.mo21827c();
            }
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4944, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            m11725r();
        }
    }

    /* renamed from: H */
    public void mo20383H() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4945, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10906L, "onCameraClosed");
        }
    }

    /* renamed from: Z */
    public void mo20451Z() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4946, new Class[0], Void.TYPE).isSupported) {
            super.mo20451Z();
        }
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4947, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10906L;
            LogUtil.m15942a(aVar, "onPreCameraSwitch: " + this.f10919K.mo18211di());
            this.f10788j.mo21641v(false);
            super.mo20379C();
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4948, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10906L, "onPreviewStarted");
            this.f10919K.mo18054am(true);
        }
    }

    /* renamed from: B */
    private final void m11686B() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4949, new Class[0], Void.TYPE).isSupported) {
            UsageStatsHelper.m16042a((Context) this.f10787i).mo22693a("capture_info", UsageStatsHelper.m16042a((Context) this.f10787i).mo22688a(new String[]{"mode", "is_back_camera"}));
        }
    }

    /* renamed from: I */
    public void mo20384I() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4950, new Class[0], Void.TYPE).isSupported) {
            UsageStatsHelper.m16042a((Context) this.f10787i).mo22693a("capture_info", UsageStatsHelper.m16042a((Context) this.f10787i).mo22688a(new String[]{"mode", "is_back_camera"}));
        }
    }

    /* renamed from: c */
    public final void mo20606c() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4951, new Class[0], Void.TYPE).isSupported && this.f10925l) {
            this.f10930q.mo20140c();
        }
    }

    @Nullable
    /* renamed from: ai */
    public List<Surface> mo20554ai() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10907a, false, 4952, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f10921d != null) {
            ImageReader imageReader = this.f10921d;
            if (imageReader == null) {
                C3443i.m21151a();
            }
            imageReader.close();
        }
        ArrayList arrayList = new ArrayList();
        int i = DeviceHelper.f14009da;
        int i2 = DeviceHelper.f14010db;
        this.f10917I = 0;
        this.f10921d = ImageReader.newInstance(i, i2, 1144402265, 2);
        ImageReader imageReader2 = this.f10921d;
        if (imageReader2 == null) {
            C3443i.m21151a();
        }
        CameraController g = CameraController.m8868g();
        C3443i.m21152a((Object) g, "CameraController.getInstance()");
        imageReader2.setOnImageAvailableListener(new C2193d(this), g.mo19518i());
        ImageReader imageReader3 = this.f10921d;
        if (imageReader3 == null) {
            C3443i.m21151a();
        }
        arrayList.add(imageReader3.getSurface());
        return arrayList;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.n$d */
    /* compiled from: NightVisionMode.kt */
    static final class C2193d implements ImageReader.OnImageAvailableListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f10944a;

        /* renamed from: b */
        final /* synthetic */ NightVisionMode f10945b;

        C2193d(NightVisionMode nVar) {
            this.f10945b = nVar;
        }

        public final void onImageAvailable(ImageReader imageReader) {
            Throwable th;
            if (!PatchProxy.proxy(new Object[]{imageReader}, this, f10944a, false, 4972, new Class[]{ImageReader.class}, Void.TYPE).isSupported) {
                AutoCloseable acquireNextImage = imageReader.acquireNextImage();
                Throwable th2 = null;
                try {
                    Image image = (Image) acquireNextImage;
                    this.f10945b.f10788j.mo21641v(true);
                    if (this.f10945b.f10922e) {
                        AutoCloseable.m20932a(acquireNextImage, th2);
                        return;
                    }
                    C3443i.m21152a((Object) image, "image");
                    int width = image.getWidth();
                    int height = image.getHeight();
                    Image.Plane plane = image.getPlanes()[0];
                    C3443i.m21152a((Object) plane, "image.planes[0]");
                    int rowStride = plane.getRowStride();
                    image.getTimestamp();
                    this.f10945b.f10932s = width;
                    this.f10945b.f10933t = height;
                    ByteBuffer byteBuffer = null;
                    NightVisionMode nVar = this.f10945b;
                    Image.Plane plane2 = image.getPlanes()[0];
                    C3443i.m21152a((Object) plane2, "image.planes[0]");
                    ByteBuffer buffer = plane2.getBuffer();
                    C3443i.m21152a((Object) buffer, "image.planes[0].buffer");
                    ByteBuffer a = nVar.mo20603a(buffer);
                    image.close();
                    if (this.f10945b.f10919K.mo18196dT()) {
                        byte[] bArr = new byte[(height * rowStride)];
                        a.get(bArr, 0, a.remaining());
                        NightVisionMode nVar2 = this.f10945b;
                        short[] a2 = C2644av.m16109a(bArr);
                        C3443i.m21152a((Object) a2, "Utils.toShortArray(previewBuffer)");
                        nVar2.m11702a(a2);
                    }
                    a.clear();
                    if (this.f10945b.f10917I >= this.f10945b.f10916H) {
                        MzNightVisionUI h = this.f10945b.f10923f;
                        if (h == null) {
                            C3443i.m21151a();
                        }
                        h.mo22527d();
                        Unit tVar = Unit.f18749a;
                    } else {
                        NightVisionMode nVar3 = this.f10945b;
                        int f = nVar3.f10917I;
                        nVar3.f10917I = f + 1;
                        Integer.valueOf(f);
                    }
                    AutoCloseable.m20932a(acquireNextImage, th2);
                } catch (Throwable th3) {
                    AutoCloseable.m20932a(acquireNextImage, th);
                    throw th3;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11702a(short[] sArr) {
        if (!PatchProxy.proxy(new Object[]{sArr}, this, f10907a, false, 4954, new Class[]{short[].class}, Void.TYPE).isSupported) {
            int length = sArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                if (sArr[i] <= 700) {
                    iArr[i] = Color.rgb(((sArr[i] * 175) / MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION) + 80, 0, 0);
                } else if (sArr[i] > 700 && sArr[i] <= 1500) {
                    iArr[i] = Color.rgb(255, ((sArr[i] - MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION) * 125) / 800, 0);
                } else if (sArr[i] > 1500 && sArr[i] <= 2200) {
                    iArr[i] = Color.rgb(255, (((sArr[i] - 1500) * 125) / MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION) + 125, 0);
                } else if (sArr[i] > 2200 && sArr[i] <= 3200) {
                    iArr[i] = Color.rgb(255 - (((sArr[i] - 2200) * 255) / 1000), 255, 0);
                } else if (sArr[i] > 3200 && sArr[i] <= 5000) {
                    iArr[i] = Color.rgb(0, 255, ((sArr[i] - 3200) * 255) / 1800);
                } else if (sArr[i] > 5000) {
                    iArr[i] = Color.rgb(0, 255, 255);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, AudioParams.DEFAULT_FRAME_SIZE, 480, Bitmap.Config.ARGB_8888);
            CameraModeListener hVar = this.f10919K;
            C3443i.m21152a((Object) createBitmap, "bitmap");
            hVar.mo17997a(createBitmap, createBitmap.getWidth(), createBitmap.getHeight());
            if (this.f10911C) {
                Bitmap createBitmap2 = Bitmap.createBitmap(iArr, AudioParams.DEFAULT_FRAME_SIZE, 480, Bitmap.Config.ARGB_8888);
                Bitmap a = BitmapUtils.m16141a(createBitmap2, this.f10936w);
                if (this.f10936w != 0) {
                    createBitmap2.recycle();
                }
                C3443i.m21152a((Object) a, "saveBmp");
                int width = a.getWidth();
                int height = a.getHeight();
                C2644av.m16097a(this.f10912D, a);
                this.f10911C = false;
                String str = this.f10912D;
                if (str == null) {
                    C3443i.m21151a();
                }
                long j = this.f10913E;
                String str2 = this.f10914F;
                if (str2 == null) {
                    C3443i.m21151a();
                }
                mo20604a(str, j, str2, width, height);
            }
        }
    }

    @NotNull
    /* renamed from: a */
    public final ByteBuffer mo20603a(@NotNull ByteBuffer byteBuffer) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{byteBuffer}, this, f10907a, false, 4955, new Class[]{ByteBuffer.class}, ByteBuffer.class);
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

    /* renamed from: K */
    private final void m11687K() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4956, new Class[0], Void.TYPE).isSupported) {
            this.f10931r.mo20113a((AudioRecorder.C2077a) this);
            this.f10930q.mo20134a((HWRecorderWrapper.C2083b) this);
        }
    }

    /* renamed from: o */
    public void mo20412o() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4957, new Class[0], Void.TYPE).isSupported) {
            if (this.f10925l) {
                m11689M();
            } else {
                m11688L();
            }
        }
    }

    /* renamed from: ad */
    public void mo20550ad() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4958, new Class[0], Void.TYPE).isSupported) {
            this.f10927n = !this.f10927n;
            if (!this.f10927n) {
                this.f10928o = (this.f10928o + SystemClock.uptimeMillis()) - this.f10929p;
                m11691O();
            } else {
                this.f10929p = SystemClock.uptimeMillis();
            }
            mo20542U().mo21601i(this.f10927n);
            this.f10930q.mo20135a(this.f10927n);
        }
    }

    /* renamed from: ac */
    public boolean mo20549ac() {
        return !this.f10925l;
    }

    /* renamed from: a */
    public void mo20118a(@Nullable byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f10907a, false, 4959, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if ((true ^ this.f10927n) && this.f10925l) {
                this.f10930q.mo20139b(bArr);
            }
        }
    }

    /* renamed from: a */
    public void mo20142a(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10907a, false, 4960, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10906L;
            LogUtil.m15952c(aVar, "onVideoSaved: " + str);
            this.f10926m = false;
            this.f10925l = false;
            long uptimeMillis = (SystemClock.uptimeMillis() - this.f10934u) - this.f10928o;
            ContentValues contentValues = this.f10935v;
            if (str == null) {
                C3443i.m21151a();
            }
            contentValues.put("_size", Long.valueOf(new File(str).length()));
            this.f10935v.put("duration", Long.valueOf(uptimeMillis));
            CameraActivity cameraActivity = this.f10787i;
            C3443i.m21152a((Object) cameraActivity, "mActivity");
            cameraActivity.mo17689p().mo17830a(str, uptimeMillis, this.f10935v, this.f10918J, this.f10919K.mo18187dK());
        }
    }

    /* renamed from: k_ */
    public void mo20407k_() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4961, new Class[0], Void.TYPE).isSupported && this.f10925l) {
            m11689M();
        }
    }

    /* renamed from: l_ */
    public boolean mo20409l_() {
        return this.f10925l;
    }

    /* renamed from: L */
    private final void m11688L() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4962, new Class[0], Void.TYPE).isSupported) {
            this.f10919K.mo18275x(1);
            C2191b bVar = this.f10938y;
            if (bVar == null) {
                C3443i.m21151a();
            }
            bVar.postDelayed(new C2196g(this), 200);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.n$g */
    /* compiled from: NightVisionMode.kt */
    static final class C2196g implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10955a;

        /* renamed from: b */
        final /* synthetic */ NightVisionMode f10956b;

        C2196g(NightVisionMode nVar) {
            this.f10956b = nVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10955a, false, 4978, new Class[0], Void.TYPE).isSupported && !this.f10956b.f10925l) {
                this.f10956b.m11690N();
                HWRecorderWrapper k = this.f10956b.f10930q;
                int l = this.f10956b.f10939z;
                int m = this.f10956b.f10909A;
                int n = this.f10956b.f10924g;
                int a = this.f10956b.f10931r.mo20112a();
                int b = this.f10956b.f10931r.mo20114b();
                String p = this.f10956b.f10937x;
                if (p == null) {
                    C3443i.m21151a();
                }
                k.mo20137a(l, m, n, a, b, p, true, (MzCamcorderProfileManager) null);
                this.f10956b.f10919K.mo18064b(this.f10956b.f10930q.mo20138b());
                this.f10956b.f10925l = true;
                this.f10956b.f10927n = false;
                this.f10956b.f10928o = 0;
                this.f10956b.f10934u = SystemClock.uptimeMillis();
                this.f10956b.f10931r.mo20115c();
                this.f10956b.mo20542U().mo21532a(true, false);
                this.f10956b.mo20542U().mo21569b(true, false);
                this.f10956b.mo20542U().mo21506a(0);
                MzNightVisionUI h = this.f10956b.f10923f;
                if (h != null) {
                    h.mo22524a(true);
                }
                this.f10956b.m11691O();
                LogUtil.m15952c(NightVisionMode.f10906L, "start record");
                this.f10956b.f10919K.mo18277y(this.f10956b.f10936w);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public final void m11689M() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4963, new Class[0], Void.TYPE).isSupported && !this.f10926m) {
            this.f10926m = true;
            LogUtil.m15952c(f10906L, "stop record");
            m11686B();
            this.f10919K.mo18275x(2);
            mo20542U().mo21566b((int) R.string.mz_recording_save, true);
            mo20542U().mo21634t();
            this.f10931r.mo20116d();
            this.f10930q.mo20141d();
            mo20542U().mo21532a(false, false);
            mo20542U().mo21589f(true);
            mo20542U().mo21506a(512);
            this.f10788j.mo21569b(false, false);
            MzNightVisionUI uVar = this.f10923f;
            if (uVar != null) {
                uVar.mo22524a(false);
            }
            MzNightVisionUI uVar2 = this.f10923f;
            if (uVar2 != null) {
                uVar2.mo22526c();
            }
            MzNightVisionUI uVar3 = this.f10923f;
            if (uVar3 != null) {
                uVar3.mo22523a("00:00:00");
            }
            this.f10919K.mo18232ec();
            C2191b bVar = this.f10938y;
            if (bVar != null) {
                bVar.removeMessages(1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public final void m11690N() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4964, new Class[0], Void.TYPE).isSupported) {
            long currentTimeMillis = System.currentTimeMillis();
            String a = Storage.m7750a().mo18620a((Context) this.f10787i, currentTimeMillis);
            String str = a + ".mp4";
            this.f10937x = Storage.m7750a().mo18660i(str);
            File file = new File(Storage.m7750a().mo18665l());
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f10935v = new ContentValues(9);
            this.f10935v.put(PushConstants.TITLE, a);
            this.f10935v.put("_display_name", str);
            this.f10935v.put("datetaken", Long.valueOf(currentTimeMillis));
            this.f10935v.put("date_modified", Long.valueOf(currentTimeMillis / ((long) 1000)));
            this.f10935v.put("mime_type", "video/mp4");
            this.f10935v.put("_data", this.f10937x);
            this.f10935v.put("resolution", String.valueOf(this.f10932s) + "x" + String.valueOf(this.f10933t));
            this.f10935v.put("width", Integer.valueOf(this.f10932s));
            this.f10935v.put("height", Integer.valueOf(this.f10933t));
            int c = this.f10919K.mo18194dR() != -1 ? CameraUtil.m15882c(this.f10919K.mo18211di(), this.f10919K.mo18194dR()) : 0;
            this.f10939z = this.f10932s;
            this.f10909A = this.f10933t;
            if (((c / 90) & 1) == 1) {
                this.f10935v.put(MtkMediaStore.VideoColumns.ORIENTATION, 90);
                this.f10939z = this.f10933t;
                this.f10909A = this.f10932s;
            } else {
                this.f10935v.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
            }
            this.f10936w = c;
            this.f10935v.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(c));
            Location a2 = this.f10919K.mo18192dP().mo19017a(currentTimeMillis);
            if (a2 != null) {
                this.f10935v.put(Parameters.LATITUDE, Double.valueOf(a2.getLatitude()));
                this.f10935v.put(Parameters.LONGITUDE, Double.valueOf(a2.getLongitude()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Uri m11693a(String str, long j, String str2) {
        Object[] objArr = {str, new Long(j), str2};
        ChangeQuickRedirect changeQuickRedirect = f10907a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4965, new Class[]{String.class, Long.TYPE, String.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        File file = new File(str2);
        XmpMetaData gVar = new XmpMetaData("AR", false, false, -1);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(file.lastModified());
        ContentValues contentValues = new ContentValues(10);
        contentValues.put(PushConstants.TITLE, str);
        contentValues.put("_display_name", str + ".jpg");
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(seconds));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
        contentValues.put("_data", str2);
        contentValues.put("_size", Long.valueOf(file.length()));
        Location a = this.f10919K.mo18192dP().mo19017a(j);
        if (a != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(a.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(a.getLongitude()));
        }
        try {
            XmpUtilHelper.m16123a(str2, gVar);
            CameraActivity cameraActivity = this.f10787i;
            C3443i.m21152a((Object) cameraActivity, "mActivity");
            return cameraActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11701a(String str, long j) {
        if (!PatchProxy.proxy(new Object[]{str, new Long(j)}, this, f10907a, false, 4966, new Class[]{String.class, Long.TYPE}, Void.TYPE).isSupported) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                String format = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss", Locale.ENGLISH).format(Long.valueOf(j));
                exifInterface.setAttribute(ExifInterface.TAG_MAKE, "Meizu");
                exifInterface.setAttribute("Model", Build.MODEL);
                exifInterface.setAttribute(ExifInterface.TAG_SOFTWARE, "Meizu Camera");
                exifInterface.setAttribute(ExifInterface.TAG_DATETIME, format);
                exifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, format);
                exifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, format);
                exifInterface.setAttribute(ExifInterface.TAG_USER_COMMENT, MtkPatterns.KEY_URLDATA_END);
                Location a = this.f10919K.mo18192dP().mo19017a(j);
                if (a != null) {
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE, FormatUtil.m16269a(a.getLatitude()));
                    double d = (double) 0;
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, a.getLatitude() > d ? "N" : ExifInterface.LATITUDE_SOUTH);
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, FormatUtil.m16269a(a.getLongitude()));
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, a.getLongitude() > d ? ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST);
                }
                exifInterface.saveAttributes();
            } catch (IOException e) {
                LogUtil.C2630a aVar = f10906L;
                LogUtil.m15949b(aVar, "failed to write ar exif: " + e.getMessage());
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo27294d2 = {"com/meizu/media/camera/mode/NightVisionMode$enableShutterSound$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.n$c */
    /* compiled from: NightVisionMode.kt */
    public static final class C2192c extends AsyncTaskEx<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f10942a;

        /* renamed from: b */
        final /* synthetic */ boolean f10943b;

        C2192c(boolean z) {
            this.f10943b = z;
        }

        @Nullable
        /* renamed from: a */
        public Void mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10942a, false, 4971, new Class[]{Void[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            C3443i.m21155b(voidArr, "params");
            CameraController.m8868g().mo19475a(this.f10943b);
            return null;
        }
    }

    /* renamed from: d */
    private final void m11709d(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10907a, false, 4967, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new C2192c(z).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public final void m11691O() {
        if (!PatchProxy.proxy(new Object[0], this, f10907a, false, 4968, new Class[0], Void.TYPE).isSupported) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f10934u;
            if (this.f10923f != null) {
                String a = CameraUtil.m15833a(uptimeMillis, false);
                C3443i.m21152a((Object) a, "CameraUtil.millisecondToTimeString(delta ,false)");
                MzNightVisionUI uVar = this.f10923f;
                if (uVar == null) {
                    C3443i.m21151a();
                }
                uVar.mo22523a(a);
            }
            C2191b bVar = this.f10938y;
            if (bVar != null) {
                bVar.sendEmptyMessageDelayed(1, 1000);
            }
        }
    }

    /* renamed from: a */
    public final void mo20605a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10907a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4969, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10906L;
            LogUtil.m15942a(aVar, "handleRecordState: " + z);
            MzNightVisionUI uVar = this.f10923f;
            if (uVar != null) {
                uVar.mo22526c();
            }
            this.f10915G = z;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/media/camera/mode/NightVisionMode$MyHandler;", "Landroid/os/Handler;", "nightVisionMode", "Lcom/meizu/media/camera/mode/NightVisionMode;", "(Lcom/meizu/media/camera/mode/NightVisionMode;)V", "mNightVisionModeWeakReference", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.n$b */
    /* compiled from: NightVisionMode.kt */
    private static final class C2191b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10940a;

        /* renamed from: b */
        private final WeakReference<NightVisionMode> f10941b;

        public C2191b(@NotNull NightVisionMode nVar) {
            C3443i.m21155b(nVar, "nightVisionMode");
            this.f10941b = new WeakReference<>(nVar);
        }

        public void handleMessage(@NotNull Message message) {
            NightVisionMode nVar;
            if (!PatchProxy.proxy(new Object[]{message}, this, f10940a, false, 4970, new Class[]{Message.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(message, NotificationCompat.CATEGORY_MESSAGE);
                if (this.f10941b.get() != null) {
                    if (message.what == 1) {
                        NightVisionMode nVar2 = (NightVisionMode) this.f10941b.get();
                        if (nVar2 != null) {
                            nVar2.m11691O();
                        }
                    } else if (message.what == 2 && (nVar = (NightVisionMode) this.f10941b.get()) != null) {
                        nVar.m11689M();
                    }
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo27294d2 = {"Lcom/meizu/media/camera/mode/NightVisionMode$Companion;", "", "()V", "MAX_RECORD_DURATION", "", "MSG_STOP_RECORD", "MSG_UPDATE_RECORD_TIME", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.mode.n$a */
    /* compiled from: NightVisionMode.kt */
    public static final class C2190a {
        private C2190a() {
        }

        public /* synthetic */ C2190a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
