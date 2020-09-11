package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class FaceViewBindingImpl extends FaceViewBinding {

    /* renamed from: b */
    public static ChangeQuickRedirect f9602b;
    @Nullable

    /* renamed from: c */
    private static final ViewDataBinding.IncludedLayouts f9603c = null;
    @Nullable

    /* renamed from: d */
    private static final SparseIntArray f9604d = null;

    /* renamed from: e */
    private long f9605e;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public FaceViewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f9603c, f9604d));
    }

    private FaceViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f9605e = -1;
        this.f9601a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9602b, false, 3496, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9605e = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9605e != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9605e;
            this.f9605e = 0;
        }
    }
}
