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

public class MzArBindingImpl extends MzArBinding {

    /* renamed from: i */
    public static ChangeQuickRedirect f9614i;
    @Nullable

    /* renamed from: j */
    private static final ViewDataBinding.IncludedLayouts f9615j = null;
    @Nullable

    /* renamed from: k */
    private static final SparseIntArray f9616k = new SparseIntArray();

    /* renamed from: l */
    private long f9617l;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9616k.put(R.id.ar_record_timer_layout, 1);
        f9616k.put(R.id.ar_record_timer, 2);
        f9616k.put(R.id.mz_ar_control_btn, 3);
        f9616k.put(R.id.mz_ar_sticker_link, 4);
        f9616k.put(R.id.mz_ar_sticker, 5);
        f9616k.put(R.id.mz_ar_filter_bg, 6);
        f9616k.put(R.id.mz_ar_sticker_list, 7);
    }

    public MzArBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f9615j, f9616k));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private MzArBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[1], objArr[3], objArr[6], objArr[0], objArr[5], objArr[4], objArr[7]);
        this.f9617l = -1;
        this.f9610e.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9614i, false, 3503, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9617l = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9617l != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9617l;
            this.f9617l = 0;
        }
    }
}
