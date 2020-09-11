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

public class CameraBindingImpl extends CameraBinding {

    /* renamed from: w */
    public static ChangeQuickRedirect f9524w;
    @Nullable

    /* renamed from: x */
    private static final ViewDataBinding.IncludedLayouts f9525x = new ViewDataBinding.IncludedLayouts(22);
    @Nullable

    /* renamed from: y */
    private static final SparseIntArray f9526y = new SparseIntArray();

    /* renamed from: z */
    private long f9527z;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9525x.setIncludes(1, new String[]{"mz_camera_smartbar", "mz_camera_controlbar"}, new int[]{2, 3}, new int[]{R.layout.mz_camera_smartbar, R.layout.mz_camera_controlbar});
        f9526y.put(R.id.cam_preview_v1_view, 4);
        f9526y.put(R.id.cam_preview_v2_view, 5);
        f9526y.put(R.id.cam_preview_video_view, 6);
        f9526y.put(R.id.delay_inflate_one, 7);
        f9526y.put(R.id.switch_cam_anim, 8);
        f9526y.put(R.id.mz_square_control, 9);
        f9526y.put(R.id.bottom_bar_shadow, 10);
        f9526y.put(R.id.navigation_bar_shadow, 11);
        f9526y.put(R.id.mz_smartbar_arc_shadow, 12);
        f9526y.put(R.id.mz_smartbar_shadow, 13);
        f9526y.put(R.id.mz_mode_menu_stub, 14);
        f9526y.put(R.id.render_overlay, 15);
        f9526y.put(R.id.main_view_stub, 16);
        f9526y.put(R.id.delay_inflate_two, 17);
        f9526y.put(R.id.mz_image_capture_stub, 18);
        f9526y.put(R.id.mz_front_flash_view, 19);
        f9526y.put(R.id.mz_front_flash_view_bottom, 20);
        f9526y.put(R.id.mz_front_flash_hole_cover_view, 21);
    }

    public CameraBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, f9525x, f9526y));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CameraBindingImpl(androidx.databinding.DataBindingComponent r28, android.view.View r29, java.lang.Object[] r30) {
        /*
            r27 = this;
            r3 = r27
            r0 = r27
            r1 = r28
            r2 = r29
            r4 = 10
            r4 = r30[r4]
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            androidx.databinding.ViewStubProxy r6 = new androidx.databinding.ViewStubProxy
            r5 = r6
            r7 = 4
            r7 = r30[r7]
            android.view.ViewStub r7 = (android.view.ViewStub) r7
            r6.<init>(r7)
            androidx.databinding.ViewStubProxy r7 = new androidx.databinding.ViewStubProxy
            r6 = r7
            r8 = 5
            r8 = r30[r8]
            android.view.ViewStub r8 = (android.view.ViewStub) r8
            r7.<init>(r8)
            androidx.databinding.ViewStubProxy r8 = new androidx.databinding.ViewStubProxy
            r7 = r8
            r9 = 6
            r9 = r30[r9]
            android.view.ViewStub r9 = (android.view.ViewStub) r9
            r8.<init>(r9)
            r8 = 0
            r8 = r30[r8]
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            r9 = 3
            r9 = r30[r9]
            com.meizu.media.camera.databinding.MzCameraControlbarBinding r9 = (com.meizu.media.camera.databinding.MzCameraControlbarBinding) r9
            androidx.databinding.ViewStubProxy r11 = new androidx.databinding.ViewStubProxy
            r10 = r11
            r12 = 7
            r12 = r30[r12]
            android.view.ViewStub r12 = (android.view.ViewStub) r12
            r11.<init>(r12)
            androidx.databinding.ViewStubProxy r12 = new androidx.databinding.ViewStubProxy
            r11 = r12
            r13 = 17
            r13 = r30[r13]
            android.view.ViewStub r13 = (android.view.ViewStub) r13
            r12.<init>(r13)
            androidx.databinding.ViewStubProxy r13 = new androidx.databinding.ViewStubProxy
            r12 = r13
            r14 = 16
            r14 = r30[r14]
            android.view.ViewStub r14 = (android.view.ViewStub) r14
            r13.<init>(r14)
            r13 = 1
            r13 = r30[r13]
            com.meizu.media.camera.views.MzInterceptFrameLayout r13 = (com.meizu.media.camera.views.MzInterceptFrameLayout) r13
            r14 = 21
            r14 = r30[r14]
            android.view.View r14 = (android.view.View) r14
            r15 = 19
            r15 = r30[r15]
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            r16 = 20
            r16 = r30[r16]
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            androidx.databinding.ViewStubProxy r3 = new androidx.databinding.ViewStubProxy
            r17 = r3
            r18 = 18
            r18 = r30[r18]
            r26 = r0
            r0 = r18
            android.view.ViewStub r0 = (android.view.ViewStub) r0
            r3.<init>(r0)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r18 = r0
            r3 = 14
            r3 = r30[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            r0 = 12
            r0 = r30[r0]
            r19 = r0
            android.widget.ImageView r19 = (android.widget.ImageView) r19
            r0 = 13
            r0 = r30[r0]
            r20 = r0
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r21 = r0
            r3 = 9
            r3 = r30[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            r0 = 11
            r0 = r30[r0]
            r22 = r0
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            r0 = 15
            r0 = r30[r0]
            r23 = r0
            com.meizu.media.camera.views.RenderOverlay r23 = (com.meizu.media.camera.views.RenderOverlay) r23
            r0 = 2
            r0 = r30[r0]
            r24 = r0
            com.meizu.media.camera.databinding.MzCameraSmartbarBinding r24 = (com.meizu.media.camera.databinding.MzCameraSmartbarBinding) r24
            r0 = 8
            r0 = r30[r0]
            r25 = r0
            com.meizu.media.camera.views.MzImageView r25 = (com.meizu.media.camera.views.MzImageView) r25
            r3 = 2
            r0 = r27
            r0 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = -1
            r2 = r27
            r2.f9527z = r0
            androidx.databinding.ViewStubProxy r0 = r2.f9503b
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9504c
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9505d
            r0.setContainingBinding(r2)
            android.widget.FrameLayout r0 = r2.f9506e
            r1 = 0
            r0.setTag(r1)
            androidx.databinding.ViewStubProxy r0 = r2.f9508g
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9509h
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9510i
            r0.setContainingBinding(r2)
            com.meizu.media.camera.views.MzInterceptFrameLayout r0 = r2.f9511j
            r0.setTag(r1)
            androidx.databinding.ViewStubProxy r0 = r2.f9515n
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9516o
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9519r
            r0.setContainingBinding(r2)
            r0 = r29
            r2.setRootTag((android.view.View) r0)
            r27.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.databinding.CameraBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9524w, false, 3448, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9527z = 4;
            }
            this.f9522u.invalidateAll();
            this.f9507f.invalidateAll();
            requestRebind();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r8.f9522u.hasPendingBindings() == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r8.f9507f.hasPendingBindings() == false) goto L_0x003d;
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
            com.meizu.savior.ChangeQuickRedirect r3 = f9524w
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 3449(0xd79, float:4.833E-42)
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
            long r1 = r8.f9527z     // Catch:{ all -> 0x003e }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            if (r1 == 0) goto L_0x002a
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            return r2
        L_0x002a:
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            com.meizu.media.camera.databinding.MzCameraSmartbarBinding r1 = r8.f9522u
            boolean r1 = r1.hasPendingBindings()
            if (r1 == 0) goto L_0x0034
            return r2
        L_0x0034:
            com.meizu.media.camera.databinding.MzCameraControlbarBinding r1 = r8.f9507f
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.databinding.CameraBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (!PatchProxy.proxy(new Object[]{lifecycleOwner}, this, f9524w, false, 3450, new Class[]{LifecycleOwner.class}, Void.TYPE).isSupported) {
            super.setLifecycleOwner(lifecycleOwner);
            this.f9522u.setLifecycleOwner(lifecycleOwner);
            this.f9507f.setLifecycleOwner(lifecycleOwner);
        }
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), obj, new Integer(i2)}, this, f9524w, false, 3451, new Class[]{Integer.TYPE, Object.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        switch (i) {
            case 0:
                return m9994a((MzCameraControlbarBinding) obj, i2);
            case 1:
                return m9995a((MzCameraSmartbarBinding) obj, i2);
            default:
                return false;
        }
    }

    /* renamed from: a */
    private boolean m9994a(MzCameraControlbarBinding mzCameraControlbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9527z |= 1;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m9995a(MzCameraSmartbarBinding mzCameraSmartbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9527z |= 2;
        }
        return true;
    }

    public void executeBindings() {
        if (!PatchProxy.proxy(new Object[0], this, f9524w, false, 3452, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                long j = this.f9527z;
                this.f9527z = 0;
            }
            executeBindingsOn(this.f9522u);
            executeBindingsOn(this.f9507f);
            if (this.f9503b.getBinding() != null) {
                executeBindingsOn(this.f9503b.getBinding());
            }
            if (this.f9504c.getBinding() != null) {
                executeBindingsOn(this.f9504c.getBinding());
            }
            if (this.f9505d.getBinding() != null) {
                executeBindingsOn(this.f9505d.getBinding());
            }
            if (this.f9508g.getBinding() != null) {
                executeBindingsOn(this.f9508g.getBinding());
            }
            if (this.f9509h.getBinding() != null) {
                executeBindingsOn(this.f9509h.getBinding());
            }
            if (this.f9510i.getBinding() != null) {
                executeBindingsOn(this.f9510i.getBinding());
            }
            if (this.f9515n.getBinding() != null) {
                executeBindingsOn(this.f9515n.getBinding());
            }
            if (this.f9516o.getBinding() != null) {
                executeBindingsOn(this.f9516o.getBinding());
            }
            if (this.f9519r.getBinding() != null) {
                executeBindingsOn(this.f9519r.getBinding());
            }
        }
    }
}
