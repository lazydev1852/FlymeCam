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

public class MzDocBindingImpl extends MzDocBinding {

    /* renamed from: c */
    public static ChangeQuickRedirect f9711c;
    @Nullable

    /* renamed from: d */
    private static final ViewDataBinding.IncludedLayouts f9712d = null;
    @Nullable

    /* renamed from: e */
    private static final SparseIntArray f9713e = new SparseIntArray();

    /* renamed from: f */
    private long f9714f;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9713e.put(R.id.doc_scanner, 1);
    }

    public MzDocBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f9712d, f9713e));
    }

    private MzDocBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[0]);
        this.f9714f = -1;
        this.f9710b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9711c, false, 3552, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9714f = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9714f != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9714f;
            this.f9714f = 0;
        }
    }
}
