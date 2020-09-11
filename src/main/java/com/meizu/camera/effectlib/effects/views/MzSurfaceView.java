package com.meizu.camera.effectlib.effects.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.app.NotificationCompat;
import com.meizu.camera.effectlib.effects.p058a.GLES20Utils;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.imageproc.SurfaceTextureBitmap;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\\\u0018\u0000 Ó\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\bÐ\u0001Ñ\u0001Ò\u0001Ó\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\u0019J\b\u0010z\u001a\u00020xH\u0002J\b\u0010{\u001a\u00020xH\u0002J\u0018\u0010|\u001a\u00020x2\u0006\u0010|\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\u000eH\u0016J\u001b\u0010~\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000bH\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020K2\u0007\u0010\u0001\u001a\u00020KH\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010NH\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010\u0001\u001a\u00020x2\t\u0010\u0001\u001a\u0004\u0018\u000101H\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010NH\u0016J\t\u0010\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0004J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0002J\t\u0010\u0001\u001a\u00020xH\u0016J\u0007\u0010\u0001\u001a\u00020xJ-\u0010\u0001\u001a\u00020x2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\t\u0010\u0001\u001a\u00020xH\u0016J\u0007\u0010\u0001\u001a\u00020xJ\u0012\u0010 \u0001\u001a\u00020x2\u0007\u0010¡\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010¢\u0001\u001a\u00020x2\u0007\u0010£\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¤\u0001\u001a\u00020x2\u0007\u0010¥\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¦\u0001\u001a\u00020x2\u0007\u0010§\u0001\u001a\u00020PH\u0016J%\u0010¨\u0001\u001a\u00020x2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000bH\u0016J,\u0010ª\u0001\u001a\u00020x2\u0007\u0010«\u0001\u001a\u00020B2\u0006\u0010\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010¬\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010­\u0001\u001a\u00020x2\u0007\u0010®\u0001\u001a\u00020NH\u0016J\u0012\u0010¯\u0001\u001a\u00020x2\u0007\u0010°\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010±\u0001\u001a\u00020x2\u0007\u0010²\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010³\u0001\u001a\u00020x2\u0007\u0010¡\u0001\u001a\u00020UH\u0016J\u0012\u0010´\u0001\u001a\u00020x2\u0007\u0010µ\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¶\u0001\u001a\u00020x2\u0007\u0010·\u0001\u001a\u00020\u000bH\u0016J$\u0010¶\u0001\u001a\u00020x2\u0007\u0010·\u0001\u001a\u00020\u000b2\u0007\u0010¸\u0001\u001a\u00020\u000b2\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J-\u0010¶\u0001\u001a\u00020x2\u0007\u0010·\u0001\u001a\u00020\u000b2\u0007\u0010¸\u0001\u001a\u00020\u000b2\u0007\u0010º\u0001\u001a\u00020\u000e2\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010»\u0001\u001a\u00020x2\u0007\u0010¡\u0001\u001a\u000208H\u0016J\u001b\u0010¼\u0001\u001a\u00020x2\u0007\u0010¡\u0001\u001a\u0002082\u0007\u0010½\u0001\u001a\u00020qH\u0016J\u0012\u0010¾\u0001\u001a\u00020x2\u0007\u0010¿\u0001\u001a\u00020\u000eH\u0016J\u0014\u0010À\u0001\u001a\u00020x2\t\u0010\u0001\u001a\u0004\u0018\u000101H\u0016J$\u0010Á\u0001\u001a\u00020x2\u0007\u0010Â\u0001\u001a\u00020I2\u0007\u0010Ã\u0001\u001a\u00020I2\u0007\u0010Ä\u0001\u001a\u00020IH\u0016J\u0012\u0010Å\u0001\u001a\u00020x2\u0007\u0010²\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010Æ\u0001\u001a\u00020x2\u0007\u0010Ç\u0001\u001a\u00020IH\u0016J\u0012\u0010È\u0001\u001a\u00020x2\u0007\u0010É\u0001\u001a\u00020\u000eH\u0016J\t\u0010Ê\u0001\u001a\u00020xH\u0002J,\u0010Ë\u0001\u001a\u00020x2\u0007\u0010Ì\u0001\u001a\u00020.2\u0007\u0010Í\u0001\u001a\u00020\u000b2\u0006\u0010\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010Î\u0001\u001a\u00020x2\u0007\u0010Ì\u0001\u001a\u00020.H\u0016J\u0012\u0010Ï\u0001\u001a\u00020x2\u0007\u0010Ì\u0001\u001a\u00020.H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0016\u0010 \u001a\n \"*\u0004\u0018\u00010!0!X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \"*\u0004\u0018\u00010$0$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0018\u00010+R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020IX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010l\u001a\b\u0018\u00010mR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010qX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uX\u0004¢\u0006\u0002\n\u0000¨\u0006Ô\u0001"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/meizu/camera/effectlib/effects/views/PreviewView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAttached", "", "mBitmap", "Landroid/graphics/Bitmap;", "mBitmapSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mBitmapSurfaceTextureWrapper", "Lcom/meizu/imageproc/SurfaceTextureWrapper;", "mBokehListener", "Lcom/meizu/camera/effectlib/effects/views/PreviewView$BokehListener;", "mDevicePlatform", "mDeviceType", "", "mDrawOrder", "", "mEGLConfig", "", "Landroid/opengl/EGLConfig;", "[Landroid/opengl/EGLConfig;", "mEGLContext", "Landroid/opengl/EGLContext;", "kotlin.jvm.PlatformType", "mEGLDisplay", "Landroid/opengl/EGLDisplay;", "mEglConfig", "mEglSurface", "Landroid/opengl/EGLSurface;", "mEnableDraw", "mFactor", "mGLRenderer", "Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView$CameraPreviewRender;", "mGetEffectBitmap", "mHolder", "Landroid/view/SurfaceHolder;", "mIdFBO", "mIdentityMatrix", "", "mIsBokehOn", "mIsMoreSurfaceTxture", "mIsTofOn", "mIsYuvInput", "mIsYuvRenderProgramInit", "mListener", "Lcom/meizu/camera/effectlib/effects/views/PreviewView$SurfaceTextureListener;", "mMVPMatrix", "mMVPMatrixLocation", "mMVPTofMatrix", "mMatrix", "mNeedClean", "mNeedFBThumnail", "mPaused", "mPositionLocation", "mPreviewData", "", "mPreviewHight", "mPreviewRowstride", "mPreviewTexture", "Lcom/meizu/camera/effectlib/effects/gles/GLTexture;", "mPreviewWidth", "mPy", "", "mRGBData", "", "mRGBsize", "mRender", "Lcom/meizu/camera/effectlib/effects/renders/BaseRender;", "mRenderFactory", "Lcom/meizu/camera/effectlib/effects/views/EffectRenderFactory;", "mRenderProgram", "Lcom/meizu/camera/effectlib/effects/views/YuvRenderProgram;", "mRenderTranslationY", "mRenderViewCallBackListener", "Lcom/meizu/camera/effectlib/effects/views/PreviewView$RenderViewCallBackListener;", "mScaleFactor", "mScaleX", "mScaleY", "mShareTexture", "mShareTextureId", "mSupportFBandEffectOverlay", "mSurfaceCreated", "mSurfaceHeight", "mSurfaceTexture", "mSurfaceTextureWrapper", "mSurfaceWidth", "mSyncObject", "", "mTexMatrix", "mTexMatrixLocation", "mTextureCoordLocation", "mThreadinited", "mTransformMatrix", "mUTextureUVLocation", "mUTextureYLocation", "mUVTextureId", "mVfbRender", "mViewHandler", "Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView$CameraPreviewRenderViewHandler;", "mViewHeight", "mViewWidth", "mWrapperListener", "Lcom/meizu/camera/effectlib/effects/views/PreviewView$SurfaceTextureWrapperListener;", "mYTextureId", "misUseFBHigherLib", "sQueue", "Ljava/util/Vector;", "Ljava/lang/Runnable;", "checkEglError", "", "msg", "checkFrameBufferStatus", "deleteFrameBuffer", "enableDraw", "needSetAlpha", "getBitmap", "width", "height", "getPreviewBitmap", "getPreviewYuv", "yuv", "yuvSize", "yuvStride", "getRender", "getSurfaceTexture", "getTransform", "matrix", "getVfbRender", "getViewHeight", "getViewWidth", "init", "initCameraPreviewRender", "initRender", "initRenderProgram", "initSurfaceTextureBitmap", "initSurfaceTextureWrapper", "layout", "l", "t", "r", "b", "onPause", "onResume", "refresh", "release", "releaseSurfaceTexture", "releaseframeBuffer", "resumeSurfaceTexture", "resumeSurfaceTextureWrapper", "setBokehListener", "listener", "setBokehStatus", "isBokehOn", "setCleanScreen", "needClean", "setEffectRenderFactory", "factory", "setPreviewBitmap", "bitmap", "setPreviewData", "data", "rowstride", "setRender", "render", "setRenderTranslationY", "renderTranslationY", "setRenderType", "renderType", "setRenderViewCallBackListener", "setShowBitmap", "showBitmap", "setSurfaceTextureBitmap", "rotation", "factor", "isCameraV2", "forceVerticalConvert", "setSurfaceTextureListener", "setSurfaceTextureListener2", "wrapperListener", "setTofStatus", "isTofOn", "setTransform", "setTransformParms", "scaleX", "scaleY", "py", "setVfbRenderType", "setViewAlpha", "alpha", "setYuvInput", "isYuvInput", "setupBuffers", "surfaceChanged", "holder", "format", "surfaceCreated", "surfaceDestroyed", "CameraPreviewRender", "CameraPreviewRenderViewHandler", "CloseVFBRunnable", "Companion", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: MzSurfaceView.kt */
public final class MzSurfaceView extends SurfaceView implements SurfaceHolder.Callback, PreviewView {

    /* renamed from: a */
    public static ChangeQuickRedirect f3835a = null;
    /* access modifiers changed from: private */

    /* renamed from: aB */
    public static final int f3836aB = 0;
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public static final int f3837aC = 1;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public static final int f3838aD = 2;
    /* access modifiers changed from: private */

    /* renamed from: aE */
    public static final int f3839aE = 3;

    /* renamed from: aF */
    private static final long f3840aF = f3840aF;
    /* access modifiers changed from: private */

    /* renamed from: aG */
    public static final int f3841aG = 4;

    /* renamed from: aH */
    private static final long f3842aH = f3842aH;
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public static final String f3843aI = f3843aI;
    /* access modifiers changed from: private */

    /* renamed from: aJ */
    public static final int f3844aJ = 4;
    /* access modifiers changed from: private */

    /* renamed from: aK */
    public static final int f3845aK = 5;
    /* access modifiers changed from: private */

    /* renamed from: aL */
    public static final int f3846aL = 6;
    /* access modifiers changed from: private */

    /* renamed from: aM */
    public static final int f3847aM = 7;
    /* access modifiers changed from: private */

    /* renamed from: aN */
    public static final int f3848aN = 8;
    /* access modifiers changed from: private */

    /* renamed from: aO */
    public static final int f3849aO = 9;
    /* access modifiers changed from: private */

    /* renamed from: aP */
    public static final float[] f3850aP = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: aQ */
    public static final float[] f3851aQ = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: aR */
    public static final float[] f3852aR = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: aS */
    public static int f3853aS;

    /* renamed from: b */
    public static final C1180d f3854b = new C1180d((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: A */
    public EGLSurface f3855A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public BaseRender f3856B;

    /* renamed from: C */
    private int f3857C;

    /* renamed from: D */
    private int f3858D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f3859E;

    /* renamed from: F */
    private String f3860F;

    /* renamed from: G */
    private int f3861G;

    /* renamed from: H */
    private boolean f3862H;

    /* renamed from: I */
    private boolean f3863I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public boolean f3864J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public Bitmap f3865K;

    /* renamed from: L */
    private final int f3866L;

    /* renamed from: M */
    private final int[] f3867M;

    /* renamed from: N */
    private final int[] f3868N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public EffectRenderFactory f3869O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public PreviewView.C1193b f3870P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f3871Q;

    /* renamed from: R */
    private boolean f3872R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public boolean f3873S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public boolean f3874T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f3875U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public byte[] f3876V;

    /* renamed from: W */
    private int f3877W;
    /* access modifiers changed from: private */

    /* renamed from: aA */
    public boolean f3878aA;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public int f3879aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public int f3880ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public YuvRenderProgram f3881ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public boolean f3882ad;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public int f3883ae;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public int f3884af;
    /* access modifiers changed from: private */

    /* renamed from: ag */
    public int f3885ag;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public int f3886ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public int f3887ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public int f3888aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public int f3889ak;

    /* renamed from: al */
    private final int f3890al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public final float[] f3891am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public final float[] f3892an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public final short[] f3893ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public boolean f3894ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public int f3895aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public GLTexture f3896ar;

    /* renamed from: as */
    private final int f3897as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public BaseRender f3898at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public boolean f3899au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public boolean f3900av;
    /* access modifiers changed from: private */

    /* renamed from: aw */
    public int f3901aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public float f3902ax;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public float f3903ay;
    /* access modifiers changed from: private */

    /* renamed from: az */
    public float f3904az;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SurfaceTexture f3905c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SurfaceTextureWrapper f3906d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SurfaceTexture f3907e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SurfaceTextureWrapper f3908f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Object f3909g;

    /* renamed from: h */
    private SurfaceHolder f3910h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PreviewView.C1194c f3911i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PreviewView.C1195d f3912j;

    /* renamed from: k */
    private PreviewView.C1192a f3913k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f3914l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f3915m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f3916n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public GLTexture f3917o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f3918p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final Vector<Runnable> f3919q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final float[] f3920r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final float[] f3921s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final float[] f3922t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final float[] f3923u;

    /* renamed from: v */
    private C1176a f3924v;

    /* renamed from: w */
    private C1178b f3925w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public EGLDisplay f3926x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public EGLContext f3927y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final EGLConfig[] f3928z;

    /* renamed from: i */
    public void mo14117i() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MzSurfaceView(@NotNull Context context) {
        super(context);
        C3443i.m21155b(context, "context");
        this.f3909g = new Object();
        this.f3919q = new Vector<>();
        this.f3920r = new float[16];
        this.f3921s = new float[16];
        this.f3922t = new float[16];
        this.f3923u = new float[16];
        this.f3926x = EGL14.EGL_NO_DISPLAY;
        this.f3927y = EGL14.EGL_NO_CONTEXT;
        this.f3928z = new EGLConfig[1];
        this.f3866L = 4;
        this.f3867M = new int[6000000];
        this.f3868N = new int[2];
        this.f3883ae = -1;
        this.f3884af = -1;
        this.f3885ag = -1;
        this.f3886ah = -1;
        this.f3887ai = -1;
        this.f3888aj = -1;
        this.f3889ak = -1;
        this.f3890al = -1;
        this.f3891am = new float[16];
        this.f3892an = new float[16];
        this.f3893ao = new short[]{0, 2, 1, 1, 2, 3};
        this.f3895aq = -1;
        this.f3897as = -1;
        this.f3901aw = 1;
        this.f3878aA = true;
        this.f3910h = getHolder();
        SurfaceHolder surfaceHolder = this.f3910h;
        if (surfaceHolder == null) {
            C3443i.m21151a();
        }
        surfaceHolder.addCallback(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MzSurfaceView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        C3443i.m21155b(context, "context");
        C3443i.m21155b(attributeSet, "attrs");
        this.f3909g = new Object();
        this.f3919q = new Vector<>();
        this.f3920r = new float[16];
        this.f3921s = new float[16];
        this.f3922t = new float[16];
        this.f3923u = new float[16];
        this.f3926x = EGL14.EGL_NO_DISPLAY;
        this.f3927y = EGL14.EGL_NO_CONTEXT;
        this.f3928z = new EGLConfig[1];
        this.f3866L = 4;
        this.f3867M = new int[6000000];
        this.f3868N = new int[2];
        this.f3883ae = -1;
        this.f3884af = -1;
        this.f3885ag = -1;
        this.f3886ah = -1;
        this.f3887ai = -1;
        this.f3888aj = -1;
        this.f3889ak = -1;
        this.f3890al = -1;
        this.f3891am = new float[16];
        this.f3892an = new float[16];
        this.f3893ao = new short[]{0, 2, 1, 1, 2, 3};
        this.f3895aq = -1;
        this.f3897as = -1;
        this.f3901aw = 1;
        this.f3878aA = true;
        this.f3910h = getHolder();
        SurfaceHolder surfaceHolder = this.f3910h;
        if (surfaceHolder == null) {
            C3443i.m21151a();
        }
        surfaceHolder.addCallback(this);
    }

    /* renamed from: a */
    public void mo14100a() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 338, new Class[0], Void.TYPE).isSupported) {
            mo14244b();
        }
    }

    public void surfaceCreated(@NotNull SurfaceHolder surfaceHolder) {
        if (!PatchProxy.proxy(new Object[]{surfaceHolder}, this, f3835a, false, 339, new Class[]{SurfaceHolder.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(surfaceHolder, "holder");
            Log.i(f3843aI, " surfaceCreated");
            this.f3871Q = true;
            if (!this.f3872R && this.f3924v != null) {
                this.f3872R = true;
                C1176a aVar = this.f3924v;
                if (aVar == null) {
                    C3443i.m21151a();
                }
                aVar.mo14259a(this);
                C1176a aVar2 = this.f3924v;
                if (aVar2 == null) {
                    C3443i.m21151a();
                }
                aVar2.mo14258a();
            }
        }
    }

    public void surfaceChanged(@NotNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{surfaceHolder, new Integer(i), new Integer(i2), new Integer(i3)}, this, f3835a, false, 340, new Class[]{SurfaceHolder.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(surfaceHolder, "holder");
            String str = f3843aI;
            Log.d(str, " surfaceChanged w:" + i2 + "x" + i3);
            if (i2 <= 0 || i3 <= 0 || (i2 == this.f3857C && i3 == this.f3858D)) {
                this.f3857C = i2;
                this.f3858D = i3;
            } else if (this.f3857C == 0 && this.f3858D == 0) {
                this.f3857C = i2;
                this.f3858D = i3;
            }
        }
    }

    public void surfaceDestroyed(@NotNull SurfaceHolder surfaceHolder) {
        if (!PatchProxy.proxy(new Object[]{surfaceHolder}, this, f3835a, false, 341, new Class[]{SurfaceHolder.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(surfaceHolder, "holder");
            Log.i(f3843aI, "surfaceDestroyed");
            this.f3871Q = false;
        }
    }

    /* renamed from: b */
    public final void mo14244b() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 342, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3843aI, " initCameraPreviewRender ");
            this.f3924v = new C1176a();
            this.f3925w = new C1178b(this, this);
            Matrix.setIdentityM(this.f3920r, 0);
            Matrix.setIdentityM(this.f3921s, 0);
            Matrix.setIdentityM(this.f3923u, 0);
            Matrix.setIdentityM(this.f3891am, 0);
            Matrix.setIdentityM(this.f3892an, 0);
            this.f3894ap = false;
            this.f3859E = false;
        }
    }

    public void layout(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3835a, false, 343, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.layout(i, i2, i3, i4);
            this.f3914l = getWidth();
            this.f3915m = getHeight();
            String str = f3843aI;
            Log.v(str, "layout:" + this.f3914l + "x" + this.f3915m);
            EffectRenderContext.m4369h().mo14191b(this.f3914l, this.f3915m);
            invalidate();
        }
    }

    /* renamed from: m */
    public void mo14122m() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 344, new Class[0], Void.TYPE).isSupported) {
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            if (h.mo14238v() && this.f3924v != null) {
                C1176a aVar = this.f3924v;
                if (aVar == null) {
                    C3443i.m21151a();
                }
                aVar.mo14261c();
            }
        }
    }

    @Nullable
    public SurfaceTexture getSurfaceTexture() {
        return this.f3905c;
    }

    public void setTransform(@Nullable float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3835a, false, 345, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null && fArr.length >= this.f3920r.length) {
            System.arraycopy(fArr, 0, this.f3920r, 0, this.f3920r.length);
            System.arraycopy(fArr, 0, this.f3891am, 0, this.f3891am.length);
            System.arraycopy(fArr, 0, this.f3892an, 0, this.f3892an.length);
            Matrix.rotateM(this.f3891am, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.f3891am, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.f3892an, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.f3892an, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    public void setTransformParms(float f, float f2, float f3) {
        this.f3902ax = f;
        this.f3903ay = f2;
        this.f3904az = f3;
    }

    /* renamed from: a */
    public void mo14103a(@Nullable float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3835a, false, 346, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null && fArr.length >= this.f3920r.length) {
            System.arraycopy(this.f3920r, 0, fArr, 0, this.f3920r.length);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MzSurfaceView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C3443i.m21155b(context, "context");
        C3443i.m21155b(attributeSet, "attrs");
        this.f3909g = new Object();
        this.f3919q = new Vector<>();
        this.f3920r = new float[16];
        this.f3921s = new float[16];
        this.f3922t = new float[16];
        this.f3923u = new float[16];
        this.f3926x = EGL14.EGL_NO_DISPLAY;
        this.f3927y = EGL14.EGL_NO_CONTEXT;
        this.f3928z = new EGLConfig[1];
        this.f3866L = 4;
        this.f3867M = new int[6000000];
        this.f3868N = new int[2];
        this.f3883ae = -1;
        this.f3884af = -1;
        this.f3885ag = -1;
        this.f3886ah = -1;
        this.f3887ai = -1;
        this.f3888aj = -1;
        this.f3889ak = -1;
        this.f3890al = -1;
        this.f3891am = new float[16];
        this.f3892an = new float[16];
        this.f3893ao = new short[]{0, 2, 1, 1, 2, 3};
        this.f3895aq = -1;
        this.f3897as = -1;
        this.f3901aw = 1;
        this.f3878aA = true;
    }

    public void setSurfaceTextureListener(@NotNull PreviewView.C1194c cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, this, f3835a, false, 347, new Class[]{PreviewView.C1194c.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(cVar, "listener");
            this.f3911i = cVar;
        }
    }

    public void setSurfaceTextureListener2(@NotNull PreviewView.C1194c cVar, @NotNull PreviewView.C1195d dVar) {
        Class[] clsArr = {PreviewView.C1194c.class, PreviewView.C1195d.class};
        if (!PatchProxy.proxy(new Object[]{cVar, dVar}, this, f3835a, false, 348, clsArr, Void.TYPE).isSupported) {
            C3443i.m21155b(cVar, "listener");
            C3443i.m21155b(dVar, "wrapperListener");
            this.f3911i = cVar;
            this.f3912j = dVar;
        }
    }

    public void setRenderViewCallBackListener(@NotNull PreviewView.C1193b bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f3835a, false, 349, new Class[]{PreviewView.C1193b.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar, "listener");
            this.f3870P = bVar;
        }
    }

    @Nullable
    public BaseRender getRender() {
        return this.f3856B;
    }

    @Nullable
    public BaseRender getVfbRender() {
        return this.f3898at;
    }

    @Nullable
    public Bitmap getPreviewBitmap() {
        Bitmap bitmap;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3835a, false, 350, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        synchronized (this.f3909g) {
            if (this.f3865K != null) {
                Bitmap bitmap2 = this.f3865K;
                if (bitmap2 == null) {
                    C3443i.m21151a();
                }
                if (!bitmap2.isRecycled()) {
                    bitmap = this.f3865K;
                }
            }
            bitmap = null;
        }
        return bitmap;
    }

    @Nullable
    /* renamed from: a */
    public Bitmap mo14099a(int i, int i2) {
        Bitmap bitmap;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f3835a, false, 351, new Class[]{Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        synchronized (this.f3909g) {
            bitmap = null;
            if (this.f3865K != null) {
                Bitmap bitmap2 = this.f3865K;
                if (bitmap2 == null) {
                    C3443i.m21151a();
                }
                if (!bitmap2.isRecycled()) {
                    Bitmap bitmap3 = this.f3865K;
                    if (bitmap3 == null) {
                        C3443i.m21151a();
                    }
                    bitmap = Bitmap.createScaledBitmap(bitmap3, i, i2, false);
                }
            }
        }
        return bitmap;
    }

    public void setRenderTranslationY(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 352, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f3916n = i;
            mo14122m();
        }
    }

    /* renamed from: d */
    public void mo14106d() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 353, new Class[0], Void.TYPE).isSupported) {
            if (Build.VERSION.SDK_INT >= 29) {
                mo14245e();
                return;
            }
            synchronized (this.f3909g) {
                Log.i(f3843aI, "MzSurfaceView init ");
                if (this.f3905c == null) {
                    try {
                        this.f3917o = EffectRenderContext.m4369h().mo14169a((PreviewView) this);
                        if (this.f3917o != null) {
                            EffectRenderContext h = EffectRenderContext.m4369h();
                            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                            h.mo14177a(this.f3917o);
                        }
                        if (f3853aS == 1) {
                            Log.i(f3843aI, "has watch init ");
                            EffectRenderContext.m4369h().mo14225k(true);
                            this.f3905c = GLES20Utils.m4016a().newInstance(new Object[]{false});
                            EffectRenderContext.m4369h().mo14175a(this.f3905c);
                            Log.i(f3843aI, "newInstance SurfaceTexture:" + this.f3905c + "PreviewTexture:" + this.f3917o);
                            this.f3918p = false;
                        } else {
                            EffectRenderContext h2 = EffectRenderContext.m4369h();
                            C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
                            this.f3905c = h2.mo14241y();
                            if (this.f3905c == null) {
                                this.f3905c = GLES20Utils.m4016a().newInstance(new Object[]{false});
                                EffectRenderContext.m4369h().mo14175a(this.f3905c);
                                Log.i(f3843aI, "newInstance SurfaceTexture:" + this.f3905c + "PreviewTexture:" + this.f3917o);
                                this.f3918p = false;
                            } else {
                                Log.i(f3843aI, "useInstance SurfaceTexture:" + this.f3905c + "PreviewTexture:" + this.f3917o);
                            }
                        }
                        EffectRenderContext h3 = EffectRenderContext.m4369h();
                        C3443i.m21152a((Object) h3, "EffectRenderContext.getInstance()");
                        if (!h3.mo14216g()) {
                            EffectRenderContext h4 = EffectRenderContext.m4369h();
                            C3443i.m21152a((Object) h4, "EffectRenderContext.getInstance()");
                            this.f3907e = h4.mo14198c();
                            if (this.f3907e == null) {
                                Log.e(f3843aI, " EffectRenderContext.getInstance().getNeedNewSurfaceTexture() is false mBitmapSurfaceTexture is null");
                                this.f3907e = this.f3905c;
                            }
                        } else {
                            this.f3907e = this.f3905c;
                        }
                        f3853aS++;
                        Log.i(f3843aI, "count:" + f3853aS);
                        EffectRenderContext.m4369h().mo14178a((PreviewView) this, this.f3905c);
                        EffectRenderContext.m4369h().mo14175a(this.f3905c);
                        EffectRenderContext h5 = EffectRenderContext.m4369h();
                        C3443i.m21152a((Object) h5, "EffectRenderContext.getInstance()");
                        h5.mo14200c(this.f3905c);
                        if (this.f3911i != null) {
                            PreviewView.C1194c cVar = this.f3911i;
                            if (cVar == null) {
                                C3443i.m21151a();
                            }
                            cVar.mo14347a(this.f3905c, this.f3914l, this.f3915m);
                        }
                    } catch (Exception e) {
                        Log.e(f3843aI, "error:" + e.getMessage());
                    }
                } else if (this.f3911i != null) {
                    PreviewView.C1194c cVar2 = this.f3911i;
                    if (cVar2 == null) {
                        C3443i.m21151a();
                    }
                    cVar2.mo14347a(this.f3905c, this.f3914l, this.f3915m);
                }
                if (this.f3871Q && !this.f3872R && this.f3924v != null) {
                    this.f3872R = true;
                    C1176a aVar = this.f3924v;
                    if (aVar == null) {
                        C3443i.m21151a();
                    }
                    aVar.mo14259a(this);
                    C1176a aVar2 = this.f3924v;
                    if (aVar2 == null) {
                        C3443i.m21151a();
                    }
                    aVar2.mo14258a();
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: e */
    public final void mo14245e() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 354, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3909g) {
                Log.i(f3843aI, "MzSurfaceView init ");
                if (this.f3906d == null) {
                    try {
                        this.f3917o = EffectRenderContext.m4369h().mo14169a((PreviewView) this);
                        if (this.f3917o != null) {
                            EffectRenderContext h = EffectRenderContext.m4369h();
                            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                            h.mo14177a(this.f3917o);
                        }
                        if (f3853aS == 1) {
                            Log.i(f3843aI, "has watch init ");
                            EffectRenderContext.m4369h().mo14225k(true);
                            this.f3906d = new SurfaceTextureWrapper(false);
                            EffectRenderContext.m4369h().mo14181a(this.f3906d);
                            Log.i(f3843aI, "newInstance SurfaceTexture:" + this.f3906d + "PreviewTexture:" + this.f3917o);
                            this.f3918p = false;
                        } else {
                            EffectRenderContext h2 = EffectRenderContext.m4369h();
                            C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
                            this.f3906d = h2.mo14242z();
                            if (this.f3906d == null) {
                                this.f3906d = new SurfaceTextureWrapper(false);
                                EffectRenderContext.m4369h().mo14181a(this.f3906d);
                                Log.i(f3843aI, "newInstance SurfaceTexture:" + this.f3906d + "PreviewTexture:" + this.f3917o);
                                this.f3918p = false;
                            } else {
                                Log.i(f3843aI, "useInstance SurfaceTexture:" + this.f3906d + "PreviewTexture:" + this.f3917o);
                            }
                        }
                        this.f3908f = this.f3906d;
                        f3853aS++;
                        Log.i(f3843aI, "count:" + f3853aS);
                        EffectRenderContext.m4369h().mo14180a((PreviewView) this, this.f3906d);
                        EffectRenderContext.m4369h().mo14181a(this.f3906d);
                        EffectRenderContext.m4369h().f3806c = this.f3906d;
                        if (this.f3912j != null) {
                            PreviewView.C1195d dVar = this.f3912j;
                            if (dVar == null) {
                                C3443i.m21151a();
                            }
                            dVar.mo14352a(this.f3906d, this.f3914l, this.f3915m);
                        }
                    } catch (Exception e) {
                        Log.e(f3843aI, "error:" + e.getMessage());
                    }
                } else if (this.f3912j != null) {
                    PreviewView.C1195d dVar2 = this.f3912j;
                    if (dVar2 == null) {
                        C3443i.m21151a();
                    }
                    dVar2.mo14352a(this.f3906d, this.f3914l, this.f3915m);
                }
                if (this.f3871Q && !this.f3872R && this.f3924v != null) {
                    this.f3872R = true;
                    C1176a aVar = this.f3924v;
                    if (aVar == null) {
                        C3443i.m21151a();
                    }
                    aVar.mo14259a(this);
                    C1176a aVar2 = this.f3924v;
                    if (aVar2 == null) {
                        C3443i.m21151a();
                    }
                    aVar2.mo14258a();
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: h */
    public void mo14116h() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 355, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3843aI, "release");
            if (this.f3924v != null) {
                C1176a aVar = this.f3924v;
                if (aVar == null) {
                    C3443i.m21151a();
                }
                aVar.mo14262d();
            }
            if (!this.f3871Q && this.f3924v != null && this.f3872R) {
                C1176a aVar2 = this.f3924v;
                if (aVar2 == null) {
                    C3443i.m21151a();
                }
                aVar2.mo14263e();
                this.f3872R = false;
            }
        }
    }

    /* renamed from: j */
    public void mo14118j() {
        int i = 0;
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 356, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3843aI, "ReleaseSurfaceTexture");
            if (Build.VERSION.SDK_INT >= 29) {
                synchronized (this.f3909g) {
                    EffectRenderContext.m4369h().f3806c = null;
                    EffectRenderContext h = EffectRenderContext.m4369h();
                    C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                    List<SurfaceTextureWrapper> b = h.mo14189b();
                    C3443i.m21152a((Object) b, "surfaceTextureList");
                    int size = b.size();
                    while (i < size) {
                        SurfaceTextureWrapper surfaceTextureWrapper = b.get(i);
                        surfaceTextureWrapper.setOnFrameAvailableListener((SurfaceTextureWrapper.C1568a) null);
                        String str = f3843aI;
                        Log.i(str, "ReleaseSurfaceTexture:" + surfaceTextureWrapper);
                        if (this.f3912j != null) {
                            PreviewView.C1195d dVar = this.f3912j;
                            if (dVar == null) {
                                C3443i.m21151a();
                            }
                            dVar.mo14355b(surfaceTextureWrapper);
                        }
                        i++;
                    }
                    EffectRenderContext.m4369h().mo14208e();
                    Unit tVar = Unit.f18749a;
                }
                return;
            }
            synchronized (this.f3909g) {
                EffectRenderContext h2 = EffectRenderContext.m4369h();
                C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
                h2.mo14200c((SurfaceTexture) null);
                EffectRenderContext h3 = EffectRenderContext.m4369h();
                C3443i.m21152a((Object) h3, "EffectRenderContext.getInstance()");
                List<SurfaceTexture> a = h3.mo14171a();
                C3443i.m21152a((Object) a, "surfaceTextureList");
                int size2 = a.size();
                while (i < size2) {
                    SurfaceTexture surfaceTexture = a.get(i);
                    surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                    String str2 = f3843aI;
                    Log.i(str2, "ReleaseSurfaceTexture:" + surfaceTexture);
                    if (this.f3911i != null) {
                        PreviewView.C1194c cVar = this.f3911i;
                        if (cVar == null) {
                            C3443i.m21151a();
                        }
                        cVar.mo14351c(surfaceTexture);
                    }
                    i++;
                }
                EffectRenderContext.m4369h().mo14208e();
                Unit tVar2 = Unit.f18749a;
            }
        }
    }

    /* renamed from: f */
    public void mo14108f() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 357, new Class[0], Void.TYPE).isSupported) {
            if (Build.VERSION.SDK_INT >= 29) {
                mo14246g();
                return;
            }
            synchronized (this.f3909g) {
                Log.i(f3843aI, "resumeSurfaceTexture ");
                try {
                    this.f3905c = GLES20Utils.m4016a().newInstance(new Object[]{false});
                    EffectRenderContext.m4369h().mo14175a(this.f3905c);
                    String str = f3843aI;
                    Log.i(str, "newInstance SurfaceTexture:" + this.f3905c + "PreviewTexture:" + this.f3917o);
                    this.f3918p = false;
                    EffectRenderContext h = EffectRenderContext.m4369h();
                    C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                    if (!h.mo14216g()) {
                        EffectRenderContext h2 = EffectRenderContext.m4369h();
                        C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
                        this.f3907e = h2.mo14198c();
                        if (this.f3907e == null) {
                            Log.e(f3843aI, " EffectRenderContext.getInstance().getNeedNewSurfaceTexture() is false mBitmapSurfaceTexture is null");
                            this.f3907e = this.f3905c;
                        }
                    } else {
                        this.f3907e = this.f3905c;
                    }
                    String str2 = f3843aI;
                    Log.i(str2, "count:" + f3853aS);
                    EffectRenderContext.m4369h().mo14178a((PreviewView) this, this.f3905c);
                    EffectRenderContext h3 = EffectRenderContext.m4369h();
                    C3443i.m21152a((Object) h3, "EffectRenderContext.getInstance()");
                    h3.mo14200c(this.f3905c);
                    if (this.f3911i != null) {
                        PreviewView.C1194c cVar = this.f3911i;
                        if (cVar == null) {
                            C3443i.m21151a();
                        }
                        cVar.mo14347a(this.f3905c, this.f3914l, this.f3915m);
                    }
                    Unit tVar = Unit.f18749a;
                } catch (Exception e) {
                    String str3 = f3843aI;
                    Integer.valueOf(Log.e(str3, "error:" + e.getMessage()));
                }
            }
            return;
        }
        return;
    }

    /* renamed from: g */
    public final void mo14246g() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 358, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3909g) {
                Log.i(f3843aI, "resumeSurfaceTexture ");
                try {
                    this.f3906d = new SurfaceTextureWrapper(false);
                    EffectRenderContext.m4369h().mo14181a(this.f3906d);
                    String str = f3843aI;
                    Log.i(str, "newInstance SurfaceTexture:" + this.f3906d + "PreviewTexture:" + this.f3917o);
                    this.f3918p = false;
                    this.f3908f = this.f3906d;
                    String str2 = f3843aI;
                    Log.i(str2, "count:" + f3853aS);
                    EffectRenderContext.m4369h().mo14180a((PreviewView) this, this.f3906d);
                    EffectRenderContext.m4369h().f3806c = this.f3906d;
                    if (this.f3912j != null) {
                        PreviewView.C1195d dVar = this.f3912j;
                        if (dVar == null) {
                            C3443i.m21151a();
                        }
                        dVar.mo14352a(this.f3906d, this.f3914l, this.f3915m);
                    }
                    Unit tVar = Unit.f18749a;
                } catch (Exception e) {
                    String str3 = f3843aI;
                    Integer.valueOf(Log.e(str3, "error:" + e.getMessage()));
                }
            }
            return;
        }
        return;
    }

    /* renamed from: k */
    public void mo14119k() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 359, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3843aI, "onResume");
            this.f3894ap = false;
            if (this.f3869O != null) {
                if (this.f3856B != null) {
                    EffectRenderContext h = EffectRenderContext.m4369h();
                    BaseRender aVar = this.f3856B;
                    if (aVar == null) {
                        C3443i.m21151a();
                    }
                    EffectRenderFactory.C1191c c = aVar.mo14046c();
                    C3443i.m21152a((Object) c, "mRender!!.type");
                    if (!h.mo14197b(c.mo14345d())) {
                        EffectRenderFactory bVar = this.f3869O;
                        if (bVar == null) {
                            C3443i.m21151a();
                        }
                        BaseRender aVar2 = this.f3856B;
                        if (aVar2 == null) {
                            C3443i.m21151a();
                        }
                        this.f3856B = bVar.mo14319a(aVar2.mo14046c());
                    }
                }
                if (this.f3898at != null) {
                    EffectRenderContext h2 = EffectRenderContext.m4369h();
                    BaseRender aVar3 = this.f3898at;
                    if (aVar3 == null) {
                        C3443i.m21151a();
                    }
                    EffectRenderFactory.C1191c c2 = aVar3.mo14046c();
                    C3443i.m21152a((Object) c2, "mVfbRender!!.type");
                    if (!h2.mo14197b(c2.mo14345d())) {
                        EffectRenderFactory bVar2 = this.f3869O;
                        if (bVar2 == null) {
                            C3443i.m21151a();
                        }
                        BaseRender aVar4 = this.f3898at;
                        if (aVar4 == null) {
                            C3443i.m21151a();
                        }
                        this.f3898at = bVar2.mo14319a(aVar4.mo14046c());
                    }
                }
            }
        }
    }

    /* renamed from: l */
    public void mo14120l() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 360, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3843aI, "onPause");
            this.f3894ap = true;
            if (this.f3924v != null) {
                C1176a aVar = this.f3924v;
                if (aVar == null) {
                    C3443i.m21151a();
                }
                aVar.mo14260b();
            }
        }
    }

    public void setEffectRenderFactory(@NotNull EffectRenderFactory bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f3835a, false, 361, new Class[]{EffectRenderFactory.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar, "factory");
            this.f3869O = bVar;
            if (this.f3869O != null) {
                EffectRenderFactory bVar2 = this.f3869O;
                if (bVar2 == null) {
                    C3443i.m21151a();
                }
                this.f3860F = bVar2.mo14326b();
                EffectRenderFactory bVar3 = this.f3869O;
                if (bVar3 == null) {
                    C3443i.m21151a();
                }
                this.f3861G = bVar3.mo14328c();
                EffectRenderFactory bVar4 = this.f3869O;
                if (bVar4 == null) {
                    C3443i.m21151a();
                }
                this.f3862H = bVar4.mo14331d();
                EffectRenderFactory bVar5 = this.f3869O;
                if (bVar5 == null) {
                    C3443i.m21151a();
                }
                this.f3863I = bVar5.mo14333e();
                EffectRenderFactory bVar6 = this.f3869O;
                if (bVar6 == null) {
                    C3443i.m21151a();
                }
                this.f3864J = bVar6.mo14334f();
                EffectRenderContext.m4369h().mo14174a(this.f3861G, this.f3862H, this.f3863I, this.f3864J);
                EffectRenderContext.m4369h().mo14174a(this.f3861G, this.f3862H, this.f3863I, this.f3864J);
                String str = f3843aI;
                Log.i(str, "mDeviceType " + this.f3860F + " mDevicePlatform " + this.f3861G + " mNeedFBThumnail " + this.f3862H + " misUseFBHigherLib " + this.f3863I + " mSupportFBandEffectOverlay" + this.f3864J);
                return;
            }
            Log.i(f3843aI, "mDeviceType is null ");
        }
    }

    /* renamed from: c */
    public void mo14105c() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 362, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3843aI, "initSurfaceTextureBitmap");
            SurfaceTextureBitmap.m6367a();
        }
    }

    public void setSurfaceTextureBitmap(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 363, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            setSurfaceTextureBitmap(i, 2, true);
        }
    }

    public void setSurfaceTextureBitmap(int i, int i2, boolean z) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 364, new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3909g) {
                SurfaceTextureBitmap.m6368a(true);
                String str = f3843aI;
                Log.i(str, "setSurfaceTextureBitmap rotation " + i + " factor " + i2);
                this.f3900av = true;
                this.f3901aw = i2;
                Unit tVar = Unit.f18749a;
            }
        }
    }

    public void setSurfaceTextureBitmap(int i, int i2, boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f3835a, false, 365, new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            setSurfaceTextureBitmap(i, i2, z2);
            if (z) {
                this.f3865K = f3854b.mo14268a(this.f3865K);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView$CloseVFBRunnable;", "Ljava/lang/Runnable;", "mBaseRender", "Lcom/meizu/camera/effectlib/effects/renders/BaseRender;", "(Lcom/meizu/camera/effectlib/effects/renders/BaseRender;)V", "getMBaseRender", "()Lcom/meizu/camera/effectlib/effects/renders/BaseRender;", "setMBaseRender", "run", "", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.views.MzSurfaceView$c */
    /* compiled from: MzSurfaceView.kt */
    protected static final class C1179c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f3939a;
        @Nullable

        /* renamed from: b */
        private BaseRender f3940b;

        public C1179c(@Nullable BaseRender aVar) {
            this.f3940b = aVar;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f3939a, false, 403, new Class[0], Void.TYPE).isSupported) {
                String n = MzSurfaceView.f3843aI;
                StringBuilder sb = new StringBuilder();
                sb.append("CloseVFBRunnable render:");
                BaseRender aVar = this.f3940b;
                if (aVar == null) {
                    C3443i.m21151a();
                }
                sb.append(aVar);
                Log.e(n, sb.toString());
                if (this.f3940b != null) {
                    BaseRender aVar2 = this.f3940b;
                    if (aVar2 == null) {
                        C3443i.m21151a();
                    }
                    aVar2.mo14048d();
                    this.f3940b = null;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        if (kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r0.mo14345d(), (java.lang.Object) "Mzmake up") != false) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setRenderType(@org.jetbrains.annotations.NotNull java.lang.String r9) {
        /*
            r8 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            com.meizu.savior.ChangeQuickRedirect r3 = f3835a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r6[r2] = r4
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 366(0x16e, float:5.13E-43)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            java.lang.String r1 = "renderType"
            kotlin.jvm.p108b.C3443i.m21155b(r9, r1)
            com.meizu.camera.effectlib.effects.views.b r1 = r8.f3869O
            if (r1 != 0) goto L_0x0029
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0029:
            com.meizu.camera.effectlib.effects.views.b$c r9 = r1.mo14321a((java.lang.String) r9)
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3856B
            if (r1 == 0) goto L_0x0043
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3856B
            if (r1 != 0) goto L_0x0038
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0038:
            com.meizu.camera.effectlib.effects.views.b$c r1 = r1.mo14046c()
            boolean r1 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r1, (java.lang.Object) r9)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x00ff
        L_0x0043:
            com.meizu.camera.effectlib.effects.b.a r0 = r8.f3856B
            if (r0 == 0) goto L_0x00da
            com.meizu.camera.effectlib.effects.b.a r0 = r8.f3856B
            if (r0 != 0) goto L_0x004e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x004e:
            com.meizu.camera.effectlib.effects.views.b$c r0 = r0.mo14046c()
            java.lang.String r1 = "mRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.mo14345d()
            java.lang.String r1 = "Mzvfacebeauty"
            boolean r0 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x007f
            com.meizu.camera.effectlib.effects.b.a r0 = r8.f3856B
            if (r0 != 0) goto L_0x006a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x006a:
            com.meizu.camera.effectlib.effects.views.b$c r0 = r0.mo14046c()
            java.lang.String r1 = "mRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.mo14345d()
            java.lang.String r1 = "Mzmake up"
            boolean r0 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00da
        L_0x007f:
            java.lang.String r0 = f3843aI
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Render:"
            r1.append(r2)
            com.meizu.camera.effectlib.effects.b.a r2 = r8.f3856B
            r1.append(r2)
            java.lang.String r2 = " renderType:"
            r1.append(r2)
            com.meizu.camera.effectlib.effects.b.a r2 = r8.f3856B
            if (r2 != 0) goto L_0x009c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x009c:
            com.meizu.camera.effectlib.effects.views.b$c r2 = r2.mo14046c()
            java.lang.String r3 = "mRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r2 = r2.mo14345d()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3856B
            if (r1 != 0) goto L_0x00be
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00be:
            com.meizu.camera.effectlib.effects.views.b$c r1 = r1.mo14046c()
            java.lang.String r2 = "mRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.mo14345d()
            r0.mo14202c((java.lang.String) r1)
            java.util.Vector<java.lang.Runnable> r0 = r8.f3919q
            com.meizu.camera.effectlib.effects.views.MzSurfaceView$c r1 = new com.meizu.camera.effectlib.effects.views.MzSurfaceView$c
            com.meizu.camera.effectlib.effects.b.a r2 = r8.f3856B
            r1.<init>(r2)
            r0.add(r1)
        L_0x00da:
            com.meizu.camera.effectlib.effects.views.b r0 = r8.f3869O
            if (r0 != 0) goto L_0x00e1
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00e1:
            com.meizu.camera.effectlib.effects.b.a r9 = r0.mo14319a((com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c) r9)
            r8.f3856B = r9
            java.lang.String r9 = f3843aI
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setRenderType   mRender "
            r0.append(r1)
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3856B
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r9, r0)
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzSurfaceView.setRenderType(java.lang.String):void");
    }

    public void setRender(@NotNull BaseRender aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f3835a, false, 367, new Class[]{BaseRender.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(aVar, "render");
            String str = f3843aI;
            Log.i(str, "setRender   mRender " + aVar);
            this.f3856B = aVar;
            if (this.f3898at != null) {
                this.f3898at = aVar;
            }
        }
    }

    public int getViewWidth() {
        return this.f3857C;
    }

    public int getViewHeight() {
        return this.f3858D;
    }

    public void setViewAlpha(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 368, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            setAlpha(f);
        }
    }

    public void setBokehStatus(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 369, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3909g) {
                Log.v("camPreviewRenderView", "setBokehStatus:" + z);
                if (!z) {
                    if (this.f3925w != null) {
                        C1178b bVar = this.f3925w;
                        if (bVar == null) {
                            C3443i.m21151a();
                        }
                        bVar.removeMessages(f3839aE);
                    }
                    this.f3873S = z;
                    this.f3875U = z;
                    if (this.f3876V != null) {
                        this.f3876V = null;
                    }
                } else if (this.f3925w != null) {
                    C1178b bVar2 = this.f3925w;
                    if (bVar2 == null) {
                        C3443i.m21151a();
                    }
                    bVar2.sendEmptyMessageDelayed(f3839aE, f3840aF);
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    public void setTofStatus(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 370, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3909g) {
                Log.v("camPreviewRenderView", "setTofStatus:" + z);
                if (!z) {
                    if (this.f3925w != null) {
                        C1178b bVar = this.f3925w;
                        if (bVar == null) {
                            C3443i.m21151a();
                        }
                        bVar.removeMessages(f3841aG);
                    }
                    this.f3874T = z;
                    if (this.f3876V != null) {
                        this.f3876V = null;
                    }
                } else if (this.f3925w != null) {
                    C1178b bVar2 = this.f3925w;
                    if (bVar2 == null) {
                        C3443i.m21151a();
                    }
                    bVar2.sendEmptyMessageDelayed(f3841aG, f3842aH);
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    public void setPreviewData(@NotNull byte[] bArr, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3)}, this, f3835a, false, 371, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(bArr, "data");
            if (this.f3876V == null) {
                String str = f3843aI;
                Log.v(str, "setPreviewData:" + i + "x" + i2);
                this.f3876V = new byte[(((i3 * i2) * 3) / 2)];
                this.f3877W = i;
                this.f3879aa = i2;
                this.f3880ab = i3;
            } else if (!(this.f3877W == i && this.f3879aa == i2)) {
                String str2 = f3843aI;
                Log.v(str2, "setPreviewData:" + i + "x" + i2);
                this.f3876V = new byte[(((i3 * i2) * 3) / 2)];
                this.f3877W = i;
                this.f3879aa = i2;
                this.f3880ab = i3;
            }
            this.f3876V = bArr;
        }
    }

    public void setPreviewBitmap(@Nullable Bitmap bitmap, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{bitmap, new Integer(i), new Integer(i2)}, this, f3835a, false, 372, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            throw new Standard("An operation is not implemented: " + "not implemented");
        }
    }

    public void setShowBitmap(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f3835a, false, 373, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            throw new Standard("An operation is not implemented: " + "not implemented");
        }
    }

    public void setBokehListener(@NotNull PreviewView.C1192a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f3835a, false, 374, new Class[]{PreviewView.C1192a.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(aVar, "listener");
            this.f3913k = aVar;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public final void m4463D() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 375, new Class[0], Void.TYPE).isSupported) {
            Log.v(f3843aI, "initRenderProgram");
            YuvRenderProgram dVar = this.f3881ac;
            if (dVar == null) {
                C3443i.m21151a();
            }
            dVar.mo14359a();
            this.f3882ad = true;
            if (this.f3883ae == -1) {
                YuvRenderProgram dVar2 = this.f3881ac;
                if (dVar2 == null) {
                    C3443i.m21151a();
                }
                this.f3883ae = dVar2.mo14369i();
            }
            if (this.f3884af == -1) {
                YuvRenderProgram dVar3 = this.f3881ac;
                if (dVar3 == null) {
                    C3443i.m21151a();
                }
                this.f3884af = dVar3.mo14369i();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public final void m4466E() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 376, new Class[0], Void.TYPE).isSupported) {
            Log.v(f3843aI, "setupBuffers");
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.f3895aq = iArr[0];
            GLES20.glBindFramebuffer(36160, this.f3895aq);
            GLTexture cVar = this.f3896ar;
            if (cVar == null) {
                C3443i.m21151a();
            }
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, cVar.mo14028a(), 0);
            mo14243a("glFrameBufferTexture2D");
            m4467F();
            mo14243a("glClear setupBuffers");
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    /* renamed from: F */
    private final void m4467F() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 377, new Class[0], Void.TYPE).isSupported) {
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            mo14243a("glCheckFramebufferStatus");
            if (glCheckFramebufferStatus == 36057) {
                Log.e(f3843aI, "incomplete dimensions");
            } else if (glCheckFramebufferStatus != 36061) {
                switch (glCheckFramebufferStatus) {
                    case 36053:
                        Log.e(f3843aI, "complete");
                        return;
                    case 36054:
                        Log.e(f3843aI, "incomplete attachment");
                        return;
                    case 36055:
                        Log.e(f3843aI, "incomplete missing attachment");
                        return;
                    default:
                        Log.e(f3843aI, "default");
                        return;
                }
            } else {
                Log.e(f3843aI, "framebuffer unsupported");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public final void m4469G() {
        if (!PatchProxy.proxy(new Object[0], this, f3835a, false, 378, new Class[0], Void.TYPE).isSupported && this.f3895aq != -1) {
            GLES20.glDeleteBuffers(1, new int[]{this.f3895aq}, 0);
            mo14243a("glDeleteBuffers deleteFrameBuffer");
            this.f3895aq = -1;
        }
    }

    /* renamed from: a */
    public final void mo14243a(@NotNull String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f3835a, false, 379, new Class[]{String.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str, NotificationCompat.CATEGORY_MESSAGE);
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                String str2 = f3843aI;
                Log.e(str2, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
                throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            }
        }
    }

    public void setYuvInput(boolean z) {
        this.f3875U = z;
    }

    /* renamed from: a */
    public int mo14098a(@NotNull byte[] bArr, @NotNull int[] iArr, @NotNull int[] iArr2) {
        int i;
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, iArr, iArr2}, this, changeQuickRedirect, false, 380, new Class[]{byte[].class, int[].class, int[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(bArr, "yuv");
        C3443i.m21155b(iArr, "yuvSize");
        C3443i.m21155b(iArr2, "yuvStride");
        synchronized (this.f3909g) {
            if (!SurfaceTextureBitmap.m6369b()) {
                SurfaceTextureBitmap.m6368a(true);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                i = SurfaceTextureBitmap.m6363a(this.f3908f, bArr, iArr, iArr2, EffectRenderContext.m4369h().mo14188b(this.f3861G, this.f3862H, this.f3863I, this.f3864J));
            } else {
                i = SurfaceTextureBitmap.m6362a(this.f3907e, bArr, iArr, iArr2, EffectRenderContext.m4369h().mo14188b(this.f3861G, this.f3862H, this.f3863I, this.f3864J));
            }
        }
        return i;
    }

    @SuppressLint({"HandlerLeak"})
    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView$CameraPreviewRenderViewHandler;", "Landroid/os/Handler;", "view", "Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView;", "(Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView;Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView;)V", "mView", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.views.MzSurfaceView$b */
    /* compiled from: MzSurfaceView.kt */
    protected final class C1178b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f3936a;

        /* renamed from: b */
        final /* synthetic */ MzSurfaceView f3937b;

        /* renamed from: c */
        private final WeakReference<MzSurfaceView> f3938c;

        public C1178b(MzSurfaceView mzSurfaceView, @NotNull MzSurfaceView mzSurfaceView2) {
            C3443i.m21155b(mzSurfaceView2, "view");
            this.f3937b = mzSurfaceView;
            this.f3938c = new WeakReference<>(mzSurfaceView2);
        }

        public void handleMessage(@NotNull Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f3936a, false, 402, new Class[]{Message.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(message, NotificationCompat.CATEGORY_MESSAGE);
                MzSurfaceView mzSurfaceView = (MzSurfaceView) this.f3938c.get();
                if (mzSurfaceView != null && mzSurfaceView.f3911i != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        int i = message.what;
                        if (i == MzSurfaceView.f3836aB) {
                            PreviewView.C1195d b = mzSurfaceView.f3912j;
                            if (b == null) {
                                C3443i.m21151a();
                            }
                            b.mo14352a(mzSurfaceView.f3906d, mzSurfaceView.f3914l, mzSurfaceView.f3915m);
                        } else if (i == MzSurfaceView.f3837aC) {
                            PreviewView.C1195d b2 = mzSurfaceView.f3912j;
                            if (b2 == null) {
                                C3443i.m21151a();
                            }
                            b2.mo14356c(mzSurfaceView.f3906d);
                        } else if (i == MzSurfaceView.f3838aD) {
                            PreviewView.C1195d b3 = mzSurfaceView.f3912j;
                            if (b3 == null) {
                                C3443i.m21151a();
                            }
                            Object obj = message.obj;
                            if (obj != null) {
                                b3.mo14353a((SurfaceTextureWrapper) obj);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.meizu.imageproc.SurfaceTextureWrapper");
                            }
                        } else if (i == MzSurfaceView.f3839aE) {
                            Log.v("camPreviewRenderView", "enable bokeh");
                            this.f3937b.f3873S = true;
                            this.f3937b.f3875U = true;
                        } else if (i == MzSurfaceView.f3841aG) {
                            Log.v("camPreviewRenderView", "enable tof");
                            this.f3937b.f3874T = true;
                            this.f3937b.f3875U = true;
                        }
                    } else {
                        int i2 = message.what;
                        if (i2 == MzSurfaceView.f3836aB) {
                            PreviewView.C1194c a = mzSurfaceView.f3911i;
                            if (a == null) {
                                C3443i.m21151a();
                            }
                            a.mo14347a(mzSurfaceView.f3905c, mzSurfaceView.f3914l, mzSurfaceView.f3915m);
                        } else if (i2 == MzSurfaceView.f3837aC) {
                            PreviewView.C1194c a2 = mzSurfaceView.f3911i;
                            if (a2 == null) {
                                C3443i.m21151a();
                            }
                            a2.mo14349b(mzSurfaceView.f3905c);
                        } else if (i2 == MzSurfaceView.f3838aD) {
                            PreviewView.C1194c a3 = mzSurfaceView.f3911i;
                            if (a3 == null) {
                                C3443i.m21151a();
                            }
                            Object obj2 = message.obj;
                            if (obj2 != null) {
                                a3.mo14348a((SurfaceTexture) obj2);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type android.graphics.SurfaceTexture");
                            }
                        } else if (i2 == MzSurfaceView.f3839aE) {
                            Log.v("camPreviewRenderView", "enable bokeh");
                            this.f3937b.f3873S = true;
                            this.f3937b.f3875U = true;
                        } else if (i2 == MzSurfaceView.f3841aG) {
                            Log.v("camPreviewRenderView", "enable tof");
                            this.f3937b.f3874T = true;
                            this.f3937b.f3875U = true;
                        }
                    }
                    int i3 = message.what;
                    if (i3 == MzSurfaceView.f3836aB) {
                        PreviewView.C1194c a4 = mzSurfaceView.f3911i;
                        if (a4 == null) {
                            C3443i.m21151a();
                        }
                        a4.mo14347a(mzSurfaceView.f3905c, mzSurfaceView.f3914l, mzSurfaceView.f3915m);
                    } else if (i3 == MzSurfaceView.f3837aC) {
                        PreviewView.C1194c a5 = mzSurfaceView.f3911i;
                        if (a5 == null) {
                            C3443i.m21151a();
                        }
                        a5.mo14349b(mzSurfaceView.f3905c);
                    } else if (i3 == MzSurfaceView.f3838aD) {
                        PreviewView.C1194c a6 = mzSurfaceView.f3911i;
                        if (a6 == null) {
                            C3443i.m21151a();
                        }
                        Object obj3 = message.obj;
                        if (obj3 != null) {
                            a6.mo14348a((SurfaceTexture) obj3);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.SurfaceTexture");
                    } else if (i3 == MzSurfaceView.f3839aE) {
                        Log.v("camPreviewRenderView", "enable bokeh");
                        this.f3937b.f3873S = true;
                        this.f3937b.f3875U = true;
                    } else if (i3 == MzSurfaceView.f3841aG) {
                        Log.v("camPreviewRenderView", "enable tof");
                        this.f3937b.f3874T = true;
                        this.f3937b.f3875U = true;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        if (kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r0.mo14345d(), (java.lang.Object) "Mzmake up") != false) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setVfbRenderType(@org.jetbrains.annotations.NotNull java.lang.String r9) {
        /*
            r8 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            com.meizu.savior.ChangeQuickRedirect r3 = f3835a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r6[r2] = r4
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 381(0x17d, float:5.34E-43)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            java.lang.String r1 = "renderType"
            kotlin.jvm.p108b.C3443i.m21155b(r9, r1)
            boolean r1 = r8.f3864J
            if (r1 != 0) goto L_0x002e
            java.lang.String r9 = f3843aI
            java.lang.String r0 = "not SupportFBandEffectOverlay"
            android.util.Log.i(r9, r0)
            return
        L_0x002e:
            com.meizu.camera.effectlib.effects.views.b r1 = r8.f3869O
            if (r1 != 0) goto L_0x0035
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0035:
            com.meizu.camera.effectlib.effects.views.b$c r9 = r1.mo14321a((java.lang.String) r9)
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3898at
            if (r1 == 0) goto L_0x004f
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3898at
            if (r1 != 0) goto L_0x0044
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0044:
            com.meizu.camera.effectlib.effects.views.b$c r1 = r1.mo14046c()
            boolean r1 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r1, (java.lang.Object) r9)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x010b
        L_0x004f:
            com.meizu.camera.effectlib.effects.b.a r0 = r8.f3898at
            if (r0 == 0) goto L_0x00e6
            com.meizu.camera.effectlib.effects.b.a r0 = r8.f3898at
            if (r0 != 0) goto L_0x005a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x005a:
            com.meizu.camera.effectlib.effects.views.b$c r0 = r0.mo14046c()
            java.lang.String r1 = "mVfbRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.mo14345d()
            java.lang.String r1 = "Mzvfacebeauty"
            boolean r0 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x008b
            com.meizu.camera.effectlib.effects.b.a r0 = r8.f3898at
            if (r0 != 0) goto L_0x0076
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0076:
            com.meizu.camera.effectlib.effects.views.b$c r0 = r0.mo14046c()
            java.lang.String r1 = "mVfbRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.mo14345d()
            java.lang.String r1 = "Mzmake up"
            boolean r0 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00e6
        L_0x008b:
            java.lang.String r0 = f3843aI
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ":"
            r1.append(r2)
            com.meizu.camera.effectlib.effects.b.a r2 = r8.f3898at
            r1.append(r2)
            java.lang.String r2 = " renderType:"
            r1.append(r2)
            com.meizu.camera.effectlib.effects.b.a r2 = r8.f3898at
            if (r2 != 0) goto L_0x00a8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00a8:
            com.meizu.camera.effectlib.effects.views.b$c r2 = r2.mo14046c()
            java.lang.String r3 = "mVfbRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r2 = r2.mo14345d()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3898at
            if (r1 != 0) goto L_0x00ca
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ca:
            com.meizu.camera.effectlib.effects.views.b$c r1 = r1.mo14046c()
            java.lang.String r2 = "mVfbRender!!.type"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.mo14345d()
            r0.mo14202c((java.lang.String) r1)
            java.util.Vector<java.lang.Runnable> r0 = r8.f3919q
            com.meizu.camera.effectlib.effects.views.MzSurfaceView$c r1 = new com.meizu.camera.effectlib.effects.views.MzSurfaceView$c
            com.meizu.camera.effectlib.effects.b.a r2 = r8.f3898at
            r1.<init>(r2)
            r0.add(r1)
        L_0x00e6:
            com.meizu.camera.effectlib.effects.views.b r0 = r8.f3869O
            if (r0 != 0) goto L_0x00ed
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00ed:
            com.meizu.camera.effectlib.effects.b.a r9 = r0.mo14319a((com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c) r9)
            r8.f3898at = r9
            java.lang.String r9 = f3843aI
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setVfbRenderType   mVfbRender "
            r0.append(r1)
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3898at
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r9, r0)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzSurfaceView.setVfbRenderType(java.lang.String):void");
    }

    public void setCleanScreen(boolean z) {
        this.f3899au = z;
    }

    /* renamed from: a */
    public void mo14102a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3835a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 382, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "enableDraw :" + z);
            this.f3878aA = z;
            if (!z2) {
                return;
            }
            if (this.f3878aA) {
                setViewAlpha(1.0f);
            } else {
                setViewAlpha(0.0f);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\fH\u0002J\u0006\u0010\u0013\u001a\u00020\fJ\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\fJ\b\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\fH\u0002J\b\u0010&\u001a\u00020\fH\u0002J\u0006\u0010'\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView$CameraPreviewRender;", "", "(Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView;)V", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "mOESTextureId", "", "mPreviewView", "Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView;", "attach", "", "checkEglError", "msg", "", "destroy", "detach", "detachTex", "draw", "drawFrame", "data", "", "drawTexture", "transformMatrix", "", "mvpMatrix", "getGpuBitmap", "Landroid/graphics/Bitmap;", "width", "height", "factor", "init", "previewView", "initEGL", "initTex", "onDestroyGL", "onDraw", "onRelease", "release", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.views.MzSurfaceView$a */
    /* compiled from: MzSurfaceView.kt */
    private final class C1176a {

        /* renamed from: a */
        public static ChangeQuickRedirect f3929a;

        /* renamed from: c */
        private HandlerThread f3931c;

        /* renamed from: d */
        private MzSurfaceView f3932d;

        /* renamed from: e */
        private Handler f3933e;

        public C1176a() {
        }

        /* renamed from: a */
        public final void mo14259a(@NotNull MzSurfaceView mzSurfaceView) {
            if (!PatchProxy.proxy(new Object[]{mzSurfaceView}, this, f3929a, false, 385, new Class[]{MzSurfaceView.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(mzSurfaceView, "previewView");
                Log.d("GLRenderer", "init");
                this.f3932d = mzSurfaceView;
                this.f3931c = new HandlerThread("SurfaceView Renderer Thread");
                HandlerThread handlerThread = this.f3931c;
                if (handlerThread == null) {
                    C3443i.m21151a();
                }
                handlerThread.start();
                HandlerThread handlerThread2 = this.f3931c;
                if (handlerThread2 == null) {
                    C3443i.m21151a();
                }
                this.f3933e = new C1177a(this, handlerThread2.getLooper());
                Handler handler = this.f3933e;
                if (handler == null) {
                    C3443i.m21151a();
                }
                handler.sendEmptyMessage(MzSurfaceView.f3844aJ);
            }
        }

        @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo27294d2 = {"com/meizu/camera/effectlib/effects/views/MzSurfaceView$CameraPreviewRender$init$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
        /* renamed from: com.meizu.camera.effectlib.effects.views.MzSurfaceView$a$a */
        /* compiled from: MzSurfaceView.kt */
        public static final class C1177a extends Handler {

            /* renamed from: a */
            public static ChangeQuickRedirect f3934a;

            /* renamed from: b */
            final /* synthetic */ C1176a f3935b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1177a(C1176a aVar, Looper looper) {
                super(looper);
                this.f3935b = aVar;
            }

            public void handleMessage(@NotNull Message message) {
                if (!PatchProxy.proxy(new Object[]{message}, this, f3934a, false, 401, new Class[]{Message.class}, Void.TYPE).isSupported) {
                    C3443i.m21155b(message, NotificationCompat.CATEGORY_MESSAGE);
                    int i = message.what;
                    if (i == MzSurfaceView.f3844aJ) {
                        this.f3935b.mo14264f();
                    } else if (i == MzSurfaceView.f3847aM) {
                        this.f3935b.m4595i();
                        this.f3935b.m4597k();
                    } else if (i == MzSurfaceView.f3849aO) {
                        this.f3935b.m4596j();
                    } else if (i == MzSurfaceView.f3845aK) {
                        this.f3935b.m4597k();
                    } else if (i == MzSurfaceView.f3848aN) {
                        this.f3935b.m4594h();
                    } else if (i == MzSurfaceView.f3846aL) {
                        this.f3935b.m4593g();
                    }
                }
            }
        }

        /* renamed from: a */
        public final void mo14258a() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 386, new Class[0], Void.TYPE).isSupported && this.f3933e != null) {
                Handler handler = this.f3933e;
                if (handler == null) {
                    C3443i.m21151a();
                }
                handler.sendEmptyMessage(MzSurfaceView.f3847aM);
            }
        }

        /* renamed from: b */
        public final void mo14260b() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 387, new Class[0], Void.TYPE).isSupported && this.f3933e != null) {
                Handler handler = this.f3933e;
                if (handler == null) {
                    C3443i.m21151a();
                }
                handler.sendEmptyMessage(MzSurfaceView.f3849aO);
            }
        }

        /* renamed from: c */
        public final void mo14261c() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 388, new Class[0], Void.TYPE).isSupported && this.f3933e != null) {
                Handler handler = this.f3933e;
                if (handler == null) {
                    C3443i.m21151a();
                }
                handler.sendEmptyMessage(MzSurfaceView.f3845aK);
            }
        }

        /* renamed from: d */
        public final void mo14262d() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 389, new Class[0], Void.TYPE).isSupported && this.f3933e != null) {
                Handler handler = this.f3933e;
                if (handler == null) {
                    C3443i.m21151a();
                }
                handler.sendEmptyMessage(MzSurfaceView.f3848aN);
            }
        }

        /* renamed from: e */
        public final void mo14263e() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 390, new Class[0], Void.TYPE).isSupported && this.f3933e != null) {
                Handler handler = this.f3933e;
                if (handler == null) {
                    C3443i.m21151a();
                }
                handler.sendEmptyMessage(MzSurfaceView.f3846aL);
            }
        }

        /* renamed from: f */
        public final void mo14264f() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 391, new Class[0], Void.TYPE).isSupported) {
                Log.d("GLRenderer", "initEGL");
                MzSurfaceView.this.f3926x = EGL14.eglGetDisplay(0);
                if (MzSurfaceView.this.f3926x != EGL14.EGL_NO_DISPLAY) {
                    int[] iArr = new int[2];
                    if (EGL14.eglInitialize(MzSurfaceView.this.f3926x, iArr, 0, iArr, 1)) {
                        EGL14.eglChooseConfig(MzSurfaceView.this.f3926x, new int[]{12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344}, 0, MzSurfaceView.this.f3928z, 0, MzSurfaceView.this.f3928z.length, new int[1], 0);
                        m4586a("eglChooseConfig");
                        int[] iArr2 = {12440, 2, 12344};
                        int[] iArr3 = {12344};
                        MzSurfaceView mzSurfaceView = this.f3932d;
                        if (mzSurfaceView == null) {
                            C3443i.m21151a();
                        }
                        SurfaceHolder holder = mzSurfaceView.getHolder();
                        if (holder != null) {
                            MzSurfaceView mzSurfaceView2 = this.f3932d;
                            if (mzSurfaceView2 == null) {
                                C3443i.m21151a();
                            }
                            if (mzSurfaceView2.f3871Q) {
                                MzSurfaceView.this.f3855A = EGL14.eglCreateWindowSurface(MzSurfaceView.this.f3926x, MzSurfaceView.this.f3928z[0], holder, iArr3, 0);
                                m4586a("eglCreateWindowSurface");
                                MzSurfaceView.this.f3927y = EGL14.eglCreateContext(MzSurfaceView.this.f3926x, MzSurfaceView.this.f3928z[0], EGL14.EGL_NO_CONTEXT, iArr2, 0);
                                m4586a("eglCreateContext");
                                if (MzSurfaceView.this.f3927y == EGL14.EGL_NO_CONTEXT) {
                                    String n = MzSurfaceView.f3843aI;
                                    Log.d(n, "Errorcode:" + EGL14.eglGetError());
                                    throw new RuntimeException("eglCreateContext fail failed! " + EGL14.eglGetError());
                                } else if (!EGL14.eglMakeCurrent(MzSurfaceView.this.f3926x, MzSurfaceView.this.f3855A, MzSurfaceView.this.f3855A, MzSurfaceView.this.f3927y)) {
                                    throw new RuntimeException("eglMakeCurrent failed! " + EGL14.eglGetError());
                                } else {
                                    return;
                                }
                            }
                        }
                        Log.d(MzSurfaceView.f3843aI, "holder null or surface not be created");
                        return;
                    }
                    Log.d(MzSurfaceView.f3843aI, "unable to initialize EGL14");
                    throw new RuntimeException("unable to initialize EGL14");
                }
                Log.d(MzSurfaceView.f3843aI, "unable to get EGL14 display");
                throw new RuntimeException("unable to get EGL14 display");
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public final void m4593g() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 392, new Class[0], Void.TYPE).isSupported) {
                Log.i(MzSurfaceView.f3843aI, "onDestroyGL");
                EGL14.eglDestroyContext(MzSurfaceView.this.f3926x, MzSurfaceView.this.f3927y);
                MzSurfaceView.this.f3927y = EGL14.EGL_NO_CONTEXT;
                MzSurfaceView.this.f3926x = EGL14.EGL_NO_DISPLAY;
                HandlerThread handlerThread = this.f3931c;
                if (handlerThread == null) {
                    C3443i.m21151a();
                }
                handlerThread.getLooper().quit();
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0150, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0172, code lost:
            com.meizu.camera.effectlib.effects.views.MzSurfaceView.m4524e(r8.f3930b, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0177, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ed, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x020f, code lost:
            com.meizu.camera.effectlib.effects.views.MzSurfaceView.m4524e(r8.f3930b, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0214, code lost:
            throw r2;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:57:0x0153, B:87:0x01f0] */
        /* renamed from: h */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m4594h() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f3929a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 393(0x189, float:5.51E-43)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                java.lang.String r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI
                java.lang.String r2 = "onRelease  release 1..................."
                android.util.Log.i(r1, r2)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                java.lang.Object r1 = r1.f3909g
                monitor-enter(r1)
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0362 }
                java.lang.String r3 = "MzSurfaceView release"
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.c r3 = (com.meizu.camera.effectlib.effects.views.PreviewView) r3     // Catch:{ all -> 0x0362 }
                r2.mo14193b((com.meizu.camera.effectlib.effects.views.PreviewView) r3)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                android.graphics.Bitmap r2 = r2.f3865K     // Catch:{ all -> 0x0362 }
                r3 = 0
                if (r2 == 0) goto L_0x006a
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                android.graphics.Bitmap r2 = r2.f3865K     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x004e
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x004e:
                boolean r2 = r2.isRecycled()     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x006a
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                android.graphics.Bitmap r2 = r2.f3865K     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x005f
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x005f:
                r2.recycle()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r4 = r3
                android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ all -> 0x0362 }
                r2.f3865K = r4     // Catch:{ all -> 0x0362 }
            L_0x006a:
                com.meizu.imageproc.SurfaceTextureBitmap.m6368a((boolean) r0)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ all -> 0x0362 }
                r4 = -1
                if (r2 == 0) goto L_0x0239
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                android.graphics.SurfaceTexture r5 = (android.graphics.SurfaceTexture) r5     // Catch:{ all -> 0x0362 }
                r2.f3907e = r5     // Catch:{ all -> 0x0362 }
                int r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3853aS     // Catch:{ all -> 0x0362 }
                r5 = 1
                if (r2 <= r5) goto L_0x008a
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3859E = r5     // Catch:{ all -> 0x0362 }
            L_0x008a:
                int r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3853aS     // Catch:{ all -> 0x0362 }
                if (r2 <= 0) goto L_0x0098
                int r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3853aS     // Catch:{ all -> 0x0362 }
                int r2 = r2 + r4
                com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3853aS = r2     // Catch:{ all -> 0x0362 }
            L_0x0098:
                r2 = r3
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                java.util.Vector r5 = r5.f3919q     // Catch:{ all -> 0x0362 }
                if (r5 == 0) goto L_0x00c4
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                java.util.Vector r5 = r5.f3919q     // Catch:{ all -> 0x0362 }
                boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0362 }
                if (r5 != 0) goto L_0x00c4
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0362 }
                java.lang.String r5 = "sQueue.remove"
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                java.util.Vector r2 = r2.f3919q     // Catch:{ all -> 0x0362 }
                java.lang.Object r2 = r2.remove(r0)     // Catch:{ all -> 0x0362 }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x0362 }
            L_0x00c4:
                if (r2 == 0) goto L_0x00c9
                r2.run()     // Catch:{ all -> 0x0362 }
            L_0x00c9:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3856B     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x00e2
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0362 }
                java.lang.String r5 = "CameraPreviewRenderView set Render null"
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                com.meizu.camera.effectlib.effects.b.a r5 = (com.meizu.camera.effectlib.effects.p059b.BaseRender) r5     // Catch:{ all -> 0x0362 }
                r2.f3856B = r5     // Catch:{ all -> 0x0362 }
            L_0x00e2:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3898at     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x00fb
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0362 }
                java.lang.String r5 = "CameraPreviewRenderView set VfbRender null"
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                com.meizu.camera.effectlib.effects.b.a r5 = (com.meizu.camera.effectlib.effects.p059b.BaseRender) r5     // Catch:{ all -> 0x0362 }
                r2.f3898at = r5     // Catch:{ all -> 0x0362 }
            L_0x00fb:
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0362 }
                r5 = 29
                if (r2 < r5) goto L_0x019e
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                boolean r2 = r2.f3918p     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0178
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.imageproc.SurfaceTextureWrapper r5 = r5.f3906d     // Catch:{ all -> 0x0362 }
                boolean r2 = r2.mo14196b((com.meizu.imageproc.SurfaceTextureWrapper) r5)     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0178
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ Exception -> 0x0152 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0152 }
                r5.<init>()     // Catch:{ Exception -> 0x0152 }
                java.lang.String r6 = "detachFromGLContext:"
                r5.append(r6)     // Catch:{ Exception -> 0x0152 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0152 }
                com.meizu.imageproc.SurfaceTextureWrapper r6 = r6.f3906d     // Catch:{ Exception -> 0x0152 }
                if (r6 != 0) goto L_0x0132
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0152 }
            L_0x0132:
                r5.append(r6)     // Catch:{ Exception -> 0x0152 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0152 }
                android.util.Log.i(r2, r5)     // Catch:{ Exception -> 0x0152 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0152 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3906d     // Catch:{ Exception -> 0x0152 }
                if (r2 != 0) goto L_0x0147
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0152 }
            L_0x0147:
                r2.detachFromGLContext()     // Catch:{ Exception -> 0x0152 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
            L_0x014c:
                r2.f3918p = r0     // Catch:{ all -> 0x0362 }
                goto L_0x0178
            L_0x0150:
                r2 = move-exception
                goto L_0x0172
            L_0x0152:
                r2 = move-exception
                java.lang.String r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0150 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0150 }
                r6.<init>()     // Catch:{ all -> 0x0150 }
                java.lang.String r7 = "error:"
                r6.append(r7)     // Catch:{ all -> 0x0150 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0150 }
                r6.append(r2)     // Catch:{ all -> 0x0150 }
                java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0150 }
                android.util.Log.e(r5, r2)     // Catch:{ all -> 0x0150 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                goto L_0x014c
            L_0x0172:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r3.f3918p = r0     // Catch:{ all -> 0x0362 }
                throw r2     // Catch:{ all -> 0x0362 }
            L_0x0178:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.c$d r2 = r2.f3912j     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0194
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.c$d r2 = r2.f3912j     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x018b
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x018b:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.imageproc.SurfaceTextureWrapper r5 = r5.f3906d     // Catch:{ all -> 0x0362 }
                r2.mo14353a(r5)     // Catch:{ all -> 0x0362 }
            L_0x0194:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                com.meizu.imageproc.SurfaceTextureWrapper r5 = (com.meizu.imageproc.SurfaceTextureWrapper) r5     // Catch:{ all -> 0x0362 }
                r2.f3906d = r5     // Catch:{ all -> 0x0362 }
                goto L_0x0239
            L_0x019e:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                boolean r2 = r2.f3918p     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0215
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                android.graphics.SurfaceTexture r5 = r5.f3905c     // Catch:{ all -> 0x0362 }
                boolean r2 = r2.mo14195b((android.graphics.SurfaceTexture) r5)     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0215
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ Exception -> 0x01ef }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ef }
                r5.<init>()     // Catch:{ Exception -> 0x01ef }
                java.lang.String r6 = "detachFromGLContext:"
                r5.append(r6)     // Catch:{ Exception -> 0x01ef }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x01ef }
                android.graphics.SurfaceTexture r6 = r6.f3905c     // Catch:{ Exception -> 0x01ef }
                if (r6 != 0) goto L_0x01cf
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x01ef }
            L_0x01cf:
                r5.append(r6)     // Catch:{ Exception -> 0x01ef }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01ef }
                android.util.Log.i(r2, r5)     // Catch:{ Exception -> 0x01ef }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x01ef }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ Exception -> 0x01ef }
                if (r2 != 0) goto L_0x01e4
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x01ef }
            L_0x01e4:
                r2.detachFromGLContext()     // Catch:{ Exception -> 0x01ef }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
            L_0x01e9:
                r2.f3918p = r0     // Catch:{ all -> 0x0362 }
                goto L_0x0215
            L_0x01ed:
                r2 = move-exception
                goto L_0x020f
            L_0x01ef:
                r2 = move-exception
                java.lang.String r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x01ed }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ed }
                r6.<init>()     // Catch:{ all -> 0x01ed }
                java.lang.String r7 = "error:"
                r6.append(r7)     // Catch:{ all -> 0x01ed }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x01ed }
                r6.append(r2)     // Catch:{ all -> 0x01ed }
                java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x01ed }
                android.util.Log.e(r5, r2)     // Catch:{ all -> 0x01ed }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                goto L_0x01e9
            L_0x020f:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r3.f3918p = r0     // Catch:{ all -> 0x0362 }
                throw r2     // Catch:{ all -> 0x0362 }
            L_0x0215:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.c$c r2 = r2.f3911i     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0231
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.c$c r2 = r2.f3911i     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x0228
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x0228:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                android.graphics.SurfaceTexture r5 = r5.f3905c     // Catch:{ all -> 0x0362 }
                r2.mo14348a(r5)     // Catch:{ all -> 0x0362 }
            L_0x0231:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                android.graphics.SurfaceTexture r5 = (android.graphics.SurfaceTexture) r5     // Catch:{ all -> 0x0362 }
                r2.f3905c = r5     // Catch:{ all -> 0x0362 }
            L_0x0239:
                int r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3853aS     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x02e6
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0362 }
                java.lang.String r5 = "onRelease  release 2.................."
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0362 }
                java.lang.String r5 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ all -> 0x0362 }
                boolean r2 = r2.mo14216g()     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0262
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.c r5 = (com.meizu.camera.effectlib.effects.views.PreviewView) r5     // Catch:{ all -> 0x0362 }
                r2.mo14193b((com.meizu.camera.effectlib.effects.views.PreviewView) r5)     // Catch:{ all -> 0x0362 }
            L_0x0262:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3859E = r0     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0362 }
                java.lang.String r5 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ all -> 0x0362 }
                r5 = r3
                com.meizu.camera.effectlib.effects.a.c r5 = (com.meizu.camera.effectlib.effects.p058a.GLTexture) r5     // Catch:{ all -> 0x0362 }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x02bb
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0362 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0362 }
                r5.<init>()     // Catch:{ all -> 0x0362 }
                java.lang.String r6 = " recycle mPreviewTexture id "
                r5.append(r6)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.a.c r6 = r6.f3917o     // Catch:{ all -> 0x0362 }
                if (r6 != 0) goto L_0x0297
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x0297:
                int r6 = r6.mo14028a()     // Catch:{ all -> 0x0362 }
                r5.append(r6)     // Catch:{ all -> 0x0362 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0362 }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x02b0
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x02b0:
                r2.mo14032c()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                com.meizu.camera.effectlib.effects.a.c r5 = (com.meizu.camera.effectlib.effects.p058a.GLTexture) r5     // Catch:{ all -> 0x0362 }
                r2.f3917o = r5     // Catch:{ all -> 0x0362 }
            L_0x02bb:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                boolean r2 = r2.f3864J     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x02e6
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3896ar     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x02e1
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3896ar     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x02d6
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x02d6:
                r2.mo14032c()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                com.meizu.camera.effectlib.effects.a.c r5 = (com.meizu.camera.effectlib.effects.p058a.GLTexture) r5     // Catch:{ all -> 0x0362 }
                r2.f3896ar = r5     // Catch:{ all -> 0x0362 }
            L_0x02e1:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.m4469G()     // Catch:{ all -> 0x0362 }
            L_0x02e6:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                byte[] r2 = r2.f3876V     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x02f6
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r5 = r3
                byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x0362 }
                r2.f3876V = r5     // Catch:{ all -> 0x0362 }
            L_0x02f6:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac     // Catch:{ all -> 0x0362 }
                if (r2 == 0) goto L_0x0345
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x0309
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x0309:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                int r5 = r5.f3883ae     // Catch:{ all -> 0x0362 }
                r2.mo14360a((int) r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x031d
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x031d:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                int r5 = r5.f3884af     // Catch:{ all -> 0x0362 }
                r2.mo14360a((int) r5)     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac     // Catch:{ all -> 0x0362 }
                if (r2 != 0) goto L_0x0331
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0362 }
            L_0x0331:
                r2.mo14368h()     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.d r3 = (com.meizu.camera.effectlib.effects.views.YuvRenderProgram) r3     // Catch:{ all -> 0x0362 }
                r2.f3881ac = r3     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3883ae = r4     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3884af = r4     // Catch:{ all -> 0x0362 }
            L_0x0345:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3882ad = r0     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3875U = r0     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3873S = r0     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3874T = r0     // Catch:{ all -> 0x0362 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x0362 }
                r2.f3899au = r0     // Catch:{ all -> 0x0362 }
                kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ all -> 0x0362 }
                monitor-exit(r1)
                return
            L_0x0362:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzSurfaceView.C1176a.m4594h():void");
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public final void m4595i() {
            if (!PatchProxy.proxy(new Object[0], this, f3929a, false, 394, new Class[0], Void.TYPE).isSupported) {
                Log.d(MzSurfaceView.f3843aI, "initTex");
                synchronized (MzSurfaceView.this.f3909g) {
                    if (MzSurfaceView.this.f3905c != null) {
                        if (MzSurfaceView.this.f3917o == null) {
                            MzSurfaceView.this.f3917o = EffectRenderContext.m4369h().mo14169a((PreviewView) MzSurfaceView.this);
                            if (MzSurfaceView.this.f3917o == null) {
                                int[] iArr = new int[1];
                                GLES20.glGenTextures(iArr.length, iArr, 0);
                                MzSurfaceView.this.f3917o = new GLTexture(iArr[0], 36197);
                                EffectRenderContext h = EffectRenderContext.m4369h();
                                C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                                h.mo14177a(MzSurfaceView.this.f3917o);
                                EffectRenderContext.m4369h().mo14179a((PreviewView) MzSurfaceView.this, MzSurfaceView.this.f3917o);
                                String n = MzSurfaceView.f3843aI;
                                StringBuilder sb = new StringBuilder();
                                sb.append("create id ");
                                GLTexture t = MzSurfaceView.this.f3917o;
                                if (t == null) {
                                    C3443i.m21151a();
                                }
                                sb.append(t.mo14028a());
                                sb.append(" mPreviewTexture ");
                                sb.append(MzSurfaceView.this.f3917o);
                                Log.i(n, sb.toString());
                            }
                            String n2 = MzSurfaceView.f3843aI;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("create id ");
                            GLTexture t2 = MzSurfaceView.this.f3917o;
                            if (t2 == null) {
                                C3443i.m21151a();
                            }
                            sb2.append(t2.mo14028a());
                            Log.i(n2, sb2.toString());
                        }
                        if (MzSurfaceView.this.f3864J && MzSurfaceView.this.f3896ar == null) {
                            MzSurfaceView.this.f3896ar = GLTexture.m4033a(MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m);
                            String n3 = MzSurfaceView.f3843aI;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("create mShareTextureid ");
                            GLTexture v = MzSurfaceView.this.f3896ar;
                            if (v == null) {
                                C3443i.m21151a();
                            }
                            sb3.append(v.mo14028a());
                            sb3.append(" mShareTexture ");
                            sb3.append(MzSurfaceView.this.f3896ar);
                            Log.i(n3, sb3.toString());
                            MzSurfaceView.this.m4466E();
                        }
                    }
                    Unit tVar = Unit.f18749a;
                }
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
            com.meizu.camera.effectlib.effects.views.MzSurfaceView.m4524e(r8.f3930b, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ea, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x010c, code lost:
            com.meizu.camera.effectlib.effects.views.MzSurfaceView.m4524e(r8.f3930b, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0111, code lost:
            throw r2;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:25:0x0076, B:48:0x00ed] */
        /* renamed from: j */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m4596j() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f3929a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 395(0x18b, float:5.54E-43)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                java.lang.Object r1 = r1.f3909g
                monitor-enter(r1)
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x018a }
                r3 = 29
                if (r2 < r3) goto L_0x009b
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                boolean r2 = r2.f3918p     // Catch:{ all -> 0x018a }
                if (r2 == 0) goto L_0x0112
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3906d     // Catch:{ all -> 0x018a }
                boolean r2 = r2.mo14196b((com.meizu.imageproc.SurfaceTextureWrapper) r3)     // Catch:{ all -> 0x018a }
                if (r2 == 0) goto L_0x0112
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ Exception -> 0x0075 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0075 }
                r3.<init>()     // Catch:{ Exception -> 0x0075 }
                java.lang.String r4 = "detachTex:"
                r3.append(r4)     // Catch:{ Exception -> 0x0075 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0075 }
                com.meizu.imageproc.SurfaceTextureWrapper r4 = r4.f3906d     // Catch:{ Exception -> 0x0075 }
                if (r4 != 0) goto L_0x0054
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0075 }
            L_0x0054:
                r3.append(r4)     // Catch:{ Exception -> 0x0075 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0075 }
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x0075 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0075 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3906d     // Catch:{ Exception -> 0x0075 }
                if (r2 != 0) goto L_0x0069
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0075 }
            L_0x0069:
                r2.detachFromGLContext()     // Catch:{ Exception -> 0x0075 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
            L_0x006e:
                r2.f3918p = r0     // Catch:{ all -> 0x018a }
                goto L_0x0112
            L_0x0073:
                r2 = move-exception
                goto L_0x0095
            L_0x0075:
                r2 = move-exception
                java.lang.String r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r4.<init>()     // Catch:{ all -> 0x0073 }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0073 }
                r4.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r3, r2)     // Catch:{ all -> 0x0073 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                goto L_0x006e
            L_0x0095:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                r3.f3918p = r0     // Catch:{ all -> 0x018a }
                throw r2     // Catch:{ all -> 0x018a }
            L_0x009b:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                boolean r2 = r2.f3918p     // Catch:{ all -> 0x018a }
                if (r2 == 0) goto L_0x0112
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                android.graphics.SurfaceTexture r3 = r3.f3905c     // Catch:{ all -> 0x018a }
                boolean r2 = r2.mo14195b((android.graphics.SurfaceTexture) r3)     // Catch:{ all -> 0x018a }
                if (r2 == 0) goto L_0x0112
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ Exception -> 0x00ec }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec }
                r3.<init>()     // Catch:{ Exception -> 0x00ec }
                java.lang.String r4 = "detachTex:"
                r3.append(r4)     // Catch:{ Exception -> 0x00ec }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x00ec }
                android.graphics.SurfaceTexture r4 = r4.f3905c     // Catch:{ Exception -> 0x00ec }
                if (r4 != 0) goto L_0x00cc
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x00ec }
            L_0x00cc:
                r3.append(r4)     // Catch:{ Exception -> 0x00ec }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00ec }
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x00ec }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x00ec }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ Exception -> 0x00ec }
                if (r2 != 0) goto L_0x00e1
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x00ec }
            L_0x00e1:
                r2.detachFromGLContext()     // Catch:{ Exception -> 0x00ec }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
            L_0x00e6:
                r2.f3918p = r0     // Catch:{ all -> 0x018a }
                goto L_0x0112
            L_0x00ea:
                r2 = move-exception
                goto L_0x010c
            L_0x00ec:
                r2 = move-exception
                java.lang.String r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x00ea }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
                r4.<init>()     // Catch:{ all -> 0x00ea }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x00ea }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00ea }
                r4.append(r2)     // Catch:{ all -> 0x00ea }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00ea }
                android.util.Log.e(r3, r2)     // Catch:{ all -> 0x00ea }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                goto L_0x00e6
            L_0x010c:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                r3.f3918p = r0     // Catch:{ all -> 0x018a }
                throw r2     // Catch:{ all -> 0x018a }
            L_0x0112:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.c r2 = (com.meizu.camera.effectlib.effects.views.PreviewView) r2     // Catch:{ all -> 0x018a }
                r0.mo14193b((com.meizu.camera.effectlib.effects.views.PreviewView) r2)     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.a.c r0 = r0.f3917o     // Catch:{ all -> 0x018a }
                if (r0 == 0) goto L_0x0171
                java.lang.String r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x018a }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
                r2.<init>()     // Catch:{ all -> 0x018a }
                java.lang.String r3 = " recycle mPreviewTexture id "
                r2.append(r3)     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3917o     // Catch:{ all -> 0x018a }
                if (r3 != 0) goto L_0x013e
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x018a }
            L_0x013e:
                int r3 = r3.mo14028a()     // Catch:{ all -> 0x018a }
                r2.append(r3)     // Catch:{ all -> 0x018a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.a.c r0 = r0.f3917o     // Catch:{ all -> 0x018a }
                if (r0 != 0) goto L_0x0157
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x018a }
            L_0x0157:
                r0.mo14032c()     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x018a }
                r2 = 0
                r3 = r2
                com.meizu.camera.effectlib.effects.a.c r3 = (com.meizu.camera.effectlib.effects.p058a.GLTexture) r3     // Catch:{ all -> 0x018a }
                r0.f3917o = r3     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x018a }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.a.c r2 = (com.meizu.camera.effectlib.effects.p058a.GLTexture) r2     // Catch:{ all -> 0x018a }
                r0.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r2)     // Catch:{ all -> 0x018a }
            L_0x0171:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x018a }
                r0.mo14159D()     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x018a }
                r0.mo14160E()     // Catch:{ all -> 0x018a }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x018a }
                r0.mo14163H()     // Catch:{ all -> 0x018a }
                kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ all -> 0x018a }
                monitor-exit(r1)
                return
            L_0x018a:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzSurfaceView.C1176a.m4596j():void");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x03ba, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:283:0x071d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ad, code lost:
            return;
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m4597k() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f3929a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 396(0x18c, float:5.55E-43)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                java.lang.Object r1 = r1.f3909g
                monitor-enter(r1)
                r2 = 0
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                java.util.Vector r3 = r3.f3919q     // Catch:{ all -> 0x071e }
                if (r3 == 0) goto L_0x0040
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                java.util.Vector r3 = r3.f3919q     // Catch:{ all -> 0x071e }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x071e }
                if (r3 != 0) goto L_0x0040
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                java.util.Vector r2 = r2.f3919q     // Catch:{ all -> 0x071e }
                java.lang.Object r2 = r2.remove(r0)     // Catch:{ all -> 0x071e }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x071e }
            L_0x0040:
                if (r2 == 0) goto L_0x0047
                r2.run()     // Catch:{ all -> 0x071e }
                kotlin.t r2 = kotlin.Unit.f18749a     // Catch:{ all -> 0x071e }
            L_0x0047:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.b r2 = r2.f3869O     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0051
                monitor-exit(r1)
                return
            L_0x0051:
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x071e }
                r3 = 29
                r4 = 36197(0x8d65, float:5.0723E-41)
                r5 = 1
                if (r2 < r3) goto L_0x0368
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3906d     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x0680
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3894ap     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x008e
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x008c, all -> 0x008a }
                boolean r0 = r0.f3918p     // Catch:{ Exception -> 0x008c, all -> 0x008a }
                if (r0 == 0) goto L_0x0081
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x008c, all -> 0x008a }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3906d     // Catch:{ Exception -> 0x008c, all -> 0x008a }
                if (r0 != 0) goto L_0x007e
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            L_0x007e:
                r0.updateTexImage()     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            L_0x0081:
                java.lang.String r0 = "MzSurfaceView"
                java.lang.String r2 = "app has been background ,not to draw ,return "
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
                monitor-exit(r1)
                return
            L_0x008a:
                monitor-exit(r1)
                return
            L_0x008c:
                monitor-exit(r1)
                return
            L_0x008e:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3878aA     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x00b2
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
                boolean r0 = r0.f3918p     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
                if (r0 == 0) goto L_0x00ac
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3906d     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
                if (r0 != 0) goto L_0x00a9
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            L_0x00a9:
                r0.updateTexImage()     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            L_0x00ac:
                monitor-exit(r1)
                return
            L_0x00ae:
                monitor-exit(r1)
                return
            L_0x00b0:
                monitor-exit(r1)
                return
            L_0x00b2:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0164
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c r6 = (com.meizu.camera.effectlib.effects.views.PreviewView) r6     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14169a((com.meizu.camera.effectlib.effects.views.PreviewView) r6)     // Catch:{ all -> 0x071e }
                r2.f3917o = r3     // Catch:{ all -> 0x071e }
                int[] r2 = new int[r5]     // Catch:{ all -> 0x071e }
                int r3 = r2.length     // Catch:{ all -> 0x071e }
                android.opengl.GLES20.glGenTextures(r3, r2, r0)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3917o     // Catch:{ all -> 0x071e }
                if (r3 != 0) goto L_0x013d
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r6 = new com.meizu.camera.effectlib.effects.a.c     // Catch:{ all -> 0x071e }
                r2 = r2[r0]     // Catch:{ all -> 0x071e }
                r6.<init>(r2, r4)     // Catch:{ all -> 0x071e }
                r3.f3917o = r6     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3917o     // Catch:{ all -> 0x071e }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c r3 = (com.meizu.camera.effectlib.effects.views.PreviewView) r3     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                r2.mo14179a((com.meizu.camera.effectlib.effects.views.PreviewView) r3, (com.meizu.camera.effectlib.effects.p058a.GLTexture) r4)     // Catch:{ all -> 0x071e }
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "onDraw create id "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x0121
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0121:
                int r4 = r4.mo14028a()     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r4 = " mPreviewTexture "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
            L_0x013d:
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "onDraw create id "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x0156
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0156:
                int r4 = r4.mo14028a()     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
            L_0x0164:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3864J     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x01c3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3896ar     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x01c3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                int r3 = r3.f3914l     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                int r4 = r4.f3915m     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = com.meizu.camera.effectlib.effects.p058a.GLTexture.m4033a(r3, r4)     // Catch:{ all -> 0x071e }
                r2.f3896ar = r3     // Catch:{ all -> 0x071e }
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "onDraw create mShareTextureid "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3896ar     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x01a2
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x01a2:
                int r4 = r4.mo14028a()     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r4 = " mShareTexture "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3896ar     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r2.m4466E()     // Catch:{ all -> 0x071e }
            L_0x01c3:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3918p     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0253
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3906d     // Catch:{ all -> 0x071e }
                boolean r0 = r0.mo14196b((com.meizu.imageproc.SurfaceTextureWrapper) r2)     // Catch:{ all -> 0x071e }
                if (r0 != 0) goto L_0x01e0
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r0.mo14108f()     // Catch:{ all -> 0x071e }
            L_0x01e0:
                java.lang.String r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ Exception -> 0x0221 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0221 }
                r2.<init>()     // Catch:{ Exception -> 0x0221 }
                java.lang.String r3 = "attachToGLContext:"
                r2.append(r3)     // Catch:{ Exception -> 0x0221 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0221 }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3906d     // Catch:{ Exception -> 0x0221 }
                if (r3 != 0) goto L_0x01f9
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0221 }
            L_0x01f9:
                r2.append(r3)     // Catch:{ Exception -> 0x0221 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0221 }
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x0221 }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0221 }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3906d     // Catch:{ Exception -> 0x0221 }
                if (r0 != 0) goto L_0x020e
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0221 }
            L_0x020e:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0221 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ Exception -> 0x0221 }
                if (r2 != 0) goto L_0x0219
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0221 }
            L_0x0219:
                int r2 = r2.mo14028a()     // Catch:{ Exception -> 0x0221 }
                r0.attachToGLContext(r2)     // Catch:{ Exception -> 0x0221 }
                goto L_0x023e
            L_0x0221:
                r0 = move-exception
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "error:"
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x071e }
                r3.append(r0)     // Catch:{ all -> 0x071e }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x071e }
            L_0x023e:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3906d     // Catch:{ all -> 0x071e }
                if (r0 != 0) goto L_0x0249
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0249:
                r0.updateTexImage()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r0.f3918p = r5     // Catch:{ all -> 0x071e }
                monitor-exit(r1)
                return
            L_0x0253:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3906d     // Catch:{ all -> 0x071e }
                boolean r2 = r2.mo14196b((com.meizu.imageproc.SurfaceTextureWrapper) r3)     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x026a
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r0.mo14246g()     // Catch:{ all -> 0x071e }
                monitor-exit(r1)
                return
            L_0x026a:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3906d     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0275
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0275:
                r2.updateTexImage()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3906d     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0283
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0283:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r3 = r3.f3922t     // Catch:{ all -> 0x071e }
                r2.getTransformMatrix(r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r2 = r2.f3922t     // Catch:{ all -> 0x071e }
                boolean r2 = com.meizu.camera.effectlib.effects.p058a.GLES20Utils.m4018a((float[]) r2)     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x02d6
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r2 = r2.f3922t     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r3 = r3.f3921s     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r4 = r4.f3921s     // Catch:{ all -> 0x071e }
                int r4 = r4.length     // Catch:{ all -> 0x071e }
                java.lang.System.arraycopy(r2, r0, r3, r0, r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r3 = r3.f3921s     // Catch:{ all -> 0x071e }
                r2.mo14187a((float[]) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c$b r2 = r2.f3870P     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x02d6
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c$b r2 = r2.f3870P     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x02d3
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x02d3:
                r2.mo14346n_()     // Catch:{ all -> 0x071e }
            L_0x02d6:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                boolean r2 = r2.mo14216g()     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0341
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c r4 = (com.meizu.camera.effectlib.effects.views.PreviewView) r4     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14169a((com.meizu.camera.effectlib.effects.views.PreviewView) r4)     // Catch:{ all -> 0x071e }
                r2.f3917o = r3     // Catch:{ all -> 0x071e }
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "getGLTexture "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x030f
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x030f:
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14156A()     // Catch:{ all -> 0x071e }
                if (r2 == r3) goto L_0x034c
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3917o     // Catch:{ all -> 0x071e }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r3)     // Catch:{ all -> 0x071e }
                goto L_0x034c
            L_0x0341:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3906d     // Catch:{ all -> 0x071e }
                r2.f3908f = r3     // Catch:{ all -> 0x071e }
            L_0x034c:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3906d     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3806c     // Catch:{ all -> 0x071e }
                if (r2 == r3) goto L_0x0680
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3906d     // Catch:{ all -> 0x071e }
                r2.f3806c = r3     // Catch:{ all -> 0x071e }
                goto L_0x0680
            L_0x0368:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x0680
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3894ap     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x039b
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0399, all -> 0x0397 }
                boolean r0 = r0.f3918p     // Catch:{ Exception -> 0x0399, all -> 0x0397 }
                if (r0 == 0) goto L_0x038e
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x0399, all -> 0x0397 }
                android.graphics.SurfaceTexture r0 = r0.f3905c     // Catch:{ Exception -> 0x0399, all -> 0x0397 }
                if (r0 != 0) goto L_0x038b
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x0399, all -> 0x0397 }
            L_0x038b:
                r0.updateTexImage()     // Catch:{ Exception -> 0x0399, all -> 0x0397 }
            L_0x038e:
                java.lang.String r0 = "MzSurfaceView"
                java.lang.String r2 = "app has been background ,not to draw ,return "
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x0399, all -> 0x0397 }
                monitor-exit(r1)
                return
            L_0x0397:
                monitor-exit(r1)
                return
            L_0x0399:
                monitor-exit(r1)
                return
            L_0x039b:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3878aA     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x03bf
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x03bd, all -> 0x03bb }
                boolean r0 = r0.f3918p     // Catch:{ Exception -> 0x03bd, all -> 0x03bb }
                if (r0 == 0) goto L_0x03b9
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x03bd, all -> 0x03bb }
                android.graphics.SurfaceTexture r0 = r0.f3905c     // Catch:{ Exception -> 0x03bd, all -> 0x03bb }
                if (r0 != 0) goto L_0x03b6
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x03bd, all -> 0x03bb }
            L_0x03b6:
                r0.updateTexImage()     // Catch:{ Exception -> 0x03bd, all -> 0x03bb }
            L_0x03b9:
                monitor-exit(r1)
                return
            L_0x03bb:
                monitor-exit(r1)
                return
            L_0x03bd:
                monitor-exit(r1)
                return
            L_0x03bf:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0471
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c r6 = (com.meizu.camera.effectlib.effects.views.PreviewView) r6     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14169a((com.meizu.camera.effectlib.effects.views.PreviewView) r6)     // Catch:{ all -> 0x071e }
                r2.f3917o = r3     // Catch:{ all -> 0x071e }
                int[] r2 = new int[r5]     // Catch:{ all -> 0x071e }
                int r3 = r2.length     // Catch:{ all -> 0x071e }
                android.opengl.GLES20.glGenTextures(r3, r2, r0)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3917o     // Catch:{ all -> 0x071e }
                if (r3 != 0) goto L_0x044a
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r6 = new com.meizu.camera.effectlib.effects.a.c     // Catch:{ all -> 0x071e }
                r2 = r2[r0]     // Catch:{ all -> 0x071e }
                r6.<init>(r2, r4)     // Catch:{ all -> 0x071e }
                r3.f3917o = r6     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3917o     // Catch:{ all -> 0x071e }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c r3 = (com.meizu.camera.effectlib.effects.views.PreviewView) r3     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                r2.mo14179a((com.meizu.camera.effectlib.effects.views.PreviewView) r3, (com.meizu.camera.effectlib.effects.p058a.GLTexture) r4)     // Catch:{ all -> 0x071e }
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "onDraw create id "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x042e
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x042e:
                int r4 = r4.mo14028a()     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r4 = " mPreviewTexture "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
            L_0x044a:
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "onDraw create id "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x0463
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0463:
                int r4 = r4.mo14028a()     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
            L_0x0471:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3864J     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x04d0
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3896ar     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x04d0
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                int r3 = r3.f3914l     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                int r4 = r4.f3915m     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = com.meizu.camera.effectlib.effects.p058a.GLTexture.m4033a(r3, r4)     // Catch:{ all -> 0x071e }
                r2.f3896ar = r3     // Catch:{ all -> 0x071e }
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "onDraw create mShareTextureid "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3896ar     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x04af
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x04af:
                int r4 = r4.mo14028a()     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r4 = " mShareTexture "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3896ar     // Catch:{ all -> 0x071e }
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r2.m4466E()     // Catch:{ all -> 0x071e }
            L_0x04d0:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3918p     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0560
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ all -> 0x071e }
                boolean r0 = r0.mo14195b((android.graphics.SurfaceTexture) r2)     // Catch:{ all -> 0x071e }
                if (r0 != 0) goto L_0x04ed
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r0.mo14108f()     // Catch:{ all -> 0x071e }
            L_0x04ed:
                java.lang.String r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ Exception -> 0x052e }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x052e }
                r2.<init>()     // Catch:{ Exception -> 0x052e }
                java.lang.String r3 = "attachToGLContext:"
                r2.append(r3)     // Catch:{ Exception -> 0x052e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x052e }
                android.graphics.SurfaceTexture r3 = r3.f3905c     // Catch:{ Exception -> 0x052e }
                if (r3 != 0) goto L_0x0506
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x052e }
            L_0x0506:
                r2.append(r3)     // Catch:{ Exception -> 0x052e }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x052e }
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x052e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x052e }
                android.graphics.SurfaceTexture r0 = r0.f3905c     // Catch:{ Exception -> 0x052e }
                if (r0 != 0) goto L_0x051b
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x052e }
            L_0x051b:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ Exception -> 0x052e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ Exception -> 0x052e }
                if (r2 != 0) goto L_0x0526
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x052e }
            L_0x0526:
                int r2 = r2.mo14028a()     // Catch:{ Exception -> 0x052e }
                r0.attachToGLContext(r2)     // Catch:{ Exception -> 0x052e }
                goto L_0x054b
            L_0x052e:
                r0 = move-exception
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "error:"
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x071e }
                r3.append(r0)     // Catch:{ all -> 0x071e }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x071e }
            L_0x054b:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r0 = r0.f3905c     // Catch:{ all -> 0x071e }
                if (r0 != 0) goto L_0x0556
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0556:
                r0.updateTexImage()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r0.f3918p = r5     // Catch:{ all -> 0x071e }
                monitor-exit(r1)
                return
            L_0x0560:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r3 = r3.f3905c     // Catch:{ all -> 0x071e }
                boolean r2 = r2.mo14195b((android.graphics.SurfaceTexture) r3)     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0577
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r0.mo14108f()     // Catch:{ all -> 0x071e }
                monitor-exit(r1)
                return
            L_0x0577:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0582
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0582:
                r2.updateTexImage()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x0590
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x0590:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r3 = r3.f3922t     // Catch:{ all -> 0x071e }
                r2.getTransformMatrix(r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r2 = r2.f3922t     // Catch:{ all -> 0x071e }
                boolean r2 = com.meizu.camera.effectlib.effects.p058a.GLES20Utils.m4018a((float[]) r2)     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x05e3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r2 = r2.f3922t     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r3 = r3.f3921s     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r4 = r4.f3921s     // Catch:{ all -> 0x071e }
                int r4 = r4.length     // Catch:{ all -> 0x071e }
                java.lang.System.arraycopy(r2, r0, r3, r0, r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r3 = r3.f3921s     // Catch:{ all -> 0x071e }
                r2.mo14187a((float[]) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c$b r2 = r2.f3870P     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x05e3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c$b r2 = r2.f3870P     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x05e0
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x05e0:
                r2.mo14346n_()     // Catch:{ all -> 0x071e }
            L_0x05e3:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                boolean r2 = r2.mo14216g()     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x064e
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.c r4 = (com.meizu.camera.effectlib.effects.views.PreviewView) r4     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14169a((com.meizu.camera.effectlib.effects.views.PreviewView) r4)     // Catch:{ all -> 0x071e }
                r2.f3917o = r3     // Catch:{ all -> 0x071e }
                java.lang.String r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI     // Catch:{ all -> 0x071e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "getGLTexture "
                r3.append(r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3917o     // Catch:{ all -> 0x071e }
                if (r4 != 0) goto L_0x061c
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x061c:
                r3.append(r4)     // Catch:{ all -> 0x071e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x071e }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3917o     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14156A()     // Catch:{ all -> 0x071e }
                if (r2 == r3) goto L_0x0659
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3917o     // Catch:{ all -> 0x071e }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r3)     // Catch:{ all -> 0x071e }
                goto L_0x0659
            L_0x064e:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r3 = r3.f3905c     // Catch:{ all -> 0x071e }
                r2.f3907e = r3     // Catch:{ all -> 0x071e }
            L_0x0659:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r4 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r3 = r3.mo14241y()     // Catch:{ all -> 0x071e }
                if (r2 == r3) goto L_0x0680
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x071e }
                java.lang.String r3 = "EffectRenderContext.getInstance()"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r3 = r3.f3905c     // Catch:{ all -> 0x071e }
                r2.mo14200c((android.graphics.SurfaceTexture) r3)     // Catch:{ all -> 0x071e }
            L_0x0680:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r2 = r2.f3875U     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x06e1
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3856B     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x06de
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.graphics.SurfaceTexture r2 = r2.f3905c     // Catch:{ all -> 0x071e }
                if (r2 == 0) goto L_0x06de
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x06bd
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.d r3 = new com.meizu.camera.effectlib.effects.views.d     // Catch:{ all -> 0x071e }
                r3.<init>()     // Catch:{ all -> 0x071e }
                r2.f3881ac = r3     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x06b5
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x06b5:
                r2.mo14362b()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r2.f3882ad = r0     // Catch:{ all -> 0x071e }
            L_0x06bd:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                boolean r0 = r0.f3882ad     // Catch:{ all -> 0x071e }
                if (r0 != 0) goto L_0x06ca
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                r0.m4463D()     // Catch:{ all -> 0x071e }
            L_0x06ca:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                byte[] r0 = r0.f3876V     // Catch:{ all -> 0x071e }
                if (r0 == 0) goto L_0x06db
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                byte[] r0 = r0.f3876V     // Catch:{ all -> 0x071e }
                r8.m4587a((byte[]) r0)     // Catch:{ all -> 0x071e }
            L_0x06db:
                kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ all -> 0x071e }
                goto L_0x071c
            L_0x06de:
                kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ all -> 0x071e }
                goto L_0x071c
            L_0x06e1:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = r8.f3932d     // Catch:{ all -> 0x071e }
                if (r2 != 0) goto L_0x06e8
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x06e8:
                int r2 = r2.getWidth()     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = r8.f3932d     // Catch:{ all -> 0x071e }
                if (r3 != 0) goto L_0x06f3
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x071e }
            L_0x06f3:
                int r3 = r3.getHeight()     // Catch:{ all -> 0x071e }
                android.opengl.GLES20.glViewport(r0, r0, r2, r3)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r0 = r0.f3922t     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                float[] r2 = r2.f3920r     // Catch:{ all -> 0x071e }
                r8.m4588a(r0, r2)     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.opengl.EGLDisplay r0 = r0.f3926x     // Catch:{ all -> 0x071e }
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this     // Catch:{ all -> 0x071e }
                android.opengl.EGLSurface r2 = r2.f3855A     // Catch:{ all -> 0x071e }
                boolean r0 = android.opengl.EGL14.eglSwapBuffers(r0, r2)     // Catch:{ all -> 0x071e }
                java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x071e }
            L_0x071c:
                monitor-exit(r1)
                return
            L_0x071e:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzSurfaceView.C1176a.m4597k():void");
        }

        /* renamed from: a */
        private final void m4588a(float[] fArr, float[] fArr2) {
            if (PatchProxy.proxy(new Object[]{fArr, fArr2}, this, f3929a, false, 397, new Class[]{float[].class, float[].class}, Void.TYPE).isSupported || MzSurfaceView.this.f3917o == null) {
                return;
            }
            if (MzSurfaceView.this.f3856B != null || MzSurfaceView.this.f3898at != null) {
                if (MzSurfaceView.this.f3899au) {
                    GLES20.glClear(16384);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (MzSurfaceView.this.f3856B != null) {
                    BaseRender q = MzSurfaceView.this.f3856B;
                    if (q == null) {
                        C3443i.m21151a();
                    }
                    q.mo14043a(MzSurfaceView.f3850aP);
                    EffectRenderContext h = EffectRenderContext.m4369h();
                    C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
                    if (h.mo14237u()) {
                        BaseRender q2 = MzSurfaceView.this.f3856B;
                        if (q2 == null) {
                            C3443i.m21151a();
                        }
                        q2.mo14045b(MzSurfaceView.f3852aR);
                    } else {
                        BaseRender q3 = MzSurfaceView.this.f3856B;
                        if (q3 == null) {
                            C3443i.m21151a();
                        }
                        q3.mo14045b(MzSurfaceView.f3851aQ);
                    }
                    BaseRender q4 = MzSurfaceView.this.f3856B;
                    if (q4 == null) {
                        C3443i.m21151a();
                    }
                    q4.mo14047c(fArr2);
                    BaseRender q5 = MzSurfaceView.this.f3856B;
                    if (q5 == null) {
                        C3443i.m21151a();
                    }
                    q5.mo14049d(fArr);
                }
                if (MzSurfaceView.this.f3914l <= 0 || MzSurfaceView.this.f3915m <= 0) {
                    String n = MzSurfaceView.f3843aI;
                    Log.i(n, "render view size not init:" + MzSurfaceView.this.f3914l + "x" + MzSurfaceView.this.f3915m);
                    MzSurfaceView.this.f3914l = MzSurfaceView.this.getViewWidth();
                    MzSurfaceView.this.f3915m = MzSurfaceView.this.getViewHeight();
                    return;
                }
                if (MzSurfaceView.this.f3898at != null) {
                    BaseRender r = MzSurfaceView.this.f3898at;
                    if (r == null) {
                        C3443i.m21151a();
                    }
                    EffectRenderFactory.C1191c c = r.mo14046c();
                    C3443i.m21152a((Object) c, "mVfbRender!!.type");
                    if (C3443i.m21154a((Object) c.mo14345d(), (Object) "Mzvfacebeauty") && MzSurfaceView.this.f3864J) {
                        BaseRender r2 = MzSurfaceView.this.f3898at;
                        if (r2 == null) {
                            C3443i.m21151a();
                        }
                        r2.mo14043a(MzSurfaceView.f3850aP);
                        EffectRenderContext h2 = EffectRenderContext.m4369h();
                        C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
                        if (h2.mo14237u()) {
                            BaseRender r3 = MzSurfaceView.this.f3898at;
                            if (r3 == null) {
                                C3443i.m21151a();
                            }
                            r3.mo14045b(MzSurfaceView.f3852aR);
                        } else {
                            BaseRender r4 = MzSurfaceView.this.f3898at;
                            if (r4 == null) {
                                C3443i.m21151a();
                            }
                            r4.mo14045b(MzSurfaceView.f3851aQ);
                        }
                        if (MzSurfaceView.this.f3856B != null) {
                            BaseRender q6 = MzSurfaceView.this.f3856B;
                            if (q6 == null) {
                                C3443i.m21151a();
                            }
                            EffectRenderFactory.C1191c c2 = q6.mo14046c();
                            C3443i.m21152a((Object) c2, "mRender!!.type");
                            if ((!C3443i.m21154a((Object) c2.mo14345d(), (Object) "Mznone")) && MzSurfaceView.this.f3896ar != null) {
                                if (MzSurfaceView.this.f3895aq == -1) {
                                    MzSurfaceView.this.m4466E();
                                }
                                m4586a("glBindFramebuffer");
                                GLES20.glBindFramebuffer(36160, MzSurfaceView.this.f3895aq);
                                if (MzSurfaceView.this.f3899au) {
                                    GLES20.glClear(16384);
                                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                                }
                                BaseRender r5 = MzSurfaceView.this.f3898at;
                                if (r5 == null) {
                                    C3443i.m21151a();
                                }
                                r5.mo14047c(MzSurfaceView.this.f3923u);
                                BaseRender r6 = MzSurfaceView.this.f3898at;
                                if (r6 == null) {
                                    C3443i.m21151a();
                                }
                                r6.mo14049d(MzSurfaceView.this.f3921s);
                                BaseRender r7 = MzSurfaceView.this.f3898at;
                                if (r7 == null) {
                                    C3443i.m21151a();
                                }
                                r7.mo14040a(MzSurfaceView.this.f3917o, 0, MzSurfaceView.this.f3916n, MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m);
                                GLES20.glBindFramebuffer(36160, 0);
                                EffectRenderFactory E = MzSurfaceView.this.f3869O;
                                if (E == null) {
                                    C3443i.m21151a();
                                }
                                BaseRender q7 = MzSurfaceView.this.f3856B;
                                if (q7 == null) {
                                    C3443i.m21151a();
                                }
                                BaseRender b = E.mo14325b(q7.mo14046c());
                                if (b == null) {
                                    C3443i.m21151a();
                                }
                                b.mo14043a(MzSurfaceView.f3850aP);
                                EffectRenderContext h3 = EffectRenderContext.m4369h();
                                C3443i.m21152a((Object) h3, "EffectRenderContext.getInstance()");
                                if (h3.mo14237u()) {
                                    b.mo14045b(MzSurfaceView.f3852aR);
                                } else {
                                    b.mo14045b(MzSurfaceView.f3851aQ);
                                }
                                b.mo14047c(MzSurfaceView.this.f3920r);
                                b.mo14049d(MzSurfaceView.this.f3923u);
                                b.mo14040a(MzSurfaceView.this.f3896ar, 0, MzSurfaceView.this.f3916n, MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m);
                                if (MzSurfaceView.this.f3900av) {
                                    MzSurfaceView.this.f3865K = m4584a(MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m, MzSurfaceView.this.f3901aw);
                                    MzSurfaceView.this.f3900av = false;
                                    return;
                                }
                                return;
                            }
                        }
                        BaseRender r8 = MzSurfaceView.this.f3898at;
                        if (r8 == null) {
                            C3443i.m21151a();
                        }
                        r8.mo14047c(MzSurfaceView.this.f3920r);
                        BaseRender r9 = MzSurfaceView.this.f3898at;
                        if (r9 == null) {
                            C3443i.m21151a();
                        }
                        r9.mo14049d(MzSurfaceView.this.f3921s);
                        BaseRender r10 = MzSurfaceView.this.f3898at;
                        if (r10 == null) {
                            C3443i.m21151a();
                        }
                        r10.mo14040a(MzSurfaceView.this.f3917o, 0, MzSurfaceView.this.f3916n, MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m);
                        if (MzSurfaceView.this.f3900av) {
                            MzSurfaceView.this.f3865K = m4584a(MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m, MzSurfaceView.this.f3901aw);
                            MzSurfaceView.this.f3900av = false;
                            return;
                        }
                        return;
                    }
                }
                if (MzSurfaceView.this.f3856B != null) {
                    BaseRender q8 = MzSurfaceView.this.f3856B;
                    if (q8 == null) {
                        C3443i.m21151a();
                    }
                    q8.mo14040a(MzSurfaceView.this.f3917o, 0, MzSurfaceView.this.f3916n, MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m);
                    if (MzSurfaceView.this.f3900av) {
                        MzSurfaceView.this.f3865K = m4584a(MzSurfaceView.this.f3914l, MzSurfaceView.this.f3915m, MzSurfaceView.this.f3901aw);
                        MzSurfaceView.this.f3900av = false;
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void m4587a(byte[] r21) {
            /*
                r20 = this;
                r7 = r20
                r8 = r21
                r9 = 1
                java.lang.Object[] r0 = new java.lang.Object[r9]
                r10 = 0
                r0[r10] = r8
                com.meizu.savior.ChangeQuickRedirect r2 = f3929a
                java.lang.Class[] r5 = new java.lang.Class[r9]
                java.lang.Class<byte[]> r1 = byte[].class
                r5[r10] = r1
                java.lang.Class r6 = java.lang.Void.TYPE
                r3 = 0
                r4 = 398(0x18e, float:5.58E-43)
                r1 = r20
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
                boolean r0 = r0.isSupported
                if (r0 == 0) goto L_0x0022
                return
            L_0x0022:
                r0 = 16384(0x4000, float:2.2959E-41)
                android.opengl.GLES20.glClear(r0)
                r0 = 0
                android.opengl.GLES20.glClearColor(r0, r0, r0, r0)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3881ac
                if (r0 != 0) goto L_0x0036
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0036:
                java.nio.FloatBuffer r0 = r0.mo14364d()
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r1 = r1.f3881ac
                if (r1 != 0) goto L_0x0045
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0045:
                java.nio.FloatBuffer r1 = r1.mo14365e()
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r3 = r3.f3881ac
                if (r3 != 0) goto L_0x0056
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0056:
                int r3 = r3.mo14363c()
                java.lang.String r4 = "aPosition"
                int r3 = android.opengl.GLES20.glGetAttribLocation(r3, r4)
                r2.f3885ag = r3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r3 = r3.f3881ac
                if (r3 != 0) goto L_0x0070
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0070:
                int r3 = r3.mo14363c()
                java.lang.String r4 = "aTextureCoordinate"
                int r3 = android.opengl.GLES20.glGetAttribLocation(r3, r4)
                r2.f3886ah = r3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r3 = r3.f3881ac
                if (r3 != 0) goto L_0x008a
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x008a:
                int r3 = r3.mo14363c()
                java.lang.String r4 = "textureY"
                int r3 = android.opengl.GLES20.glGetUniformLocation(r3, r4)
                r2.f3887ai = r3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r3 = r3.f3881ac
                if (r3 != 0) goto L_0x00a4
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x00a4:
                int r3 = r3.mo14363c()
                java.lang.String r4 = "textureUV"
                int r3 = android.opengl.GLES20.glGetUniformLocation(r3, r4)
                r2.f3888aj = r3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r3 = r3.f3881ac
                if (r3 != 0) goto L_0x00be
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x00be:
                int r3 = r3.mo14363c()
                java.lang.String r4 = "uMVPMatrix"
                int r3 = android.opengl.GLES20.glGetUniformLocation(r3, r4)
                r2.f3889ak = r3
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r2 = r2.f3914l
                if (r2 <= 0) goto L_0x030a
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r2 = r2.f3915m
                if (r2 > 0) goto L_0x00dd
                goto L_0x030a
            L_0x00dd:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac
                if (r2 != 0) goto L_0x00e8
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x00e8:
                boolean r2 = r2.mo14367g()
                if (r2 != 0) goto L_0x00f8
                java.lang.String r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI
                java.lang.String r1 = "RenderProgram not ready"
                android.util.Log.i(r0, r1)
                return
            L_0x00f8:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r2 = r2.f3914l
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r3 = r3.f3915m
                android.opengl.GLES20.glViewport(r10, r10, r2, r3)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3881ac
                if (r2 != 0) goto L_0x0112
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0112:
                int r2 = r2.mo14363c()
                android.opengl.GLES20.glUseProgram(r2)
                r2 = 0
                java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
                if (r8 == 0) goto L_0x0195
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r2 = r2.f3880ab
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r3 = r3.f3879aa
                int r2 = r2 * r3
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
                if (r2 != 0) goto L_0x0135
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0135:
                r2.clear()
                r2.position(r10)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r3 = r3.f3880ab
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3879aa
                int r3 = r3 * r4
                java.nio.ByteBuffer r3 = r2.put(r8, r10, r3)
                r3.position(r10)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r3 = r3.f3880ab
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3879aa
                int r3 = r3 * r4
                int r3 = r3 / 2
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)
                if (r3 != 0) goto L_0x0169
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0169:
                r3.clear()
                r3.position(r10)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3880ab
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r5 = r5.f3879aa
                int r4 = r4 * r5
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r5 = r5.f3880ab
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r6 = r6.f3879aa
                int r5 = r5 * r6
                int r5 = r5 / 2
                java.nio.ByteBuffer r4 = r3.put(r8, r4, r5)
                r4.position(r10)
                goto L_0x0196
            L_0x0195:
                r3 = r2
            L_0x0196:
                if (r2 == 0) goto L_0x020b
                if (r3 == 0) goto L_0x020b
                r4 = 33984(0x84c0, float:4.7622E-41)
                android.opengl.GLES20.glActiveTexture(r4)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3883ae
                r5 = 3553(0xde1, float:4.979E-42)
                android.opengl.GLES20.glBindTexture(r5, r4)
                r2.position(r10)
                r11 = 3553(0xde1, float:4.979E-42)
                r12 = 0
                r13 = 6409(0x1909, float:8.981E-42)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r14 = r4.f3880ab
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r15 = r4.f3879aa
                r16 = 0
                r17 = 6409(0x1909, float:8.981E-42)
                r18 = 5121(0x1401, float:7.176E-42)
                r19 = r2
                java.nio.Buffer r19 = (java.nio.Buffer) r19
                android.opengl.GLES20.glTexImage2D(r11, r12, r13, r14, r15, r16, r17, r18, r19)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3887ai
                android.opengl.GLES20.glUniform1i(r4, r10)
                r4 = 33985(0x84c1, float:4.7623E-41)
                android.opengl.GLES20.glActiveTexture(r4)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3884af
                android.opengl.GLES20.glBindTexture(r5, r4)
                r3.position(r10)
                r13 = 6410(0x190a, float:8.982E-42)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3880ab
                int r14 = r4 / 2
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3879aa
                int r15 = r4 / 2
                r17 = 6410(0x190a, float:8.982E-42)
                r19 = r3
                java.nio.Buffer r19 = (java.nio.Buffer) r19
                android.opengl.GLES20.glTexImage2D(r11, r12, r13, r14, r15, r16, r17, r18, r19)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r4 = r4.f3888aj
                android.opengl.GLES20.glUniform1i(r4, r9)
            L_0x020b:
                r0.position(r10)
                r4 = 34962(0x8892, float:4.8992E-41)
                android.opengl.GLES20.glBindBuffer(r4, r10)
                r4 = 34963(0x8893, float:4.8994E-41)
                android.opengl.GLES20.glBindBuffer(r4, r10)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r11 = r4.f3885ag
                r12 = 3
                r13 = 5126(0x1406, float:7.183E-42)
                r14 = 0
                r15 = 12
                r16 = r0
                java.nio.Buffer r16 = (java.nio.Buffer) r16
                android.opengl.GLES20.glVertexAttribPointer(r11, r12, r13, r14, r15, r16)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3881ac
                if (r0 != 0) goto L_0x0238
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0238:
                java.lang.String r4 = "glVertexAttribPointer PositionLocation"
                r0.mo14361a((java.lang.String) r4)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r0 = r0.f3885ag
                android.opengl.GLES20.glEnableVertexAttribArray(r0)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3881ac
                if (r0 != 0) goto L_0x0251
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0251:
                java.lang.String r4 = "glEnableVertexAttribArray PositionLocation"
                r0.mo14361a((java.lang.String) r4)
                r1.position(r10)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r11 = r0.f3886ah
                r12 = 2
                r13 = 5126(0x1406, float:7.183E-42)
                r14 = 0
                r15 = 8
                r16 = r1
                java.nio.Buffer r16 = (java.nio.Buffer) r16
                android.opengl.GLES20.glVertexAttribPointer(r11, r12, r13, r14, r15, r16)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r0 = r0.f3886ah
                android.opengl.GLES20.glEnableVertexAttribArray(r0)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3881ac
                if (r0 != 0) goto L_0x0280
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0280:
                java.lang.String r1 = "glEnableVertexAttribArray TextureCoordLocation"
                r0.mo14361a((java.lang.String) r1)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                boolean r0 = r0.f3874T
                if (r0 == 0) goto L_0x02ad
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r0 = r0.f3889ak
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                float[] r1 = r1.f3892an
                android.opengl.GLES20.glUniformMatrix4fv(r0, r9, r10, r1, r10)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3881ac
                if (r0 != 0) goto L_0x02a7
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x02a7:
                java.lang.String r1 = "glUniformMatrix4fv mMVPMatrix"
                r0.mo14361a((java.lang.String) r1)
                goto L_0x02cc
            L_0x02ad:
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r0 = r0.f3889ak
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                float[] r1 = r1.f3891am
                android.opengl.GLES20.glUniformMatrix4fv(r0, r9, r10, r1, r10)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3881ac
                if (r0 != 0) goto L_0x02c7
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x02c7:
                java.lang.String r1 = "glUniformMatrix4fv mMVPMatrix"
                r0.mo14361a((java.lang.String) r1)
            L_0x02cc:
                r0 = 4
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                short[] r1 = r1.f3893ao
                int r1 = r1.length
                r4 = 5123(0x1403, float:7.179E-42)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.d r5 = r5.f3881ac
                if (r5 != 0) goto L_0x02e1
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x02e1:
                java.nio.ShortBuffer r5 = r5.mo14366f()
                java.nio.Buffer r5 = (java.nio.Buffer) r5
                android.opengl.GLES20.glDrawElements(r0, r1, r4, r5)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                android.opengl.EGLDisplay r0 = r0.f3926x
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                android.opengl.EGLSurface r1 = r1.f3855A
                android.opengl.EGL14.eglSwapBuffers(r0, r1)
                if (r2 != 0) goto L_0x02fe
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x02fe:
                r2.rewind()
                if (r3 != 0) goto L_0x0306
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0306:
                r3.rewind()
                return
            L_0x030a:
                java.lang.String r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.f3843aI
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "view size not init:"
                r1.append(r2)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r2 = r2.f3914l
                r1.append(r2)
                java.lang.String r2 = "x"
                r1.append(r2)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r2 = r2.f3915m
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.i(r0, r1)
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r1 = r1.getViewWidth()
                r0.f3914l = r1
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                com.meizu.camera.effectlib.effects.views.MzSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzSurfaceView.this
                int r1 = r1.getViewHeight()
                r0.f3915m = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzSurfaceView.C1176a.m4587a(byte[]):void");
        }

        /* renamed from: a */
        private final void m4586a(String str) {
            int eglGetError;
            if (!PatchProxy.proxy(new Object[]{str}, this, f3929a, false, 399, new Class[]{String.class}, Void.TYPE).isSupported && (eglGetError = EGL14.eglGetError()) != 12288) {
                String n = MzSurfaceView.f3843aI;
                Log.d(n, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
                throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            }
        }

        /* renamed from: a */
        private final Bitmap m4584a(int i, int i2, int i3) {
            float f;
            Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3)};
            ChangeQuickRedirect changeQuickRedirect = f3929a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 400, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            Log.i(MzSurfaceView.f3843aI, "getBitmapforGpu:" + i + "x" + i2);
            ByteBuffer allocate = ByteBuffer.allocate(i * i2 * 4);
            GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocate);
            ByteBuffer wrap = ByteBuffer.wrap(allocate.array());
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(wrap);
            Bitmap a = SurfaceTextureBitmap.m6364a(createBitmap);
            createBitmap.recycle();
            float f2 = (float) i;
            float ab = MzSurfaceView.this.f3902ax * f2;
            if (MzSurfaceView.this.f3904az < ((float) 0)) {
                f = (((float) i2) * MzSurfaceView.this.f3903ay) + MzSurfaceView.this.f3904az;
                MzSurfaceView.this.f3904az = 0.0f;
            } else {
                f = ((float) i2) * MzSurfaceView.this.f3903ay;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(a, 0, (int) MzSurfaceView.this.f3904az, i, (int) ((f / ab) * f2));
            a.recycle();
            Log.i(MzSurfaceView.f3843aI, "getBitmapforGpu end");
            C3443i.m21152a((Object) createBitmap2, "bmp3");
            return createBitmap2;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/views/MzSurfaceView$Companion;", "", "()V", "DELAYTIME", "", "DELAYTOFTIME", "MSG_ATTACH", "", "MSG_DEINIT", "MSG_DETACH", "MSG_INIT", "MSG_RELEASE", "MSG_RENDER", "MSG_TYPE_ENABLE_BOKEH", "MSG_TYPE_ENABLE_TOF", "MSG_TYPE_ON_SURFACE_TEXTURE_AVAILIBLE", "MSG_TYPE_ON_SURFACE_TEXTURE_DESTROYED", "MSG_TYPE_ON_SURFACE_TEXTURE_UPDATED", "POS_VERTICES", "", "TAG", "", "TEX_VERTICES", "TEX_VERTICES_WITCH", "mCount", "verticalConvert", "Landroid/graphics/Bitmap;", "bitmap", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.views.MzSurfaceView$d */
    /* compiled from: MzSurfaceView.kt */
    public static final class C1180d {

        /* renamed from: a */
        public static ChangeQuickRedirect f3941a;

        private C1180d() {
        }

        public /* synthetic */ C1180d(DefaultConstructorMarker gVar) {
            this();
        }

        @Nullable
        /* renamed from: a */
        public final Bitmap mo14268a(@Nullable Bitmap bitmap) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, f3941a, false, 404, new Class[]{Bitmap.class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            Canvas canvas = new Canvas();
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            canvas.setBitmap(createBitmap);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.reset();
            matrix.postRotate(180.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
            matrix.postScale(-1.0f, 1.0f);
            matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
            canvas.drawBitmap(bitmap, matrix, (Paint) null);
            bitmap.recycle();
            return createBitmap;
        }
    }
}
