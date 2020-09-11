package kotlinx.coroutines.p112b;

import kotlin.C3450n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C3382a;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p107a.C3425m;
import kotlinx.coroutines.C3497ag;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\b\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a>\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aR\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2\u0006\u0010\u000e\u001a\u0002H\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo27294d2 = {"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.b.a */
public final class Cancellable {
    @InternalCoroutinesApi
    /* renamed from: a */
    public static final <T> void m21511a(@NotNull C3414b<? super Continuation<? super T>, ? extends Object> bVar, @NotNull Continuation<? super T> dVar) {
        try {
            Continuation<Unit> a = C3382a.m21029a(C3382a.m21030a(bVar, dVar));
            Result.C3448a aVar = Result.f18741a;
            C3497ag.m21427a(a, Result.m21195d(Unit.f18749a));
        } catch (Throwable th) {
            Result.C3448a aVar2 = Result.f18741a;
            dVar.mo27424b(Result.m21195d(C3450n.m21198a(th)));
        }
    }

    /* renamed from: a */
    public static final <R, T> void m21512a(@NotNull C3425m<? super R, ? super Continuation<? super T>, ? extends Object> mVar, R r, @NotNull Continuation<? super T> dVar) {
        try {
            Continuation<Unit> a = C3382a.m21029a(C3382a.m21031a(mVar, r, dVar));
            Result.C3448a aVar = Result.f18741a;
            C3497ag.m21427a(a, Result.m21195d(Unit.f18749a));
        } catch (Throwable th) {
            Result.C3448a aVar2 = Result.f18741a;
            dVar.mo27424b(Result.m21195d(C3450n.m21198a(th)));
        }
    }

    /* renamed from: a */
    public static final void m21510a(@NotNull Continuation<? super Unit> dVar, @NotNull Continuation<?> dVar2) {
        try {
            Continuation<? super Unit> a = C3382a.m21029a(dVar);
            Result.C3448a aVar = Result.f18741a;
            C3497ag.m21427a(a, Result.m21195d(Unit.f18749a));
        } catch (Throwable th) {
            Result.C3448a aVar2 = Result.f18741a;
            dVar2.mo27424b(Result.m21195d(C3450n.m21198a(th)));
        }
    }
}
