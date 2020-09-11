package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzFunnySnapNoFaceBindingImpl extends MzFunnySnapNoFaceBinding {

    /* renamed from: b */
    public static ChangeQuickRedirect f9736b;
    @Nullable

    /* renamed from: c */
    private static final ViewDataBinding.IncludedLayouts f9737c = null;
    @Nullable

    /* renamed from: d */
    private static final SparseIntArray f9738d = null;

    /* renamed from: e */
    private long f9739e;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public MzFunnySnapNoFaceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f9737c, f9738d));
    }

    private MzFunnySnapNoFaceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f9739e = -1;
        this.f9735a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9736b, false, 3580, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9739e = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9739e != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9739e;
            this.f9739e = 0;
        }
    }
}
