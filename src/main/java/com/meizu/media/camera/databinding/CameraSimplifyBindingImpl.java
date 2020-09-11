package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class CameraSimplifyBindingImpl extends CameraSimplifyBinding {

    /* renamed from: s */
    public static ChangeQuickRedirect f9546s;
    @Nullable

    /* renamed from: t */
    private static final ViewDataBinding.IncludedLayouts f9547t = new ViewDataBinding.IncludedLayouts(18);
    @Nullable

    /* renamed from: u */
    private static final SparseIntArray f9548u = new SparseIntArray();

    /* renamed from: v */
    private long f9549v;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9547t.setIncludes(1, new String[]{"mz_camera_simplify_smartbar", "mz_camera_controlbar"}, new int[]{2, 3}, new int[]{R.layout.mz_camera_simplify_smartbar, R.layout.mz_camera_controlbar});
        f9548u.put(R.id.preview_content, 4);
        f9548u.put(R.id.delay_inflate_one, 5);
        f9548u.put(R.id.switch_cam_anim, 6);
        f9548u.put(R.id.mz_square_control, 7);
        f9548u.put(R.id.bottom_bar_shadow, 8);
        f9548u.put(R.id.navigation_bar_shadow, 9);
        f9548u.put(R.id.mz_smartbar_arc_shadow, 10);
        f9548u.put(R.id.mz_mode_menu_stub, 11);
        f9548u.put(R.id.render_overlay, 12);
        f9548u.put(R.id.delay_inflate_two, 13);
        f9548u.put(R.id.mz_image_capture_stub, 14);
        f9548u.put(R.id.mz_front_flash_view, 15);
        f9548u.put(R.id.mz_front_flash_view_bottom, 16);
        f9548u.put(R.id.mz_front_flash_hole_cover_view, 17);
    }

    public CameraSimplifyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, f9547t, f9548u));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CameraSimplifyBindingImpl(androidx.databinding.DataBindingComponent r24, android.view.View r25, java.lang.Object[] r26) {
        /*
            r23 = this;
            r3 = r23
            r0 = r23
            r1 = r24
            r2 = r25
            r4 = 8
            r4 = r26[r4]
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r5 = 0
            r5 = r26[r5]
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            r6 = 3
            r6 = r26[r6]
            com.meizu.media.camera.databinding.MzCameraControlbarBinding r6 = (com.meizu.media.camera.databinding.MzCameraControlbarBinding) r6
            r7 = 2
            r7 = r26[r7]
            com.meizu.media.camera.databinding.MzCameraSimplifySmartbarBinding r7 = (com.meizu.media.camera.databinding.MzCameraSimplifySmartbarBinding) r7
            androidx.databinding.ViewStubProxy r9 = new androidx.databinding.ViewStubProxy
            r8 = r9
            r10 = 5
            r10 = r26[r10]
            android.view.ViewStub r10 = (android.view.ViewStub) r10
            r9.<init>(r10)
            androidx.databinding.ViewStubProxy r10 = new androidx.databinding.ViewStubProxy
            r9 = r10
            r11 = 13
            r11 = r26[r11]
            android.view.ViewStub r11 = (android.view.ViewStub) r11
            r10.<init>(r11)
            r10 = 1
            r10 = r26[r10]
            com.meizu.media.camera.views.MzInterceptFrameLayout r10 = (com.meizu.media.camera.views.MzInterceptFrameLayout) r10
            r11 = 17
            r11 = r26[r11]
            android.view.View r11 = (android.view.View) r11
            r12 = 15
            r12 = r26[r12]
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r13 = 16
            r13 = r26[r13]
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            androidx.databinding.ViewStubProxy r15 = new androidx.databinding.ViewStubProxy
            r14 = r15
            r16 = 14
            r16 = r26[r16]
            r3 = r16
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r15.<init>(r3)
            androidx.databinding.ViewStubProxy r3 = new androidx.databinding.ViewStubProxy
            r15 = r3
            r16 = 11
            r16 = r26[r16]
            r22 = r0
            r0 = r16
            android.view.ViewStub r0 = (android.view.ViewStub) r0
            r3.<init>(r0)
            r0 = 10
            r0 = r26[r0]
            r16 = r0
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r17 = r0
            r3 = 7
            r3 = r26[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            r0 = 9
            r0 = r26[r0]
            r18 = r0
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            r0 = 4
            r0 = r26[r0]
            r19 = r0
            com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r19 = (com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView) r19
            r0 = 12
            r0 = r26[r0]
            r20 = r0
            com.meizu.media.camera.views.RenderOverlay r20 = (com.meizu.media.camera.views.RenderOverlay) r20
            r0 = 6
            r0 = r26[r0]
            r21 = r0
            com.meizu.media.camera.views.MzImageView r21 = (com.meizu.media.camera.views.MzImageView) r21
            r3 = 2
            r0 = r23
            r0 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = -1
            r2 = r23
            r2.f9549v = r0
            android.widget.FrameLayout r0 = r2.f9529b
            r1 = 0
            r0.setTag(r1)
            androidx.databinding.ViewStubProxy r0 = r2.f9532e
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9533f
            r0.setContainingBinding(r2)
            com.meizu.media.camera.views.MzInterceptFrameLayout r0 = r2.f9534g
            r0.setTag(r1)
            androidx.databinding.ViewStubProxy r0 = r2.f9538k
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9539l
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9541n
            r0.setContainingBinding(r2)
            r0 = r25
            r2.setRootTag((android.view.View) r0)
            r23.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.databinding.CameraSimplifyBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9546s, false, 3459, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9549v = 4;
            }
            this.f9531d.invalidateAll();
            this.f9530c.invalidateAll();
            requestRebind();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r8.f9531d.hasPendingBindings() == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r8.f9530c.hasPendingBindings() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f9546s
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 3460(0xd84, float:4.848E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x001e
            java.lang.Object r0 = r1.result
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x001e:
            monitor-enter(r8)
            long r1 = r8.f9549v     // Catch:{ all -> 0x003e }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            if (r1 == 0) goto L_0x002a
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            return r2
        L_0x002a:
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            com.meizu.media.camera.databinding.MzCameraSimplifySmartbarBinding r1 = r8.f9531d
            boolean r1 = r1.hasPendingBindings()
            if (r1 == 0) goto L_0x0034
            return r2
        L_0x0034:
            com.meizu.media.camera.databinding.MzCameraControlbarBinding r1 = r8.f9530c
            boolean r1 = r1.hasPendingBindings()
            if (r1 == 0) goto L_0x003d
            return r2
        L_0x003d:
            return r0
        L_0x003e:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.databinding.CameraSimplifyBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (!PatchProxy.proxy(new Object[]{lifecycleOwner}, this, f9546s, false, 3461, new Class[]{LifecycleOwner.class}, Void.TYPE).isSupported) {
            super.setLifecycleOwner(lifecycleOwner);
            this.f9531d.setLifecycleOwner(lifecycleOwner);
            this.f9530c.setLifecycleOwner(lifecycleOwner);
        }
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), obj, new Integer(i2)}, this, f9546s, false, 3462, new Class[]{Integer.TYPE, Object.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        switch (i) {
            case 0:
                return m9996a((MzCameraControlbarBinding) obj, i2);
            case 1:
                return m9997a((MzCameraSimplifySmartbarBinding) obj, i2);
            default:
                return false;
        }
    }

    /* renamed from: a */
    private boolean m9996a(MzCameraControlbarBinding mzCameraControlbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9549v |= 1;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m9997a(MzCameraSimplifySmartbarBinding mzCameraSimplifySmartbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9549v |= 2;
        }
        return true;
    }

    public void executeBindings() {
        if (!PatchProxy.proxy(new Object[0], this, f9546s, false, 3463, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                long j = this.f9549v;
                this.f9549v = 0;
            }
            executeBindingsOn(this.f9531d);
            executeBindingsOn(this.f9530c);
            if (this.f9532e.getBinding() != null) {
                executeBindingsOn(this.f9532e.getBinding());
            }
            if (this.f9533f.getBinding() != null) {
                executeBindingsOn(this.f9533f.getBinding());
            }
            if (this.f9538k.getBinding() != null) {
                executeBindingsOn(this.f9538k.getBinding());
            }
            if (this.f9539l.getBinding() != null) {
                executeBindingsOn(this.f9539l.getBinding());
            }
            if (this.f9541n.getBinding() != null) {
                executeBindingsOn(this.f9541n.getBinding());
            }
        }
    }
}
