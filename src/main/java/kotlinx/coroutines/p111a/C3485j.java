package kotlinx.coroutines.p111a;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStrings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\f\u001a\u00020\rH\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, mo27294d2 = {"Lkotlinx/coroutines/internal/OpDescriptor;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "isEarlierThan", "", "that", "perform", "affected", "toString", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.j */
/* compiled from: Atomic.kt */
public abstract class C3485j {
    @Nullable
    /* renamed from: b */
    public abstract C3471c<?> mo27573b();

    @Nullable
    /* renamed from: c */
    public abstract Object mo27574c(@Nullable Object obj);

    @NotNull
    public String toString() {
        return DebugStrings.m21412b(this) + '@' + DebugStrings.m21410a((Object) this);
    }

    /* renamed from: a */
    public final boolean mo27606a(@NotNull C3485j jVar) {
        C3471c<?> b;
        C3471c<?> b2 = mo27573b();
        if (b2 == null || (b = jVar.mo27573b()) == null || b2.mo27569a() >= b.mo27569a()) {
            return false;
        }
        return true;
    }
}
