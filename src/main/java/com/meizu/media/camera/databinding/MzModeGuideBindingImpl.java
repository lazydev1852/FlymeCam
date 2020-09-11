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

public class MzModeGuideBindingImpl extends MzModeGuideBinding {

    /* renamed from: h */
    public static ChangeQuickRedirect f9796h;
    @Nullable

    /* renamed from: i */
    private static final ViewDataBinding.IncludedLayouts f9797i = null;
    @Nullable

    /* renamed from: j */
    private static final SparseIntArray f9798j = new SparseIntArray();

    /* renamed from: k */
    private long f9799k;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9798j.put(R.id.mz_mode_bg_mask, 1);
        f9798j.put(R.id.mz_mode_guide_back, 2);
        f9798j.put(R.id.mz_mode_guide_title, 3);
        f9798j.put(R.id.mz_mode_guide_card, 4);
        f9798j.put(R.id.indicator_guide_view, 5);
        f9798j.put(R.id.mz_mode_guide_enter, 6);
    }

    public MzModeGuideBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f9797i, f9798j));
    }

    private MzModeGuideBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], objArr[1], objArr[0], objArr[2], objArr[4], objArr[6], objArr[3]);
        this.f9799k = -1;
        this.f9791c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9796h, false, 3615, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9799k = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9799k != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9799k;
            this.f9799k = 0;
        }
    }
}
