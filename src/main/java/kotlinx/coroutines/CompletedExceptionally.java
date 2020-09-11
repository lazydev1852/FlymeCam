package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0000\u0018\u00002\u00020\fB%\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, mo27294d2 = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.g */
public final class CompletedExceptionally extends C3542l {

    /* renamed from: c */
    private static final AtomicIntegerFieldUpdater f18920c = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "b");

    /* renamed from: b */
    private volatile int f18921b;

    /* renamed from: a */
    public final boolean mo27733a() {
        return f18920c.compareAndSet(this, 0, 1);
    }
}
