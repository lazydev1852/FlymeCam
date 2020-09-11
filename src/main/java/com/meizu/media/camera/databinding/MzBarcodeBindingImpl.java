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

public class MzBarcodeBindingImpl extends MzBarcodeBinding {

    /* renamed from: A */
    public static ChangeQuickRedirect f9649A;
    @Nullable

    /* renamed from: B */
    private static final ViewDataBinding.IncludedLayouts f9650B = null;
    @Nullable

    /* renamed from: C */
    private static final SparseIntArray f9651C = new SparseIntArray();

    /* renamed from: D */
    private long f9652D;

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        f9651C.put(R.id.mz_barcode_auto_cover_view, 1);
        f9651C.put(R.id.mz_barcode_layout, 2);
        f9651C.put(R.id.mode_exit_control, 3);
        f9651C.put(R.id.mz_barcode_result_layout, 4);
        f9651C.put(R.id.mz_barcode_info_exit_layout, 5);
        f9651C.put(R.id.mz_barcode_info_exit_view, 6);
        f9651C.put(R.id.mz_barcode_info_header, 7);
        f9651C.put(R.id.header_image, 8);
        f9651C.put(R.id.header_title, 9);
        f9651C.put(R.id.header_content_main, 10);
        f9651C.put(R.id.header_content_extra, 11);
        f9651C.put(R.id.header_price, 12);
        f9651C.put(R.id.header_content_sub, 13);
        f9651C.put(R.id.header_content_sub_extra, 14);
        f9651C.put(R.id.header_divider, 15);
        f9651C.put(R.id.mz_barcode_info_list, 16);
        f9651C.put(R.id.mz_barcode_list_divider_bottom, 17);
        f9651C.put(R.id.mz_barcode_smartbar, 18);
        f9651C.put(R.id.barcode_second, 19);
        f9651C.put(R.id.barcode_third, 20);
        f9651C.put(R.id.mz_barcode_flash_tip_layout, 21);
        f9651C.put(R.id.mz_barcode_flash_tip_icon, 22);
        f9651C.put(R.id.mz_barcode_flash_tip_text, 23);
        f9651C.put(R.id.mz_barcode_auto_result_hint, 24);
        f9651C.put(R.id.mz_barcode_result_type_hint, 25);
    }

    public MzBarcodeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, f9650B, f9651C));
    }

    private MzBarcodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[19], objArr[20], objArr[0], objArr[11], objArr[10], objArr[13], objArr[14], objArr[15], objArr[8], objArr[12], objArr[9], objArr[3], objArr[1], objArr[24], objArr[22], objArr[21], objArr[23], objArr[5], objArr[6], objArr[7], objArr[16], objArr[2], objArr[17], objArr[4], objArr[25], objArr[18]);
        this.f9652D = -1;
        this.f9625c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        if (!PatchProxy.proxy(new Object[0], this, f9649A, false, 3517, new Class[0], Void.TYPE).isSupported) {
            synchronized (this) {
                this.f9652D = 1;
            }
            requestRebind();
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9652D != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            long j = this.f9652D;
            this.f9652D = 0;
        }
    }
}
