package kotlin.jvm.p108b;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo27294d2 = {"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.jvm.b.b */
/* compiled from: ArrayIterator.kt */
public final class C3440b {
    @NotNull
    /* renamed from: a */
    public static final <T> Iterator<T> m21133a(@NotNull T[] tArr) {
        C3443i.m21155b(tArr, "array");
        return new ArrayIterator<>(tArr);
    }
}
