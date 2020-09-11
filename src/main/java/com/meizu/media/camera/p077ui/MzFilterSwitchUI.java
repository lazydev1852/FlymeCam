package com.meizu.media.camera.p077ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.meizu.media.camera.R;
import com.meizu.media.camera.databinding.MzFilterSwitchBinding;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzFilterSwitchUI;", "Landroid/view/View$OnClickListener;", "mActivity", "Landroid/content/Context;", "mFilterSwitchBinding", "Lcom/meizu/media/camera/databinding/MzFilterSwitchBinding;", "mCommonUI", "Lcom/meizu/media/camera/ui/MzCommonUI;", "(Landroid/content/Context;Lcom/meizu/media/camera/databinding/MzFilterSwitchBinding;Lcom/meizu/media/camera/ui/MzCommonUI;)V", "mFilterLut", "Landroid/widget/TextView;", "mFilterNormal", "mFilterSwitch", "Landroid/view/View;", "mFilterSwitchAnim", "Landroid/animation/ObjectAnimator;", "mIsShowing", "", "mLoadLayout", "mTextPaint", "Landroid/graphics/Paint;", "handleCountDownStatus", "", "isCountDown", "handleFilterSwitch", "show", "needAnim", "hide", "initLayout", "onClick", "view", "sp2px", "", "sp", "", "startFilterSwitchAnim", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.n */
public final class MzFilterSwitchUI implements View.OnClickListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f13284a;

    /* renamed from: b */
    public static final C2530a f13285b = new C2530a((DefaultConstructorMarker) null);

    /* renamed from: m */
    private static final LogUtil.C2630a f13286m = new LogUtil.C2630a("MzFilterSwitchUI");

    /* renamed from: c */
    private View f13287c;

    /* renamed from: d */
    private boolean f13288d;

    /* renamed from: e */
    private TextView f13289e;

    /* renamed from: f */
    private TextView f13290f;

    /* renamed from: g */
    private boolean f13291g;

    /* renamed from: h */
    private Paint f13292h = new Paint();

    /* renamed from: i */
    private ObjectAnimator f13293i;

    /* renamed from: j */
    private final Context f13294j;

    /* renamed from: k */
    private final MzFilterSwitchBinding f13295k;

    /* renamed from: l */
    private final MzCommonUI f13296l;

    public MzFilterSwitchUI(@NotNull Context context, @NotNull MzFilterSwitchBinding mzFilterSwitchBinding, @NotNull MzCommonUI mzCommonUI) {
        C3443i.m21155b(context, "mActivity");
        C3443i.m21155b(mzFilterSwitchBinding, "mFilterSwitchBinding");
        C3443i.m21155b(mzCommonUI, "mCommonUI");
        this.f13294j = context;
        this.f13295k = mzFilterSwitchBinding;
        this.f13296l = mzCommonUI;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzFilterSwitchUI$Companion;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.n$a */
    /* compiled from: MzFilterSwitchUI.kt */
    public static final class C2530a {
        private C2530a() {
        }

        public /* synthetic */ C2530a(DefaultConstructorMarker gVar) {
            this();
        }
    }

    /* renamed from: a */
    public final void mo22299a() {
        float f;
        if (!PatchProxy.proxy(new Object[0], this, f13284a, false, 7175, new Class[0], Void.TYPE).isSupported && !this.f13288d) {
            this.f13287c = this.f13295k.f9725c;
            this.f13289e = this.f13295k.f9724b;
            this.f13290f = this.f13295k.f9723a;
            this.f13288d = true;
            Paint paint = this.f13292h;
            if (paint == null) {
                C3443i.m21151a();
            }
            paint.setTextSize(this.f13294j.getResources().getDimension(R.dimen.mz_font_size_13sp));
            Paint paint2 = this.f13292h;
            if (paint2 == null) {
                C3443i.m21151a();
            }
            paint2.setTextAlign(Paint.Align.LEFT);
            Typeface create = Typeface.create("sans-serif-medium", 0);
            this.f13292h.setTypeface(create);
            this.f13292h.setShadowLayer(2.0f, 0.0f, 1.0f, this.f13294j.getResources().getColor(R.color.mz_mode_name_shadow_color));
            float dimension = this.f13294j.getResources().getDimension(R.dimen.mz_filterswitch_hint_padding_left);
            float dimension2 = this.f13294j.getResources().getDimension(R.dimen.mz_filterswitch_hint_padding_top);
            float f2 = this.f13292h.getFontMetrics().bottom - this.f13292h.getFontMetrics().top;
            if (!NavigationBarUtils.m15972a()) {
                f = this.f13294j.getResources().getDimension(R.dimen.mz_mode_text_margin_top);
            } else if (DeviceHelper.f13874aa) {
                f = ((float) CameraUtil.m15901h()) + (((float) CameraUtil.m15809a()) * 1.3333334f) + this.f13294j.getResources().getDimension(R.dimen.mz_mode_text_margin__top_18_9_control_bar);
            } else {
                f = this.f13294j.getResources().getDimension(R.dimen.mz_mode_text_margin_top_navigation_bar);
            }
            float f3 = (float) 4;
            float f4 = ((f - (f2 / f3)) + f3) - dimension2;
            View view = this.f13287c;
            if (view == null) {
                C3443i.m21151a();
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = (int) f4;
                View view2 = this.f13287c;
                if (view2 == null) {
                    C3443i.m21151a();
                }
                view2.setLayoutParams(layoutParams2);
                Paint paint3 = this.f13292h;
                if (paint3 == null) {
                    C3443i.m21151a();
                }
                paint3.setTextSize(13.0f);
                Paint paint4 = this.f13292h;
                if (paint4 == null) {
                    C3443i.m21151a();
                }
                paint4.setTypeface(create);
                Paint paint5 = this.f13292h;
                TextView textView = this.f13289e;
                if (textView == null) {
                    C3443i.m21151a();
                }
                float measureText = paint5.measureText(textView.getText().toString());
                TextView textView2 = this.f13289e;
                if (textView2 == null) {
                    C3443i.m21151a();
                }
                ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
                if (layoutParams3 != null) {
                    FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                    layoutParams4.leftMargin = m15252a((float) (165 - ((int) measureText)));
                    layoutParams4.leftMargin -= (int) dimension;
                    TextView textView3 = this.f13289e;
                    if (textView3 == null) {
                        C3443i.m21151a();
                    }
                    textView3.setLayoutParams(layoutParams4);
                    TextView textView4 = this.f13289e;
                    if (textView4 == null) {
                        C3443i.m21151a();
                    }
                    View.OnClickListener onClickListener = this;
                    textView4.setOnClickListener(onClickListener);
                    TextView textView5 = this.f13290f;
                    if (textView5 == null) {
                        C3443i.m21151a();
                    }
                    textView5.setOnClickListener(onClickListener);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    /* renamed from: a */
    private final int m15252a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f13284a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7176, new Class[]{Float.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        Resources resources = this.f13294j.getResources();
        C3443i.m21152a((Object) resources, "mActivity.resources");
        return (int) ((f * resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void onClick(@NotNull View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f13284a, false, 7177, new Class[]{View.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(view, "view");
            if (this.f13296l.mo21703aP() == 1) {
                int id = view.getId();
                if (id == R.id.filter_lut) {
                    TextView textView = this.f13289e;
                    if (textView == null) {
                        C3443i.m21151a();
                    }
                    textView.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_unselect_color));
                    TextView textView2 = this.f13290f;
                    if (textView2 == null) {
                        C3443i.m21151a();
                    }
                    textView2.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_select_color));
                    this.f13296l.mo21686D(true);
                } else if (id == R.id.filter_normal) {
                    TextView textView3 = this.f13289e;
                    if (textView3 == null) {
                        C3443i.m21151a();
                    }
                    textView3.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_select_color));
                    TextView textView4 = this.f13290f;
                    if (textView4 == null) {
                        C3443i.m21151a();
                    }
                    textView4.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_unselect_color));
                    this.f13296l.mo21686D(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m15254b() {
        if (!PatchProxy.proxy(new Object[0], this, f13284a, false, 7178, new Class[0], Void.TYPE).isSupported) {
            View view = this.f13287c;
            if (view == null) {
                C3443i.m21151a();
            }
            view.setVisibility(0);
            if (this.f13296l.mo21560ay()) {
                TextView textView = this.f13289e;
                if (textView == null) {
                    C3443i.m21151a();
                }
                textView.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_unselect_color));
                TextView textView2 = this.f13290f;
                if (textView2 == null) {
                    C3443i.m21151a();
                }
                textView2.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_select_color));
            } else {
                TextView textView3 = this.f13289e;
                if (textView3 == null) {
                    C3443i.m21151a();
                }
                textView3.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_select_color));
                TextView textView4 = this.f13290f;
                if (textView4 == null) {
                    C3443i.m21151a();
                }
                textView4.setTextColor(this.f13294j.getResources().getColor(R.color.mz_settting_item_unselect_color));
            }
            this.f13291g = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m15257c() {
        if (!PatchProxy.proxy(new Object[0], this, f13284a, false, 7179, new Class[0], Void.TYPE).isSupported) {
            View view = this.f13287c;
            if (view == null) {
                C3443i.m21151a();
            }
            view.setVisibility(4);
            this.f13291g = false;
        }
    }

    /* renamed from: a */
    public final void mo22301a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13284a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7180, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z2) {
                m15256b(z);
                return;
            }
            MzFilterSwitchUI nVar = this;
            if (z) {
                m15254b();
            } else {
                m15257c();
            }
        }
    }

    /* renamed from: b */
    private final void m15256b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13284a, false, 7181, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f13293i != null) {
                ObjectAnimator objectAnimator = this.f13293i;
                if (objectAnimator == null) {
                    C3443i.m21151a();
                }
                if (objectAnimator.isRunning()) {
                    ObjectAnimator objectAnimator2 = this.f13293i;
                    if (objectAnimator2 == null) {
                        C3443i.m21151a();
                    }
                    objectAnimator2.end();
                }
            }
            View view = this.f13287c;
            if (view == null) {
                C3443i.m21151a();
            }
            float[] fArr = new float[2];
            fArr[0] = z ? 0.0f : 1.0f;
            fArr[1] = z ? 1.0f : 0.0f;
            this.f13293i = ObjectAnimator.ofFloat(view, "alpha", fArr);
            ObjectAnimator objectAnimator3 = this.f13293i;
            if (objectAnimator3 == null) {
                C3443i.m21151a();
            }
            objectAnimator3.setStartDelay(z ? 100 : 0);
            ObjectAnimator objectAnimator4 = this.f13293i;
            if (objectAnimator4 == null) {
                C3443i.m21151a();
            }
            objectAnimator4.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            ObjectAnimator objectAnimator5 = this.f13293i;
            if (objectAnimator5 == null) {
                C3443i.m21151a();
            }
            objectAnimator5.setDuration(z ? 160 : 96);
            ObjectAnimator objectAnimator6 = this.f13293i;
            if (objectAnimator6 == null) {
                C3443i.m21151a();
            }
            objectAnimator6.addListener(new C2531b(this, z));
            ObjectAnimator objectAnimator7 = this.f13293i;
            if (objectAnimator7 == null) {
                C3443i.m21151a();
            }
            objectAnimator7.start();
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo27294d2 = {"com/meizu/media/camera/ui/MzFilterSwitchUI$startFilterSwitchAnim$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.n$b */
    /* compiled from: MzFilterSwitchUI.kt */
    public static final class C2531b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f13297a;

        /* renamed from: b */
        final /* synthetic */ MzFilterSwitchUI f13298b;

        /* renamed from: c */
        final /* synthetic */ boolean f13299c;

        C2531b(MzFilterSwitchUI nVar, boolean z) {
            this.f13298b = nVar;
            this.f13299c = z;
        }

        public void onAnimationStart(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f13297a, false, 7183, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                super.onAnimationStart(animator);
                if (this.f13299c) {
                    this.f13298b.m15254b();
                }
            }
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f13297a, false, 7184, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                super.onAnimationEnd(animator);
                if (!this.f13299c) {
                    this.f13298b.m15257c();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo22300a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13284a, false, 7182, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f13293i != null) {
                ObjectAnimator objectAnimator = this.f13293i;
                if (objectAnimator == null) {
                    C3443i.m21151a();
                }
                if (objectAnimator.isRunning()) {
                    ObjectAnimator objectAnimator2 = this.f13293i;
                    if (objectAnimator2 == null) {
                        C3443i.m21151a();
                    }
                    objectAnimator2.end();
                }
            }
            if (this.f13287c != null && this.f13291g) {
                if (z) {
                    View view = this.f13287c;
                    if (view == null) {
                        C3443i.m21151a();
                    }
                    view.setVisibility(4);
                    return;
                }
                View view2 = this.f13287c;
                if (view2 == null) {
                    C3443i.m21151a();
                }
                view2.setVisibility(0);
            }
        }
    }
}
