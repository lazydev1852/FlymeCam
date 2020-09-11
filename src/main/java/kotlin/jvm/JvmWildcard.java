package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(AnnotationRetention.BINARY)
@Documented
@java.lang.annotation.Target({})
@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo27294d2 = {"Lkotlin/jvm/JvmWildcard;", "", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: JvmPlatformAnnotations.kt */
public @interface JvmWildcard {
}