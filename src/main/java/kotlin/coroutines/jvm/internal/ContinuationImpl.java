package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.C3450n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C3382a;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo27294d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
/* renamed from: kotlin.coroutines.jvm.internal.a */
public abstract class ContinuationImpl implements Serializable, Continuation<Object>, CoroutineStackFrame {
    @Nullable

    /* renamed from: a */
    private final Continuation<Object> f18678a;

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: a */
    public abstract Object mo19190a(@NotNull Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27439b() {
    }

    public ContinuationImpl(@Nullable Continuation<Object> dVar) {
        this.f18678a = dVar;
    }

    @Nullable
    /* renamed from: e */
    public final Continuation<Object> mo27442e() {
        return this.f18678a;
    }

    /* renamed from: b */
    public final void mo27424b(@NotNull Object obj) {
        Continuation dVar = this;
        while (true) {
            ContinuationImpl aVar = (ContinuationImpl) dVar;
            DebugProbes.m21065b(aVar);
            Continuation dVar2 = aVar.f18678a;
            if (dVar2 == null) {
                C3443i.m21151a();
            }
            try {
                Object a = aVar.mo19190a(obj);
                if (a != C3382a.m21036a()) {
                    Result.C3448a aVar2 = Result.f18741a;
                    obj = Result.m21195d(a);
                    aVar.mo27439b();
                    if (dVar2 instanceof ContinuationImpl) {
                        dVar = dVar2;
                    } else {
                        dVar2.mo27424b(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                Result.C3448a aVar3 = Result.f18741a;
                obj = Result.m21195d(C3450n.m21198a(th));
            }
        }
    }

    @NotNull
    /* renamed from: a */
    public Continuation<Unit> mo27438a(@NotNull Continuation<?> dVar) {
        C3443i.m21155b(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @NotNull
    /* renamed from: a */
    public Continuation<Unit> mo19192a(@Nullable Object obj, @NotNull Continuation<?> dVar) {
        C3443i.m21155b(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Serializable d = mo27441d();
        if (d == null) {
            d = getClass().getName();
        }
        sb.append(d);
        return sb.toString();
    }

    @Nullable
    /* renamed from: c */
    public CoroutineStackFrame mo27440c() {
        Continuation<Object> dVar = this.f18678a;
        if (!(dVar instanceof CoroutineStackFrame)) {
            dVar = null;
        }
        return (CoroutineStackFrame) dVar;
    }

    @Nullable
    /* renamed from: d */
    public StackTraceElement mo27441d() {
        return C3389e.m21060a(this);
    }
}
