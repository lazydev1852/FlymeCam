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

public class CountDownToCaptureBindingImpl extends CountDownToCaptureBinding {

    /* renamed from: c */
    public static ChangeQuickRedirect f9552c;
    @Nullable

    /* renamed from: d */
    private static final ViewDataBinding.IncludedLayouts f9553d = null;
    @Nullable

    /* renamed from: e */
    private static final SparseIntArray f9554e = new SparseIntArray();

    /* renamed from: f */
    private long f9555f;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9554e.put(R.id.remaining_seconds, 1);
    }

    public CountDownToCaptureBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f9553d, f9554e));
    }

    private CountDownToCaptureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[1]);
        this.f9555f = -1;
        this.f9550a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9552c, false, 3470, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9555f = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9555f != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9555f;
            this.f9555f = 0;
        }
    }
}
