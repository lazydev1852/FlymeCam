package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzCamAsdLayoutBindingImpl extends MzCamAsdLayoutBinding {

    /* renamed from: b */
    public static ChangeQuickRedirect f9654b;
    @Nullable

    /* renamed from: c */
    private static final ViewDataBinding.IncludedLayouts f9655c = null;
    @Nullable

    /* renamed from: d */
    private static final SparseIntArray f9656d = new SparseIntArray();
    @NonNull

    /* renamed from: e */
    private final FrameLayout f9657e;

    /* renamed from: f */
    private long f9658f;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9656d.put(R.id.mz_asd_image_view, 1);
    }

    public MzCamAsdLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f9655c, f9656d));
    }

    private MzCamAsdLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1]);
        this.f9658f = -1;
        this.f9657e = objArr[0];
        this.f9657e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9654b, false, 3524, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9658f = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9658f != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9658f;
            this.f9658f = 0;
        }
    }
}
