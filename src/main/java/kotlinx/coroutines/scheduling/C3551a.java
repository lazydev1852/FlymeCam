package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.scheduling.a */
public final /* synthetic */ class C3551a {

    /* renamed from: a */
    public static final /* synthetic */ int[] f18962a = new int[CoroutineScheduler.WorkerState.values().length];

    static {
        f18962a[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
        f18962a[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
        f18962a[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
        f18962a[CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;
        f18962a[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
    }
}
