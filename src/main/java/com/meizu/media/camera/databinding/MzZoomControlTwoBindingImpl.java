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

public class MzZoomControlTwoBindingImpl extends MzZoomControlTwoBinding {

    /* renamed from: i */
    public static ChangeQuickRedirect f9875i;
    @Nullable

    /* renamed from: j */
    private static final ViewDataBinding.IncludedLayouts f9876j = null;
    @Nullable

    /* renamed from: k */
    private static final SparseIntArray f9877k = new SparseIntArray();

    /* renamed from: l */
    private long f9878l;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9877k.put(R.id.mz_zoom_indicator_inner_layout, 1);
        f9877k.put(R.id.mz_zoom_indicator_two, 2);
        f9877k.put(R.id.mz_zoom_indicator_two_x, 3);
        f9877k.put(R.id.mz_out_zoom_click_list, 4);
        f9877k.put(R.id.mz_zoom_board_layout, 5);
        f9877k.put(R.id.mz_zoom_circle_board_view, 6);
        f9877k.put(R.id.mz_inner_zoom_click_list, 7);
    }

    public MzZoomControlTwoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f9876j, f9877k));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private MzZoomControlTwoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[7], objArr[4], objArr[5], objArr[6], objArr[1], objArr[0], objArr[2], objArr[3]);
        this.f9878l = -1;
        this.f9872f.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9875i, false, 3685, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9878l = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9878l != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9878l;
            this.f9878l = 0;
        }
    }
}
