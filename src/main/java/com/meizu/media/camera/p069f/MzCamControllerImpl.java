package com.meizu.media.camera.p069f;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import com.meizu.camera.effectlib.effects.filters.EffectRenderEngine;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.media.camera.CamIntentTask;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzBurstHandler;
import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzFacebeautyManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.PreviewGestures;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraControllerV2;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.filter.MzDynamicFilterManager;
import com.meizu.media.camera.mode.ARMode;
import com.meizu.media.camera.mode.AutoMode;
import com.meizu.media.camera.mode.CameraMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.mode.GifMode;
import com.meizu.media.camera.mode.ManualMode;
import com.meizu.media.camera.mode.NightVisionMode;
import com.meizu.media.camera.mode.TofMode;
import com.meizu.media.camera.mode.VideoMode;
import com.meizu.media.camera.p077ui.MzARUI;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.simplify.MzSimplifyImageCaptureHandler;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C3359b;
import kotlin.jvm.p108b.C3443i;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u0014\u0010'\u001a\u00020\f2\n\u0010$\u001a\u00020(\"\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\fH\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\u000eH\u0016J\u0010\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0014H\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\b\u00106\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u00020\u000eH\u0016J\u001c\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020\u000eH\u0016J\b\u0010>\u001a\u00020\u000eH\u0016J\b\u0010?\u001a\u00020\u000eH\u0016J\b\u0010@\u001a\u00020\u000eH\u0016J\b\u0010A\u001a\u00020\u000eH\u0016J\b\u0010B\u001a\u00020\u000eH\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J\b\u0010D\u001a\u00020\u000eH\u0016J\b\u0010E\u001a\u00020\u000eH\u0016J\b\u0010F\u001a\u00020\u000eH\u0016J\b\u0010G\u001a\u00020\u000eH\u0016J\b\u0010H\u001a\u00020\u000eH\u0016J\b\u0010I\u001a\u00020\u000eH\u0016J\b\u0010J\u001a\u00020\u000eH\u0016J\b\u0010K\u001a\u00020\u000eH\u0016J\b\u0010L\u001a\u00020\u000eH\u0016J\b\u0010M\u001a\u00020\u000eH\u0016J\b\u0010N\u001a\u00020\u000eH\u0016J\b\u0010O\u001a\u00020\u000eH\u0016J\b\u0010P\u001a\u00020\u000eH\u0016J\b\u0010Q\u001a\u00020\u000eH\u0016J\b\u0010R\u001a\u00020\u000eH\u0016J\b\u0010S\u001a\u00020\u000eH\u0016J\b\u0010T\u001a\u00020\u000eH\u0016J\b\u0010U\u001a\u00020\u000eH\u0016J\b\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\fH\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020\fH\u0016J\u0012\u0010[\u001a\u00020\f2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\"\u0010^\u001a\u00020\f2\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u0014H\u0016J\u0010\u0010c\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0014H\u0016J\b\u0010d\u001a\u00020\fH\u0016J\b\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020\u0014H\u0016J\u0010\u0010h\u001a\u00020\f2\u0006\u0010i\u001a\u00020\u0014H\u0016J\b\u0010j\u001a\u00020\fH\u0016J\u0010\u0010k\u001a\u00020\f2\u0006\u0010l\u001a\u00020\u000eH\u0016J\u0018\u0010m\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u0014H\u0016J\b\u0010n\u001a\u00020\fH\u0016J\b\u0010o\u001a\u00020\fH\u0016J\b\u0010p\u001a\u00020\fH\u0016J2\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u00142\b\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u00020\u000eH\u0016J\b\u0010x\u001a\u00020\fH\u0016J\b\u0010y\u001a\u00020\fH\u0016J\b\u0010z\u001a\u00020\fH\u0016J\b\u0010{\u001a\u00020\fH\u0016J\u0010\u0010|\u001a\u00020\f2\u0006\u0010}\u001a\u00020\u000eH\u0016J\u0010\u0010~\u001a\u00020\f2\u0006\u0010\u001a\u00020\u000eH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J,\u0010\u0001\u001a\u00020\f2\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J,\u0010\u0001\u001a\u00020\f2\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u0014H\u0016J$\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\u001a\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0014H\u0016J\u0012\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\u001b\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J\u0011\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0012\u0010\u0001\u001a\u00020\f2\u0007\u0010 \u0001\u001a\u00020\u0014H\u0016J$\u0010¡\u0001\u001a\u00020\f2\u0013\u0010¢\u0001\u001a\u000e\u0012\t\u0012\u0007\u0012\u0002\b\u00030¤\u00010£\u0001H\u0016¢\u0006\u0003\u0010¥\u0001J\u0014\u0010¦\u0001\u001a\u00020\f2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0019H\u0016J\u001d\u0010¦\u0001\u001a\u00020\f2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010¨\u0001\u001a\u00020\u000eH\u0016J\u0015\u0010©\u0001\u001a\u00020\f2\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\u0011\u0010¬\u0001\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0011\u0010­\u0001\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u0011\u0010®\u0001\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0015\u0010¯\u0001\u001a\u00020\f2\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\u0013\u0010²\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u0012\u0010µ\u0001\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010·\u0001\u001a\u00020\f2\u0007\u0010¸\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¹\u0001\u001a\u00020\f2\u0007\u0010º\u0001\u001a\u00020\u000eH\u0016J\u0011\u0010»\u0001\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010¼\u0001\u001a\u00020\fH\u0016J\u001b\u0010½\u0001\u001a\u00020\f2\u0007\u0010¾\u0001\u001a\u00020\u000e2\u0007\u0010¿\u0001\u001a\u00020\u0014H\u0016J\u001e\u0010À\u0001\u001a\u00020\f2\u0007\u0010Á\u0001\u001a\u00020\u000e2\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\t\u0010Ä\u0001\u001a\u00020\fH\u0016J\t\u0010Å\u0001\u001a\u00020\u000eH\u0016J\t\u0010Æ\u0001\u001a\u00020\fH\u0016J\t\u0010Ç\u0001\u001a\u00020\fH\u0016J\t\u0010È\u0001\u001a\u00020\fH\u0016J\u0015\u0010É\u0001\u001a\u00020\f2\n\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0016J\u0013\u0010Ì\u0001\u001a\u00020\f2\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0016J\t\u0010Ï\u0001\u001a\u00020\fH\u0016J\u0011\u0010Ð\u0001\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u0012\u0010Ñ\u0001\u001a\u00020\f2\u0007\u0010Ò\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ó\u0001\u001a\u00020\fH\u0016J\u001b\u0010Ô\u0001\u001a\u00020\f2\u0007\u0010Õ\u0001\u001a\u00020\u000e2\u0007\u0010Ö\u0001\u001a\u00020\u000eH\u0016J1\u0010×\u0001\u001a\u00020\f2\u0007\u0010¾\u0001\u001a\u00020\u000e2\u0007\u0010Ø\u0001\u001a\u00020\u00142\b\u0010Ù\u0001\u001a\u00030Ú\u00012\n\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u0001H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006Ý\u0001"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/MzCamControllerImpl;", "Lcom/meizu/media/camera/MzCamController;", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "getMCamModule", "()Lcom/meizu/media/camera/MzCamModule;", "setMCamModule", "(Lcom/meizu/media/camera/MzCamModule;)V", "cancelGifRecord", "", "checkAmazingARSdkDlStatus", "", "cleanFbHalEffect", "doModeOut", "enableRecordingMeterSeparate", "enable", "getCurrentCameraId", "", "getCurrentFBState", "getFilterHandler", "Lcom/meizu/media/camera/filter/MzDynamicFilterManager;", "getFlashValue", "Lcom/meizu/media/camera/camcontroller/CameraController$FlashMode;", "getFocusManager", "Lcom/meizu/media/camera/FocusOverlayManager;", "getModuleState", "Lcom/meizu/media/camera/MzCamController$ModuleState;", "getPreferences", "Lcom/meizu/media/camera/ComboPreferences;", "getSecureCameraCaptureTime", "", "gotoAmazingAR", "handleAsd", "needUpdateNow", "handleFbEffectState", "state", "handleMFll", "", "handleManual20MStatus", "isManual20MOn", "handleManualHighSizeStatus", "on", "handlePauseFrameTransition", "delay", "handleRecordStatus", "handleSlowMotionStatus", "handleVideoEisStatus", "eisOn", "handleWideAngleStatus", "cameraId", "hasFilterEffect", "hasMobileDownloadPermission", "hasSceneEffect", "initRenderOverlay", "renderOverlay", "Lcom/meizu/media/camera/views/RenderOverlay;", "gestures", "Lcom/meizu/media/camera/PreviewGestures;", "isARVideoRecording", "isBackPortrait", "isBarcodeAutoEnable", "isBarcodeAutoHintShowing", "isBarcodeAutoInfoShowing", "isBarcodeAutoSupported", "isBurstCaptureInProgress", "isCameraIdle", "isEisEnable", "isFBOn", "isFilterControllerShowing", "isImageCaptureIntent", "isMZMMSImageCaptureIntent", "isModeControllerShow", "isOpenScannerIntent", "isPreviewStart", "isSettingVisible", "isVideoCaptureIntent", "isVideoMode", "isWaitFirstFrame", "isWideAngleIconDisable", "isZoomBoardShowing", "isZoomIndicatorSupported", "isZoomSliderShowing", "isZoomSupported", "needFbCaptureLoading", "onCaptureCancelled", "onCaptureDone", "onCaptureRetake", "onDepthFrameAvailable", "onDoubleTapEvent", "e", "Landroid/view/MotionEvent;", "onDoubleTapUp", "view", "Landroid/view/View;", "x", "y", "onFlashChange", "onFrameAvailable", "onInfoClick", "onLapseTimeChange", "index", "onModeChange", "mode", "onModeChangePre", "onModeMenuVisibilityChanged", "isVisible", "onPreSingleTapConfirmed", "onPreviewUIDestroyed", "onPreviewUIReady", "onRecordReviewPlay", "onScreenSizeChanged", "width", "height", "yOffset", "previewRect", "Landroid/graphics/RectF;", "needUpdate", "onScrollCancelLongPressCapture", "onSettingChanged", "onShutterButtonCancel", "onShutterButtonClick", "onShutterButtonDown", "isKeyDown", "onShutterButtonFocus", "pressed", "onShutterButtonLongClick", "onShutterButtonLongClickReleased", "onShutterButtonUp", "onSingleTapConfirmed", "needCaptureAfterFocus", "onSingleTapUp", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "onVideoDone", "onVideoRetake", "onZoomParamChanged", "requestedZoom", "onZoomUIChanged", "needSetTouchZoom", "needUpdateIndicatorText", "openFilterEffect", "pressRecordButton", "pressRecordPauseButton", "pressSwitchCameraButton", "flipUp", "resetFilterEffect", "needRestore", "needSetRender", "resetIconLoc", "resetTextureTranslation", "restoreFilterEffect", "resumeFbEffectState", "isWatch", "isFbMode", "setChangeModeEnable", "setFBStatusForGender", "gender", "setFaces", "faces", "", "Lcom/meizu/media/camera/camcontroller/CameraController$FaceInfo;", "([Lcom/meizu/media/camera/camcontroller/CameraController$FaceInfo;)V", "setFlashValue", "flashValue", "updateParams", "setHdrMode", "hdrMode", "Lcom/meizu/media/camera/camcontroller/CameraController$HdrMode;", "setMobileDownloadPermission", "setOpticalStablization", "setRefreshPreviewEnable", "setRenderType", "renderType", "", "setSurfaceTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setUIBlockFocus", "isUsed", "setUIBlockShakeFocus", "isBlock", "setVideoCleanScreen", "needClean", "setVoiceEnable", "setWeakFbEffect", "showZoomIndicator", "isShow", "animType", "startTextureTranslationAnim", "moveUp", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "stopPreview", "supportLongClickProcessing", "switchCameraInPortraitRecord", "thumbnailAnimExit", "tryRestartPreview", "updateBufferInAutoMode", "buffer", "", "updateCameraBound", "cameraBound", "Landroid/graphics/Rect;", "updateCameraOrientation", "updateRecordPortraitStatus", "updateSpecialZoomValue", "zoomIndex", "updateWatchStateUI", "updateWideAngelZoom", "support", "resetValue", "zoomSliderAnimStart", "duration", "translateY", "", "interpolator", "Landroid/view/animation/PathInterpolator;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.j */
public final class MzCamControllerImpl implements MzCamController {

    /* renamed from: a */
    public static ChangeQuickRedirect f9999a;
    @NotNull

    /* renamed from: b */
    public MzCamModule f10000b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LogUtil.C2630a f10001c = new LogUtil.C2630a("MzCamControllerImpl");

    /* renamed from: a */
    public void mo17883a(@Nullable MotionEvent motionEvent) {
    }

    /* renamed from: af */
    public void mo17909af() {
    }

    @NotNull
    /* renamed from: a */
    public final MzCamModule mo20037a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4325, new Class[0], MzCamModule.class);
        if (proxy.isSupported) {
            return (MzCamModule) proxy.result;
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule;
    }

    /* renamed from: a */
    public final void mo20038a(@NotNull MzCamModule mzCamModule) {
        if (!PatchProxy.proxy(new Object[]{mzCamModule}, this, f9999a, false, 4326, new Class[]{MzCamModule.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(mzCamModule, "<set-?>");
            this.f10000b = mzCamModule;
        }
    }

    /* renamed from: w */
    public void mo17957w() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4327, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule.mo18032aQ()) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule2.mo18075bI()) {
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule3.mo18078bL()) {
                        MzCamModule mzCamModule4 = this.f10000b;
                        if (mzCamModule4 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule4.mo18115bw() != MzCamController.ModuleState.SWITCHING_MODE) {
                            MzCamModule mzCamModule5 = this.f10000b;
                            if (mzCamModule5 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            if (mzCamModule5.mo18115bw() != MzCamController.ModuleState.SWITCHING_CAMERA) {
                                return;
                            }
                        }
                        MzCamModule mzCamModule6 = this.f10000b;
                        if (mzCamModule6 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule6.mo18082bP()) {
                            LogUtil.C2630a aVar = this.f10001c;
                            StringBuilder sb = new StringBuilder();
                            sb.append("onFrameAvailable mSwitchingModeNum:");
                            MzCamModule mzCamModule7 = this.f10000b;
                            if (mzCamModule7 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            sb.append(mzCamModule7.mo18081bO());
                            LogUtil.m15952c(aVar, sb.toString());
                            MzCamModule mzCamModule8 = this.f10000b;
                            if (mzCamModule8 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            if (mzCamModule8.mo18081bO() == 0) {
                                MzCamModule mzCamModule9 = this.f10000b;
                                if (mzCamModule9 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                MzUIController aU = mzCamModule9.mo18036aU();
                                if (aU == null) {
                                    C3443i.m21151a();
                                }
                                if (aU.mo21590f()) {
                                    MzCamModule mzCamModule10 = this.f10000b;
                                    if (mzCamModule10 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    mzCamModule10.mo18262s(1);
                                    MzCamModule mzCamModule11 = this.f10000b;
                                    if (mzCamModule11 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    MzCamUI u = mzCamModule11.mo18267u();
                                    if (u == null) {
                                        C3443i.m21151a();
                                    }
                                    u.mo22085a(true);
                                    return;
                                }
                                MzCamModule mzCamModule12 = this.f10000b;
                                if (mzCamModule12 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                if (!mzCamModule12.mo18080bN()) {
                                    MzCamModule mzCamModule13 = this.f10000b;
                                    if (mzCamModule13 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    mzCamModule13.mo18110br().post(new C2060b(this));
                                } else {
                                    MzCamModule mzCamModule14 = this.f10000b;
                                    if (mzCamModule14 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    mzCamModule14.mo18110br().removeMessages(14);
                                    MzCamModule mzCamModule15 = this.f10000b;
                                    if (mzCamModule15 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    mzCamModule15.mo18110br().sendEmptyMessage(14);
                                    MzCamModule mzCamModule16 = this.f10000b;
                                    if (mzCamModule16 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    mzCamModule16.mo18110br().sendEmptyMessageDelayed(27, 30);
                                }
                                MzCamModule mzCamModule17 = this.f10000b;
                                if (mzCamModule17 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                mzCamModule17.mo17967G(false);
                            }
                        }
                    }
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.j$b */
    /* compiled from: MzCamControllerImpl.kt */
    static final class C2060b implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10004a;

        /* renamed from: b */
        final /* synthetic */ MzCamControllerImpl f10005b;

        C2060b(MzCamControllerImpl jVar) {
            this.f10005b = jVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10004a, false, 4455, new Class[0], Void.TYPE).isSupported && this.f10005b.mo20037a().mo18081bO() == 0 && this.f10005b.mo20037a().mo18082bP()) {
                MzUIController aU = this.f10005b.mo20037a().mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                if (!aU.mo21590f()) {
                    if (this.f10005b.mo20037a().mo18110br().hasMessages(14)) {
                        this.f10005b.mo20037a().mo18110br().removeMessages(14);
                        if (this.f10005b.mo20037a().mo18267u() != null) {
                            MzCamUI u = this.f10005b.mo20037a().mo18267u();
                            if (u == null) {
                                C3443i.m21151a();
                            }
                            u.mo22064a(this.f10005b.mo20037a().mo18113bu());
                        }
                        if (this.f10005b.mo20037a().mo18029aN() != null) {
                            CameraMode aN = this.f10005b.mo20037a().mo18029aN();
                            if (aN == null) {
                                C3443i.m21151a();
                            }
                            aN.mo20452a(this.f10005b.mo20037a().mo18113bu());
                        }
                        if (this.f10005b.mo20037a().mo18036aU() != null) {
                            MzUIController aU2 = this.f10005b.mo20037a().mo18036aU();
                            if (aU2 == null) {
                                C3443i.m21151a();
                            }
                            aU2.mo21505a(this.f10005b.mo20037a().mo18113bu());
                        }
                    }
                    this.f10005b.mo17876Y();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo17878a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4328, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18029aN() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN = mzCamModule2.mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                aN.mo20516b(i);
            }
        }
    }

    /* renamed from: c */
    public void mo17935c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4329, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            CameraController.m8868g().mo19508d(z);
        }
    }

    /* renamed from: x */
    public boolean mo17958x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4330, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18041aZ();
    }

    /* renamed from: z */
    public void mo17960z() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4331, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17965E(true);
        }
    }

    /* renamed from: A */
    public void mo17852A() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4332, new Class[0], Void.TYPE).isSupported) {
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            if (g.mo19522k() != null) {
                MzCamModule mzCamModule = this.f10000b;
                if (mzCamModule == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule.mo17965E(false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:255:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17885a(@org.jetbrains.annotations.Nullable android.view.View r17, int r18, int r19, boolean r20) {
        /*
            r16 = this;
            r7 = r16
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = 4
            java.lang.Object[] r0 = new java.lang.Object[r11]
            r12 = 0
            r0[r12] = r17
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r8)
            r13 = 1
            r0[r13] = r1
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r9)
            r14 = 2
            r0[r14] = r1
            java.lang.Byte r1 = new java.lang.Byte
            r1.<init>(r10)
            r15 = 3
            r0[r15] = r1
            com.meizu.savior.ChangeQuickRedirect r2 = f9999a
            java.lang.Class[] r5 = new java.lang.Class[r11]
            java.lang.Class<android.view.View> r1 = android.view.View.class
            r5[r12] = r1
            java.lang.Class r1 = java.lang.Integer.TYPE
            r5[r13] = r1
            java.lang.Class r1 = java.lang.Integer.TYPE
            r5[r14] = r1
            java.lang.Class r1 = java.lang.Boolean.TYPE
            r5[r15] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 4333(0x10ed, float:6.072E-42)
            r1 = r16
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x004a
            return
        L_0x004a:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0053
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0053:
            boolean r0 = r0.mo18077bK()
            if (r0 == 0) goto L_0x0340
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0062
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0062:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x006b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x006b:
            boolean r0 = r0.mo21590f()
            if (r0 != 0) goto L_0x0340
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x007a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x007a:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0083
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0083:
            boolean r0 = r0.mo21477A()
            if (r0 == 0) goto L_0x008b
            goto L_0x0340
        L_0x008b:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0094
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0094:
            int r0 = r0.mo18114bv()
            if (r0 != r15) goto L_0x00d6
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x00a3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00a3:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x00ac
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ac:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = r0.mo20403g_()
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.GIF
            if (r0 == r1) goto L_0x00d6
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x00bd
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00bd:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x00c6
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00c6:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = r0.mo20403g_()
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r0 != r1) goto L_0x00d4
            boolean r0 = r16.mo17898aA()
            if (r0 != 0) goto L_0x00d6
        L_0x00d4:
            r0 = 1
            goto L_0x00d7
        L_0x00d6:
            r0 = 0
        L_0x00d7:
            com.meizu.media.camera.MzCamModule r1 = r7.f10000b
            if (r1 != 0) goto L_0x00e0
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00e0:
            boolean r1 = r1.mo18032aQ()
            if (r1 != 0) goto L_0x033f
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 == 0) goto L_0x033f
            com.meizu.media.camera.MzCamModule r1 = r7.f10000b
            if (r1 != 0) goto L_0x00fe
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00fe:
            boolean r1 = r1.mo18067bA()
            if (r1 == 0) goto L_0x033f
            if (r0 != 0) goto L_0x033f
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x010f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x010f:
            int r0 = r0.mo18114bv()
            if (r0 == r11) goto L_0x033f
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x011e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x011e:
            int r0 = r0.mo18114bv()
            r1 = -1
            if (r0 == r1) goto L_0x033f
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x012e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x012e:
            int r0 = r0.mo18114bv()
            if (r0 != 0) goto L_0x0136
            goto L_0x033f
        L_0x0136:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x013f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x013f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0148
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0148:
            boolean r0 = r0.mo21591f(r8, r9)
            if (r0 != 0) goto L_0x033e
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0157
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0157:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0160
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0160:
            boolean r0 = r0.mo21595g(r8, r9)
            if (r0 == 0) goto L_0x0168
            goto L_0x033e
        L_0x0168:
            boolean r0 = r16.mo17873V()
            if (r0 == 0) goto L_0x0196
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0177
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0177:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x0196
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0186
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0186:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x018f
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x018f:
            boolean r0 = r0.mo22144b((int) r8, (int) r9)
            if (r0 == 0) goto L_0x0196
            return
        L_0x0196:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x019f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x019f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x01a8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01a8:
            boolean r0 = r0.mo21649z()
            if (r0 == 0) goto L_0x01e7
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x01b7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x01b7:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x01c0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01c0:
            r0.mo21609k((boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x01cc
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x01cc:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x01d5
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01d5:
            android.content.Context r0 = r0.getApplicationContext()
            com.meizu.media.camera.util.at r0 = com.meizu.media.camera.util.UsageStatsHelper.m16042a((android.content.Context) r0)
            java.lang.String r1 = "close_filter"
            java.lang.String r2 = "type"
            java.lang.String r3 = "click_preview"
            r0.mo22691a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3)
            return
        L_0x01e7:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x01f0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x01f0:
            r0.mo18265t((boolean) r12)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x01fc
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x01fc:
            com.meizu.media.camera.l r0 = r0.mo18038aW()
            if (r0 != 0) goto L_0x0205
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0205:
            boolean r0 = r0.mo20326a()
            if (r0 != 0) goto L_0x0224
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0214
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0214:
            com.meizu.media.camera.l r0 = r0.mo18038aW()
            if (r0 != 0) goto L_0x021d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x021d:
            boolean r0 = r0.mo20333b()
            if (r0 != 0) goto L_0x0224
            return
        L_0x0224:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x022d
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x022d:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x0236
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0236:
            boolean r0 = r0.mo20410m()
            if (r0 == 0) goto L_0x023d
            return
        L_0x023d:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0246
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0246:
            r0.mo18274w((boolean) r10)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0252
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0252:
            boolean r0 = r0.mo18109bq()
            if (r0 != r13) goto L_0x02a9
            boolean r0 = r16.mo17864M()
            if (r0 == 0) goto L_0x026a
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0267
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0267:
            r0.mo18274w((boolean) r12)
        L_0x026a:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0273
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0273:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x027c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x027c:
            boolean r0 = r0.mo20458ae()
            if (r0 != 0) goto L_0x028e
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x028b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x028b:
            r0.mo18274w((boolean) r12)
        L_0x028e:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0297
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0297:
            int r0 = r0.mo18031aP()
            if (r0 != r13) goto L_0x02a9
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x02a6
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02a6:
            r0.mo18274w((boolean) r12)
        L_0x02a9:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x02b2
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02b2:
            com.meizu.media.camera.h r0 = r0.mo18097be()
            if (r0 == 0) goto L_0x033d
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x02c1
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02c1:
            com.meizu.media.camera.MzCamController$ModuleState r0 = r0.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r1 = com.meizu.media.camera.MzCamController.ModuleState.IDLE
            if (r0 != r1) goto L_0x033d
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x02d2
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02d2:
            int r0 = r0.mo18114bv()
            if (r0 == r13) goto L_0x0302
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x02e1
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02e1:
            int r0 = r0.mo18114bv()
            if (r0 == r14) goto L_0x0302
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x02f0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02f0:
            int r0 = r0.mo18114bv()
            if (r0 != r15) goto L_0x033d
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14049s
            if (r0 != 0) goto L_0x0302
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14050t
            if (r0 != 0) goto L_0x0302
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14051u
            if (r0 == 0) goto L_0x033d
        L_0x0302:
            boolean r0 = r16.mo17907ad()
            if (r0 != 0) goto L_0x033d
            boolean r0 = r16.mo17928ay()
            if (r0 != 0) goto L_0x033d
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0317
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0317:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x0320
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0320:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = r0.mo20403g_()
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.AR
            if (r0 == r1) goto L_0x033d
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0331
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0331:
            com.meizu.media.camera.h r0 = r0.mo18097be()
            if (r0 != 0) goto L_0x033a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x033a:
            r0.mo20204a((int) r8, (int) r9)
        L_0x033d:
            return
        L_0x033e:
            return
        L_0x033f:
            return
        L_0x0340:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17885a(android.view.View, int, int, boolean):void");
    }

    /* renamed from: B */
    public void mo17853B() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4334, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18274w(false);
        }
    }

    /* renamed from: a */
    public boolean mo17897a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f9999a, false, 4335, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamUI aV = mzCamModule.mo18037aV();
        if (aV == null) {
            C3443i.m21151a();
        }
        if (aV.mo22049L()) {
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18133cK();
            return true;
        }
        MzCamModule mzCamModule3 = this.f10000b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule3.mo18098bf()) {
            MzCamModule mzCamModule4 = this.f10000b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule4.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            if (aU.mo21591f(i, i2)) {
                return false;
            }
        }
        MzCamModule mzCamModule5 = this.f10000b;
        if (mzCamModule5 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule5.mo18114bv() != 1) {
            return false;
        }
        MzCamModule mzCamModule6 = this.f10000b;
        if (mzCamModule6 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzUIController aU2 = mzCamModule6.mo18036aU();
        if (aU2 == null) {
            C3443i.m21151a();
        }
        if (aU2.mo21603i(i, i2)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo17884a(@Nullable View view, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i), new Integer(i2)}, this, f9999a, false, 4336, new Class[]{View.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            if (!aU.mo21590f()) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (!mzCamModule2.mo18032aQ()) {
                    CameraController g = CameraController.m8868g();
                    C3443i.m21152a((Object) g, "CameraController.getInstance()");
                    if (g.mo19522k() != null) {
                        MzCamModule mzCamModule3 = this.f10000b;
                        if (mzCamModule3 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule3.mo18067bA()) {
                            MzCamModule mzCamModule4 = this.f10000b;
                            if (mzCamModule4 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            if (mzCamModule4.mo18114bv() != 3) {
                                MzCamModule mzCamModule5 = this.f10000b;
                                if (mzCamModule5 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                if (mzCamModule5.mo18114bv() != 4) {
                                    MzCamModule mzCamModule6 = this.f10000b;
                                    if (mzCamModule6 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    if (mzCamModule6.mo18114bv() != 0) {
                                        MzCamModule mzCamModule7 = this.f10000b;
                                        if (mzCamModule7 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        MzCamUI aV = mzCamModule7.mo18037aV();
                                        if (aV == null) {
                                            C3443i.m21151a();
                                        }
                                        if (aV.mo22049L()) {
                                            MzCamModule mzCamModule8 = this.f10000b;
                                            if (mzCamModule8 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            mzCamModule8.mo18133cK();
                                            return;
                                        }
                                        MzCamModule mzCamModule9 = this.f10000b;
                                        if (mzCamModule9 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        MzUIController aU2 = mzCamModule9.mo18036aU();
                                        if (aU2 == null) {
                                            C3443i.m21151a();
                                        }
                                        if (!aU2.mo21591f(i, i2)) {
                                            MzCamModule mzCamModule10 = this.f10000b;
                                            if (mzCamModule10 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            MzUIController aU3 = mzCamModule10.mo18036aU();
                                            if (aU3 == null) {
                                                C3443i.m21151a();
                                            }
                                            if (!aU3.mo21587e(i, i2) && !mo17958x() && !mo17863L() && !mo17864M()) {
                                                MzCamModule mzCamModule11 = this.f10000b;
                                                if (mzCamModule11 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                CameraMode aN = mzCamModule11.mo18029aN();
                                                if (aN == null) {
                                                    C3443i.m21151a();
                                                }
                                                if (aN.mo20418u() && !CameraModeType.m10985n(CameraModeType.ModeType.SQUARE)) {
                                                    MzCamModule mzCamModule12 = this.f10000b;
                                                    if (mzCamModule12 == null) {
                                                        C3443i.m21156b("mCamModule");
                                                    }
                                                    MzUIController aU4 = mzCamModule12.mo18036aU();
                                                    if (aU4 == null) {
                                                        C3443i.m21151a();
                                                    }
                                                    if (!aU4.mo21477A()) {
                                                        MzCamModule mzCamModule13 = this.f10000b;
                                                        if (mzCamModule13 == null) {
                                                            C3443i.m21156b("mCamModule");
                                                        }
                                                        MzUIController aU5 = mzCamModule13.mo18036aU();
                                                        if (aU5 == null) {
                                                            C3443i.m21151a();
                                                        }
                                                        if (!aU5.mo21590f()) {
                                                            MzCamModule mzCamModule14 = this.f10000b;
                                                            if (mzCamModule14 == null) {
                                                                C3443i.m21156b("mCamModule");
                                                            }
                                                            MzCamModule mzCamModule15 = this.f10000b;
                                                            if (mzCamModule15 == null) {
                                                                C3443i.m21156b("mCamModule");
                                                            }
                                                            mzCamModule14.mo18272v(!mzCamModule15.mo18098bf());
                                                            MzCamModule mzCamModule16 = this.f10000b;
                                                            if (mzCamModule16 == null) {
                                                                C3443i.m21156b("mCamModule");
                                                            }
                                                            MzCamUI aV2 = mzCamModule16.mo18037aV();
                                                            if (aV2 == null) {
                                                                C3443i.m21151a();
                                                            }
                                                            MzCamModule mzCamModule17 = this.f10000b;
                                                            if (mzCamModule17 == null) {
                                                                C3443i.m21156b("mCamModule");
                                                            }
                                                            aV2.mo22151d(mzCamModule17.mo18098bf());
                                                            MzCamModule mzCamModule18 = this.f10000b;
                                                            if (mzCamModule18 == null) {
                                                                C3443i.m21156b("mCamModule");
                                                            }
                                                            MzUIController aU6 = mzCamModule18.mo18036aU();
                                                            if (aU6 == null) {
                                                                C3443i.m21151a();
                                                            }
                                                            MzCamModule mzCamModule19 = this.f10000b;
                                                            if (mzCamModule19 == null) {
                                                                C3443i.m21156b("mCamModule");
                                                            }
                                                            aU6.mo21530a(mzCamModule19.mo18098bf());
                                                            if (DeviceHelper.f13854aG) {
                                                                mo17933b(new boolean[0]);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public int mo17930b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4337, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamUI aV = mzCamModule.mo18037aV();
        if (aV == null) {
            C3443i.m21151a();
        }
        aV.mo22065a(i);
        return i;
    }

    /* renamed from: a */
    public void mo17880a(int i, boolean z, boolean z2) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4338, new Class[]{Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18257p(i);
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18149ca() != -1) {
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamModule mzCamModule4 = this.f10000b;
                if (mzCamModule4 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule3.mo18259q(mzCamModule4.mo18149ca());
                MzCamModule mzCamModule5 = this.f10000b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule5.mo18261r(-1);
            }
            MzCamModule mzCamModule6 = this.f10000b;
            if (mzCamModule6 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule6.mo17973M(z);
            MzCamModule mzCamModule7 = this.f10000b;
            if (mzCamModule7 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule7.mo18097be() != null && CameraModeType.m10983m(CameraModeType.ModeType.AUTO)) {
                CameraController.FocusMode focusMode = CameraController.FocusMode.AUTO;
                MzCamModule mzCamModule8 = this.f10000b;
                if (mzCamModule8 == null) {
                    C3443i.m21156b("mCamModule");
                }
                FocusOverlayManager be = mzCamModule8.mo18097be();
                if (be == null) {
                    C3443i.m21151a();
                }
                if (focusMode == be.mo20225h()) {
                    MzCamModule mzCamModule9 = this.f10000b;
                    if (mzCamModule9 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamUI aV = mzCamModule9.mo18037aV();
                    if (aV == null) {
                        C3443i.m21151a();
                    }
                    if (aV.mo22191s()) {
                        MzCamModule mzCamModule10 = this.f10000b;
                        if (mzCamModule10 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        FocusOverlayManager be2 = mzCamModule10.mo18097be();
                        if (be2 == null) {
                            C3443i.m21151a();
                        }
                        be2.mo20221f();
                    }
                }
            }
            MzCamModule mzCamModule11 = this.f10000b;
            if (mzCamModule11 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule11.mo18110br().hasMessages(29)) {
                Message message = new Message();
                message.what = 29;
                message.obj = Boolean.valueOf(z2);
                MzCamModule mzCamModule12 = this.f10000b;
                if (mzCamModule12 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule12.mo18110br().sendMessage(message);
            }
        }
    }

    /* renamed from: a */
    public void mo17879a(int i, int i2, int i3, @Nullable RectF rectF, boolean z) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3), rectF, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4339, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, RectF.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                MzCamModule mzCamModule = this.f10000b;
                if (mzCamModule == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule.mo17990a(i, i2, i3);
            }
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule2.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21509a(i, i2, rectF);
        }
    }

    /* renamed from: C */
    public void mo17854C() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4341, new Class[0], Void.TYPE).isSupported && mo20039b()) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule.mo18029aN();
            if (aN != null) {
                ((VideoMode) aN).mo20664B();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.VideoMode");
        }
    }

    /* renamed from: D */
    public void mo17855D() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4343, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            int bo = mzCamModule.mo18107bo();
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (bo != CameraUtil.m15867b((Activity) mzCamModule2.mo18030aO())) {
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule3.mo18170cv();
            }
        }
    }

    /* renamed from: a */
    public void mo17886a(@Nullable CameraController.FlashMode flashMode) {
        if (!PatchProxy.proxy(new Object[]{flashMode}, this, f9999a, false, 4344, new Class[]{CameraController.FlashMode.class}, Void.TYPE).isSupported) {
            mo17887a(flashMode, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ce, code lost:
        if (r1.mo20241t() == false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0142, code lost:
        if (r12.mo20403g_() == com.meizu.media.camera.mode.CameraModeType.ModeType.MANUAL) goto L_0x0144;
     */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x015a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17887a(@org.jetbrains.annotations.Nullable com.meizu.media.camera.camcontroller.CameraController.FlashMode r11, boolean r12) {
        /*
            r10 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r11
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r12)
            r9 = 1
            r1[r9] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.camcontroller.CameraController$FlashMode> r2 = com.meizu.media.camera.camcontroller.CameraController.FlashMode.class
            r6[r8] = r2
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r6[r9] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4345(0x10f9, float:6.089E-42)
            r2 = r10
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0029
            return
        L_0x0029:
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x0032
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0032:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x003b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x003b:
            boolean r1 = r1.mo20420w()
            com.meizu.media.camera.MzCamModule r2 = r10.f10000b
            if (r2 != 0) goto L_0x0048
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0048:
            boolean r2 = r2.mo18163co()
            if (r2 == 0) goto L_0x005a
            com.meizu.media.camera.MzCamModule r2 = r10.f10000b
            if (r2 != 0) goto L_0x0057
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0057:
            r2.mo17981U(r8)
        L_0x005a:
            if (r1 == 0) goto L_0x0089
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x0065
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0065:
            int r1 = r1.mo18114bv()
            if (r1 != r0) goto L_0x0089
            com.meizu.media.camera.MzCamModule r12 = r10.f10000b
            if (r12 != 0) goto L_0x0074
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x0074:
            com.meizu.media.camera.MzCamModule$d r12 = r12.mo18164cp()
            r12.mo18314a(r11)
            com.meizu.media.camera.MzCamModule r11 = r10.f10000b
            if (r11 != 0) goto L_0x0084
            java.lang.String r12 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r12)
        L_0x0084:
            r11.mo17981U(r9)
            goto L_0x0197
        L_0x0089:
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x0092
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0092:
            int r1 = r1.mo18114bv()
            if (r1 != r0) goto L_0x00d0
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x00a1
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00a1:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.MACRO
            if (r1 != r2) goto L_0x00d0
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x00b2
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00b2:
            com.meizu.media.camera.h r1 = r1.mo18097be()
            if (r1 == 0) goto L_0x00d0
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x00c1
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00c1:
            com.meizu.media.camera.h r1 = r1.mo18097be()
            if (r1 != 0) goto L_0x00ca
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ca:
            boolean r1 = r1.mo20241t()
            if (r1 != 0) goto L_0x0163
        L_0x00d0:
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x00d9
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00d9:
            com.meizu.media.camera.l r1 = r1.mo18038aW()
            if (r1 != 0) goto L_0x00e2
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00e2:
            boolean r1 = r1.mo20327a((com.meizu.media.camera.camcontroller.CameraController.FlashMode) r11)
            if (r12 == 0) goto L_0x0163
            if (r1 == 0) goto L_0x0163
            com.meizu.media.camera.MzCamModule r12 = r10.f10000b
            if (r12 != 0) goto L_0x00f3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00f3:
            com.meizu.media.camera.mode.f r12 = r12.mo18029aN()
            if (r12 != 0) goto L_0x00fc
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00fc:
            com.meizu.media.camera.mode.CameraModeType$ModeType r12 = r12.mo20403g_()
            boolean r12 = com.meizu.media.camera.mode.CameraModeType.m10979k((com.meizu.media.camera.mode.CameraModeType.ModeType) r12)
            if (r12 != 0) goto L_0x0144
            com.meizu.media.camera.MzCamModule r12 = r10.f10000b
            if (r12 != 0) goto L_0x010f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x010f:
            com.meizu.media.camera.l r12 = r12.mo18038aW()
            if (r12 != 0) goto L_0x0118
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0118:
            boolean r12 = r12.mo20354s()
            if (r12 == 0) goto L_0x014b
            boolean r12 = com.meizu.media.camera.util.DeviceHelper.f13895av
            if (r12 != 0) goto L_0x0126
            boolean r12 = com.meizu.media.camera.util.DeviceHelper.f13896aw
            if (r12 == 0) goto L_0x014b
        L_0x0126:
            boolean r12 = com.meizu.media.camera.util.DeviceHelper.f13898ay
            if (r12 == 0) goto L_0x014b
            com.meizu.media.camera.MzCamModule r12 = r10.f10000b
            if (r12 != 0) goto L_0x0133
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0133:
            com.meizu.media.camera.mode.f r12 = r12.mo18029aN()
            if (r12 != 0) goto L_0x013c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x013c:
            com.meizu.media.camera.mode.CameraModeType$ModeType r12 = r12.mo20403g_()
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.MANUAL
            if (r12 != r1) goto L_0x014b
        L_0x0144:
            boolean[] r12 = new boolean[r9]
            r12[r8] = r8
            r10.mo17933b((boolean[]) r12)
        L_0x014b:
            com.meizu.media.camera.MzCamModule r12 = r10.f10000b
            if (r12 != 0) goto L_0x0154
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0154:
            com.meizu.media.camera.l r12 = r12.mo18038aW()
            if (r12 != 0) goto L_0x015d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x015d:
            r1 = 4
            boolean[] r2 = new boolean[r8]
            r12.mo20317a((int) r1, (boolean[]) r2)
        L_0x0163:
            com.meizu.media.camera.MzCamModule r12 = r10.f10000b
            if (r12 != 0) goto L_0x016c
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x016c:
            com.meizu.media.camera.h r12 = r12.mo18097be()
            if (r12 == 0) goto L_0x0197
            com.meizu.media.camera.MzCamModule r12 = r10.f10000b
            if (r12 != 0) goto L_0x017b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x017b:
            com.meizu.media.camera.h r12 = r12.mo18097be()
            if (r12 != 0) goto L_0x0184
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0184:
            com.meizu.media.camera.MzCamModule r1 = r10.f10000b
            if (r1 != 0) goto L_0x018d
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x018d:
            int r1 = r1.mo18114bv()
            if (r1 != r0) goto L_0x0194
            r8 = 1
        L_0x0194:
            r12.mo20207a((com.meizu.media.camera.camcontroller.CameraController.FlashMode) r11, (boolean) r8)
        L_0x0197:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17887a(com.meizu.media.camera.camcontroller.CameraController$FlashMode, boolean):void");
    }

    /* renamed from: a */
    public void mo17891a(boolean z, int i) {
        int i2;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Integer(i)}, this, f9999a, false, 4346, new Class[]{Boolean.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f10001c;
            StringBuilder sb = new StringBuilder();
            sb.append("mCameraState:");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            sb.append(mzCamModule.mo18114bv());
            LogUtil.m15942a(aVar, sb.toString());
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule2.mo18032aQ()) {
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule3.mo18115bw() != MzCamController.ModuleState.SWITCHING_CAMERA) {
                    MzCamModule mzCamModule4 = this.f10000b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule4.mo18036aU() != null) {
                        MzCamModule mzCamModule5 = this.f10000b;
                        if (mzCamModule5 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        MzUIController aU = mzCamModule5.mo18036aU();
                        if (aU == null) {
                            C3443i.m21151a();
                        }
                        DeviceUtil.m16194a(aU.mo21541af(), 22560);
                    }
                    int V = CameraController.m8865V();
                    if (V <= 1) {
                        LogUtil.C2630a aVar2 = this.f10001c;
                        LogUtil.m15949b(aVar2, "numberOfCameras = " + V);
                        return;
                    }
                    MzCamModule mzCamModule6 = this.f10000b;
                    if (mzCamModule6 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule6.mo18249n(mzCamModule6.mo18081bO() + 1);
                    MzCamModule mzCamModule7 = this.f10000b;
                    if (mzCamModule7 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamModule mzCamModule8 = this.f10000b;
                    if (mzCamModule8 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule8.mo18031aP() != 1) {
                        i2 = 1;
                    } else if (!DeviceHelper.f14043m || CameraModeType.m10946a() != CameraModeType.ModeType.PORTRAIT) {
                        i2 = CameraModeType.m10946a() == CameraModeType.ModeType.TOF ? DeviceHelper.f13913bM : 0;
                    } else {
                        i2 = DeviceHelper.f13911bK;
                    }
                    mzCamModule7.mo18242j(i2);
                    if (DeviceHelper.f14043m) {
                        MzCamModule mzCamModule9 = this.f10000b;
                        if (mzCamModule9 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule9.mo18031aP() == 0 && CameraModeType.m10946a() == CameraModeType.ModeType.AUTO && DeviceHelper.f13851aD) {
                            MzCamModule mzCamModule10 = this.f10000b;
                            if (mzCamModule10 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            mzCamModule10.mo18242j(DeviceHelper.f13912bL);
                        }
                    }
                    EffectRenderContext h = EffectRenderContext.m4369h();
                    C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                    h.mo14215g(true);
                    MzCamModule mzCamModule11 = this.f10000b;
                    if (mzCamModule11 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule11.mo18262s(4);
                    MzCamModule mzCamModule12 = this.f10000b;
                    if (mzCamModule12 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule12.mo18005a(MzCamController.ModuleState.SWITCHING_CAMERA);
                    MzCamModule mzCamModule13 = this.f10000b;
                    if (mzCamModule13 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzUIController aU2 = mzCamModule13.mo18036aU();
                    if (aU2 == null) {
                        C3443i.m21151a();
                    }
                    aU2.mo21611l(false);
                    MzCamModule mzCamModule14 = this.f10000b;
                    if (mzCamModule14 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzUIController aU3 = mzCamModule14.mo18036aU();
                    if (aU3 == null) {
                        C3443i.m21151a();
                    }
                    aU3.mo21506a(0);
                    MzCamModule mzCamModule15 = this.f10000b;
                    if (mzCamModule15 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzUIController aU4 = mzCamModule15.mo18036aU();
                    if (aU4 == null) {
                        C3443i.m21151a();
                    }
                    aU4.mo21585e(i, true);
                    MzCamModule mzCamModule16 = this.f10000b;
                    if (mzCamModule16 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule16.mo18095bc() == CameraModeType.ModeType.VIDEO) {
                        EffectRenderContext h2 = EffectRenderContext.m4369h();
                        C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
                        h2.mo14186a(true);
                    }
                    MzCamModule mzCamModule17 = this.f10000b;
                    if (mzCamModule17 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule17.mo18145cW();
                    MzCamModule mzCamModule18 = this.f10000b;
                    if (mzCamModule18 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule18.mo18168ct();
                    MzCamModule mzCamModule19 = this.f10000b;
                    if (mzCamModule19 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule19.mo18095bc() == null) {
                        boolean o = CameraModeType.m10987o(CameraModeType.m10946a());
                        MzCamModule mzCamModule20 = this.f10000b;
                        if (mzCamModule20 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        mzCamModule20.mo18016a(true, true, CameraModeType.m10946a() == CameraModeType.ModeType.FUNNY_SNAP, o, CameraModeType.m10946a() == CameraModeType.ModeType.AR);
                    }
                    mo17937d(false);
                }
            }
        }
    }

    /* renamed from: E */
    public void mo17856E() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4347, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule.mo18032aQ()) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule2.mo18114bv() != 4) {
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule3.mo18114bv() != 0) {
                        MzCamModule mzCamModule4 = this.f10000b;
                        if (mzCamModule4 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule4.mo18029aN() != null) {
                            MzCamModule mzCamModule5 = this.f10000b;
                            if (mzCamModule5 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            MzCamUI u = mzCamModule5.mo18267u();
                            if (u == null) {
                                C3443i.m21151a();
                            }
                            if (!u.mo22191s()) {
                                MzCamModule mzCamModule6 = this.f10000b;
                                if (mzCamModule6 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                MzUIController aU = mzCamModule6.mo18036aU();
                                if (aU == null) {
                                    C3443i.m21151a();
                                }
                                DeviceUtil.m16194a(aU.mo21541af(), 22560);
                                MzCamModule mzCamModule7 = this.f10000b;
                                if (mzCamModule7 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                CameraMode aN = mzCamModule7.mo18029aN();
                                if (aN == null) {
                                    C3443i.m21151a();
                                }
                                aN.mo20412o();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:385:0x05b4, code lost:
        if (r3.mo18031aP() != 1) goto L_0x058e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0605  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0625  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x063a  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x067f  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0691  */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x0698  */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x06a4  */
    /* JADX WARNING: Removed duplicated region for block: B:461:0x06af  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x06b9  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x06c4  */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x06ce  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17934c(int r18) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = 1
            java.lang.Object[] r0 = new java.lang.Object[r9]
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r8)
            r10 = 0
            r0[r10] = r1
            com.meizu.savior.ChangeQuickRedirect r2 = f9999a
            java.lang.Class[] r5 = new java.lang.Class[r9]
            java.lang.Class r1 = java.lang.Integer.TYPE
            r5[r10] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 4348(0x10fc, float:6.093E-42)
            r1 = r17
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            com.meizu.media.camera.util.ac$a r0 = r7.f10001c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onModeChange"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0046
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0046:
            boolean r0 = r0.mo18032aQ()
            if (r0 == 0) goto L_0x00bd
            com.meizu.media.camera.util.ac$a r0 = r7.f10001c
            java.lang.String r1 = "No need to change mode"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x005c
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x005c:
            r0.mo18249n((int) r10)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0068
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0068:
            r0.mo17969I(r10)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0074
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0074:
            com.meizu.media.camera.MzCamController$ModuleState r1 = com.meizu.media.camera.MzCamController.ModuleState.IDLE
            r0.mo18005a((com.meizu.media.camera.MzCamController.ModuleState) r1)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0082
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0082:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x008b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x008b:
            com.meizu.media.camera.MzCamModule r1 = r7.f10000b
            if (r1 != 0) goto L_0x0094
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0094:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 == 0) goto L_0x00b1
            com.meizu.media.camera.MzCamModule r1 = r7.f10000b
            if (r1 != 0) goto L_0x00a3
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00a3:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x00ac
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ac:
            int r1 = r1.mo20543V()
            goto L_0x00b9
        L_0x00b1:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            int r1 = com.meizu.media.camera.mode.CameraModeType.m10962e((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
        L_0x00b9:
            r0.mo21638u((int) r1)
            return
        L_0x00bd:
            com.meizu.media.camera.mode.CameraModeType$ModeType[] r0 = com.meizu.media.camera.mode.CameraModeType.f10557b
            r0 = r0[r8]
            com.meizu.media.camera.util.ac$a r1 = r7.f10001c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "mCameraMode:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x00d6
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x00d6:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.MzCamModule r1 = r7.f10000b
            if (r1 != 0) goto L_0x00ed
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00ed:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 == 0) goto L_0x010f
            com.meizu.media.camera.MzCamModule r1 = r7.f10000b
            if (r1 != 0) goto L_0x00fc
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00fc:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x0105
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0105:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = r1.mo20403g_()
            java.lang.String r2 = "mCamModule.mCameraMode!!.modeType"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            goto L_0x0118
        L_0x010f:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            java.lang.String r2 = "CameraModeType.getCurrentCameraModeType()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
        L_0x0118:
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x0121
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0121:
            com.meizu.media.camera.l r2 = r2.mo18038aW()
            if (r2 != 0) goto L_0x012a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x012a:
            r2.mo20358w()
            com.meizu.media.camera.util.ac$a r2 = r7.f10001c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "preModeType:"
            r3.append(r4)
            java.lang.String r4 = r1.name()
            r3.append(r4)
            java.lang.String r4 = "    currentModeType:"
            r3.append(r4)
            java.lang.String r4 = r0.name()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            com.meizu.media.camera.util.ac$a r2 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "preModeType:"
            r3.append(r4)
            java.lang.String r4 = r1.name()
            r3.append(r4)
            java.lang.String r4 = "    currentModeType:"
            r3.append(r4)
            java.lang.String r4 = r0.name()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            com.meizu.media.camera.mode.CameraModeType.m10962e((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 != r0) goto L_0x01b0
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x0187
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0187:
            boolean r2 = r2.mo18159ck()
            if (r2 != 0) goto L_0x01b0
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0196
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0196:
            com.meizu.media.camera.MzCamModule r1 = r7.f10000b
            if (r1 != 0) goto L_0x019f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x019f:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x01a8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01a8:
            boolean r1 = r1.mo21590f()
            r0.mo18046ae(r1)
            return
        L_0x01b0:
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x01b9
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01b9:
            int r3 = r2.mo18081bO()
            int r3 = r3 + r9
            r2.mo18249n((int) r3)
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x01ca
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01ca:
            float r2 = r2.mo18113bu()
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r2 = com.meizu.media.camera.util.CameraUtil.m15829a((float) r2)
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r3 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_18X_9_FullScreen
            if (r2 == r3) goto L_0x01f1
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r3 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_18_9
            if (r2 != r3) goto L_0x01db
            goto L_0x01f1
        L_0x01db:
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x01e4
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01e4:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x01ed
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01ed:
            r2.mo22179o((boolean) r10)
            goto L_0x0206
        L_0x01f1:
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x01fa
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01fa:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x0203
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0203:
            r2.mo22179o((boolean) r9)
        L_0x0206:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            if (r1 == r2) goto L_0x020c
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING
        L_0x020c:
            boolean r15 = com.meizu.media.camera.mode.CameraModeType.m10987o((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.AR
            if (r1 != r2) goto L_0x0217
            r16 = 1
            goto L_0x0219
        L_0x0217:
            r16 = 0
        L_0x0219:
            com.meizu.media.camera.MzCamModule r11 = r7.f10000b
            if (r11 != 0) goto L_0x0222
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0222:
            r12 = 1
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x022c
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x022c:
            boolean r13 = r2.mo18160cl()
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            if (r1 != r2) goto L_0x0236
            r14 = 1
            goto L_0x0237
        L_0x0236:
            r14 = 0
        L_0x0237:
            r11.mo18016a((boolean) r12, (boolean) r13, (boolean) r14, (boolean) r15, (boolean) r16)
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x0243
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0243:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x024c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x024c:
            r2.mo22098aE()
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13928bb
            if (r2 == 0) goto L_0x0281
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x025c
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x025c:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x0265
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0265:
            boolean r3 = r17.mo17873V()
            r2.mo22086a((boolean) r3, (int) r10)
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x0275
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0275:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x027e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x027e:
            r2.mo22193t()
        L_0x0281:
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x028a
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x028a:
            com.meizu.media.camera.MzCamController$ModuleState r3 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_MODE
            r2.mo18005a((com.meizu.media.camera.MzCamController.ModuleState) r3)
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x0298
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0298:
            r2.mo17970J(r10)
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x02a4
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x02a4:
            r2.mo18141cS()
            com.meizu.media.camera.mode.CameraModeType.m10959d((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            com.meizu.media.camera.mode.CameraModeType.m10952b((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x02b6
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x02b6:
            int r2 = r2.mo18031aP()
            boolean r3 = com.meizu.media.camera.mode.CameraModeType.m10970g((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r3 == 0) goto L_0x02d0
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x02c9
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x02c9:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f13939bm
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x02d0:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.TOF
            if (r0 != r3) goto L_0x0307
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13855aH
            if (r3 == 0) goto L_0x02f7
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x02e1
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x02e1:
            int r3 = r3.mo18031aP()
            if (r3 == r9) goto L_0x03c9
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x02f0
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x02f0:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f13913bM
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x02f7:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0300
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0300:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f13913bM
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x0307:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.NightVision
            if (r0 != r3) goto L_0x031b
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0314
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0314:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f13913bM
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x031b:
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f14043m
            if (r3 == 0) goto L_0x0356
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r0 != r3) goto L_0x0356
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13855aH
            if (r3 == 0) goto L_0x0346
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0330
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0330:
            int r3 = r3.mo18031aP()
            if (r3 == r9) goto L_0x03c9
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x033f
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x033f:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f13911bK
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x0346:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x034f
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x034f:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f13911bK
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x0356:
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13851aD
            if (r3 == 0) goto L_0x037c
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.AUTO
            if (r0 != r3) goto L_0x037c
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0367
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0367:
            int r3 = r3.mo18031aP()
            if (r3 == r9) goto L_0x037c
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0376
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0376:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f13912bL
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x037c:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            if (r0 != r3) goto L_0x0384
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.AR
            if (r1 != r3) goto L_0x0388
        L_0x0384:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING
            if (r0 != r3) goto L_0x0395
        L_0x0388:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0391
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0391:
            r3.mo18242j((int) r9)
            goto L_0x03c9
        L_0x0395:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.MACRO
            if (r0 != r3) goto L_0x03a8
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x03a2
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x03a2:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f14030dv
            r3.mo18242j((int) r4)
            goto L_0x03c9
        L_0x03a8:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x03b1
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x03b1:
            int r3 = r3.mo18031aP()
            if (r3 != r9) goto L_0x03bd
            boolean r3 = com.meizu.media.camera.mode.CameraModeType.m10967f((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r3 != 0) goto L_0x03c9
        L_0x03bd:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x03c6
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x03c6:
            r3.mo18242j((int) r10)
        L_0x03c9:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x03d2
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x03d2:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()
            if (r3 == 0) goto L_0x044d
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x03e1
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x03e1:
            com.meizu.media.camera.util.at r3 = r3.mo18096bd()
            if (r3 == 0) goto L_0x03fc
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x03f0
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x03f0:
            com.meizu.media.camera.util.at r3 = r3.mo18096bd()
            if (r3 != 0) goto L_0x03f9
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x03f9:
            r3.mo22698c((boolean) r10)
        L_0x03fc:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0405
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0405:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()
            if (r3 != 0) goto L_0x040e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x040e:
            r3.mo20404h_()
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x041a
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x041a:
            com.meizu.media.camera.u r3 = r3.mo18036aU()
            if (r3 != 0) goto L_0x0423
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0423:
            r3.mo21644x()
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x042f
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x042f:
            com.meizu.media.camera.n r3 = r3.mo18026aK()
            if (r3 != 0) goto L_0x0438
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0438:
            r3.mo20766a((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0444
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0444:
            com.meizu.media.camera.f.i r3 = r3.mo18106bn()
            com.meizu.media.camera.util.Contants$AsdSceneType r4 = com.meizu.media.camera.util.Contants.AsdSceneType.AUTO
            r3.mo18557a((com.meizu.media.camera.util.Contants.AsdSceneType) r4)
        L_0x044d:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0456
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0456:
            r3.mo18244k((int) r10)
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0462
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0462:
            r3.mo18259q((int) r10)
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x046e
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x046e:
            com.meizu.media.camera.MzCamModule r4 = r7.f10000b
            if (r4 != 0) goto L_0x0477
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x0477:
            com.meizu.media.camera.CameraActivity r4 = r4.mo18030aO()
            com.meizu.media.camera.MzCamModule r5 = r7.f10000b
            if (r5 != 0) goto L_0x0484
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x0484:
            com.meizu.media.camera.l r5 = r5.mo18038aW()
            com.meizu.media.camera.MzCamModule r6 = r7.f10000b
            if (r6 != 0) goto L_0x0491
            java.lang.String r11 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r11)
        L_0x0491:
            com.meizu.media.camera.u r6 = r6.mo18036aU()
            com.meizu.media.camera.MzCamModule r11 = r7.f10000b
            if (r11 != 0) goto L_0x049e
            java.lang.String r12 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r12)
        L_0x049e:
            com.meizu.media.camera.mode.h r11 = (com.meizu.media.camera.mode.CameraModeListener) r11
            com.meizu.media.camera.mode.f r4 = com.meizu.media.camera.mode.CameraModeFactory.m11401a(r0, r4, r5, r6, r11)
            r3.mo18012a((com.meizu.media.camera.mode.CameraMode) r4)
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            if (r0 != r3) goto L_0x04bf
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            boolean r3 = com.meizu.media.camera.mode.CameraModeType.m10985n((com.meizu.media.camera.mode.CameraModeType.ModeType) r3)
            if (r3 == 0) goto L_0x04bf
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x04bc
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x04bc:
            r3.mo18272v((boolean) r9)
        L_0x04bf:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x04c8
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x04c8:
            int r3 = r3.mo18031aP()
            int r4 = com.meizu.media.camera.util.DeviceHelper.f14029du
            if (r3 != r4) goto L_0x053d
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x04d9
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x04d9:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()
            if (r3 != 0) goto L_0x04e2
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x04e2:
            com.meizu.media.camera.mode.CameraModeType$ModeType r4 = com.meizu.media.camera.mode.CameraModeType.ModeType.VIDEO
            boolean r3 = r3.mo20547a((com.meizu.media.camera.mode.CameraModeType.ModeType) r4)
            if (r3 == 0) goto L_0x053d
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x04f3
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x04f3:
            com.meizu.media.camera.e r3 = r3.mo18039aX()
            if (r3 == 0) goto L_0x0524
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0502
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0502:
            com.meizu.media.camera.e r3 = r3.mo18039aX()
            if (r3 != 0) goto L_0x050b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x050b:
            java.lang.String r4 = "pref_video_quality_key"
            r5 = 0
            java.lang.String r3 = r3.getString(r4, r5)
            if (r3 != 0) goto L_0x0516
            r3 = -1
            goto L_0x0525
        L_0x0516:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "Integer.valueOf(videoQuality)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            int r3 = r3.intValue()
            goto L_0x0525
        L_0x0524:
            r3 = 0
        L_0x0525:
            int r4 = com.meizu.media.camera.util.DeviceHelper.f14004cy
            if (r3 == r4) goto L_0x0531
            int r4 = com.meizu.media.camera.util.DeviceHelper.f14005cz
            if (r3 == r4) goto L_0x0531
            int r4 = com.meizu.media.camera.util.DeviceHelper.f14003cx
            if (r3 != r4) goto L_0x053d
        L_0x0531:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x053a
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x053a:
            r3.mo18242j((int) r10)
        L_0x053d:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0546
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0546:
            boolean r3 = r3.mo18160cl()
            if (r3 == 0) goto L_0x0564
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0555
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0555:
            r3.mo18242j((int) r9)
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x0561
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0561:
            r3.mo17980T(r10)
        L_0x0564:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x056d
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x056d:
            com.meizu.media.camera.u r3 = r3.mo18036aU()
            if (r3 != 0) goto L_0x0576
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0576:
            com.meizu.media.camera.MzCamModule r4 = r7.f10000b
            if (r4 != 0) goto L_0x057f
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x057f:
            boolean r4 = r4.mo18116bx()
            boolean r4 = com.meizu.media.camera.mode.CameraModeType.m10949a(r8, r4)
            r3.mo21570b(r4, r10, r10)
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13927ba
            if (r3 == 0) goto L_0x0591
        L_0x058e:
            r1 = 1
            goto L_0x0601
        L_0x0591:
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r3 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r4 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PRO7SERIES
            if (r3 != r4) goto L_0x05b7
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.AUTO
            if (r1 == r3) goto L_0x05a7
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r1 == r3) goto L_0x05a7
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.AUTO
            if (r0 == r3) goto L_0x05a7
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r0 != r3) goto L_0x05b7
        L_0x05a7:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x05b0
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x05b0:
            int r3 = r3.mo18031aP()
            if (r3 == r9) goto L_0x05b7
            goto L_0x058e
        L_0x05b7:
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r3 == 0) goto L_0x05c4
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r1 == r3) goto L_0x058e
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r0 != r3) goto L_0x05c4
            goto L_0x058e
        L_0x05c4:
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r3 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r4 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY
            if (r3 == r4) goto L_0x05d0
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r3 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r4 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL
            if (r3 != r4) goto L_0x05d9
        L_0x05d0:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r1 == r3) goto L_0x058e
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r0 != r3) goto L_0x05d9
            goto L_0x058e
        L_0x05d9:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            if (r0 != r3) goto L_0x05de
            goto L_0x058e
        L_0x05de:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x05e7
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x05e7:
            int r3 = r3.mo18031aP()
            if (r2 == r3) goto L_0x05ee
            goto L_0x058e
        L_0x05ee:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.TOF
            if (r1 == r3) goto L_0x058e
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.TOF
            if (r0 != r3) goto L_0x05f7
            goto L_0x058e
        L_0x05f7:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.NightVision
            if (r1 == r3) goto L_0x058e
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.NightVision
            if (r0 != r1) goto L_0x0600
            goto L_0x058e
        L_0x0600:
            r1 = 0
        L_0x0601:
            com.meizu.media.camera.MzCamModule r3 = r7.f10000b
            if (r3 != 0) goto L_0x060a
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x060a:
            r3.mo17968H(r1)
            com.meizu.media.camera.util.ac$a r3 = r7.f10001c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "preCameraId:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ",currentCameraId:"
            r4.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r7.f10000b
            if (r2 != 0) goto L_0x062a
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x062a:
            int r2 = r2.mo18031aP()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r2)
            if (r1 == 0) goto L_0x067f
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r1 == 0) goto L_0x0658
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r0 != r1) goto L_0x0658
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x064b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x064b:
            com.meizu.media.camera.ui.i r0 = r0.mo18037aV()
            if (r0 != 0) goto L_0x0654
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0654:
            r0.mo22145c((int) r10)
            goto L_0x066f
        L_0x0658:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0661
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0661:
            com.meizu.media.camera.ui.i r0 = r0.mo18037aV()
            if (r0 != 0) goto L_0x066a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x066a:
            r1 = 8
            r0.mo22145c((int) r1)
        L_0x066f:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0678
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0678:
            r0.mo18168ct()
            r7.mo17937d((boolean) r10)
            goto L_0x068b
        L_0x067f:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x0688
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0688:
            r0.mo18136cN()
        L_0x068b:
            boolean r0 = r17.mo17873V()
            if (r0 != 0) goto L_0x0694
            r7.mo17931b((boolean) r10, (int) r10)
        L_0x0694:
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x069d
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x069d:
            r0.mo18278y((boolean) r9)
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x06a9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06a9:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x06b2
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x06b2:
            r0.mo21637u()
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x06be
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06be:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x06c7
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x06c7:
            r0.mo20457ab()
            com.meizu.media.camera.MzCamModule r0 = r7.f10000b
            if (r0 != 0) goto L_0x06d3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06d3:
            r0.mo18046ae(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17934c(int):void");
    }

    /* renamed from: F */
    public void mo17857F() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4349, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18029aN() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule2.mo18036aU() != null) {
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    CameraMode aN = mzCamModule3.mo18029aN();
                    if (aN == null) {
                        C3443i.m21151a();
                    }
                    aN.mo20550ad();
                }
            }
        }
    }

    /* renamed from: d */
    public void mo17937d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4350, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzDynamicFilterManager aJ = mzCamModule.mo18025aJ();
            if (aJ == null) {
                C3443i.m21151a();
            }
            aJ.mo20079a(z, true);
        }
    }

    /* renamed from: a */
    public void mo17894a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4351, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzDynamicFilterManager aJ = mzCamModule.mo18025aJ();
            if (aJ == null) {
                C3443i.m21151a();
            }
            aJ.mo20079a(z, z2);
        }
    }

    /* renamed from: G */
    public void mo17858G() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4352, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzDynamicFilterManager aJ = mzCamModule.mo18025aJ();
            if (aJ == null) {
                C3443i.m21151a();
            }
            aJ.mo20086g();
        }
    }

    /* renamed from: H */
    public boolean mo17859H() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4353, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17859H();
    }

    /* renamed from: I */
    public boolean mo17860I() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4354, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            if (!DeviceHelper.f13877ad) {
                return false;
            }
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            Contants.AsdSceneType a = aU.mo21504a();
            C3443i.m21152a((Object) a, "mCamModule.mCommonUI!!.asdSceneType");
            return C3443i.m21154a((Object) a.getAsdEffect().f13819e, (Object) "Mznone") ^ true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: J */
    public void mo17861J() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4355, new Class[0], Void.TYPE).isSupported) {
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            h.mo14207d(true);
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzDynamicFilterManager aJ = mzCamModule.mo18025aJ();
            if (aJ == null) {
                C3443i.m21151a();
            }
            aJ.mo20081b();
            EffectRenderContext h2 = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            h2.mo14219i(mzCamModule2.mo18031aP());
        }
    }

    @Nullable
    /* renamed from: aF */
    public MzDynamicFilterManager mo17903aF() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4356, new Class[0], MzDynamicFilterManager.class);
        if (proxy.isSupported) {
            return (MzDynamicFilterManager) proxy.result;
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18025aJ();
    }

    /* renamed from: K */
    public boolean mo17862K() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4357, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzUIController aU = mzCamModule.mo18036aU();
        if (aU == null) {
            C3443i.m21151a();
        }
        return aU.mo21649z();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b3, code lost:
        if (r0.mo18072bF() != false) goto L_0x00b5;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17939e(boolean r9) {
        /*
            r8 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r9)
            r3 = 0
            r1[r3] = r2
            com.meizu.savior.ChangeQuickRedirect r4 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r0 = java.lang.Boolean.TYPE
            r6[r3] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r0 = 0
            r5 = 4358(0x1106, float:6.107E-42)
            r2 = r8
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0024
            return
        L_0x0024:
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13865aR
            if (r0 != 0) goto L_0x0029
            return
        L_0x0029:
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x0032
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0032:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 == 0) goto L_0x0088
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x0041
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0041:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x004a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x004a:
            int r0 = r0.mo20543V()
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10966f((int) r0)
            if (r0 != 0) goto L_0x0088
            com.meizu.media.camera.MzCamModule r9 = r8.f10000b
            if (r9 != 0) goto L_0x005d
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x005d:
            com.meizu.media.camera.ac r9 = r9.mo18024aI()
            if (r9 == 0) goto L_0x0087
            com.meizu.media.camera.MzCamModule r9 = r8.f10000b
            if (r9 != 0) goto L_0x006c
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x006c:
            com.meizu.media.camera.ac r9 = r9.mo18024aI()
            if (r9 != 0) goto L_0x0075
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0075:
            r9.mo18765b()
            com.meizu.media.camera.MzCamModule r9 = r8.f10000b
            if (r9 != 0) goto L_0x0081
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x0081:
            r0 = 0
            com.meizu.media.camera.ac r0 = (com.meizu.media.camera.VoiceAssist) r0
            r9.mo18008a((com.meizu.media.camera.VoiceAssist) r0)
        L_0x0087:
            return
        L_0x0088:
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x0091
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0091:
            com.meizu.media.camera.ac r0 = r0.mo18024aI()
            if (r0 != 0) goto L_0x00ea
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x00a0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00a0:
            boolean r0 = r0.mo18032aQ()
            if (r0 == 0) goto L_0x00b5
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x00af
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00af:
            boolean r0 = r0.mo18072bF()
            if (r0 == 0) goto L_0x00ea
        L_0x00b5:
            if (r9 != 0) goto L_0x00b8
            return
        L_0x00b8:
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x00c1
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00c1:
            com.meizu.media.camera.ac r1 = new com.meizu.media.camera.ac
            com.meizu.media.camera.MzCamModule r2 = r8.f10000b
            if (r2 != 0) goto L_0x00cc
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00cc:
            com.meizu.media.camera.CameraActivity r2 = r2.mo18030aO()
            if (r2 != 0) goto L_0x00d5
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00d5:
            android.content.Context r2 = r2.getApplicationContext()
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x00e2
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x00e2:
            com.meizu.media.camera.ac$a r3 = (com.meizu.media.camera.VoiceAssist.C1790a) r3
            r1.<init>(r2, r3)
            r0.mo18008a((com.meizu.media.camera.VoiceAssist) r1)
        L_0x00ea:
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x00f3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00f3:
            com.meizu.media.camera.ac r0 = r0.mo18024aI()
            if (r0 == 0) goto L_0x0128
            if (r9 == 0) goto L_0x0113
            com.meizu.media.camera.MzCamModule r9 = r8.f10000b
            if (r9 != 0) goto L_0x0104
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x0104:
            com.meizu.media.camera.ac r9 = r9.mo18024aI()
            if (r9 != 0) goto L_0x010d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x010d:
            r0 = 50
            r9.mo18764a((long) r0)
            goto L_0x0128
        L_0x0113:
            com.meizu.media.camera.MzCamModule r9 = r8.f10000b
            if (r9 != 0) goto L_0x011c
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x011c:
            com.meizu.media.camera.ac r9 = r9.mo18024aI()
            if (r9 != 0) goto L_0x0125
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0125:
            r9.mo18763a()
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17939e(boolean):void");
    }

    /* renamed from: L */
    public boolean mo17863L() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4359, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18030aO() == null) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f10000b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraActivity aO = mzCamModule2.mo18030aO();
        if (aO == null) {
            C3443i.m21151a();
        }
        Intent intent = aO.getIntent();
        C3443i.m21152a((Object) intent, "mCamModule.mActivity!!.intent");
        return MzSimplifyImageCaptureHandler.m13135b(intent.getAction());
    }

    /* renamed from: N */
    public boolean mo17865N() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4360, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18094bb();
    }

    /* renamed from: f */
    public void mo17941f(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4362, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18097be() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                FocusOverlayManager be = mzCamModule2.mo18097be();
                if (be == null) {
                    C3443i.m21151a();
                }
                be.mo20218d(z);
            }
        }
    }

    /* renamed from: a */
    public void mo17889a(@Nullable RenderOverlay renderOverlay, @Nullable PreviewGestures yVar) {
        Class[] clsArr = {RenderOverlay.class, PreviewGestures.class};
        if (!PatchProxy.proxy(new Object[]{renderOverlay, yVar}, this, f9999a, false, 4363, clsArr, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21523a(renderOverlay, yVar);
        }
    }

    /* renamed from: g */
    public void mo17943g(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4364, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18029aN() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN = mzCamModule2.mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                if (aN.mo20543V() == CameraModeType.m10962e(CameraModeType.ModeType.AUTO)) {
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (!mzCamModule3.mo18116bx()) {
                        MzCamModule mzCamModule4 = this.f10000b;
                        if (mzCamModule4 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule4.mo18097be() != null) {
                            MzCamModule mzCamModule5 = this.f10000b;
                            if (mzCamModule5 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            FocusOverlayManager be = mzCamModule5.mo18097be();
                            if (be == null) {
                                C3443i.m21151a();
                            }
                            be.mo20224g(z);
                        }
                        MzCamModule mzCamModule6 = this.f10000b;
                        if (mzCamModule6 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        MzCamParamsManager aW = mzCamModule6.mo18038aW();
                        if (aW == null) {
                            C3443i.m21151a();
                        }
                        aW.mo20334c(z);
                        return;
                    }
                }
            }
            MzCamModule mzCamModule7 = this.f10000b;
            if (mzCamModule7 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule7.mo18097be() != null) {
                MzCamModule mzCamModule8 = this.f10000b;
                if (mzCamModule8 == null) {
                    C3443i.m21156b("mCamModule");
                }
                FocusOverlayManager be2 = mzCamModule8.mo18097be();
                if (be2 == null) {
                    C3443i.m21151a();
                }
                be2.mo20224g(z);
            }
            MzCamModule mzCamModule9 = this.f10000b;
            if (mzCamModule9 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamParamsManager aW2 = mzCamModule9.mo18038aW();
            if (aW2 == null) {
                C3443i.m21151a();
            }
            aW2.mo20334c(z);
        }
    }

    /* renamed from: O */
    public void mo17866O() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4365, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(this.f10001c, "onSurfaceTextureAvailable");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17965E(true);
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18025aJ() == null || !mo17859H() || !DeviceHelper.f13886am || DeviceHelper.f13910bJ != CameraController.CameraApi.API2) {
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule3.mo18037aV() != null) {
                    MzCamModule mzCamModule4 = this.f10000b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamUI aV = mzCamModule4.mo18037aV();
                    if (aV == null) {
                        C3443i.m21151a();
                    }
                    aV.mo22141b("Mznone");
                    return;
                }
                return;
            }
            MzCamModule mzCamModule5 = this.f10000b;
            if (mzCamModule5 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzDynamicFilterManager aJ = mzCamModule5.mo18025aJ();
            if (aJ == null) {
                C3443i.m21151a();
            }
            aJ.mo20089j();
        }
    }

    /* renamed from: P */
    public void mo17867P() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4366, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17965E(true);
        }
    }

    /* renamed from: Q */
    public void mo17868Q() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4367, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            synchronized (mzCamModule.mo18088bV()) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule2.mo17998a((SurfaceTexture) null);
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule3.mo18002a((SurfaceTextureWrapper) null);
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: R */
    public void mo17869R() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4368, new Class[0], Void.TYPE).isSupported && CameraModeType.m10983m(CameraModeType.ModeType.GIF)) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule.mo18029aN();
            if (aN != null) {
                ((GifMode) aN).mo20562c();
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule2.mo18262s(1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.GifMode");
        }
    }

    /* renamed from: h */
    public void mo17945h(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4369, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (CameraModeType.m10983m(CameraModeType.ModeType.AR)) {
                MzCamModule mzCamModule = this.f10000b;
                if (mzCamModule == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN = mzCamModule.mo18029aN();
                if (aN != null) {
                    ((ARMode) aN).mo20392a(z);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.ARMode");
            } else if (CameraModeType.m10983m(CameraModeType.ModeType.NightVision)) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN2 = mzCamModule2.mo18029aN();
                if (aN2 != null) {
                    ((NightVisionMode) aN2).mo20605a(z);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.NightVisionMode");
            }
        }
    }

    /* renamed from: i */
    public void mo17946i(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4370, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule.mo18037aV();
            if (aV == null) {
                C3443i.m21151a();
            }
            aV.mo22184p(z);
        }
    }

    /* renamed from: j */
    public void mo17947j(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4371, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18097be() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                FocusOverlayManager be = mzCamModule2.mo18097be();
                if (be == null) {
                    C3443i.m21151a();
                }
                be.mo20228i(z);
            }
        }
    }

    /* renamed from: a */
    public void mo17890a(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f9999a, false, 4372, new Class[]{String.class}, Void.TYPE).isSupported && DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18153ce() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                EffectRenderEngine ce = mzCamModule2.mo18153ce();
                if (ce == null) {
                    C3443i.m21151a();
                }
                ce.mo14071a(str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0085, code lost:
        if (r1 == r2.mo20403g_()) goto L_0x0087;
     */
    /* renamed from: S */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17870S() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4373(0x1115, float:6.128E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x001f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x001f:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0028
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0028:
            r2 = 1024(0x400, float:1.435E-42)
            r1.mo21581d((int) r2, (boolean) r0)
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0036
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0036:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x003f
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x003f:
            com.meizu.media.camera.MzCamModule r2 = r8.f10000b
            if (r2 != 0) goto L_0x0048
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0048:
            int r2 = r2.mo18031aP()
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x0055
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0055:
            boolean r3 = r3.mo18093ba()
            r4 = 1
            r3 = r3 ^ r4
            r1.mo21585e((int) r2, (boolean) r3)
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0067
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0067:
            boolean r1 = r1.mo18098bf()
            if (r1 != 0) goto L_0x0087
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.GIF
            com.meizu.media.camera.MzCamModule r2 = r8.f10000b
            if (r2 != 0) goto L_0x0078
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0078:
            com.meizu.media.camera.mode.f r2 = r2.mo18029aN()
            if (r2 != 0) goto L_0x0081
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0081:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = r2.mo20403g_()
            if (r1 != r2) goto L_0x00bd
        L_0x0087:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0090
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0090:
            r1.mo18272v((boolean) r0)
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x009c
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x009c:
            com.meizu.media.camera.ui.i r1 = r1.mo18037aV()
            if (r1 != 0) goto L_0x00a5
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00a5:
            r1.mo22151d((boolean) r0)
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00b1
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00b1:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x00ba
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ba:
            r1.mo21530a((boolean) r0)
        L_0x00bd:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00c6
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00c6:
            boolean r1 = r1.mo18093ba()
            if (r1 != 0) goto L_0x0148
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00d5
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00d5:
            boolean r1 = r1.mo18094bb()
            if (r1 != 0) goto L_0x0148
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00e4
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00e4:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = r1.mo18095bc()
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            if (r1 == r2) goto L_0x0148
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00f7
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00f7:
            r2 = 5
            r1.mo18262s((int) r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0104
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0104:
            com.meizu.media.camera.MzCamController$ModuleState r2 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_MODE
            r1.mo18005a((com.meizu.media.camera.MzCamController.ModuleState) r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0112
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0112:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x011b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x011b:
            boolean r1 = r1.mo21590f()
            if (r1 == 0) goto L_0x0148
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10987o((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            com.meizu.media.camera.MzCamModule r2 = r8.f10000b
            if (r2 != 0) goto L_0x0132
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0132:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x013b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x013b:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r5 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            if (r3 != r5) goto L_0x0144
            goto L_0x0145
        L_0x0144:
            r4 = 0
        L_0x0145:
            r2.mo22088a((boolean) r4, (boolean) r1)
        L_0x0148:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0151
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0151:
            com.meizu.media.camera.h r1 = r1.mo18097be()
            if (r1 == 0) goto L_0x016c
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0160
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0160:
            com.meizu.media.camera.h r1 = r1.mo18097be()
            if (r1 != 0) goto L_0x0169
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0169:
            r1.mo20226h(r0)
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17870S():void");
    }

    /* renamed from: b */
    public void mo17933b(@NotNull boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{zArr}, this, f9999a, false, 4374, new Class[]{boolean[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(zArr, "needUpdateNow");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18038aW() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule2.mo18036aU() != null) {
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule3.mo18029aN() != null) {
                        MzCamModule mzCamModule4 = this.f10000b;
                        if (mzCamModule4 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        MzCamParamsManager aW = mzCamModule4.mo18038aW();
                        if (aW == null) {
                            C3443i.m21151a();
                        }
                        if (aW.mo20354s() && ((DeviceHelper.f13895av || DeviceHelper.f13896aw) && DeviceHelper.f13898ay)) {
                            MzCamModule mzCamModule5 = this.f10000b;
                            if (mzCamModule5 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            CameraMode aN = mzCamModule5.mo18029aN();
                            if (aN == null) {
                                C3443i.m21151a();
                            }
                            if (aN.mo20403g_() == CameraModeType.ModeType.MANUAL) {
                                MzCamModule mzCamModule6 = this.f10000b;
                                if (mzCamModule6 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                MzCamParamsManager aW2 = mzCamModule6.mo18038aW();
                                if (aW2 == null) {
                                    C3443i.m21151a();
                                }
                                aW2.mo20331b(true, Arrays.copyOf(zArr, zArr.length));
                                return;
                            }
                        }
                        MzCamModule mzCamModule7 = this.f10000b;
                        if (mzCamModule7 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule7.mo18189dM() != CameraController.HdrMode.ON) {
                            MzCamModule mzCamModule8 = this.f10000b;
                            if (mzCamModule8 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            MzUIController aU = mzCamModule8.mo18036aU();
                            if (aU == null) {
                                C3443i.m21151a();
                            }
                            if (aU.mo21612l()) {
                                MzCamModule mzCamModule9 = this.f10000b;
                                if (mzCamModule9 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                CameraMode aN2 = mzCamModule9.mo18029aN();
                                if (aN2 == null) {
                                    C3443i.m21151a();
                                }
                                if (CameraModeType.m10979k(aN2.mo20403g_())) {
                                    if (mo17910ag()) {
                                        MzCamModule mzCamModule10 = this.f10000b;
                                        if (mzCamModule10 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        CameraMode aN3 = mzCamModule10.mo18029aN();
                                        if (aN3 == null) {
                                            C3443i.m21151a();
                                        }
                                        if (CameraModeType.m10979k(aN3.mo20403g_())) {
                                            MzCamModule mzCamModule11 = this.f10000b;
                                            if (mzCamModule11 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            boolean z = mzCamModule11.mo18031aP() == 1;
                                            if (z && DeviceHelper.f13902bB) {
                                                MzCamModule mzCamModule12 = this.f10000b;
                                                if (mzCamModule12 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                MzCamParamsManager aW3 = mzCamModule12.mo18038aW();
                                                if (aW3 == null) {
                                                    C3443i.m21151a();
                                                }
                                                aW3.mo20331b(true, Arrays.copyOf(zArr, zArr.length));
                                                return;
                                            } else if (z || !DeviceHelper.f13903bC) {
                                                MzCamModule mzCamModule13 = this.f10000b;
                                                if (mzCamModule13 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                MzCamParamsManager aW4 = mzCamModule13.mo18038aW();
                                                if (aW4 == null) {
                                                    C3443i.m21151a();
                                                }
                                                aW4.mo20331b(false, Arrays.copyOf(zArr, zArr.length));
                                                return;
                                            } else {
                                                MzCamModule mzCamModule14 = this.f10000b;
                                                if (mzCamModule14 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                MzCamParamsManager aW5 = mzCamModule14.mo18038aW();
                                                if (aW5 == null) {
                                                    C3443i.m21151a();
                                                }
                                                aW5.mo20331b(true, Arrays.copyOf(zArr, zArr.length));
                                                return;
                                            }
                                        }
                                    }
                                    MzCamModule mzCamModule15 = this.f10000b;
                                    if (mzCamModule15 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    MzCamParamsManager aW6 = mzCamModule15.mo18038aW();
                                    if (aW6 == null) {
                                        C3443i.m21151a();
                                    }
                                    aW6.mo20331b(true, Arrays.copyOf(zArr, zArr.length));
                                    return;
                                }
                            }
                        }
                        MzCamModule mzCamModule16 = this.f10000b;
                        if (mzCamModule16 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        MzCamParamsManager aW7 = mzCamModule16.mo18038aW();
                        if (aW7 == null) {
                            C3443i.m21151a();
                        }
                        aW7.mo20331b(false, Arrays.copyOf(zArr, zArr.length));
                        return;
                    }
                }
            }
            LogUtil.m15952c(this.f10001c, "not to do MFLL");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17948k(boolean r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r10)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4375(0x1117, float:6.13E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13877ad
            if (r1 == 0) goto L_0x00e9
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.AUTO
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x0031
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0031:
            com.meizu.media.camera.mode.f r2 = r2.mo18029aN()
            if (r2 != 0) goto L_0x003a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x003a:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = r2.mo20403g_()
            if (r1 != r2) goto L_0x00b3
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0049
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0049:
            boolean r1 = r1.mo18116bx()
            if (r1 != 0) goto L_0x00b3
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0058
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0058:
            com.meizu.media.camera.camcontroller.CameraController$HdrMode r1 = r1.mo18189dM()
            com.meizu.media.camera.camcontroller.CameraController$HdrMode r2 = com.meizu.media.camera.camcontroller.CameraController.HdrMode.ON
            if (r1 == r2) goto L_0x00b3
            boolean r1 = r9.mo17910ag()
            if (r1 != 0) goto L_0x00b3
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x006f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x006f:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0078
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0078:
            boolean r1 = r1.mo21649z()
            if (r1 != 0) goto L_0x00b3
            boolean r1 = r9.mo17859H()
            if (r1 != 0) goto L_0x00b3
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x008d
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x008d:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0096
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0096:
            boolean r1 = r1.mo21590f()
            if (r1 != 0) goto L_0x00b3
            boolean r1 = r9.mo17900aC()
            if (r1 != 0) goto L_0x00b3
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x00ab
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00ab:
            boolean r1 = r1.mo18134cL()
            if (r1 == 0) goto L_0x00b3
            r1 = 1
            goto L_0x00b4
        L_0x00b3:
            r1 = 0
        L_0x00b4:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.SLOWMOTION
            com.meizu.media.camera.MzCamModule r3 = r9.f10000b
            if (r3 != 0) goto L_0x00bf
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x00bf:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()
            if (r3 != 0) goto L_0x00c8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00c8:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = r3.mo20403g_()
            if (r2 == r3) goto L_0x00e9
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.util.Contants$CameraV2Key r3 = com.meizu.media.camera.util.Contants.CameraV2Key.AI_ASD_ENABLE
            java.lang.String r3 = r3.getKeyName()
            if (r1 == 0) goto L_0x00dd
            java.lang.String r1 = "1"
            goto L_0x00df
        L_0x00dd:
            java.lang.String r1 = "0"
        L_0x00df:
            r4 = 2
            boolean[] r4 = new boolean[r4]
            r4[r8] = r10
            r4[r0] = r0
            r2.mo19471a((java.lang.String) r3, (java.lang.String) r1, (boolean[]) r4)
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17948k(boolean):void");
    }

    /* renamed from: a */
    public void mo17892a(boolean z, int i, float f, @Nullable PathInterpolator pathInterpolator) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i), new Float(f), pathInterpolator};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4376, new Class[]{Boolean.TYPE, Integer.TYPE, Float.TYPE, PathInterpolator.class}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21531a(z, i, f, pathInterpolator);
        }
    }

    /* renamed from: T */
    public int mo17871T() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4377, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18031aP();
    }

    /* renamed from: U */
    public boolean mo17872U() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4378, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13929bc) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18031aP() == DeviceHelper.f14029du) {
                return false;
            }
        }
        CameraModeType.ModeType[] modeTypeArr = {CameraModeType.ModeType.PANORAMA, CameraModeType.ModeType.FUNNY_SNAP, CameraModeType.ModeType.AR, CameraModeType.ModeType.PORTRAIT, CameraModeType.ModeType.TOF, CameraModeType.ModeType.BACK_TRACE, CameraModeType.ModeType.MACRO, CameraModeType.ModeType.NightVision};
        MzCamModule mzCamModule2 = this.f10000b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule2.mo18029aN();
        if (aN != null && C3359b.m20948a(modeTypeArr, aN.mo20403g_())) {
            return false;
        }
        MzCamModule mzCamModule3 = this.f10000b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN2 = mzCamModule3.mo18029aN();
        if ((aN2 == null || aN2.mo20403g_() != CameraModeType.ModeType.AUTO) && mo17898aA()) {
            MzCamModule mzCamModule4 = this.f10000b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule4.mo18029aN() != null) {
                MzCamModule mzCamModule5 = this.f10000b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN3 = mzCamModule5.mo18029aN();
                if (aN3 == null) {
                    C3443i.m21151a();
                }
                if (aN3.mo20403g_() != CameraModeType.ModeType.PORTRAIT) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public void mo17931b(boolean z, int i) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4379, new Class[]{Boolean.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI u = mzCamModule.mo18267u();
            if (u == null) {
                C3443i.m21151a();
            }
            u.mo22086a(z, i);
        }
    }

    /* renamed from: W */
    public boolean mo17874W() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4380, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamUI u = mzCamModule.mo18267u();
        if (u == null) {
            C3443i.m21151a();
        }
        return u.mo22196u();
    }

    @Nullable
    /* renamed from: X */
    public MzCamController.ModuleState mo17875X() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4381, new Class[0], MzCamController.ModuleState.class);
        if (proxy.isSupported) {
            return (MzCamController.ModuleState) proxy.result;
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18115bw();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo27294d2 = {"com/meizu/media/camera/impl/MzCamControllerImpl$doModeOut$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.j$a */
    /* compiled from: MzCamControllerImpl.kt */
    public static final class C2059a implements Animation.AnimationListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f10002a;

        /* renamed from: b */
        final /* synthetic */ MzCamControllerImpl f10003b;

        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        C2059a(MzCamControllerImpl jVar) {
            this.f10003b = jVar;
        }

        public void onAnimationStart(@Nullable Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f10002a, false, 4453, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a a = this.f10003b.f10001c;
                LogUtil.m15942a(a, "doModeOut onAnimationStart start mSwitchingModeNum:" + this.f10003b.mo20037a().mo18081bO() + ",mIsPreviewStarted:" + this.f10003b.mo20037a().mo18075bI());
                if (this.f10003b.mo20037a().mo18081bO() > 0 || !this.f10003b.mo20037a().mo18075bI()) {
                    LogUtil.C2630a a2 = this.f10003b.f10001c;
                    LogUtil.m15956e(a2, "Return, since preview is not started or switch mode coming: " + this.f10003b.mo20037a().mo18081bO());
                    return;
                }
                MzUIController aU = this.f10003b.mo20037a().mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                aU.mo21547al();
                CameraMode aN = this.f10003b.mo20037a().mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                aN.mo20402f_();
            }
        }

        public void onAnimationEnd(@Nullable Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f10002a, false, 4454, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a a = this.f10003b.f10001c;
                LogUtil.m15942a(a, "doModeOut onAnimationEnd start mSwitchingModeNum:" + this.f10003b.mo20037a().mo18081bO() + ",mIsPreviewStarted:" + this.f10003b.mo20037a().mo18075bI());
                if (this.f10003b.mo20037a().mo18081bO() > 0 || !this.f10003b.mo20037a().mo18075bI()) {
                    LogUtil.C2630a a2 = this.f10003b.f10001c;
                    LogUtil.m15956e(a2, "Return, since preview is not started or switch mode coming: " + this.f10003b.mo20037a().mo18081bO());
                    return;
                }
                if (this.f10003b.mo20037a().mo18036aU() != null) {
                    MzUIController aU = this.f10003b.mo20037a().mo18036aU();
                    if (aU == null) {
                        C3443i.m21151a();
                    }
                    if (aU.mo21590f()) {
                        LogUtil.m15942a(this.f10003b.f10001c, "reset state to IDLE, since slide out anim cancel for change to modeController view");
                        this.f10003b.mo20037a().mo18262s(1);
                        this.f10003b.mo20037a().mo18005a(MzCamController.ModuleState.IDLE);
                        return;
                    }
                }
                if (this.f10003b.mo20037a().mo18077bK() && !this.f10003b.mo17898aA()) {
                    MzCamParamsManager aW = this.f10003b.mo20037a().mo18038aW();
                    if (aW == null) {
                        C3443i.m21151a();
                    }
                    if (!aW.mo20352q() || this.f10003b.mo20037a().mo18031aP() != 0) {
                        this.f10003b.mo20037a().mo18143cU();
                    }
                }
                if ((!this.f10003b.mo17910ag() || DeviceHelper.f13886am) && !this.f10003b.mo20037a().mo18070bD()) {
                    this.f10003b.mo17858G();
                }
                if (this.f10003b.mo20037a().mo18036aU() != null) {
                    MzUIController aU2 = this.f10003b.mo20037a().mo18036aU();
                    if (aU2 == null) {
                        C3443i.m21151a();
                    }
                    aU2.mo21548am();
                    MzUIController aU3 = this.f10003b.mo20037a().mo18036aU();
                    if (aU3 == null) {
                        C3443i.m21151a();
                    }
                    aU3.mo21585e(this.f10003b.mo20037a().mo18031aP(), false);
                }
                this.f10003b.mo20037a().mo18204db();
                MzCamUI aV = this.f10003b.mo20037a().mo18037aV();
                if (aV == null) {
                    C3443i.m21151a();
                }
                aV.mo22094aA();
                this.f10003b.mo20037a().mo18251o();
                this.f10003b.mo20037a().mo18278y(false);
                this.f10003b.mo20037a().mo18262s(1);
                this.f10003b.mo20037a().mo18005a(MzCamController.ModuleState.IDLE);
                this.f10003b.mo17941f(false);
                CameraMode aN = this.f10003b.mo20037a().mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                aN.mo20552ag();
                if (this.f10003b.mo20037a().mo18079bM()) {
                    this.f10003b.mo20037a().mo17968H(false);
                    this.f10003b.mo20037a().mo18140cR();
                    MzCamUI aV2 = this.f10003b.mo20037a().mo18037aV();
                    if (aV2 == null) {
                        C3443i.m21151a();
                    }
                    aV2.mo22128aq();
                }
                this.f10003b.mo17933b(true);
                MzCamUI aV3 = this.f10003b.mo20037a().mo18037aV();
                if (aV3 == null) {
                    C3443i.m21151a();
                }
                aV3.mo22097aD();
                MzCamUI aV4 = this.f10003b.mo20037a().mo18037aV();
                if (aV4 == null) {
                    C3443i.m21151a();
                }
                aV4.mo22201x(false);
                MzCamUI aV5 = this.f10003b.mo20037a().mo18037aV();
                if (aV5 == null) {
                    C3443i.m21151a();
                }
                aV5.mo22137az();
                LogUtil.m15942a(this.f10003b.f10001c, "doModeOut onAnimationEnd end");
            }
        }
    }

    /* renamed from: Y */
    public void mo17876Y() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4382, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(this.f10001c, "doModeOut success");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule.mo18037aV();
            if (aV == null) {
                C3443i.m21151a();
            }
            aV.mo22077a((Animation.AnimationListener) new C2059a(this));
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV2 = mzCamModule2.mo18037aV();
            if (aV2 == null) {
                C3443i.m21151a();
            }
            aV2.mo22149d();
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule3.mo18110br().sendEmptyMessage(17);
        }
    }

    /* renamed from: Z */
    public boolean mo17877Z() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4385, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18151cc();
    }

    /* renamed from: l */
    public void mo17949l(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4386, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17974N(z);
        }
    }

    /* renamed from: aa */
    public boolean mo17904aa() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4387, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18078bL();
    }

    /* renamed from: m */
    public void mo17950m(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f9999a, false, 4388, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            boolean z2 = mzCamModule.mo18031aP() == 1;
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18242j(z ? DeviceHelper.f13949bw : 0);
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule3.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            MzCamModule mzCamModule4 = this.f10000b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            aU.mo21585e(mzCamModule4.mo18031aP(), true);
            MzCamModule mzCamModule5 = this.f10000b;
            if (mzCamModule5 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule5.mo18168ct();
            MzCamModule mzCamModule6 = this.f10000b;
            if (mzCamModule6 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule6.mo18016a(true, z2, false, false, false);
            mo17937d(false);
        }
    }

    /* renamed from: n */
    public void mo17951n(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f9999a, false, 4389, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            boolean z2 = mzCamModule.mo18031aP() == 1;
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18242j(0);
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamParamsManager aW = mzCamModule3.mo18038aW();
            if (aW == null) {
                C3443i.m21151a();
            }
            aW.mo20337d(z);
            MzCamModule mzCamModule4 = this.f10000b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule4.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            if (aN.mo20403g_() == CameraModeType.ModeType.MANUAL) {
                MzCamModule mzCamModule5 = this.f10000b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN2 = mzCamModule5.mo18029aN();
                if (aN2 != null) {
                    ((ManualMode) aN2).mo20581d(false);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.ManualMode");
                }
            } else {
                LogUtil.C2630a aVar = this.f10001c;
                StringBuilder sb = new StringBuilder();
                sb.append("current mode is not ManualMode, modeType = ");
                MzCamModule mzCamModule6 = this.f10000b;
                if (mzCamModule6 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN3 = mzCamModule6.mo18029aN();
                if (aN3 == null) {
                    C3443i.m21151a();
                }
                sb.append(aN3.mo20403g_().name());
                LogUtil.m15956e(aVar, sb.toString());
            }
            MzCamModule mzCamModule7 = this.f10000b;
            if (mzCamModule7 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule7.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            MzCamModule mzCamModule8 = this.f10000b;
            if (mzCamModule8 == null) {
                C3443i.m21156b("mCamModule");
            }
            aU.mo21585e(mzCamModule8.mo18031aP(), true);
            MzCamModule mzCamModule9 = this.f10000b;
            if (mzCamModule9 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule9.mo18168ct();
            MzCamModule mzCamModule10 = this.f10000b;
            if (mzCamModule10 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule10.mo18016a(true, z2, false, false, false);
            mo17937d(false);
        }
    }

    /* renamed from: o */
    public void mo17952o(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f9999a, false, 4390, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (CameraModeType.m10983m(CameraModeType.ModeType.VIDEO)) {
                MzCamModule mzCamModule = this.f10000b;
                if (mzCamModule == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule.mo18031aP() == DeviceHelper.f13949bw) {
                    MzCamModule mzCamModule2 = this.f10000b;
                    if (mzCamModule2 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule2.mo18242j(0);
                }
            }
            if (DeviceHelper.f13928bb && mo17900aC()) {
                mo17931b(mo17873V(), 0);
            }
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule3.mo18168ct();
            MzCamModule mzCamModule4 = this.f10000b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule4.mo18037aV();
            if (aV == null) {
                C3443i.m21151a();
            }
            aV.mo22193t();
            MzCamModule mzCamModule5 = this.f10000b;
            if (mzCamModule5 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule5.mo18016a(true, false, false, true, false);
        }
    }

    /* renamed from: ab */
    public void mo17905ab() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4391, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18242j(0);
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18168ct();
            boolean z = DeviceHelper.f13910bJ == CameraController.CameraApi.API2 && CameraController.m8868g().mo19442F();
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule3.mo18016a(true, false, false, z, false);
        }
    }

    /* renamed from: e */
    public void mo17938e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4392, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzFacebeautyManager aK = mzCamModule.mo18026aK();
            if (aK == null) {
                C3443i.m21151a();
            }
            aK.mo20765a(i);
        }
    }

    /* renamed from: a */
    public void mo17893a(boolean z, @Nullable AnimatorListenerAdapter animatorListenerAdapter) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), animatorListenerAdapter};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4394, new Class[]{Boolean.TYPE, AnimatorListenerAdapter.class}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule.mo18037aV();
            if (aV == null) {
                C3443i.m21151a();
            }
            aV.mo22087a(z, animatorListenerAdapter);
        }
    }

    /* renamed from: ac */
    public void mo17906ac() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4395, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule.mo18037aV();
            if (aV == null) {
                C3443i.m21151a();
            }
            aV.mo22098aE();
        }
    }

    /* renamed from: f */
    public void mo17940f(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4396, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            if (aN.mo20403g_() == CameraModeType.ModeType.TIMELAPSE) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN2 = mzCamModule2.mo18029aN();
                if (aN2 != null) {
                    ((VideoMode) aN2).mo20669d(i);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.VideoMode");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r10 == false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013c  */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17953p(boolean r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r10)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4397(0x112d, float:6.162E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            if (r10 != 0) goto L_0x003d
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x002d
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x002d:
            java.lang.String r1 = r1.mo18023aH()
            java.lang.String r2 = com.meizu.media.camera.util.UsageStatsHelper.m16050d()
            boolean r1 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x006d
            if (r10 != 0) goto L_0x006d
        L_0x003d:
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0046
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0046:
            com.meizu.media.camera.util.at r1 = r1.mo18096bd()
            if (r1 == 0) goto L_0x006d
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0055
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0055:
            com.meizu.media.camera.util.at r1 = r1.mo18096bd()
            if (r1 != 0) goto L_0x005e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x005e:
            r1.mo22698c((boolean) r8)
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x006a
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x006a:
            r1.mo18046ae(r10)
        L_0x006d:
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0076
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0076:
            com.meizu.media.camera.MzCamController$ModuleState r1 = r1.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r2 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_CAMERA
            if (r1 == r2) goto L_0x0092
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0087
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0087:
            com.meizu.media.camera.MzCamController$ModuleState r1 = r1.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r2 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_MODE
            if (r1 != r2) goto L_0x0090
            goto L_0x0092
        L_0x0090:
            r1 = 0
            goto L_0x0093
        L_0x0092:
            r1 = 1
        L_0x0093:
            if (r10 == 0) goto L_0x013c
            r9.mo17931b((boolean) r8, (int) r0)
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x00a1
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00a1:
            com.meizu.media.camera.u r2 = r2.mo18036aU()
            if (r2 != 0) goto L_0x00aa
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00aa:
            com.meizu.media.camera.MzCamModule r3 = r9.f10000b
            if (r3 != 0) goto L_0x00b3
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x00b3:
            int r3 = r3.mo18031aP()
            r2.mo21585e((int) r3, (boolean) r0)
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x00c3
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00c3:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x00cc
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00cc:
            r2.mo22179o((boolean) r0)
            if (r1 == 0) goto L_0x00ee
            boolean r2 = com.meizu.media.camera.animation.SwitchAnimManager.m8190a()
            if (r2 == 0) goto L_0x00d8
            goto L_0x00ee
        L_0x00d8:
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x00e1
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00e1:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x00ea
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ea:
            r2.mo22127ap()
            goto L_0x0117
        L_0x00ee:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r2 = com.meizu.media.camera.mode.CameraModeType.m10987o((com.meizu.media.camera.mode.CameraModeType.ModeType) r2)
            com.meizu.media.camera.MzCamModule r3 = r9.f10000b
            if (r3 != 0) goto L_0x00ff
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x00ff:
            com.meizu.media.camera.ui.i r3 = r3.mo18037aV()
            if (r3 != 0) goto L_0x0108
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0108:
            r4 = 0
            com.meizu.media.camera.mode.CameraModeType$ModeType r5 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r6 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            if (r5 != r6) goto L_0x0113
            r5 = 1
            goto L_0x0114
        L_0x0113:
            r5 = 0
        L_0x0114:
            r3.mo22140b((android.view.animation.Animation.AnimationListener) r4, (boolean) r5, (boolean) r2)
        L_0x0117:
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x0120
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0120:
            com.meizu.media.camera.h r2 = r2.mo18097be()
            if (r2 == 0) goto L_0x0163
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x012f
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x012f:
            com.meizu.media.camera.h r2 = r2.mo18097be()
            if (r2 != 0) goto L_0x0138
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0138:
            r2.mo20221f()
            goto L_0x0163
        L_0x013c:
            boolean r2 = r9.mo17873V()
            if (r2 == 0) goto L_0x0145
            r9.mo17931b((boolean) r0, (int) r0)
        L_0x0145:
            if (r1 != 0) goto L_0x0163
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x0150
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0150:
            com.meizu.media.camera.ui.i r2 = r2.mo18037aV()
            if (r2 != 0) goto L_0x0159
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0159:
            com.meizu.media.camera.f.j$c r3 = new com.meizu.media.camera.f.j$c
            r3.<init>(r9)
            android.view.animation.Animation$AnimationListener r3 = (android.view.animation.Animation.AnimationListener) r3
            r2.mo22077a((android.view.animation.Animation.AnimationListener) r3)
        L_0x0163:
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x016c
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x016c:
            com.meizu.media.camera.mode.f r2 = r2.mo18029aN()
            if (r2 != 0) goto L_0x0175
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0175:
            r2.mo20393a((boolean) r10, (boolean) r1)
            if (r10 == 0) goto L_0x018f
            com.meizu.media.camera.MzCamModule r10 = r9.f10000b
            if (r10 != 0) goto L_0x0183
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0183:
            com.meizu.media.camera.ui.i r10 = r10.mo18037aV()
            if (r10 != 0) goto L_0x018c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x018c:
            r10.mo22142b((boolean) r8)
        L_0x018f:
            r9.mo17948k(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17953p(boolean):void");
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo27294d2 = {"com/meizu/media/camera/impl/MzCamControllerImpl$onModeMenuVisibilityChanged$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.j$c */
    /* compiled from: MzCamControllerImpl.kt */
    public static final class C2061c implements Animation.AnimationListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f10006a;

        /* renamed from: b */
        final /* synthetic */ MzCamControllerImpl f10007b;

        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        public void onAnimationStart(@Nullable Animation animation) {
        }

        C2061c(MzCamControllerImpl jVar) {
            this.f10007b = jVar;
        }

        public void onAnimationEnd(@Nullable Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f10006a, false, 4456, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                MzCamUI aV = this.f10007b.mo20037a().mo18037aV();
                if (aV == null) {
                    C3443i.m21151a();
                }
                aV.mo22094aA();
                MzUIController aU = this.f10007b.mo20037a().mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                aU.mo21585e(this.f10007b.mo20037a().mo18031aP(), false);
            }
        }
    }

    /* renamed from: ad */
    public boolean mo17907ad() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4398, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzUIController aU = mzCamModule.mo18036aU();
        if (aU != null) {
            return aU.mo21590f();
        }
        return false;
    }

    /* renamed from: ae */
    public boolean mo17908ae() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4399, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18036aU() == null) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f10000b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzUIController aU = mzCamModule2.mo18036aU();
        if (aU == null) {
            C3443i.m21151a();
        }
        return aU.mo21479B();
    }

    /* renamed from: ah */
    public void mo17911ah() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4401, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(this.f10001c, "setWeakFbEffect");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18026aK() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzFacebeautyManager aK = mzCamModule2.mo18026aK();
                if (aK == null) {
                    C3443i.m21151a();
                }
                aK.mo20778h();
            }
        }
    }

    /* renamed from: ai */
    public void mo17912ai() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4402, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(this.f10001c, "cleanFbHalEffect");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18026aK() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzFacebeautyManager aK = mzCamModule2.mo18026aK();
                if (aK == null) {
                    C3443i.m21151a();
                }
                aK.mo20770b(0);
            }
        }
    }

    /* renamed from: aj */
    public boolean mo17913aj() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4403, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return !mzCamModule.mo18240i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        if (r1.mo20403g_() == com.meizu.media.camera.mode.CameraModeType.ModeType.TOF) goto L_0x008a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17896a(@org.jetbrains.annotations.NotNull com.meizu.media.camera.camcontroller.CameraController.C1880f<?>[] r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.camcontroller.CameraController$f[]> r2 = com.meizu.media.camera.camcontroller.CameraController.C1880f[].class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4404(0x1134, float:6.171E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            java.lang.String r1 = "faces"
            kotlin.jvm.p108b.C3443i.m21155b(r10, r1)
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x002b
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x002b:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 == 0) goto L_0x0047
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x003a
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x003a:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0043
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0043:
            boolean r8 = r1.mo21615m()
        L_0x0047:
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0050
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0050:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 == 0) goto L_0x00d1
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x005f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x005f:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x0068
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0068:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = r1.mo20403g_()
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            if (r1 == r2) goto L_0x008a
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x0079
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0079:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x0082
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0082:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = r1.mo20403g_()
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.TOF
            if (r1 != r2) goto L_0x00d1
        L_0x008a:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            java.lang.String r2 = "CameraController.getInstance().deviceProxy"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            int r1 = r1.mo19733b()
            if (r1 != r0) goto L_0x00d1
            com.meizu.media.camera.MzCamModule r0 = r9.f10000b
            if (r0 != 0) goto L_0x00ab
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00ab:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x00b4
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00b4:
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x00bd
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00bd:
            int r1 = r1.mo18194dR()
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x00ca
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00ca:
            android.graphics.Rect r2 = r2.mo18161cm()
            r0.mo20546a(r10, r1, r8, r2)
        L_0x00d1:
            com.meizu.media.camera.MzCamModule r0 = r9.f10000b
            if (r0 != 0) goto L_0x00da
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00da:
            com.meizu.media.camera.ui.i r0 = r0.mo18037aV()
            if (r0 != 0) goto L_0x00e3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00e3:
            com.meizu.media.camera.MzCamModule r1 = r9.f10000b
            if (r1 != 0) goto L_0x00ec
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00ec:
            int r1 = r1.mo18194dR()
            com.meizu.media.camera.MzCamModule r2 = r9.f10000b
            if (r2 != 0) goto L_0x00f9
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00f9:
            android.graphics.Rect r2 = r2.mo18161cm()
            r0.mo22092a((com.meizu.media.camera.camcontroller.CameraController.C1880f<?>[]) r10, (int) r1, (boolean) r8, (android.graphics.Rect) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17896a(com.meizu.media.camera.camcontroller.CameraController$f[]):void");
    }

    /* renamed from: a */
    public void mo17882a(@NotNull Rect rect) {
        if (!PatchProxy.proxy(new Object[]{rect}, this, f9999a, false, 4405, new Class[]{Rect.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(rect, "cameraBound");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18062b(rect);
            Storage.m7750a().mo18629a(rect);
        }
    }

    /* renamed from: a */
    public void mo17881a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4406, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO = mzCamModule.mo18030aO();
            if (aO == null) {
                C3443i.m21151a();
            }
            if (aO.mo17699z()) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN = mzCamModule2.mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                if (aN.mo20403g_() != CameraModeType.ModeType.FUNNY_SNAP) {
                    LogUtil.C2630a aVar = this.f10001c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("handlePauseFrameTransition: mHasShowFrameTransition = ");
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    sb.append(mzCamModule3.mo18084bR());
                    sb.append(", delay = ");
                    sb.append(j);
                    LogUtil.m15942a(aVar, sb.toString());
                    MzCamModule mzCamModule4 = this.f10000b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (!mzCamModule4.mo18084bR()) {
                        MzCamModule mzCamModule5 = this.f10000b;
                        if (mzCamModule5 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        Handler br = mzCamModule5.mo18110br();
                        MzCamModule mzCamModule6 = this.f10000b;
                        if (mzCamModule6 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        br.removeCallbacks(mzCamModule6.mo18207de());
                        if (j > 0) {
                            MzCamModule mzCamModule7 = this.f10000b;
                            if (mzCamModule7 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            Handler br2 = mzCamModule7.mo18110br();
                            MzCamModule mzCamModule8 = this.f10000b;
                            if (mzCamModule8 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            br2.postDelayed(mzCamModule8.mo18207de(), j);
                            return;
                        }
                        MzCamModule mzCamModule9 = this.f10000b;
                        if (mzCamModule9 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        Handler br3 = mzCamModule9.mo18110br();
                        MzCamModule mzCamModule10 = this.f10000b;
                        if (mzCamModule10 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        br3.post(mzCamModule10.mo18207de());
                    }
                }
            }
        }
    }

    /* renamed from: g */
    public void mo17942g(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4408, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18026aK() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzFacebeautyManager aK = mzCamModule2.mo18026aK();
                if (aK == null) {
                    C3443i.m21151a();
                }
                aK.mo20772c(i);
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzFacebeautyManager aK2 = mzCamModule3.mo18026aK();
                if (aK2 == null) {
                    C3443i.m21151a();
                }
                aK2.mo20774d(i);
            }
        }
    }

    @Nullable
    /* renamed from: ak */
    public FocusOverlayManager mo17914ak() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4409, new Class[0], FocusOverlayManager.class);
        if (proxy.isSupported) {
            return (FocusOverlayManager) proxy.result;
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17914ak();
    }

    /* renamed from: al */
    public boolean mo17915al() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4410, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (DeviceHelper.f13862aO && DeviceHelper.f13910bJ == CameraController.CameraApi.API2 && CameraModeType.m10983m(CameraModeType.ModeType.VIDEO)) {
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            if (g.mo19522k() != null) {
                CameraController g2 = CameraController.m8868g();
                C3443i.m21152a((Object) g2, "CameraController.getInstance()");
                CameraProxy k = g2.mo19522k();
                C3443i.m21152a((Object) k, "CameraController.getInstance().deviceProxy");
                if (k.mo19733b() != 1) {
                    MzCamModule mzCamModule = this.f10000b;
                    if (mzCamModule == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    int h = mzCamModule.mo18238h();
                    if (h == 5 || h == 6) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        if (r1.mo22495d() == false) goto L_0x007a;
     */
    /* renamed from: am */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo17916am() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 4411(0x113b, float:6.181E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x001e
            java.lang.Object r0 = r1.result
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x001e:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0027
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0027:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x0030
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0030:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.MANUAL
            boolean r1 = r1.mo20547a((com.meizu.media.camera.mode.CameraModeType.ModeType) r2)
            if (r1 == 0) goto L_0x007a
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0041
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0041:
            com.meizu.media.camera.ui.i r1 = r1.mo18037aV()
            if (r1 != 0) goto L_0x004a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x004a:
            com.meizu.media.camera.ui.t r1 = r1.mo22063Z()
            if (r1 != 0) goto L_0x0053
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0053:
            boolean r1 = r1.mo22503i()
            if (r1 != 0) goto L_0x00a1
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0062
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0062:
            com.meizu.media.camera.ui.i r1 = r1.mo18037aV()
            if (r1 != 0) goto L_0x006b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x006b:
            com.meizu.media.camera.ui.t r1 = r1.mo22063Z()
            if (r1 != 0) goto L_0x0074
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0074:
            boolean r1 = r1.mo22495d()
            if (r1 != 0) goto L_0x00a1
        L_0x007a:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0083
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0083:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 == 0) goto L_0x00a2
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0092
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0092:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x009b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x009b:
            boolean r1 = r1.mo21649z()
            if (r1 == 0) goto L_0x00a2
        L_0x00a1:
            r0 = 1
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo17916am():boolean");
    }

    /* renamed from: an */
    public void mo17917an() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4412, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f10001c;
            StringBuilder sb = new StringBuilder();
            sb.append(" thumbnailAnimExit mCameraResumeExecuted:");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            sb.append(mzCamModule.mo18077bK());
            sb.append("  register mCameraServiceListener:");
            sb.append(this);
            sb.append("mStopped:");
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            sb.append(mzCamModule2.mo18034aS());
            LogUtil.m15942a(aVar, sb.toString());
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule3.mo18034aS()) {
                MzCamModule mzCamModule4 = this.f10000b;
                if (mzCamModule4 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule4.mo18203da();
                MzCamModule mzCamModule5 = this.f10000b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraOptTask.m7840a((CamIntentTask.C1777c) mzCamModule5);
                MzCamModule mzCamModule6 = this.f10000b;
                if (mzCamModule6 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (!mzCamModule6.mo18077bK()) {
                    CameraController g = CameraController.m8868g();
                    C3443i.m21152a((Object) g, "CameraController.getInstance()");
                    if (g.mo19522k() != null) {
                        LogUtil.m15949b(this.f10001c, "thumbnailAnimExit camera is opened");
                    }
                }
            }
        }
    }

    /* renamed from: ao */
    public void mo17918ao() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4413, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21546ak();
        }
    }

    /* renamed from: ap */
    public void mo17919ap() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4414, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18029aN() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN = mzCamModule2.mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                aN.mo20385J();
            }
        }
    }

    /* renamed from: aq */
    public long mo17920aq() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4415, new Class[0], Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18074bH();
    }

    /* renamed from: ar */
    public boolean mo17921ar() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4416, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18037aV() == null) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f10000b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamUI aV = mzCamModule2.mo18037aV();
        if (aV == null) {
            C3443i.m21151a();
        }
        if (aV.mo22124am() == null) {
            return false;
        }
        MzCamModule mzCamModule3 = this.f10000b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamUI aV2 = mzCamModule3.mo18037aV();
        if (aV2 == null) {
            C3443i.m21151a();
        }
        MzARUI am = aV2.mo22124am();
        if (am == null) {
            C3443i.m21151a();
        }
        return am.mo21954j();
    }

    /* renamed from: as */
    public boolean mo17922as() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4417, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18075bI();
    }

    /* renamed from: q */
    public void mo17954q(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4418, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule.mo18037aV();
            if (aV != null) {
                aV.mo22201x(z);
            }
        }
    }

    /* renamed from: at */
    public void mo17923at() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4419, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            UsageStatsHelper bd = mzCamModule.mo18096bd();
            if (bd != null) {
                bd.mo22700e(CameraModeType.ModeType.AMAZINGAR.toString());
                bd.mo22701f(String.valueOf(0));
                bd.mo22695b("mode_start");
            }
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule2.mo18037aV();
            if (aV == null) {
                C3443i.m21151a();
            }
            aV.mo22110aQ();
        }
    }

    /* renamed from: au */
    public boolean mo17924au() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4420, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamUI aV = mzCamModule.mo18037aV();
        if (aV == null) {
            C3443i.m21151a();
        }
        return aV.mo22111aR();
    }

    /* renamed from: a */
    public void mo17895a(@Nullable byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f9999a, false, 4421, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18029aN() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule2.mo18031aP() != 1) {
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    CameraMode aN = mzCamModule3.mo18029aN();
                    if (aN == null) {
                        C3443i.m21151a();
                    }
                    if (aN.mo20547a(CameraModeType.ModeType.AUTO)) {
                        MzCamModule mzCamModule4 = this.f10000b;
                        if (mzCamModule4 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        CameraMode aN2 = mzCamModule4.mo18029aN();
                        if (aN2 != null) {
                            ((AutoMode) aN2).mo20488a(bArr);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.AutoMode");
                    }
                }
            }
        }
    }

    /* renamed from: av */
    public boolean mo17925av() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4422, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13880ag) {
            return false;
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule.mo18029aN();
        if (aN == null) {
            C3443i.m21151a();
        }
        if (!aN.mo20547a(CameraModeType.ModeType.AUTO)) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f10000b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule2.mo18031aP() == 1) {
            return false;
        }
        MzCamModule mzCamModule3 = this.f10000b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule3.mo18031aP() != DeviceHelper.f14029du) {
            return true;
        }
        return false;
    }

    /* renamed from: ax */
    public boolean mo17927ax() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4423, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule.mo18029aN();
        if (aN == null || !mo17959y() || !(aN instanceof AutoMode)) {
            return false;
        }
        return ((AutoMode) aN).mo20494r();
    }

    /* renamed from: ay */
    public boolean mo17928ay() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4424, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule.mo18029aN();
        if (aN == null || !mo17959y() || !(aN instanceof AutoMode)) {
            return false;
        }
        return ((AutoMode) aN).mo20495s();
    }

    @Nullable
    /* renamed from: s */
    public CameraController.FlashMode mo17956s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4425, new Class[0], CameraController.FlashMode.class);
        if (proxy.isSupported) {
            return (CameraController.FlashMode) proxy.result;
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamParamsManager aW = mzCamModule.mo18038aW();
        if (aW == null) {
            C3443i.m21151a();
        }
        return aW.mo20342g();
    }

    /* renamed from: r */
    public void mo17955r(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4426, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17979S(z);
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18159ck() && CameraModeType.m10983m(CameraModeType.ModeType.TOF)) {
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN = mzCamModule3.mo18029aN();
                if (aN != null) {
                    ((TofMode) aN).mo20654a(true);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.TofMode");
            }
        }
    }

    /* renamed from: az */
    public void mo17929az() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4427, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18036aU() != null) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzUIController aU = mzCamModule2.mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                DeviceUtil.m16194a(aU.mo21541af(), 22560);
            }
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule3.mo17980T(true);
            mo17934c(CameraModeType.m10962e(CameraModeType.ModeType.VIDEO));
            MzCamModule mzCamModule4 = this.f10000b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule4.mo17980T(false);
        }
    }

    /* renamed from: aA */
    public boolean mo17898aA() {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4428, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18036aU() != null && CameraModeType.m10983m(CameraModeType.ModeType.PORTRAIT)) {
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule2.mo18116bx()) {
                z = true;
            }
        }
        LogUtil.C2630a aVar = this.f10001c;
        LogUtil.m15942a(aVar, "isStereoOn1 " + z);
        return z;
    }

    /* renamed from: aB */
    public void mo17899aB() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4429, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule.mo18029aN();
            if (aN != null && mo17959y()) {
                if (aN instanceof NightVisionMode) {
                    ((NightVisionMode) aN).mo20606c();
                } else if (aN instanceof VideoMode) {
                    ((VideoMode) aN).mo20666L();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo17932b(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4430, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI aV = mzCamModule.mo18037aV();
            if (aV == null) {
                C3443i.m21151a();
            }
            aV.mo22089a(z, z2, false);
        }
    }

    /* renamed from: aC */
    public boolean mo17900aC() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4431, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18267u() == null) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f10000b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzCamUI u = mzCamModule2.mo18267u();
        if (u == null) {
            C3443i.m21151a();
        }
        return u.mo22198v();
    }

    /* renamed from: h */
    public void mo17944h(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4432, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18261r(i);
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18149ca() != -1) {
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI aV = mzCamModule3.mo18037aV();
                if (aV == null) {
                    C3443i.m21151a();
                }
                MzCamModule mzCamModule4 = this.f10000b;
                if (mzCamModule4 == null) {
                    C3443i.m21156b("mCamModule");
                }
                aV.mo22065a(mzCamModule4.mo18149ca());
            }
        }
    }

    /* renamed from: aD */
    public boolean mo17901aD() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4433, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18070bD();
    }

    @Nullable
    /* renamed from: aE */
    public ComboPreferences mo17902aE() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4434, new Class[0], ComboPreferences.class);
        if (proxy.isSupported) {
            return (ComboPreferences) proxy.result;
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17902aE();
    }

    /* renamed from: dl */
    public void mo18214dl() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4435, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21555at();
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU2 = mzCamModule2.mo18036aU();
            if (aU2 == null) {
                C3443i.m21151a();
            }
            aU2.mo21496S();
        }
    }

    /* renamed from: dn */
    public void mo18216dn() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4436, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18110br().removeMessages(16);
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule2.mo18032aQ()) {
                MzCamModule mzCamModule3 = this.f10000b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule3.mo18114bv() != 4) {
                    MzCamModule mzCamModule4 = this.f10000b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule4.mo18114bv() != 0) {
                        MzCamModule mzCamModule5 = this.f10000b;
                        if (mzCamModule5 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule5.mo18114bv() != 5) {
                            MzCamModule mzCamModule6 = this.f10000b;
                            if (mzCamModule6 == null) {
                                C3443i.m21156b("mCamModule");
                            }
                            MzCamUI aV = mzCamModule6.mo18037aV();
                            if (aV == null) {
                                C3443i.m21151a();
                            }
                            if (!aV.mo22049L() && DeviceHelper.f13838R) {
                                MzCamModule mzCamModule7 = this.f10000b;
                                if (mzCamModule7 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                MzUIController aU = mzCamModule7.mo18036aU();
                                if (aU == null) {
                                    C3443i.m21151a();
                                }
                                if (!aU.mo21494Q()) {
                                    MzCamModule mzCamModule8 = this.f10000b;
                                    if (mzCamModule8 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    if (!mzCamModule8.mo18098bf() && !mo17958x()) {
                                        MzCamModule mzCamModule9 = this.f10000b;
                                        if (mzCamModule9 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        CameraMode aN = mzCamModule9.mo18029aN();
                                        if (aN == null) {
                                            C3443i.m21151a();
                                        }
                                        if (aN.mo20403g_() == CameraModeType.ModeType.FUNNY_SNAP) {
                                            MzCamModule mzCamModule10 = this.f10000b;
                                            if (mzCamModule10 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            MzCamUI aV2 = mzCamModule10.mo18037aV();
                                            if (aV2 == null) {
                                                C3443i.m21151a();
                                            }
                                            if (!aV2.mo22049L()) {
                                                MzCamModule mzCamModule11 = this.f10000b;
                                                if (mzCamModule11 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                if (mzCamModule11.mo18114bv() == 1) {
                                                    MzCamModule mzCamModule12 = this.f10000b;
                                                    if (mzCamModule12 == null) {
                                                        C3443i.m21156b("mCamModule");
                                                    }
                                                    CameraMode aN2 = mzCamModule12.mo18029aN();
                                                    if (aN2 == null) {
                                                        C3443i.m21151a();
                                                    }
                                                    aN2.mo20449X();
                                                    return;
                                                }
                                            }
                                        }
                                        MzCamModule mzCamModule13 = this.f10000b;
                                        if (mzCamModule13 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        CameraMode aN3 = mzCamModule13.mo18029aN();
                                        if (aN3 == null) {
                                            C3443i.m21151a();
                                        }
                                        if (aN3.mo20417t()) {
                                            MzCamModule mzCamModule14 = this.f10000b;
                                            if (mzCamModule14 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            MzBurstHandler aL = mzCamModule14.mo18027aL();
                                            if (aL == null) {
                                                C3443i.m21151a();
                                            }
                                            if (aL.mo20296o()) {
                                                MzCamModule mzCamModule15 = this.f10000b;
                                                if (mzCamModule15 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                CameraActivity aO = mzCamModule15.mo18030aO();
                                                if (aO == null) {
                                                    C3443i.m21151a();
                                                }
                                                if (aO.mo17641g() <= 105906176) {
                                                    LogUtil.m15952c(this.f10001c, "Not enough space or storage not ready.");
                                                    return;
                                                }
                                                MzCamModule mzCamModule16 = this.f10000b;
                                                if (mzCamModule16 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                if (mzCamModule16.mo18097be() != null) {
                                                    MzCamModule mzCamModule17 = this.f10000b;
                                                    if (mzCamModule17 == null) {
                                                        C3443i.m21156b("mCamModule");
                                                    }
                                                    FocusOverlayManager be = mzCamModule17.mo18097be();
                                                    if (be == null) {
                                                        C3443i.m21151a();
                                                    }
                                                    if (be.mo20235n()) {
                                                        return;
                                                    }
                                                }
                                                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                                                    CameraController g = CameraController.m8868g();
                                                    if (g != null) {
                                                        CameraControllerV2 cameraControllerV2 = (CameraControllerV2) g;
                                                        if (Build.VERSION.SDK_INT >= 23 && !cameraControllerV2.mo19569ak()) {
                                                            return;
                                                        }
                                                    } else {
                                                        throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.camcontroller.CameraControllerV2");
                                                    }
                                                }
                                                MzCamModule mzCamModule18 = this.f10000b;
                                                if (mzCamModule18 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                if (mzCamModule18.mo18031aP() == DeviceHelper.f14029du) {
                                                    MzCamModule mzCamModule19 = this.f10000b;
                                                    if (mzCamModule19 == null) {
                                                        C3443i.m21156b("mCamModule");
                                                    }
                                                    MzUIController aU2 = mzCamModule19.mo18036aU();
                                                    if (aU2 == null) {
                                                        C3443i.m21151a();
                                                    }
                                                    MzCamModule mzCamModule20 = this.f10000b;
                                                    if (mzCamModule20 == null) {
                                                        C3443i.m21156b("mCamModule");
                                                    }
                                                    CameraActivity aO2 = mzCamModule20.mo18030aO();
                                                    if (aO2 == null) {
                                                        C3443i.m21151a();
                                                    }
                                                    aU2.mo21529a(aO2.getResources().getString(DeviceHelper.f14030dv != -1 ? R.string.mz_just_wide_angle_not_support_burst : R.string.mz_wide_angle_not_support_burst), true, new long[0]);
                                                    return;
                                                }
                                                MzCamModule mzCamModule21 = this.f10000b;
                                                if (mzCamModule21 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                if (mzCamModule21.mo18114bv() == 3) {
                                                    MzCamModule mzCamModule22 = this.f10000b;
                                                    if (mzCamModule22 == null) {
                                                        C3443i.m21156b("mCamModule");
                                                    }
                                                    MzBurstHandler aL2 = mzCamModule22.mo18027aL();
                                                    if (aL2 == null) {
                                                        C3443i.m21151a();
                                                    }
                                                    if (!aL2.mo20294m() && !mo17910ag()) {
                                                        MzCamModule mzCamModule23 = this.f10000b;
                                                        if (mzCamModule23 == null) {
                                                            C3443i.m21156b("mCamModule");
                                                        }
                                                        mzCamModule23.mo18110br().sendEmptyMessageDelayed(16, 100);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                MzCamModule mzCamModule24 = this.f10000b;
                                                if (mzCamModule24 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                MzCamModule mzCamModule25 = this.f10000b;
                                                if (mzCamModule25 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                if (mzCamModule25.mo18031aP() != 1 || DeviceHelper.f13910bJ != CameraController.CameraApi.API2) {
                                                    mzCamModule24.mo17962B(true);
                                                    MzCamModule mzCamModule26 = this.f10000b;
                                                    if (mzCamModule26 == null) {
                                                        C3443i.m21156b("mCamModule");
                                                    }
                                                    if (mzCamModule26.mo18097be() != null) {
                                                        MzCamModule mzCamModule27 = this.f10000b;
                                                        if (mzCamModule27 == null) {
                                                            C3443i.m21156b("mCamModule");
                                                        }
                                                        FocusOverlayManager be2 = mzCamModule27.mo18097be();
                                                        if (be2 == null) {
                                                            C3443i.m21151a();
                                                        }
                                                        be2.mo20213b();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: do */
    public void mo18217do() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4437, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13838R) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18110br().removeMessages(16);
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule2.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21555at();
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule3.mo18069bC()) {
                MzCamModule mzCamModule4 = this.f10000b;
                if (mzCamModule4 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule4.mo18097be() != null) {
                    MzCamModule mzCamModule5 = this.f10000b;
                    if (mzCamModule5 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    FocusOverlayManager be = mzCamModule5.mo18097be();
                    if (be == null) {
                        C3443i.m21151a();
                    }
                    if (be.mo20240s()) {
                        MzCamModule mzCamModule6 = this.f10000b;
                        if (mzCamModule6 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        mzCamModule6.mo17962B(false);
                        return;
                    }
                }
            }
            MzCamModule mzCamModule7 = this.f10000b;
            if (mzCamModule7 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule7.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            if (aN.mo20403g_() == CameraModeType.ModeType.FUNNY_SNAP) {
                MzCamModule mzCamModule8 = this.f10000b;
                if (mzCamModule8 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN2 = mzCamModule8.mo18029aN();
                if (aN2 == null) {
                    C3443i.m21151a();
                }
                aN2.mo20450Y();
                return;
            }
            MzCamModule mzCamModule9 = this.f10000b;
            if (mzCamModule9 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzBurstHandler aL = mzCamModule9.mo18027aL();
            if (aL == null) {
                C3443i.m21151a();
            }
            aL.mo20299r();
        }
    }

    /* renamed from: dp */
    public void mo18218dp() {
        if (!PatchProxy.proxy(new Object[0], this, f9999a, false, 4438, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21555at();
            if (mo20040c()) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule2.mo17971K(true);
                mo18048ag(true);
            }
        }
    }

    /* renamed from: ag */
    public void mo18048ag(boolean z) {
        boolean z2 = true;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f9999a, false, 4439, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f10001c;
            StringBuilder sb = new StringBuilder();
            sb.append("onShutterButtonFocus : ");
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            sb.append(mzCamModule.mo18114bv());
            LogUtil.m15952c(aVar, sb.toString());
            MzCamModule mzCamModule2 = this.f10000b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18114bv() != -1) {
                if (mo17925av() && mo17926aw() && mo17927ax()) {
                    EventBus.m21789a().mo27980d(19);
                }
                if (mo20040c()) {
                    MzCamModule mzCamModule3 = this.f10000b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamModule mzCamModule4 = this.f10000b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule4.mo18083bQ()) {
                        mzCamModule3.mo17971K(false);
                    } else {
                        return;
                    }
                }
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                    CameraController g = CameraController.m8868g();
                    if (g != null) {
                        CameraControllerV2 cameraControllerV2 = (CameraControllerV2) g;
                        if (Build.VERSION.SDK_INT >= 23 && !cameraControllerV2.mo19569ak()) {
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.camcontroller.CameraControllerV2");
                    }
                }
                MzCamModule mzCamModule5 = this.f10000b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzUIController aU = mzCamModule5.mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                if (aU.mo21493P() && z) {
                    MzCamModule mzCamModule6 = this.f10000b;
                    if (mzCamModule6 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzUIController aU2 = mzCamModule6.mo18036aU();
                    if (aU2 == null) {
                        C3443i.m21151a();
                    }
                    if (!aU2.mo21494Q()) {
                        MzCamModule mzCamModule7 = this.f10000b;
                        if (mzCamModule7 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        CameraMode aN = mzCamModule7.mo18029aN();
                        if (aN == null) {
                            C3443i.m21151a();
                        }
                        if (aN.mo20403g_() != CameraModeType.ModeType.BARCODE) {
                            if (!DeviceHelper.f13880ag || !mo17928ay()) {
                                MzCamModule mzCamModule8 = this.f10000b;
                                if (mzCamModule8 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                if (mzCamModule8.mo18114bv() == 3) {
                                    MzCamModule mzCamModule9 = this.f10000b;
                                    if (mzCamModule9 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    CameraMode aN2 = mzCamModule9.mo18029aN();
                                    if (aN2 == null) {
                                        C3443i.m21151a();
                                    }
                                    if (aN2.mo20403g_() == CameraModeType.ModeType.PANORAMA) {
                                        mo18215dm();
                                        return;
                                    }
                                }
                                boolean z3 = mo17898aA() && !CameraOptTask.m8419w();
                                MzCamModule mzCamModule10 = this.f10000b;
                                if (mzCamModule10 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                MzCamParamsManager aW = mzCamModule10.mo18038aW();
                                if (aW == null) {
                                    C3443i.m21151a();
                                }
                                boolean z4 = aW.mo20352q() && !CameraOptTask.m8419w();
                                MzCamModule mzCamModule11 = this.f10000b;
                                if (mzCamModule11 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                MzUIController aU3 = mzCamModule11.mo18036aU();
                                if (aU3 == null) {
                                    C3443i.m21151a();
                                }
                                if (!aU3.mo21499V() || CameraOptTask.m8419w()) {
                                    z2 = false;
                                }
                                MzCamModule mzCamModule12 = this.f10000b;
                                if (mzCamModule12 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                if (!mzCamModule12.mo18032aQ()) {
                                    MzCamModule mzCamModule13 = this.f10000b;
                                    if (mzCamModule13 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    if (mzCamModule13.mo18114bv() != 3 || z3 || z4 || z2) {
                                        MzCamModule mzCamModule14 = this.f10000b;
                                        if (mzCamModule14 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        if (mzCamModule14.mo18114bv() != 0) {
                                            MzCamModule mzCamModule15 = this.f10000b;
                                            if (mzCamModule15 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            if (mzCamModule15.mo18110br().hasMessages(16)) {
                                                MzCamModule mzCamModule16 = this.f10000b;
                                                if (mzCamModule16 == null) {
                                                    C3443i.m21156b("mCamModule");
                                                }
                                                mzCamModule16.mo18110br().removeMessages(16);
                                            }
                                            MzCamModule mzCamModule17 = this.f10000b;
                                            if (mzCamModule17 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            CameraMode aN3 = mzCamModule17.mo18029aN();
                                            if (aN3 == null) {
                                                C3443i.m21151a();
                                            }
                                            aN3.mo20544W();
                                            MzCamModule mzCamModule18 = this.f10000b;
                                            if (mzCamModule18 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            ComboPreferences aE = mo17902aE();
                                            if (aE == null) {
                                                C3443i.m21151a();
                                            }
                                            MzCamModule mzCamModule19 = this.f10000b;
                                            if (mzCamModule19 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            CameraActivity aO = mzCamModule19.mo18030aO();
                                            if (aO == null) {
                                                C3443i.m21151a();
                                            }
                                            String string = aE.getString("pref_camera_timer_key", aO.getString(R.string.pref_camera_timer_default));
                                            if (string == null) {
                                                C3443i.m21151a();
                                            }
                                            C3443i.m21152a((Object) string, "getPreferences()!!.getSt…_camera_timer_default))!!");
                                            mzCamModule18.mo18252o(Integer.parseInt(string));
                                            mo18215dm();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:181:0x026e, code lost:
        if (r3.mo20549ac() == false) goto L_0x0270;
     */
    /* renamed from: dm */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18215dm() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f9999a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4440(0x1158, float:6.222E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            com.meizu.media.camera.util.ac$a r1 = r8.f10001c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onShutterButtonClick : "
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x002b
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x002b:
            int r3 = r3.mo18114bv()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.String r2 = "onShutterButtonClick"
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0049
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0049:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0052
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0052:
            r1.mo21496S()
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x005e
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x005e:
            int r1 = r1.mo18114bv()
            r2 = -1
            if (r1 != r2) goto L_0x0066
            return
        L_0x0066:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x006f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x006f:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0078
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0078:
            boolean r1 = r1.mo21493P()
            if (r1 == 0) goto L_0x034a
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0087
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0087:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0090
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0090:
            boolean r1 = r1.mo21494Q()
            if (r1 == 0) goto L_0x0098
            goto L_0x034a
        L_0x0098:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00a1
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00a1:
            boolean r1 = r1.mo18032aQ()
            if (r1 != 0) goto L_0x0349
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00b0
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00b0:
            int r1 = r1.mo18114bv()
            r2 = 4
            if (r1 == r2) goto L_0x0349
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00c0
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00c0:
            int r1 = r1.mo18114bv()
            if (r1 == 0) goto L_0x0349
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00cf
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00cf:
            int r1 = r1.mo18114bv()
            r2 = 5
            if (r1 != r2) goto L_0x00d8
            goto L_0x0349
        L_0x00d8:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x00e1
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x00e1:
            com.meizu.media.camera.CameraActivity r1 = r1.mo18030aO()
            if (r1 != 0) goto L_0x00ea
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ea:
            long r1 = r1.mo17641g()
            r3 = 105906176(0x6500000, double:5.2324603E-316)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0112
            com.meizu.media.camera.util.ac$a r0 = r8.f10001c
            java.lang.String r1 = "Not enough space or storage not ready."
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x0105
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0105:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x010e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x010e:
            r0.mo17642h()
            return
        L_0x0112:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x011b
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x011b:
            com.meizu.media.camera.ui.i r1 = r1.mo18037aV()
            if (r1 != 0) goto L_0x0124
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0124:
            boolean r1 = r1.mo22049L()
            if (r1 != 0) goto L_0x0348
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0133
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0133:
            com.meizu.media.camera.ui.i r1 = r1.mo18037aV()
            if (r1 != 0) goto L_0x013c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x013c:
            boolean r1 = r1.mo22191s()
            if (r1 == 0) goto L_0x0144
            goto L_0x0348
        L_0x0144:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x014d
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x014d:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0156
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0156:
            boolean r1 = r1.mo21477A()
            if (r1 != 0) goto L_0x0347
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x0165
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0165:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x016e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x016e:
            boolean r1 = r1.mo21590f()
            if (r1 == 0) goto L_0x0176
            goto L_0x0347
        L_0x0176:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x017f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x017f:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x0188
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0188:
            boolean r1 = r1.mo20411n()
            if (r1 == 0) goto L_0x01a4
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x0197
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0197:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x01a0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01a0:
            r0.mo20384I()
            return
        L_0x01a4:
            boolean r1 = r8.mo17898aA()
            r2 = 1
            if (r1 == 0) goto L_0x01b3
            boolean r1 = com.meizu.media.camera.CameraOptTask.m8419w()
            if (r1 != 0) goto L_0x01b3
            r1 = 1
            goto L_0x01b4
        L_0x01b3:
            r1 = 0
        L_0x01b4:
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x01bd
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x01bd:
            com.meizu.media.camera.l r3 = r3.mo18038aW()
            if (r3 != 0) goto L_0x01c6
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01c6:
            boolean r3 = r3.mo20352q()
            if (r3 == 0) goto L_0x01d4
            boolean r3 = com.meizu.media.camera.CameraOptTask.m8419w()
            if (r3 != 0) goto L_0x01d4
            r3 = 1
            goto L_0x01d5
        L_0x01d4:
            r3 = 0
        L_0x01d5:
            com.meizu.media.camera.MzCamModule r4 = r8.f10000b
            if (r4 != 0) goto L_0x01de
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x01de:
            com.meizu.media.camera.u r4 = r4.mo18036aU()
            if (r4 != 0) goto L_0x01e7
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01e7:
            boolean r4 = r4.mo21499V()
            if (r4 == 0) goto L_0x01f5
            boolean r4 = com.meizu.media.camera.CameraOptTask.m8419w()
            if (r4 != 0) goto L_0x01f5
            r4 = 1
            goto L_0x01f6
        L_0x01f5:
            r4 = 0
        L_0x01f6:
            com.meizu.media.camera.MzCamModule r5 = r8.f10000b
            if (r5 != 0) goto L_0x01ff
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x01ff:
            int r5 = r5.mo18114bv()
            r6 = 3
            if (r5 != r6) goto L_0x020d
            if (r1 != 0) goto L_0x020d
            if (r3 != 0) goto L_0x020d
            if (r4 != 0) goto L_0x020d
            return
        L_0x020d:
            com.meizu.media.camera.e r1 = r8.mo17902aE()
            if (r1 != 0) goto L_0x0216
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0216:
            java.lang.String r3 = "pref_camera_timer_sound_key"
            com.meizu.media.camera.MzCamModule r4 = r8.f10000b
            if (r4 != 0) goto L_0x0221
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x0221:
            com.meizu.media.camera.CameraActivity r4 = r4.mo18030aO()
            if (r4 != 0) goto L_0x022a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x022a:
            r5 = 2131755761(0x7f1002f1, float:1.914241E38)
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r1 = r1.getString(r3, r4)
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x023e
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x023e:
            com.meizu.media.camera.CameraActivity r3 = r3.mo18030aO()
            if (r3 != 0) goto L_0x0247
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0247:
            r4 = 2131755779(0x7f100303, float:1.9142447E38)
            java.lang.String r3 = r3.getString(r4)
            boolean r1 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r1, (java.lang.Object) r3)
            boolean r3 = com.meizu.media.camera.util.DeviceUtil.m16200b()
            if (r3 == 0) goto L_0x0270
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x0261
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0261:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()
            if (r3 != 0) goto L_0x026a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x026a:
            boolean r3 = r3.mo20549ac()
            if (r3 != 0) goto L_0x0271
        L_0x0270:
            r1 = 0
        L_0x0271:
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x027a
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x027a:
            com.meizu.media.camera.ui.i r3 = r3.mo18037aV()
            if (r3 != 0) goto L_0x0283
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0283:
            boolean r3 = r3.mo22198v()
            if (r3 == 0) goto L_0x02a2
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x0292
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0292:
            com.meizu.media.camera.ui.i r3 = r3.mo18037aV()
            if (r3 != 0) goto L_0x029b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x029b:
            boolean r4 = r8.mo17873V()
            r3.mo22086a((boolean) r4, (int) r0)
        L_0x02a2:
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x02ab
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x02ab:
            int r3 = r3.mo18090bX()
            if (r3 <= 0) goto L_0x0301
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x02ba
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x02ba:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()
            if (r3 != 0) goto L_0x02c3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x02c3:
            boolean r3 = r3.mo20419v()
            if (r3 == 0) goto L_0x0301
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x02d2
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x02d2:
            com.meizu.media.camera.ui.i r0 = r0.mo18037aV()
            if (r0 != 0) goto L_0x02db
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x02db:
            com.meizu.media.camera.MzCamModule r3 = r8.f10000b
            if (r3 != 0) goto L_0x02e4
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x02e4:
            int r3 = r3.mo18090bX()
            r0.mo22069a((int) r3, (boolean) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x02f4
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02f4:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x02fd
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x02fd:
            r0.mo21575c((boolean) r2)
            goto L_0x0346
        L_0x0301:
            com.meizu.media.camera.MzCamModule r1 = r8.f10000b
            if (r1 != 0) goto L_0x030a
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x030a:
            r1.mo18276x((boolean) r0)
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x0316
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0316:
            com.meizu.media.camera.h r0 = r0.mo18097be()
            if (r0 == 0) goto L_0x0331
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x0325
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0325:
            com.meizu.media.camera.h r0 = r0.mo18097be()
            if (r0 != 0) goto L_0x032e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x032e:
            r0.mo20213b()
        L_0x0331:
            com.meizu.media.camera.MzCamModule r0 = r8.f10000b
            if (r0 != 0) goto L_0x033a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x033a:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x0343
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0343:
            r0.mo20384I()
        L_0x0346:
            return
        L_0x0347:
            return
        L_0x0348:
            return
        L_0x0349:
            return
        L_0x034a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.MzCamControllerImpl.mo18215dm():void");
    }

    /* renamed from: af */
    public void mo18047af(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4441, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15952c(this.f10001c, "onShutterButtonDown");
            long j = 0;
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            if (aN.mo20547a(CameraModeType.ModeType.MANUAL)) {
                MzCamModule mzCamModule2 = this.f10000b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN2 = mzCamModule2.mo18029aN();
                if (aN2 != null) {
                    j = ((ManualMode) aN2).mo20575B();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.ManualMode");
                }
            }
            MzCamModule mzCamModule3 = this.f10000b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule3.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21513a(j, z);
        }
    }

    /* renamed from: b */
    public boolean mo20039b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4442, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18266t();
    }

    /* renamed from: a */
    public void mo17888a(@Nullable CameraController.HdrMode hdrMode) {
        if (!PatchProxy.proxy(new Object[]{hdrMode}, this, f9999a, false, 4443, new Class[]{CameraController.HdrMode.class}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17888a(hdrMode);
        }
    }

    /* renamed from: ag */
    public boolean mo17910ag() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4444, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17910ag();
    }

    /* renamed from: d */
    public void mo17936d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9999a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4445, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f10000b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17936d(i);
        }
    }

    /* renamed from: y */
    public boolean mo17959y() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4448, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17959y();
    }

    /* renamed from: c */
    public boolean mo20040c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4449, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule.mo18029aN();
        if (aN == null) {
            C3443i.m21151a();
        }
        if (aN.mo20403g_() == CameraModeType.ModeType.FUNNY_SNAP) {
            return true;
        }
        MzCamModule mzCamModule2 = this.f10000b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule2.mo18211di() == DeviceHelper.f14029du) {
            return false;
        }
        MzCamModule mzCamModule3 = this.f10000b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule3.mo18211di() == 1 && DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
            return false;
        }
        MzCamModule mzCamModule4 = this.f10000b;
        if (mzCamModule4 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN2 = mzCamModule4.mo18029aN();
        if (aN2 == null) {
            C3443i.m21151a();
        }
        return aN2.mo20417t();
    }

    /* renamed from: V */
    public boolean mo17873V() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4450, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17873V();
    }

    /* renamed from: M */
    public boolean mo17864M() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4451, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17864M();
    }

    /* renamed from: aw */
    public boolean mo17926aw() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9999a, false, 4452, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f10000b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17926aw();
    }
}
