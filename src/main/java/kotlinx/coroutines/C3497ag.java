package kotlinx.coroutines;

import kotlin.C3450n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.p111a.Symbol;
import kotlinx.coroutines.p111a.ThreadContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\b\u001a.\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00100\bH\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo27294d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "UNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ag */
/* compiled from: DispatchedContinuation.kt */
public final class C3497ag {
    @NotNull
    @JvmField

    /* renamed from: a */
    public static final Symbol f18847a = new Symbol("REUSABLE_CLAIMED");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Symbol f18848b = new Symbol("UNDEFINED");

    @InternalCoroutinesApi
    /* renamed from: a */
    public static final <T> void m21427a(@NotNull Continuation<? super T> dVar, @NotNull Object obj) {
        boolean z;
        CoroutineContext a;
        Object a2;
        if (dVar instanceof DispatchedContinuation) {
            DispatchedContinuation afVar = (DispatchedContinuation) dVar;
            Object a3 = C3543m.m21672a(obj);
            if (afVar.f18843c.mo27727b(afVar.mo27423a())) {
                afVar.f18841a = a3;
                afVar.f18849e = 1;
                afVar.f18843c.mo27658a(afVar.mo27423a(), afVar);
                return;
            }
            C3499am a4 = C3530bl.f18906a.mo27715a();
            if (a4.mo27653g()) {
                afVar.f18841a = a3;
                afVar.f18849e = 1;
                a4.mo27646a((DispatchedTask<?>) afVar);
                return;
            }
            DispatchedTask ahVar = afVar;
            a4.mo27647a(true);
            try {
                C3512ay ayVar = (C3512ay) afVar.mo27423a().mo27412a(C3512ay.f18878b);
                if (ayVar == null || ayVar.mo27559c()) {
                    z = false;
                } else {
                    Result.C3448a aVar = Result.f18741a;
                    afVar.mo27424b(Result.m21195d(C3450n.m21198a((Throwable) ayVar.mo27672i())));
                    z = true;
                }
                if (!z) {
                    a = afVar.mo27423a();
                    a2 = ThreadContext.m21375a(a, afVar.f18842b);
                    afVar.f18844d.mo27424b(obj);
                    Unit tVar = Unit.f18749a;
                    ThreadContext.m21376b(a, a2);
                }
                do {
                } while (a4.mo27652f());
            } catch (Throwable th) {
                try {
                    ahVar.mo27639a(th, (Throwable) null);
                } catch (Throwable th2) {
                    a4.mo27648b(true);
                    throw th2;
                }
            }
            a4.mo27648b(true);
            return;
        }
        dVar.mo27424b(obj);
    }
}
