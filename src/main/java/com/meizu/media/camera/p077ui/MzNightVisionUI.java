package com.meizu.media.camera.p077ui;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewStubProxy;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzNightvisionBinding;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001bR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzNightVisionUI;", "", "dataBinding", "Lcom/meizu/media/camera/databinding/DelayInflateTwoBinding;", "activity", "Landroid/app/Activity;", "renderOverlay", "Lcom/meizu/media/camera/views/RenderOverlay;", "camUI", "Lcom/meizu/media/camera/ui/MzCamUI;", "(Lcom/meizu/media/camera/databinding/DelayInflateTwoBinding;Landroid/app/Activity;Lcom/meizu/media/camera/views/RenderOverlay;Lcom/meizu/media/camera/ui/MzCamUI;)V", "DEFAULT_TIME_TEXT", "", "mActivity", "mCamUI", "mNightVisionLayoutContainer", "Landroid/widget/FrameLayout;", "mRecordTimeTextView", "Landroid/widget/TextView;", "mResourcesContext", "Landroid/content/Context;", "mUIController", "Lcom/meizu/media/camera/MzUIController;", "doFrameTransitionFadeOut", "", "init", "isTextViewVisible", "", "onEnter", "onLeave", "resetRecordView", "setRecordTime", "time", "setUIController", "uicontroller", "showRecordTimeView", "show", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.u */
public final class MzNightVisionUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13615a;

    /* renamed from: b */
    private FrameLayout f13616b;

    /* renamed from: c */
    private TextView f13617c;

    /* renamed from: d */
    private Activity f13618d;

    /* renamed from: e */
    private Context f13619e;

    /* renamed from: f */
    private MzUIController f13620f;

    /* renamed from: g */
    private final String f13621g = "00:00:00";

    /* renamed from: h */
    private MzCamUI f13622h;

    public MzNightVisionUI(@NotNull DelayInflateTwoBinding delayInflateTwoBinding, @NotNull Activity activity, @NotNull RenderOverlay renderOverlay, @NotNull MzCamUI iVar) {
        C3443i.m21155b(delayInflateTwoBinding, "dataBinding");
        C3443i.m21155b(activity, PushConstants.INTENT_ACTIVITY_NAME);
        C3443i.m21155b(renderOverlay, "renderOverlay");
        C3443i.m21155b(iVar, "camUI");
        m15639a(delayInflateTwoBinding, activity, renderOverlay, iVar);
    }

    /* renamed from: a */
    private final void m15639a(DelayInflateTwoBinding delayInflateTwoBinding, Activity activity, RenderOverlay renderOverlay, MzCamUI iVar) {
        Class[] clsArr = {DelayInflateTwoBinding.class, Activity.class, RenderOverlay.class, MzCamUI.class};
        if (!PatchProxy.proxy(new Object[]{delayInflateTwoBinding, activity, renderOverlay, iVar}, this, f13615a, false, 7477, clsArr, Void.TYPE).isSupported) {
            this.f13618d = activity;
            this.f13622h = iVar;
            Activity activity2 = this.f13618d;
            if (activity2 == null) {
                C3443i.m21151a();
            }
            this.f13619e = ContextBuilder.m6349a(activity2, true, true);
            ViewStubProxy viewStubProxy = delayInflateTwoBinding.f9587r;
            C3443i.m21152a((Object) viewStubProxy, "dataBinding.mzNightvisionStub");
            if (viewStubProxy.getViewStub() != null) {
                ViewStubProxy viewStubProxy2 = delayInflateTwoBinding.f9587r;
                C3443i.m21152a((Object) viewStubProxy2, "dataBinding.mzNightvisionStub");
                ViewStub viewStub = viewStubProxy2.getViewStub();
                if (viewStub == null) {
                    C3443i.m21151a();
                }
                MzNightvisionBinding mzNightvisionBinding = (MzNightvisionBinding) DataBindingUtil.bind(viewStub.inflate());
                if (mzNightvisionBinding == null) {
                    C3443i.m21151a();
                }
                this.f13616b = mzNightvisionBinding.f9800a;
            } else {
                ViewStubProxy viewStubProxy3 = delayInflateTwoBinding.f9587r;
                C3443i.m21152a((Object) viewStubProxy3, "dataBinding.mzNightvisionStub");
                MzNightvisionBinding mzNightvisionBinding2 = (MzNightvisionBinding) viewStubProxy3.getBinding();
                if (mzNightvisionBinding2 == null) {
                    C3443i.m21151a();
                }
                this.f13616b = mzNightvisionBinding2.f9800a;
            }
            FrameLayout frameLayout = this.f13616b;
            if (frameLayout == null) {
                C3443i.m21151a();
            }
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = CameraUtil.m15901h();
                layoutParams2.gravity = 49;
                FrameLayout frameLayout2 = this.f13616b;
                if (frameLayout2 == null) {
                    C3443i.m21151a();
                }
                frameLayout2.setLayoutParams(layoutParams2);
                FrameLayout frameLayout3 = this.f13616b;
                if (frameLayout3 == null) {
                    C3443i.m21151a();
                }
                this.f13617c = (TextView) frameLayout3.findViewById(R.id.nightvision_record_timer);
                TextView textView = this.f13617c;
                if (textView == null) {
                    C3443i.m21151a();
                }
                textView.setText(this.f13621g);
                TextView textView2 = this.f13617c;
                if (textView2 == null) {
                    C3443i.m21151a();
                }
                textView2.setVisibility(4);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    /* renamed from: a */
    public final void mo22521a() {
        if (!PatchProxy.proxy(new Object[0], this, f13615a, false, 7478, new Class[0], Void.TYPE).isSupported) {
            FrameLayout frameLayout = this.f13616b;
            if (frameLayout == null) {
                C3443i.m21151a();
            }
            frameLayout.setVisibility(0);
        }
    }

    /* renamed from: b */
    public final void mo22525b() {
        if (!PatchProxy.proxy(new Object[0], this, f13615a, false, 7479, new Class[0], Void.TYPE).isSupported) {
            FrameLayout frameLayout = this.f13616b;
            if (frameLayout == null) {
                C3443i.m21151a();
            }
            frameLayout.setVisibility(8);
        }
    }

    /* renamed from: a */
    public final void mo22522a(@NotNull MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f13615a, false, 7480, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(uVar, "uicontroller");
            this.f13620f = uVar;
        }
    }

    /* renamed from: e */
    private final boolean m15640e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13615a, false, 7481, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        TextView textView = this.f13617c;
        return textView != null && textView.getVisibility() == 0;
    }

    /* renamed from: a */
    public final void mo22524a(boolean z) {
        TextView textView;
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13615a, false, 7482, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (textView = this.f13617c) != null) {
            if (!z) {
                i = 4;
            }
            textView.setVisibility(i);
        }
    }

    /* renamed from: a */
    public final void mo22523a(@NotNull String str) {
        TextView textView;
        if (!PatchProxy.proxy(new Object[]{str}, this, f13615a, false, 7483, new Class[]{String.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str, "time");
            if (m15640e() && (textView = this.f13617c) != null) {
                textView.setText(str);
            }
        }
    }

    /* renamed from: c */
    public final void mo22526c() {
        TextView textView;
        if (!PatchProxy.proxy(new Object[0], this, f13615a, false, 7484, new Class[0], Void.TYPE).isSupported && (textView = this.f13617c) != null) {
            textView.setText(this.f13621g);
        }
    }

    /* renamed from: d */
    public final void mo22527d() {
        MzCamUI iVar;
        if (!PatchProxy.proxy(new Object[0], this, f13615a, false, 7485, new Class[0], Void.TYPE).isSupported && (iVar = this.f13622h) != null) {
            iVar.mo22135ax();
        }
    }
}
