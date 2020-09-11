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

public class MzZoomControlBindingImpl extends MzZoomControlBinding {

    /* renamed from: f */
    public static ChangeQuickRedirect f9863f;
    @Nullable

    /* renamed from: g */
    private static final ViewDataBinding.IncludedLayouts f9864g = null;
    @Nullable

    /* renamed from: h */
    private static final SparseIntArray f9865h = new SparseIntArray();

    /* renamed from: i */
    private long f9866i;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9865h.put(R.id.mz_zoom_circle_layout, 1);
        f9865h.put(R.id.mz_zoom_circle, 2);
        f9865h.put(R.id.mz_zoom_indicator, 3);
        f9865h.put(R.id.mz_zoom_slide_bar, 4);
    }

    public MzZoomControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f9864g, f9865h));
    }

    private MzZoomControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[1], objArr[3], objArr[0], objArr[4]);
        this.f9866i = -1;
        this.f9861d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9863f, false, 3678, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9866i = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9866i != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9866i;
            this.f9866i = 0;
        }
    }
}
