package kotlinx.coroutines.p111a;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.C3359b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo27294d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.a */
public class ArrayQueue<T> {

    /* renamed from: a */
    private Object[] f18772a = new Object[16];

    /* renamed from: b */
    private int f18773b;

    /* renamed from: c */
    private int f18774c;

    /* renamed from: a */
    public final boolean mo27567a() {
        return this.f18773b == this.f18774c;
    }

    /* renamed from: a */
    public final void mo27566a(@NotNull T t) {
        this.f18772a[this.f18774c] = t;
        this.f18774c = (this.f18774c + 1) & (this.f18772a.length - 1);
        if (this.f18774c == this.f18773b) {
            m21280c();
        }
    }

    @Nullable
    /* renamed from: b */
    public final T mo27568b() {
        if (this.f18773b == this.f18774c) {
            return null;
        }
        T t = this.f18772a[this.f18773b];
        this.f18772a[this.f18773b] = null;
        this.f18773b = (this.f18773b + 1) & (this.f18772a.length - 1);
        if (t != null) {
            return t;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    /* renamed from: c */
    private final void m21280c() {
        int length = this.f18772a.length;
        Object[] objArr = new Object[(length << 1)];
        C3359b.m20946a(this.f18772a, objArr, 0, this.f18773b, 0, 10, (Object) null);
        C3359b.m20946a(this.f18772a, objArr, this.f18772a.length - this.f18773b, 0, this.f18773b, 4, (Object) null);
        this.f18772a = objArr;
        this.f18773b = 0;
        this.f18774c = length;
    }
}
