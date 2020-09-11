package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.p111a.ThreadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000C2\u000601j\u0002`22\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\bø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001bH\b¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\bø\u0001\u0000¢\u0006\u0004\b$\u0010!J \u0010%\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010!J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0004\b'\u0010(J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,R\u001e\u0010-\u001a\u0004\u0018\u00010&8\u0000@\u0000X\u000e¢\u0006\f\n\u0004\b-\u0010.\u0012\u0004\b/\u00100R$\u00103\u001a\n\u0018\u000101j\u0004\u0018\u0001`28\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u00109R\u0016\u0010:\u001a\u00020&8\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b:\u0010.R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u0013\u0010?\u001a\u00020\u001b8F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010#R\u0019\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, mo27294d2 = {"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "cause", "", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "isReusable", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.af */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements Continuation<T>, CoroutineStackFrame {

    /* renamed from: j */
    private static final AtomicReferenceFieldUpdater f18840j = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "i");
    @Nullable
    @JvmField

    /* renamed from: a */
    public Object f18841a = C3497ag.f18848b;
    @NotNull
    @JvmField

    /* renamed from: b */
    public final Object f18842b;
    @NotNull
    @JvmField

    /* renamed from: c */
    public final CoroutineDispatcher f18843c;
    @NotNull
    @JvmField

    /* renamed from: d */
    public final Continuation<T> f18844d;
    @Nullable

    /* renamed from: h */
    private final CoroutineStackFrame f18845h;

    /* renamed from: i */
    private volatile Object f18846i;

    @NotNull
    /* renamed from: a */
    public CoroutineContext mo27423a() {
        return this.f18844d.mo27423a();
    }

    @Nullable
    /* renamed from: d */
    public StackTraceElement mo27441d() {
        return null;
    }

    public DispatchedContinuation(@NotNull CoroutineDispatcher tVar, @NotNull Continuation<? super T> dVar) {
        super(0);
        this.f18843c = tVar;
        this.f18844d = dVar;
        Continuation<T> dVar2 = this.f18844d;
        this.f18845h = (CoroutineStackFrame) (!(dVar2 instanceof CoroutineStackFrame) ? null : dVar2);
        this.f18842b = ThreadContext.m21374a(mo27423a());
        this.f18846i = null;
    }

    @Nullable
    /* renamed from: c */
    public CoroutineStackFrame mo27440c() {
        return this.f18845h;
    }

    @Nullable
    /* renamed from: b */
    public final C3536f<?> mo27632b() {
        Object obj = this.f18846i;
        if (!(obj instanceof C3536f)) {
            obj = null;
        }
        return (C3536f) obj;
    }

    /* renamed from: f */
    public final boolean mo27634f() {
        return this.f18846i != null;
    }

    @Nullable
    /* renamed from: e */
    public Object mo27633e() {
        Object obj = this.f18841a;
        if (Debug.m21406a()) {
            if (!(obj != C3497ag.f18848b)) {
                throw new AssertionError();
            }
        }
        this.f18841a = C3497ag.f18848b;
        return obj;
    }

    @NotNull
    /* renamed from: h */
    public Continuation<T> mo27635h() {
        return this;
    }

    /* renamed from: b */
    public void mo27424b(@NotNull Object obj) {
        CoroutineContext a;
        Object a2;
        CoroutineContext a3 = this.f18844d.mo27423a();
        Object a4 = C3543m.m21672a(obj);
        if (this.f18843c.mo27727b(a3)) {
            this.f18841a = a4;
            this.f18849e = 0;
            this.f18843c.mo27658a(a3, this);
            return;
        }
        C3499am a5 = C3530bl.f18906a.mo27715a();
        if (a5.mo27653g()) {
            this.f18841a = a4;
            this.f18849e = 0;
            a5.mo27646a((DispatchedTask<?>) this);
            return;
        }
        DispatchedTask ahVar = this;
        a5.mo27647a(true);
        try {
            a = mo27423a();
            a2 = ThreadContext.m21375a(a, this.f18842b);
            this.f18844d.mo27424b(obj);
            Unit tVar = Unit.f18749a;
            ThreadContext.m21376b(a, a2);
            do {
            } while (a5.mo27652f());
        } catch (Throwable th) {
            try {
                ahVar.mo27639a(th, (Throwable) null);
            } catch (Throwable th2) {
                a5.mo27648b(true);
                throw th2;
            }
        }
        a5.mo27648b(true);
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.f18843c + ", " + DebugStrings.m21411a((Continuation<?>) this.f18844d) + ']';
    }
}
