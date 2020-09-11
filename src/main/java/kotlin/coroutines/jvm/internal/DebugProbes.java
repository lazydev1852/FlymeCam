package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001¨\u0006\b"}, mo27294d2 = {"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", "T", "completion", "probeCoroutineResumed", "", "frame", "probeCoroutineSuspended", "kotlin-stdlib"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.coroutines.jvm.internal.f */
public final class DebugProbes {
    @NotNull
    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    public static final <T> Continuation<T> m21064a(@NotNull Continuation<? super T> dVar) {
        C3443i.m21155b(dVar, "completion");
        return dVar;
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: b */
    public static final void m21065b(@NotNull Continuation<?> dVar) {
        C3443i.m21155b(dVar, "frame");
    }
}
