package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class StubCamPreviewLayoutBindingImpl extends StubCamPreviewLayoutBinding {

    /* renamed from: b */
    public static ChangeQuickRedirect f9880b;
    @Nullable

    /* renamed from: c */
    private static final ViewDataBinding.IncludedLayouts f9881c = null;
    @Nullable

    /* renamed from: d */
    private static final SparseIntArray f9882d = null;

    /* renamed from: e */
    private long f9883e;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public StubCamPreviewLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f9881c, f9882d));
    }

    private StubCamPreviewLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f9883e = -1;
        this.f9879a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9880b, false, 3692, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9883e = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9883e != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9883e;
            this.f9883e = 0;
        }
    }
}
