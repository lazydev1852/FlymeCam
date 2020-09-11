package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.scheduling.f */
/* compiled from: Tasks.kt */
public final class C3554f extends C3560l {

    /* renamed from: a */
    public static final C3554f f18976a = new C3554f();

    private C3554f() {
    }

    /* renamed from: a */
    public long mo27770a() {
        return System.nanoTime();
    }
}
