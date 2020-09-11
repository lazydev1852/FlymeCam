package com.loc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.loc.ap */
public @interface EntityField {
    /* renamed from: a */
    String mo13028a();

    /* renamed from: b */
    int mo13029b();
}
