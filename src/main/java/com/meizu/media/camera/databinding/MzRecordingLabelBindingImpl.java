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

public class MzRecordingLabelBindingImpl extends MzRecordingLabelBinding {

    /* renamed from: d */
    public static ChangeQuickRedirect f9809d;
    @Nullable

    /* renamed from: e */
    private static final ViewDataBinding.IncludedLayouts f9810e = null;
    @Nullable

    /* renamed from: f */
    private static final SparseIntArray f9811f = new SparseIntArray();

    /* renamed from: g */
    private long f9812g;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9811f.put(R.id.night_img, 1);
        f9811f.put(R.id.voice_img, 2);
    }

    public MzRecordingLabelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f9810e, f9811f));
    }

    private MzRecordingLabelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[1], objArr[2]);
        this.f9812g = -1;
        this.f9806a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9809d, false, 3629, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9812g = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9812g != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9812g;
            this.f9812g = 0;
        }
    }
}
