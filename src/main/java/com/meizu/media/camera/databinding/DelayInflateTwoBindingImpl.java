package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class DelayInflateTwoBindingImpl extends DelayInflateTwoBinding {

    /* renamed from: D */
    public static ChangeQuickRedirect f9596D;
    @Nullable

    /* renamed from: E */
    private static final ViewDataBinding.IncludedLayouts f9597E = new ViewDataBinding.IncludedLayouts(30);
    @Nullable

    /* renamed from: F */
    private static final SparseIntArray f9598F = new SparseIntArray();
    @NonNull

    /* renamed from: G */
    private final FrameLayout f9599G;

    /* renamed from: H */
    private long f9600H;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9597E.setIncludes(0, new String[]{"mz_filter_control", "mz_lutfilter_control", "mz_filter_switch", "mz_recording_label"}, new int[]{1, 2, 3, 4}, new int[]{R.layout.mz_filter_control, R.layout.mz_lutfilter_control, R.layout.mz_filter_switch, R.layout.mz_recording_label});
        f9598F.put(R.id.toast_text, 5);
        f9598F.put(R.id.mz_watch_stub, 6);
        f9598F.put(R.id.mz_zoom_stub, 7);
        f9598F.put(R.id.mz_zoom_two_stub, 8);
        f9598F.put(R.id.mz_night_stub, 9);
        f9598F.put(R.id.mz_icon_wide_angle, 10);
        f9598F.put(R.id.mz_asd_stub, 11);
        f9598F.put(R.id.mz_fb_stub, 12);
        f9598F.put(R.id.mz_stereo_camera_stub, 13);
        f9598F.put(R.id.mz_makeup_stub, 14);
        f9598F.put(R.id.mz_manual_stub, 15);
        f9598F.put(R.id.mz_barcode_stub, 16);
        f9598F.put(R.id.mz_nightvision_stub, 17);
        f9598F.put(R.id.mz_funny_snap_no_face_stub, 18);
        f9598F.put(R.id.mz_funny_snap_stub, 19);
        f9598F.put(R.id.mz_ar_stub, 20);
        f9598F.put(R.id.mz_video_stub, 21);
        f9598F.put(R.id.mz_doc_stub, 22);
        f9598F.put(R.id.mz_slow_motion_stub, 23);
        f9598F.put(R.id.shutter_anim, 24);
        f9598F.put(R.id.mz_setting_stub, 25);
        f9598F.put(R.id.mz_top_setting_stub, 26);
        f9598F.put(R.id.mz_mode_guide_stub, 27);
        f9598F.put(R.id.mz_mode_move_btn_layout, 28);
        f9598F.put(R.id.mz_mode_move_btn, 29);
    }

    public DelayInflateTwoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, f9597E, f9598F));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DelayInflateTwoBindingImpl(androidx.databinding.DataBindingComponent r36, android.view.View r37, java.lang.Object[] r38) {
        /*
            r35 = this;
            r3 = r35
            r0 = r35
            r1 = r36
            r2 = r37
            r4 = 1
            r4 = r38[r4]
            com.meizu.media.camera.databinding.MzFilterControlBinding r4 = (com.meizu.media.camera.databinding.MzFilterControlBinding) r4
            r5 = 3
            r5 = r38[r5]
            com.meizu.media.camera.databinding.MzFilterSwitchBinding r5 = (com.meizu.media.camera.databinding.MzFilterSwitchBinding) r5
            r6 = 2
            r6 = r38[r6]
            com.meizu.media.camera.databinding.MzLutfilterControlBinding r6 = (com.meizu.media.camera.databinding.MzLutfilterControlBinding) r6
            androidx.databinding.ViewStubProxy r8 = new androidx.databinding.ViewStubProxy
            r7 = r8
            r9 = 20
            r9 = r38[r9]
            android.view.ViewStub r9 = (android.view.ViewStub) r9
            r8.<init>(r9)
            androidx.databinding.ViewStubProxy r9 = new androidx.databinding.ViewStubProxy
            r8 = r9
            r10 = 11
            r10 = r38[r10]
            android.view.ViewStub r10 = (android.view.ViewStub) r10
            r9.<init>(r10)
            androidx.databinding.ViewStubProxy r10 = new androidx.databinding.ViewStubProxy
            r9 = r10
            r11 = 16
            r11 = r38[r11]
            android.view.ViewStub r11 = (android.view.ViewStub) r11
            r10.<init>(r11)
            androidx.databinding.ViewStubProxy r11 = new androidx.databinding.ViewStubProxy
            r10 = r11
            r12 = 22
            r12 = r38[r12]
            android.view.ViewStub r12 = (android.view.ViewStub) r12
            r11.<init>(r12)
            androidx.databinding.ViewStubProxy r12 = new androidx.databinding.ViewStubProxy
            r11 = r12
            r13 = 12
            r13 = r38[r13]
            android.view.ViewStub r13 = (android.view.ViewStub) r13
            r12.<init>(r13)
            androidx.databinding.ViewStubProxy r13 = new androidx.databinding.ViewStubProxy
            r12 = r13
            r14 = 18
            r14 = r38[r14]
            android.view.ViewStub r14 = (android.view.ViewStub) r14
            r13.<init>(r14)
            androidx.databinding.ViewStubProxy r14 = new androidx.databinding.ViewStubProxy
            r13 = r14
            r15 = 19
            r15 = r38[r15]
            android.view.ViewStub r15 = (android.view.ViewStub) r15
            r14.<init>(r15)
            r14 = 10
            r14 = r38[r14]
            com.meizu.media.camera.views.GlowImageView r14 = (com.meizu.media.camera.views.GlowImageView) r14
            androidx.databinding.ViewStubProxy r15 = new androidx.databinding.ViewStubProxy
            r33 = r15
            r16 = 14
            r16 = r38[r16]
            r3 = r16
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r34 = r0
            r0 = r33
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r16 = r0
            r3 = 15
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r17 = r0
            r3 = 27
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            r0 = 29
            r0 = r38[r0]
            r18 = r0
            android.widget.TextView r18 = (android.widget.TextView) r18
            r0 = 28
            r0 = r38[r0]
            r19 = r0
            android.widget.LinearLayout r19 = (android.widget.LinearLayout) r19
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r20 = r0
            r3 = 9
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r21 = r0
            r3 = 17
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r22 = r0
            r3 = 25
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r23 = r0
            r3 = 23
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r24 = r0
            r3 = 13
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r25 = r0
            r3 = 26
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r26 = r0
            r3 = 21
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r27 = r0
            r3 = 6
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r28 = r0
            r3 = 7
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            androidx.databinding.ViewStubProxy r0 = new androidx.databinding.ViewStubProxy
            r29 = r0
            r3 = 8
            r3 = r38[r3]
            android.view.ViewStub r3 = (android.view.ViewStub) r3
            r0.<init>(r3)
            r0 = 4
            r0 = r38[r0]
            r30 = r0
            com.meizu.media.camera.databinding.MzRecordingLabelBinding r30 = (com.meizu.media.camera.databinding.MzRecordingLabelBinding) r30
            r0 = 24
            r0 = r38[r0]
            r31 = r0
            com.meizu.media.camera.animation.CaptureAnimView r31 = (com.meizu.media.camera.animation.CaptureAnimView) r31
            r0 = 5
            r0 = r38[r0]
            r32 = r0
            com.meizu.media.camera.views.ToastTextView r32 = (com.meizu.media.camera.views.ToastTextView) r32
            r3 = 4
            r0 = r35
            r0 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r0 = -1
            r2 = r35
            r2.f9600H = r0
            r0 = 0
            r0 = r38[r0]
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r2.f9599G = r0
            android.widget.FrameLayout r0 = r2.f9599G
            r1 = 0
            r0.setTag(r1)
            androidx.databinding.ViewStubProxy r0 = r2.f9573d
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9574e
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9575f
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9576g
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9577h
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9578i
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9579j
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9581l
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9582m
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9583n
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9586q
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9587r
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9588s
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9589t
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9590u
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9591v
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9592w
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9593x
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9594y
            r0.setContainingBinding(r2)
            androidx.databinding.ViewStubProxy r0 = r2.f9595z
            r0.setContainingBinding(r2)
            r0 = r37
            r2.setRootTag((android.view.View) r0)
            r35.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.databinding.DelayInflateTwoBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9596D, false, 3485, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9600H = 16;
            }
            this.f9570a.invalidateAll();
            this.f9572c.invalidateAll();
            this.f9571b.invalidateAll();
            this.f9567A.invalidateAll();
            requestRebind();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r8.f9570a.hasPendingBindings() == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r8.f9572c.hasPendingBindings() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r8.f9571b.hasPendingBindings() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r8.f9567A.hasPendingBindings() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f9596D
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 3486(0xd9e, float:4.885E-42)
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
            long r1 = r8.f9600H     // Catch:{ all -> 0x0050 }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            if (r1 == 0) goto L_0x002a
            monitor-exit(r8)     // Catch:{ all -> 0x0050 }
            return r2
        L_0x002a:
            monitor-exit(r8)     // Catch:{ all -> 0x0050 }
            com.meizu.media.camera.databinding.MzFilterControlBinding r1 = r8.f9570a
            boolean r1 = r1.hasPendingBindings()
            if (r1 == 0) goto L_0x0034
            return r2
        L_0x0034:
            com.meizu.media.camera.databinding.MzLutfilterControlBinding r1 = r8.f9572c
            boolean r1 = r1.hasPendingBindings()
            if (r1 == 0) goto L_0x003d
            return r2
        L_0x003d:
            com.meizu.media.camera.databinding.MzFilterSwitchBinding r1 = r8.f9571b
            boolean r1 = r1.hasPendingBindings()
            if (r1 == 0) goto L_0x0046
            return r2
        L_0x0046:
            com.meizu.media.camera.databinding.MzRecordingLabelBinding r1 = r8.f9567A
            boolean r1 = r1.hasPendingBindings()
            if (r1 == 0) goto L_0x004f
            return r2
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0050 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.databinding.DelayInflateTwoBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (!PatchProxy.proxy(new Object[]{lifecycleOwner}, this, f9596D, false, 3487, new Class[]{LifecycleOwner.class}, Void.TYPE).isSupported) {
            super.setLifecycleOwner(lifecycleOwner);
            this.f9570a.setLifecycleOwner(lifecycleOwner);
            this.f9572c.setLifecycleOwner(lifecycleOwner);
            this.f9571b.setLifecycleOwner(lifecycleOwner);
            this.f9567A.setLifecycleOwner(lifecycleOwner);
        }
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), obj, new Integer(i2)}, this, f9596D, false, 3488, new Class[]{Integer.TYPE, Object.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        switch (i) {
            case 0:
                return m10000a((MzLutfilterControlBinding) obj, i2);
            case 1:
                return m10001a((MzRecordingLabelBinding) obj, i2);
            case 2:
                return m9999a((MzFilterSwitchBinding) obj, i2);
            case 3:
                return m9998a((MzFilterControlBinding) obj, i2);
            default:
                return false;
        }
    }

    /* renamed from: a */
    private boolean m10000a(MzLutfilterControlBinding mzLutfilterControlBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9600H |= 1;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10001a(MzRecordingLabelBinding mzRecordingLabelBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9600H |= 2;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m9999a(MzFilterSwitchBinding mzFilterSwitchBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9600H |= 4;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m9998a(MzFilterControlBinding mzFilterControlBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9600H |= 8;
        }
        return true;
    }

    public void executeBindings() {
        if (!PatchProxy.proxy(new Object[0], this, f9596D, false, 3489, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                long j = this.f9600H;
                this.f9600H = 0;
            }
            executeBindingsOn(this.f9570a);
            executeBindingsOn(this.f9572c);
            executeBindingsOn(this.f9571b);
            executeBindingsOn(this.f9567A);
            if (this.f9573d.getBinding() != null) {
                executeBindingsOn(this.f9573d.getBinding());
            }
            if (this.f9574e.getBinding() != null) {
                executeBindingsOn(this.f9574e.getBinding());
            }
            if (this.f9575f.getBinding() != null) {
                executeBindingsOn(this.f9575f.getBinding());
            }
            if (this.f9576g.getBinding() != null) {
                executeBindingsOn(this.f9576g.getBinding());
            }
            if (this.f9577h.getBinding() != null) {
                executeBindingsOn(this.f9577h.getBinding());
            }
            if (this.f9578i.getBinding() != null) {
                executeBindingsOn(this.f9578i.getBinding());
            }
            if (this.f9579j.getBinding() != null) {
                executeBindingsOn(this.f9579j.getBinding());
            }
            if (this.f9581l.getBinding() != null) {
                executeBindingsOn(this.f9581l.getBinding());
            }
            if (this.f9582m.getBinding() != null) {
                executeBindingsOn(this.f9582m.getBinding());
            }
            if (this.f9583n.getBinding() != null) {
                executeBindingsOn(this.f9583n.getBinding());
            }
            if (this.f9586q.getBinding() != null) {
                executeBindingsOn(this.f9586q.getBinding());
            }
            if (this.f9587r.getBinding() != null) {
                executeBindingsOn(this.f9587r.getBinding());
            }
            if (this.f9588s.getBinding() != null) {
                executeBindingsOn(this.f9588s.getBinding());
            }
            if (this.f9589t.getBinding() != null) {
                executeBindingsOn(this.f9589t.getBinding());
            }
            if (this.f9590u.getBinding() != null) {
                executeBindingsOn(this.f9590u.getBinding());
            }
            if (this.f9591v.getBinding() != null) {
                executeBindingsOn(this.f9591v.getBinding());
            }
            if (this.f9592w.getBinding() != null) {
                executeBindingsOn(this.f9592w.getBinding());
            }
            if (this.f9593x.getBinding() != null) {
                executeBindingsOn(this.f9593x.getBinding());
            }
            if (this.f9594y.getBinding() != null) {
                executeBindingsOn(this.f9594y.getBinding());
            }
            if (this.f9595z.getBinding() != null) {
                executeBindingsOn(this.f9595z.getBinding());
            }
        }
    }
}
