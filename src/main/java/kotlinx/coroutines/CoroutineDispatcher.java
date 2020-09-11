package kotlinx.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.C3367b;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContextImpl;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0002J\u0014\u0010\u0014\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\rH\u0017J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, mo27294d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.t */
public abstract class CoroutineDispatcher extends CoroutineContextImpl implements ContinuationInterceptor {

    /* renamed from: c */
    public static final C3561a f18997c = new C3561a((DefaultConstructorMarker) null);

    /* renamed from: a */
    public abstract void mo27658a(@NotNull CoroutineContext gVar, @NotNull Runnable runnable);

    /* renamed from: b */
    public boolean mo27727b(@NotNull CoroutineContext gVar) {
        return true;
    }

    @Nullable
    /* renamed from: a */
    public <E extends CoroutineContext.C3378b> E mo27412a(@NotNull CoroutineContext.C3380c<E> cVar) {
        return ContinuationInterceptor.C3373a.m21008a(this, cVar);
    }

    @NotNull
    /* renamed from: b */
    public CoroutineContext mo27414b(@NotNull CoroutineContext.C3380c<?> cVar) {
        return ContinuationInterceptor.C3373a.m21009b(this, cVar);
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.f18658a);
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo27294d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    @ExperimentalStdlibApi
    /* renamed from: kotlinx.coroutines.t$a */
    /* compiled from: CoroutineDispatcher.kt */
    public static final class C3561a extends C3367b<ContinuationInterceptor, CoroutineDispatcher> {
        public /* synthetic */ C3561a(DefaultConstructorMarker gVar) {
            this();
        }

        private C3561a() {
            super(ContinuationInterceptor.f18658a, C35621.f18998a);
        }
    }

    @NotNull
    /* renamed from: a */
    public final <T> Continuation<T> mo27425a(@NotNull Continuation<? super T> dVar) {
        return new DispatchedContinuation<>(this, dVar);
    }

    @InternalCoroutinesApi
    /* renamed from: b */
    public void mo27426b(@NotNull Continuation<?> dVar) {
        if (dVar != null) {
            C3536f<?> b = ((DispatchedContinuation) dVar).mo27632b();
            if (b != null) {
                b.mo27730f();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
    }

    @NotNull
    public String toString() {
        return DebugStrings.m21412b(this) + '@' + DebugStrings.m21410a((Object) this);
    }
}
