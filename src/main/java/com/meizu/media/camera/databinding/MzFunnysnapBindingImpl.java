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

public class MzFunnysnapBindingImpl extends MzFunnysnapBinding {

    /* renamed from: v */
    public static ChangeQuickRedirect f9761v;
    @Nullable

    /* renamed from: w */
    private static final ViewDataBinding.IncludedLayouts f9762w = null;
    @Nullable

    /* renamed from: x */
    private static final SparseIntArray f9763x = new SparseIntArray();

    /* renamed from: y */
    private long f9764y;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9763x.put(R.id.mz_fs_beauty_layout, 1);
        f9763x.put(R.id.mz_fs_beauty_hint, 2);
        f9763x.put(R.id.mz_fs_whiten_skin_bt, 3);
        f9763x.put(R.id.mz_fs_thin_face_bt, 4);
        f9763x.put(R.id.mz_fs_cancel_seekbar_bt, 5);
        f9763x.put(R.id.mz_fs_beauty_seekbar, 6);
        f9763x.put(R.id.mz_fs_sticker_layout, 7);
        f9763x.put(R.id.mz_fs_cancel_bt, 8);
        f9763x.put(R.id.mz_fs_tab, 9);
        f9763x.put(R.id.mz_filter, 10);
        f9763x.put(R.id.mz_fs_vp, 11);
        f9763x.put(R.id.mz_fs_filter, 12);
        f9763x.put(R.id.mz_fs_filter_name, 13);
        f9763x.put(R.id.mz_fs_filter_list, 14);
        f9763x.put(R.id.mz_fs_control_btn, 15);
        f9763x.put(R.id.mz_fs_show_filter_bt, 16);
        f9763x.put(R.id.mz_fs_show_sticker_bt, 17);
        f9763x.put(R.id.mz_fs_ar_enter_btn, 18);
        f9763x.put(R.id.mz_fs_ar_icon, 19);
        f9763x.put(R.id.mz_fs_ar_loading, 20);
    }

    public MzFunnysnapBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, f9762w, f9763x));
    }

    private MzFunnysnapBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[10], objArr[18], objArr[19], objArr[20], objArr[2], objArr[1], objArr[6], objArr[8], objArr[5], objArr[15], objArr[12], objArr[14], objArr[13], objArr[16], objArr[17], objArr[7], objArr[9], objArr[4], objArr[11], objArr[3], objArr[0]);
        this.f9764y = -1;
        this.f9760u.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9761v, false, 3587, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9764y = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9764y != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9764y;
            this.f9764y = 0;
        }
    }
}
