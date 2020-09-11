package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p107a.C3425m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo27294d2 = {"Lkotlinx/coroutines/ThreadContextElement;", "S", "Lkotlin/coroutines/CoroutineContext$Element;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.bk */
public interface ThreadContextElement<S> extends CoroutineContext.C3378b {

    @Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.bk$a */
    /* compiled from: ThreadContextElement.kt */
    public static final class C3529a {
        /* renamed from: a */
        public static <S, R> R m21615a(ThreadContextElement<S> bkVar, R r, @NotNull C3425m<? super R, ? super CoroutineContext.C3378b, ? extends R> mVar) {
            return CoroutineContext.C3378b.C3379a.m21021a(bkVar, r, mVar);
        }

        @Nullable
        /* renamed from: a */
        public static <S, E extends CoroutineContext.C3378b> E m21616a(ThreadContextElement<S> bkVar, @NotNull CoroutineContext.C3380c<E> cVar) {
            return CoroutineContext.C3378b.C3379a.m21022a((CoroutineContext.C3378b) bkVar, cVar);
        }

        @NotNull
        /* renamed from: a */
        public static <S> CoroutineContext m21617a(ThreadContextElement<S> bkVar, @NotNull CoroutineContext gVar) {
            return CoroutineContext.C3378b.C3379a.m21023a((CoroutineContext.C3378b) bkVar, gVar);
        }

        @NotNull
        /* renamed from: b */
        public static <S> CoroutineContext m21618b(ThreadContextElement<S> bkVar, @NotNull CoroutineContext.C3380c<?> cVar) {
            return CoroutineContext.C3378b.C3379a.m21024b(bkVar, cVar);
        }
    }

    /* renamed from: a */
    void mo27713a(@NotNull CoroutineContext gVar, S s);

    /* renamed from: c */
    S mo27714c(@NotNull CoroutineContext gVar);
}
