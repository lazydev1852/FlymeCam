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

public class MzMakeupControlBindingImpl extends MzMakeupControlBinding {

    /* renamed from: c */
    public static ChangeQuickRedirect f9775c;
    @Nullable

    /* renamed from: d */
    private static final ViewDataBinding.IncludedLayouts f9776d = null;
    @Nullable

    /* renamed from: e */
    private static final SparseIntArray f9777e = new SparseIntArray();

    /* renamed from: f */
    private long f9778f;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9777e.put(R.id.mz_makeup_gallery, 1);
    }

    public MzMakeupControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f9776d, f9777e));
    }

    private MzMakeupControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[0]);
        this.f9778f = -1;
        this.f9774b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9775c, false, 3601, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9778f = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9778f != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9778f;
            this.f9778f = 0;
        }
    }
}
