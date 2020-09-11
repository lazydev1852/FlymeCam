package com.bun.miitmdid.utils;

import androidx.annotation.Keep;
import com.bun.miitmdid.supplier.IdSupplier;

@Keep
public interface SupplierListener {
    @Keep
    void OnSupport(boolean z, IdSupplier idSupplier);
}
