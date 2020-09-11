package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzVideoContainerBindingImpl extends MzVideoContainerBinding {

    /* renamed from: b */
    public static ChangeQuickRedirect f9848b;
    @Nullable

    /* renamed from: c */
    private static final ViewDataBinding.IncludedLayouts f9849c = null;
    @Nullable

    /* renamed from: d */
    private static final SparseIntArray f9850d = null;

    /* renamed from: e */
    private long f9851e;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public MzVideoContainerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f9849c, f9850d));
    }

    private MzVideoContainerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f9851e = -1;
        this.f9847a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9848b, false, 3664, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9851e = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9851e != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9851e;
            this.f9851e = 0;
        }
    }
}
