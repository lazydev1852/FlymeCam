package kotlinx.coroutines.p111a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u000e\u0010\fR\u001a\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0013\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, mo27294d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.c */
/* compiled from: Atomic.kt */
public abstract class C3471c<T> extends C3485j {

    /* renamed from: b */
    private static final AtomicReferenceFieldUpdater f18777b = AtomicReferenceFieldUpdater.newUpdater(C3471c.class, Object.class, "a");

    /* renamed from: a */
    private volatile Object f18778a = Atomic.f18776b;

    /* renamed from: a */
    public long mo27569a() {
        return 0;
    }

    @Nullable
    /* renamed from: a */
    public abstract Object mo27570a(T t);

    /* renamed from: a */
    public abstract void mo27571a(T t, @Nullable Object obj);

    @NotNull
    /* renamed from: b */
    public C3471c<?> mo27573b() {
        return this;
    }

    @Nullable
    /* renamed from: b */
    public final Object mo27572b(@Nullable Object obj) {
        if (Debug.m21406a()) {
            if (!(obj != Atomic.f18776b)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this.f18778a;
        if (obj2 != Atomic.f18776b) {
            return obj2;
        }
        if (f18777b.compareAndSet(this, Atomic.f18776b, obj)) {
            return obj;
        }
        return this.f18778a;
    }

    @Nullable
    /* renamed from: c */
    public final Object mo27574c(@Nullable Object obj) {
        Object obj2 = this.f18778a;
        if (obj2 == Atomic.f18776b) {
            obj2 = mo27572b(mo27570a(obj));
        }
        mo27571a(obj, obj2);
        return obj2;
    }
}
