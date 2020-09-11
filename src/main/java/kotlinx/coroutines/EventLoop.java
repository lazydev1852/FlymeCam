package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlinx.coroutines.C3500an;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004J\b\u0010\r\u001a\u00020\bH\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, mo27294d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ao */
public abstract class EventLoop extends C3499am {
    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: b */
    public abstract Thread mo27630b();

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final void mo27666k() {
        Thread b = mo27630b();
        if (Thread.currentThread() != b) {
            TimeSource a = C3531bn.m21630a();
            if (a != null) {
                a.mo27721a(b);
            } else {
                LockSupport.unpark(b);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo27665b(long j, @NotNull C3500an.C3501a aVar) {
        if (Debug.m21406a()) {
            if (!(this != DefaultExecutor.f18836b)) {
                throw new AssertionError();
            }
        }
        DefaultExecutor.f18836b.mo27656a(j, aVar);
    }
}
