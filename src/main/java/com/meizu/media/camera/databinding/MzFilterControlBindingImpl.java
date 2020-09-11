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

public class MzFilterControlBindingImpl extends MzFilterControlBinding {

    /* renamed from: e */
    public static ChangeQuickRedirect f9719e;
    @Nullable

    /* renamed from: f */
    private static final ViewDataBinding.IncludedLayouts f9720f = null;
    @Nullable

    /* renamed from: g */
    private static final SparseIntArray f9721g = new SparseIntArray();

    /* renamed from: h */
    private long f9722h;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9721g.put(R.id.filter_name, 1);
        f9721g.put(R.id.mz_filter, 2);
        f9721g.put(R.id.mz_filter_list, 3);
    }

    public MzFilterControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f9720f, f9721g));
    }

    private MzFilterControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[0], objArr[2], objArr[3]);
        this.f9722h = -1;
        this.f9716b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9719e, false, 3559, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9722h = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9722h != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9722h;
            this.f9722h = 0;
        }
    }
}
