package com.meizu.media.camera.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.jvm.p108b.Ref;
import kotlin.p100c.C3357b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020 H\u0002J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020 H\u0002J\u0010\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020 H\u0002J\u001a\u0010G\u001a\u00020H2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010I\u001a\u0004\u0018\u00010\u0005J\u000e\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020\u0015J\u0010\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020\u0015H\u0002J\u0006\u0010N\u001a\u00020HJ\u0010\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020QH\u0014J0\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0014J\u0018\u0010X\u001a\u00020H2\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007H\u0014J\u0016\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u00020 J\u0006\u0010^\u001a\u00020HJ\u0016\u0010_\u001a\u00020H2\u0006\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u00020 J\u0010\u0010`\u001a\u00020\u00152\u0006\u0010a\u001a\u00020bH\u0016J \u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0015H\u0002J\u000e\u0010g\u001a\u00020H2\u0006\u0010h\u001a\u00020\u0007J\u0016\u0010i\u001a\u00020H2\u0006\u0010j\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u0007J\u0010\u0010l\u001a\u00020H2\b\u0010m\u001a\u0004\u0018\u00010'J\u000e\u0010n\u001a\u00020H2\u0006\u0010o\u001a\u00020\u0007J\u000e\u0010p\u001a\u00020H2\u0006\u0010q\u001a\u00020 J\u000e\u0010r\u001a\u00020H2\u0006\u0010s\u001a\u00020\u001eJ\u0014\u0010t\u001a\u00020H2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020 0\u001dJ\u0014\u0010v\u001a\u00020H2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u000e\u0010x\u001a\u00020H2\u0006\u0010y\u001a\u00020\u0007J\u001e\u0010z\u001a\u00020H2\u000e\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0006\u0010|\u001a\u00020\u0015J\u000e\u0010}\u001a\u00020H2\u0006\u0010~\u001a\u00020 J\u0019\u0010\u001a\u00020H2\u0006\u0010M\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020 H\u0002J\u0010\u0010\u0001\u001a\u00020H2\u0007\u0010\u0001\u001a\u00020\u0015R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo27294d2 = {"Lcom/meizu/media/camera/views/ZoomCircleBoardView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBgPaint", "Landroid/graphics/Paint;", "mCameraState", "mCenterSelectPaint", "mCircleCenter", "Landroid/graphics/Point;", "mCircleRadius", "mCircleScaleInRadius", "mCircleScaleOutRadius", "mClickZoomIndexList", "Ljava/util/ArrayList;", "mCurrentInSpecialAngle", "", "mHintPaint", "Landroid/text/TextPaint;", "mHintPath", "Landroid/graphics/Path;", "mHintPathRectF", "Landroid/graphics/RectF;", "mHintText", "", "", "mHintTextAngle", "", "mIsScaleZoom", "mIsTeleRecording", "mLastValueIndex", "mLastX", "mLastY", "mListener", "Lcom/meizu/media/camera/views/ZoomCircleBoardView$ZoomCircleViewListener;", "mMaxMoveOffSet", "mMaxValueIndex", "mMinMoveOffSet", "mMoveAngleDiff", "mMoveAngleOffSet", "mMoveOffSet", "mPerformHapticAngle", "mPerformValueIndex", "mResourcesContext", "mSelectedValueIndex", "mSpecialThickAngle", "mSpecialThickText", "mSpecialThickTextAngle", "mStartAngle", "mThickAngleInterval", "mThickPaint", "mThinAngleMaxIndex", "mThinAngleMaxOffset", "mThinIndexOffSet", "mThinPaint", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mWidth", "getAngleByLength", "length", "getCoordinatePoint", "", "radius", "cirAngle", "getLengthByAngle", "angle", "init", "", "attributeSet", "isInSpecialAngle", "value", "notifyValueChange", "notifyValue", "onActionUp", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onScale", "xPos", "yPos", "onScaleEnd", "onScaleStart", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "scrollToTarget", "targetMove", "thickIndex", "updateChange", "setCameraState", "cameraState", "setCurrentValue", "thickAngleIndex", "zoomIndex", "setListener", "listener", "setMaxValueIndex", "maxIndex", "setSpecialAngle", "specialAngle", "setSpecialThickText", "specialThickText", "setThickAngle", "thickAngle", "setThickHintText", "thickHint", "setThinIndexOffSet", "thinIndexOffSet", "setZoomClickIndex", "clickIndexList", "resetValue", "updateMoveOffSet", "delta", "updateValue", "offSet", "updateVideoTeleStatus", "isTeleRecording", "Companion", "ZoomCircleViewListener", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: ZoomCircleBoardView.kt */
public final class ZoomCircleBoardView extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f15153a;

    /* renamed from: b */
    public static final C2733a f15154b = new C2733a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: A */
    public float f15155A;

    /* renamed from: B */
    private float f15156B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f15157C;

    /* renamed from: D */
    private int f15158D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public C2734b f15159E;

    /* renamed from: F */
    private ValueAnimator f15160F;

    /* renamed from: G */
    private ArrayList<Integer> f15161G;

    /* renamed from: H */
    private boolean f15162H;

    /* renamed from: I */
    private boolean f15163I;

    /* renamed from: J */
    private int f15164J;

    /* renamed from: K */
    private int f15165K;

    /* renamed from: L */
    private int f15166L;

    /* renamed from: M */
    private float f15167M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public float f15168N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public int f15169O;

    /* renamed from: P */
    private Path f15170P;

    /* renamed from: Q */
    private RectF f15171Q;

    /* renamed from: R */
    private boolean f15172R;

    /* renamed from: c */
    private Point f15173c;

    /* renamed from: d */
    private int f15174d;

    /* renamed from: e */
    private int f15175e;

    /* renamed from: f */
    private int f15176f;

    /* renamed from: g */
    private Context f15177g;

    /* renamed from: h */
    private Paint f15178h;

    /* renamed from: i */
    private Paint f15179i;

    /* renamed from: j */
    private Paint f15180j;

    /* renamed from: k */
    private Paint f15181k;

    /* renamed from: l */
    private TextPaint f15182l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f15183m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f15184n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public List<Float> f15185o;

    /* renamed from: p */
    private String f15186p;

    /* renamed from: q */
    private float f15187q;

    /* renamed from: r */
    private List<String> f15188r;

    /* renamed from: s */
    private List<Float> f15189s;

    /* renamed from: t */
    private float f15190t;

    /* renamed from: u */
    private float f15191u;

    /* renamed from: v */
    private int f15192v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public float f15193w;

    /* renamed from: x */
    private float f15194x;

    /* renamed from: y */
    private float f15195y;

    /* renamed from: z */
    private int f15196z;

    @JvmOverloads
    public ZoomCircleBoardView(@Nullable Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ZoomCircleBoardView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ZoomCircleBoardView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15183m = -15.0f;
        this.f15184n = 270.0f;
        this.f15185o = new ArrayList();
        this.f15186p = "15mm";
        this.f15188r = new ArrayList();
        this.f15189s = new ArrayList();
        this.f15158D = this.f15157C;
        this.f15164J = -1;
        this.f15169O = this.f15158D;
        this.f15170P = new Path();
        mo23282a(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ZoomCircleBoardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH&¨\u0006\r"}, mo27294d2 = {"Lcom/meizu/media/camera/views/ZoomCircleBoardView$ZoomCircleViewListener;", "", "isAnimRunning", "", "isVideoRecording", "onChange", "", "index", "", "updateValue", "onValueChange", "valueIndex", "calculateCameraId", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ZoomCircleBoardView$b */
    /* compiled from: ZoomCircleBoardView.kt */
    public interface C2734b {
        /* renamed from: a */
        void mo22205a(int i, int i2);

        /* renamed from: a */
        void mo22206a(int i, boolean z);

        /* renamed from: a */
        boolean mo22207a();

        /* renamed from: b */
        boolean mo22208b();

        @Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 15})
        /* renamed from: com.meizu.media.camera.views.ZoomCircleBoardView$b$a */
        /* compiled from: ZoomCircleBoardView.kt */
        public static final class C2735a {
            /* renamed from: a */
            public static /* synthetic */ void m16684a(C2734b bVar, int i, int i2, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        i2 = -1;
                    }
                    bVar.mo22205a(i, i2);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onValueChange");
            }
        }
    }

    /* renamed from: a */
    public final void mo23282a(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        if (!PatchProxy.proxy(new Object[]{context, attributeSet}, this, f15153a, false, 8927, new Class[]{Context.class, AttributeSet.class}, Void.TYPE).isSupported) {
            this.f15177g = context;
            Context context2 = this.f15177g;
            if (context2 == null) {
                C3443i.m21151a();
            }
            Resources resources = context2.getResources();
            this.f15173c = new Point(resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle_board_center_x), resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle_board_center_y));
            Point point = this.f15173c;
            if (point == null) {
                C3443i.m21151a();
            }
            this.f15174d = point.y;
            this.f15175e = this.f15174d - resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle__board_scale_out_radius_padding);
            this.f15176f = resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle_board_scale_in_radius);
            this.f15178h = new Paint();
            Paint paint = this.f15178h;
            if (paint == null) {
                C3443i.m21151a();
            }
            paint.setAntiAlias(true);
            Paint paint2 = this.f15178h;
            if (paint2 == null) {
                C3443i.m21151a();
            }
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = this.f15178h;
            if (paint3 == null) {
                C3443i.m21151a();
            }
            paint3.setStrokeWidth((float) this.f15174d);
            Paint paint4 = this.f15178h;
            if (paint4 == null) {
                C3443i.m21151a();
            }
            paint4.setColor(resources.getColor(R.color.mz_zoom_circle_board_bg));
            this.f15180j = new Paint(1);
            Paint paint5 = this.f15180j;
            if (paint5 == null) {
                C3443i.m21151a();
            }
            paint5.setStrokeWidth(4.0f);
            Paint paint6 = this.f15180j;
            if (paint6 == null) {
                C3443i.m21151a();
            }
            paint6.setStyle(Paint.Style.STROKE);
            Paint paint7 = this.f15180j;
            if (paint7 == null) {
                C3443i.m21151a();
            }
            paint7.setColor(-1);
            this.f15181k = new Paint(this.f15180j);
            Paint paint8 = this.f15181k;
            if (paint8 == null) {
                C3443i.m21151a();
            }
            paint8.setStrokeWidth(2.0f);
            Paint paint9 = this.f15181k;
            if (paint9 == null) {
                C3443i.m21151a();
            }
            paint9.setColor(resources.getColor(R.color.mz_zoom_circle_board_thin_paint));
            this.f15179i = new Paint(this.f15180j);
            Paint paint10 = this.f15179i;
            if (paint10 == null) {
                C3443i.m21151a();
            }
            paint10.setColor(getResources().getColor(R.color.mz_settting_item_select_color));
            this.f15182l = new TextPaint(1);
            TextPaint textPaint = this.f15182l;
            if (textPaint == null) {
                C3443i.m21151a();
            }
            textPaint.setAntiAlias(true);
            TextPaint textPaint2 = this.f15182l;
            if (textPaint2 == null) {
                C3443i.m21151a();
            }
            textPaint2.setTextSize(24.0f);
            TextPaint textPaint3 = this.f15182l;
            if (textPaint3 == null) {
                C3443i.m21151a();
            }
            textPaint3.setColor(resources.getColor(R.color.mz_zoom_circle_board_thin_paint));
            TextPaint textPaint4 = this.f15182l;
            if (textPaint4 == null) {
                C3443i.m21151a();
            }
            this.f15187q = m16659b(textPaint4.measureText(this.f15186p));
            this.f15195y = -m16663c(this.f15183m);
            Point point2 = this.f15173c;
            if (point2 == null) {
                C3443i.m21151a();
            }
            float f = ((float) point2.x) * 2.0f;
            Point point3 = this.f15173c;
            if (point3 == null) {
                C3443i.m21151a();
            }
            this.f15171Q = new RectF(0.0f, 86.5f, f, ((((float) point3.x) * 2.0f) + ((float) 90)) - 3.5f);
        }
    }

    public final void setSpecialAngle(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8928, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f15183m = f;
            this.f15195y = -m16663c(this.f15183m);
        }
    }

    public final void setSpecialThickText(@NotNull String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f15153a, false, 8929, new Class[]{String.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str, "specialThickText");
            if (this.f15183m != 0.0f) {
                this.f15186p = str;
            }
            TextPaint textPaint = this.f15182l;
            if (textPaint == null) {
                C3443i.m21151a();
            }
            this.f15187q = m16659b(textPaint.measureText(this.f15186p));
        }
    }

    public final void setThickAngle(@NotNull List<Float> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f15153a, false, 8930, new Class[]{List.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(list, "thickAngle");
            this.f15185o.clear();
            this.f15185o = list;
        }
    }

    public final void setThickHintText(@NotNull List<String> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f15153a, false, 8931, new Class[]{List.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(list, "thickHint");
            this.f15188r = list;
            int size = this.f15188r.size();
            for (int i = 0; i < size; i++) {
                List<Float> list2 = this.f15189s;
                TextPaint textPaint = this.f15182l;
                if (textPaint == null) {
                    C3443i.m21151a();
                }
                list2.add(i, Float.valueOf(m16659b(textPaint.measureText(this.f15188r.get(i)))));
            }
        }
    }

    public final void setThinIndexOffSet(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8932, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15165K = i;
            this.f15166L = ((this.f15185o.size() - 1) * 10) + this.f15165K;
            this.f15167M = ((float) this.f15165K) * 1.5f;
            this.f15194x = -m16663c(((float) this.f15166L) * 1.5f);
        }
    }

    public final void setMaxValueIndex(int i) {
        this.f15196z = i;
    }

    public final void setListener(@Nullable C2734b bVar) {
        this.f15159E = bVar;
    }

    public final void setZoomClickIndex(@Nullable ArrayList<Integer> arrayList, boolean z) {
        Object[] objArr = {arrayList, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8933, new Class[]{ArrayList.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15161G = arrayList;
            if (z) {
                this.f15184n = 270.0f;
                this.f15193w = 0.0f;
                this.f15156B = 0.0f;
                this.f15155A = 0.0f;
                this.f15157C = 0;
                this.f15169O = 0;
                this.f15168N = 0.0f;
                this.f15172R = false;
            }
            invalidate();
        }
    }

    /* renamed from: a */
    public final void mo23283a(boolean z) {
        float f;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8934, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15172R = z;
            if (this.f15172R) {
                f = -m16663c(this.f15185o.get(2).floatValue());
            } else {
                f = -m16663c(this.f15183m);
            }
            this.f15195y = f;
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8935, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, i2);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8936, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onLayout(z, i, i2, i3, i4);
            this.f15192v = getWidth();
        }
    }

    public void onDraw(@NotNull Canvas canvas) {
        float f;
        float f2;
        Canvas canvas2 = canvas;
        if (!PatchProxy.proxy(new Object[]{canvas2}, this, f15153a, false, 8937, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(canvas2, "canvas");
            if (getVisibility() == 0) {
                super.onDraw(canvas);
                Point point = this.f15173c;
                if (point == null) {
                    C3443i.m21151a();
                }
                float f3 = (float) point.x;
                Point point2 = this.f15173c;
                if (point2 == null) {
                    C3443i.m21151a();
                }
                float f4 = (float) point2.y;
                float f5 = (float) this.f15174d;
                Paint paint = this.f15178h;
                if (paint == null) {
                    C3443i.m21151a();
                }
                canvas2.drawCircle(f3, f4, f5, paint);
                if (this.f15183m != 0.0f) {
                    float f6 = this.f15184n + this.f15183m;
                    float[] a = m16658a(this.f15175e, f6);
                    float[] a2 = m16658a(this.f15176f, f6);
                    float f7 = a[0];
                    float f8 = a[1];
                    float f9 = a2[0];
                    float f10 = a2[1];
                    Paint paint2 = this.f15180j;
                    if (paint2 == null) {
                        C3443i.m21151a();
                    }
                    canvas.drawLine(f7, f8, f9, f10, paint2);
                    this.f15170P.reset();
                    Path path = this.f15170P;
                    RectF rectF = this.f15171Q;
                    if (rectF == null) {
                        C3443i.m21151a();
                    }
                    path.addArc(rectF, (this.f15184n + this.f15183m) - (this.f15187q / ((float) 2)), this.f15187q);
                    String str = this.f15186p;
                    Path path2 = this.f15170P;
                    TextPaint textPaint = this.f15182l;
                    if (textPaint == null) {
                        C3443i.m21151a();
                    }
                    canvas.drawTextOnPath(str, path2, 0.0f, 0.0f, textPaint);
                }
                int i = this.f15172R ? 15 : 0;
                int i2 = this.f15166L;
                if (i <= i2) {
                    int i3 = i;
                    while (true) {
                        float f11 = this.f15184n + (((float) i3) * 1.5f);
                        float[] a3 = m16658a(this.f15175e, f11);
                        float[] a4 = m16658a(this.f15176f, f11);
                        float f12 = a3[0];
                        float f13 = a3[1];
                        float f14 = a4[0];
                        float f15 = a4[1];
                        Paint paint3 = this.f15181k;
                        if (paint3 == null) {
                            C3443i.m21151a();
                        }
                        canvas.drawLine(f12, f13, f14, f15, paint3);
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
                int i4 = this.f15172R ? 2 : 0;
                int size = this.f15185o.size();
                for (int i5 = i4; i5 < size; i5++) {
                    if (DeviceHelper.f13930bd == -1 || i5 != this.f15185o.size() - 1) {
                        f2 = this.f15184n + this.f15185o.get(i5).floatValue();
                    } else {
                        f2 = this.f15184n + (((float) this.f15166L) * 1.5f);
                    }
                    float[] a5 = m16658a(this.f15175e, f2);
                    float[] a6 = m16658a(this.f15176f, f2);
                    float f16 = a5[0];
                    float f17 = a5[1];
                    float f18 = a6[0];
                    float f19 = a6[1];
                    Paint paint4 = this.f15180j;
                    if (paint4 == null) {
                        C3443i.m21151a();
                    }
                    canvas.drawLine(f16, f17, f18, f19, paint4);
                }
                int i6 = this.f15172R ? 2 : 0;
                int size2 = this.f15188r.size();
                for (int i7 = i6; i7 < size2; i7++) {
                    if (DeviceHelper.f13930bd == -1 || i7 != this.f15188r.size() - 1) {
                        f = this.f15184n + this.f15185o.get(i7).floatValue();
                    } else {
                        f = this.f15184n + (((float) this.f15166L) * 1.5f);
                    }
                    this.f15170P.reset();
                    Path path3 = this.f15170P;
                    RectF rectF2 = this.f15171Q;
                    if (rectF2 == null) {
                        C3443i.m21151a();
                    }
                    path3.addArc(rectF2, f - (this.f15189s.get(i7).floatValue() / ((float) 2)), this.f15189s.get(i7).floatValue());
                    String str2 = this.f15188r.get(i7);
                    Path path4 = this.f15170P;
                    TextPaint textPaint2 = this.f15182l;
                    if (textPaint2 == null) {
                        C3443i.m21151a();
                    }
                    canvas.drawTextOnPath(str2, path4, 0.0f, 0.0f, textPaint2);
                }
                float[] a7 = m16658a(this.f15175e, 270.0f);
                float[] a8 = m16658a(this.f15176f, 270.0f);
                float f20 = a7[0];
                float f21 = a7[1];
                float f22 = a8[0];
                float f23 = a8[1];
                Paint paint5 = this.f15179i;
                if (paint5 == null) {
                    C3443i.m21151a();
                }
                canvas.drawLine(f20, f21, f22, f23, paint5);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r1.mo22207a() == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f15153a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.view.MotionEvent> r2 = android.view.MotionEvent.class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 8938(0x22ea, float:1.2525E-41)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0025
            java.lang.Object r10 = r1.result
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            return r10
        L_0x0025:
            java.lang.String r1 = "event"
            kotlin.jvm.p108b.C3443i.m21155b(r10, r1)
            int r1 = r9.getVisibility()
            if (r1 != 0) goto L_0x009b
            com.meizu.media.camera.views.ZoomCircleBoardView$b r1 = r9.f15159E
            if (r1 == 0) goto L_0x0041
            com.meizu.media.camera.views.ZoomCircleBoardView$b r1 = r9.f15159E
            if (r1 != 0) goto L_0x003b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x003b:
            boolean r1 = r1.mo22207a()
            if (r1 != 0) goto L_0x009b
        L_0x0041:
            boolean r1 = r9.f15162H
            if (r1 == 0) goto L_0x0046
            goto L_0x009b
        L_0x0046:
            int r1 = r10.getAction()
            float r2 = r10.getX()
            int r2 = (int) r2
            float r10 = r10.getY()
            android.animation.ValueAnimator r3 = r9.f15160F
            if (r3 == 0) goto L_0x0065
            android.animation.ValueAnimator r3 = r9.f15160F
            if (r3 != 0) goto L_0x005e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x005e:
            boolean r3 = r3.isRunning()
            if (r3 == 0) goto L_0x0065
            return r0
        L_0x0065:
            switch(r1) {
                case 0: goto L_0x008e;
                case 1: goto L_0x008a;
                case 2: goto L_0x0069;
                case 3: goto L_0x008a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x0095
        L_0x0069:
            float r1 = r9.f15190t
            float r3 = (float) r2
            float r1 = r1 - r3
            float r3 = r9.f15191u
            float r3 = r10 - r3
            int r4 = r9.f15192v
            int r4 = r4 / 2
            if (r2 <= r4) goto L_0x0078
            float r3 = -r3
        L_0x0078:
            float r4 = java.lang.Math.abs(r1)
            float r5 = java.lang.Math.abs(r3)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r1 = r3
        L_0x0086:
            r9.m16657a((boolean) r0, (float) r1)
            goto L_0x0095
        L_0x008a:
            r9.mo23284b()
            goto L_0x0095
        L_0x008e:
            r9.f15162H = r8
            float r1 = (float) r2
            r9.f15190t = r1
            r9.f15191u = r10
        L_0x0095:
            float r1 = (float) r2
            r9.f15190t = r1
            r9.f15191u = r10
            return r0
        L_0x009b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.ZoomCircleBoardView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    public final void mo23281a(float f, float f2) {
        this.f15162H = true;
        this.f15190t = f;
        this.f15191u = f2;
    }

    /* renamed from: b */
    public final void mo23285b(float f, float f2) {
        Object[] objArr = {new Float(f), new Float(f2)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8939, new Class[]{Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            float f3 = f - this.f15190t;
            float f4 = f2 - this.f15191u;
            if (Math.abs(f3) <= Math.abs(f4)) {
                f3 = f4;
            }
            m16657a(true, f3);
            this.f15190t = f;
            this.f15191u = f2;
        }
    }

    /* renamed from: a */
    public final void mo23279a() {
        if (!PatchProxy.proxy(new Object[0], this, f15153a, false, 8940, new Class[0], Void.TYPE).isSupported && this.f15162H) {
            this.f15162H = false;
            mo23284b();
        }
    }

    /* renamed from: a */
    public final void mo23280a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15153a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8941, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            m16657a(true, f);
        }
    }

    public final void setCurrentValue(int i, int i2) {
        int i3;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f15153a, false, 8942, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f15160F != null) {
                ValueAnimator valueAnimator = this.f15160F;
                if (valueAnimator == null) {
                    C3443i.m21151a();
                }
                if (valueAnimator.isRunning()) {
                    return;
                }
            }
            if (i != -1) {
                if (this.f15183m == 0.0f) {
                    i3 = i;
                } else if (i == 0) {
                    m16653a((270.0f - this.f15183m) - this.f15184n, i, false);
                    this.f15157C = -1;
                    return;
                } else {
                    i3 = i - 1;
                }
                if (i2 == -1) {
                    i2 = i;
                }
                ArrayList<Integer> arrayList = this.f15161G;
                if (arrayList == null) {
                    C3443i.m21151a();
                }
                Integer num = arrayList.get(i2);
                C3443i.m21152a((Object) num, "mClickZoomIndexList!![indexZoom]");
                this.f15157C = num.intValue();
                ArrayList<Integer> arrayList2 = this.f15161G;
                if (arrayList2 == null) {
                    C3443i.m21151a();
                }
                Integer num2 = arrayList2.get(i2);
                C3443i.m21152a((Object) num2, "mClickZoomIndexList!![indexZoom]");
                int intValue = num2.intValue();
                if (101 <= intValue && 299 >= intValue) {
                    this.f15157C = 100;
                }
                m16653a((270.0f - this.f15185o.get(i3).floatValue()) - this.f15184n, i, false);
            } else if (i2 != -1) {
                this.f15157C = i2;
            }
        }
    }

    /* renamed from: b */
    public final void mo23284b() {
        float f;
        if (!PatchProxy.proxy(new Object[0], this, f15153a, false, 8943, new Class[0], Void.TYPE).isSupported) {
            this.f15190t = 0.0f;
            if (this.f15183m != 0.0f && this.f15184n >= 270.0f - (this.f15183m / ((float) 2))) {
                f = Math.abs(this.f15183m) - (this.f15184n - 270.0f);
                m16653a(Math.abs(this.f15183m) - (this.f15184n - 270.0f), 0, true);
            } else if (this.f15183m == 0.0f || this.f15184n >= 270.0f - (this.f15183m / ((float) 2)) || this.f15184n < 270.0f) {
                f = 0.0f;
            } else {
                f = 270.0f - this.f15184n;
                m16653a(270.0f - this.f15184n, 1, true);
                this.f15157C = 0;
            }
            if (f != 0.0f) {
                C2734b bVar = this.f15159E;
                if (bVar == null) {
                    C3443i.m21151a();
                }
                if (!bVar.mo22208b()) {
                    DeviceUtil.m16194a((View) this, 22500);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m16657a(boolean z, float f) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Float(f)}, this, f15153a, false, 8944, new Class[]{Boolean.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            this.f15193w -= f;
            if (this.f15193w >= this.f15195y) {
                this.f15193w = this.f15195y;
            } else if (this.f15193w <= this.f15194x) {
                this.f15193w = this.f15194x;
            }
            this.f15155A = m16659b(this.f15193w);
            this.f15184n = this.f15155A + 270.0f;
            if (this.f15157C == -1 && this.f15184n <= 270.0f) {
                this.f15184n = 270.0f;
            } else if (this.f15172R && this.f15184n >= 270.0f - this.f15185o.get(2).floatValue()) {
                this.f15184n = 270.0f - this.f15185o.get(2).floatValue();
            } else if (this.f15184n >= 270.0f - this.f15183m) {
                this.f15184n = 270.0f - this.f15183m;
            } else if (this.f15184n <= (270.0f - this.f15185o.get(this.f15185o.size() - 1).floatValue()) - this.f15167M) {
                this.f15184n = (270.0f - this.f15185o.get(this.f15185o.size() - 1).floatValue()) - this.f15167M;
            }
            m16666c(z);
            invalidate();
        }
    }

    /* renamed from: b */
    private final float m16659b(float f) {
        return (float) (((double) (f * 360.0f)) / (((double) this.f15174d) * 6.283185307179586d));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final float m16663c(float f) {
        return (float) (((double) (f / 360.0f)) * ((double) this.f15174d) * 6.283185307179586d);
    }

    /* renamed from: b */
    public final void mo23286b(boolean z) {
        this.f15163I = z;
    }

    public final void setCameraState(int i) {
        this.f15164J = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r1.isRunning() == false) goto L_0x0041;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m16666c(boolean r12) {
        /*
            r11 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r12)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f15153a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 8945(0x22f1, float:1.2535E-41)
            r2 = r11
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            com.meizu.media.camera.views.ZoomCircleBoardView$b r1 = r11.f15159E
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            float r1 = r11.f15183m
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1132920832(0x43870000, float:270.0)
            if (r1 == 0) goto L_0x0075
            android.animation.ValueAnimator r1 = r11.f15160F
            if (r1 == 0) goto L_0x0041
            android.animation.ValueAnimator r1 = r11.f15160F
            if (r1 != 0) goto L_0x003b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x003b:
            boolean r1 = r1.isRunning()
            if (r1 != 0) goto L_0x0075
        L_0x0041:
            boolean r1 = r11.f15163I
            if (r1 != 0) goto L_0x005c
            float r1 = r11.f15184n
            float r4 = r11.f15183m
            float r4 = r3 - r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x005c
            r11.f15158D = r8
            com.meizu.media.camera.views.ZoomCircleBoardView$b r12 = r11.f15159E
            if (r12 != 0) goto L_0x0058
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0058:
            r12.mo22206a((int) r8, (boolean) r8)
            return
        L_0x005c:
            boolean r1 = r11.f15163I
            if (r1 == 0) goto L_0x0075
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0075
            r11.f15158D = r8
            r11.f15157C = r8
            com.meizu.media.camera.views.ZoomCircleBoardView$b r12 = r11.f15159E
            if (r12 != 0) goto L_0x0071
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0071:
            r12.mo22206a((int) r0, (boolean) r8)
            return
        L_0x0075:
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r3 = 1132396544(0x437f0000, float:255.0)
            r4 = 100
            if (r1 >= 0) goto L_0x008f
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x008f
            int r1 = r11.f15157C
            if (r1 <= r4) goto L_0x008b
            r11.f15157C = r4
        L_0x008b:
            r1 = 100
            goto L_0x012e
        L_0x008f:
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r3 = 1131413504(0x43700000, float:240.0)
            r5 = 300(0x12c, float:4.2E-43)
            if (r1 >= 0) goto L_0x00b0
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x00b0
            int r1 = r11.f15157C
            if (r1 >= r4) goto L_0x00a6
            r11.f15157C = r4
            goto L_0x00ac
        L_0x00a6:
            int r1 = r11.f15157C
            if (r1 <= r5) goto L_0x00ac
            r11.f15157C = r5
        L_0x00ac:
            r1 = 200(0xc8, float:2.8E-43)
            goto L_0x012e
        L_0x00b0:
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r3 = 700(0x2bc, float:9.81E-43)
            if (r1 >= 0) goto L_0x00d0
            float r1 = r11.f15184n
            r6 = 1130430464(0x43610000, float:225.0)
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x00d0
            int r1 = r11.f15157C
            if (r1 >= r5) goto L_0x00c7
            r11.f15157C = r5
            goto L_0x00cd
        L_0x00c7:
            int r1 = r11.f15157C
            if (r1 <= r3) goto L_0x00cd
            r11.f15157C = r3
        L_0x00cd:
            r1 = 400(0x190, float:5.6E-43)
            goto L_0x012e
        L_0x00d0:
            float r1 = r11.f15184n
            r5 = 1130758144(0x43660000, float:230.0)
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            r5 = 1129447424(0x43520000, float:210.0)
            r6 = 1500(0x5dc, float:2.102E-42)
            if (r1 >= 0) goto L_0x00f2
            float r1 = r11.f15184n
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x00f2
            int r1 = r11.f15157C
            if (r1 >= r3) goto L_0x00e9
            r11.f15157C = r3
            goto L_0x00ef
        L_0x00e9:
            int r1 = r11.f15157C
            if (r1 <= r6) goto L_0x00ef
            r11.f15157C = r6
        L_0x00ef:
            r1 = 800(0x320, float:1.121E-42)
            goto L_0x012e
        L_0x00f2:
            float r1 = r11.f15184n
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            r3 = 1128464384(0x43430000, float:195.0)
            r5 = 3100(0xc1c, float:4.344E-42)
            if (r1 >= 0) goto L_0x0112
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0112
            int r1 = r11.f15157C
            if (r1 >= r6) goto L_0x0109
            r11.f15157C = r6
            goto L_0x010f
        L_0x0109:
            int r1 = r11.f15157C
            if (r1 <= r5) goto L_0x010f
            r11.f15157C = r5
        L_0x010f:
            r1 = 1600(0x640, float:2.242E-42)
            goto L_0x012e
        L_0x0112:
            float r1 = r11.f15184n
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x012d
            float r1 = r11.f15184n
            double r6 = (double) r1
            r9 = 4640906639447162880(0x4067d00000000000, double:190.5)
            int r1 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r1 < 0) goto L_0x012d
            int r1 = r11.f15157C
            if (r1 >= r5) goto L_0x012a
            r11.f15157C = r5
        L_0x012a:
            r1 = 3200(0xc80, float:4.484E-42)
            goto L_0x012e
        L_0x012d:
            r1 = 0
        L_0x012e:
            int r3 = r11.f15157C
            if (r3 == 0) goto L_0x0145
            int r2 = r11.f15157C
            int r2 = r2 / r4
            int r2 = r2 + r0
            float r0 = (float) r2
            float r0 = kotlin.p100c.C3357b.m20933a(r0)
            int r0 = kotlin.p100c.C3357b.m20934b(r0)
            float r0 = (float) r0
            r2 = -15
            float r2 = (float) r2
            float r2 = r2 * r0
        L_0x0145:
            r11.f15156B = r2
            if (r12 != 0) goto L_0x014a
            return
        L_0x014a:
            if (r1 == 0) goto L_0x015d
            int r12 = r11.f15157C
            float r0 = (float) r1
            float r1 = r11.f15155A
            float r2 = r11.f15156B
            float r1 = r1 - r2
            float r1 = -r1
            float r0 = r0 * r1
            r1 = 1097859072(0x41700000, float:15.0)
            float r0 = r0 / r1
            int r0 = (int) r0
            int r12 = r12 + r0
            goto L_0x015e
        L_0x015d:
            r12 = 0
        L_0x015e:
            r11.f15158D = r12
            int r12 = r11.f15158D
            int r0 = r11.f15196z
            if (r12 < r0) goto L_0x016b
            int r12 = r11.f15196z
            r11.f15158D = r12
            goto L_0x0171
        L_0x016b:
            int r12 = r11.f15158D
            if (r12 > 0) goto L_0x0171
            r11.f15158D = r8
        L_0x0171:
            int r12 = r11.f15158D
            int r0 = r11.f15169O
            if (r12 == r0) goto L_0x01a3
            float r12 = r11.f15155A
            float r0 = r11.f15168N
            float r12 = r12 - r0
            float r12 = java.lang.Math.abs(r12)
            r0 = 1069547520(0x3fc00000, float:1.5)
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 < 0) goto L_0x01a3
            com.meizu.media.camera.views.ZoomCircleBoardView$b r12 = r11.f15159E
            if (r12 != 0) goto L_0x018d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x018d:
            boolean r12 = r12.mo22208b()
            if (r12 != 0) goto L_0x019b
            r12 = r11
            android.view.View r12 = (android.view.View) r12
            r0 = 22500(0x57e4, float:3.1529E-41)
            com.meizu.media.camera.util.DeviceUtil.m16194a((android.view.View) r12, (int) r0)
        L_0x019b:
            float r12 = r11.f15155A
            r11.f15168N = r12
            int r12 = r11.f15158D
            r11.f15169O = r12
        L_0x01a3:
            com.meizu.media.camera.views.ZoomCircleBoardView$b r12 = r11.f15159E
            if (r12 != 0) goto L_0x01aa
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01aa:
            int r0 = r11.f15158D
            r1 = 2
            r2 = 0
            com.meizu.media.camera.views.ZoomCircleBoardView.C2734b.C2735a.m16684a(r12, r0, r8, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.ZoomCircleBoardView.m16666c(boolean):void");
    }

    /* renamed from: a */
    private final float[] m16658a(int i, float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Float(f)}, this, f15153a, false, 8946, new Class[]{Integer.TYPE, Float.TYPE}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        float[] fArr = new float[2];
        double radians = Math.toRadians((double) f);
        float f2 = (float) 90;
        if (f < f2) {
            Point point = this.f15173c;
            if (point == null) {
                C3443i.m21151a();
            }
            double d = (double) i;
            fArr[0] = (float) (((double) point.x) + (Math.cos(radians) * d));
            Point point2 = this.f15173c;
            if (point2 == null) {
                C3443i.m21151a();
            }
            fArr[1] = (float) (((double) point2.y) + (Math.sin(radians) * d));
        } else if (f == 90.0f) {
            Point point3 = this.f15173c;
            if (point3 == null) {
                C3443i.m21151a();
            }
            fArr[0] = (float) point3.x;
            Point point4 = this.f15173c;
            if (point4 == null) {
                C3443i.m21151a();
            }
            fArr[1] = (float) (point4.y + i);
        } else {
            if (f > f2) {
                float f3 = (float) 180;
                if (f < f3) {
                    double d2 = (((double) (f3 - f)) * 3.141592653589793d) / 180.0d;
                    Point point5 = this.f15173c;
                    if (point5 == null) {
                        C3443i.m21151a();
                    }
                    double d3 = (double) i;
                    fArr[0] = (float) (((double) point5.x) - (Math.cos(d2) * d3));
                    Point point6 = this.f15173c;
                    if (point6 == null) {
                        C3443i.m21151a();
                    }
                    fArr[1] = (float) (((double) point6.y) + (Math.sin(d2) * d3));
                }
            }
            if (f == 180.0f) {
                Point point7 = this.f15173c;
                if (point7 == null) {
                    C3443i.m21151a();
                }
                fArr[0] = (float) (point7.x - i);
                Point point8 = this.f15173c;
                if (point8 == null) {
                    C3443i.m21151a();
                }
                fArr[1] = (float) point8.y;
            } else {
                float f4 = (float) 180;
                if (f > f4 && f < ((float) 270)) {
                    double d4 = (((double) (f - f4)) * 3.141592653589793d) / 180.0d;
                    Point point9 = this.f15173c;
                    if (point9 == null) {
                        C3443i.m21151a();
                    }
                    double d5 = (double) i;
                    fArr[0] = (float) (((double) point9.x) - (Math.cos(d4) * d5));
                    Point point10 = this.f15173c;
                    if (point10 == null) {
                        C3443i.m21151a();
                    }
                    fArr[1] = (float) (((double) point10.y) - (Math.sin(d4) * d5));
                } else if (f == 270.0f) {
                    Point point11 = this.f15173c;
                    if (point11 == null) {
                        C3443i.m21151a();
                    }
                    fArr[0] = (float) point11.x;
                    Point point12 = this.f15173c;
                    if (point12 == null) {
                        C3443i.m21151a();
                    }
                    fArr[1] = (float) (point12.y - i);
                } else {
                    double d6 = (((double) (((float) 360) - f)) * 3.141592653589793d) / 180.0d;
                    Point point13 = this.f15173c;
                    if (point13 == null) {
                        C3443i.m21151a();
                    }
                    double d7 = (double) i;
                    fArr[0] = (float) (((double) point13.x) + (Math.cos(d6) * d7));
                    Point point14 = this.f15173c;
                    if (point14 == null) {
                        C3443i.m21151a();
                    }
                    fArr[1] = (float) (((double) point14.y) - (Math.sin(d6) * d7));
                }
            }
        }
        return fArr;
    }

    /* renamed from: a */
    private final void m16653a(float f, int i, boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Float(f), new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f15153a, false, 8947, new Class[]{Float.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15156B = 0.0f;
            if (f != 0.0f) {
                if (this.f15160F != null) {
                    ValueAnimator valueAnimator = this.f15160F;
                    if (valueAnimator == null) {
                        C3443i.m21151a();
                    }
                    if (valueAnimator.isRunning()) {
                        ValueAnimator valueAnimator2 = this.f15160F;
                        if (valueAnimator2 == null) {
                            C3443i.m21151a();
                        }
                        valueAnimator2.end();
                    }
                }
                this.f15160F = ValueAnimator.ofFloat(new float[]{0.0f, (float) C3357b.m20934b(m16663c(f))});
                ValueAnimator valueAnimator3 = this.f15160F;
                if (valueAnimator3 != null) {
                    valueAnimator3.setDuration(200);
                }
                ValueAnimator valueAnimator4 = this.f15160F;
                if (valueAnimator4 != null) {
                    valueAnimator4.setInterpolator(new PathInterpolator(0.16f, 0.0f, 0.33f, 1.0f));
                }
                Ref.C3444a aVar = new Ref.C3444a();
                aVar.f18733a = 0.0f;
                ValueAnimator valueAnimator5 = this.f15160F;
                if (valueAnimator5 != null) {
                    valueAnimator5.addUpdateListener(new C2736c(this, aVar));
                }
                ValueAnimator valueAnimator6 = this.f15160F;
                if (valueAnimator6 != null) {
                    valueAnimator6.addListener(new C2737d(this, z, i));
                }
                ValueAnimator valueAnimator7 = this.f15160F;
                if (valueAnimator7 != null) {
                    valueAnimator7.start();
                }
            } else if (this.f15159E != null) {
                if (this.f15183m != 0.0f && this.f15184n == 270.0f - this.f15183m) {
                    this.f15157C = -1;
                }
                if (z) {
                    C2734b bVar = this.f15159E;
                    if (bVar == null) {
                        C3443i.m21151a();
                    }
                    bVar.mo22206a(i, false);
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ZoomCircleBoardView$c */
    /* compiled from: ZoomCircleBoardView.kt */
    static final class C2736c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f15197a;

        /* renamed from: b */
        final /* synthetic */ ZoomCircleBoardView f15198b;

        /* renamed from: c */
        final /* synthetic */ Ref.C3444a f15199c;

        C2736c(ZoomCircleBoardView zoomCircleBoardView, Ref.C3444a aVar) {
            this.f15198b = zoomCircleBoardView;
            this.f15199c = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f15197a, false, 8950, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                C3443i.m21152a((Object) valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    float f = this.f15199c.f18733a - floatValue;
                    this.f15199c.f18733a = floatValue;
                    this.f15198b.m16657a(false, f);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo27294d2 = {"com/meizu/media/camera/views/ZoomCircleBoardView$scrollToTarget$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ZoomCircleBoardView$d */
    /* compiled from: ZoomCircleBoardView.kt */
    public static final class C2737d implements Animator.AnimatorListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f15200a;

        /* renamed from: b */
        final /* synthetic */ ZoomCircleBoardView f15201b;

        /* renamed from: c */
        final /* synthetic */ boolean f15202c;

        /* renamed from: d */
        final /* synthetic */ int f15203d;

        public void onAnimationCancel(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f15200a, false, 8953, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        public void onAnimationRepeat(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f15200a, false, 8954, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        public void onAnimationStart(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f15200a, false, 8951, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        C2737d(ZoomCircleBoardView zoomCircleBoardView, boolean z, int i) {
            this.f15201b = zoomCircleBoardView;
            this.f15202c = z;
            this.f15203d = i;
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            int i = 0;
            if (!PatchProxy.proxy(new Object[]{animator}, this, f15200a, false, 8952, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                if (this.f15201b.f15159E != null) {
                    if (this.f15201b.f15183m != 0.0f && this.f15201b.f15184n == 270.0f - this.f15201b.f15183m) {
                        this.f15201b.f15157C = -1;
                    }
                    if (this.f15202c) {
                        C2734b a = this.f15201b.f15159E;
                        if (a == null) {
                            C3443i.m21151a();
                        }
                        a.mo22206a(this.f15203d, false);
                    }
                }
                if (Math.abs(this.f15201b.f15155A + ((Number) this.f15201b.f15185o.get(2)).floatValue()) <= 0.05f) {
                    this.f15201b.f15155A = -((Number) this.f15201b.f15185o.get(2)).floatValue();
                    this.f15201b.f15193w = this.f15201b.m16663c(this.f15201b.f15155A);
                } else {
                    this.f15201b.f15193w = (float) C3357b.m20934b(this.f15201b.f15193w);
                    this.f15201b.f15155A = (float) C3357b.m20934b(this.f15201b.f15155A);
                }
                this.f15201b.f15168N = this.f15201b.f15155A;
                ZoomCircleBoardView zoomCircleBoardView = this.f15201b;
                if (this.f15201b.f15157C >= 0) {
                    i = this.f15201b.f15157C;
                }
                zoomCircleBoardView.f15169O = i;
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo27294d2 = {"Lcom/meizu/media/camera/views/ZoomCircleBoardView$Companion;", "", "()V", "sCenterAngle", "", "sEverThickAngleInterval", "sEverThinAngleInterval", "sTextDrawAngleOffset", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ZoomCircleBoardView$a */
    /* compiled from: ZoomCircleBoardView.kt */
    public static final class C2733a {
        private C2733a() {
        }

        public /* synthetic */ C2733a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
