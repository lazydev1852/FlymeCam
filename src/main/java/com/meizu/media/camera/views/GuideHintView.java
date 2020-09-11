package com.meizu.media.camera.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.meizu.common.util.ResourceUtils;
import com.meizu.media.camera.ActivityBase;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/views/GuideHintView;", "", "()V", "Companion", "HintKind", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: GuideHintView.kt */
public final class GuideHintView {

    /* renamed from: a */
    public static final C2693a f14589a = new C2693a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static int f14590b = -1;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000ej\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, mo27294d2 = {"Lcom/meizu/media/camera/views/GuideHintView$HintKind;", "", "gravity", "", "horizontalMargin", "triangleLeftMargin", "textResId", "textWidth", "textHeight", "showLimit", "(Ljava/lang/String;IIIIIIII)V", "getGravity", "()I", "setGravity", "(I)V", "getHorizontalMargin", "setHorizontalMargin", "getShowLimit", "setShowLimit", "getTextHeight", "setTextHeight", "getTextResId", "setTextResId", "getTextWidth", "setTextWidth", "getTriangleLeftMargin", "setTriangleLeftMargin", "FUNNY_CAM_HINT", "FUNNY_AR_HINT", "SUPER_NIGHT_HINT", "WIDE_ANGLE_HINT", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* compiled from: GuideHintView.kt */
    public enum HintKind {
        FUNNY_CAM_HINT(81, 0, 0, R.string.mz_funny_cam_guide_desc, R.dimen.mz_funny_cam_hint_text_width, R.dimen.mz_funny_cam_hint_text_height, 3),
        FUNNY_AR_HINT(8388693, R.dimen.mz_ar_margin_end, R.dimen.mz_ar_triangle_margin_end, R.string.mz_funny_cam_ar_intro_desc, R.dimen.mz_ar_hint_text_width, R.dimen.mz_ar_hint_text_height, 1),
        SUPER_NIGHT_HINT(8388693, R.dimen.mz_supernight_margin_end, R.dimen.mz_supernight_triangle_margin_end, R.string.mz_hint_supernight_desc, R.dimen.mz_supernight_hint_text_width, R.dimen.mz_supernight_hint_text_height, 1);
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private int gravity;
        private int horizontalMargin;
        private int showLimit;
        private int textHeight;
        private int textResId;
        private int textWidth;
        private int triangleLeftMargin;

        private HintKind(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.gravity = i;
            this.horizontalMargin = i2;
            this.triangleLeftMargin = i3;
            this.textResId = i4;
            this.textWidth = i5;
            this.textHeight = i6;
            this.showLimit = i7;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final int getHorizontalMargin() {
            return this.horizontalMargin;
        }

        public final int getTriangleLeftMargin() {
            return this.triangleLeftMargin;
        }

        public final void setGravity(int i) {
            this.gravity = i;
        }

        public final void setHorizontalMargin(int i) {
            this.horizontalMargin = i;
        }

        public final void setTriangleLeftMargin(int i) {
            this.triangleLeftMargin = i;
        }

        public final int getShowLimit() {
            return this.showLimit;
        }

        public final int getTextHeight() {
            return this.textHeight;
        }

        public final int getTextResId() {
            return this.textResId;
        }

        public final int getTextWidth() {
            return this.textWidth;
        }

        public final void setShowLimit(int i) {
            this.showLimit = i;
        }

        public final void setTextHeight(int i) {
            this.textHeight = i;
        }

        public final void setTextResId(int i) {
            this.textResId = i;
        }

        public final void setTextWidth(int i) {
            this.textWidth = i;
        }

        static {
            HintKind[] hintKindArr = new HintKind[4];
            HintKind hintKind = new HintKind("FUNNY_CAM_HINT", 0, 81, 0, 0, R.string.mz_funny_cam_guide_desc, R.dimen.mz_funny_cam_hint_text_width, R.dimen.mz_funny_cam_hint_text_height, 3);
            FUNNY_CAM_HINT = hintKind;
            hintKindArr[0] = hintKind;
            HintKind hintKind2 = new HintKind("FUNNY_AR_HINT", 1, 8388693, R.dimen.mz_ar_margin_end, R.dimen.mz_ar_triangle_margin_end, R.string.mz_funny_cam_ar_intro_desc, R.dimen.mz_ar_hint_text_width, R.dimen.mz_ar_hint_text_height, 1);
            FUNNY_AR_HINT = hintKind2;
            hintKindArr[1] = hintKind2;
            HintKind hintKind3 = new HintKind("SUPER_NIGHT_HINT", 2, 8388693, R.dimen.mz_supernight_margin_end, R.dimen.mz_supernight_triangle_margin_end, R.string.mz_hint_supernight_desc, R.dimen.mz_supernight_hint_text_width, R.dimen.mz_supernight_hint_text_height, 1);
            SUPER_NIGHT_HINT = hintKind3;
            hintKindArr[2] = hintKind3;
            HintKind hintKind4 = new HintKind("WIDE_ANGLE_HINT", 3, (DeviceHelper.f13928bb ? 17 : GravityCompat.START) | 80, R.dimen.mz_wideangle_margin_end, DeviceHelper.f13928bb ? R.dimen.mz_wideangle_new_widget_triangle_margin_end : R.dimen.mz_wideangle_triangle_margin_end, R.string.mz_hint_wideangle_desc, R.dimen.mz_wideangle_hint_text_width, R.dimen.mz_wideangle_hint_text_height, 1);
            WIDE_ANGLE_HINT = hintKind4;
            hintKindArr[3] = hintKind4;
            $VALUES = hintKindArr;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo27294d2 = {"Lcom/meizu/media/camera/views/GuideHintView$Companion;", "", "()V", "TRIANGLE_WIDTH", "", "showingHintId", "", "getBottomMargin", "hintKind", "Lcom/meizu/media/camera/views/GuideHintView$HintKind;", "resourcesContext", "Landroid/content/Context;", "removeHint", "", "hint", "mActivity", "Lcom/meizu/media/camera/ActivityBase;", "showHint", "", "context", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.views.GuideHintView$a */
    /* compiled from: GuideHintView.kt */
    public static final class C2693a {

        /* renamed from: a */
        public static ChangeQuickRedirect f14591a;

        private C2693a() {
        }

        public /* synthetic */ C2693a(DefaultConstructorMarker gVar) {
            this();
        }

        /* renamed from: a */
        public final boolean mo22899a(@NotNull HintKind hintKind, @NotNull ActivityBase activityBase) {
            int i;
            HintKind hintKind2 = hintKind;
            ActivityBase activityBase2 = activityBase;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hintKind2, activityBase2}, this, f14591a, false, 8375, new Class[]{HintKind.class, ActivityBase.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            C3443i.m21155b(hintKind2, "hintKind");
            C3443i.m21155b(activityBase2, "context");
            ComboPreferences a = ComboPreferences.m10003a(activityBase.getApplicationContext());
            Context f = activityBase.mo17639f();
            int i2 = a.getInt(hintKind.name(), 0);
            if (hintKind.ordinal() <= GuideHintView.f14590b || i2 >= hintKind.getShowLimit()) {
                return false;
            }
            int a2 = GuideHintView.f14590b;
            GuideHintView.f14590b = hintKind.ordinal();
            FrameLayout d = CameraUtil.m15889d((Activity) activityBase2);
            CameraUtil.m15860a((ViewGroup) d, (Object) Integer.valueOf(a2));
            Context context = activityBase2;
            View inflate = LayoutInflater.from(context).inflate(R.layout.mz_guide_layout, (ViewGroup) null);
            C3443i.m21152a((Object) inflate, "guideLayout");
            inflate.setTag(hintKind2);
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.mz_guide_hint);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int gravity = hintKind.getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            C3443i.m21152a((Object) f, "resourcesContext");
            layoutParams.bottomMargin = m16435a(hintKind2, f);
            if (hintKind.getHorizontalMargin() != 0) {
                if (gravity == 17) {
                    layoutParams.leftMargin = 0;
                } else if (gravity != 8388611) {
                    layoutParams.rightMargin = (int) f.getResources().getDimension(hintKind.getHorizontalMargin());
                } else {
                    layoutParams.leftMargin = (int) f.getResources().getDimension(hintKind.getHorizontalMargin());
                }
            }
            layoutParams.gravity = hintKind.getGravity();
            C3443i.m21152a((Object) relativeLayout, "guideView");
            relativeLayout.setLayoutParams(layoutParams);
            TextView textView = (TextView) inflate.findViewById(R.id.mz_guide_text);
            C3443i.m21152a((Object) textView, "guideText");
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            if (layoutParams2 != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                textView.setText(hintKind.getTextResId());
                textView.setTypeface(Typeface.create("Flyme-Medium", 0));
                layoutParams3.width = (int) f.getResources().getDimension(hintKind.getTextWidth());
                layoutParams3.height = (int) f.getResources().getDimension(hintKind.getTextHeight());
                textView.setLayoutParams(layoutParams3);
                ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.mz_guide_triangle);
                C3443i.m21152a((Object) imageView, "triangle");
                ViewGroup.LayoutParams layoutParams4 = imageView.getLayoutParams();
                if (layoutParams4 != null) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
                    if (gravity == 1) {
                        if (!DeviceHelper.f13928bb || hintKind2 != HintKind.WIDE_ANGLE_HINT) {
                            i = (int) ((((float) layoutParams3.width) - ResourceUtils.m5160a(16.0f, context)) / ((float) 2));
                        } else {
                            i = (int) ((((float) (layoutParams3.width / 2)) - f.getResources().getDimension(hintKind.getTriangleLeftMargin())) - ResourceUtils.m5160a(16.0f, context));
                        }
                        layoutParams5.leftMargin = i;
                    } else if (gravity != 8388611) {
                        layoutParams5.leftMargin = (int) ((((float) layoutParams3.width) - f.getResources().getDimension(hintKind.getTriangleLeftMargin())) - ResourceUtils.m5160a(16.0f, context));
                    } else {
                        layoutParams5.leftMargin = (int) f.getResources().getDimension(hintKind.getTriangleLeftMargin());
                    }
                    imageView.setLayoutParams(layoutParams5);
                    inflate.setOnClickListener(new C2694a(d, a, hintKind2, i2));
                    d.addView(inflate);
                    return true;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }

        @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo27295k = 3, mo27296mv = {1, 1, 15})
        /* renamed from: com.meizu.media.camera.views.GuideHintView$a$a */
        /* compiled from: GuideHintView.kt */
        static final class C2694a implements View.OnClickListener {

            /* renamed from: a */
            public static ChangeQuickRedirect f14592a;

            /* renamed from: b */
            final /* synthetic */ FrameLayout f14593b;

            /* renamed from: c */
            final /* synthetic */ ComboPreferences f14594c;

            /* renamed from: d */
            final /* synthetic */ HintKind f14595d;

            /* renamed from: e */
            final /* synthetic */ int f14596e;

            C2694a(FrameLayout frameLayout, ComboPreferences eVar, HintKind hintKind, int i) {
                this.f14593b = frameLayout;
                this.f14594c = eVar;
                this.f14595d = hintKind;
                this.f14596e = i;
            }

            public final void onClick(View view) {
                if (!PatchProxy.proxy(new Object[]{view}, this, f14592a, false, 8378, new Class[]{View.class}, Void.TYPE).isSupported) {
                    this.f14593b.removeView(view);
                    this.f14594c.edit().putInt(this.f14595d.name(), this.f14596e + 1).apply();
                    GuideHintView.f14590b = -1;
                }
            }
        }

        /* renamed from: a */
        private final int m16435a(HintKind hintKind, Context context) {
            int dimension;
            int i = 0;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hintKind, context}, this, f14591a, false, 8376, new Class[]{HintKind.class, Context.class}, Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            switch (C2740d.f15241a[hintKind.ordinal()]) {
                case 1:
                    return ((int) context.getResources().getDimension(R.dimen.mz_ar_margin_bottom)) + CameraUtil.m15897f();
                case 2:
                    if (DeviceHelper.f13874aa) {
                        return (int) (((float) CameraUtil.m15897f()) + context.getResources().getDimension(R.dimen.mz_supernight_margin_bottom));
                    }
                    return (int) (context.getResources().getDimension(R.dimen.mz_bottom_bar_height) + context.getResources().getDimension(R.dimen.mz_supernight_margin_bottom));
                case 3:
                    if (!DeviceHelper.f13874aa) {
                        return (int) ((context.getResources().getDimension(R.dimen.mz_control_bar_height) / 2.0f) + context.getResources().getDimension(R.dimen.mz_control_bar_margin_bottom) + ((float) CameraUtil.m15912r()) + context.getResources().getDimension(R.dimen.mz_shutter_background_radius) + context.getResources().getDimension(R.dimen.mz_funny_snap_record_guide_margin_bottom));
                    }
                    float dimension2 = (context.getResources().getDimension(R.dimen.mz_control_bar_height) / 2.0f) + context.getResources().getDimension(R.dimen.mz_control_bar_margin_bottom_18_9);
                    if (!NavigationBarUtils.m15973a(context.getResources())) {
                        i = CameraUtil.m15912r() / 2;
                    }
                    return (int) ((dimension2 - ((float) i)) + context.getResources().getDimension(R.dimen.mz_shutter_background_radius) + context.getResources().getDimension(R.dimen.mz_funny_snap_record_guide_margin_bottom));
                case 4:
                    if (DeviceHelper.f13874aa) {
                        dimension = (int) (((float) CameraUtil.m15897f()) + context.getResources().getDimension(R.dimen.mz_wideangle_margin_bottom));
                    } else {
                        dimension = (int) (context.getResources().getDimension(R.dimen.mz_bottom_bar_height) + context.getResources().getDimension(R.dimen.mz_wideangle_margin_bottom));
                    }
                    int i2 = dimension;
                    if (CameraModeType.m10983m(CameraModeType.ModeType.MANUAL)) {
                        return i2 + ((int) context.getResources().getDimension(R.dimen.mz_manual_gallery_height));
                    }
                    return i2;
                default:
                    return 0;
            }
        }

        /* renamed from: b */
        public final void mo22900b(@NotNull HintKind hintKind, @NotNull ActivityBase activityBase) {
            if (!PatchProxy.proxy(new Object[]{hintKind, activityBase}, this, f14591a, false, 8377, new Class[]{HintKind.class, ActivityBase.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(hintKind, "hint");
                C3443i.m21155b(activityBase, "mActivity");
                if (CameraUtil.m15860a((ViewGroup) CameraUtil.m15889d((Activity) activityBase), (Object) hintKind)) {
                    ComboPreferences a = ComboPreferences.m10003a(activityBase.getApplicationContext());
                    a.edit().putInt(hintKind.name(), a.getInt(hintKind.name(), 0) + 1).apply();
                }
            }
        }
    }
}
