package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzArContainerBindingImpl extends MzArContainerBinding {

    /* renamed from: b */
    public static ChangeQuickRedirect f9619b;
    @Nullable

    /* renamed from: c */
    private static final ViewDataBinding.IncludedLayouts f9620c = null;
    @Nullable

    /* renamed from: d */
    private static final SparseIntArray f9621d = null;

    /* renamed from: e */
    private long f9622e;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public MzArContainerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f9620c, f9621d));
    }

    private MzArContainerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f9622e = -1;
        this.f9618a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9619b, false, 3510, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9622e = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9622e != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9622e;
            this.f9622e = 0;
        }
    }
}
