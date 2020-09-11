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

public class MzNightvisionBindingImpl extends MzNightvisionBinding {

    /* renamed from: c */
    public static ChangeQuickRedirect f9802c;
    @Nullable

    /* renamed from: d */
    private static final ViewDataBinding.IncludedLayouts f9803d = null;
    @Nullable

    /* renamed from: e */
    private static final SparseIntArray f9804e = new SparseIntArray();

    /* renamed from: f */
    private long f9805f;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9804e.put(R.id.nightvision_record_timer, 1);
    }

    public MzNightvisionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f9803d, f9804e));
    }

    private MzNightvisionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[1]);
        this.f9805f = -1;
        this.f9800a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9802c, false, 3622, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9805f = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9805f != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9805f;
            this.f9805f = 0;
        }
    }
}
