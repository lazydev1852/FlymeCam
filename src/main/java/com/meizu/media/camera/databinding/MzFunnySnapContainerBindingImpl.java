package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzFunnySnapContainerBindingImpl extends MzFunnySnapContainerBinding {

    /* renamed from: b */
    public static ChangeQuickRedirect f9731b;
    @Nullable

    /* renamed from: c */
    private static final ViewDataBinding.IncludedLayouts f9732c = null;
    @Nullable

    /* renamed from: d */
    private static final SparseIntArray f9733d = null;

    /* renamed from: e */
    private long f9734e;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public MzFunnySnapContainerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f9732c, f9733d));
    }

    private MzFunnySnapContainerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f9734e = -1;
        this.f9730a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9731b, false, 3573, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9734e = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9734e != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9734e;
            this.f9734e = 0;
        }
    }
}
