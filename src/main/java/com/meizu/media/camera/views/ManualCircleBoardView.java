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
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.NotificationCompat;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 v2\u00020\u0001:\u0002vwB'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020?H\u0002J\u0006\u0010A\u001a\u00020?J\u0010\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0002J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\nH\u0002J\u0010\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0002J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\nH\u0002J\u001a\u0010L\u001a\u00020?2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0005J\u000e\u0010N\u001a\u00020?2\u0006\u0010N\u001a\u00020\u001bJ\b\u0010O\u001a\u00020?H\u0002J\b\u0010P\u001a\u00020?H\u0002J\u0010\u0010Q\u001a\u00020?2\u0006\u0010R\u001a\u00020SH\u0014J0\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007H\u0014J\u0018\u0010Z\u001a\u00020?2\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007H\u0014J\u0010\u0010]\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u0007H\u0002J\u000e\u0010c\u001a\u00020?2\u0006\u0010d\u001a\u00020\u0007J\u000e\u0010e\u001a\u00020?2\u0006\u0010f\u001a\u00020\u001bJ\u000e\u0010g\u001a\u00020?2\u0006\u0010h\u001a\u00020\u0007J\u000e\u0010i\u001a\u00020?2\u0006\u0010j\u001a\u00020\u0007J\u000e\u0010k\u001a\u00020?2\u0006\u0010l\u001a\u000203J&\u0010m\u001a\u00020?2\u0010\u0010n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010o2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020302J\u0010\u0010q\u001a\u00020?2\b\u0010r\u001a\u0004\u0018\u00010$J\b\u0010s\u001a\u00020?H\u0002J\u0010\u0010t\u001a\u00020?2\u0006\u0010I\u001a\u00020\nH\u0002J\b\u0010u\u001a\u00020?H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006x"}, mo27294d2 = {"Lcom/meizu/media/camera/views/ManualCircleBoardView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAnimBaseAngleOffSet", "", "mBgPaint", "Landroid/graphics/Paint;", "mCenterSelectPaint", "mCircleCenter", "Landroid/graphics/Point;", "mCircleRadius", "mCircleScaleInRadius", "mCircleScaleOutRadius", "mHintPaint", "Landroid/text/TextPaint;", "mHintPath", "Landroid/graphics/Path;", "mHintRectF", "Landroid/graphics/RectF;", "mIndexEverInterval", "mIsSoldInterval", "", "mItemIndexPosition", "Ljava/util/HashMap;", "mLastPressedX", "mLastScrollX", "mLastValueIndex", "mLastX", "mLastY", "mListener", "Lcom/meizu/media/camera/views/ManualCircleBoardView$ValueChangeListener;", "mMaxIndexOffSet", "mMaxOffSet", "mMaxScaleIndex", "mMove", "mMoveAngleOffSet", "mNeedSeparateShow", "mOffSet", "mResourcesContext", "mScaleInterval", "mScroller", "Landroid/widget/OverScroller;", "mSelectedValueIndex", "mShowValue", "", "", "mShowValueAngle", "mStartAngle", "mThickPaint", "mThinPaint", "mTotalValue", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mVelocityTracker", "Landroid/view/VelocityTracker;", "mWidth", "computeScroll", "", "countVelocityTracker", "forceFinishScroll", "getAngleByLength", "length", "getCoordinatePoint", "", "radius", "cirAngle", "getLengthByAngle", "angle", "getSelectIndex", "offSet", "init", "attributeSet", "needSeparateShow", "notifyValueChange", "onActionUp", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "scrollToTarget", "targetMove", "thickIndex", "setIndexEverInterval", "indexEverInterval", "setIsSolidInterval", "solidInterval", "setMaxIndexOffSet", "indexOffSet", "setScaleInterval", "scaleInterval", "setSelectorValue", "value", "setValue", "showValueIndex", "", "totalValues", "setValueChangeListener", "listener", "updateAngle", "updateAngleAndValue", "updateMoveAndValue", "Companion", "ValueChangeListener", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: ManualCircleBoardView.kt */
public final class ManualCircleBoardView extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14687a;

    /* renamed from: b */
    public static final C2703a f14688b = new C2703a((DefaultConstructorMarker) null);

    /* renamed from: A */
    private ValueAnimator f14689A;

    /* renamed from: B */
    private List<String> f14690B;

    /* renamed from: C */
    private List<String> f14691C;

    /* renamed from: D */
    private List<Float> f14692D;

    /* renamed from: E */
    private HashMap<Integer, Float> f14693E;

    /* renamed from: F */
    private boolean f14694F;

    /* renamed from: G */
    private boolean f14695G;

    /* renamed from: H */
    private int f14696H;

    /* renamed from: I */
    private int f14697I;

    /* renamed from: J */
    private int f14698J;

    /* renamed from: K */
    private int f14699K;

    /* renamed from: L */
    private VelocityTracker f14700L;

    /* renamed from: M */
    private OverScroller f14701M;

    /* renamed from: N */
    private int f14702N;

    /* renamed from: O */
    private int f14703O;

    /* renamed from: c */
    private Point f14704c;

    /* renamed from: d */
    private int f14705d;

    /* renamed from: e */
    private int f14706e;

    /* renamed from: f */
    private int f14707f;

    /* renamed from: g */
    private Context f14708g;

    /* renamed from: h */
    private Paint f14709h;

    /* renamed from: i */
    private Paint f14710i;

    /* renamed from: j */
    private Paint f14711j;

    /* renamed from: k */
    private Paint f14712k;

    /* renamed from: l */
    private TextPaint f14713l;

    /* renamed from: m */
    private Path f14714m;

    /* renamed from: n */
    private RectF f14715n;

    /* renamed from: o */
    private float f14716o;

    /* renamed from: p */
    private float f14717p;

    /* renamed from: q */
    private float f14718q;

    /* renamed from: r */
    private int f14719r;

    /* renamed from: s */
    private float f14720s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f14721t;

    /* renamed from: u */
    private float f14722u;

    /* renamed from: v */
    private float f14723v;

    /* renamed from: w */
    private float f14724w;

    /* renamed from: x */
    private int f14725x;

    /* renamed from: y */
    private int f14726y;

    /* renamed from: z */
    private C2704b f14727z;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo27294d2 = {"Lcom/meizu/media/camera/views/ManualCircleBoardView$ValueChangeListener;", "", "onValueChange", "", "valueIndex", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ManualCircleBoardView$b */
    /* compiled from: ManualCircleBoardView.kt */
    public interface C2704b {
        /* renamed from: a */
        void mo22514a(int i);
    }

    @JvmOverloads
    public ManualCircleBoardView(@Nullable Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ManualCircleBoardView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ManualCircleBoardView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14716o = 270.0f;
        this.f14726y = this.f14725x;
        this.f14692D = new ArrayList();
        mo22977a(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ManualCircleBoardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: a */
    public final void mo22977a(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        if (!PatchProxy.proxy(new Object[]{context, attributeSet}, this, f14687a, false, 8453, new Class[]{Context.class, AttributeSet.class}, Void.TYPE).isSupported) {
            this.f14708g = context;
            this.f14701M = new OverScroller(context, new DecelerateInterpolator());
            OverScroller overScroller = this.f14701M;
            if (overScroller == null) {
                C3443i.m21151a();
            }
            overScroller.setFriction(0.009f);
            Context context2 = this.f14708g;
            if (context2 == null) {
                C3443i.m21151a();
            }
            Resources resources = context2.getResources();
            this.f14704c = new Point(resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle_board_center_x), resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle_board_center_y));
            Point point = this.f14704c;
            if (point == null) {
                C3443i.m21151a();
            }
            this.f14705d = point.y;
            this.f14706e = this.f14705d - resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle__board_scale_out_radius_padding);
            this.f14707f = resources.getDimensionPixelOffset(R.dimen.mz_zoom_circle_board_scale_in_radius);
            this.f14709h = new Paint();
            Paint paint = this.f14709h;
            if (paint == null) {
                C3443i.m21151a();
            }
            paint.setAntiAlias(true);
            Paint paint2 = this.f14709h;
            if (paint2 == null) {
                C3443i.m21151a();
            }
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = this.f14709h;
            if (paint3 == null) {
                C3443i.m21151a();
            }
            paint3.setStrokeWidth((float) this.f14705d);
            Paint paint4 = this.f14709h;
            if (paint4 == null) {
                C3443i.m21151a();
            }
            paint4.setColor(resources.getColor(R.color.mz_zoom_circle_board_bg));
            this.f14711j = new Paint(1);
            Paint paint5 = this.f14711j;
            if (paint5 == null) {
                C3443i.m21151a();
            }
            paint5.setStrokeWidth(4.0f);
            Paint paint6 = this.f14711j;
            if (paint6 == null) {
                C3443i.m21151a();
            }
            paint6.setStyle(Paint.Style.STROKE);
            Paint paint7 = this.f14711j;
            if (paint7 == null) {
                C3443i.m21151a();
            }
            paint7.setColor(-1);
            this.f14712k = new Paint(this.f14711j);
            Paint paint8 = this.f14712k;
            if (paint8 == null) {
                C3443i.m21151a();
            }
            paint8.setStrokeWidth(2.0f);
            Paint paint9 = this.f14712k;
            if (paint9 == null) {
                C3443i.m21151a();
            }
            paint9.setColor(resources.getColor(R.color.mz_zoom_circle_board_thin_paint));
            this.f14710i = new Paint(this.f14711j);
            Paint paint10 = this.f14710i;
            if (paint10 == null) {
                C3443i.m21151a();
            }
            paint10.setColor(getResources().getColor(R.color.mz_settting_item_select_color));
            this.f14713l = new TextPaint(1);
            TextPaint textPaint = this.f14713l;
            if (textPaint == null) {
                C3443i.m21151a();
            }
            textPaint.setAntiAlias(true);
            TextPaint textPaint2 = this.f14713l;
            if (textPaint2 == null) {
                C3443i.m21151a();
            }
            textPaint2.setTextSize(24.0f);
            TextPaint textPaint3 = this.f14713l;
            if (textPaint3 == null) {
                C3443i.m21151a();
            }
            textPaint3.setColor(resources.getColor(R.color.mz_zoom_circle_board_thin_paint));
            this.f14714m = new Path();
            Point point2 = this.f14704c;
            if (point2 == null) {
                C3443i.m21151a();
            }
            float f = (float) (point2.x * 2);
            Point point3 = this.f14704c;
            if (point3 == null) {
                C3443i.m21151a();
            }
            this.f14715n = new RectF(0.0f, 86.5f, f, ((float) ((point3.x * 2) + 90)) - 3.5f);
        }
    }

    public final void setScaleInterval(int i) {
        this.f14699K = i;
    }

    public final void setMaxIndexOffSet(int i) {
        this.f14697I = i;
    }

    /* renamed from: a */
    public final void mo22978a(boolean z) {
        this.f14694F = z;
    }

    public final void setIndexEverInterval(int i) {
        this.f14696H = i;
    }

    public final void setIsSolidInterval(boolean z) {
        this.f14695G = z;
    }

    public final void setValueChangeListener(@Nullable C2704b bVar) {
        this.f14727z = bVar;
    }

    public final void setValue(@Nullable List<Integer> list, @NotNull List<String> list2) {
        if (!PatchProxy.proxy(new Object[]{list, list2}, this, f14687a, false, 8454, new Class[]{List.class, List.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(list2, "totalValues");
            if (list == null) {
                this.f14691C = list2;
            } else {
                this.f14691C = new ArrayList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    List<String> list3 = this.f14691C;
                    if (list3 == null) {
                        C3443i.m21151a();
                    }
                    Integer num = list.get(i);
                    if (num == null) {
                        C3443i.m21151a();
                    }
                    list3.add(list2.get(num.intValue()));
                }
            }
            List<String> list4 = this.f14691C;
            if (list4 == null) {
                C3443i.m21151a();
            }
            int size2 = list4.size();
            for (int i2 = 0; i2 < size2; i2++) {
                List<Float> list5 = this.f14692D;
                if (list5 == null) {
                    C3443i.m21151a();
                }
                TextPaint textPaint = this.f14713l;
                if (textPaint == null) {
                    C3443i.m21151a();
                }
                List<String> list6 = this.f14691C;
                if (list6 == null) {
                    C3443i.m21151a();
                }
                list5.add(i2, Float.valueOf(m16474c(textPaint.measureText(list6.get(i2)))));
            }
            this.f14690B = list2;
            this.f14693E = new HashMap<>();
            List<String> list7 = this.f14691C;
            if (list7 == null) {
                C3443i.m21151a();
            }
            this.f14698J = ((list7.size() - 1) * this.f14699K) + this.f14697I;
            this.f14722u = -((float) ((((((double) this.f14705d) * 6.283185307179586d) * ((double) this.f14698J)) * ((double) 1.5f)) / ((double) 360)));
            List<String> list8 = this.f14690B;
            if (list8 == null) {
                C3443i.m21151a();
            }
            int size3 = list8.size();
            for (int i3 = 0; i3 < size3; i3++) {
                if (this.f14696H == 0 || i3 == 0) {
                    HashMap<Integer, Float> hashMap = this.f14693E;
                    if (hashMap == null) {
                        C3443i.m21151a();
                    }
                    hashMap.put(Integer.valueOf(i3), Float.valueOf(((float) (-this.f14699K)) * 1.5f * ((float) i3)));
                } else {
                    Context context = this.f14708g;
                    if (context == null) {
                        C3443i.m21151a();
                    }
                    String string = context.getResources().getString(R.string.auto);
                    List<String> list9 = this.f14690B;
                    if (list9 == null) {
                        C3443i.m21151a();
                    }
                    if (C3443i.m21154a((Object) string, (Object) list9.get(0))) {
                        HashMap<Integer, Float> hashMap2 = this.f14693E;
                        if (hashMap2 == null) {
                            C3443i.m21151a();
                        }
                        hashMap2.put(Integer.valueOf(i3), Float.valueOf((((float) (-this.f14699K)) * 1.5f) - (((((float) this.f14699K) * 1.5f) / ((float) this.f14696H)) * ((float) (i3 - 1)))));
                    } else {
                        HashMap<Integer, Float> hashMap3 = this.f14693E;
                        if (hashMap3 == null) {
                            C3443i.m21151a();
                        }
                        hashMap3.put(Integer.valueOf(i3), Float.valueOf(((-(((float) this.f14699K) * 1.5f)) / ((float) this.f14696H)) * ((float) i3)));
                    }
                }
            }
            HashMap<Integer, Float> hashMap4 = this.f14693E;
            if (hashMap4 == null) {
                C3443i.m21151a();
            }
            for (int i4 = 0; i4 < hashMap4.size(); i4++) {
            }
        }
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14687a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8455, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, i2);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f14687a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8456, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onLayout(z, i, i2, i3, i4);
            this.f14719r = getWidth();
        }
    }

    public void onDraw(@NotNull Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14687a, false, 8457, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(canvas, "canvas");
            if (getVisibility() == 0) {
                super.onDraw(canvas);
                Point point = this.f14704c;
                if (point == null) {
                    C3443i.m21151a();
                }
                float f = (float) point.x;
                Point point2 = this.f14704c;
                if (point2 == null) {
                    C3443i.m21151a();
                }
                float f2 = (float) point2.y;
                float f3 = (float) this.f14705d;
                Paint paint = this.f14709h;
                if (paint == null) {
                    C3443i.m21151a();
                }
                canvas.drawCircle(f, f2, f3, paint);
                int i = this.f14698J;
                if (i >= 0) {
                    int i2 = 0;
                    while (true) {
                        float f4 = this.f14716o + (((float) i2) * 1.5f);
                        float[] a = m16470a(this.f14706e, f4);
                        float[] a2 = m16470a(this.f14707f, f4);
                        if (i2 % this.f14699K == 0) {
                            float f5 = a[0];
                            float f6 = a[1];
                            float f7 = a2[0];
                            float f8 = a2[1];
                            Paint paint2 = this.f14711j;
                            if (paint2 == null) {
                                C3443i.m21151a();
                            }
                            canvas.drawLine(f5, f6, f7, f8, paint2);
                            if (!this.f14694F || i2 % (this.f14699K * 2) == 0) {
                                Path path = this.f14714m;
                                if (path == null) {
                                    C3443i.m21151a();
                                }
                                path.reset();
                                Path path2 = this.f14714m;
                                if (path2 == null) {
                                    C3443i.m21151a();
                                }
                                RectF rectF = this.f14715n;
                                if (rectF == null) {
                                    C3443i.m21151a();
                                }
                                List<Float> list = this.f14692D;
                                if (list == null) {
                                    C3443i.m21151a();
                                }
                                float floatValue = f4 - (list.get(i2 / this.f14699K).floatValue() / ((float) 2));
                                List<Float> list2 = this.f14692D;
                                if (list2 == null) {
                                    C3443i.m21151a();
                                }
                                path2.addArc(rectF, floatValue, list2.get(i2 / this.f14699K).floatValue() + 3.5f);
                                List<String> list3 = this.f14691C;
                                if (list3 == null) {
                                    C3443i.m21151a();
                                }
                                String str = list3.get(i2 / this.f14699K);
                                Path path3 = this.f14714m;
                                if (path3 == null) {
                                    C3443i.m21151a();
                                }
                                TextPaint textPaint = this.f14713l;
                                if (textPaint == null) {
                                    C3443i.m21151a();
                                }
                                canvas.drawTextOnPath(str, path3, 0.0f, 0.0f, textPaint);
                            }
                        } else {
                            float f9 = a[0];
                            float f10 = a[1];
                            float f11 = a2[0];
                            float f12 = a2[1];
                            Paint paint3 = this.f14712k;
                            if (paint3 == null) {
                                C3443i.m21151a();
                            }
                            canvas.drawLine(f9, f10, f11, f12, paint3);
                        }
                        if (i2 == i) {
                            break;
                        }
                        i2++;
                    }
                }
                float[] a3 = m16470a(this.f14706e, 270.0f);
                float[] a4 = m16470a(this.f14707f, 270.0f);
                float f13 = a3[0];
                float f14 = a3[1];
                float f15 = a4[0];
                float f16 = a4[1];
                Paint paint4 = this.f14710i;
                if (paint4 == null) {
                    C3443i.m21151a();
                }
                canvas.drawLine(f13, f14, f15, f16, paint4);
            }
        }
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14687a, false, 8458, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (getVisibility() != 0) {
            return false;
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f14700L == null) {
            this.f14700L = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.f14700L;
        if (velocityTracker == null) {
            C3443i.m21151a();
        }
        velocityTracker.addMovement(motionEvent);
        if (this.f14689A != null) {
            ValueAnimator valueAnimator = this.f14689A;
            if (valueAnimator == null) {
                C3443i.m21151a();
            }
            if (valueAnimator.isRunning()) {
                return true;
            }
        }
        switch (action) {
            case 0:
                mo22976a();
                this.f14717p = (float) x;
                this.f14718q = y;
                this.f14703O = x;
                this.f14720s = 0.0f;
                break;
            case 1:
            case 3:
                this.f14717p = 0.0f;
                if (this.f14703O - x != 0) {
                    m16476c();
                    break;
                } else {
                    m16472b();
                    break;
                }
            case 2:
                float f = this.f14717p - ((float) x);
                float f2 = y - this.f14718q;
                if (x > this.f14719r / 2) {
                    f2 = -f2;
                }
                if (Math.abs(f) <= Math.abs(f2)) {
                    f = f2;
                }
                this.f14720s = f;
                m16478d();
                break;
        }
        this.f14717p = (float) x;
        this.f14718q = y;
        return true;
    }

    public void computeScroll() {
        if (!PatchProxy.proxy(new Object[0], this, f14687a, false, 8459, new Class[0], Void.TYPE).isSupported) {
            super.computeScroll();
            OverScroller overScroller = this.f14701M;
            if (overScroller == null) {
                C3443i.m21151a();
            }
            if (overScroller.computeScrollOffset()) {
                OverScroller overScroller2 = this.f14701M;
                if (overScroller2 == null) {
                    C3443i.m21151a();
                }
                int currX = overScroller2.getCurrX();
                OverScroller overScroller3 = this.f14701M;
                if (overScroller3 == null) {
                    C3443i.m21151a();
                }
                if (currX == overScroller3.getFinalX()) {
                    m16472b();
                    return;
                }
                OverScroller overScroller4 = this.f14701M;
                if (overScroller4 == null) {
                    C3443i.m21151a();
                }
                int currX2 = overScroller4.getCurrX();
                this.f14720s = (float) (this.f14702N - currX2);
                m16478d();
                this.f14702N = currX2;
            }
        }
    }

    /* renamed from: b */
    private final void m16472b() {
        if (!PatchProxy.proxy(new Object[0], this, f14687a, false, 8460, new Class[0], Void.TYPE).isSupported) {
            this.f14703O = 0;
            if (this.f14695G) {
                int i = (int) (this.f14723v / 1.5f);
                float f = this.f14723v % 1.5f;
                if (f >= 0.6f) {
                    f = this.f14723v - (((float) (i + 1)) * 1.5f);
                }
                m16468a(f, -1);
                return;
            }
            float f2 = this.f14723v;
            HashMap<Integer, Float> hashMap = this.f14693E;
            if (hashMap == null) {
                C3443i.m21151a();
            }
            Float f3 = hashMap.get(Integer.valueOf(this.f14726y));
            if (f3 == null) {
                C3443i.m21151a();
            }
            C3443i.m21152a((Object) f3, "mItemIndexPosition!![mSelectedValueIndex]!!");
            m16468a(f2 - f3.floatValue(), -1);
        }
    }

    /* renamed from: c */
    private final void m16476c() {
        if (!PatchProxy.proxy(new Object[0], this, f14687a, false, 8461, new Class[0], Void.TYPE).isSupported) {
            OverScroller overScroller = this.f14701M;
            if (overScroller == null) {
                C3443i.m21151a();
            }
            overScroller.forceFinished(true);
            VelocityTracker velocityTracker = this.f14700L;
            if (velocityTracker == null) {
                C3443i.m21151a();
            }
            velocityTracker.computeCurrentVelocity(MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION);
            VelocityTracker velocityTracker2 = this.f14700L;
            if (velocityTracker2 == null) {
                C3443i.m21151a();
            }
            float xVelocity = velocityTracker2.getXVelocity();
            if (Math.abs(xVelocity) > ((float) 300)) {
                OverScroller overScroller2 = this.f14701M;
                if (overScroller2 == null) {
                    C3443i.m21151a();
                }
                overScroller2.fling(0, 0, (int) xVelocity, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0);
            } else {
                m16472b();
            }
            this.f14702N = 0;
        }
    }

    /* renamed from: d */
    private final synchronized void m16478d() {
        if (!PatchProxy.proxy(new Object[0], this, f14687a, false, 8462, new Class[0], Void.TYPE).isSupported) {
            this.f14721t -= this.f14720s;
            if (this.f14721t >= ((float) 0)) {
                this.f14721t = 0.0f;
                OverScroller overScroller = this.f14701M;
                if (overScroller == null) {
                    C3443i.m21151a();
                }
                overScroller.forceFinished(true);
            } else if (this.f14721t <= this.f14722u) {
                this.f14721t = this.f14722u;
                OverScroller overScroller2 = this.f14701M;
                if (overScroller2 == null) {
                    C3443i.m21151a();
                }
                overScroller2.forceFinished(true);
            }
            this.f14723v = m16474c(this.f14721t);
            m16479e();
            this.f14725x = this.f14726y;
            this.f14726y = m16471b(this.f14723v);
            m16480f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized void m16467a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14687a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8463, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f14723v = this.f14724w - f;
            m16479e();
        }
    }

    /* renamed from: e */
    private final synchronized void m16479e() {
        if (!PatchProxy.proxy(new Object[0], this, f14687a, false, 8464, new Class[0], Void.TYPE).isSupported) {
            this.f14716o = this.f14723v + 270.0f;
            if (this.f14725x == -1 && this.f14716o <= 270.0f) {
                this.f14716o = 270.0f;
            } else if (this.f14716o >= 270.0f) {
                this.f14716o = 270.0f;
            } else if (this.f14716o <= 270.0f - (((float) this.f14698J) * 1.5f)) {
                this.f14716o = 270.0f - (((float) this.f14698J) * 1.5f);
            }
            postInvalidate();
        }
    }

    /* renamed from: b */
    private final int m16471b(float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f)}, this, f14687a, false, 8465, new Class[]{Float.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        float max = Math.max(f, m16474c(this.f14722u));
        if (this.f14695G) {
            return (int) ((((-max) / ((float) 9)) * 1024.0f) / ((float) 10));
        }
        HashMap<Integer, Float> hashMap = this.f14693E;
        if (hashMap == null) {
            C3443i.m21151a();
        }
        int size = hashMap.size();
        for (int i = 0; i < size; i++) {
            HashMap<Integer, Float> hashMap2 = this.f14693E;
            if (hashMap2 == null) {
                C3443i.m21151a();
            }
            Float f2 = hashMap2.get(Integer.valueOf(i));
            if (f2 == null) {
                C3443i.m21151a();
            }
            if (((double) Math.abs(max - f2.floatValue())) <= 1.5d / ((double) (this.f14696H + 1))) {
                return i;
            }
        }
        return this.f14725x;
    }

    /* renamed from: a */
    public final void mo22976a() {
        if (!PatchProxy.proxy(new Object[0], this, f14687a, false, 8466, new Class[0], Void.TYPE).isSupported) {
            if (this.f14701M != null) {
                OverScroller overScroller = this.f14701M;
                if (overScroller == null) {
                    C3443i.m21151a();
                }
                overScroller.forceFinished(true);
            }
            if (this.f14689A != null) {
                ValueAnimator valueAnimator = this.f14689A;
                if (valueAnimator == null) {
                    C3443i.m21151a();
                }
                valueAnimator.cancel();
            }
        }
    }

    public final void setSelectorValue(@NotNull String str) {
        float f;
        if (!PatchProxy.proxy(new Object[]{str}, this, f14687a, false, 8467, new Class[]{String.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str, "value");
            this.f14720s = 0.0f;
            if (this.f14695G) {
                f = (((float) Integer.parseInt(str)) / 102.4f) * ((float) -9);
                if (f % 1.5f != 0.0f) {
                    int i = (int) (this.f14723v / 1.5f);
                    float f2 = this.f14723v % 1.5f;
                    f = f2 < 0.6f ? f - f2 : ((float) (i + 1)) * 1.5f;
                }
            } else {
                List<String> list = this.f14690B;
                if (list == null) {
                    C3443i.m21151a();
                }
                this.f14726y = list.indexOf(str);
                HashMap<Integer, Float> hashMap = this.f14693E;
                if (hashMap == null) {
                    C3443i.m21151a();
                }
                Float f3 = hashMap.get(Integer.valueOf(this.f14726y));
                if (f3 == null) {
                    C3443i.m21151a();
                }
                f = f3.floatValue();
            }
            this.f14721t = m16477d(f);
            m16478d();
        }
    }

    /* renamed from: c */
    private final float m16474c(float f) {
        return (float) (((double) (f * 360.0f)) / (((double) this.f14705d) * 6.283185307179586d));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final float m16477d(float f) {
        return (float) (((double) (f / 360.0f)) * ((double) this.f14705d) * 6.283185307179586d);
    }

    /* renamed from: f */
    private final void m16480f() {
        if (!PatchProxy.proxy(new Object[0], this, f14687a, false, 8468, new Class[0], Void.TYPE).isSupported && this.f14727z != null) {
            C2704b bVar = this.f14727z;
            if (bVar == null) {
                C3443i.m21151a();
            }
            bVar.mo22514a(this.f14726y);
        }
    }

    /* renamed from: a */
    private final float[] m16470a(int i, float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Float(f)}, this, f14687a, false, 8469, new Class[]{Integer.TYPE, Float.TYPE}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        float[] fArr = new float[2];
        double radians = Math.toRadians((double) f);
        float f2 = (float) 90;
        if (f < f2) {
            Point point = this.f14704c;
            if (point == null) {
                C3443i.m21151a();
            }
            double d = (double) i;
            fArr[0] = (float) (((double) point.x) + (Math.cos(radians) * d));
            Point point2 = this.f14704c;
            if (point2 == null) {
                C3443i.m21151a();
            }
            fArr[1] = (float) (((double) point2.y) + (Math.sin(radians) * d));
        } else if (f == 90.0f) {
            Point point3 = this.f14704c;
            if (point3 == null) {
                C3443i.m21151a();
            }
            fArr[0] = (float) point3.x;
            Point point4 = this.f14704c;
            if (point4 == null) {
                C3443i.m21151a();
            }
            fArr[1] = (float) (point4.y + i);
        } else {
            if (f > f2) {
                float f3 = (float) 180;
                if (f < f3) {
                    double d2 = (((double) (f3 - f)) * 3.141592653589793d) / 180.0d;
                    Point point5 = this.f14704c;
                    if (point5 == null) {
                        C3443i.m21151a();
                    }
                    double d3 = (double) i;
                    fArr[0] = (float) (((double) point5.x) - (Math.cos(d2) * d3));
                    Point point6 = this.f14704c;
                    if (point6 == null) {
                        C3443i.m21151a();
                    }
                    fArr[1] = (float) (((double) point6.y) + (Math.sin(d2) * d3));
                }
            }
            if (f == 180.0f) {
                Point point7 = this.f14704c;
                if (point7 == null) {
                    C3443i.m21151a();
                }
                fArr[0] = (float) (point7.x - i);
                Point point8 = this.f14704c;
                if (point8 == null) {
                    C3443i.m21151a();
                }
                fArr[1] = (float) point8.y;
            } else {
                float f4 = (float) 180;
                if (f > f4 && f < ((float) 270)) {
                    double d4 = (((double) (f - f4)) * 3.141592653589793d) / 180.0d;
                    Point point9 = this.f14704c;
                    if (point9 == null) {
                        C3443i.m21151a();
                    }
                    double d5 = (double) i;
                    fArr[0] = (float) (((double) point9.x) - (Math.cos(d4) * d5));
                    Point point10 = this.f14704c;
                    if (point10 == null) {
                        C3443i.m21151a();
                    }
                    fArr[1] = (float) (((double) point10.y) - (Math.sin(d4) * d5));
                } else if (f == 270.0f) {
                    Point point11 = this.f14704c;
                    if (point11 == null) {
                        C3443i.m21151a();
                    }
                    fArr[0] = (float) point11.x;
                    Point point12 = this.f14704c;
                    if (point12 == null) {
                        C3443i.m21151a();
                    }
                    fArr[1] = (float) (point12.y - i);
                } else {
                    double d6 = (((double) (((float) 360) - f)) * 3.141592653589793d) / 180.0d;
                    Point point13 = this.f14704c;
                    if (point13 == null) {
                        C3443i.m21151a();
                    }
                    double d7 = (double) i;
                    fArr[0] = (float) (((double) point13.x) + (Math.cos(d6) * d7));
                    Point point14 = this.f14704c;
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
    private final void m16468a(float f, int i) {
        if (!PatchProxy.proxy(new Object[]{new Float(f), new Integer(i)}, this, f14687a, false, 8470, new Class[]{Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (f == 0.0f) {
                this.f14720s = 0.0f;
                return;
            }
            this.f14724w = this.f14723v;
            this.f14689A = ValueAnimator.ofFloat(new float[]{0.0f, f});
            ValueAnimator valueAnimator = this.f14689A;
            if (valueAnimator == null) {
                C3443i.m21151a();
            }
            valueAnimator.setDuration(100);
            ValueAnimator valueAnimator2 = this.f14689A;
            if (valueAnimator2 == null) {
                C3443i.m21151a();
            }
            valueAnimator2.setInterpolator(new PathInterpolator(0.16f, 0.0f, 0.33f, 1.0f));
            ValueAnimator valueAnimator3 = this.f14689A;
            if (valueAnimator3 == null) {
                C3443i.m21151a();
            }
            valueAnimator3.addUpdateListener(new C2705c(this));
            ValueAnimator valueAnimator4 = this.f14689A;
            if (valueAnimator4 == null) {
                C3443i.m21151a();
            }
            valueAnimator4.addListener(new C2706d(this, f));
            ValueAnimator valueAnimator5 = this.f14689A;
            if (valueAnimator5 == null) {
                C3443i.m21151a();
            }
            valueAnimator5.start();
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo27294d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ManualCircleBoardView$c */
    /* compiled from: ManualCircleBoardView.kt */
    static final class C2705c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f14728a;

        /* renamed from: b */
        final /* synthetic */ ManualCircleBoardView f14729b;

        C2705c(ManualCircleBoardView manualCircleBoardView) {
            this.f14729b = manualCircleBoardView;
        }

        public final void onAnimationUpdate(@NotNull ValueAnimator valueAnimator) {
            if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14728a, false, 8473, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    this.f14729b.m16467a(((Float) animatedValue).floatValue());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo27294d2 = {"com/meizu/media/camera/views/ManualCircleBoardView$scrollToTarget$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ManualCircleBoardView$d */
    /* compiled from: ManualCircleBoardView.kt */
    public static final class C2706d implements Animator.AnimatorListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f14730a;

        /* renamed from: b */
        final /* synthetic */ ManualCircleBoardView f14731b;

        /* renamed from: c */
        final /* synthetic */ float f14732c;

        public void onAnimationCancel(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f14730a, false, 8476, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        public void onAnimationRepeat(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f14730a, false, 8477, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        public void onAnimationStart(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f14730a, false, 8474, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        C2706d(ManualCircleBoardView manualCircleBoardView, float f) {
            this.f14731b = manualCircleBoardView;
            this.f14732c = f;
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f14730a, false, 8475, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                ManualCircleBoardView manualCircleBoardView = this.f14731b;
                manualCircleBoardView.f14721t = manualCircleBoardView.f14721t - this.f14731b.m16477d(this.f14732c);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo27294d2 = {"Lcom/meizu/media/camera/views/ManualCircleBoardView$Companion;", "", "()V", "sAngleInterval", "", "sCenterAngle", "sSolidIntervalTolerance", "sTextDrawAngleOffset", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.ManualCircleBoardView$a */
    /* compiled from: ManualCircleBoardView.kt */
    public static final class C2703a {
        private C2703a() {
        }

        public /* synthetic */ C2703a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
