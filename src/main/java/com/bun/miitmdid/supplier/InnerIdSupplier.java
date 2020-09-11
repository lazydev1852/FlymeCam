package com.bun.miitmdid.supplier;

import androidx.annotation.Keep;

public interface InnerIdSupplier extends IdSupplier {
    @Keep
    String getUDID();
}
