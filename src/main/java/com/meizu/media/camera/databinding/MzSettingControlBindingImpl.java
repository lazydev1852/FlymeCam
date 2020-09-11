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

public class MzSettingControlBindingImpl extends MzSettingControlBinding {

    /* renamed from: d */
    public static ChangeQuickRedirect f9816d;
    @Nullable

    /* renamed from: e */
    private static final ViewDataBinding.IncludedLayouts f9817e = null;
    @Nullable

    /* renamed from: f */
    private static final SparseIntArray f9818f = new SparseIntArray();

    /* renamed from: g */
    private long f9819g;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9818f.put(R.id.mz_setting_toolbar, 1);
        f9818f.put(R.id.mz_setting_listview, 2);
    }

    public MzSettingControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f9817e, f9818f));
    }

    private MzSettingControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[2], objArr[1]);
        this.f9819g = -1;
        this.f9813a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9816d, false, 3636, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9819g = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9819g != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9819g;
            this.f9819g = 0;
        }
    }
}
