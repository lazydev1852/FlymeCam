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

public class MzFilterSwitchBindingImpl extends MzFilterSwitchBinding {

    /* renamed from: d */
    public static ChangeQuickRedirect f9726d;
    @Nullable

    /* renamed from: e */
    private static final ViewDataBinding.IncludedLayouts f9727e = null;
    @Nullable

    /* renamed from: f */
    private static final SparseIntArray f9728f = new SparseIntArray();

    /* renamed from: g */
    private long f9729g;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9728f.put(R.id.filter_normal, 1);
        f9728f.put(R.id.filter_lut, 2);
    }

    public MzFilterSwitchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f9727e, f9728f));
    }

    private MzFilterSwitchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[1], objArr[0]);
        this.f9729g = -1;
        this.f9725c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9726d, false, 3566, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9729g = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9729g != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9729g;
            this.f9729g = 0;
        }
    }
}
