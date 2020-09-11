package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Executors;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020,2\u00020-2\u00020 B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\u00020\b2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0011\u0010\u0015J#\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u001b\u0010\u0018\u001a\u00020\b2\n\u0010\u0017\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R \u0010(\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b*\u0010&¨\u0006+"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.scheduling.e */
/* compiled from: Dispatcher.kt */
public final class C3553e extends Executors implements Executor, C3557i {

    /* renamed from: f */
    private static final AtomicIntegerFieldUpdater f18970f = AtomicIntegerFieldUpdater.newUpdater(C3553e.class, "e");

    /* renamed from: b */
    private final ConcurrentLinkedQueue<Runnable> f18971b = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    private volatile int f18972e = 0;
    @NotNull

    /* renamed from: g */
    private final C3552c f18973g;

    /* renamed from: h */
    private final int f18974h;

    /* renamed from: i */
    private final int f18975i;

    /* renamed from: c */
    public int mo27767c() {
        return this.f18975i;
    }

    public C3553e(@NotNull C3552c cVar, int i, int i2) {
        this.f18973g = cVar;
        this.f18974h = i;
        this.f18975i = i2;
    }

    public void execute(@NotNull Runnable runnable) {
        m21725a(runnable, false);
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    /* renamed from: a */
    public void mo27658a(@NotNull CoroutineContext gVar, @NotNull Runnable runnable) {
        m21725a(runnable, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0013  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m21725a(java.lang.Runnable r3, boolean r4) {
        /*
            r2 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f18970f
            int r0 = r0.incrementAndGet(r2)
            int r1 = r2.f18974h
            if (r0 > r1) goto L_0x0013
            kotlinx.coroutines.scheduling.c r0 = r2.f18973g
            r1 = r2
            kotlinx.coroutines.scheduling.i r1 = (kotlinx.coroutines.scheduling.C3557i) r1
            r0.mo27765a(r3, r1, r4)
            return
        L_0x0013:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = r2.f18971b
            r0.add(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = f18970f
            int r3 = r3.decrementAndGet(r2)
            int r0 = r2.f18974h
            if (r3 < r0) goto L_0x0023
            return
        L_0x0023:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r3 = r2.f18971b
            java.lang.Object r3 = r3.poll()
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            if (r3 == 0) goto L_0x002e
            goto L_0x0000
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.C3553e.m21725a(java.lang.Runnable, boolean):void");
    }

    @NotNull
    public String toString() {
        return super.toString() + "[dispatcher = " + this.f18973g + ']';
    }

    /* renamed from: b */
    public void mo27766b() {
        Runnable poll = this.f18971b.poll();
        if (poll != null) {
            this.f18973g.mo27765a(poll, this, true);
            return;
        }
        f18970f.decrementAndGet(this);
        Runnable poll2 = this.f18971b.poll();
        if (poll2 != null) {
            m21725a(poll2, true);
        }
    }
}
