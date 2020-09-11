package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.p102e.C3401d;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.p111a.C3487n;
import kotlinx.coroutines.p111a.C3488p;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.scheduling.b */
public final class Dispatcher extends C3552c {

    /* renamed from: b */
    public static final Dispatcher f18963b;
    @NotNull

    /* renamed from: e */
    private static final CoroutineDispatcher f18964e;

    @NotNull
    public String toString() {
        return "DefaultDispatcher";
    }

    static {
        Dispatcher bVar = new Dispatcher();
        f18963b = bVar;
        f18964e = bVar.mo27764a(C3488p.m21370a("kotlinx.coroutines.io.parallelism", C3401d.m21100c(64, C3487n.m21360a()), 0, 0, 12, (Object) null));
    }

    private Dispatcher() {
        super(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: b */
    public final CoroutineDispatcher mo27762b() {
        return f18964e;
    }

    public void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }
}
