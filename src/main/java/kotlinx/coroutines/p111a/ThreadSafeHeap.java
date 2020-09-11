package kotlinx.coroutines.p111a;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.p108b.C3443i;
import kotlinx.coroutines.Debug;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.p111a.C3493s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000602j\u0002`3B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0005J\u0011\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b \u0010\u0012J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0010¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0010¢\u0006\u0004\b$\u0010#J\u001f\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'R \u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010*\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198F@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u0010#¨\u00061"}, mo27294d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@InternalCoroutinesApi
/* renamed from: kotlinx.coroutines.a.r */
public class ThreadSafeHeap<T extends C3493s & Comparable<? super T>> {

    /* renamed from: a */
    private T[] f18825a;

    /* renamed from: b */
    private volatile int f18826b = 0;

    /* renamed from: a */
    public final int mo27614a() {
        return this.f18826b;
    }

    /* renamed from: b */
    private final void m21386b(int i) {
        this.f18826b = i;
    }

    /* renamed from: b */
    public final boolean mo27618b() {
        return mo27614a() == 0;
    }

    @Nullable
    @PublishedApi
    /* renamed from: e */
    public final T mo27621e() {
        T[] tArr = this.f18825a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    @PublishedApi
    /* renamed from: a */
    public final T mo27615a(int i) {
        boolean z = false;
        if (Debug.m21406a()) {
            if (!(mo27614a() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f18825a;
        if (tArr == null) {
            C3443i.m21151a();
        }
        m21386b(mo27614a() - 1);
        if (i < mo27614a()) {
            m21385a(i, mo27614a());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                if (t == null) {
                    C3443i.m21151a();
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i2];
                if (t2 == null) {
                    C3443i.m21151a();
                }
                if (comparable.compareTo(t2) < 0) {
                    m21385a(i, i2);
                    m21387c(i2);
                }
            }
            m21388d(i);
        }
        T t3 = tArr[mo27614a()];
        if (t3 == null) {
            C3443i.m21151a();
        }
        if (Debug.m21406a()) {
            if (t3.mo27624b() == this) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        t3.mo27623a((ThreadSafeHeap<?>) null);
        t3.mo27622a(-1);
        tArr[mo27614a()] = (C3493s) null;
        return t3;
    }

    @PublishedApi
    /* renamed from: b */
    public final void mo27617b(@NotNull T t) {
        if (Debug.m21406a()) {
            if (!(t.mo27624b() == null)) {
                throw new AssertionError();
            }
        }
        t.mo27623a((ThreadSafeHeap<?>) this);
        C3493s[] f = m21389f();
        int a = mo27614a();
        m21386b(a + 1);
        f[a] = t;
        t.mo27622a(a);
        m21387c(a);
    }

    /* renamed from: c */
    private final void m21387c(int i) {
        while (i > 0) {
            T[] tArr = this.f18825a;
            if (tArr == null) {
                C3443i.m21151a();
            }
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            if (t == null) {
                C3443i.m21151a();
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i];
            if (t2 == null) {
                C3443i.m21151a();
            }
            if (comparable.compareTo(t2) > 0) {
                m21385a(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private final void m21388d(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 < mo27614a()) {
                T[] tArr = this.f18825a;
                if (tArr == null) {
                    C3443i.m21151a();
                }
                int i3 = i2 + 1;
                if (i3 < mo27614a()) {
                    T t = tArr[i3];
                    if (t == null) {
                        C3443i.m21151a();
                    }
                    Comparable comparable = (Comparable) t;
                    T t2 = tArr[i2];
                    if (t2 == null) {
                        C3443i.m21151a();
                    }
                    if (comparable.compareTo(t2) < 0) {
                        i2 = i3;
                    }
                }
                T t3 = tArr[i];
                if (t3 == null) {
                    C3443i.m21151a();
                }
                Comparable comparable2 = (Comparable) t3;
                T t4 = tArr[i2];
                if (t4 == null) {
                    C3443i.m21151a();
                }
                if (comparable2.compareTo(t4) > 0) {
                    m21385a(i, i2);
                    i = i2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    private final T[] m21389f() {
        T[] tArr = this.f18825a;
        if (tArr == null) {
            T[] tArr2 = new C3493s[4];
            this.f18825a = tArr2;
            return tArr2;
        } else if (mo27614a() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, mo27614a() * 2);
            C3443i.m21152a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (C3493s[]) copyOf;
            this.f18825a = tArr3;
            return tArr3;
        }
    }

    /* renamed from: a */
    private final void m21385a(int i, int i2) {
        T[] tArr = this.f18825a;
        if (tArr == null) {
            C3443i.m21151a();
        }
        T t = tArr[i2];
        if (t == null) {
            C3443i.m21151a();
        }
        T t2 = tArr[i];
        if (t2 == null) {
            C3443i.m21151a();
        }
        tArr[i] = t;
        tArr[i2] = t2;
        t.mo27622a(i);
        t2.mo27622a(i2);
    }

    @Nullable
    /* renamed from: c */
    public final T mo27619c() {
        T e;
        synchronized (this) {
            e = mo27621e();
        }
        return e;
    }

    @Nullable
    /* renamed from: d */
    public final T mo27620d() {
        T a;
        synchronized (this) {
            a = mo27614a() > 0 ? mo27615a(0) : null;
        }
        return a;
    }

    /* renamed from: a */
    public final boolean mo27616a(@NotNull T t) {
        boolean z;
        synchronized (this) {
            z = true;
            boolean z2 = false;
            if (t.mo27624b() == null) {
                z = false;
            } else {
                int c = t.mo27625c();
                if (Debug.m21406a()) {
                    if (c >= 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                mo27615a(c);
            }
        }
        return z;
    }
}
