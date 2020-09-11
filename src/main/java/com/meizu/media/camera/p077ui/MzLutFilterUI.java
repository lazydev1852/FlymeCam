package com.meizu.media.camera.p077ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.databinding.MzLutfilterControlBinding;
import com.meizu.media.camera.filter.CenterLockLayoutManager;
import com.meizu.media.camera.filter.CenterLockListener;
import com.meizu.media.camera.filter.FilterRecyclerView;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.views.SelectAdapter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.text.C3467f;
import kotlin.text.Regex;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 b2\u00020\u0001:\u0001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\f\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u000104J\u000e\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nJ\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0012J\u000e\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020\u0012J\u000e\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\u0012J\u0006\u0010>\u001a\u000208J\u000e\u0010?\u001a\u0002082\u0006\u00106\u001a\u00020\u0012J\u0006\u0010@\u001a\u000208J&\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FJ\u000e\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\u0012J\u000e\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020\u0018J\u0014\u0010L\u001a\u0002082\f\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cJ\u000e\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020\u0018J\u000e\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020RJ\u0010\u0010S\u001a\u0002082\b\u0010Q\u001a\u0004\u0018\u00010TJ\u000e\u0010U\u001a\u0002082\u0006\u0010V\u001a\u00020+J\u000e\u0010W\u001a\u0002082\u0006\u0010Q\u001a\u00020XJ\u000e\u0010Y\u001a\u0002082\u0006\u0010Z\u001a\u000202J\u0006\u0010[\u001a\u000208J\u0010\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020FH\u0002J\u000e\u0010^\u001a\u0002082\u0006\u0010_\u001a\u00020\u0012J\u0010\u0010`\u001a\u0002082\b\u0010a\u001a\u0004\u0018\u00010\nR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzLutFilterUI;", "", "mActivity", "Landroid/content/Context;", "mFilterControlBinding", "Lcom/meizu/media/camera/databinding/MzLutfilterControlBinding;", "mController", "Lcom/meizu/media/camera/MzCamController;", "(Landroid/content/Context;Lcom/meizu/media/camera/databinding/MzLutfilterControlBinding;Lcom/meizu/media/camera/MzCamController;)V", "filterEffect", "", "getFilterEffect", "()Ljava/lang/String;", "filterList", "Lflyme/support/v7/widget/MzRecyclerView;", "getFilterList", "()Lflyme/support/v7/widget/MzRecyclerView;", "isAnimRunning", "", "()Z", "isScrolling", "<set-?>", "isShowing", "mCameraState", "", "mCenterLockListener", "Lcom/meizu/media/camera/filter/CenterLockListener;", "mFilterAdapter", "Lflyme/support/v7/widget/RecyclerView$Adapter;", "mFilterAnim", "Landroid/animation/ObjectAnimator;", "mFilterControl", "Landroid/view/View;", "mFilterList", "Lcom/meizu/media/camera/filter/FilterRecyclerView;", "mFilterName", "Landroid/widget/TextView;", "mFilterView", "mIsFilterOnMove", "mIsFilterOnTouch", "mLoadLayout", "mNeedInitStickerLoc", "mPreviewAspectRatio", "Lcom/meizu/media/camera/util/CameraUtil$ScreeAspectRatio;", "mRenderTypes", "Ljava/util/ArrayList;", "mSetAdapter", "mTextPaint", "Landroid/graphics/Paint;", "mUIController", "Lcom/meizu/media/camera/MzUIController;", "getFilterAdapter", "Lcom/meizu/media/camera/views/SelectAdapter;", "getSubString", "value", "handleCountDownStatus", "", "isCountDown", "handleFilterNameVisible", "needShow", "hideFilterMenu", "needAnim", "initLayout", "needPerformHapticFeedbackOnScroll", "onDestroy", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "", "distanceY", "scrollToNextFilter", "isNext", "scrollToSelectFilter", "index", "setAdapter", "adapter", "setCameraState", "cameraState", "setLayoutListener", "listener", "Lcom/meizu/media/camera/filter/FilterRecyclerView$LayoutListener;", "setOnFilterItemClickListener", "Lflyme/support/v7/widget/MzRecyclerView$OnItemClickListener;", "setPreviewAspectRatio", "aspectRatio", "setScrollListener", "Lcom/meizu/media/camera/filter/FilterRecyclerView$ScrollListener;", "setUIController", "uicontroller", "showFilterMenu", "sp2px", "sp", "startFilterAnim", "show", "updateDisplayName", "name", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.r */
public final class MzLutFilterUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13489a;

    /* renamed from: b */
    public static final C2567a f13490b = new C2567a((DefaultConstructorMarker) null);

    /* renamed from: x */
    private static final LogUtil.C2630a f13491x = new LogUtil.C2630a("MzLutFilterUI");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f13492c;

    /* renamed from: d */
    private boolean f13493d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13494e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FilterRecyclerView f13495f;

    /* renamed from: g */
    private TextView f13496g;

    /* renamed from: h */
    private View f13497h;

    /* renamed from: i */
    private MzUIController f13498i;

    /* renamed from: j */
    private ObjectAnimator f13499j;

    /* renamed from: k */
    private CameraUtil.ScreeAspectRatio f13500k;

    /* renamed from: l */
    private boolean f13501l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f13502m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f13503n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f13504o;

    /* renamed from: p */
    private int f13505p = -1;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CenterLockListener f13506q;

    /* renamed from: r */
    private RecyclerView.C3260a<?> f13507r;
    @NotNull

    /* renamed from: s */
    private final String f13508s = "Mznone";

    /* renamed from: t */
    private final Paint f13509t = new Paint(1);

    /* renamed from: u */
    private final Context f13510u;

    /* renamed from: v */
    private final MzLutfilterControlBinding f13511v;

    /* renamed from: w */
    private final MzCamController f13512w;

    public MzLutFilterUI(@NotNull Context context, @NotNull MzLutfilterControlBinding mzLutfilterControlBinding, @NotNull MzCamController mzCamController) {
        C3443i.m21155b(context, "mActivity");
        C3443i.m21155b(mzLutfilterControlBinding, "mFilterControlBinding");
        C3443i.m21155b(mzCamController, "mController");
        this.f13510u = context;
        this.f13511v = mzLutfilterControlBinding;
        this.f13512w = mzCamController;
    }

    /* renamed from: a */
    public final boolean mo22444a() {
        return this.f13501l;
    }

    /* renamed from: b */
    public final boolean mo22448b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13489a, false, 7375, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        FilterRecyclerView filterRecyclerView = this.f13495f;
        if (filterRecyclerView == null) {
            C3443i.m21151a();
        }
        int scrollState = filterRecyclerView.getScrollState();
        LogUtil.C2630a aVar = f13491x;
        LogUtil.m15942a(aVar, "mFilterList.getScrollState(): " + scrollState);
        switch (scrollState) {
            case 0:
                return false;
            case 1:
                return this.f13502m;
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: c */
    public final boolean mo22450c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13489a, false, 7376, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f13499j == null) {
            return false;
        }
        ObjectAnimator objectAnimator = this.f13499j;
        if (objectAnimator == null) {
            C3443i.m21151a();
        }
        return objectAnimator.isRunning();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzLutFilterUI$Companion;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "getFileWithOutSuffix", "", "fileName", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.r$a */
    /* compiled from: MzLutFilterUI.kt */
    public static final class C2567a {

        /* renamed from: a */
        public static ChangeQuickRedirect f13513a;

        private C2567a() {
        }

        public /* synthetic */ C2567a(DefaultConstructorMarker gVar) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final String mo22457a(@Nullable String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f13513a, false, 7399, new Class[]{String.class}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if ((str != null ? C3467f.m21256b((CharSequence) str, ".", 0, false, 6, (Object) null) : 0) <= 0) {
                return str != null ? str : "null";
            }
            if (str != null) {
                int b = C3467f.m21256b((CharSequence) str, ".", 0, false, 6, (Object) null);
                if (str != null) {
                    String substring = str.substring(0, b);
                    C3443i.m21152a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        return substring;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return "null";
        }
    }

    /* renamed from: d */
    public final void mo22451d() {
        if (!PatchProxy.proxy(new Object[0], this, f13489a, false, 7377, new Class[0], Void.TYPE).isSupported && !this.f13493d) {
            this.f13492c = this.f13511v.f9766b;
            this.f13497h = this.f13511v.f9767c;
            this.f13495f = this.f13511v.f9768d;
            FilterRecyclerView filterRecyclerView = this.f13495f;
            if (filterRecyclerView == null) {
                C3443i.m21151a();
            }
            filterRecyclerView.setSelectorCanDraw(false);
            this.f13504o = true;
            this.f13496g = this.f13511v.f9765a;
            CenterLockLayoutManager aVar = new CenterLockLayoutManager(this.f13510u, this.f13510u.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f13510u.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_width), this.f13510u.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_checked_width));
            aVar.mo26076b(0);
            FilterRecyclerView filterRecyclerView2 = this.f13495f;
            if (filterRecyclerView2 == null) {
                C3443i.m21151a();
            }
            filterRecyclerView2.setLayoutManager(aVar);
            this.f13506q = new CenterLockListener(this.f13510u.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f13510u.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_width), this.f13510u.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_checked_width));
            FilterRecyclerView filterRecyclerView3 = this.f13495f;
            if (filterRecyclerView3 == null) {
                C3443i.m21151a();
            }
            filterRecyclerView3.setDisableMoveHead(true);
            FilterRecyclerView filterRecyclerView4 = this.f13495f;
            if (filterRecyclerView4 == null) {
                C3443i.m21151a();
            }
            filterRecyclerView4.mo26374a((RecyclerView.C3274l) this.f13506q);
            this.f13493d = true;
            if (NavigationBarUtils.m15972a()) {
                View view = this.f13492c;
                if (view == null) {
                    C3443i.m21151a();
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.bottomMargin += CameraUtil.m15899g();
                    View view2 = this.f13492c;
                    if (view2 == null) {
                        C3443i.m21151a();
                    }
                    view2.setLayoutParams(layoutParams2);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
    }

    /* renamed from: a */
    public final void mo22438a(@NotNull MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f13489a, false, 7378, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(uVar, "uicontroller");
            this.f13498i = uVar;
        }
    }

    /* renamed from: a */
    public final void mo22436a(@NotNull FilterRecyclerView.C2065a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f13489a, false, 7379, new Class[]{FilterRecyclerView.C2065a.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(aVar, "listener");
            FilterRecyclerView filterRecyclerView = this.f13495f;
            if (filterRecyclerView == null) {
                C3443i.m21151a();
            }
            filterRecyclerView.setLayoutListener(aVar);
        }
    }

    /* renamed from: a */
    public final void mo22441a(@Nullable RecyclerView.C3260a<?> aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f13489a, false, 7380, new Class[]{RecyclerView.C3260a.class}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f13491x, "setAdapter");
            if (this.f13495f != null) {
                this.f13507r = aVar;
                FilterRecyclerView filterRecyclerView = this.f13495f;
                if (filterRecyclerView == null) {
                    C3443i.m21151a();
                }
                filterRecyclerView.setAdapter(aVar);
                this.f13494e = true;
                this.f13504o = true;
            }
        }
    }

    @Nullable
    /* renamed from: e */
    public final SelectAdapter<?> mo22453e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13489a, false, 7381, new Class[0], SelectAdapter.class);
        if (proxy.isSupported) {
            return (SelectAdapter) proxy.result;
        }
        FilterRecyclerView filterRecyclerView = this.f13495f;
        if (filterRecyclerView == null) {
            C3443i.m21151a();
        }
        if (filterRecyclerView.getAdapter() == null) {
            return null;
        }
        FilterRecyclerView filterRecyclerView2 = this.f13495f;
        if (filterRecyclerView2 == null) {
            C3443i.m21151a();
        }
        RecyclerView.C3260a adapter = filterRecyclerView2.getAdapter();
        if (adapter != null) {
            return (SelectAdapter) adapter;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.views.SelectAdapter<*>");
    }

    /* renamed from: a */
    public final void mo22440a(@Nullable MzRecyclerView.C3227j jVar) {
        if (!PatchProxy.proxy(new Object[]{jVar}, this, f13489a, false, 7382, new Class[]{MzRecyclerView.C3227j.class}, Void.TYPE).isSupported && this.f13495f != null) {
            FilterRecyclerView filterRecyclerView = this.f13495f;
            if (filterRecyclerView == null) {
                C3443i.m21151a();
            }
            filterRecyclerView.setOnItemClickListener(jVar);
            FilterRecyclerView filterRecyclerView2 = this.f13495f;
            if (filterRecyclerView2 == null) {
                C3443i.m21151a();
            }
            filterRecyclerView2.mo26373a((RecyclerView.C3273k) new C2568b(this));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, mo27294d2 = {"com/meizu/media/camera/ui/MzLutFilterUI$setOnFilterItemClickListener$1", "Lflyme/support/v7/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "recyclerView", "Lflyme/support/v7/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "b", "onTouchEvent", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.r$b */
    /* compiled from: MzLutFilterUI.kt */
    public static final class C2568b implements RecyclerView.C3273k {

        /* renamed from: a */
        public static ChangeQuickRedirect f13514a;

        /* renamed from: b */
        final /* synthetic */ MzLutFilterUI f13515b;

        /* renamed from: a */
        public void mo22325a(boolean z) {
        }

        /* renamed from: b */
        public void mo22327b(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
            Class[] clsArr = {RecyclerView.class, MotionEvent.class};
            if (!PatchProxy.proxy(new Object[]{recyclerView, motionEvent}, this, f13514a, false, 7401, clsArr, Void.TYPE).isSupported) {
                C3443i.m21155b(recyclerView, "recyclerView");
                C3443i.m21155b(motionEvent, "motionEvent");
            }
        }

        C2568b(MzLutFilterUI rVar) {
            this.f13515b = rVar;
        }

        /* renamed from: a */
        public boolean mo22326a(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{recyclerView, motionEvent}, this, f13514a, false, 7400, new Class[]{RecyclerView.class, MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            C3443i.m21155b(recyclerView, "recyclerView");
            C3443i.m21155b(motionEvent, "motionEvent");
            switch (motionEvent.getAction()) {
                case 0:
                    this.f13515b.f13502m = true;
                    this.f13515b.f13503n = false;
                    break;
                case 1:
                    this.f13515b.f13502m = false;
                    this.f13515b.f13503n = false;
                    break;
                case 2:
                    this.f13515b.f13503n = true;
                    break;
            }
            return false;
        }
    }

    /* renamed from: f */
    public final void mo22455f() {
        if (!PatchProxy.proxy(new Object[0], this, f13489a, false, 7383, new Class[0], Void.TYPE).isSupported) {
            this.f13501l = true;
            mo22452d(true);
        }
    }

    /* renamed from: a */
    public final void mo22443a(boolean z) {
        SelectAdapter<?> e;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13489a, false, 7384, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13501l = false;
            this.f13502m = false;
            this.f13503n = false;
            if (z) {
                mo22452d(false);
                return;
            }
            View view = this.f13492c;
            if (view == null) {
                C3443i.m21151a();
            }
            view.setVisibility(4);
            if (this.f13494e && (e = mo22453e()) != null) {
                e.mo23410b(false);
            }
            EventBus.m21789a().mo27980d(6);
        }
    }

    /* renamed from: a */
    public final void mo22442a(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13489a, false, 7385, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f13491x, "updateDisplayName" + str);
            List b = C3467f.m21259b((CharSequence) f13490b.mo22457a(str), new String[]{"_"}, false, 0, 6, (Object) null);
            String str2 = (String) b.get(0);
            if (b.size() > 2) {
                for (int i = 1; i < b.size() - 1; i++) {
                    str2 = str2 + "_" + ((String) b.get(i));
                }
            }
            String b2 = mo22445b(str2);
            TextView textView = this.f13496g;
            if (textView == null) {
                C3443i.m21151a();
            }
            textView.setText(b2);
            this.f13509t.setTextSize(13.0f);
            float measureText = this.f13509t.measureText(b2);
            TextView textView2 = this.f13496g;
            if (textView2 == null) {
                C3443i.m21151a();
            }
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = m15489a((float) (180 - (((int) measureText) / 2)));
                TextView textView3 = this.f13496g;
                if (textView3 == null) {
                    C3443i.m21151a();
                }
                textView3.setLayoutParams(layoutParams2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    /* renamed from: a */
    private final int m15489a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f13489a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7386, new Class[]{Float.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        Resources resources = this.f13510u.getResources();
        C3443i.m21152a((Object) resources, "mActivity.resources");
        return (int) ((f * resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @NotNull
    /* renamed from: b */
    public final String mo22445b(@NotNull String str) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f13489a, false, 7387, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        C3443i.m21155b(str, "value");
        int length = str.length();
        String str2 = "";
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            String substring = str.substring(i, i3);
            C3443i.m21152a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            i2 = new Regex("[一-龥]").mo27546a(substring) ? i2 + 2 : i2 + 1;
            if (i2 <= 8) {
                str2 = str2 + substring;
            }
            i = i3;
        }
        if (i2 <= 8) {
            return str2;
        }
        return str2 + "...";
    }

    /* renamed from: a */
    public final void mo22435a(int i) {
        SelectAdapter<?> e;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13489a, false, 7388, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f13491x;
            LogUtil.m15952c(aVar, "scrollToSelectFilter: " + this.f13495f + " index: " + i);
            if (this.f13495f != null) {
                if (!this.f13501l && this.f13494e && (e = mo22453e()) != null) {
                    e.mo23410b(false);
                }
                CenterLockListener bVar = this.f13506q;
                if (bVar == null) {
                    C3443i.m21151a();
                }
                bVar.mo20073a(true);
                FilterRecyclerView filterRecyclerView = this.f13495f;
                if (filterRecyclerView == null) {
                    C3443i.m21151a();
                }
                filterRecyclerView.mo26403g(i);
            }
        }
    }

    /* renamed from: b */
    public final void mo22447b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13489a, false, 7389, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13495f != null) {
            FilterRecyclerView filterRecyclerView = this.f13495f;
            if (filterRecyclerView == null) {
                C3443i.m21151a();
            }
            if (filterRecyclerView.getAdapter() != null) {
                FilterRecyclerView filterRecyclerView2 = this.f13495f;
                if (filterRecyclerView2 == null) {
                    C3443i.m21151a();
                }
                RecyclerView.C3260a adapter = filterRecyclerView2.getAdapter();
                if (adapter != null) {
                    SelectAdapter pVar = (SelectAdapter) adapter;
                    int b = pVar.mo23409b();
                    if (b == 1 && !z) {
                        return;
                    }
                    if (b != pVar.mo20093a() - 1 || !z) {
                        CenterLockListener bVar = this.f13506q;
                        if (bVar == null) {
                            C3443i.m21151a();
                        }
                        bVar.mo20073a(false);
                        FilterRecyclerView filterRecyclerView3 = this.f13495f;
                        if (filterRecyclerView3 == null) {
                            C3443i.m21151a();
                        }
                        filterRecyclerView3.mo26403g(z ? b + 1 : b - 1);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.views.SelectAdapter<*>");
            }
        }
    }

    /* renamed from: c */
    public final void mo22449c(boolean z) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13489a, false, 7390, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f13497h == null || !this.f13501l) {
            return;
        }
        if (z) {
            View view = this.f13497h;
            if (view == null) {
                C3443i.m21151a();
            }
            view.setVisibility(4);
            TextView textView = this.f13496g;
            if (textView == null) {
                C3443i.m21151a();
            }
            textView.setVisibility(4);
            return;
        }
        View view2 = this.f13497h;
        if (view2 == null) {
            C3443i.m21151a();
        }
        view2.setVisibility(0);
        TextView textView2 = this.f13496g;
        if (textView2 == null) {
            C3443i.m21151a();
        }
        textView2.setVisibility(0);
    }

    /* renamed from: d */
    public final void mo22452d(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13489a, false, 7392, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f13499j != null) {
                ObjectAnimator objectAnimator = this.f13499j;
                if (objectAnimator == null) {
                    C3443i.m21151a();
                }
                if (objectAnimator.isRunning()) {
                    ObjectAnimator objectAnimator2 = this.f13499j;
                    if (objectAnimator2 == null) {
                        C3443i.m21151a();
                    }
                    objectAnimator2.end();
                }
            }
            if (this.f13500k != null) {
                CameraUtil.ScreeAspectRatio screeAspectRatio = this.f13500k;
                CameraUtil.ScreeAspectRatio screeAspectRatio2 = CameraUtil.ScreeAspectRatio.Ratio_4_3;
            }
            if (z) {
                View view = this.f13492c;
                if (view == null) {
                    C3443i.m21151a();
                }
                view.setAlpha(0.01f);
                View view2 = this.f13492c;
                if (view2 == null) {
                    C3443i.m21151a();
                }
                view2.setVisibility(0);
            }
            float f = z ? 0.0f : 1.0f;
            float f2 = z ? 1.0f : 0.0f;
            int i = z ? 260 : 96;
            View view3 = this.f13492c;
            if (view3 == null) {
                C3443i.m21151a();
            }
            this.f13499j = ObjectAnimator.ofFloat(view3, "alpha", new float[]{f, f2});
            if (z) {
                ObjectAnimator objectAnimator3 = this.f13499j;
                if (objectAnimator3 == null) {
                    C3443i.m21151a();
                }
                objectAnimator3.setStartDelay(20);
            }
            ObjectAnimator objectAnimator4 = this.f13499j;
            if (objectAnimator4 == null) {
                C3443i.m21151a();
            }
            objectAnimator4.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            ObjectAnimator objectAnimator5 = this.f13499j;
            if (objectAnimator5 == null) {
                C3443i.m21151a();
            }
            objectAnimator5.setDuration((long) i);
            ObjectAnimator objectAnimator6 = this.f13499j;
            if (objectAnimator6 == null) {
                C3443i.m21151a();
            }
            objectAnimator6.addListener(new C2569c(this, z));
            ObjectAnimator objectAnimator7 = this.f13499j;
            if (objectAnimator7 == null) {
                C3443i.m21151a();
            }
            objectAnimator7.start();
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo27294d2 = {"com/meizu/media/camera/ui/MzLutFilterUI$startFilterAnim$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.r$c */
    /* compiled from: MzLutFilterUI.kt */
    public static final class C2569c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f13516a;

        /* renamed from: b */
        final /* synthetic */ MzLutFilterUI f13517b;

        /* renamed from: c */
        final /* synthetic */ boolean f13518c;

        C2569c(MzLutFilterUI rVar, boolean z) {
            this.f13517b = rVar;
            this.f13518c = z;
        }

        public void onAnimationStart(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f13516a, false, 7402, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                super.onAnimationStart(animator);
                if (this.f13518c) {
                    if (this.f13517b.f13504o && this.f13517b.f13494e) {
                        this.f13517b.f13504o = false;
                        CenterLockListener c = this.f13517b.f13506q;
                        if (c == null) {
                            C3443i.m21151a();
                        }
                        c.mo20070a((RecyclerView) this.f13517b.f13495f);
                    }
                    EventBus.m21789a().mo27980d(5);
                }
            }
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f13516a, false, 7403, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                super.onAnimationEnd(animator);
                if (!this.f13518c) {
                    View e = this.f13517b.f13492c;
                    if (e == null) {
                        C3443i.m21151a();
                    }
                    e.setVisibility(4);
                    EventBus.m21789a().mo27980d(6);
                }
                if (!this.f13517b.f13494e) {
                    return;
                }
                if (this.f13518c) {
                    SelectAdapter<?> e2 = this.f13517b.mo22453e();
                    if (e2 != null) {
                        e2.mo23410b(true);
                        return;
                    }
                    return;
                }
                SelectAdapter<?> e3 = this.f13517b.mo22453e();
                if (e3 != null) {
                    e3.mo23410b(false);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo22439a(@NotNull CameraUtil.ScreeAspectRatio screeAspectRatio) {
        if (!PatchProxy.proxy(new Object[]{screeAspectRatio}, this, f13489a, false, 7394, new Class[]{CameraUtil.ScreeAspectRatio.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(screeAspectRatio, "aspectRatio");
            this.f13500k = screeAspectRatio;
        }
    }

    /* renamed from: b */
    public final void mo22446b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13489a, false, 7395, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13505p = i;
            if (this.f13505p == 1) {
                FilterRecyclerView filterRecyclerView = this.f13495f;
                if (filterRecyclerView == null) {
                    C3443i.m21151a();
                }
                filterRecyclerView.setShouldIntercept(false);
                return;
            }
            FilterRecyclerView filterRecyclerView2 = this.f13495f;
            if (filterRecyclerView2 == null) {
                C3443i.m21151a();
            }
            filterRecyclerView2.setShouldIntercept(true);
        }
    }

    /* renamed from: a */
    public final void mo22437a(@NotNull FilterRecyclerView.C2066b bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f13489a, false, 7396, new Class[]{FilterRecyclerView.C2066b.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar, "listener");
            FilterRecyclerView filterRecyclerView = this.f13495f;
            if (filterRecyclerView == null) {
                C3443i.m21151a();
            }
            filterRecyclerView.setScrollListener(bVar);
        }
    }

    /* renamed from: e */
    public final void mo22454e(boolean z) {
        SelectAdapter<?> e;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13489a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7397, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13494e && (e = mo22453e()) != null) {
            e.mo23410b(z);
        }
    }

    /* renamed from: g */
    public final void mo22456g() {
        if (!PatchProxy.proxy(new Object[0], this, f13489a, false, 7398, new Class[0], Void.TYPE).isSupported && this.f13495f != null) {
            FilterRecyclerView filterRecyclerView = this.f13495f;
            if (filterRecyclerView == null) {
                C3443i.m21151a();
            }
            filterRecyclerView.setOnScrollListener((RecyclerView.C3274l) null);
        }
    }
}
