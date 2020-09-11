package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.p108b.C3443i;
import kotlin.p102e.C3401d;
import kotlinx.coroutines.p111a.C3482i;
import kotlinx.coroutines.p111a.C3493s;
import kotlinx.coroutines.p111a.ThreadSafeHeap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00118T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0016\u00103\u001a\u00020\u00148T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, mo27294d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.an */
/* compiled from: EventLoop.common.kt */
public abstract class C3500an extends EventLoop {

    /* renamed from: d */
    private static final AtomicReferenceFieldUpdater f18858d = AtomicReferenceFieldUpdater.newUpdater(C3500an.class, Object.class, "b");

    /* renamed from: f */
    private static final AtomicReferenceFieldUpdater f18859f = AtomicReferenceFieldUpdater.newUpdater(C3500an.class, Object.class, "e");

    /* renamed from: b */
    private volatile Object f18860b = null;

    /* renamed from: e */
    private volatile Object f18861e = null;

    /* renamed from: g */
    private volatile int f18862g = 0;

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    /* access modifiers changed from: private */
    /* renamed from: l */
    public final boolean m21460l() {
        return this.f18862g;
    }

    /* renamed from: c */
    private final void m21459c(boolean z) {
        this.f18862g = z ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo27650d() {
        if (!mo27654h()) {
            return false;
        }
        C3502b bVar = (C3502b) this.f18861e;
        if (bVar != null && !bVar.mo27618b()) {
            return false;
        }
        Object obj = this.f18860b;
        if (obj != null) {
            if (obj instanceof C3482i) {
                return ((C3482i) obj).mo27597a();
            }
            if (obj == C3504aq.f18868b) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public long mo27651e() {
        C3501a aVar;
        if (super.mo27651e() == 0) {
            return 0;
        }
        Object obj = this.f18860b;
        if (obj != null) {
            if (obj instanceof C3482i) {
                if (!((C3482i) obj).mo27597a()) {
                    return 0;
                }
            } else if (obj == C3504aq.f18868b) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        C3502b bVar = (C3502b) this.f18861e;
        if (bVar == null || (aVar = (C3501a) bVar.mo27619c()) == null) {
            return Long.MAX_VALUE;
        }
        long j = aVar.f18863a;
        TimeSource a = C3531bn.m21630a();
        return C3401d.m21096a(j - (a != null ? a.mo27718a() : System.nanoTime()), 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo27655i() {
        C3530bl.f18906a.mo27717b();
        m21459c(true);
        m21462n();
        do {
        } while (mo27649c() <= 0);
        m21463o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005a  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo27649c() {
        /*
            r8 = this;
            boolean r0 = r8.mo27652f()
            if (r0 == 0) goto L_0x000b
            long r0 = r8.mo27651e()
            return r0
        L_0x000b:
            java.lang.Object r0 = r8.f18861e
            kotlinx.coroutines.an$b r0 = (kotlinx.coroutines.C3500an.C3502b) r0
            if (r0 == 0) goto L_0x0054
            boolean r1 = r0.mo27618b()
            if (r1 != 0) goto L_0x0054
            kotlinx.coroutines.bm r1 = kotlinx.coroutines.C3531bn.m21630a()
            if (r1 == 0) goto L_0x0022
            long r1 = r1.mo27718a()
            goto L_0x0026
        L_0x0022:
            long r1 = java.lang.System.nanoTime()
        L_0x0026:
            r3 = r0
            kotlinx.coroutines.a.r r3 = (kotlinx.coroutines.p111a.ThreadSafeHeap) r3
            monitor-enter(r3)
            kotlinx.coroutines.a.s r4 = r3.mo27621e()     // Catch:{ all -> 0x0051 }
            r5 = 0
            if (r4 == 0) goto L_0x004b
            kotlinx.coroutines.an$a r4 = (kotlinx.coroutines.C3500an.C3501a) r4     // Catch:{ all -> 0x0051 }
            boolean r6 = r4.mo27662a((long) r1)     // Catch:{ all -> 0x0051 }
            r7 = 0
            if (r6 == 0) goto L_0x0041
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch:{ all -> 0x0051 }
            boolean r4 = r8.m21457b(r4)     // Catch:{ all -> 0x0051 }
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r4 == 0) goto L_0x0049
            kotlinx.coroutines.a.s r4 = r3.mo27615a((int) r7)     // Catch:{ all -> 0x0051 }
            r5 = r4
        L_0x0049:
            monitor-exit(r3)
            goto L_0x004c
        L_0x004b:
            monitor-exit(r3)
        L_0x004c:
            kotlinx.coroutines.an$a r5 = (kotlinx.coroutines.C3500an.C3501a) r5
            if (r5 == 0) goto L_0x0054
            goto L_0x0026
        L_0x0051:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0054:
            java.lang.Runnable r0 = r8.m21461m()
            if (r0 == 0) goto L_0x005d
            r0.run()
        L_0x005d:
            long r0 = r8.mo27651e()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C3500an.mo27649c():long");
    }

    /* renamed from: a */
    public final void mo27658a(@NotNull CoroutineContext gVar, @NotNull Runnable runnable) {
        mo27657a(runnable);
    }

    /* renamed from: a */
    public final void mo27657a(@NotNull Runnable runnable) {
        if (m21457b(runnable)) {
            mo27666k();
        } else {
            DefaultExecutor.f18836b.mo27657a(runnable);
        }
    }

    /* renamed from: n */
    private final void m21462n() {
        if (!Debug.m21406a() || m21460l()) {
            while (true) {
                Object obj = this.f18860b;
                if (obj == null) {
                    if (f18858d.compareAndSet(this, (Object) null, C3504aq.f18868b)) {
                        return;
                    }
                } else if (obj instanceof C3482i) {
                    ((C3482i) obj).mo27599c();
                    return;
                } else if (obj != C3504aq.f18868b) {
                    C3482i iVar = new C3482i(8, true);
                    if (obj != null) {
                        iVar.mo27596a((Runnable) obj);
                        if (f18858d.compareAndSet(this, obj, iVar)) {
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final void mo27656a(long j, @NotNull C3501a aVar) {
        switch (m21458c(j, aVar)) {
            case 0:
                if (m21455a(aVar)) {
                    mo27666k();
                    return;
                }
                return;
            case 1:
                mo27665b(j, aVar);
                return;
            case 2:
                return;
            default:
                throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* renamed from: a */
    private final boolean m21455a(C3501a aVar) {
        C3502b bVar = (C3502b) this.f18861e;
        return (bVar != null ? (C3501a) bVar.mo27619c() : null) == aVar;
    }

    /* renamed from: c */
    private final int m21458c(long j, C3501a aVar) {
        if (m21460l()) {
            return 1;
        }
        C3502b bVar = (C3502b) this.f18861e;
        if (bVar == null) {
            C3500an anVar = this;
            f18859f.compareAndSet(anVar, (Object) null, new C3502b(j));
            Object obj = anVar.f18861e;
            if (obj == null) {
                C3443i.m21151a();
            }
            bVar = (C3502b) obj;
        }
        return aVar.mo27660a(j, bVar, this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo27659j() {
        this.f18860b = null;
        this.f18861e = null;
    }

    /* renamed from: o */
    private final void m21463o() {
        C3501a aVar;
        TimeSource a = C3531bn.m21630a();
        long a2 = a != null ? a.mo27718a() : System.nanoTime();
        while (true) {
            C3502b bVar = (C3502b) this.f18861e;
            if (bVar != null && (aVar = (C3501a) bVar.mo27620d()) != null) {
                mo27665b(a2, aVar);
            } else {
                return;
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo27294d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.an$a */
    /* compiled from: EventLoop.common.kt */
    public static abstract class C3501a implements Comparable<C3501a>, Runnable, C3493s, Job {
        @JvmField

        /* renamed from: a */
        public long f18863a;

        /* renamed from: b */
        private Object f18864b;

        /* renamed from: c */
        private int f18865c;

        @Nullable
        /* renamed from: b */
        public ThreadSafeHeap<?> mo27624b() {
            Object obj = this.f18864b;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        /* renamed from: a */
        public void mo27623a(@Nullable ThreadSafeHeap<?> rVar) {
            if (this.f18864b != C3504aq.f18867a) {
                this.f18864b = rVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* renamed from: a */
        public void mo27622a(int i) {
            this.f18865c = i;
        }

        /* renamed from: c */
        public int mo27625c() {
            return this.f18865c;
        }

        /* renamed from: a */
        public int compareTo(@NotNull C3501a aVar) {
            int i = ((this.f18863a - aVar.f18863a) > 0 ? 1 : ((this.f18863a - aVar.f18863a) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        /* renamed from: a */
        public final boolean mo27662a(long j) {
            return j - this.f18863a >= 0;
        }

        /* renamed from: a */
        public final synchronized int mo27660a(long j, @NotNull C3502b bVar, @NotNull C3500an anVar) {
            if (this.f18864b == C3504aq.f18867a) {
                return 2;
            }
            ThreadSafeHeap rVar = bVar;
            C3493s sVar = this;
            synchronized (rVar) {
                C3501a aVar = (C3501a) rVar.mo27621e();
                if (anVar.m21460l()) {
                    return 1;
                }
                if (aVar == null) {
                    bVar.f18866a = j;
                } else {
                    long j2 = aVar.f18863a;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - bVar.f18866a > 0) {
                        bVar.f18866a = j;
                    }
                }
                if (this.f18863a - bVar.f18866a < 0) {
                    this.f18863a = bVar.f18866a;
                }
                rVar.mo27617b(sVar);
                return 0;
            }
        }

        /* renamed from: a */
        public final synchronized void mo27642a() {
            Object obj = this.f18864b;
            if (obj != C3504aq.f18867a) {
                if (!(obj instanceof C3502b)) {
                    obj = null;
                }
                C3502b bVar = (C3502b) obj;
                if (bVar != null) {
                    bVar.mo27616a(this);
                }
                this.f18864b = C3504aq.f18867a;
            }
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.f18863a + ']';
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo27294d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.an$b */
    /* compiled from: EventLoop.common.kt */
    public static final class C3502b extends ThreadSafeHeap<C3501a> {
        @JvmField

        /* renamed from: a */
        public long f18866a;

        public C3502b(long j) {
            this.f18866a = j;
        }
    }

    /* renamed from: b */
    private final boolean m21457b(Runnable runnable) {
        while (true) {
            Object obj = this.f18860b;
            if (m21460l()) {
                return false;
            }
            if (obj == null) {
                if (f18858d.compareAndSet(this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C3482i) {
                if (obj != null) {
                    C3482i iVar = (C3482i) obj;
                    switch (iVar.mo27596a(runnable)) {
                        case 0:
                            return true;
                        case 1:
                            f18858d.compareAndSet(this, obj, iVar.mo27601e());
                            break;
                        case 2:
                            return false;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == C3504aq.f18868b) {
                return false;
            } else {
                C3482i iVar2 = new C3482i(8, true);
                if (obj != null) {
                    iVar2.mo27596a((Runnable) obj);
                    iVar2.mo27596a(runnable);
                    if (f18858d.compareAndSet(this, obj, iVar2)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    /* renamed from: m */
    private final Runnable m21461m() {
        while (true) {
            Object obj = this.f18860b;
            if (obj == null) {
                return null;
            }
            if (obj instanceof C3482i) {
                if (obj != null) {
                    C3482i iVar = (C3482i) obj;
                    Object d = iVar.mo27600d();
                    if (d != C3482i.f18800a) {
                        return (Runnable) d;
                    }
                    f18858d.compareAndSet(this, obj, iVar.mo27601e());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == C3504aq.f18868b) {
                return null;
            } else {
                if (f18858d.compareAndSet(this, obj, (Object) null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }
}
