package com.bun.miitmdid.core;

import androidx.annotation.Keep;
import com.bun.miitmdid.supplier.IdSupplier;

@Keep
public interface IIdentifierListener {
    @Keep
    void OnSupport(boolean z, IdSupplier idSupplier);
}
