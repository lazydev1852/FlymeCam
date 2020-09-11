package kotlinx.coroutines;

import kotlin.C3450n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, mo27294d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ad */
public final class DebugStrings {
    @NotNull
    /* renamed from: a */
    public static final String m21410a(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    /* renamed from: a */
    public static final String m21411a(@NotNull Continuation<?> dVar) {
        Object obj;
        if (dVar instanceof DispatchedContinuation) {
            return dVar.toString();
        }
        try {
            Result.C3448a aVar = Result.f18741a;
            obj = Result.m21195d(dVar + '@' + m21410a((Object) dVar));
        } catch (Throwable th) {
            Result.C3448a aVar2 = Result.f18741a;
            obj = Result.m21195d(C3450n.m21198a(th));
        }
        Throwable b = Result.m21193b(obj);
        String str = obj;
        if (b != null) {
            str = dVar.getClass().getName() + '@' + m21410a((Object) dVar);
        }
        return (String) str;
    }

    @NotNull
    /* renamed from: b */
    public static final String m21412b(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }
}
