package com.meizu.media.camera.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class DelayInflateOneBindingImpl extends DelayInflateOneBinding {

    /* renamed from: g */
    public static ChangeQuickRedirect f9562g;
    @Nullable

    /* renamed from: h */
    private static final ViewDataBinding.IncludedLayouts f9563h = null;
    @Nullable

    /* renamed from: i */
    private static final SparseIntArray f9564i = new SparseIntArray();
    @NonNull

    /* renamed from: j */
    private final FrameLayout f9565j;

    /* renamed from: k */
    private long f9566k;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9564i.put(R.id.stub_cam_preview_view, 1);
        f9564i.put(R.id.stub_cam_funny_snap_view, 2);
        f9564i.put(R.id.stub_cam_ar_view, 3);
        f9564i.put(R.id.face_view_stub, 4);
        f9564i.put(R.id.bottom_bar_gaussiang, 5);
        f9564i.put(R.id.splash_anim, 6);
    }

    public DelayInflateOneBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f9563h, f9564i));
    }

    private DelayInflateOneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], new ViewStubProxy(objArr[4]), objArr[6], new ViewStubProxy(objArr[3]), new ViewStubProxy(objArr[2]), new ViewStubProxy(objArr[1]));
        this.f9566k = -1;
        this.f9557b.setContainingBinding(this);
        this.f9565j = objArr[0];
        this.f9565j.setTag((Object) null);
        this.f9559d.setContainingBinding(this);
        this.f9560e.setContainingBinding(this);
        this.f9561f.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9562g, false, 3477, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9566k = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9566k != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        if (!PatchProxy.proxy(new Object[0], this, f9562g, false, 3478, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                long j = this.f9566k;
                this.f9566k = 0;
            }
            if (this.f9557b.getBinding() != null) {
                executeBindingsOn(this.f9557b.getBinding());
            }
            if (this.f9559d.getBinding() != null) {
                executeBindingsOn(this.f9559d.getBinding());
            }
            if (this.f9560e.getBinding() != null) {
                executeBindingsOn(this.f9560e.getBinding());
            }
            if (this.f9561f.getBinding() != null) {
                executeBindingsOn(this.f9561f.getBinding());
            }
        }
    }
}
