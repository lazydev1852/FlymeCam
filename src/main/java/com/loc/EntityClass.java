package com.loc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.loc.ao */
public @interface EntityClass {
    /* renamed from: a */
    String mo13026a();

    /* renamed from: b */
    boolean mo13027b() default false;
}
