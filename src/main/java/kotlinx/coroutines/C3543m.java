package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlinx.coroutines.p111a.StackTraceRecovery;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a.\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo27294d2 = {"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.m */
/* compiled from: CompletedExceptionally.kt */
public final class C3543m {
    @Nullable
    /* renamed from: a */
    public static final <T> Object m21672a(@NotNull Object obj) {
        Throwable b = Result.m21193b(obj);
        return b == null ? obj : new C3542l(b, false, 2, (DefaultConstructorMarker) null);
    }

    @Nullable
    /* renamed from: a */
    public static final <T> Object m21673a(@NotNull Object obj, @NotNull CancellableContinuation<?> eVar) {
        Throwable b = Result.m21193b(obj);
        if (b == null) {
            return obj;
        }
        Continuation dVar = eVar;
        if (Debug.m21408c() && (dVar instanceof CoroutineStackFrame)) {
            b = StackTraceRecovery.m21358b(b, (CoroutineStackFrame) dVar);
        }
        return new C3542l(b, false, 2, (DefaultConstructorMarker) null);
    }
}
