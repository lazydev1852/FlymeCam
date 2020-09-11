package kotlinx.coroutines.scheduling;

import androidx.appcompat.widget.ActivityChooserView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.p101d.Random;
import kotlin.p102e.C3401d;
import kotlinx.coroutines.C3531bn;
import kotlinx.coroutines.Debug;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.TimeSource;
import kotlinx.coroutines.p111a.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 \\2\u00020`2\u00020a:\u0003\\]^B+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001f\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b \u0010\u0011J\u0015\u0010\"\u001a\b\u0018\u00010!R\u00020\u0000H\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0013H\b¢\u0006\u0004\b$\u0010\u0015J\u0010\u0010%\u001a\u00020\u0001H\b¢\u0006\u0004\b%\u0010\u0017J-\u0010'\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\u001b\u0010*\u001a\u00020\u00132\n\u0010)\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0004H\b¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0001H\b¢\u0006\u0004\b.\u0010\u0017J\u001b\u00100\u001a\u00020\u00012\n\u0010/\u001a\u00060!R\u00020\u0000H\u0002¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\b\u0018\u00010!R\u00020\u0000H\u0002¢\u0006\u0004\b2\u0010#J\u001b\u00105\u001a\u00020\f2\n\u0010/\u001a\u00060!R\u00020\u0000H\u0000¢\u0006\u0004\b3\u00104J+\u0010:\u001a\u00020\u00132\n\u0010/\u001a\u00060!R\u00020\u00002\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u0001H\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020\u0004H\b¢\u0006\u0004\b;\u0010-J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0004¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020\u0013H\u0000¢\u0006\u0004\bD\u0010\u0015J\u000f\u0010F\u001a\u00020\u0006H\u0016¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\fH\b¢\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\fH\u0002¢\u0006\u0004\bL\u0010IJ+\u0010M\u001a\u0004\u0018\u00010\n*\b\u0018\u00010!R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\bM\u0010NR\u0017\u0010\u0010\u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010PR\u0017\u0010 \u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0017R\u0016\u0010S\u001a\u00020R8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020R8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bU\u0010TR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010VR\u0013\u0010W\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010IR\u0016\u0010\u0003\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010PR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010XR\"\u0010Z\u001a\u000e\u0012\n\u0012\b\u0018\u00010!R\u00020\u00000Y8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006_"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* compiled from: CoroutineScheduler.kt */
public final class CoroutineScheduler implements Closeable, Executor {

    /* renamed from: e */
    static final AtomicLongFieldUpdater f18936e = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "d");
    @NotNull
    @JvmField

    /* renamed from: j */
    public static final Symbol f18937j = new Symbol("NOT_IN_STACK");

    /* renamed from: k */
    public static final C3549a f18938k = new C3549a((DefaultConstructorMarker) null);

    /* renamed from: m */
    private static final AtomicLongFieldUpdater f18939m = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, NotifyType.LIGHTS);

    /* renamed from: o */
    private static final AtomicIntegerFieldUpdater f18940o = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "n");
    @NotNull
    @JvmField

    /* renamed from: a */
    public final Tasks f18941a;
    @NotNull
    @JvmField

    /* renamed from: b */
    public final Tasks f18942b;
    @NotNull
    @JvmField

    /* renamed from: c */
    public final AtomicReferenceArray<C3550b> f18943c;

    /* renamed from: d */
    volatile long f18944d;
    @JvmField

    /* renamed from: f */
    public final int f18945f;
    @JvmField

    /* renamed from: g */
    public final int f18946g;
    @JvmField

    /* renamed from: h */
    public final long f18947h;
    @NotNull
    @JvmField

    /* renamed from: i */
    public final String f18948i;

    /* renamed from: l */
    private volatile long f18949l;

    /* renamed from: n */
    private volatile int f18950n;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* compiled from: CoroutineScheduler.kt */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i, int i2, long j, @NotNull String str) {
        this.f18945f = i;
        this.f18946g = i2;
        this.f18947h = j;
        this.f18948i = str;
        if (this.f18945f >= 1) {
            if (this.f18946g >= this.f18945f) {
                if (this.f18946g <= 2097150) {
                    if (this.f18947h > 0) {
                        this.f18941a = new Tasks();
                        this.f18942b = new Tasks();
                        this.f18949l = 0;
                        this.f18943c = new AtomicReferenceArray<>(this.f18946g + 1);
                        this.f18944d = ((long) this.f18945f) << 42;
                        this.f18950n = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + this.f18947h + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + this.f18946g + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + this.f18946g + " should be greater than or equals to core pool size " + this.f18945f).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + this.f18945f + " should be at least 1").toString());
    }

    /* renamed from: a */
    public final boolean mo27749a(@NotNull C3550b bVar) {
        long j;
        long j2;
        int a;
        if (bVar.mo27760b() != f18937j) {
            return false;
        }
        do {
            j = this.f18949l;
            int i = (int) (2097151 & j);
            j2 = (2097152 + j) & -2097152;
            a = bVar.mo27754a();
            if (Debug.m21406a()) {
                if (!(a != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.mo27757a((Object) this.f18943c.get(i));
        } while (!f18939m.compareAndSet(this, j, ((long) a) | j2));
        return true;
    }

    /* renamed from: b */
    private final int m21684b(C3550b bVar) {
        Object b = bVar.mo27760b();
        while (b != f18937j) {
            if (b == null) {
                return 0;
            }
            C3550b bVar2 = (C3550b) b;
            int a = bVar2.mo27754a();
            if (a != 0) {
                return a;
            }
            b = bVar2.mo27760b();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final int m21688d() {
        return (int) (this.f18944d & 2097151);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: a */
    public final boolean mo27748a() {
        return this.f18950n;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$a */
    /* compiled from: CoroutineScheduler.kt */
    public static final class C3549a {
        private C3549a() {
        }

        public /* synthetic */ C3549a(DefaultConstructorMarker gVar) {
            this();
        }
    }

    public void execute(@NotNull Runnable runnable) {
        m21681a(this, runnable, (C3557i) null, false, 6, (Object) null);
    }

    public void close() {
        mo27744a(10000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        if (r9 != null) goto L_0x007d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27744a(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f18940o
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = r8.m21691g()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r3 = r8.f18943c
            monitor-enter(r3)
            long r4 = r8.f18944d     // Catch:{ all -> 0x00be }
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r3)
            if (r2 > r4) goto L_0x0062
            r3 = 1
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r5 = r8.f18943c
            java.lang.Object r5 = r5.get(r3)
            if (r5 != 0) goto L_0x0028
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0028:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r5 = (kotlinx.coroutines.scheduling.CoroutineScheduler.C3550b) r5
            if (r5 == r0) goto L_0x005d
        L_0x002c:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L_0x003c
            r6 = r5
            java.lang.Thread r6 = (java.lang.Thread) r6
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r5.join(r9)
            goto L_0x002c
        L_0x003c:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r5.f18953b
            boolean r7 = kotlinx.coroutines.Debug.m21406a()
            if (r7 == 0) goto L_0x0056
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L_0x004a
            r6 = 1
            goto L_0x004b
        L_0x004a:
            r6 = 0
        L_0x004b:
            if (r6 == 0) goto L_0x004e
            goto L_0x0056
        L_0x004e:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x0056:
            kotlinx.coroutines.scheduling.m r5 = r5.f18952a
            kotlinx.coroutines.scheduling.d r6 = r8.f18942b
            r5.mo27776a((kotlinx.coroutines.scheduling.Tasks) r6)
        L_0x005d:
            if (r3 == r4) goto L_0x0062
            int r3 = r3 + 1
            goto L_0x001d
        L_0x0062:
            kotlinx.coroutines.scheduling.d r9 = r8.f18942b
            r9.mo27594b()
            kotlinx.coroutines.scheduling.d r9 = r8.f18941a
            r9.mo27594b()
        L_0x006c:
            if (r0 == 0) goto L_0x0075
            kotlinx.coroutines.scheduling.h r9 = r0.mo27755a((boolean) r2)
            if (r9 == 0) goto L_0x0075
            goto L_0x007d
        L_0x0075:
            kotlinx.coroutines.scheduling.d r9 = r8.f18941a
            java.lang.Object r9 = r9.mo27595c()
            kotlinx.coroutines.scheduling.h r9 = (kotlinx.coroutines.scheduling.C3556h) r9
        L_0x007d:
            if (r9 == 0) goto L_0x0080
            goto L_0x0088
        L_0x0080:
            kotlinx.coroutines.scheduling.d r9 = r8.f18942b
            java.lang.Object r9 = r9.mo27595c()
            kotlinx.coroutines.scheduling.h r9 = (kotlinx.coroutines.scheduling.C3556h) r9
        L_0x0088:
            if (r9 == 0) goto L_0x008e
            r8.mo27747a((kotlinx.coroutines.scheduling.C3556h) r9)
            goto L_0x006c
        L_0x008e:
            if (r0 == 0) goto L_0x0095
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.mo27758a((kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState) r9)
        L_0x0095:
            boolean r9 = kotlinx.coroutines.Debug.m21406a()
            if (r9 == 0) goto L_0x00b7
            long r9 = r8.f18944d
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r9 = (int) r9
            int r10 = r8.f18945f
            if (r9 != r10) goto L_0x00ac
            r1 = 1
        L_0x00ac:
            if (r1 == 0) goto L_0x00af
            goto L_0x00b7
        L_0x00af:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x00b7:
            r9 = 0
            r8.f18949l = r9
            r8.f18944d = r9
            return
        L_0x00be:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.mo27744a(long):void");
    }

    /* renamed from: a */
    public static /* synthetic */ void m21681a(CoroutineScheduler coroutineScheduler, Runnable runnable, C3557i iVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            iVar = C3555g.f18977a;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.mo27745a(runnable, iVar, z);
    }

    /* renamed from: a */
    public final void mo27745a(@NotNull Runnable runnable, @NotNull C3557i iVar, boolean z) {
        TimeSource a = C3531bn.m21630a();
        if (a != null) {
            a.mo27722b();
        }
        C3556h a2 = mo27743a(runnable, iVar);
        C3550b g = m21691g();
        C3556h a3 = m21680a(g, a2, z);
        if (a3 == null || m21686b(a3)) {
            boolean z2 = z && g != null;
            if (a2.f18980g.mo27767c() != 0) {
                m21682a(z2);
            } else if (!z2) {
                mo27750b();
            }
        } else {
            throw new RejectedExecutionException(this.f18948i + " was terminated");
        }
    }

    @NotNull
    /* renamed from: a */
    public final C3556h mo27743a(@NotNull Runnable runnable, @NotNull C3557i iVar) {
        long a = C3559k.f18987f.mo27770a();
        if (!(runnable instanceof C3556h)) {
            return new C3558j(runnable, a, iVar);
        }
        C3556h hVar = (C3556h) runnable;
        hVar.f18979f = a;
        hVar.f18980g = iVar;
        return hVar;
    }

    /* renamed from: b */
    public final void mo27750b() {
        if (!m21689e() && !m21683a(this, 0, 1, (Object) null)) {
            m21689e();
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m21683a(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coroutineScheduler.f18944d;
        }
        return coroutineScheduler.m21685b(j);
    }

    /* renamed from: b */
    private final boolean m21685b(long j) {
        if (C3401d.m21100c(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f18945f) {
            int f = m21690f();
            if (f == 1 && this.f18945f > 1) {
                m21690f();
            }
            if (f > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private final boolean m21689e() {
        C3550b c;
        do {
            c = m21687c();
            if (c == null) {
                return false;
            }
        } while (!C3550b.f18951d.compareAndSet(c, -1, 0));
        LockSupport.unpark(c);
        return true;
    }

    /* renamed from: f */
    private final int m21690f() {
        synchronized (this.f18943c) {
            if (mo27748a()) {
                return -1;
            }
            long j = this.f18944d;
            int i = (int) (j & 2097151);
            boolean z = false;
            int c = C3401d.m21100c(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (c >= this.f18945f) {
                return 0;
            }
            if (i >= this.f18946g) {
                return 0;
            }
            int i2 = ((int) (this.f18944d & 2097151)) + 1;
            if (i2 > 0 && this.f18943c.get(i2) == null) {
                C3550b bVar = new C3550b(this, i2);
                this.f18943c.set(i2, bVar);
                if (i2 == ((int) (2097151 & f18936e.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    bVar.start();
                    int i3 = c + 1;
                    return i3;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* renamed from: a */
    private final C3556h m21680a(@Nullable C3550b bVar, C3556h hVar, boolean z) {
        if (bVar == null || bVar.f18953b == WorkerState.TERMINATED) {
            return hVar;
        }
        if (hVar.f18980g.mo27767c() == 0 && bVar.f18953b == WorkerState.BLOCKING) {
            return hVar;
        }
        bVar.f18955e = true;
        return bVar.f18952a.mo27775a(hVar, z);
    }

    /* renamed from: g */
    private final C3550b m21691g() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof C3550b)) {
            currentThread = null;
        }
        C3550b bVar = (C3550b) currentThread;
        if (bVar == null || !C3443i.m21154a((Object) CoroutineScheduler.this, (Object) this)) {
            return null;
        }
        return bVar;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f18943c.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            C3550b bVar = this.f18943c.get(i6);
            if (bVar != null) {
                int b = bVar.f18952a.mo27777b();
                switch (C3551a.f18962a[bVar.f18953b.ordinal()]) {
                    case 1:
                        i3++;
                        break;
                    case 2:
                        i2++;
                        arrayList.add(String.valueOf(b) + "b");
                        break;
                    case 3:
                        i++;
                        arrayList.add(String.valueOf(b) + "c");
                        break;
                    case 4:
                        i4++;
                        if (b <= 0) {
                            break;
                        } else {
                            arrayList.add(String.valueOf(b) + "d");
                            break;
                        }
                    case 5:
                        i5++;
                        break;
                }
            }
        }
        long j = this.f18944d;
        return this.f18948i + '@' + DebugStrings.m21410a((Object) this) + '[' + "Pool Size {" + "core = " + this.f18945f + ", " + "max = " + this.f18946g + "}, " + "Worker States {" + "CPU = " + i + ", " + "blocking = " + i2 + ", " + "parked = " + i3 + ", " + "dormant = " + i4 + ", " + "terminated = " + i5 + "}, " + "running workers queues = " + arrayList + ", " + "global CPU queue size = " + this.f18941a.mo27592a() + ", " + "global blocking queue size = " + this.f18942b.mo27592a() + ", " + "Control State {" + "created workers= " + ((int) (2097151 & j)) + ", " + "blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", " + "CPUs acquired = " + (this.f18945f - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    /* renamed from: a */
    public final void mo27747a(@NotNull C3556h hVar) {
        TimeSource a;
        try {
            hVar.run();
            a = C3531bn.m21630a();
            if (a == null) {
                return;
            }
        } catch (Throwable th) {
            TimeSource a2 = C3531bn.m21630a();
            if (a2 != null) {
                a2.mo27723c();
            }
            throw th;
        }
        a.mo27723c();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0004\u0018\u00002\u00020IB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u001dJ\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u001dJ\u000f\u0010\"\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010\u0017J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u001dJ\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u001dR*\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\tR\u0016\u00102\u001a\u0002018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010-R\u0014\u0010D\u001a\u00020A8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00108¨\u0006H"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$b */
    /* compiled from: CoroutineScheduler.kt */
    public final class C3550b extends Thread {

        /* renamed from: d */
        static final AtomicIntegerFieldUpdater f18951d = AtomicIntegerFieldUpdater.newUpdater(C3550b.class, "c");
        @NotNull
        @JvmField

        /* renamed from: a */
        public final WorkQueue f18952a;
        @NotNull
        @JvmField

        /* renamed from: b */
        public WorkerState f18953b;
        @NotNull

        /* renamed from: c */
        volatile int f18954c;
        @JvmField

        /* renamed from: e */
        public boolean f18955e;

        /* renamed from: g */
        private volatile int f18957g;

        /* renamed from: h */
        private long f18958h;
        @Nullable

        /* renamed from: i */
        private volatile Object f18959i;

        /* renamed from: j */
        private long f18960j;

        /* renamed from: k */
        private int f18961k;

        private C3550b() {
            setDaemon(true);
            this.f18952a = new WorkQueue();
            this.f18953b = WorkerState.DORMANT;
            this.f18954c = 0;
            this.f18959i = CoroutineScheduler.f18937j;
            this.f18961k = Random.f18692b.mo27452b();
        }

        /* renamed from: a */
        public final int mo27754a() {
            return this.f18957g;
        }

        /* renamed from: a */
        public final void mo27756a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f18948i);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.f18957g = i;
        }

        public C3550b(CoroutineScheduler coroutineScheduler, int i) {
            this();
            mo27756a(i);
        }

        /* renamed from: a */
        public final void mo27757a(@Nullable Object obj) {
            this.f18959i = obj;
        }

        @Nullable
        /* renamed from: b */
        public final Object mo27760b() {
            return this.f18959i;
        }

        /* renamed from: c */
        private final boolean m21704c() {
            boolean z;
            if (this.f18953b == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            while (true) {
                long j = coroutineScheduler.f18944d;
                if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                    if (CoroutineScheduler.f18936e.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.f18953b = WorkerState.CPU_ACQUIRED;
            return true;
        }

        /* renamed from: a */
        public final boolean mo27758a(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.f18953b;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.f18936e.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f18953b = workerState;
            }
            return z;
        }

        public void run() {
            m21705d();
        }

        /* renamed from: d */
        private final void m21705d() {
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.mo27748a() && this.f18953b != WorkerState.TERMINATED) {
                    C3556h a = mo27755a(this.f18955e);
                    if (a != null) {
                        this.f18960j = 0;
                        m21700a(a);
                    } else {
                        this.f18955e = false;
                        if (this.f18960j == 0) {
                            m21707e();
                        } else if (!z) {
                            z = true;
                        } else {
                            mo27758a(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f18960j);
                            this.f18960j = 0;
                        }
                    }
                }
            }
            mo27758a(WorkerState.TERMINATED);
        }

        /* renamed from: e */
        private final void m21707e() {
            if (!m21709f()) {
                CoroutineScheduler.this.mo27749a(this);
                return;
            }
            if (Debug.m21406a()) {
                if (!(this.f18952a.mo27777b() == 0)) {
                    throw new AssertionError();
                }
            }
            this.f18954c = -1;
            while (m21709f() && !CoroutineScheduler.this.mo27748a() && this.f18953b != WorkerState.TERMINATED) {
                mo27758a(WorkerState.PARKING);
                Thread.interrupted();
                m21710g();
            }
        }

        /* renamed from: f */
        private final boolean m21709f() {
            return this.f18959i != CoroutineScheduler.f18937j;
        }

        /* renamed from: c */
        private final void m21703c(int i) {
            if (i != 0 && mo27758a(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.mo27750b();
            }
        }

        /* renamed from: d */
        private final void m21706d(int i) {
            if (i != 0) {
                CoroutineScheduler.f18936e.addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState workerState = this.f18953b;
                if (workerState != WorkerState.TERMINATED) {
                    if (Debug.m21406a()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.f18953b = WorkerState.DORMANT;
                }
            }
        }

        /* renamed from: b */
        public final int mo27759b(int i) {
            int i2 = this.f18961k;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f18961k = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % i;
        }

        /* renamed from: g */
        private final void m21710g() {
            if (this.f18958h == 0) {
                this.f18958h = System.nanoTime() + CoroutineScheduler.this.f18947h;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f18947h);
            if (System.nanoTime() - this.f18958h >= 0) {
                this.f18958h = 0;
                m21711h();
            }
        }

        /* renamed from: h */
        private final void m21711h() {
            synchronized (CoroutineScheduler.this.f18943c) {
                if (!CoroutineScheduler.this.mo27748a()) {
                    if (CoroutineScheduler.this.m21688d() > CoroutineScheduler.this.f18945f) {
                        if (f18951d.compareAndSet(this, -1, 1)) {
                            int i = this.f18957g;
                            mo27756a(0);
                            CoroutineScheduler.this.mo27746a(this, i, 0);
                            int andDecrement = (int) (CoroutineScheduler.f18936e.getAndDecrement(CoroutineScheduler.this) & 2097151);
                            if (andDecrement != i) {
                                C3550b bVar = CoroutineScheduler.this.f18943c.get(andDecrement);
                                if (bVar == null) {
                                    C3443i.m21151a();
                                }
                                C3550b bVar2 = bVar;
                                CoroutineScheduler.this.f18943c.set(i, bVar2);
                                bVar2.mo27756a(i);
                                CoroutineScheduler.this.mo27746a(bVar2, andDecrement, i);
                            }
                            CoroutineScheduler.this.f18943c.set(andDecrement, (Object) null);
                            Unit tVar = Unit.f18749a;
                            this.f18953b = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        /* renamed from: e */
        private final void m21708e(int i) {
            this.f18958h = 0;
            if (this.f18953b == WorkerState.PARKING) {
                if (Debug.m21406a()) {
                    boolean z = true;
                    if (i != 1) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                this.f18953b = WorkerState.BLOCKING;
            }
        }

        @Nullable
        /* renamed from: a */
        public final C3556h mo27755a(boolean z) {
            C3556h hVar;
            if (m21704c()) {
                return m21701b(z);
            }
            if (z) {
                hVar = this.f18952a.mo27779c();
                if (hVar == null) {
                    hVar = (C3556h) CoroutineScheduler.this.f18942b.mo27595c();
                }
            } else {
                hVar = (C3556h) CoroutineScheduler.this.f18942b.mo27595c();
            }
            return hVar != null ? hVar : m21702c(true);
        }

        /* renamed from: b */
        private final C3556h m21701b(boolean z) {
            C3556h i;
            C3556h i2;
            if (z) {
                boolean z2 = mo27759b(CoroutineScheduler.this.f18945f * 2) == 0;
                if (z2 && (i2 = m21712i()) != null) {
                    return i2;
                }
                C3556h c = this.f18952a.mo27779c();
                if (c != null) {
                    return c;
                }
                if (!z2 && (i = m21712i()) != null) {
                    return i;
                }
            } else {
                C3556h i3 = m21712i();
                if (i3 != null) {
                    return i3;
                }
            }
            return m21702c(false);
        }

        /* renamed from: i */
        private final C3556h m21712i() {
            if (mo27759b(2) == 0) {
                C3556h hVar = (C3556h) CoroutineScheduler.this.f18941a.mo27595c();
                if (hVar != null) {
                    return hVar;
                }
                return (C3556h) CoroutineScheduler.this.f18942b.mo27595c();
            }
            C3556h hVar2 = (C3556h) CoroutineScheduler.this.f18942b.mo27595c();
            if (hVar2 != null) {
                return hVar2;
            }
            return (C3556h) CoroutineScheduler.this.f18941a.mo27595c();
        }

        /* renamed from: c */
        private final C3556h m21702c(boolean z) {
            long a;
            int i = 1;
            if (Debug.m21406a()) {
                if (!(this.f18952a.mo27777b() == 0)) {
                    throw new AssertionError();
                }
            }
            int a2 = CoroutineScheduler.this.m21688d();
            if (a2 < 2) {
                return null;
            }
            int b = mo27759b(a2);
            long j = Long.MAX_VALUE;
            int i2 = 0;
            while (i2 < a2) {
                b += i;
                if (b > a2) {
                    b = 1;
                }
                C3550b bVar = CoroutineScheduler.this.f18943c.get(b);
                if (!(bVar == null || bVar == this)) {
                    if (Debug.m21406a()) {
                        if (!(this.f18952a.mo27777b() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        a = this.f18952a.mo27778b(bVar.f18952a);
                    } else {
                        a = this.f18952a.mo27774a(bVar.f18952a);
                    }
                    long j2 = a;
                    if (j2 == -1) {
                        return this.f18952a.mo27779c();
                    }
                    if (j2 > 0) {
                        j = Math.min(j, j2);
                    }
                }
                i2++;
                i = 1;
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.f18960j = j;
            return null;
        }

        /* renamed from: a */
        private final void m21700a(C3556h hVar) {
            int c = hVar.f18980g.mo27767c();
            m21708e(c);
            m21703c(c);
            CoroutineScheduler.this.mo27747a(hVar);
            m21706d(c);
        }
    }

    /* renamed from: b */
    private final boolean m21686b(C3556h hVar) {
        boolean z = true;
        if (hVar.f18980g.mo27767c() != 1) {
            z = false;
        }
        if (z) {
            return this.f18942b.mo27593a(hVar);
        }
        return this.f18941a.mo27593a(hVar);
    }

    /* renamed from: a */
    public final void mo27746a(@NotNull C3550b bVar, int i, int i2) {
        while (true) {
            long j = this.f18949l;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & -2097152;
            if (i3 == i) {
                i3 = i2 == 0 ? m21684b(bVar) : i2;
            }
            if (i3 >= 0) {
                if (f18939m.compareAndSet(this, j, j2 | ((long) i3))) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private final C3550b m21687c() {
        while (true) {
            long j = this.f18949l;
            C3550b bVar = this.f18943c.get((int) (2097151 & j));
            if (bVar == null) {
                return null;
            }
            long j2 = (2097152 + j) & -2097152;
            int b = m21684b(bVar);
            if (b >= 0) {
                if (f18939m.compareAndSet(this, j, ((long) b) | j2)) {
                    bVar.mo27757a((Object) f18937j);
                    return bVar;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m21682a(boolean z) {
        long addAndGet = f18936e.addAndGet(this, 2097152);
        if (!z && !m21689e() && !m21685b(addAndGet)) {
            m21689e();
        }
    }
}
