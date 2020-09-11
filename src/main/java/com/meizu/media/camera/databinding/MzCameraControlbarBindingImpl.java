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

public class MzCameraControlbarBindingImpl extends MzCameraControlbarBinding {

    /* renamed from: o */
    public static ChangeQuickRedirect f9673o;
    @Nullable

    /* renamed from: p */
    private static final ViewDataBinding.IncludedLayouts f9674p = null;
    @Nullable

    /* renamed from: q */
    private static final SparseIntArray f9675q = new SparseIntArray();

    /* renamed from: r */
    private long f9676r;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9675q.put(R.id.switch_camera_btn, 1);
        f9675q.put(R.id.mode_exit_btn, 2);
        f9675q.put(R.id.record_pause_btn, 3);
        f9675q.put(R.id.shutter_bg, 4);
        f9675q.put(R.id.mode_menu_shutter_btn, 5);
        f9675q.put(R.id.shutter_button, 6);
        f9675q.put(R.id.shutter_capture_loading, 7);
        f9675q.put(R.id.record_start_btn, 8);
        f9675q.put(R.id.thumbnail_bg, 9);
        f9675q.put(R.id.thumbnail_btn, 10);
        f9675q.put(R.id.capture_loading, 11);
        f9675q.put(R.id.record_shutter_btn, 12);
        f9675q.put(R.id.switch_record_btn, 13);
    }

    public MzCameraControlbarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, f9674p, f9675q));
    }

    private MzCameraControlbarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[11], objArr[2], objArr[5], objArr[0], objArr[3], objArr[12], objArr[8], objArr[4], objArr[6], objArr[7], objArr[1], objArr[13], objArr[9], objArr[10]);
        this.f9676r = -1;
        this.f9662d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9673o, false, 3531, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9676r = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9676r != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9676r;
            this.f9676r = 0;
        }
    }
}
