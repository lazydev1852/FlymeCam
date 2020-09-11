package kotlinx.coroutines.p111a;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo27294d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "a", "", "[Ljava/lang/Object;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "i", "append", "", "value", "start", "take", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.t */
/* compiled from: ThreadContext.kt */
public final class C3494t {

    /* renamed from: a */
    private Object[] f18827a;

    /* renamed from: b */
    private int f18828b;
    @NotNull

    /* renamed from: c */
    private final CoroutineContext f18829c;

    public C3494t(@NotNull CoroutineContext gVar, int i) {
        this.f18829c = gVar;
        this.f18827a = new Object[i];
    }

    @NotNull
    /* renamed from: c */
    public final CoroutineContext mo27629c() {
        return this.f18829c;
    }

    /* renamed from: a */
    public final void mo27627a(@Nullable Object obj) {
        Object[] objArr = this.f18827a;
        int i = this.f18828b;
        this.f18828b = i + 1;
        objArr[i] = obj;
    }

    @Nullable
    /* renamed from: a */
    public final Object mo27626a() {
        Object[] objArr = this.f18827a;
        int i = this.f18828b;
        this.f18828b = i + 1;
        return objArr[i];
    }

    /* renamed from: b */
    public final void mo27628b() {
        this.f18828b = 0;
    }
}
