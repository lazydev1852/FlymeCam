package com.meizu.media.camera.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class Entry {

    /* renamed from: j */
    public static final String[] f14057j = {"_id"};
    @Column("_id")

    /* renamed from: k */
    public long f14058k = 0;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Column {
        String defaultValue() default "";

        boolean fullText() default false;

        boolean indexed() default false;

        boolean unique() default false;

        String value();

        boolean visible() default true;
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Table {
        String value();
    }
}
