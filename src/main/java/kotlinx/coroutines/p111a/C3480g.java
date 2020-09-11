package kotlinx.coroutines.p111a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.p108b.C3443i;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\b\u0017\u0018\u00002\u00020C:\u0005JKLMNB\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u000f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\rH\b¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0011\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\r2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001a\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\f\b\u0000\u0010\u001c*\u00060\u0000j\u0002`\u00032\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00030 ¢\u0006\u0004\b!\u0010\"J \u0010$\u001a\u00060\u0000j\u0002`\u00032\n\u0010#\u001a\u00060\u0000j\u0002`\u0003H\u0010¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b&\u0010\u0007J\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u0002J\u000f\u0010(\u001a\u00020\u0005H\u0001¢\u0006\u0004\b(\u0010\u0002J,\u0010*\u001a\u00020)2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J.\u00100\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001c\u0018\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\rH\b¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b2\u0010-J\u0017\u00103\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0001¢\u0006\u0004\b3\u0010-J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J/\u0010<\u001a\u00020;2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00032\u0006\u0010:\u001a\u00020)H\u0001¢\u0006\u0004\b<\u0010=J'\u0010A\u001a\u00020\u00052\n\u0010>\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0000¢\u0006\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010/R\u0013\u0010\u0013\u001a\u00020C8F@\u0006¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0017\u0010G\u001a\u00060\u0000j\u0002`\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010-R\u0017\u0010I\u001a\u00060\u0000j\u0002`\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bH\u0010-¨\u0006O"}, mo27294d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@InternalCoroutinesApi
/* renamed from: kotlinx.coroutines.a.g */
/* compiled from: LockFreeLinkedList.kt */
public class C3480g {

    /* renamed from: b */
    private static final AtomicReferenceFieldUpdater f18790b = AtomicReferenceFieldUpdater.newUpdater(C3480g.class, Object.class, "a");

    /* renamed from: d */
    static final AtomicReferenceFieldUpdater f18791d = AtomicReferenceFieldUpdater.newUpdater(C3480g.class, Object.class, "c");

    /* renamed from: f */
    static final AtomicReferenceFieldUpdater f18792f = AtomicReferenceFieldUpdater.newUpdater(C3480g.class, Object.class, "e");

    /* renamed from: a */
    private volatile Object f18793a = null;

    /* renamed from: c */
    volatile Object f18794c = this;

    /* renamed from: e */
    volatile Object f18795e = this;

    /* renamed from: i */
    private final C3486k m21316i() {
        C3486k kVar = (C3486k) this.f18793a;
        if (kVar != null) {
            return kVar;
        }
        C3486k kVar2 = new C3486k(this);
        f18790b.lazySet(this, kVar2);
        return kVar2;
    }

    @PublishedApi
    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo27294d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.g$a */
    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class C3481a extends C3471c<C3480g> {
        @Nullable
        @JvmField

        /* renamed from: d */
        public C3480g f18796d;
        @NotNull
        @JvmField

        /* renamed from: e */
        public final C3480g f18797e;

        public C3481a(@NotNull C3480g gVar) {
            this.f18797e = gVar;
        }

        /* renamed from: a */
        public void mo27571a(@NotNull C3480g gVar, @Nullable Object obj) {
            boolean z = obj == null;
            C3480g gVar2 = z ? this.f18797e : this.f18796d;
            if (gVar2 != null && C3480g.f18791d.compareAndSet(gVar, this, gVar2) && z) {
                C3480g gVar3 = this.f18797e;
                C3480g gVar4 = this.f18796d;
                if (gVar4 == null) {
                    C3443i.m21151a();
                }
                gVar3.m21315c(gVar4);
            }
        }
    }

    /* renamed from: d */
    public boolean mo27583d() {
        return mo27586e() instanceof C3486k;
    }

    @NotNull
    /* renamed from: f */
    public final C3480g mo27587f() {
        return C3479f.m21311a(mo27586e());
    }

    @NotNull
    /* renamed from: g */
    public final C3480g mo27588g() {
        C3480g a = m21312a((C3485j) null);
        return a != null ? a : m21314b((C3480g) this.f18795e);
    }

    /* renamed from: b */
    private final C3480g m21314b(C3480g gVar) {
        while (gVar.mo27583d()) {
            gVar = (C3480g) gVar.f18795e;
        }
        return gVar;
    }

    /* renamed from: a */
    public final boolean mo27585a(@NotNull C3480g gVar) {
        f18792f.lazySet(gVar, this);
        f18791d.lazySet(gVar, this);
        while (mo27586e() == this) {
            if (f18791d.compareAndSet(this, this, gVar)) {
                gVar.m21315c(this);
                return true;
            }
        }
        return false;
    }

    @PublishedApi
    /* renamed from: a */
    public final int mo27584a(@NotNull C3480g gVar, @NotNull C3480g gVar2, @NotNull C3481a aVar) {
        f18792f.lazySet(gVar, this);
        f18791d.lazySet(gVar, gVar2);
        aVar.f18796d = gVar2;
        if (!f18791d.compareAndSet(this, gVar2, aVar)) {
            return 0;
        }
        return aVar.mo27574c(this) == null ? 1 : 2;
    }

    /* renamed from: c */
    public boolean mo27582c() {
        return mo27589h() == null;
    }

    @Nullable
    @PublishedApi
    /* renamed from: h */
    public final C3480g mo27589h() {
        Object e;
        C3480g gVar;
        do {
            e = mo27586e();
            if (e instanceof C3486k) {
                return ((C3486k) e).f18811a;
            }
            if (e == this) {
                return (C3480g) e;
            }
            if (e != null) {
                gVar = (C3480g) e;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!f18791d.compareAndSet(this, e, gVar.m21316i()));
        gVar.m21312a((C3485j) null);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (f18791d.compareAndSet(r4, r3, ((kotlinx.coroutines.p111a.C3486k) r5).f18811a) != false) goto L_0x0051;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.p111a.C3480g m21312a(kotlinx.coroutines.p111a.C3485j r8) {
        /*
            r7 = this;
        L_0x0000:
            java.lang.Object r0 = r7.f18795e
            kotlinx.coroutines.a.g r0 = (kotlinx.coroutines.p111a.C3480g) r0
            r1 = 0
            r2 = r1
            kotlinx.coroutines.a.g r2 = (kotlinx.coroutines.p111a.C3480g) r2
            r3 = r0
        L_0x0009:
            r4 = r2
        L_0x000a:
            java.lang.Object r5 = r3.f18794c
            r6 = r7
            kotlinx.coroutines.a.g r6 = (kotlinx.coroutines.p111a.C3480g) r6
            if (r5 != r6) goto L_0x001e
            if (r0 != r3) goto L_0x0014
            return r3
        L_0x0014:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f18792f
            boolean r0 = r1.compareAndSet(r7, r0, r3)
            if (r0 != 0) goto L_0x001d
            goto L_0x0000
        L_0x001d:
            return r3
        L_0x001e:
            boolean r6 = r7.mo27583d()
            if (r6 == 0) goto L_0x0025
            return r1
        L_0x0025:
            if (r5 != r8) goto L_0x0028
            return r3
        L_0x0028:
            boolean r6 = r5 instanceof kotlinx.coroutines.p111a.C3485j
            if (r6 == 0) goto L_0x003e
            if (r8 == 0) goto L_0x0038
            r0 = r5
            kotlinx.coroutines.a.j r0 = (kotlinx.coroutines.p111a.C3485j) r0
            boolean r0 = r8.mo27606a(r0)
            if (r0 == 0) goto L_0x0038
            return r1
        L_0x0038:
            kotlinx.coroutines.a.j r5 = (kotlinx.coroutines.p111a.C3485j) r5
            r5.mo27574c(r3)
            goto L_0x0000
        L_0x003e:
            boolean r6 = r5 instanceof kotlinx.coroutines.p111a.C3486k
            if (r6 == 0) goto L_0x0058
            if (r4 == 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f18791d
            kotlinx.coroutines.a.k r5 = (kotlinx.coroutines.p111a.C3486k) r5
            kotlinx.coroutines.a.g r5 = r5.f18811a
            boolean r3 = r6.compareAndSet(r4, r3, r5)
            if (r3 != 0) goto L_0x0051
            goto L_0x0000
        L_0x0051:
            r3 = r4
            goto L_0x0009
        L_0x0053:
            java.lang.Object r3 = r3.f18795e
            kotlinx.coroutines.a.g r3 = (kotlinx.coroutines.p111a.C3480g) r3
            goto L_0x000a
        L_0x0058:
            if (r5 == 0) goto L_0x005f
            kotlinx.coroutines.a.g r5 = (kotlinx.coroutines.p111a.C3480g) r5
            r4 = r3
            r3 = r5
            goto L_0x000a
        L_0x005f:
            kotlin.q r8 = new kotlin.q
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p111a.C3480g.m21312a(kotlinx.coroutines.a.j):kotlinx.coroutines.a.g");
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    @NotNull
    /* renamed from: e */
    public final Object mo27586e() {
        while (true) {
            Object obj = this.f18794c;
            if (!(obj instanceof C3485j)) {
                return obj;
            }
            ((C3485j) obj).mo27574c(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m21315c(C3480g gVar) {
        C3480g gVar2;
        do {
            gVar2 = (C3480g) gVar.f18795e;
            if (mo27586e() != gVar) {
                return;
            }
        } while (!f18792f.compareAndSet(gVar, gVar2, this));
        if (mo27583d()) {
            gVar.m21312a((C3485j) null);
        }
    }
}
