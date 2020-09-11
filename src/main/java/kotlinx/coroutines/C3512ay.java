package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p107a.C3425m;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 (2\u00020\u0001:\u0001(J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H\u0017J\u0014\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'J\u001a\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018H&J\f\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H'JE\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140\u001fj\u0002`\"H'J1\u0010\u001a\u001a\u00020\u001b2'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140\u001fj\u0002`\"H&J\u0011\u0010#\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0002J\b\u0010'\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, mo27294d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ay */
/* compiled from: Job.kt */
public interface C3512ay extends CoroutineContext.C3378b {

    /* renamed from: b */
    public static final C3514b f18878b = C3514b.f18879a;

    @NotNull
    @InternalCoroutinesApi
    /* renamed from: a */
    Job mo27670a(boolean z, boolean z2, @NotNull C3414b<? super Throwable, Unit> bVar);

    @NotNull
    @InternalCoroutinesApi
    /* renamed from: a */
    C3537h mo27671a(@NotNull C3539j jVar);

    /* renamed from: c */
    boolean mo27559c();

    @NotNull
    @InternalCoroutinesApi
    /* renamed from: i */
    CancellationException mo27672i();

    /* renamed from: j */
    boolean mo27673j();

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo27294d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.ay$b */
    /* compiled from: Job.kt */
    public static final class C3514b implements CoroutineContext.C3380c<C3512ay> {

        /* renamed from: a */
        static final /* synthetic */ C3514b f18879a = new C3514b();

        static {
            CoroutineExceptionHandler.C3563a aVar = CoroutineExceptionHandler.f18999a;
        }

        private C3514b() {
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.ay$a */
    /* compiled from: Job.kt */
    public static final class C3513a {
        /* renamed from: a */
        public static <R> R m21502a(C3512ay ayVar, R r, @NotNull C3425m<? super R, ? super CoroutineContext.C3378b, ? extends R> mVar) {
            return CoroutineContext.C3378b.C3379a.m21021a(ayVar, r, mVar);
        }

        @Nullable
        /* renamed from: a */
        public static <E extends CoroutineContext.C3378b> E m21503a(C3512ay ayVar, @NotNull CoroutineContext.C3380c<E> cVar) {
            return CoroutineContext.C3378b.C3379a.m21022a((CoroutineContext.C3378b) ayVar, cVar);
        }

        @NotNull
        /* renamed from: a */
        public static CoroutineContext m21504a(C3512ay ayVar, @NotNull CoroutineContext gVar) {
            return CoroutineContext.C3378b.C3379a.m21023a((CoroutineContext.C3378b) ayVar, gVar);
        }

        @NotNull
        /* renamed from: b */
        public static CoroutineContext m21506b(C3512ay ayVar, @NotNull CoroutineContext.C3380c<?> cVar) {
            return CoroutineContext.C3378b.C3379a.m21024b(ayVar, cVar);
        }

        /* renamed from: a */
        public static /* synthetic */ Job m21505a(C3512ay ayVar, boolean z, boolean z2, C3414b bVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return ayVar.mo27670a(z, z2, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
    }
}
