package com.meizu.media.camera.modemove.p073b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.views.MzImageView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010 \u001a\u00020\u0014J\u0016\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/helper/DragFloatViewHelper;", "", "mActivity", "Lcom/meizu/media/camera/CameraActivity;", "(Lcom/meizu/media/camera/CameraActivity;)V", "<set-?>", "Landroid/view/View;", "floatView", "getFloatView", "()Landroid/view/View;", "mOffsetX", "", "mOffsetY", "mParams", "Landroid/view/WindowManager$LayoutParams;", "mWindowManager", "Landroid/view/WindowManager;", "createFloatView", "coverView", "createView", "", "touchRawX", "", "touchRawY", "scale", "topRecycler", "", "offSetX", "offSetY", "getLocation", "", "initParams", "removeView", "updateView", "x", "y", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.b.a */
public final class DragFloatViewHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f11310a;
    @Nullable

    /* renamed from: b */
    private View f11311b;

    /* renamed from: c */
    private WindowManager f11312c;

    /* renamed from: d */
    private WindowManager.LayoutParams f11313d;

    /* renamed from: e */
    private int f11314e;

    /* renamed from: f */
    private int f11315f;

    /* renamed from: g */
    private final CameraActivity f11316g;

    public DragFloatViewHelper(@NotNull CameraActivity cameraActivity) {
        C3443i.m21155b(cameraActivity, "mActivity");
        this.f11316g = cameraActivity;
    }

    @Nullable
    /* renamed from: a */
    public final View mo20737a() {
        return this.f11311b;
    }

    /* renamed from: a */
    public final void mo20739a(@NotNull View view, float f, float f2, float f3, boolean z) {
        Object[] objArr = {view, new Float(f), new Float(f2), new Float(f3), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11310a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5290, new Class[]{View.class, Float.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(view, "coverView");
            Context f4 = this.f11316g.mo17639f();
            C3443i.m21152a((Object) f4, "mActivity.resourcesContext");
            int dimensionPixelOffset = f4.getResources().getDimensionPixelOffset(R.dimen.mz_mode_move_item_touch_offset_x);
            Context f5 = this.f11316g.mo17639f();
            C3443i.m21152a((Object) f5, "mActivity.resourcesContext");
            int dimensionPixelOffset2 = f5.getResources().getDimensionPixelOffset(R.dimen.mz_mode_move_item_touch_offset_y);
            if (!z) {
                dimensionPixelOffset /= 2;
                dimensionPixelOffset2 /= 3;
            }
            this.f11311b = m12282a(view);
            Object systemService = this.f11316g.getSystemService("window");
            if (systemService != null) {
                this.f11312c = (WindowManager) systemService;
                View view2 = this.f11311b;
                if (view2 == null) {
                    C3443i.m21151a();
                }
                this.f11313d = m12284c(view2);
                WindowManager.LayoutParams layoutParams = this.f11313d;
                if (layoutParams == null) {
                    C3443i.m21151a();
                }
                layoutParams.width = (int) (((float) view.getWidth()) * f3);
                WindowManager.LayoutParams layoutParams2 = this.f11313d;
                if (layoutParams2 == null) {
                    C3443i.m21151a();
                }
                layoutParams2.height = (int) (((float) view.getHeight()) * f3);
                int[] b = m12283b(view);
                WindowManager.LayoutParams layoutParams3 = this.f11313d;
                if (layoutParams3 == null) {
                    C3443i.m21151a();
                }
                layoutParams3.x = b[0];
                WindowManager.LayoutParams layoutParams4 = this.f11313d;
                if (layoutParams4 == null) {
                    C3443i.m21151a();
                }
                layoutParams4.y = b[1];
                WindowManager windowManager = this.f11312c;
                if (windowManager == null) {
                    C3443i.m21151a();
                }
                windowManager.addView(this.f11311b, this.f11313d);
                this.f11314e = (int) ((f - ((float) b[0])) + ((float) dimensionPixelOffset));
                this.f11315f = (int) ((f2 - ((float) b[1])) + ((float) dimensionPixelOffset2));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
    }

    /* renamed from: a */
    public final void mo20740a(@NotNull View view, int i, int i2, float f) {
        Object[] objArr = {view, new Integer(i), new Integer(i2), new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f11310a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5291, new Class[]{View.class, Integer.TYPE, Integer.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(view, "coverView");
            this.f11311b = m12282a(view);
            Object systemService = this.f11316g.getSystemService("window");
            if (systemService != null) {
                this.f11312c = (WindowManager) systemService;
                View view2 = this.f11311b;
                if (view2 == null) {
                    C3443i.m21151a();
                }
                this.f11313d = m12284c(view2);
                WindowManager.LayoutParams layoutParams = this.f11313d;
                if (layoutParams == null) {
                    C3443i.m21151a();
                }
                layoutParams.width = (int) (((float) view.getWidth()) * f);
                WindowManager.LayoutParams layoutParams2 = this.f11313d;
                if (layoutParams2 == null) {
                    C3443i.m21151a();
                }
                layoutParams2.height = (int) (((float) view.getHeight()) * f);
                int[] b = m12283b(view);
                WindowManager.LayoutParams layoutParams3 = this.f11313d;
                if (layoutParams3 == null) {
                    C3443i.m21151a();
                }
                layoutParams3.x = b[0];
                WindowManager.LayoutParams layoutParams4 = this.f11313d;
                if (layoutParams4 == null) {
                    C3443i.m21151a();
                }
                layoutParams4.y = b[1];
                WindowManager windowManager = this.f11312c;
                if (windowManager == null) {
                    C3443i.m21151a();
                }
                windowManager.addView(this.f11311b, this.f11313d);
                this.f11314e = i;
                this.f11315f = i2;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
    }

    /* renamed from: a */
    private final View m12282a(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f11310a, false, 5292, new Class[]{View.class}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        MzImageView mzImageView = new MzImageView(ContextBuilder.m6349a(this.f11316g, true, true));
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        if (createBitmap != null && !createBitmap.isRecycled()) {
            mzImageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            mzImageView.setImageBitmap(createBitmap);
        }
        return mzImageView;
    }

    /* renamed from: b */
    private final int[] m12283b(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f11310a, false, 5293, new Class[]{View.class}, int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    /* renamed from: c */
    private final WindowManager.LayoutParams m12284c(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f11310a, false, 5294, new Class[]{View.class}, WindowManager.LayoutParams.class);
        if (proxy.isSupported) {
            return (WindowManager.LayoutParams) proxy.result;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.token = view.getWindowToken();
        layoutParams.type = 2;
        layoutParams.format = -3;
        layoutParams.flags = 262944;
        layoutParams.gravity = 51;
        return layoutParams;
    }

    /* renamed from: a */
    public final void mo20738a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11310a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5295, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.f11311b != null) {
            WindowManager.LayoutParams layoutParams = this.f11313d;
            if (layoutParams == null) {
                C3443i.m21151a();
            }
            layoutParams.x = i - this.f11314e;
            WindowManager.LayoutParams layoutParams2 = this.f11313d;
            if (layoutParams2 == null) {
                C3443i.m21151a();
            }
            layoutParams2.y = i2 - this.f11315f;
            WindowManager windowManager = this.f11312c;
            if (windowManager == null) {
                C3443i.m21151a();
            }
            windowManager.updateViewLayout(this.f11311b, this.f11313d);
        }
    }

    /* renamed from: b */
    public final void mo20741b() {
        if (!PatchProxy.proxy(new Object[0], this, f11310a, false, 5296, new Class[0], Void.TYPE).isSupported && this.f11311b != null && this.f11312c != null) {
            WindowManager windowManager = this.f11312c;
            if (windowManager == null) {
                C3443i.m21151a();
            }
            windowManager.removeView(this.f11311b);
        }
    }
}
