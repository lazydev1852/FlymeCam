package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzCameraSmartbarBindingImpl extends MzCameraSmartbarBinding {

    /* renamed from: s */
    public static ChangeQuickRedirect f9705s;
    @Nullable

    /* renamed from: t */
    private static final ViewDataBinding.IncludedLayouts f9706t = null;
    @Nullable

    /* renamed from: u */
    private static final SparseIntArray f9707u = new SparseIntArray();

    /* renamed from: v */
    private long f9708v;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9707u.put(R.id.mz_camera_smartbar, 1);
        f9707u.put(R.id.menu_smb_mode_exit, 2);
        f9707u.put(R.id.flashlight_control, 3);
        f9707u.put(R.id.video_eis_switch, 4);
        f9707u.put(R.id.manual_20m_control, 5);
        f9707u.put(R.id.hdr_control, 6);
        f9707u.put(R.id.timer_control, 7);
        f9707u.put(R.id.record_portrait_control, 8);
        f9707u.put(R.id.filter_control, 9);
        f9707u.put(R.id.tripod, 10);
        f9707u.put(R.id.info, 11);
        f9707u.put(R.id.fb_control, 12);
        f9707u.put(R.id.time_lapse_control, 13);
        f9707u.put(R.id.fps_control, 14);
        f9707u.put(R.id.menu_control, 15);
        f9707u.put(R.id.smartbar_hint_textview, 16);
        f9707u.put(R.id.smartbar_bg_hint_textview, 17);
    }

    public MzCameraSmartbarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, f9706t, f9707u));
    }

    private MzCameraSmartbarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[12], objArr[9], objArr[3], objArr[14], objArr[6], objArr[11], objArr[5], objArr[15], objArr[2], objArr[1], objArr[0], objArr[8], objArr[17], objArr[16], objArr[13], objArr[7], objArr[10], objArr[4]);
        this.f9708v = -1;
        this.f9697k.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9705s, false, 3545, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9708v = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9708v != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9708v;
            this.f9708v = 0;
        }
    }
}
