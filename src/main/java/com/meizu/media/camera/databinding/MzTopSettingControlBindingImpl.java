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

public class MzTopSettingControlBindingImpl extends MzTopSettingControlBinding {

    /* renamed from: h */
    public static ChangeQuickRedirect f9843h;
    @Nullable

    /* renamed from: i */
    private static final ViewDataBinding.IncludedLayouts f9844i = null;
    @Nullable

    /* renamed from: j */
    private static final SparseIntArray f9845j = new SparseIntArray();

    /* renamed from: k */
    private long f9846k;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9845j.put(R.id.mz_setting_item0, 2);
        f9845j.put(R.id.mz_setting_item1, 3);
        f9845j.put(R.id.mz_setting_item2, 4);
        f9845j.put(R.id.mz_setting_item3, 5);
        f9845j.put(R.id.mz_setting_item4, 6);
    }

    public MzTopSettingControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f9844i, f9845j));
    }

    private MzTopSettingControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[0], objArr[1]);
        this.f9846k = -1;
        this.f9841f.setTag((Object) null);
        this.f9842g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9843h, false, 3657, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9846k = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9846k != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9846k;
            this.f9846k = 0;
        }
    }
}
