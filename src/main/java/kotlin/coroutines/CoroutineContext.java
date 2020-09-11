package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0002¨\u0006\u0013"}, mo27294d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
/* renamed from: kotlin.coroutines.g */
public interface CoroutineContext {

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, mo27294d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.g$c */
    /* compiled from: CoroutineContext.kt */
    public interface C3380c<E extends C3378b> {
    }

    /* renamed from: a */
    <R> R mo27411a(R r, @NotNull C3425m<? super R, ? super C3378b, ? extends R> mVar);

    @Nullable
    /* renamed from: a */
    <E extends C3378b> E mo27412a(@NotNull C3380c<E> cVar);

    @NotNull
    /* renamed from: a */
    CoroutineContext mo27413a(@NotNull CoroutineContext gVar);

    @NotNull
    /* renamed from: b */
    CoroutineContext mo27414b(@NotNull C3380c<?> cVar);

    @Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.g$a */
    /* compiled from: CoroutineContext.kt */
    public static final class C3376a {
        @NotNull
        /* renamed from: a */
        public static CoroutineContext m21016a(CoroutineContext gVar, @NotNull CoroutineContext gVar2) {
            C3443i.m21155b(gVar2, "context");
            return gVar2 == C3381h.f18661a ? gVar : (CoroutineContext) gVar2.mo27411a(gVar, C3377a.f18660a);
        }

        @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
        /* renamed from: kotlin.coroutines.g$a$a */
        /* compiled from: CoroutineContext.kt */
        static final class C3377a extends Lambda implements C3425m<CoroutineContext, C3378b, CoroutineContext> {

            /* renamed from: a */
            public static final C3377a f18660a = new C3377a();

            C3377a() {
                super(2);
            }

            @NotNull
            /* renamed from: a */
            public final CoroutineContext mo19191a(@NotNull CoroutineContext gVar, @NotNull C3378b bVar) {
                C3368c cVar;
                C3443i.m21155b(gVar, "acc");
                C3443i.m21155b(bVar, "element");
                CoroutineContext b = gVar.mo27414b(bVar.mo27415o_());
                if (b == C3381h.f18661a) {
                    return bVar;
                }
                ContinuationInterceptor eVar = (ContinuationInterceptor) b.mo27412a(ContinuationInterceptor.f18658a);
                if (eVar == null) {
                    cVar = new C3368c(b, bVar);
                } else {
                    CoroutineContext b2 = b.mo27414b(ContinuationInterceptor.f18658a);
                    if (b2 == C3381h.f18661a) {
                        cVar = new C3368c(bVar, eVar);
                    } else {
                        cVar = new C3368c(new C3368c(b2, bVar), eVar);
                    }
                }
                return cVar;
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, mo27294d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.g$b */
    /* compiled from: CoroutineContext.kt */
    public interface C3378b extends CoroutineContext {
        @Nullable
        /* renamed from: a */
        <E extends C3378b> E mo27412a(@NotNull C3380c<E> cVar);

        @NotNull
        /* renamed from: o_ */
        C3380c<?> mo27415o_();

        @Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 16})
        /* renamed from: kotlin.coroutines.g$b$a */
        /* compiled from: CoroutineContext.kt */
        public static final class C3379a {
            @NotNull
            /* renamed from: a */
            public static CoroutineContext m21023a(C3378b bVar, @NotNull CoroutineContext gVar) {
                C3443i.m21155b(gVar, "context");
                return C3376a.m21016a(bVar, gVar);
            }

            @Nullable
            /* renamed from: a */
            public static <E extends C3378b> E m21022a(C3378b bVar, @NotNull C3380c<E> cVar) {
                C3443i.m21155b(cVar, "key");
                if (!C3443i.m21154a((Object) bVar.mo27415o_(), (Object) cVar)) {
                    return null;
                }
                if (bVar != null) {
                    return bVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type E");
            }

            /* renamed from: a */
            public static <R> R m21021a(C3378b bVar, R r, @NotNull C3425m<? super R, ? super C3378b, ? extends R> mVar) {
                C3443i.m21155b(mVar, "operation");
                return mVar.mo19191a(r, bVar);
            }

            @NotNull
            /* renamed from: b */
            public static CoroutineContext m21024b(C3378b bVar, @NotNull C3380c<?> cVar) {
                C3443i.m21155b(cVar, "key");
                boolean a = C3443i.m21154a((Object) bVar.mo27415o_(), (Object) cVar);
                CoroutineContext gVar = bVar;
                if (a) {
                    gVar = C3381h.f18661a;
                }
                return gVar;
            }
        }
    }
}
