package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000{2\b\u0012\u0004\u0012\u00028\u00000|2\u00060cj\u0002`dB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0016\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001d\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\n\u0018\u00010(j\u0004\u0018\u0001`)H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u0010\u001cJ\u001e\u00102\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n00H\b¢\u0006\u0004\b2\u00103J8\u00109\u001a\u00020\n2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04j\u0002`7H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u000fH\u0002¢\u0006\u0004\b;\u0010\u0018J8\u0010=\u001a\u00020<2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04j\u0002`7H\u0002¢\u0006\u0004\b=\u0010>JB\u0010?\u001a\u00020\n2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04j\u0002`72\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0014¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bD\u0010EJ\u000f\u0010H\u001a\u00020\u000fH\u0000¢\u0006\u0004\bG\u0010\u0018J:\u0010K\u001a\u00020\n2\u0006\u0010I\u001a\u00028\u00002!\u0010J\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04H\u0016¢\u0006\u0004\bK\u0010LJ#\u0010N\u001a\u0004\u0018\u00010M2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bN\u0010OJ \u0010R\u001a\u00020\n2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000PH\u0016ø\u0001\u0000¢\u0006\u0004\bR\u0010\fJ\u000f\u0010S\u001a\u00020\nH\u0002¢\u0006\u0004\bS\u0010\u001cJ\u0011\u0010U\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\bT\u0010'J\u000f\u0010V\u001a\u00020AH\u0016¢\u0006\u0004\bV\u0010CJ\u000f\u0010W\u001a\u00020\u000fH\u0002¢\u0006\u0004\bW\u0010\u0018J#\u0010W\u001a\u0004\u0018\u00010\b2\u0006\u0010I\u001a\u00028\u00002\b\u0010X\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bW\u0010YJ\u0019\u0010[\u001a\u0004\u0018\u00010\b2\u0006\u0010Z\u001a\u00020\rH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u000fH\u0002¢\u0006\u0004\b]\u0010\u0018J\u001b\u0010_\u001a\u00020\n*\u00020^2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0004\b_\u0010`J\u001b\u0010a\u001a\u00020\n*\u00020^2\u0006\u0010Z\u001a\u00020\rH\u0016¢\u0006\u0004\ba\u0010bR\u001e\u0010g\u001a\n\u0018\u00010cj\u0004\u0018\u0001`d8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u001c\u0010i\u001a\u00020h8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010m\u001a\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u0018R\u0016\u0010q\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bq\u0010\u0018R\u0016\u0010r\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\br\u0010\u0018R(\u0010x\u001a\u0004\u0018\u00010s2\b\u0010I\u001a\u0004\u0018\u00010s8B@BX\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\by\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006z"}, mo27294d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@PublishedApi
/* renamed from: kotlinx.coroutines.f */
/* compiled from: CancellableContinuationImpl.kt */
public class C3536f<T> extends DispatchedTask<T> implements CoroutineStackFrame, CancellableContinuation<T> {

    /* renamed from: c */
    private static final AtomicIntegerFieldUpdater f18913c = AtomicIntegerFieldUpdater.newUpdater(C3536f.class, "b");

    /* renamed from: h */
    private static final AtomicReferenceFieldUpdater f18914h = AtomicReferenceFieldUpdater.newUpdater(C3536f.class, Object.class, "d");
    @NotNull

    /* renamed from: a */
    private final CoroutineContext f18915a;

    /* renamed from: b */
    private volatile int f18916b;

    /* renamed from: d */
    private volatile Object f18917d;

    /* renamed from: i */
    private volatile Object f18918i;
    @NotNull

    /* renamed from: j */
    private final Continuation<T> f18919j;

    @Nullable
    /* renamed from: d */
    public StackTraceElement mo27441d() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: g */
    public String mo27731g() {
        return "CancellableContinuation";
    }

    @NotNull
    /* renamed from: h */
    public final Continuation<T> mo27635h() {
        return this.f18919j;
    }

    @NotNull
    /* renamed from: a */
    public CoroutineContext mo27423a() {
        return this.f18915a;
    }

    /* renamed from: i */
    private final Job m21643i() {
        return (Job) this.f18918i;
    }

    /* renamed from: a */
    private final void m21641a(Job akVar) {
        this.f18918i = akVar;
    }

    @Nullable
    /* renamed from: b */
    public final Object mo27729b() {
        return this.f18917d;
    }

    /* renamed from: j */
    private final boolean m21644j() {
        return (this.f18919j instanceof DispatchedContinuation) && ((DispatchedContinuation) this.f18919j).mo27634f();
    }

    @Nullable
    /* renamed from: c */
    public CoroutineStackFrame mo27440c() {
        Continuation<T> dVar = this.f18919j;
        if (!(dVar instanceof CoroutineStackFrame)) {
            dVar = null;
        }
        return (CoroutineStackFrame) dVar;
    }

    @Nullable
    /* renamed from: e */
    public Object mo27633e() {
        return mo27729b();
    }

    /* renamed from: a */
    public void mo27638a(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof C3545o) {
            try {
                ((C3545o) obj).f18934b.mo27487a(th);
            } catch (Throwable th2) {
                CoroutineContext a = mo27423a();
                C3564w.m21759a(a, (Throwable) new C3546q("Exception in cancellation handler for " + this, th2));
            }
        }
    }

    /* renamed from: b */
    public void mo27424b(@NotNull Object obj) {
        m21639a(C3543m.m21673a(obj, this), this.f18849e);
    }

    /* renamed from: a */
    private final void m21640a(int i) {
        if (!m21645k()) {
            C3498ai.m21435a(this, i);
        }
    }

    /* renamed from: d */
    private final void m21642d(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    /* renamed from: l */
    private final void m21646l() {
        if (!m21644j()) {
            mo27730f();
        }
    }

    /* renamed from: f */
    public final void mo27730f() {
        Job i = m21643i();
        if (i != null) {
            i.mo27642a();
        }
        m21641a((Job) C3526bg.f18905a);
    }

    /* renamed from: a */
    public <T> T mo27637a(@Nullable Object obj) {
        if (obj instanceof C3544n) {
            return ((C3544n) obj).f18932a;
        }
        return obj instanceof C3545o ? ((C3545o) obj).f18933a : obj;
    }

    @NotNull
    public String toString() {
        return mo27731g() + '(' + DebugStrings.m21411a((Continuation<?>) this.f18919j) + "){" + mo27729b() + "}@" + DebugStrings.m21410a((Object) this);
    }

    /* renamed from: k */
    private final boolean m21645k() {
        do {
            switch (this.f18916b) {
                case 0:
                    break;
                case 1:
                    return false;
                default:
                    throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f18913c.compareAndSet(this, 0, 2));
        return true;
    }

    /* renamed from: a */
    private final CompletedExceptionally m21639a(Object obj, int i) {
        while (true) {
            Object obj2 = this.f18917d;
            if (!(obj2 instanceof CancellableContinuationImpl)) {
                if (obj2 instanceof CompletedExceptionally) {
                    CompletedExceptionally gVar = (CompletedExceptionally) obj2;
                    if (gVar.mo27733a()) {
                        return gVar;
                    }
                }
                m21642d(obj);
            } else if (f18914h.compareAndSet(this, obj2, obj)) {
                m21646l();
                m21640a(i);
                return null;
            }
        }
    }
}
