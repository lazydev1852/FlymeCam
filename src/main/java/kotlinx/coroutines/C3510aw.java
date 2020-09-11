package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p107a.C3414b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00010\u0014B8\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012'\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R7\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012¨\u0006\u0013"}, mo27294d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.aw */
/* compiled from: JobSupport.kt */
public final class C3510aw extends C3517ba<C3512ay> {

    /* renamed from: g */
    private static final AtomicIntegerFieldUpdater f18874g = AtomicIntegerFieldUpdater.newUpdater(C3510aw.class, "a");

    /* renamed from: a */
    private volatile int f18875a = 0;

    /* renamed from: h */
    private final C3414b<Throwable, Unit> f18876h;

    /* renamed from: a */
    public /* synthetic */ Object mo27487a(Object obj) {
        mo27669b((Throwable) obj);
        return Unit.f18749a;
    }

    public C3510aw(@NotNull C3512ay ayVar, @NotNull C3414b<? super Throwable, Unit> bVar) {
        super(ayVar);
        this.f18876h = bVar;
    }

    /* renamed from: b */
    public void mo27669b(@Nullable Throwable th) {
        if (f18874g.compareAndSet(this, 0, 1)) {
            this.f18876h.mo27487a(th);
        }
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancelling[" + DebugStrings.m21412b(this) + '@' + DebugStrings.m21410a((Object) this) + ']';
    }
}
