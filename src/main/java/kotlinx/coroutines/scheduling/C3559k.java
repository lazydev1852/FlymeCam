package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.p102e.C3401d;
import kotlinx.coroutines.p111a.C3487n;
import kotlinx.coroutines.p111a.C3488p;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\r\u001a\u00020\u000e*\u00020\u000f8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010¨\u0006\u0011"}, mo27294d2 = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.scheduling.k */
/* compiled from: Tasks.kt */
public final class C3559k {
    @JvmField

    /* renamed from: a */
    public static final long f18982a = C3488p.m21372a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);
    @JvmField

    /* renamed from: b */
    public static final int f18983b = C3488p.m21370a("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
    @JvmField

    /* renamed from: c */
    public static final int f18984c = C3488p.m21370a("kotlinx.coroutines.scheduler.core.pool.size", C3401d.m21100c(C3487n.m21360a(), 2), 1, 0, 8, (Object) null);
    @JvmField

    /* renamed from: d */
    public static final int f18985d = C3488p.m21370a("kotlinx.coroutines.scheduler.max.pool.size", C3401d.m21095a(C3487n.m21360a() * 128, f18984c, 2097150), 0, 2097150, 4, (Object) null);
    @JvmField

    /* renamed from: e */
    public static final long f18986e = TimeUnit.SECONDS.toNanos(C3488p.m21372a("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));
    @NotNull
    @JvmField

    /* renamed from: f */
    public static C3560l f18987f = C3554f.f18976a;
}
