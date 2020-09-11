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

public class MzSquareControlBindingImpl extends MzSquareControlBinding {

    /* renamed from: f */
    public static ChangeQuickRedirect f9825f;
    @Nullable

    /* renamed from: g */
    private static final ViewDataBinding.IncludedLayouts f9826g = null;
    @Nullable

    /* renamed from: h */
    private static final SparseIntArray f9827h = new SparseIntArray();

    /* renamed from: i */
    private long f9828i;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9827h.put(R.id.mz_square_top, 1);
        f9827h.put(R.id.mz_square_rect, 2);
        f9827h.put(R.id.mz_square_bottom, 3);
        f9827h.put(R.id.mz_square_tip, 4);
    }

    public MzSquareControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f9826g, f9827h));
    }

    private MzSquareControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[0], objArr[2], objArr[4], objArr[1]);
        this.f9828i = -1;
        this.f9821b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9825f, false, 3643, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9828i = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9828i != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9828i;
            this.f9828i = 0;
        }
    }
}
