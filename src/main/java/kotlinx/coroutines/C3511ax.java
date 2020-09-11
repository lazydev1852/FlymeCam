package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p107a.C3414b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012'\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R/\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo27294d2 = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ax */
/* compiled from: JobSupport.kt */
public final class C3511ax extends C3518bb<C3512ay> {

    /* renamed from: a */
    private final C3414b<Throwable, Unit> f18877a;

    /* renamed from: a */
    public /* synthetic */ Object mo27487a(Object obj) {
        mo27669b((Throwable) obj);
        return Unit.f18749a;
    }

    public C3511ax(@NotNull C3512ay ayVar, @NotNull C3414b<? super Throwable, Unit> bVar) {
        super(ayVar);
        this.f18877a = bVar;
    }

    /* renamed from: b */
    public void mo27669b(@Nullable Throwable th) {
        this.f18877a.mo27487a(th);
    }

    @NotNull
    public String toString() {
        return "InvokeOnCompletion[" + DebugStrings.m21412b(this) + '@' + DebugStrings.m21410a((Object) this) + ']';
    }
}
