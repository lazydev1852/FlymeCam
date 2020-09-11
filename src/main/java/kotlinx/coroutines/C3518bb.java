package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.C3512ay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b \u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u0006\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, mo27294d2 = {"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.bb */
/* compiled from: JobSupport.kt */
public abstract class C3518bb<J extends C3512ay> extends CompletionHandler implements Job, C3508au {
    @NotNull
    @JvmField

    /* renamed from: b */
    public final J f18882b;

    /* renamed from: b */
    public boolean mo27643b() {
        return true;
    }

    @Nullable
    /* renamed from: p_ */
    public C3525bf mo27644p_() {
        return null;
    }

    public C3518bb(@NotNull J j) {
        this.f18882b = j;
    }

    /* renamed from: a */
    public void mo27642a() {
        J j = this.f18882b;
        if (j != null) {
            ((C3519bc) j).mo27682a((C3518bb<?>) this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
}
