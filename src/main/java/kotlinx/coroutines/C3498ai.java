package kotlinx.coroutines;

import kotlin.C3450n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.p111a.StackTraceRecovery;
import kotlinx.coroutines.p111a.ThreadContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\b\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, mo27294d2 = {"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ai */
/* compiled from: DispatchedTask.kt */
public final class C3498ai {
    /* renamed from: a */
    public static final boolean m21437a(int i) {
        return i == 1;
    }

    /* renamed from: b */
    public static final boolean m21438b(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: a */
    public static final <T> void m21435a(@NotNull DispatchedTask<? super T> ahVar, int i) {
        Continuation<? super T> h = ahVar.mo27635h();
        if (!m21438b(i) || !(h instanceof DispatchedContinuation) || m21437a(i) != m21437a(ahVar.f18849e)) {
            m21436a(ahVar, h, i);
            return;
        }
        CoroutineDispatcher tVar = ((DispatchedContinuation) h).f18843c;
        CoroutineContext a = h.mo27423a();
        if (tVar.mo27727b(a)) {
            tVar.mo27658a(a, ahVar);
        } else {
            m21434a((DispatchedTask<?>) ahVar);
        }
    }

    /* renamed from: a */
    public static final <T> void m21436a(@NotNull DispatchedTask<? super T> ahVar, @NotNull Continuation<? super T> dVar, int i) {
        Object obj;
        Object e = ahVar.mo27633e();
        Throwable c = ahVar.mo27640c(e);
        if (c == null) {
            c = null;
        } else if (Debug.m21408c() && (dVar instanceof CoroutineStackFrame)) {
            c = StackTraceRecovery.m21358b(c, (CoroutineStackFrame) dVar);
        }
        if (c != null) {
            Result.C3448a aVar = Result.f18741a;
            obj = Result.m21195d(C3450n.m21198a(c));
        } else {
            Result.C3448a aVar2 = Result.f18741a;
            obj = Result.m21195d(e);
        }
        switch (i) {
            case 0:
                dVar.mo27424b(obj);
                return;
            case 1:
                C3497ag.m21427a(dVar, obj);
                return;
            case 2:
                if (dVar != null) {
                    DispatchedContinuation afVar = (DispatchedContinuation) dVar;
                    CoroutineContext a = afVar.mo27423a();
                    Object a2 = ThreadContext.m21375a(a, afVar.f18842b);
                    try {
                        afVar.f18844d.mo27424b(obj);
                        Unit tVar = Unit.f18749a;
                        return;
                    } finally {
                        ThreadContext.m21376b(a, a2);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
                }
            default:
                throw new IllegalStateException(("Invalid mode " + i).toString());
        }
    }

    /* renamed from: a */
    private static final void m21434a(@NotNull DispatchedTask<?> ahVar) {
        C3499am a = C3530bl.f18906a.mo27715a();
        if (a.mo27653g()) {
            a.mo27646a(ahVar);
            return;
        }
        a.mo27647a(true);
        try {
            m21436a(ahVar, ahVar.mo27635h(), 2);
            do {
            } while (a.mo27652f());
        } catch (Throwable th) {
            a.mo27648b(true);
            throw th;
        }
        a.mo27648b(true);
    }
}
