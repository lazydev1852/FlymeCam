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

public class MzVideoControlBindingImpl extends MzVideoControlBinding {

    /* renamed from: c */
    public static ChangeQuickRedirect f9854c;
    @Nullable

    /* renamed from: d */
    private static final ViewDataBinding.IncludedLayouts f9855d = null;
    @Nullable

    /* renamed from: e */
    private static final SparseIntArray f9856e = new SparseIntArray();

    /* renamed from: f */
    private long f9857f;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9856e.put(R.id.video_record_timer, 1);
    }

    public MzVideoControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f9855d, f9856e));
    }

    private MzVideoControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[1]);
        this.f9857f = -1;
        this.f9852a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9854c, false, 3671, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9857f = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9857f != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9857f;
            this.f9857f = 0;
        }
    }
}
