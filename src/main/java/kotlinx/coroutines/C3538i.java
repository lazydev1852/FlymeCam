package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo27294d2 = {"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.i */
/* compiled from: JobSupport.kt */
public final class C3538i extends C3517ba<C3519bc> implements C3537h {
    @NotNull
    @JvmField

    /* renamed from: a */
    public final C3539j f18922a;

    /* renamed from: a */
    public /* synthetic */ Object mo27487a(Object obj) {
        mo27669b((Throwable) obj);
        return Unit.f18749a;
    }

    public C3538i(@NotNull C3519bc bcVar, @NotNull C3539j jVar) {
        super(bcVar);
        this.f18922a = jVar;
    }

    /* renamed from: b */
    public void mo27669b(@Nullable Throwable th) {
        this.f18922a.mo27683a((C3527bi) this.f18882b);
    }

    /* renamed from: a */
    public boolean mo27711a(@NotNull Throwable th) {
        return ((C3519bc) this.f18882b).mo27685b(th);
    }

    @NotNull
    public String toString() {
        return "ChildHandle[" + this.f18922a + ']';
    }
}
