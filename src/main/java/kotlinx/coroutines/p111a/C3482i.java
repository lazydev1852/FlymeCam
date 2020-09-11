package kotlinx.coroutines.p111a;

import com.loc.C1108h;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlinx.coroutines.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0013\u0010)\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0013\u0010.\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, mo27294d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.i */
/* compiled from: LockFreeTaskQueue.kt */
public final class C3482i<E> {
    @NotNull
    @JvmField

    /* renamed from: a */
    public static final Symbol f18800a = new Symbol("REMOVE_FROZEN");

    /* renamed from: b */
    public static final C3483a f18801b = new C3483a((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater f18802e = AtomicReferenceFieldUpdater.newUpdater(C3482i.class, Object.class, "d");

    /* renamed from: g */
    private static final AtomicLongFieldUpdater f18803g = AtomicLongFieldUpdater.newUpdater(C3482i.class, C1108h.f3354h);

    /* renamed from: c */
    private final int f18804c = (this.f18808i - 1);

    /* renamed from: d */
    private volatile Object f18805d = null;

    /* renamed from: f */
    private volatile long f18806f = 0;

    /* renamed from: h */
    private AtomicReferenceArray f18807h = new AtomicReferenceArray(this.f18808i);

    /* renamed from: i */
    private final int f18808i;

    /* renamed from: j */
    private final boolean f18809j;

    public C3482i(int i, boolean z) {
        this.f18808i = i;
        this.f18809j = z;
        boolean z2 = true;
        if (this.f18804c <= 1073741823) {
            if (!((this.f18808i & this.f18804c) != 0 ? false : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: a */
    public final boolean mo27597a() {
        C3483a aVar = f18801b;
        long j = this.f18806f;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* renamed from: b */
    public final int mo27598b() {
        C3483a aVar = f18801b;
        long j = this.f18806f;
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0))) & 1073741823;
    }

    /* renamed from: a */
    private final C3482i<E> m21332a(int i, E e) {
        Object obj = this.f18807h.get(this.f18804c & i);
        if (!(obj instanceof C3484b) || ((C3484b) obj).f18810a != i) {
            return null;
        }
        this.f18807h.set(i & this.f18804c, e);
        return this;
    }

    @NotNull
    /* renamed from: e */
    public final C3482i<E> mo27601e() {
        return m21333a(m21335f());
    }

    /* renamed from: b */
    private final C3482i<E> m21334b(long j) {
        C3482i<E> iVar = new C3482i<>(this.f18808i * 2, this.f18809j);
        C3483a aVar = f18801b;
        int i = (int) ((1152921503533105152L & j) >> 30);
        for (int i2 = (int) ((1073741823 & j) >> 0); (this.f18804c & i2) != (this.f18804c & i); i2++) {
            Object obj = this.f18807h.get(this.f18804c & i2);
            if (obj == null) {
                obj = new C3484b(i2);
            }
            iVar.f18807h.set(iVar.f18804c & i2, obj);
        }
        iVar.f18806f = f18801b.mo27604a(j, 1152921504606846976L);
        return iVar;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.i$b */
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class C3484b {
        @JvmField

        /* renamed from: a */
        public final int f18810a;

        public C3484b(int i) {
            this.f18810a = i;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006&"}, mo27294d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.i$a */
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class C3483a {
        /* renamed from: a */
        public final int mo27602a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        /* renamed from: a */
        public final long mo27604a(long j, long j2) {
            return j & (~j2);
        }

        private C3483a() {
        }

        public /* synthetic */ C3483a(DefaultConstructorMarker gVar) {
            this();
        }

        /* renamed from: a */
        public final long mo27603a(long j, int i) {
            return mo27604a(j, 1073741823) | (((long) i) << 0);
        }

        /* renamed from: b */
        public final long mo27605b(long j, int i) {
            return mo27604a(j, 1152921503533105152L) | (((long) i) << 30);
        }
    }

    /* renamed from: c */
    public final boolean mo27599c() {
        long j;
        do {
            j = this.f18806f;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f18803g.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d A[LOOP:1: B:19:0x006d->B:22:0x007f, LOOP_START, PHI: r0 
  PHI: (r0v15 kotlinx.coroutines.a.i) = (r0v14 kotlinx.coroutines.a.i), (r0v17 kotlinx.coroutines.a.i) binds: [B:18:0x0063, B:22:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo27596a(@org.jetbrains.annotations.NotNull E r13) {
        /*
            r12 = this;
        L_0x0000:
            long r2 = r12.f18806f
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0012
            kotlinx.coroutines.a.i$a r13 = f18801b
            int r13 = r13.mo27602a(r2)
            return r13
        L_0x0012:
            kotlinx.coroutines.a.i$a r0 = f18801b
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r0 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r1 = 30
            long r4 = r4 >> r1
            int r9 = (int) r4
            int r10 = r12.f18804c
            int r1 = r9 + 2
            r1 = r1 & r10
            r4 = r0 & r10
            r5 = 1
            if (r1 != r4) goto L_0x0030
            return r5
        L_0x0030:
            boolean r1 = r12.f18809j
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L_0x0050
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f18807h
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L_0x0050
            int r1 = r12.f18808i
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 < r2) goto L_0x004f
            int r9 = r9 - r0
            r0 = r9 & r4
            int r1 = r12.f18808i
            int r1 = r1 >> r5
            if (r0 <= r1) goto L_0x0000
        L_0x004f:
            return r5
        L_0x0050:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f18803g
            kotlinx.coroutines.a.i$a r4 = f18801b
            long r4 = r4.mo27605b(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f18807h
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
            kotlinx.coroutines.a.i r0 = (kotlinx.coroutines.p111a.C3482i) r0
        L_0x006d:
            long r1 = r0.f18806f
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0077
            goto L_0x0082
        L_0x0077:
            kotlinx.coroutines.a.i r0 = r0.mo27601e()
            kotlinx.coroutines.a.i r0 = r0.m21332a((int) r9, r13)
            if (r0 == 0) goto L_0x0082
            goto L_0x006d
        L_0x0082:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p111a.C3482i.mo27596a(java.lang.Object):int");
    }

    @Nullable
    /* renamed from: d */
    public final Object mo27600d() {
        while (true) {
            long j = this.f18806f;
            if ((1152921504606846976L & j) != 0) {
                return f18800a;
            }
            C3483a aVar = f18801b;
            int i = (int) ((1073741823 & j) >> 0);
            if ((((int) ((1152921503533105152L & j) >> 30)) & this.f18804c) == (this.f18804c & i)) {
                return null;
            }
            Object obj = this.f18807h.get(this.f18804c & i);
            if (obj == null) {
                if (this.f18809j) {
                    return null;
                }
            } else if (obj instanceof C3484b) {
                return null;
            } else {
                int i2 = (i + 1) & 1073741823;
                if (f18803g.compareAndSet(this, j, f18801b.mo27603a(j, i2))) {
                    this.f18807h.set(this.f18804c & i, (Object) null);
                    return obj;
                } else if (this.f18809j) {
                    C3482i iVar = this;
                    do {
                        iVar = iVar.m21331a(i, i2);
                    } while (iVar != null);
                    return obj;
                }
            }
        }
    }

    /* renamed from: a */
    private final C3482i<E> m21331a(int i, int i2) {
        long j;
        int i3;
        do {
            j = this.f18806f;
            C3483a aVar = f18801b;
            boolean z = false;
            i3 = (int) ((1073741823 & j) >> 0);
            if (Debug.m21406a()) {
                if (i3 == i) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return mo27601e();
            }
        } while (!f18803g.compareAndSet(this, j, f18801b.mo27603a(j, i2)));
        this.f18807h.set(this.f18804c & i3, (Object) null);
        return null;
    }

    /* renamed from: f */
    private final long m21335f() {
        long j;
        long j2;
        do {
            j = this.f18806f;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f18803g.compareAndSet(this, j, j2));
        return j2;
    }

    /* renamed from: a */
    private final C3482i<E> m21333a(long j) {
        while (true) {
            C3482i<E> iVar = (C3482i) this.f18805d;
            if (iVar != null) {
                return iVar;
            }
            f18802e.compareAndSet(this, (Object) null, m21334b(j));
        }
    }
}
