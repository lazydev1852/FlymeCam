package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import kotlinx.coroutines.p111a.C3480g;
import kotlinx.coroutines.p111a.LockFreeLinkedList;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, mo27294d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.bf */
/* compiled from: JobSupport.kt */
public final class C3525bf extends LockFreeLinkedList implements C3508au {
    /* renamed from: b */
    public boolean mo27643b() {
        return true;
    }

    @NotNull
    /* renamed from: p_ */
    public C3525bf mo27644p_() {
        return this;
    }

    @NotNull
    /* renamed from: a */
    public final String mo27710a(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        LockFreeLinkedList eVar = this;
        Object e = eVar.mo27586e();
        if (e != null) {
            boolean z = true;
            for (C3480g gVar = (C3480g) e; !C3443i.m21154a((Object) gVar, (Object) eVar); gVar = gVar.mo27587f()) {
                if (gVar instanceof C3518bb) {
                    C3518bb bbVar = (C3518bb) gVar;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(bbVar);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            C3443i.m21152a((Object) sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @NotNull
    public String toString() {
        return Debug.m21407b() ? mo27710a("Active") : super.toString();
    }
}
