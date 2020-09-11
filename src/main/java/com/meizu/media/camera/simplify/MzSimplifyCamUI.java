package com.meizu.media.camera.simplify;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.imageproc.SurfaceTextureBitmap;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.media.camera.ActivityBase;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.CameraSimplifyActivity;
import com.meizu.media.camera.MzSimplifyCamModule;
import com.meizu.media.camera.PreviewGestures;
import com.meizu.media.camera.R;
import com.meizu.media.camera.animation.C1825q;
import com.meizu.media.camera.animation.SwitchAnimManager;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.databinding.CameraSimplifyBinding;
import com.meizu.media.camera.databinding.DelayInflateOneBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.FaceViewBinding;
import com.meizu.media.camera.databinding.StubCamPreviewLayoutBinding;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.simplify.FocusOverlaySimplifyManager;
import com.meizu.media.camera.simplify.MzSimplifyCamController;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.BitmapUtils;
import com.meizu.media.camera.util.C2644av;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.views.CameraRootView;
import com.meizu.media.camera.views.FaceView;
import com.meizu.media.camera.views.FocusIndicator;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.media.camera.views.MzImageView;
import com.meizu.media.camera.views.MzSlideModeRenderer;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.media.camera.views.ZoomRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Ã\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0004Ã\u0002Ä\u0002B\u001d\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010\u001a2\u0006\u0010w\u001a\u00020 J\u000e\u0010x\u001a\u00020u2\u0006\u0010v\u001a\u00020\u001aJ\u0018\u0010y\u001a\u00020 2\b\u0010z\u001a\u0004\u0018\u00010\u001a2\u0006\u0010w\u001a\u00020 J\u0006\u0010{\u001a\u00020 J\u0016\u0010|\u001a\u00020u2\u0006\u0010}\u001a\u00020\u00122\u0006\u0010~\u001a\u00020\u0012J\u001e\u0010|\u001a\u00020u2\u0006\u0010}\u001a\u00020\u00122\u0006\u0010~\u001a\u00020\u00122\u0006\u0010\u001a\u00020 J\u0010\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020 J\t\u0010\u0001\u001a\u00020uH\u0016J\u0007\u0010\u0001\u001a\u00020uJ\u0010\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\u0012J/\u0010\u0001\u001a\u00020u2\t\u0010\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u0007\u0010\u0001\u001a\u00020uJ\u0007\u0010\u0001\u001a\u00020uJ\u0010\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020 J\u0019\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012J\u001b\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u0007\u0010\u0001\u001a\u00020\u001cJ\t\u0010\u0001\u001a\u0004\u0018\u00010oJ\u0007\u0010\u0001\u001a\u00020\u0012J\u0007\u0010\u0001\u001a\u00020\u0012J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015J\u0007\u0010\u0001\u001a\u00020oJ\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u0004\u0018\u00010&J\u0007\u0010\u0001\u001a\u00020 J\t\u0010\u0001\u001a\u0004\u0018\u000102J\t\u0010\u0001\u001a\u00020uH\u0002J\u0007\u0010\u0001\u001a\u00020\u0012J\u0007\u0010\u0001\u001a\u00020\u0012J\u0007\u0010 \u0001\u001a\u00020 J\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001J\t\u0010£\u0001\u001a\u0004\u0018\u00010WJ\t\u0010¤\u0001\u001a\u0004\u0018\u00010[J\t\u0010¥\u0001\u001a\u0004\u0018\u00010bJ\t\u0010¦\u0001\u001a\u0004\u0018\u00010bJ\t\u0010§\u0001\u001a\u0004\u0018\u00010iJ\u001c\u0010¨\u0001\u001a\u0004\u0018\u00010\u00152\u0006\u0010w\u001a\u00020 2\u0007\u0010©\u0001\u001a\u00020 H\u0002J\t\u0010ª\u0001\u001a\u0004\u0018\u00010sJ\t\u0010«\u0001\u001a\u00020 H\u0016J\u0007\u0010¬\u0001\u001a\u00020uJ\u0007\u0010­\u0001\u001a\u00020uJ\u0007\u0010®\u0001\u001a\u00020uJ\u0007\u0010¯\u0001\u001a\u00020uJ\u0010\u0010°\u0001\u001a\u00020u2\u0007\u0010±\u0001\u001a\u00020 J\t\u0010²\u0001\u001a\u00020uH\u0002J\u0013\u0010³\u0001\u001a\u00020u2\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001J\u0007\u0010¶\u0001\u001a\u00020uJ\u0007\u0010·\u0001\u001a\u00020uJ\u001e\u0010¸\u0001\u001a\u0004\u0018\u00010)2\b\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010»\u0001\u001a\u00020)H\u0002J\u0007\u0010¼\u0001\u001a\u00020 J\u0007\u0010½\u0001\u001a\u00020uJ\u0010\u0010¾\u0001\u001a\u00020u2\u0007\u0010¿\u0001\u001a\u00020\u0012J\u0007\u0010À\u0001\u001a\u00020uJ\t\u0010Á\u0001\u001a\u00020uH\u0016J\u0015\u0010Â\u0001\u001a\u00020u2\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0016J'\u0010Å\u0001\u001a\u00020u2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J'\u0010Ç\u0001\u001a\u00020u2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J8\u0010È\u0001\u001a\u00020u2\u0017\u0010É\u0001\u001a\u0012\u0012\u000b\u0012\t\u0012\u0002\b\u0003\u0018\u00010Ë\u0001\u0018\u00010Ê\u00012\u000e\u0010Ì\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010Í\u0001H\u0016¢\u0006\u0003\u0010Î\u0001J\u0012\u0010Ï\u0001\u001a\u00020u2\u0007\u0010Ð\u0001\u001a\u00020 H\u0016J\u0012\u0010Ñ\u0001\u001a\u00020u2\u0007\u0010Ò\u0001\u001a\u00020 H\u0016J\t\u0010Ó\u0001\u001a\u00020uH\u0016J\u0012\u0010Ô\u0001\u001a\u00020u2\u0007\u0010Ð\u0001\u001a\u00020<H\u0016J\u0014\u0010Õ\u0001\u001a\u00020u2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010×\u0001\u001a\u00020u2\u0007\u0010Ø\u0001\u001a\u00020 J\u0007\u0010Ù\u0001\u001a\u00020uJ\u0010\u0010Ú\u0001\u001a\u00020u2\u0007\u0010Û\u0001\u001a\u00020 J\u0007\u0010Ü\u0001\u001a\u00020uJ\u0007\u0010Ý\u0001\u001a\u00020uJ0\u0010Þ\u0001\u001a\u00020u2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010ß\u0001\u001a\u00020 H\u0016J0\u0010à\u0001\u001a\u00020u2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010ß\u0001\u001a\u00020 H\u0016J\u0007\u0010á\u0001\u001a\u00020uJ\u0007\u0010â\u0001\u001a\u00020uJ\u0019\u0010ã\u0001\u001a\u00020u2\u0007\u0010ä\u0001\u001a\u00020\u00122\u0007\u0010å\u0001\u001a\u00020 J\u0007\u0010æ\u0001\u001a\u00020uJ$\u0010ç\u0001\u001a\u00020u2\u0007\u0010è\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u0014\u0010é\u0001\u001a\u00020 2\t\u0010è\u0001\u001a\u0004\u0018\u00010bH\u0016J\u0014\u0010ê\u0001\u001a\u00020 2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010bH\u0016J&\u0010ë\u0001\u001a\u00020u2\t\u0010è\u0001\u001a\u0004\u0018\u00010b2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u0014\u0010ì\u0001\u001a\u00020u2\t\u0010è\u0001\u001a\u0004\u0018\u00010bH\u0016J$\u0010í\u0001\u001a\u00020u2\u0007\u0010Ö\u0001\u001a\u00020i2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u0014\u0010î\u0001\u001a\u00020 2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010iH\u0016J\u0014\u0010ï\u0001\u001a\u00020 2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010iH\u0016J&\u0010ð\u0001\u001a\u00020u2\t\u0010è\u0001\u001a\u0004\u0018\u00010i2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u0014\u0010ñ\u0001\u001a\u00020u2\t\u0010è\u0001\u001a\u0004\u0018\u00010iH\u0016J\u0007\u0010ò\u0001\u001a\u00020uJ\u0007\u0010ó\u0001\u001a\u00020uJ\t\u0010ô\u0001\u001a\u00020uH\u0016J=\u0010õ\u0001\u001a\u00020u2\u0007\u0010¹\u0001\u001a\u00020@2\u0007\u0010å\u0001\u001a\u00020 2\u0007\u0010ö\u0001\u001a\u00020 2\u0007\u0010÷\u0001\u001a\u00020\u00122\u0007\u0010ø\u0001\u001a\u00020\u00122\u0007\u0010ù\u0001\u001a\u00020\u0012J\u0007\u0010ú\u0001\u001a\u00020uJ\u0007\u0010û\u0001\u001a\u00020uJ\u0007\u0010ü\u0001\u001a\u00020uJ\u001a\u0010ý\u0001\u001a\u00020u2\t\u0010þ\u0001\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0003\u0010ÿ\u0001J\u0007\u0010\u0002\u001a\u00020uJ\t\u0010\u0002\u001a\u00020uH\u0016J\t\u0010\u0002\u001a\u00020uH\u0002J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010±\u0001\u001a\u00020 J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020 J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020\u001cJ\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020 J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020 J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010ä\u0001\u001a\u00020\u0012J\u0012\u0010\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020 H\u0016J\u0015\u0010\u0002\u001a\u00020u2\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0016J/\u0010\u0002\u001a\u00020u2\u0015\u0010É\u0001\u001a\u0010\u0012\t\u0012\u0007\u0012\u0002\b\u00030Ë\u0001\u0018\u00010Ê\u00012\u0007\u0010ä\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0003\u0010\u0002J\u001b\u0010\u0002\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020 J\u0012\u0010\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020 H\u0016J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010ä\u0001\u001a\u00020\u0012J-\u0010\u0002\u001a\u00020u2\t\u0010\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012J\u0013\u0010\u0002\u001a\u00020u2\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002J\u0019\u0010\u0002\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012J\u0010\u0010\u0002\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020 J\u0013\u0010 \u0002\u001a\u00020u2\n\u0010¡\u0002\u001a\u0005\u0018\u00010¢\u0002J\u0012\u0010£\u0002\u001a\u00020u2\u0007\u0010¤\u0002\u001a\u00020 H\u0016J\u0010\u0010¥\u0002\u001a\u00020u2\u0007\u0010¦\u0002\u001a\u00020 J\u0010\u0010§\u0002\u001a\u00020u2\u0007\u0010¨\u0002\u001a\u00020\u0012J\u000f\u0010©\u0002\u001a\u00020u2\u0006\u0010v\u001a\u00020eJ\u001b\u0010ª\u0002\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0002J-\u0010ª\u0002\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010«\u0002\u001a\u00020\u00122\u0007\u0010¬\u0002\u001a\u00020 H\u0002J\u0013\u0010­\u0002\u001a\u00020u2\n\u0010¡\u0002\u001a\u0005\u0018\u00010¢\u0002J'\u0010®\u0002\u001a\u00020u2\u0018\u0010¯\u0002\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150Ê\u0001\"\u0004\u0018\u00010\u0015¢\u0006\u0003\u0010°\u0002J\u0007\u0010±\u0002\u001a\u00020uJ\t\u0010²\u0002\u001a\u00020uH\u0002J\u0014\u0010²\u0002\u001a\u00020u2\t\u0010³\u0002\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010²\u0002\u001a\u00020u2\u0007\u0010´\u0002\u001a\u00020 H\u0002J\u000f\u0010µ\u0002\u001a\u00020u2\u0006\u0010w\u001a\u00020 J\u001c\u0010¶\u0002\u001a\u00020u2\u0007\u0010·\u0002\u001a\u00020 2\n\u0010¸\u0002\u001a\u0005\u0018\u00010¹\u0002J\u0007\u0010º\u0002\u001a\u00020uJ\u0012\u0010º\u0002\u001a\u00020u2\u0007\u0010»\u0002\u001a\u00020 H\u0002J\u001b\u0010¼\u0002\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0002J\u001e\u0010½\u0002\u001a\u00020u2\n\u0010¾\u0002\u001a\u0005\u0018\u00010¿\u00022\u0007\u0010À\u0002\u001a\u00020\u001cH\u0016J\u0012\u0010Á\u0002\u001a\u00020u2\u0007\u0010\u0002\u001a\u00020\u001cH\u0002J\u0007\u0010Â\u0002\u001a\u00020uR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010sX\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0002"}, mo27294d2 = {"Lcom/meizu/media/camera/simplify/MzSimplifyCamUI;", "Lcom/meizu/camera/effectlib/effects/views/PreviewView$SurfaceTextureListener;", "Lcom/meizu/camera/effectlib/effects/views/PreviewView$BokehListener;", "Lcom/meizu/media/camera/simplify/FocusOverlaySimplifyManager$FocusUI;", "Lcom/meizu/media/camera/PreviewGestures$SingleTapListener;", "Lcom/meizu/media/camera/PreviewGestures$DoubleTapListener;", "Lcom/meizu/media/camera/views/CameraRootView$MyDisplayListener;", "Lcom/meizu/media/camera/camcontroller/CameraController$CameraFaceDetectionCallback;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "Lcom/meizu/camera/effectlib/effects/views/PreviewView$SurfaceTextureWrapperListener;", "activity", "Lcom/meizu/media/camera/CameraSimplifyActivity;", "controller", "Lcom/meizu/media/camera/MzSimplifyCamModule;", "binding", "Lcom/meizu/media/camera/databinding/CameraSimplifyBinding;", "(Lcom/meizu/media/camera/CameraSimplifyActivity;Lcom/meizu/media/camera/MzSimplifyCamModule;Lcom/meizu/media/camera/databinding/CameraSimplifyBinding;)V", "ANIMATION_TIME", "", "mActivity", "mAnimateBitmap", "Landroid/graphics/Bitmap;", "mAnimateSlidingModeInForFSnapRunable", "Ljava/lang/Runnable;", "mAnimateSwitchingForFSnapRunable", "mAnimateSwitchingListener", "Landroid/view/animation/Animation$AnimationListener;", "mAspectRatio", "", "mCameraId", "mCameraSimplifyBinding", "mCanDoEstimation", "", "mController", "mFaceNum", "mFaceView", "Lcom/meizu/media/camera/views/FaceView;", "mFocusRenderer", "Lcom/meizu/media/camera/views/MzFocusRenderer;", "mFocusTakePicturePadding", "mFocusTakePictureRect", "Landroid/graphics/RectF;", "mFullScreen", "mGestureRect", "mGestures", "Lcom/meizu/media/camera/PreviewGestures;", "mHandler", "Landroid/os/Handler;", "mHasSurfaceTextureBitmapInit", "mImageCaptureUI", "Lcom/meizu/media/camera/simplify/MzSimplifyImageCaptureUI;", "mIsAnimViewFullScreen", "mIsFaceDetectionPaused", "mIsResumeFrameTransition", "mIsSquareMode", "mIsSwitchAnimWaitingSurfaceReady", "mIsVideoRecording", "mLastOrientationId", "mLastPreviewBitmap", "mLastTimeFaceViewUpdated", "", "mLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "mMatrix", "Landroid/graphics/Matrix;", "mNeedRefresh", "mNotSelectableToast", "Landroid/widget/Toast;", "mOrientationChangedTime", "mPreviewData", "", "mPreviewDataHight", "mPreviewDataWidth", "mPreviewHeight", "mPreviewRect", "mPreviewTranslationY", "mPreviewValueAnimator", "Landroid/animation/ValueAnimator;", "mPreviewWidth", "mPreviewYuvSize", "", "mPreviewYuvStride", "mRenderOverlay", "Lcom/meizu/media/camera/views/RenderOverlay;", "mRequestFsPreviewCode", "mScreenRatio", "mSlideModeRenderer", "Lcom/meizu/media/camera/views/MzSlideModeRenderer;", "mSlidingModeInAnimListener", "mSmartBarHeight", "mSmartbarHintTextView", "Landroid/widget/TextView;", "mSquareTopHeight", "mSubCamSurfaceTextureListener", "Landroid/view/TextureView$SurfaceTextureListener;", "mSubCamTextureView", "Landroid/view/TextureView;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mSurfaceTextureRotation", "mSurfaceTextureSizeListener", "Lcom/meizu/media/camera/ui/MzCamUI$SurfaceTextureSizeChangedListener;", "mSurfaceTextureUncroppedHeight", "mSurfaceTextureUncroppedWidth", "mSurfaceTextureWrapper", "Lcom/meizu/imageproc/SurfaceTextureWrapper;", "mSwitchAnimView", "Lcom/meizu/media/camera/views/MzImageView;", "mSyncObject", "", "mTextureView", "Lcom/meizu/camera/effectlib/effects/views/CameraPreviewRenderView;", "mTextureViewCanInit", "mTouchPadding", "mVideoUI", "Lcom/meizu/media/camera/simplify/MzSimplifyVideoUI;", "animateSlidingModeIn", "", "listener", "isFunny", "animateSlidingModeOut", "animateSwitchCamera", "secondAnimListener", "arePreviewControlsVisible", "capturePreviewBitmap", "oriention", "scaleFactor", "forceVerticalConvert", "clearFaces", "isVisible", "clearFocus", "destroyPreview", "disableFlingByBottomHeight", "height", "doBokeh", "data", "width", "rowstride", "doFrameAvailable", "doFrameTransitionFadeOut", "enableGestures", "enable", "focusInGestureArea", "x", "y", "focusInPreviewArea", "getAspectRatio", "getCameraPreviewRenderView", "getCurrentCameraId", "getFaceNum", "getFastBitmap", "getFilterPreviewView", "getFocusIndicator", "Lcom/meizu/media/camera/views/FocusIndicator;", "getFocusRenderer", "getFullScreenState", "getImageCaptureUI", "getLastPreviewBitmap", "getPreviewHeight", "getPreviewWidth", "getResumeFrameStatus", "getRootView", "Landroid/view/View;", "getSlideModeRenderer", "getSmartbarHintTextView", "getSubCamSurfaceTexture", "getSurfaceTexture", "getSurfaceTextureWrapper", "getSwitchAnimBitmap", "isFBOn", "getVideoUI", "hasFaces", "hideSlidingAnimView", "inflateDelay", "initDisplayChangeListener", "initRenderOverlay", "initSurfaceTexture", "needExecRefresh", "initTextureAnim", "initializeControlByIntent", "uicontroller", "Lcom/meizu/media/camera/simplify/MzSimplifyUIController;", "initializeSecondTime", "invalidateRenderOverlay", "mapRect", "matrix", "", "rect", "onBackPressed", "onCameraClose", "onCameraOpened", "cameraId", "onDestroy", "onDisplayChanged", "onDoubleTapEvent", "e", "Landroid/view/MotionEvent;", "onDoubleTapUp", "v", "onDown", "onFaceDetection", "faces", "", "Lcom/meizu/media/camera/camcontroller/CameraController$FaceInfo;", "camera", "Lcom/meizu/media/camera/camcontroller/CameraProxy;", "([Lcom/meizu/media/camera/camcontroller/CameraController$FaceInfo;Lcom/meizu/media/camera/camcontroller/CameraProxy;)V", "onFocusFailed", "timeout", "onFocusMeter", "timeOut", "onFocusStarted", "onFocusSucceeded", "onFrameAvailable", "surfaceTexture", "onNavBarStateChange", "show", "onPause", "onPreviewFocusChanged", "previewFocused", "onPreviewStart", "onResume", "onSingleTapConfirmed", "needCaptureAfterFocus", "onSingleTapUp", "onSlidAnimEnd", "onStart", "onStartFaceDetection", "orientation", "mirror", "onStop", "onSurfaceTextureAvailable", "surface", "onSurfaceTextureDestroyed", "onSurfaceTextureRelease", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "onSurfaceTextureWrapperAvailable", "onSurfaceTextureWrapperDestroyed", "onSurfaceTextureWrapperRelease", "onSurfaceTextureWrapperSizeChanged", "onSurfaceTextureWrapperUpdated", "onSwitchCameraAnimEnd", "onTrimMemory", "pauseFaceDetection", "prepareMatrix", "isWatchCamera", "displayOrientation", "viewWidth", "viewHeight", "releaseAnimateBitmap", "releasePreview", "removeDisplayChangeListener", "requestRenderOverlayLayout", "msgType", "(Ljava/lang/Integer;)V", "resetTextureTranslation", "resumeFaceDetection", "resumeFrameTransitionFadeOut", "resumeSurfaceTexture", "setAnimViewFullScreen", "fullScreen", "setAspectRatio", "aspectRatio", "setBokehStatus", "isBokehOn", "setCleanScreen", "needClean", "setDisplayOrientation", "setDrawMeterSeparateUI", "isDrawMeterSeparateUI", "setExposureBarListenner", "listenner", "Lcom/meizu/media/camera/views/MzFocusRenderer$OnSeekBarChangeListener;", "setFaceView", "([Lcom/meizu/media/camera/camcontroller/CameraController$FaceInfo;I)V", "setFocusPosition", "setIsVideoRecording", "isRecording", "setMeterSeparateEnable", "isMeteringSeparate", "setOrientationIndicator", "setPreviewData", "setPreviewRender", "render", "Lcom/meizu/camera/effectlib/effects/renders/BaseRender;", "setPreviewSize", "setRefreshPreviewEnable", "setRenderType", "renderType", "", "setScreenExposureEnable", "isScreenExposure", "setSquareTransform", "square", "setSubCamSurfaceTextureVisible", "visibility", "setSurfaceTextureSizeChangedListener", "setTransformMatrix", "previewTranslationY", "needUpdate", "setVfbRenderType", "showFrameTransition", "bitmaps", "([Landroid/graphics/Bitmap;)V", "showPreferencesToast", "showResumeFrameTransition", "bitmap", "isShowWaitAnim", "showSlidingAnimView", "startTextureTranslationAnim", "moveUp", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "updateAnimViewLayout", "forceUpdate", "updateAnimViewLayoutByBitmapSize", "updateCameraBoundAndZoom", "cameraBound", "Landroid/graphics/Rect;", "zoom", "updateFullScreen", "updatePreviewSize", "Companion", "SaveLastPreviewBitmapTask", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.simplify.d */
public final class MzSimplifyCamUI implements SurfaceTexture.OnFrameAvailableListener, PreviewView.C1192a, PreviewView.C1194c, PreviewView.C1195d, CameraController.C1877d, FocusOverlaySimplifyManager.C2302a, CameraRootView.C2681a, PreviewGestures.C2670b, PreviewGestures.C2673e {

    /* renamed from: a */
    public static ChangeQuickRedirect f11806a;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public static final LogUtil.C2630a f11807al = new LogUtil.C2630a("MzSimplifyCamUI");

    /* renamed from: b */
    public static final C2306a f11808b = new C2306a((DefaultConstructorMarker) null);

    /* renamed from: A */
    private boolean f11809A;

    /* renamed from: B */
    private long f11810B;

    /* renamed from: C */
    private int f11811C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public MzImageView f11812D;

    /* renamed from: E */
    private boolean f11813E;

    /* renamed from: F */
    private int f11814F;

    /* renamed from: G */
    private int f11815G;

    /* renamed from: H */
    private PreviewGestures f11816H;

    /* renamed from: I */
    private RenderOverlay f11817I;

    /* renamed from: J */
    private MzFocusRenderer f11818J;

    /* renamed from: K */
    private MzSlideModeRenderer f11819K;

    /* renamed from: L */
    private int f11820L;

    /* renamed from: M */
    private boolean f11821M;

    /* renamed from: N */
    private boolean f11822N;

    /* renamed from: O */
    private int f11823O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public Bitmap f11824P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f11825Q;

    /* renamed from: R */
    private boolean f11826R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public Bitmap f11827S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public ValueAnimator f11828T;

    /* renamed from: U */
    private int f11829U;

    /* renamed from: V */
    private int f11830V;

    /* renamed from: W */
    private boolean f11831W;

    /* renamed from: X */
    private boolean f11832X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public Animation.AnimationListener f11833Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public Animation.AnimationListener f11834Z;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public int f11835aa;

    /* renamed from: ab */
    private int[] f11836ab;

    /* renamed from: ac */
    private int[] f11837ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public boolean f11838ad;

    /* renamed from: ae */
    private Object f11839ae;

    /* renamed from: af */
    private final Runnable f11840af;

    /* renamed from: ag */
    private final Runnable f11841ag;

    /* renamed from: ah */
    private final View.OnLayoutChangeListener f11842ah;

    /* renamed from: ai */
    private final TextureView.SurfaceTextureListener f11843ai;

    /* renamed from: aj */
    private int f11844aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public final Handler f11845ak;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RectF f11846c = new RectF();

    /* renamed from: d */
    private RectF f11847d = new RectF();

    /* renamed from: e */
    private RectF f11848e = new RectF();

    /* renamed from: f */
    private MzSimplifyImageCaptureUI f11849f;

    /* renamed from: g */
    private MzSimplifyVideoUI f11850g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CameraSimplifyActivity f11851h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MzSimplifyCamModule f11852i;

    /* renamed from: j */
    private CameraSimplifyBinding f11853j;

    /* renamed from: k */
    private SurfaceTexture f11854k;

    /* renamed from: l */
    private SurfaceTextureWrapper f11855l;

    /* renamed from: m */
    private TextView f11856m;

    /* renamed from: n */
    private FaceView f11857n;

    /* renamed from: o */
    private float f11858o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f11859p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f11860q;

    /* renamed from: r */
    private float f11861r;

    /* renamed from: s */
    private float f11862s;

    /* renamed from: t */
    private int f11863t;

    /* renamed from: u */
    private int f11864u;

    /* renamed from: v */
    private MzCamUI.C2499c f11865v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public CameraPreviewRenderView f11866w;

    /* renamed from: x */
    private TextureView f11867x;

    /* renamed from: y */
    private float f11868y;

    /* renamed from: z */
    private boolean f11869z;

    /* renamed from: a */
    public void mo21165a(@Nullable View view, int i, int i2, boolean z) {
    }

    /* renamed from: b */
    public void mo14350b(@Nullable SurfaceTexture surfaceTexture, int i, int i2) {
    }

    /* renamed from: b */
    public void mo21178b(@Nullable View view, int i, int i2) {
    }

    /* renamed from: b */
    public void mo14354b(@Nullable SurfaceTextureWrapper surfaceTextureWrapper, int i, int i2) {
    }

    /* renamed from: p */
    public final void mo21213p() {
    }

    /* renamed from: p */
    public final void mo21214p(boolean z) {
    }

    /* renamed from: q */
    public final void mo21215q() {
    }

    public MzSimplifyCamUI(@NotNull CameraSimplifyActivity cameraSimplifyActivity, @NotNull MzSimplifyCamModule mzSimplifyCamModule, @NotNull CameraSimplifyBinding cameraSimplifyBinding) {
        C3443i.m21155b(cameraSimplifyActivity, PushConstants.INTENT_ACTIVITY_NAME);
        C3443i.m21155b(mzSimplifyCamModule, "controller");
        C3443i.m21155b(cameraSimplifyBinding, "binding");
        this.f11851h = cameraSimplifyActivity;
        this.f11852i = mzSimplifyCamModule;
        this.f11853j = cameraSimplifyBinding;
        this.f11811C = -1;
        this.f11821M = true;
        this.f11826R = true;
        this.f11829U = 260;
        this.f11835aa = 4;
        this.f11836ab = new int[2];
        this.f11837ac = new int[2];
        this.f11839ae = new Object();
        this.f11840af = new C2315i(this);
        this.f11841ag = new C2316j(this);
        this.f11842ah = new C2317k(this);
        this.f11843ai = new C2318l();
        if (!EventBus.m21789a().mo27978b(this)) {
            EventBus.m21789a().mo27974a((Object) this);
        }
        if (!DeviceHelper.f13840T) {
            boolean z = DeviceHelper.f13841U;
        }
        CameraSimplifyBinding cameraSimplifyBinding2 = this.f11853j;
        if (cameraSimplifyBinding2 == null) {
            C3443i.m21151a();
        }
        CameraPreviewRenderView cameraPreviewRenderView = cameraSimplifyBinding2.f9543p;
        PreviewView.C1194c cVar = this;
        cameraPreviewRenderView.setSurfaceTextureListener(cVar);
        cameraPreviewRenderView.setBokehListener(this);
        cameraPreviewRenderView.addOnLayoutChangeListener(this.f11842ah);
        if (cameraPreviewRenderView != null) {
            cameraPreviewRenderView.addOnLayoutChangeListener(this.f11842ah);
            cameraPreviewRenderView.mo14100a();
            cameraPreviewRenderView.setSurfaceTextureListener2(cVar, this);
            cameraPreviewRenderView.setEffectRenderFactory(EffectRenderFactory.m4739a());
            cameraPreviewRenderView.setRenderType("Mznone");
            this.f11866w = cameraPreviewRenderView;
            this.f11812D = this.f11853j.f9545r;
            this.f11815G = CameraUtil.m15901h();
            this.f11814F = CameraUtil.m15904j();
            Context f = this.f11851h.mo17639f();
            C3443i.m21152a((Object) f, "mActivity.resourcesContext");
            this.f11863t = f.getResources().getDimensionPixelSize(R.dimen.mz_focus_take_picture_padding);
            Context f2 = this.f11851h.mo17639f();
            C3443i.m21152a((Object) f2, "mActivity.resourcesContext");
            this.f11864u = f2.getResources().getDimensionPixelSize(R.dimen.mz_touch_operation_padding);
            this.f11858o = ((float) CameraUtil.m15865b()) / ((float) CameraUtil.m15809a());
            this.f11856m = this.f11853j.f9531d.f9682f;
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            h.mo14194b(false);
            m12946V();
            this.f11817I = this.f11853j.f9544q;
            MzSlideModeRenderer jVar = new MzSlideModeRenderer(this.f11851h.getApplicationContext(), (MzSlideModeRenderer.C2751a) null, this.f11853j.getRoot());
            if (mzSimplifyCamModule.mo18353D() || mzSimplifyCamModule.mo18352C() || mzSimplifyCamModule.mo18350A()) {
                jVar.mo23375b(false);
            }
            this.f11819K = jVar;
            this.f11845ak = new Handler();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView");
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo27294d2 = {"Lcom/meizu/media/camera/simplify/MzSimplifyCamUI$Companion;", "", "()V", "LAST_PREVIEW_IMAGE_FILE_NAME", "", "REQUEST_FS_PREVIEW_FOR_CAMERA_SWITCH_END", "", "REQUEST_FS_PREVIEW_FOR_CAMERA_SWITCH_START", "REQUEST_FS_PREVIEW_FOR_MODE_SWITCH_END", "REQUEST_FS_PREVIEW_FOR_MODE_SWITCH_START", "REQUEST_FS_PREVIEW_FOR_OTHERS", "SPLATFORM_MTK", "SPLATFORM_QUALCOMM", "SPLATFORM_SAMSUNG", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$a */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2306a {
        private C2306a() {
        }

        public /* synthetic */ C2306a(DefaultConstructorMarker gVar) {
            this();
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$i */
    /* compiled from: MzSimplifyCamUI.kt */
    static final class C2315i implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11895a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11896b;

        C2315i(MzSimplifyCamUI dVar) {
            this.f11896b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11895a, false, 5664, new Class[0], Void.TYPE).isSupported && this.f11896b.f11835aa == 0) {
                this.f11896b.f11835aa = 1;
                this.f11896b.mo21180b(this.f11896b.f11833Y, true);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$j */
    /* compiled from: MzSimplifyCamUI.kt */
    static final class C2316j implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11897a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11898b;

        C2316j(MzSimplifyCamUI dVar) {
            this.f11898b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11897a, false, 5665, new Class[0], Void.TYPE).isSupported && this.f11898b.f11835aa == 2) {
                this.f11898b.f11835aa = 3;
                this.f11898b.mo21175a(this.f11898b.f11834Z, true);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, mo27294d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$k */
    /* compiled from: MzSimplifyCamUI.kt */
    static final class C2317k implements View.OnLayoutChangeListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11899a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11900b;

        C2317k(MzSimplifyCamUI dVar) {
            this.f11900b = dVar;
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i;
            int i10 = i2;
            int i11 = i3;
            int i12 = i4;
            Object[] objArr = {view, new Integer(i9), new Integer(i10), new Integer(i11), new Integer(i12), new Integer(i5), new Integer(i6), new Integer(i7), new Integer(i8)};
            ChangeQuickRedirect changeQuickRedirect = f11899a;
            Class[] clsArr = {View.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE};
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5666, clsArr, Void.TYPE).isSupported) {
                int i13 = i11 - i9;
                int i14 = i12 - i10;
                if (this.f11900b.f11859p != i13 || this.f11900b.f11860q != i14) {
                    this.f11900b.f11859p = i13;
                    this.f11900b.f11860q = i14;
                    this.f11900b.m12965d(i13, i14);
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$mSubCamSurfaceTextureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "texture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$l */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2318l implements TextureView.SurfaceTextureListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11901a;

        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int i, int i2) {
            if (!PatchProxy.proxy(new Object[]{surfaceTexture, new Integer(i), new Integer(i2)}, this, f11901a, false, 5667, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                C3443i.m21155b(surfaceTexture, "texture");
            }
        }

        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surfaceTexture) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTexture}, this, f11901a, false, 5669, new Class[]{SurfaceTexture.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            C3443i.m21155b(surfaceTexture, "texture");
            return true;
        }

        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int i, int i2) {
            if (!PatchProxy.proxy(new Object[]{surfaceTexture, new Integer(i), new Integer(i2)}, this, f11901a, false, 5668, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                C3443i.m21155b(surfaceTexture, "texture");
            }
        }

        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surfaceTexture) {
            if (!PatchProxy.proxy(new Object[]{surfaceTexture}, this, f11901a, false, 5670, new Class[]{SurfaceTexture.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(surfaceTexture, "texture");
            }
        }

        C2318l() {
        }
    }

    @Nullable
    /* renamed from: a */
    public final MzSlideModeRenderer mo21156a() {
        return this.f11819K;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void requestRenderOverlayLayout(@Nullable Integer num) {
        if (!PatchProxy.proxy(new Object[]{num}, this, f11806a, false, 5544, new Class[]{Integer.class}, Void.TYPE).isSupported && num != null && num.intValue() == 8 && this.f11817I != null) {
            RenderOverlay renderOverlay = this.f11817I;
            if (renderOverlay == null) {
                C3443i.m21151a();
            }
            renderOverlay.mo23142a((RenderOverlay.C2723a) this.f11819K);
            RenderOverlay renderOverlay2 = this.f11817I;
            if (renderOverlay2 == null) {
                C3443i.m21151a();
            }
            renderOverlay2.requestLayout();
            RenderOverlay renderOverlay3 = this.f11817I;
            if (renderOverlay3 == null) {
                C3443i.m21151a();
            }
            renderOverlay3.mo23139a();
            RenderOverlay renderOverlay4 = this.f11817I;
            if (renderOverlay4 == null) {
                C3443i.m21151a();
            }
            renderOverlay4.invalidate();
        }
    }

    /* renamed from: q */
    private final void m12979q(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11806a, false, 5545, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f11825Q) {
                this.f11825Q = true;
            } else if (!CameraOptTask.m7846m() || z) {
                new C2325s(this).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J'\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0006\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0004¨\u0006\u000b"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$showResumeFrameTransition$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/graphics/Bitmap;", "onPostExecute", "", "bitmap", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$s */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2325s extends AsyncTaskEx<Void, Void, Bitmap> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11914a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11915b;

        C2325s(MzSimplifyCamUI dVar) {
            this.f11915b = dVar;
        }

        @Nullable
        /* renamed from: a */
        public Bitmap mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11914a, false, 5681, new Class[]{Void[].class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            C3443i.m21155b(voidArr, "params");
            CameraSimplifyActivity a = this.f11915b.f11851h;
            if (a == null) {
                C3443i.m21151a();
            }
            File file = new File(a.getFilesDir(), "last_preview_file");
            if (!file.exists()) {
                return null;
            }
            LogUtil.m15942a(MzSimplifyCamUI.f11807al, "decodeFile start");
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), (BitmapFactory.Options) null);
            LogUtil.m15942a(MzSimplifyCamUI.f11807al, "decodeFile end");
            return decodeFile;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public final void m12943S() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5548, new Class[0], Void.TYPE).isSupported) {
            SwitchAnimManager.m8194a((View) this.f11812D, (PreviewView) this.f11866w, (View) null, (ViewGroup) null, 0.0f, 50, false, false, (Animation.AnimationListener) new C2323q(this));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$resumeFrameTransitionFadeOut$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$q */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2323q implements Animation.AnimationListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11910a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11911b;

        public void onAnimationRepeat(@NotNull Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f11910a, false, 5677, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animation, "animation");
            }
        }

        C2323q(MzSimplifyCamUI dVar) {
            this.f11911b = dVar;
        }

        public void onAnimationStart(@NotNull Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f11910a, false, 5675, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animation, "animation");
                if (this.f11911b.f11866w != null) {
                    CameraPreviewRenderView d = this.f11911b.f11866w;
                    if (d == null) {
                        C3443i.m21151a();
                    }
                    d.setViewAlpha(1.0f);
                }
            }
        }

        public void onAnimationEnd(@NotNull Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f11910a, false, 5676, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animation, "animation");
                MzImageView e = this.f11911b.f11812D;
                if (e == null) {
                    C3443i.m21151a();
                }
                e.setVisibility(8);
                MzSimplifyCamModule f = this.f11911b.f11852i;
                if (f == null) {
                    C3443i.m21151a();
                }
                if (f.mo18354E()) {
                    this.f11911b.mo21172a(true);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo21168a(@Nullable MzSimplifyUIController jVar) {
        if (!PatchProxy.proxy(new Object[]{jVar}, this, f11806a, false, 5551, new Class[]{MzSimplifyUIController.class}, Void.TYPE).isSupported) {
            if (this.f11849f == null) {
                CameraSimplifyBinding cameraSimplifyBinding = this.f11853j;
                if (cameraSimplifyBinding == null) {
                    C3443i.m21151a();
                }
                this.f11849f = new MzSimplifyImageCaptureUI(cameraSimplifyBinding.getRoot(), this.f11852i, jVar);
            }
            MzSimplifyImageCaptureUI hVar = this.f11849f;
            if (hVar == null) {
                C3443i.m21151a();
            }
            hVar.mo21283a();
        }
    }

    /* renamed from: a */
    public final void mo21172a(boolean z) {
        PreviewGestures yVar;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5552, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (yVar = this.f11816H) != null) {
            yVar.mo22776a(z);
        }
    }

    /* renamed from: a */
    public final void mo21171a(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f11806a, false, 5554, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (this.f11866w != null) {
                CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
                if (cameraPreviewRenderView == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView.setRenderType(str);
            }
            if (this.f11852i != null) {
                this.f11852i.mo18462c(str);
            }
        }
    }

    /* renamed from: b */
    public final void mo21181b(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f11806a, false, 5555, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (!DeviceHelper.f13886am) {
                mo21171a(str);
            } else if (this.f11866w != null) {
                CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
                if (cameraPreviewRenderView == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView.setVfbRenderType(str);
            }
        }
    }

    /* renamed from: a */
    public final void mo21169a(@NotNull MzCamUI.C2499c cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, this, f11806a, false, 5556, new Class[]{MzCamUI.C2499c.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(cVar, "listener");
            this.f11865v = cVar;
        }
    }

    /* renamed from: a */
    public final void mo21157a(float f) {
        if (!PatchProxy.proxy(new Object[]{new Float(f)}, this, f11806a, false, 5557, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            if (f <= ((float) 0)) {
                LogUtil.C2630a aVar = f11807al;
                LogUtil.m15949b(aVar, "Invalid aspect ratio: " + f);
                return;
            }
            if (f < 1.0f) {
                f = 1.0f / f;
            }
            if (!C2644av.m16103a(this.f11868y, f)) {
                this.f11868y = f;
                m12958b(this.f11868y);
                if (this.f11828T != null) {
                    ValueAnimator valueAnimator = this.f11828T;
                    if (valueAnimator == null) {
                        C3443i.m21151a();
                    }
                    if (valueAnimator.isRunning()) {
                        ValueAnimator valueAnimator2 = this.f11828T;
                        if (valueAnimator2 == null) {
                            C3443i.m21151a();
                        }
                        valueAnimator2.end();
                    }
                }
                if (this.f11809A) {
                    mo21153O();
                }
                if (this.f11859p != 0 && this.f11860q != 0) {
                    m12965d(this.f11859p, this.f11860q);
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo21182b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5558, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f11869z = z;
            m12965d(this.f11859p, this.f11860q);
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            h.mo14194b(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0068, code lost:
        if (java.lang.Math.abs(r9.f11868y - ((((float) com.meizu.media.camera.util.CameraUtil.m15865b()) + ((float) com.meizu.media.camera.util.CameraUtil.m15912r())) / ((float) com.meizu.media.camera.util.CameraUtil.m15809a()))) < 0.1f) goto L_0x006c;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12958b(float r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Float r2 = new java.lang.Float
            r2.<init>(r10)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f11806a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Float.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5561(0x15b9, float:7.793E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            float r1 = r9.f11868y
            float r2 = r9.f11858o
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            r2 = 1036831949(0x3dcccccd, float:0.1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0033
            goto L_0x006c
        L_0x0033:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13874aa
            if (r1 == 0) goto L_0x0048
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r1 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_18_9
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r3 = com.meizu.media.camera.util.CameraUtil.m15829a((float) r10)
            if (r1 == r3) goto L_0x006c
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r1 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_18X_9_FullScreen
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r10 = com.meizu.media.camera.util.CameraUtil.m15829a((float) r10)
            if (r1 != r10) goto L_0x0048
            goto L_0x006c
        L_0x0048:
            boolean r10 = com.meizu.media.camera.util.NavigationBarUtils.m15972a()
            if (r10 == 0) goto L_0x006b
            int r10 = com.meizu.media.camera.util.CameraUtil.m15865b()
            float r10 = (float) r10
            int r1 = com.meizu.media.camera.util.CameraUtil.m15912r()
            float r1 = (float) r1
            float r10 = r10 + r1
            int r1 = com.meizu.media.camera.util.CameraUtil.m15809a()
            float r1 = (float) r1
            float r10 = r10 / r1
            float r1 = r9.f11868y
            float r1 = r1 - r10
            float r10 = java.lang.Math.abs(r1)
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r0 = 0
        L_0x006c:
            r9.f11809A = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyCamUI.m12958b(float):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12951a(int i, int i2, int i3, boolean z) {
        float f;
        float f2;
        boolean z2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float[] fArr;
        MzCamUI.C2499c cVar;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        boolean z3 = z;
        if (!PatchProxy.proxy(new Object[]{new Integer(i4), new Integer(i5), new Integer(i6), new Byte(z3 ? (byte) 1 : 0)}, this, f11806a, false, 5562, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            float[] fArr2 = new float[16];
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.mo14103a(fArr2);
            if (i4 > i5) {
                f2 = (float) Math.max(i4, (int) (((float) i5) * this.f11868y));
                f = (float) Math.max(i5, (int) (((float) i4) / this.f11868y));
            } else {
                float abs = Math.abs(1.3333334f - this.f11868y);
                float abs2 = Math.abs(1.2222222f - this.f11868y);
                float abs3 = Math.abs(this.f11858o - this.f11868y);
                if (abs >= abs3 || abs2 >= abs3) {
                    f2 = (float) Math.max(i4, (int) (((float) i5) / this.f11868y));
                    f = (float) Math.max(i5, (int) (((float) i4) * this.f11868y));
                } else {
                    float f8 = (float) i4;
                    f = abs2 < abs ? (11.0f * f8) / 9.0f : (4.0f * f8) / 3.0f;
                    f2 = f8;
                }
            }
            if (DeviceHelper.f13874aa) {
                f2 = (float) i4;
                f = this.f11868y * f2;
            }
            float f9 = f2;
            float f10 = f;
            if ((!C2644av.m16103a(this.f11861r, f9) || !C2644av.m16103a(this.f11862s, f10)) && (cVar = this.f11865v) != null) {
                this.f11861r = f9;
                this.f11862s = f10;
                cVar.mo22243a((int) this.f11861r, (int) this.f11862s);
            }
            boolean z4 = DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.INVENSENSE && this.f11852i != null && this.f11852i.mo18439an();
            if (z4) {
                float f11 = f9 * 0.25f;
                float f12 = f10 * 0.25f;
                float f13 = (f10 + f12) / ((float) i5);
                Matrix.setIdentityM(fArr2, 0);
                Matrix.scaleM(fArr2, 0, (f9 + f11) / ((float) i4), f13, 1.0f);
                float f14 = (float) 2;
                float f15 = (((float) this.f11860q) * (((float) 1) - f13)) / f14;
                if ((DeviceHelper.f13874aa || !NavigationBarUtils.m15972a()) && !this.f11809A) {
                    f15 = (f15 - ((float) this.f11815G)) + ((float) i6);
                }
                float[] fArr3 = new float[16];
                Matrix.setIdentityM(fArr3, 0);
                Matrix.translateM(fArr3, 0, 0.0f, ((f15 + (f12 / f14)) * f14) / ((float) this.f11860q), 0.0f);
                z2 = z4;
                f4 = f10;
                f7 = f9;
                Matrix.multiplyMM(fArr3, 0, fArr3, 0, fArr2, 0);
                CameraPreviewRenderView cameraPreviewRenderView2 = this.f11866w;
                if (cameraPreviewRenderView2 == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView2.setTransform(fArr3);
                f5 = f11;
                f6 = f12;
                f3 = 0.25f;
            } else {
                z2 = z4;
                f4 = f10;
                f7 = f9;
                f6 = 0.0f;
                f5 = 0.0f;
                f3 = 0.0f;
            }
            float f16 = (float) i4;
            float f17 = (float) i5;
            float f18 = f4 / f17;
            Matrix.setIdentityM(fArr2, 0);
            float f19 = f17;
            Matrix.scaleM(fArr2, 0, f7 / f16, f18, 1.0f);
            float f20 = (float) 2;
            float f21 = (((float) this.f11860q) * (((float) 1) - f18)) / f20;
            if ((DeviceHelper.f13874aa || !NavigationBarUtils.m15972a()) && !this.f11809A) {
                f21 = (f21 - ((float) this.f11815G)) + ((float) i6);
            }
            float[] fArr4 = new float[16];
            Matrix.setIdentityM(fArr4, 0);
            Matrix.translateM(fArr4, 0, 0.0f, (f21 * f20) / ((float) this.f11860q), 0.0f);
            float[] fArr5 = fArr4;
            float f22 = f19;
            float f23 = f16;
            float f24 = f6;
            float[] fArr6 = fArr2;
            float f25 = f5;
            Matrix.multiplyMM(fArr4, 0, fArr4, 0, fArr6, 0);
            boolean z5 = z2;
            if (!z5) {
                CameraPreviewRenderView cameraPreviewRenderView3 = this.f11866w;
                if (cameraPreviewRenderView3 == null) {
                    C3443i.m21151a();
                }
                fArr = fArr5;
                cameraPreviewRenderView3.setTransform(fArr);
            } else {
                fArr = fArr5;
            }
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15952c(aVar, "setTransformMatrix needCropPreview:" + z5 + ", scaledTexture:" + f7 + "x" + f4 + ", width:" + i4 + "x" + i5 + ", crop:" + f25 + "x" + f24 + ", cropRatio:" + f3);
            RectF rectF = new RectF(0.0f, 0.0f, f23, f22);
            m12949a(fArr, rectF);
            int width = (int) rectF.width();
            if (width > this.f11859p) {
                width = this.f11859p;
            }
            int height = (int) rectF.height();
            if (height > this.f11860q) {
                height = this.f11860q;
            }
            int f26 = this.f11851h != null ? CameraUtil.m15897f() : 0;
            TextureView textureView = this.f11867x;
            if (textureView != null) {
                android.graphics.Matrix matrix = new android.graphics.Matrix();
                this.f11846c.set(0.0f, (float) this.f11815G, (float) width, ((float) height) - ((float) f26));
                matrix.setRectToRect(rectF, this.f11846c, Matrix.ScaleToFit.CENTER);
                textureView.setTransform(matrix);
            }
            CameraUtil.ScreeAspectRatio a = CameraUtil.m15829a(this.f11868y);
            if (this.f11869z) {
                this.f11814F = CameraUtil.m15904j();
                float f27 = (float) width;
                this.f11846c.set(0.0f, (float) this.f11814F, f27, ((float) this.f11814F) + f27);
                this.f11847d.set(0.0f, (float) this.f11814F, f27, ((float) this.f11814F) + f27);
            } else if (this.f11809A) {
                float f28 = (float) width;
                float f29 = (float) height;
                this.f11846c.set(0.0f, 0.0f, f28, f29);
                this.f11847d.set(0.0f, (float) this.f11815G, f28, f29 - ((float) f26));
            } else if (DeviceHelper.f13874aa && CameraUtil.ScreeAspectRatio.Ratio_16_9 == a) {
                float f30 = (float) width;
                this.f11846c.set(0.0f, (float) this.f11815G, f30, ((float) height) + ((float) this.f11815G));
                this.f11847d.set(0.0f, (float) this.f11815G, f30, ((float) this.f11815G) + (1.3333334f * f30));
            } else if (!NavigationBarUtils.m15972a() || DeviceHelper.f13874aa) {
                float f31 = (float) width;
                float f32 = (float) height;
                this.f11846c.set(0.0f, (float) this.f11815G, f31, ((float) this.f11815G) + f32);
                this.f11847d.set(0.0f, (float) this.f11815G, f31, ((float) this.f11815G) + f32);
            } else {
                float f33 = (float) width;
                float f34 = (float) height;
                this.f11846c.set(0.0f, 0.0f, f33, f34);
                this.f11847d.set(0.0f, (float) this.f11815G, f33, f34);
            }
            float f35 = (float) i6;
            this.f11846c.set(this.f11846c.left, this.f11846c.top - f35, this.f11846c.right, this.f11846c.bottom - f35);
            this.f11847d.set(this.f11847d.left, this.f11847d.top, this.f11847d.right, this.f11847d.bottom - f35);
            this.f11848e.set(this.f11847d.left + ((float) this.f11863t), this.f11847d.top, this.f11847d.right - ((float) this.f11863t), this.f11847d.bottom);
            this.f11847d.set(this.f11847d.left + ((float) this.f11864u), this.f11847d.top, this.f11847d.right - ((float) this.f11864u), this.f11847d.bottom);
            FaceView faceView = this.f11857n;
            if (faceView != null) {
                faceView.setTextureTranslationY(i6);
                faceView.setCropPreviewRatio(f3);
            }
            PreviewGestures yVar = this.f11816H;
            if (yVar != null) {
                yVar.mo22772a(this.f11847d, this.f11864u);
            }
            if (this.f11818J != null && z3) {
                MzFocusRenderer gVar = this.f11818J;
                if (gVar == null) {
                    C3443i.m21151a();
                }
                gVar.mo23326a((int) this.f11846c.width(), (int) this.f11846c.height());
            }
            if (this.f11852i != null) {
                FocusOverlaySimplifyManager am = this.f11852i.mo18438am();
                if (am != null) {
                    am.mo21058a(f3);
                }
                this.f11852i.mo18379a((int) this.f11846c.width(), (int) this.f11846c.height(), (int) this.f11846c.top, this.f11846c, z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m12965d(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5563, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15942a(aVar, "setTransformMatrix width:" + i + ",height:" + i2);
            m12951a(i, i2, this.f11830V, true);
        }
    }

    /* renamed from: a */
    private final RectF m12949a(float[] fArr, RectF rectF) {
        RectF rectF2 = rectF;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr, rectF2}, this, f11806a, false, 5564, new Class[]{float[].class, RectF.class}, RectF.class);
        if (proxy.isSupported) {
            return (RectF) proxy.result;
        }
        int i = (int) ((fArr[0] * rectF2.left) + (fArr[1] * rectF2.top) + fArr[3]);
        int i2 = (int) ((fArr[4] * rectF2.left) + (fArr[5] * rectF2.top) + fArr[7]);
        int i3 = (int) ((fArr[0] * rectF2.left) + (fArr[1] * rectF2.bottom) + fArr[3]);
        int i4 = (int) ((fArr[4] * rectF2.left) + (fArr[5] * rectF2.bottom) + fArr[7]);
        int i5 = (int) ((fArr[0] * rectF2.right) + (fArr[1] * rectF2.top) + fArr[3]);
        int i6 = (int) ((fArr[4] * rectF2.right) + (fArr[5] * rectF2.top) + fArr[7]);
        int i7 = (int) ((fArr[0] * rectF2.right) + (fArr[1] * rectF2.bottom) + fArr[3]);
        int i8 = (int) ((fArr[4] * rectF2.right) + (fArr[5] * rectF2.bottom) + fArr[7]);
        int min = Math.min(i, Math.min(i3, Math.min(i5, i7)));
        int max = Math.max(i, Math.max(i3, Math.max(i5, i7)));
        int min2 = Math.min(i2, Math.min(i4, Math.min(i6, i8)));
        int max2 = Math.max(i2, Math.max(i4, Math.max(i6, i8)));
        rectF2.left = (float) min;
        rectF2.right = (float) max;
        rectF2.top = (float) min2;
        rectF2.bottom = (float) max2;
        return rectF2;
    }

    @Nullable
    /* renamed from: b */
    public final SurfaceTexture mo21176b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5565, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        if (EffectRenderContext.m4369h().mo14195b(this.f11854k)) {
            return this.f11854k;
        }
        return null;
    }

    @Nullable
    /* renamed from: c */
    public final SurfaceTexture mo21184c() {
        SurfaceTexture surfaceTexture;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5566, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        TextureView textureView = this.f11867x;
        if (textureView == null || (surfaceTexture = textureView.getSurfaceTexture()) == null) {
            return null;
        }
        return surfaceTexture;
    }

    @Nullable
    /* renamed from: d */
    public final SurfaceTextureWrapper mo21188d() {
        return this.f11855l;
    }

    /* renamed from: a */
    public final void mo21158a(int i) {
        TextureView textureView;
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5567, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (textureView = this.f11867x) != null) {
            textureView.setVisibility(i);
        }
    }

    /* renamed from: T */
    private final FocusIndicator m12944T() {
        FocusIndicator cVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5569, new Class[0], FocusIndicator.class);
        if (proxy.isSupported) {
            return (FocusIndicator) proxy.result;
        }
        if (this.f11857n != null) {
            FaceView faceView = this.f11857n;
            if (faceView == null) {
                C3443i.m21151a();
            }
            if (faceView.mo22843a()) {
                cVar = this.f11857n;
                return cVar;
            }
        }
        cVar = this.f11818J;
        return cVar;
    }

    /* renamed from: e */
    public final void mo21190e() {
        DelayInflateOneBinding delayInflateOneBinding;
        DelayInflateTwoBinding delayInflateTwoBinding;
        FaceViewBinding faceViewBinding;
        StubCamPreviewLayoutBinding stubCamPreviewLayoutBinding;
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5572, new Class[0], Void.TYPE).isSupported) {
            CameraSimplifyBinding cameraSimplifyBinding = this.f11853j;
            if (cameraSimplifyBinding == null) {
                C3443i.m21151a();
            }
            ViewStubProxy viewStubProxy = cameraSimplifyBinding.f9532e;
            C3443i.m21152a((Object) viewStubProxy, "mCameraSimplifyBinding!!.delayInflateOne");
            if (viewStubProxy.getViewStub() != null) {
                ViewStubProxy viewStubProxy2 = this.f11853j.f9532e;
                C3443i.m21152a((Object) viewStubProxy2, "mCameraSimplifyBinding.delayInflateOne");
                ViewStub viewStub = viewStubProxy2.getViewStub();
                if (viewStub == null) {
                    C3443i.m21151a();
                }
                delayInflateOneBinding = (DelayInflateOneBinding) DataBindingUtil.bind(viewStub.inflate());
            } else {
                ViewStubProxy viewStubProxy3 = this.f11853j.f9532e;
                C3443i.m21152a((Object) viewStubProxy3, "mCameraSimplifyBinding.delayInflateOne");
                delayInflateOneBinding = (DelayInflateOneBinding) viewStubProxy3.getBinding();
            }
            ViewStubProxy viewStubProxy4 = this.f11853j.f9533f;
            C3443i.m21152a((Object) viewStubProxy4, "mCameraSimplifyBinding.delayInflateTwo");
            if (viewStubProxy4.getViewStub() != null) {
                ViewStubProxy viewStubProxy5 = this.f11853j.f9533f;
                C3443i.m21152a((Object) viewStubProxy5, "mCameraSimplifyBinding.delayInflateTwo");
                ViewStub viewStub2 = viewStubProxy5.getViewStub();
                if (viewStub2 == null) {
                    C3443i.m21151a();
                }
                delayInflateTwoBinding = (DelayInflateTwoBinding) DataBindingUtil.bind(viewStub2.inflate());
            } else {
                ViewStubProxy viewStubProxy6 = this.f11853j.f9533f;
                C3443i.m21152a((Object) viewStubProxy6, "mCameraSimplifyBinding.delayInflateTwo");
                delayInflateTwoBinding = (DelayInflateTwoBinding) viewStubProxy6.getBinding();
            }
            ViewStubProxy viewStubProxy7 = this.f11853j.f9541n;
            C3443i.m21152a((Object) viewStubProxy7, "mCameraSimplifyBinding.mzSquareControl");
            if (viewStubProxy7.getViewStub() != null) {
                ViewStubProxy viewStubProxy8 = this.f11853j.f9541n;
                C3443i.m21152a((Object) viewStubProxy8, "mCameraSimplifyBinding.mzSquareControl");
                ViewStub viewStub3 = viewStubProxy8.getViewStub();
                if (viewStub3 == null) {
                    C3443i.m21151a();
                }
                viewStub3.inflate();
            }
            if (delayInflateOneBinding == null) {
                C3443i.m21151a();
            }
            if (delayInflateOneBinding.f9557b.getViewStub() != null) {
                ViewStub viewStub4 = delayInflateOneBinding.f9557b.getViewStub();
                if (viewStub4 == null) {
                    C3443i.m21151a();
                }
                View inflate = viewStub4.inflate();
                C3443i.m21152a((Object) inflate, "delayInflateOneBinding.f…getViewStub()!!.inflate()");
                faceViewBinding = (FaceViewBinding) DataBindingUtil.bind(inflate);
            } else {
                ViewDataBinding binding = delayInflateOneBinding.f9557b.getBinding();
                if (binding != null) {
                    faceViewBinding = (FaceViewBinding) binding;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.databinding.FaceViewBinding");
                }
            }
            if (faceViewBinding == null) {
                C3443i.m21151a();
            }
            FaceView faceView = faceViewBinding.f9601a;
            faceView.setWatchCamera(false);
            C3443i.m21152a((Object) faceView, "this");
            mo21169a((MzCamUI.C2499c) faceView);
            this.f11857n = faceView;
            if (DeviceHelper.f13840T && DeviceHelper.f13856aI && DeviceHelper.f14042l) {
                if (delayInflateOneBinding.f9561f.getViewStub() != null) {
                    ViewStub viewStub5 = delayInflateOneBinding.f9561f.getViewStub();
                    if (viewStub5 == null) {
                        C3443i.m21151a();
                    }
                    View inflate2 = viewStub5.inflate();
                    C3443i.m21152a((Object) inflate2, "delayInflateOneBinding.s…getViewStub()!!.inflate()");
                    stubCamPreviewLayoutBinding = (StubCamPreviewLayoutBinding) DataBindingUtil.bind(inflate2);
                } else {
                    ViewDataBinding binding2 = delayInflateOneBinding.f9561f.getBinding();
                    if (binding2 != null) {
                        stubCamPreviewLayoutBinding = (StubCamPreviewLayoutBinding) binding2;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.databinding.StubCamPreviewLayoutBinding");
                    }
                }
                if (stubCamPreviewLayoutBinding == null) {
                    C3443i.m21151a();
                }
                TextureView textureView = stubCamPreviewLayoutBinding.f9879a;
                textureView.setSurfaceTextureListener(this.f11843ai);
                this.f11867x = textureView;
            }
            if (DeviceHelper.f13877ad) {
                if (delayInflateTwoBinding == null) {
                    C3443i.m21151a();
                }
                if (delayInflateTwoBinding.f9574e.getViewStub() != null) {
                    ViewStub viewStub6 = delayInflateTwoBinding.f9574e.getViewStub();
                    if (viewStub6 == null) {
                        C3443i.m21151a();
                    }
                    viewStub6.inflate();
                }
            }
        }
    }

    /* renamed from: f */
    public final void mo21192f() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5573, new Class[0], Void.TYPE).isSupported) {
            if (this.f11818J == null) {
                CameraSimplifyActivity cameraSimplifyActivity = this.f11851h;
                if (cameraSimplifyActivity == null) {
                    C3443i.m21151a();
                }
                this.f11818J = new MzFocusRenderer(cameraSimplifyActivity.mo17639f());
                RenderOverlay renderOverlay = this.f11817I;
                if (renderOverlay == null) {
                    C3443i.m21151a();
                }
                renderOverlay.mo23142a((RenderOverlay.C2723a) this.f11818J);
            }
            if (this.f11816H == null) {
                ActivityBase activityBase = this.f11851h;
                PreviewGestures.C2673e eVar = this;
                PreviewGestures.C2670b bVar = this;
                CameraSimplifyActivity cameraSimplifyActivity2 = this.f11851h;
                if (cameraSimplifyActivity2 == null) {
                    C3443i.m21151a();
                }
                Context f = cameraSimplifyActivity2.mo17639f();
                CameraSimplifyBinding cameraSimplifyBinding = this.f11853j;
                if (cameraSimplifyBinding == null) {
                    C3443i.m21151a();
                }
                PreviewGestures yVar = new PreviewGestures(activityBase, eVar, bVar, new ZoomRenderer(f, cameraSimplifyBinding.getRoot()), this.f11818J);
                yVar.mo22772a(this.f11847d, this.f11864u);
                RenderOverlay renderOverlay2 = this.f11817I;
                if (renderOverlay2 == null) {
                    C3443i.m21151a();
                }
                renderOverlay2.setGestures(yVar);
                this.f11816H = yVar;
            }
            PreviewGestures yVar2 = this.f11816H;
            if (yVar2 == null) {
                C3443i.m21151a();
            }
            yVar2.mo22773a(this.f11817I);
            MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
            if (mzSimplifyCamModule == null) {
                C3443i.m21151a();
            }
            mzSimplifyCamModule.mo18393a(this.f11817I, this.f11816H);
            RenderOverlay renderOverlay3 = this.f11817I;
            if (renderOverlay3 == null) {
                C3443i.m21151a();
            }
            renderOverlay3.requestLayout();
            EventBus.m21789a().mo27980d(9);
        }
    }

    /* renamed from: b */
    public final void mo21177b(int i) {
        this.f11820L = i;
    }

    /* renamed from: g */
    public final void mo21194g() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5574, new Class[0], Void.TYPE).isSupported) {
            MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
            if (mzSimplifyCamModule == null) {
                C3443i.m21151a();
            }
            mzSimplifyCamModule.mo18350A();
        }
    }

    /* renamed from: c */
    public final void mo21187c(boolean z) {
        FaceView faceView;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5575, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (faceView = this.f11857n) != null) {
            faceView.mo22844b();
            if (!z) {
                faceView.mo22846c();
            }
        }
    }

    /* renamed from: h */
    public final void mo21196h() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5576, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11807al, "onStop");
            if (this.f11867x != null) {
                TextureView textureView = this.f11867x;
                if (textureView == null) {
                    C3443i.m21151a();
                }
                if (textureView.getVisibility() == 0) {
                    TextureView textureView2 = this.f11867x;
                    if (textureView2 == null) {
                        C3443i.m21151a();
                    }
                    textureView2.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: i */
    public final void mo21198i() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5577, new Class[0], Void.TYPE).isSupported && !this.f11826R) {
            LogUtil.m15952c(f11807al, "releasePreview");
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.mo14116h();
            this.f11826R = true;
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            h.mo14227l(true);
        }
    }

    /* renamed from: j */
    public final void mo21200j() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5578, new Class[0], Void.TYPE).isSupported) {
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.mo14117i();
            if (!this.f11826R) {
                LogUtil.m15952c(f11807al, "destroyPreview");
                CameraPreviewRenderView cameraPreviewRenderView2 = this.f11866w;
                if (cameraPreviewRenderView2 == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView2.mo14116h();
                this.f11826R = true;
                EffectRenderContext h = EffectRenderContext.m4369h();
                C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                h.mo14227l(true);
            }
        }
    }

    /* renamed from: k */
    public final void mo21202k() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5579, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11807al, "onCameraClose");
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.mo14118j();
            this.f11826R = true;
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            h.mo14227l(true);
            this.f11838ad = false;
        }
    }

    /* renamed from: l */
    public final void mo21204l() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5580, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11807al, UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONSTART);
            TextureView textureView = this.f11867x;
            if (textureView != null) {
                textureView.setVisibility(0);
            }
        }
    }

    /* renamed from: d */
    public final void mo21189d(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11806a, false, 5581, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15952c(aVar, "initSurfaceTexture:" + this.f11826R);
            if (this.f11826R) {
                CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
                if (cameraPreviewRenderView == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView.mo14106d();
                this.f11826R = false;
                EffectRenderContext h = EffectRenderContext.m4369h();
                C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                h.mo14227l(false);
            }
            this.f11821M = true;
            EffectRenderContext h2 = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
            h2.mo14222j(this.f11821M);
            if (z) {
                CameraPreviewRenderView cameraPreviewRenderView2 = this.f11866w;
                if (cameraPreviewRenderView2 == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView2.mo14122m();
            }
        }
    }

    /* renamed from: e */
    public final void mo21191e(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11806a, false, 5582, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15952c(aVar, "resumeSurfaceTexture:" + this.f11826R);
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            if (h.mo14165J()) {
                CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
                if (cameraPreviewRenderView == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView.mo14108f();
                this.f11826R = false;
                EffectRenderContext h2 = EffectRenderContext.m4369h();
                C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
                h2.mo14227l(false);
            }
            this.f11821M = true;
            EffectRenderContext h3 = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h3, "EffectRenderContext.getInstance()");
            h3.mo14222j(this.f11821M);
            if (z) {
                CameraPreviewRenderView cameraPreviewRenderView2 = this.f11866w;
                if (cameraPreviewRenderView2 == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView2.mo14122m();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015c  */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo21206m() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f11806a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5583(0x15cf, float:7.823E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            com.meizu.media.camera.util.ac$a r1 = f11807al
            java.lang.String r2 = "onPause start"
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            r8.f11825Q = r0
            com.meizu.media.camera.views.FaceView r1 = r8.f11857n
            if (r1 == 0) goto L_0x0026
            r1.mo22844b()
        L_0x0026:
            android.graphics.Bitmap r1 = r8.f11824P
            if (r1 == 0) goto L_0x002d
            r1.recycle()
        L_0x002d:
            com.meizu.media.camera.MzSimplifyCamModule r1 = r8.f11852i
            if (r1 != 0) goto L_0x0034
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0034:
            com.meizu.media.camera.simplify.MzSimplifyCamController$ModuleState r1 = r1.mo18476h()
            com.meizu.media.camera.simplify.MzSimplifyCamController$ModuleState r2 = com.meizu.media.camera.simplify.MzSimplifyCamController.ModuleState.IDLE
            if (r1 == r2) goto L_0x00a5
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 != 0) goto L_0x0043
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0043:
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x00a5
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 != 0) goto L_0x0050
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0050:
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            if (r1 == 0) goto L_0x009d
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            com.meizu.media.camera.util.ac$a r2 = f11807al
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "cache drawable:"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            if (r1 == 0) goto L_0x0099
            android.graphics.Bitmap r2 = r1.getBitmap()
            if (r2 == 0) goto L_0x0099
            android.graphics.Bitmap r1 = r1.getBitmap()
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1)
            r8.f11824P = r1
            com.meizu.media.camera.util.ac$a r1 = f11807al
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "cache bitmap:"
            r2.append(r3)
            android.graphics.Bitmap r3 = r8.f11824P
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            goto L_0x00a8
        L_0x0099:
            r8.m12945U()
            goto L_0x00a8
        L_0x009d:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable"
            r0.<init>(r1)
            throw r0
        L_0x00a5:
            r8.m12945U()
        L_0x00a8:
            com.meizu.media.camera.CameraSimplifyActivity r1 = r8.f11851h
            if (r1 != 0) goto L_0x00af
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00af:
            boolean r1 = r1.mo17773y()
            r2 = 0
            if (r1 != 0) goto L_0x0105
            com.meizu.media.camera.animation.SwitchAnimManager.m8189a((boolean) r0)
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 == 0) goto L_0x014e
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 != 0) goto L_0x00c4
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00c4:
            r3 = 8
            r1.setVisibility(r3)
            com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = r8.f11866w
            if (r1 != 0) goto L_0x00d0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00d0:
            r3 = 1065353216(0x3f800000, float:1.0)
            r1.setViewAlpha(r3)
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 != 0) goto L_0x00dc
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00dc:
            android.view.animation.Animation r1 = r1.getAnimation()
            if (r1 == 0) goto L_0x014e
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 != 0) goto L_0x00e9
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00e9:
            android.view.animation.Animation r1 = r1.getAnimation()
            r1.reset()
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 != 0) goto L_0x00f7
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00f7:
            r1.clearAnimation()
            com.meizu.media.camera.views.MzImageView r1 = r8.f11812D
            if (r1 != 0) goto L_0x0101
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0101:
            r1.setImageBitmap(r2)
            goto L_0x014e
        L_0x0105:
            com.meizu.media.camera.CameraSimplifyActivity r1 = r8.f11851h
            if (r1 != 0) goto L_0x010c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x010c:
            boolean r1 = r1.mo17773y()
            if (r1 == 0) goto L_0x014e
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            if (r1 == r3) goto L_0x014e
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            android.graphics.Bitmap r1 = r8.f11824P     // Catch:{ Exception -> 0x0141 }
            if (r1 == 0) goto L_0x0145
            android.graphics.Bitmap r1 = r8.f11824P     // Catch:{ Exception -> 0x0141 }
            if (r1 != 0) goto L_0x0127
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0141 }
        L_0x0127:
            boolean r1 = r1.isRecycled()     // Catch:{ Exception -> 0x0141 }
            if (r1 != 0) goto L_0x0145
            com.meizu.media.camera.CameraSimplifyActivity r1 = r8.f11851h     // Catch:{ Exception -> 0x0141 }
            if (r1 != 0) goto L_0x0134
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0141 }
        L_0x0134:
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x0141 }
            android.graphics.Bitmap r3 = r8.f11824P     // Catch:{ Exception -> 0x0141 }
            r4 = 1103626240(0x41c80000, float:25.0)
            android.graphics.Bitmap r1 = com.meizu.media.camera.animation.C1825q.m8250a(r1, r3, r4, r0)     // Catch:{ Exception -> 0x0141 }
            goto L_0x0146
        L_0x0141:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0145:
            r1 = r2
        L_0x0146:
            r2 = 1
            android.graphics.Bitmap[] r2 = new android.graphics.Bitmap[r2]
            r2[r0] = r1
            r8.mo21174a((android.graphics.Bitmap[]) r2)
        L_0x014e:
            com.meizu.media.camera.simplify.d$b r1 = new com.meizu.media.camera.simplify.d$b
            r1.<init>(r8, r0)
            java.lang.Void[] r0 = new java.lang.Void[r0]
            r1.execute(r0)
            com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = r8.f11866w
            if (r0 == 0) goto L_0x0166
            com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = r8.f11866w
            if (r0 != 0) goto L_0x0163
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0163:
            r0.mo14120l()
        L_0x0166:
            com.meizu.media.camera.util.ac$a r0 = f11807al
            java.lang.String r1 = "onPause end"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyCamUI.mo21206m():void");
    }

    /* renamed from: U */
    private final void m12945U() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5584, new Class[0], Void.TYPE).isSupported) {
            if (this.f11820L == 1) {
                z = true;
            }
            int i = 90;
            if (z) {
                i = -90;
            }
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.setSurfaceTextureBitmap(i);
            if (this.f11846c.width() == 0.0f || this.f11846c.height() == 0.0f) {
                LogUtil.m15949b(f11807al, "Not to getBitmap, width and height must be > 0");
                return;
            }
            CameraPreviewRenderView cameraPreviewRenderView2 = this.f11866w;
            if (cameraPreviewRenderView2 == null) {
                C3443i.m21151a();
            }
            float f = (float) 8;
            this.f11824P = cameraPreviewRenderView2.mo14099a((int) (this.f11846c.width() / f), (int) (this.f11846c.height() / f));
        }
    }

    /* renamed from: a */
    public final void mo21174a(@NotNull Bitmap... bitmapArr) {
        if (!PatchProxy.proxy(new Object[]{bitmapArr}, this, f11806a, false, 5585, new Class[]{Bitmap[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bitmapArr, "bitmaps");
            MzImageView mzImageView = this.f11812D;
            if (mzImageView == null) {
                C3443i.m21151a();
            }
            if (mzImageView.getVisibility() != 0) {
                if (bitmapArr.length > 0) {
                    Bitmap bitmap = bitmapArr[0];
                    if (bitmap != null && !bitmap.isRecycled()) {
                        m12967e(bitmap.getWidth(), bitmap.getHeight());
                        MzImageView mzImageView2 = this.f11812D;
                        if (mzImageView2 == null) {
                            C3443i.m21151a();
                        }
                        mzImageView2.clearAnimation();
                        MzImageView mzImageView3 = this.f11812D;
                        if (mzImageView3 == null) {
                            C3443i.m21151a();
                        }
                        mzImageView3.setAlpha(1.0f);
                        MzImageView mzImageView4 = this.f11812D;
                        if (mzImageView4 == null) {
                            C3443i.m21151a();
                        }
                        mzImageView4.setVisibility(0);
                        MzImageView mzImageView5 = this.f11812D;
                        if (mzImageView5 == null) {
                            C3443i.m21151a();
                        }
                        mzImageView5.setImageBitmap(bitmap);
                        LogUtil.m15942a(f11807al, "showFrameTransition with bitmap finish");
                        return;
                    }
                    return;
                }
                new C2324r(this).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J'\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0006\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0004¨\u0006\u000b"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$showFrameTransition$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/graphics/Bitmap;", "onPostExecute", "", "bitmap", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$r */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2324r extends AsyncTaskEx<Void, Void, Bitmap> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11912a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11913b;

        C2324r(MzSimplifyCamUI dVar) {
            this.f11913b = dVar;
        }

        @Nullable
        /* renamed from: a */
        public Bitmap mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11912a, false, 5679, new Class[]{Void[].class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            C3443i.m21155b(voidArr, "params");
            CameraSimplifyActivity a = this.f11913b.f11851h;
            if (a == null) {
                C3443i.m21151a();
            }
            File file = new File(a.getFilesDir(), "last_preview_file");
            if (!file.exists()) {
                return null;
            }
            LogUtil.m15942a(MzSimplifyCamUI.f11807al, "decodeFile start");
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), (BitmapFactory.Options) null);
            LogUtil.m15942a(MzSimplifyCamUI.f11807al, "decodeFile end");
            return decodeFile;
        }
    }

    /* renamed from: n */
    public final void mo21208n() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5586, new Class[0], Void.TYPE).isSupported) {
            if (CameraModeType.ModeType.FUNNY_SNAP != CameraModeType.m10946a()) {
                m12979q(true);
            }
            if (this.f11866w != null) {
                CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
                if (cameraPreviewRenderView == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView.mo14119k();
            }
            SwitchAnimManager.m8189a(true);
        }
    }

    /* renamed from: o */
    public final void mo21210o() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5587, new Class[0], Void.TYPE).isSupported) {
            EventBus.m21789a().mo27979c(this);
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.setSurfaceTextureListener((PreviewView.C1194c) null);
            mo21200j();
            if (this.f11867x != null) {
                TextureView textureView = this.f11867x;
                if (textureView == null) {
                    C3443i.m21151a();
                }
                textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
                this.f11867x = null;
            }
            MzSimplifyImageCaptureUI hVar = this.f11849f;
            if (hVar != null) {
                hVar.mo21292f();
            }
            Handler handler = this.f11845ak;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.f11817I = null;
            this.f11857n = null;
        }
    }

    /* renamed from: r */
    public final boolean mo21216r() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5588, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
        if (mzSimplifyCamModule == null) {
            C3443i.m21151a();
        }
        if (!mzSimplifyCamModule.mo18350A()) {
            return false;
        }
        MzSimplifyCamModule mzSimplifyCamModule2 = this.f11852i;
        if (mzSimplifyCamModule2 == null) {
            C3443i.m21151a();
        }
        mzSimplifyCamModule2.mo18368S();
        return true;
    }

    /* renamed from: a */
    public final void mo21161a(int i, boolean z) {
        FaceView faceView;
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5589, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && (faceView = this.f11857n) != null) {
            faceView.mo22844b();
            faceView.setVisibility(0);
            faceView.setDisplayOrientation(i);
            faceView.setMirror(z);
            faceView.mo22847d();
            this.f11831W = false;
        }
    }

    /* renamed from: a */
    public void mo14347a(@NotNull SurfaceTexture surfaceTexture, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{surfaceTexture, new Integer(i), new Integer(i2)}, this, f11806a, false, 5590, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(surfaceTexture, "surface");
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15952c(aVar, "SurfaceTexture ready:" + surfaceTexture + "context:" + this.f11851h);
            this.f11854k = surfaceTexture;
            SurfaceTexture surfaceTexture2 = this.f11854k;
            if (surfaceTexture2 != null) {
                surfaceTexture2.setOnFrameAvailableListener(this);
            }
            if (this.f11845ak == null || this.f11851h == null) {
                LogUtil.m15949b(f11807al, "onSurfaceTextureAvailable:Activity has been destroy,no need to update UI");
            } else {
                this.f11851h.runOnUiThread(new C2320n(this));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo27294d2 = {"<anonymous>", "", "run", "com/meizu/media/camera/simplify/MzSimplifyCamUI$onSurfaceTextureAvailable$1$1"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$n */
    /* compiled from: MzSimplifyCamUI.kt */
    static final class C2320n implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11904a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11905b;

        C2320n(MzSimplifyCamUI dVar) {
            this.f11905b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11904a, false, 5672, new Class[0], Void.TYPE).isSupported && this.f11905b.f11852i != null) {
                this.f11905b.f11852i.mo18355F();
                if (!(this.f11905b.f11859p == 0 || this.f11905b.f11860q == 0)) {
                    this.f11905b.m12965d(this.f11905b.f11859p, this.f11905b.f11860q);
                }
                this.f11905b.f11852i.mo18414aJ();
                if (this.f11905b.f11852i.mo18472f()) {
                    LogUtil.m15952c(MzSimplifyCamUI.f11807al, "isFBOn");
                    CameraPreviewRenderView d = this.f11905b.f11866w;
                    if (d == null) {
                        C3443i.m21151a();
                    }
                    d.setVfbRenderType("Mzvfacebeauty");
                    CameraPreviewRenderView d2 = this.f11905b.f11866w;
                    if (d2 == null) {
                        C3443i.m21151a();
                    }
                    d2.setRenderType("Mznone");
                    return;
                }
                this.f11905b.mo21171a("Mznone");
            }
        }
    }

    /* renamed from: a */
    public boolean mo14348a(@Nullable SurfaceTexture surfaceTexture) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTexture}, this, f11806a, false, 5591, new Class[]{SurfaceTexture.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f11807al;
        LogUtil.m15952c(aVar, "SurfaceTexture destroyed:" + this.f11854k + "context:" + this.f11851h);
        if (this.f11854k != null) {
            SurfaceTexture surfaceTexture2 = this.f11854k;
            if (surfaceTexture2 == null) {
                C3443i.m21151a();
            }
            surfaceTexture2.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.f11854k = null;
        }
        MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
        if (mzSimplifyCamModule == null) {
            C3443i.m21151a();
        }
        mzSimplifyCamModule.mo18356G();
        MzSimplifyCamModule mzSimplifyCamModule2 = this.f11852i;
        if (mzSimplifyCamModule2 == null) {
            C3443i.m21151a();
        }
        mzSimplifyCamModule2.mo18413aI();
        LogUtil.m15952c(f11807al, "SurfaceTexture destroyed");
        SurfaceTextureBitmap.m6368a(false);
        return true;
    }

    /* renamed from: c */
    public boolean mo14351c(@Nullable SurfaceTexture surfaceTexture) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTexture}, this, f11806a, false, 5592, new Class[]{SurfaceTexture.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f11807al;
        LogUtil.m15952c(aVar, "SurfaceTexture release:" + this.f11854k + "context:" + this.f11851h);
        if (this.f11854k != null) {
            SurfaceTexture surfaceTexture2 = this.f11854k;
            if (surfaceTexture2 == null) {
                C3443i.m21151a();
            }
            surfaceTexture2.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.f11854k = null;
        }
        MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
        if (mzSimplifyCamModule == null) {
            C3443i.m21151a();
        }
        mzSimplifyCamModule.mo18413aI();
        SurfaceTextureBitmap.m6368a(false);
        this.f11826R = true;
        EffectRenderContext h = EffectRenderContext.m4369h();
        C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
        h.mo14227l(true);
        return true;
    }

    /* renamed from: b */
    public void mo14349b(@Nullable SurfaceTexture surfaceTexture) {
        if (!PatchProxy.proxy(new Object[]{surfaceTexture}, this, f11806a, false, 5593, new Class[]{SurfaceTexture.class}, Void.TYPE).isSupported) {
            if (surfaceTexture != null && this.f11813E) {
                this.f11813E = false;
                MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
                if (mzSimplifyCamModule == null) {
                    C3443i.m21151a();
                }
                mzSimplifyCamModule.mo18415aK();
            }
            SurfaceTextureBitmap.m6368a(true);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "it", "Lcom/meizu/imageproc/SurfaceTextureWrapper;", "kotlin.jvm.PlatformType", "onFrameAvailable"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$p */
    /* compiled from: MzSimplifyCamUI.kt */
    static final class C2322p implements SurfaceTextureWrapper.C1568a {

        /* renamed from: a */
        public static ChangeQuickRedirect f11908a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11909b;

        C2322p(MzSimplifyCamUI dVar) {
            this.f11909b = dVar;
        }

        /* renamed from: a */
        public final void mo17626a(SurfaceTextureWrapper surfaceTextureWrapper) {
            if (!PatchProxy.proxy(new Object[]{surfaceTextureWrapper}, this, f11908a, false, 5674, new Class[]{SurfaceTextureWrapper.class}, Void.TYPE).isSupported) {
                this.f11909b.mo21148J();
            }
        }
    }

    /* renamed from: a */
    public void mo14352a(@NotNull SurfaceTextureWrapper surfaceTextureWrapper, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{surfaceTextureWrapper, new Integer(i), new Integer(i2)}, this, f11806a, false, 5594, new Class[]{SurfaceTextureWrapper.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(surfaceTextureWrapper, "surfaceTexture");
            this.f11855l = surfaceTextureWrapper;
            SurfaceTextureWrapper surfaceTextureWrapper2 = this.f11855l;
            if (surfaceTextureWrapper2 == null) {
                C3443i.m21151a();
            }
            surfaceTextureWrapper2.setOnFrameAvailableListener(new C2322p(this));
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15952c(aVar, "mSurfaceTextureWrapper ready:" + this.f11855l + "context:" + this.f11851h);
            if (this.f11845ak == null || this.f11851h == null) {
                LogUtil.m15949b(f11807al, "onSurfaceTextureAvailable:Activity has been destroy,no need to update UI");
            } else {
                this.f11851h.runOnUiThread(new C2321o(this));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo27294d2 = {"<anonymous>", "", "run", "com/meizu/media/camera/simplify/MzSimplifyCamUI$onSurfaceTextureWrapperAvailable$2$1"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$o */
    /* compiled from: MzSimplifyCamUI.kt */
    static final class C2321o implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11906a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11907b;

        C2321o(MzSimplifyCamUI dVar) {
            this.f11907b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11906a, false, 5673, new Class[0], Void.TYPE).isSupported && this.f11907b.f11852i != null) {
                this.f11907b.f11852i.mo18355F();
                if (!(this.f11907b.f11859p == 0 || this.f11907b.f11860q == 0)) {
                    this.f11907b.m12965d(this.f11907b.f11859p, this.f11907b.f11860q);
                }
                this.f11907b.f11852i.mo18414aJ();
                if (this.f11907b.f11852i.mo18472f()) {
                    LogUtil.m15952c(MzSimplifyCamUI.f11807al, "isFBOn");
                    CameraPreviewRenderView d = this.f11907b.f11866w;
                    if (d == null) {
                        C3443i.m21151a();
                    }
                    d.setVfbRenderType("Mzvfacebeauty");
                    CameraPreviewRenderView d2 = this.f11907b.f11866w;
                    if (d2 == null) {
                        C3443i.m21151a();
                    }
                    d2.setRenderType("Mznone");
                    return;
                }
                this.f11907b.mo21171a("Mznone");
            }
        }
    }

    /* renamed from: a */
    public boolean mo14353a(@Nullable SurfaceTextureWrapper surfaceTextureWrapper) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTextureWrapper}, this, f11806a, false, 5595, new Class[]{SurfaceTextureWrapper.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f11807al;
        LogUtil.m15952c(aVar, "mSurfaceTextureWrapper destroyed:" + this.f11855l + "context:" + this.f11851h);
        if (this.f11855l != null) {
            SurfaceTextureWrapper surfaceTextureWrapper2 = this.f11855l;
            if (surfaceTextureWrapper2 == null) {
                C3443i.m21151a();
            }
            surfaceTextureWrapper2.setOnFrameAvailableListener((SurfaceTextureWrapper.C1568a) null);
            this.f11855l = null;
        }
        MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
        if (mzSimplifyCamModule == null) {
            C3443i.m21151a();
        }
        mzSimplifyCamModule.mo18356G();
        MzSimplifyCamModule mzSimplifyCamModule2 = this.f11852i;
        if (mzSimplifyCamModule2 == null) {
            C3443i.m21151a();
        }
        mzSimplifyCamModule2.mo18413aI();
        LogUtil.m15952c(f11807al, "SurfaceTexture destroyed");
        SurfaceTextureBitmap.m6368a(false);
        return true;
    }

    /* renamed from: c */
    public void mo14356c(@Nullable SurfaceTextureWrapper surfaceTextureWrapper) {
        if (!PatchProxy.proxy(new Object[]{surfaceTextureWrapper}, this, f11806a, false, 5596, new Class[]{SurfaceTextureWrapper.class}, Void.TYPE).isSupported) {
            if (surfaceTextureWrapper != null && this.f11813E) {
                this.f11813E = false;
                MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
                if (mzSimplifyCamModule == null) {
                    C3443i.m21151a();
                }
                mzSimplifyCamModule.mo18415aK();
            }
            SurfaceTextureBitmap.m6368a(true);
        }
    }

    /* renamed from: b */
    public boolean mo14355b(@Nullable SurfaceTextureWrapper surfaceTextureWrapper) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTextureWrapper}, this, f11806a, false, 5597, new Class[]{SurfaceTextureWrapper.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f11807al;
        LogUtil.m15952c(aVar, "SurfaceTextureWrapper release:" + this.f11854k + "context:" + this.f11851h);
        if (this.f11854k != null) {
            SurfaceTexture surfaceTexture = this.f11854k;
            if (surfaceTexture == null) {
                C3443i.m21151a();
            }
            surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.f11854k = null;
        }
        MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
        if (mzSimplifyCamModule == null) {
            C3443i.m21151a();
        }
        mzSimplifyCamModule.mo18413aI();
        SurfaceTextureBitmap.m6368a(false);
        this.f11826R = true;
        EffectRenderContext h = EffectRenderContext.m4369h();
        C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
        h.mo14227l(true);
        return true;
    }

    /* renamed from: s */
    public boolean mo21218s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5598, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        FaceView faceView = this.f11857n;
        if (faceView != null) {
            return faceView.mo22843a();
        }
        return false;
    }

    /* renamed from: t */
    public void mo21219t() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5599, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11807al, "clearFocus");
            FocusIndicator T = m12944T();
            if (T != null) {
                T.mo22844b();
            }
        }
    }

    /* renamed from: a */
    public void mo21159a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5600, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported || this.f11818J == null) {
            return;
        }
        if (i == -1 && i2 == -1) {
            MzFocusRenderer gVar = this.f11818J;
            if (gVar == null) {
                C3443i.m21151a();
            }
            gVar.mo23327a((int) this.f11846c.centerX(), (int) this.f11846c.centerY(), this.f11846c, this.f11847d);
            return;
        }
        MzFocusRenderer gVar2 = this.f11818J;
        if (gVar2 == null) {
            C3443i.m21151a();
        }
        gVar2.mo23327a(i, i2, this.f11846c, this.f11847d);
    }

    /* renamed from: f */
    public void mo21193f(boolean z) {
        MzFocusRenderer gVar;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5601, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (gVar = this.f11818J) != null) {
            gVar.mo23334c(z);
        }
    }

    /* renamed from: g */
    public void mo21195g(boolean z) {
        MzFocusRenderer gVar;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5602, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (gVar = this.f11818J) != null) {
            gVar.mo23336d(z);
        }
    }

    /* renamed from: h */
    public void mo21197h(boolean z) {
        MzFocusRenderer gVar;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5603, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (gVar = this.f11818J) != null) {
            gVar.mo23338e(z);
        }
    }

    /* renamed from: b */
    public final boolean mo21183b(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f11806a, false, 5605, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f11847d.contains((float) i, (float) i2);
    }

    /* renamed from: u */
    public void mo21220u() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5606, new Class[0], Void.TYPE).isSupported && mo21145G() != null) {
            MzFocusRenderer G = mo21145G();
            if (G == null) {
                C3443i.m21151a();
            }
            RectF rectF = this.f11846c;
            if (this.f11820L == 1) {
                z = true;
            }
            G.mo23328a(rectF, z);
        }
    }

    /* renamed from: a */
    public void mo21162a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5607, new Class[]{Long.TYPE}, Void.TYPE).isSupported && m12944T() != null) {
            FocusIndicator T = m12944T();
            if (T == null) {
                C3443i.m21151a();
            }
            T.mo22840a(j);
        }
    }

    /* renamed from: i */
    public void mo21199i(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5608, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && m12944T() != null) {
            FocusIndicator T = m12944T();
            if (T == null) {
                C3443i.m21151a();
            }
            T.mo22842a(z);
        }
    }

    /* renamed from: j */
    public void mo21201j(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5609, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && m12944T() != null) {
            FocusIndicator T = m12944T();
            if (T == null) {
                C3443i.m21151a();
            }
            T.mo22845b(z);
        }
    }

    /* renamed from: a */
    public void mo21170a(@Nullable MzFocusRenderer.C2743b bVar) {
        MzFocusRenderer gVar;
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f11806a, false, 5610, new Class[]{MzFocusRenderer.C2743b.class}, Void.TYPE).isSupported && (gVar = this.f11818J) != null) {
            gVar.mo23330a(bVar);
        }
    }

    /* renamed from: v */
    public void mo21221v() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5611, new Class[0], Void.TYPE).isSupported && this.f11857n != null) {
            this.f11831W = true;
            FaceView faceView = this.f11857n;
            if (faceView == null) {
                C3443i.m21151a();
            }
            faceView.mo22846c();
        }
    }

    /* renamed from: w */
    public void mo21222w() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5612, new Class[0], Void.TYPE).isSupported && this.f11857n != null) {
            this.f11831W = false;
            FaceView faceView = this.f11857n;
            if (faceView == null) {
                C3443i.m21151a();
            }
            faceView.mo22847d();
        }
    }

    /* renamed from: b */
    public void mo21179b(@Nullable View view, int i, int i2, boolean z) {
        Object[] objArr = {view, new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5613, new Class[]{View.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f11852i != null && !this.f11852i.mo18402a(i, i2)) {
            float f = (float) i;
            float f2 = (float) i2;
            if (this.f11846c.contains(f, f2)) {
                if (!this.f11848e.contains(f, f2)) {
                    LogUtil.m15942a(f11807al, "it doesn't need to take picture after focus, since the position is not in the FocusTakePictureRect");
                    z = false;
                }
                this.f11852i.mo18388a(view, i, i2, z);
            }
        }
    }

    /* renamed from: a */
    public void mo21164a(@Nullable View view, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i), new Integer(i2)}, this, f11806a, false, 5614, new Class[]{View.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
            if (mzSimplifyCamModule == null) {
                C3443i.m21151a();
            }
            mzSimplifyCamModule.mo18387a(view, i, i2);
        }
    }

    /* renamed from: a */
    public void mo21163a(@Nullable MotionEvent motionEvent) {
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f11806a, false, 5615, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
            if (mzSimplifyCamModule == null) {
                C3443i.m21151a();
            }
            mzSimplifyCamModule.mo18386a(motionEvent);
        }
    }

    /* renamed from: x */
    public void mo21223x() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5616, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11807al, "Device flip detected.");
            MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
            if (mzSimplifyCamModule == null) {
                C3443i.m21151a();
            }
            mzSimplifyCamModule.mo18372W();
        }
    }

    /* renamed from: a */
    public void mo19552a(@Nullable CameraController.C1880f<?>[] fVarArr, @Nullable CameraProxy<?> dVar) {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{fVarArr, dVar}, this, f11806a, false, 5617, new Class[]{CameraController.C1880f[].class, CameraProxy.class}, Void.TYPE).isSupported) {
            if (!(this.f11844aj == 0 && (fVarArr == null || fVarArr.length == 0)) && (fVarArr == null || fVarArr.length != this.f11844aj)) {
                z = true;
            }
            if (z) {
                LogUtil.C2630a aVar = f11807al;
                StringBuilder sb = new StringBuilder();
                sb.append("onFaceDetection faces:");
                sb.append(fVarArr != null ? Integer.valueOf(fVarArr.length) : fVarArr);
                LogUtil.m15942a(aVar, sb.toString());
            }
            if (CameraModeType.m10946a() != CameraModeType.ModeType.FUNNY_SNAP) {
                if (!this.f11832X || CameraModeType.m10946a() != CameraModeType.ModeType.VIDEO) {
                    MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
                    if (mzSimplifyCamModule == null) {
                        C3443i.m21151a();
                    }
                    if (mzSimplifyCamModule.mo18418aN() == 1 && this.f11852i != null) {
                        this.f11852i.mo18400a(fVarArr);
                        return;
                    }
                    return;
                }
                FaceView faceView = this.f11857n;
                if (faceView != null) {
                    faceView.mo22844b();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo19551a(@Nullable Rect rect, float f) {
        if (!PatchProxy.proxy(new Object[]{rect, new Float(f)}, this, f11806a, false, 5618, new Class[]{Rect.class, Float.TYPE}, Void.TYPE).isSupported) {
            FaceView faceView = this.f11857n;
            if (faceView != null) {
                faceView.mo22841a(rect, f);
            }
            if (this.f11852i != null) {
                MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
                if (rect == null) {
                    C3443i.m21151a();
                }
                mzSimplifyCamModule.mo18384a(rect);
            }
        }
    }

    /* renamed from: y */
    public final int mo21224y() {
        return this.f11844aj;
    }

    @Nullable
    /* renamed from: z */
    public final MzSimplifyImageCaptureUI mo21225z() {
        return this.f11849f;
    }

    @Nullable
    /* renamed from: A */
    public final CameraPreviewRenderView mo21139A() {
        return this.f11866w;
    }

    @Nullable
    /* renamed from: B */
    public final MzSimplifyVideoUI mo21140B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5619, new Class[0], MzSimplifyVideoUI.class);
        if (proxy.isSupported) {
            return (MzSimplifyVideoUI) proxy.result;
        }
        if (this.f11850g == null) {
            CameraSimplifyBinding cameraSimplifyBinding = this.f11853j;
            if (cameraSimplifyBinding == null) {
                C3443i.m21151a();
            }
            View root = cameraSimplifyBinding.getRoot();
            CameraSimplifyActivity cameraSimplifyActivity = this.f11851h;
            if (cameraSimplifyActivity == null) {
                C3443i.m21151a();
            }
            this.f11850g = new MzSimplifyVideoUI(root, cameraSimplifyActivity.mo17639f());
        }
        return this.f11850g;
    }

    /* renamed from: c */
    public final void mo21185c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5620, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i == this.f11811C) {
                System.currentTimeMillis();
                long j = this.f11810B;
            } else {
                this.f11811C = i;
                this.f11810B = System.currentTimeMillis();
            }
            MzFocusRenderer gVar = this.f11818J;
            if (gVar != null) {
                gVar.setOrientation(i, true);
            }
        }
    }

    /* renamed from: C */
    public final void mo21141C() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5621, new Class[0], Void.TYPE).isSupported) {
            m12980r(false);
        }
    }

    /* renamed from: r */
    private final void m12980r(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5622, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!this.f11822N) {
                if (this.f11828T != null) {
                    ValueAnimator valueAnimator = this.f11828T;
                    if (valueAnimator == null) {
                        C3443i.m21151a();
                    }
                    if (valueAnimator.isRunning() && !z) {
                        return;
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) this.f11846c.height());
                layoutParams.topMargin = (int) this.f11846c.top;
                layoutParams.gravity = 48;
                MzImageView mzImageView = this.f11812D;
                if (mzImageView == null) {
                    C3443i.m21151a();
                }
                mzImageView.setLayoutParams(layoutParams);
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            MzImageView mzImageView2 = this.f11812D;
            if (mzImageView2 == null) {
                C3443i.m21151a();
            }
            mzImageView2.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: e */
    private final void m12967e(int i, int i2) {
        int i3;
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f11806a, false, 5623, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            float f = ((float) i2) / ((float) i);
            boolean z2 = ((double) Math.abs(f - (((float) CameraUtil.m15865b()) / ((float) CameraUtil.m15809a())))) < 0.012d;
            boolean z3 = ((double) Math.abs(f - 1.7777778f)) < 0.012d;
            boolean z4 = i == i2 && CameraModeType.m10946a() == CameraModeType.ModeType.SQUARE;
            if ((!DeviceHelper.f13874aa || !z2) && (DeviceHelper.f13874aa || !z3)) {
                z = false;
            }
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15942a(aVar, "updateAnimViewLayoutByBitmapSize width:" + i + "  height:" + i2);
            LogUtil.C2630a aVar2 = f11807al;
            StringBuilder sb = new StringBuilder();
            sb.append("updateAnimViewLayoutByBitmapSize isFullScreen:");
            sb.append(z);
            LogUtil.m15942a(aVar2, sb.toString());
            if (z) {
                i3 = -1;
            } else if (DeviceHelper.f13874aa) {
                i3 = z3 ? (int) ((((float) CameraUtil.m15809a()) / ((float) 9)) * ((float) 16)) : z4 ? CameraUtil.m15809a() : (int) ((((float) CameraUtil.m15809a()) / ((float) 3)) * ((float) 4));
            } else {
                i3 = z4 ? CameraUtil.m15809a() : (int) ((((float) CameraUtil.m15809a()) / ((float) 3)) * ((float) 4));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
            if (z4) {
                layoutParams.topMargin = CameraUtil.m15904j();
                layoutParams.gravity = 48;
            } else if (!z) {
                if ((NavigationBarUtils.m15972a() || CameraModeType.m10983m(CameraModeType.ModeType.MANUAL)) && !DeviceHelper.f13874aa) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.f11815G;
                }
                layoutParams.gravity = 48;
            }
            MzImageView mzImageView = this.f11812D;
            if (mzImageView == null) {
                C3443i.m21151a();
            }
            mzImageView.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: k */
    public final void mo21203k(boolean z) {
        this.f11822N = z;
    }

    /* renamed from: a */
    public final boolean mo21175a(@Nullable Animation.AnimationListener animationListener, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{animationListener, new Byte(z ? (byte) 1 : 0)}, this, f11806a, false, 5624, new Class[]{Animation.AnimationListener.class, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11825Q) {
            MzImageView mzImageView = this.f11812D;
            if (mzImageView == null) {
                C3443i.m21151a();
            }
            if (mzImageView.getVisibility() == 0) {
                LogUtil.m15952c(f11807al, "not need to do animateSwitchCamera");
                this.f11825Q = false;
                return false;
            }
        }
        this.f11813E = true;
        if (this.f11834Z != animationListener) {
            this.f11834Z = animationListener;
        }
        Animation.AnimationListener animationListener2 = null;
        SwitchAnimManager.m8189a(true);
        MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
        if (mzSimplifyCamModule == null) {
            C3443i.m21151a();
        }
        new C2312f(this, z, mzSimplifyCamModule.mo18472f(), animationListener2, animationListener).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        return true;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J'\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0006\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\u000b"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$animateSwitchCamera$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/graphics/Bitmap;", "onPostExecute", "", "bitmap", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$f */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2312f extends AsyncTaskEx<Void, Void, Bitmap> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11885a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11886b;

        /* renamed from: c */
        final /* synthetic */ boolean f11887c;

        /* renamed from: d */
        final /* synthetic */ boolean f11888d;

        /* renamed from: e */
        final /* synthetic */ Animation.AnimationListener f11889e;

        /* renamed from: f */
        final /* synthetic */ Animation.AnimationListener f11890f;

        C2312f(MzSimplifyCamUI dVar, boolean z, boolean z2, Animation.AnimationListener animationListener, Animation.AnimationListener animationListener2) {
            this.f11886b = dVar;
            this.f11887c = z;
            this.f11888d = z2;
            this.f11889e = animationListener;
            this.f11890f = animationListener2;
        }

        @Nullable
        /* renamed from: a */
        public Bitmap mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11885a, false, 5659, new Class[]{Void[].class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            C3443i.m21155b(voidArr, "params");
            Bitmap a = this.f11886b.m12948a(this.f11887c, this.f11888d);
            if (a == null) {
                C3443i.m21151a();
            }
            return a;
        }

        /* renamed from: a */
        public void mo17660a(@Nullable Bitmap bitmap) {
            if (!PatchProxy.proxy(new Object[]{bitmap}, this, f11885a, false, 5660, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                if (this.f11886b.f11827S != null) {
                    Bitmap i = this.f11886b.f11827S;
                    if (i == null) {
                        C3443i.m21151a();
                    }
                    if (!i.isRecycled()) {
                        Bitmap i2 = this.f11886b.f11827S;
                        if (i2 == null) {
                            C3443i.m21151a();
                        }
                        i2.recycle();
                    }
                }
                this.f11886b.f11827S = bitmap;
                this.f11886b.mo21141C();
                SwitchAnimManager.m8193a((View) this.f11886b.f11812D, (PreviewView) this.f11886b.f11866w, (View) null, (ViewGroup) null, this.f11886b.f11846c.centerX(), this.f11886b.f11846c.centerY(), this.f11889e, this.f11890f, this.f11886b.f11827S);
            }
        }
    }

    /* renamed from: D */
    public final void mo21142D() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5625, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11807al, "onSwitchCameraAnimEnd mSwitchAnimView.setVisibility(View.GONE)");
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.setViewAlpha(1.0f);
            MzImageView mzImageView = this.f11812D;
            if (mzImageView == null) {
                C3443i.m21151a();
            }
            mzImageView.setAlpha(1.0f);
            MzImageView mzImageView2 = this.f11812D;
            if (mzImageView2 == null) {
                C3443i.m21151a();
            }
            mzImageView2.setVisibility(8);
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            h.mo14186a(false);
            EffectRenderContext h2 = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
            h2.mo14215g(false);
            mo21147I().mo14122m();
        }
    }

    /* renamed from: E */
    public final int mo21143E() {
        return this.f11859p;
    }

    /* renamed from: F */
    public final int mo21144F() {
        return this.f11860q;
    }

    @Nullable
    /* renamed from: G */
    public final MzFocusRenderer mo21145G() {
        return this.f11818J;
    }

    /* renamed from: c */
    public final void mo21186c(int i, int i2) {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f11806a, false, 5626, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                z = true;
            }
            cameraPreviewRenderView.setSurfaceTextureBitmap(i, i2, z);
        }
    }

    /* renamed from: a */
    public final void mo21160a(int i, int i2, boolean z) {
        boolean z2 = false;
        Object[] objArr = {new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5627, new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                z2 = true;
            }
            cameraPreviewRenderView.setSurfaceTextureBitmap(i, i2, z, z2);
        }
    }

    @Nullable
    /* renamed from: H */
    public final Bitmap mo21146H() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5628, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (this.f11866w == null) {
            return null;
        }
        CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
        if (cameraPreviewRenderView == null) {
            C3443i.m21151a();
        }
        return cameraPreviewRenderView.getPreviewBitmap();
    }

    @NotNull
    /* renamed from: I */
    public final CameraPreviewRenderView mo21147I() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11806a, false, 5629, new Class[0], CameraPreviewRenderView.class);
        if (proxy.isSupported) {
            return (CameraPreviewRenderView) proxy.result;
        }
        CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
        if (cameraPreviewRenderView == null) {
            C3443i.m21151a();
        }
        return cameraPreviewRenderView;
    }

    /* renamed from: l */
    public final void mo21205l(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5630, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f11821M != z && z) {
                CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
                if (cameraPreviewRenderView == null) {
                    C3443i.m21151a();
                }
                cameraPreviewRenderView.mo14122m();
            }
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            h.mo14222j(z);
            this.f11821M = z;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$doFrameAvailable$1", "Ljava/lang/Runnable;", "run", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$g */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2313g implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11891a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11892b;

        C2313g(MzSimplifyCamUI dVar) {
            this.f11892b = dVar;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11891a, false, 5661, new Class[0], Void.TYPE).isSupported && this.f11892b.f11852i != null) {
                if (!(!this.f11892b.f11825Q || this.f11892b.f11859p == 0 || this.f11892b.f11860q == 0)) {
                    this.f11892b.m12965d(this.f11892b.f11859p, this.f11892b.f11860q);
                }
                if (this.f11892b.f11825Q && this.f11892b.f11852i.mo18476h() == MzSimplifyCamController.ModuleState.IDLE) {
                    LogUtil.m15942a(MzSimplifyCamUI.f11807al, "first frame come");
                    this.f11892b.m12943S();
                    this.f11892b.f11825Q = false;
                }
                if (!(this.f11892b.f11852i == null || CameraModeType.ModeType.FUNNY_SNAP == CameraModeType.m10946a())) {
                    this.f11892b.f11852i.mo18375Z();
                }
                CameraPreviewRenderView d = this.f11892b.f11866w;
                if (d == null) {
                    C3443i.m21151a();
                }
                d.mo14122m();
            }
        }
    }

    /* renamed from: J */
    public final void mo21148J() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5631, new Class[0], Void.TYPE).isSupported) {
            Handler handler = this.f11845ak;
            if (handler != null) {
                handler.post(new C2313g(this));
            } else {
                LogUtil.m15942a(f11807al, "onFrameAvailable:Activity has been destroy,no need to update UI");
            }
        }
    }

    public void onFrameAvailable(@Nullable SurfaceTexture surfaceTexture) {
        if (!PatchProxy.proxy(new Object[]{surfaceTexture}, this, f11806a, false, 5632, new Class[]{SurfaceTexture.class}, Void.TYPE).isSupported) {
            mo21148J();
        }
    }

    /* renamed from: m */
    public final void mo21207m(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11806a, false, 5634, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f11807al, "showSlidingAnimView");
            MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
            if (mzSimplifyCamModule == null) {
                C3443i.m21151a();
            }
            boolean f = mzSimplifyCamModule.mo18472f();
            MzImageView mzImageView = this.f11812D;
            if (mzImageView == null) {
                C3443i.m21151a();
            }
            if (mzImageView.getVisibility() != 0) {
                new C2326t(this, z, f).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J'\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0006\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\u000b"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$showSlidingAnimView$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "doInBackground", "voids", "", "([Ljava/lang/Void;)Landroid/graphics/Bitmap;", "onPostExecute", "", "bitmap", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$t */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2326t extends AsyncTaskEx<Void, Void, Bitmap> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11916a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11917b;

        /* renamed from: c */
        final /* synthetic */ boolean f11918c;

        /* renamed from: d */
        final /* synthetic */ boolean f11919d;

        C2326t(MzSimplifyCamUI dVar, boolean z, boolean z2) {
            this.f11917b = dVar;
            this.f11918c = z;
            this.f11919d = z2;
        }

        @Nullable
        /* renamed from: a */
        public Bitmap mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11916a, false, 5683, new Class[]{Void[].class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            C3443i.m21155b(voidArr, "voids");
            Bitmap a = this.f11917b.m12948a(this.f11918c, this.f11919d);
            if (a == null) {
                C3443i.m21151a();
            }
            return a;
        }

        /* renamed from: a */
        public void mo17660a(@Nullable Bitmap bitmap) {
            if (!PatchProxy.proxy(new Object[]{bitmap}, this, f11916a, false, 5684, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                if (this.f11917b.f11827S != null) {
                    Bitmap i = this.f11917b.f11827S;
                    if (i == null) {
                        C3443i.m21151a();
                    }
                    if (!i.isRecycled()) {
                        Bitmap i2 = this.f11917b.f11827S;
                        if (i2 == null) {
                            C3443i.m21151a();
                        }
                        i2.recycle();
                    }
                }
                this.f11917b.f11827S = bitmap;
                this.f11917b.mo21141C();
                MzImageView e = this.f11917b.f11812D;
                if (e == null) {
                    C3443i.m21151a();
                }
                e.setImageBitmap(this.f11917b.f11827S);
                MzImageView e2 = this.f11917b.f11812D;
                if (e2 == null) {
                    C3443i.m21151a();
                }
                e2.setVisibility(0);
            }
        }
    }

    /* renamed from: K */
    public final void mo21149K() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5635, new Class[0], Void.TYPE).isSupported) {
            MzImageView mzImageView = this.f11812D;
            if (mzImageView == null) {
                C3443i.m21151a();
            }
            mzImageView.setVisibility(8);
        }
    }

    /* renamed from: b */
    public final void mo21180b(@Nullable Animation.AnimationListener animationListener, boolean z) {
        Object[] objArr = {animationListener, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5636, new Class[]{Animation.AnimationListener.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15942a(aVar, "animateSlidingModeIn start isFunny:" + z);
            if (this.f11833Y != animationListener) {
                this.f11833Y = animationListener;
            }
            if (SwitchAnimManager.m8191a((View) this.f11812D)) {
                float f = (float) 8;
                float f2 = (float) 0;
                if (this.f11846c.width() / f <= f2 || this.f11846c.height() / f <= f2) {
                    Handler handler = this.f11845ak;
                    if (handler != null) {
                        handler.postDelayed(new C2310d(animationListener), 50);
                        return;
                    }
                    return;
                }
                MzSimplifyCamModule mzSimplifyCamModule = this.f11852i;
                if (mzSimplifyCamModule == null) {
                    C3443i.m21151a();
                }
                new C2308c(this, z, mzSimplifyCamModule.mo18472f(), animationListener).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
                return;
            }
            Handler handler2 = this.f11845ak;
            if (handler2 != null) {
                handler2.postDelayed(new C2311e(animationListener), 50);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J'\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0006\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014¨\u0006\f"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$animateSlidingModeIn$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/graphics/Bitmap;", "onPostExecute", "", "bitmap", "onPreExecute", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$c */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2308c extends AsyncTaskEx<Void, Void, Bitmap> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11874a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11875b;

        /* renamed from: c */
        final /* synthetic */ boolean f11876c;

        /* renamed from: d */
        final /* synthetic */ boolean f11877d;

        /* renamed from: e */
        final /* synthetic */ Animation.AnimationListener f11878e;

        /* renamed from: a */
        public void mo19181a() {
        }

        C2308c(MzSimplifyCamUI dVar, boolean z, boolean z2, Animation.AnimationListener animationListener) {
            this.f11875b = dVar;
            this.f11876c = z;
            this.f11877d = z2;
            this.f11878e = animationListener;
        }

        @Nullable
        /* renamed from: a */
        public Bitmap mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11874a, false, 5654, new Class[]{Void[].class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            C3443i.m21155b(voidArr, "params");
            Bitmap a = this.f11875b.m12948a(this.f11876c, this.f11877d);
            if (a == null) {
                C3443i.m21151a();
            }
            return a;
        }

        /* renamed from: a */
        public void mo17660a(@Nullable Bitmap bitmap) {
            if (!PatchProxy.proxy(new Object[]{bitmap}, this, f11874a, false, 5655, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                if (SwitchAnimManager.m8191a((View) this.f11875b.f11812D)) {
                    if (!SwitchAnimManager.m8190a() && this.f11875b.f11827S != null) {
                        Bitmap i = this.f11875b.f11827S;
                        if (i == null) {
                            C3443i.m21151a();
                        }
                        if (!i.isRecycled()) {
                            Bitmap i2 = this.f11875b.f11827S;
                            if (i2 == null) {
                                C3443i.m21151a();
                            }
                            i2.recycle();
                        }
                    }
                    this.f11875b.f11827S = bitmap;
                    this.f11875b.mo21141C();
                    SwitchAnimManager.m8192a(this.f11875b.f11812D, 160, this.f11878e, this.f11875b.f11827S);
                    return;
                }
                Handler l = this.f11875b.f11845ak;
                if (l != null) {
                    l.postDelayed(new C2309a(this), 50);
                }
            }
        }

        @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$animateSlidingModeIn$1$onPostExecute$1", "Ljava/lang/Runnable;", "run", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
        /* renamed from: com.meizu.media.camera.simplify.d$c$a */
        /* compiled from: MzSimplifyCamUI.kt */
        public static final class C2309a implements Runnable {

            /* renamed from: a */
            public static ChangeQuickRedirect f11879a;

            /* renamed from: b */
            final /* synthetic */ C2308c f11880b;

            C2309a(C2308c cVar) {
                this.f11880b = cVar;
            }

            public void run() {
                Animation.AnimationListener animationListener;
                if (!PatchProxy.proxy(new Object[0], this, f11879a, false, 5656, new Class[0], Void.TYPE).isSupported && (animationListener = this.f11880b.f11878e) != null) {
                    animationListener.onAnimationEnd((Animation) null);
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$animateSlidingModeIn$2", "Ljava/lang/Runnable;", "run", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$d */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2310d implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11881a;

        /* renamed from: b */
        final /* synthetic */ Animation.AnimationListener f11882b;

        C2310d(Animation.AnimationListener animationListener) {
            this.f11882b = animationListener;
        }

        public void run() {
            Animation.AnimationListener animationListener;
            if (!PatchProxy.proxy(new Object[0], this, f11881a, false, 5657, new Class[0], Void.TYPE).isSupported && (animationListener = this.f11882b) != null) {
                animationListener.onAnimationEnd((Animation) null);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$animateSlidingModeIn$3", "Ljava/lang/Runnable;", "run", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$e */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2311e implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11883a;

        /* renamed from: b */
        final /* synthetic */ Animation.AnimationListener f11884b;

        C2311e(Animation.AnimationListener animationListener) {
            this.f11884b = animationListener;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11883a, false, 5658, new Class[0], Void.TYPE).isSupported && this.f11884b != null) {
                this.f11884b.onAnimationEnd((Animation) null);
                LogUtil.m15942a(MzSimplifyCamUI.f11807al, "animateSlidingModeIn end");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Bitmap m12948a(boolean z, boolean z2) {
        Bitmap bitmap;
        boolean z3 = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f11806a, false, 5637, new Class[]{Boolean.TYPE, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        LogUtil.C2630a aVar = f11807al;
        LogUtil.m15942a(aVar, "getSwitchAnimBitmap start isFunny:" + z + ",isFBOn:" + z2);
        Bitmap bitmap2 = null;
        if (this.f11820L == 1) {
            z3 = true;
        }
        if (this.f11866w != null) {
            int i = 90;
            if (z3 && (!z2 || !DeviceHelper.f13904bD)) {
                i = -90;
            }
            this.f11823O = i;
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.setSurfaceTextureBitmap(this.f11823O);
        }
        CameraPreviewRenderView cameraPreviewRenderView2 = this.f11866w;
        if (cameraPreviewRenderView2 == null) {
            C3443i.m21151a();
        }
        float f = (float) 8;
        Bitmap a = cameraPreviewRenderView2.mo14099a((int) (this.f11846c.width() / f), (int) (this.f11846c.height() / f));
        LogUtil.C2630a aVar2 = f11807al;
        LogUtil.m15942a(aVar2, "getSwitchAnimBitmap from textureview bitmap:" + a);
        if (z3 && z2 && DeviceHelper.f13904bD) {
            a = BitmapUtils.m16147c(a);
            LogUtil.m15942a(f11807al, "verticalConvert");
        }
        LogUtil.C2630a aVar3 = f11807al;
        LogUtil.m15942a(aVar3, "getSwitchAnimBitmap bitmap:" + a);
        if (a == null || a.isRecycled()) {
            bitmap = Bitmap.createBitmap((int) (this.f11846c.width() / f), (int) (this.f11846c.height() / f), Bitmap.Config.ARGB_8888);
            new Canvas(bitmap).drawColor(-12303292);
            LogUtil.m15949b(f11807al, "surface may be released, so we can't get bitmap,use default bitmap");
        } else {
            bitmap = C1825q.m8250a(this.f11851h, a, 18.0f, true);
        }
        LogUtil.C2630a aVar4 = f11807al;
        LogUtil.m15942a(aVar4, "getSwitchAnimBitmap end bitmap:" + bitmap);
        return bitmap;
    }

    /* renamed from: a */
    public final void mo21166a(@NotNull Animation.AnimationListener animationListener) {
        if (!PatchProxy.proxy(new Object[]{animationListener}, this, f11806a, false, 5638, new Class[]{Animation.AnimationListener.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(animationListener, "listener");
            if (this.f11812D != null) {
                MzImageView mzImageView = this.f11812D;
                if (mzImageView == null) {
                    C3443i.m21151a();
                }
                if (mzImageView.getVisibility() == 0) {
                    SwitchAnimManager.m8194a((View) this.f11812D, (PreviewView) this.f11866w, (View) null, (ViewGroup) null, 0.5f, 100, false, false, animationListener);
                    LogUtil.m15942a(f11807al, "animateSlidingModeOut");
                    return;
                }
                animationListener.onAnimationEnd((Animation) null);
            }
        }
    }

    /* renamed from: L */
    public final void mo21150L() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5639, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11807al, "onSlidAnimEnd mSwitchAnimView.setVisibility(View.GONE)");
            MzImageView mzImageView = this.f11812D;
            if (mzImageView == null) {
                C3443i.m21151a();
            }
            mzImageView.clearAnimation();
            MzImageView mzImageView2 = this.f11812D;
            if (mzImageView2 == null) {
                C3443i.m21151a();
            }
            mzImageView2.setVisibility(8);
        }
    }

    /* renamed from: M */
    public final void mo21151M() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5640, new Class[0], Void.TYPE).isSupported) {
            RenderOverlay renderOverlay = this.f11817I;
            if (renderOverlay == null) {
                C3443i.m21151a();
            }
            renderOverlay.mo23139a();
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J'\u0010\n\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\f\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo27294d2 = {"Lcom/meizu/media/camera/simplify/MzSimplifyCamUI$SaveLastPreviewBitmapTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "camUI", "Lcom/meizu/media/camera/simplify/MzSimplifyCamUI;", "mIsWatch", "", "(Lcom/meizu/media/camera/simplify/MzSimplifyCamUI;Z)V", "mCamUI", "Ljava/lang/ref/WeakReference;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$b */
    /* compiled from: MzSimplifyCamUI.kt */
    private static final class C2307b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11870a;

        /* renamed from: b */
        private WeakReference<MzSimplifyCamUI> f11871b = new WeakReference<>(this.f11872c);

        /* renamed from: c */
        private MzSimplifyCamUI f11872c;

        /* renamed from: d */
        private boolean f11873d;

        public C2307b(@NotNull MzSimplifyCamUI dVar, boolean z) {
            C3443i.m21155b(dVar, "camUI");
            this.f11872c = dVar;
            this.f11873d = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:103:0x01de A[SYNTHETIC, Splitter:B:103:0x01de] */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x01eb  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x01f6  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x0224 A[SYNTHETIC, Splitter:B:123:0x0224] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x012f  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x014f  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x015a  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01a5  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01b0  */
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull java.lang.Void... r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f11870a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<java.lang.Void[]> r0 = java.lang.Void[].class
                r6[r8] = r0
                java.lang.Class<java.lang.Void> r7 = java.lang.Void.class
                r4 = 0
                r5 = 5653(0x1615, float:7.922E-42)
                r2 = r9
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r0.isSupported
                if (r1 == 0) goto L_0x0021
                java.lang.Object r10 = r0.result
                java.lang.Void r10 = (java.lang.Void) r10
                return r10
            L_0x0021:
                java.lang.String r0 = "params"
                kotlin.jvm.p108b.C3443i.m21155b(r10, r0)
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                r0 = 0
                if (r10 != 0) goto L_0x0030
                return r0
            L_0x0030:
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                if (r10 != 0) goto L_0x003b
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x003b:
                com.meizu.media.camera.simplify.d r10 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r10
                com.meizu.media.camera.CameraSimplifyActivity r10 = r10.f11851h
                android.content.Context r10 = r10.getApplicationContext()
                com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.simplify.MzSimplifyCamUI.f11807al
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "doInBackground blur last preview bitmap start:"
                r2.append(r3)
                java.lang.String r3 = "ctx"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r10, (java.lang.String) r3)
                java.io.File r3 = r10.getFilesDir()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.simplify.MzSimplifyCamUI.f11807al
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "previewBitmap:"
                r2.append(r3)
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r3 = r9.f11871b
                java.lang.Object r3 = r3.get()
                if (r3 != 0) goto L_0x007f
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x007f:
                com.meizu.media.camera.simplify.d r3 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r3
                android.graphics.Bitmap r3 = r3.f11824P
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r1 = r9.f11871b
                java.lang.Object r1 = r1.get()
                if (r1 != 0) goto L_0x009a
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x009a:
                com.meizu.media.camera.simplify.d r1 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r1
                android.graphics.Bitmap r1 = r1.f11824P
                if (r1 == 0) goto L_0x0232
                boolean r1 = r9.f11873d
                if (r1 == 0) goto L_0x00cb
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r1 = r9.f11871b
                java.lang.Object r1 = r1.get()
                if (r1 != 0) goto L_0x00b1
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x00b1:
                com.meizu.media.camera.simplify.d r1 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r1
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r2 = r9.f11871b
                java.lang.Object r2 = r2.get()
                if (r2 != 0) goto L_0x00be
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x00be:
                com.meizu.media.camera.simplify.d r2 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r2
                android.graphics.Bitmap r2 = r2.f11824P
                android.graphics.Bitmap r2 = com.meizu.media.camera.util.BitmapUtils.m16140a(r2)
                r1.f11824P = r2
            L_0x00cb:
                r1 = r0
                android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r2 = r9.f11871b     // Catch:{ Exception -> 0x022d }
                java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x022d }
                if (r2 != 0) goto L_0x00d9
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x022d }
            L_0x00d9:
                com.meizu.media.camera.simplify.d r2 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r2     // Catch:{ Exception -> 0x022d }
                android.graphics.Bitmap r2 = r2.f11824P     // Catch:{ Exception -> 0x022d }
                if (r2 == 0) goto L_0x0115
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r2 = r9.f11871b     // Catch:{ Exception -> 0x022d }
                java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x022d }
                if (r2 != 0) goto L_0x00ec
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x022d }
            L_0x00ec:
                com.meizu.media.camera.simplify.d r2 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r2     // Catch:{ Exception -> 0x022d }
                android.graphics.Bitmap r2 = r2.f11824P     // Catch:{ Exception -> 0x022d }
                if (r2 != 0) goto L_0x00f7
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x022d }
            L_0x00f7:
                boolean r2 = r2.isRecycled()     // Catch:{ Exception -> 0x022d }
                if (r2 != 0) goto L_0x0115
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r2 = r9.f11871b     // Catch:{ Exception -> 0x022d }
                java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x022d }
                if (r2 != 0) goto L_0x0108
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x022d }
            L_0x0108:
                com.meizu.media.camera.simplify.d r2 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r2     // Catch:{ Exception -> 0x022d }
                android.graphics.Bitmap r2 = r2.f11824P     // Catch:{ Exception -> 0x022d }
                r3 = 1103626240(0x41c80000, float:25.0)
                android.graphics.Bitmap r2 = com.meizu.media.camera.animation.C1825q.m8250a(r10, r2, r3, r8)     // Catch:{ Exception -> 0x022d }
                goto L_0x0116
            L_0x0115:
                r2 = r1
            L_0x0116:
                java.io.File r3 = new java.io.File
                java.io.File r10 = r10.getFilesDir()
                java.lang.String r4 = "last_preview_file"
                r3.<init>(r10, r4)
                if (r2 == 0) goto L_0x0232
                boolean r10 = r2.isRecycled()
                if (r10 != 0) goto L_0x0232
                boolean r10 = r3.exists()
                if (r10 == 0) goto L_0x0132
                r3.delete()
            L_0x0132:
                r10 = r0
                java.io.FileOutputStream r10 = (java.io.FileOutputStream) r10
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0197, all -> 0x0193 }
                r4.<init>(r3)     // Catch:{ Exception -> 0x0197, all -> 0x0193 }
                android.graphics.Bitmap$CompressFormat r10 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0191 }
                r3 = 90
                r5 = r4
                java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ Exception -> 0x0191 }
                r2.compress(r10, r3, r5)     // Catch:{ Exception -> 0x0191 }
                r4.flush()     // Catch:{ Exception -> 0x0191 }
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                if (r10 != 0) goto L_0x0152
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0152:
                com.meizu.media.camera.simplify.d r10 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r10
                android.graphics.Bitmap r10 = r10.f11824P
                if (r10 == 0) goto L_0x0183
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                if (r10 != 0) goto L_0x0165
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0165:
                com.meizu.media.camera.simplify.d r10 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r10
                android.graphics.Bitmap r10 = r10.f11824P
                if (r10 != 0) goto L_0x0170
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0170:
                r10.recycle()
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                if (r10 != 0) goto L_0x017e
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x017e:
                com.meizu.media.camera.simplify.d r10 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r10
                r10.f11824P = r1
            L_0x0183:
                r2.recycle()
                r4.close()     // Catch:{ IOException -> 0x018b }
                goto L_0x0232
            L_0x018b:
                r10 = move-exception
                r10.printStackTrace()
                goto L_0x0232
            L_0x0191:
                r10 = move-exception
                goto L_0x019a
            L_0x0193:
                r0 = move-exception
                r4 = r10
                r10 = r0
                goto L_0x01e3
            L_0x0197:
                r3 = move-exception
                r4 = r10
                r10 = r3
            L_0x019a:
                r10.printStackTrace()     // Catch:{ all -> 0x01e2 }
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                if (r10 != 0) goto L_0x01a8
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x01a8:
                com.meizu.media.camera.simplify.d r10 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r10
                android.graphics.Bitmap r10 = r10.f11824P
                if (r10 == 0) goto L_0x01d9
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                if (r10 != 0) goto L_0x01bb
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x01bb:
                com.meizu.media.camera.simplify.d r10 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r10
                android.graphics.Bitmap r10 = r10.f11824P
                if (r10 != 0) goto L_0x01c6
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x01c6:
                r10.recycle()
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r10 = r9.f11871b
                java.lang.Object r10 = r10.get()
                if (r10 != 0) goto L_0x01d4
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x01d4:
                com.meizu.media.camera.simplify.d r10 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r10
                r10.f11824P = r1
            L_0x01d9:
                r2.recycle()
                if (r4 == 0) goto L_0x0232
                r4.close()     // Catch:{ IOException -> 0x018b }
                goto L_0x0232
            L_0x01e2:
                r10 = move-exception
            L_0x01e3:
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r0 = r9.f11871b
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x01ee
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x01ee:
                com.meizu.media.camera.simplify.d r0 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r0
                android.graphics.Bitmap r0 = r0.f11824P
                if (r0 == 0) goto L_0x021f
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r0 = r9.f11871b
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0201
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0201:
                com.meizu.media.camera.simplify.d r0 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r0
                android.graphics.Bitmap r0 = r0.f11824P
                if (r0 != 0) goto L_0x020c
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x020c:
                r0.recycle()
                java.lang.ref.WeakReference<com.meizu.media.camera.simplify.d> r0 = r9.f11871b
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x021a
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x021a:
                com.meizu.media.camera.simplify.d r0 = (com.meizu.media.camera.simplify.MzSimplifyCamUI) r0
                r0.f11824P = r1
            L_0x021f:
                r2.recycle()
                if (r4 == 0) goto L_0x022c
                r4.close()     // Catch:{ IOException -> 0x0228 }
                goto L_0x022c
            L_0x0228:
                r0 = move-exception
                r0.printStackTrace()
            L_0x022c:
                throw r10
            L_0x022d:
                r10 = move-exception
                r10.printStackTrace()
                return r0
            L_0x0232:
                com.meizu.media.camera.util.ac$a r10 = com.meizu.media.camera.simplify.MzSimplifyCamUI.f11807al
                java.lang.String r1 = "doInBackground blur last preview bitmap end"
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyCamUI.C2307b.doInBackground(java.lang.Void[]):java.lang.Void");
        }
    }

    /* renamed from: N */
    public final void mo21152N() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5642, new Class[0], Void.TYPE).isSupported) {
            if (this.f11825Q) {
                this.f11825Q = false;
            }
            LogUtil.C2630a aVar = f11807al;
            LogUtil.m15942a(aVar, "releaseAnimateBitmap mAnimateBitmap:" + this.f11827S);
            if (!SwitchAnimManager.m8197b() && this.f11827S != null) {
                Bitmap bitmap = this.f11827S;
                if (bitmap == null) {
                    C3443i.m21151a();
                }
                if (!bitmap.isRecycled()) {
                    Bitmap bitmap2 = this.f11827S;
                    if (bitmap2 == null) {
                        C3443i.m21151a();
                    }
                    bitmap2.recycle();
                    this.f11827S = null;
                }
            }
            if (this.f11812D != null) {
                MzImageView mzImageView = this.f11812D;
                if (mzImageView == null) {
                    C3443i.m21151a();
                }
                mzImageView.setImageBitmap((Bitmap) null);
            }
        }
    }

    /* renamed from: V */
    private final void m12946V() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5643, new Class[0], Void.TYPE).isSupported) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration((long) this.f11829U);
            valueAnimator.addUpdateListener(new C2314h(this));
            this.f11828T = valueAnimator;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo27294d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/meizu/media/camera/simplify/MzSimplifyCamUI$initTextureAnim$1$1"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$h */
    /* compiled from: MzSimplifyCamUI.kt */
    static final class C2314h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11893a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11894b;

        C2314h(MzSimplifyCamUI dVar) {
            this.f11894b = dVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f11893a, false, 5663, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                Object animatedValue = valueAnimator.getAnimatedValue("TranslateY");
                if (animatedValue != null) {
                    this.f11894b.m12951a(this.f11894b.mo21143E(), this.f11894b.mo21144F(), ((Integer) animatedValue).intValue(), false);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    /* renamed from: O */
    public final void mo21153O() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5644, new Class[0], Void.TYPE).isSupported && this.f11830V != 0) {
            this.f11830V = 0;
            m12951a(mo21143E(), mo21144F(), this.f11830V, false);
            mo21141C();
        }
    }

    /* renamed from: a */
    public final void mo21173a(boolean z, @Nullable AnimatorListenerAdapter animatorListenerAdapter) {
        int i;
        ValueAnimator valueAnimator;
        PathInterpolator pathInterpolator;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), animatorListenerAdapter}, this, f11806a, false, 5645, new Class[]{Boolean.TYPE, AnimatorListenerAdapter.class}, Void.TYPE).isSupported) {
            if (this.f11869z || this.f11809A || NavigationBarUtils.m15972a()) {
                LogUtil.C2630a aVar = f11807al;
                LogUtil.m15952c(aVar, "startTextureTranslationAnim mIsSquareMode:" + this.f11869z + ", mFullScreen:" + this.f11809A + "   return");
                return;
            }
            if (this.f11828T != null) {
                ValueAnimator valueAnimator2 = this.f11828T;
                if (valueAnimator2 == null) {
                    C3443i.m21151a();
                }
                if (valueAnimator2.isRunning()) {
                    ValueAnimator valueAnimator3 = this.f11828T;
                    if (valueAnimator3 == null) {
                        C3443i.m21151a();
                    }
                    valueAnimator3.end();
                }
            }
            if (z) {
                i = 0;
            } else {
                i = CameraUtil.m15901h();
            }
            int h = z ? CameraUtil.m15901h() : 0;
            if (this.f11830V != h || !z) {
                LogUtil.C2630a aVar2 = f11807al;
                LogUtil.m15952c(aVar2, "startTextureTranslationAnim " + i + " to " + h);
                this.f11830V = h;
                PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("TranslateY", new int[]{i, h});
                ValueAnimator valueAnimator4 = this.f11828T;
                if (valueAnimator4 == null) {
                    C3443i.m21151a();
                }
                valueAnimator4.setValues(new PropertyValuesHolder[]{ofInt, ofInt});
                if (z) {
                    valueAnimator = this.f11828T;
                    if (valueAnimator == null) {
                        C3443i.m21151a();
                    }
                    pathInterpolator = new PathInterpolator(0.2f, 0.0f, 0.05f, 1.0f);
                } else {
                    valueAnimator = this.f11828T;
                    if (valueAnimator == null) {
                        C3443i.m21151a();
                    }
                    pathInterpolator = new PathInterpolator(0.29f, 0.5f, 0.16f, 1.0f);
                }
                valueAnimator.setInterpolator(pathInterpolator);
                ValueAnimator valueAnimator5 = this.f11828T;
                if (valueAnimator5 == null) {
                    C3443i.m21151a();
                }
                valueAnimator5.addListener(new C2327u(this, h, animatorListenerAdapter));
                ValueAnimator valueAnimator6 = this.f11828T;
                if (valueAnimator6 == null) {
                    C3443i.m21151a();
                }
                valueAnimator6.start();
                return;
            }
            LogUtil.m15952c(f11807al, "startTextureTranslationAnim already moveUp, return");
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$startTextureTranslationAnim$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$u */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2327u extends AnimatorListenerAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f11920a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11921b;

        /* renamed from: c */
        final /* synthetic */ int f11922c;

        /* renamed from: d */
        final /* synthetic */ AnimatorListenerAdapter f11923d;

        C2327u(MzSimplifyCamUI dVar, int i, AnimatorListenerAdapter animatorListenerAdapter) {
            this.f11921b = dVar;
            this.f11922c = i;
            this.f11923d = animatorListenerAdapter;
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f11920a, false, 5685, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                ValueAnimator m = this.f11921b.f11828T;
                if (m == null) {
                    C3443i.m21151a();
                }
                m.removeListener(this);
                this.f11921b.m12951a(this.f11921b.mo21143E(), this.f11921b.mo21144F(), this.f11922c, true);
                AnimatorListenerAdapter animatorListenerAdapter = this.f11923d;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }

        public void onAnimationStart(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f11920a, false, 5686, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                super.onAnimationStart(animator);
                AnimatorListenerAdapter animatorListenerAdapter = this.f11923d;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo21167a(@Nullable BaseRender aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f11806a, false, 5646, new Class[]{BaseRender.class}, Void.TYPE).isSupported && this.f11866w != null) {
            CameraPreviewRenderView cameraPreviewRenderView = this.f11866w;
            if (cameraPreviewRenderView == null) {
                C3443i.m21151a();
            }
            cameraPreviewRenderView.setRender(aVar);
        }
    }

    /* renamed from: n */
    public final void mo21209n(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11806a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5647, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f11849f != null) {
            MzSimplifyImageCaptureUI hVar = this.f11849f;
            if (hVar == null) {
                C3443i.m21151a();
            }
            hVar.mo21285a(z);
        }
    }

    /* renamed from: o */
    public final void mo21211o(boolean z) {
        this.f11832X = z;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J'\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo27294d2 = {"com/meizu/media/camera/simplify/MzSimplifyCamUI$onPreviewStart$1", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.simplify.d$m */
    /* compiled from: MzSimplifyCamUI.kt */
    public static final class C2319m extends AsyncTaskEx<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11902a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifyCamUI f11903b;

        C2319m(MzSimplifyCamUI dVar) {
            this.f11903b = dVar;
        }

        @Nullable
        /* renamed from: a */
        public Void mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11902a, false, 5671, new Class[]{Void[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            C3443i.m21155b(voidArr, "params");
            CameraPreviewRenderView d = this.f11903b.f11866w;
            if (d == null) {
                C3443i.m21151a();
            }
            d.mo14105c();
            this.f11903b.f11838ad = true;
            return null;
        }
    }

    /* renamed from: P */
    public final void mo21154P() {
        if (!PatchProxy.proxy(new Object[0], this, f11806a, false, 5652, new Class[0], Void.TYPE).isSupported && this.f11866w != null && !this.f11838ad) {
            new C2319m(this).mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: Q */
    public final boolean mo21155Q() {
        return this.f11825Q;
    }
}
