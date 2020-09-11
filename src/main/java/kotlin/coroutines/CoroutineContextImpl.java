package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo27294d2 = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
/* renamed from: kotlin.coroutines.a */
public abstract class CoroutineContextImpl implements CoroutineContext.C3378b {
    @NotNull

    /* renamed from: b */
    private final CoroutineContext.C3380c<?> f18648b;

    public CoroutineContextImpl(@NotNull CoroutineContext.C3380c<?> cVar) {
        C3443i.m21155b(cVar, "key");
        this.f18648b = cVar;
    }

    /* renamed from: a */
    public <R> R mo27411a(R r, @NotNull C3425m<? super R, ? super CoroutineContext.C3378b, ? extends R> mVar) {
        C3443i.m21155b(mVar, "operation");
        return CoroutineContext.C3378b.C3379a.m21021a(this, r, mVar);
    }

    @Nullable
    /* renamed from: a */
    public <E extends CoroutineContext.C3378b> E mo27412a(@NotNull CoroutineContext.C3380c<E> cVar) {
        C3443i.m21155b(cVar, "key");
        return CoroutineContext.C3378b.C3379a.m21022a((CoroutineContext.C3378b) this, cVar);
    }

    @NotNull
    /* renamed from: a */
    public CoroutineContext mo27413a(@NotNull CoroutineContext gVar) {
        C3443i.m21155b(gVar, "context");
        return CoroutineContext.C3378b.C3379a.m21023a((CoroutineContext.C3378b) this, gVar);
    }

    @NotNull
    /* renamed from: b */
    public CoroutineContext mo27414b(@NotNull CoroutineContext.C3380c<?> cVar) {
        C3443i.m21155b(cVar, "key");
        return CoroutineContext.C3378b.C3379a.m21024b(this, cVar);
    }

    @NotNull
    /* renamed from: o_ */
    public CoroutineContext.C3380c<?> mo27415o_() {
        return this.f18648b;
    }
}
