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

public class MzManualControlBindingImpl extends MzManualControlBinding {

    /* renamed from: g */
    public static ChangeQuickRedirect f9785g;
    @Nullable

    /* renamed from: h */
    private static final ViewDataBinding.IncludedLayouts f9786h = null;
    @Nullable

    /* renamed from: i */
    private static final SparseIntArray f9787i = new SparseIntArray();

    /* renamed from: j */
    private long f9788j;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9787i.put(R.id.manual_hint, 1);
        f9787i.put(R.id.mz_manual_control, 2);
        f9787i.put(R.id.horizontal_wheel_view, 3);
        f9787i.put(R.id.manual_circle_board_view, 4);
        f9787i.put(R.id.mz_manual_gallery, 5);
    }

    public MzManualControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f9786h, f9787i));
    }

    private MzManualControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[4], objArr[1], objArr[2], objArr[0], objArr[5]);
        this.f9788j = -1;
        this.f9783e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9785g, false, 3608, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9788j = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9788j != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9788j;
            this.f9788j = 0;
        }
    }
}
