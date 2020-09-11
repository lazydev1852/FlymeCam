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

public class MzStereoCameraControlBindingImpl extends MzStereoCameraControlBinding {

    /* renamed from: d */
    public static ChangeQuickRedirect f9832d;
    @Nullable

    /* renamed from: e */
    private static final ViewDataBinding.IncludedLayouts f9833e = null;
    @Nullable

    /* renamed from: f */
    private static final SparseIntArray f9834f = new SparseIntArray();

    /* renamed from: g */
    private long f9835g;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9834f.put(R.id.stereo_camera_hint, 1);
        f9834f.put(R.id.stereo_horizontal_wheel_view, 2);
    }

    public MzStereoCameraControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f9833e, f9834f));
    }

    private MzStereoCameraControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[1], objArr[2]);
        this.f9835g = -1;
        this.f9829a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9832d, false, 3650, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9835g = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9835g != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9835g;
            this.f9835g = 0;
        }
    }
}
