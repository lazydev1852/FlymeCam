package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, mo27294d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
/* renamed from: kotlin.coroutines.e */
public interface ContinuationInterceptor extends CoroutineContext.C3378b {

    /* renamed from: a */
    public static final C3374b f18658a = C3374b.f18659a;

    @NotNull
    /* renamed from: a */
    <T> Continuation<T> mo27425a(@NotNull Continuation<? super T> dVar);

    /* renamed from: b */
    void mo27426b(@NotNull Continuation<?> dVar);

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo27294d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.e$b */
    /* compiled from: ContinuationInterceptor.kt */
    public static final class C3374b implements CoroutineContext.C3380c<ContinuationInterceptor> {

        /* renamed from: a */
        static final /* synthetic */ C3374b f18659a = new C3374b();

        private C3374b() {
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.e$a */
    /* compiled from: ContinuationInterceptor.kt */
    public static final class C3373a {
        @Nullable
        /* renamed from: a */
        public static <E extends CoroutineContext.C3378b> E m21008a(ContinuationInterceptor eVar, @NotNull CoroutineContext.C3380c<E> cVar) {
            C3443i.m21155b(cVar, "key");
            if (cVar instanceof C3367b) {
                C3367b bVar = (C3367b) cVar;
                if (!bVar.mo27417a(eVar.mo27415o_())) {
                    return null;
                }
                E a = bVar.mo27416a((CoroutineContext.C3378b) eVar);
                if (!(a instanceof CoroutineContext.C3378b)) {
                    return null;
                }
                return a;
            } else if (ContinuationInterceptor.f18658a != cVar) {
                return null;
            } else {
                if (eVar != null) {
                    return eVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type E");
            }
        }

        @NotNull
        /* renamed from: b */
        public static CoroutineContext m21009b(ContinuationInterceptor eVar, @NotNull CoroutineContext.C3380c<?> cVar) {
            C3443i.m21155b(cVar, "key");
            if (cVar instanceof C3367b) {
                C3367b bVar = (C3367b) cVar;
                boolean a = bVar.mo27417a(eVar.mo27415o_());
                CoroutineContext gVar = eVar;
                if (a) {
                    CoroutineContext.C3378b a2 = bVar.mo27416a((CoroutineContext.C3378b) eVar);
                    gVar = eVar;
                    if (a2 != null) {
                        gVar = C3381h.f18661a;
                    }
                }
                return gVar;
            }
            CoroutineContext gVar2 = eVar;
            if (ContinuationInterceptor.f18658a == cVar) {
                gVar2 = C3381h.f18661a;
            }
            return gVar2;
        }
    }
}
