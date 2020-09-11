package kotlin.internal.p104a;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, mo27294d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "kotlin-stdlib-jdk7"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: kotlin.internal.a.a */
public class JDK7PlatformImplementations extends PlatformImplementations {
    /* renamed from: a */
    public void mo27480a(@NotNull Throwable th, @NotNull Throwable th2) {
        C3443i.m21155b(th, "cause");
        C3443i.m21155b(th2, "exception");
        th.addSuppressed(th2);
    }
}
