package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0010\u0018\u00002\u00020\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\b¨\u0006\u000e"}, mo27294d2 = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.l */
/* compiled from: CompletedExceptionally.kt */
public class C3542l {

    /* renamed from: c */
    private static final AtomicIntegerFieldUpdater f18929c = AtomicIntegerFieldUpdater.newUpdater(C3542l.class, "b");
    @NotNull
    @JvmField

    /* renamed from: a */
    public final Throwable f18930a;

    /* renamed from: b */
    private volatile int f18931b;

    public C3542l(@NotNull Throwable th, boolean z) {
        this.f18930a = th;
        this.f18931b = z ? 1 : 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C3542l(Throwable th, boolean z, int i, DefaultConstructorMarker gVar) {
        this(th, (i & 2) != 0 ? false : z);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: b */
    public final boolean mo27738b() {
        return this.f18931b;
    }

    /* renamed from: c */
    public final boolean mo27739c() {
        return f18929c.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return DebugStrings.m21412b(this) + '[' + this.f18930a + ']';
    }
}
