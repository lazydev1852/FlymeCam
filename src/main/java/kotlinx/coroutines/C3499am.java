package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.p111a.ArrayQueue;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0010J\u0010\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0014R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo27294d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.am */
/* compiled from: EventLoop.common.kt */
public abstract class C3499am extends CoroutineDispatcher {

    /* renamed from: b */
    private long f18855b;

    /* renamed from: d */
    private boolean f18856d;

    /* renamed from: e */
    private ArrayQueue<DispatchedTask<?>> f18857e;

    /* renamed from: c */
    private final long m21444c(boolean z) {
        return z ? 4294967296L : 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo27655i() {
    }

    /* renamed from: c */
    public long mo27649c() {
        if (!mo27652f()) {
            return Long.MAX_VALUE;
        }
        return mo27651e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo27650d() {
        return mo27654h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public long mo27651e() {
        ArrayQueue<DispatchedTask<?>> aVar = this.f18857e;
        if (aVar == null || aVar.mo27567a()) {
            return Long.MAX_VALUE;
        }
        return 0;
    }

    /* renamed from: f */
    public final boolean mo27652f() {
        DispatchedTask b;
        ArrayQueue<DispatchedTask<?>> aVar = this.f18857e;
        if (aVar == null || (b = aVar.mo27568b()) == null) {
            return false;
        }
        b.run();
        return true;
    }

    /* renamed from: a */
    public final void mo27646a(@NotNull DispatchedTask<?> ahVar) {
        ArrayQueue<DispatchedTask<?>> aVar = this.f18857e;
        if (aVar == null) {
            aVar = new ArrayQueue<>();
            this.f18857e = aVar;
        }
        aVar.mo27566a(ahVar);
    }

    /* renamed from: g */
    public final boolean mo27653g() {
        return this.f18855b >= m21444c(true);
    }

    /* renamed from: h */
    public final boolean mo27654h() {
        ArrayQueue<DispatchedTask<?>> aVar = this.f18857e;
        if (aVar != null) {
            return aVar.mo27567a();
        }
        return true;
    }

    /* renamed from: a */
    public static /* synthetic */ void m21443a(C3499am amVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            amVar.mo27647a(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    /* renamed from: a */
    public final void mo27647a(boolean z) {
        this.f18855b += m21444c(z);
        if (!z) {
            this.f18856d = true;
        }
    }

    /* renamed from: b */
    public final void mo27648b(boolean z) {
        this.f18855b -= m21444c(z);
        if (this.f18855b <= 0) {
            if (Debug.m21406a()) {
                if (!(this.f18855b == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f18856d) {
                mo27655i();
            }
        }
    }
}
