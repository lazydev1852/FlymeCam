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

public class MzCameraSimplifySmartbarBindingImpl extends MzCameraSimplifySmartbarBinding {

    /* renamed from: g */
    public static ChangeQuickRedirect f9683g;
    @Nullable

    /* renamed from: h */
    private static final ViewDataBinding.IncludedLayouts f9684h = null;
    @Nullable

    /* renamed from: i */
    private static final SparseIntArray f9685i = new SparseIntArray();

    /* renamed from: j */
    private long f9686j;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9685i.put(R.id.mz_camera_smartbar, 1);
        f9685i.put(R.id.flashlight_control, 2);
        f9685i.put(R.id.fb_control, 3);
        f9685i.put(R.id.smartbar_hint_textview, 4);
        f9685i.put(R.id.smartbar_bg_hint_textview, 5);
    }

    public MzCameraSimplifySmartbarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f9684h, f9685i));
    }

    private MzCameraSimplifySmartbarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[2], objArr[1], objArr[0], objArr[5], objArr[4]);
        this.f9686j = -1;
        this.f9680d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9683g, false, 3538, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9686j = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9686j != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9686j;
            this.f9686j = 0;
        }
    }
}
